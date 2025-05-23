package com.tenpay.sdk.net.sso;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$TransInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tenpay.sdk.net.core.cookie.PayCookieLogic;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.gateway.data.TransInfoOutput;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoCookie;", "", "()V", "COOKIE_REQ_KEY", "", "loadForRequest", "", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$TransInfo;", "url", "saveFromResponse", "", "transInfoOutput", "Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaySsoCookie {

    @NotNull
    private static final String COOKIE_REQ_KEY = "Cookie";

    @NotNull
    public static final PaySsoCookie INSTANCE = new PaySsoCookie();

    PaySsoCookie() {
    }

    @NotNull
    public final List<PayGatewayProto$TransInfo> loadForRequest(@NotNull String url) {
        List<PayGatewayProto$TransInfo> emptyList;
        int collectionSizeOrDefault;
        List<PayGatewayProto$TransInfo> emptyList2;
        Intrinsics.checkNotNullParameter(url, "url");
        if (!((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_COOKIE_JAR_ENABLE, false)) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        try {
            String host = new URL(url).getHost();
            PayCookieLogic payCookieLogic = PayCookieLogic.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(host, "host");
            List<Cookie> loadForRequest = payCookieLogic.loadForRequest(host);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(loadForRequest, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Cookie cookie : loadForRequest) {
                PayGatewayProto$TransInfo payGatewayProto$TransInfo = new PayGatewayProto$TransInfo();
                payGatewayProto$TransInfo.key.set("Cookie");
                payGatewayProto$TransInfo.value.set(ByteStringMicro.copyFromUtf8(cookie.name() + ContainerUtils.KEY_VALUE_DELIMITER + cookie.value()));
                arrayList.add(payGatewayProto$TransInfo);
            }
            return arrayList;
        } catch (Exception e16) {
            DLog.INSTANCE.w(PayCookieLogic.TAG, "sso loadCookie error:", e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    public final void saveFromResponse(@NotNull String url, @Nullable TransInfoOutput transInfoOutput) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(url, "url");
        if (!((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_COOKIE_JAR_ENABLE, false)) {
            return;
        }
        try {
            HttpUrl parse = HttpUrl.INSTANCE.parse(url);
            if (parse == null || transInfoOutput == null) {
                return;
            }
            List<String> cookieSet = transInfoOutput.getCookieSet();
            if (cookieSet != null) {
                arrayList = new ArrayList();
                Iterator<T> it = cookieSet.iterator();
                while (it.hasNext()) {
                    Cookie parse2 = Cookie.INSTANCE.parse(parse, (String) it.next());
                    if (parse2 != null) {
                        arrayList.add(parse2);
                    }
                }
            } else {
                arrayList = null;
            }
            PayCookieLogic.INSTANCE.saveFromResponse(parse.host(), arrayList);
        } catch (Exception e16) {
            DLog.INSTANCE.w(PayCookieLogic.TAG, "sso saveCookie error:", e16);
        }
    }
}
