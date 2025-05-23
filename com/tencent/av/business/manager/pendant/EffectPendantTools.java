package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class EffectPendantTools extends EffectPendantBase {
    public String J;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static long f73401a = 0;

        /* renamed from: b, reason: collision with root package name */
        static String f73402b = null;

        /* renamed from: c, reason: collision with root package name */
        private static String f73403c = "actAVFunChatDecorate";

        static void a(String str, String str2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!tv.c.b(str2, f73402b)) {
                if (!TextUtils.isEmpty(f73402b)) {
                    long j3 = f73401a;
                    if (j3 != 0) {
                        b(str, f73402b, (currentTimeMillis - j3) / 1000);
                    }
                }
                f73402b = str2;
                f73401a = currentTimeMillis;
            }
        }

        public static void b(String str, String str2, long j3) {
            if (!TextUtils.isEmpty(str2)) {
                long currentTimeMillis = (System.currentTimeMillis() - j3) / 1000;
                HashMap hashMap = new HashMap();
                hashMap.put("tempID", str2);
                hashMap.put("duration", currentTimeMillis + "");
                UserAction.onUserAction(f73403c, true, -1L, -1L, hashMap, true);
                AVCoreLog.printColorLog(str, "onStateReport, ID: " + str2 + "  pendant time: " + j3);
            }
        }

        public static void c(String str, VideoAppInterface videoAppInterface) {
            PendantItem u16;
            if (videoAppInterface.Y(2) && (u16 = ((EffectPendantTools) videoAppInterface.B(2)).u()) != null && !TextUtils.isEmpty(u16.getId())) {
                a(str, null);
            }
        }
    }

    public EffectPendantTools(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.J = null;
    }

    public static boolean b0(VideoMaterial videoMaterial) {
        return false;
    }

    public static int c0(PendantItem pendantItem, boolean z16) {
        if (pendantItem != null || z16) {
            int e16 = AEFilterSupport.e();
            if (e16 == 3) {
                return 3;
            }
            if (e16 == 4) {
                return 4;
            }
            if (e16 == 7) {
                return 5;
            }
        }
        return 0;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected boolean B() {
        return true;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected void H() {
        List<T> list = this.f73303i;
        if (list == 0 || list.size() == 0) {
            List<PendantItem> i3 = ((com.tencent.av.business.processor.b) ((hu.a) this.f73316e.B(15)).n(1)).i(com.tencent.av.b.j(), "pendant_update_template.json", "pendant_default_template.json");
            this.f73303i = i3;
            I(i3);
        }
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase
    public int U() {
        return 3002;
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase
    public EffectPendantBase.a W(int i3, int i16) {
        EffectPendantBase.a W = super.W(i3, i16);
        if (this.H != null && W != null && W.f73387a != null) {
            boolean b16 = iu.a.c().b();
            if (!b0(W.f73387a) || b16) {
                this.H.l(0);
            }
        }
        return W;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase, com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public boolean C(final PendantItem pendantItem) {
        boolean z16;
        if (r() > 0 && pendantItem != null && !TextUtils.isEmpty(pendantItem.getId())) {
            boolean z17 = true;
            if (TextUtils.isEmpty(pendantItem.getResUrl())) {
                return true;
            }
            final File file = new File(v(pendantItem));
            boolean exists = file.exists();
            if (!exists) {
                String str = com.tencent.av.b.l() + pendantItem.getName();
                File file2 = new File(str);
                if (file2.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String fileMd5 = SecUtil.getFileMd5(str);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String md5 = pendantItem.getMd5();
                    AVCoreLog.printColorLog(this.f73315d, "isTemplateUsable :" + fileMd5 + "|" + md5 + "|" + (currentTimeMillis2 - currentTimeMillis));
                    exists = md5.equalsIgnoreCase(fileMd5);
                }
                file = file2;
            }
            if (exists) {
                String T = T(pendantItem);
                File file3 = new File(T, IVideoFilterTools.CONFIG_FILE);
                long length = file3.length();
                if ((file3.exists() && length < 1) || !file3.exists()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    File file4 = new File(T, "params.dat");
                    long length2 = file4.length();
                    if ((!file4.exists() || length2 >= 1) && file4.exists()) {
                        z17 = false;
                    }
                    z16 = z17;
                }
                if (z16) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.business.manager.pendant.EffectPendantTools.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ZipUtils.unZipFile(file, EffectPendantTools.this.y(pendantItem));
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    e16.printStackTrace();
                                }
                            }
                        }
                    }, 5, null, false);
                    return false;
                }
            }
            return exists;
        }
        AVCoreLog.printErrorLog(this.f73315d, "isTemplateUsable:" + r() + "|");
        return false;
    }

    @Override // com.tencent.av.business.manager.pendant.EffectPendantBase, com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public boolean L(long j3, PendantItem pendantItem) {
        String id5;
        EffectMutexManager effectMutexManager;
        boolean L = super.L(j3, pendantItem);
        if (L && pendantItem != null && !TextUtils.equals("0", pendantItem.getId()) && (effectMutexManager = (EffectMutexManager) this.f73316e.B(12)) != null) {
            effectMutexManager.m(3002, pendantItem.getId());
        }
        String str = this.f73315d;
        if (pendantItem == null) {
            id5 = null;
        } else {
            id5 = pendantItem.getId();
        }
        a.a(str, id5);
        if (QLog.isColorLevel()) {
            QLog.i(this.f73315d, 2, "setCurrentItem, item[" + pendantItem + "]");
        }
        return L;
    }

    @Override // com.tencent.av.business.manager.EffectMutexManager.a
    public void d(int i3, String str) {
        long d16 = e.d();
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f73315d, 4, "MuteByOthers, seq[" + d16 + "], fromMuteKey[" + i3 + "], data[" + str + "]");
        }
        if (i3 != U() && i3 != 3003) {
            if (i3 == 3001 || i3 == 3004 || i3 == 3005) {
                M(d16, "0");
            }
        }
    }

    @Override // com.tencent.av.business.manager.a
    protected void j(long j3, int i3, String str, String str2) {
        PendantItem u16;
        if ((i3 == 2 || i3 == 3) && (u16 = u()) != null && !TextUtils.isEmpty(u16.getId())) {
            L(j3, null);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public int r() {
        return 106;
    }
}
