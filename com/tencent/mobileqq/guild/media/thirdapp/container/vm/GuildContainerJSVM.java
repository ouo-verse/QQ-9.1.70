package com.tencent.mobileqq.guild.media.thirdapp.container.vm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.EntryType;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.GuildOpenJsMethodProvider;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.OpenPluginRuntime;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.k;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001!\u0018\u0000 -2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0003J\b\u0010\u0015\u001a\u00020\u000bH\u0003J\u001a\u0010\u0017\u001a\u00020\u000b2\u0010\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R(\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020!0&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerJSVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVM;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/ContainerLifeEvent;", "event", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isVisible", DomainData.DOMAIN_NAME, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "context", "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/k;", "e", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/k;", "webJSHandler", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerJSVM$d", "f", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerJSVM$d;", "mAction", "", "Lkotlin/Pair;", "", h.F, "Ljava/util/List;", "messageList", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildContainerJSVM extends BaseVM<ol3.b, MviUIState, com.tencent.base.api.runtime.a<BaseParam>> implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k webJSHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, d>> messageList;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229428a;

        static {
            int[] iArr = new int[ContainerLifeEvent.values().length];
            try {
                iArr[ContainerLifeEvent.ON_APP_FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContainerLifeEvent.ON_APP_BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f229428a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerJSVM$c", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/d;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d
        @NotNull
        public EntryType a() {
            return d.a.a(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.d
        public void b(@NotNull ContainerMsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            ((com.tencent.base.api.runtime.a) GuildContainerJSVM.this.getMContext()).e().h(intent);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerJSVM$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildContainerJSVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public GuildContainerJSVM() {
        List<Pair<String, d>> listOf;
        d dVar = new d();
        this.mAction = dVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(Reflection.getOrCreateKotlinClass(MainProcessIntent.ContainerLifeIntent.class).getQualifiedName(), dVar));
        this.messageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerJSVM", 1, "[handleAction] intent " + intent);
        if (intent instanceof MainProcessIntent.ContainerLifeIntent) {
            l(((MainProcessIntent.ContainerLifeIntent) intent).getEvent());
        }
    }

    private final void l(ContainerLifeEvent event) {
        int i3 = b.f229428a[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerJSVM", 1, "[handleContainerLife] else event " + event);
                return;
            }
            k kVar = this.webJSHandler;
            if (kVar != null) {
                kVar.j();
                return;
            }
            return;
        }
        k kVar2 = this.webJSHandler;
        if (kVar2 != null) {
            kVar2.l();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        c cVar = new c();
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        this.webJSHandler = new k(new GuildOpenJsMethodProvider().b(), new OpenPluginRuntime(startParams, new WeakReference(ch.m()), new WeakReference(((com.tencent.base.api.runtime.a) getMContext()).f()), cVar));
        GuildMediaWebIPCServer a16 = GuildMediaWebIPCServer.INSTANCE.a();
        k kVar = this.webJSHandler;
        Intrinsics.checkNotNull(kVar);
        a16.h(kVar);
    }

    private final void n(boolean isVisible) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerJSVM", 1, "[notifyWebForeground] isVisible " + isVisible);
        RemoteWebRenderIPCServer a16 = RemoteWebRenderIPCServer.INSTANCE.a();
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        a16.U(startParams.getWebPageId(), isVisible);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerJSVM", 1, "[onPause] ");
        n(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerJSVM", 1, "[onResume] ");
        n(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<BaseParam> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerJSVM", 1, "[onCreate] ");
        BaseParam h16 = context.h();
        Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher.StartParams");
        this.startParams = (GuildOpenContainerLauncher.StartParams) h16;
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.base.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerJSVM", 1, "[onDestroy] ");
        k kVar = this.webJSHandler;
        if (kVar != null) {
            kVar.e();
            GuildMediaWebIPCServer.INSTANCE.a().r(kVar);
        }
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.base.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }
}
