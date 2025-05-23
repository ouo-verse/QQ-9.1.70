package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.m;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class EffectPendantBase extends EffectConfigBase<PendantItem> implements EffectMutexManager.a {
    protected boolean F;
    protected String[] G;
    protected EffectPendantTipsImpl H;
    protected final a I;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public VideoMaterial f73387a;

        /* renamed from: b, reason: collision with root package name */
        public String f73388b;

        /* renamed from: c, reason: collision with root package name */
        public PendantItem f73389c;
    }

    public EffectPendantBase(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = new a();
    }

    public void R() {
        a aVar = this.I;
        aVar.f73387a = null;
        aVar.f73389c = null;
        aVar.f73388b = null;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public String v(PendantItem pendantItem) {
        if (pendantItem != null) {
            return com.tencent.av.b.m() + pendantItem.getMd5();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String T(PendantItem pendantItem) {
        String str;
        String str2 = "";
        if (pendantItem != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(y(pendantItem));
            sb5.append(pendantItem.getName());
            String str3 = File.separator;
            sb5.append(str3);
            String sb6 = sb5.toString();
            if (new File(sb6).exists()) {
                str = null;
                str2 = sb6;
            } else {
                str = com.tencent.av.b.l() + pendantItem.getName() + str3;
                if (new File(str).exists()) {
                    str2 = str;
                }
            }
            if (TextUtils.isEmpty(str2) && QLog.isDevelopLevel()) {
                QLog.i(this.f73315d, 4, "getFilterPathForRead, new[" + sb6 + "], old[" + str + "], item[" + pendantItem + "]");
            }
        }
        return str2;
    }

    public abstract int U();

    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public String y(PendantItem pendantItem) {
        if (pendantItem != null) {
            return com.tencent.av.b.n() + pendantItem.getMd5() + File.separator;
        }
        return "";
    }

    public a W(int i3, int i16) {
        PendantItem pendantItem;
        if (!m.K()) {
            return null;
        }
        PendantItem u16 = u();
        if (this.F) {
            this.F = false;
            R();
        }
        if (i3 != 0 && i16 != 0 && u16 != null && !TextUtils.isEmpty(u16.getId())) {
            String T = T(u16);
            String id5 = u16.getId();
            if (T.equals(this.I.f73388b) && (pendantItem = this.I.f73389c) != null && id5.equals(pendantItem.getId())) {
                return this.I;
            }
            long currentTimeMillis = System.currentTimeMillis();
            VideoMaterial loadLightAsset = VideoMaterial.loadLightAsset(T);
            a aVar = this.I;
            aVar.f73387a = loadLightAsset;
            aVar.f73389c = u16;
            aVar.f73388b = T;
            AVCoreLog.printColorLog(this.f73315d, String.format("getVideoPendant, patternPath[%s], id[%s], material[%s], cost[%s]", T, id5, loadLightAsset, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            return this.I;
        }
        if (!TextUtils.isEmpty(this.I.f73388b)) {
            this.I.f73388b = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: X */
    public boolean C(PendantItem pendantItem) {
        boolean z16;
        boolean z17;
        boolean C = super.C(pendantItem);
        if (C) {
            String T = T(pendantItem);
            String[] strArr = this.G;
            if (strArr != null && strArr.length > 0) {
                z16 = false;
                for (String str : strArr) {
                    File file = new File(T, str);
                    long length = file.length();
                    if ((file.exists() && length < 1) || !file.exists()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17 && !z16) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z17 && QLog.isColorLevel()) {
                        QLog.i(this.f73315d, 2, "isTemplateUsable, fileName[" + str + "], item[" + pendantItem + "]");
                    }
                    if (z16) {
                        break;
                    }
                }
            } else {
                z16 = false;
            }
            if (z16) {
                String v3 = v(pendantItem);
                final String y16 = y(pendantItem);
                final File file2 = new File(v3);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.business.manager.pendant.EffectPendantBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ZipUtils.unZipFile(file2, y16);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i(EffectPendantBase.this.f73315d, 2, "isTemplateUsable unzip error", e16);
                            }
                        }
                    }
                }, 16, null, false);
                if (QLog.isDevelopLevel()) {
                    QLog.i(this.f73315d, 4, "isTemplateUsable, need unzip item[" + pendantItem + "]");
                }
            }
        }
        return C;
    }

    protected void Y(long j3, PendantItem pendantItem) {
        VideoAppInterface videoAppInterface = this.f73316e;
        if (videoAppInterface != null) {
            ((fu.a) videoAppInterface.B(1)).X(j3, pendantItem);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    /* renamed from: Z */
    public boolean L(long j3, PendantItem pendantItem) {
        boolean L = super.L(j3, pendantItem);
        SessionInfo f16 = n.e().f();
        Y(j3, pendantItem);
        if (pendantItem != null && !TextUtils.isEmpty(pendantItem.getId())) {
            f16.I1.set(1);
        } else {
            f16.I1.clear(1);
        }
        return L;
    }

    public void a0(EffectPendantTipsImpl effectPendantTipsImpl) {
        this.H = effectPendantTipsImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.EffectConfigBase, com.tencent.av.business.manager.a
    public void g() {
        super.g();
        EffectMutexManager effectMutexManager = (EffectMutexManager) this.f73316e.B(12);
        if (effectMutexManager != null) {
            effectMutexManager.n(U(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public boolean i(String str) {
        return uv.b.f().a(this.f73316e);
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    public List<PendantItem> q(String str) {
        List q16 = super.q(str);
        ArrayList arrayList = new ArrayList();
        if (q16 != null) {
            arrayList.addAll(q16);
        }
        return arrayList;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase
    protected Class<?> x() {
        return PendantItem.class;
    }
}
