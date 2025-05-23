package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/LoginPublicFragmentActivity;", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "Landroid/content/res/Resources;", "getResources", "", "name", "", "getSystemService", "Lcom/tencent/mobileqq/activity/ec;", "a0", "Lcom/tencent/mobileqq/activity/ec;", "quiProfileTheme", "<init>", "()V", "b0", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class LoginPublicFragmentActivity extends QPublicFragmentActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ec quiProfileTheme;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0007J0\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0007J0\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/LoginPublicFragmentActivity$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "cls", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "b", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "c", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.LoginPublicFragmentActivity$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, intent, cls);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(cls, "cls");
            QPublicFragmentActivity.b.b(context, intent, LoginPublicFragmentActivity.class, cls);
        }

        @JvmStatic
        public final void b(@NotNull Activity activity, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> cls, int requestCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, activity, intent, cls, Integer.valueOf(requestCode));
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(cls, "cls");
            QPublicFragmentActivity.b.e(activity, intent, LoginPublicFragmentActivity.class, cls, requestCode);
        }

        @JvmStatic
        public final void c(@NotNull QBaseFragment fragment, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> cls, int requestCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, fragment, intent, cls, Integer.valueOf(requestCode));
                return;
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(cls, "cls");
            QPublicFragmentActivity.b.g(fragment, intent, LoginPublicFragmentActivity.class, cls, requestCode);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LoginPublicFragmentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.quiProfileTheme = new ec(this);
        }
    }

    @JvmStatic
    public static final void F2(@NotNull Activity activity, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> cls, int i3) {
        INSTANCE.b(activity, intent, cls, i3);
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Resources) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ec ecVar = this.quiProfileTheme;
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
        return ecVar.b(resources);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public Object getSystemService(@NotNull String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) name);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            Object systemService = super.getSystemService(name);
            if (systemService instanceof LayoutInflater) {
                return this.quiProfileTheme.a((LayoutInflater) systemService);
            }
        }
        return super.getSystemService(name);
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
