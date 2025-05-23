package com.tenpay.sdk.net.sso;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qphone.base.BaseConstants;
import com.tenpay.sdk.net.callback.CallbackThreadEnum;
import com.tenpay.sdk.net.callback.PayCallbackCenter;
import com.tenpay.sdk.net.callback.ThreadCallback;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.task.base.Task;
import com.tenpay.sdk.net.utils.ThreadUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002Jn\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001f"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoService;", "", "()V", "TAG", "", "ssoClient", "Lcom/tenpay/sdk/net/sso/PaySsoClient;", "getSsoClient", "()Lcom/tenpay/sdk/net/sso/PaySsoClient;", "ssoClient$delegate", "Lkotlin/Lazy;", "sendRequest", "Lcom/tenpay/sdk/net/core/task/base/Task;", "context", "Landroid/content/Context;", "baseUrl", "uin", "isEncrypt", "", "isEcdhEncrypt", BaseConstants.ATTR_KET_EXTRA_MAP, "", "paySsoCmd", "Lcom/tenpay/sdk/net/sso/PaySsoCmd;", "callbackOnThread", "Lcom/tenpay/sdk/net/callback/CallbackThreadEnum;", "callback", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "Lcom/tenpay/sdk/net/sso/PaySsoResult;", Const.BUNDLE_KEY_REQUEST, "Lcom/tenpay/sdk/net/sso/PaySsoRequest;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaySsoService {

    @NotNull
    public static final PaySsoService INSTANCE = new PaySsoService();

    @NotNull
    public static final String TAG = "QWalletHttp-PaySsoService";

    /* renamed from: ssoClient$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy ssoClient;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PaySsoClient>() { // from class: com.tenpay.sdk.net.sso.PaySsoService$ssoClient$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PaySsoClient invoke() {
                return new PaySsoClient().newInstance$qwallet_impl_release(":" + MobileQQ.sProcessId, 4, ThreadUtils.INSTANCE.createDefaultThreadPool("QWSSOThread"));
            }
        });
        ssoClient = lazy;
    }

    PaySsoService() {
    }

    private final PaySsoClient getSsoClient() {
        return (PaySsoClient) ssoClient.getValue();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Task sendRequest(@Nullable Context context, @NotNull String baseUrl, @Nullable String str, boolean z16, boolean z17, @Nullable Map<String, String> map, @NotNull PaySsoCmd paySsoCmd, @Nullable NetCallback<PaySsoResult> netCallback) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(paySsoCmd, "paySsoCmd");
        return sendRequest$default(context, baseUrl, str, z16, z17, map, paySsoCmd, null, netCallback, 128, null);
    }

    public static /* synthetic */ Task sendRequest$default(Context context, String str, String str2, boolean z16, boolean z17, Map map, PaySsoCmd paySsoCmd, CallbackThreadEnum callbackThreadEnum, NetCallback netCallback, int i3, Object obj) {
        CallbackThreadEnum callbackThreadEnum2;
        if ((i3 & 128) != 0) {
            callbackThreadEnum2 = CallbackThreadEnum.MAIN;
        } else {
            callbackThreadEnum2 = callbackThreadEnum;
        }
        return sendRequest(context, str, str2, z16, z17, map, paySsoCmd, callbackThreadEnum2, netCallback);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Task sendRequest(@Nullable Context context, @NotNull String baseUrl, @Nullable String uin, boolean isEncrypt, boolean isEcdhEncrypt, @Nullable Map<String, String> extraMap, @NotNull PaySsoCmd paySsoCmd, @NotNull CallbackThreadEnum callbackOnThread, @Nullable NetCallback<PaySsoResult> callback) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(paySsoCmd, "paySsoCmd");
        Intrinsics.checkNotNullParameter(callbackOnThread, "callbackOnThread");
        PaySsoRequest paySsoRequest = new PaySsoRequest(baseUrl, uin, isEncrypt, isEcdhEncrypt, extraMap, paySsoCmd, new ThreadCallback(callbackOnThread, callback), new WeakReference(context));
        paySsoRequest.setNetCallback(PayCallbackCenter.INSTANCE);
        return INSTANCE.sendRequest(paySsoRequest);
    }

    @NotNull
    public final Task sendRequest(@NotNull PaySsoRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return getSsoClient().send(request);
    }
}
