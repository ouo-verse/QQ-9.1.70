package com.tencent.av.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.service.f;
import com.tencent.av.service.g;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    VideoAppInterface f73197a;

    /* renamed from: b, reason: collision with root package name */
    boolean f73198b = false;

    /* renamed from: c, reason: collision with root package name */
    com.tencent.av.service.g f73199c = null;

    /* renamed from: d, reason: collision with root package name */
    ServiceConnection f73200d = new b();

    /* renamed from: e, reason: collision with root package name */
    f.a f73201e = new a();

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.cache.api.collection.a<String, String> f73202f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f73203g = false;

    /* renamed from: h, reason: collision with root package name */
    int f73204h = -1;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements ServiceConnection {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements IBinder.DeathRecipient {
            a() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                AVCoreLog.printAllUserLog("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
            }
        }

        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QLog.w("QQServiceProxy", 1, "QQServiceForAV onServiceConnected, name[" + componentName + "]");
            r rVar = r.this;
            rVar.f73198b = false;
            rVar.f73199c = g.a.j(iBinder);
            try {
                r rVar2 = r.this;
                rVar2.f73199c.L1(rVar2.f73201e, "video_process_cookie");
                r rVar3 = r.this;
                if (rVar3.f73203g) {
                    rVar3.b();
                }
                VideoAppInterface videoAppInterface = r.this.f73197a;
                if (videoAppInterface != null) {
                    videoAppInterface.k0(new Object[]{10});
                }
            } catch (RemoteException e16) {
                AVCoreLog.printErrorLog("QQServiceProxy", "QQServiceForAV onServiceConnected Exception msg = " + e16.getMessage());
            }
            try {
                r.this.f73199c.asBinder().linkToDeath(new a(), 0);
            } catch (Exception e17) {
                AVCoreLog.printErrorLog("QQServiceProxy", "QQServiceForAV onServiceConnected Exception msg = " + e17.getMessage());
            }
            if (r.this.f73197a != null && com.tencent.av.r.h0() != null) {
                com.tencent.av.r.h0().b2();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected");
            }
            try {
                r rVar = r.this;
                com.tencent.av.service.g gVar = rVar.f73199c;
                if (gVar != null) {
                    gVar.g0(rVar.f73201e);
                }
                VideoAppInterface videoAppInterface = r.this.f73197a;
                if (videoAppInterface != null) {
                    videoAppInterface.k0(new Object[]{11});
                    r.this.f73197a.X().deleteObservers();
                }
            } catch (RemoteException e16) {
                QLog.e("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected RemoteException", e16);
            }
            r.this.f73199c = null;
        }
    }

    public r(VideoAppInterface videoAppInterface) {
        this.f73197a = videoAppInterface;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean A() {
        int i3 = 2;
        i3 = 2;
        i3 = 2;
        boolean z16 = false;
        try {
            com.tencent.av.service.g gVar = this.f73199c;
            if (gVar != null) {
                boolean k06 = gVar.k0();
                z16 = k06;
                i3 = k06;
            } else if (QLog.isColorLevel()) {
                QLog.i("QQServiceProxy", 2, "isInAVGameRoom, service is not ready.");
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceProxy", i3, "isInAVGameRoom", th5);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QQServiceProxy", 4, "isInAVGameRoom, ret[" + z16 + "]");
        }
        return z16;
    }

    public boolean B() {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.s();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "isPhoneCalling", e16);
                }
            }
        }
        return false;
    }

    public boolean C() {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isQQServiceBind ");
            if (this.f73199c != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("QQServiceProxy", 2, sb5.toString());
        }
        if (this.f73199c != null) {
            return true;
        }
        return false;
    }

    public boolean D() {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.O3();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "isQQpaused", e16);
                }
            }
        }
        return false;
    }

    public void E(boolean z16) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                gVar.A1(z16);
            } catch (Throwable th5) {
                QLog.e("QQServiceProxy", 1, "keepVideoProcessAlive fail.", th5);
            }
        }
    }

    public void F(String str, Bitmap bitmap) {
        if (bitmap != null) {
            ImageCacheHelper.f98636a.i(str, bitmap, Business.Conversation);
        }
    }

    public void G(String str, String str2) {
        if (this.f73202f != null && !TextUtils.isEmpty(str2)) {
            this.f73202f.f(str, str2);
        }
    }

    public boolean H(String str) {
        VideoAppInterface videoAppInterface;
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null && (videoAppInterface = this.f73197a) != null) {
            try {
                return gVar.H1(str, videoAppInterface.getCurrentAccountUin());
            } catch (RemoteException e16) {
                e16.printStackTrace();
                return true;
            }
        }
        return true;
    }

    public void I(String str) {
        try {
            com.tencent.av.service.g gVar = this.f73199c;
            if (gVar != null) {
                gVar.g5(str);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceProxy", 2, "[red dot] redTouchManagerClick", e16);
            }
        }
    }

    public void J(String str) {
        try {
            com.tencent.av.service.g gVar = this.f73199c;
            if (gVar != null) {
                gVar.J1(str);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQServiceProxy", 2, "[red dot] redTouchManagerExposure", e16);
            }
        }
    }

    public Bundle K(int i3, int i16, int i17, Bundle bundle, ResultReceiver resultReceiver) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.M0(i3, i16, i17, null, bundle, resultReceiver);
            } catch (RemoteException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQServiceProxy", 2, "requestEvent, mainCmd[" + i3 + "], subType[" + i16 + "], seq[" + i17 + "]");
                    return null;
                }
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("QQServiceProxy", 1, "requestEvent, fail, mainCmd[" + i3 + "], subType[" + i16 + "], seq[" + i17 + "]");
            return null;
        }
        return null;
    }

    public void L(int i3, String str) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                gVar.m0(i3, str);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "setBindInfo", e16);
                }
            }
        }
    }

    public void M(int i3, String str, String str2) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                gVar.u1(i3, str, str2);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "setPeerInfo", e16);
                }
            }
        }
    }

    public void N(int i3, String str) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                gVar.U3(i3, str);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "startPumpMessage", e16);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean O() {
        boolean D2;
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                D2 = gVar.D2(2);
            } catch (RemoteException e16) {
                QLog.e("startRealNameAuth", 1, "startRealNameAuth error", e16);
            } catch (NullPointerException e17) {
                AVCoreLog.printErrorLog("startRealNameAuth", e17.getMessage());
            }
            if (QLog.isColorLevel()) {
                QLog.e("startRealNameAuth", 2, "startRealNameAuth  result " + this.f73199c + "   " + D2);
            }
            return D2;
        }
        D2 = false;
        if (QLog.isColorLevel()) {
        }
        return D2;
    }

    public void P(String str) {
        if (this.f73199c != null) {
            try {
                QLog.w("QQServiceProxy", 1, "stopPumpMessage[" + str + "]");
                this.f73199c.n4();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "stopPumpMessage", e16);
                }
            }
        }
    }

    public void Q(long j3) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                gVar.L2(j3);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "syncChatingTime", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        AVCoreLog.printAllUserLog("QQServiceProxy", "unbindQQService");
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                gVar.n4();
                this.f73199c.g0(this.f73201e);
            } catch (RemoteException e16) {
                QLog.e("QQServiceProxy", 2, "unbindQQService1 ", e16);
            } catch (Exception e17) {
                QLog.e("QQServiceProxy", 2, "unbindQQService2 ", e17);
            }
            try {
                VideoAppInterface videoAppInterface = this.f73197a;
                if (videoAppInterface != null) {
                    videoAppInterface.getApp().unbindService(this.f73200d);
                }
            } catch (Exception e18) {
                QLog.e("QQServiceProxy", 2, "unbindService3 ", e18);
            }
        }
    }

    public void S() {
        ImageCacheHelper.f98636a.e();
        com.tencent.cache.api.collection.a<String, String> aVar = this.f73202f;
        if (aVar != null) {
            aVar.d();
        }
        this.f73197a = null;
    }

    public void a(long j3, String str, long j16) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                gVar.k1(j3, str, j16);
                return;
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList e = ", e16);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQServiceProxy", 2, "addSharpMsgRecordList mQQServiceForAV==null");
        }
    }

    public void b() {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                gVar.v4();
                return;
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "avStartAddFriendService", e16);
                    return;
                }
                return;
            }
        }
        this.f73203g = true;
    }

    public void c() {
        if (QLog.isColorLevel()) {
            QLog.d("QQServiceProxy", 2, "bindQQService");
        }
        if (this.f73199c == null && !this.f73198b && this.f73197a != null) {
            this.f73198b = true;
            try {
                this.f73197a.getApp().bindService(new Intent(this.f73197a.getApp(), (Class<?>) QQServiceForAV.class), this.f73200d, 1);
            } catch (IllegalStateException e16) {
                QLog.e("QQServiceProxy", 1, "state error!", e16);
            } catch (SecurityException e17) {
                QLog.e("QQServiceProxy", 1, "the caller does not have permission to access the service or the service can not be found.", e17);
            }
        }
    }

    public int d(String str) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.n3(str);
            } catch (RemoteException e16) {
                QLog.e("QQServiceProxy", 2, "convertUinTypeEx e = ", e16);
                return -1;
            }
        }
        QLog.e("QQServiceProxy", 2, "convertUinTypeEx mQQServiceForAV == null");
        return -1;
    }

    public boolean e(int i3, long j3) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.P0(i3, j3);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "curGAInviteIsRight", e16);
                }
            }
        }
        return true;
    }

    public String f(ew.a aVar, int i3) throws NullPointerException {
        String str;
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                str = gVar.M(aVar.f397247a, aVar.f397248b, aVar.f397249c, i3);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("QQServiceProxy", 2, "getHDFacePath, param = " + aVar, e16);
                }
                str = null;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQServiceProxy", 2, "getHDFacePath, param = " + aVar + ", path = " + str);
            }
            return str;
        }
        throw new NullPointerException("mQQServiceForAV is null");
    }

    public Bitmap g(String str) {
        return ImageCacheHelper.f98636a.f(str);
    }

    public Bitmap h() {
        return BaseImageUtil.getDefaultFaceBitmap(true);
    }

    public long i(String str) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.r3(str);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", e16);
                }
            }
        }
        return 0L;
    }

    public long[] j(String str) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.K4(str);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "getDiscussMemberList", e16);
                }
            }
        }
        return null;
    }

    public String k(int i3, String str, String str2) {
        String r16 = r(i3, str, str2);
        String s16 = s(r16);
        if (!TextUtils.isEmpty(s16) && !s16.equals(str)) {
            return s16;
        }
        if (this.f73199c != null) {
            if (TextUtils.isEmpty(str) || str.equals(str)) {
                try {
                    String x36 = this.f73199c.x3(i3, str, str2);
                    try {
                        if (!TextUtils.isEmpty(x36)) {
                            G(r16, x36);
                        }
                        if (com.tencent.av.utils.e.k()) {
                            QLog.w("QQServiceProxy", 1, "getDisplayName, uinType[" + i3 + "], uin[" + LogUtil.getSafePrintUin(str) + "], extraUin[" + str2 + "], name[" + x36 + "]");
                        }
                        return x36;
                    } catch (RemoteException e16) {
                        e = e16;
                        str = x36;
                        if (QLog.isColorLevel()) {
                            QLog.w("QQServiceProxy", 2, "getDisplayName", e);
                            return str;
                        }
                        return str;
                    }
                } catch (RemoteException e17) {
                    e = e17;
                }
            } else {
                return str;
            }
        } else {
            return str;
        }
    }

    public String l(int i3, String str, String str2) {
        return s(r(i3, str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m() {
        boolean d46;
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                d46 = gVar.d4();
            } catch (RemoteException e16) {
                VideoAppInterface videoAppInterface = this.f73197a;
                if (videoAppInterface != null) {
                    uv.b.m(videoAppInterface.getApp());
                }
                QLog.e("PtuResChecker", 1, "getEffectsSoLoadIsOk", e16);
            } catch (NullPointerException e17) {
                VideoAppInterface videoAppInterface2 = this.f73197a;
                if (videoAppInterface2 != null) {
                    uv.b.m(videoAppInterface2.getApp());
                }
                QLog.e("PtuResChecker", 1, "getEffectsSoLoadIsOk", e17);
            }
            if (QLog.isColorLevel()) {
                QLog.e("PtuResChecker", 2, "getEffectsSoLoadIsOk, service[" + this.f73199c + "], result[" + d46 + "]");
            }
            return d46;
        }
        VideoAppInterface videoAppInterface3 = this.f73197a;
        if (videoAppInterface3 != null) {
            uv.b.m(videoAppInterface3.getApp());
        }
        QLog.i("PtuResChecker", 1, "getEffectsSoLoadIsOk, service not ready.");
        d46 = false;
        if (QLog.isColorLevel()) {
        }
        return d46;
    }

    public Bitmap n(int i3, String str, String str2, boolean z16, boolean z17) {
        int i16;
        String o16 = o(i3, str, str2, z16);
        Bitmap g16 = g(o16);
        if (g16 == null) {
            com.tencent.av.service.g gVar = this.f73199c;
            if (gVar != null) {
                try {
                    g16 = gVar.x1(i3, str, str2, z16, z17);
                    if (g16 != null) {
                        F(o16, g16);
                        i16 = 0;
                    } else {
                        i16 = 1;
                    }
                } catch (RemoteException unused) {
                    if (z17) {
                        g16 = h();
                    }
                    i16 = 2;
                } catch (NullPointerException unused2) {
                    if (z17) {
                        g16 = h();
                    }
                    i16 = 3;
                }
            } else {
                i16 = 4;
                if (z17) {
                    g16 = h();
                }
            }
        } else {
            i16 = -3;
        }
        if (com.tencent.av.utils.e.j()) {
            QLog.w("QQServiceProxy", 1, "getFaceBitmap, uinType[" + i3 + "], uin[" + str + "], extraUin[" + str2 + "], isNeedReturnDefaultValue[" + z17 + "], ret[" + i16 + "]");
        }
        return g16;
    }

    public String o(int i3, String str, String str2, boolean z16) {
        String str3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(i3);
        sb5.append("_");
        sb5.append(str);
        sb5.append("_");
        sb5.append(str2);
        sb5.append("_");
        if (z16) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        sb5.append(str3);
        return sb5.toString();
    }

    public int p(int i3, String str) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.m3(i3, str);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "getDiscussMemberNum", e16);
                }
            }
        }
        return 0;
    }

    public boolean q() {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.S4();
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "getNearbyProfileData", e16);
                }
            }
        }
        return false;
    }

    public String r(int i3, String str, String str2) {
        return "" + i3 + "_" + str + "_" + str2;
    }

    public String s(String str) {
        com.tencent.cache.api.collection.a<String, String> aVar = this.f73202f;
        if (aVar != null) {
            return aVar.e(str);
        }
        return "";
    }

    public String t(String str) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.getPhoneNumByUin(str);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "getPhoneNumByUin", e16);
                }
            }
        }
        return null;
    }

    public String u(String str) {
        String str2;
        String s16 = s(str);
        if (TextUtils.isEmpty(s16)) {
            com.tencent.av.service.g gVar = this.f73199c;
            if (gVar == null) {
                return null;
            }
            try {
                str2 = gVar.X1(str);
                try {
                    G(str, str2);
                    QLog.w("QQServiceProxy", 1, "getPhoneUserNameByPhoneNum, number[" + str + "], name[" + str2 + "]");
                    return str2;
                } catch (RemoteException e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        QLog.w("QQServiceProxy", 2, "getPhoneUserNameByPhoneNum", e);
                        return str2;
                    }
                    return str2;
                }
            } catch (RemoteException e17) {
                e = e17;
                str2 = null;
            }
        } else {
            return s16;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean v() {
        boolean z16;
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                z16 = gVar.D2(1);
            } catch (RemoteException e16) {
                QLog.e("getRealNameAuthed", 1, "getRealNameAuthed error", e16);
            } catch (NullPointerException e17) {
                AVCoreLog.printErrorLog("getRealNameAuthed", e17.getMessage());
            }
            if (QLog.isColorLevel()) {
                QLog.e("getRealNameAuthed", 2, "getEffectLibPagSoLoadIsOk  result " + this.f73199c + "   " + z16);
            }
            return z16;
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    public boolean w() {
        com.tencent.av.service.g gVar;
        int i3;
        if (this.f73204h == -1 && (gVar = this.f73199c) != null) {
            try {
                if (gVar.K2()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                this.f73204h = i3;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQServiceProxy", 2, "getTalkBack", e16);
                }
            }
        }
        if (this.f73204h != 1) {
            return false;
        }
        return true;
    }

    public boolean x(long j3) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar != null) {
            try {
                return gVar.K0(j3);
            } catch (RemoteException e16) {
                QLog.e("QQServiceProxy", 2, "getTroopAdmins-->troopUin=" + j3, e16);
            }
        }
        return false;
    }

    public void y() {
        this.f73202f = new com.tencent.cache.api.collection.a<>(Business.Default, "AVNickname", 100);
    }

    public boolean z(String str) {
        com.tencent.av.service.g gVar = this.f73199c;
        if (gVar == null) {
            return false;
        }
        try {
            return gVar.isFriend(str);
        } catch (RemoteException e16) {
            QLog.e("QQServiceProxy", 2, IProfileProtocolConst.PARAM_IS_FRIEND, e16);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends f.a {
        a() {
        }

        @Override // com.tencent.av.service.f
        public void E4(RecvGVideoLevelInfo[] recvGVideoLevelInfoArr) throws RemoteException {
            VideoAppInterface videoAppInterface;
            if (recvGVideoLevelInfoArr != null && recvGVideoLevelInfoArr.length > 0 && (videoAppInterface = r.this.f73197a) != null) {
                videoAppInterface.k0(new Object[]{501, recvGVideoLevelInfoArr});
            }
        }

        @Override // com.tencent.av.service.f
        public void K1(boolean z16, String str, String str2, String str3) throws RemoteException {
            VideoAppInterface videoAppInterface = r.this.f73197a;
            if (videoAppInterface != null) {
                videoAppInterface.k0(new Object[]{47, Boolean.valueOf(z16), str, str2, str3});
            }
        }

        @Override // com.tencent.av.service.f
        public Bundle U2(String str, int i3, int i16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("QQServiceProxy", 2, "getDataFromVideoProcess cmd = " + i3 + ",subCmd = " + i16 + ",request = " + bundle + ",callbackCookie = " + str);
            }
            if (i3 != 1) {
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("camera_used_desc", QavCameraUsage.f73493a);
            return bundle2;
        }

        @Override // com.tencent.av.service.f
        public void c1(String str, int i3, byte[] bArr) {
            ScreenShareManager screenShareManager;
            int length;
            QLog.i("QQServiceProxy", 2, "onReceivePushMsg");
            if (r.this.f73197a == null) {
                return;
            }
            if (TextUtils.equals(str, "avChatRoom")) {
                ChatRoomMng D = r.this.f73197a.D();
                if (D != null) {
                    D.q(i3, bArr);
                }
            } else if ((TextUtils.equals(str, "avScreenShareAsk") || TextUtils.equals(str, "avScreenShareAnswer")) && (screenShareManager = (ScreenShareManager) r.this.f73197a.B(18)) != null) {
                screenShareManager.o(i3, bArr);
            }
            int i16 = 0;
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onReceivePushMsg , key[");
                sb5.append(str);
                sb5.append("], msgType[");
                sb5.append(i3);
                sb5.append("], bytes[");
                if (bArr == null) {
                    length = 0;
                } else {
                    length = bArr.length;
                }
                sb5.append(length);
                sb5.append("]");
                QLog.i("ChatRoomMng", 4, sb5.toString());
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onReceivePushMsg  , key[");
            sb6.append(str);
            sb6.append("], msgType[");
            sb6.append(i3);
            sb6.append("], bytes[");
            if (bArr != null) {
                i16 = bArr.length;
            }
            sb6.append(i16);
            sb6.append("]");
            QLog.i("ChatRoomMng", 4, sb6.toString());
        }

        @Override // com.tencent.av.service.f
        public void x2(RecvMsg recvMsg) throws RemoteException {
        }

        @Override // com.tencent.av.service.f
        public void j4(String str, int i3, int i16, byte[] bArr) throws RemoteException {
        }
    }
}
