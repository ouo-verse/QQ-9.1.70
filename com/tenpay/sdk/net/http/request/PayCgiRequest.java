package com.tenpay.sdk.net.http.request;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.request.CallbackDelegateAbility;
import com.tenpay.sdk.net.core.request.ContextAbility;
import com.tenpay.sdk.net.core.request.RetryAbility;
import com.tenpay.sdk.net.http.PayCgiService;
import com.tenpay.sdk.net.http.common.HttpConst;
import com.tenpay.sdk.net.http.result.HttpResult;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004Bm\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u001b\u001a\u00020\u00152\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tenpay/sdk/net/http/request/PayCgiRequest;", "Lcom/tenpay/sdk/net/http/request/HttpRequest;", "Lcom/tenpay/sdk/net/core/request/ContextAbility;", "Lcom/tenpay/sdk/net/core/request/RetryAbility;", "Lcom/tenpay/sdk/net/core/request/CallbackDelegateAbility;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "originUrl", "", "headerMap", "", "paramMap", "", "bizData", "", "bizCallback", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "contextRef", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Object;Lcom/tenpay/sdk/net/core/callback/NetCallback;Lmqq/util/WeakReference;)V", "forbidEcdhAes", "", "getAccount", "getCmd", "getContext", "getDelegate", "rebuildUrl", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, BaseConstants.ATTR_KET_EXTRA_MAP, "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayCgiRequest extends HttpRequest implements ContextAbility, RetryAbility, CallbackDelegateAbility<HttpResult> {

    @Nullable
    private final NetCallback<HttpResult> bizCallback;

    @Nullable
    private final WeakReference<Context> contextRef;

    public /* synthetic */ PayCgiRequest(String str, Map map, Map map2, Object obj, NetCallback netCallback, WeakReference weakReference, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : map, (i3 & 4) != 0 ? null : map2, obj, (i3 & 16) != 0 ? null : netCallback, (i3 & 32) != 0 ? null : weakReference);
    }

    private final String rebuildUrl(String originUrl) {
        boolean startsWith;
        boolean contains$default;
        String str;
        startsWith = StringsKt__StringsJVMKt.startsWith(originUrl, "http", true);
        if (startsWith) {
            return originUrl;
        }
        StringBuffer stringBuffer = new StringBuffer();
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) originUrl, (CharSequence) "mqq.tenpay.com", false, 2, (Object) null);
        if (!contains$default) {
            if (TextUtils.isEmpty(Cgi.wallet_domain)) {
                str = Cgi.DOMAIN_YUN_SERVER;
            } else {
                str = Cgi.wallet_domain;
            }
            stringBuffer.append("https://" + str);
        }
        stringBuffer.append(originUrl);
        stringBuffer.append("ver=2.0&chv=3");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "StringBuffer().apply {\n \u2026=3\")\n        }.toString()");
        return stringBuffer2;
    }

    @Override // com.tenpay.sdk.net.core.request.RetryAbility
    public void forbidEcdhAes() {
        Object obj;
        Iterator<T> it = getTagList().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (obj instanceof CgiBizData) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        CgiBizData cgiBizData = (CgiBizData) obj;
        if (cgiBizData == null) {
            return;
        }
        cgiBizData.setEcdhEncrypt(false);
    }

    @Override // com.tenpay.sdk.net.core.request.NetRequest
    @NotNull
    public String getAccount() {
        Object obj;
        String uin;
        Iterator<T> it = getTagList().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (obj instanceof CgiBizData) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        CgiBizData cgiBizData = (CgiBizData) obj;
        if (cgiBizData == null || (uin = cgiBizData.getUin()) == null) {
            return super.getAccount();
        }
        return uin;
    }

    @Override // com.tenpay.sdk.net.core.request.RetryAbility
    @NotNull
    /* renamed from: getCmd */
    public String getOriginUrl() {
        return getOriginUrl();
    }

    @Override // com.tenpay.sdk.net.core.request.ContextAbility
    @Nullable
    public Context getContext() {
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tenpay.sdk.net.core.request.CallbackDelegateAbility
    @Nullable
    public NetCallback<HttpResult> getDelegate() {
        return this.bizCallback;
    }

    @Override // com.tenpay.sdk.net.core.request.RetryAbility
    public void retry(@Nullable Map<String, String> extraMap) {
        Object obj;
        if (extraMap != null) {
            Iterator<T> it = getTagList().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (obj instanceof CgiBizData) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            CgiBizData cgiBizData = (CgiBizData) obj;
            if (cgiBizData == null) {
                return;
            }
            cgiBizData.getExtraData().putAll(extraMap);
            Map<String, String> paramMap = getParamMap();
            if (paramMap != null) {
                paramMap.putAll(extraMap);
            }
        }
        PayCgiService.INSTANCE.sendRequest(this);
    }

    @NotNull
    public String toString() {
        return PayCgiRequest.class.getSimpleName() + " " + getOriginUrl();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayCgiRequest(@NotNull String originUrl, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable Object obj, @Nullable NetCallback<HttpResult> netCallback, @Nullable WeakReference<Context> weakReference) {
        super(originUrl, map, map2, HttpConst.MethodType.POST, null, 16, null);
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        this.bizCallback = netCallback;
        this.contextRef = weakReference;
        if (obj != null) {
            getTagList().add(obj);
        }
        setRequestUrl(rebuildUrl(originUrl));
    }
}
