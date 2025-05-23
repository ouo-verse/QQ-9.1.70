package com.tencent.mobileqq.guild.setting.group;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.util.DataCompatTransformKt;
import com.tencent.mobileqq.guild.config.z;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindableGroups;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSortAndWriteBindGroupsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.en;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import ef1.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ao;
import wh2.bp;
import wh2.cc;
import wh2.ce;
import wh2.eg;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001\u0016\u0018\u0000 ]2\u00020\u0001:\u0001^B\u001f\u0012\u0006\u0010.\u001a\u00020\u000b\u0012\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002\u00a2\u0006\u0004\b[\u0010\\J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0013\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0007J?\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J?\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0019J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0003J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0003J\u0016\u0010)\u001a\u00020\u00192\u0006\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020 J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010+\u001a\u00020\u0019R\u0014\u0010.\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00101\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00100R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000208058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00100R\"\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010?R\u0016\u0010E\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010@R \u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00120K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00020O8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00120O8F\u00a2\u0006\u0006\u001a\u0004\bS\u0010QR\u0011\u0010W\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u0011\u0010Z\u001a\u00020B8F\u00a2\u0006\u0006\u001a\u0004\bX\u0010Y\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel;", "Lef1/b;", "", "Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "m2", "Lcom/tencent/mobileqq/guild/setting/group/g;", "g2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/setting/group/h;", "i2", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "groupCodes", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", SemanticAttributes.DbSystemValues.H2, "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "troopUin", "", "y2", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l2", "com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel$createTroopModifyObserver$1", "f2", "()Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel$createTroopModifyObserver$1;", "", "onCleared", "j2", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "o2", "t2", "w2", "Lcom/tencent/mobileqq/guild/setting/group/p;", "groupData", "z2", "e2", "type", "v2", "u2", "data", "targetData", ICustomDataEditor.STRING_PARAM_2, "p2", "x2", BdhLogUtil.LogTag.Tag_Conn, "J", "bindGuildId", "D", "Ljava/util/List;", "groupCodeList", "E", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel$createTroopModifyObserver$1;", "mTroopModifyObserver", "", UserInfo.SEX_FEMALE, "boundGroupList", "Lcom/tencent/mobileqq/guild/setting/group/OneBindableGroupSettingData;", "G", "unboundGroupList", "", "H", "Ljava/util/Map;", "bindableGroupToType", "I", "Z", "isLoading", "", "_bindGroupLimit", "K", "_isSorting", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "L", "Landroidx/lifecycle/MutableLiveData;", "_pageDataLiveData", "Lcom/tencent/mobileqq/guild/util/cn;", "M", "Lcom/tencent/mobileqq/guild/util/cn;", "_isSaveSuccess", "Landroidx/lifecycle/LiveData;", ICustomDataEditor.NUMBER_PARAM_2, "()Landroidx/lifecycle/LiveData;", "pageDataLiveData", "q2", "isSaveSuccess", "r2", "()Z", "isSorting", "k2", "()I", "bindGroupLimit", "<init>", "(JLjava/util/List;)V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBindGroupSettingViewModel extends ef1.b {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final long bindGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final List<Long> groupCodeList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildBindGroupSettingViewModel$createTroopModifyObserver$1 mTroopModifyObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<IGProBindingGroup> boundGroupList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<OneBindableGroupSettingData> unboundGroupList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Map<Long, GroupType> bindableGroupToType;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: J, reason: from kotlin metadata */
    private int _bindGroupLimit;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean _isSorting;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<a>> _pageDataLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _isSaveSuccess;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "guildId", "", "groupCodeList", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7890a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f233400a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f233401b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ List f233402c;

            public C7890a(ViewModelStoreOwner viewModelStoreOwner, long j3, List list) {
                this.f233400a = viewModelStoreOwner;
                this.f233401b = j3;
                this.f233402c = list;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new GuildBindGroupSettingViewModel(this.f233401b, this.f233402c), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
        public final GuildBindGroupSettingViewModel a(@NotNull ViewModelStoreOwner owner, long guildId, @Nullable List<Long> groupCodeList) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7890a(owner, guildId, groupCodeList)).get(GuildBindGroupSettingViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (GuildBindGroupSettingViewModel) viewModel;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errorMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindableGroups;", "createdGroups", "managedGroups", "joinedGroups", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindableGroups;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindableGroups;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindableGroups;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements cc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<BindableGroupsResult> f233403a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super BindableGroupsResult> cancellableContinuation) {
            this.f233403a = cancellableContinuation;
        }

        @Override // wh2.cc
        public final void a(int i3, String errorMsg, IGProBindableGroups createdGroups, IGProBindableGroups managedGroups, IGProBindableGroups joinedGroups) {
            Map mapOf;
            if (i3 != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "fetchBindableGroups failed: " + i3 + "-" + errorMsg;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.group.GuildBindGroupSettingViewModel", 1, (String) it.next(), null);
                }
                CancellableContinuation<BindableGroupsResult> cancellableContinuation = this.f233403a;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new BindableGroupsResult(i3, errorMsg, null, 4, null)));
                return;
            }
            GroupType groupType = GroupType.CreatedGroup;
            Intrinsics.checkNotNullExpressionValue(createdGroups, "createdGroups");
            GroupType groupType2 = GroupType.ManagedGroup;
            Intrinsics.checkNotNullExpressionValue(managedGroups, "managedGroups");
            GroupType groupType3 = GroupType.JoinedGroup;
            Intrinsics.checkNotNullExpressionValue(joinedGroups, "joinedGroups");
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(groupType, x.a(createdGroups)), TuplesKt.to(groupType2, x.a(managedGroups)), TuplesKt.to(groupType3, x.a(joinedGroups)));
            Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
            BindableGroupsResult bindableGroupsResult = new BindableGroupsResult(i3, errorMsg, mapOf);
            Logger.f235387a.d().i("Guild.group.GuildBindGroupSettingViewModel", 1, "fetchBindableGroups: " + bindableGroupsResult);
            this.f233403a.resumeWith(Result.m476constructorimpl(bindableGroupsResult));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel$c", "Lwh2/ao;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "Lkotlin/collections/ArrayList;", "bindingGroups", "", "onFetchGuildBoundGroupsWithGroupCodes", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ao {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<ArrayList<IGProBindingGroup>> f233404a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<Long> f233405b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super ArrayList<IGProBindingGroup>> continuation, ArrayList<Long> arrayList) {
            this.f233404a = continuation;
            this.f233405b = arrayList;
        }

        @Override // wh2.ao
        public void onFetchGuildBoundGroupsWithGroupCodes(int result, @Nullable String errMsg, @Nullable ArrayList<IGProBindingGroup> bindingGroups) {
            boolean z16;
            Object first;
            if (result == 0) {
                if (bindingGroups != null && !bindingGroups.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    this.f233404a.resumeWith(Result.m476constructorimpl(bindingGroups));
                    Logger logger = Logger.f235387a;
                    ArrayList<Long> arrayList = this.f233405b;
                    if (QLog.isColorLevel()) {
                        Logger.a d16 = logger.d();
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) bindingGroups);
                        d16.d("Guild.group.GuildBindGroupSettingViewModel", 2, "fetchBoundGroups success " + arrayList + ", " + first);
                        return;
                    }
                    return;
                }
            }
            this.f233404a.resumeWith(Result.m476constructorimpl(null));
            Logger logger2 = Logger.f235387a;
            ArrayList<Long> arrayList2 = this.f233405b;
            Logger.b bVar = new Logger.b();
            String str = "fetchBoundGroups error " + arrayList2 + ", result:" + result + " errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.group.GuildBindGroupSettingViewModel", 1, (String) it.next(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errorMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMemberGetBoundGroupRsp;", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMemberGetBoundGroupRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements ce {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<h> f233407a;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super h> cancellableContinuation) {
            this.f233407a = cancellableContinuation;
        }

        @Override // wh2.ce
        public final void a(int i3, String errorMsg, IGProMemberGetBoundGroupRsp iGProMemberGetBoundGroupRsp) {
            int collectionSizeOrDefault;
            Set set;
            if (i3 != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "fetchBoundGroupsFirstPage failed: " + i3 + "-" + errorMsg;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.group.GuildBindGroupSettingViewModel", 1, (String) it.next(), null);
                }
                CancellableContinuation<h> cancellableContinuation = this.f233407a;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new h(i3, errorMsg, 100, null, null, 24, null)));
                return;
            }
            ArrayList<IGProBindingGroup> bindingGroupList = iGProMemberGetBoundGroupRsp.getBindingGroupList();
            Intrinsics.checkNotNullExpressionValue(bindingGroupList, "rsp.bindingGroupList");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(bindingGroupList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = bindingGroupList.iterator();
            while (it5.hasNext()) {
                arrayList.add(Long.valueOf(((IGProBindingGroup) it5.next()).getGroupCode()));
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            ArrayList<Long> allBindGroupCodeList = iGProMemberGetBoundGroupRsp.getAllBindGroupCodeList();
            Intrinsics.checkNotNullExpressionValue(allBindGroupCodeList, "rsp.allBindGroupCodeList");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : allBindGroupCodeList) {
                if (!set.contains((Long) obj)) {
                    arrayList2.add(obj);
                }
            }
            Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
            int bindingGroupLimit = iGProMemberGetBoundGroupRsp.getBindingGroupLimit();
            ArrayList<IGProBindingGroup> bindingGroupList2 = iGProMemberGetBoundGroupRsp.getBindingGroupList();
            Intrinsics.checkNotNullExpressionValue(bindingGroupList2, "rsp.bindingGroupList");
            h hVar = new h(i3, errorMsg, bindingGroupLimit, bindingGroupList2, arrayList2);
            Logger.f235387a.d().i("Guild.group.GuildBindGroupSettingViewModel", 1, "fetchBoundGroupsFirstPage: " + hVar);
            this.f233407a.resumeWith(Result.m476constructorimpl(hVar));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel$e", "Lwh2/bp;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindingGroup;", "Lkotlin/collections/ArrayList;", "bindingGroups", "", "onGetBindingGroupInfos", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements bp {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<ArrayList<IGProBindingGroup>> f233408a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<Long> f233409b;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super ArrayList<IGProBindingGroup>> continuation, ArrayList<Long> arrayList) {
            this.f233408a = continuation;
            this.f233409b = arrayList;
        }

        @Override // wh2.bp
        public void onGetBindingGroupInfos(int result, @Nullable String errMsg, @Nullable ArrayList<IGProBindingGroup> bindingGroups) {
            boolean z16;
            Object first;
            if (result == 0) {
                if (bindingGroups != null && !bindingGroups.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    this.f233408a.resumeWith(Result.m476constructorimpl(bindingGroups));
                    Logger logger = Logger.f235387a;
                    ArrayList<Long> arrayList = this.f233409b;
                    if (QLog.isColorLevel()) {
                        Logger.a d16 = logger.d();
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) bindingGroups);
                        d16.d("Guild.group.GuildBindGroupSettingViewModel", 2, "getBindingGroupInfos success " + arrayList + ", " + first);
                        return;
                    }
                    return;
                }
            }
            this.f233408a.resumeWith(Result.m476constructorimpl(null));
            Logger logger2 = Logger.f235387a;
            ArrayList<Long> arrayList2 = this.f233409b;
            Logger.b bVar = new Logger.b();
            String str = "getBindingGroupInfos error " + arrayList2 + ", result:" + result + " errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.group.GuildBindGroupSettingViewModel", 1, (String) it.next(), null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingViewModel$f", "Lwh2/eg;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSortAndWriteBindGroupsRsp;", "rsp", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements eg {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<Long> f233411b;

        f(ArrayList<Long> arrayList) {
            this.f233411b = arrayList;
        }

        @Override // wh2.eg
        public void a(int result, @Nullable String errMsg, @Nullable IGProSortAndWriteBindGroupsRsp rsp) {
            ArrayList<Long> arrayList;
            Logger.a d16 = Logger.f235387a.d();
            if (rsp != null) {
                arrayList = rsp.getGroupCodeList();
            } else {
                arrayList = null;
            }
            d16.i("Guild.group.GuildBindGroupSettingViewModel", 1, "saveBindGroupSetting result:" + result + " errMsg:" + errMsg + ", rsp:" + arrayList);
            if (result == 0 && rsp != null) {
                if (DataCompatTransformKt.c(this.f233411b, rsp.getGroupCodeList())) {
                    QQToastUtil.showQQToast(1, "\u90e8\u5206\u7fa4\u804a\u5c55\u793a\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                }
                GuildBindGroupSettingViewModel.this._isSaveSuccess.setValue(Boolean.TRUE);
            } else {
                SecurityTipHelperKt.F(ch.i(), result, errMsg, null, null, null, 56, null);
                GuildBindGroupSettingViewModel.this._isSaveSuccess.setValue(Boolean.FALSE);
            }
        }
    }

    public GuildBindGroupSettingViewModel(long j3, @Nullable List<Long> list) {
        this.bindGuildId = j3;
        this.groupCodeList = list;
        GuildBindGroupSettingViewModel$createTroopModifyObserver$1 f26 = f2();
        this.mTroopModifyObserver = f26;
        this.boundGroupList = new ArrayList();
        this.unboundGroupList = new ArrayList();
        this.bindableGroupToType = new LinkedHashMap();
        this._bindGroupLimit = 100;
        this._pageDataLiveData = new MutableLiveData<>();
        this._isSaveSuccess = new cn<>();
        ch.l().addObserver(f26);
        o2();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$createTroopModifyObserver$1] */
    private final GuildBindGroupSettingViewModel$createTroopModifyObserver$1 f2() {
        return new com.tencent.mobileqq.troop.api.observer.e() { // from class: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$createTroopModifyObserver$1
            @Override // com.tencent.mobileqq.troop.api.observer.e
            protected void onGetTroopInfoResult(boolean isSuc, @Nullable String troopuin) {
                Long l3;
                if (isSuc) {
                    if (troopuin != null) {
                        l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopuin);
                    } else {
                        l3 = null;
                    }
                    if (l3 != null) {
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(GuildBindGroupSettingViewModel.this), null, null, new GuildBindGroupSettingViewModel$createTroopModifyObserver$1$onGetTroopInfoResult$1(GuildBindGroupSettingViewModel.this, troopuin, null), 3, null);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g2(Continuation<? super BindableGroupsResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getGuildBindableGroups(new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h2(ArrayList<Long> arrayList, Continuation<? super ArrayList<IGProBindingGroup>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        IRuntimeService S0 = ch.S0(IGPSService.class, "Guild.group.GuildBindGroupSettingViewModel");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchGuildBoundGroupsWithGroupCodes(String.valueOf(this.bindGuildId), arrayList, new c(safeContinuation, arrayList));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i2(Continuation<? super h> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getGuildBoundGroupsFirstPage(String.valueOf(this.bindGuildId), 50, new d(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l2(ArrayList<Long> arrayList, Continuation<? super ArrayList<IGProBindingGroup>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        IRuntimeService S0 = ch.S0(IGPSService.class, "Guild.group.GuildBindGroupSettingViewModel");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).getBindingGroupInfos(arrayList, new e(safeContinuation, arrayList));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<GroupType> m2() {
        List<GroupType> listOf;
        List<GroupType> listOf2;
        if (!z.f216289a.c() || w2()) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(GroupType.CreatedGroup);
            return listOf;
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new GroupType[]{GroupType.CreatedGroup, GroupType.ManagedGroup, GroupType.JoinedGroup});
        return listOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object y2(long j3, Continuation<? super Boolean> continuation) {
        GuildBindGroupSettingViewModel$updateGroupBindInfo$1 guildBindGroupSettingViewModel$updateGroupBindInfo$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        boolean z17;
        ArrayList<Long> arrayListOf;
        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel;
        boolean z18;
        ArrayList arrayList;
        boolean z19;
        Object first;
        Object first2;
        boolean z26;
        Object firstOrNull;
        if (continuation instanceof GuildBindGroupSettingViewModel$updateGroupBindInfo$1) {
            guildBindGroupSettingViewModel$updateGroupBindInfo$1 = (GuildBindGroupSettingViewModel$updateGroupBindInfo$1) continuation;
            int i16 = guildBindGroupSettingViewModel$updateGroupBindInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildBindGroupSettingViewModel$updateGroupBindInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildBindGroupSettingViewModel$updateGroupBindInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildBindGroupSettingViewModel$updateGroupBindInfo$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        j3 = guildBindGroupSettingViewModel$updateGroupBindInfo$1.J$0;
                        guildBindGroupSettingViewModel = (GuildBindGroupSettingViewModel) guildBindGroupSettingViewModel$updateGroupBindInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<IGProBindingGroup> list = this.boundGroupList;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (((IGProBindingGroup) it.next()).getGroupCode() == j3) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                z17 = true;
                                break;
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                        List<OneBindableGroupSettingData> list2 = this.unboundGroupList;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator<T> it5 = list2.iterator();
                            while (it5.hasNext()) {
                                if (((OneBindableGroupSettingData) it5.next()).a(j3)) {
                                    z18 = true;
                                    break;
                                }
                            }
                        }
                        z18 = false;
                        if (!z18) {
                            return Boxing.boxBoolean(false);
                        }
                    }
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boxing.boxLong(j3));
                    guildBindGroupSettingViewModel$updateGroupBindInfo$1.L$0 = this;
                    guildBindGroupSettingViewModel$updateGroupBindInfo$1.J$0 = j3;
                    guildBindGroupSettingViewModel$updateGroupBindInfo$1.label = 1;
                    obj = l2(arrayListOf, guildBindGroupSettingViewModel$updateGroupBindInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildBindGroupSettingViewModel = this;
                }
                arrayList = (ArrayList) obj;
                if (arrayList != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                    IGProBindingGroup iGProBindingGroup = (IGProBindingGroup) firstOrNull;
                    if (iGProBindingGroup != null && iGProBindingGroup.getGroupCode() == j3) {
                        z19 = true;
                        if (!z19) {
                            return Boxing.boxBoolean(false);
                        }
                        Iterator<IGProBindingGroup> it6 = guildBindGroupSettingViewModel.boundGroupList.iterator();
                        int i17 = 0;
                        while (true) {
                            if (it6.hasNext()) {
                                if (it6.next().getGroupCode() == j3) {
                                    z26 = true;
                                } else {
                                    z26 = false;
                                }
                                if (z26) {
                                    break;
                                }
                                i17++;
                            } else {
                                i17 = -1;
                                break;
                            }
                        }
                        if (i17 >= 0) {
                            List<IGProBindingGroup> list3 = guildBindGroupSettingViewModel.boundGroupList;
                            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                            list3.set(i17, first2);
                            return Boxing.boxBoolean(true);
                        }
                        for (OneBindableGroupSettingData oneBindableGroupSettingData : guildBindGroupSettingViewModel.unboundGroupList) {
                            if (oneBindableGroupSettingData.a(j3)) {
                                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                                return Boxing.boxBoolean(oneBindableGroupSettingData.k((IGProBindingGroup) first));
                            }
                        }
                        return Boxing.boxBoolean(false);
                    }
                }
                z19 = false;
                if (!z19) {
                }
            }
        }
        guildBindGroupSettingViewModel$updateGroupBindInfo$1 = new GuildBindGroupSettingViewModel$updateGroupBindInfo$1(this, continuation);
        Object obj2 = guildBindGroupSettingViewModel$updateGroupBindInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildBindGroupSettingViewModel$updateGroupBindInfo$1.label;
        if (i3 == 0) {
        }
        arrayList = (ArrayList) obj2;
        if (arrayList != null) {
        }
        z19 = false;
        if (!z19) {
        }
    }

    public final void e2() {
        this._isSorting = !this._isSorting;
        t2();
    }

    @NotNull
    public final List<Long> j2() {
        int collectionSizeOrDefault;
        List<IGProBindingGroup> list = this.boundGroupList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((IGProBindingGroup) it.next()).getGroupCode()));
        }
        return arrayList;
    }

    /* renamed from: k2, reason: from getter */
    public final int get_bindGroupLimit() {
        return this._bindGroupLimit;
    }

    @NotNull
    public final LiveData<List<a>> n2() {
        return this._pageDataLiveData;
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b o2() {
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.group.GuildBindGroupSettingViewModel initData", null, null, Boolean.TRUE, new GuildBindGroupSettingViewModel$initData$1(this, null), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        ch.l().removeObserver(this.mTroopModifyObserver);
    }

    public final void p2(long troopUin) {
        Logger.f235387a.d().i("Guild.group.GuildBindGroupSettingViewModel", 1, "insertCreateGroup " + troopUin);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GuildBindGroupSettingViewModel$insertCreateGroup$2(this, troopUin, null), 3, null);
    }

    @NotNull
    public final LiveData<Boolean> q2() {
        return this._isSaveSuccess;
    }

    /* renamed from: r2, reason: from getter */
    public final boolean get_isSorting() {
        return this._isSorting;
    }

    public final void s2(@NotNull GroupChatData data, @NotNull GroupChatData targetData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(targetData, "targetData");
        Collections.swap(this.boundGroupList, this.boundGroupList.indexOf(data.getGroupData()), this.boundGroupList.indexOf(targetData.getGroupData()));
        t2();
    }

    public final void t2() {
        boolean z16;
        int lastIndex;
        ItemPositionType itemPositionType;
        boolean z17 = true;
        if (this.isLoading) {
            Logger.f235387a.d().w("Guild.group.GuildBindGroupSettingViewModel", 1, "notifyDataChanged but return, current is loading");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.boundGroupList.size() > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        arrayList.add(new BindTitleData(z16, this._isSorting, 0, 4, null));
        if (this.boundGroupList.isEmpty()) {
            arrayList.add(new PlaceHolderData(4));
        } else {
            int i3 = 0;
            for (Object obj : this.boundGroupList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                IGProBindingGroup iGProBindingGroup = (IGProBindingGroup) obj;
                if (this.boundGroupList.size() == 1) {
                    itemPositionType = ItemPositionType.Single;
                } else if (i3 != 0) {
                    lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.boundGroupList);
                    if (i3 == lastIndex) {
                        itemPositionType = ItemPositionType.Bottom;
                    } else {
                        itemPositionType = ItemPositionType.Middle;
                    }
                } else {
                    itemPositionType = ItemPositionType.Top;
                }
                arrayList.add(new GroupChatData(iGProBindingGroup.getGroupCode(), true, iGProBindingGroup, this._isSorting, false, 0, itemPositionType, 48, null));
                i3 = i16;
            }
        }
        if (this._isSorting) {
            this._pageDataLiveData.setValue(arrayList);
            return;
        }
        arrayList.add(new PlaceHolderData(2));
        if (this.boundGroupList.size() < this._bindGroupLimit) {
            z17 = false;
        }
        int i17 = 0;
        for (Object obj2 : this.unboundGroupList) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            OneBindableGroupSettingData oneBindableGroupSettingData = (OneBindableGroupSettingData) obj2;
            if (i17 > 0) {
                arrayList.add(new BindGroupSpaceData(16.0f, 0, 2, null));
            }
            arrayList.addAll(oneBindableGroupSettingData.f(z17));
            i17 = i18;
        }
        this._pageDataLiveData.setValue(arrayList);
    }

    public final void u2(@NotNull GroupType type) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(type, "type");
        Iterator<T> it = this.unboundGroupList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((OneBindableGroupSettingData) obj).getCom.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.KEY_GROUP_TYPE java.lang.String() == type) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        OneBindableGroupSettingData oneBindableGroupSettingData = (OneBindableGroupSettingData) obj;
        if (oneBindableGroupSettingData != null) {
            oneBindableGroupSettingData.j(true);
            t2();
        }
    }

    public final void v2(@NotNull GroupType type) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(type, "type");
        Iterator<T> it = this.unboundGroupList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((OneBindableGroupSettingData) obj).getCom.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.KEY_GROUP_TYPE java.lang.String() == type) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        OneBindableGroupSettingData oneBindableGroupSettingData = (OneBindableGroupSettingData) obj;
        if (oneBindableGroupSettingData != null) {
            oneBindableGroupSettingData.i(!oneBindableGroupSettingData.getIsCollapse());
            oneBindableGroupSettingData.j(false);
            t2();
        }
    }

    public final boolean w2() {
        if (this.bindGuildId == 0) {
            return true;
        }
        return false;
    }

    public final void x2() {
        ArrayList<Long> arrayList = new ArrayList<>(j2());
        en enVar = new en();
        enVar.d(this.bindGuildId);
        enVar.c(arrayList);
        Logger.f235387a.d().i("Guild.group.GuildBindGroupSettingViewModel", 1, "expectBindList: " + enVar.a());
        IRuntimeService S0 = ch.S0(IGPSService.class, "Guild.group.GuildBindGroupSettingViewModel");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setGuildBoundGroups(enVar, new f(arrayList));
    }

    public final void z2(@NotNull final GroupChatData groupData) {
        boolean z16;
        boolean z17;
        boolean z18;
        int collectionSizeOrDefault;
        boolean z19;
        Intrinsics.checkNotNullParameter(groupData, "groupData");
        Object obj = null;
        if (groupData.getIsBindGroup()) {
            Logger.f235387a.d().i("Guild.group.GuildBindGroupSettingViewModel", 1, "updateGroupBindState: " + groupData.getId() + " to unbound");
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.boundGroupList, (Function1) new Function1<IGProBindingGroup, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$updateGroupBindState$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull IGProBindingGroup it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getGroupCode() == GroupChatData.this.getId());
                }
            });
            for (OneBindableGroupSettingData oneBindableGroupSettingData : this.unboundGroupList) {
                if (oneBindableGroupSettingData.a(groupData.getId())) {
                    Logger.f235387a.d().w("Guild.group.GuildBindGroupSettingViewModel", 1, "currentGroup: " + oneBindableGroupSettingData);
                    oneBindableGroupSettingData.h(groupData.getId());
                }
            }
            if (this.bindableGroupToType.containsKey(Long.valueOf(groupData.getId()))) {
                Iterator<T> it = this.unboundGroupList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((OneBindableGroupSettingData) next).getCom.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.KEY_GROUP_TYPE java.lang.String() == this.bindableGroupToType.get(Long.valueOf(groupData.getId()))) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        obj = next;
                        break;
                    }
                }
                OneBindableGroupSettingData oneBindableGroupSettingData2 = (OneBindableGroupSettingData) obj;
                if (oneBindableGroupSettingData2 != null) {
                    oneBindableGroupSettingData2.b().add(0, groupData.getGroupData());
                }
            }
        } else {
            Logger.f235387a.d().i("Guild.group.GuildBindGroupSettingViewModel", 1, "updateGroupBindState: " + groupData.getId() + " to bound");
            List<IGProBindingGroup> list = this.boundGroupList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it5 = list.iterator();
                while (it5.hasNext()) {
                    if (((IGProBindingGroup) it5.next()).getGroupCode() == groupData.getId()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z17) {
                Logger.a d16 = Logger.f235387a.d();
                List list2 = this.boundGroupList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it6 = list2.iterator();
                while (it6.hasNext()) {
                    arrayList.add(Long.valueOf(((IGProBindingGroup) it6.next()).getGroupCode()));
                }
                d16.w("Guild.group.GuildBindGroupSettingViewModel", 1, "currentBoundList: " + arrayList);
                CollectionsKt__MutableCollectionsKt.removeAll((List) this.boundGroupList, (Function1) new Function1<IGProBindingGroup, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$updateGroupBindState$9
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull IGProBindingGroup it7) {
                        Intrinsics.checkNotNullParameter(it7, "it");
                        return Boolean.valueOf(it7.getGroupCode() == GroupChatData.this.getId());
                    }
                });
            }
            this.boundGroupList.add(groupData.getGroupData());
            if (this.bindableGroupToType.containsKey(Long.valueOf(groupData.getId()))) {
                Iterator<T> it7 = this.unboundGroupList.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    Object next2 = it7.next();
                    if (((OneBindableGroupSettingData) next2).getCom.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.KEY_GROUP_TYPE java.lang.String() == this.bindableGroupToType.get(Long.valueOf(groupData.getId()))) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        obj = next2;
                        break;
                    }
                }
                OneBindableGroupSettingData oneBindableGroupSettingData3 = (OneBindableGroupSettingData) obj;
                if (oneBindableGroupSettingData3 != null) {
                    CollectionsKt__MutableCollectionsKt.removeAll((List) oneBindableGroupSettingData3.b(), (Function1) new Function1<IGProBindingGroup, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$updateGroupBindState$11$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull IGProBindingGroup it8) {
                            Intrinsics.checkNotNullParameter(it8, "it");
                            return Boolean.valueOf(it8.getGroupCode() == GroupChatData.this.getId());
                        }
                    });
                    CollectionsKt__MutableCollectionsKt.removeAll((List) oneBindableGroupSettingData3.e(), (Function1) new Function1<IGProBindingGroup, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$updateGroupBindState$11$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull IGProBindingGroup it8) {
                            Intrinsics.checkNotNullParameter(it8, "it");
                            return Boolean.valueOf(it8.getGroupCode() == GroupChatData.this.getId());
                        }
                    });
                }
            } else {
                Logger.f235387a.d().w("Guild.group.GuildBindGroupSettingViewModel", 1, "can't find group type");
                for (OneBindableGroupSettingData oneBindableGroupSettingData4 : this.unboundGroupList) {
                    CollectionsKt__MutableCollectionsKt.removeAll((List) oneBindableGroupSettingData4.b(), (Function1) new Function1<IGProBindingGroup, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$updateGroupBindState$13$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull IGProBindingGroup it8) {
                            Intrinsics.checkNotNullParameter(it8, "it");
                            return Boolean.valueOf(it8.getGroupCode() == GroupChatData.this.getId());
                        }
                    });
                    CollectionsKt__MutableCollectionsKt.removeAll((List) oneBindableGroupSettingData4.e(), (Function1) new Function1<IGProBindingGroup, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$updateGroupBindState$13$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull IGProBindingGroup it8) {
                            Intrinsics.checkNotNullParameter(it8, "it");
                            return Boolean.valueOf(it8.getGroupCode() == GroupChatData.this.getId());
                        }
                    });
                }
            }
        }
        t2();
    }
}
