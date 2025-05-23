package com.tencent.mobileqq.vas.pendant.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\rH&J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/api/ISpecialShapeAvatarMaskLayer;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getMaskLayer", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "uin", "", "specialShapeMaskId", "", "sizeW", "sizeH", "isSpecialShapeAvatar", "", "isSupportSpecialShapeMask", "startLoadLayer", "", "resultCallback", "Lcom/tencent/mobileqq/vas/pendant/api/ILoadResultCallback;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ISpecialShapeAvatarMaskLayer extends QRouteApi {
    @Nullable
    Bitmap getMaskLayer(@NotNull Context context, @NotNull String uin, int specialShapeMaskId, int sizeW, int sizeH);

    boolean isSpecialShapeAvatar(@NotNull String uin);

    boolean isSupportSpecialShapeMask();

    void startLoadLayer(@NotNull String uin, int specialShapeMaskId, @Nullable ILoadResultCallback resultCallback);
}
