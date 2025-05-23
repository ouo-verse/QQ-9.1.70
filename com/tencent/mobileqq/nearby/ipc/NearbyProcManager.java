package com.tencent.mobileqq.nearby.ipc;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.config.af;
import com.tencent.mobileqq.config.ah;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.ProcessConstant;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyRankConfig;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7$RspBody;

/* loaded from: classes33.dex */
public class NearbyProcManager implements Manager, b {

    /* renamed from: d, reason: collision with root package name */
    private INearbyAppInterface f252612d;

    /* renamed from: e, reason: collision with root package name */
    private e f252613e;

    /* renamed from: f, reason: collision with root package name */
    private final List<c> f252614f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<c> f252615h = new ArrayList();
    private int[] C = null;
    private boolean[] D = null;

    /* renamed from: i, reason: collision with root package name */
    private MqqHandler f252616i = ThreadManager.getUIHandler();

    /* renamed from: m, reason: collision with root package name */
    private MqqHandler f252617m = ThreadManager.getSubThreadHandler();

    /* JADX WARN: Multi-variable type inference failed */
    public NearbyProcManager(AppInterface appInterface) {
        this.f252612d = (INearbyAppInterface) appInterface;
        this.f252613e = new e(appInterface, this);
    }

    private Message k(Message message) {
        return this.f252613e.e(message);
    }

    private Object[] l(int i3, Object... objArr) {
        return this.f252613e.f(i3, objArr);
    }

    @Override // com.tencent.mobileqq.nearby.ipc.b
    public void a(Object obj) {
        cmd0x9c7$RspBody cmd0x9c7_rspbody = (cmd0x9c7$RspBody) obj;
        Object[] objArr = new Object[1];
        objArr[0] = cmd0x9c7_rspbody == null ? null : cmd0x9c7_rspbody.toByteArray();
        l(4123, objArr);
    }

    @Override // com.tencent.mobileqq.nearby.ipc.b
    public void b(boolean z16, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        l(z16 ? 4099 : 4098, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
    }

    @Override // com.tencent.mobileqq.nearby.ipc.b
    public void d() {
        this.f252613e.b();
    }

    @Override // com.tencent.mobileqq.nearby.ipc.b
    public boolean f(int i3, boolean z16) {
        boolean z17;
        SharedPreferences sharedPreferences = ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getSharedPreferences(INearbySPUtil.NEARBY_EVENT_FILE, this.f252612d.getAccount(), 4);
        if (this.D == null) {
            this.D = new boolean[2];
            String str = null;
            int i16 = 0;
            while (true) {
                boolean[] zArr = this.D;
                if (i16 >= zArr.length) {
                    break;
                }
                if (i16 == 0) {
                    str = INearbySPUtil.CONFIG_SHOW_DATE;
                } else if (i16 == 1) {
                    str = INearbySPUtil.CONFIG_SHOW_RANK;
                }
                zArr[i16] = sharedPreferences.getBoolean(str, false);
                i16++;
            }
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        boolean[] zArr2 = this.D;
        if (zArr2[i3] != z16) {
            zArr2[i3] = z16;
            try {
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                    l.b("onGetMyTabConfig", "save config", Integer.valueOf(i3), e16.toString());
                }
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    edit.putBoolean(INearbySPUtil.CONFIG_SHOW_RANK, z16);
                }
                z17 = true;
            } else {
                edit.putBoolean(INearbySPUtil.CONFIG_SHOW_DATE, z16);
            }
            z17 = true;
        } else {
            z17 = false;
        }
        try {
            boolean commit = edit.commit();
            if (QLog.isColorLevel()) {
                l.b("onGetMyTabConfig", Boolean.valueOf(commit), Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.nearby.ipc.b
    public Message h(Message message) {
        Bundle data;
        Bundle data2 = message.getData();
        int i3 = message.what;
        if (i3 != 4118) {
            if (i3 == 4138 && (data = message.getData()) != null) {
                ((IQQAvatarManagerService) this.f252612d.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY)).removeFaceFromCache(FaceInfo.getFaceBmpCacheKey(data.getInt("headType"), data.getString("id"), data.getInt("idType"), 3, 0));
            }
        } else {
            if (data2 == null) {
                return null;
            }
            j(4118, data2.getStringArrayList("keys"), data2.getStringArrayList("paths"));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.nearby.ipc.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public DynamicAvatar e(int i3, String str) {
        Message message = new Message();
        message.what = 4142;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i3);
        bundle.putString("id", str);
        message.setData(bundle);
        Message k3 = k(message);
        if (k3 == null) {
            return null;
        }
        Bundle data = k3.getData();
        data.setClassLoader(DynamicAvatar.class.getClassLoader());
        DynamicAvatar dynamicAvatar = (DynamicAvatar) data.getParcelable("avatarInfo");
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "ipc getDynamicAvatarInfo : " + dynamicAvatar);
        }
        return dynamicAvatar;
    }

    public void j(final int i3, final Object... objArr) {
        int i16;
        synchronized (this.f252615h) {
            for (int i17 = 0; i17 < this.f252615h.size(); i17++) {
                final c cVar = this.f252615h.get(i17);
                this.f252616i.post(new Runnable() { // from class: com.tencent.mobileqq.nearby.ipc.NearbyProcManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar.a(i3, objArr);
                    }
                });
            }
        }
        synchronized (this.f252614f) {
            for (i16 = 0; i16 < this.f252614f.size(); i16++) {
                final c cVar2 = this.f252614f.get(i16);
                this.f252617m.post(new Runnable() { // from class: com.tencent.mobileqq.nearby.ipc.NearbyProcManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cVar2.a(i3, objArr);
                    }
                });
            }
        }
    }

