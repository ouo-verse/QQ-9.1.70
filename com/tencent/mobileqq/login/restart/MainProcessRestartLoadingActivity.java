package com.tencent.mobileqq.login.restart;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.restart.MainProcessRestartLoadingActivity;
import com.tencent.mobileqq.login.restart.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0012\u001a\u00020\rH\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0014R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/login/restart/MainProcessRestartLoadingActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "", "initView", "Landroid/graphics/Bitmap;", "Q2", "M2", "S2", "R2", "W2", "Y2", "N2", "dismissLoading", "", "shouldWaitAppRuntime", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreate", "onBackEvent", "doOnResume", "doOnDestroy", "a0", "Z", "firstResume", "Landroid/os/Handler;", "b0", "Landroid/os/Handler;", "uiHandler", "<init>", "()V", "c0", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MainProcessRestartLoadingActivity extends QBaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d0, reason: collision with root package name */
    private static int f242596d0;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean firstResume;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/login/restart/MainProcessRestartLoadingActivity$a;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "tipText", "", "a", "", "FINISH_ACTIVITY_DELAY", "J", "KEY_LOADING_BG", "Ljava/lang/String;", "KEY_NAVIGATION_BAR_COLOR", "KEY_TIP_TEXT", "KILL_ACCOUNT_PROCESS_DELAY", "RESTART_MAIN_PROCESS_DELAY", "TAG", "", "topActivityId", "I", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.restart.MainProcessRestartLoadingActivity$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/login/restart/MainProcessRestartLoadingActivity$a$a", "Lcom/tencent/mobileqq/login/restart/a$a;", "Landroid/graphics/Bitmap;", "getBackground", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.login.restart.MainProcessRestartLoadingActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static final class BinderC7988a extends a.AbstractBinderC7989a {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bitmap f242599d;

            BinderC7988a(Bitmap bitmap) {
                this.f242599d = bitmap;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
                }
            }

            @Override // com.tencent.mobileqq.login.restart.a
            @NotNull
            public Bitmap getBackground() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                QLog.i("MainProcessRestartLoadingActivity", 2, "remote call getBackground");
                return this.f242599d;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull Context context, @Nullable Bitmap bitmap, @Nullable String tipText) {
            Window window;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, bitmap, tipText);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) MainProcessRestartLoadingActivity.class);
            if (bitmap != null) {
                Bundle bundle = new Bundle();
                bundle.putBinder("loadingBg", new BinderC7988a(bitmap));
                intent.putExtras(bundle);
            }
            if (tipText != null) {
                intent.putExtra("tipText", tipText);
            }
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null && (window = topActivity.getWindow()) != null) {
                Intrinsics.checkNotNullExpressionValue(window, "window");
                intent.putExtra("navigationBarColor", window.getNavigationBarColor());
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/restart/MainProcessRestartLoadingActivity$b", "Lcom/tencent/mobileqq/login/restart/r;", "", "success", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements r {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainProcessRestartLoadingActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(MainProcessRestartLoadingActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.N2();
        }

        @Override // com.tencent.mobileqq.login.restart.r
        public void a(boolean success) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MainProcessRestartLoadingActivity.this.Y2();
                Handler handler = MainProcessRestartLoadingActivity.this.uiHandler;
                final MainProcessRestartLoadingActivity mainProcessRestartLoadingActivity = MainProcessRestartLoadingActivity.this;
                handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.login.restart.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainProcessRestartLoadingActivity.b.c(MainProcessRestartLoadingActivity.this);
                    }
                }, 3000L);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, success);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24215);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MainProcessRestartLoadingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.firstResume = true;
            this.uiHandler = new Handler(Looper.getMainLooper());
        }
    }

    private final void M2() {
        int i3;
        boolean z16;
        int navigationBarColor = getWindow().getNavigationBarColor();
        Intent intent = getIntent();
        if (intent != null) {
            i3 = intent.getIntExtra("navigationBarColor", navigationBarColor);
        } else {
            i3 = navigationBarColor;
        }
        if (i3 != navigationBarColor) {
            getWindow().setNavigationBarColor(i3);
            if (com.tencent.mobileqq.qui.immersive.c.c(i3) > com.tencent.mobileqq.qui.immersive.c.f276883h) {
                z16 = true;
            } else {
                z16 = false;
            }
            ImmersiveUtils.setNavigationBarIconColor(getWindow(), z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N2() {
        QLog.i("MainProcessRestartLoadingActivity", 1, "finishActivity");
        if (!isFinishing()) {
            finish();
        }
        this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.login.restart.p
            @Override // java.lang.Runnable
            public final void run() {
                MainProcessRestartLoadingActivity.P2(MainProcessRestartLoadingActivity.this);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(MainProcessRestartLoadingActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (f242596d0 == this$0.hashCode()) {
            System.exit(0);
        } else {
            QLog.w("MainProcessRestartLoadingActivity", 1, "activity is not top now, ignore exit");
        }
    }

    private final Bitmap Q2() {
        IBinder iBinder;
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            iBinder = extras.getBinder("loadingBg");
        } else {
            iBinder = null;
        }
        if (iBinder == null) {
            QLog.d("MainProcessRestartLoadingActivity", 1, "binder is null");
            return null;
        }
        try {
            a j3 = a.AbstractBinderC7989a.j(iBinder);
            if (j3 == null) {
                return null;
            }
            return j3.getBackground();
        } catch (Throwable th5) {
            QLog.e("MainProcessRestartLoadingActivity", 1, "getBackground fail:", th5);
            return null;
        }
    }

    private final void R2() {
        QLog.i("MainProcessRestartLoadingActivity", 1, "killMainProcess");
        MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.mobileqq");
    }

    private final void S2() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.restart.m
            @Override // java.lang.Runnable
            public final void run() {
                MainProcessRestartLoadingActivity.T2(MainProcessRestartLoadingActivity.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T2(final MainProcessRestartLoadingActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("MainProcessRestartLoadingActivity", 1, "closeAllMainActivity");
        QIPCClientHelper.getInstance().callServer("LoginIPCModule", "finishActivity", null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.login.restart.n
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MainProcessRestartLoadingActivity.U2(MainProcessRestartLoadingActivity.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(final MainProcessRestartLoadingActivity this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R2();
        this$0.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.login.restart.o
            @Override // java.lang.Runnable
            public final void run() {
                MainProcessRestartLoadingActivity.V2(MainProcessRestartLoadingActivity.this);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(MainProcessRestartLoadingActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W2();
    }

    private final void W2() {
        QLog.i("MainProcessRestartLoadingActivity", 1, "startMainProcess");
        ProcessPreloadHelper.f242601a.e(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y2() {
        QLog.i("MainProcessRestartLoadingActivity", 1, "startSplashActivity");
        LoginProcessRestartMonitor.f(Stage.RESTART);
        dismissLoading();
        QRoute.createNavigator(this, RouterConstants.UI_ROUTER_SPLASH).withBoolean("switch_account_restart_disable_splash", true).withTransition(this, R.anim.fade_in, R.anim.fade_out).request();
    }

    private final void dismissLoading() {
        l.f242636a.a(this);
    }

    private final void initView() {
        View view;
        String str;
        Bitmap Q2 = Q2();
        QLog.i("MainProcessRestartLoadingActivity", 1, "background bitmap " + Q2);
        Window window = getWindow();
        if (window != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        if (Q2 != null && view != null && (view instanceof ViewGroup)) {
            View view2 = new View(this);
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            view2.setBackground(new BitmapDrawable(view2.getResources(), Q2));
            ((ViewGroup) view).addView(view2);
        } else {
            View view3 = new View(this);
            view3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            view3.setBackgroundResource(com.tencent.mobileqq.R.drawable.qui_common_bg_bottom_standard_bg);
            setContentView(view3);
        }
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("tipText")) == null) {
            str = "";
        }
        l.f242636a.c(this, str, false);
        M2();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState)).booleanValue();
        }
        f242596d0 = hashCode();
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(savedInstanceState);
        initView();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnDestroy();
            dismissLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.firstResume) {
            this.firstResume = false;
            S2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity
    protected boolean shouldWaitAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
