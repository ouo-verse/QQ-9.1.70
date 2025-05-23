package com.tencent.mobileqq.springhb.entry.worker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener;
import com.tencent.mobileqq.mini.entry.desktop.IMiniAppDesktopChangeApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u000201B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/e;", "Landroid/os/Handler$Callback;", "", "d", "Lcom/tencent/mobileqq/springhb/entry/worker/e$b;", "lifeCycleListener", "c", DomainData.DOMAIN_NAME, "p", "o", "", "e", "j", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "g", tl.h.F, "l", "Landroid/os/Message;", "msg", "handleMessage", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "getSpringApi", "()Lcom/tencent/mobileqq/springhb/entry/worker/d;", "springApi", "Z", "isLeftDrawerOpen", "f", "isResume", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "isMiniAppDesktopOpened", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "lifeCycleListenerList", "Lcom/tencent/mobileqq/mini/entry/desktop/DesktopChangeListener;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/mini/entry/desktop/DesktopChangeListener;", "desktopChangeListener", "<init>", "(Lcom/tencent/mobileqq/springhb/entry/worker/d;)V", "D", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final DesktopChangeListener desktopChangeListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d springApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isLeftDrawerOpen;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isResume;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isMiniAppDesktopOpened;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler uiHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> lifeCycleListenerList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/e$a;", "", "", "DELAY_TIME_FOR_CLOSING_MINI_DESKTOP", "J", "", "MESSAGE_MINI_DESKTOP_CLOSE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.worker.e$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/worker/e$b;", "", "", "c", "b", "i", "e", "d", tl.h.F, "f", "a", "g", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            }
        }

        public void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        public void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/springhb/entry/worker/e$c", "Lcom/tencent/mobileqq/mini/entry/desktop/DesktopChangeListener;", "", "onStartDesktopOpenAnimation", "onDesktopOpened", "onDesktopClosed", "onDesktopResume", "onDesktopAccountChanged", "onDesktopDestroy", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements DesktopChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener
        public void onDesktopAccountChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                QLog.d("SpringHbLifeCycleMonitor", 2, "onDesktopAccountChanged");
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener
        public void onDesktopClosed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.d("SpringHbLifeCycleMonitor", 2, "onDesktopClosed");
            e.this.uiHandler.removeMessages(1);
            e.this.uiHandler.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener
        public void onDesktopDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener
        public void onDesktopOpened() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d("SpringHbLifeCycleMonitor", 2, "onDesktopOpened");
            e.this.q(true);
            e.this.uiHandler.removeMessages(1);
            Iterator it = e.this.lifeCycleListenerList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).e();
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener
        public void onDesktopResume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                QLog.d("SpringHbLifeCycleMonitor", 2, "onDesktopResume");
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener
        public void onStartDesktopOpenAnimation() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("SpringHbLifeCycleMonitor", 2, "onStartDesktopOpenAnimation ");
            e.this.q(true);
            Iterator it = e.this.lifeCycleListenerList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).i();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60695);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull d springApi) {
        Intrinsics.checkNotNullParameter(springApi, "springApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) springApi);
            return;
        }
        this.springApi = springApi;
        this.uiHandler = new Handler(Looper.getMainLooper(), this);
        this.lifeCycleListenerList = new CopyOnWriteArrayList<>();
        this.desktopChangeListener = new c();
    }

    private final void d() {
        QLog.d("SpringHbLifeCycleMonitor", 2, "doCloseMiniAppDesktop");
        this.isMiniAppDesktopOpened = false;
        ApngImage.playByTag(26);
        Iterator<T> it = this.lifeCycleListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).d();
        }
    }

    public final void c(@NotNull b lifeCycleListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) lifeCycleListener);
        } else {
            Intrinsics.checkNotNullParameter(lifeCycleListener, "lifeCycleListener");
            this.lifeCycleListenerList.add(lifeCycleListener);
        }
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        QLog.d("SpringHbLifeCycleMonitor", 2, "isMiniAppDesktopOpened = " + this.isMiniAppDesktopOpened + ",isResume = " + this.isResume + ",isLeftDrawerOpen = " + this.isLeftDrawerOpen);
        if (!this.isMiniAppDesktopOpened && this.isResume && !this.isLeftDrawerOpen) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isMiniAppDesktopOpened;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QLog.d("SpringHbLifeCycleMonitor", 2, "onAccountChanged");
        this.uiHandler.removeCallbacksAndMessages(null);
        p();
        Iterator<T> it = this.lifeCycleListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QLog.d("SpringHbLifeCycleMonitor", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.uiHandler.removeCallbacksAndMessages(null);
        o();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            d();
        }
        return true;
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d("SpringHbLifeCycleMonitor", 2, "onDrawerClosed");
        this.isLeftDrawerOpen = false;
        ApngImage.playByTag(26);
        Iterator<T> it = this.lifeCycleListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b();
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.d("SpringHbLifeCycleMonitor", 2, "onDrawerOpened");
        this.isLeftDrawerOpen = true;
        Iterator<T> it = this.lifeCycleListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).c();
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QLog.d("SpringHbLifeCycleMonitor", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.isResume = false;
        Iterator<T> it = this.lifeCycleListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).f();
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QLog.d("SpringHbLifeCycleMonitor", 2, "onPullRefresh");
        Iterator<T> it = this.lifeCycleListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).g();
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.isResume = true;
        QLog.d("SpringHbLifeCycleMonitor", 2, "onResume");
        try {
            ApngImage.playByTag(26);
        } catch (Throwable th5) {
            QLog.e("SpringHbLifeCycleMonitor", 1, "onResume e:", th5);
        }
        Iterator<T> it = this.lifeCycleListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).h();
        }
    }

    public final void n(@NotNull b lifeCycleListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) lifeCycleListener);
        } else {
            Intrinsics.checkNotNullParameter(lifeCycleListener, "lifeCycleListener");
            this.lifeCycleListenerList.remove(lifeCycleListener);
        }
    }

    public final void o() {
        IMiniAppDesktopChangeApi iMiniAppDesktopChangeApi;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        MiniAppPullInterface d16 = this.springApi.i().d();
        QLog.d("SpringHbLifeCycleMonitor", 2, "removeMiniAppDestopChangeListener miniAppPullInterface = " + d16);
        if (d16 instanceof IMiniAppDesktopChangeApi) {
            iMiniAppDesktopChangeApi = (IMiniAppDesktopChangeApi) d16;
        } else {
            iMiniAppDesktopChangeApi = null;
        }
        if (iMiniAppDesktopChangeApi != null) {
            iMiniAppDesktopChangeApi.removeDesktopChangeListener(this.desktopChangeListener);
        }
    }

    public final void p() {
        IMiniAppDesktopChangeApi iMiniAppDesktopChangeApi;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        MiniAppPullInterface d16 = this.springApi.i().d();
        QLog.d("SpringHbLifeCycleMonitor", 2, "setMiniAppDestopChangeListener miniAppPullInterface = " + d16);
        if (d16 instanceof IMiniAppDesktopChangeApi) {
            iMiniAppDesktopChangeApi = (IMiniAppDesktopChangeApi) d16;
        } else {
            iMiniAppDesktopChangeApi = null;
        }
        if (iMiniAppDesktopChangeApi != null) {
            iMiniAppDesktopChangeApi.addDesktopChangeListener(this.desktopChangeListener);
        }
    }

    public final void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isMiniAppDesktopOpened = z16;
        }
    }
}
