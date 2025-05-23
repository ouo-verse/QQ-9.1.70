package com.tenpay.sdk.net.sso;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.request.CallbackDelegateAbility;
import com.tenpay.sdk.net.core.request.ContextAbility;
import com.tenpay.sdk.net.core.request.NetRequest;
import com.tenpay.sdk.net.core.request.RetryAbility;
import com.tenpay.sdk.net.core.task.base.Priority;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00020\u0005Bm\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0015J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011H\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010)\u001a\u00020#2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010+H\u0016R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a\u00a8\u0006,"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoRequest;", "Lcom/tenpay/sdk/net/core/request/NetRequest;", "Lcom/tenpay/sdk/net/sso/PaySsoResult;", "Lcom/tenpay/sdk/net/core/request/ContextAbility;", "Lcom/tenpay/sdk/net/core/request/RetryAbility;", "Lcom/tenpay/sdk/net/core/request/CallbackDelegateAbility;", "originUrl", "", "uin", "isEncrypt", "", "isEcdhEncrypt", "paramMap", "", "paySsoCmd", "Lcom/tenpay/sdk/net/sso/PaySsoCmd;", "bizCallback", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "contextRef", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lcom/tenpay/sdk/net/sso/PaySsoCmd;Lcom/tenpay/sdk/net/core/callback/NetCallback;Lmqq/util/WeakReference;)V", "getBizCallback", "()Lcom/tenpay/sdk/net/core/callback/NetCallback;", "fullUrl", "getFullUrl", "()Ljava/lang/String;", "()Z", "setEcdhEncrypt", "(Z)V", "getOriginUrl", "getPaySsoCmd", "()Lcom/tenpay/sdk/net/sso/PaySsoCmd;", "getUin", "forbidEcdhAes", "", "getAccount", "getCmd", "getContext", "getDelegate", "rebuildUrl", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "inExtraMap", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaySsoRequest extends NetRequest<PaySsoResult> implements ContextAbility, RetryAbility, CallbackDelegateAbility<PaySsoResult> {

    @Nullable
    private final NetCallback<PaySsoResult> bizCallback;

    @Nullable
    private final WeakReference<Context> contextRef;

    @NotNull
    private final String fullUrl;
    private boolean isEcdhEncrypt;
    private final boolean isEncrypt;

    @NotNull
    private final String originUrl;

    @NotNull
    private final PaySsoCmd paySsoCmd;

    @Nullable
    private final String uin;

    public /* synthetic */ PaySsoRequest(String str, String str2, boolean z16, boolean z17, Map map, PaySsoCmd paySsoCmd, NetCallback netCallback, WeakReference weakReference, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z16, z17, (i3 & 16) != 0 ? null : map, paySsoCmd, (i3 & 64) != 0 ? null : netCallback, (i3 & 128) != 0 ? null : weakReference);
    }

    private final String rebuildUrl(String originUrl) {
        boolean contains$default;
        String str;
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
        this.isEcdhEncrypt = false;
    }

    @Override // com.tenpay.sdk.net.core.request.NetRequest
    @NotNull
    public String getAccount() {
        String str = this.uin;
        if (str == null) {
            return super.getAccount();
        }
        return str;
    }

    @Nullable
    public final NetCallback<PaySsoResult> getBizCallback() {
        return this.bizCallback;
    }

    @Override // com.tenpay.sdk.net.core.request.RetryAbility
    @NotNull
    /* renamed from: getCmd, reason: from getter */
    public String getOriginUrl() {
        return this.originUrl;
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
    public NetCallback<PaySsoResult> getDelegate() {
        return this.bizCallback;
    }

    @NotNull
    public final String getFullUrl() {
        return this.fullUrl;
    }

    @NotNull
    public final String getOriginUrl() {
        return this.originUrl;
    }

    @NotNull
    public final PaySsoCmd getPaySsoCmd() {
        return this.paySsoCmd;
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: isEcdhEncrypt, reason: from getter */
    public final boolean getIsEcdhEncrypt() {
        return this.isEcdhEncrypt;
    }

    /* renamed from: isEncrypt, reason: from getter */
    public final boolean getIsEncrypt() {
        return this.isEncrypt;
    }

    @Override // com.tenpay.sdk.net.core.request.RetryAbility
    public void retry(@Nullable Map<String, String> inExtraMap) {
        Map<String, String> paramMap;
        if (inExtraMap != null && (paramMap = getParamMap()) != null) {
            paramMap.putAll(inExtraMap);
        }
        PaySsoService.INSTANCE.sendRequest(this);
    }

    public final void setEcdhEncrypt(boolean z16) {
        this.isEcdhEncrypt = z16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaySsoRequest(@NotNull String originUrl, @Nullable String str, boolean z16, boolean z17, @Nullable Map<String, String> map, @NotNull PaySsoCmd paySsoCmd, @Nullable NetCallback<PaySsoResult> netCallback, @Nullable WeakReference<Context> weakReference) {
        super(map, Priority.NORMAL_PRIORITY, null, 4, null);
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intrinsics.checkNotNullParameter(paySsoCmd, "paySsoCmd");
        this.originUrl = originUrl;
        this.uin = str;
        this.isEncrypt = z16;
        this.isEcdhEncrypt = z17;
        this.paySsoCmd = paySsoCmd;
        this.bizCallback = netCallback;
        this.contextRef = weakReference;
        this.fullUrl = rebuildUrl(originUrl);
    }
}
