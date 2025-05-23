package com.tencent.mobileqq.guild.homev2.viewmodels;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import androidx.core.os.BundleKt;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.homev2.misc.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildHomeSections;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import lp1.SubTabData;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ch;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0011\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b2\u0010 J\u001d\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0003J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0014R+\u0010\r\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00038V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R&\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0%0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010#R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001d\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0!8F\u00a2\u0006\u0006\u001a\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildTabsViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/homev2/misc/a;", "", "source", "", "W1", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Llp1/c;", "T1", "(Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildTabsViewModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildHomeSections;", "U1", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com/tencent/mobileqq/guild/homev2/viewmodels/GuildTabsViewModel$b", "R1", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildTabsViewModel$b;", "Z1", "account", "onAccountChanged", "oldGuildId", "Z2", "onCleared", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/properties/ReadWriteProperty;", "getGuildId", "()Ljava/lang/String;", "X1", "(Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "D", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_flowTabItems", "Lkotlin/Pair;", "E", "refreshTabFlow", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "G", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildTabsViewModel$b;", "observer", "S1", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "flowTabItems", "<init>", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildTabsViewModel extends ef1.b implements a {

    @NotNull
    private static final Set<Integer> J;

    @NotNull
    private static final Set<Integer> K;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableStateFlow<List<SubTabData>> _flowTabItems;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Pair<String, Long>> refreshTabFlow;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private b observer;
    static final /* synthetic */ KProperty<Object>[] I = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GuildTabsViewModel.class, "guildId", "getGuildId()Ljava/lang/String;", 0))};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildTabsViewModel$2", f = "GuildTabsViewModel.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildTabsViewModel$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                GuildTabsViewModel guildTabsViewModel = GuildTabsViewModel.this;
                this.label = 1;
                if (guildTabsViewModel.W1("init", this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildTabsViewModel$3", f = "GuildTabsViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildTabsViewModel$3, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Pair<? extends String, ? extends Long>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Pair<? extends String, ? extends Long> pair, Continuation<? super Unit> continuation) {
            return invoke2((Pair<String, Long>) pair, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                GuildTabsViewModel guildTabsViewModel = GuildTabsViewModel.this;
                String str = "tabRefresh(" + pair.getFirst() + ")";
                this.label = 1;
                if (guildTabsViewModel.W1(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull Pair<String, Long> pair, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/homev2/viewmodels/GuildTabsViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onChannelListUpdated", "onGuildInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            if (!Intrinsics.areEqual(guildId, GuildTabsViewModel.this.getGuildId())) {
                return;
            }
            GuildTabsViewModel.this.refreshTabFlow.setValue(TuplesKt.to("onChannelListUpdated", Long.valueOf(SystemClock.uptimeMillis())));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (!Intrinsics.areEqual(guildId, GuildTabsViewModel.this.getGuildId())) {
                return;
            }
            GuildTabsViewModel.this.refreshTabFlow.setValue(TuplesKt.to("onGuildInfoUpdated", Long.valueOf(SystemClock.uptimeMillis())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildHomeSections;", "kotlin.jvm.PlatformType", "result", "", "a", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildHomeSections;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ch {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<IGProGuildHomeSections> f226067b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super IGProGuildHomeSections> cancellableContinuation) {
            this.f226067b = cancellableContinuation;
        }

        @Override // wh2.ch
        public final void a(IGProGuildHomeSections iGProGuildHomeSections) {
            Object m476constructorimpl;
            try {
                this.f226067b.resumeWith(Result.m476constructorimpl(iGProGuildHomeSections));
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("getGuildHomeSections() resume Fails");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildTabsViewModel", 1, (String) it.next(), m479exceptionOrNullimpl);
                }
            }
        }
    }

    static {
        Set<Integer> of5;
        Set<Integer> of6;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 6});
        J = of5;
        of6 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 2});
        K = of6;
    }

    public GuildTabsViewModel(@NotNull String guildId) {
        List emptyList;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = com.tencent.mobileqq.guild.homev2.misc.b.a(this, guildId);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this._flowTabItems = StateFlowKt.MutableStateFlow(emptyList);
        MutableStateFlow<Pair<String, Long>> MutableStateFlow = StateFlowKt.MutableStateFlow(TuplesKt.to("init", 0L));
        this.refreshTabFlow = MutableStateFlow;
        r rVar = r.f214743a;
        IRuntimeService S0 = com.tencent.mobileqq.guild.util.ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        this.gProService = (IGPSService) S0;
        this.observer = R1();
        Logger.f235387a.d().d("GuildTabsViewModel", 1, "init: " + guildId);
        this.gProService.addObserver(this.observer);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
        FlowKt.launchIn(FlowKt.onEach(FlowKt.sample(MutableStateFlow, 1000L), new AnonymousClass3(null)), ViewModelKt.getViewModelScope(this));
    }

    private final b R1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object T1(GuildTabsViewModel guildTabsViewModel, Continuation<? super List<SubTabData>> continuation) {
        GuildTabsViewModel$getGuildHomeItems$1 guildTabsViewModel$getGuildHomeItems$1;
        Object coroutine_suspended;
        int i3;
        String b16;
        if (continuation instanceof GuildTabsViewModel$getGuildHomeItems$1) {
            guildTabsViewModel$getGuildHomeItems$1 = (GuildTabsViewModel$getGuildHomeItems$1) continuation;
            int i16 = guildTabsViewModel$getGuildHomeItems$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildTabsViewModel$getGuildHomeItems$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildTabsViewModel$getGuildHomeItems$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildTabsViewModel$getGuildHomeItems$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        guildTabsViewModel = (GuildTabsViewModel) guildTabsViewModel$getGuildHomeItems$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    long l3 = MiscKt.l(guildTabsViewModel.getGuildId());
                    guildTabsViewModel$getGuildHomeItems$1.L$0 = guildTabsViewModel;
                    guildTabsViewModel$getGuildHomeItems$1.label = 1;
                    obj = guildTabsViewModel.U1(l3, guildTabsViewModel$getGuildHomeItems$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                IGProGuildHomeSections iGProGuildHomeSections = (IGProGuildHomeSections) obj;
                List<SubTabData> Z1 = guildTabsViewModel.Z1(iGProGuildHomeSections, guildTabsViewModel.getGuildId());
                Logger.a d16 = Logger.f235387a.d();
                b16 = GuildTabsViewModelKt.b(iGProGuildHomeSections);
                d16.a("GuildTabsViewModel", 1, "refreshTabPageData " + b16);
                return Z1;
            }
        }
        guildTabsViewModel$getGuildHomeItems$1 = new GuildTabsViewModel$getGuildHomeItems$1(this, continuation);
        Object obj2 = guildTabsViewModel$getGuildHomeItems$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildTabsViewModel$getGuildHomeItems$1.label;
        if (i3 == 0) {
        }
        IGProGuildHomeSections iGProGuildHomeSections2 = (IGProGuildHomeSections) obj2;
        List<SubTabData> Z12 = guildTabsViewModel.Z1(iGProGuildHomeSections2, guildTabsViewModel.getGuildId());
        Logger.a d162 = Logger.f235387a.d();
        b16 = GuildTabsViewModelKt.b(iGProGuildHomeSections2);
        d162.a("GuildTabsViewModel", 1, "refreshTabPageData " + b16);
        return Z12;
    }

    private final Object U1(long j3, Continuation<? super IGProGuildHomeSections> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.gProService.getGuildHomeSections(j3, new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object W1(String str, Continuation<? super Unit> continuation) {
        GuildTabsViewModel$refresh$1 guildTabsViewModel$refresh$1;
        Object coroutine_suspended;
        int i3;
        GuildTabsViewModel guildTabsViewModel;
        if (continuation instanceof GuildTabsViewModel$refresh$1) {
            guildTabsViewModel$refresh$1 = (GuildTabsViewModel$refresh$1) continuation;
            int i16 = guildTabsViewModel$refresh$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildTabsViewModel$refresh$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildTabsViewModel$refresh$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildTabsViewModel$refresh$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        guildTabsViewModel = (GuildTabsViewModel) guildTabsViewModel$refresh$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Logger.f235387a.d().d("GuildTabsViewModel", 1, "refresh[" + str + "]: guildId=" + getGuildId());
                    guildTabsViewModel$refresh$1.L$0 = this;
                    guildTabsViewModel$refresh$1.label = 1;
                    obj = T1(this, guildTabsViewModel$refresh$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildTabsViewModel = this;
                }
                guildTabsViewModel._flowTabItems.setValue((List) obj);
                return Unit.INSTANCE;
            }
        }
        guildTabsViewModel$refresh$1 = new GuildTabsViewModel$refresh$1(this, continuation);
        Object obj2 = guildTabsViewModel$refresh$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildTabsViewModel$refresh$1.label;
        if (i3 == 0) {
        }
        guildTabsViewModel._flowTabItems.setValue((List) obj2);
        return Unit.INSTANCE;
    }

    @SuppressLint({"WrongConstant"})
    private final List<SubTabData> Z1(IGProGuildHomeSections iGProGuildHomeSections, String str) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List take;
        List plus;
        List drop;
        List<SubTabData> plus2;
        SubTabData subTabData;
        ArrayList<IGProCategoryChannelInfoList> commonCategories = iGProGuildHomeSections.getCommonCategories();
        Intrinsics.checkNotNullExpressionValue(commonCategories, "this.commonCategories");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(commonCategories, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProCategoryChannelInfoList iGProCategoryChannelInfoList : commonCategories) {
            long categoryId = iGProCategoryChannelInfoList.getCategoryId();
            int categoryType = iGProCategoryChannelInfoList.getCategoryType();
            String categoryName = iGProCategoryChannelInfoList.getCategoryName();
            Intrinsics.checkNotNullExpressionValue(categoryName, "it.name");
            arrayList.add(new SubTabData(categoryId, categoryType, categoryName, iGProCategoryChannelInfoList.getUrl(), iGProCategoryChannelInfoList.getUrlType(), BundleKt.bundleOf(TuplesKt.to("guildId", str), TuplesKt.to("EXTRA_CATEGORY_ID", Long.valueOf(iGProCategoryChannelInfoList.getCategoryId())), TuplesKt.to("EXTRA_CATEGORY_NAME", iGProCategoryChannelInfoList.getCategoryName()), TuplesKt.to("EXTRA_URL", iGProCategoryChannelInfoList.getUrl()))));
        }
        ArrayList<IGProChannel> feedChannels = iGProGuildHomeSections.getFeedChannels();
        Intrinsics.checkNotNullExpressionValue(feedChannels, "this.feedChannels");
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(feedChannels, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (IGProChannel iGProChannel : feedChannels) {
            if (iGProChannel.getHiddenPostChannel() == 1) {
                subTabData = new SubTabData(iGProChannel.getCategoryInfo().getCategoryId(), 1, "\u5168\u90e8", null, 0, BundleKt.bundleOf(TuplesKt.to("EXTRA_CATEGORY_ID", Long.valueOf(iGProChannel.getCategoryInfo().getCategoryId())), TuplesKt.to("EXTRA_CATEGORY_NAME", "\u5168\u90e8"), TuplesKt.to("channelId", String.valueOf(iGProChannel.getChannelId()))), 24, null);
            } else {
                long channelId = iGProChannel.getChannelId();
                String channelName = iGProChannel.getChannelName();
                Intrinsics.checkNotNullExpressionValue(channelName, "channel.channelName");
                subTabData = new SubTabData(channelId, 99, channelName, null, 0, BundleKt.bundleOf(TuplesKt.to("EXTRA_CATEGORY_ID", Long.valueOf(iGProChannel.getCategoryInfo().getCategoryId())), TuplesKt.to("EXTRA_CATEGORY_NAME", iGProChannel.getChannelName()), TuplesKt.to("channelId", String.valueOf(iGProChannel.getChannelId()))), 24, null);
            }
            arrayList2.add(subTabData);
        }
        take = CollectionsKt___CollectionsKt.take(arrayList2, 1);
        plus = CollectionsKt___CollectionsKt.plus((Collection) take, (Iterable) arrayList);
        drop = CollectionsKt___CollectionsKt.drop(arrayList2, 1);
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) drop);
        return plus2;
    }

    @NotNull
    public final MutableStateFlow<List<SubTabData>> S1() {
        return this._flowTabItems;
    }

    public void X1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId.setValue(this, I[0], str);
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.a
    public void Z2(@NotNull String oldGuildId) {
        Intrinsics.checkNotNullParameter(oldGuildId, "oldGuildId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GuildTabsViewModel$onGuildIdChanged$1(this, null), 3, null);
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.d
    @NotNull
    public String getGuildId() {
        return (String) this.guildId.getValue(this, I[0]);
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.gProService.deleteObserver(this.observer);
        r rVar = r.f214743a;
        IRuntimeService S0 = com.tencent.mobileqq.guild.util.ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        this.gProService = iGPSService;
        iGPSService.addObserver(this.observer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(this.observer);
    }
}
