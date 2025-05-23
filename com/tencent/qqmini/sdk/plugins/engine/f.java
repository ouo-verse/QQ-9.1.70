package com.tencent.qqmini.sdk.plugins.engine;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/sdk/plugins/engine/f;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/qqmini/sdk/plugins/engine/e;", "permissionCallback", "", "a", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public interface f {
    @RequiresApi(23)
    void a(@NotNull Activity activity, @NotNull String permission, @NotNull e permissionCallback);
}
