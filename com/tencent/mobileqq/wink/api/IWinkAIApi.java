package com.tencent.mobileqq.wink.api;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\r\u001a\u00020\u0005H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IWinkAIApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "imagePath", "originText", "", "useCache", "Lcom/tencent/mobileqq/wink/api/e;", "imageTextResponseCallback", "", "requestImageText", "cancelImageText", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "enableAIAvatar", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkAIApi extends QRouteApi {
    void cancelImageText(@NotNull String imagePath);

    void clearCache(@Nullable String imagePath);

    boolean enableAIAvatar();

    void requestImageText(@NotNull String imagePath, @NotNull String originText, boolean useCache, @NotNull e imageTextResponseCallback);
}
