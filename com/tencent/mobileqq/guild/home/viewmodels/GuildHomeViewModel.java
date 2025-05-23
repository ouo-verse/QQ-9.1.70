package com.tencent.mobileqq.guild.home.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildCheckinViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderColorsViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderEntryViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeTitleViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.net.GuildNetViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.cover.GuildCoverViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ef1.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.v;

/* compiled from: P */
@Deprecated(message = "\u65b0\u7248\u672c\u5c06\u4f1a\u5e9f\u5f03")
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001fB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\bc\u0010dJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000b\u001a\u00020\u0003J\b\u0010\f\u001a\u00020\u0003H\u0016J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\b\u0010\u0013\u001a\u00020\u0003H\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00103\u001a\u00020.8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00109\u001a\u0002048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010?\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010E\u001a\u00020@8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010K\u001a\u00020F8\u0006\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR \u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR \u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010PR&\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0M0L8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bU\u0010P\u001a\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bZ\u0010[R \u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0M0]8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b^\u0010_R \u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0M0]8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\ba\u0010_\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeViewModel;", "Lef1/b;", "Lmp1/b;", "", "e2", "i2", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "k2", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "d2", SemanticAttributes.DbSystemValues.H2, "finishRefresh", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "R1", "onResume", "g2", "f2", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/cover/GuildCoverViewModel;", "D", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/cover/GuildCoverViewModel;", "U1", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/rightlist/cover/GuildCoverViewModel;", "coverViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderColorsViewModel;", "E", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderColorsViewModel;", "b2", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderColorsViewModel;", "headerColorsViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel;", "X1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderBarsViewModel;", "guildHomeHeaderBarsViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeTitleViewModel;", "G", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeTitleViewModel;", "Z1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeTitleViewModel;", "guildHomeTitleViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "H", "Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "K1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "guildSubTabPageViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "I", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "()Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "guildHomePermissionViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildCheckinViewModel;", "J", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildCheckinViewModel;", "W1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildCheckinViewModel;", "guildCheckinViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderEntryViewModel;", "K", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderEntryViewModel;", "getGuildHomeHeaderEntryViewModel", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderEntryViewModel;", "guildHomeHeaderEntryViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/net/GuildNetViewModel;", "L", "Lcom/tencent/mobileqq/guild/home/viewmodels/net/GuildNetViewModel;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/guild/home/viewmodels/net/GuildNetViewModel;", "guildNetViewModel", "Landroidx/lifecycle/MutableLiveData;", "Lef1/a;", "", "M", "Landroidx/lifecycle/MutableLiveData;", "_liveStartRefresh", "N", "_liveFinishRefresh", "", "P", "getLiveSwitchTab", "()Landroidx/lifecycle/MutableLiveData;", "liveSwitchTab", "", "getGuildId", "()Ljava/lang/String;", "guildId", "Landroidx/lifecycle/LiveData;", "T", "()Landroidx/lifecycle/LiveData;", "liveStartRefresh", "c2", "liveFinishRefresh", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeViewModel extends ef1.b implements mp1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private FacadeArgsData facadeArgsData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GuildCoverViewModel coverViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildHomeHeaderColorsViewModel headerColorsViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GuildHomeHeaderBarsViewModel guildHomeHeaderBarsViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GuildHomeTitleViewModel guildHomeTitleViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.viewmodels.e guildSubTabPageViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GuildHomePermissionViewModel guildHomePermissionViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final GuildCheckinViewModel guildCheckinViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final GuildHomeHeaderEntryViewModel guildHomeHeaderEntryViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final GuildNetViewModel guildNetViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Boolean>> _liveStartRefresh;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Boolean>> _liveFinishRefresh;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Long>> liveSwitchTab;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225343a;

        public b(ViewModelStoreOwner viewModelStoreOwner) {
            this.f225343a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildCoverViewModel(GuildFacadeType.FeedsGuildHome9015), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225344a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f225345b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f225344a = viewModelStoreOwner;
            this.f225345b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f225345b.facadeArgsData.f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            TimedValue timedValue = new TimedValue(new GuildHomeHeaderColorsViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225346a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f225347b;

        public d(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f225346a = viewModelStoreOwner;
            this.f225347b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildHomeHeaderBarsViewModel(this.f225347b.facadeArgsData), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225348a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f225349b;

        public e(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f225348a = viewModelStoreOwner;
            this.f225349b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildHomeTitleViewModel(this.f225349b.facadeArgsData), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225350a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f225351b;

        public f(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f225350a = viewModelStoreOwner;
            this.f225351b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f225351b.facadeArgsData.f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.home.viewmodels.e(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225352a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f225353b;

        public g(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f225352a = viewModelStoreOwner;
            this.f225353b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f225353b.facadeArgsData.f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            TimedValue timedValue = new TimedValue(new GuildHomePermissionViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class h implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225354a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f225355b;

        public h(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f225354a = viewModelStoreOwner;
            this.f225355b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildCheckinViewModel(this.f225355b.facadeArgsData), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class i implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225356a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f225357b;

        public i(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f225356a = viewModelStoreOwner;
            this.f225357b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildHomeHeaderEntryViewModel(this.f225357b.facadeArgsData), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class j implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225358a;

        public j(ViewModelStoreOwner viewModelStoreOwner) {
            this.f225358a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildNetViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public GuildHomeViewModel(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new b(this)).get(GuildCoverViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.coverViewModel = (GuildCoverViewModel) viewModel;
        ViewModel viewModel2 = new ViewModelProvider(this, new c(this, this)).get(GuildHomeHeaderColorsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.headerColorsViewModel = (GuildHomeHeaderColorsViewModel) viewModel2;
        ViewModel viewModel3 = new ViewModelProvider(this, new d(this, this)).get(GuildHomeHeaderBarsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildHomeHeaderBarsViewModel = (GuildHomeHeaderBarsViewModel) viewModel3;
        ViewModel viewModel4 = new ViewModelProvider(this, new e(this, this)).get(GuildHomeTitleViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel4, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildHomeTitleViewModel = (GuildHomeTitleViewModel) viewModel4;
        ViewModel viewModel5 = new ViewModelProvider(this, new f(this, this)).get(com.tencent.mobileqq.guild.home.viewmodels.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel5, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildSubTabPageViewModel = (com.tencent.mobileqq.guild.home.viewmodels.e) viewModel5;
        ViewModel viewModel6 = new ViewModelProvider(this, new g(this, this)).get(GuildHomePermissionViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel6, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildHomePermissionViewModel = (GuildHomePermissionViewModel) viewModel6;
        ViewModel viewModel7 = new ViewModelProvider(this, new h(this, this)).get(GuildCheckinViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel7, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildCheckinViewModel = (GuildCheckinViewModel) viewModel7;
        ViewModel viewModel8 = new ViewModelProvider(this, new i(this, this)).get(GuildHomeHeaderEntryViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel8, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildHomeHeaderEntryViewModel = (GuildHomeHeaderEntryViewModel) viewModel8;
        ViewModel viewModel9 = new ViewModelProvider(this, new j(this)).get(GuildNetViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel9, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildNetViewModel = (GuildNetViewModel) viewModel9;
        this._liveStartRefresh = new MutableLiveData<>();
        this._liveFinishRefresh = new MutableLiveData<>();
        this.liveSwitchTab = new MutableLiveData<>();
        e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void e2() {
        this.coverViewModel.S1(getGuildId());
    }

    private final void i2() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchGuildInfoWithSource(getGuildId(), 1, new v() { // from class: com.tencent.mobileqq.guild.home.viewmodels.f
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                GuildHomeViewModel.j2(i3, str, iGProGuildInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(int i3, String str, IGProGuildInfo iGProGuildInfo) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().c("Guild.NewHome.GuildHomeViewModel", 2, "triggerRefresh fetchGuildInfoWithSource end result:" + i3 + " errMsg:" + str);
        }
    }

    @Override // mp1.b
    @NotNull
    /* renamed from: K1, reason: from getter */
    public com.tencent.mobileqq.guild.home.viewmodels.e getGuildSubTabPageViewModel() {
        return this.guildSubTabPageViewModel;
    }

    public final void R1(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LiveData<GuildHomeCoverColors> T1 = this.headerColorsViewModel.T1();
        final Function1<GuildHomeCoverColors, Unit> function1 = new Function1<GuildHomeCoverColors, Unit>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel$bindInternalDataObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeCoverColors guildHomeCoverColors) {
                invoke2(guildHomeCoverColors);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeCoverColors colorsFromCover) {
                GuildHomeHeaderBarsViewModel guildHomeHeaderBarsViewModel = GuildHomeViewModel.this.getGuildHomeHeaderBarsViewModel();
                Intrinsics.checkNotNullExpressionValue(colorsFromCover, "colorsFromCover");
                guildHomeHeaderBarsViewModel.p2(colorsFromCover);
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.viewmodels.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeViewModel.S1(Function1.this, obj);
            }
        });
        LiveData<Boolean> R1 = this.guildHomeHeaderEntryViewModel.R1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel$bindInternalDataObserve$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isGroupChatShow) {
                Logger logger = Logger.f235387a;
                if (QLog.isDebugVersion()) {
                    logger.d().d("Guild.NewHome.GuildHomeViewModel", 1, "guildHomeHeaderEntryViewModel isGroupChatShow:" + isGroupChatShow);
                }
                GuildHomeHeaderBarsViewModel guildHomeHeaderBarsViewModel = GuildHomeViewModel.this.getGuildHomeHeaderBarsViewModel();
                Intrinsics.checkNotNullExpressionValue(isGroupChatShow, "isGroupChatShow");
                guildHomeHeaderBarsViewModel.m2(isGroupChatShow.booleanValue());
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.viewmodels.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeViewModel.T1(Function1.this, obj);
            }
        });
    }

    @Override // mp1.b
    @NotNull
    public LiveData<ef1.a<Boolean>> T() {
        return this._liveStartRefresh;
    }

    @NotNull
    /* renamed from: U1, reason: from getter */
    public final GuildCoverViewModel getCoverViewModel() {
        return this.coverViewModel;
    }

    @NotNull
    /* renamed from: W1, reason: from getter */
    public final GuildCheckinViewModel getGuildCheckinViewModel() {
        return this.guildCheckinViewModel;
    }

    @NotNull
    /* renamed from: X1, reason: from getter */
    public final GuildHomeHeaderBarsViewModel getGuildHomeHeaderBarsViewModel() {
        return this.guildHomeHeaderBarsViewModel;
    }

    @NotNull
    /* renamed from: Z1, reason: from getter */
    public final GuildHomeTitleViewModel getGuildHomeTitleViewModel() {
        return this.guildHomeTitleViewModel;
    }

    @Override // mp1.b
    @NotNull
    /* renamed from: a1, reason: from getter */
    public GuildHomePermissionViewModel getGuildHomePermissionViewModel() {
        return this.guildHomePermissionViewModel;
    }

    @NotNull
    /* renamed from: a2, reason: from getter */
    public final GuildNetViewModel getGuildNetViewModel() {
        return this.guildNetViewModel;
    }

    @NotNull
    /* renamed from: b2, reason: from getter */
    public final GuildHomeHeaderColorsViewModel getHeaderColorsViewModel() {
        return this.headerColorsViewModel;
    }

    @NotNull
    public LiveData<ef1.a<Boolean>> c2() {
        return this._liveFinishRefresh;
    }

    @Nullable
    public final IGProGuildInfo d2() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        return ((IGPSService) S0).getGuildInfo(getGuildId());
    }

    public final void f2() {
        this.guildHomeHeaderBarsViewModel.j2();
    }

    @Override // mp1.b
    public void finishRefresh() {
        this._liveFinishRefresh.setValue(new ef1.a<>(Boolean.TRUE));
    }

    public final void g2() {
        this.guildHomeHeaderBarsViewModel.k2();
    }

    @NotNull
    public String getGuildId() {
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        return str;
    }

    public final void h2() {
        TraceUtils.n("Guild.HomePage.Fragment.StartRefresh");
        this._liveStartRefresh.setValue(new ef1.a<>(Boolean.TRUE));
        i2();
    }

    public final void k2(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        this.guildHomeHeaderBarsViewModel.n2(facadeArgsData);
        GuildHomeHeaderColorsViewModel guildHomeHeaderColorsViewModel = this.headerColorsViewModel;
        String str = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        guildHomeHeaderColorsViewModel.X1(str);
        this.guildHomeTitleViewModel.k2(facadeArgsData);
        com.tencent.mobileqq.guild.home.viewmodels.e guildSubTabPageViewModel = getGuildSubTabPageViewModel();
        String str2 = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
        guildSubTabPageViewModel.T1(str2);
        GuildHomePermissionViewModel guildHomePermissionViewModel = getGuildHomePermissionViewModel();
        String str3 = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str3, "facadeArgsData.guildId");
        guildHomePermissionViewModel.g2(str3);
        this.guildCheckinViewModel.q2(facadeArgsData);
        this.guildHomeHeaderEntryViewModel.T1(facadeArgsData);
        e2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public final void onResume() {
        this.guildHomeHeaderBarsViewModel.onResume();
        this.guildNetViewModel.onResume();
    }
}
