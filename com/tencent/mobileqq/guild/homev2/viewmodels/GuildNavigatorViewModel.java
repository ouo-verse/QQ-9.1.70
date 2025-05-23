package com.tencent.mobileqq.guild.homev2.viewmodels;

import android.os.SystemClock;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.home.navigator.NavigatorData;
import com.tencent.mobileqq.guild.homev2.misc.a;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info;
import com.tencent.mobileqq.qqguildsdk.data.genc.bn;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.cg;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\t\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\f\u00a2\u0006\u0004\b/\u0010\u001bJ\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0007H\u0002J\u000f\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fR+\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildNavigatorViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/homev2/misc/a;", "", "Lcom/tencent/mobileqq/guild/home/navigator/d;", "T1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "Z1", "com/tencent/mobileqq/guild/homev2/viewmodels/GuildNavigatorViewModel$b", "S1", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildNavigatorViewModel$b;", "", "account", "", "onAccountChanged", "onCleared", "oldGuildId", "Z2", "from", "W1", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/properties/ReadWriteProperty;", "getGuildId", "()Ljava/lang/String;", "X1", "(Ljava/lang/String;)V", "guildId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "D", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_navigatorFlow", "", "E", "refreshTabFlow", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "G", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildNavigatorViewModel$b;", "observer", "Lkotlinx/coroutines/flow/StateFlow;", "U1", "()Lkotlinx/coroutines/flow/StateFlow;", "navigatorFlow", "<init>", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNavigatorViewModel extends ef1.b implements a {

    @NotNull
    private static final Set<Integer> J;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<List<NavigatorData>> _navigatorFlow;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Long> refreshTabFlow;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private b observer;
    static final /* synthetic */ KProperty<Object>[] I = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GuildNavigatorViewModel.class, "guildId", "getGuildId()Ljava/lang/String;", 0))};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildNavigatorViewModel$1", f = "GuildNavigatorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildNavigatorViewModel$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invoke(long j3, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(Long.valueOf(j3), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildNavigatorViewModel.this.W1("push");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Long l3, Continuation<? super Unit> continuation) {
            return invoke(l3.longValue(), continuation);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/homev2/viewmodels/GuildNavigatorViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onChannelListUpdated", "onGuildInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            if (!Intrinsics.areEqual(guildId, GuildNavigatorViewModel.this.getGuildId())) {
                return;
            }
            GuildNavigatorViewModel.this.refreshTabFlow.setValue(Long.valueOf(SystemClock.uptimeMillis()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (!Intrinsics.areEqual(guildId, GuildNavigatorViewModel.this.getGuildId())) {
                return;
            }
            GuildNavigatorViewModel.this.refreshTabFlow.setValue(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "categories", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "kotlin.jvm.PlatformType", "onGetGuildHomeCategories"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class c implements cg {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<List<NavigatorData>> f226063a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildNavigatorViewModel f226064b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super List<NavigatorData>> cancellableContinuation, GuildNavigatorViewModel guildNavigatorViewModel) {
            this.f226063a = cancellableContinuation;
            this.f226064b = guildNavigatorViewModel;
        }

        @Override // wh2.cg
        public final void onGetGuildHomeCategories(ArrayList<IGProCategoryChannelInfoList> categories) {
            boolean z16;
            List emptyList;
            if (categories != null && !categories.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("getCategoryChannelIdListExcludeCategoryType empty");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.NewHome.GuildNavigatorViewModel", 1, (String) it.next(), null);
                }
                CancellableContinuation<List<NavigatorData>> cancellableContinuation = this.f226063a;
                Result.Companion companion = Result.INSTANCE;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                cancellableContinuation.resumeWith(Result.m476constructorimpl(emptyList));
                return;
            }
            Intrinsics.checkNotNullExpressionValue(categories, "categories");
            GuildNavigatorViewModel guildNavigatorViewModel = this.f226064b;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it5 = categories.iterator();
            while (it5.hasNext()) {
                NavigatorData Z1 = guildNavigatorViewModel.Z1((IGProCategoryChannelInfoList) it5.next());
                if (Z1 != null) {
                    arrayList.add(Z1);
                }
            }
            this.f226063a.resumeWith(Result.m476constructorimpl(arrayList));
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.NewHome.GuildNavigatorViewModel", 2, "getCategoryChannelIdListExcludeCategoryType success  " + arrayList.size());
            }
        }
    }

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{9, 3, 7, 11, 10, 2});
        J = of5;
    }

    public GuildNavigatorViewModel(@NotNull String guildId) {
        List emptyList;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = com.tencent.mobileqq.guild.homev2.misc.b.a(this, guildId);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this._navigatorFlow = StateFlowKt.MutableStateFlow(emptyList);
        MutableStateFlow<Long> MutableStateFlow = StateFlowKt.MutableStateFlow(0L);
        this.refreshTabFlow = MutableStateFlow;
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        this.gProService = (IGPSService) S0;
        b S1 = S1();
        this.observer = S1;
        this.gProService.addObserver(S1);
        W1("init");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.sample(MutableStateFlow, 1000L), new AnonymousClass1(null)), ViewModelKt.getViewModelScope(this));
    }

    private final b S1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object T1(Continuation<? super List<NavigatorData>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        bn bnVar = new bn();
        bnVar.e(MiscKt.l(getGuildId()));
        bnVar.f(true);
        bnVar.d(true);
        this.gProService.getGuildHomeCategories(bnVar, new c(cancellableContinuationImpl, this));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigatorData Z1(IGProCategoryChannelInfoList iGProCategoryChannelInfoList) {
        String str;
        String str2;
        int i3;
        String str3;
        Object firstOrNull;
        String str4 = null;
        if (iGProCategoryChannelInfoList == null || !J.contains(Integer.valueOf(iGProCategoryChannelInfoList.getCategoryType())) || iGProCategoryChannelInfoList.getCloseSwitch()) {
            return null;
        }
        long categoryId = iGProCategoryChannelInfoList.getCategoryId();
        if (iGProCategoryChannelInfoList.getCategoryType() == 7) {
            ArrayList<IGProChannel> channelInfoList = iGProCategoryChannelInfoList.getChannelInfoList();
            Intrinsics.checkNotNullExpressionValue(channelInfoList, "channelInfoList");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) channelInfoList);
            IGProChannel iGProChannel = (IGProChannel) firstOrNull;
            if (iGProChannel == null) {
                Logger.f235387a.d().w("Guild.NewHome.GuildNavigatorViewModel", 1, "schedule info convert error " + iGProCategoryChannelInfoList);
                return null;
            }
            categoryId = iGProChannel.getChannelId();
        }
        long j3 = categoryId;
        int categoryType = iGProCategoryChannelInfoList.getCategoryType();
        String name = iGProCategoryChannelInfoList.getCategoryName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        IGProNavigationV2Info navigation = iGProCategoryChannelInfoList.getNavigation();
        if (navigation != null) {
            str = navigation.getIconUrl();
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        IGProNavigationV2Info navigation2 = iGProCategoryChannelInfoList.getNavigation();
        if (navigation2 != null) {
            i3 = navigation2.getJumpUrlType();
        } else {
            i3 = 0;
        }
        int i16 = i3;
        IGProNavigationV2Info navigation3 = iGProCategoryChannelInfoList.getNavigation();
        if (navigation3 != null) {
            str4 = navigation3.getJumpUrl();
        }
        if (str4 == null) {
            str3 = "";
        } else {
            str3 = str4;
        }
        return new NavigatorData(1, j3, categoryType, name, str2, i16, str3);
    }

    @NotNull
    public final StateFlow<List<NavigatorData>> U1() {
        return this._navigatorFlow;
    }

    public final void W1(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GuildNavigatorViewModel$refreshData$1(this, from, null), 3, null);
    }

    public void X1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId.setValue(this, I[0], str);
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.a
    public void Z2(@NotNull String oldGuildId) {
        Intrinsics.checkNotNullParameter(oldGuildId, "oldGuildId");
        W1("guildId");
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
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
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
