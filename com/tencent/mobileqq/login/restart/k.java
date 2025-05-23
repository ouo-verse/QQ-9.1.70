package com.tencent.mobileqq.login.restart;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.Window;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.login.restart.MainProcessRestartLoadingActivity;
import com.tencent.mobileqq.login.restart.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\bH\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/login/restart/k;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "tipText", "Lkotlin/Function1;", "", "", "callback", "f", "Landroid/graphics/Bitmap;", "c", "d", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f242631a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/restart/k$a", "Lcom/tencent/mobileqq/login/restart/r;", "", "success", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements r {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f242632a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f242633b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f242634c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f242635d;

        a(Activity activity, Bitmap bitmap, String str, Function1<? super Boolean, Unit> function1) {
            this.f242632a = activity;
            this.f242633b = bitmap;
            this.f242634c = str;
            this.f242635d = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, bitmap, str, function1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Activity activity) {
            if (activity != null) {
                l.f242636a.a(activity);
            }
        }

        @Override // com.tencent.mobileqq.login.restart.r
        public void a(boolean success) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, success);
                return;
            }
            try {
                MainProcessRestartLoadingActivity.Companion companion = MainProcessRestartLoadingActivity.INSTANCE;
                Context context = this.f242632a;
                if (context == null) {
                    context = BaseApplication.getContext();
                }
                Intrinsics.checkNotNullExpressionValue(context, "activity ?: MobileQQ.getContext()");
                companion.a(context, this.f242633b, this.f242634c);
                if (c.f242621a.a().f()) {
                    k.f242631a.d();
                }
                Function1<Boolean, Unit> function1 = this.f242635d;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                }
            } catch (Exception e16) {
                QLog.e("MainProcessRestartHelper", 1, "restart main process error: ", e16);
                LoginProcessRestartMonitor.f242582a.h();
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final Activity activity = this.f242632a;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.login.restart.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.a.c(activity);
                    }
                });
                Function1<Boolean, Unit> function12 = this.f242635d;
                if (function12 != null) {
                    function12.invoke(Boolean.FALSE);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23573);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f242631a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bitmap c(Activity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
            decorView.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.login.restart.i
            @Override // java.lang.Runnable
            public final void run() {
                k.e();
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        QLog.e("MainProcessRestartHelper", 1, "main process restart maybe fail!!!");
        LoginProcessRestartMonitor.f242582a.k("seriousSlow");
        QRoute.createNavigator(BaseApplication.getContext(), RouterConstants.UI_ROUTER_LOGIN).withFlags(268435456).withBoolean("logout_intent", true).requestWithReturn();
    }

    @JvmStatic
    @UiThread
    public static final void f(@Nullable Activity activity, @NotNull String tipText, @Nullable Function1<? super Boolean, Unit> callback) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        QLog.i("MainProcessRestartHelper", 1, "restartMainProcess " + activity);
        LoginProcessRestartMonitor.f(Stage.CAPTURE);
        if (activity != null) {
            bitmap = f242631a.c(activity);
        } else {
            bitmap = null;
        }
        QLog.i("MainProcessRestartHelper", 1, "capture window bitmap:" + bitmap);
        LoginProcessRestartMonitor.f(Stage.LOADING);
        if (activity != null) {
            l.d(l.f242636a, activity, tipText, false, 4, null);
        }
        ProcessPreloadHelper.f242601a.d(new a(activity, bitmap, tipText, callback));
    }
}
