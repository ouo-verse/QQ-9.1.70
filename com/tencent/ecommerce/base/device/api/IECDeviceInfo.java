package com.tencent.ecommerce.base.device.api;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.luggage.wxa.yf.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H&J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "", "checkDeviceHasNavigationBar", "", "context", "Landroid/content/Context;", "getAppDisplayMetrics", "Landroid/util/DisplayMetrics;", "getAppFontScale", "", "getNavigationBarHeight", "", "getSystemDisplayMetrics", e.NAME, "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "resetViewSize2Normal", "view", "Landroid/view/View;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECDeviceInfo {
    boolean checkDeviceHasNavigationBar(@NotNull Context context);

    @Nullable
    DisplayMetrics getAppDisplayMetrics();

    float getAppFontScale();

    int getNavigationBarHeight(@NotNull Context context);

    @NotNull
    DisplayMetrics getSystemDisplayMetrics();

    void hideNavigationBar(@NotNull Context activity);

    void resetViewSize2Normal(@NotNull Context context, @NotNull View view);
}
