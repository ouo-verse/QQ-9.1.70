package com.tencent.mobileqq.guild.home.viewmodels.header;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.base.extension.FlowKt$throttle$1;
import com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.header.processors.b;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\u001e!\u0018\u0000 ^2\u00020\u0001:\u0001_B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0014\u0010\u001a\u001a\u00020\u00042\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002J$\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\rH\u0002J\u000f\u0010\u001f\u001a\u00020\u001eH\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010%\u001a\u00020$H\u0002R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020*0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020*0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010J\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010 R\u001b\u0010M\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010H\u001a\u0004\bL\u0010#R\u001b\u0010Q\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010H\u001a\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001d\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0U8F\u00a2\u0006\u0006\u001a\u0004\bV\u0010WR\u0014\u0010[\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010Z\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel;", "Lef1/b;", "", "account", "", "onAccountChanged", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", NodeProps.COLORS, "p2", "o2", "", ViewStickEventHelper.IS_SHOW, "m2", "onResume", "k2", "j2", "onCleared", "from", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "l2", "W1", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/c;", "event", "f2", "needUpdateList", "forceUpdateMapData", "g2", "com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel$b", "X1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel$b;", "com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel$c", "Z1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel$c;", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$d;", ICustomDataEditor.STRING_ARRAY_PARAM_2, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "Le12/a;", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "D", "Le12/a;", "_dataList", "", "E", "Ljava/util/List;", "allList", "Lkotlinx/coroutines/Job;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/Job;", "collectJob", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "G", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "", "", "H", "Ljava/util/Map;", "headerBarsDataMap", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/f;", "I", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/f;", "dataConvertor", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/b;", "J", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/b;", "processors", "K", "Lkotlin/Lazy;", "e2", "preloadHeaderInfoListener", "L", "c2", "preloadGameInfoListener", "M", "d2", "()Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$d;", "preloadGroupChatListener", "N", "Z", "isFirstTimeOnResume", "Landroidx/lifecycle/LiveData;", "b2", "()Landroidx/lifecycle/LiveData;", "dataList", "getGuildId", "()Ljava/lang/String;", "guildId", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", "P", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderBarsViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private FacadeArgsData facadeArgsData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.a<List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b>> _dataList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> allList;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Job collectJob;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> headerBarsDataMap;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final f dataConvertor;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.viewmodels.header.processors.b processors;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy preloadHeaderInfoListener;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy preloadGameInfoListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy preloadGroupChatListener;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isFirstTimeOnResume;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel$b", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$b;", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildMainFrameHeaderInfo;", "headerIndo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildHomeHeaderRepository.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository.b
        public void a(@NotNull String guildId, @Nullable IGProGuildMainFrameHeaderInfo headerIndo) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildHomeHeaderBarsViewModel.this.dataConvertor.h(guildId, headerIndo, "GuildHomeHeaderBarsViewModel");
            GuildHomeHeaderBarsViewModel.h2(GuildHomeHeaderBarsViewModel.this, "onHeaderChange", false, true, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel$c", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$c;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements GuildHomeHeaderRepository.c {
        c() {
        }
    }

    public GuildHomeHeaderBarsViewModel(@NotNull FacadeArgsData facadeArgsData) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        this._dataList = new e12.a<>();
        this.allList = new ArrayList();
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        this.headerBarsDataMap = new LinkedHashMap();
        f fVar = new f(this.facadeArgsData);
        this.dataConvertor = fVar;
        b.Companion companion = com.tencent.mobileqq.guild.home.viewmodels.header.processors.b.INSTANCE;
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        this.processors = companion.a(str, fVar);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel$preloadHeaderInfoListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeHeaderBarsViewModel.b invoke() {
                GuildHomeHeaderBarsViewModel.b X1;
                X1 = GuildHomeHeaderBarsViewModel.this.X1();
                return X1;
            }
        });
        this.preloadHeaderInfoListener = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel$preloadGameInfoListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeHeaderBarsViewModel.c invoke() {
                GuildHomeHeaderBarsViewModel.c Z1;
                Z1 = GuildHomeHeaderBarsViewModel.this.Z1();
                return Z1;
            }
        });
        this.preloadGameInfoListener = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeHeaderRepository.d>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel$preloadGroupChatListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeHeaderRepository.d invoke() {
                GuildHomeHeaderRepository.d a26;
                a26 = GuildHomeHeaderBarsViewModel.this.a2();
                return a26;
            }
        });
        this.preloadGroupChatListener = lazy3;
        this.isFirstTimeOnResume = true;
        l2("init");
        W1();
        GuildHomeHeaderRepository guildHomeHeaderRepository = GuildHomeHeaderRepository.f225337d;
        guildHomeHeaderRepository.j(e2());
        guildHomeHeaderRepository.h(c2());
        guildHomeHeaderRepository.i(d2());
    }

    private final void W1() {
        Job job = this.collectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Flow onEach = FlowKt.onEach(this.processors.c(), new GuildHomeHeaderBarsViewModel$collectProcessorEventSource$1(this, null));
        Ref.LongRef longRef = new Ref.LongRef();
        Job launchIn = FlowKt.launchIn(FlowKt.m2026catch(FlowKt.onEach(FlowKt.debounce(onEach, new FlowKt$throttle$1(longRef, 800L)), new GuildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1(longRef, null, this)), new GuildHomeHeaderBarsViewModel$collectProcessorEventSource$3(null)), ViewModelKt.getViewModelScope(this));
        this.collectJob = launchIn;
        if (launchIn != null) {
            launchIn.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel$collectProcessorEventSource$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    Logger.f235387a.d().d("GuildHomeHeaderBarsViewModel", 1, "collectProcessorEventSource completed " + th5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b X1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c Z1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildHomeHeaderRepository.d a2() {
        return new GuildHomeHeaderRepository.d() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.h
        };
    }

    private final c c2() {
        return (c) this.preloadGameInfoListener.getValue();
    }

    private final GuildHomeHeaderRepository.d d2() {
        return (GuildHomeHeaderRepository.d) this.preloadGroupChatListener.getValue();
    }

    private final b e2() {
        return (b) this.preloadHeaderInfoListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<?> event) {
        Iterator<T> it = event.a().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("GuildHomeHeaderBarsViewModel", 1, "updateItem " + event);
            }
            com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar = this.headerBarsDataMap.get(pair.getFirst());
            if (bVar == null) {
                Logger.b bVar2 = new Logger.b();
                String str = "headerBarsDataMap NotFind " + pair.getFirst();
                if (str instanceof String) {
                    bVar2.a().add(str);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("GuildHomeHeaderBarsViewModel", 1, (String) it5.next(), null);
                }
            } else {
                com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b replacedItem = event.b().l(bVar, pair.getSecond(), this.allList).getReplacedItem();
                if (replacedItem != null) {
                    this.headerBarsDataMap.put(Integer.valueOf(replacedItem.getId()), replacedItem);
                    i.b(this.allList, replacedItem);
                }
            }
        }
    }

    private final void g2(final String from, final boolean needUpdateList, final boolean forceUpdateMapData) {
        UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeHeaderBarsViewModel.i2(needUpdateList, this, forceUpdateMapData, from);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getGuildId() {
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h2(GuildHomeHeaderBarsViewModel guildHomeHeaderBarsViewModel, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        guildHomeHeaderBarsViewModel.g2(str, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(boolean z16, GuildHomeHeaderBarsViewModel this$0, boolean z17, String from) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(from, "$from");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeHeaderBarsViewModel", 1, "notifyDataChanged from:" + from);
        }
        if (z16) {
            this$0.allList.clear();
            this$0.allList.addAll(this$0.dataConvertor.d());
        }
        this$0._dataList.setValue(i.f225419a.a(this$0.allList));
        if (z17) {
            for (com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar : this$0.allList) {
                this$0.headerBarsDataMap.put(Integer.valueOf(bVar.getId()), bVar);
            }
        }
    }

    private final com.tencent.mobileqq.qcoroutine.api.coroutine.b l2(String from) {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildHomeHeaderBarsViewModel activateGuild", null, null, Boolean.TRUE, new GuildHomeHeaderBarsViewModel$refreshData$1(this, null), 6, null);
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b>> b2() {
        return this._dataList;
    }

    public final void j2() {
        this.processors.e();
    }

    public final void k2() {
        this.processors.f();
    }

    public final void m2(boolean isShow) {
        this.dataConvertor.k(isShow);
        h2(this, "updateGroupChatShow", false, true, 2, null);
    }

    public final void n2(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        this.dataConvertor.l(facadeArgsData);
        com.tencent.mobileqq.guild.home.viewmodels.header.processors.b bVar = this.processors;
        String str = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        bVar.g(str);
        this.dataConvertor.g(false);
        String str2 = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
        GuildHomeHeaderRepository.J(str2, false, 2, null);
    }

    public final void o2() {
        this.dataConvertor.m();
        h2(this, "updateNavigatorExpand", false, true, 2, null);
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.processors.d(account);
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeHeaderBarsViewModel", 1, "onCleared");
        }
        this.processors.b();
        GuildHomeHeaderRepository guildHomeHeaderRepository = GuildHomeHeaderRepository.f225337d;
        guildHomeHeaderRepository.o(e2());
        guildHomeHeaderRepository.m(c2());
        guildHomeHeaderRepository.n(d2());
    }

    public final void onResume() {
        if (this.isFirstTimeOnResume) {
            this.isFirstTimeOnResume = false;
            return;
        }
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        GuildHomeHeaderRepository.J(str, false, 2, null);
    }

    public final void p2(@NotNull GuildHomeCoverColors colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.dataConvertor.n(colors);
        h2(this, "updateTintColors", false, true, 2, null);
    }
}
