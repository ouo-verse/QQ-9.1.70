package com.tencent.hippy.qq.api.impl;

import android.content.Context;
import com.tencent.hippy.qq.adapter.image.HippyQQImageView;
import com.tencent.hippy.qq.adapter.image.HippyQQImageViewController;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.IHippyInnerApi;
import com.tencent.hippy.qq.interpolators.HippyInterpolatorConfig;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/hippy/qq/api/impl/HippyInnerApiImpl;", "Lcom/tencent/hippy/qq/api/IHippyInnerApi;", "()V", "getHippyInterpolator", "Lcom/tencent/hippy/qq/api/HippyInterpolator;", "bundleName", "", "getHippyQQImageView", "Lcom/tencent/mtt/hippy/views/image/HippyImageView;", "context", "Landroid/content/Context;", "getHippyQQImageViewController", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/views/image/HippyImageViewController;", "hippy-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippyInnerApiImpl implements IHippyInnerApi {
    @Override // com.tencent.hippy.qq.api.IHippyInnerApi
    @Nullable
    public HippyInterpolator getHippyInterpolator(@NotNull String bundleName) {
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        return HippyInterpolatorConfig.getInterpolator(bundleName);
    }

    @Override // com.tencent.hippy.qq.api.IHippyInnerApi
    @NotNull
    public HippyImageView getHippyQQImageView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new HippyQQImageView(context);
    }

    @Override // com.tencent.hippy.qq.api.IHippyInnerApi
    @NotNull
    public Class<? extends HippyImageViewController> getHippyQQImageViewController() {
        return HippyQQImageViewController.class;
    }
}
