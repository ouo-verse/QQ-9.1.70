package com.tenpay.sdk.net.http.interceptor;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.oskplayer.util.SecretUtils;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.net.core.comm.SessionKey;
import com.tenpay.sdk.net.core.encrypt.DecryptResult;
import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import com.tenpay.sdk.net.core.processor.EncryptProcessor;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.http.request.CgiBizData;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/sdk/net/http/interceptor/EncryptInterceptor;", "Lokhttp3/Interceptor;", "()V", "encryptProcessor", "Lcom/tenpay/sdk/net/core/processor/EncryptProcessor;", "appendExtra", "", "url", "finalExtra", "getGuid", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class EncryptInterceptor implements Interceptor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final EncryptProcessor encryptProcessor = new EncryptProcessor();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/sdk/net/http/interceptor/EncryptInterceptor$Companion;", "", "()V", "tag", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String tag() {
            return "QWalletHttp-Encrypt(" + Thread.currentThread().getName() + ")";
        }

        Companion() {
        }
    }

    private final String appendExtra(String url, String finalExtra) {
        return url + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + finalExtra + ContainerUtils.FIELD_DELIMITER + NetUtil.getDeviceInfo(MobileQQ.sMobileQQ.getApplicationContext(), getGuid());
    }

    private final String getGuid() {
        boolean z16;
        String hexGuid = ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).hexGuid();
        if (hexGuid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            hexGuid = ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).ipcGetGuid();
            if (hexGuid == null) {
                hexGuid = "";
            }
            f.c(INSTANCE.tag(), "ipc guid = " + hexGuid);
        }
        return hexGuid;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Map<String, String> map;
        String substringAfterLast$default;
        String substringBefore$default;
        String str;
        String str2;
        String str3;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        CgiBizData cgiBizData = (CgiBizData) request.tag(CgiBizData.class);
        MediaType mediaType = null;
        if (cgiBizData != null) {
            map = cgiBizData.getExtraData();
        } else {
            map = null;
        }
        if (map == null) {
            return chain.proceed(request);
        }
        StatisticInfo statisticInfo = (StatisticInfo) chain.request().tag(StatisticInfo.class);
        String url = chain.request().url().url().toString();
        Intrinsics.checkNotNullExpressionValue(url, "chain.request().url.toUrl().toString()");
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(url, '/', (String) null, 2, (Object) null);
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(substringAfterLast$default, '.', (String) null, 2, (Object) null);
        SessionKey sessionKey = new SessionKey(substringBefore$default, cgiBizData.getPsKey(), cgiBizData.getUin());
        EncryptProcessor.ProcessResult processEncrypt = this.encryptProcessor.processEncrypt(url, sessionKey, cgiBizData.getExtraData(), cgiBizData.isEncrypt(), cgiBizData.isEcdhEncrypt(), statisticInfo);
        if (!cgiBizData.isEncrypt()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(processEncrypt.getFinalExtra().entrySet(), ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<Map.Entry<String, String>, CharSequence>() { // from class: com.tenpay.sdk.net.http.interceptor.EncryptInterceptor$intercept$finalExtra$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull Map.Entry<String, String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((Object) it.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((Object) it.getValue());
                }
            }, 30, null);
            url = appendExtra(url, joinToString$default);
        }
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.url(url);
        FormBody.Builder builder = new FormBody.Builder(null, 1, null);
        Iterator<Map.Entry<String, String>> it = processEncrypt.getBodyData().entrySet().iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            String value = next.getValue();
            if (value != null) {
                str = value;
            }
            builder.add(key, str);
        }
        newBuilder.post(builder.build());
        Request build = newBuilder.build();
        String tag = INSTANCE.tag();
        if (cgiBizData.isEcdhEncrypt()) {
            str2 = "ecdh";
        } else {
            str2 = SecretUtils.DES;
        }
        f.b(tag, "after " + str2 + " encrypt: " + processEncrypt.getBodyData());
        Response proceed = chain.proceed(build);
        EncryptProcessor encryptProcessor = this.encryptProcessor;
        boolean isSuccessful = proceed.isSuccessful();
        boolean isEcdhEncrypt = cgiBizData.isEcdhEncrypt();
        EncryptResult encryptResult = processEncrypt.getEncryptResult();
        ResponseBody body = proceed.body();
        if (body != null) {
            str3 = body.string();
        } else {
            str3 = null;
        }
        DecryptResult processDecrypt = encryptProcessor.processDecrypt(isSuccessful, isEcdhEncrypt, sessionKey, encryptResult, statisticInfo, str3);
        if (processDecrypt == null) {
            return proceed;
        }
        ResponseBody.Companion companion = ResponseBody.INSTANCE;
        ResponseBody body2 = proceed.body();
        if (body2 != null) {
            mediaType = body2.get$contentType();
        }
        String decodedPlain = processDecrypt.getDecodedPlain();
        if (decodedPlain != null) {
            str = decodedPlain;
        }
        return proceed.newBuilder().body(companion.create(mediaType, str)).build();
    }
}
