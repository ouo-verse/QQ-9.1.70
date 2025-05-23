package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.CreateRoleItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.DescriptionItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.DisplayExtra;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.LevelRoleItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.LevelRoleTipItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.RoleEveryoneItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.RoleItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.RoleVisitorItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.SpaceItem;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0001\u0019\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003fghB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\bc\u0010dJ\u0010\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0014J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100#H\u0002J\b\u0010&\u001a\u00020%H\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R \u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001d018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\r018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00103R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u000209018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00103R\u0014\u0010>\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00100#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010:R\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010(R\u0016\u0010S\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010(R\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020U0T8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bV\u0010WR\u001d\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001d0Y8F\u00a2\u0006\u0006\u001a\u0004\bZ\u0010[R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00040Y8F\u00a2\u0006\u0006\u001a\u0004\b]\u0010[R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020\r0Y8F\u00a2\u0006\u0006\u001a\u0004\b_\u0010[R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u0002090Y8F\u00a2\u0006\u0006\u001a\u0004\ba\u0010[\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel;", "Lef1/b;", "", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "", "l2", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "from", "to", "j2", "q2", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "showState", "o2", "", "W1", "account", "onAccountChanged", "onCleared", "", "i2", "p2", "r2", "com/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$d", "Z1", "()Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$d;", "k2", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "roleModels", "b2", "d2", "c2", "Lcom/tencent/mobileqq/guild/base/repository/h;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "X1", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", ICustomDataEditor.NUMBER_PARAM_2, "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "D", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "roleRepository", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "_liveList", "G", "_liveGuildId", "H", "_liveShowState", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$RunningState;", "I", "_liveRunningState", "J", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$d;", "onCreateOnFetchRoleGroupListCallback", "K", "Lcom/tencent/mobileqq/guild/base/repository/h;", "onReorderCallback", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "L", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "M", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "N", "Ljava/util/List;", "roleItems", "P", "rawRoleItems", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "selfType", BdhLogUtil.LogTag.Tag_Req, "guildOwnerNickname", ExifInterface.LATITUDE_SOUTH, "guildOwnerTinyId", "Lcom/tencent/mobileqq/guild/util/cn;", "Lcf1/b;", "getToastEvent", "()Lcom/tencent/mobileqq/guild/util/cn;", "toastEvent", "Landroidx/lifecycle/LiveData;", "f2", "()Landroidx/lifecycle/LiveData;", "liveList", "e2", "liveGuildId", SemanticAttributes.DbSystemValues.H2, "liveShowState", "g2", "liveRunningState", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;)V", "T", "a", "RunningState", "ShowState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RoleGroupListViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final IRoleGroupListRepository roleRepository;
    private final /* synthetic */ ef1.d E;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r>> _liveList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _liveGuildId;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ShowState> _liveShowState;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<RunningState> _liveRunningState;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final d onCreateOnFetchRoleGroupListCallback;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.base.repository.h<Boolean> onReorderCallback;

    /* renamed from: L, reason: from kotlin metadata */
    private IGPSService gProService;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gProObserver;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> roleItems;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private List<RoleGroupModel> rawRoleItems;

    /* renamed from: Q, reason: from kotlin metadata */
    private int selfType;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String guildOwnerNickname;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String guildOwnerTinyId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$RunningState;", "", "(Ljava/lang/String;I)V", "REFRESH", "REORDER", "ADD", "REMOVE", QzoneDataUpdateAction.UPDATE, com.tencent.tmdownloader.a.CONNTECTSTATE_FINISH, RLog.ERROR, "PAGE_END", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum RunningState {
        REFRESH,
        REORDER,
        ADD,
        REMOVE,
        UPDATE,
        FINISH,
        ERROR,
        PAGE_END
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "SORTABLE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum ShowState {
        NORMAL,
        SORTABLE
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232855a;

        static {
            int[] iArr = new int[ShowState.values().length];
            try {
                iArr[ShowState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShowState.SORTABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f232855a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "tinyId", "onUserDisplayNameUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, RoleGroupListViewModel.this.getGuildId())) {
                IGPSService iGPSService = RoleGroupListViewModel.this.gProService;
                Unit unit = null;
                if (iGPSService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gProService");
                    iGPSService = null;
                }
                IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildId);
                if (guildInfo != null) {
                    RoleGroupListViewModel.this.selfType = guildInfo.getUserType();
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    RoleGroupListViewModel.this._liveRunningState.setValue(RunningState.PAGE_END);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            boolean z16;
            if (RoleGroupListViewModel.this.guildOwnerTinyId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && Intrinsics.areEqual(RoleGroupListViewModel.this.guildOwnerTinyId, tinyId)) {
                RoleGroupListViewModel roleGroupListViewModel = RoleGroupListViewModel.this;
                IGPSService iGPSService = roleGroupListViewModel.gProService;
                if (iGPSService == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gProService");
                    iGPSService = null;
                }
                String guildUserDisplayName = iGPSService.getGuildUserDisplayName(RoleGroupListViewModel.this.getGuildId(), RoleGroupListViewModel.this.guildOwnerTinyId);
                Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "gProService.getGuildUser\u2026uildId, guildOwnerTinyId)");
                roleGroupListViewModel.guildOwnerNickname = guildUserDisplayName;
                if (RoleGroupListViewModel.this._liveRunningState.getValue() == RunningState.FINISH) {
                    RoleGroupListViewModel.this.k2();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$d", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable RoleGroupListModel result) {
            Intrinsics.checkNotNullParameter(error, "error");
            boolean z16 = true;
            if (!error.d()) {
                RoleGroupListViewModel.this.getToastEvent().setValue(new cf1.b(error.f431477a, error.f431478b));
                QLog.e("Guild.rg.RoleGroupListViewModel", 1, "Failed fetch role groups, error: " + error);
                RoleGroupListViewModel.this._liveRunningState.setValue(RunningState.ERROR);
                return;
            }
            if (result == null) {
                z16 = false;
            }
            if (z16) {
                RoleGroupListViewModel.this.rawRoleItems = result.d();
                RoleGroupListViewModel.this.n2(result.getGuildId());
                RoleGroupListViewModel.this.k2();
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$e", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lri1/a;", "error", "result", "", "b", "(Lri1/a;Ljava/lang/Boolean;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.base.repository.h<Boolean> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable Boolean result) {
            Intrinsics.checkNotNullParameter(error, "error");
            boolean z16 = false;
            if (!error.d()) {
                RoleGroupListViewModel.this.getToastEvent().setValue(new cf1.b(error.f431477a, cb.d(error.f431478b, QQGuildUIUtil.r(R.string.f146330tw))));
                RoleGroupListViewModel.this._liveRunningState.setValue(RunningState.ERROR);
                return;
            }
            if (result != null) {
                z16 = true;
            }
            if (z16) {
                RoleGroupListViewModel.this.getToastEvent().setValue(new cf1.b(error.f431477a, QQGuildUIUtil.r(R.string.f146340tx)));
                RoleGroupListViewModel.this._liveRunningState.setValue(RunningState.FINISH);
                RoleGroupListViewModel.this._liveShowState.setValue(ShowState.NORMAL);
                RoleGroupListViewModel.m2(RoleGroupListViewModel.this, null, 1, null);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public RoleGroupListViewModel(@NotNull String guildId, @NotNull IRoleGroupListRepository roleRepository) {
        List<? extends com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> emptyList;
        List<RoleGroupModel> emptyList2;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleRepository, "roleRepository");
        this.guildId = guildId;
        this.roleRepository = roleRepository;
        this.E = new ef1.d();
        this._liveList = new MutableLiveData<>();
        this._liveGuildId = new MutableLiveData<>();
        this._liveShowState = new MutableLiveData<>(ShowState.NORMAL);
        this._liveRunningState = new MutableLiveData<>();
        this.onCreateOnFetchRoleGroupListCallback = Z1();
        this.onReorderCallback = a2();
        this.gProObserver = X1();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.roleItems = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.rawRoleItems = emptyList2;
        this.guildOwnerNickname = "";
        this.guildOwnerTinyId = "";
        p2();
    }

    private final GPServiceObserver X1() {
        return new c();
    }

    private final d Z1() {
        return new d();
    }

    private final com.tencent.mobileqq.guild.base.repository.h<Boolean> a2() {
        return new e();
    }

    private final List<com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> b2(List<RoleGroupModel> roleModels) {
        int i3;
        List<com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> emptyList;
        ShowState value = h2().getValue();
        if (value == null) {
            i3 = -1;
        } else {
            i3 = b.f232855a[value.ordinal()];
        }
        if (i3 == -1) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                return c2(roleModels);
            }
            throw new NoWhenBranchMatchedException();
        }
        return d2(roleModels);
    }

    private final List<com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> c2(List<RoleGroupModel> roleModels) {
        List split$default;
        int collectionSizeOrDefault;
        List<com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> listOf;
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        String qqStr = HardCodeUtil.qqStr(R.string.f154801fs);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_rol\u2026list_reorder_description)");
        split$default = StringsKt__StringsKt.split$default((CharSequence) qqStr, new String[]{"\n"}, false, 0, 6, (Object) null);
        spreadBuilder.add(new DescriptionItem(split$default));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = roleModels.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RoleGroupModel roleGroupModel = (RoleGroupModel) next;
            if (!roleGroupModel.w() && !roleGroupModel.C()) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(new RoleItem((RoleGroupModel) it5.next(), null, 2, null));
        }
        Object[] array = arrayList2.toArray(new RoleItem[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        spreadBuilder.addSpread(array);
        spreadBuilder.add(new SpaceItem(40.0f));
        listOf = CollectionsKt__CollectionsKt.listOf(spreadBuilder.toArray(new com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r[spreadBuilder.size()]));
        return listOf;
    }

    private final List<com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> d2(List<RoleGroupModel> roleModels) {
        int collectionSizeOrDefault;
        Object obj;
        Object obj2;
        boolean z16;
        List listOf;
        List listOf2;
        List listOf3;
        List<com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> emptyList;
        RoleItem roleItem;
        List<RoleGroupModel> list = roleModels;
        ArrayList<RoleGroupModel> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RoleGroupModel roleGroupModel = (RoleGroupModel) next;
            if (roleGroupModel.w() || roleGroupModel.C()) {
                z17 = true;
            }
            if (!z17) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (RoleGroupModel roleGroupModel2 : arrayList) {
            if (roleGroupModel2.v()) {
                roleItem = new RoleItem(roleGroupModel2, new DisplayExtra(roleGroupModel2.getRolePermission().getIsAccessibleInList(), this.guildOwnerNickname));
            } else {
                roleItem = new RoleItem(roleGroupModel2, new DisplayExtra(roleGroupModel2.getRolePermission().getIsAccessibleInList(), null, 2, null));
            }
            arrayList2.add(roleItem);
        }
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                if (((RoleGroupModel) obj).w()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        RoleGroupModel roleGroupModel3 = (RoleGroupModel) obj;
        if (roleGroupModel3 == null) {
            this._liveRunningState.setValue(RunningState.PAGE_END);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Iterator<T> it6 = list.iterator();
        while (true) {
            if (it6.hasNext()) {
                obj2 = it6.next();
                if (((RoleGroupModel) obj2).C()) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        RoleGroupModel roleGroupModel4 = (RoleGroupModel) obj2;
        int i3 = this.selfType;
        if (i3 != 2 && i3 != 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean a16 = com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().getGuildPermission(this.guildId).a(70001);
        ArrayList arrayList3 = new ArrayList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r[]{new SpaceItem(12.0f), new LevelRoleItem(null, null, z16, 3, null), new LevelRoleTipItem(null, 1, null)});
        arrayList3.addAll(listOf);
        if (a16) {
            String qqStr = HardCodeUtil.qqStr(R.string.f154731fl);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_list_create_role)");
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r[]{new SpaceItem(12.0f), new CreateRoleItem(qqStr)});
            arrayList3.addAll(listOf3);
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        Object[] array = arrayList2.toArray(new RoleItem[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        spreadBuilder.addSpread(array);
        spreadBuilder.add(new SpaceItem(17.6f));
        spreadBuilder.add(new RoleEveryoneItem("", roleGroupModel3));
        listOf2 = CollectionsKt__CollectionsKt.listOf(spreadBuilder.toArray(new com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r[spreadBuilder.size()]));
        arrayList3.addAll(listOf2);
        if (roleGroupModel4 != null) {
            arrayList3.add(new SpaceItem(17.6f));
            arrayList3.add(new RoleVisitorItem("", roleGroupModel4));
        }
        arrayList3.add(new SpaceItem(30.0f));
        return arrayList3;
    }

    private final void i2(int from, int to5) {
        Iterator<Integer> it = com.tencent.mobileqq.guild.base.extension.p.a(from, to5).iterator();
        if (!it.hasNext()) {
            CollectionsKt__CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            IntIterator intIterator = (IntIterator) it;
            int nextInt = intIterator.nextInt();
            while (it.hasNext()) {
                int nextInt2 = intIterator.nextInt();
                Collections.swap(this.roleItems, nextInt, nextInt2);
                arrayList.add(Unit.INSTANCE);
                nextInt = nextInt2;
            }
        }
        this._liveList.setValue(new ArrayList(this.roleItems));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2() {
        this.roleItems = b2(this.rawRoleItems);
        this._liveList.setValue(new ArrayList(this.roleItems));
        this._liveGuildId.setValue(this.guildId);
        this._liveRunningState.setValue(RunningState.FINISH);
    }

    public static /* synthetic */ void m2(RoleGroupListViewModel roleGroupListViewModel, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = roleGroupListViewModel.guildId;
        }
        roleGroupListViewModel.l2(str);
    }

    private final void p2() {
        IGPSService iGPSService = this.gProService;
        Unit unit = null;
        if (iGPSService != null) {
            if (iGPSService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gProService");
                iGPSService = null;
            }
            iGPSService.deleteObserver(this.gProObserver);
        }
        IGPSService iGPSService2 = (IGPSService) MiscKt.c(IGPSService.class, "Guild.rg.RoleGroupListViewModel", "");
        this.gProService = iGPSService2;
        if (iGPSService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
            iGPSService2 = null;
        }
        iGPSService2.addObserver(this.gProObserver);
        IGPSService iGPSService3 = this.gProService;
        if (iGPSService3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
            iGPSService3 = null;
        }
        IGProGuildInfo guildInfo = iGPSService3.getGuildInfo(this.guildId);
        if (guildInfo != null) {
            this.selfType = guildInfo.getUserType();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this._liveRunningState.setValue(RunningState.PAGE_END);
        }
    }

    private final void r2() {
        IGPSService iGPSService = this.gProService;
        if (iGPSService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
            iGPSService = null;
        }
        iGPSService.deleteObserver(this.gProObserver);
    }

    public final boolean W1() {
        List<RoleGroupModel> list = this.rawRoleItems;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RoleGroupModel) obj).z()) {
                arrayList.add(obj);
            }
        }
        long size = arrayList.size();
        IGPSService iGPSService = this.gProService;
        if (iGPSService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
            iGPSService = null;
        }
        if (size < iGPSService.getGuildRoleLimit(this.guildId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final LiveData<String> e2() {
        return this._liveGuildId;
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r>> f2() {
        return this._liveList;
    }

    @NotNull
    public final LiveData<RunningState> g2() {
        return this._liveRunningState;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public cn<cf1.b> getToastEvent() {
        return this.E.a();
    }

    @NotNull
    public final LiveData<ShowState> h2() {
        return this._liveShowState;
    }

    public final void j2(@NotNull com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r from, @NotNull com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r to5) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to5, "to");
        i2(this.roleItems.indexOf(from), this.roleItems.indexOf(to5));
    }

    public final void l2(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        IGPSService iGPSService = this.gProService;
        IGPSService iGPSService2 = null;
        if (iGPSService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
            iGPSService = null;
        }
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildId);
        if (guildInfo == null) {
            this._liveRunningState.setValue(RunningState.PAGE_END);
            return;
        }
        String creatorId = guildInfo.getCreatorId();
        Intrinsics.checkNotNullExpressionValue(creatorId, "guildInfo.creatorId");
        this.guildOwnerTinyId = creatorId;
        IGPSService iGPSService3 = this.gProService;
        if (iGPSService3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
        } else {
            iGPSService2 = iGPSService3;
        }
        String guildUserDisplayName = iGPSService2.getGuildUserDisplayName(guildId, this.guildOwnerTinyId);
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "gProService.getGuildUser\u2026uildId, guildOwnerTinyId)");
        this.guildOwnerNickname = guildUserDisplayName;
        this._liveRunningState.setValue(RunningState.REFRESH);
        this.roleRepository.h(new FetchRoleGroupParam(guildId, null, false, 112, 6, null), this.onCreateOnFetchRoleGroupListCallback);
    }

    public final void n2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void o2(@NotNull ShowState showState) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        this._liveShowState.setValue(showState);
        this.roleItems = b2(this.rawRoleItems);
        this._liveList.setValue(new ArrayList(this.roleItems));
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        p2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        r2();
    }

    public final void q2() {
        int collectionSizeOrDefault;
        List<String> list;
        boolean z16;
        if (!NetworkUtil.isNetworkAvailable()) {
            getToastEvent().setValue(new cf1.b(-93, QQGuildUIUtil.r(R.string.f146330tw)));
            this._liveRunningState.setValue(RunningState.ERROR);
            return;
        }
        this._liveRunningState.setValue(RunningState.REORDER);
        List<? extends com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r> list2 = this.roleItems;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r rVar = (com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r) obj;
            if ((rVar instanceof RoleItem) && ((RoleItem) rVar).getRole().getIsSortableForBackend()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r) it.next()).getId());
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList2);
        if (list.isEmpty()) {
            this._liveRunningState.setValue(RunningState.FINISH);
            o2(ShowState.NORMAL);
        } else {
            this.roleRepository.j(this.guildId, list, this.onReorderCallback);
        }
    }
}
