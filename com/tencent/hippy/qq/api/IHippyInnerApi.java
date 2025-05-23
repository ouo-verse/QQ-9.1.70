package com.tencent.hippy.qq.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/hippy/qq/api/IHippyInnerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getHippyInterpolator", "Lcom/tencent/hippy/qq/api/HippyInterpolator;", "bundleName", "", "getHippyQQImageView", "Lcom/tencent/mtt/hippy/views/image/HippyImageView;", "context", "Landroid/content/Context;", "getHippyQQImageViewController", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/views/image/HippyImageViewController;", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyInnerApi extends QRouteApi {
    @Nullable
    HippyInterpolator getHippyInterpolator(@NotNull String bundleName);

    @NotNull
    HippyImageView getHippyQQImageView(@NotNull Context context);

    @NotNull
    Class<? extends HippyImageViewController> getHippyQQImageViewController();
}
