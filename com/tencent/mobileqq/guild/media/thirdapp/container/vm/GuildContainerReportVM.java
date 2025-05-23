package com.tencent.mobileqq.guild.media.thirdapp.container.vm;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.report.GuildMediaWebTimeReportTask;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001'\u0018\u0000 72.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u001a\u0010\u0015\u001a\u00020\b2\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R(\u00100\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020'0,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerReportVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVM;", "", "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/ContainerLifeEvent;", "event", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "u", "context", "t", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "", "e", "Z", "isWebStarted", "", "f", "J", "webStartTime", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/b;", h.F, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/b;", "lifeReportTask", "com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerReportVM$c", "i", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerReportVM$c;", "mAction", "", "Lkotlin/Pair;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "messageList", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebTimeReportTask;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/thirdapp/container/report/GuildMediaWebTimeReportTask;", "timeReportTask", "<init>", "()V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildContainerReportVM extends BaseVM<ol3.b, MviUIState, com.tencent.base.api.runtime.a<BaseParam>> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildMediaWebTimeReportTask timeReportTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildOpenContainerLauncher.StartParams startParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isWebStarted;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long webStartTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.thirdapp.container.report.b lifeReportTask = new com.tencent.mobileqq.guild.media.thirdapp.container.report.b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, c>> messageList;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229437a;

        static {
            int[] iArr = new int[ContainerLifeEvent.values().length];
            try {
                iArr[ContainerLifeEvent.ON_SURFACE_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContainerLifeEvent.ON_SURFACE_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContainerLifeEvent.ON_REMOTE_WEB_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ContainerLifeEvent.ON_REMOTE_WEB_REBUILD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f229437a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/vm/GuildContainerReportVM$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildContainerReportVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public GuildContainerReportVM() {
        List<Pair<String, c>> listOf;
        c cVar = new c();
        this.mAction = cVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(Reflection.getOrCreateKotlinClass(MainProcessIntent.ContainerLifeIntent.class).getQualifiedName(), cVar));
        this.messageList = listOf;
        this.timeReportTask = new GuildMediaWebTimeReportTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerReportVM", 1, "[handleAction] intent " + intent);
        if (intent instanceof MainProcessIntent.ContainerLifeIntent) {
            p(((MainProcessIntent.ContainerLifeIntent) intent).getEvent());
        } else if (intent instanceof MainProcessIntent.RemoteWebTimeCostIntent) {
            this.timeReportTask.c(((MainProcessIntent.RemoteWebTimeCostIntent) intent).getType());
        }
    }

    private final void o() {
        GuildMediaWebIPCServer a16 = GuildMediaWebIPCServer.INSTANCE.a();
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        a16.i(startParams.getWebPageId(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vm.GuildContainerReportVM$checkIfWebAlreadyAttach$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                GuildMediaWebTimeReportTask guildMediaWebTimeReportTask;
                com.tencent.mobileqq.guild.media.thirdapp.container.report.b bVar;
                Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerReportVM", 1, "checkIfWebAlreadyAttach result " + z16);
                if (z16) {
                    guildMediaWebTimeReportTask = GuildContainerReportVM.this.timeReportTask;
                    guildMediaWebTimeReportTask.f();
                    bVar = GuildContainerReportVM.this.lifeReportTask;
                    bVar.f();
                }
            }
        });
    }

    private final void p(ContainerLifeEvent event) {
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaThirdApp.GuildContainerReportVM", 1, "[handleContainerLife] event " + event);
        int i3 = b.f229437a[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        logger.d().d("QGMC.MediaThirdApp.GuildContainerReportVM", 1, "[handleContainerLife] else event " + event);
                        return;
                    }
                    q();
                    return;
                }
                this.timeReportTask.d("media_web_service_disconnection");
                this.lifeReportTask.d(true);
                return;
            }
            s();
            return;
        }
        r();
    }

    private final void q() {
        this.timeReportTask.d("media_web_remote_rebuild");
    }

    private final void r() {
        u();
        this.timeReportTask.d("media_web_surface_create");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        boolean d16 = lt1.a.d((com.tencent.base.api.runtime.a) getMContext());
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerReportVM", 1, "onSurfaceTextureDestroyed " + d16);
        if (!d16) {
            this.timeReportTask.d("media_web_surface_destroy");
        }
    }

    private final void u() {
        if (this.isWebStarted) {
            return;
        }
        this.isWebStarted = true;
        this.webStartTime = System.currentTimeMillis();
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerReportVM", 1, "[reportWebRealStart] webStartTime " + this.webStartTime);
        GuildMediaWebTimeReportTask guildMediaWebTimeReportTask = this.timeReportTask;
        GuildOpenContainerLauncher.StartParams startParams = this.startParams;
        GuildOpenContainerLauncher.StartParams startParams2 = null;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
            startParams = null;
        }
        guildMediaWebTimeReportTask.h(startParams);
        com.tencent.mobileqq.guild.media.thirdapp.container.report.b bVar = this.lifeReportTask;
        GuildOpenContainerLauncher.StartParams startParams3 = this.startParams;
        if (startParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startParams");
        } else {
            startParams2 = startParams3;
        }
        bVar.g(startParams2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerReportVM", 1, "[onDestroy] ");
        this.timeReportTask.e();
        com.tencent.mobileqq.guild.media.thirdapp.container.report.b.e(this.lifeReportTask, false, 1, null);
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.base.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<BaseParam> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildContainerReportVM", 1, "[onCreate] ");
        BaseParam h16 = context.h();
        Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher.StartParams");
        this.startParams = (GuildOpenContainerLauncher.StartParams) h16;
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.base.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        o();
    }
}
