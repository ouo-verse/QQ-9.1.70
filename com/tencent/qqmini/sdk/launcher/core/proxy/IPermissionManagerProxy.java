package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J+\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000bH&\u00a2\u0006\u0002\u0010\u000fJ \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/proxy/IPermissionManagerProxy;", "", "isPermissionGranted", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/qqmini/sdk/launcher/core/proxy/Permissions;", "requestForPermission", "", "callbacks", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/RequestPermissionCallback;", "permissionStr", "", "", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/core/proxy/RequestPermissionCallback;)V", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public interface IPermissionManagerProxy {
    boolean isPermissionGranted(@NotNull Activity activity, @NotNull Permissions permission);

    void requestForPermission(@NotNull Activity activity, @NotNull Permissions permission, @NotNull RequestPermissionCallback callbacks);

    void requestForPermission(@NotNull Activity activity, @NotNull String permissionStr, @NotNull RequestPermissionCallback callbacks);

    void requestForPermission(@NotNull Activity activity, @NotNull String[] permissionStr, @NotNull RequestPermissionCallback callbacks);
}
