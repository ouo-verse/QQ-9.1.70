package com.tencent.open.agent.util;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\b\rB\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/open/agent/util/PhotoEditResultHelper;", "", "Landroid/app/Application$ActivityLifecycleCallbacks;", "d", "", tl.h.F, "g", "Lcom/tencent/open/agent/util/PhotoEditResultHelper$b;", "a", "Lcom/tencent/open/agent/util/PhotoEditResultHelper$b;", "e", "()Lcom/tencent/open/agent/util/PhotoEditResultHelper$b;", "callback", "b", "Landroid/app/Application$ActivityLifecycleCallbacks;", "activityLifecycleCallbacks", "Ljava/lang/Object;", "c", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "", "Lkotlin/Lazy;", "f", "()Z", "switchOn", "<init>", "(Lcom/tencent/open/agent/util/PhotoEditResultHelper$b;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PhotoEditResultHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy switchOn;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/open/agent/util/PhotoEditResultHelper$b;", "", "Landroid/content/Intent;", "intent", "", "a", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a(@NotNull Intent intent);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/open/agent/util/PhotoEditResultHelper$c", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                if (Intrinsics.areEqual(activity.getClass(), PublicFragmentActivityForOpenSDK.class)) {
                    Intent intent = activity.getIntent();
                    if (intent == null) {
                        return;
                    } else {
                        PhotoEditResultHelper.this.getCallback().a(intent);
                    }
                }
            } catch (Exception unused) {
                QLog.e("PhotoEditResultHelper", 1, "onActivityCreated ");
            }
            Object obj = PhotoEditResultHelper.this.lock;
            PhotoEditResultHelper photoEditResultHelper = PhotoEditResultHelper.this;
            synchronized (obj) {
                MobileQQ.sMobileQQ.unregisterActivityLifecycleCallbacks(photoEditResultHelper.activityLifecycleCallbacks);
                photoEditResultHelper.activityLifecycleCallbacks = null;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    public PhotoEditResultHelper(@NotNull b callback) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.lock = new Object();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.agent.util.PhotoEditResultHelper$switchOn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_virtual_account_photo_edit_fix_switch", true);
                t.b("PhotoEditResultHelper", "isSwitchOn: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        this.switchOn = lazy;
    }

    private final Application.ActivityLifecycleCallbacks d() {
        return new c();
    }

    private final boolean f() {
        return ((Boolean) this.switchOn.getValue()).booleanValue();
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final b getCallback() {
        return this.callback;
    }

    public final void g() {
        if (!f()) {
            return;
        }
        synchronized (this.lock) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.activityLifecycleCallbacks;
            if (activityLifecycleCallbacks != null) {
                MobileQQ.sMobileQQ.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                this.activityLifecycleCallbacks = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void h() {
        if (!f()) {
            return;
        }
        synchronized (this.lock) {
            if (this.activityLifecycleCallbacks == null) {
                Application.ActivityLifecycleCallbacks d16 = d();
                this.activityLifecycleCallbacks = d16;
                MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(d16);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
