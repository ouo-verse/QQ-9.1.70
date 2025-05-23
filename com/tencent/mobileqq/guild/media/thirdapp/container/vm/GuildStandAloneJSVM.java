package com.tencent.mobileqq.guild.media.thirdapp.container.vm;

import androidx.lifecycle.LifecycleObserver;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.core.notify.aa;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.EntryType;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.GuildOpenJsMethodProvider;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.OpenPluginRuntime;
import com.tencent.mobileqq.guild.media.thirdapp.container.vm.GuildStandAloneJSVM;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0003\u0018\u001c+\u0018\u0000 \u000e2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b:\u00011B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0016\u001a\u00020\u000b2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R(\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00180'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVM;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$GetUserProfileIntent;", "intent", "", "l", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "methodTag", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "p", "context", "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$b", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$b;", "actionCallback", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$c", "e", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$c;", "globalMiniAppJSEvent", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/b;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "jsMethodMap", "", "Lkotlin/Pair;", h.F, "Ljava/util/List;", "messageList", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$e", "i", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$e;", "provider", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildStandAloneJSVM extends BaseVM<ol3.b, MviUIState, com.tencent.base.api.runtime.a<BaseParam>> implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b actionCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c globalMiniAppJSEvent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b> jsMethodMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e provider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            ContainerMsgIntent containerMsgIntent;
            Intrinsics.checkNotNullParameter(i3, "i");
            Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "[actionCallback] " + i3);
            if (i3 instanceof ContainerMsgIntent) {
                containerMsgIntent = (ContainerMsgIntent) i3;
            } else {
                containerMsgIntent = null;
            }
            if (containerMsgIntent != null) {
                GuildStandAloneJSVM.this.m(containerMsgIntent);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/aa;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<aa> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull aa event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger.f235387a.d().i("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "onEventReceive: MediaGlobalWebJsEvent. " + event);
            GuildStandAloneJSVM.this.m(event.getIntent());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "Lorg/json/JSONObject;", "result", "", "isFrequentCallback", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f229464a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f229465b;

        d(RequestEvent requestEvent, String str) {
            this.f229464a = requestEvent;
            this.f229465b = str;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c
        public void a(@NotNull JSONObject result, boolean isFrequentCallback) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!isFrequentCallback) {
                Logger logger = Logger.f235387a;
                String str = this.f229465b;
                logger.d().d("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "[callbackToJs] methodTag " + str + ",  result " + result);
            }
            this.f229464a.ok(result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildStandAloneJSVM$e", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/d;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/EntryType;", "a", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(GuildStandAloneJSVM this$0, ContainerMsgIntent intent) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(intent, "$intent");
            this$0.m(intent);
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d
        @NotNull
        public EntryType a() {
            return EntryType.MINI_APP;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d
        public void b(@NotNull final ContainerMsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            final GuildStandAloneJSVM guildStandAloneJSVM = GuildStandAloneJSVM.this;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vm.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildStandAloneJSVM.e.d(GuildStandAloneJSVM.this, intent);
                }
            });
        }
    }

    public GuildStandAloneJSVM() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.actionCallback = bVar;
        this.globalMiniAppJSEvent = new c();
        this.jsMethodMap = new HashMap<>();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(MiniAppIntent.MiniAppRequestEvent.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(MiniAppIntent.GetUserProfileIntent.class).getQualifiedName(), bVar)});
        this.messageList = listOf;
        this.provider = new e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l(MiniAppIntent.GetUserProfileIntent intent) {
        intent.getAsyncResult().a(0L, "", lt1.a.g((com.tencent.base.api.runtime.a) getMContext()).getExtra());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void m(ContainerMsgIntent intent) {
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "[handleJSIntent] intent: " + intent);
        if (intent instanceof MiniAppIntent.GetUserProfileIntent) {
            l((MiniAppIntent.GetUserProfileIntent) intent);
            return;
        }
        if (intent instanceof MiniAppIntent.MiniAppRequestEvent) {
            MiniAppIntent.MiniAppRequestEvent miniAppRequestEvent = (MiniAppIntent.MiniAppRequestEvent) intent;
            logger.d().d("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "[handleJSIntent] event " + lt1.a.e(miniAppRequestEvent.getReq()) + " ");
            String str = miniAppRequestEvent.getReq().event;
            Intrinsics.checkNotNullExpressionValue(str, "intent.req.event");
            p(str, miniAppRequestEvent.getReq());
            return;
        }
        ((com.tencent.base.api.runtime.a) getMContext()).e().h(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        OpenPluginRuntime openPluginRuntime = new OpenPluginRuntime(lt1.a.g((com.tencent.base.api.runtime.a) getMContext()), new WeakReference(ch.m()), new WeakReference(((com.tencent.base.api.runtime.a) getMContext()).f()), this.provider);
        GuildOpenJsMethodProvider guildOpenJsMethodProvider = new GuildOpenJsMethodProvider();
        this.jsMethodMap.putAll(guildOpenJsMethodProvider.b());
        this.jsMethodMap.putAll(guildOpenJsMethodProvider.d());
        Iterator<Map.Entry<String, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b>> it = this.jsMethodMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(openPluginRuntime);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p(String methodTag, RequestEvent req) {
        boolean z16;
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "[onInvoke], methodTag " + methodTag + ", req " + lt1.a.e(req));
        com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b bVar = this.jsMethodMap.get(methodTag);
        JSONObject jSONObject = null;
        if (bVar == null) {
            Logger.b bVar2 = new Logger.b();
            String str = "can not find response handler for " + methodTag;
            if (str instanceof String) {
                bVar2.a().add(str);
            }
            Iterator<T> it = bVar2.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, (String) it.next(), null);
            }
            return;
        }
        try {
            String str2 = req.jsonParams;
            boolean z17 = false;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                jSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
            }
            logger.d().d("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "[onInvoke], methodTag " + methodTag + ", handler " + bVar + ", jsonArgs " + jSONObject);
            bVar.c(lt1.a.b((com.tencent.base.api.runtime.a) getMContext()), jSONObject, new d(req, methodTag));
        } catch (JSONException e16) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            String str3 = "handleJsRequest JSONException " + e16;
            if (str3 instanceof String) {
                bVar3.a().add(str3);
            }
            Iterator<T> it5 = bVar3.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, (String) it5.next(), e16);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<BaseParam> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "[onCreate] ");
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            j e16 = context.e();
            String str = (String) pair.getFirst();
            if (str == null) {
                str = "";
            }
            e16.d(str, (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        n();
        com.tencent.mobileqq.guild.media.core.j.d().V(aa.class, this.globalMiniAppJSEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneJSVM", 1, "[onDestroy] ");
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            j e16 = ((com.tencent.base.api.runtime.a) getMContext()).e();
            String str = (String) pair.getFirst();
            if (str == null) {
                str = "";
            }
            e16.b(str, (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<Map.Entry<String, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b>> it5 = this.jsMethodMap.entrySet().iterator();
        while (it5.hasNext()) {
            it5.next().getValue().onDestroy();
        }
        this.jsMethodMap.clear();
        com.tencent.mobileqq.guild.media.core.j.d().j(aa.class, this.globalMiniAppJSEvent);
    }
}
