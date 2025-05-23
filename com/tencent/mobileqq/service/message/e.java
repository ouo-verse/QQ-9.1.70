package com.tencent.mobileqq.service.message;

import MessageSvcPack.stConfNumInfo;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;
    private static final AppShareID P0;
    public static int Q0;
    private static String R0;
    public static b S0;
    public static int T0;
    public static HashMap<String, c> U0;
    public static boolean V0;
    private ConcurrentHashMap<String, byte[]> A;
    private ConcurrentHashMap<String, Integer> A0;
    private ConcurrentHashMap<String, byte[]> B;
    private ConcurrentHashMap<String, ArrayList<Object[]>> B0;
    private ConcurrentHashMap<String, byte[]> C;
    private ConcurrentHashMap<Long, ArrayList<msg_comm$Msg>> C0;
    private ConcurrentHashMap<String, byte[]> D;
    private ConcurrentHashMap<Long, ArrayList<msg_comm$Msg>> D0;
    private ConcurrentHashMap<String, byte[]> E;
    private ConcurrentHashMap<String, Integer> E0;
    private ConcurrentHashMap<String, byte[]> F;
    private ConcurrentHashMap<String, ArrayList<Object[]>> F0;
    private ConcurrentHashMap<String, byte[]> G;
    private ConcurrentHashMap<String, DisMsgReadedNotify> G0;
    private ConcurrentHashMap<String, byte[]> H;
    private ConcurrentHashMap<String, GroupMsgReadedNotify> H0;
    private ConcurrentHashMap<String, byte[]> I;
    private long I0;
    private ConcurrentHashMap<String, byte[]> J;
    private ConcurrentHashMap<String, AppShareID> J0;
    private ConcurrentHashMap<String, byte[]> K;
    private final HashSet<String> K0;
    private ConcurrentHashMap<String, byte[]> L;
    private ConcurrentHashMap<String, OpenID> L0;
    private ConcurrentHashMap<String, byte[]> M;
    private HashMap<Long, ArrayList<String>> M0;
    private ConcurrentHashMap<String, byte[]> N;
    private ConcurrentHashMap<String, Object> N0;
    private ConcurrentHashMap<String, byte[]> O;
    private boolean O0;
    private ConcurrentHashMap<String, Long> P;
    private ConcurrentHashMap<String, Long> Q;
    private ConcurrentHashMap<String, Long> R;
    private ConcurrentHashMap<Pair<String, Integer>, Long> S;
    private ConcurrentHashMap<Pair<String, Integer>, Long> T;
    private ConcurrentHashMap<String, ConcurrentHashMap<String, Set<Integer>>> U;
    private ConcurrentHashMap<String, ConcurrentHashMap<Integer, HashSet<Long>>> V;
    private ConcurrentHashMap<String, MessageRecord> W;
    private Set<String> X;
    private ConcurrentHashMap<String, Long> Y;
    public ConcurrentHashMap<String, String> Z;

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f286193a;

    /* renamed from: a0, reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f286194a0;

    /* renamed from: b, reason: collision with root package name */
    private int f286195b;

    /* renamed from: b0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286196b0;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f286197c;

    /* renamed from: c0, reason: collision with root package name */
    public HashMap<Long, MessageRecord> f286198c0;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, Object[]> f286199d;

    /* renamed from: d0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286200d0;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, Object[]> f286201e;

    /* renamed from: e0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286202e0;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, Boolean> f286203f;

    /* renamed from: f0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286204f0;

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, Boolean> f286205g;

    /* renamed from: g0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286206g0;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f286207h;

    /* renamed from: h0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286208h0;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f286209i;

    /* renamed from: i0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286210i0;

    /* renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<String, Boolean> f286211j;

    /* renamed from: j0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286212j0;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<stConfNumInfo> f286213k;

    /* renamed from: k0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286214k0;

    /* renamed from: l, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f286215l;

    /* renamed from: l0, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286216l0;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, Pair<Long, Long>> f286217m;

    /* renamed from: m0, reason: collision with root package name */
    private final ConcurrentHashMap<Long, Pair<Long, Long>> f286218m0;

    /* renamed from: n, reason: collision with root package name */
    private ConcurrentHashMap<String, Pair<Long, Long>> f286219n;

    /* renamed from: n0, reason: collision with root package name */
    private byte[] f286220n0;

    /* renamed from: o, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f286221o;

    /* renamed from: o0, reason: collision with root package name */
    private byte[] f286222o0;

    /* renamed from: p, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f286223p;

    /* renamed from: p0, reason: collision with root package name */
    private long f286224p0;

    /* renamed from: q, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f286225q;

    /* renamed from: q0, reason: collision with root package name */
    private int f286226q0;

    /* renamed from: r, reason: collision with root package name */
    public AtomicInteger f286227r;

    /* renamed from: r0, reason: collision with root package name */
    private SharedPreferences f286228r0;

    /* renamed from: s, reason: collision with root package name */
    private ArrayList<String> f286229s;

    /* renamed from: s0, reason: collision with root package name */
    private a f286230s0;

    /* renamed from: t, reason: collision with root package name */
    private ConcurrentHashMap<String, ConcurrentHashMap<Long, d>> f286231t;

    /* renamed from: t0, reason: collision with root package name */
    private int f286232t0;

    /* renamed from: u, reason: collision with root package name */
    private ConcurrentHashMap<String, ConcurrentHashMap<Long, d>> f286233u;

    /* renamed from: u0, reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f286234u0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f286235v;

    /* renamed from: v0, reason: collision with root package name */
    public ConcurrentHashMap<String, Set<String>> f286236v0;

    /* renamed from: w, reason: collision with root package name */
    private MessageRecord f286237w;

    /* renamed from: w0, reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f286238w0;

    /* renamed from: x, reason: collision with root package name */
    private ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> f286239x;

    /* renamed from: x0, reason: collision with root package name */
    public List<MessageRecord> f286240x0;

    /* renamed from: y, reason: collision with root package name */
    private ConcurrentHashMap<String, List<Integer>> f286241y;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f286242y0;

    /* renamed from: z, reason: collision with root package name */
    private ConcurrentHashMap<String, byte[]> f286243z;

    /* renamed from: z0, reason: collision with root package name */
    ArrayList<MessageRecord> f286244z0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements SharedPreferences.Editor {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private SharedPreferences.Editor f286245d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f286246e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            } else {
                this.f286246e = false;
            }
        }

        private void a() {
            this.f286245d = e.this.f286228r0.edit();
            if (e.this.N0 != null && e.this.N0.size() > 0) {
                for (String str : e.this.N0.keySet()) {
                    Object obj = e.this.N0.get(str);
                    if (obj instanceof Long) {
                        this.f286245d.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        this.f286245d.putString(str, (String) obj);
                    } else if (obj instanceof Boolean) {
                        this.f286245d.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Integer) {
                        this.f286245d.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Float) {
                        this.f286245d.putFloat(str, ((Float) obj).floatValue());
                    }
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        @TargetApi(9)
        public void apply() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            } else if (this.f286246e) {
                this.f286246e = false;
                this.f286245d.apply();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            this.f286246e = true;
            e.this.N0.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            if (this.f286246e) {
                this.f286246e = false;
                try {
                    a();
                    boolean commit = this.f286245d.commit();
                    if (commit) {
                        e.this.N0.clear();
                    } else if (QLog.isColorLevel()) {
                        QLog.d(e.R0, 2, "AsyncEditor commit fail!");
                    }
                    return commit;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w(e.R0, 2, "commit Exception ! ", e16);
                    }
                    this.f286246e = true;
                    return false;
                } catch (OutOfMemoryError e17) {
                    if (QLog.isColorLevel()) {
                        QLog.w(e.R0, 2, "commit OutOfMemoryError ! ", e17);
                    }
                    this.f286246e = true;
                }
            }
            return false;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
            }
            this.f286246e = true;
            e.this.N0.put(str, Boolean.valueOf(z16));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 6, this, str, Float.valueOf(f16));
            }
            this.f286246e = true;
            e.this.N0.put(str, Float.valueOf(f16));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            }
            this.f286246e = true;
            e.this.N0.put(str, Integer.valueOf(i3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3));
            }
            this.f286246e = true;
            e.this.N0.put(str, Long.valueOf(j3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            }
            this.f286246e = true;
            e.this.N0.put(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @Deprecated
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) set);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.f286246e = true;
            e.this.N0.remove(str);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        String a(byte[] bArr);

        List<MessageRecord> b(String str, int i3, e eVar);

        String c(byte[] bArr);

        byte[] d(String str);

        byte[] e(String str);

        StringBuilder f();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f286248a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f286249b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f286250c;

        /* renamed from: d, reason: collision with root package name */
        public long f286251d;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f286249b = true;
            this.f286250c = true;
            this.f286251d = 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f286252a;

        /* renamed from: b, reason: collision with root package name */
        public int f286253b;

        /* renamed from: c, reason: collision with root package name */
        public long f286254c;

        /* renamed from: d, reason: collision with root package name */
        public long f286255d;

        /* renamed from: e, reason: collision with root package name */
        public int f286256e;

        public d(String str, int i3, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.f286252a = str;
            this.f286253b = i3;
            this.f286254c = j3;
            this.f286255d = j16;
            this.f286256e = e.Q0;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "MsgSendingInfo{frienduin='" + this.f286252a + "', istroop=" + this.f286253b + ", uniseq=" + this.f286254c + ", localSendTime=" + this.f286255d + ", delayTime=" + this.f286256e + '}';
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45097);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 198)) {
            redirector.redirect((short) 198);
            return;
        }
        P0 = new AppShareID();
        Q0 = 200;
        R0 = "Q.msg.MessageCache";
        S0 = new g();
        com.tencent.imcore.message.s.a();
        T0 = 3;
        U0 = new HashMap<>();
    }

    public e(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.f286195b = 0;
        this.f286197c = new ConcurrentHashMap<>();
        this.f286199d = new ConcurrentHashMap<>();
        this.f286201e = new ConcurrentHashMap<>();
        this.f286203f = new ConcurrentHashMap<>();
        this.f286205g = new ConcurrentHashMap<>();
        this.f286207h = new ConcurrentHashMap<>();
        this.f286209i = new ConcurrentHashMap<>();
        this.f286211j = new ConcurrentHashMap<>();
        this.f286213k = new ArrayList<>();
        this.f286215l = new ConcurrentHashMap<>();
        this.f286217m = new ConcurrentHashMap<>();
        this.f286219n = new ConcurrentHashMap<>();
        this.f286221o = new ConcurrentHashMap<>();
        this.f286223p = new ConcurrentHashMap<>();
        this.f286225q = new ConcurrentHashMap<>();
        this.f286227r = new AtomicInteger(0);
        this.f286229s = new ArrayList<>();
        this.f286231t = new ConcurrentHashMap<>();
        this.f286233u = new ConcurrentHashMap<>();
        this.f286235v = false;
        this.f286237w = null;
        this.f286239x = new ConcurrentHashMap<>();
        this.f286241y = new ConcurrentHashMap<>();
        this.f286243z = new ConcurrentHashMap<>();
        this.A = new ConcurrentHashMap<>();
        this.B = new ConcurrentHashMap<>();
        this.C = new ConcurrentHashMap<>();
        this.D = new ConcurrentHashMap<>();
        this.E = new ConcurrentHashMap<>();
        this.F = new ConcurrentHashMap<>();
        this.G = new ConcurrentHashMap<>();
        this.H = new ConcurrentHashMap<>();
        this.I = new ConcurrentHashMap<>();
        this.J = new ConcurrentHashMap<>();
        this.K = new ConcurrentHashMap<>();
        this.L = new ConcurrentHashMap<>();
        this.M = new ConcurrentHashMap<>();
        this.N = new ConcurrentHashMap<>();
        this.O = new ConcurrentHashMap<>();
        this.P = new ConcurrentHashMap<>();
        this.Q = new ConcurrentHashMap<>();
        this.R = new ConcurrentHashMap<>();
        this.S = new ConcurrentHashMap<>();
        this.T = new ConcurrentHashMap<>();
        this.U = new ConcurrentHashMap<>();
        this.V = new ConcurrentHashMap<>();
        this.W = new ConcurrentHashMap<>();
        this.X = Collections.synchronizedSet(new HashSet());
        this.Y = new ConcurrentHashMap<>();
        this.Z = new ConcurrentHashMap<>();
        this.f286194a0 = new ConcurrentHashMap<>();
        this.f286196b0 = new ConcurrentHashMap<>();
        this.f286198c0 = new HashMap<>();
        this.f286200d0 = new ConcurrentHashMap<>();
        this.f286202e0 = new ConcurrentHashMap<>();
        this.f286204f0 = new ConcurrentHashMap<>();
        this.f286206g0 = new ConcurrentHashMap<>();
        this.f286208h0 = new ConcurrentHashMap<>();
        this.f286210i0 = new ConcurrentHashMap<>();
        this.f286212j0 = new ConcurrentHashMap<>();
        this.f286214k0 = new ConcurrentHashMap<>();
        this.f286216l0 = new ConcurrentHashMap<>();
        this.f286218m0 = new ConcurrentHashMap<>();
        this.f286224p0 = -1L;
        this.f286226q0 = -1;
        this.f286232t0 = -1;
        this.f286234u0 = new ConcurrentHashMap<>();
        this.f286236v0 = new ConcurrentHashMap<>();
        this.f286238w0 = new ConcurrentHashMap<>();
        this.f286240x0 = new ArrayList();
        this.f286242y0 = false;
        this.f286244z0 = new ArrayList<>();
        this.A0 = new ConcurrentHashMap<>();
        this.B0 = new ConcurrentHashMap<>();
        this.C0 = new ConcurrentHashMap<>();
        this.D0 = new ConcurrentHashMap<>();
        this.E0 = new ConcurrentHashMap<>();
        this.F0 = new ConcurrentHashMap<>();
        this.G0 = new ConcurrentHashMap<>();
        this.H0 = new ConcurrentHashMap<>();
        this.I0 = 0L;
        this.J0 = new ConcurrentHashMap<>();
        this.K0 = new HashSet<>();
        this.L0 = new ConcurrentHashMap<>();
        this.M0 = new HashMap<>();
        this.N0 = new ConcurrentHashMap<>();
        this.O0 = false;
        this.f286193a = appRuntime;
        this.f286228r0 = appRuntime.getApp().getSharedPreferences(appRuntime.getCurrentAccountUin(), 0);
        this.f286230s0 = new a();
        V0 = false;
    }

    public static long K0() {
        return NetConnInfoCenter.getServerTime();
    }

    private List<MessageRecord> N0(String str, int i3) {
        return S0.b(str, i3, this);
    }

    public static void N1(b bVar) {
        S0 = bVar;
    }

    private void O1(String str, long j3) {
        String md5 = MD5.toMD5(str);
        if (this.f286193a.getCurrentAccountUin() != null) {
            this.f286230s0.putLong(AppConstants.Preferences.DEL_FRIEND_MSG_TIME + md5, j3);
        }
    }

    private String U(byte[] bArr) {
        return S0.c(bArr);
    }

    private String W1(byte[] bArr) {
        return S0.a(bArr);
    }

    private StringBuilder Z0() {
        return S0.f();
    }

    private byte[] h1(String str) {
        return S0.d(str);
    }

    private byte[] i1(String str) {
        return S0.e(str);
    }

    public static boolean r1(d dVar) {
        if (dVar != null && dVar.f286255d > 0) {
            long currentTimeMillis = System.currentTimeMillis() - dVar.f286255d;
            if (currentTimeMillis < Q0 && currentTimeMillis > 0) {
                return false;
            }
        }
        return true;
    }

    public void A(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (i3 == 1) {
            j3 = Math.max(j3, B0(str));
        } else if (i3 == 3000) {
            j3 = Math.max(j3, s0(str));
        } else {
            List<MessageRecord> N0 = N0(str, i3);
            if (N0 != null && !N0.isEmpty()) {
                j3 = Math.max(j3, N0.get(N0.size() - 1).time);
            }
            j(str, 0L, 0L);
            if (i3 == 0) {
                O1(str, NetConnInfoCenter.getServerTimeMillis());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "addMsgDelLastSeq uin = " + str + ",type = " + i3 + " , lastSeqId = " + j3);
        }
        this.P.put(ao.f(str, i3), Long.valueOf(Math.max(j3, M0(str, i3))));
        if (this.f286193a.getCurrentAccountUin() != null) {
            this.f286230s0.putLong(AppConstants.Preferences.GET_DEL_MSG_LAST_SEQ + ao.f(str, i3), j3).commit();
        }
    }

    public long A0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Long) iPatchRedirector.redirect((short) 73, (Object) this, (Object) str)).longValue();
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return 0L;
        }
        if (!this.f286207h.containsKey(str)) {
            this.f286207h.put(str, Long.valueOf(this.f286228r0.getLong(AppConstants.Preferences.GET_TROOP_EXPIRED_SEQ + str, 0L)));
        }
        return this.f286207h.get(str).longValue();
    }

    public void A1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            iPatchRedirector.redirect((short) 143, (Object) this, (Object) str);
        } else if (this.f286205g.containsKey(str)) {
            this.f286205g.remove(str);
        }
    }

    public void B(MessageRecord messageRecord) {
        ConcurrentHashMap<String, Set<Integer>> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            iPatchRedirector.redirect((short) 133, (Object) this, (Object) messageRecord);
            return;
        }
        synchronized (this.U) {
            if (!messageRecord.isLongMsg()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "addOnlineLongMsgFragment longid=" + messageRecord.getLongMsgInfoString());
            }
            String f16 = ao.f(messageRecord.frienduin, messageRecord.istroop);
            String g16 = ao.g(messageRecord);
            if (this.U.containsKey(f16) && this.U.get(f16) != null) {
                concurrentHashMap = this.U.get(f16);
            } else {
                ConcurrentHashMap<String, Set<Integer>> concurrentHashMap2 = new ConcurrentHashMap<>();
                this.U.put(f16, concurrentHashMap2);
                concurrentHashMap = concurrentHashMap2;
            }
            if (concurrentHashMap.containsKey(g16)) {
                Set<Integer> set = concurrentHashMap.get(g16);
                set.add(Integer.valueOf(messageRecord.longMsgIndex));
                if (messageRecord.longMsgCount <= set.size()) {
                    concurrentHashMap.remove(g16);
                }
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(Integer.valueOf(messageRecord.longMsgIndex));
                concurrentHashMap.put(g16, hashSet);
            }
        }
    }

    public long B0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Long) iPatchRedirector.redirect((short) 72, (Object) this, (Object) str)).longValue();
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return 0L;
        }
        if (!this.f286197c.containsKey(str)) {
            this.f286197c.put(str, Long.valueOf(this.f286228r0.getLong(AppConstants.Preferences.GET_TROOP_LAST_MESSAGE_TIME + str, 0L)));
        }
        Long l3 = this.f286197c.get(str);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public void B1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, (Object) this, (Object) str);
        } else {
            this.F0.remove(str);
        }
    }

    public void C(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            iPatchRedirector.redirect((short) 132, (Object) this, (Object) list);
        } else if (list != null && !list.isEmpty()) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                B(it.next());
            }
        }
    }

    public Object[] C0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (Object[]) iPatchRedirector.redirect((short) 87, (Object) this, (Object) str);
        }
        if (this.f286199d.containsKey(str)) {
            return this.f286199d.get(str);
        }
        if (this.f286193a.getCurrentAccountUin() != null) {
            long j3 = this.f286228r0.getLong(AppConstants.Preferences.GET_TROOP_MEMBER_SEQ + str, -1L);
            if (j3 != 0) {
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j3);
                return objArr;
            }
            return null;
        }
        return null;
    }

    public void C1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            iPatchRedirector.redirect((short) 139, (Object) this, (Object) str);
        } else if (this.f286203f.containsKey(str)) {
            this.f286203f.remove(str);
        }
    }

    public void D(String str, OpenID openID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 156)) {
            iPatchRedirector.redirect((short) 156, (Object) this, (Object) str, (Object) openID);
            return;
        }
        this.L0.put(str, openID);
        if (QLog.isColorLevel()) {
            QLog.d("openid", 2, "add openid to cache = " + openID);
        }
    }

    public long D0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            return ((Long) iPatchRedirector.redirect((short) 117, (Object) this, (Object) str)).longValue();
        }
        long M0 = M0(str, 1);
        long B0 = B0(str);
        return Math.max(Math.max(B0, M0), A0(str));
    }

    public void D1(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            iPatchRedirector.redirect((short) 137, this, str, Integer.valueOf(i3), str2);
            return;
        }
        synchronized (this.U) {
            Map<String, Set<Integer>> Q02 = Q0(str, i3);
            if (Q02 == null) {
                return;
            }
            if (Q02.containsKey(str2)) {
                Q02.remove(str2);
            }
        }
    }

    public void E(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "addPCQQSearchMsgKey uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:" + U(bArr));
        }
        byte[] bArr2 = this.A.get(str);
        if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
            this.A.put(str, bArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                this.f286230s0.putString(str, U(bArr));
            }
        }
    }

    public byte[] E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.f286222o0 == null && this.f286193a.getCurrentAccountUin() != null) {
            this.f286222o0 = h1(this.f286228r0.getString(AppConstants.Preferences.GET_PUB_ACCOUNT_MSG_COOKIE, ""));
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "--->>getLastPubAccountCookie lastPACookie:" + U(this.f286222o0));
        }
        return this.f286222o0;
    }

    public void E1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, j3);
        } else {
            this.C0.remove(Long.valueOf(j3));
        }
    }

    public void F(long j3, List<msg_comm$Msg> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Long.valueOf(j3), list);
            return;
        }
        ArrayList<msg_comm$Msg> arrayList = this.C0.get(Long.valueOf(j3));
        if (arrayList == null || arrayList.size() == 0) {
            arrayList = new ArrayList<>();
        }
        arrayList.addAll(list);
        this.C0.put(Long.valueOf(j3), arrayList);
    }

    public byte[] F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        byte[] bArr = this.f286220n0;
        if ((bArr == null || bArr.length == 0) && this.f286193a.getCurrentAccountUin() != null) {
            String string = this.f286228r0.getString(AppConstants.Preferences.GET_MSG_V2_SYNC_COOKIE, "");
            if (string.length() == 0) {
                this.f286220n0 = null;
            } else {
                this.f286220n0 = h1(string);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "--->>getLastSyncCookie lastSyncCookie:" + U(this.f286220n0));
        }
        return this.f286220n0;
    }

    public void F1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            this.D0.remove(Long.valueOf(j3));
        }
    }

    public void G(long j3, List<msg_comm$Msg> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Long.valueOf(j3), list);
            return;
        }
        ArrayList<msg_comm$Msg> arrayList = this.D0.get(Long.valueOf(j3));
        if (arrayList == null || arrayList.size() == 0) {
            arrayList = new ArrayList<>();
        }
        arrayList.addAll(list);
        this.D0.put(Long.valueOf(j3), arrayList);
    }

    public byte[] G0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 182)) {
            return (byte[]) iPatchRedirector.redirect((short) 182, (Object) this, (Object) str, (Object) str2);
        }
        return H0(str, str2, true);
    }

    public d G1(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 161)) {
            return (d) iPatchRedirector.redirect((short) 161, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        QLog.i("MsgSend", 1, String.format("removeSendingCache key = %d %s %d", Long.valueOf(j3), MsfSdkUtils.getShortUin(str), Integer.valueOf(i3)), new RuntimeException());
        String f16 = ao.f(str, i3);
        d dVar = null;
        if (this.f286231t.containsKey(f16)) {
            ConcurrentHashMap<Long, d> concurrentHashMap = this.f286231t.get(f16);
            if (concurrentHashMap != null) {
                dVar = concurrentHashMap.remove(Long.valueOf(j3));
            }
            if (concurrentHashMap != null && concurrentHashMap.isEmpty()) {
                this.f286231t.remove(f16);
            }
        }
        if (!u1() && this.f286233u.containsKey(f16)) {
            ConcurrentHashMap<Long, d> concurrentHashMap2 = this.f286233u.get(f16);
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.remove(Long.valueOf(j3));
            }
            if (concurrentHashMap2 != null && concurrentHashMap2.isEmpty()) {
                this.f286233u.remove(f16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "msgSending:delete result in messageSendingTemp " + this.f286233u);
            }
        }
        if (this.V.containsKey(f16)) {
            Iterator<Integer> it = this.V.get(f16).keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int intValue = it.next().intValue();
                HashSet<Long> hashSet = this.V.get(f16).get(Integer.valueOf(intValue));
                if (QLog.isColorLevel()) {
                    QLog.d(R0, 2, String.format("removeSendingCache  longMsgFragmentSet = %s", hashSet));
                }
                if (hashSet.contains(Long.valueOf(j3))) {
                    hashSet.remove(Long.valueOf(j3));
                    if (hashSet.isEmpty()) {
                        i16 = intValue;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(R0, 2, "removeSendingCache uniseq=" + j3 + "longid=" + intValue);
                    }
                }
            }
            if (i16 != 0) {
                this.V.get(f16).remove(Integer.valueOf(i16));
            }
        }
        return dVar;
    }

    public void H(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        byte[] bArr2 = this.E.get(str);
        if (bArr2 == null || !bArr2.equals(bArr)) {
            this.E.put(str, bArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences sharedPreferences = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "pub", 0);
                String W1 = W1(bArr);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, W1);
                edit.commit();
            }
        }
    }

    public byte[] H0(String str, String str2, boolean z16) {
        ConcurrentHashMap<String, byte[]> concurrentHashMap;
        String str3;
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 183)) {
            return (byte[]) iPatchRedirector.redirect((short) 183, this, str, str2, Boolean.valueOf(z16));
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (z16) {
            concurrentHashMap = this.f286204f0;
        } else {
            concurrentHashMap = this.f286206g0;
        }
        String str4 = str + "_" + str2;
        if (!concurrentHashMap.containsKey(str4)) {
            BaseApplication app = this.f286193a.getApp();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f286193a.getCurrentAccountUin());
            sb5.append("MatchChat");
            if (z16) {
                str3 = "";
            } else {
                str3 = "_campus";
            }
            sb5.append(str3);
            String string = app.getSharedPreferences(sb5.toString(), 0).getString(str4, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            concurrentHashMap.put(str4, i16);
            return i16;
        }
        return concurrentHashMap.get(str4);
    }

    public void H1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.B0.remove(str);
        }
    }

    public void I(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 193)) {
            iPatchRedirector.redirect((short) 193, this, str, str2, bArr);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            try {
                byte[] bArr2 = this.f286212j0.get(str3);
                if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                    SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "qq_circle", 0).edit();
                    if (bArr != null && bArr.length != 0) {
                        this.f286212j0.put(str3, bArr);
                        edit.putString(str3, W1(bArr));
                        edit.apply();
                    }
                    this.f286212j0.remove(str3);
                    edit.remove(str3);
                    edit.apply();
                }
            } catch (Exception e16) {
                QLog.d(R0 + "QQCircle", 2, "addQQCircleChatSessionKey throw e, e = ", e16);
            }
        }
    }

    public byte[] I0(String str, String str2) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 186)) {
            return (byte[]) iPatchRedirector.redirect((short) 186, (Object) this, (Object) str, (Object) str2);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        ConcurrentHashMap<String, byte[]> concurrentHashMap = this.f286208h0;
        String str3 = str + "_" + str2;
        if (!concurrentHashMap.containsKey(str3)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "MatchFriendChat", 0).getString(str3, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            concurrentHashMap.put(str3, i16);
            return i16;
        }
        return concurrentHashMap.get(str3);
    }

    public void I1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, j3);
            return;
        }
        String currentAccountUin = this.f286193a.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin) && j3 > 0) {
            this.f286234u0.put(currentAccountUin, Long.valueOf(j3));
            SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(currentAccountUin + "birth", 0).edit();
            edit.putLong(currentAccountUin + "_time", j3);
            edit.apply();
        }
    }

    public void J(ArrayList<RevokeMsgInfo> arrayList) {
        boolean z16;
        String format;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 171)) {
            iPatchRedirector.redirect((short) 171, (Object) this, (Object) arrayList);
            return;
        }
        RevokeMsgInfo revokeMsgInfo = arrayList.get(0);
        if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "RevokeNotifyCache, add cache, " + revokeMsgInfo.toString());
        }
        int i3 = revokeMsgInfo.f281286d;
        String str = revokeMsgInfo.f281288f;
        if (revokeMsgInfo.F > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            format = String.format("%s&%d&%d&%d", str, Integer.valueOf(i3), Integer.valueOf(revokeMsgInfo.E), Integer.valueOf(revokeMsgInfo.F));
        } else {
            format = String.format("%s&%d&%d", str, Integer.valueOf(i3), Long.valueOf(revokeMsgInfo.f281287e));
        }
        if (this.f286239x.containsKey(format)) {
            ArrayList arrayList2 = this.f286239x.get(format);
            ArrayList arrayList3 = new ArrayList();
            Iterator<RevokeMsgInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                RevokeMsgInfo next = it.next();
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    RevokeMsgInfo revokeMsgInfo2 = (RevokeMsgInfo) it5.next();
                    if (next.f281287e != revokeMsgInfo2.f281287e || next.f281291m != revokeMsgInfo2.f281291m) {
                    }
                }
                arrayList3.add(next);
            }
            arrayList2.addAll(arrayList3);
            return;
        }
        this.f286239x.put(format, arrayList);
    }

    public ArrayList<String> J0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f286229s;
    }

    public void J1(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, str, Long.valueOf(j3));
            return;
        }
        String currentAccountUin = this.f286193a.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin) && !TextUtils.isEmpty(str) && j3 > 0) {
            String str2 = currentAccountUin + "_noticetime_" + str;
            this.f286238w0.put(str2, Long.valueOf(j3));
            SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(currentAccountUin + "birth", 0).edit();
            edit.putLong(str2, j3);
            edit.apply();
        }
    }

    public void K(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        byte[] bArr2 = this.F.get(str);
        if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
            this.F.put(str, bArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences sharedPreferences = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "same_state", 0);
                String W1 = W1(bArr);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, W1);
                edit.commit();
            }
        }
    }

    public void K1(Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) set);
            return;
        }
        String currentAccountUin = this.f286193a.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin) && set != null) {
            this.f286236v0.put(currentAccountUin, set);
            SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(currentAccountUin + "birth", 0).edit();
            edit.putStringSet(currentAccountUin + "_list", set);
            edit.apply();
        }
    }

    public d L(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 160)) {
            return (d) iPatchRedirector.redirect((short) 160, (Object) this, (Object) messageRecord, i3);
        }
        String f16 = ao.f(messageRecord.frienduin, messageRecord.istroop);
        d dVar = new d(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, System.currentTimeMillis());
        dVar.f286256e = i3;
        if (this.f286231t.containsKey(f16)) {
            ConcurrentHashMap<Long, d> concurrentHashMap = this.f286231t.get(f16);
            if (concurrentHashMap != null) {
                concurrentHashMap.put(Long.valueOf(messageRecord.uniseq), dVar);
            } else {
                ConcurrentHashMap<Long, d> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(Long.valueOf(messageRecord.uniseq), dVar);
                this.f286231t.put(f16, concurrentHashMap2);
            }
        } else {
            ConcurrentHashMap<Long, d> concurrentHashMap3 = new ConcurrentHashMap<>();
            concurrentHashMap3.put(Long.valueOf(messageRecord.uniseq), dVar);
            this.f286231t.put(f16, concurrentHashMap3);
        }
        if (messageRecord.isLongMsg()) {
            if (this.V.containsKey(f16)) {
                if (this.V.get(f16).containsKey(Integer.valueOf(messageRecord.longMsgId))) {
                    this.V.get(f16).get(Integer.valueOf(messageRecord.longMsgId)).add(Long.valueOf(messageRecord.uniseq));
                } else {
                    HashSet<Long> hashSet = new HashSet<>();
                    hashSet.add(Long.valueOf(messageRecord.uniseq));
                    this.V.get(f16).put(Integer.valueOf(messageRecord.longMsgId), hashSet);
                }
            } else {
                ConcurrentHashMap<Integer, HashSet<Long>> concurrentHashMap4 = new ConcurrentHashMap<>();
                HashSet<Long> hashSet2 = new HashSet<>();
                hashSet2.add(Long.valueOf(messageRecord.uniseq));
                concurrentHashMap4.put(Integer.valueOf(messageRecord.longMsgId), hashSet2);
                this.V.put(f16, concurrentHashMap4);
            }
        }
        return dVar;
    }

    public byte[] L0(String str) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (byte[]) iPatchRedirector.redirect((short) 67, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.L.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "movie_ticket_bytes_chat_sig", 0).getString(str, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.L.put(str, i16);
            return i16;
        }
        return this.L.get(str);
    }

    public void L1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f286195b = i3;
        if (this.f286193a.getCurrentAccountUin() != null) {
            this.f286230s0.putInt(AppConstants.Preferences.GET_LAST_MESSAGE_TIME, i3);
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "--->>setBuddyMsgLastSeq lastseq = " + i3);
            }
        }
    }

    public void M(long j3, String str, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 157)) {
            iPatchRedirector.redirect((short) 157, this, Long.valueOf(j3), str, Long.valueOf(j16));
            return;
        }
        ArrayList<String> arrayList = this.M0.get(Long.valueOf(j3));
        if (arrayList == null) {
            if (this.M0.size() >= 20) {
                Iterator<Long> it = this.M0.keySet().iterator();
                long j17 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    long longValue = it.next().longValue();
                    long parseLong = Long.parseLong(this.M0.get(Long.valueOf(longValue)).get(0));
                    if (j16 - parseLong > 300) {
                        j17 = longValue;
                        break;
                    } else if (parseLong < j16) {
                        j17 = longValue;
                    }
                }
                this.M0.remove(Long.valueOf(j17));
            }
            arrayList = new ArrayList<>();
        }
        if (arrayList.size() >= 20) {
            arrayList.remove(0);
        }
        String l3 = Long.toString(j16);
        if (arrayList.size() == 0) {
            arrayList.add(l3);
        } else {
            arrayList.set(0, l3);
        }
        arrayList.add(str);
        this.M0.put(Long.valueOf(j3), arrayList);
    }

    public long M0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return ((Long) iPatchRedirector.redirect((short) 79, (Object) this, (Object) str, i3)).longValue();
        }
        String f16 = ao.f(str, i3);
        if (this.f286193a.getCurrentAccountUin() == null) {
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "getMsgDelLastSeq uin = " + str + ",type = " + i3 + " , lastSeqId = 0");
            }
            return 0L;
        }
        if (!this.P.containsKey(f16)) {
            long j3 = this.f286228r0.getLong(AppConstants.Preferences.GET_DEL_MSG_LAST_SEQ + f16, 0L);
            this.P.put(f16, Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "getMsgDelLastSeq uin = " + str + ",type = " + i3 + " , lastSeqId = " + j3);
            }
        }
        return this.P.get(f16).longValue();
    }

    public void M1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f286242y0 = z16;
        }
    }

    public void N(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 195)) {
            iPatchRedirector.redirect((short) 195, this, str, str2, bArr);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            try {
                byte[] bArr2 = this.f286214k0.get(str3);
                if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                    SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "qq_square", 0).edit();
                    if (bArr != null && bArr.length != 0) {
                        this.f286214k0.put(str3, bArr);
                        edit.putString(str3, W1(bArr));
                        edit.apply();
                    }
                    this.f286214k0.remove(str3);
                    edit.remove(str3);
                    edit.apply();
                }
            } catch (Exception e16) {
                QLog.d(R0 + "QQSquare", 2, "addSquareChatSessionKey throw e, e = ", e16);
            }
        }
    }

    public void O(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, this, str, Long.valueOf(j3));
            return;
        }
        this.R.put(str, Long.valueOf(j3));
        String currentAccountUin = this.f286193a.getCurrentAccountUin();
        if (currentAccountUin != null) {
            this.f286230s0.putLong(str + currentAccountUin, j3).commit();
        }
    }

    public int O0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 174)) {
            return ((Integer) iPatchRedirector.redirect((short) 174, (Object) this)).intValue();
        }
        if (this.f286232t0 < 0) {
            if (this.f286228r0.contains(AppConstants.Preferences.MSGSIGNAL_SWITCH)) {
                this.f286232t0 = this.f286228r0.getInt(AppConstants.Preferences.MSGSIGNAL_SWITCH, 0);
            } else {
                this.f286232t0 = 0;
            }
        }
        return this.f286232t0;
    }

    public void P(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 189)) {
            iPatchRedirector.redirect((short) 189, this, str, str2, bArr);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            try {
                byte[] bArr2 = this.f286210i0.get(str3);
                if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                    SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "tiny_session_sig", 0).edit();
                    if (bArr != null && bArr.length != 0) {
                        this.f286210i0.put(str3, bArr);
                        edit.putString(str3, W1(bArr));
                        edit.commit();
                    }
                    this.f286210i0.remove(str3);
                    edit.remove(str3);
                    edit.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public byte[] P0(String str) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (byte[]) iPatchRedirector.redirect((short) 70, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.H.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "nearby_assistant", 0).getString(str, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.H.put(str, i16);
            return i16;
        }
        return this.H.get(str);
    }

    public void P1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this, (Object) str, i3);
            return;
        }
        this.E0.put(str, Integer.valueOf(i3));
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder(128);
                sb5.append("setDiscussionMsgState discussionUin: ");
                sb5.append(str);
                sb5.append(" state: ");
                sb5.append(i3);
                QLog.d(R0, 2, sb5.toString());
            }
            if (i3 == 2) {
                A1(str);
            }
        }
    }

    public void Q(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            iPatchRedirector.redirect((short) 149, (Object) this, (Object) messageRecord);
            return;
        }
        this.W.put(String.valueOf(messageRecord.istroop) + "_" + messageRecord.frienduin + "_" + messageRecord.uniseq, messageRecord);
    }

    public Map<String, Set<Integer>> Q0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            return (Map) iPatchRedirector.redirect((short) 134, (Object) this, (Object) str, i3);
        }
        synchronized (this.U) {
            String f16 = ao.f(str, i3);
            if (!this.U.containsKey(f16) || this.U.get(f16) == null) {
                return null;
            }
            ConcurrentHashMap<String, Set<Integer>> concurrentHashMap = this.U.get(f16);
            if (concurrentHashMap != null && concurrentHashMap.isEmpty()) {
                this.U.remove(f16);
                return null;
            }
            return concurrentHashMap;
        }
    }

    public void Q1(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
            return;
        }
        this.f286222o0 = bArr;
        if (this.f286193a.getCurrentAccountUin() != null) {
            String U = U(bArr);
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "--->>setLastPubAccountCookie lastPACookie:" + U);
            }
            this.f286230s0.putString(AppConstants.Preferences.GET_PUB_ACCOUNT_MSG_COOKIE, U);
        }
    }

    public void R(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            iPatchRedirector.redirect((short) 152, (Object) this, (Object) messageRecord);
            return;
        }
        this.X.add(messageRecord.frienduin + "_" + messageRecord.msgUid + "_" + messageRecord.shmsgseq);
    }

    public OpenID R0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 154)) {
            return (OpenID) iPatchRedirector.redirect((short) 154, (Object) this, (Object) str);
        }
        if (!this.L0.containsKey(str)) {
            EntityManager createEntityManager = this.f286193a.getEntityManagerFactory().createEntityManager();
            OpenID openID = (OpenID) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) OpenID.class, str);
            if (openID != null) {
                D(str, openID);
                if (QLog.isColorLevel()) {
                    QLog.d("openid", 2, "Add cache from db appid = " + str);
                }
            }
            createEntityManager.close();
        } else if (QLog.isColorLevel()) {
            QLog.d("openid", 2, "Already in cache appid = " + str + ",openid=" + this.L0.get(str).openID);
        }
        return this.L0.get(str);
    }

    public void R1(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
            return;
        }
        this.f286220n0 = bArr;
        if (this.f286193a.getCurrentAccountUin() != null) {
            String U = U(bArr);
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "--->>setLastSyncCookie lastSyncCookie:" + U);
            }
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "--->>setBuddyMsgLastSeq cookie = " + U(bArr));
            }
            this.f286230s0.putString(AppConstants.Preferences.GET_MSG_V2_SYNC_COOKIE, U);
        }
    }

    public void S(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] bArr2 = this.J.get(str);
            if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "tribe_bytes_chat_sig", 0).edit();
                if (bArr != null && bArr.length != 0) {
                    this.J.put(str, bArr);
                    edit.putString(str, W1(bArr));
                    edit.commit();
                }
                this.J.remove(str);
                edit.remove(str);
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public ArrayList<msg_comm$Msg> S0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ArrayList) iPatchRedirector.redirect((short) 26, (Object) this, j3);
        }
        return this.C0.get(Long.valueOf(j3));
    }

    public void S1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 168)) {
            iPatchRedirector.redirect((short) 168, (Object) this, z16);
        } else {
            this.f286235v = z16;
        }
    }

    public void T(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "addWpaMsgKey uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:" + U(bArr));
        }
        byte[] bArr2 = this.f286243z.get(str);
        if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
            this.f286243z.put(str, bArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                this.f286230s0.putString(str, U(bArr));
            }
        }
    }

    public ArrayList<msg_comm$Msg> T0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (ArrayList) iPatchRedirector.redirect((short) 29, (Object) this, j3);
        }
        return this.D0.get(Long.valueOf(j3));
    }

    public void T1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 175)) {
            iPatchRedirector.redirect((short) 175, (Object) this, i3);
            return;
        }
        if (O0() != i3) {
            this.f286232t0 = i3;
            this.f286230s0.putInt(AppConstants.Preferences.MSGSIGNAL_SWITCH, i3);
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "--->>setMsgSignalSwitch = " + i3);
            }
        }
    }

    public byte[] U0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (byte[]) iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "pcQQSearchKey uin:null peerUin:" + str + " key:null");
            }
            return null;
        }
        if (!this.A.containsKey(str)) {
            String string = this.f286228r0.getString(str, null);
            if (string == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(R0, 2, "pcQQSearchKey uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:null");
                }
                return null;
            }
            this.A.put(str, h1(string));
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "pcQQSearchKey uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:" + U(this.A.get(str)));
        }
        return this.A.get(str);
    }

    public void U1(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 172)) {
            iPatchRedirector.redirect((short) 172, (Object) this, (Object) messageRecord);
        } else {
            this.f286237w = messageRecord;
        }
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, (Object) this);
            return;
        }
        if (!this.f286231t.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, ConcurrentHashMap<Long, d>> entry : this.f286231t.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                    for (Map.Entry<Long, d> entry2 : entry.getValue().entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("uin", entry2.getValue().f286252a);
                            jSONObject.put("type", entry2.getValue().f286253b);
                            jSONObject.put("uniseq", entry2.getValue().f286254c);
                            jSONArray.mo162put(jSONObject);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
            if (this.f286193a.getCurrentAccountUin() != null) {
                this.f286230s0.putString("msgSending", jSONArray.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(R0, 2, "msgSending:write msgSending file before exit," + jSONArray.toString());
                }
            }
        }
        Y();
        this.f286195b = -1;
        this.f286197c.clear();
        this.B0.clear();
        this.f286215l.clear();
        this.F0.clear();
        this.G0.clear();
        this.H0.clear();
        this.f286219n.clear();
        this.I0 = 0L;
        this.K0.clear();
        this.J0.clear();
        this.L0.clear();
        this.f286229s.clear();
        this.f286231t.clear();
        this.f286233u.clear();
        this.f286199d.clear();
        this.f286201e.clear();
        this.f286205g.clear();
        this.f286203f.clear();
        this.Q.clear();
    }

    public byte[] V0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (byte[]) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.E.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "pub", 0).getString(str, null);
            if (string == null) {
                return null;
            }
            this.E.put(str, i1(string));
        }
        return this.E.get(str);
    }

    public void V1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, i3);
            return;
        }
        this.A0.put(str, Integer.valueOf(i3));
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "setTroopMsgResponseState state: " + str + " state: " + i3);
            }
            if (i3 == 2) {
                C1(str);
            }
        }
    }

    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "clearDiscPullSeqCache");
        }
        this.f286211j.clear();
    }

    public byte[] W0(String str, String str2) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 192)) {
            return (byte[]) iPatchRedirector.redirect((short) 192, (Object) this, (Object) str, (Object) str2);
        }
        if (this.f286193a.getCurrentAccountUin() == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "_" + str2;
        if (!this.f286212j0.containsKey(str3)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "qq_circle", 0).getString(str3, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.f286212j0.put(str3, i16);
            return i16;
        }
        return this.f286212j0.get(str3);
    }

    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this);
        } else {
            this.Y.clear();
        }
    }

    public byte[] X0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (byte[]) iPatchRedirector.redirect((short) 63, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.F.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "same_state", 0).getString(str, null);
            if (string == null) {
                return null;
            }
            this.F.put(str, i1(string));
        }
        return this.F.get(str);
    }

    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            iPatchRedirector.redirect((short) 121, (Object) this);
            return;
        }
        a aVar = this.f286230s0;
        if (aVar != null) {
            aVar.commit();
        }
    }

    public byte[] Y0(String str, String str2) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 194)) {
            return (byte[]) iPatchRedirector.redirect((short) 194, (Object) this, (Object) str, (Object) str2);
        }
        if (this.f286193a.getCurrentAccountUin() == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "_" + str2;
        if (!this.f286214k0.containsKey(str3)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "qq_square", 0).getString(str3, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.f286214k0.put(str3, i16);
            return i16;
        }
        return this.f286214k0.get(str3);
    }

    public void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            iPatchRedirector.redirect((short) 145, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "dumpDiscMsgJob size = " + this.f286205g.size());
        }
    }

    public void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 141)) {
            iPatchRedirector.redirect((short) 141, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "dumpGroupMsgJob size = " + this.f286203f.size());
        }
    }

    public long a1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Long) iPatchRedirector.redirect((short) 75, (Object) this, (Object) str)).longValue();
        }
        String currentAccountUin = this.f286193a.getCurrentAccountUin();
        if (currentAccountUin == null) {
            return 0L;
        }
        if (!this.R.containsKey(str)) {
            this.R.put(str, Long.valueOf(this.f286228r0.getLong(str + currentAccountUin, 0L)));
        }
        return this.R.get(str).longValue();
    }

    public byte[] b0(String str) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (byte[]) iPatchRedirector.redirect((short) 68, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.G.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "accost", 0).getString(str, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.G.put(str, i16);
            return i16;
        }
        return this.G.get(str);
    }

    public byte[] b1(String str, String str2) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 188)) {
            return (byte[]) iPatchRedirector.redirect((short) 188, (Object) this, (Object) str, (Object) str2);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "_" + str2;
        if (!this.f286210i0.containsKey(str3)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "tiny_session_sig", 0).getString(str3, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.f286210i0.put(str3, i16);
            return i16;
        }
        return this.f286210i0.get(str3);
    }

    public AppRuntime c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.f286193a;
    }

    public byte[] c1(String str) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (byte[]) iPatchRedirector.redirect((short) 64, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.J.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "tribe_bytes_chat_sig", 0).getString(str, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.J.put(str, i16);
            return i16;
        }
        return this.J.get(str);
    }

    public void d(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] bArr2 = this.G.get(str);
            if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "accost", 0).edit();
                if (bArr != null && bArr.length != 0) {
                    this.G.put(str, bArr);
                    edit.putString(str, W1(bArr));
                    edit.commit();
                }
                this.G.remove(str);
                edit.remove(str);
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public AppShareID d0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            return (AppShareID) iPatchRedirector.redirect((short) 125, (Object) this, (Object) str);
        }
        if (!this.J0.containsKey(str)) {
            EntityManager createEntityManager = this.f286193a.getEntityManagerFactory().createEntityManager();
            AppShareID appShareID = (AppShareID) DBMethodProxy.find(createEntityManager, AppShareID.class, "strPkgName=?", new String[]{str});
            if (appShareID != null) {
                e(str, appShareID);
                if (QLog.isColorLevel()) {
                    QLog.d("share_appid", 2, "Add cache from db appid = " + str);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("share_appid", 2, "Not exist in db appid = " + str);
                }
                e(str, P0);
            }
            createEntityManager.close();
        } else if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Already in cache appid = " + str);
        }
        if (this.J0.get(str) == P0) {
            return null;
        }
        return this.J0.get(str);
    }

    public int d1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).intValue();
        }
        if (!this.A0.containsKey(str)) {
            this.A0.put(str, 2);
        }
        return this.A0.get(str).intValue();
    }

    public void e(String str, AppShareID appShareID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            iPatchRedirector.redirect((short) 126, (Object) this, (Object) str, (Object) appShareID);
            return;
        }
        this.J0.put(str, appShareID);
        if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "add share appid to cache = " + str);
        }
    }

    public HashSet<String> e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            return (HashSet) iPatchRedirector.redirect((short) 124, (Object) this);
        }
        return this.K0;
    }

    public ConcurrentHashMap<String, Integer> e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.A0;
    }

    public void f(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] bArr2 = this.f286196b0.get(str);
            if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "approval_assistant", 0).edit();
                if (bArr != null && bArr.length != 0) {
                    this.f286196b0.put(str, bArr);
                    edit.putString(str, W1(bArr));
                    edit.commit();
                }
                this.f286196b0.remove(str);
                edit.remove(str);
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public byte[] f0(String str) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (byte[]) iPatchRedirector.redirect((short) 69, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.f286196b0.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "approval_assistant", 0).getString(str, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.f286196b0.put(str, i16);
            return i16;
        }
        return this.f286196b0.get(str);
    }

    public ArrayList<Object[]> f1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ArrayList) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
        return this.B0.get(str);
    }

    public void g(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] bArr2 = this.K.get(str);
            if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "audioroom_bytes_chat_sig", 0).edit();
                if (bArr != null && bArr.length != 0) {
                    this.K.put(str, bArr);
                    edit.putString(str, W1(bArr));
                    edit.commit();
                }
                this.K.remove(str);
                edit.remove(str);
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public byte[] g0(String str) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (byte[]) iPatchRedirector.redirect((short) 66, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.K.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "audioroom_bytes_chat_sig", 0).getString(str, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.K.put(str, i16);
            return i16;
        }
        return this.K.get(str);
    }

    public byte[] g1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (byte[]) iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "getWpaMsgKey uin:null peerUin:" + str + " key:null");
            }
            return null;
        }
        if (!this.f286243z.containsKey(str)) {
            String string = this.f286228r0.getString(str, null);
            if (string == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(R0, 2, "getWpaMsgKey uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:null");
                }
                return null;
            }
            this.f286243z.put(str, h1(string));
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "getWpaMsgKey uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:" + U(this.f286243z.get(str)));
        }
        return this.f286243z.get(str);
    }

    public void h(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "addBusinessCrmMsgKey----> sig:" + U(bArr) + ",length:" + bArr.length);
        }
        byte[] bArr2 = this.B.get(str);
        if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
            this.B.put(str, bArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences sharedPreferences = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "crm", 0);
                String W1 = W1(bArr);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, W1);
                edit.commit();
            }
        }
    }

    public long h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Long) iPatchRedirector.redirect((short) 40, (Object) this)).longValue();
        }
        String currentAccountUin = this.f286193a.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            return -1L;
        }
        if (!this.f286234u0.containsKey(currentAccountUin)) {
            long j3 = this.f286193a.getApp().getSharedPreferences(currentAccountUin + "birth", 0).getLong(currentAccountUin + "_time", -1L);
            if (j3 == -1) {
                return -1L;
            }
            this.f286234u0.put(currentAccountUin, Long.valueOf(j3));
        }
        return this.f286234u0.get(currentAccountUin).longValue();
    }

    public void i(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "addBusinessCrmSigt uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:" + U(bArr));
        }
        byte[] bArr2 = this.C.get(str);
        if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
            this.C.put(str, bArr);
        }
    }

    public long i0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Long) iPatchRedirector.redirect((short) 42, (Object) this, (Object) str)).longValue();
        }
        String currentAccountUin = this.f286193a.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin) || TextUtils.isEmpty(str)) {
            return -1L;
        }
        String str2 = currentAccountUin + "_noticetime_" + str;
        if (!this.f286238w0.containsKey(str2)) {
            long j3 = this.f286193a.getApp().getSharedPreferences(currentAccountUin + "birth", 0).getLong(str2, -1L);
            if (j3 == -1) {
                return -1L;
            }
            this.f286238w0.put(str2, Long.valueOf(j3));
        }
        return this.f286238w0.get(str2).longValue();
    }

    public void j(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            iPatchRedirector.redirect((short) 118, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        String md5 = MD5.toMD5(str);
        this.f286219n.put(md5, new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
        if (this.f286193a.getCurrentAccountUin() != null) {
            this.f286230s0.putLong(AppConstants.Preferences.GET_C2C_BREAK_MESSAGE_TIME + md5, j3);
            this.f286230s0.putLong(AppConstants.Preferences.GET_C2C_BREAK_MESSAGE_TIME_RAND + md5, j16);
        }
    }

    public Set<String> j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (Set) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        String currentAccountUin = this.f286193a.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            return null;
        }
        if (!this.f286236v0.containsKey(currentAccountUin)) {
            Set<String> stringSet = this.f286193a.getApp().getSharedPreferences(currentAccountUin + "birth", 0).getStringSet(currentAccountUin + "_list", null);
            if (stringSet == null) {
                return null;
            }
            this.f286236v0.put(currentAccountUin, stringSet);
        }
        return this.f286236v0.get(currentAccountUin);
    }

    public boolean j1(MessageRecord messageRecord) {
        String format;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 170)) {
            return ((Boolean) iPatchRedirector.redirect((short) 170, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (this.f286239x.isEmpty()) {
            return false;
        }
        if (messageRecord.isLongMsg()) {
            format = String.format("%s&%d&%d&%d", messageRecord.frienduin, Integer.valueOf(messageRecord.istroop), Integer.valueOf(messageRecord.longMsgId), Integer.valueOf(messageRecord.longMsgCount));
        } else {
            format = String.format("%s&%d&%d", messageRecord.frienduin, Integer.valueOf(messageRecord.istroop), Long.valueOf(messageRecord.shmsgseq));
        }
        if (!this.f286239x.containsKey(format)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "RevokeNotifyCache, msgFilter true, " + messageRecord.toString());
        }
        return true;
    }

    public void k(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        byte[] bArr2 = this.M.get(str);
        if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
            this.M.put(str, bArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences sharedPreferences = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "circle_group", 0);
                String W1 = W1(bArr);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, W1);
                edit.commit();
            }
        }
    }

    public byte[] k0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (byte[]) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "getBusinessCrmKey uin:null peerUin:" + str + " key:null");
            }
            return null;
        }
        if (!this.B.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "crm", 0).getString(str, null);
            if (string == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(R0, 2, "businessCrmKey uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:null");
                }
                return null;
            }
            this.B.put(str, i1(string));
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "businessCrmKey uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:" + U(this.B.get(str)));
        }
        return this.B.get(str);
    }

    public boolean k1(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 173)) {
            return ((Boolean) iPatchRedirector.redirect((short) 173, this, str, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        MessageRecord messageRecord = this.f286237w;
        if (messageRecord != null && messageRecord.frienduin.equals(str)) {
            MessageRecord messageRecord2 = this.f286237w;
            if (messageRecord2.istroop == i3 && messageRecord2.uniseq == j3) {
                return true;
            }
        }
        return false;
    }

    public void l(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        byte[] bArr2 = this.N.get(str);
        if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
            this.N.put(str, bArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences sharedPreferences = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "circle_group_av", 0);
                String W1 = W1(bArr);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, W1);
                edit.commit();
            }
        }
    }

    public byte[] l0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (byte[]) iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "businessCrmSigt uin:null peerUin:" + str + " key:null");
            }
            return null;
        }
        if (!this.C.containsKey(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(R0, 2, "businessCrmSigt uin:" + this.f286193a.getCurrentAccountUin() + "peerUin:" + str + " key:" + U(this.C.get(str)));
        }
        return this.C.get(str);
    }

    public boolean l1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            return ((Boolean) iPatchRedirector.redirect((short) 144, (Object) this)).booleanValue();
        }
        return this.f286205g.isEmpty();
    }

    public void m(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, str, str2, bArr);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            try {
                byte[] bArr2 = this.f286200d0.get(str3);
                if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                    SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "confess_sig", 0).edit();
                    if (bArr != null && bArr.length != 0) {
                        this.f286200d0.put(str3, bArr);
                        edit.putString(str3, W1(bArr));
                        edit.commit();
                    }
                    this.f286200d0.remove(str3);
                    edit.remove(str3);
                    edit.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public Pair<Long, Long> m0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            return (Pair) iPatchRedirector.redirect((short) 119, (Object) this, (Object) str);
        }
        String md5 = MD5.toMD5(str);
        if (this.f286193a.getCurrentAccountUin() == null || TextUtils.isEmpty(md5)) {
            return null;
        }
        if (!this.f286219n.containsKey(md5)) {
            SharedPreferences sharedPreferences = this.f286228r0;
            StringBuilder Z0 = Z0();
            Z0.append(AppConstants.Preferences.GET_C2C_BREAK_MESSAGE_TIME);
            Z0.append(md5);
            long j3 = sharedPreferences.getLong(Z0.toString(), 0L);
            SharedPreferences sharedPreferences2 = this.f286228r0;
            StringBuilder Z02 = Z0();
            Z02.append(AppConstants.Preferences.GET_C2C_BREAK_MESSAGE_TIME_RAND);
            Z02.append(md5);
            this.f286219n.put(md5, new Pair<>(Long.valueOf(j3), Long.valueOf(sharedPreferences2.getLong(Z02.toString(), 0L))));
        }
        return this.f286219n.get(md5);
    }

    public boolean m1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            return ((Boolean) iPatchRedirector.redirect((short) 140, (Object) this)).booleanValue();
        }
        return this.f286203f.isEmpty();
    }

    public void n(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] bArr2 = this.I.get(str);
            if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "dating", 0).edit();
                if (bArr != null && bArr.length != 0) {
                    this.I.put(str, bArr);
                    edit.putString(str, W1(bArr));
                    edit.commit();
                }
                this.I.remove(str);
                edit.remove(str);
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public byte[] n0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (byte[]) iPatchRedirector.redirect((short) 59, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.M.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "circle_group", 0).getString(str, null);
            if (string == null) {
                return null;
            }
            this.M.put(str, i1(string));
        }
        return this.M.get(str);
    }

    public boolean n1(int i3, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 148)) {
            return ((Boolean) iPatchRedirector.redirect((short) 148, this, Integer.valueOf(i3), str, Long.valueOf(j3))).booleanValue();
        }
        return this.W.containsKey(String.valueOf(i3) + "_" + str + "_" + j3);
    }

    public void o(String str, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) str, (Object) objArr);
            return;
        }
        if (str != null) {
            this.f286201e.put(str, objArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                this.f286230s0.putLong(AppConstants.Preferences.GET_DISCUSSION_MEMBER_SEQ + str, ((Long) objArr[0]).longValue());
                this.f286230s0.putLong(AppConstants.Preferences.GET_DISCUSSION_CONFIG_SEQ + str, ((Long) objArr[1]).longValue());
            }
        }
    }

    public byte[] o0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (byte[]) iPatchRedirector.redirect((short) 60, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.N.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "circle_group_av", 0).getString(str, null);
            if (string == null) {
                return null;
            }
            this.N.put(str, i1(string));
        }
        return this.N.get(str);
    }

    public boolean o1(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 151)) {
            return ((Boolean) iPatchRedirector.redirect((short) 151, this, str, Long.valueOf(j3), Long.valueOf(j16))).booleanValue();
        }
        if (this.X.size() == 0) {
            return false;
        }
        return this.X.contains(str + "_" + j3 + "_" + j16);
    }

    public void p(String str, DisMsgReadedNotify disMsgReadedNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, (Object) str, (Object) disMsgReadedNotify);
        } else {
            this.G0.put(str, disMsgReadedNotify);
        }
    }

    public byte[] p0(String str, String str2) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 181)) {
            return (byte[]) iPatchRedirector.redirect((short) 181, (Object) this, (Object) str, (Object) str2);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "_" + str2;
        if (!this.f286200d0.containsKey(str3)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "confess_sig", 0).getString(str3, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.f286200d0.put(str3, i16);
            return i16;
        }
        return this.f286200d0.get(str3);
    }

    public boolean p1(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            return ((Boolean) iPatchRedirector.redirect((short) 135, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return q1(messageRecord.frienduin, messageRecord.istroop, ao.g(messageRecord));
    }

    public void q(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.f286217m.put(str, new Pair<>(Long.valueOf(j3), Long.valueOf(j16)));
        if (this.f286193a.getCurrentAccountUin() != null) {
            this.f286230s0.putLong(AppConstants.Preferences.GET_DISCUSSION_LAST_INFO_SEQ + str, j3);
            this.f286230s0.putLong(AppConstants.Preferences.GET_DISCUSSION_LAST_INFO_TIME + str, j16);
        }
    }

    public byte[] q0(String str) {
        byte[] i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (byte[]) iPatchRedirector.redirect((short) 71, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.I.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "dating", 0).getString(str, null);
            if (TextUtils.isEmpty(string) || (i16 = i1(string)) == null || i16.length <= 0) {
                return null;
            }
            this.I.put(str, i16);
            return i16;
        }
        return this.I.get(str);
    }

    public boolean q1(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            return ((Boolean) iPatchRedirector.redirect((short) 136, this, str, Integer.valueOf(i3), str2)).booleanValue();
        }
        synchronized (this.U) {
            Map<String, Set<Integer>> Q02 = Q0(str, i3);
            if (Q02 == null) {
                return false;
            }
            if (!Q02.containsKey(str2)) {
                return false;
            }
            if (!Q02.get(str2).isEmpty()) {
                return true;
            }
            Q02.remove(str2);
            return false;
        }
    }

    public void r(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        byte[] bArr2 = this.O.get(str);
        if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
            this.O.put(str, bArr);
            if (this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences sharedPreferences = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "friend_validation", 0);
                String W1 = W1(bArr);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, W1);
                edit.commit();
            }
        }
    }

    public Object[] r0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (Object[]) iPatchRedirector.redirect((short) 85, (Object) this, (Object) str);
        }
        if (this.f286201e.containsKey(str)) {
            return this.f286201e.get(str);
        }
        if (this.f286193a.getCurrentAccountUin() != null) {
            long j3 = this.f286228r0.getLong(AppConstants.Preferences.GET_DISCUSSION_MEMBER_SEQ + str, -1L);
            long j16 = this.f286228r0.getLong(AppConstants.Preferences.GET_DISCUSSION_CONFIG_SEQ + str, -1L);
            if (j3 != 0) {
                return new Object[]{Long.valueOf(j3), Long.valueOf(j16)};
            }
            return null;
        }
        return null;
    }

    public void s(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, this, str, Long.valueOf(j3));
        } else {
            this.Y.put(str, Long.valueOf(j3));
        }
    }

    public long s0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            return ((Long) iPatchRedirector.redirect((short) 113, (Object) this, (Object) str)).longValue();
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return 0L;
        }
        if (!this.f286215l.containsKey(str)) {
            this.f286215l.put(str, Long.valueOf(this.f286228r0.getLong(AppConstants.Preferences.GET_DISCUSSION_LAST_MESSAGE_TIME + str, 0L)));
        }
        return this.f286215l.get(str).longValue();
    }

    public boolean s1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 167)) {
            return ((Boolean) iPatchRedirector.redirect((short) 167, (Object) this)).booleanValue();
        }
        return this.f286235v;
    }

    public void t(String str, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, (Object) str, (Object) objArr);
            return;
        }
        if (str != null) {
            this.f286199d.put(str, objArr);
            if (QLog.isColorLevel()) {
                QLog.d(R0, 2, "addGroupMsgMemberSeq: groupUin=", str, "lastSeqId=", objArr[0]);
            }
            if (this.f286193a.getCurrentAccountUin() != null) {
                this.f286230s0.putLong(AppConstants.Preferences.GET_TROOP_MEMBER_SEQ + str, ((Long) objArr[0]).longValue());
            }
        }
    }

    public int t0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return ((Integer) iPatchRedirector.redirect((short) 96, (Object) this, (Object) str)).intValue();
        }
        if (!this.E0.containsKey(str)) {
            this.E0.put(str, 2);
        }
        return this.E0.get(str).intValue();
    }

    public boolean t1(MessageRecord messageRecord) {
        ConcurrentHashMap<Long, d> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 162)) {
            return ((Boolean) iPatchRedirector.redirect((short) 162, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord == null) {
            return false;
        }
        String f16 = ao.f(messageRecord.frienduin, messageRecord.istroop);
        if (messageRecord.isLongMsg()) {
            if (!this.V.containsKey(f16) || !this.V.get(f16).containsKey(Integer.valueOf(messageRecord.longMsgId))) {
                return false;
            }
            return true;
        }
        if (!this.f286231t.containsKey(f16) || (concurrentHashMap = this.f286231t.get(f16)) == null || !concurrentHashMap.containsKey(Long.valueOf(messageRecord.uniseq))) {
            return false;
        }
        return true;
    }

    public void u(String str, GroupMsgReadedNotify groupMsgReadedNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this, (Object) str, (Object) groupMsgReadedNotify);
        } else {
            this.H0.put(str, groupMsgReadedNotify);
        }
    }

    public ConcurrentHashMap<String, Integer> u0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 98, (Object) this);
        }
        return this.E0;
    }

    public boolean u1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 165)) {
            return ((Boolean) iPatchRedirector.redirect((short) 165, (Object) this)).booleanValue();
        }
        ConcurrentHashMap<String, ConcurrentHashMap<Long, d>> concurrentHashMap = this.f286233u;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            return false;
        }
        return true;
    }

    public void v(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 184)) {
            iPatchRedirector.redirect((short) 184, this, str, str2, bArr);
        } else {
            w(str, str2, bArr, true);
        }
    }

    public ArrayList<Object[]> v0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            return (ArrayList) iPatchRedirector.redirect((short) 108, (Object) this, (Object) str);
        }
        return this.F0.get(str);
    }

    public boolean v1(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 158)) {
            return ((Boolean) iPatchRedirector.redirect((short) 158, this, Long.valueOf(j3), str)).booleanValue();
        }
        ArrayList<String> arrayList = this.M0.get(Long.valueOf(j3));
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            it.next();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void w(String str, String str2, byte[] bArr, boolean z16) {
        ConcurrentHashMap<String, byte[]> concurrentHashMap;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 185)) {
            iPatchRedirector.redirect((short) 185, this, str, str2, bArr, Boolean.valueOf(z16));
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (z16) {
                concurrentHashMap = this.f286204f0;
            } else {
                concurrentHashMap = this.f286206g0;
            }
            String str4 = str + "_" + str2;
            try {
                byte[] bArr2 = concurrentHashMap.get(str4);
                if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                    BaseApplication app = this.f286193a.getApp();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f286193a.getCurrentAccountUin());
                    sb5.append("MatchChat");
                    if (z16) {
                        str3 = "";
                    } else {
                        str3 = "_campus";
                    }
                    sb5.append(str3);
                    SharedPreferences.Editor edit = app.getSharedPreferences(sb5.toString(), 0).edit();
                    if (bArr != null && bArr.length != 0) {
                        concurrentHashMap.put(str4, bArr);
                        edit.putString(str4, W1(bArr));
                        edit.commit();
                    }
                    concurrentHashMap.remove(str4);
                    edit.remove(str4);
                    edit.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public Pair<Long, Long> w0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return (Pair) iPatchRedirector.redirect((short) 115, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        Pair<Long, Long> pair = this.f286217m.get(str);
        if (pair == null) {
            Pair<Long, Long> pair2 = new Pair<>(Long.valueOf(this.f286228r0.getLong(AppConstants.Preferences.GET_DISCUSSION_LAST_INFO_SEQ + str, 0L)), Long.valueOf(this.f286228r0.getLong(AppConstants.Preferences.GET_DISCUSSION_LAST_INFO_TIME + str, 0L)));
            this.f286217m.put(str, pair2);
            return pair2;
        }
        return pair;
    }

    public DisMsgReadedNotify w1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (DisMsgReadedNotify) iPatchRedirector.redirect((short) 101, (Object) this, (Object) str);
        }
        return this.G0.remove(str);
    }

    public void x(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 187)) {
            iPatchRedirector.redirect((short) 187, this, str, str2, bArr);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ConcurrentHashMap<String, byte[]> concurrentHashMap = this.f286208h0;
            String str3 = str + "_" + str2;
            try {
                byte[] bArr2 = concurrentHashMap.get(str3);
                if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                    SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "MatchFriendChat", 0).edit();
                    if (bArr != null && bArr.length != 0) {
                        concurrentHashMap.put(str3, bArr);
                        edit.putString(str3, W1(bArr));
                        edit.commit();
                    }
                    concurrentHashMap.remove(str3);
                    edit.remove(str3);
                    edit.commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public long x0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Long) iPatchRedirector.redirect((short) 77, (Object) this, (Object) str)).longValue();
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return 0L;
        }
        Long l3 = this.Q.get(str);
        if (l3 == null) {
            long j3 = this.f286228r0.getLong(AppConstants.Preferences.GET_FRIEND_FEED_TIME + str, -1L);
            Long valueOf = Long.valueOf(j3);
            this.Q.put(str, Long.valueOf(j3));
            l3 = valueOf;
        }
        return l3.longValue();
    }

    public GroupMsgReadedNotify x1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return (GroupMsgReadedNotify) iPatchRedirector.redirect((short) 103, (Object) this, (Object) str);
        }
        return this.H0.remove(str);
    }

    public void y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f286229s.add(str);
        }
    }

    public byte[] y0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (byte[]) iPatchRedirector.redirect((short) 62, (Object) this, (Object) str);
        }
        if (this.f286193a.getCurrentAccountUin() == null) {
            return null;
        }
        if (!this.O.containsKey(str)) {
            String string = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "friend_validation", 0).getString(str, null);
            if (string == null) {
                return null;
            }
            this.O.put(str, i1(string));
        }
        return this.O.get(str);
    }

    public MessageRecord y1(int i3, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 150)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 150, this, Integer.valueOf(i3), str, Long.valueOf(j3));
        }
        String str2 = String.valueOf(i3) + "_" + str + "_" + j3;
        MessageRecord messageRecord = this.W.get(str2);
        this.W.remove(str2);
        return messageRecord;
    }

    public void z(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] bArr2 = this.L.get(str);
            if ((bArr2 == null || !Arrays.equals(bArr2, bArr)) && this.f286193a.getCurrentAccountUin() != null) {
                SharedPreferences.Editor edit = this.f286193a.getApp().getSharedPreferences(this.f286193a.getCurrentAccountUin() + "movie_ticket_bytes_chat_sig", 0).edit();
                if (bArr != null && bArr.length != 0) {
                    this.L.put(str, bArr);
                    edit.putString(str, W1(bArr));
                    edit.commit();
                }
                this.L.remove(str);
                edit.remove(str);
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public long z0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return ((Long) iPatchRedirector.redirect((short) 105, (Object) this, (Object) str)).longValue();
        }
        Long l3 = this.Y.get(str);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public void z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 153)) {
            iPatchRedirector.redirect((short) 153, (Object) this);
        } else {
            this.X.clear();
        }
    }
}
