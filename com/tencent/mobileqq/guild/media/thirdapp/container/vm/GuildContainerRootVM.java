package com.tencent.mobileqq.guild.media.thirdapp.container.vm;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.m;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.a;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.UiThreadUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0002\u0016\u001a\u0018\u0000  2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00062\u00020\u0007:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\t\u001a\u00020\bH\u0003J\b\u0010\n\u001a\u00020\bH\u0003J\u001a\u0010\f\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerRootVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVM;", "Landroidx/lifecycle/LifecycleObserver;", "", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "context", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "notifyShowFullScreen", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerRootVM$b", "f", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerRootVM$b;", "appGuardCallback", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerRootVM$c", h.F, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerRootVM$c;", "webViewStatusListener", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildContainerRootVM extends BaseVM<Object, Object, com.tencent.base.api.runtime.a<BaseParam>> implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable notifyShowFullScreen = new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vm.b
        @Override // java.lang.Runnable
        public final void run() {
            GuildContainerRootVM.m(GuildContainerRootVM.this);
        }
    };

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b appGuardCallback = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c webViewStatusListener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerRootVM$c", "Lcom/tencent/mobileqq/remoteweb/a;", "", "webPageId", "Lcom/tencent/mobileqq/remoteweb/RemoteWebViewEvent;", "event", "", "onWebViewEvent", "", "durationMs", "onServiceDisconnected", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "type", "startTime", "onReportTimeCost", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.remoteweb.a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f229446a;

            static {
                int[] iArr = new int[RemoteWebViewEvent.values().length];
                try {
                    iArr[RemoteWebViewEvent.ON_BEFORE_LOAD_URL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RemoteWebViewEvent.ON_PAGE_STARTED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RemoteWebViewEvent.ON_PAGE_FINISH.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f229446a = iArr;
            }
        }

        c() {
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onFailed(@NotNull String str, int i3, @Nullable String str2) {
            a.C8510a.a(this, str, i3, str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.remoteweb.a
        public void onReportTimeCost(@NotNull String webPageId, @NotNull RemoteWebTimeCost type, long startTime) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(type, "type");
            ((com.tencent.base.api.runtime.a) GuildContainerRootVM.this.getMContext()).e().h(new MainProcessIntent.RemoteWebTimeCostIntent(type));
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onServiceConnected() {
            a.C8510a.c(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.remoteweb.a
        public void onServiceDisconnected(long durationMs) {
            int n3 = m.n(j.c());
            boolean d16 = lt1.a.d((com.tencent.base.api.runtime.a) GuildContainerRootVM.this.getMContext());
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onServiceDisconnected " + durationMs + ", currentTheme: " + n3 + ", isDestroy " + d16;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GuildContainerRootVM", 1, (String) it.next(), null);
            }
            if (n3 == 6 && !d16) {
                lt1.a.i((com.tencent.base.api.runtime.a) GuildContainerRootVM.this.getMContext(), ContainerLifeEvent.ON_REMOTE_WEB_DESTROY);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.a
        public void onWebViewEvent(@NotNull String str, @NotNull RemoteWebViewEvent remoteWebViewEvent, @NotNull Bundle bundle) {
            a.C8510a.f(this, str, remoteWebViewEvent, bundle);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.remoteweb.a
        public void onWebViewEvent(@NotNull String webPageId, @NotNull RemoteWebViewEvent event) {
            ContainerLifeEvent containerLifeEvent;
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(event, "event");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerRootVM", 1, webPageId + " webViewStatusListener.onWebViewEvent " + event);
            int i3 = a.f229446a[event.ordinal()];
            if (i3 == 1) {
                containerLifeEvent = ContainerLifeEvent.ON_BEFORE_LOAD_URL;
            } else if (i3 == 2) {
                containerLifeEvent = ContainerLifeEvent.ON_PAGE_STARTED;
            } else if (i3 != 3) {
                containerLifeEvent = ContainerLifeEvent.UNKNOWN;
            } else {
                containerLifeEvent = ContainerLifeEvent.ON_PAGE_FINISH;
            }
            if (containerLifeEvent != ContainerLifeEvent.UNKNOWN) {
                lt1.a.i((com.tencent.base.api.runtime.a) GuildContainerRootVM.this.getMContext(), containerLifeEvent);
            }
            if (containerLifeEvent == ContainerLifeEvent.ON_BEFORE_LOAD_URL) {
                UiThreadUtil.runOnUiThread(GuildContainerRootVM.this.notifyShowFullScreen, 1500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(GuildContainerRootVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((com.tencent.base.api.runtime.a) this$0.getMContext()).e().h(ToolProcessIntent.ShowFullScreenIconIntent.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerRootVM", 1, "[onPause] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_PAUSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerRootVM", 1, "[onResume] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_RESUME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<BaseParam> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerRootVM", 1, "[onCreate] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_CREATE);
        BaseParam h16 = context.h();
        Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher.StartParams");
        this.startParams = (GuildOpenContainerLauncher.StartParams) h16;
        GuardManagerCallbackDispatcher.registerCallBack(this.appGuardCallback);
        RemoteWebRenderIPCServer.INSTANCE.a().w(this.webViewStatusListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerRootVM", 1, "[onDestroy] ");
        lt1.a.i((com.tencent.base.api.runtime.a) getMContext(), ContainerLifeEvent.ON_DESTROY);
        GuardManagerCallbackDispatcher.unregisterCallBack(this.appGuardCallback);
        RemoteWebRenderIPCServer.INSTANCE.a().f0(this.webViewStatusListener);
        UiThreadUtil.remove(this.notifyShowFullScreen);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerRootVM$b", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IGuardInterface {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerRootVM", 1, "[onApplicationBackground] ");
            ((com.tencent.base.api.runtime.a) GuildContainerRootVM.this.getMContext()).e().h(new MainProcessIntent.ContainerLifeIntent(ContainerLifeEvent.ON_APP_BACKGROUND));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerRootVM", 1, "[onApplicationForeground] ");
            ((com.tencent.base.api.runtime.a) GuildContainerRootVM.this.getMContext()).e().h(new MainProcessIntent.ContainerLifeIntent(ContainerLifeEvent.ON_APP_FOREGROUND));
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
