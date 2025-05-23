package com.tencent.mobileqq.guild.setting.guildinfo;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildInfoAndMemberListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cj;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ef1.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ap;
import wh2.dc;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 G2\u00020\u0001:\u0002HIB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0014R\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR \u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0!0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001fR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0019\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d098F\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u001d\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!098F\u00a2\u0006\u0006\u001a\u0004\b=\u0010;R\u001d\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0!098F\u00a2\u0006\u0006\u001a\u0004\b?\u0010;R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\t098F\u00a2\u0006\u0006\u001a\u0004\bA\u0010;R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u0007098F\u00a2\u0006\u0006\u001a\u0004\bC\u0010;\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoDialogViewModel;", "Lef1/b;", "", "i2", "f2", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "U1", "", WidgetCacheConstellationData.NUM, "", "isVisitor", "W1", "", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "D", "Lkotlin/Lazy;", "Z1", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "E", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Le12/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", UserInfo.SEX_FEMALE, "Le12/a;", "_guildInfo", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "G", "_memberList", "H", "_memberAvatarMetas", "I", "_isExitGuild", "J", "_totalMemberCnt", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoDialogViewModel$b;", "K", "Landroidx/lifecycle/MutableLiveData;", "d2", "()Landroidx/lifecycle/MutableLiveData;", "relativeGroupShowLiveData", "L", "Z", SemanticAttributes.DbSystemValues.H2, "()Z", "k2", "(Z)V", "isMember", "Landroidx/lifecycle/LiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/LiveData;", "guildInfo", "c2", "memberList", "b2", "memberAvatarMetas", "g2", "isExitGuild", "e2", "totalMemberCnt", "<init>", "(Ljava/lang/String;)V", "M", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildInfoDialogViewModel extends ef1.b {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final e12.a<IGProGuildInfo> _guildInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e12.a<List<IGProUserInfo>> _memberList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final e12.a<List<String>> _memberAvatarMetas;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> _isExitGuild;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Integer> _totalMemberCnt;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<RelativeGroupShowItem> relativeGroupShowLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isMember;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel$1", f = "GuildInfoDialogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildInfoDialogViewModel.this.i2();
                IGProGuildInfo L = ch.L(GuildInfoDialogViewModel.this.guildId);
                if (L == null) {
                    return Unit.INSTANCE;
                }
                GuildInfoDialogViewModel.this._guildInfo.setValue(L);
                GuildInfoDialogViewModel.this.k2(L.isMember());
                GuildInfoDialogViewModel.this.W1(100, true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoDialogViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoDialogViewModel;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7893a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f233565a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f233566b;

            public C7893a(ViewModelStoreOwner viewModelStoreOwner, String str) {
                this.f233565a = viewModelStoreOwner;
                this.f233566b = str;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new GuildInfoDialogViewModel(this.f233566b), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildInfoDialogViewModel a(@NotNull ViewModelStoreOwner owner, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7893a(owner, guildId)).get(GuildInfoDialogViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (GuildInfoDialogViewModel) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoDialogViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", ViewStickEventHelper.IS_SHOW, "", "", "Ljava/util/List;", "()Ljava/util/List;", "groupCodes", "<init>", "(ZLjava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class RelativeGroupShowItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShow;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Long> groupCodes;

        public RelativeGroupShowItem(boolean z16, @NotNull List<Long> groupCodes) {
            Intrinsics.checkNotNullParameter(groupCodes, "groupCodes");
            this.isShow = z16;
            this.groupCodes = groupCodes;
        }

        @NotNull
        public final List<Long> a() {
            return this.groupCodes;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelativeGroupShowItem)) {
                return false;
            }
            RelativeGroupShowItem relativeGroupShowItem = (RelativeGroupShowItem) other;
            if (this.isShow == relativeGroupShowItem.isShow && Intrinsics.areEqual(this.groupCodes, relativeGroupShowItem.groupCodes)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isShow;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.groupCodes.hashCode();
        }

        @NotNull
        public String toString() {
            return "RelativeGroupShowItem(isShow=" + this.isShow + ", groupCodes=" + this.groupCodes + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014J2\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/guild/setting/guildinfo/GuildInfoDialogViewModel$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "mGuildId", "", "b", "onGuildInfoUpdated", "guildId", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "", AppConstants.Key.COLUMN_IS_VALID, "isBanned", "isFrozen", "", "guildBannedTimeLimit", "onBannedStatusChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        private final void b(String mGuildId) {
            if (Intrinsics.areEqual(mGuildId, GuildInfoDialogViewModel.this.guildId)) {
                GuildInfoDialogViewModel.this._guildInfo.setValue(ch.L(mGuildId));
                GuildInfoDialogViewModel.this._isExitGuild.setValue(Boolean.TRUE);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onBannedStatusChanged(@Nullable String guildId, boolean isValid, boolean isBanned, boolean isFrozen, long guildBannedTimeLimit) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildInfoDialogViewModel", "onBannedStatusChanged: isBanned " + isBanned);
            }
            if (isBanned) {
                GuildInfoDialogViewModel.this._guildInfo.setValue(ch.L(guildId));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String mGuildId) {
            IGProGuildInfo L;
            if (!Intrinsics.areEqual(mGuildId, GuildInfoDialogViewModel.this.guildId) || (L = ch.L(mGuildId)) == null) {
                return;
            }
            GuildInfoDialogViewModel.this._guildInfo.setValue(L);
            if (GuildInfoDialogViewModel.this.getIsMember() != L.isMember()) {
                GuildInfoDialogViewModel.this.W1(100, true);
                GuildInfoDialogViewModel.this.k2(L.isMember());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            b(guildId);
        }
    }

    public GuildInfoDialogViewModel(@NotNull String guildId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver U1;
                U1 = GuildInfoDialogViewModel.this.U1();
                return U1;
            }
        });
        this.gProObserver = lazy;
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        this._guildInfo = new e12.a<>();
        this._memberList = new e12.a<>();
        this._memberAvatarMetas = new e12.a<>();
        this._isExitGuild = new e12.a<>();
        this._totalMemberCnt = new e12.a<>();
        this.relativeGroupShowLiveData = new MutableLiveData<>();
        this.gProService.addObserver(Z1());
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildInfoDialogViewModel init", null, null, null, new AnonymousClass1(null), 14, null);
        f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver U1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(int i3, GuildInfoDialogViewModel this$0, int i16, String str, IGProGuildInfoAndMemberListRsp iGProGuildInfoAndMemberListRsp) {
        List<IGProUserInfo> list;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 != 0) {
            QLog.e("GuildInfoDialogViewModel", 1, "fetchGuildInfoAndMemberList, result: " + i16 + ",errMsg: " + str);
            return;
        }
        if (iGProGuildInfoAndMemberListRsp.getMemberList().size() > i3) {
            list = iGProGuildInfoAndMemberListRsp.getMemberList().subList(0, i3);
            Intrinsics.checkNotNullExpressionValue(list, "{\n                    rs\u20260, num)\n                }");
        } else {
            ArrayList<IGProUserInfo> memberList = iGProGuildInfoAndMemberListRsp.getMemberList();
            Intrinsics.checkNotNullExpressionValue(memberList, "rsp.memberList");
            list = CollectionsKt___CollectionsKt.toList(memberList);
        }
        this$0._memberList.setValue(list);
        this$0._memberAvatarMetas.setValue(iGProGuildInfoAndMemberListRsp.getAvatarMetas());
        this$0._totalMemberCnt.setValue(Integer.valueOf(iGProGuildInfoAndMemberListRsp.getGuildInfo().getUserNum()));
    }

    private final GPServiceObserver Z1() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    private final void f2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new GuildInfoDialogViewModel$initRelativeGroupInfo$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2() {
        ((IGPSService) ch.R0(IGPSService.class)).loadPartRoleMemberList(Long.parseLong(this.guildId), new dc() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.b
            @Override // wh2.dc
            public final void onGetUserInfo(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                GuildInfoDialogViewModel.j2(GuildInfoDialogViewModel.this, i3, str, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(GuildInfoDialogViewModel this$0, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (arrayList != null && arrayList.size() > 0) {
            this$0._memberList.setValue(arrayList);
        }
    }

    public final void W1(final int num, boolean isVisitor) {
        cj cjVar = new cj();
        cjVar.g(Long.parseLong(this.guildId));
        cjVar.f(num);
        cjVar.h(isVisitor);
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoAndMemberList(cjVar, new ap() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.a
            @Override // wh2.ap
            public final void a(int i3, String str, IGProGuildInfoAndMemberListRsp iGProGuildInfoAndMemberListRsp) {
                GuildInfoDialogViewModel.X1(num, this, i3, str, iGProGuildInfoAndMemberListRsp);
            }
        });
    }

    @NotNull
    public final LiveData<IGProGuildInfo> a2() {
        return this._guildInfo;
    }

    @NotNull
    public final LiveData<List<String>> b2() {
        return this._memberAvatarMetas;
    }

    @NotNull
    public final LiveData<List<IGProUserInfo>> c2() {
        return this._memberList;
    }

    @NotNull
    public final MutableLiveData<RelativeGroupShowItem> d2() {
        return this.relativeGroupShowLiveData;
    }

    @NotNull
    public final LiveData<Integer> e2() {
        return this._totalMemberCnt;
    }

    @NotNull
    public final LiveData<Boolean> g2() {
        return this._isExitGuild;
    }

    /* renamed from: h2, reason: from getter */
    public final boolean getIsMember() {
        return this.isMember;
    }

    public final void k2(boolean z16) {
        this.isMember = z16;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.gProService.deleteObserver(Z1());
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(Z1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(Z1());
    }
}
