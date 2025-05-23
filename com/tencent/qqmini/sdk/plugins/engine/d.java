package com.tencent.qqmini.sdk.plugins.engine;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqmini/sdk/plugins/engine/d;", "Lcom/tencent/qqmini/sdk/plugins/engine/f;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/qqmini/sdk/plugins/engine/e;", "permissionCallback", "", "a", "<init>", "()V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class d implements f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqmini/sdk/plugins/engine/d$a", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/RequestPermissionCallback;", "", "onSuccess", "onFail", "onPartialGrant", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class a implements RequestPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f348301a;

        a(e eVar) {
            this.f348301a = eVar;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onFail() {
            this.f348301a.onFailed();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onPartialGrant() {
            this.f348301a.onPartialGrant();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onSuccess() {
            this.f348301a.onSucceed();
        }
    }

    @Override // com.tencent.qqmini.sdk.plugins.engine.f
    public void a(@NotNull Activity activity, @NotNull String permission, @NotNull e permissionCallback) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        Intrinsics.checkParameterIsNotNull(permissionCallback, "permissionCallback");
        if (Intrinsics.areEqual("android.permission.ACCESS_FINE_LOCATION", permission)) {
            ((IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class)).requestForPermission(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, new a(permissionCallback));
        } else {
            ((IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class)).requestForPermission(activity, permission, new b(permissionCallback));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqmini/sdk/plugins/engine/d$b", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/RequestPermissionCallback;", "", "onSuccess", "onFail", "onPartialGrant", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class b implements RequestPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f348302a;

        b(e eVar) {
            this.f348302a = eVar;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onFail() {
            this.f348302a.onFailed();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onSuccess() {
            this.f348302a.onSucceed();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onPartialGrant() {
        }
    }
}
