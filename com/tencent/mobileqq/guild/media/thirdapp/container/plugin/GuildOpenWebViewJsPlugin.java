package com.tencent.mobileqq.guild.media.thirdapp.container.plugin;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.guild.media.thirdapp.ContentSize;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.f;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCClient;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\b\t*\u0001%\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016JM\u0010!\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0016\u0010 \u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u001f\"\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\bH\u0014J\b\u0010$\u001a\u00020\bH\u0014R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/GuildOpenWebViewJsPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "Lcom/tencent/biz/pubaccount/CustomWebView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "", "p", "", "isVisible", "", "fromScene", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/media/thirdapp/a;", "contentSize", "t", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "r", "getNameSpace", "nameSpace", "", "getWebViewEventByNameSpace", "getWebViewSchemaByNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/guild/media/thirdapp/container/plugin/GuildOpenWebViewJsPlugin$b", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/GuildOpenWebViewJsPlugin$b;", "action", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOpenWebViewJsPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action = new b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/GuildOpenWebViewJsPlugin$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements f {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.f
        public void a(@NotNull ContainerMsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            GuildOpenWebViewJsPlugin.this.r(intent);
        }
    }

    private final void p(String eventName, JSONObject data) {
        CustomWebView q16 = q();
        if (q16 == null) {
            return;
        }
        String jsScript = WebViewPlugin.toJsScript(eventName, data, null);
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "[dispatchJsEvent] script: " + jsScript);
        q16.callJs(jsScript);
    }

    private final CustomWebView q() {
        CustomWebView customWebView;
        CustomWebView e16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || (e16 = bVar.e()) == null) {
            if (QLog.isColorLevel()) {
                WebViewPlugin.b bVar2 = this.mRuntime;
                if (bVar2 != null) {
                    customWebView = bVar2.e();
                } else {
                    customWebView = null;
                }
                QLog.i("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 2, QLog.getStackTraceString(new Throwable("[getWebView] runtime[" + bVar2 + "] web[" + customWebView + "]")));
            }
            return null;
        }
        return e16;
    }

    private final void s(boolean isVisible, int fromScene) {
        String str;
        long j3;
        CustomWebView q16 = q();
        if (q16 == null) {
            return;
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "notifyWebForeground " + isVisible + ", fromScene " + fromScene);
        if (fromScene == 1) {
            str = "GuildOpen_EnterFloatWindow";
        } else {
            str = "GuildOpen_EnterBackground";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("back", isVisible);
        Unit unit = Unit.INSTANCE;
        p(str, jSONObject);
        if (isVisible) {
            j3 = 2;
        } else {
            j3 = 8589934597L;
        }
        WebViewPluginEngine pluginEngine = q16.getPluginEngine();
        if (pluginEngine != null) {
            pluginEngine.s(q16.getUrl(), j3, null);
        }
    }

    private final void t(ContentSize contentSize) {
        JSONObject h16 = lt1.a.h(contentSize);
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "[notifyWebScreenChanged] " + h16);
        p("screenModeChangeListener", h16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "guildGame";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(@Nullable String nameSpace) {
        if (QLog.isColorLevel()) {
            QLog.d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 2, "getWebViewEventByNameSpace-> ", nameSpace);
            return 0L;
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(@Nullable String nameSpace) {
        if (QLog.isColorLevel()) {
            QLog.d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 2, "getWebViewEventByNameSpace-> ", nameSpace);
            return 4294967295L;
        }
        return 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @NotNull String method, @NotNull String... args) {
        boolean z16;
        boolean z17;
        JSONObject jSONObject;
        String str;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        if (TextUtils.equals(getNameSpace(), pkgName) && !TextUtils.isEmpty(method)) {
            Logger.a d16 = Logger.f235387a.d();
            String arrays = Arrays.toString(args);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            d16.d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "handleJsRequest-> method: " + method + ", args: " + arrays);
            try {
                if (args.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                String str2 = null;
                if (z17 && (str = args[0]) != null) {
                    jSONObject = new JSONObject(str);
                } else {
                    jSONObject = null;
                }
                GuildMediaWebIPCClient a16 = GuildMediaWebIPCClient.INSTANCE.a();
                if (jSONObject != null) {
                    str2 = jSONObject.toString();
                }
                a16.n(url, method, str2);
                return true;
            } catch (JSONException e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str3 = "handleJsRequest JSONException " + e16;
                if (str3 instanceof String) {
                    bVar.a().add(str3);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, (String) it.next(), e16);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "onCreate()");
        GuildMediaWebIPCClient.INSTANCE.a().f(this.action);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "onDestroy()");
        GuildMediaWebIPCClient.INSTANCE.a().l(this.action);
        super.onDestroy();
    }

    public final void r(@NotNull ContainerMsgIntent intent) {
        CustomWebView q16;
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean z16 = intent instanceof ToolProcessIntent.SendJSCallbackIntent;
        if (!z16 || !((ToolProcessIntent.SendJSCallbackIntent) intent).isFrequentCallback()) {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "[handleIntent] intent " + intent);
        }
        if (intent instanceof ToolProcessIntent.EventNotifyIntent) {
            ToolProcessIntent.EventNotifyIntent eventNotifyIntent = (ToolProcessIntent.EventNotifyIntent) intent;
            p(eventNotifyIntent.getEventName(), eventNotifyIntent.getData());
            return;
        }
        if (z16) {
            ToolProcessIntent.SendJSCallbackIntent sendJSCallbackIntent = (ToolProcessIntent.SendJSCallbackIntent) intent;
            if (!sendJSCallbackIntent.isFrequentCallback()) {
                Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "SendJSCallbackIntent callbackToJs -> callbackId: " + sendJSCallbackIntent.getCallbackId() + ", result " + sendJSCallbackIntent.getCallbackJson());
            }
            callJs(sendJSCallbackIntent.getCallbackId(), sendJSCallbackIntent.getCallbackJson());
            return;
        }
        if (intent instanceof ToolProcessIntent.NotifyWebForegroundIntent) {
            s(((ToolProcessIntent.NotifyWebForegroundIntent) intent).isVisible(), 0);
            return;
        }
        if (intent instanceof ToolProcessIntent.NotifyFloatWindowIntent) {
            s(!((ToolProcessIntent.NotifyFloatWindowIntent) intent).isFloatWindowVisible(), 1);
            return;
        }
        if (!(intent instanceof ToolProcessIntent.NotifyWebScreenChangedIntent) || (q16 = q()) == null) {
            return;
        }
        float f16 = q16.getContext().getResources().getDisplayMetrics().density;
        float f17 = f16 / 3.0f;
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenWebViewJsPlugin", 1, "[handleIntent] density " + f16 + ", radio " + f17);
        ToolProcessIntent.NotifyWebScreenChangedIntent notifyWebScreenChangedIntent = (ToolProcessIntent.NotifyWebScreenChangedIntent) intent;
        roundToInt = MathKt__MathJVMKt.roundToInt(((float) notifyWebScreenChangedIntent.getLeftPlaceHolder()) * f17);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(((float) notifyWebScreenChangedIntent.getTopPlaceHolder()) * f17);
        roundToInt3 = MathKt__MathJVMKt.roundToInt(((float) notifyWebScreenChangedIntent.getRightPlaceHolder()) * f17);
        roundToInt4 = MathKt__MathJVMKt.roundToInt(((float) notifyWebScreenChangedIntent.getBottomPlaceHolder()) * f17);
        t(new ContentSize(roundToInt2, roundToInt, roundToInt3, roundToInt4, notifyWebScreenChangedIntent.getScreenMode()));
    }
}
