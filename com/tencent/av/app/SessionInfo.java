package com.tencent.av.app;

import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.ui.al;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.ba;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.util.AVConstants;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SessionInfo extends s {
    public static int j3;
    public Boolean O2;
    public Boolean P2;
    public Boolean Q2;
    public boolean R2;
    public boolean S2;
    public boolean T2;
    public String U2;
    public boolean V2;
    public int W2;
    public boolean X2;
    public boolean Y2;
    public long Z2;

    /* renamed from: a3, reason: collision with root package name */
    public boolean f73003a3;

    /* renamed from: b3, reason: collision with root package name */
    public int f73007b3;

    /* renamed from: c3, reason: collision with root package name */
    public boolean f73011c3;

    /* renamed from: d3, reason: collision with root package name */
    public boolean f73015d3;

    /* renamed from: e3, reason: collision with root package name */
    public boolean f73019e3;

    /* renamed from: f, reason: collision with root package name */
    public final String f73020f;

    /* renamed from: f3, reason: collision with root package name */
    public boolean f73024f3;

    /* renamed from: g3, reason: collision with root package name */
    public boolean f73029g3;

    /* renamed from: h3, reason: collision with root package name */
    public boolean f73034h3;
    public HashSet<Integer> i3;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f73072r0;

    /* renamed from: w2, reason: collision with root package name */
    protected WeakReference<al> f73094w2;

    /* renamed from: g, reason: collision with root package name */
    public int f73025g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f73030h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f73035i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f73039j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f73043k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f73047l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f73051m = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f73055n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f73059o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f73063p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f73067q = -1;

    /* renamed from: r, reason: collision with root package name */
    public boolean f73071r = false;

    /* renamed from: s, reason: collision with root package name */
    public int f73075s = -1;

    /* renamed from: t, reason: collision with root package name */
    public String f73079t = "1";

    /* renamed from: u, reason: collision with root package name */
    public long f73083u = -1;

    /* renamed from: v, reason: collision with root package name */
    public boolean f73087v = false;

    /* renamed from: w, reason: collision with root package name */
    public String f73091w = null;

    /* renamed from: x, reason: collision with root package name */
    private String f73095x = "";

    /* renamed from: y, reason: collision with root package name */
    public String f73099y = null;

    /* renamed from: z, reason: collision with root package name */
    public String f73103z = null;
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public String E = null;
    public long F = 0;
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public int J = 0;
    public boolean K = false;
    public boolean L = false;
    public boolean M = true;
    public boolean N = false;
    public boolean O = false;
    public boolean P = false;
    public int Q = 3;
    public boolean R = true;
    public boolean S = false;
    public boolean T = true;
    public boolean U = true;
    public boolean V = true;
    public boolean W = false;
    public boolean X = false;
    public boolean Y = false;
    public int Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    public int f73000a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    public int f73004b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public int f73008c0 = -1;

    /* renamed from: d0, reason: collision with root package name */
    public long f73012d0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    public int f73016e0 = 0;

    /* renamed from: f0, reason: collision with root package name */
    public int f73021f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    public String f73026g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    public String f73031h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f73036i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    public int f73040j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    public int f73044k0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f73048l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f73052m0 = false;

    /* renamed from: n0, reason: collision with root package name */
    public int f73056n0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f73060o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f73064p0 = false;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f73068q0 = false;

    /* renamed from: s0, reason: collision with root package name */
    public long f73076s0 = 0;

    /* renamed from: t0, reason: collision with root package name */
    public String f73080t0 = null;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f73084u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f73088v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    public ArrayList<Long> f73092w0 = new ArrayList<>();

    /* renamed from: x0, reason: collision with root package name */
    public ArrayList<String> f73096x0 = new ArrayList<>();

    /* renamed from: y0, reason: collision with root package name */
    public long f73100y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public long f73104z0 = 0;
    public int A0 = -1;
    public int B0 = 0;
    public int C0 = 0;
    public String D0 = null;
    public int E0 = 0;
    public String F0 = null;
    public String G0 = null;
    public String[] H0 = null;
    public boolean I0 = false;
    public byte[] J0 = null;
    public boolean K0 = false;
    public boolean L0 = false;
    public boolean M0 = false;
    public boolean N0 = false;
    public boolean O0 = false;
    public long P0 = 0;
    public long[] Q0 = null;
    public int R0 = -1;
    public int S0 = 0;
    public int T0 = 0;
    public boolean U0 = false;
    public boolean V0 = false;
    public boolean W0 = false;
    public int X0 = 2;
    public String Y0 = null;
    public long Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    public int f73001a1 = 0;

    /* renamed from: b1, reason: collision with root package name */
    public int f73005b1 = 1;

    /* renamed from: c1, reason: collision with root package name */
    @Deprecated
    public int f73009c1 = -1;

    /* renamed from: d1, reason: collision with root package name */
    @Deprecated
    public boolean f73013d1 = false;

    /* renamed from: e1, reason: collision with root package name */
    @Deprecated
    public boolean f73017e1 = false;

    /* renamed from: f1, reason: collision with root package name */
    @Deprecated
    public boolean f73022f1 = false;

    /* renamed from: g1, reason: collision with root package name */
    @Deprecated
    public boolean f73027g1 = false;

    /* renamed from: h1, reason: collision with root package name */
    @Deprecated
    public boolean f73032h1 = false;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f73037i1 = false;

    /* renamed from: j1, reason: collision with root package name */
    public boolean f73041j1 = false;

    /* renamed from: k1, reason: collision with root package name */
    public volatile ArrayList<com.tencent.av.gaudio.c> f73045k1 = new ArrayList<>();

    /* renamed from: l1, reason: collision with root package name */
    public volatile boolean f73049l1 = false;

    /* renamed from: m1, reason: collision with root package name */
    public ArrayList<com.tencent.av.gaudio.c> f73053m1 = new ArrayList<>();

    /* renamed from: n1, reason: collision with root package name */
    public ArrayList<com.tencent.av.gaudio.c> f73057n1 = new ArrayList<>();

    /* renamed from: o1, reason: collision with root package name */
    public ArrayList<AVPhoneUserInfo> f73061o1 = new ArrayList<>();

    /* renamed from: p1, reason: collision with root package name */
    public String f73065p1 = TraeConstants.DEVICE_NONE;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f73069q1 = false;

    /* renamed from: r1, reason: collision with root package name */
    public boolean f73073r1 = false;

    /* renamed from: s1, reason: collision with root package name */
    public boolean f73077s1 = true;

    /* renamed from: t1, reason: collision with root package name */
    public boolean f73081t1 = false;

    /* renamed from: u1, reason: collision with root package name */
    public boolean f73085u1 = false;

    /* renamed from: v1, reason: collision with root package name */
    public long f73089v1 = 0;

    /* renamed from: w1, reason: collision with root package name */
    public boolean f73093w1 = false;

    /* renamed from: x1, reason: collision with root package name */
    public boolean f73097x1 = false;

    /* renamed from: y1, reason: collision with root package name */
    public boolean f73101y1 = false;

    /* renamed from: z1, reason: collision with root package name */
    public boolean f73105z1 = false;
    public boolean A1 = false;
    public boolean B1 = false;
    public boolean C1 = false;
    public int D1 = 7;
    public boolean E1 = false;
    public boolean F1 = false;
    public boolean G1 = false;
    public boolean H1 = false;
    public BitSet I1 = new BitSet();
    public String J1 = "";
    public long K1 = 0;
    public boolean L1 = false;
    public boolean M1 = true;
    public boolean N1 = false;
    public int O1 = 1;
    public boolean P1 = false;
    public int Q1 = 0;
    public int R1 = 0;
    public int S1 = -1;
    public boolean T1 = false;
    public int U1 = 0;
    public int V1 = 0;
    public int W1 = 1;
    public String X1 = null;
    public boolean Y1 = false;
    public boolean Z1 = true;

    /* renamed from: a2, reason: collision with root package name */
    public int f73002a2 = -1;

    /* renamed from: b2, reason: collision with root package name */
    public boolean f73006b2 = false;

    /* renamed from: c2, reason: collision with root package name */
    public int f73010c2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getEffectSettingQavNone();

    /* renamed from: d2, reason: collision with root package name */
    public long f73014d2 = 0;

    /* renamed from: e2, reason: collision with root package name */
    public boolean f73018e2 = false;

    /* renamed from: f2, reason: collision with root package name */
    public boolean f73023f2 = false;

    /* renamed from: g2, reason: collision with root package name */
    public String f73028g2 = null;

    /* renamed from: h2, reason: collision with root package name */
    public int f73033h2 = 15000;

    /* renamed from: i2, reason: collision with root package name */
    public boolean f73038i2 = false;

    /* renamed from: j2, reason: collision with root package name */
    public int f73042j2 = 0;

    /* renamed from: k2, reason: collision with root package name */
    public int f73046k2 = 0;

    /* renamed from: l2, reason: collision with root package name */
    public int f73050l2 = 0;

    /* renamed from: m2, reason: collision with root package name */
    protected final ConcurrentHashMap<Long, Boolean> f73054m2 = new ConcurrentHashMap<>();

    /* renamed from: n2, reason: collision with root package name */
    public int f73058n2 = 0;

    /* renamed from: o2, reason: collision with root package name */
    public boolean f73062o2 = false;

    /* renamed from: p2, reason: collision with root package name */
    public int f73066p2 = -1;

    /* renamed from: q2, reason: collision with root package name */
    public int f73070q2 = -1;

    /* renamed from: r2, reason: collision with root package name */
    public int f73074r2 = -1;

    /* renamed from: s2, reason: collision with root package name */
    public int f73078s2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();

    /* renamed from: t2, reason: collision with root package name */
    public int f73082t2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();

    /* renamed from: u2, reason: collision with root package name */
    public boolean f73086u2 = false;

    /* renamed from: v2, reason: collision with root package name */
    private int f73090v2 = 0;

    /* renamed from: x2, reason: collision with root package name */
    public boolean f73098x2 = false;

    /* renamed from: y2, reason: collision with root package name */
    public boolean f73102y2 = false;

    /* renamed from: z2, reason: collision with root package name */
    public boolean f73106z2 = false;
    public boolean A2 = false;
    public boolean B2 = false;
    public int C2 = -1;
    public int D2 = 20;
    public boolean E2 = false;
    public boolean F2 = false;
    public boolean G2 = false;
    public boolean H2 = false;
    public boolean I2 = false;
    public boolean J2 = false;
    public String K2 = "";
    public boolean L2 = false;
    public String M2 = "";
    public String N2 = "";

    public SessionInfo() {
        Boolean bool = Boolean.FALSE;
        this.O2 = bool;
        this.P2 = bool;
        this.Q2 = bool;
        this.R2 = false;
        this.S2 = false;
        this.T2 = false;
        this.U2 = null;
        this.V2 = false;
        this.W2 = 0;
        this.X2 = false;
        this.Y2 = false;
        this.Z2 = -1L;
        this.f73003a3 = false;
        this.f73007b3 = 0;
        this.f73011c3 = false;
        this.f73015d3 = false;
        this.f73019e3 = false;
        this.f73024f3 = true;
        this.f73029g3 = false;
        this.f73034h3 = false;
        this.i3 = new HashSet<>(8);
        String str = "SessionInfo_" + com.tencent.av.utils.e.d();
        this.f73020f = str;
        QLog.w(str, 1, "createSession");
    }

    private boolean g(com.tencent.av.gaudio.c cVar) {
        Iterator<com.tencent.av.gaudio.c> it = this.f73053m1.iterator();
        while (it.hasNext()) {
            com.tencent.av.gaudio.c next = it.next();
            if (cVar.f73828b == next.f73828b && cVar.f73827a == next.f73827a) {
                return true;
            }
        }
        return false;
    }

    private void j(long j16) {
        X(j16, 0L);
        this.f73014d2 = 0L;
        n0("clearSessionInfo", 0);
        this.f73067q = -1;
        this.K = false;
        this.L = false;
        p0(j16, "clearSessionInfo", 0);
        this.f73078s2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
        this.f73082t2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getVoiceTypeNone();
        this.Y1 = false;
        this.Z1 = true;
        a0(false);
        this.f73076s0 = 0L;
        this.Y0 = null;
        this.H = false;
        this.Y = false;
        this.f73048l0 = false;
        this.f73052m0 = false;
        this.f73018e2 = false;
        this.A0 = -1;
        this.M1 = true;
        this.J1 = "";
        this.K1 = 0L;
        this.I1.clear();
        c0(j16, false);
        k0(j16, false);
        this.O1 = 1;
        this.S0 = 0;
        this.f73010c2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getEffectSettingQavNone();
        this.X2 = false;
        this.f73094w2 = null;
        this.f73054m2.clear();
        A0("clearSessionInfo", 0, 0);
        this.f73098x2 = false;
        this.f73102y2 = false;
        this.f73106z2 = false;
        this.A2 = false;
        this.B2 = false;
        this.C2 = -1;
        this.f73070q2 = -1;
        this.E2 = false;
        this.H2 = false;
        this.J2 = false;
        Boolean bool = Boolean.FALSE;
        this.O2 = bool;
        this.P2 = bool;
        this.Q2 = bool;
        this.V2 = false;
        this.D1 = 7;
    }

    public boolean A() {
        if (this.f73043k == 3) {
            return true;
        }
        return false;
    }

    public void A0(String str, int i3, int i16) {
        if ((this.f73046k2 != i3 || this.f73050l2 != i16) && QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "updateShareInfo, state[" + this.f73046k2 + "-->" + i3 + "], type[" + this.f73050l2 + "-->" + i16 + "], from[" + str + "]");
        }
        if (this.f73046k2 != i3) {
            this.f73046k2 = i3;
        }
        if (this.f73050l2 != i16) {
            this.f73050l2 = i16;
        }
    }

    public boolean B() {
        if (this.S0 == 2) {
            return true;
        }
        return false;
    }

    public void B0(long j16, boolean z16, boolean z17) {
        try {
            this.f73054m2.put(Long.valueOf(j16), Boolean.valueOf(z16));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public boolean C() {
        if (this.f73043k == 2) {
            return true;
        }
        return false;
    }

    public boolean D() {
        if (this.f73043k == 0) {
            return true;
        }
        return false;
    }

    public boolean E() {
        int i3 = this.f73035i;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public boolean F() {
        int i3 = this.f73035i;
        if (i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    public boolean G() {
        if (this.T0 != 0) {
            return true;
        }
        return false;
    }

    public boolean H() {
        if (!G() && !this.V0) {
            return false;
        }
        return true;
    }

    public boolean I() {
        if (this.T0 == 2) {
            return true;
        }
        return false;
    }

    public boolean J() {
        if (!this.f73098x2 && !this.f73102y2) {
            return false;
        }
        return true;
    }

    public boolean K() {
        if (this.f73043k == 1) {
            return true;
        }
        return false;
    }

    public boolean L() {
        if (this.f73043k == 14) {
            return true;
        }
        return false;
    }

    public boolean M(long j16, int i3) {
        for (int i16 = 0; i16 < this.f73045k1.size(); i16++) {
            if (this.f73045k1.get(i16).f73827a == j16 && this.f73045k1.get(i16).f73828b == i3) {
                return this.f73045k1.get(i16).f73832f;
            }
        }
        return false;
    }

    public boolean N() {
        if (this.f73043k == 10) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        r0 = true;
        r1 = r5.getKey().longValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean O(String str) {
        boolean z16 = false;
        long j16 = 0;
        try {
            long q16 = AVUtil.q(str);
            Iterator<Map.Entry<Long, Boolean>> it = this.f73054m2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, Boolean> next = it.next();
                if (next.getValue() != null && next.getValue().booleanValue() && next.getKey() != null && next.getKey().longValue() != q16) {
                    break;
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "isOtherUserShareScreenNow, [" + j16 + "," + z16 + "]");
        }
        return z16;
    }

    public boolean P() {
        int i3 = this.f73035i;
        if (i3 != 2 && i3 != 4) {
            return false;
        }
        return true;
    }

    public boolean Q(BaseVideoAppInterface baseVideoAppInterface) {
        String str;
        boolean z16;
        int i3;
        if (this.f73090v2 == 0 && baseVideoAppInterface != null) {
            int i16 = this.f73067q;
            if (i16 == -1) {
                i16 = ba.avRelationType2UinType(this.S0);
            }
            if (i16 == 0) {
                str = this.f73091w;
            } else if (i16 == 1) {
                str = String.valueOf(this.P0);
            } else if (i16 == -1) {
                str = String.valueOf(this.P0);
            } else {
                str = null;
            }
            if (i16 != -1) {
                z16 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).isShowVideoMsg(baseVideoAppInterface.getApplicationContext(), baseVideoAppInterface.getAccount(), str, i16);
                if (z16) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                this.f73090v2 = i3;
            } else {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.i(this.f73020f, 2, "isVideoMsgBlocked ret[" + z16 + "], uin[" + str + "], type[" + i16 + "], flag[" + this.f73090v2 + "]");
            }
        }
        if (this.f73090v2 == 1) {
            return true;
        }
        return false;
    }

    public boolean R() {
        int size = this.f73045k1.size();
        if (QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "isVideoNumReachMaxNow, size[" + size + "]");
        }
        if (size >= 16) {
            return true;
        }
        return false;
    }

    public void S() {
        WeakReference<al> weakReference = this.f73094w2;
        if (weakReference != null && weakReference.get() != null) {
            this.f73094w2.get().a();
        }
    }

    public void T(AVPhoneUserInfo aVPhoneUserInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f73020f, 2, "onPhoneUserInfoInRoom info = " + aVPhoneUserInfo.toString());
        }
        this.f73061o1.add(aVPhoneUserInfo);
    }

    public void U(al alVar) {
        WeakReference<al> weakReference = this.f73094w2;
        if (weakReference != null && weakReference.get() != null && this.f73094w2.get() == alVar) {
            return;
        }
        this.f73094w2 = new WeakReference<>(alVar);
    }

    public void V(long j16, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f73020f, 2, "resetVideoDisplayListExceptTargetUin-->Uin = " + j16 + " ,clearRenderFlag" + z16 + " ,clearRecvDataFlag" + z17);
        }
        for (int i3 = 0; i3 < this.f73045k1.size(); i3++) {
            if (this.f73045k1.get(i3).f73827a != j16) {
                if (z16) {
                    this.f73045k1.get(i3).f73830d = false;
                }
                if (z17) {
                    this.f73045k1.get(i3).f73832f = false;
                }
            }
        }
    }

    public void W(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f73020f, 2, "SessionInfo setAvType:" + i3, new Throwable());
        }
        this.f73063p = i3;
        j3 = i3;
    }

    public void X(long j16, long j17) {
        QLog.w(this.f73020f, 1, "setConnectedTime, connectedTime[" + this.f73100y0 + "->" + j17 + "], seq[" + j16 + "]");
        this.f73100y0 = j17;
    }

    public void Y(String str, String str2) {
        if (com.tencent.av.utils.e.k() || !TextUtils.equals(str2, this.F0)) {
            QLog.w(this.f73020f, 1, "setDeviceName, from[" + str + "], deviceName[" + this.F0 + "->" + str2 + "]");
        }
        this.F0 = str2;
    }

    public void Z(String str, int i3) {
        boolean z16 = true;
        if ((i3 == 0 || i3 == 1) && this.R0 == 2) {
            switch (this.f73043k) {
                case 8:
                case 9:
                case 10:
                    z16 = false;
                    break;
            }
        }
        if (QLog.isDevelopLevel() || this.R0 != i3) {
            QLog.i(this.f73020f, 2, "setGAudioStatusType, from[" + str + "], isNeedUpdate[" + z16 + "], state[" + this.f73043k + "], cur[" + this.R0 + "], come[" + i3 + "]");
        }
        if (z16) {
            this.R0 = i3;
        }
    }

    public void a0(boolean z16) {
        QLog.w(this.f73020f, 1, "setHasChangeDoubleScreen, hasChangeDoubleScreen[" + this.O0 + "->" + z16 + "]");
        this.O0 = z16;
    }

    public void b0(boolean z16) {
        this.f73086u2 = z16;
    }

    public void c0(long j16, boolean z16) {
        if (QLog.isDevelopLevel() || this.N != z16) {
            QLog.w(this.f73020f, 1, "setLocalHasVideo, localHasVideo[" + this.N + "->" + z16 + "], seq[" + j16 + "]");
            if (!z16) {
                QLog.w(this.f73020f, 1, "why call not local hasVideo, str[1], isVisible[]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            }
        }
        this.N = z16;
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.app.SessionInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).tryLoadPtuSo();
                }
            }, 16, null, true);
        }
        ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).checkVoiceRecog(this.N, this.O);
    }

    public void d0(String str, boolean z16) {
        if (QLog.isDevelopLevel() || this.K != z16) {
            QLog.w(this.f73020f, 1, "setLocalMuteStatus, from[" + str + "], mute[" + z16 + "]");
        }
        this.K = z16;
    }

    public void e(com.tencent.av.gaudio.c cVar, boolean z16) {
        long j16 = cVar.f73827a;
        int i3 = cVar.f73828b;
        if (QLog.isColorLevel()) {
            QLog.d(this.f73020f, 2, "addVideoViewInfo-->Uin = " + j16 + " ,VideoSrcType = " + i3 + " ,insertHead = " + z16);
        }
        int q16 = q(j16, i3);
        if (q16 != -1 && QLog.isColorLevel()) {
            QLog.e(this.f73020f, 2, "addVideoViewInfo Error,The View Info Is Exsit.Uin = " + j16 + " ,VideoSrcType = " + i3 + " ,Index = " + q16);
        }
        if (z16) {
            this.f73045k1.add(0, cVar);
        } else {
            this.f73045k1.add(cVar);
        }
        synchronized (this.f73053m1) {
            if (!g(cVar)) {
                if (z16) {
                    this.f73053m1.add(0, cVar);
                } else {
                    this.f73053m1.add(cVar);
                }
                S();
                if (QLog.isColorLevel()) {
                    QLog.d(this.f73020f, 2, "addVideoViewInfo mMultiVideoTalkList-->Uin = " + j16 + " ,VideoSrcType = " + i3 + " ,insertHead = " + z16);
                }
            }
        }
    }

    public void e0(String str, int i3) {
        if (com.tencent.av.utils.e.k() || i3 != this.X0) {
            QLog.w(this.f73020f, 1, "setMicAuthByAdmin[" + str + "], micAuthByAdmin[" + this.X0 + "->" + i3 + "]");
        }
        this.X0 = i3;
    }

    public boolean f() {
        boolean z16;
        int i3 = this.S0;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
            if (i3 == 3 || i3 == 0) {
                if (this.f73060o0) {
                    z16 = this.f73064p0;
                } else if (this.f73043k == 4) {
                    z16 = true;
                }
            }
        } else {
            z16 = this.U0;
        }
        QLog.i(AVConstants.SHARE_TAG, 1, "canStartScreenShare, relationType[" + this.S0 + "], isDoubleVideoMeeting[" + this.f73060o0 + "], ret[" + z16 + "]");
        return z16;
    }

    public void f0(boolean z16) {
        this.P1 = z16;
    }

    public void g0(boolean z16, boolean z17) {
        String str;
        String str2 = this.f73020f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setNeedCloseViewForZplanAvatar ");
        if (z16) {
            str = "local";
        } else {
            str = " remote";
        }
        sb5.append(str);
        sb5.append(" isNeed=");
        sb5.append(z17);
        QLog.d(str2, 1, sb5.toString(), new Throwable("\u6253\u5370\u5806\u6808"));
        if (z16) {
            this.f73106z2 = z17;
        } else {
            this.A2 = z17;
        }
    }

    public void h(long j16) {
        if (QLog.isColorLevel()) {
            QLog.w(this.f73020f, 1, "clearDoubleVideoSessionInfo, sessionId[" + this.f73030h + "], seq[" + j16 + "]");
        }
        j(j16);
    }

    public void h0(int i3) {
        QLog.i(this.f73020f, 1, "setPeerSdkVersion [" + i3 + "]");
        this.f73070q2 = i3;
    }

    public void i(long j16) {
        j(j16);
        l0("clearMultiVideoSessionInfo", false);
        this.Z0 = 0L;
        this.f73009c1 = -1;
        this.f73013d1 = false;
        this.f73017e1 = false;
        this.f73022f1 = false;
        this.f73027g1 = false;
        this.f73032h1 = false;
        this.f73037i1 = false;
        this.f73045k1.clear();
        synchronized (this.f73053m1) {
            this.f73053m1.clear();
            S();
        }
        this.f73094w2 = null;
        this.f73057n1.clear();
        W(0);
    }

    public void i0(int i3) {
        QLog.i(this.f73020f, 1, "setPeerTerminalType [" + i3 + "]");
        this.f73074r2 = i3;
    }

    public void j0(String str) {
        this.B = str;
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f73020f, 4, "setPhoneNum, phoneNum[" + str + "]");
        }
    }

    public AVPhoneUserInfo k(long j16) {
        Iterator<AVPhoneUserInfo> it = this.f73061o1.iterator();
        while (it.hasNext()) {
            AVPhoneUserInfo next = it.next();
            if (next.accountType != 1 && next.account == j16) {
                return next;
            }
        }
        return null;
    }

    public void k0(long j16, boolean z16) {
        if (QLog.isDevelopLevel() || this.O != z16) {
            QLog.w(this.f73020f, 1, "setRemoteHasVideo, remoteHasVideo[" + this.O + "->" + z16 + "], seq[" + j16 + "]", new Throwable("\u6253\u5370\u5806\u6808"));
        }
        this.O = z16;
        ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).checkVoiceRecog(this.N, this.O);
    }

    public int l() {
        int i3;
        if (this.f73060o0 || (i3 = this.S0) == 100) {
            return 1;
        }
        int i16 = this.f73035i;
        if (i16 == 1 || i16 == 2 || i3 == 3) {
            return 2;
        }
        if (i16 == 3 || i16 == 4 || i3 == 1 || i3 == 2) {
            return 1;
        }
        return 0;
    }

    public void l0(String str, boolean z16) {
        if (com.tencent.av.utils.e.k() || z16 != this.W0) {
            QLog.w(this.f73020f, 1, "setRoomMicOff[" + str + "], isRoomMicOff[" + this.W0 + "->" + z16 + "]");
        }
        this.W0 = z16;
    }

    public long m() {
        long j16;
        int i3;
        if (!this.f73060o0 && (i3 = this.S0) != 100) {
            int i16 = this.f73035i;
            if (i16 != 1 && i16 != 2 && i3 != 3) {
                if (i16 != 3 && i16 != 4 && i3 != 1 && i3 != 2) {
                    return 0L;
                }
                j16 = this.P0;
                if (j16 == 0) {
                    try {
                        return Long.parseLong(this.f73103z);
                    } catch (Throwable th5) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(this.f73020f, 4, "getChatRoomUin", th5);
                        }
                    }
                }
            } else {
                try {
                    return Long.parseLong(this.f73091w);
                } catch (Throwable th6) {
                    if (!QLog.isDevelopLevel()) {
                        return 0L;
                    }
                    QLog.i(this.f73020f, 4, "getChatRoomUin", th6);
                    return 0L;
                }
            }
        } else {
            j16 = this.P0;
            if (j16 == 0) {
                try {
                    return Long.parseLong(this.f73091w);
                } catch (Throwable th7) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i(this.f73020f, 4, "getChatRoomUin", th7);
                    }
                }
            }
        }
        return j16;
    }

    public void m0(String str, String str2) {
        if (!TextUtils.equals(this.f73030h, str2) || QLog.isColorLevel()) {
            QLog.i(this.f73020f, 1, "setSessionId[" + str + "], SessionId[" + this.f73030h + "->" + str2 + "]" + QLog.getStackTraceString(new Throwable()));
        }
        this.f73030h = str2;
    }

    public int n(long j16) {
        for (int i3 = 0; i3 < this.f73045k1.size(); i3++) {
            if (this.f73045k1.get(i3).f73831e && this.f73045k1.get(i3).f73827a != j16) {
                return i3;
            }
        }
        return -1;
    }

    public void n0(String str, int i3) {
        if (this.f73043k != i3 || QLog.isColorLevel()) {
            QLog.w(this.f73020f, 1, "setState[" + str + "], SessionState[" + this.f73043k + "->" + i3 + "]");
        }
        if (this.f73043k != i3) {
            ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).checkMemPerf(this.f73043k, i3);
            this.f73043k = i3;
        }
    }

    public int o() {
        for (int i3 = 0; i3 < this.f73045k1.size(); i3++) {
            if (this.f73045k1.get(i3).f73830d) {
                return i3;
            }
        }
        return -1;
    }

    public void o0(int i3) {
        if (this.f73025g != i3 || QLog.isColorLevel()) {
            QLog.i(this.f73020f, 1, "SessionStatus[" + this.f73025g + "->" + i3 + "]");
        }
        this.f73025g = i3;
    }

    public int p(long j16, int i3) {
        synchronized (this.f73053m1) {
            int i16 = 0;
            if (i3 != 0) {
                while (i16 < this.f73053m1.size()) {
                    if (this.f73053m1.get(i16).f73827a == j16 && this.f73053m1.get(i16).f73828b == i3) {
                        return i16;
                    }
                    i16++;
                }
            } else {
                while (i16 < this.f73053m1.size()) {
                    if (this.f73053m1.get(i16).f73827a == j16) {
                        return i16;
                    }
                    i16++;
                }
            }
            return -1;
        }
    }

    public void p0(long j16, String str, int i3) {
        if (this.f73035i != i3 || QLog.isColorLevel()) {
            QLog.w(this.f73020f, 1, "setSessionType[" + str + "], SessionType[" + this.f73035i + "->" + i3 + "], seq[" + j16 + "]");
        }
        this.f73035i = i3;
    }

    public int q(long j16, int i3) {
        int i16 = 0;
        if (i3 != 0) {
            while (i16 < this.f73045k1.size()) {
                if (this.f73045k1.get(i16).f73827a == j16 && this.f73045k1.get(i16).f73828b == i3) {
                    return i16;
                }
                i16++;
            }
            return -1;
        }
        while (i16 < this.f73045k1.size()) {
            if (this.f73045k1.get(i16).f73827a == j16) {
                return i16;
            }
            i16++;
        }
        return -1;
    }

    public void q0(String str, int i3) {
        if (QLog.isDevelopLevel() || this.J != i3) {
            QLog.w(this.f73020f, 1, "setSpeakerMode, from[" + str + "], mode[" + i3 + "]");
        }
        this.J = i3;
    }

    public String r(String str) {
        return this.f73095x;
    }

    public void r0(String str, boolean z16) {
        if (com.tencent.av.utils.e.j() || z16 != this.I0) {
            QLog.w(this.f73020f, 1, "setSpeakerOn, from[" + str + "], isSpeakerOn[" + this.I0 + "->" + z16 + "]");
        }
        this.I0 = z16;
    }

    public boolean s() {
        for (int i3 = 0; i3 < this.f73045k1.size(); i3++) {
            if (this.f73045k1.get(i3).f73829c) {
                return true;
            }
        }
        return false;
    }

    public void s0(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("normal_2_meeting", 2, "setSwitch2DoubleMeeting, from[" + str + "], [" + this.V0 + "-->" + z16 + "]");
        }
        this.V0 = z16;
    }

    public boolean t() {
        for (int i3 = 0; i3 < this.f73045k1.size(); i3++) {
            if (this.f73045k1.get(i3).f73832f) {
                return false;
            }
        }
        return true;
    }

    public void t0(String str, int i3) {
        if (this.f73047l != i3 || QLog.isColorLevel()) {
            QLog.w(this.f73020f, 1, "setSwitchState[" + str + "], state[" + this.f73047l + "->" + i3 + "]");
        }
        this.f73047l = i3;
    }

    public String toString() {
        return "[" + this.f73020f + "], a[" + this.f73030h + "], b[" + this.f73035i + "], c[" + this.f73025g + "], d[" + this.S0 + "], e[" + this.f73067q + "], f[" + this.P0 + "], g[" + this.f73043k + "], h[" + this.f73047l + "], i[" + this.f73091w + "], j[" + this.f73095x + "], l[" + this.f73103z + "], m[" + this.A + "], n[" + this.f73063p + "], u[" + this.N + "], v[" + this.f73208d + "], w[" + this.G + "], x[" + this.H2 + "], y[" + this.f73098x2 + "], z[" + this.f73102y2 + "], o[" + this.H2 + "]";
    }

    public boolean u() {
        int i3 = this.f73043k;
        if (i3 != 2 && i3 != 7) {
            return false;
        }
        return true;
    }

    public void u0(String str, int i3) {
        QLog.w(this.f73020f, 1, "setSwitchToGAudioMode[" + str + "], switchToGAudioMode[" + this.T0 + "->" + i3 + "]");
        this.T0 = i3;
    }

    public boolean v() {
        if (!TextUtils.isEmpty(this.f73030h) && this.f73030h.equals(this.U2)) {
            return true;
        }
        return false;
    }

    public void v0(String str, String str2) {
        this.f73095x = str2;
        QLog.d(this.f73020f, 1, "setTraceId from:=" + str + ", traceId:=" + str2);
    }

    public boolean w() {
        if (this.f73043k == 5) {
            return true;
        }
        return false;
    }

    public void w0(long j16, String str, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.w(this.f73020f, 1, "setVideoState[" + str + "], startOrStopVideo[" + z16 + "], isRemote[" + z17 + "], seq[" + j16 + "]");
        }
        if (z16) {
            if (z17) {
                k0(j16, true);
            } else {
                c0(j16, true);
            }
            int i3 = this.f73035i;
            if (i3 == 1) {
                p0(j16, "setVideoState.1", 2);
                return;
            } else {
                if (i3 == 3) {
                    p0(j16, "setVideoState.2", 4);
                    return;
                }
                return;
            }
        }
        if (z17) {
            k0(j16, false);
        } else {
            c0(j16, false);
        }
        int i16 = this.f73035i;
        if (i16 == 2 && !this.O && !this.N && !this.P) {
            p0(j16, "setVideoState.3", 1);
        } else if (i16 == 4 && !this.O && !this.N && !this.P) {
            p0(j16, "setVideoState.4", 3);
        }
    }

    public boolean x() {
        if (this.f73043k == 6) {
            return true;
        }
        return false;
    }

    public void x0(boolean z16, boolean z17) {
        String str;
        String str2 = this.f73020f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setZplanAvatarUsingStatus ");
        if (z16) {
            str = "local";
        } else {
            str = " remote";
        }
        sb5.append(str);
        sb5.append(" isUsing=");
        sb5.append(z17);
        QLog.d(str2, 1, sb5.toString(), new Throwable("\u6253\u5370\u5806\u6808"));
        if (z16) {
            this.f73098x2 = z17;
        } else {
            this.f73102y2 = z17;
        }
    }

    public boolean y() {
        if (this.f73043k == 15) {
            return true;
        }
        return false;
    }

    public void y0(String str, boolean z16) {
        if (this.f73060o0 != z16 || QLog.isColorLevel()) {
            QLog.i(this.f73020f, 1, "updateDoubleMeeting, from[" + str + "], [" + this.f73060o0 + "-->" + z16 + "]");
        }
        if (this.f73060o0 != z16) {
            this.f73060o0 = z16;
        }
    }

    public boolean z() {
        if (this.f73043k == 4) {
            return true;
        }
        return false;
    }

    public void z0(String str, boolean z16) {
        if (this.f73064p0 != z16 || QLog.isColorLevel()) {
            QLog.i(this.f73020f, 1, "updateInMeetingRoom, from[" + str + "], [" + this.f73064p0 + "-->" + z16 + "]");
        }
        if (this.f73064p0 != z16) {
            this.f73064p0 = z16;
        }
    }
}
