package com.tencent.qqnt.robot.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\tH&J2\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/robot/api/IRobotSharePreviewApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getIconAndTipsBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getRobotBottomLineText", "Lkotlin/Pair;", "", "uin", "name", "getRobotFaceDrawable", "Landroid/graphics/drawable/Drawable;", "robotUin", "getRobotQRCodeBitmap", "url", "size", "color", "isPureColor", "", "bgColor", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotSharePreviewApi extends QRouteApi {
    @Nullable
    Bitmap getIconAndTipsBitmap(int width, int height);

    @NotNull
    Pair<String, String> getRobotBottomLineText(@NotNull String uin, @Nullable String name);

    @Nullable
    Drawable getRobotFaceDrawable(@NotNull String robotUin);

    @Nullable
    Bitmap getRobotQRCodeBitmap(@NotNull String url, int size, int color, boolean isPureColor, int bgColor);
}
