package com.tencent.mobileqq.portal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.portal.HongbaoAnimView;
import com.tencent.mobileqq.portal.HongbaoView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.springhb.ac;
import com.tencent.mobileqq.springhb.entry.worker.DemoteLevel;
import com.tencent.mobileqq.springhb.preload.s;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HongbaoView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private long C;
    private long D;
    private d E;
    private d F;
    private LinkedList<String> G;
    private Handler H;
    private Boolean I;

    /* renamed from: d, reason: collision with root package name */
    private final FrameLayout f259247d;

    /* renamed from: e, reason: collision with root package name */
    private final HongbaoAnimView f259248e;

    /* renamed from: f, reason: collision with root package name */
    private int f259249f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f259250h;

    /* renamed from: i, reason: collision with root package name */
    private b f259251i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f259252m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Function0<Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vip.j f259256d;

        a(com.tencent.mobileqq.vip.j jVar) {
            this.f259256d = jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoView.this, (Object) jVar);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HongbaoView.this.f259251i.a();
            this.f259256d.a();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Integer[] f259258a;

        /* renamed from: b, reason: collision with root package name */
        private int f259259b;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f259258a = new Integer[]{10, 20, 20, 30, 30, 30, 30, 40, 40, 40, 50, 50, 60};
                a();
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f259259b = this.f259258a[Math.abs(new Random().nextInt() % this.f259258a.length)].intValue();
            }
        }

        public boolean b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
            }
            if (i3 >= this.f259259b) {
                return true;
            }
            return false;
        }

        public void c(List<Integer> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else if (list != null && list.size() > 0) {
                this.f259258a = (Integer[]) list.toArray(new Integer[0]);
                a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        public static boolean a() {
            return false;
        }

        public static boolean b() {
            com.tencent.mobileqq.springhb.entry.worker.b bVar = com.tencent.mobileqq.springhb.entry.worker.b.f289157a;
            if (bVar.c() == DemoteLevel.LV3 || DeviceInfoUtils.isLowPerfDevice() || Build.VERSION.SDK_INT < 26 || bVar.e()) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        View f259260a;

        /* renamed from: b, reason: collision with root package name */
        String f259261b;

        /* renamed from: c, reason: collision with root package name */
        private String f259262c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f259263d;

        /* renamed from: e, reason: collision with root package name */
        private ISuperPlayer f259264e;

        /* renamed from: f, reason: collision with root package name */
        private Handler f259265f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes16.dex */
        public class a implements ISuperPlayer.OnVideoPreparedListener {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ISuperPlayer f259267e;

            a(ISuperPlayer iSuperPlayer) {
                this.f259267e = iSuperPlayer;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) iSuperPlayer);
                }
            }

            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) iSuperPlayer);
                } else if (d.this.f259263d) {
                    this.f259267e.start();
                }
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static d f(Handler handler, Context context, final String str, String str2) {
            d dVar = new d();
            dVar.f259262c = str;
            dVar.f259261b = str2;
            dVar.f259265f = handler;
            ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(context);
            ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(context, 117, createPlayerVideoView);
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str2, 101, (String) null);
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            obtain.isPrePlay = true;
            createMediaPlayer.setXYaxis(2);
            if ("video1".equals(str)) {
                createMediaPlayer.setLoopback(true);
            } else {
                createMediaPlayer.setLoopback(false);
            }
            createMediaPlayer.openMediaPlayer(context, createVideoInfoForUrl, 0L, obtain);
            createMediaPlayer.setPlaySpeedRatio(1.3f);
            createMediaPlayer.setOnVideoPreparedListener(new a(createMediaPlayer));
            createMediaPlayer.setOnCompletionListener(new ISuperPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.portal.n
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
                public final void onCompletion(ISuperPlayer iSuperPlayer) {
                    HongbaoView.d.g(str, iSuperPlayer);
                }
            });
            dVar.f259264e = createMediaPlayer;
            dVar.f259260a = (View) createPlayerVideoView;
            return dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void g(String str, ISuperPlayer iSuperPlayer) {
            QLog.d("HongbaoView", 1, str + " onCompletion");
        }

        protected void finalize() throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            super.finalize();
            try {
                this.f259264e.release();
            } catch (Exception unused) {
            }
        }

        public void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            this.f259263d = false;
            this.f259264e.pause();
            QLog.d("HongbaoView", 1, this.f259262c + " pause");
        }

        public void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            this.f259264e.release();
            QLog.d("HongbaoView", 1, this.f259262c + " release");
        }

        public void j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.f259263d = true;
            this.f259264e.start();
            QLog.d("HongbaoView", 1, this.f259262c + " start");
        }
    }

    public HongbaoView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f259249f = 0;
        this.f259250h = null;
        this.f259251i = new b();
        this.f259252m = true;
        this.C = SystemClock.uptimeMillis();
        this.D = 0L;
        this.G = new LinkedList<>();
        this.I = Boolean.FALSE;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f259247d = frameLayout;
        HongbaoAnimView hongbaoAnimView = new HongbaoAnimView(context, null);
        this.f259248e = hongbaoAnimView;
        addView(frameLayout, -1, -1);
        addView(hongbaoAnimView, -1, -1);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HongbaoView");
        baseHandlerThread.start();
        this.H = new Handler(baseHandlerThread.getLooper());
    }

    private void f(d dVar) {
        g();
        post(new Runnable(dVar) { // from class: com.tencent.mobileqq.portal.HongbaoView.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f259255d;

            {
                this.f259255d = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoView.this, (Object) dVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                d dVar2 = this.f259255d;
                boolean z16 = false;
                if (dVar2 != null && dVar2.f259260a.getParent() == null) {
                    HongbaoView.this.f259247d.addView(this.f259255d.f259260a, 0);
                    QLog.d("HongbaoView", 1, "view add" + this.f259255d.f259262c);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("add view error : view empty=");
                if (this.f259255d == null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.e("HongbaoView", 1, sb5.toString());
            }
        });
    }

    private d h(Context context, String str, String str2, boolean z16) {
        QLog.d("HongbaoView", 1, "prepare video:" + str);
        d f16 = d.f(this.H, context, str, str2);
        if (z16) {
            f16.j();
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        d dVar;
        d dVar2 = this.F;
        if (dVar2 != null) {
            dVar2.j();
        }
        FrameLayout frameLayout = this.f259247d;
        if (frameLayout != null && (dVar = this.E) != null) {
            frameLayout.removeView(dVar.f259260a);
        }
    }

    private void n() {
        if (this.f259250h != null) {
            QLog.d("HongbaoView", 1, "run delay runnable");
            this.H.post(this.f259250h);
            this.f259250h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Context context) {
        boolean z16;
        g();
        boolean z17 = true;
        QLog.d("HongbaoView", 1, "playVideos");
        if (this.E == null && this.G.size() > 0) {
            QLog.d("HongbaoView", 1, "playVideos video1");
            String pop = this.G.pop();
            if (!TextUtils.isEmpty(pop)) {
                if (this.F == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.E = h(context, "video1", pop, z16);
                if (this.F == null) {
                    v();
                }
                f(this.E);
            }
        }
        if (this.F == null && this.G.size() > 0) {
            QLog.d("HongbaoView", 1, "playVideos video2");
            String pop2 = this.G.pop();
            if (!TextUtils.isEmpty(pop2)) {
                if (this.E != null) {
                    z17 = false;
                }
                this.F = h(context, "video2", pop2, z17);
                if (this.E == null) {
                    v();
                }
                f(this.F);
            }
        }
    }

    private void v() {
        g();
        post(new Runnable() { // from class: com.tencent.mobileqq.portal.HongbaoView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                while (HongbaoView.this.f259247d.getChildCount() > 1) {
                    HongbaoView.this.f259247d.getChildAt(1);
                    HongbaoView.this.f259247d.removeView(HongbaoView.this.f259247d.getChildAt(1));
                }
            }
        });
    }

    private void w(@NonNull Context context) {
        this.H.post(new Runnable(context) { // from class: com.tencent.mobileqq.portal.HongbaoView.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f259253d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.portal.HongbaoView$1$a */
            /* loaded from: classes16.dex */
            class a implements SDKInitListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    } else {
                        QLog.i("HongbaoView", 1, "video sdk init.");
                    }
                }
            }

            {
                this.f259253d = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongbaoView.this, (Object) context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!QQVideoPlaySDKManager.isSDKReady()) {
                    QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new a());
                }
                try {
                    LockMethodProxy.sleep(100L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                HongbaoView.this.G.add(HongbaoView.this.t(0));
                HongbaoView.this.G.add(HongbaoView.this.t(1));
                HongbaoView.this.s(this.f259253d);
            }
        });
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f259248e.k();
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            if (!ac.h().k()) {
                ac.h().v();
            }
            d dVar = this.E;
            if (dVar != null && dVar.f259263d) {
                this.E.h();
            }
        } catch (Exception e16) {
            QLog.e("HongbaoView", 1, e16, new Object[0]);
        }
        this.f259248e.m();
        if (!this.f259252m) {
            return;
        }
        this.f259252m = false;
        QLog.d("HongbaoView", 1, "anim pause");
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        try {
            if (!ac.h().k()) {
                ac.h().o(2);
            }
            d dVar = this.E;
            if (dVar != null && !dVar.f259263d) {
                this.E.j();
            }
        } catch (Exception e16) {
            QLog.e("HongbaoView", 1, e16, new Object[0]);
        }
        this.f259248e.n();
        if (this.f259252m) {
            return;
        }
        this.f259252m = true;
        QLog.d("HongbaoView", 1, "anim resume");
        this.f259251i.a();
        n();
    }

    public void m(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (this.f259251i.b(i3) && j3 > 3000) {
            QLog.d("HongbaoView", 1, "\u4e2d\u5956\u4e86");
            if (!this.f259248e.l()) {
                this.f259248e.j();
            }
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j16 = this.C;
        if (uptimeMillis - j16 > 400) {
            this.f259248e.q(HongbaoAnimView.HitLevel.SLOW);
        } else if (uptimeMillis - j16 > 150) {
            this.f259248e.q(HongbaoAnimView.HitLevel.NORMAL);
        } else {
            this.f259248e.q(HongbaoAnimView.HitLevel.FAST);
        }
        this.C = uptimeMillis;
        u();
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.f259252m) {
            QLog.d("HongbaoView", 1, "onActivityResume");
            l();
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.d("HongbaoView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.H.getLooper().quit();
        this.f259248e.o();
        d dVar = this.E;
        if (dVar != null) {
            try {
                dVar.f259264e.release();
                this.E.f259264e.setOnCompletionListener(null);
            } catch (Exception unused) {
            }
        }
        d dVar2 = this.F;
        if (dVar2 != null) {
            try {
                dVar2.f259264e.release();
                this.F.f259264e.setOnCompletionListener(null);
            } catch (Exception unused2) {
            }
        }
    }

    public void q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        QLog.dAsync("HongbaoView", 1, "[Async log]onTick progressMills=" + j3);
        u();
    }

    public void r(Function1<Boolean, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function1);
            return;
        }
        QLog.d("HongbaoView", 1, "playEnding isResume=" + this.f259252m);
        this.f259249f = 3;
        d dVar = this.E;
        if (dVar != null) {
            dVar.i();
        }
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.portal.m
            @Override // java.lang.Runnable
            public final void run() {
                HongbaoView.this.j();
            }
        }, 800L);
        if (!this.f259252m) {
            function1.invoke(Boolean.FALSE);
        } else {
            this.f259248e.r(function1);
        }
    }

    public void setGiftFiredNums(List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            this.f259251i.c(list);
        }
    }

    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        ac.h().u(z16);
        if (z16) {
            try {
                if (!ac.h().k()) {
                    ac.h().v();
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("HongbaoView", 1, e16, new Object[0]);
                return;
            }
        }
        try {
            if (this.f259252m && !ac.h().k()) {
                ac.h().o(2);
            }
        } catch (Exception e17) {
            QLog.e("HongbaoView", 1, e17, new Object[0]);
        }
    }

    public void setOnGiftResultAnimFinished(com.tencent.mobileqq.vip.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) jVar);
        } else {
            this.f259248e.setOnGiftFired(new a(jVar));
        }
    }

    public String t(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (!s.a("spring_shua_animation.zip").r()) {
            str = "";
        } else {
            str = s.a("spring_shua_animation.zip").o() + File.separator + "video/" + i3 + ".mp4";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.I.booleanValue()) {
            return;
        }
        if (c.b()) {
            w(getContext());
        }
        this.f259248e.w();
        this.f259248e.v();
        this.I = Boolean.TRUE;
    }

    private void g() {
    }
}
