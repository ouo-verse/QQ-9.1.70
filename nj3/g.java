package nj3;

import android.content.Intent;
import com.tencent.filament.zplanservice.pbjava.WebViewChannel$OpenUrlRequest;
import com.tencent.filament.zplanservice.pbjava.WebViewChannel$OpenUrlResponse;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lnj3/g;", "Lel0/h;", "Lcom/tencent/filament/zplanservice/pbjava/WebViewChannel$OpenUrlRequest;", "req", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/WebViewChannel$OpenUrlResponse;", "", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IWebViewChannelResponse;", "callback", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g implements el0.h {
    @Override // el0.h
    public void a(WebViewChannel$OpenUrlRequest req, Function1<? super WebViewChannel$OpenUrlResponse, Unit> callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("QQWebViewChannelProxy", 1, "openUrl : " + req.url.get());
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.putExtra("url", req.url.get());
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
        WebViewChannel$OpenUrlResponse webViewChannel$OpenUrlResponse = new WebViewChannel$OpenUrlResponse();
        webViewChannel$OpenUrlResponse.success.set(true);
        callback.invoke(webViewChannel$OpenUrlResponse);
    }
}
