package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.f;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.o;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.n;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msf.service.protocol.pb.offlinepush;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.c;
import com.tencent.qphone.base.util.log.report.LogManager;
import com.tencent.qphone.base.util.log.report.LogReport;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    public static final String A0 = "com.tencent.mobileqq.action.QQWiFi";
    public static final String B0 = "com.tencent.mobileqq.msf.qqwifi.settings";
    public static final String C0 = "com.tencent.mobileqq.msf.qqwifi.redtouch";
    public static final String D0 = "com.tencent.mobileqq.msf.qqwifi.autoconnect";
    public static final String E0 = "com.tencent.mobileqq.msf.receiveofflinepushav";
    public static final String F0 = "com.tencent.mobileqq.msf.offlinepushclearallav";
    private static final long[] G0;
    private static final String H0 = "com.tencent.mobileqq.broadcast.pcactiveQQ";
    static final int I0 = 20140416;
    public static final int J0 = 0;
    public static final int K0 = 1;
    public static final int L0 = 2;
    public static final int M0 = 3;
    public static final int N0 = -56;
    public static final int O0 = -55;

    /* renamed from: d0, reason: collision with root package name */
    public static final String f249708d0 = "app_push_info_";

    /* renamed from: e0, reason: collision with root package name */
    static final String f249709e0 = "MSF.C.PushManager";

    /* renamed from: f0, reason: collision with root package name */
    static final String f249710f0 = "PCActivePush";

    /* renamed from: g0, reason: collision with root package name */
    private static final int[] f249711g0;

    /* renamed from: h0, reason: collision with root package name */
    private static int f249712h0 = 0;

    /* renamed from: i0, reason: collision with root package name */
    static SimpleDateFormat f249713i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    public static final String f249714j0 = "alarmAddedTime";

    /* renamed from: k0, reason: collision with root package name */
    public static long f249715k0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    public static boolean f249716l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    public static String f249717m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    public static volatile boolean f249718n0 = false;

    /* renamed from: o0, reason: collision with root package name */
    static final String f249719o0 = "OnlinePush.ReqPush";

    /* renamed from: p0, reason: collision with root package name */
    static final String f249720p0 = "CliNotifySvc.SvcReqPush";

    /* renamed from: q0, reason: collision with root package name */
    static final String f249721q0 = "StatSvc.QueryHB";

    /* renamed from: r0, reason: collision with root package name */
    static final String f249722r0 = "trpc.msg.register_proxy.RegisterProxy.MangeConfigPush";

    /* renamed from: s0, reason: collision with root package name */
    static int f249723s0 = 0;

    /* renamed from: t0, reason: collision with root package name */
    static int f249724t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    public static int f249725u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    public static int f249726v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public static final String f249727w0 = "com.tencent.mobileqq.msf.receiveofflinepush";

    /* renamed from: x0, reason: collision with root package name */
    public static final String f249728x0 = "com.tencent.mobileqq.msf.offlinepushclearall";

    /* renamed from: y0, reason: collision with root package name */
    public static final String f249729y0 = "com.tencent.mobileqq.msf.devlockquickloginpush";

    /* renamed from: z0, reason: collision with root package name */
    public static final String f249730z0 = "com.tencent.mobileqq.msf.devlockquickloginpushclear";
    public long A;
    public long B;
    private long C;
    private long D;
    ArrayList<j> E;
    ArrayList<j> F;
    boolean G;
    boolean H;
    public QQNotificationManager I;
    public MediaPlayer J;
    private AtomicBoolean K;
    private String L;
    private int M;
    private PendingIntent N;
    private BroadcastReceiver O;
    String P;
    String Q;
    String R;
    String S;
    String T;
    String U;
    String V;
    String W;
    String X;
    String Y;
    private int Z;

    /* renamed from: a, reason: collision with root package name */
    MsfCore f249731a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f249732a0;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f249733b;

    /* renamed from: b0, reason: collision with root package name */
    private Object f249734b0;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f249735c;

    /* renamed from: c0, reason: collision with root package name */
    public ToServiceMsg f249736c0;

    /* renamed from: d, reason: collision with root package name */
    private final HandlerThread f249737d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f249738e;

    /* renamed from: f, reason: collision with root package name */
    String f249739f;

    /* renamed from: g, reason: collision with root package name */
    String f249740g;

    /* renamed from: h, reason: collision with root package name */
    private final int f249741h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<String, com.tencent.mobileqq.msf.core.push.a> f249742i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.mobileqq.msf.core.push.g f249743j;

    /* renamed from: k, reason: collision with root package name */
    private PendingIntent f249744k;

    /* renamed from: l, reason: collision with root package name */
    AlarmManager f249745l;

    /* renamed from: m, reason: collision with root package name */
    k f249746m;

    /* renamed from: n, reason: collision with root package name */
    int f249747n;

    /* renamed from: o, reason: collision with root package name */
    public long f249748o;

    /* renamed from: p, reason: collision with root package name */
    boolean f249749p;

    /* renamed from: q, reason: collision with root package name */
    private Boolean f249750q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f249751r;

    /* renamed from: s, reason: collision with root package name */
    boolean f249752s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f249753t;

    /* renamed from: u, reason: collision with root package name */
    volatile Object f249754u;

    /* renamed from: v, reason: collision with root package name */
    int f249755v;

    /* renamed from: w, reason: collision with root package name */
    long f249756w;

    /* renamed from: x, reason: collision with root package name */
    final long f249757x;

    /* renamed from: y, reason: collision with root package name */
    long f249758y;

    /* renamed from: z, reason: collision with root package name */
    public long f249759z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what == h.I0) {
                h.this.c();
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Handler.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what == 1) {
                h.this.c(((Boolean) message.obj).booleanValue());
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements c.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.qphone.base.util.c.d
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            h.this.f249749p = z16;
            QLog.d(h.f249709e0, 1, "[asyncIsMiui6], isMiui6: " + h.this.f249749p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver f249763a;

        d(BroadcastReceiver broadcastReceiver) {
            this.f249763a = broadcastReceiver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this, (Object) broadcastReceiver);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(h.this.f249740g);
            BaseApplication.getContext().registerReceiver(this.f249763a, intentFilter);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements Runnable {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                long j3 = com.tencent.mobileqq.msf.core.x.b.j();
                if (j3 > 0) {
                    LockMethodProxy.sleep(j3);
                }
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            if (NetConnInfoCenter.isNetSupport()) {
                synchronized (h.this.f249754u) {
                    h.this.f249754u.notify();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f249766a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f249767b;

        f(Context context, Intent intent) {
            this.f249766a = context;
            this.f249767b = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, context, intent);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                h.this.a(this.f249766a, this.f249767b);
                LogManager.checkAndReportLogInfo();
                h.this.y();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g implements MediaPlayer.OnCompletionListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
            } else {
                mediaPlayer.release();
                h.this.J = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.push.h$h, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8096h implements MediaPlayer.OnCompletionListener {
        static IPatchRedirector $redirector_;

        C8096h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
            } else {
                mediaPlayer.release();
                h.this.J = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class i extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            QLog.d(h.f249710f0, 1, "onReceive action: " + action);
            if (h.H0.equals(action)) {
                String stringExtra = intent.getStringExtra("uin");
                int intExtra = intent.getIntExtra("retryIndex", 1);
                h.this.K.compareAndSet(false, true);
                h.this.a(stringExtra, intExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public offlinepush.PbPushOffMsg f249772a;

        /* renamed from: b, reason: collision with root package name */
        public int f249773b;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class k extends BaseThread {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            while (true) {
                synchronized (h.this.f249754u) {
                    try {
                        LockMethodProxy.wait(h.this.f249754u);
                    } catch (InterruptedException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w(h.f249709e0, 2, e16.toString(), e16);
                        }
                    }
                }
                h.this.f();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f249711g0 = new int[]{1, 1, 1, 5, 5, 10, 10, 30, 30, 60, 60, 900, 900};
        f249713i0 = new SimpleDateFormat("dd HH:mm:ss");
        f249715k0 = 0L;
        f249716l0 = false;
        f249717m0 = "0";
        f249718n0 = false;
        f249723s0 = 10101;
        f249724t0 = 10102;
        f249725u0 = TVKEventId.PLAYER_STATE_START_PLAY;
        f249726v0 = TVKEventId.PLAYER_STATE_PAUSE;
        G0 = new long[]{100, 200, 200, 100};
    }

    public h(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f249739f = "";
        this.f249740g = "";
        this.f249741h = 1;
        this.f249742i = new ConcurrentHashMap<>();
        this.f249746m = new k();
        this.f249747n = -1;
        this.f249748o = 0L;
        this.f249749p = false;
        this.f249750q = Boolean.TRUE;
        this.f249751r = true;
        this.f249752s = false;
        this.f249753t = false;
        this.f249754u = new Object();
        this.f249755v = 30000;
        this.f249756w = 0L;
        this.f249757x = MiniBoxNoticeInfo.MIN_5;
        this.f249758y = 0L;
        this.f249759z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = false;
        this.H = false;
        this.K = new AtomicBoolean(false);
        this.L = "0";
        this.M = -1;
        this.N = null;
        this.O = new i();
        this.P = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.Q = this.P + "/Tencent/MobileQQ/";
        this.R = AppConstants.PATH_CUSTOM_HEAD;
        this.S = this.Q + this.R + "_hd/";
        this.T = this.Q + this.R + "_thd/";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.R);
        sb5.append("_hd/");
        this.U = sb5.toString();
        this.V = this.Q + ".billd_urldrawable/";
        this.W = AppConstants.RoamingMapPath.ALL_RING;
        this.X = AppConstants.RoamingMapPath.ALL_VIBRATE;
        this.Y = AppConstants.RoamingMapPath.SPECIAL_CARE_RING;
        this.f249732a0 = false;
        this.f249734b0 = new Object();
        this.f249731a = msfCore;
        this.f249733b = new Handler(q.i().getLooper(), new a());
        this.f249735c = new Handler(q.i().getLooper(), new b());
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("onConnClosedPushThread");
        this.f249737d = baseHandlerThread;
        baseHandlerThread.start();
        this.f249738e = new Handler(baseHandlerThread.getLooper());
        this.f249743j = new com.tencent.mobileqq.msf.core.push.g(this);
        this.f249746m.setName("MsfCorePushManager");
        this.f249749p = com.tencent.qphone.base.util.c.i();
        com.tencent.qphone.base.util.c.a(new c());
    }

    private void f(String str) {
        com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(str);
        aVar.f249600n = String.valueOf(com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext()));
        JceOutputStream jceOutputStream = new JceOutputStream();
        aVar.writeTo(jceOutputStream);
        MsfStore.getNativeConfigStore().setConfig(f249708d0 + str, HexUtil.bytes2HexStr(jceOutputStream.toByteArray()));
    }

    private void g() {
        int i3;
        int size;
        if (this.F.size() > 0) {
            offlinepush.PbPushOffMsg pbPushOffMsg = this.F.get(0).f249772a;
            BaseApplication context = BaseApplication.getContext();
            Object[] l3 = l();
            if (l3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249709e0, 2, "Decode Message error, exit now");
                    return;
                }
                return;
            }
            String str = (String) l3[0];
            String str2 = (String) l3[1];
            String str3 = (String) l3[2];
            Bitmap decodeFile = BitmapFactory.decodeFile((String) l3[3]);
            if (decodeFile != null) {
                decodeFile = a(decodeFile, 50, 50);
            }
            if (this.I == null) {
                this.I = QQNotificationManager.getInstance();
            }
            NotificationCompat.Builder when = new NotificationCompat.Builder(context).setContentTitle(str2).setContentText(str3).setAutoCancel(true).setSmallIcon(BaseApplication.appnewavmsgicon).setTicker(str).setWhen(System.currentTimeMillis());
            if (decodeFile != null) {
                when.setLargeIcon(decodeFile);
            } else {
                when.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), BaseApplication.qqlaunchicon));
            }
            int i16 = Build.VERSION.SDK_INT;
            if (a(context, pbPushOffMsg.to_uin.get())) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249709e0, 2, "isShowNofityLight=true");
                }
                Calendar.getInstance().get(11);
                when.setLights(-16711936, 2000, 2000);
            }
            Intent intent = new Intent(E0);
            intent.putExtra(QQNotificationManager.PARAM_FROMUIN, pbPushOffMsg.from_uin.get());
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG);
            intent.setPackage(BaseApplication.getContext().getPackageName());
            if (i16 > 23) {
                i3 = 201326592;
            } else {
                i3 = 134217728;
            }
            when.setContentIntent(PendingIntent.getBroadcast(context, 0, intent, i3));
            when.setDeleteIntent(PendingIntent.getBroadcast(context, 0, new Intent(F0), i3));
            Notification build = when.build();
            this.I.cancel(f249709e0, NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG);
            if (this.f249749p) {
                try {
                    int i17 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -1);
                    if (this.G) {
                        size = this.F.size();
                    } else {
                        size = i17 + this.F.size();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(BadgeUtilImpl.TAG, 2, "NOTIFICATION_ID_PUSH_AVMSG changeMI6Badge count=" + size);
                    }
                    this.H = true;
                    BadgeUtilImpl.changeMI6Badge(BaseApplication.getContext(), size, build);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.i(BadgeUtilImpl.TAG, 2, "NOTIFICATION_ID_PUSH_AVMSG exception ex=" + th5);
                    }
                }
            }
            QQNotificationManager.addChannelIfNeed(build, QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
            this.I.notify(f249709e0, NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG, build);
            if (a(String.valueOf(pbPushOffMsg.to_uin.get()), context) == 1 && a()) {
                a(PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.SOUND_TYPE + pbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId), false);
            }
            if (b(String.valueOf(pbPushOffMsg.to_uin.get()), context) == 1 && b()) {
                ((Vibrator) context.getSystemService("vibrator")).vibrate(G0, -1);
                return;
            }
            return;
        }
        if (this.I == null) {
            this.I = QQNotificationManager.getInstance();
        }
        this.I.cancel(f249709e0, NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG);
    }

    private int h() {
        ArrayList arrayList = new ArrayList();
        Iterator<j> it = this.E.iterator();
        while (it.hasNext()) {
            j next = it.next();
            boolean z16 = true;
            if (a(next.f249772a.msg_type.get(), next.f249772a.dwViedoType.get()) == 1 && next.f249772a.discuss_info.has()) {
                Long valueOf = Long.valueOf(next.f249772a.discuss_info.discuss_uin.get());
                Iterator it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        if (((Long) it5.next()).equals(valueOf)) {
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    arrayList.add(valueOf);
                }
            }
        }
        return arrayList.size();
    }

    private Object[] l() {
        if (this.F.size() == 1) {
            Object[] objArr = new Object[4];
            Object[] a16 = a(this.F.get(0).f249772a);
            if (a16 == null) {
                return null;
            }
            int intValue = ((Integer) a16[0]).intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue != 2) {
                        return null;
                    }
                } else {
                    String str = "[\u79bb\u7ebf\u6d88\u606f]" + a16[2] + "(" + a16[4] + "):" + a16[1];
                    String str2 = a16[4] + "[\u79bb\u7ebf\u6d88\u606f]";
                    String str3 = a16[2] + ":" + a16[1];
                    objArr[0] = str;
                    objArr[1] = str2;
                    objArr[2] = str3;
                    objArr[3] = a16[3];
                    return objArr;
                }
            }
            String str4 = "[\u79bb\u7ebf\u6d88\u606f]" + a16[2] + ":" + a16[1];
            String str5 = a16[2] + "[\u79bb\u7ebf\u6d88\u606f]";
            String str6 = (String) a16[1];
            if (a(BaseApplication.getContext())) {
                if (((String) a16[1]).contains("\u89c6\u9891")) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(a16[2]);
                    str6 = "\u7ed9\u4f60\u53d1\u8d77\u8fc7\u89c6\u9891\u901a\u8bdd\uff0c\u8bf7\u7ed3\u675f\u5f53\u524d\u7535\u8bdd\u540e\u56de\u62e8\u3002";
                    sb5.append("\u7ed9\u4f60\u53d1\u8d77\u8fc7\u89c6\u9891\u901a\u8bdd\uff0c\u8bf7\u7ed3\u675f\u5f53\u524d\u7535\u8bdd\u540e\u56de\u62e8\u3002");
                    str4 = sb5.toString();
                }
                if (((String) a16[1]).contains("\u8bed\u97f3")) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(a16[2]);
                    str6 = "\u7ed9\u4f60\u53d1\u8d77\u8fc7\u8bed\u97f3\u901a\u8bdd\uff0c\u8bf7\u7ed3\u675f\u5f53\u524d\u7535\u8bdd\u540e\u56de\u62e8\u3002";
                    sb6.append("\u7ed9\u4f60\u53d1\u8d77\u8fc7\u8bed\u97f3\u901a\u8bdd\uff0c\u8bf7\u7ed3\u675f\u5f53\u524d\u7535\u8bdd\u540e\u56de\u62e8\u3002");
                    str4 = sb6.toString();
                }
            }
            objArr[0] = str4;
            objArr[1] = str5;
            objArr[2] = str6;
            objArr[3] = a16[3];
            return objArr;
        }
        Object[] objArr2 = new Object[4];
        String str7 = "\u6536\u5230" + this.F.size() + "\u4e2a\u672a\u63a5\u6765\u7535";
        objArr2[2] = str7;
        objArr2[1] = "QQ[\u79bb\u7ebf\u6d88\u606f]";
        objArr2[0] = "[\u79bb\u7ebf\u6d88\u606f]QQ " + str7;
        return objArr2;
    }

    private int m() {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        Iterator<j> it = this.E.iterator();
        while (it.hasNext()) {
            Long valueOf = Long.valueOf(it.next().f249772a.from_uin.get());
            Iterator it5 = arrayList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    if (((Long) it5.next()).equals(valueOf)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                arrayList.add(valueOf);
            }
        }
        return arrayList.size();
    }

    private static boolean q() {
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Intent intent = new Intent("com.tencent.mobileqq.msf.wakeup");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        String[] configList = MsfStore.getNativeConfigStore().getConfigList(f249708d0);
        int i16 = 1;
        if (configList == null || configList.length == 0) {
            QLog.d(f249709e0, 1, "loadAppPushInfo null");
        }
        if (true == z16 && configList == null) {
            int i17 = f249712h0;
            int[] iArr = f249711g0;
            if (i17 < iArr.length) {
                QLog.d(f249709e0, 1, "loop to loadAppPushInfo with time " + iArr[f249712h0] + " seconds");
                Message obtainMessage = this.f249735c.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = Boolean.valueOf(z16);
                this.f249735c.sendMessageDelayed(obtainMessage, (long) (iArr[f249712h0] * 1000));
                f249712h0++;
                int c16 = com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext());
                for (String str : configList) {
                    byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
                    com.tencent.mobileqq.msf.core.push.a aVar = new com.tencent.mobileqq.msf.core.push.a();
                    aVar.readFrom(new JceInputStream(hexStr2Bytes));
                    if (!a(aVar.f249588b, BaseApplication.getContext().getPackageName())) {
                        QLog.e(f249709e0, i16, "filter other push process. processName:" + aVar.f249588b);
                        MsfStore.getNativeConfigStore().removeConfig(f249708d0 + aVar.f249588b);
                    } else {
                        this.f249742i.put(aVar.f249588b, aVar);
                        if (aVar.f249597k != null && aVar.f249589c > 0) {
                            if (c16 == -1) {
                                QLog.d(f249709e0, i16, "nVersionCode:" + c16 + " sendMsgPushRegister now");
                                i3 = i16;
                            } else {
                                String valueOf = String.valueOf(c16);
                                String str2 = aVar.f249600n;
                                if (str2 != null) {
                                    if (str2.equals(valueOf)) {
                                        QLog.d(f249709e0, 1, "info.installVersion :" + aVar.f249600n + " strVersionCode:" + valueOf + " sendMsgPushRegister now");
                                        i3 = 1;
                                    } else if (z16) {
                                        QLog.d(f249709e0, 1, "info.installVersion :" + aVar.f249600n + " bBoot:" + z16 + " strVersionCode:" + valueOf + " sendMsgPushRegister now");
                                        i3 = 1;
                                    } else {
                                        QLog.d(f249709e0, 1, "info.installVersion :" + aVar.f249600n + " strVersionCode:" + valueOf + " no need sendMsgPushRegister");
                                        i3 = 0;
                                    }
                                } else if (z16) {
                                    QLog.d(f249709e0, 1, "info.installVersion :" + aVar.f249600n + " bBoot:" + z16 + " sendMsgPushRegister now");
                                    i3 = 1;
                                } else {
                                    QLog.d(f249709e0, 1, "info.installVersion :" + aVar.f249600n + " bBoot:" + z16 + " no need sendMsgPushRegister");
                                    i3 = 0;
                                }
                            }
                            if (i3 != 0) {
                                if (aVar.f249597k != null) {
                                    this.f249731a.getAccountCenter().d(aVar.f249597k.uin, "autoRegPush");
                                }
                                this.f249743j.a(aVar, null, false, RegPushReason.msfBoot);
                            } else {
                                aVar.f249589c = 0L;
                            }
                            if (f249716l0) {
                                i16 = 1;
                            } else {
                                i16 = 1;
                                f249716l0 = true;
                                f249717m0 = aVar.f249597k.uin;
                            }
                        }
                    }
                }
            }
        }
        if (this.f249731a.getStatReporter() != null) {
            this.f249731a.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.G0, configList != null, f249712h0, true == z16 ? 0 : 1, (Map<String, String>) null, false, false);
        }
        int c162 = com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext());
        while (r9 < r8) {
        }
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f249750q = Boolean.valueOf(z16);
            BaseApplication.getContext().getSharedPreferences(BaseConstants.SP_PUSH_MANAGER, 0).edit().putBoolean(BaseConstants.KEY_IS_BLOCK_PUSH_REGISTER, z16).apply();
        }
    }

    public synchronized void e(String str) {
        PushRegisterInfo pushRegisterInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        String packageName = BaseApplication.getContext().getPackageName();
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "recv processName:" + packageName + " recv KickedMsg ");
        }
        com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(packageName);
        if (aVar != null && (pushRegisterInfo = aVar.f249597k) != null && pushRegisterInfo.uin.equals(str)) {
            aVar.f249589c = 0L;
            aVar.f249597k = null;
            f(packageName);
        }
        if (this.f249731a.getAccountCenter().e().equals(str)) {
            this.f249731a.getAccountCenter().d("0", "onKicked");
        }
    }

    public long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Long) iPatchRedirector.redirect((short) 32, (Object) this)).longValue();
        }
        return this.C;
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Long) iPatchRedirector.redirect((short) 34, (Object) this)).longValue();
        }
        return this.D;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }
        return 3;
    }

    public long n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this)).longValue();
        }
        long j3 = this.f249758y;
        if (j3 == 0) {
            return MiniBoxNoticeInfo.MIN_5;
        }
        return j3;
    }

    public synchronized void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.f249752s) {
            this.f249746m.start();
            this.f249752s = true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        j.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "MSF_Alive_Log alarm receive " + intent);
        }
        if (this.f249748o > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f249748o;
            if (currentTimeMillis > 0 && (eVar = this.f249731a.statReporter.f247848b) != null) {
                eVar.f247863d = currentTimeMillis;
            }
            this.f249748o = 0L;
        }
        synchronized (this.f249754u) {
            this.f249754u.notify();
        }
        if (this.f249731a.getStandByModeManager() != null) {
            this.f249731a.getStandByModeManager().j();
        }
        q.s().post(new f(context, intent));
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f249750q.booleanValue();
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Iterator<String> it = this.f249742i.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(it.next());
            if (aVar != null && aVar.f249597k != null && aVar.f249589c != 0) {
                return true;
            }
        }
        return false;
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "onAVNotificationBroadcast");
        }
        BaseApplication context = BaseApplication.getContext();
        if (this.I == null) {
            this.I = QQNotificationManager.getInstance();
        }
        this.I.cancel(f249709e0, NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG);
        this.F.clear();
        try {
            Intent intent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "Start QQ failed" + e16);
            }
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            f249718n0 = false;
            f();
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        synchronized (this.f249754u) {
            this.f249754u.notify();
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "onNotificationBroadcast");
        }
        BaseApplication context = BaseApplication.getContext();
        if (this.I == null) {
            this.I = QQNotificationManager.getInstance();
        }
        this.I.cancel(f249709e0, 478);
        this.E.clear();
        try {
            if (r()) {
                Intent intent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(f249709e0, 2, "uin kicked out");
                }
                Intent intent2 = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "Start QQ failed" + e16);
            }
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "onNotificationClearAll");
        }
        this.E.clear();
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "onNotificationClearAllAV");
        }
        this.F.clear();
    }

    public void z() {
        AlarmManager alarmManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        if (this.K.get()) {
            QLog.d(f249710f0, 1, "stop tryActiveQQ by regPush");
            try {
                BaseApplication.getContext().unregisterReceiver(this.O);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("account", this.L);
            hashMap.put("retryIndex", String.valueOf(this.M));
            hashMap.put("reason", "regpush");
            if (this.f249731a.getStatReporter() != null) {
                this.f249731a.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247759v0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
            PendingIntent pendingIntent = this.N;
            if (pendingIntent != null && (alarmManager = this.f249745l) != null) {
                try {
                    alarmManager.cancel(pendingIntent);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            this.K.set(false);
        }
    }

    public int b(String str) {
        PushRegisterInfo pushRegisterInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).intValue();
        }
        Iterator<String> it = this.f249742i.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(it.next());
            if (aVar != null && (pushRegisterInfo = aVar.f249597k) != null && pushRegisterInfo.uin.equals(str)) {
                if (aVar.f249589c == 0) {
                    return -2;
                }
                return aVar.f249597k.iStatus;
            }
        }
        return -1;
    }

    public void a(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16));
            return;
        }
        this.I = QQNotificationManager.getInstance();
        this.f249739f = DeviceInfoMonitor.getModel() + "|" + Build.VERSION.RELEASE;
        this.f249740g = MsfSdkUtils.getProcessName(context) + "_" + getClass().hashCode();
        this.f249745l = (AlarmManager) BaseApplication.getContext().getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
        this.f249750q = Boolean.valueOf(BaseApplication.getContext().getSharedPreferences(BaseConstants.SP_PUSH_MANAGER, 0).getBoolean(BaseConstants.KEY_IS_BLOCK_PUSH_REGISTER, this.f249750q.booleanValue()));
        c(z16);
        o();
        q.s().post(new d(this));
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "clearOfflinePushNotification");
        }
        ((NotificationManager) BaseApplication.getContext().getSystemService("notification")).cancel(478);
        this.E.clear();
        this.G = false;
    }

    void f() {
        Iterator<String> it = this.f249742i.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(it.next());
            if (aVar != null && aVar.f249597k != null && aVar.f249589c != 0) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = aVar.f249592f;
                    if (j3 != 0 && currentTimeMillis - j3 > 25200000) {
                        a(aVar, RegPushReason.msfHeartTimeTooLong);
                    } else if (f249718n0 && aVar.f249595i != null && this.f249731a.nowSocketConnAdd != null && aVar.f249595i.equals(this.f249731a.nowSocketConnAdd)) {
                        this.f249743j.a(aVar, false);
                    } else if (!this.f249731a.isConnected()) {
                        this.f249731a.triggerNetServiceToConnect();
                        a(n());
                    } else {
                        a(aVar, RegPushReason.msfByNetChange);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w(f249709e0, 2, e16.toString(), e16);
                    }
                }
            }
        }
    }

    public synchronized void b(CommandCallbackerInfo commandCallbackerInfo, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) commandCallbackerInfo, (Object) toServiceMsg);
            return;
        }
        String b16 = n.b(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "recv processName:" + b16 + " recv unRegisterCmdCall ");
        }
        if (!this.f249742i.containsKey(b16)) {
            this.f249742i.putIfAbsent(b16, new com.tencent.mobileqq.msf.core.push.a(b16));
        }
        this.f249742i.get(b16).f249599m = commandCallbackerInfo;
        FromServiceMsg a16 = n.a(toServiceMsg);
        a16.setMsgSuccess();
        this.f249731a.addRespToQuque(toServiceMsg, a16);
        f(b16);
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
            return;
        }
        QLog.d(f249710f0, 1, "onPCActive");
        if (this.I == null) {
            this.I = QQNotificationManager.getInstance();
        }
        this.I.cancel(f249709e0, 478);
        this.E.clear();
        this.K.set(true);
        BaseApplication.getContext().registerReceiver(this.O, new IntentFilter(H0));
        this.M = 0;
        this.L = str;
        a(str, 0);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "clearOfflinePushNotificationAV");
        }
        if (this.I == null) {
            this.I = QQNotificationManager.getInstance();
        }
        this.I.cancel(f249709e0, NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG);
        this.F.clear();
        this.H = false;
    }

    public long a(String str) {
        PushRegisterInfo pushRegisterInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).longValue();
        }
        Iterator<String> it = this.f249742i.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(it.next());
            if (aVar != null && (pushRegisterInfo = aVar.f249597k) != null && pushRegisterInfo.uin.equals(str)) {
                if (aVar.f249589c == 0) {
                    return -2L;
                }
                return aVar.f249597k.extStatus;
            }
        }
        return -1L;
    }

    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) context);
            return;
        }
        if (this.f249744k != null) {
            QLog.d(f249709e0, 1, "cancel alarm, intent:" + this.f249744k);
            this.f249745l.cancel(this.f249744k);
        }
    }

    public void e(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "onRecvSsoHelloPush from:" + fromServiceMsg);
        }
        try {
            ToServiceMsg toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), BaseConstants.CMD_SSOHELLOPUSH);
            toServiceMsg.putWupBuffer(fromServiceMsg.getWupBuffer());
            toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg.setNeedCallback(false);
            toServiceMsg.setTimeout(30000L);
            toServiceMsg.setRequestSsoSeq(fromServiceMsg.getRequestSsoSeq());
            this.f249736c0 = toServiceMsg;
            try {
                this.f249731a.sendSsoMsg(toServiceMsg);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(f249709e0, 2, "send sso hello push resp error " + e16, e16);
                }
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.i(f249709e0, 2, "onRecvSsoHelloPush error " + e17, e17);
            }
        }
    }

    private String a(PushRegisterInfo pushRegisterInfo) {
        StringBuilder sb5 = new StringBuilder();
        if (pushRegisterInfo != null) {
            sb5.append("uin=");
            sb5.append(pushRegisterInfo.uin);
            sb5.append(", pushIds=");
            sb5.append(pushRegisterInfo.pushIds);
            sb5.append(", iStatus=");
            sb5.append(pushRegisterInfo.iStatus);
            sb5.append(", extStatus=");
            sb5.append(pushRegisterInfo.extStatus);
            sb5.append(", bKikPC=");
            sb5.append((int) pushRegisterInfo.bKikPC);
            sb5.append(", bKikWeak=");
            sb5.append((int) pushRegisterInfo.bKikWeak);
            sb5.append(", timeStamp=");
            sb5.append(pushRegisterInfo.timeStamp);
            sb5.append(", iLargeSeq=");
            sb5.append(pushRegisterInfo.iLargeSeq);
        }
        return sb5.toString();
    }

    public void b(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) fromServiceMsg);
            return;
        }
        Iterator<String> it = this.f249742i.keySet().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(it.next());
            if (aVar != null) {
                if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_CONN_PROBE)) {
                    QLog.d(f249709e0, 1, "[VendorPush.onRecvPushMsg] StatSvc.MsfConnProbe received. ", fromServiceMsg.getStringForLog());
                    MsfService.getCore().getMsfProbeManager().b(fromServiceMsg);
                    return;
                }
                if (fromServiceMsg.getServiceCmd().equals(f249720p0)) {
                    UniPacket uniPacket = new UniPacket(true);
                    uniPacket.setEncodeName("UTF-8");
                    try {
                        uniPacket.decode(fromServiceMsg.getWupBuffer());
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f249709e0, 2, "decode PushMsg error " + th5, th5);
                            return;
                        }
                        return;
                    }
                } else if (fromServiceMsg.getServiceCmd().equals(f249721q0)) {
                    if (com.tencent.mobileqq.msf.core.x.b.f250193x) {
                        aVar.f249595i = this.f249731a.nowSocketConnAdd;
                        aVar.f249592f = System.currentTimeMillis();
                        a(aVar, RegPushReason.serverPush);
                        z16 = true;
                    } else if (QLog.isColorLevel()) {
                        QLog.e(f249709e0, 2, "recv push StatSvc.QueryHB, but do not support useAnyPacketAsPushHB ");
                    }
                } else if (fromServiceMsg.getServiceCmd().equals(f249722r0)) {
                    boolean isSuccess = fromServiceMsg.isSuccess();
                    if (isSuccess) {
                        MsfPullConfigUtil.parseConfigResponse(fromServiceMsg.getWupBuffer(), true);
                        z16 = true;
                    }
                    QLog.i(f249709e0, 1, "recv onRecvPushMsg COMMAND_REGISTER_PROXY_HOTFIX_PUSH result = " + isSuccess + " | fromServiceMsg = " + fromServiceMsg);
                } else if (fromServiceMsg.isSuccess()) {
                    if (a(aVar, fromServiceMsg)) {
                        z16 = true;
                    }
                } else {
                    if (fromServiceMsg.getServiceCmd() != null && fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
                        com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247651c, fromServiceMsg.getWupBuffer(), 3);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f249709e0, 2, "recv error onRecvPushMsg FromServiceMsg  " + fromServiceMsg);
                    }
                }
            }
        }
        if (z16 || !QLog.isColorLevel()) {
            return;
        }
        QLog.w(f249709e0, 2, "found not handle push msg " + fromServiceMsg);
    }

    public void d(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) fromServiceMsg);
            return;
        }
        try {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            com.tencent.msf.service.protocol.serverconfig.f fVar = (com.tencent.msf.service.protocol.serverconfig.f) uniPacket.getByClass("PushReq", new com.tencent.msf.service.protocol.serverconfig.f());
            QLog.d(f249709e0, 1, "onRecvSsoPush req.type: " + fVar.f336803a);
            com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.getCore().getMsfNetService();
            int i3 = fVar.f336803a;
            if (i3 == 1) {
                if (msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a) {
                    ((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).s().a(fVar);
                }
            } else if (i3 == 2) {
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                fromServiceMsg.setMsfCommand(MsfCommand.onRecvConfigPush);
                MsfService.getCore().addRespToQuque(null, fromServiceMsg);
            } else if (i3 == 3) {
                LogReport.getInstance().onLogPush(fromServiceMsg, fVar);
            }
            a(fromServiceMsg, fVar);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(f249709e0, 2, "onRecvSsoPush error " + e16, e16);
            }
        }
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) toServiceMsg);
            return;
        }
        String b16 = n.b(toServiceMsg);
        com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(b16);
        if (aVar != null) {
            int intValue = ((Integer) toServiceMsg.getAttribute("battery_capacity", 0)).intValue();
            if (intValue > 0) {
                aVar.f249597k.batteryCapacity = intValue;
            }
            int intValue2 = ((Integer) toServiceMsg.getAttribute("power_connect", -1)).intValue();
            if (intValue2 != -1) {
                aVar.f249597k.powerConnect = intValue2;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "updateBatteryStatus batteryCapacity:", Integer.valueOf(intValue), " powerConnectStatus:", Integer.valueOf(intValue2));
            }
            f(b16);
        }
    }

    public void a(ToServiceMsg toServiceMsg, RegPushReason regPushReason) {
        int i3;
        PushRegisterInfo pushRegisterInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg, (Object) regPushReason);
            return;
        }
        if (this.f249735c.hasMessages(1)) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "remove message handler mLoadPushInfoHandler");
            }
            this.f249735c.removeMessages(1);
        }
        String b16 = n.b(toServiceMsg);
        if (a(b16, BaseApplication.getContext().getPackageName())) {
            if (!this.f249742i.containsKey(b16)) {
                this.f249742i.putIfAbsent(b16, new com.tencent.mobileqq.msf.core.push.a(b16));
            }
            PushRegisterInfo d16 = o.d(toServiceMsg);
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "recv processName:" + b16 + " recv regPush  ,regPushReason:" + regPushReason);
            }
            com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(b16);
            if (aVar != null && (pushRegisterInfo = aVar.f249597k) != null && aVar.f249589c != 0 && pushRegisterInfo.uin.equals(d16.uin)) {
                PushRegisterInfo pushRegisterInfo2 = aVar.f249597k;
                if (pushRegisterInfo2.iStatus == d16.iStatus) {
                    long j3 = pushRegisterInfo2.extStatus;
                    long j16 = d16.extStatus;
                    if (j3 == j16 && j16 != 1000 && pushRegisterInfo2.bKikPC == d16.bKikPC && pushRegisterInfo2.bKikWeak == d16.bKikWeak && pushRegisterInfo2.timeStamp == d16.timeStamp && pushRegisterInfo2.iLargeSeq == d16.iLargeSeq) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249709e0, 2, "handlerPush also register Push " + MD5.toMD5(d16.uin) + "iStatus:" + d16.iStatus + " extStatus:" + d16.extStatus);
                        }
                        FromServiceMsg a16 = n.a(toServiceMsg);
                        a16.setMsgSuccess();
                        this.f249731a.addRespToQuque(toServiceMsg, a16);
                        i3 = d16.iStatus;
                        if (i3 != 95 || i3 == 21) {
                            return;
                        }
                        MsfService.core.pushManager.z();
                        return;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e(f249709e0, 2, "handlerPush not found the same register Push " + MD5.toMD5(d16.uin) + " iStatus:" + d16.iStatus + " extStatus:" + d16.extStatus);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, String.format("old{%s}, new{%s}", a(aVar.f249597k), a(d16)));
            }
            PushRegisterInfo pushRegisterInfo3 = aVar.f249597k;
            if (pushRegisterInfo3 != null) {
                toServiceMsg.extraData.putInt("oldStatus", pushRegisterInfo3.iStatus);
            } else {
                QLog.d(f249709e0, 1, "oldPushInfo.appPushRegisterInfo is null");
            }
            aVar.f249597k = d16;
            aVar.f249587a = toServiceMsg.getAppId();
            Iterator<Long> it = d16.pushIds.iterator();
            while (it.hasNext()) {
                aVar.f249589c = it.next().longValue() | aVar.f249589c;
            }
            f(b16);
            this.f249743j.a(aVar, toServiceMsg, false, regPushReason);
            i3 = d16.iStatus;
            if (i3 != 95) {
                return;
            } else {
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(f249709e0, 2, "recv other processName:" + b16 + " recv regPush ");
        }
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            if (j3 <= 30000 || j3 >= 3600000) {
                return;
            }
            this.f249758y = j3;
        }
    }

    public void c(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f249709e0, 4, "onRecvPushReaded getted");
        }
        try {
            offlinepush.PbPushOffReadedNotify pbPushOffReadedNotify = new offlinepush.PbPushOffReadedNotify();
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            byte[] bArr = new byte[wupBuffer.length - 4];
            System.arraycopy(wupBuffer, 4, bArr, 0, wupBuffer.length - 4);
            pbPushOffReadedNotify.mergeFrom(bArr);
            int i3 = pbPushOffReadedNotify.cNotifyType.get();
            long j3 = 0;
            if ((i3 & 1) != 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<offlinepush.C2CMsgReadedNotify> it = pbPushOffReadedNotify.vC2CReadedNotify.get().iterator();
                while (it.hasNext()) {
                    long j16 = it.next().lPeerUin.get();
                    if (QLog.isDevelopLevel()) {
                        QLog.d(f249709e0, 4, "onRecvPushReaded C2C uin:" + j16);
                    }
                    Iterator<j> it5 = this.E.iterator();
                    while (it5.hasNext()) {
                        j next = it5.next();
                        long j17 = next.f249772a.to_uin.get();
                        if (next.f249772a.from_uin.get() == j16) {
                            arrayList.add(next);
                        }
                        j3 = j17;
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(f249709e0, 4, "onRecvPushReaded remove" + arrayList.size() + " message");
                }
                this.E.removeAll(arrayList);
            }
            if ((i3 & 4) != 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<offlinepush.DisMsgReadedNotify> it6 = pbPushOffReadedNotify.vDisReadedNotify.get().iterator();
                while (it6.hasNext()) {
                    long j18 = it6.next().lDisUin.get();
                    if (QLog.isDevelopLevel()) {
                        QLog.d(f249709e0, 4, "onRecvPushReaded Discuss uin:" + j18);
                    }
                    Iterator<j> it7 = this.E.iterator();
                    while (it7.hasNext()) {
                        j next2 = it7.next();
                        long j19 = next2.f249772a.to_uin.get();
                        if (next2.f249772a.discuss_info.discuss_uin.get() == j18) {
                            arrayList2.add(next2);
                        }
                        j3 = j19;
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(f249709e0, 4, "onRecvPushReaded remove" + arrayList2.size() + " message");
                }
                this.E.removeAll(arrayList2);
            }
            BadgeUtilImpl.setBadge(BaseApplication.getContext(), BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -1) + this.E.size());
            a(true);
            a(j3, fromServiceMsg.getRequestSsoSeq(), pbPushOffReadedNotify.svr_ip.get());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "onRecvPushReaded decode error:" + e16, e16);
            }
        }
    }

    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            this.f249743j.b(toServiceMsg, fromServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, j3);
            return;
        }
        MsfCore msfCore = this.f249731a;
        if (msfCore != null && msfCore.isConnected()) {
            this.D = j3;
        } else if (this.f249731a != null) {
            QLog.i(f249709e0, 1, "not need to update lastRecvTimeForSG, isConned:" + this.f249731a.isConnected());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007e, code lost:
    
        if ((r6 & 1) == 1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object[] b(boolean z16) {
        String str;
        String str2 = "[\u7279\u522b\u5173\u6ce8]";
        String str3 = "";
        if (this.E.size() == 1 && !z16) {
            Object[] objArr = new Object[4];
            Object[] a16 = a(this.E.get(0).f249772a);
            if (a16 == null) {
                return null;
            }
            int intValue = ((Integer) a16[0]).intValue();
            if (intValue != 0) {
                if (intValue == 1) {
                    String str4 = "[\u79bb\u7ebf\u6d88\u606f]" + a16[2] + "(" + a16[4] + "):" + a16[1];
                    String str5 = a16[4] + "[\u79bb\u7ebf\u6d88\u606f]";
                    String str6 = a16[2] + ":" + a16[1];
                    objArr[0] = str4;
                    objArr[1] = str5;
                    objArr[2] = str6;
                    objArr[3] = a16[3];
                    return objArr;
                }
                if (intValue != 2) {
                    if (intValue != 3) {
                        return null;
                    }
                    if (this.E.get(0).f249772a.msg_flag.has()) {
                        long j3 = this.E.get(0).f249772a.msg_flag.get();
                        if ((j3 & 2) == 2) {
                            str2 = "[\u6709\u4eba@\u6211]";
                        }
                        String str7 = "[\u79bb\u7ebf\u6d88\u606f]" + str2 + a16[2] + ":" + a16[1];
                        String str8 = a16[5] + "[\u79bb\u7ebf\u6d88\u606f]";
                        String str9 = str2 + a16[2] + ":" + a16[1];
                        objArr[0] = str7;
                        objArr[1] = str8;
                        objArr[2] = str9;
                        objArr[3] = a16[3];
                        return objArr;
                    }
                    str2 = "";
                    String str72 = "[\u79bb\u7ebf\u6d88\u606f]" + str2 + a16[2] + ":" + a16[1];
                    String str82 = a16[5] + "[\u79bb\u7ebf\u6d88\u606f]";
                    String str92 = str2 + a16[2] + ":" + a16[1];
                    objArr[0] = str72;
                    objArr[1] = str82;
                    objArr[2] = str92;
                    objArr[3] = a16[3];
                    return objArr;
                }
            }
            String str10 = "[\u79bb\u7ebf\u6d88\u606f]" + a16[2] + ":" + a16[1];
            String str11 = a16[2] + "[\u79bb\u7ebf\u6d88\u606f]";
            String str12 = (String) a16[1];
            objArr[0] = str10;
            objArr[1] = str11;
            objArr[2] = str12;
            objArr[3] = a16[3];
            return objArr;
        }
        int m3 = m();
        if (m3 == 1 && !z16) {
            Object[] a17 = a(this.E.get(r1.size() - 1).f249772a);
            if (a17 == null) {
                return null;
            }
            Object[] objArr2 = new Object[4];
            int intValue2 = ((Integer) a17[0]).intValue();
            if (intValue2 != 0) {
                if (intValue2 == 1) {
                    int h16 = h();
                    if (h16 == 1) {
                        String str13 = "[\u79bb\u7ebf\u6d88\u606f]" + a17[2] + "(" + a17[4] + "):" + a17[1];
                        String str14 = a17[4] + "[" + this.E.size() + "\u6761\u79bb\u7ebf\u6d88\u606f]";
                        String str15 = a17[2] + ":" + a17[1];
                        objArr2[0] = str13;
                        objArr2[1] = str14;
                        objArr2[2] = str15;
                        objArr2[3] = a17[3];
                        return objArr2;
                    }
                    objArr2[2] = "\u6709" + h16 + "\u4e2a\u8054\u7cfb\u4eba\u7ed9\u4f60\u53d1\u6765" + this.E.size() + "\u6761\u79bb\u7ebf\u6d88\u606f";
                    objArr2[3] = a17[3];
                    objArr2[1] = "QQ[\u79bb\u7ebf\u6d88\u606f]";
                    objArr2[0] = "[\u79bb\u7ebf\u6d88\u606f]" + a17[2] + "(" + a17[4] + "):" + a17[1];
                    return objArr2;
                }
                if (intValue2 != 2) {
                    if (intValue2 != 3) {
                        return null;
                    }
                    if (this.E.get(0).f249772a.msg_flag.has()) {
                        ArrayList<j> arrayList = this.E;
                        long j16 = arrayList.get(arrayList.size() - 1).f249772a.msg_flag.get();
                        if ((j16 & 2) == 2) {
                            str3 = "[\u6709\u4eba@\u6211]";
                        } else if ((j16 & 1) == 1) {
                            str3 = "[\u7279\u522b\u5173\u6ce8]";
                        }
                    }
                    String str16 = "[\u79bb\u7ebf\u6d88\u606f]" + str3 + a17[2] + ":" + a17[1];
                    String str17 = a17[5] + "[" + this.E.size() + "\u6761\u79bb\u7ebf\u6d88\u606f]";
                    String str18 = str3 + a17[2] + ":" + a17[1];
                    objArr2[0] = str16;
                    objArr2[1] = str17;
                    objArr2[2] = str18;
                    objArr2[3] = a17[3];
                    return objArr2;
                }
            }
            String str19 = "[\u79bb\u7ebf\u6d88\u606f]" + a17[2] + ":" + a17[1];
            String str20 = a17[2] + "[" + this.E.size() + "\u6761\u79bb\u7ebf\u6d88\u606f]";
            String str21 = (String) a17[1];
            objArr2[0] = str19;
            objArr2[1] = str20;
            objArr2[2] = str21;
            objArr2[3] = a17[3];
            return objArr2;
        }
        ArrayList<j> arrayList2 = this.E;
        Object[] a18 = a(arrayList2.get(arrayList2.size() - 1).f249772a);
        if (a18 == null) {
            return null;
        }
        int intValue3 = ((Integer) a18[0]).intValue();
        if (intValue3 != 0) {
            if (intValue3 == 1) {
                return new Object[]{"[\u79bb\u7ebf\u6d88\u606f]" + a18[2] + "(" + a18[4] + "):" + a18[1], "QQ[\u79bb\u7ebf\u6d88\u606f]", "\u6709" + m3 + "\u4e2a\u8054\u7cfb\u4eba\u7ed9\u4f60\u53d1\u6765" + this.E.size() + "\u6761\u79bb\u7ebf\u6d88\u606f", a18[3]};
            }
            if (intValue3 != 2) {
                if (intValue3 != 3) {
                    return null;
                }
                if (this.E.get(0).f249772a.msg_flag.has()) {
                    ArrayList<j> arrayList3 = this.E;
                    long j17 = arrayList3.get(arrayList3.size() - 1).f249772a.msg_flag.get();
                    if ((j17 & 2) == 2) {
                        str = "[\u6709\u4eba@\u6211]";
                    } else if ((j17 & 1) == 1) {
                        str = "[\u7279\u522b\u5173\u6ce8]";
                    }
                    return new Object[]{"[\u79bb\u7ebf\u6d88\u606f]" + str + a18[2] + ":" + a18[1], "QQ[\u79bb\u7ebf\u6d88\u606f]", "\u6709" + m3 + "\u4e2a\u8054\u7cfb\u4eba\u7ed9\u4f60\u53d1\u6765" + this.E.size() + "\u6761\u79bb\u7ebf\u6d88\u606f", a18[3]};
                }
                str = "";
                return new Object[]{"[\u79bb\u7ebf\u6d88\u606f]" + str + a18[2] + ":" + a18[1], "QQ[\u79bb\u7ebf\u6d88\u606f]", "\u6709" + m3 + "\u4e2a\u8054\u7cfb\u4eba\u7ed9\u4f60\u53d1\u6765" + this.E.size() + "\u6761\u79bb\u7ebf\u6d88\u606f", a18[3]};
            }
        }
        return new Object[]{"[\u79bb\u7ebf\u6d88\u606f]" + a18[2] + ":" + a18[1], "QQ[\u79bb\u7ebf\u6d88\u606f]", "\u6709" + m3 + "\u4e2a\u8054\u7cfb\u4eba\u7ed9\u4f60\u53d1\u6765" + this.E.size() + "\u6761\u79bb\u7ebf\u6d88\u606f", a18[3]};
    }

    public synchronized void a(PushRegisterInfo pushRegisterInfo, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) pushRegisterInfo, (Object) toServiceMsg);
            return;
        }
        String b16 = n.b(toServiceMsg);
        if (a(b16, BaseApplication.getContext().getPackageName())) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "recv processName:" + b16 + " recv unRegisterPush ");
            }
            if (!this.f249742i.containsKey(b16)) {
                this.f249742i.putIfAbsent(b16, new com.tencent.mobileqq.msf.core.push.a(b16));
            }
            this.f249742i.get(b16).f249597k = pushRegisterInfo;
            this.f249742i.get(b16).f249587a = toServiceMsg.getAppId();
            this.f249742i.get(b16).f249589c = 0L;
            this.f249743j.a(this.f249742i.get(b16), toServiceMsg, true, RegPushReason.appRegister);
            ArrayList<Long> arrayList = this.f249742i.get(b16).f249597k.pushIds;
            ArrayList<Long> arrayList2 = pushRegisterInfo.pushIds;
            ArrayList<Long> arrayList3 = new ArrayList<>();
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                if (!arrayList2.contains(Long.valueOf(longValue))) {
                    arrayList3.add(Long.valueOf(longValue));
                }
            }
            this.f249742i.get(b16).f249597k.pushIds = arrayList3;
            if (this.f249742i.get(b16).f249589c == 0) {
                this.f249742i.get(b16).f249597k = null;
            }
            f(b16);
        } else if (QLog.isColorLevel()) {
            QLog.e(f249709e0, 2, "recv other processName:" + b16 + " recv unRegisterPush ");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(offlinepush.PbPushOffMsg pbPushOffMsg) {
        String str;
        Bitmap decodeResource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) pbPushOffMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "onRecvDevlockQuickloginOfflinePush start...");
        }
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (pbPushOffMsg.msg_str.has()) {
            str = new String(pbPushOffMsg.msg_str.get().toByteArray(), "utf-8");
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "onRecvDevlockQuickloginOfflinePush  maintip:" + str);
            }
            BaseApplication context = BaseApplication.getContext();
            decodeResource = BitmapFactory.decodeResource(context.getResources(), BaseApplication.devlockQuickloginIcon);
            if (decodeResource != null) {
                decodeResource = a(decodeResource, 50, 50);
            }
            NotificationCompat.Builder when = new NotificationCompat.Builder(context).setContentTitle("\u4e00\u952e\u9a8c\u8bc1").setContentText(str).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker("\u4e00\u952e\u9a8c\u8bc1").setWhen(System.currentTimeMillis());
            if (decodeResource == null) {
                when.setLargeIcon(decodeResource);
            } else {
                when.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), BaseApplication.qqlaunchicon));
            }
            int i3 = Build.VERSION.SDK_INT;
            Intent intent = new Intent(f249727w0);
            int i16 = i3 <= 23 ? 201326592 : 134217728;
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, i16);
            intent.putExtra(QQNotificationManager.PARAM_FROMUIN, pbPushOffMsg.from_uin.get());
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 480);
            when.setContentIntent(broadcast);
            when.setDeleteIntent(PendingIntent.getBroadcast(context, 0, new Intent(f249730z0), i16));
            Notification build = when.build();
            if (this.I == null) {
                this.I = QQNotificationManager.getInstance();
            }
            this.I.cancel(f249709e0, 480);
            QQNotificationManager.addChannelIfNeed(build, QQNotificationManager.CHANNEL_ID_OTHER);
            this.I.notify(f249709e0, 480, build);
            this.f249733b.removeMessages(I0);
            this.f249733b.sendEmptyMessageDelayed(I0, 120000L);
        }
        str = null;
        if (QLog.isColorLevel()) {
        }
        BaseApplication context2 = BaseApplication.getContext();
        decodeResource = BitmapFactory.decodeResource(context2.getResources(), BaseApplication.devlockQuickloginIcon);
        if (decodeResource != null) {
        }
        NotificationCompat.Builder when2 = new NotificationCompat.Builder(context2).setContentTitle("\u4e00\u952e\u9a8c\u8bc1").setContentText(str).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker("\u4e00\u952e\u9a8c\u8bc1").setWhen(System.currentTimeMillis());
        if (decodeResource == null) {
        }
        int i36 = Build.VERSION.SDK_INT;
        Intent intent2 = new Intent(f249727w0);
        if (i36 <= 23) {
        }
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context2, 0, intent2, i16);
        intent2.putExtra(QQNotificationManager.PARAM_FROMUIN, pbPushOffMsg.from_uin.get());
        intent2.putExtra(QQNotificationManager.PARAM_NOTIFYID, 480);
        when2.setContentIntent(broadcast2);
        when2.setDeleteIntent(PendingIntent.getBroadcast(context2, 0, new Intent(f249730z0), i16));
        Notification build2 = when2.build();
        if (this.I == null) {
        }
        this.I.cancel(f249709e0, 480);
        QQNotificationManager.addChannelIfNeed(build2, QQNotificationManager.CHANNEL_ID_OTHER);
        this.I.notify(f249709e0, 480, build2);
        this.f249733b.removeMessages(I0);
        this.f249733b.sendEmptyMessageDelayed(I0, 120000L);
    }

    public synchronized void a(CommandCallbackerInfo commandCallbackerInfo, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) commandCallbackerInfo, (Object) toServiceMsg);
            return;
        }
        String b16 = n.b(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "recv processName:" + b16 + " appCmdCallbacker " + commandCallbackerInfo);
        }
        if (!this.f249742i.containsKey(b16)) {
            this.f249742i.putIfAbsent(b16, new com.tencent.mobileqq.msf.core.push.a(b16));
        }
        this.f249742i.get(b16).f249599m = commandCallbackerInfo;
        FromServiceMsg a16 = n.a(toServiceMsg);
        a16.setMsgSuccess();
        this.f249731a.addRespToQuque(toServiceMsg, a16);
        f(b16);
    }

    public synchronized void a(com.tencent.mobileqq.msf.sdk.n nVar, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) nVar, (Object) toServiceMsg);
            return;
        }
        QLog.d(f249709e0, 1, "recv proxyRegister sendProcess=" + n.b(toServiceMsg) + " registerProcess" + nVar.f250621b + " callbacker=" + nVar.f250624e + " appid=" + nVar.f250620a + " ProxyRegisterInfo=" + nVar);
        if (!this.f249742i.containsKey(nVar.f250621b)) {
            ConcurrentHashMap<String, com.tencent.mobileqq.msf.core.push.a> concurrentHashMap = this.f249742i;
            String str = nVar.f250621b;
            concurrentHashMap.putIfAbsent(str, new com.tencent.mobileqq.msf.core.push.a(str));
        }
        com.tencent.mobileqq.msf.core.push.a aVar = this.f249742i.get(nVar.f250621b);
        aVar.f249587a = nVar.f250620a;
        aVar.f249599m = nVar.f250624e;
        aVar.f249598l = nVar.f250623d;
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(toServiceMsg);
        a16.setMsgSuccess();
        this.f249731a.addRespToQuque(toServiceMsg, a16);
        f(nVar.f250621b);
    }

    private boolean b() {
        if (com.tencent.qphone.base.util.a.d()) {
            return true;
        }
        return com.tencent.qphone.base.util.a.a() && com.tencent.qphone.base.util.a.b();
    }

    private boolean b(offlinepush.PbPushOffMsg pbPushOffMsg) {
        if (QLog.isDevelopLevel()) {
            QLog.d(f249709e0, 4, "onRecvPbPushOffMsg msg_type:0x" + Integer.toHexString(pbPushOffMsg.msg_type.get()) + " dwViedoType:" + pbPushOffMsg.dwViedoType.get());
        }
        return pbPushOffMsg.msg_type.get() == 734 || pbPushOffMsg.msg_type.get() == 215 || pbPushOffMsg.msg_type.get() == 519 || pbPushOffMsg.msg_type.get() == 562;
    }

    private Object[] b(int i3, String str) {
        return new Object[]{Integer.valueOf(i3), str};
    }

    public int b(String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this, (Object) str, (Object) context)).intValue();
        }
        if (str == null) {
            return 1;
        }
        try {
            return Integer.parseInt(context.getSharedPreferences(str, 4).getString(this.X, String.valueOf(1)));
        } catch (Exception e16) {
            e16.printStackTrace();
            return 1;
        }
    }

    public synchronized void a(String str, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) toServiceMsg);
            return;
        }
        QLog.d(f249709e0, 1, "recv processName:" + n.b(toServiceMsg) + " recv proxyUnRegister " + str);
        this.f249742i.remove(str);
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(toServiceMsg);
        a16.setMsgSuccess();
        this.f249731a.addRespToQuque(toServiceMsg, a16);
        MsfStore.getNativeConfigStore().removeConfig(f249708d0 + str);
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f249709e0, 2, "MSF onNotificationQQWiFi=" + str);
        }
        BaseApplication.getContext().startActivity(new Intent(str));
    }

    private boolean a(String str, String str2) {
        if (!str.equals(str2)) {
            if (!str.equals(str2 + MsfConstants.PROCESS_VIDEO)) {
                if (!str.equals(str2 + ":QQ")) {
                    if (!str.equals(str2 + ":nearby_video")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "clearDevlockQuickloginNotification");
        }
        if (this.I == null) {
            this.I = QQNotificationManager.getInstance();
        }
        this.I.cancel(f249709e0, 480);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084 A[Catch: Exception -> 0x0079, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0079, blocks: (B:27:0x0063, B:35:0x0084), top: B:26:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.tencent.qphone.base.a aVar) {
        String str;
        long elapsedRealtime;
        long j3;
        String str2;
        boolean z16;
        long j16;
        boolean z17;
        long j17;
        String str3;
        long j18;
        String str4;
        long j19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) aVar);
            return;
        }
        boolean isColorLevel = QLog.isColorLevel();
        String str5 = f249709e0;
        if (isColorLevel) {
            QLog.d(f249709e0, 2, "onConnClosed " + aVar);
        }
        try {
            elapsedRealtime = SystemClock.elapsedRealtime();
            j3 = this.f249759z;
        } catch (Exception e16) {
            e = e16;
            str = str5;
        }
        if (j3 > 0) {
            long j26 = this.D;
            if (j26 > 0) {
                if (j3 > j26) {
                    j16 = elapsedRealtime - j3;
                    z16 = true;
                } else {
                    j16 = 0;
                    z16 = false;
                }
                str2 = "2";
                z17 = true;
                j17 = this.A;
                if (j17 <= 0) {
                    str3 = f249709e0;
                    try {
                        j19 = this.D;
                    } catch (Exception e17) {
                        e = e17;
                        str = str3;
                        QLog.d(str, 1, "onCloseConn's report error! ", e);
                        f249718n0 = false;
                        this.f249743j.f249699b = false;
                        this.f249758y = 0L;
                        this.C = 0L;
                        this.D = 0L;
                        this.f249759z = 0L;
                        this.A = 0L;
                        this.B = 0L;
                        f249715k0 = 0L;
                        this.f249738e.post(new e());
                    }
                    if (j19 > 0) {
                        if (j17 > j19) {
                            j16 = elapsedRealtime - j17;
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        z17 = true;
                        j18 = j16;
                        str4 = "4";
                        if (z17) {
                            str5 = str3;
                            QLog.d(str5, 1, "t1:" + this.f249759z + ",t2:" + this.A + ",t3:" + this.D + ",t4:" + elapsedRealtime);
                            String e18 = MsfService.getCore().getAccountCenter().e();
                            if (this.f249731a.getStatReporter() != null) {
                                str = str5;
                                try {
                                    this.f249731a.getStatReporter().a(str4, e18, z16, j18, this.f249759z, this.A, this.B, this.D, elapsedRealtime);
                                } catch (Exception e19) {
                                    e = e19;
                                    QLog.d(str, 1, "onCloseConn's report error! ", e);
                                    f249718n0 = false;
                                    this.f249743j.f249699b = false;
                                    this.f249758y = 0L;
                                    this.C = 0L;
                                    this.D = 0L;
                                    this.f249759z = 0L;
                                    this.A = 0L;
                                    this.B = 0L;
                                    f249715k0 = 0L;
                                    this.f249738e.post(new e());
                                }
                            }
                        }
                        f249718n0 = false;
                        this.f249743j.f249699b = false;
                        this.f249758y = 0L;
                        this.C = 0L;
                        this.D = 0L;
                        this.f249759z = 0L;
                        this.A = 0L;
                        this.B = 0L;
                        f249715k0 = 0L;
                        this.f249738e.post(new e());
                    }
                } else {
                    str3 = f249709e0;
                }
                j18 = j16;
                str4 = str2;
                if (z17) {
                }
                f249718n0 = false;
                this.f249743j.f249699b = false;
                this.f249758y = 0L;
                this.C = 0L;
                this.D = 0L;
                this.f249759z = 0L;
                this.A = 0L;
                this.B = 0L;
                f249715k0 = 0L;
                this.f249738e.post(new e());
            }
        }
        str2 = "0";
        z16 = true;
        j16 = 0;
        z17 = false;
        j17 = this.A;
        if (j17 <= 0) {
        }
        j18 = j16;
        str4 = str2;
        if (z17) {
        }
        f249718n0 = false;
        this.f249743j.f249699b = false;
        this.f249758y = 0L;
        this.C = 0L;
        this.D = 0L;
        this.f249759z = 0L;
        this.A = 0L;
        this.B = 0L;
        f249715k0 = 0L;
        this.f249738e.post(new e());
    }

    public int c(String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this, (Object) str, (Object) context)).intValue();
        }
        if (str == null) {
            return 1;
        }
        try {
            return Integer.parseInt(context.getSharedPreferences(str, 4).getString(this.Y, String.valueOf(1)));
        } catch (Exception e16) {
            e16.printStackTrace();
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Intent intent) {
        com.tencent.mobileqq.msf.core.c0.e netFlowStore = this.f249731a.getNetFlowStore();
        if (netFlowStore != null) {
            if (QLog.isColorLevel()) {
                netFlowStore.a(context, intent);
            } else if (this.f249753t) {
                netFlowStore.a(context, intent);
            }
        }
        this.f249753t = !this.f249753t;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, j3);
            return;
        }
        long j16 = 30000;
        if (j3 < 30000) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "queryPushIntervTime less than 30000,change to 30000.");
            }
        } else {
            j16 = 3600000;
            if (j3 > 3600000) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249709e0, 2, "queryPushIntervTime greater than 600000 ,change to 600000.");
                }
            }
            if (this.f249744k != null) {
                b(BaseApplication.getContext());
            }
            Intent intent = new Intent(this.f249740g);
            intent.setAction(this.f249740g);
            this.f249744k = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, intent, Build.VERSION.SDK_INT <= 23 ? 201326592 : 134217728);
            this.f249745l = (AlarmManager) BaseApplication.getContext().getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
            long currentTimeMillis = System.currentTimeMillis() + j3;
            if (!com.tencent.mobileqq.msf.core.x.b.h()) {
                try {
                    QLog.d(f249709e0, 1, "register alarm with setAndAllowWhileIdle, intent:" + this.f249744k);
                    Method declaredMethod = AlarmManager.class.getDeclaredMethod("setAndAllowWhileIdle", Integer.TYPE, Long.TYPE, PendingIntent.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f249745l, 0, Long.valueOf(currentTimeMillis), this.f249744k);
                } catch (Exception e16) {
                    QLog.e(f249709e0, 1, "MSF_Alive_Log doRegistertAlarm excep!", e16);
                    try {
                        QLog.d(f249709e0, 1, "register alarm, intent:" + this.f249744k);
                        this.f249745l.set(0, currentTimeMillis, this.f249744k);
                    } catch (Exception e17) {
                        QLog.e(f249709e0, 1, "MSF_Alive_Log doRegistertAlarm excep throw et!", e17);
                    }
                }
            } else {
                try {
                    QLog.d(f249709e0, 1, "register alarm, intent:" + this.f249744k);
                    this.f249745l.set(0, currentTimeMillis, this.f249744k);
                } catch (Exception e18) {
                    QLog.e(f249709e0, 1, "MSF_Alive_Log doRegistertAlarm excep throw et!", e18);
                }
            }
            if (QLog.isColorLevel()) {
                return;
            }
            QLog.d(f249709e0, 2, "MSF_Alive_Log register " + this.f249740g + " alarm alive send at " + f249713i0.format(Long.valueOf(currentTimeMillis)));
            return;
        }
        j3 = j16;
        if (this.f249744k != null) {
        }
        Intent intent2 = new Intent(this.f249740g);
        intent2.setAction(this.f249740g);
        this.f249744k = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, intent2, Build.VERSION.SDK_INT <= 23 ? 201326592 : 134217728);
        this.f249745l = (AlarmManager) BaseApplication.getContext().getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
        long currentTimeMillis2 = System.currentTimeMillis() + j3;
        if (!com.tencent.mobileqq.msf.core.x.b.h()) {
        }
        if (QLog.isColorLevel()) {
        }
    }

    public boolean a(com.tencent.mobileqq.msf.core.push.a aVar, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) aVar, (Object) fromServiceMsg)).booleanValue();
        }
        CommandCallbackerInfo commandCallbackerInfo = aVar.f249599m;
        boolean z16 = false;
        if (commandCallbackerInfo != null && commandCallbackerInfo.uin.equals(fromServiceMsg.getUin())) {
            Iterator<String> it = aVar.f249599m.cmds.iterator();
            while (it.hasNext()) {
                if (it.next().equals(fromServiceMsg.getServiceCmd())) {
                    if (!fromServiceMsg.getServiceCmd().startsWith("ConfigPushSvc")) {
                        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP, 1);
                    }
                    MsfSdkUtils.addFromMsgProcessName(aVar.f249588b, fromServiceMsg);
                    fromServiceMsg.setMsfCommand(MsfCommand.onRecvPushMsg);
                    if (QLog.isColorLevel()) {
                        QLog.d(f249709e0, 2, "handleCmdPush " + aVar.f249588b + " " + fromServiceMsg.getShortStringForLog());
                    }
                    this.f249731a.addRespToQuque(aVar.f249588b, null, fromServiceMsg);
                    z16 = true;
                }
            }
        }
        return z16;
    }

    public void a(com.tencent.mobileqq.msf.core.push.a aVar, RegPushReason regPushReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) aVar, (Object) regPushReason);
            return;
        }
        if (aVar.f249589c > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "send " + aVar.f249588b + " push register, pushId is " + aVar.f249589c);
            }
            this.f249743j.a(aVar, null, false, regPushReason);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, aVar.f249588b + " queryPushId is " + aVar.f249589c + " ,skip register.");
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            this.f249743j.a(toServiceMsg, fromServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    public void a(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.C = j3;
            b(j16);
        }
    }

    public void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            this.f249743j.a(fromServiceMsg, toServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) fromServiceMsg, (Object) toServiceMsg);
        }
    }

    public static Bitmap a(Bitmap bitmap, float f16, int i3, int i16) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            if (bitmap == null) {
                return null;
            }
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect2 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Matrix matrix = new Matrix();
            matrix.setRectToRect(new RectF(rect), new RectF(rect2), Matrix.ScaleToFit.FILL);
            canvas.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true), rect2, rect2, paint);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i3, int i16) {
        double d16;
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int i17 = (i3 + i16) / 2;
        double d17 = f16;
        int i18 = (int) (4.0d * d17);
        if (i17 > 70) {
            if (i17 > 100) {
                if (i17 <= 128) {
                    d16 = 8.0d;
                } else {
                    i18 = (int) ((((i3 / 100) * 4) + 8) * f16);
                }
            }
            return a(bitmap, i18, (int) (i3 * f16), (int) (i16 * f16));
        }
        d16 = 2.0d;
        i18 = (int) (d17 * d16);
        return a(bitmap, i18, (int) (i3 * f16), (int) (i16 * f16));
    }

    private int a(int i3, int i16) {
        if (i3 != 9 && i3 != 10 && i3 != 16 && i3 != 17 && i3 != 31 && i3 != 79 && i3 != 97 && i3 != 120 && i3 != 208) {
            if (i3 == 215 || i3 == 519) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        switch (i16) {
                            case 11:
                                break;
                            case 12:
                                break;
                            case 13:
                                return 1;
                            default:
                                if (QLog.isColorLevel()) {
                                    QLog.d(f249709e0, 2, "onRecvPbPushOffMsg unknow dwVideoType:" + i16);
                                }
                                return -1;
                        }
                    }
                    return 2;
                }
            } else if (i3 != 529 && i3 != 562 && i3 != 734) {
                if (i3 != 42) {
                    if (i3 == 43 || i3 == 82) {
                        return 3;
                    }
                    if (i3 != 83) {
                        if (i3 != 132 && i3 != 133) {
                            if (i3 == 140 || i3 == 141) {
                                return 2;
                            }
                            if (i3 != 166 && i3 != 167) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(f249709e0, 2, "onRecvPbPushOffMsg unknow msgtype:" + i3);
                                }
                                return -1;
                            }
                        }
                    }
                }
                return 1;
            }
        }
        return 0;
    }

    private Object[] a(offlinepush.PbPushOffMsg pbPushOffMsg) {
        String l3;
        String str;
        String l16;
        Object[] objArr = new Object[6];
        String str2 = null;
        if (pbPushOffMsg.msg_str.has()) {
            String stringUtf8 = pbPushOffMsg.msg_str.get().toStringUtf8();
            int a16 = a(pbPushOffMsg.msg_type.get(), pbPushOffMsg.dwViedoType.get());
            this.f249747n = a16;
            String str3 = "";
            if (a16 == 0) {
                if (pbPushOffMsg.from_nick.has() && pbPushOffMsg.from_nick.get().toStringUtf8().length() != 0) {
                    l3 = pbPushOffMsg.from_nick.get().toStringUtf8();
                } else {
                    l3 = Long.toString(pbPushOffMsg.from_uin.get());
                }
                if (pbPushOffMsg.from_uin.has()) {
                    pbPushOffMsg.from_uin.get();
                    str3 = a(0, "" + pbPushOffMsg.from_uin.get());
                }
            } else {
                if (a16 != 1) {
                    if (a16 != 2) {
                        if (a16 != 3) {
                            return null;
                        }
                        if (pbPushOffMsg.group_info.has()) {
                            if (pbPushOffMsg.group_info.group_card.has()) {
                                l3 = pbPushOffMsg.group_info.group_card.get().toStringUtf8();
                            } else {
                                l3 = Long.toString(pbPushOffMsg.from_uin.get());
                            }
                            str = pbPushOffMsg.group_info.group_name.has() ? pbPushOffMsg.group_info.group_name.get().toStringUtf8() : null;
                            if (pbPushOffMsg.group_info.group_code.has()) {
                                long j3 = pbPushOffMsg.group_info.group_code.get();
                                if (str == null || str.length() == 0) {
                                    str = Long.toString(j3);
                                }
                                str3 = a(1, "" + j3);
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(f249709e0, 2, "onRecvPbPushOffMsg get troop msg, but no msg.group_info exit");
                            }
                            return null;
                        }
                    } else if (pbPushOffMsg.c2c_tmp_msg_head.has()) {
                        if (pbPushOffMsg.from_nick.has() && pbPushOffMsg.from_nick.get().toStringUtf8().length() != 0) {
                            l3 = pbPushOffMsg.from_nick.get().toStringUtf8();
                        } else if (pbPushOffMsg.c2c_tmp_msg_head.discuss_remark.has()) {
                            l3 = pbPushOffMsg.c2c_tmp_msg_head.discuss_remark.get().toStringUtf8();
                        } else if (pbPushOffMsg.c2c_tmp_msg_head.group_card.has()) {
                            l3 = pbPushOffMsg.c2c_tmp_msg_head.group_card.get().toStringUtf8();
                        } else if (pbPushOffMsg.c2c_tmp_msg_head.group_name.has()) {
                            l3 = pbPushOffMsg.c2c_tmp_msg_head.group_name.get().toStringUtf8();
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(f249709e0, 2, "onRecvPbPushOffMsg get c2c temp msg, no nick find use from_uin");
                            }
                            l3 = Long.toString(pbPushOffMsg.from_uin.get());
                        }
                        if (pbPushOffMsg.c2c_tmp_msg_head.group_uin.has()) {
                            str3 = a(3, "" + pbPushOffMsg.c2c_tmp_msg_head.group_uin.get());
                        } else if (pbPushOffMsg.c2c_tmp_msg_head.group_code.has()) {
                            str3 = a(3, "" + pbPushOffMsg.c2c_tmp_msg_head.group_code.get());
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(f249709e0, 2, "onRecvPbPushOffMsg get c2c temp msg, but no msg.c2c_tmp_msg_head exit");
                        }
                        return null;
                    }
                } else if (pbPushOffMsg.discuss_info.has()) {
                    if (pbPushOffMsg.discuss_info.discuss_remark.has()) {
                        l3 = pbPushOffMsg.discuss_info.discuss_remark.get().toStringUtf8();
                    } else if (pbPushOffMsg.from_nick.has()) {
                        l3 = pbPushOffMsg.from_nick.get().toStringUtf8();
                    } else {
                        l3 = Long.toString(pbPushOffMsg.from_uin.get());
                    }
                    if (pbPushOffMsg.discuss_info.dis_name.has()) {
                        l16 = pbPushOffMsg.discuss_info.dis_name.get().toStringUtf8();
                    } else {
                        l16 = Long.toString(pbPushOffMsg.discuss_info.discuss_uin.get());
                    }
                    if (pbPushOffMsg.discuss_info.discuss_uin.has()) {
                        long j16 = pbPushOffMsg.discuss_info.discuss_uin.get();
                        if (l16 == null || l16.length() == 0) {
                            l16 = Long.toString(j16);
                        }
                        str3 = a(3, "" + j16);
                    }
                    String str4 = l16;
                    str = null;
                    str2 = str4;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(f249709e0, 2, "onRecvPbPushOffMsg get discuss msg, but no msg.discuss_info exit");
                    }
                    return null;
                }
                objArr[0] = Integer.valueOf(a16);
                objArr[1] = stringUtf8;
                objArr[2] = l3;
                objArr[3] = str3;
                objArr[4] = str2;
                objArr[5] = str;
                return objArr;
            }
            str = null;
            objArr[0] = Integer.valueOf(a16);
            objArr[1] = stringUtf8;
            objArr[2] = l3;
            objArr[3] = str3;
            objArr[4] = str2;
            objArr[5] = str;
            return objArr;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249709e0, 2, "onRecvPbPushOffMsg no msg str exit");
        }
        return null;
    }

    @RequiresApi(api = 26)
    private void a(boolean z16) {
        int size;
        if (this.E.size() > 0) {
            offlinepush.PbPushOffMsg pbPushOffMsg = this.E.get(0).f249772a;
            BaseApplication context = BaseApplication.getContext();
            Object[] b16 = b(z16);
            if (b16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249709e0, 2, "Decode Message error, exit now");
                    return;
                }
                return;
            }
            String str = (String) b16[0];
            String str2 = (String) b16[1];
            String str3 = (String) b16[2];
            Bitmap decodeFile = BitmapFactory.decodeFile((String) b16[3]);
            if (decodeFile != null) {
                decodeFile = a(decodeFile, 50, 50);
            }
            NotificationCompat.Builder when = new NotificationCompat.Builder(context).setContentTitle(str2).setContentText(str3).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker(str).setWhen(System.currentTimeMillis());
            if (decodeFile != null) {
                when.setLargeIcon(decodeFile);
            } else {
                when.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), BaseApplication.qqlaunchicon));
            }
            int i3 = Build.VERSION.SDK_INT;
            if (a(context, pbPushOffMsg.to_uin.get())) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249709e0, 2, "isShowNofityLight=true");
                }
                Calendar.getInstance().get(11);
                when.setLights(-16711936, 2000, 2000);
            }
            Intent intent = new Intent(f249727w0);
            intent.putExtra(QQNotificationManager.PARAM_FROMUIN, pbPushOffMsg.from_uin.get());
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 478);
            intent.setPackage(BaseApplication.getContext().getPackageName());
            int i16 = i3 > 23 ? 201326592 : 134217728;
            when.setContentIntent(PendingIntent.getBroadcast(context, 0, intent, i16));
            when.setDeleteIntent(PendingIntent.getBroadcast(context, 0, new Intent(f249728x0), i16));
            Notification build = when.build();
            QQNotificationManager.addChannelIfNeed(build, QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
            QQNotificationManager qQNotificationManager = this.I;
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel(f249709e0, 478);
            }
            if (this.f249749p) {
                try {
                    SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("unreadcount", 4);
                    int i17 = sharedPreferences.getInt("unread", -1);
                    if (QLog.isColorLevel()) {
                        QLog.i(BadgeUtilImpl.TAG, 2, "NOTIFICATION_ID_PUSH_MSG mIsPushOffAVShow " + this.H + "count=" + i17);
                    }
                    if (this.H) {
                        size = this.E.size();
                    } else {
                        size = this.E.size() + i17;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(BadgeUtilImpl.TAG, 2, "NOTIFICATION_ID_PUSH_MSG changeMI6Badge count=" + size);
                    }
                    if (this.H && this.G) {
                        size += sharedPreferences.getInt("unread", -1);
                    }
                    this.G = true;
                    BadgeUtilImpl.changeMI6Badge(BaseApplication.getContext(), size, build);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.i(BadgeUtilImpl.TAG, 2, "NOTIFICATION_ID_PUSH_MSG exception ex=" + th5);
                    }
                }
            }
            String valueOf = String.valueOf(pbPushOffMsg.to_uin.get());
            boolean b17 = com.tencent.mobileqq.msf.core.push.f.b(context, valueOf);
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "fireNotifition: invoked. ", " msgNotificationEnabled: ", Boolean.valueOf(b17), " toUin: ", valueOf);
            }
            if (b17) {
                if (q() && SdkInfoUtil.isOreo() && this.f249751r) {
                    this.f249751r = false;
                    QLog.d(f249709e0, 1, "HPush_msf-notification cancelAll before first notify:");
                    this.I.cancelAll();
                }
                this.I.notify(f249709e0, 478, build);
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.tencent.mobileqq_preferences", 4);
            boolean z17 = c(String.valueOf(pbPushOffMsg.to_uin.get()), context) != 0 ? c(String.valueOf(pbPushOffMsg.to_uin.get()), context) == 1 : a(String.valueOf(pbPushOffMsg.to_uin.get()), context) == 1;
            if (b(String.valueOf(pbPushOffMsg.to_uin.get()), context) == 1 && b()) {
                Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                if (a(sharedPreferences2)) {
                    vibrator.vibrate(1000L);
                } else {
                    vibrator.vibrate(G0, -1);
                }
            }
            if (z17 && a()) {
                if (QLog.isColorLevel()) {
                    QLog.i("PushManager", 2, "-->isSpecialCareSound:" + a(sharedPreferences2));
                }
                if (a(sharedPreferences2)) {
                    int i18 = defaultSharedPreferences.getInt(AppConstants.Preferences.SOUND_TYPE + pbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(AppConstants.Preferences.SPECIAL_SOUND_TYPE);
                    ArrayList<j> arrayList = this.E;
                    sb5.append(arrayList.get(arrayList.size() - 1).f249772a.to_uin.get());
                    ArrayList<j> arrayList2 = this.E;
                    sb5.append(arrayList2.get(arrayList2.size() - 1).f249772a.from_uin.get());
                    int i19 = sharedPreferences2.getInt(sb5.toString(), i18);
                    try {
                        if (i19 == 1) {
                            sharedPreferences2.getInt(AppConstants.Preferences.DEFAULT_SPECIAL_SOUND_SOURCE + i19, i19);
                        } else {
                            String string = sharedPreferences2.getString(AppConstants.Preferences.SPECIAL_SOUND_URL + i19, "");
                            if (!TextUtils.isEmpty(string)) {
                                File file = new File(BaseApplication.getContext().getFilesDir(), string);
                                if (file.exists()) {
                                    a(file.getAbsolutePath(), false);
                                    return;
                                } else if (QLog.isColorLevel()) {
                                    QLog.i("PushManager", 2, "-->special sound not exist.");
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("PushManager", 2, "special sound play exception|" + e16.getMessage());
                        }
                        e16.printStackTrace();
                    }
                }
            }
            if (a(String.valueOf(pbPushOffMsg.to_uin.get()), context) == 1 && a()) {
                a(defaultSharedPreferences.getInt(AppConstants.Preferences.SOUND_TYPE + pbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId), false);
                return;
            }
            return;
        }
        if (this.I == null) {
            this.I = QQNotificationManager.getInstance();
        }
        this.I.cancel(f249709e0, 478);
    }

    private boolean a(SharedPreferences sharedPreferences) {
        try {
            ArrayList<j> arrayList = this.E;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            offlinepush.PbPushOffMsg pbPushOffMsg = this.E.get(r0.size() - 1).f249772a;
            return sharedPreferences.contains(AppConstants.Preferences.SPECIAL_SOUND_TYPE + pbPushOffMsg.to_uin.get() + pbPushOffMsg.from_uin.get());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("PushManager", 2, "-->isSpecialCareSound...exception=" + e16.getMessage());
            }
            e16.printStackTrace();
            return false;
        }
    }

    private boolean a() {
        return com.tencent.qphone.base.util.a.a();
    }

    public synchronized void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, Boolean.valueOf(z16));
            return;
        }
        try {
            MediaPlayer mediaPlayer = this.J;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    return;
                }
                try {
                    this.J.release();
                    this.J = null;
                } catch (Exception unused) {
                    this.J = null;
                } catch (Throwable th5) {
                    this.J = null;
                    throw th5;
                }
            }
            if (this.J == null) {
                this.J = new MediaPlayer();
            }
            this.J.reset();
            this.J.setDataSource(new FileInputStream(str).getFD());
            a(this.J);
            this.J.prepare();
            this.J.setOnCompletionListener(new g());
            this.J.start();
            this.J.setLooping(z16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public synchronized void a(int i3, boolean z16) {
        MediaPlayer mediaPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        try {
            MediaPlayer mediaPlayer2 = this.J;
            if (mediaPlayer2 != null) {
                if (mediaPlayer2.isPlaying()) {
                    return;
                }
                try {
                    this.J.release();
                    this.J = null;
                } catch (Exception unused) {
                    this.J = null;
                } catch (Throwable th5) {
                    this.J = null;
                    throw th5;
                }
            }
            if (i3 != 1000) {
                this.J = a((Context) BaseApplication.getContext(), i3);
            } else {
                this.J = a(BaseApplication.getContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
            }
            mediaPlayer = this.J;
        } catch (Exception unused2) {
        }
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnCompletionListener(new C8096h());
        this.J.start();
        this.J.setLooping(z16);
    }

    public void a(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f249709e0, 4, "onRecvPbPushOffMsg getted");
        }
        if (MsfService.getCore().getUinPushStatus(fromServiceMsg.getUin()) != 95) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f249709e0, 4, "onRecvPbPushOffMsg client status:" + MsfService.getCore().getUinPushStatus(fromServiceMsg.getUin()) + " drop now");
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.msf.service.e.a()) {
            if (QLog.isDevelopLevel()) {
                QLog.d(f249709e0, 4, "onRecvPbPushOffMsg mobileqq is running drop now");
                return;
            }
            return;
        }
        Iterator<j> it = this.E.iterator();
        while (it.hasNext()) {
            if (fromServiceMsg.getRequestSsoSeq() == it.next().f249773b) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249709e0, 2, "onRecvPbPushOffMsg get duplicate msg drop now.");
                    return;
                }
                return;
            }
        }
        Iterator<j> it5 = this.F.iterator();
        while (it5.hasNext()) {
            int i3 = it5.next().f249773b;
            if (fromServiceMsg.getRequestSsoSeq() == i3) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249709e0, 2, "onRecvPbPushOffMsg get duplicate av msg drop now ssoseq:" + i3);
                    return;
                }
                return;
            }
        }
        j jVar = new j();
        try {
            offlinepush.PbPushOffMsg pbPushOffMsg = new offlinepush.PbPushOffMsg();
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            byte[] bArr = new byte[wupBuffer.length - 4];
            System.arraycopy(wupBuffer, 4, bArr, 0, wupBuffer.length - 4);
            pbPushOffMsg.mergeFrom(bArr);
            jVar.f249772a = pbPushOffMsg;
            jVar.f249773b = fromServiceMsg.getRequestSsoSeq();
            if (b(pbPushOffMsg)) {
                this.F.add(jVar);
                g();
            } else if (pbPushOffMsg.msg_type.get() == 528) {
                c(pbPushOffMsg);
            } else {
                this.E.add(jVar);
                a(false);
            }
            a(pbPushOffMsg.to_uin.get(), fromServiceMsg.getRequestSsoSeq(), pbPushOffMsg.svr_ip.get());
            BadgeUtilImpl.setBadge(BaseApplication.getContext(), BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -5) + this.E.size() + this.F.size());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "onRecvPbPushOffMsg decode error:" + e16, e16);
            }
        }
    }

    private void a(long j3, int i3, int i16) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", Long.toString(j3), BaseConstants.CMD_RESPPUSH);
        toServiceMsg.setAppId(this.f249742i.get(BaseApplication.getContext().getPackageName()).f249587a);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setRequestSsoSeq(i3);
        toServiceMsg.setNeedCallback(false);
        a.a.b.a.a.c.b bVar = new a.a.b.a.a.c.b();
        bVar.f25182a = j3;
        bVar.f25184c = i16;
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setServantName(BaseConstants.CMD_RESPPUSH);
        uniPacket.setFuncName("SvcRespPushMsg");
        uniPacket.setRequestId(i3);
        uniPacket.put("resp", bVar);
        toServiceMsg.putWupBuffer(uniPacket.encode());
        this.f249731a.sendSsoMsg(toServiceMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i3) {
        if (com.tencent.mobileqq.msf.service.e.a()) {
            QLog.d(f249710f0, 1, "stop tryActiveQQ by mainProcessReady");
            try {
                BaseApplication.getContext().unregisterReceiver(this.O);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("account", str);
            hashMap.put("retryIndex", String.valueOf(i3));
            hashMap.put("reason", "mainProcessReady");
            if (this.f249731a.getStatReporter() != null) {
                this.f249731a.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247759v0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
            this.K.set(false);
            return;
        }
        if (i3 >= com.tencent.mobileqq.msf.core.x.b.j0()) {
            QLog.d(f249710f0, 1, "stop tryActiveQQ index: " + i3);
            try {
                BaseApplication.getContext().unregisterReceiver(this.O);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("account", str);
            hashMap2.put("retryIndex", String.valueOf(i3));
            hashMap2.put("reason", "tryTooMuch");
            if (this.f249731a.getStatReporter() != null) {
                this.f249731a.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247759v0, false, 0L, 0L, (Map<String, String>) hashMap2, false, false);
            }
            this.K.set(false);
            return;
        }
        QLog.d(f249710f0, 1, "tryActiveQQ index: " + i3);
        Intent intent = new Intent(BaseApplicationImpl.bootBroadcastName);
        intent.putExtra(CoreService.KEY_START_MODE, 1);
        intent.putExtra("k_pcactive_uin", str);
        intent.putExtra("k_pcactive_retryIndex", i3);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        BaseApplication.getContext().sendBroadcast(intent);
        this.L = str;
        this.M = i3;
        Intent intent2 = new Intent(H0);
        intent2.putExtra("uin", str);
        intent2.putExtra("retryIndex", i3 + 1);
        this.N = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, intent2, Build.VERSION.SDK_INT > 23 ? 201326592 : 134217728);
        this.f249745l.set(0, System.currentTimeMillis() + 300000, this.N);
    }

    public String a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (String) iPatchRedirector.redirect((short) 52, (Object) this, i3, (Object) str);
        }
        String path = BaseApplication.getContext().getFilesDir().getPath();
        StringBuilder sb5 = new StringBuilder(256);
        if (Environment.getExternalStorageState().equals("mounted")) {
            sb5.append(this.S);
        } else {
            sb5.append(path + this.U);
        }
        Object[] b16 = b(i3, str);
        int intValue = ((Integer) b16[0]).intValue();
        if (intValue == -56) {
            sb5.append("troop_sys_");
            str = (String) b16[1];
        } else if (intValue == -55) {
            sb5.append("sys_");
            str = (String) b16[1];
        } else if (intValue == 1) {
            sb5.append("troop_");
        } else if (intValue == 3) {
            sb5.append("discussion_");
        }
        sb5.append(MD5.toMD5(MD5.toMD5(MD5.toMD5(str) + str) + str));
        sb5.append(".png");
        return sb5.toString();
    }

    public static boolean a(Context context, long j3) {
        if (!SettingCloneUtil.readValue(context, "" + j3, "\u901a\u77e5\u65f6\u6307\u793a\u706f\u95ea\u70c1", AppConstants.QQSETTING_NOTIFY_BLNCONTROL_KEY, true)) {
            return false;
        }
        boolean readValue = SettingCloneUtil.readValue(context, (String) null, AppConstants.Preferences.NO_DISTURB_MODE, AppConstants.QQSETTING_NODISTURB_MODE_KEY, false);
        if (readValue) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "onRecvPbPushOffMsg isNoDisturbMode:" + readValue);
            }
            int i3 = Calendar.getInstance().get(11);
            if (i3 >= 23 || i3 < 8) {
                return false;
            }
        }
        return true;
    }

    public int a(String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this, (Object) str, (Object) context)).intValue();
        }
        if (str == null) {
            return 1;
        }
        try {
            return Integer.parseInt(context.getSharedPreferences(str, 4).getString(this.W, String.valueOf(1)));
        } catch (Exception e16) {
            e16.printStackTrace();
            return 1;
        }
    }

    private void a(MediaPlayer mediaPlayer) {
        mediaPlayer.setAudioStreamType(k());
    }

    private MediaPlayer a(Context context, int i3) {
        try {
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(i3);
            if (openRawResourceFd == null) {
                return null;
            }
            MediaPlayer mediaPlayer = new MediaPlayer();
            a(mediaPlayer);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "createAndSetAudioStreamType  create failed:", e16);
            }
            return null;
        }
    }

    private MediaPlayer a(Context context, Uri uri) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            a(mediaPlayer);
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (IOException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(f249709e0, 2, "createAndSetAudioStreamType create failed:", e16);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(5:3|(3:10|11|(1:13)(1:14))|5|(1:7)|8)|21|22|23|(5:25|(3:27|28|(1:30)(1:31))|5|(0)|8)|38|39|(1:41)(1:42)|5|(0)|8|(1:(4:44|5|(0)|8))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        if (((java.lang.Integer) a(r1, "getCallStateGemini", (java.lang.Class<?>[]) new java.lang.Class[]{r10}, new java.lang.Object[]{1})).intValue() != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        if (((java.lang.Integer) a(r12, "getCallStateGemini", new java.lang.Object[]{1})).intValue() != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cf, code lost:
    
        if (((java.lang.Integer) a(r12, "getCallState", new java.lang.Object[]{1})).intValue() != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x006d, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        boolean z16 = true;
        if (telephonyManager != null) {
            if (SystemMethodProxy.getCallState(telephonyManager) == 0) {
                try {
                    Class cls = Integer.TYPE;
                    if (((Integer) a(telephonyManager, "getCallStateGemini", (Class<?>[]) new Class[]{cls}, new Object[]{0})).intValue() != 0) {
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f249709e0, 2, "1 isCalling Exception", e16);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f249709e0, 2, "isCalling: " + z16);
            }
            return z16;
        }
        TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone2");
        if (telephonyManager2 != null) {
            if (SystemMethodProxy.getCallState(telephonyManager2) == 0) {
                try {
                    if (((Integer) a(telephonyManager2, "getCallStateGemini", new Object[]{0})).intValue() != 0) {
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f249709e0, 2, "2 isCalling Exception", e17);
                    }
                }
            }
            if (QLog.isColorLevel()) {
            }
            return z16;
        }
        Object a16 = a("android.telephony.MSimTelephonyManager", "getDefault", (Object[]) null, (Class<?>[]) null);
        if (((Integer) a(a16, "getCallState", new Object[]{0})).intValue() != 0) {
        }
        if (QLog.isColorLevel()) {
        }
        return z16;
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Method method = obj.getClass().getMethod(str, clsArr);
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }

    static Object a(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getDeclaredMethod(str2, clsArr).invoke(cls, objArr);
    }

    static Class<?>[] a(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = objArr[i3];
            if (obj != null) {
                clsArr[i3] = obj.getClass();
            } else {
                clsArr[i3] = String.class;
            }
            Class<?> cls = clsArr[i3];
            if (cls == Integer.class) {
                clsArr[i3] = Integer.TYPE;
            } else if (cls == Boolean.class) {
                clsArr[i3] = Boolean.TYPE;
            }
        }
        return clsArr;
    }

    static Object a(Object obj, String str, Object[] objArr) throws Exception {
        return a(obj, str, a(objArr), objArr);
    }

    private void a(FromServiceMsg fromServiceMsg, com.tencent.msf.service.protocol.serverconfig.f fVar) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), BaseConstants.CMD_PUSHRESP);
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        uniPacket.setServantName("QQService.ConfigPushSvc.MainServant");
        uniPacket.setFuncName("PushResp");
        com.tencent.msf.service.protocol.serverconfig.g gVar = new com.tencent.msf.service.protocol.serverconfig.g();
        gVar.f336808b = fVar.f336805c;
        int i3 = fVar.f336803a;
        gVar.f336807a = i3;
        if (i3 == 3) {
            gVar.f336809c = fVar.f336804b;
        }
        uniPacket.put("PushResp", gVar);
        toServiceMsg.putWupBuffer(uniPacket.encode());
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setRequestSsoSeq(fromServiceMsg.getRequestSsoSeq());
        try {
            MsfService.getCore().sendSsoMsg(toServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(f249709e0, 2, "send push sso resp error " + e16, e16);
            }
        }
    }
}