    public void m() {
        this.f252613e.g();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        m();
        this.f252613e = null;
        synchronized (this.f252614f) {
            this.f252614f.clear();
        }
        synchronized (this.f252615h) {
            this.f252615h.clear();
        }
    }

    @Override // com.tencent.mobileqq.nearby.ipc.b
    public void c(byte[] bArr) {
        l(4141, bArr);
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "saveDynamicAvarInfo2db send ipcMsg.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mobileqq.nearby.ipc.b
    public Object[] g(int i3, Object... objArr) {
        if (i3 != 4100) {
            if (i3 != 4122) {
                if (i3 == 4126) {
                    ((af) this.f252612d.getManager(com.tencent.mobileqq.nearby.e.f252577d)).a();
                } else if (i3 != 4130) {
                    if (i3 == 4139) {
                        ah.e();
                    } else if (i3 != 4145) {
                        if (i3 == 4158) {
                            j(4158, new Object[0]);
                        } else if (i3 != 4160) {
                            switch (i3) {
                                case 4113:
                                    if (objArr != null && objArr.length == 2) {
                                        j(4113, objArr[0], objArr[1]);
                                        break;
                                    } else {
                                        return null;
                                    }
                                case 4114:
                                    if (objArr != null && objArr.length == 2) {
                                        j(4114, objArr[0], objArr[1]);
                                        break;
                                    } else {
                                        return null;
                                    }
                                    break;
                                case 4115:
                                    if (objArr != null && objArr.length == 1) {
                                        j(4115, objArr);
                                        break;
                                    } else {
                                        return null;
                                    }
                                    break;
                                case 4116:
                                    if (objArr != null && objArr.length == 1) {
                                        j(4116, objArr);
                                        break;
                                    } else {
                                        return null;
                                    }
                            }
                        } else {
                            try {
                                j(4160, (Integer) objArr[0], (String) objArr[1], (Bitmap) objArr[2]);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    } else if (objArr != null && objArr.length == 2) {
                        ((NearbyHandler) this.f252612d.getBusinessHandler(com.tencent.mobileqq.nearby.e.f252574a)).D2(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    }
                } else {
                    if (objArr == null || objArr.length != 2) {
                        return null;
                    }
                    j(4130, Integer.valueOf(((Integer) objArr[0]).intValue()), Boolean.valueOf(((Boolean) objArr[1]).booleanValue()));
                }
            } else {
                if (objArr == null || objArr.length < 3) {
                    return null;
                }
                try {
                    QLog.i("updateCharmConfigIPC", 1, "Charm=" + ((Integer) objArr[0]).intValue());
                    if (objArr[1] != null) {
                        new Oidb_0x686$NearbyRankConfig().mergeFrom((byte[]) objArr[1]);
                    }
                    if (objArr[2] != null) {
                        new Oidb_0x686$NearbyFeedConfig().mergeFrom((byte[]) objArr[2]);
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("NearbyProcManager", 2, "MSG_GET_CHARM_EVENT catch exception:", e17);
                    }
                }
            }
        } else if (objArr != null && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                if (QLog.isColorLevel()) {
                    l.b("MSG_NOTIFY_HAS_UNREAD_MSG", Integer.valueOf(intValue));
                }
            }
        }
        return null;
    }
}
