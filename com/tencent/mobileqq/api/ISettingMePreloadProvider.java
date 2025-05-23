package com.tencent.mobileqq.api;

import android.content.Context;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.webbundle.sdk.WebBundleConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/api/ISettingMePreloadProvider;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", WebBundleConstants.EVENT_TYPE_OF_PRELOAD_VIEW, "", "context", "Landroid/content/Context;", "preLoader", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "drawer-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ISettingMePreloadProvider extends QRouteApi {
    void preloadView(@NotNull Context context, @NotNull RFWLayoutPreLoader preLoader);
}
