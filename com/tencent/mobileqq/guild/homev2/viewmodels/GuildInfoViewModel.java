package com.tencent.mobileqq.guild.homev2.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.homev2.misc.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\t\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b1\u0010\u0015J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000f\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0014R+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R(\u0010(\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00050%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160)8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R%\u00100\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00050%0-8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildInfoViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/homev2/misc/a;", "", "guildId", "", "type", "", "S1", "com/tencent/mobileqq/guild/homev2/viewmodels/GuildInfoViewModel$b", "Q1", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildInfoViewModel$b;", "oldGuildId", "Z2", "onCleared", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/properties/ReadWriteProperty;", "getGuildId", "()Ljava/lang/String;", "R1", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "D", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "setGuildInfo", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "E", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "getObserver", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "observer", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_flowGuildInfo", "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "liveGuildInfo", "Lkotlinx/coroutines/flow/StateFlow;", "O1", "()Lkotlinx/coroutines/flow/StateFlow;", "flowGuildInfo", "<init>", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildInfoViewModel extends ef1.b implements a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver observer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Pair<IGProGuildInfo, Integer>> _flowGuildInfo;
    static final /* synthetic */ KProperty<Object>[] H = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GuildInfoViewModel.class, "guildId", "getGuildId()Ljava/lang/String;", 0))};

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildInfoViewModel$a;", "", "", "type", "", "a", "SOURCE_TYPE_DELETE_GUILD", "I", "SOURCE_TYPE_DESTROY_GUILD", "SOURCE_TYPE_GUILD_ID_CHANGED", "SOURCE_TYPE_GUILD_INFO_UPDATE", "SOURCE_TYPE_GUILD_LIST_UPDATE", "SOURCE_TYPE_INIT", "SOURCE_TYPE_KICK_FROM_GUILD", "SOURCE_TYPE_REMOVE_GUILD", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildInfoViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(int type) {
            switch (type) {
                case 0:
                    return "init";
                case 1:
                    return "guild info update";
                case 2:
                    return "remove guild";
                case 3:
                    return "delete guild";
                case 4:
                    return "kick from guild";
                case 5:
                    return "destroy guild";
                case 6:
                    return "guild list update";
                case 7:
                    return "guild id changed";
                default:
                    return "unknown";
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/homev2/viewmodels/GuildInfoViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "onGuildListUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            GuildInfoViewModel.this.S1(guildId, 4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            GuildInfoViewModel.this.S1(guildId, 3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            GuildInfoViewModel.this.S1(guildId, 5);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            GuildInfoViewModel.this.S1(guildId, 1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildListUpdated() {
            GuildInfoViewModel guildInfoViewModel = GuildInfoViewModel.this;
            guildInfoViewModel.S1(guildInfoViewModel.getGuildId(), 6);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            GuildInfoViewModel.this.S1(guildId, 2);
        }
    }

    public GuildInfoViewModel(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = com.tencent.mobileqq.guild.homev2.misc.b.a(this, guildId);
        b Q1 = Q1();
        this.observer = Q1;
        this._flowGuildInfo = StateFlowKt.MutableStateFlow(new Pair(null, 0));
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGProGlobalService) S0).addObserver(Q1);
        S1(guildId, 0);
    }

    private final b Q1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(String guildId, int type) {
        if (guildId == null || !Intrinsics.areEqual(guildId, getGuildId())) {
            return;
        }
        IGProGuildInfo L = ch.L(guildId);
        this.guildInfo = L;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildInfoViewModel", 2, "updateGuildInfoFrom: guildId = " + guildId + ", type = " + type + "(" + INSTANCE.a(type) + "), result = " + L);
        }
        this._flowGuildInfo.setValue(new Pair<>(L, Integer.valueOf(type)));
    }

    @NotNull
    public final StateFlow<Pair<IGProGuildInfo, Integer>> O1() {
        return FlowKt.asStateFlow(this._flowGuildInfo);
    }

    @NotNull
    public final LiveData<IGProGuildInfo> P1() {
        final MutableStateFlow<Pair<IGProGuildInfo, Integer>> mutableStateFlow = this._flowGuildInfo;
        return FlowLiveDataConversions.asLiveData$default(new Flow<IGProGuildInfo>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildInfoViewModel$special$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildInfoViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<Pair<? extends IGProGuildInfo, ? extends Integer>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f226060d;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildInfoViewModel$special$$inlined$map$1$2", f = "GuildInfoViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildInfoViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f226060d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Pair<? extends IGProGuildInfo, ? extends Integer> pair, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f226060d;
                                IGProGuildInfo first = pair.getFirst();
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(first, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super IGProGuildInfo> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public void R1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId.setValue(this, H[0], str);
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.a
    public void Z2(@NotNull String oldGuildId) {
        Intrinsics.checkNotNullParameter(oldGuildId, "oldGuildId");
        S1(getGuildId(), 7);
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.d
    @NotNull
    public String getGuildId() {
        return (String) this.guildId.getValue(this, H[0]);
    }

    @Nullable
    public final IGProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGProGlobalService) S0).deleteObserver(this.observer);
    }
}
