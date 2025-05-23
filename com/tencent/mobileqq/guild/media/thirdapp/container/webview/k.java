package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

import android.util.Log;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.OpenPluginRuntime;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0017B3\u0012\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015`\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J,\u0010\t\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\u0005J*\u0010\f\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\"j\b\u0012\u0004\u0012\u00020\u0002`#0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/k;", "", "", "method", "jsCallbackId", "", "d", "url", "jsonString", "f", "k", "e", "g", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "i", "j", "l", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/b;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "methodMap", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;", "b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;", "runtime", "c", "Z", "isVisible", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingCallbackMap", "<init>", "(Ljava/util/HashMap;Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/e;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b> methodMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OpenPluginRuntime runtime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isVisible;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, ArrayList<String>> pendingCallbackMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/webview/k$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "Lorg/json/JSONObject;", "result", "", "isFrequentCallback", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f229524a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f229525b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f229526c;

        b(String str, k kVar, String str2) {
            this.f229524a = str;
            this.f229525b = kVar;
            this.f229526c = str2;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c
        public void a(@NotNull JSONObject result, boolean isFrequentCallback) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!isFrequentCallback) {
                Logger logger = Logger.f235387a;
                String str = this.f229526c;
                logger.d().d("QGMC.MediaThirdApp.GuildMediaWebJSHandler", 1, "sendJSCallbackToClient callbackToJs -> method: " + str + ", result " + result);
            }
            GuildMediaWebIPCServer a16 = GuildMediaWebIPCServer.INSTANCE.a();
            String str2 = this.f229524a;
            String jSONObject = result.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "result.toString()");
            a16.t(str2, jSONObject, isFrequentCallback);
            this.f229525b.k(this.f229526c, this.f229524a);
        }
    }

    public k(@NotNull HashMap<String, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b> methodMap, @NotNull OpenPluginRuntime runtime) {
        Intrinsics.checkNotNullParameter(methodMap, "methodMap");
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.methodMap = methodMap;
        this.runtime = runtime;
        this.isVisible = true;
        this.pendingCallbackMap = new ConcurrentHashMap<>();
        Iterator<Map.Entry<String, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b>> it = methodMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(this.runtime);
        }
    }

    private final void d(String method, String jsCallbackId) {
        boolean z16;
        if (jsCallbackId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            synchronized (this.pendingCallbackMap) {
                ArrayList<String> arrayList = this.pendingCallbackMap.get(method);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                Intrinsics.checkNotNullExpressionValue(arrayList, "pendingCallbackMap[method] ?: ArrayList<String>()");
                if (!arrayList.contains(jsCallbackId)) {
                    arrayList.add(jsCallbackId);
                }
                this.pendingCallbackMap.put(method, arrayList);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(String url, String method, String jsCallbackId, String jsonString) {
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b bVar = this.methodMap.get(method);
        boolean z18 = true;
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJSHandler", 1, "handleJSAPIInMainProcess->  method: " + method + ", jsCallbackId " + jsCallbackId + ", handler " + bVar + " isVisible " + this.isVisible);
        JSONObject jSONObject = null;
        if (bVar == null) {
            Logger.b bVar2 = new Logger.b();
            String str = "can not find response handler for " + method;
            if (str instanceof String) {
                bVar2.a().add(str);
            }
            Iterator<T> it = bVar2.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebJSHandler", 1, (String) it.next(), null);
            }
            GuildMediaWebIPCServer.INSTANCE.a().n(jsCallbackId, 900);
            return;
        }
        if (jsonString != null) {
            if (jsonString.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (z16) {
                    try {
                        jSONObject = new JSONObject(jsonString);
                    } catch (JSONException e16) {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar3 = new Logger.b();
                        String str2 = "handleJsRequest JSONException " + e16;
                        if (str2 instanceof String) {
                            bVar3.a().add(str2);
                        }
                        Iterator<T> it5 = bVar3.a().iterator();
                        while (it5.hasNext()) {
                            Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildMediaWebJSHandler", 1, (String) it5.next(), e16);
                        }
                        return;
                    }
                }
                if (jsCallbackId.length() <= 0) {
                    z18 = false;
                }
                if (!z18 && !this.isVisible) {
                    GuildMediaWebIPCServer.INSTANCE.a().n(jsCallbackId, 900);
                    return;
                }
                b bVar4 = new b(jsCallbackId, this, method);
                d(method, jsCallbackId);
                if (url == null) {
                    url = "";
                }
                bVar.c(url, jSONObject, bVar4);
            }
        }
        z16 = false;
        if (z16) {
        }
        if (jsCallbackId.length() <= 0) {
        }
        if (!z18) {
        }
        b bVar42 = new b(jsCallbackId, this, method);
        d(method, jsCallbackId);
        if (url == null) {
        }
        bVar.c(url, jSONObject, bVar42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(k this$0, String str, String method, String jsCallbackId, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(jsCallbackId, "$jsCallbackId");
        this$0.f(str, method, jsCallbackId, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String method, String jsCallbackId) {
        boolean z16;
        if (jsCallbackId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            synchronized (this.pendingCallbackMap) {
                ArrayList<String> arrayList = this.pendingCallbackMap.get(method);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                Intrinsics.checkNotNullExpressionValue(arrayList, "pendingCallbackMap[method] ?: ArrayList<String>()");
                if (arrayList.contains(jsCallbackId)) {
                    arrayList.remove(jsCallbackId);
                }
                this.pendingCallbackMap.put(method, arrayList);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void e() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJSHandler", 1, "[destroy]");
        if (!this.pendingCallbackMap.isEmpty()) {
            synchronized (this.pendingCallbackMap) {
                Iterator<Map.Entry<String, ArrayList<String>>> it = this.pendingCallbackMap.entrySet().iterator();
                while (it.hasNext()) {
                    for (String str : it.next().getValue()) {
                        Logger logger = Logger.f235387a;
                        if (QLog.isDevelopLevel()) {
                            Log.d("QGMC.MediaThirdApp.GuildMediaWebJSHandler", "[destroy] notifyJSError jsCallbackId " + str);
                        }
                        GuildMediaWebIPCServer.INSTANCE.a().n(str, 900);
                    }
                }
                this.pendingCallbackMap.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
        HashMap<String, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b> hashMap = this.methodMap;
        Iterator<Map.Entry<String, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b>> it5 = hashMap.entrySet().iterator();
        while (it5.hasNext()) {
            it5.next().getValue().onDestroy();
        }
        hashMap.clear();
    }

    public final void g(@Nullable final String url, @NotNull final String method, @NotNull final String jsCallbackId, @Nullable final String jsonString) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(jsCallbackId, "jsCallbackId");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.webview.j
            @Override // java.lang.Runnable
            public final void run() {
                k.h(k.this, url, method, jsCallbackId, jsonString);
            }
        });
    }

    public final boolean i(@NotNull String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return this.methodMap.containsKey(method);
    }

    public final void j() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJSHandler", 1, "[pause] ");
        this.isVisible = false;
    }

    public final void l() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaWebJSHandler", 1, "[resume] ");
        this.isVisible = true;
    }

    public final void m(@NotNull ContainerMsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.runtime.getHostProvider().b(intent);
    }
}
