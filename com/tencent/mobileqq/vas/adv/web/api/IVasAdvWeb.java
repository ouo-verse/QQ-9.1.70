package com.tencent.mobileqq.vas.adv.web.api;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/api/IVasAdvWeb;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Publisher;", "getWebView", "Lcom/tencent/biz/ui/TouchWebView;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "initWebView", "", "removeWebView", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAdvWeb extends QRouteApi, VasAdvWebEvent.Publisher {
    @Nullable
    TouchWebView getWebView(@NotNull Activity activity);

    void initWebView();

    void removeWebView();
}
