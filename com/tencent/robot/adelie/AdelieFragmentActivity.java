package com.tencent.robot.adelie;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.homepage.utils.k;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/adelie/AdelieFragmentActivity;", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "Landroid/content/res/Resources;", "getResources", "", "name", "", "getSystemService", "Lcom/tencent/robot/adelie/homepage/utils/k;", "a0", "Lkotlin/Lazy;", "F2", "()Lcom/tencent/robot/adelie/homepage/utils/k;", "adelieTheme", "<init>", "()V", "b0", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieFragmentActivity extends QPublicFragmentActivity {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy adelieTheme;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006J6\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/adelie/AdelieFragmentActivity$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "cls", "", "a", "", "requestCode", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.AdelieFragmentActivity$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable Intent intent, @Nullable Class<? extends QPublicBaseFragment> cls) {
            QPublicFragmentActivity.b.b(context, intent, AdelieFragmentActivity.class, cls);
        }

        public final void b(@Nullable Context context, @Nullable Intent intent, @Nullable Class<? extends QPublicBaseFragment> cls, int requestCode) {
            QPublicFragmentActivity.b.f(context, intent, AdelieFragmentActivity.class, cls, requestCode);
        }

        Companion() {
        }
    }

    public AdelieFragmentActivity() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.robot.adelie.AdelieFragmentActivity$adelieTheme$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k invoke() {
                return new k(AdelieFragmentActivity.this);
            }
        });
        this.adelieTheme = lazy;
    }

    private final k F2() {
        return (k) this.adelieTheme.getValue();
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
        k F2 = F2();
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
        return F2.b(resources);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public Object getSystemService(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            Object systemService = super.getSystemService(name);
            if (systemService instanceof LayoutInflater) {
                return F2().a((LayoutInflater) systemService);
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
