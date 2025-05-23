package com.qwallet.temp.hippy;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/qwallet/temp/hippy/IHippyWebViewTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getQQHippyWebView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getQQHippyWebViewControllerClazz", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/uimanager/HippyViewController;", "qqpay_temp_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IHippyWebViewTempApi extends QRouteApi {
    @NotNull
    View getQQHippyWebView(@NotNull Context context);

    @NotNull
    Class<? extends HippyViewController<?>> getQQHippyWebViewControllerClazz();
}
