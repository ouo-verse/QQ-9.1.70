package com.tencent.hippy.qq.api;

import com.tencent.hippy.qq.utils.screenshot.ShareImageUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/hippy/qq/api/ShareResultCallbackBase;", "", "shareResultCallback", "Lcom/tencent/hippy/qq/utils/screenshot/ShareImageUtils$ShareResultCallBack;", "getShareResultCallback", "()Lcom/tencent/hippy/qq/utils/screenshot/ShareImageUtils$ShareResultCallBack;", "setShareResultCallback", "(Lcom/tencent/hippy/qq/utils/screenshot/ShareImageUtils$ShareResultCallBack;)V", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public interface ShareResultCallbackBase {
    @Nullable
    ShareImageUtils.ShareResultCallBack getShareResultCallback();

    void setShareResultCallback(@Nullable ShareImageUtils.ShareResultCallBack shareResultCallBack);
}
