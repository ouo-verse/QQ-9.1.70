package com.tencent.mobileqq.guild.rolegroup.levelrole;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mm.plugin.appbrand.jsapi.sensor.JsApiEnableDeviceOrientation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.w;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.x;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.aq;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0003J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\u0014\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0012J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011098F\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\t098F\u00a2\u0006\u0006\u001a\u0004\b=\u0010;\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "R1", "Q1", "S1", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "itemData", "", "isChecked", "O1", "b2", "P1", "", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "levelRoles", "", "", "tempAddingRoles", "c2", "Z1", "", "T1", "()[Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "roleId", ICustomDataEditor.STRING_ARRAY_PARAM_2, "account", "onAccountChanged", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleViewAndSelectParam;", "i", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleViewAndSelectParam;", "mParam", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_rolesLiveList", BdhLogUtil.LogTag.Tag_Conn, "_liveIsSelectRole", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/z;", "D", "Lkotlin/Lazy;", "W1", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/z;", "mFetchAction", "", "E", "Ljava/util/Set;", "mAllRolesSelected", UserInfo.SEX_FEMALE, "mTempSelectedLvRolesWhenEnter", "G", "mTempSelectedLvRolesWhenAdd", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "H", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "mGPSService", "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "rolesLiveList", "U1", "liveIsSelectRole", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleViewAndSelectParam;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLevelRoleViewAndSelectViewModel extends ViewModel implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _liveIsSelectRole;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFetchAction;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Set<String> mAllRolesSelected;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Set<String> mTempSelectedLvRolesWhenEnter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Set<String> mTempSelectedLvRolesWhenAdd;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private IGPSService mGPSService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LevelRoleViewAndSelectParam mParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<LevelRoleUIData>> _rolesLiveList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectViewModel$b", "Lvh2/aq;", "", "result", "", "errMsg", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleList", "levelRoleList", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements aq {
        b() {
        }

        @Override // vh2.aq
        public void a(int result, @NotNull String errMsg, @NotNull List<? extends IGProGuildRoleInfo> roleList, @NotNull List<? extends IGProGuildRoleInfo> levelRoleList) {
            int collectionSizeOrDefault;
            List mutableList;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(roleList, "roleList");
            Intrinsics.checkNotNullParameter(levelRoleList, "levelRoleList");
            if (result != 0) {
                QQToastUtil.showQQToast(1, errMsg);
                return;
            }
            GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel = GuildLevelRoleViewAndSelectViewModel.this;
            ArrayList<IGProGuildRoleInfo> arrayList = new ArrayList();
            Iterator<T> it = levelRoleList.iterator();
            while (true) {
                boolean z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                IGProGuildRoleInfo iGProGuildRoleInfo = (IGProGuildRoleInfo) next;
                if (guildLevelRoleViewAndSelectViewModel.mParam.getPageLayoutType() == PageLayoutType.MANAGE_AND_ADD && guildLevelRoleViewAndSelectViewModel.mAllRolesSelected.contains(iGProGuildRoleInfo.getRoleId())) {
                    z16 = true;
                }
                if (!z16) {
                    arrayList.add(next);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (IGProGuildRoleInfo iGProGuildRoleInfo2 : arrayList) {
                String roleId = iGProGuildRoleInfo2.getRoleId();
                String name = iGProGuildRoleInfo2.getName();
                int count = iGProGuildRoleInfo2.getCount();
                String levelDesc = iGProGuildRoleInfo2.getLevelDesc();
                String levelIconUrl = iGProGuildRoleInfo2.getLevelIconUrl();
                String levelSimpleDsc = iGProGuildRoleInfo2.getLevelSimpleDsc();
                int visibleChannelsCount = iGProGuildRoleInfo2.getVisibleChannelsCount();
                int speakableChannelsCount = iGProGuildRoleInfo2.getSpeakableChannelsCount();
                Intrinsics.checkNotNullExpressionValue(roleId, "roleId");
                Intrinsics.checkNotNullExpressionValue(levelSimpleDsc, "levelSimpleDsc");
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Intrinsics.checkNotNullExpressionValue(levelDesc, "levelDesc");
                Intrinsics.checkNotNullExpressionValue(levelIconUrl, "levelIconUrl");
                arrayList2.add(new LevelRoleUIData(roleId, levelSimpleDsc, name, levelDesc, count, levelIconUrl, visibleChannelsCount, speakableChannelsCount, 0.0f, 256, null));
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.rg.LevelRole.ListViewModel", 2, "result:" + result + " errMsg:" + errMsg + " levelRoleSize:" + levelRoleList.size() + " afterFilter:" + mutableList.size());
            }
            if (GuildLevelRoleViewAndSelectViewModel.this.mParam.getPageLayoutType() == PageLayoutType.VIEW_LEVEL_ROLES_ENTRANCE) {
                String qqStr = HardCodeUtil.qqStr(R.string.f147370wp);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_level_role_list_view_tip)");
                mutableList.add(0, new LevelRoleUIData("LEVEL_ROLE_TIP_ID", null, qqStr, null, 0, null, 0, 0, 0.0f, 506, null));
            }
            if (GuildLevelRoleViewAndSelectViewModel.this.mParam.getPageLayoutType() == PageLayoutType.BIND_CHANNEL_SPEAKABLE || GuildLevelRoleViewAndSelectViewModel.this.mParam.getPageLayoutType() == PageLayoutType.BIND_CHANNEL_VISIBLE) {
                mutableList.add(0, new LevelRoleUIData("LEVEL_ROLE_SPACE_ID", null, null, null, 0, null, 0, 0, 0.0f, 510, null));
            }
            GuildLevelRoleViewAndSelectViewModel.this._rolesLiveList.postValue(mutableList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectViewModel$c", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/x;", "", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "roleGroupDataList", "", "total", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements x {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.x
        public void a(@NotNull List<RoleLabelData> roleGroupDataList, int total) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(roleGroupDataList, "roleGroupDataList");
            MutableLiveData mutableLiveData = GuildLevelRoleViewAndSelectViewModel.this._rolesLiveList;
            ArrayList<RoleLabelData> arrayList = new ArrayList();
            for (Object obj : roleGroupDataList) {
                if (((RoleLabelData) obj).isLevelRole()) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (RoleLabelData roleLabelData : arrayList) {
                arrayList2.add(new LevelRoleUIData(roleLabelData.getRoleId(), roleLabelData.getLvName(), roleLabelData.getRoleName(), null, 0, roleLabelData.getLvIcon(), 0, 0, 0.0f, JsApiEnableDeviceOrientation.CTRL_INDEX, null));
            }
            mutableLiveData.postValue(arrayList2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectViewModel$d", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/w;", "Lri1/a;", "error", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements w {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LevelRoleUIData f232628b;

        d(LevelRoleUIData levelRoleUIData) {
            this.f232628b = levelRoleUIData;
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.w
        public void a(@NotNull ri1.a error) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (!error.d()) {
                int i3 = error.f431477a;
                if (i3 != 10023 && i3 != 180010) {
                    ch.d1(1, R.string.f1500313w);
                    return;
                } else {
                    ch.e1(1, error.f431478b);
                    return;
                }
            }
            GuildLevelRoleViewAndSelectViewModel.this.P1(this.f232628b);
        }
    }

    public GuildLevelRoleViewAndSelectViewModel(@NotNull LevelRoleViewAndSelectParam mParam) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mParam, "mParam");
        this.mParam = mParam;
        this._rolesLiveList = new MutableLiveData<>();
        this._liveIsSelectRole = new MutableLiveData<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<z>() { // from class: com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectViewModel$mFetchAction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final z invoke() {
                return GuildBindPermissionActionFactory.a(GuildLevelRoleViewAndSelectViewModel.this.mParam.getGuildId(), GuildLevelRoleViewAndSelectViewModel.this.mParam.getChannelId(), GuildLevelRoleViewAndSelectViewModel.this.mParam.getFetchType());
            }
        });
        this.mFetchAction = lazy;
        this.mAllRolesSelected = new LinkedHashSet();
        this.mTempSelectedLvRolesWhenEnter = new LinkedHashSet();
        this.mTempSelectedLvRolesWhenAdd = new LinkedHashSet();
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.mGPSService = (IGPSService) R0;
        AccountChangedNotifier.f214789d.a(this);
    }

    private final void Q1() {
        this.mGPSService.fetchRoleList(this.mParam.getGuildId(), 3, 121, new b());
    }

    private final void R1() {
        W1().d(this.mGPSService, new c());
    }

    private final z W1() {
        return (z) this.mFetchAction.getValue();
    }

    public final void O1(@NotNull LevelRoleUIData itemData, boolean isChecked) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (isChecked) {
            this.mTempSelectedLvRolesWhenAdd.add(itemData.getRoleId());
        } else {
            this.mTempSelectedLvRolesWhenAdd.remove(itemData.getRoleId());
        }
        MutableLiveData<Boolean> mutableLiveData = this._liveIsSelectRole;
        boolean z16 = true;
        if (!(!this.mTempSelectedLvRolesWhenAdd.isEmpty()) && this.mTempSelectedLvRolesWhenEnter.size() == 0) {
            z16 = false;
        }
        mutableLiveData.postValue(Boolean.valueOf(z16));
    }

    public final void P1(@NotNull LevelRoleUIData itemData) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        MutableLiveData<List<LevelRoleUIData>> mutableLiveData = this._rolesLiveList;
        List<LevelRoleUIData> value = mutableLiveData.getValue();
        if (value != null) {
            arrayList = new ArrayList();
            for (Object obj : value) {
                if (!Intrinsics.areEqual(itemData.getRoleId(), ((LevelRoleUIData) obj).getRoleId())) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = new ArrayList();
        }
        mutableLiveData.postValue(arrayList);
        this.mAllRolesSelected.remove(itemData.getRoleId());
    }

    public final void S1() {
        if (this.mParam.getPageLayoutType() == PageLayoutType.MANAGE_AND_DELETE && !this.mParam.isCreating()) {
            R1();
        } else {
            Q1();
        }
    }

    @NotNull
    public final RoleLabelData[] T1() {
        int collectionSizeOrDefault;
        List<LevelRoleUIData> value = X1().getValue();
        if (value != null) {
            ArrayList<LevelRoleUIData> arrayList = new ArrayList();
            for (Object obj : value) {
                if (this.mAllRolesSelected.contains(((LevelRoleUIData) obj).getRoleId())) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (LevelRoleUIData levelRoleUIData : arrayList) {
                arrayList2.add(new RoleLabelData(levelRoleUIData.getRoleId(), 0, levelRoleUIData.getRoleName(), 0, levelRoleUIData.getRoleLVName(), levelRoleUIData.getRoleIcon(), false, false, 0, 458, null));
            }
            Object[] array = arrayList2.toArray(new RoleLabelData[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            RoleLabelData[] roleLabelDataArr = (RoleLabelData[]) array;
            if (roleLabelDataArr != null) {
                return roleLabelDataArr;
            }
        }
        return new RoleLabelData[0];
    }

    @NotNull
    public final LiveData<Boolean> U1() {
        return this._liveIsSelectRole;
    }

    @NotNull
    public final LiveData<List<LevelRoleUIData>> X1() {
        return this._rolesLiveList;
    }

    @NotNull
    public final List<String> Z1() {
        return new ArrayList(this.mTempSelectedLvRolesWhenAdd);
    }

    public final boolean a2(@NotNull String roleId) {
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        return this.mTempSelectedLvRolesWhenAdd.contains(roleId);
    }

    public final void b2(@NotNull LevelRoleUIData itemData) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        z W1 = W1();
        IGPSService iGPSService = this.mGPSService;
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(itemData.getRoleId());
        W1.b(iGPSService, arrayList, arrayListOf, new d(itemData));
    }

    public final void c2(@NotNull List<RoleLabelData> levelRoles, @NotNull List<String> tempAddingRoles) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(levelRoles, "levelRoles");
        Intrinsics.checkNotNullParameter(tempAddingRoles, "tempAddingRoles");
        List<RoleLabelData> list = levelRoles;
        ArrayList<RoleLabelData> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RoleLabelData) obj).isLevelRole()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (RoleLabelData roleLabelData : arrayList) {
            arrayList2.add(new LevelRoleUIData(roleLabelData.getRoleId(), roleLabelData.getLvName(), roleLabelData.getRoleName(), null, 0, roleLabelData.getLvIcon(), 0, 0, 0.0f, JsApiEnableDeviceOrientation.CTRL_INDEX, null));
        }
        this._rolesLiveList.postValue(arrayList2);
        Set<String> set = this.mAllRolesSelected;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList3.add(((RoleLabelData) it.next()).getRoleId());
        }
        set.addAll(arrayList3);
        List<String> list2 = tempAddingRoles;
        this.mTempSelectedLvRolesWhenEnter.addAll(list2);
        this.mTempSelectedLvRolesWhenAdd.addAll(list2);
        this._liveIsSelectRole.postValue(Boolean.valueOf(!this.mTempSelectedLvRolesWhenAdd.isEmpty()));
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.mGPSService = (IGPSService) R0;
    }
}
