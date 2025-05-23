package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

import android.os.Bundle;
import android.view.Surface;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.util.UiThreadUtil;
import eipc.EIPCConnection;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u00015B\u000f\u0012\u0006\u00101\u001a\u00020\u0002\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0014J\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fJ \u0010$\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u0004JB\u0010,\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCServer;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "uniqueKey", "", "j", "jsonString", "k", "Landroid/os/Bundle;", "params", "", "l", "action", "", "callbackId", "Leipc/EIPCResult;", "onCall", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/k;", "provider", tl.h.F, "Lkotlin/Function1;", "callback", "i", "destroy", "isVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "jsCallbackId", "code", DomainData.DOMAIN_NAME, "o", "r", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", ReportConstant.COSTREPORT_PREFIX, "callbackJson", "isFrequentCallback", "t", "webPageId", "Landroid/view/Surface;", "surface", "width", "height", "needRebuildDisplay", "Leipc/EIPCResultCallback;", "v", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "containerProviderList", "name", "<init>", "(Ljava/lang/String;)V", "e", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaWebIPCServer extends QIPCModule {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildMediaWebIPCServer> f229494f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<k> containerProviderList;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCServer$b;", "", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCServer;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCServer;", "sInstance", "", "NOTIFY_APP_IN_BACKGROUND", "I", "", "TAG", "Ljava/lang/String;", "USER_AUTH_APP_ID_IS_NOT_SAME", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer$b, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildMediaWebIPCServer b() {
            return (GuildMediaWebIPCServer) GuildMediaWebIPCServer.f229494f.getValue();
        }

        @NotNull
        public final GuildMediaWebIPCServer a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildMediaWebIPCServer> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GuildMediaWebIPCServer>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMediaWebIPCServer invoke() {
                return new GuildMediaWebIPCServer("GuildMediaWebIPCServer");
            }
        });
        f229494f = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaWebIPCServer(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        this.containerProviderList = new CopyOnWriteArrayList<>();
        GuardManagerCallbackDispatcher.registerCallBack(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(String uniqueKey) {
        Boolean bool;
        EIPCConnection clientConnection = QIPCServerHelper.getInstance().getServer().getClientConnection("com.tencent.mobileqq:tool", 1);
        boolean z16 = false;
        if (clientConnection != null && clientConnection.isAvailable()) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("key_web_attach_web_page_id", uniqueKey);
                Unit unit = Unit.INSTANCE;
                EIPCResult callModule = clientConnection.callModule("GuildMediaWebIPCClient", "action_client_check_if_attach", bundle);
                if (callModule != null) {
                    if (callModule.isSuccess()) {
                        z16 = true;
                    }
                }
            } catch (Throwable th5) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "[checkIfAttach] callModule throwable " + th5;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, (String) it.next(), null);
                }
            }
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "[doCheckClientConnect] result " + z16);
            return z16;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        if (clientConnection != null) {
            bool = Boolean.valueOf(clientConnection.isAvailable());
        } else {
            bool = null;
        }
        String str2 = "[doCheckClientConnect] clientConnection: " + bool;
        if (str2 instanceof String) {
            bVar2.a().add(str2);
        }
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, (String) it5.next(), null);
        }
        return false;
    }

    private final String k(String jsonString) {
        boolean z16;
        if (jsonString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        try {
            String optString = new JSONObject(jsonString).optString("callback");
            if (optString == null) {
                return "";
            }
            return optString;
        } catch (JSONException e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "handleJsRequest JSONException " + e16;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, (String) it.next(), e16);
            }
            return "";
        }
    }

    private final void l(Bundle params) {
        String str;
        String str2;
        Object obj;
        boolean z16;
        String string;
        String str3 = "";
        if (params == null || (str = params.getString("key_web_js_api_url")) == null) {
            str = "";
        }
        if (params == null || (str2 = params.getString("key_web_js_api_method")) == null) {
            str2 = "";
        }
        if (params != null && (string = params.getString("key_web_js_api_json")) != null) {
            str3 = string;
        }
        String k3 = k(str3);
        Iterator<T> it = this.containerProviderList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((k) obj).i(str2)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        k kVar = (k) obj;
        Logger.a d16 = Logger.f235387a.d();
        if (kVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "[onCall] method " + str2 + " isRegister " + z16);
        if (kVar != null) {
            kVar.g(str, str2, k3, str3);
        } else {
            n(k3, 900);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GuildMediaWebIPCServer this$0, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GuildMediaWebIPCServer this$0, ContainerMsgIntent containerMsgIntent) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this$0.containerProviderList);
        k kVar = (k) firstOrNull;
        if (kVar != null) {
            kVar.m(containerMsgIntent);
        }
    }

    public static /* synthetic */ void u(GuildMediaWebIPCServer guildMediaWebIPCServer, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        guildMediaWebIPCServer.t(str, str2, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Surface surface, final EIPCResultCallback eIPCResultCallback, final EIPCResult eIPCResult) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "updateSurface(" + surface + ") result " + eIPCResult.code + ", error: " + eIPCResult.f396321e);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaWebIPCServer.x(EIPCResultCallback.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(EIPCResultCallback eIPCResultCallback, EIPCResult eIPCResult) {
        if (eIPCResultCallback != null) {
            eIPCResultCallback.onCallback(eIPCResult);
        }
    }

    public final void destroy() {
        Iterator<T> it = this.containerProviderList.iterator();
        while (it.hasNext()) {
            ((k) it.next()).e();
        }
        this.containerProviderList.clear();
    }

    public final void h(@NotNull k provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (!this.containerProviderList.contains(provider)) {
            this.containerProviderList.add(provider);
        }
    }

    public final void i(@NotNull String uniqueKey, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CorountineFunKt.e(MediaChannelCore.INSTANCE.a().getCoroutineScope(), "checkIfAttach", null, null, null, new GuildMediaWebIPCServer$checkIfAttach$1(callback, this, uniqueKey, null), 14, null);
    }

    public final void m(boolean isVisible) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "notifyFloatWindow " + isVisible);
        s(new ToolProcessIntent.NotifyFloatWindowIntent(isVisible));
    }

    public final void n(@NotNull String jsCallbackId, int code) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jsCallbackId, "jsCallbackId");
        if (jsCallbackId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret", String.valueOf(code));
        Unit unit = Unit.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
        u(this, jsCallbackId, jSONObject2, false, 4, null);
    }

    public final void o(boolean isVisible) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "notifyWebForeground " + isVisible);
        s(new ToolProcessIntent.NotifyWebForegroundIntent(isVisible));
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable final Bundle params, int callbackId) {
        Serializable serializable;
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "[onCall] action " + action);
        if (Intrinsics.areEqual(action, "action_server_send_js_api")) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaWebIPCServer.p(GuildMediaWebIPCServer.this, params);
                }
            });
        } else if (Intrinsics.areEqual(action, "action_server_send_msg_intent")) {
            final ContainerMsgIntent containerMsgIntent = null;
            if (params != null) {
                serializable = params.getSerializable("key_msg_intent");
            } else {
                serializable = null;
            }
            if (serializable instanceof ContainerMsgIntent) {
                containerMsgIntent = (ContainerMsgIntent) serializable;
            }
            if (containerMsgIntent != null) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildMediaWebIPCServer.q(GuildMediaWebIPCServer.this, containerMsgIntent);
                    }
                });
            }
        }
        EIPCResult UNKNOW_RESULT = EIPCResult.UNKNOW_RESULT;
        Intrinsics.checkNotNullExpressionValue(UNKNOW_RESULT, "UNKNOW_RESULT");
        return UNKNOW_RESULT;
    }

    public final void r(@NotNull k provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (this.containerProviderList.contains(provider)) {
            this.containerProviderList.remove(provider);
        }
    }

    public final void s(@NotNull ContainerMsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_msg_intent", intent);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "GuildMediaWebIPCClient", "action_client_send_msg_intent", bundle, null);
    }

    public final void t(@NotNull String callbackId, @NotNull String callbackJson, boolean isFrequentCallback) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(callbackJson, "callbackJson");
        if (!isFrequentCallback) {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "[sendJSCallbackToClient] callbackId " + callbackId + ", callbackJson " + callbackJson);
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_web_callback_id", callbackId);
        bundle.putString("key_web_callback_json", callbackJson);
        bundle.putBoolean("key_web_callback_frequent", isFrequentCallback);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "GuildMediaWebIPCClient", "action_client_send_callback", bundle, null);
    }

    public final void v(@NotNull String webPageId, @Nullable final Surface surface, int width, int height, boolean needRebuildDisplay, @Nullable final EIPCResultCallback callback) {
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Bundle bundle = new Bundle();
        if (surface != null) {
            bundle.putParcelable("key_surface", surface);
        }
        bundle.putString("key_web_page_id", webPageId);
        bundle.putInt("guild_webview_width", width);
        bundle.putInt("guild_webview_height", height);
        bundle.putBoolean("guild_force_rebuild_display", needRebuildDisplay);
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "[updateSurface] surface " + surface + ", size[" + width + ", " + height + "]");
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "GuildMediaWebIPCClient", "action_client_update_resize_web", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.f
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GuildMediaWebIPCServer.w(surface, callback, eIPCResult);
            }
        });
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCServer$a", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements IGuardInterface {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(GuildMediaWebIPCServer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(GuildMediaWebIPCServer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o(true);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "onApplicationBackground");
            final GuildMediaWebIPCServer guildMediaWebIPCServer = GuildMediaWebIPCServer.this;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaWebIPCServer.a.c(GuildMediaWebIPCServer.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCServer", 1, "onApplicationForeground");
            final GuildMediaWebIPCServer guildMediaWebIPCServer = GuildMediaWebIPCServer.this;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaWebIPCServer.a.d(GuildMediaWebIPCServer.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
        }
    }
}
