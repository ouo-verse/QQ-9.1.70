package com.tencent.mobileqq.qwallet.jsp;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.qwallet.protocol.Wallet.pb.pet.PetRank$GenArkTokenRsp;
import com.qwallet.temp.IPayShareMsgTempApi;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J=\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/FinancialPetShareArkMessageHandler;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$b;", "runtime", "Landroid/app/Activity;", tl.h.F, "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "", "c", "Lcom/tencent/mobileqq/webview/swift/y;", "uiInterface", "e", "d", "Lorg/json/JSONObject;", "jsonData", "", "", "args", "jsCallback", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "Lcom/qwallet/temp/IPayShareMsgTempApi;", "Lcom/qwallet/temp/IPayShareMsgTempApi;", "tempApi", "", "b", "Ljava/lang/Object;", "shareMsgImpl", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class FinancialPetShareArkMessageHandler extends QWalletJsPlugin.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPayShareMsgTempApi tempApi = (IPayShareMsgTempApi) QRoute.api(IPayShareMsgTempApi.class);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object shareMsgImpl;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qwallet/jsp/FinancialPetShareArkMessageHandler$b", "Lcom/qwallet/temp/IPayShareMsgTempApi$a;", "", "callbackId", "result", "", "a", "Landroid/content/Intent;", "intent", "", "requestCode", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements IPayShareMsgTempApi.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewPlugin f278530a;

        b(WebViewPlugin webViewPlugin) {
            this.f278530a = webViewPlugin;
        }

        @Override // com.qwallet.temp.IPayShareMsgTempApi.a
        public void a(@Nullable String callbackId, @Nullable String result) {
            if (!TextUtils.isEmpty(callbackId)) {
                this.f278530a.callJs(callbackId, result);
            }
        }

        @Override // com.qwallet.temp.IPayShareMsgTempApi.a
        public void startActivityForResult(@Nullable Intent intent, byte requestCode) {
            this.f278530a.startActivityForResult(intent, requestCode);
        }
    }

    private final Activity h(WebViewPlugin.b runtime) {
        Activity activity = runtime.a();
        while (activity instanceof BasePluginActivity) {
            activity = ((BasePluginActivity) activity).getOutActivity();
        }
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        return activity;
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.c
    public void a(@NotNull final WebViewPlugin plugin, @Nullable final JSONObject jsonData, @NotNull String[] args, @Nullable final String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(args, "args");
        hl2.a.f405243a.b(new Function2<Integer, PetRank$GenArkTokenRsp, Unit>() { // from class: com.tencent.mobileqq.qwallet.jsp.FinancialPetShareArkMessageHandler$handleRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, PetRank$GenArkTokenRsp petRank$GenArkTokenRsp) {
                invoke(num.intValue(), petRank$GenArkTokenRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable PetRank$GenArkTokenRsp petRank$GenArkTokenRsp) {
                IPayShareMsgTempApi iPayShareMsgTempApi;
                Object obj;
                Iterator keys;
                IPayShareMsgTempApi iPayShareMsgTempApi2;
                Integer num;
                IPayShareMsgTempApi iPayShareMsgTempApi3;
                if (petRank$GenArkTokenRsp != null) {
                    FinancialPetShareArkMessageHandler financialPetShareArkMessageHandler = FinancialPetShareArkMessageHandler.this;
                    JSONObject jSONObject = jsonData;
                    String str = jsCallback;
                    WebViewPlugin webViewPlugin = plugin;
                    try {
                        QLog.d("QWallet.Pet.FinancialPetShareArkMessageHandler", 2, "[handleRequest] sign:" + petRank$GenArkTokenRsp.sign.get());
                        String str2 = petRank$GenArkTokenRsp.sign.get();
                        JSONObject jSONObject2 = null;
                        if (str2 != null) {
                            JSONObject jSONObject3 = new JSONObject(str2);
                            String optString = jSONObject3.optString("app");
                            String optString2 = jSONObject3.optString("view");
                            String optString3 = jSONObject3.optString(PublicAccountMessageUtilImpl.META_NAME);
                            String optString4 = jSONObject3.optString("ver");
                            String optString5 = jSONObject3.optString(DownloadInfo.spKey_Config);
                            String optString6 = jSONObject3.optString("desc");
                            String optString7 = jSONObject3.optString("prompt");
                            iPayShareMsgTempApi2 = financialPetShareArkMessageHandler.tempApi;
                            if (iPayShareMsgTempApi2 != null) {
                                num = Integer.valueOf(iPayShareMsgTempApi2.convertShareType(jSONObject != null ? jSONObject.optInt("shareSupportType") : 0));
                            } else {
                                num = null;
                            }
                            IPayShareMsgTempApi.ShareArkParam shareArkParam = new IPayShareMsgTempApi.ShareArkParam(optString, optString2, optString3, optString4, optString5, optString6, optString7, num);
                            iPayShareMsgTempApi3 = financialPetShareArkMessageHandler.tempApi;
                            if (iPayShareMsgTempApi3 != null) {
                                jSONObject2 = iPayShareMsgTempApi3.buildArkMsgParamJSON(shareArkParam);
                            }
                        }
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        if (jSONObject2 != null && (keys = jSONObject2.keys()) != null) {
                            Intrinsics.checkNotNullExpressionValue(keys, "keys()");
                            while (keys.hasNext()) {
                                String str3 = (String) keys.next();
                                jSONObject.put(str3, jSONObject2.get(str3));
                            }
                        }
                        iPayShareMsgTempApi = financialPetShareArkMessageHandler.tempApi;
                        if (iPayShareMsgTempApi != null) {
                            obj = financialPetShareArkMessageHandler.shareMsgImpl;
                            iPayShareMsgTempApi.shareArkMsgToQQ(1059, obj, jSONObject, false);
                        }
                    } catch (Exception e16) {
                        QLog.e("QWallet.Pet.FinancialPetShareArkMessageHandler", 1, e16, new Object[0]);
                        if (str != null) {
                            webViewPlugin.callJs(str, "{\"result\":3}");
                        }
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.b
    public void c(@NotNull WebViewPlugin plugin) {
        Object obj;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        WebViewPlugin.b bVar = plugin.mRuntime;
        if (bVar != null && bVar.b() != null) {
            IPayShareMsgTempApi iPayShareMsgTempApi = this.tempApi;
            if (iPayShareMsgTempApi != null) {
                WebViewPlugin.b bVar2 = plugin.mRuntime;
                Intrinsics.checkNotNullExpressionValue(bVar2, "plugin.mRuntime");
                Activity h16 = h(bVar2);
                Activity a16 = plugin.mRuntime.a();
                AppInterface b16 = plugin.mRuntime.b();
                Intrinsics.checkNotNullExpressionValue(b16, "plugin.mRuntime.app");
                obj = iPayShareMsgTempApi.createShareMsgImpl(h16, a16, b16, new b(plugin));
            } else {
                obj = null;
            }
            this.shareMsgImpl = obj;
            IPayShareMsgTempApi iPayShareMsgTempApi2 = this.tempApi;
            if (iPayShareMsgTempApi2 != null) {
                iPayShareMsgTempApi2.initWebInterface(obj, plugin);
                return;
            }
            return;
        }
        QLog.w("QWallet.Pet.FinancialPetShareArkMessageHandler", 1, "onCreate but runtime is null");
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.b
    public void d() {
        IPayShareMsgTempApi iPayShareMsgTempApi = this.tempApi;
        if (iPayShareMsgTempApi != null) {
            iPayShareMsgTempApi.onShareMsgImplDestroy(this.shareMsgImpl);
        }
        this.shareMsgImpl = null;
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.b
    public void e(@Nullable y uiInterface) {
        IPayShareMsgTempApi iPayShareMsgTempApi = this.tempApi;
        if (iPayShareMsgTempApi != null) {
            iPayShareMsgTempApi.onShareMsgImplSetWebUiInterface(this.shareMsgImpl, uiInterface);
        }
    }
}
