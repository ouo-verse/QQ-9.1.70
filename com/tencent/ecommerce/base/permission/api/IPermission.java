package com.tencent.ecommerce.base.permission.api;

import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J-\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a2\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/permission/api/IPermission;", "", "hasPermission", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "onRequestPermissionResult", "", "requestCode", "", "permissions", "", "grantResult", "", "(I[Ljava/lang/String;[I)V", "requestPermissions", "permissionListener", "Lcom/tencent/ecommerce/base/permission/api/PermissionListener;", "(Landroid/content/Context;[Ljava/lang/String;Lcom/tencent/ecommerce/base/permission/api/PermissionListener;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IPermission {
    boolean hasPermission(@NotNull Context activity, @NotNull String permission);

    void onRequestPermissionResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResult);

    void requestPermissions(@NotNull Context activity, @NotNull String[] permissions, @NotNull PermissionListener permissionListener);
}
