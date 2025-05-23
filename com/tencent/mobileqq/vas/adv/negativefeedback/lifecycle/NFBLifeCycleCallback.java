package com.tencent.mobileqq.vas.adv.negativefeedback.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.negativefeedback.common.QPublicAccountNFBController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/negativefeedback/lifecycle/NFBLifeCycleCallback;", "Lcom/tencent/mobileqq/app/lifecycle/DefaultBaseActivityLifecycleCallback;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnActivityCreate", "doOnActivityOnStart", "doOnActivityStopped", "doOnActivityDestroyed", "Landroid/os/Handler;", "d", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Landroid/os/Handler;", "mMainHandler", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "mLifeCycleEnabled", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NFBLifeCycleCallback extends DefaultBaseActivityLifecycleCallback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMainHandler;

    public NFBLifeCycleCallback() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.lifecycle.NFBLifeCycleCallback$mMainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.mMainHandler = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Activity activity, Bundle bundle) {
        QPublicAccountNFBController.f308109d.doOnActivityCreate(activity, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Activity activity) {
        QPublicAccountNFBController.f308109d.doOnActivityDestroyed(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Activity activity) {
        QPublicAccountNFBController.f308109d.doOnActivityOnStart(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Activity activity) {
        QPublicAccountNFBController.f308109d.doOnActivityStopped(activity);
    }

    private final boolean m() {
        return QPublicAccountNFBController.f308109d.h();
    }

    private final Handler n() {
        return (Handler) this.mMainHandler.getValue();
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(@Nullable final Activity activity, @Nullable final Bundle savedInstanceState) {
        if (activity != null && m()) {
            n().post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.lifecycle.a
                @Override // java.lang.Runnable
                public final void run() {
                    NFBLifeCycleCallback.i(activity, savedInstanceState);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(@Nullable final Activity activity) {
        if (activity != null && m()) {
            n().post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.lifecycle.b
                @Override // java.lang.Runnable
                public final void run() {
                    NFBLifeCycleCallback.j(activity);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityOnStart(@Nullable final Activity activity) {
        if (activity != null && m()) {
            n().post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.lifecycle.d
                @Override // java.lang.Runnable
                public final void run() {
                    NFBLifeCycleCallback.k(activity);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityStopped(@Nullable final Activity activity) {
        if (activity != null && m()) {
            n().post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.lifecycle.c
                @Override // java.lang.Runnable
                public final void run() {
                    NFBLifeCycleCallback.l(activity);
                }
            });
        }
    }
}
