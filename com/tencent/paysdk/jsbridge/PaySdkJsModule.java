package com.tencent.paysdk.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.p004if.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$UserInfo;
import com.tencent.paysdk.api.IUserInfoProvider;
import com.tencent.paysdk.api.g;
import com.tencent.paysdk.api.i;
import com.tencent.paysdk.api.j;
import com.tencent.paysdk.api.l;
import com.tencent.paysdk.api.o;
import com.tencent.paysdk.api.q;
import com.tencent.paysdk.core.JsDelegatorDecorator;
import com.tencent.paysdk.data.VideoInfo;
import com.tencent.paysdk.util.ThreadCenter;
import com.tencent.paysdk.util.f;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.vivo.push.PushClientConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B9\u0012\b\u0010A\u001a\u0004\u0018\u000102\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u0012\b\u0010D\u001a\u0004\u0018\u000105\u0012\b\u0010E\u001a\u0004\u0018\u000108\u0012\b\u0010F\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\bG\u0010HJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J$\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0002J.\u0010\u000e\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J,\u0010\u0014\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u001c\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010\u0016\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010\u0018\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010\u0019\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0006\u0010\u001a\u001a\u00020\u0005J\u001c\u0010\u001b\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010\u001c\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001e\u0010\u001d\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J\u001c\u0010\u001e\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0017J\u001c\u0010\u001f\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010 \u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010!\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010\"\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001c\u0010#\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001e\u0010$\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J \u0010%\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0007J \u0010&\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0007J \u0010'\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0007J\u001c\u0010(\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u001e\u0010)\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J\u0006\u0010*\u001a\u00020\u0005J\u001a\u0010-\u001a\u00020\u00052\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050+J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0004\u0018\u0001088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R$\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u0004\u0018\u0001028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\u00a8\u0006I"}, d2 = {"Lcom/tencent/paysdk/jsbridge/PaySdkJsModule;", "Lcom/tencent/paysdk/jsbridge/b;", "", "event", "params", "", "dispatchEvent", "", "", "sucCallbackToWeb", "errMsg", "errCallbackToWeb", "", "errCode", "commonCallbackToWeb", "Lcom/tencent/paysdk/api/l;", "targetJsDelegator", "", "isSameDelegate", "code", "onLoginCallback", "onH5LoadFinish", w.NAME, "replayVideo", "startPreview", "setH5LayoutParams", "onPageAppear", "onPayFinish", "hideBackButton", "publishMsgToAllWebView", "closeH5", "close", "openWebview", "openUrl", "writeLog", "actionLogin", "refreshWKcookie", "getMainUserInfo", "getAppInfo", "getDeviceInfo", "unlockVideo", "doH5Report", "onWebBack", "Lkotlin/Function1;", "safeReplay", "setReplayFun", "getName", "onJsDestroy", "TAG", "Ljava/lang/String;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "Lcom/tencent/paysdk/api/c;", "mAuthTaskProvider", "Lcom/tencent/paysdk/api/c;", "Lcom/tencent/paysdk/vipauth/b;", "mIVipInternalJSInterface", "Lcom/tencent/paysdk/vipauth/b;", "mJsDelegate", "Lcom/tencent/paysdk/api/l;", "mSafeReplay", "Lkotlin/jvm/functions/Function1;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/paysdk/api/o;", "webView", "authTaskProvider", "iVipInternalJSInterface", "jsDelegate", "<init>", "(Landroid/content/Context;Lcom/tencent/paysdk/api/o;Lcom/tencent/paysdk/api/c;Lcom/tencent/paysdk/vipauth/b;Lcom/tencent/paysdk/api/l;)V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public class PaySdkJsModule extends b {
    static IPatchRedirector $redirector_;
    private final String TAG;
    private final com.tencent.paysdk.api.c mAuthTaskProvider;
    private final Context mContext;
    private final com.tencent.paysdk.vipauth.b mIVipInternalJSInterface;
    private final l mJsDelegate;
    private Function1<? super Boolean, Unit> mSafeReplay;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/paysdk/jsbridge/PaySdkJsModule$a", "Lmq3/a;", "", "isInternalLogin", "", h.F, "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class a implements mq3.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f342024b;

        a(Map map) {
            this.f342024b = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) PaySdkJsModule.this, (Object) map);
            }
        }

        @Override // mq3.a
        public void h(boolean isInternalLogin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                PaySdkJsModule.this.onLoginCallback(this.f342024b, 0, "");
                PaySdkJsModule.this.sucCallbackToWeb(this.f342024b);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, isInternalLogin);
            }
        }
    }

    public PaySdkJsModule(@Nullable Context context, @Nullable o oVar, @Nullable com.tencent.paysdk.api.c cVar, @Nullable com.tencent.paysdk.vipauth.b bVar, @Nullable l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, context, oVar, cVar, bVar, lVar);
            return;
        }
        this.TAG = "PaySdkJsModule";
        this.mContext = context;
        this.mWebView = oVar;
        this.mAuthTaskProvider = cVar;
        this.mIVipInternalJSInterface = bVar;
        this.mJsDelegate = lVar;
    }

    private final void commonCallbackToWeb(Map<String, ? extends Object> params, int errCode, String errMsg) {
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", errCode);
            jSONObject.put("errMsg", errMsg);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        String str = (String) params.get("callback");
        if (!TextUtils.isEmpty(str)) {
            callJsFunction(str, jSONObject, null);
        }
    }

    private final void dispatchEvent(String event, String params) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(params);
            jSONObject.put("messageName", event);
            jSONObject.put("messageParams", jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        callJsFunction("TVAJSBridge && TVAJSBridge.dispatchEvent", jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void errCallbackToWeb(Map<String, ? extends Object> params, String errMsg) {
        commonCallbackToWeb(params, -1, errMsg);
    }

    private final Context getContext() {
        com.tencent.paysdk.api.c cVar = this.mAuthTaskProvider;
        if (cVar == null) {
            return this.mContext;
        }
        return cVar.d().e().getContext();
    }

    private final boolean isSameDelegate(l targetJsDelegator) {
        l lVar = this.mJsDelegate;
        if (targetJsDelegator != lVar && (!(lVar instanceof JsDelegatorDecorator) || targetJsDelegator != ((JsDelegatorDecorator) lVar).j())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoginCallback(Map<String, ? extends Object> params, int code, String errMsg) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", code);
            jSONObject.put("errMsg", errMsg);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        callJsFunction((String) params.get("callback"), jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sucCallbackToWeb(Map<String, ? extends Object> params) {
        commonCallbackToWeb(params, 0, "");
    }

    @JavascriptInterface
    public final void actionLogin(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "actionLogin(): " + params);
        com.tencent.paysdk.a.l().u(new a(params));
        com.tencent.paysdk.a l3 = com.tencent.paysdk.a.l();
        Object obj = params.get("type");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            str = "";
        }
        l3.e(str);
        com.tencent.paysdk.audio.a.INSTANCE.a().k();
    }

    @JavascriptInterface
    public final void close(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "close(): " + params);
        l lVar = this.mJsDelegate;
        if (lVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "close--VideoAuthJsDelegate is null");
            errCallbackToWeb(params, "VideoAuthJsDelegate is null");
        } else {
            lVar.b();
            sucCallbackToWeb(params);
        }
    }

    @JavascriptInterface
    public void closeH5(@NotNull Map<String, ? extends Object> params) {
        q g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "closeH5(): " + params);
        o oVar = this.mWebView;
        if (oVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "closeH5--mWebView is null");
            errCallbackToWeb(params, "mWebView is null");
            return;
        }
        if (oVar.k().getVisibility() == 0) {
            this.mWebView.k().setVisibility(8);
        }
        ViewParent parent = this.mWebView.k().getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(this.mWebView.k());
            l lVar = this.mJsDelegate;
            if (lVar != null && (g16 = lVar.g()) != null) {
                g16.onDetach();
            }
        }
        this.mWebView.clear();
        sucCallbackToWeb(params);
    }

    @JavascriptInterface
    public final void doH5Report(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) params);
            return;
        }
        com.tencent.paysdk.log.c.b(this.TAG, "doH5Report(): " + params);
        com.tencent.paysdk.api.c cVar = this.mAuthTaskProvider;
        if (cVar != null) {
            cVar.b(params);
        }
        sucCallbackToWeb(params);
    }

    @JavascriptInterface
    public final void getAppInfo(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "getAppInfo(): " + params);
        com.tencent.paysdk.data.a appInfo = com.tencent.paysdk.a.l().getAppInfo();
        JSONObject jSONObject = new JSONObject();
        if (appInfo != null) {
            try {
                jSONObject.put("errCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PushClientConstants.TAG_PKG_NAME, appInfo.f());
                jSONObject2.put("version", appInfo.g());
                jSONObject2.put("player_platform", appInfo.a());
                jSONObject2.put("appid", appInfo.b());
                jSONObject.put("result", jSONObject2);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        callJsFunction((String) params.get("callback"), jSONObject, null);
    }

    @JavascriptInterface
    public final void getDeviceInfo(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "getDeviceInfo(): " + params);
        com.tencent.paysdk.data.b deviceInfo = com.tencent.paysdk.a.l().getDeviceInfo();
        JSONObject jSONObject = new JSONObject();
        if (deviceInfo != null) {
            try {
                jSONObject.put("errCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("omgid", deviceInfo.a());
                jSONObject2.put("guid", deviceInfo.getGuid());
                jSONObject2.put("qimei36", deviceInfo.getQimei36());
                jSONObject2.put("screenWidth", deviceInfo.c());
                jSONObject2.put("screenHeight", deviceInfo.b());
                jSONObject.put("result", jSONObject2);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        callJsFunction((String) params.get("callback"), jSONObject, null);
    }

    @JavascriptInterface
    public final void getMainUserInfo(@NotNull final Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "getMainUserInfo(): " + params);
        ThreadCenter.c(new Runnable(params) { // from class: com.tencent.paysdk.jsbridge.PaySdkJsModule$getMainUserInfo$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map f342025d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f342025d = params;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) PaySdkJsModule.this, (Object) params);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                String lowerCase;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                IUserInfoProvider d16 = com.tencent.paysdk.a.l().d();
                IUserInfoProvider.UserType type = d16.type();
                IUserInfoProvider.UserType userType = IUserInfoProvider.UserType.UNDEFINE;
                String name = userType.name();
                if (name != null) {
                    Intrinsics.checkNotNullExpressionValue(name.toLowerCase(), "(this as java.lang.String).toLowerCase()");
                    int i3 = c.f342028a[type.ordinal()];
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3) {
                            String name2 = userType.name();
                            if (name2 != null) {
                                lowerCase = name2.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            String name3 = IUserInfoProvider.UserType.WX.name();
                            if (name3 != null) {
                                lowerCase = name3.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    } else {
                        String name4 = IUserInfoProvider.UserType.QQ.name();
                        if (name4 != null) {
                            lowerCase = name4.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (d16.getUserInfo() != null) {
                        j userInfo = d16.getUserInfo();
                        try {
                            jSONObject.put("errCode", 0);
                            JSONObject jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("nickname", userInfo.c());
                            jSONObject3.put(QAdLoginDefine$UserInfo.HEAD_IMAGE_URL, userInfo.g());
                            jSONObject2.put(ITVKPlayerEventListener.KEY_USER_INFO, jSONObject3);
                            jSONObject2.put("type", lowerCase);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                    ThreadCenter.a(new Runnable(jSONObject) { // from class: com.tencent.paysdk.jsbridge.PaySdkJsModule$getMainUserInfo$1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ JSONObject f342026d;

                        {
                            this.f342026d = jSONObject;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) PaySdkJsModule$getMainUserInfo$1.this, (Object) jSONObject);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this);
                            } else {
                                PaySdkJsModule.this.callJsFunction((String) PaySdkJsModule$getMainUserInfo$1.this.f342025d.get("callback"), this.f342026d, null);
                            }
                        }
                    });
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        });
    }

    @Override // com.tencent.paysdk.jsbridge.b
    @NotNull
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return "core";
    }

    @JavascriptInterface
    public final void getVideoInfo(@NotNull Map<String, ? extends Object> params) {
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "getVideoInfo(): " + params + TokenParser.SP);
        com.tencent.paysdk.api.c cVar = this.mAuthTaskProvider;
        if (cVar != null) {
            iVar = cVar.c();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "getVideoInfo--authTaskProvider or tvkCommunicator is null");
            errCallbackToWeb(params, "tvkCommunicator is null");
            return;
        }
        VideoInfo c16 = this.mAuthTaskProvider.c().c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", c16.m());
            jSONObject2.put("vid", c16.n());
            jSONObject2.put("cid", c16.b());
            jSONObject2.put("lid", c16.c());
            jSONObject2.put("pid", c16.d());
            jSONObject2.put("chid", c16.a());
            jSONObject2.put("previewTime", c16.f());
            jSONObject2.put("previewCount", c16.g());
            jSONObject2.put("restPreviewCount", c16.h());
            jSONObject2.put("isMainCamera", c16.o());
            jSONObject2.put("startpreview", c16.l());
            jSONObject2.put("rewardAdEnable", c16.j());
            jSONObject2.put("rewardAdCurrentPoint", c16.i());
            jSONObject2.put("rewardAdList", c16.k());
            jSONObject2.put("bizParams", c16.p());
            com.tencent.paysdk.vipauth.b bVar = this.mIVipInternalJSInterface;
            if (bVar != null) {
                jSONObject2.put("payviewInfo", bVar.b());
                jSONObject2.put("h5CreatedTime", this.mIVipInternalJSInterface.c());
                jSONObject2.put("tryPlayEndTime", this.mIVipInternalJSInterface.e());
                jSONObject2.put("sessionId", this.mIVipInternalJSInterface.i());
            }
            jSONObject.put("result", jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        callJsFunction((String) params.get("callback"), jSONObject, null);
    }

    @JavascriptInterface
    public final void hideBackButton(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "hideBackButton(): " + params);
        l lVar = this.mJsDelegate;
        if (lVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "hideBackButton--VideoAuthJsDelegate is null");
            errCallbackToWeb(params, "VideoAuthJsDelegate is null");
        } else {
            lVar.e();
            sucCallbackToWeb(params);
        }
    }

    @JavascriptInterface
    public final void onH5LoadFinish(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "onH5LoadFinish(): " + params);
        l lVar = this.mJsDelegate;
        if (lVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "mJsDelegate is null");
            errCallbackToWeb(params, "mJsDelegate is null");
        } else {
            lVar.g().d();
            sucCallbackToWeb(params);
        }
    }

    @Override // com.tencent.paysdk.jsbridge.b
    public void onJsDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        }
    }

    public final void onPageAppear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            dispatchEvent("onPageAppear", "{}");
        }
    }

    @JavascriptInterface
    public final void onPayFinish(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "onPayFinish(): " + params);
        if (this.mJsDelegate == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "VideoAuthJsDelegate is null");
            errCallbackToWeb(params, "VideoAuthJsDelegate is null");
            return;
        }
        try {
            Object obj = params.get("code");
            if (obj != null) {
                f.a(((Integer) obj).intValue(), (String) params.get("cid"), (String) params.get("vid"), (String) params.get("msg"), (String) params.get("source"));
                sucCallbackToWeb(params);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e16) {
            e16.printStackTrace();
            errCallbackToWeb(params, "exception");
        }
    }

    public final void onWebBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (this.mWebView.k().getVisibility() == 0) {
            this.mWebView.k().setVisibility(8);
        }
        this.mWebView.clear();
        ViewParent parent = this.mWebView.k().getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeAllViews();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @JavascriptInterface
    public final void openUrl(@NotNull Map<String, ? extends Object> params) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "openUrl(): " + params);
        if (this.mJsDelegate == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "openWebview--VideoAuthJsDelegate is null");
            errCallbackToWeb(params, "VideoAuthJsDelegate is null");
            return;
        }
        Object obj = params.get("url");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        if (str != null && (context = getContext()) != null) {
            com.tencent.paysdk.a.l().b(context, str);
            com.tencent.paysdk.audio.a.INSTANCE.a().k();
            sucCallbackToWeb(params);
        }
    }

    @JavascriptInterface
    public final void openWebview(@NotNull Map<String, ? extends Object> params) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "openWebview(): " + params);
        com.tencent.paysdk.api.c cVar = this.mAuthTaskProvider;
        if (cVar != null) {
            gVar = cVar.d();
        } else {
            gVar = null;
        }
        if (gVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "openWebview--authTaskProvider or HostViewProvider is null");
            errCallbackToWeb(params, "HostViewProvider is null");
        } else if (!TextUtils.isEmpty((String) params.get("url"))) {
            Context context = getContext();
            if (context instanceof Activity) {
                if (this.mAuthTaskProvider.a(context).a(params)) {
                    sucCallbackToWeb(params);
                } else {
                    errCallbackToWeb(params, "open web error");
                }
            } else {
                com.tencent.paysdk.log.c.a(this.TAG, "getContext() not activity");
                errCallbackToWeb(params, "getContext() not activity");
            }
            com.tencent.paysdk.audio.a.INSTANCE.a().k();
        }
    }

    @JavascriptInterface
    public final void publishMsgToAllWebView(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) params);
            return;
        }
        com.tencent.paysdk.log.c.b(this.TAG, "publishMsgToAllWebView(): " + params);
        sucCallbackToWeb(params);
    }

    @JavascriptInterface
    public final void refreshWKcookie(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) params);
            return;
        }
        com.tencent.paysdk.log.c.b(this.TAG, "refreshWKcookie(): " + params);
        com.tencent.paysdk.a.l().a();
        sucCallbackToWeb(params);
    }

    @JavascriptInterface
    public final void replayVideo(@NotNull Map<String, ? extends Object> params) {
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "replayVideo(): " + params);
        com.tencent.paysdk.api.c cVar = this.mAuthTaskProvider;
        if (cVar != null) {
            iVar = cVar.c();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "replayVideo--authTaskProvider or tvkCommunicator is null");
            errCallbackToWeb(params, "tvkCommunicator is null");
            return;
        }
        Function1<? super Boolean, Unit> function1 = this.mSafeReplay;
        if (function1 == null || function1.invoke(Boolean.FALSE) == null) {
            this.mAuthTaskProvider.c().b(false);
            Unit unit = Unit.INSTANCE;
        }
        onWebBack();
        sucCallbackToWeb(params);
    }

    @JavascriptInterface
    public final void setH5LayoutParams(@NotNull Map<String, ? extends Object> params) {
        g d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "setH5LayoutParams(): " + params);
        if (this.mJsDelegate == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "setH5LayoutParams--VideoAuthJsDelegate is null");
            errCallbackToWeb(params, "VideoAuthJsDelegate is null");
            return;
        }
        Object obj = params.get("width");
        if (obj != null) {
            int intValue = ((Integer) obj).intValue();
            Object obj2 = params.get("height");
            if (obj2 != null) {
                int intValue2 = ((Integer) obj2).intValue();
                com.tencent.paysdk.api.c cVar = this.mAuthTaskProvider;
                if (cVar != null && (d16 = cVar.d()) != null) {
                    if (isSameDelegate(d16.f())) {
                        com.tencent.paysdk.util.c.c(d16.a(), intValue, intValue2);
                    } else if (isSameDelegate(d16.c())) {
                        com.tencent.paysdk.util.c.c(d16.d(), intValue, intValue2);
                    }
                    this.mJsDelegate.f(intValue, intValue2);
                    sucCallbackToWeb(params);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void setReplayFun(@NotNull Function1<? super Boolean, Unit> safeReplay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) safeReplay);
        } else {
            Intrinsics.checkNotNullParameter(safeReplay, "safeReplay");
            this.mSafeReplay = safeReplay;
        }
    }

    @JavascriptInterface
    public final void startPreview(@NotNull Map<String, ? extends Object> params) {
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "startPreview(): " + params);
        com.tencent.paysdk.api.c cVar = this.mAuthTaskProvider;
        if (cVar != null) {
            iVar = cVar.c();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "startPreview--authTaskProvider or tvkCommunicator is null");
            errCallbackToWeb(params, "tvkCommunicator is null");
            return;
        }
        Function1<? super Boolean, Unit> function1 = this.mSafeReplay;
        if (function1 == null || function1.invoke(Boolean.FALSE) == null) {
            this.mAuthTaskProvider.c().f();
            Unit unit = Unit.INSTANCE;
        }
        onWebBack();
        sucCallbackToWeb(params);
    }

    @JavascriptInterface
    public final void unlockVideo(@NotNull Map<String, ? extends Object> params) {
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "unlockVideo(): " + params);
        com.tencent.paysdk.api.c cVar = this.mAuthTaskProvider;
        if (cVar != null) {
            iVar = cVar.c();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            com.tencent.paysdk.log.c.a(this.TAG, "unlockVideo--authTaskProvider or tvkCommunicator is null");
            errCallbackToWeb(params, "tvkCommunicator is null");
        } else {
            this.mAuthTaskProvider.c().a();
            sucCallbackToWeb(params);
        }
    }

    @JavascriptInterface
    public final void writeLog(@NotNull Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.paysdk.log.c.b(this.TAG, "writeLog(): " + params);
        com.tencent.paysdk.log.c.b(this.TAG, (String) params.get("content"));
        sucCallbackToWeb(params);
    }
}
