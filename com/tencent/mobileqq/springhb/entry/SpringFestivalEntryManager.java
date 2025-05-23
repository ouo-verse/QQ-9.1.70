package com.tencent.mobileqq.springhb.entry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.springhb.ad;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.c;
import com.tencent.mobileqq.springhb.entry.d;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.BreathLightData;
import com.tencent.mobileqq.springhb.entry.model.CommonData;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.springhb.entry.model.MainActivityData;
import com.tencent.mobileqq.springhb.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.springhb.entry.model.PendantData;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import com.tencent.mobileqq.springhb.entry.model.UserData;
import com.tencent.mobileqq.springhb.preload.SpringHbPreloadManager;
import com.tencent.mobileqq.springhb.preload.i;
import com.tencent.mobileqq.springhb.preload.r;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SpringFestivalEntryManager implements Manager, Handler.Callback, c {
    static IPatchRedirector $redirector_;
    public static boolean X;
    static SimpleDateFormat Y;
    private Handler C;
    private Handler D;
    private volatile int E;
    com.tencent.mobileqq.springhb.config.g F;
    private b G;
    private volatile MsgTabBannerData H;
    private volatile BaseActivityData I;
    private volatile MainActivityData J;
    private long K;
    private volatile boolean L;
    private volatile boolean M;
    private volatile boolean N;
    private volatile boolean P;
    private com.tencent.mobileqq.springhb.entry.model.b Q;
    private Object R;
    private Object S;
    private long T;
    private long U;
    private int V;
    private boolean W;

    /* renamed from: d, reason: collision with root package name */
    private volatile EntryConfigBean f289058d;

    /* renamed from: e, reason: collision with root package name */
    private volatile UserData f289059e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f289060f;

    /* renamed from: h, reason: collision with root package name */
    public volatile int f289061h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f289062i;

    /* renamed from: m, reason: collision with root package name */
    private List<d.a> f289063m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class TaskCallbackNotNullWrapper implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Runnable f289077d;

        public TaskCallbackNotNullWrapper(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) runnable);
            } else {
                this.f289077d = runnable;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (SpringFestivalEntryManager.this.G != null) {
                this.f289077d.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements Comparator<d.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d.a aVar, d.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
            }
            return com.tencent.mobileqq.springhb.b.b(aVar.f289084b, aVar2.f289084b);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75302);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 50)) {
            redirector.redirect((short) 50);
        } else {
            X = false;
            Y = new SimpleDateFormat("yyyy_MM_dd");
        }
    }

    public SpringFestivalEntryManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f289060f = false;
        this.f289061h = 0;
        this.f289062i = false;
        this.E = 0;
        this.N = true;
        this.P = false;
        this.R = new Object();
        this.S = new Object();
        this.V = 1;
        this.W = false;
        this.f289063m = Collections.synchronizedList(new LinkedList());
        this.D = new Handler(ThreadManagerV2.getUIHandlerV2().getLooper());
        this.C = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), this);
        this.F = (com.tencent.mobileqq.springhb.config.g) qQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
        p0(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    SpringFestivalEntryManager.this.j0();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    private void C() {
        QLog.i("SpringHb_SpringFestivalEntryManager", 1, "generateTasksAndLaunch," + (System.currentTimeMillis() - this.K));
        this.K = System.currentTimeMillis();
        this.L = false;
        p0(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this);
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
                    if (SpringFestivalEntryManager.this.E != 0 && SpringFestivalEntryManager.this.E != 3 && SpringFestivalEntryManager.this.E != 4) {
                        SpringFestivalEntryManager springFestivalEntryManager = SpringFestivalEntryManager.this;
                        springFestivalEntryManager.x(springFestivalEntryManager.I());
                    }
                    SpringFestivalEntryManager.this.Q();
                    SpringFestivalEntryManager.this.i0();
                    SpringFestivalEntryManager.this.u();
                    SpringFestivalEntryManager.this.w();
                } catch (Throwable th5) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(202, th5, new String[0]);
                    }
                    QLog.d("SpringHb_SpringFestivalEntryManager", 1, "generateTasksAndLaunch ex. " + th5.getMessage(), th5);
                }
            }
        });
    }

    private long D(BaseActivityData baseActivityData) {
        long taskAboutToOverDuration = baseActivityData.getTaskTime().end - (baseActivityData.getTaskAboutToOverDuration() * 1000);
        if (taskAboutToOverDuration < baseActivityData.getTaskTime().begin) {
            return baseActivityData.getTaskTime().begin;
        }
        return taskAboutToOverDuration;
    }

    private String H() {
        QQAppInterface K = K();
        if (K != null) {
            return K.getCurrentAccountUin();
        }
        return "";
    }

    private QQAppInterface K() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return null;
    }

    private void P(Message message) {
        d.a aVar;
        QLog.i("SpringHb_SpringFestivalEntryManager", 1, "handleTaskMsg isSpeedUp: " + Y() + " currentTime is: " + en.i(I()));
        if (message.arg1 != 1) {
            if (this.f289063m.size() > 0) {
                aVar = this.f289063m.remove(0);
                e0(aVar);
            } else {
                aVar = null;
            }
            QLog.i("SpringHb_SpringFestivalEntryManager", 1, String.format("handleTaskMsg task is %s", aVar));
        } else {
            QLog.i("SpringHb_SpringFestivalEntryManager", 1, "handleTaskMsg just loop check. do nothing.");
        }
        if (!this.f289063m.isEmpty()) {
            s0();
        } else {
            x0(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        try {
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringFestivalEntryManager", 2, String.format("initLocalCacheInfo speedUp=%b", Boolean.valueOf(Y())));
            }
        } catch (Throwable th5) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(209, th5, new String[0]);
            }
            QLog.i("SpringHb_SpringFestivalEntryManager", 1, th5.getMessage(), th5);
        }
    }

    private synchronized void R(String str) {
        if (this.f289059e == null) {
            UserData read = UserData.read(H());
            this.f289059e = read;
            QLog.d("SpringHb_SpringFestivalEntryManager", 1, String.format("initLocalUserData by=%s UserData=%s", str, read));
        }
    }

    private static boolean U(List list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean W() {
        i i3;
        if (X()) {
            return true;
        }
        QQAppInterface K = K();
        if (K != null && (i3 = ((SpringHbPreloadManager) K.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER)).i()) != null && i3.d()) {
            return true;
        }
        return false;
    }

    private void e0(d.a aVar) {
        String simpleString;
        BaseActivityData baseActivityData = this.I;
        MsgTabBannerData msgTabBannerData = this.H;
        Object[] objArr = new Object[6];
        objArr[0] = "onTaskNeed2Execute --> ";
        objArr[1] = aVar;
        objArr[2] = "\ncurBaseActivityData=";
        String str = "null";
        if (baseActivityData == null) {
            simpleString = "null";
        } else {
            simpleString = baseActivityData.toSimpleString();
        }
        objArr[3] = simpleString;
        objArr[4] = "\ncurMsgTabBannerData=";
        if (msgTabBannerData != null) {
            str = msgTabBannerData.toSimpleString();
        }
        objArr[5] = str;
        QLog.d("SpringHb_SpringFestivalEntryManager", 1, objArr);
        int i3 = aVar.f289083a;
        if (i3 != 2001) {
            if (i3 != 2002) {
                if (i3 != 3001) {
                    if (i3 != 3002) {
                        if (i3 != 5001) {
                            if (i3 != 5002) {
                                switch (i3) {
                                    case 1001:
                                        if (!W()) {
                                            QLog.d("SpringHb_SpringFestivalEntryManager", 1, "onTaskNeed2Execute --> ACTIVITY_START resource doesn't exist");
                                            return;
                                        } else {
                                            q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.3
                                                static IPatchRedirector $redirector_;

                                                /* renamed from: d, reason: collision with root package name */
                                                final /* synthetic */ d.a f289070d;

                                                {
                                                    this.f289070d = aVar;
                                                    IPatchRedirector iPatchRedirector = $redirector_;
                                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    IPatchRedirector iPatchRedirector = $redirector_;
                                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                                        return;
                                                    }
                                                    Object obj = this.f289070d.f289085c;
                                                    if (obj instanceof BaseActivityData) {
                                                        BaseActivityData baseActivityData2 = (BaseActivityData) obj;
                                                        SpringFestivalEntryManager.this.I = baseActivityData2;
                                                        SpringFestivalEntryManager.this.G.h(this.f289070d.f289084b, baseActivityData2);
                                                    }
                                                }
                                            }));
                                            return;
                                        }
                                    case 1002:
                                        if (!W()) {
                                            QLog.d("SpringHb_SpringFestivalEntryManager", 1, "onTaskNeed2Execute --> ACTIVITY_REAL_START resource doesn't exist");
                                            return;
                                        } else {
                                            q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.4
                                                static IPatchRedirector $redirector_;

                                                /* renamed from: d, reason: collision with root package name */
                                                final /* synthetic */ d.a f289071d;

                                                {
                                                    this.f289071d = aVar;
                                                    IPatchRedirector iPatchRedirector = $redirector_;
                                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    IPatchRedirector iPatchRedirector = $redirector_;
                                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                                        return;
                                                    }
                                                    Object obj = this.f289071d.f289085c;
                                                    if (obj instanceof BaseActivityData) {
                                                        BaseActivityData baseActivityData2 = (BaseActivityData) obj;
                                                        SpringFestivalEntryManager.this.I = baseActivityData2;
                                                        SpringFestivalEntryManager.this.G.j(this.f289071d.f289084b, baseActivityData2);
                                                    }
                                                }
                                            }));
                                            return;
                                        }
                                    case 1003:
                                        q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.5
                                            static IPatchRedirector $redirector_;

                                            /* renamed from: d, reason: collision with root package name */
                                            final /* synthetic */ d.a f289072d;

                                            {
                                                this.f289072d = aVar;
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                                }
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                                    return;
                                                }
                                                Object obj = this.f289072d.f289085c;
                                                if (obj instanceof BaseActivityData) {
                                                    BaseActivityData baseActivityData2 = (BaseActivityData) obj;
                                                    SpringFestivalEntryManager.this.I = baseActivityData2;
                                                    SpringFestivalEntryManager.this.G.c(baseActivityData2);
                                                }
                                            }
                                        }));
                                        return;
                                    case 1004:
                                        q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.6
                                            static IPatchRedirector $redirector_;

                                            /* renamed from: d, reason: collision with root package name */
                                            final /* synthetic */ d.a f289073d;

                                            {
                                                this.f289073d = aVar;
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                                }
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                                } else if (SpringFestivalEntryManager.this.u0(this.f289073d.f289085c)) {
                                                    SpringFestivalEntryManager.this.G.k(SpringFestivalEntryManager.this.I);
                                                    SpringFestivalEntryManager.this.I = null;
                                                }
                                            }
                                        }));
                                        return;
                                    default:
                                        switch (i3) {
                                            case 6001:
                                                q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.13
                                                    static IPatchRedirector $redirector_;

                                                    /* renamed from: d, reason: collision with root package name */
                                                    final /* synthetic */ d.a f289067d;

                                                    {
                                                        this.f289067d = aVar;
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                                        }
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                            iPatchRedirector.redirect((short) 2, (Object) this);
                                                            return;
                                                        }
                                                        Object obj = this.f289067d.f289085c;
                                                        if (obj instanceof MainActivityData) {
                                                            MainActivityData mainActivityData = (MainActivityData) obj;
                                                            SpringFestivalEntryManager.this.J = mainActivityData;
                                                            SpringFestivalEntryManager.this.G.i(mainActivityData);
                                                        }
                                                    }
                                                }));
                                                return;
                                            case 6002:
                                                q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.14
                                                    static IPatchRedirector $redirector_;

                                                    /* renamed from: d, reason: collision with root package name */
                                                    final /* synthetic */ d.a f289068d;

                                                    {
                                                        this.f289068d = aVar;
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                                        }
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                            iPatchRedirector.redirect((short) 2, (Object) this);
                                                            return;
                                                        }
                                                        Object obj = this.f289068d.f289085c;
                                                        if (obj instanceof MainActivityData) {
                                                            MainActivityData mainActivityData = (MainActivityData) obj;
                                                            SpringFestivalEntryManager.this.J = mainActivityData;
                                                            SpringFestivalEntryManager.this.G.b(mainActivityData);
                                                        }
                                                    }
                                                }));
                                                return;
                                            case 6003:
                                                q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.15
                                                    static IPatchRedirector $redirector_;

                                                    /* renamed from: d, reason: collision with root package name */
                                                    final /* synthetic */ d.a f289069d;

                                                    {
                                                        this.f289069d = aVar;
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                                        }
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                            iPatchRedirector.redirect((short) 2, (Object) this);
                                                        } else if (SpringFestivalEntryManager.this.v0(this.f289069d.f289085c)) {
                                                            SpringFestivalEntryManager.this.G.d(SpringFestivalEntryManager.this.J);
                                                            SpringFestivalEntryManager.this.J = null;
                                                        }
                                                    }
                                                }));
                                                return;
                                            default:
                                                return;
                                        }
                                }
                            }
                            q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.12
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ d.a f289066d;

                                {
                                    this.f289066d = aVar;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                    } else if (SpringFestivalEntryManager.this.w0(this.f289066d.f289085c)) {
                                        SpringFestivalEntryManager.this.G.e(SpringFestivalEntryManager.this.H);
                                        SpringFestivalEntryManager.this.H = null;
                                    }
                                }
                            }));
                            return;
                        }
                        q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.11
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ d.a f289065d;

                            {
                                this.f289065d = aVar;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Object obj = this.f289065d.f289085c;
                                if (obj instanceof MsgTabBannerData) {
                                    MsgTabBannerData msgTabBannerData2 = (MsgTabBannerData) obj;
                                    SpringFestivalEntryManager.this.H = msgTabBannerData2;
                                    SpringFestivalEntryManager.this.G.g(msgTabBannerData2);
                                }
                            }
                        }));
                        return;
                    }
                    q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.10
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ d.a f289064d;

                        {
                            this.f289064d = aVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else if (SpringFestivalEntryManager.this.u0(this.f289064d.f289085c)) {
                                SpringFestivalEntryManager.this.G.l(SpringFestivalEntryManager.this.I);
                            }
                        }
                    }));
                    return;
                }
                q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.9
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ d.a f289076d;

                    {
                        this.f289076d = aVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        Object obj = this.f289076d.f289085c;
                        if (obj instanceof BaseActivityData) {
                            BaseActivityData baseActivityData2 = (BaseActivityData) obj;
                            if (baseActivityData2.equals(SpringFestivalEntryManager.this.I)) {
                                SpringFestivalEntryManager.this.G.m(baseActivityData2);
                            }
                        }
                    }
                }));
                return;
            }
            q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ d.a f289075d;

                {
                    this.f289075d = aVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (SpringFestivalEntryManager.this.u0(this.f289075d.f289085c)) {
                        SpringFestivalEntryManager.this.G.a(SpringFestivalEntryManager.this.I);
                    }
                }
            }));
            return;
        }
        q0(new TaskCallbackNotNullWrapper(new Runnable(aVar) { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d.a f289074d;

            {
                this.f289074d = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Object obj = this.f289074d.f289085c;
                if (obj instanceof BaseActivityData) {
                    BaseActivityData baseActivityData2 = (BaseActivityData) obj;
                    if (baseActivityData2.equals(SpringFestivalEntryManager.this.I)) {
                        SpringFestivalEntryManager.this.G.f(baseActivityData2);
                    }
                }
            }
        }));
    }

    private void f0(int i3, long j3, Object obj) {
        BaseActivityData baseActivityData;
        d.a aVar;
        MsgTabBannerData msgTabBannerData;
        if (i3 == 5002) {
            if (obj instanceof MsgTabBannerData) {
                msgTabBannerData = (MsgTabBannerData) obj;
            } else {
                msgTabBannerData = this.H;
            }
            aVar = new d.a(i3, j3, msgTabBannerData);
        } else {
            if (obj instanceof BaseActivityData) {
                baseActivityData = (BaseActivityData) obj;
            } else {
                baseActivityData = this.I;
            }
            aVar = new d.a(i3, j3, baseActivityData);
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 2, String.format("onTaskNeed2ExecuteForClear task=%s", d.b(i3)));
        }
        e0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i0() {
        if (this.f289058d != null) {
            this.f289058d.preHandleConfigs();
            v(this.f289058d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j0() {
        try {
            if (this.f289059e == null) {
                R("prepareActivityOnInit");
            }
        } catch (Throwable th5) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(208, th5, new String[0]);
            }
            QLog.e("SpringHb_SpringFestivalEntryManager", 1, th5.getMessage(), th5);
        }
    }

    private void m0(String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("SpringHb_SpringFestivalEntryManager", 2, "reportBrushAbnormalQuit activityID = " + str + ",leftCountDownDuration = " + j3);
        }
    }

    private void n0(long j3) {
        String simpleString;
        String str;
        long j16;
        boolean z16;
        String simpleString2;
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 2, "runCurrentTask. isPeedUp: " + Y() + " currentTime is: " + en.i(j3) + " taskSize:" + this.f289063m.size());
            Iterator<d.a> it = this.f289063m.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                QLog.d("SpringHb_SpringFestivalEntryManager", 2, String.format("before runCurrentTask [%d] task= %s", Integer.valueOf(i3), it.next().toString()));
                i3++;
            }
        }
        if (U(this.f289063m)) {
            x(j3);
            if (QLog.isColorLevel()) {
                QLog.w("SpringHb_SpringFestivalEntryManager", 2, "runCurrentTask, taskList is empty return");
                return;
            }
            return;
        }
        x0(2);
        BaseActivityData A = A(j3);
        Object[] objArr = new Object[1];
        String str2 = "null";
        if (A == null) {
            simpleString = "null";
        } else {
            simpleString = A.toSimpleString();
        }
        objArr[0] = simpleString;
        QLog.i("SpringHb_SpringFestivalEntryManager", 1, String.format("\u3010findOnGoingActivity\u3011 %s", objArr));
        if (A == null) {
            f0(2002, j3, null);
            f0(3002, j3, null);
            f0(1004, j3, null);
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringFestivalEntryManager", 2, "runCurrentTask. mCurrentActivityInfo is null,hide pendent and return.");
            }
            str = "SpringHb_SpringFestivalEntryManager";
        } else {
            BaseActivityData baseActivityData = this.I;
            if (baseActivityData != null && !baseActivityData.equals(A)) {
                QLog.d("SpringHb_SpringFestivalEntryManager", 1, String.format("should close pre_activity %s", baseActivityData.toSimpleString()));
                f0(2002, j3, baseActivityData);
                f0(3002, j3, baseActivityData);
                f0(1004, j3, baseActivityData);
            }
            if (A.getTaskAboutToOverDuration() <= 0) {
                str = "SpringHb_SpringFestivalEntryManager";
                j16 = 0;
                z16 = false;
            } else {
                j16 = D(A);
                str = "SpringHb_SpringFestivalEntryManager";
                z16 = com.tencent.mobileqq.springhb.b.d(new TimeInfo(j16, A.getTaskTime().end), j3);
            }
            if (z16) {
                e0(new d.a(1003, j16, A));
            } else if (A.getPeakDelayMs() > 0 && !A.scheduleTaskAfterPeak()) {
                if (j3 < A.getTaskTime().begin + A.getPeakDelayMs()) {
                    e0(new d.a(1001, A.getTaskTime().begin, A));
                } else {
                    e0(new d.a(1002, A.getTaskTime().begin + A.getPeakDelayMs(), A));
                }
            } else {
                e0(new d.a(1002, A.getTaskTime().begin, A));
            }
            if (A.schedulePendant()) {
                PendantData pendantData = A.pendantData;
                if (pendantData != null && com.tencent.mobileqq.springhb.b.c(pendantData.getTaskTime(), j3)) {
                    e0(new d.a(2001, pendantData.getTaskTime().begin, A));
                } else {
                    f0(2002, j3, A);
                }
            }
            BreathLightData breathLightData = A.breathLightData;
            if (breathLightData != null && com.tencent.mobileqq.springhb.b.c(breathLightData.getTaskTime(), j3)) {
                e0(new d.a(3001, A.getTaskTime().begin, A));
            } else {
                f0(3002, j3, A);
            }
        }
        MsgTabBannerData B = B(j3);
        Object[] objArr2 = new Object[1];
        if (B == null) {
            simpleString2 = "null";
        } else {
            simpleString2 = B.toSimpleString();
        }
        objArr2[0] = simpleString2;
        String str3 = str;
        QLog.i(str3, 1, String.format("\u3010findOnGoingMsgTabBanner\u3011 %s", objArr2));
        if (B == null) {
            f0(5002, j3, null);
        } else {
            MsgTabBannerData msgTabBannerData = this.H;
            if (msgTabBannerData != null && msgTabBannerData.getTaskTime().end == j3) {
                QLog.d(str3, 1, String.format("should close pre msgTabBanner id=%d", msgTabBannerData.f289095id));
                f0(5002, j3, msgTabBannerData);
            }
            e0(new d.a(5001, B.getTaskTime().begin, B));
        }
        MainActivityData z17 = z();
        Object[] objArr3 = new Object[1];
        if (z17 != null) {
            str2 = z17.toString();
        }
        objArr3[0] = str2;
        QLog.i(str3, 1, String.format("\u3010findMainActivity\u3011 %s", objArr3));
        if (z17 == null) {
            f0(6003, j3, null);
            return;
        }
        TimeInfo timeInfo = z17.configTimeInfo;
        if (timeInfo.begin > j3) {
            e0(new d.a(6001, j3, z17));
        } else if (com.tencent.mobileqq.springhb.b.d(timeInfo, j3)) {
            e0(new d.a(6002, z17.configTimeInfo.begin, z17));
        } else {
            f0(6003, j3, null);
        }
    }

    private void r0() {
        try {
            UserData userData = this.f289059e;
            if (userData != null) {
                UserData.write(userData.getOwnerUin(), userData);
            }
        } catch (Throwable th5) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(201, th5, new String[0]);
            }
            QLog.d("SpringHb_SpringFestivalEntryManager", 1, th5.getMessage(), th5);
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 2, "saveLocalUserData");
        }
    }

    private synchronized void s0() {
        QLog.i("SpringHb_SpringFestivalEntryManager", 1, "scheduleNextTask.");
        this.C.removeMessages(1001);
        List<d.a> list = this.f289063m;
        if (list != null && !list.isEmpty()) {
            d.a aVar = this.f289063m.get(0);
            long I = aVar.f289084b - I();
            if (I < -300000) {
                w();
                QLog.i("SpringHb_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time < -5 minute, checkAndScheduleTask.");
            } else if (I < 86400000) {
                Message obtain = Message.obtain(this.C, 1001);
                if (I > MiniBoxNoticeInfo.MIN_5) {
                    obtain.arg1 = 1;
                    I = 300000;
                }
                if (Y()) {
                    I /= this.V;
                }
                this.C.sendMessageDelayed(obtain, I);
                QLog.i("SpringHb_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time is: " + I + " next task is: " + aVar.toString());
                if (QLog.isColorLevel()) {
                    Iterator<d.a> it = this.f289063m.iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        QLog.d("SpringHb_SpringFestivalEntryManager", 2, String.format("scheduleNextTask [%d] task= %s", Integer.valueOf(i3), it.next().toString()));
                        i3++;
                    }
                }
            } else {
                QLog.i("SpringHb_SpringFestivalEntryManager", 1, "scheduleNextTask. delay time beyond 24 hour. do nothing.");
            }
            return;
        }
        QLog.i("SpringHb_SpringFestivalEntryManager", 1, "scheduleNextTask. task list is empty. return.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u() {
        PendantData pendantData;
        this.f289063m.clear();
        if (this.f289058d == null) {
            if (QLog.isColorLevel()) {
                QLog.i("SpringHb_SpringFestivalEntryManager", 2, "buildAndSortPartyTaskQueue entryConfig=null return");
            }
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (BaseActivityData baseActivityData : this.f289058d.activities) {
            if (baseActivityData.getPeakDelayMs() > 0 && !baseActivityData.scheduleTaskAfterPeak()) {
                linkedList.add(new d.a(1001, baseActivityData.getTaskTime().begin, baseActivityData));
                linkedList.add(new d.a(1002, baseActivityData.getTaskTime().begin + baseActivityData.getPeakDelayMs(), baseActivityData));
            } else {
                linkedList.add(new d.a(1002, baseActivityData.getTaskTime().begin, baseActivityData));
            }
            if (baseActivityData.schedulePendant() && (pendantData = baseActivityData.pendantData) != null) {
                linkedList.add(new d.a(2001, pendantData.getTaskTime().begin, baseActivityData));
                linkedList.add(new d.a(2002, pendantData.getTaskTime().end, baseActivityData));
            }
            BreathLightData breathLightData = baseActivityData.breathLightData;
            if (breathLightData != null) {
                linkedList.add(new d.a(3001, breathLightData.getTaskTime().begin, baseActivityData));
                linkedList.add(new d.a(3002, breathLightData.getTaskTime().end, baseActivityData));
            }
            if (baseActivityData.getTaskAboutToOverDuration() > 0) {
                linkedList.add(new d.a(1003, D(baseActivityData), baseActivityData));
            }
            linkedList.add(new d.a(1004, baseActivityData.getTaskTime().end, baseActivityData));
        }
        for (MsgTabBannerData msgTabBannerData : this.f289058d.msgTabBanners) {
            linkedList.add(new d.a(5001, msgTabBannerData.getTaskTime().begin, msgTabBannerData));
            linkedList.add(new d.a(5002, msgTabBannerData.getTaskTime().end, msgTabBannerData));
        }
        MainActivityData mainActivityData = this.f289058d.commonData.mainActivityData;
        TimeInfo timeInfo = mainActivityData.configTimeInfo;
        long j3 = timeInfo.begin;
        long j16 = timeInfo.end;
        if (j16 > j3) {
            linkedList.add(new d.a(6002, j3, mainActivityData));
            linkedList.add(new d.a(6003, j16, mainActivityData));
        }
        if (!U(linkedList)) {
            Collections.sort(linkedList, new a());
            this.f289063m.addAll(linkedList);
        }
        QLog.i("SpringHb_SpringFestivalEntryManager", 1, String.format("buildAndSortPartyTaskQueue list=%s", this.f289063m));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u0(Object obj) {
        if (obj instanceof BaseActivityData) {
            if (((BaseActivityData) obj).equals(this.I)) {
                return true;
            }
            return false;
        }
        if (obj == null && this.I != null) {
            return true;
        }
        return false;
    }

    private synchronized void v(EntryConfigBean entryConfigBean) {
        if (entryConfigBean != null) {
            if (entryConfigBean.activities.size() > 0) {
                try {
                    long I = I();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(entryConfigBean.activities);
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        BaseActivityData baseActivityData = (BaseActivityData) arrayList.get(size);
                        long j3 = baseActivityData.getConfigTime().end;
                        if (baseActivityData.getType() == 2 && I > j3) {
                            UserData.UserDataItem O = O(baseActivityData.f289093id);
                            if (QLog.isColorLevel()) {
                                QLog.d("SpringHb_SpringFestivalEntryManager", 2, "checkAndReportAbnormalQuitBrushActivitys ,act.id = " + baseActivityData.f289093id + ",isAbnormalQuit = " + O.isAbnormalQuit + ",hasReportedAbnormalQuit = " + O.hasReportedAbnormalQuit);
                            }
                            if (O.isAbnormalQuit && !O.hasReportedAbnormalQuit) {
                                m0(baseActivityData.f289093id, O.leftCountDownDuration);
                                O.hasReportedAbnormalQuit = true;
                                g0();
                            }
                        }
                    }
                } catch (Throwable th5) {
                    QLog.d("SpringHb_SpringFestivalEntryManager", 1, "checkAndReportAbnormalQuitBrushActivities exception", th5);
                }
                return;
            }
        }
        QLog.d("SpringHb_SpringFestivalEntryManager", 1, String.format("checkAndReportAbnormalQuitBrushActivitys return", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v0(Object obj) {
        if (obj instanceof MainActivityData) {
            if (((MainActivityData) obj).equals(this.J)) {
                return true;
            }
            return false;
        }
        if (obj == null && this.J != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        boolean z16;
        QLog.i("SpringHb_SpringFestivalEntryManager", 1, String.format("checkAndScheduleTask isZipResCheckSuc=%b", Boolean.valueOf(this.M)));
        if (!this.M) {
            return;
        }
        try {
            synchronized (this.S) {
                long I = I();
                n0(I);
                y(I);
                s0();
            }
        } catch (Throwable th5) {
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(204, th5, "isMainThread=" + z16 + "stack=" + Log.getStackTraceString(th5));
                }
            } catch (Throwable unused) {
            }
            QLog.e("SpringHb_SpringFestivalEntryManager", 1, "checkAndScheduleTask ex. " + th5.getMessage(), th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w0(Object obj) {
        if (obj instanceof MsgTabBannerData) {
            if (((MsgTabBannerData) obj).equals(this.H)) {
                return true;
            }
            return false;
        }
        if (obj == null && this.H != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(long j3) {
        QLog.d("SpringHb_SpringFestivalEntryManager", 1, String.format("clearAllTasks currentTime=%s", en.i(j3)));
        this.f289063m.clear();
        this.C.removeMessages(1001);
        x0(4);
        f0(2002, j3, null);
        f0(3002, j3, null);
        f0(1004, j3, null);
        f0(5002, j3, null);
        f0(6003, j3, null);
    }

    private void x0(int i3) {
        QLog.i("SpringHb_SpringFestivalEntryManager", 1, "updatePartyState " + d.a(this.E) + " ==> " + d.a(i3));
        this.E = i3;
    }

    private synchronized void y(long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 2, "clearOutOfDataTask before:" + this.f289063m);
        }
        for (int size = this.f289063m.size() - 1; size >= 0; size--) {
            if (this.f289063m.get(size).f289084b <= j3) {
                this.f289063m.remove(size);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 2, "clearOutOfDataTask end:" + this.f289063m);
        }
    }

    public BaseActivityData A(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (BaseActivityData) iPatchRedirector.redirect((short) 42, (Object) this, j3);
        }
        if (this.f289058d == null) {
            return null;
        }
        synchronized (this.R) {
            for (BaseActivityData baseActivityData : this.f289058d.activities) {
                if (com.tencent.mobileqq.springhb.b.d(baseActivityData.getTaskTime(), j3)) {
                    return baseActivityData;
                }
            }
            return null;
        }
    }

    public synchronized MsgTabBannerData B(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (MsgTabBannerData) iPatchRedirector.redirect((short) 38, (Object) this, j3);
        }
        if (this.f289058d == null) {
            return null;
        }
        for (MsgTabBannerData msgTabBannerData : this.f289058d.msgTabBanners) {
            if (com.tencent.mobileqq.springhb.b.d(msgTabBannerData.getTaskTime(), j3)) {
                return msgTabBannerData;
            }
        }
        return null;
    }

    public String E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.f289058d != null && this.f289058d.commonData != null) {
            return this.f289058d.commonData.activityType;
        }
        return "";
    }

    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (this.f289061h == 1) {
            return true;
        }
        if (this.f289061h == 2) {
            return false;
        }
        return this.f289060f;
    }

    public BaseActivityData G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (BaseActivityData) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.I;
    }

    public long I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Long) iPatchRedirector.redirect((short) 35, (Object) this)).longValue();
        }
        if (Y()) {
            return ((NetConnInfoCenter.getServerTimeMillis() - this.U) * this.V) + this.T;
        }
        return NetConnInfoCenter.getServerTimeMillis();
    }

    @Nullable
    public EntryConfigBean J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (EntryConfigBean) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f289058d;
    }

    public com.tencent.mobileqq.springhb.entry.model.b L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.springhb.entry.model.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.Q;
    }

    public int M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.V;
    }

    @NonNull
    public UserData N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (UserData) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (this.f289059e == null) {
            R("getUserData");
        }
        return this.f289059e;
    }

    @NonNull
    public UserData.UserDataItem O(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (UserData.UserDataItem) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        return N().getAndGenUserDataItem(str);
    }

    public synchronized boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        try {
            EntryConfigBean entryConfigBean = this.f289058d;
            if (entryConfigBean != null && (!entryConfigBean.activities.isEmpty() || !entryConfigBean.msgTabBanners.isEmpty())) {
                long I = I();
                CommonData commonData = entryConfigBean.commonData;
                long j3 = commonData.forbidRefreshBeforeTime * 1000;
                long j16 = commonData.forbidRefreshAfterTime * 1000;
                if (!entryConfigBean.activities.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(entryConfigBean.activities);
                    Collections.sort(arrayList, com.tencent.mobileqq.springhb.b.f288967a);
                    PendantData pendantData = ((BaseActivityData) arrayList.get(0)).pendantData;
                    if (pendantData != null) {
                        TimeInfo b16 = ad.b(pendantData.taskTimeInfo, j3);
                        TimeInfo a16 = ad.a(pendantData.taskTimeInfo, j16);
                        if (com.tencent.mobileqq.springhb.b.c(b16, I) || com.tencent.mobileqq.springhb.b.c(a16, I)) {
                            QLog.i("SpringHb_SpringFestivalEntryManager", 1, String.format("isForbidRefreshTime [%d,%d] curTime=%s [%s,%s] act=%s", Long.valueOf(j3), Long.valueOf(j16), en.i(I), b16, a16, pendantData.toSimpleString()));
                            return true;
                        }
                    }
                }
                if (!entryConfigBean.msgTabBanners.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(entryConfigBean.msgTabBanners);
                    Collections.sort(arrayList2, com.tencent.mobileqq.springhb.b.f288967a);
                    MsgTabBannerData msgTabBannerData = (MsgTabBannerData) arrayList2.get(0);
                    TimeInfo b17 = ad.b(msgTabBannerData.taskTimeInfo, j3);
                    TimeInfo a17 = ad.a(msgTabBannerData.taskTimeInfo, j16);
                    if (com.tencent.mobileqq.springhb.b.c(b17, I) || com.tencent.mobileqq.springhb.b.c(a17, I)) {
                        QLog.i("SpringHb_SpringFestivalEntryManager", 1, String.format("isForbidRefreshTime [%d,%d] curTime=%s [%s,%s] ban=%s", Long.valueOf(j3), Long.valueOf(j16), en.i(I), b17, a17, msgTabBannerData.toSimpleString()));
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th5) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(523, th5, new String[0]);
            }
            QLog.e("SpringHb_SpringFestivalEntryManager", 1, "isForbidRefreshTime e:" + th5);
            return false;
        }
    }

    public boolean T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f289058d == null || this.f289058d.commonData == null) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 1, "entryConfig invalid");
        }
        if (this.f289058d != null && this.f289058d.commonData != null && this.f289058d.commonData.isGameCenterActivity()) {
            return true;
        }
        return false;
    }

    public boolean V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeBool("_2022_shuayishua_entrymanagerpendant_show_switch", true);
        QLog.d("SpringHb_SpringFestivalEntryManager", 1, "isPendantShowSwitchOn ", Boolean.valueOf(decodeBool));
        return decodeBool;
    }

    public boolean X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f289058d == null || this.f289058d.commonData == null) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 1, "entryConfig invalid");
        }
        if (this.f289058d != null && this.f289058d.commonData != null && this.f289058d.commonData.isSpringActivity()) {
            return true;
        }
        return false;
    }

    public boolean Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.entry.c
    @Nullable
    @Deprecated
    public String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        }
        return "";
    }

    public boolean a0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, j3)).booleanValue();
        }
        if (Y.format(new Date(j3)).equals(Y.format(new Date(I())))) {
            return true;
        }
        return false;
    }

    public boolean b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.f289059e != null) {
            return true;
        }
        return false;
    }

    public synchronized void c0(EntryConfigBean entryConfigBean) {
        boolean z16;
        String simpleString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) entryConfigBean);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onEntryConfigReady config is: ");
            if (entryConfigBean == null) {
                simpleString = "null";
            } else {
                simpleString = entryConfigBean.toSimpleString();
            }
            sb5.append(simpleString);
            QLog.i("SpringHb_SpringFestivalEntryManager", 2, sb5.toString());
        }
        if (AppSetting.f99565y) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 1, "onEntryConfigReady enableTalkBack, return.");
            return;
        }
        if (entryConfigBean == null) {
            entryConfigBean = new EntryConfigBean();
            QLog.d("SpringHb_SpringFestivalEntryManager", 1, "onEntryConfigReady use empty entryConfig!!!!!!");
        }
        if (this.f289059e == null) {
            R("onEntryConfigReady");
        }
        if (this.f289059e.onGetEntryConfig(entryConfigBean)) {
            g0();
        }
        if (!d0(null, entryConfigBean.version)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.M = z16;
        r.f289531a.d();
        this.f289058d = entryConfigBean;
        if (this.G == null) {
            this.L = true;
            QLog.i("SpringHb_SpringFestivalEntryManager", 1, "onEntryConfigReady earlier than setTaskCallback\uff0chold taskQueue");
        } else {
            C();
        }
    }

    @Deprecated
    public boolean d0(List<Object> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) list, i3)).booleanValue();
        }
        return false;
    }

    public void g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.C.sendEmptyMessageDelayed(1002, 1000L);
        }
    }

    public void h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.C.sendEmptyMessage(1002);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1001) {
            try {
                P(message);
            } catch (Throwable th5) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(203, th5, new String[0]);
                }
                QLog.i("SpringHb_SpringFestivalEntryManager", 1, th5.getMessage(), th5);
            }
        } else if (i3 == 1002) {
            this.C.removeMessages(1002);
            r0();
        }
        return false;
    }

    public void k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
        } else {
            l0(false);
        }
    }

    public void l0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, z16);
            return;
        }
        boolean z17 = true;
        QLog.d("SpringHb_SpringFestivalEntryManager", 1, "refreshScheduleTask force=" + z16);
        if (this.E != 0 && this.E != 3 && this.E != 4) {
            z17 = false;
        }
        if (this.f289058d == null) {
            return;
        }
        if (!z16 && z17) {
            if (this.E == 3) {
                q0(new TaskCallbackNotNullWrapper(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.17
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (SpringFestivalEntryManager.this.G != null) {
                            SpringFestivalEntryManager.this.G.k(SpringFestivalEntryManager.this.I);
                            SpringFestivalEntryManager.this.I = null;
                        }
                    }
                }));
                return;
            }
            return;
        }
        p0(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager.18
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpringFestivalEntryManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QLog.d("SpringHb_SpringFestivalEntryManager", 1, "refreshScheduleTask ...");
                    SpringFestivalEntryManager.this.w();
                }
            }
        });
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("SpringHb_SpringFestivalEntryManager", 2, "onDestroy.");
        try {
            if (this.C.hasMessages(1002)) {
                r0();
            }
            this.C.removeCallbacksAndMessages(null);
            this.D.removeCallbacksAndMessages(null);
        } catch (Throwable th5) {
            QLog.i("SpringHb_SpringFestivalEntryManager", 1, th5.getMessage(), th5);
        }
    }

    public void p0(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) runnable);
        } else {
            this.C.post(runnable);
        }
    }

    public void q0(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) runnable);
            return;
        }
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                this.D.post(runnable);
            }
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringFestivalEntryManager", 1, e16.getMessage(), e16);
        }
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.f289058d == null || this.f289058d.commonData == null) {
            return false;
        }
        if (!this.f289058d.commonData.isGameCenterActivity() && !this.f289058d.commonData.isSpringActivity()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public void t(c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) aVar);
        }
    }

    public synchronized void t0(b bVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            return;
        }
        if (bVar != null) {
            this.G = new h(bVar);
        } else {
            Object[] objArr = new Object[1];
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            QLog.d("SpringHb_SpringFestivalEntryManager", 1, String.format("setTaskCallback clearAllTasks on callback=null isMain=%b", objArr));
            if (this.E != 0 && this.E != 3 && this.E != 4) {
                x(I());
                if (this.f289058d != null) {
                    this.L = true;
                }
            }
            this.G = null;
        }
        QLog.d("SpringHb_SpringFestivalEntryManager", 1, String.format("setTaskCallback hasHoldTaskQueue=%b callback=%s", Boolean.valueOf(this.L), bVar));
        if (bVar == null) {
            return;
        }
        if (this.L) {
            C();
        }
    }

    public synchronized MainActivityData z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (MainActivityData) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        if (this.f289058d == null) {
            return null;
        }
        return this.f289058d.commonData.mainActivityData;
    }
}
