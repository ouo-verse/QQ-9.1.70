package com.tencent.minibox.proxy;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0007H&J5\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a2\u0006\u0002\u0010\u0014J8\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH&J\"\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH&J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/minibox/proxy/PermissionProxy;", "", "clearPermissionRecord", "", PushClientConstants.TAG_PKG_NAME, "", "isPermissionAvailable", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "isPermissionGranted", "isPermissionNeedUserGranted", "isPermissionProxyEnabled", "onRequestSystemPermissionResult", "qqPermission", "requestCode", "", "permissions", "", "grantResults", "", "(Ljava/lang/Object;I[Ljava/lang/String;[I)V", "requestMiniBoxPermissionGranted", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "appName", "appIcon", "Landroid/graphics/drawable/Drawable;", "callback", "Lcom/tencent/minibox/proxy/PermissionRequestCallback;", "requestSystemPermission", "showPermissionSettingPage", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface PermissionProxy {
    void clearPermissionRecord(@NotNull String pkgName);

    boolean isPermissionAvailable(@NotNull String pkgName, @NotNull String permission);

    boolean isPermissionGranted(@NotNull String pkgName, @NotNull String permission);

    boolean isPermissionNeedUserGranted(@NotNull String pkgName, @NotNull String permission);

    boolean isPermissionProxyEnabled();

    void onRequestSystemPermissionResult(@Nullable Object qqPermission, int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults);

    void requestMiniBoxPermissionGranted(@NotNull Activity activity, @NotNull String pkgName, @NotNull String appName, @NotNull Drawable appIcon, @NotNull String permission, @NotNull PermissionRequestCallback callback);

    @Nullable
    Object requestSystemPermission(@NotNull Activity activity, @NotNull String permission, @NotNull PermissionRequestCallback callback);

    void showPermissionSettingPage(@NotNull Activity activity, @NotNull String pkgName, @NotNull String appName);
}
