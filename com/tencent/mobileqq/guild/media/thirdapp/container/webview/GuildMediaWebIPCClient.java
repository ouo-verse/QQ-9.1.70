package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

import android.os.Bundle;
import android.view.Surface;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.util.UiThreadUtil;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010 \u001a\u00020\u000f\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\"\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014J$\u0010\u0017\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCClient;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "", "callbackId", "", tl.h.F, "Leipc/EIPCResult;", "g", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "action", "f", "register", "l", "", "url", "method", "jsonString", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onCall", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "actionCallbackList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegistered", "name", "<init>", "(Ljava/lang/String;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaWebIPCClient extends QIPCModule {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildMediaWebIPCClient> f229490h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.media.thirdapp.container.intent.f> actionCallbackList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRegistered;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCClient$a;", "", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCClient;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCClient;", "sInstance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCClient$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildMediaWebIPCClient b() {
            return (GuildMediaWebIPCClient) GuildMediaWebIPCClient.f229490h.getValue();
        }

        @NotNull
        public final GuildMediaWebIPCClient a() {
            return b();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildMediaWebIPCClient$b", "Leipc/EIPCOnGetConnectionListener;", "Leipc/EIPCConnection;", "conn", "", "onConnectBind", "onConnectUnbind", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements EIPCOnGetConnectionListener {
        b() {
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(@Nullable EIPCConnection conn) {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "[onConnectBind]");
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(@Nullable EIPCConnection conn) {
            String str;
            Logger.a d16 = Logger.f235387a.d();
            if (conn != null) {
                str = conn.procName;
            } else {
                str = null;
            }
            d16.d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "[onConnectUnbind] procName: " + str);
        }
    }

    static {
        Lazy<GuildMediaWebIPCClient> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GuildMediaWebIPCClient>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCClient$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMediaWebIPCClient invoke() {
                return new GuildMediaWebIPCClient("GuildMediaWebIPCClient");
            }
        });
        f229490h = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaWebIPCClient(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        this.actionCallbackList = new CopyOnWriteArrayList<>();
        this.isRegistered = new AtomicBoolean(false);
    }

    private final EIPCResult g(Bundle params, int callbackId) {
        String str;
        boolean z16;
        if (params == null || (str = params.getString("key_web_attach_web_page_id")) == null) {
            str = "";
        }
        int i3 = 0;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[handleCheckIfWebPageAttach] invalid page id!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, (String) it.next(), null);
            }
            EIPCResult createResult = EIPCResult.createResult(-1000, new Bundle());
            Intrinsics.checkNotNullExpressionValue(createResult, "createResult(GuildMediaW\u2026_INVALID_PARAM, Bundle())");
            return createResult;
        }
        if (!RemoteWebRenderIPCClient.INSTANCE.a().u(str)) {
            i3 = -102;
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "[handleCheckIfWebPageAttach] pageId: " + str + ", result " + i3);
        EIPCResult createResult2 = EIPCResult.createResult(i3, new Bundle());
        Intrinsics.checkNotNullExpressionValue(createResult2, "createResult(code, Bundle())");
        return createResult2;
    }

    private final void h(Bundle params, int callbackId) {
        Surface surface;
        if (params.containsKey("key_surface")) {
            surface = (Surface) params.getParcelable("key_surface");
        } else {
            surface = null;
        }
        Surface surface2 = surface;
        String string = params.getString("key_web_page_id");
        if (string == null) {
            string = "";
        }
        String str = string;
        int i3 = params.getInt("guild_webview_width");
        int i16 = params.getInt("guild_webview_height");
        boolean z16 = params.getBoolean("guild_force_rebuild_display");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "[handleResizeWeb] webPageId " + str + ", surface " + surface2 + ", needRebuildDisplay " + z16 + ", size[" + i3 + ", " + i16 + "]");
        final ToolProcessIntent.ResizeWebIntent resizeWebIntent = new ToolProcessIntent.ResizeWebIntent(str, surface2, i3, i16, z16);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaWebIPCClient.i(GuildMediaWebIPCClient.this, resizeWebIntent);
            }
        });
        callbackResult(callbackId, EIPCResult.createResult(0, new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildMediaWebIPCClient this$0, ToolProcessIntent.ResizeWebIntent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Iterator<T> it = this$0.actionCallbackList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.media.thirdapp.container.intent.f) it.next()).a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildMediaWebIPCClient this$0, ContainerMsgIntent containerMsgIntent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.actionCallbackList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.media.thirdapp.container.intent.f) it.next()).a(containerMsgIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GuildMediaWebIPCClient this$0, ToolProcessIntent.SendJSCallbackIntent callbackIntent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callbackIntent, "$callbackIntent");
        Iterator<T> it = this$0.actionCallbackList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.media.thirdapp.container.intent.f) it.next()).a(callbackIntent);
        }
    }

    public final void f(@NotNull com.tencent.mobileqq.guild.media.thirdapp.container.intent.f action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!this.actionCallbackList.contains(action)) {
            this.actionCallbackList.add(action);
        }
    }

    public final void l(@NotNull com.tencent.mobileqq.guild.media.thirdapp.container.intent.f action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.actionCallbackList.contains(action)) {
            this.actionCallbackList.remove(action);
        }
    }

    public final void m(@NotNull ContainerMsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "[sendIntentToServer] intent " + intent);
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_msg_intent", intent);
        QIPCClientHelper.getInstance().callServer("GuildMediaWebIPCServer", "action_server_send_msg_intent", bundle, null);
    }

    public final void n(@Nullable String url, @NotNull String method, @Nullable String jsonString) {
        Intrinsics.checkNotNullParameter(method, "method");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "[sendJSAPIToServer] method " + method + ", jsonString " + jsonString);
        Bundle bundle = new Bundle();
        if (url == null) {
            url = "";
        }
        bundle.putString("key_web_js_api_url", url);
        bundle.putString("key_web_js_api_method", method);
        if (jsonString == null) {
            jsonString = "";
        }
        bundle.putString("key_web_js_api_json", jsonString);
        QIPCClientHelper.getInstance().callServer("GuildMediaWebIPCServer", "action_server_send_js_api", bundle, null);
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        Serializable serializable;
        String str;
        String string;
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "[onCall] action: " + action + " ");
        if (action != null) {
            boolean z16 = false;
            switch (action.hashCode()) {
                case -1812856626:
                    if (action.equals("action_check_preload_web_process")) {
                        boolean z17 = SwiftBrowserStatistics.f314343h1;
                        logger.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "isPreloadWebProcess: " + z17);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_check_preload_web_process", z17);
                        Unit unit = Unit.INSTANCE;
                        EIPCResult createResult = EIPCResult.createResult(0, bundle);
                        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(0, Bundle()\u2026ocess)\n                })");
                        return createResult;
                    }
                    break;
                case -752312091:
                    if (action.equals("action_client_check_if_attach")) {
                        return g(params, callbackId);
                    }
                    break;
                case -692166170:
                    if (action.equals("action_client_send_msg_intent")) {
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
                            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    GuildMediaWebIPCClient.j(GuildMediaWebIPCClient.this, containerMsgIntent);
                                }
                            });
                            break;
                        }
                    }
                    break;
                case 95686900:
                    if (action.equals("action_client_update_resize_web")) {
                        if (params == null) {
                            params = new Bundle();
                        }
                        h(params, callbackId);
                        break;
                    }
                    break;
                case 650443793:
                    if (action.equals("action_client_send_callback")) {
                        String str2 = "";
                        if (params == null || (str = params.getString("key_web_callback_id")) == null) {
                            str = "";
                        }
                        if (params != null && (string = params.getString("key_web_callback_json")) != null) {
                            str2 = string;
                        }
                        if (params != null) {
                            z16 = params.getBoolean("key_web_callback_frequent");
                        }
                        final ToolProcessIntent.SendJSCallbackIntent sendJSCallbackIntent = new ToolProcessIntent.SendJSCallbackIntent(str, str2, z16);
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildMediaWebIPCClient.k(GuildMediaWebIPCClient.this, sendJSCallbackIntent);
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        EIPCResult UNKNOW_RESULT = EIPCResult.UNKNOW_RESULT;
        Intrinsics.checkNotNullExpressionValue(UNKNOW_RESULT, "UNKNOW_RESULT");
        return UNKNOW_RESULT;
    }

    public final void register() {
        if (!this.isRegistered.compareAndSet(false, true)) {
            return;
        }
        String qQProcessName = MobileQQ.getMobileQQ().getQQProcessName();
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebIPCClient", 1, "[register] processName: " + qQProcessName);
        QIPCClientHelper.getInstance().register(this);
        QIPCClientHelper.getInstance().getClient().addListener(new b());
    }
}
