package com.tencent.av;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager;
import com.tencent.av.zplan.avatar.manager.AVChatBgSwitchLoadingManager;
import com.tencent.avcore.jni.data.DavPBCommonParam;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116$MemberInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class r implements au.f {

    /* renamed from: a, reason: collision with root package name */
    private static String f74232a = "VideoController";

    /* renamed from: b, reason: collision with root package name */
    public static String f74233b = "WifiQQCall";

    /* renamed from: c, reason: collision with root package name */
    public static String f74234c = "WifiRandom";

    /* renamed from: d, reason: collision with root package name */
    public static int f74235d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static int f74236e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static int f74237f = 0;

    /* renamed from: g, reason: collision with root package name */
    static volatile r f74238g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f74239h = "com.tencent.av.count";

    r() {
        QLog.i(f74232a, 1, "create VideoController");
        DAVController.G();
        MAVController.A();
        AVControllerCommon.p();
    }

    public static int C0(String str) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(f74239h, 0);
        int i3 = sharedPreferences.getInt(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str, i3 + 1);
        edit.commit();
        return i3;
    }

    public static boolean g1(Context context) {
        if (context == null) {
            return false;
        }
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static r h0() {
        return f74238g;
    }

    public static boolean h1(Context context) {
        return ((PowerManager) context.getSystemService("power")).isScreenOn();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0070, code lost:
    
        if (r19 == 2) goto L54;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0086. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:55:0x0089. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int s(int i3, boolean z16, int i16) {
        if (z16) {
            if (i3 != 0) {
                if (i3 != 8) {
                    if (i3 != 1004) {
                        if (i3 == 1006) {
                            return 5;
                        }
                        if (i3 != 1021) {
                            if (i3 != 1044) {
                                if (i3 != 9500) {
                                    if (i3 == 1000) {
                                        return 8;
                                    }
                                    if (i3 == 1001) {
                                        return 12;
                                    }
                                    if (i3 != 1010) {
                                        if (i3 != 1011) {
                                            if (i3 != 1024 && i3 != 1025) {
                                                if (i3 != 10002) {
                                                    if (i3 == 10003) {
                                                        return 29;
                                                    }
                                                    switch (i3) {
                                                        case 24:
                                                            return 24;
                                                        case 25:
                                                            return 25;
                                                        case 26:
                                                            return 26;
                                                        default:
                                                            return -1;
                                                    }
                                                }
                                                return 27;
                                            }
                                            return 19;
                                        }
                                        return 21;
                                    }
                                    return 20;
                                }
                            } else {
                                return 30;
                            }
                        } else {
                            return 10;
                        }
                    } else {
                        return 9;
                    }
                }
                return 22;
            }
        } else {
            if (i3 != 0) {
                if (i3 == 12) {
                    return 1001;
                }
                if (i3 != 9500) {
                    if (i3 == 4 || i3 == 5) {
                        return 1006;
                    }
                    if (i3 == 29) {
                        return 10003;
                    }
                    if (i3 != 30) {
                        switch (i3) {
                            case 8:
                                return 1000;
                            case 9:
                                return 1004;
                            case 10:
                                return 1021;
                            default:
                                switch (i3) {
                                    case 19:
                                        return 1025;
                                    case 20:
                                        return 1010;
                                    case 21:
                                        return 1011;
                                    case 22:
                                        return 22;
                                    default:
                                        switch (i3) {
                                            case 27:
                                                return 10002;
                                        }
                                }
                        }
                    }
                    return 1044;
                }
            }
            return 0;
        }
    }

    public static r t() {
        if (f74238g == null) {
            synchronized (r.class) {
                if (f74238g == null) {
                    f74238g = new r();
                }
            }
        }
        return f74238g;
    }

    public static void u() {
        DAVController.H();
        MAVController.D();
        AVControllerCommon.q();
        f74238g = null;
    }

    public AVCallCompactHelper A() {
        return AVControllerCommon.D().v();
    }

    public String A0() {
        return MAVController.Y().f0();
    }

    public void A1(int i3, long j3) {
        MAVController.Y().onGAudioRoomDestroy(i3, j3);
    }

    public void A2(int i3, String str, String str2, String str3, String str4, boolean z16) {
        DAVController.R().Z0(i3, str, str2, str3, str4, z16);
    }

    public void A3() {
        AVControllerCommon.D().u0();
    }

    public AVChatBgSwitchLoadingManager B() {
        return DAVController.R().J();
    }

    public ArrayList<e> B0() {
        return MAVController.Y().g0();
    }

    public void B1(int i3, long j3, int i16, int i17) {
        MAVController.Y().onGAudioSDKError(i3, j3, i16, i17);
    }

    public void B2(String str, int i3, boolean z16, boolean z17, boolean z18) {
        AVControllerCommon.D().f0(str, i3, z16, z17, z18);
    }

    public boolean B3(String str) {
        return MAVController.Y().J1(str);
    }

    public AVPhoneUserInfo C(long j3, ArrayList<AVPhoneUserInfo> arrayList) {
        return MAVController.Y().G(j3, arrayList);
    }

    public void C1(long j3, boolean z16, long j16) {
        MAVController.Y().onGAudioUserAudioSuspectNoisy(j3, z16, j16);
    }

    public void C2(String str, String str2, int i3, String str3, String str4, int i16, String str5, boolean z16, boolean z17) {
        AVControllerCommon.D().g0(str, str2, i3, str3, str4, i16, str5, z16, z17);
    }

    public void C3(long j3, int i3, long j16, ArrayList<String> arrayList) {
        MAVController.Y().M1(j3, i3, j16, arrayList);
    }

    public MqqHandler D() {
        return AVControllerCommon.D().w();
    }

    public StartRingRunnable D0() {
        return DAVController.R().f72621o;
    }

    public void D1(String str) {
        AVControllerCommon.D().Q(str);
    }

    public void D2(boolean z16) {
        AVControllerCommon.D().i0(z16);
    }

    public void D3(long j3) {
        DAVController.R().u1(j3);
    }

    public com.tencent.av.ui.funchat.record.i[] E() {
        return MAVController.Y().f72711m;
    }

    public String E0() {
        return MAVController.Y().f72706h;
    }

    public void E1(int i3, long j3, long j16, int i16, long j17, long j18) {
        MAVController.Y().I0(i3, j3, j16, i16, j17, j18);
    }

    public void E2(boolean z16) {
        DAVController.R().b1(z16);
    }

    public int E3(int i3, boolean z16) {
        return DAVController.R().v1(i3, z16);
    }

    public boolean F() {
        return MAVController.Y().H();
    }

    public TraeHelper F0() {
        return AVControllerCommon.D().f72574e;
    }

    public void F1(int i3, long j3, long j16, int i16, int i17, long j17, long j18) {
        MAVController.Y().J0(i3, j3, j16, i16, i17, j17, j18);
    }

    public void F2(boolean z16) {
        AVControllerCommon.D().j0(z16);
    }

    public void F3(int i3) {
        DAVController.R().x1(i3);
    }

    public AVChatAvatarEasterEggManager G() {
        return DAVController.R().K();
    }

    public VcControllerImpl G0() {
        return DAVController.R().f72607a;
    }

    public void G1(long j3, long j16, int i3, int i16, boolean z16) {
        MAVController.Y().K0(j3, j16, i3, i16, z16);
    }

    public void G2(VideoAppInterface videoAppInterface) {
        AVControllerCommon.D().k0(videoAppInterface);
    }

    public void G3() {
        DAVController.R().y1();
    }

    public AVChatAvatarEasterEggManager H() {
        return DAVController.E;
    }

    public int H0() {
        return MAVController.Y().h0();
    }

    public void H1(int i3, String str) {
        MAVController.Y().L0(i3, str);
    }

    public int H2(int i3, int i16, int i17, int i18) {
        return DAVController.R().c1(i3, i16, i17, i18);
    }

    public void H3(boolean z16) {
        DAVController.R().z1(z16);
    }

    public p I() {
        return AVControllerCommon.D().f72585p;
    }

    public String I0(ArrayList<com.tencent.av.gaudio.c> arrayList) {
        return MAVController.Y().i0(arrayList);
    }

    public void I1() {
        DAVController.R().n0();
    }

    public int I2(boolean z16, String str) {
        return DAVController.R().d1(z16, str);
    }

    public Pair<Integer, ArrayList<e>> I3() {
        return MAVController.Y().Q1();
    }

    public long J(String str) {
        return AVControllerCommon.D().x(str);
    }

    public ax.j J0() {
        return DAVController.R().V();
    }

    public void J1(String str) {
        DAVController.R().o0(str);
    }

    public void J2(boolean z16) {
        AVControllerCommon.D().l0(z16);
    }

    public void J3(PBRepeatMessageField<submsgtype0x116$MemberInfo> pBRepeatMessageField, PBRepeatMessageField<submsgtype0x116$MemberInfo> pBRepeatMessageField2, int i3, int i16) {
        MAVController.Y().R1(pBRepeatMessageField, pBRepeatMessageField2, i3, i16);
    }

    public long K() {
        return AVControllerCommon.D().y();
    }

    public void K0() {
        MAVController.Y().j0();
    }

    public void K1(boolean z16, boolean z17) {
        AVControllerCommon.D().R(z16, z17);
    }

    public void K2(boolean z16) {
        MAVController.Y().n1(z16);
    }

    public synchronized void K3() {
        AVControllerCommon.D().v0();
    }

    public int L() {
        return AVControllerCommon.D().z();
    }

    public boolean L0() {
        return MAVController.Y().k0();
    }

    public void L1(long j3, long j16) {
        MAVController.Y().T0(j3, j16);
    }

    public int L2(boolean z16) {
        return AVControllerCommon.D().m0(z16);
    }

    public void L3(String str, String str2) {
        DAVController.R().A1(str, str2);
    }

    public int M() {
        return DAVController.R().N();
    }

    public void M0(boolean z16, boolean z17) {
        DAVController.R().W(z16, z17);
    }

    public void M1(int i3, String str, String str2, byte[] bArr, boolean z16, String str3, int i16, int i17, DavPBCommonParam.CommonParam commonParam) {
        DAVController.R().q0(i3, str, str2, bArr, z16, str3, i16, i17, commonParam);
    }

    public void M2(boolean z16) {
        DAVController.R().C = z16;
    }

    public void M3(String str, String str2, String str3) {
        DAVController.R().B1(str, str2, str3);
    }

    public long N() {
        return MAVController.Y().I();
    }

    public void N0(AVFilamentTextureView aVFilamentTextureView, boolean z16, Rect rect, int i3) {
        DAVController.R().X(aVFilamentTextureView, z16, rect, i3);
    }

    public void N1() {
        DAVController.R().r0();
    }

    public void N2(long j3) {
        MAVController.Y().f72717s = j3;
    }

    public int N3(String str) {
        return DAVController.R().C1(str);
    }

    public long O() {
        return AVControllerCommon.D().A();
    }

    public boolean O0() {
        return DAVController.R().f72611e;
    }

    public void O1(int i3, int i16, int i17, long j3, int i18, int i19) {
        MAVController.Y().onShareOpsCallback(i3, i16, i17, j3, i18, i19);
    }

    public void O2(int i3) {
        MAVController.Y().f72718t = i3;
    }

    public void O3() {
        DAVController.R().D1();
    }

    public long P() {
        return DAVController.R().O();
    }

    public void P0(long j3, int i3, long j16) {
        MAVController.Y().l0(j3, i3, j16);
    }

    public void P1(long j3) {
        DAVController.R().s0(j3);
    }

    public void P2(long j3, int i3, boolean z16, boolean z17) {
        AVControllerCommon.D().n0(j3, i3, z16, z17);
    }

    public void P3(int i3, String str) {
        DAVController.R().E1(i3, str);
    }

    public int Q(boolean z16) {
        return AVControllerCommon.D().B(z16);
    }

    public void Q0(long j3, int i3, long j16, int i16, boolean z16) {
        MAVController.Y().m0(j3, i3, j16, i16, z16);
    }

    public void Q1(String str, long j3) {
        DAVController.R().t0(str, j3);
    }

    public void Q2(long[] jArr) {
        MAVController.Y().o1(jArr);
    }

    public com.tencent.av.opengl.effects.m R(boolean z16) {
        return AVControllerCommon.D().C(z16);
    }

    public synchronized boolean R0() {
        return DAVController.R().Z();
    }

    public void R1() {
        AVControllerCommon.D().S();
    }

    public void R2(String str, boolean z16) {
        MAVController.Y().p1(str, z16);
    }

    public Bitmap S(String str, String str2, int i3, boolean z16, boolean z17) {
        return MAVController.Y().J(str, str2, i3, z16, z17);
    }

    public void S0(AVFilamentTextureView aVFilamentTextureView) {
        DAVController.R().a0(aVFilamentTextureView);
    }

    public void S1(String str) {
        DAVController.R().w0(str);
    }

    public void S2(int i3, int i16, int i17) {
        MAVController.Y().q1(i3, i16, i17);
    }

    public e T(String str) {
        return MAVController.Y().K(str);
    }

    public void T0(long[] jArr, boolean z16, String[] strArr) {
        MAVController.Y().q0(jArr, z16, strArr);
    }

    public void T1() {
        AVControllerCommon.D().T();
    }

    public void T2(String str, int i3) {
        MAVController.Y().r1(str, i3);
    }

    public String U(String str, String str2, int i3) {
        return MAVController.Y().L(str, str2, i3);
    }

    public boolean U0() {
        return DAVController.R().b0();
    }

    public void U1() {
        AVControllerCommon.D().U();
    }

    public void U2() {
        MAVController.Y().s1();
    }

    public String V(String str, String str2, int i3) {
        return MAVController.Y().M(str, str2, i3);
    }

    public boolean V0() {
        return DAVController.R().f72612f;
    }

    public void V1(long j3, int i3, int i16, MediaPlayer.OnCompletionListener onCompletionListener) {
        AVControllerCommon.D().V(j3, i3, i16, onCompletionListener);
    }

    public int V2(int i3, int i16, int i17) {
        return DAVController.R().g1(i3, i16, i17);
    }

    public QQGAudioCtrl W() {
        return MAVController.Y().N();
    }

    public boolean W0() {
        return MAVController.Y().f72699a;
    }

    public byte[] W1(long j3, long j16, byte[] bArr) {
        return DAVController.R().x0(j3, j16, bArr);
    }

    public int W2(int i3) {
        return DAVController.R().h1(i3);
    }

    public long X() {
        return MAVController.Y().f72700b;
    }

    public boolean X0() {
        return MAVController.Y().s0();
    }

    public boolean X1(String str) {
        return DAVController.R().B0(str);
    }

    public void X2(boolean z16) {
        AVControllerCommon.D().o0(z16);
    }

    public ArrayList<e> Y() {
        return MAVController.Y().O();
    }

    public boolean Y0() {
        return AVControllerCommon.D().J();
    }

    @TargetApi(21)
    public void Y1(long j3, long j16, boolean z16, int i3) {
        MAVController.Y().Y0(j3, j16, z16, i3);
    }

    public void Y2(int i3) {
        MAVController.Y().f72710l = i3;
    }

    public ArrayList<ResultRecord> Z() {
        return MAVController.Y().P();
    }

    public boolean Z0() {
        return MAVController.Y().G;
    }

    public void Z1() {
        MAVController.Y().Z0();
    }

    public void Z2(String str, long j3) {
        DAVController.R().i1(str, j3);
    }

    public int a(long j3, int i3, long j16, long[] jArr, boolean z16) {
        return MAVController.Y().t(j3, i3, j16, jArr, z16);
    }

    public int a0() {
        return MAVController.Y().Q();
    }

    public boolean a1(SessionInfo sessionInfo) {
        return MAVController.Y().u0(sessionInfo);
    }

    public synchronized void a2(int i3, long j3, int i16) {
        MAVController.Y().a1(i3, j3, i16);
    }

    public void a3(int i3) {
        MAVController.Y().f72709k = i3;
    }

    public int b(long j3, String str, int i3, int i16) {
        return DAVController.R().u(j3, str, i3, i16);
    }

    public int b0() {
        return MAVController.Y().f72701c;
    }

    public boolean b1(SessionInfo sessionInfo) {
        return AVControllerCommon.D().L(sessionInfo);
    }

    public void b2() {
        DAVController.R().E0();
    }

    public boolean b3(long j3, boolean z16) {
        return MAVController.Y().t1(j3, z16);
    }

    public void c(long j3, String str, int i3, boolean z16, Runnable runnable) {
        DAVController.R().v(j3, str, i3, z16, runnable);
    }

    public long c0(int i3, int i16, long j3) {
        return MAVController.Y().a(i3, i16, j3);
    }

    public boolean c1() {
        return AVControllerCommon.D().f72589t;
    }

    public void c2(String str, int i3) {
        AVControllerCommon.D().W(str, i3);
    }

    public void c3() {
        AVControllerCommon.D().p0();
    }

    public void d(boolean z16) {
        DAVController.R().x(z16);
    }

    public boolean d0(int i3, long j3, int i16) {
        return MAVController.Y().S(i3, j3, i16);
    }

    public boolean d1() {
        return MAVController.Y().f72716r;
    }

    public boolean d2() {
        return MAVController.Y().b1();
    }

    public void d3(int i3) {
        MAVController.Y().f72707i = i3;
    }

    public boolean e() {
        return DAVController.R().y();
    }

    public int e0() {
        return MAVController.Y().T();
    }

    public boolean e1() {
        return DAVController.R().d0();
    }

    public int e2(int i3, boolean z16) {
        return DAVController.R().G0(i3, z16);
    }

    public void e3(Runnable runnable) {
        AVControllerCommon.D().f72573d = runnable;
    }

    @Override // au.f
    public synchronized void f(int i3, com.tencent.av.ui.funchat.record.i iVar) {
        MAVController.Y().f(i3, iVar);
    }

    public long f0() {
        return MAVController.Y().U();
    }

    public boolean f1(int i3, String str, String str2, byte[] bArr, boolean z16, String str3, int i16, int i17) {
        return AVControllerCommon.D().M(i3, str, str2, bArr, z16, str3, i16, i17);
    }

    public void f2(long j3, boolean z16) {
        MAVController.Y().d1(j3, z16);
    }

    public void f3(boolean z16) {
        MAVController.Y().f72716r = z16;
    }

    public void g(long j3, String str, int i3, boolean z16) {
        DAVController.R().z(j3, str, i3, z16);
    }

    public long g0() {
        return MAVController.Y().V();
    }

    public void g2(Class cls) {
        AVControllerCommon.D().Z(cls);
    }

    public void g3(boolean z16) {
        DAVController.R().f72608b = z16;
    }

    public boolean h() {
        return DAVController.R().A();
    }

    public void h2(long j3, ArrayList<com.tencent.av.gaudio.c> arrayList, ArrayList<com.tencent.av.gaudio.c> arrayList2, int i3, boolean z16) {
        MAVController.Y().g1(j3, arrayList, arrayList2, i3, z16);
    }

    public void h3(long j3) {
        DAVController.R().f72619m = j3;
    }

    public void i() {
        DAVController.R().C();
    }

    public ArrayList<e> i0() {
        return MAVController.Y().Z();
    }

    public boolean i1() {
        return DAVController.R().e0();
    }

    public void i2(int i3) {
        AVControllerCommon.D().b0(i3);
    }

    public void i3(boolean z16) {
        DAVController.R().f72611e = z16;
    }

    public boolean j(String str, SessionInfo sessionInfo) {
        return AVControllerCommon.D().k(str, sessionInfo);
    }

    public int j0() {
        return AVControllerCommon.D().E();
    }

    public boolean j1(String str) {
        return DAVController.R().f0(str);
    }

    public void j2(int i3) {
        DAVController.R().H0(i3);
    }

    public boolean j3(boolean z16) {
        return MAVController.Y().u1(z16);
    }

    @TargetApi(21)
    public boolean k() {
        return AVControllerCommon.D().l();
    }

    public long k0(long j3) {
        return DAVController.R().getMSFInviteMessageTimeStamp(j3);
    }

    public boolean k1() {
        return AVControllerCommon.D().f72590u;
    }

    public int k2(long j3, String str, int i3, int i16, String str2, String str3, String str4, int i17, String str5, String str6, byte[] bArr, String str7, String str8, int i18, int i19, String str9, String str10) {
        return DAVController.R().I0(j3, str, i3, i16, str2, str3, str4, i17, str5, str6, bArr, str7, str8, i18, i19, str9, str10);
    }

    public void k3(boolean z16) {
        MAVController.Y().v1(z16);
    }

    public void l() {
        MAVController.Y().w();
    }

    public QavChannelProxy l0() {
        return AVControllerCommon.D().f72571b;
    }

    public boolean l1() {
        return AVControllerCommon.D().f72588s;
    }

    public void l2(int i3) {
        DAVController.R().K0(i3);
    }

    public void l3(boolean z16) {
        MAVController.Y().w1(z16);
    }

    public void m() {
        MAVController.Y().x();
    }

    public int m0() {
        return AVControllerCommon.D().f72578i;
    }

    public void m1(int i3, int i16, int i17, long j3) {
        MAVController.Y().w0(i3, i16, i17, j3);
    }

    public boolean m2(boolean z16) {
        return MAVController.Y().h1(z16);
    }

    public void m3(StartRingRunnable startRingRunnable) {
        DAVController.R().f72621o = startRingRunnable;
    }

    public void n() {
        MAVController.Y().y();
    }

    public long n0() {
        return MAVController.Y().f72708j;
    }

    public ArrayList<e> n1(int i3, ArrayList<e> arrayList) {
        return MAVController.Y().x0(i3, arrayList);
    }

    public void n2() {
        MAVController.Y().i1();
    }

    public void n3(boolean z16) {
        AVControllerCommon.D().f72588s = z16;
    }

    public void o(long j3, long j16, int i3) {
        MAVController.Y().z(j3, j16, i3);
    }

    public ArrayList<Long> o0() {
        return MAVController.Y().a0();
    }

    public void o1(int i3, String str) {
        MAVController.Y().y0(i3, str);
    }

    public void o2() {
        MAVController.Y().j1();
    }

    public boolean o3() {
        return MAVController.Y().x1();
    }

    public void p(boolean z16, int i3, int... iArr) {
        AVControllerCommon.D().m(z16, i3, iArr);
    }

    public Runnable p0() {
        return AVControllerCommon.D().f72573d;
    }

    public void p1() {
        MAVController.Y().A0();
    }

    public void p2(String str) {
        DAVController.R().L0(str);
    }

    public void p3(boolean z16) {
        MAVController.Y().y1(z16);
    }

    public void q(String str, int i3) {
        DAVController.R().E(str, i3);
    }

    public long q0() {
        return DAVController.R().S();
    }

    public void q1(long j3, int i3, int i16) {
        MAVController.Y().B0(j3, i3, i16);
    }

    public void q2(long j3, long j16, ArrayList<com.tencent.av.gaudio.a> arrayList) {
        MAVController.Y().k1(j3, j16, arrayList);
    }

    public void q3(boolean z16) {
        MAVController.Y().z1(z16);
    }

    public void r(String str, int i3) {
        DAVController.R().F(str, i3);
    }

    public int r0() {
        return MAVController.Y().b0();
    }

    public void r1() {
        DAVController.R().h0();
    }

    public void r2(String str) {
        DAVController.R().M0(str);
    }

    public void r3(boolean z16) {
        MAVController.Y().A1(z16);
    }

    public int s0(String str) {
        return DAVController.R().T(str);
    }

    public void s1(boolean z16) {
        DAVController.R().i0(z16);
    }

    public int s2(int i3, String str) {
        return DAVController.R().N0(i3, str);
    }

    public void s3(boolean z16) {
        DAVController.R().j1(z16);
    }

    public int t0(String str) {
        return DAVController.R().U(str);
    }

    public void t1(ArrayList<AVPhoneUserInfo> arrayList) {
        MAVController.Y().C0(arrayList);
    }

    public int t2(int i3, byte[] bArr) {
        return DAVController.R().O0(i3, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t3() {
        AVControllerCommon.D().q0();
    }

    @Nullable
    public PhoneStatusAudioModeMonitor u0() {
        return AVControllerCommon.D().F();
    }

    public void u1(int i3) {
        AVControllerCommon.D().P(i3);
    }

    public void u2(boolean z16, int i3, int i16, String str) {
        DAVController.R().Q0(z16, i3, i16, str);
    }

    public ArrayList<e> u3() {
        return MAVController.Y().D1();
    }

    public void v(boolean z16) {
        AVControllerCommon.D().r(z16);
    }

    public boolean v0() {
        return DAVController.R().f72608b;
    }

    public void v1(String str, long j3) {
        DAVController.R().j0(str, j3);
    }

    public void v2(int i3, String str, long j3, int i16) {
        DAVController.R().R0(i3, str, j3, i16);
    }

    public void v3() {
        MAVController.Y().E1();
    }

    public boolean w(boolean z16) {
        return AVControllerCommon.D().s(z16);
    }

    public long w0() {
        return DAVController.R().f72619m;
    }

    public void w1(long j3, String str, int i3, boolean z16) {
        DAVController.R().k0(j3, str, i3, z16);
    }

    public void w2(int i3) {
        DAVController.R().S0(i3);
    }

    public void w3() {
        AVControllerCommon.D().s0();
    }

    public void x(int i3) {
        AVControllerCommon.D().t(i3);
    }

    @TargetApi(21)
    public ScreenRecordHelper x0() {
        return AVControllerCommon.D().G();
    }

    public void x1(String str, int i3, long j3, byte[] bArr, int i16, String str2) {
        DAVController.R().l0(str, i3, j3, bArr, i16, str2);
    }

    public void x2(long j3, ArrayList<String> arrayList) {
        MAVController.Y().l1(j3, arrayList);
    }

    public void x3(int i3, int i16, boolean z16, boolean z17, String str) {
        MAVController.Y().F1(i3, i16, z16, z17, str);
    }

    public void y(String str, long j3, boolean z16) {
        MAVController.Y().E(str, j3, z16);
    }

    public ScreenShareCtrl y0() {
        return AVControllerCommon.D().H();
    }

    public void y1(int i3) {
        MAVController.Y().onFpsChange(i3);
    }

    public void y2(int i3, String str, String str2, String str3, boolean z16) {
        DAVController.R().W0(i3, str, str2, str3, z16);
    }

    public int y3(int i3, long j3, int i16, long[] jArr, boolean z16, String[] strArr) {
        return MAVController.Y().G1(i3, j3, i16, jArr, z16, strArr);
    }

    public void z(String str, long j3, boolean z16, boolean z17, int i3) {
        MAVController.Y().F(str, j3, z16, z17, i3);
    }

    public boolean z0() {
        return MAVController.Y().e0();
    }

    public void z1(long j3, String str, String[] strArr) {
        MAVController.Y().E0(j3, str, strArr);
    }

    public void z2(long j3, long j16) {
        DAVController.R().Y0(j3, j16);
    }

    public void z3(long j3) {
        DAVController.R().o1(j3);
    }
}
