package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.PermissionSwitchStatus;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.w;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.x;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.y;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GProRolePermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.aq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0015*\u0001u\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u0002:\u0002\u0088\u0001BK\u0012\u0006\u00107\u001a\u00020 \u0012\b\b\u0002\u00109\u001a\u00020 \u0012\u0006\u0010=\u001a\u00020:\u0012\b\b\u0002\u0010A\u001a\u00020>\u0012\b\b\u0002\u0010E\u001a\u00020B\u0012\b\b\u0002\u0010G\u001a\u00020B\u0012\b\b\u0002\u0010I\u001a\u00020B\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0002J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011*\b\u0012\u0004\u0012\u00020\u00160\u0011H\u0002J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0019\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020 J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020 J\u0014\u0010)\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011J\"\u0010.\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00112\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u00100\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020 H\u0016J\u0006\u00103\u001a\u00020\u0005J\u0006\u00104\u001a\u00020\u0005R\u0014\u00107\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0014\u0010I\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010DR \u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00110J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR#\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00110N8\u0006\u00a2\u0006\f\n\u0004\b@\u0010O\u001a\u0004\bP\u0010QR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020>0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR \u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00110J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010LR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020>0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010UR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001d0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010UR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020>0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010UR\"\u0010a\u001a\u0010\u0012\f\u0012\n _*\u0004\u0018\u00010B0B0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010UR\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\be\u0010c\u001a\u0004\bf\u0010gR\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020+0\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010cR\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\n0\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010cR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0017\u0010z\u001a\b\u0012\u0004\u0012\u00020B0N8F\u00a2\u0006\u0006\u001a\u0004\by\u0010QR\u0017\u0010|\u001a\b\u0012\u0004\u0012\u00020>0N8F\u00a2\u0006\u0006\u001a\u0004\b{\u0010QR\u0017\u0010~\u001a\b\u0012\u0004\u0012\u00020>0N8F\u00a2\u0006\u0006\u001a\u0004\b}\u0010QR\u001e\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00110N8F\u00a2\u0006\u0006\u001a\u0004\b\u007f\u0010QR\u0019\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020>0N8F\u00a2\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010QR\u0019\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0N8F\u00a2\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010Q\u00a8\u0006\u0089\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/k;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lri1/a;", "error", "", "d2", "c2", "e2", "", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "allSelectedRoleData", "w2", "filteredSelectedRoleData", "y2", "x2", "g2", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "l2", "input", "k2", "Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/previewavatar/a$b;", "b2", "", "m2", "()[Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "z2", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/PermissionSwitchStatus;", "type", "Z1", "", "from", "i2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "j2", "roleId", "B2", NowProxyConstants.AccountInfoKey.A2, "users", "E2", "t2", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "normalRoles", "lvRoles", Constants.BASE_IN_PLUGIN_VERSION, "allRoleData", "C2", "account", "onAccountChanged", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "i", "Ljava/lang/String;", "guildId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "channelId", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;", "fetchType", "", "D", "I", "channelType", "", "E", "Z", "isCreatingScene", UserInfo.SEX_FEMALE, "isFilterLvRole", "G", "needDisableRoleInfo", "Landroidx/lifecycle/MutableLiveData;", "H", "Landroidx/lifecycle/MutableLiveData;", "_rolesLiveList", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", ICustomDataEditor.STRING_PARAM_2, "()Landroidx/lifecycle/LiveData;", "rolesLiveList", "Le12/e;", "J", "Le12/e;", "_roleTotalLiveData", "K", "_usersLiveList", "L", "_userTotalLiveData", "M", "_permissionSwitchLiveData", "N", "_lvRoleTotalSizeLiveData", "kotlin.jvm.PlatformType", "P", "_endPageLivaData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/List;", "userCacheData", BdhLogUtil.LogTag.Tag_Req, "q2", "()Ljava/util/List;", "roleCacheDataWhenDelete", ExifInterface.LATITUDE_SOUTH, "allRoles", "T", "selectedRoles", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "U", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "mGPSService", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/z;", "V", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/z;", "mFetchAction", "com/tencent/mobileqq/guild/rolegroup/bindpermission/k$e", "W", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/k$e;", "mGProObserver", ICustomDataEditor.NUMBER_PARAM_2, "endPageLivaData", "r2", "roleTotalLiveData", "o2", "lvRoleTotalSizeLiveData", "v2", "usersLiveList", "u2", "userTotalLiveData", "p2", "permissionSwitchLiveData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionActionFactory$FetchType;IZZZ)V", "X", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k extends ViewModel implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildBindPermissionActionFactory.FetchType fetchType;

    /* renamed from: D, reason: from kotlin metadata */
    private final int channelType;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isCreatingScene;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isFilterLvRole;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean needDisableRoleInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<RoleLabelData>> _rolesLiveList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<RoleLabelData>> rolesLiveList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Integer> _roleTotalLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<a.b>> _usersLiveList;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Integer> _userTotalLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final e12.e<PermissionSwitchStatus> _permissionSwitchLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Integer> _lvRoleTotalSizeLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Boolean> _endPageLivaData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private List<RoleGroupUserUIData> userCacheData;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final List<RoleLabelData> roleCacheDataWhenDelete;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private List<RoleGroupModel> allRoles;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private List<RoleLabelData> selectedRoles;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private IGPSService mGPSService;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final z mFetchAction;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final e mGProObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/bindpermission/k$b", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/w;", "Lri1/a;", "error", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements w {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PermissionSwitchStatus f232427b;

        b(PermissionSwitchStatus permissionSwitchStatus) {
            this.f232427b = permissionSwitchStatus;
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.w
        public void a(@NotNull ri1.a error) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (!error.d()) {
                k.this.c2(error);
            } else {
                k.this._permissionSwitchLiveData.postValue(this.f232427b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/bindpermission/k$c", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/x;", "", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "roleGroupDataList", "", "total", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements x {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.x
        public void a(@NotNull List<RoleLabelData> roleGroupDataList, int total) {
            Intrinsics.checkNotNullParameter(roleGroupDataList, "roleGroupDataList");
            k.this.w2(roleGroupDataList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/bindpermission/k$d", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/y;", "", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/previewavatar/a$b;", "previewMemberUIData", "", "total", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements y {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.y
        public void a(@NotNull List<a.b> previewMemberUIData, int total) {
            Intrinsics.checkNotNullParameter(previewMemberUIData, "previewMemberUIData");
            k.this._userTotalLiveData.postValue(Integer.valueOf(total));
            k.this._usersLiveList.postValue(previewMemberUIData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/bindpermission/k$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "updateGuildId", "", "onChannelListUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String updateGuildId) {
            boolean z16;
            if (!Intrinsics.areEqual(updateGuildId, k.this.guildId)) {
                return;
            }
            if (k.this.channelId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && ch.B(k.this.channelId) == null) {
                Logger logger = Logger.f235387a;
                k kVar = k.this;
                logger.d().i("Guild.rg.BindPermission.ViewModel", 1, "onChannelListUpdated channel:" + kVar.channelId + " gone when operation");
                k.this._endPageLivaData.postValue(Boolean.TRUE);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/bindpermission/k$f", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/w;", "Lri1/a;", "error", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements w {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f232432b;

        f(String str) {
            this.f232432b = str;
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
            k.this.A2(this.f232432b);
        }
    }

    public /* synthetic */ k(String str, String str2, GuildBindPermissionActionFactory.FetchType fetchType, int i3, boolean z16, boolean z17, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? "" : str2, fetchType, (i16 & 8) != 0 ? -1 : i3, (i16 & 16) != 0 ? false : z16, (i16 & 32) != 0 ? false : z17, (i16 & 64) != 0 ? false : z18);
    }

    private final List<a.b> b2(List<RoleGroupUserUIData> list) {
        int collectionSizeOrDefault;
        List<RoleGroupUserUIData> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (RoleGroupUserUIData roleGroupUserUIData : list2) {
            arrayList.add(new a.b(2, this.guildId, roleGroupUserUIData.getMTinyId(), roleGroupUserUIData.getMName()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(ri1.a error) {
        int i3 = error.f431477a;
        if (i3 != 10023 && i3 != 180010) {
            if (!ch.p((IGProSecurityResult) error.f431479c)) {
                d2(error);
                return;
            }
            ch.d1(1, R.string.f155831ik);
        } else {
            ch.e1(1, error.f431478b);
        }
        this._endPageLivaData.postValue(Boolean.TRUE);
    }

    private final void d2(ri1.a error) {
        Object obj = error.f431479c;
        if (!(obj instanceof IGProSecurityResult)) {
            ch.d1(1, R.string.f155831ik);
            return;
        }
        long j3 = ((IGProSecurityResult) obj).get$actionCode();
        if (j3 == 102) {
            bg1.c.g((IGProSecurityResult) error.f431479c, error.f431477a, error.f431478b);
        } else if (j3 == 2) {
            ch.e1(1, ((IGProSecurityResult) error.f431479c).getStrPrompt());
        } else {
            ch.d1(1, R.string.f155831ik);
        }
    }

    private final void e2() {
        IRoleGroupListRepository.INSTANCE.a().h(new FetchRoleGroupParam(this.guildId, null, false, 111, 6, null), new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.j
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                k.f2(k.this, aVar, (RoleGroupListModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(k this$0, ri1.a error, RoleGroupListModel roleGroupListModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        if (!error.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetchAllRolesForDisableInfo error:" + error;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.BindPermission.ViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        if (roleGroupListModel != null) {
            this$0.allRoles = roleGroupListModel.d();
        }
        this$0.x2();
    }

    private final void g2() {
        this.mGPSService.fetchRoleList(this.guildId, 123, new aq() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.i
            @Override // vh2.aq
            public final void a(int i3, String str, List list, List list2) {
                k.h2(k.this, i3, str, list, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(k this$0, int i3, String str, List roleList, List list) {
        int collectionSizeOrDefault;
        List<RoleLabelData> mutableList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchDefaultSelectRoles result:" + i3 + " errMsg" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.BindPermission.ViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        Intrinsics.checkNotNullExpressionValue(roleList, "roleList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : roleList) {
            if (GuildOpenBindPermissionUtils.s(((IGProGuildRoleInfo) obj).getRoleType())) {
                arrayList.add(obj);
            }
        }
        List<IGProGuildRoleInfo> l26 = this$0.l2(arrayList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(l26, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (Iterator it5 = l26.iterator(); it5.hasNext(); it5 = it5) {
            IGProGuildRoleInfo iGProGuildRoleInfo = (IGProGuildRoleInfo) it5.next();
            String roleId = iGProGuildRoleInfo.getRoleId();
            Intrinsics.checkNotNullExpressionValue(roleId, "it.roleId");
            int color = (-16777216) | iGProGuildRoleInfo.getColor();
            String name = iGProGuildRoleInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            arrayList2.add(new RoleLabelData(roleId, color, name, iGProGuildRoleInfo.getRoleType(), null, null, false, iGProGuildRoleInfo.getPermission().getHasRolePermission(), iGProGuildRoleInfo.getDisplayType(), 112, null));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        this$0._roleTotalLiveData.postValue(Integer.valueOf(mutableList.size()));
        this$0._rolesLiveList.postValue(mutableList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RoleLabelData> k2(List<RoleLabelData> input) {
        List emptyList;
        Boolean bool;
        Pair pair;
        boolean z16;
        if (this.channelType == 7) {
            String str = this.guildId;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean contains = emptyList.contains(str);
            r rVar = r.f214743a;
            String str2 = "";
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(str);
            if (guildInfo != null) {
                bool = Boolean.valueOf(guildInfo.isMovePostSection());
            } else {
                bool = null;
            }
            if (contains) {
                pair = TuplesKt.to(Boolean.TRUE, "HardCode");
            } else if (bool == null) {
                pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
            } else {
                pair = TuplesKt.to(bool, "GuildInfo");
            }
            GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
            String str3 = guildDebugUtils.e().get(str);
            if (str3 != null) {
                str2 = str3;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "newFeedSquareResults.get(guildId) ?: \"\"");
            String pair2 = pair.toString();
            if (!Intrinsics.areEqual(str2, pair2)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + str + MsgSummary.STR_COLON + pair2);
                }
                guildDebugUtils.e().put(str, pair2);
            }
            if (((Boolean) pair.getFirst()).booleanValue()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : input) {
                    if (((RoleLabelData) obj).getRoleType() == 7) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }
        return input;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<IGProGuildRoleInfo> l2(List<? extends IGProGuildRoleInfo> list) {
        List emptyList;
        Boolean bool;
        Pair pair;
        boolean z16;
        if (this.channelType == 7) {
            String str = this.guildId;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean contains = emptyList.contains(str);
            r rVar = r.f214743a;
            String str2 = "";
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(str);
            if (guildInfo != null) {
                bool = Boolean.valueOf(guildInfo.isMovePostSection());
            } else {
                bool = null;
            }
            if (contains) {
                pair = TuplesKt.to(Boolean.TRUE, "HardCode");
            } else if (bool == null) {
                pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
            } else {
                pair = TuplesKt.to(bool, "GuildInfo");
            }
            GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
            String str3 = guildDebugUtils.e().get(str);
            if (str3 != null) {
                str2 = str3;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "newFeedSquareResults.get(guildId) ?: \"\"");
            String pair2 = pair.toString();
            if (!Intrinsics.areEqual(str2, pair2)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + str + MsgSummary.STR_COLON + pair2);
                }
                guildDebugUtils.e().put(str, pair2);
            }
            if (((Boolean) pair.getFirst()).booleanValue()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((IGProGuildRoleInfo) obj).getRoleType() == 7) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2(List<RoleLabelData> allSelectedRoleData) {
        Logger.f235387a.d().d("Guild.rg.BindPermission.ViewModel", 1, "handleSelectedRoles isF:" + this.isFilterLvRole + " allRoleSize:" + allSelectedRoleData.size());
        if (!this.isFilterLvRole) {
            this._roleTotalLiveData.postValue(Integer.valueOf(allSelectedRoleData.size()));
            y2(allSelectedRoleData);
            return;
        }
        List<RoleLabelData> list = allSelectedRoleData;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RoleLabelData) obj).isLevelRole()) {
                arrayList.add(obj);
            }
        }
        this._lvRoleTotalSizeLiveData.postValue(Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (!((RoleLabelData) obj2).isLevelRole()) {
                arrayList3.add(obj2);
            }
        }
        arrayList2.addAll(arrayList3);
        this._roleTotalLiveData.postValue(Integer.valueOf(allSelectedRoleData.size()));
        y2(arrayList2);
        if (!Intrinsics.areEqual(allSelectedRoleData, this.roleCacheDataWhenDelete)) {
            this.roleCacheDataWhenDelete.clear();
            this.roleCacheDataWhenDelete.addAll(allSelectedRoleData);
        }
    }

    private final void x2() {
        boolean booleanValue;
        int i3;
        boolean z16;
        HashMap hashMap = new HashMap();
        for (RoleGroupModel roleGroupModel : this.allRoles) {
            boolean b16 = dy1.b.b(roleGroupModel, this.isCreatingScene, this.fetchType);
            if (ch.g0(this.guildId)) {
                Iterator<RoleGroupModel> it = this.allRoles.iterator();
                int i16 = 0;
                while (true) {
                    i3 = -1;
                    if (it.hasNext()) {
                        if (it.next().t()) {
                            break;
                        } else {
                            i16++;
                        }
                    } else {
                        i16 = -1;
                        break;
                    }
                }
                Iterator<RoleGroupModel> it5 = this.allRoles.iterator();
                int i17 = 0;
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    if (Intrinsics.areEqual(it5.next().getId(), roleGroupModel.getId())) {
                        i3 = i17;
                        break;
                    }
                    i17++;
                }
                if (!roleGroupModel.s() && !roleGroupModel.v() && !roleGroupModel.t() && !roleGroupModel.u()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!b16 && (i3 <= i16 || z16)) {
                    b16 = false;
                } else {
                    b16 = true;
                }
            }
            hashMap.put(roleGroupModel.getId(), Boolean.valueOf(b16));
        }
        for (RoleLabelData roleLabelData : this.selectedRoles) {
            Boolean bool = (Boolean) hashMap.get(roleLabelData.getRoleId());
            if (bool == null) {
                booleanValue = roleLabelData.isNormalRole();
            } else {
                Intrinsics.checkNotNullExpressionValue(bool, "roleListWithDisableInfo[\u2026eId] ?: it.isNormalRole()");
                booleanValue = bool.booleanValue();
            }
            roleLabelData.setEnableModify(booleanValue);
        }
        this._rolesLiveList.postValue(this.selectedRoles);
    }

    private final void y2(List<RoleLabelData> filteredSelectedRoleData) {
        if (!this.needDisableRoleInfo) {
            this._rolesLiveList.postValue(filteredSelectedRoleData);
        } else {
            this.selectedRoles = filteredSelectedRoleData;
            x2();
        }
    }

    public final void A2(@NotNull String roleId) {
        List<RoleLabelData> mutableList;
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        List<RoleLabelData> list = this.roleCacheDataWhenDelete;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.areEqual(((RoleLabelData) obj).getRoleId(), roleId)) {
                arrayList.add(obj);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        w2(mutableList);
    }

    public final void B2(@NotNull String roleId) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        z zVar = this.mFetchAction;
        IGPSService iGPSService = this.mGPSService;
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(roleId);
        zVar.b(iGPSService, arrayList, arrayListOf, new f(roleId));
    }

    public final void C2(@NotNull List<RoleLabelData> allRoleData) {
        Intrinsics.checkNotNullParameter(allRoleData, "allRoleData");
        if (allRoleData.isEmpty()) {
            g2();
        } else {
            w2(allRoleData);
        }
    }

    public final void D2(@NotNull List<RoleGroupModel> normalRoles, @NotNull List<? extends IGProGuildRoleInfo> lvRoles) {
        boolean z16;
        int i3;
        GProRolePermission permission;
        Intrinsics.checkNotNullParameter(normalRoles, "normalRoles");
        Intrinsics.checkNotNullParameter(lvRoles, "lvRoles");
        ArrayList arrayList = new ArrayList();
        Logger.f235387a.d().d("Guild.rg.BindPermission.ViewModel", 1, "setSelectRolesCacheAfterAdd normalRoles:" + normalRoles.size() + " lvRoles:" + lvRoles.size());
        for (RoleGroupModel roleGroupModel : normalRoles) {
            String id5 = roleGroupModel.getId();
            int color = roleGroupModel.getColor();
            String name = roleGroupModel.getName();
            int roleType = roleGroupModel.getRoleType();
            IGProGuildRoleInfo lvRole = roleGroupModel.getLvRole();
            if (lvRole != null && (permission = lvRole.getPermission()) != null) {
                z16 = permission.getHasRolePermission();
            } else {
                z16 = false;
            }
            IGProGuildRoleInfo lvRole2 = roleGroupModel.getLvRole();
            if (lvRole2 != null) {
                i3 = lvRole2.getDisplayType();
            } else {
                i3 = 0;
            }
            arrayList.add(new RoleLabelData(id5, color, name, roleType, null, null, false, z16, i3, 112, null));
        }
        for (IGProGuildRoleInfo iGProGuildRoleInfo : lvRoles) {
            String roleId = iGProGuildRoleInfo.getRoleId();
            Intrinsics.checkNotNullExpressionValue(roleId, "it.roleId");
            String name2 = iGProGuildRoleInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
            String levelSimpleDsc = iGProGuildRoleInfo.getLevelSimpleDsc();
            Intrinsics.checkNotNullExpressionValue(levelSimpleDsc, "it.levelSimpleDsc");
            String levelIconUrl = iGProGuildRoleInfo.getLevelIconUrl();
            Intrinsics.checkNotNullExpressionValue(levelIconUrl, "it.levelIconUrl");
            arrayList.add(new RoleLabelData(roleId, 0, name2, 0, levelSimpleDsc, levelIconUrl, false, iGProGuildRoleInfo.getPermission().getHasRolePermission(), iGProGuildRoleInfo.getDisplayType(), 74, null));
        }
        C2(arrayList);
    }

    public final void E2(@NotNull List<RoleGroupUserUIData> users) {
        Intrinsics.checkNotNullParameter(users, "users");
        this.userCacheData = users;
        this._usersLiveList.postValue(b2(users));
        this._userTotalLiveData.postValue(Integer.valueOf(users.size()));
    }

    public final void Z1(@NotNull PermissionSwitchStatus type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this._permissionSwitchLiveData.getValue() == type) {
            return;
        }
        this.mFetchAction.c(this.mGPSService, type, new b(type));
    }

    public final void a2() {
        List<a.b> emptyList;
        List<RoleLabelData> emptyList2;
        this._userTotalLiveData.postValue(0);
        MutableLiveData<List<a.b>> mutableLiveData = this._usersLiveList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.postValue(emptyList);
        this._roleTotalLiveData.postValue(0);
        MutableLiveData<List<RoleLabelData>> mutableLiveData2 = this._rolesLiveList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData2.postValue(emptyList2);
    }

    public final void i2(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (this.needDisableRoleInfo) {
            e2();
        }
        Logger.f235387a.d().d("Guild.rg.BindPermission.ViewModel", 1, "fetchHasPermissionRoles from:" + from);
        this.mFetchAction.d(this.mGPSService, new c());
    }

    public final void j2() {
        this.mFetchAction.e(this.mGPSService, null, new d());
    }

    @NotNull
    public final RoleLabelData[] m2() {
        Collection collection;
        int collectionSizeOrDefault;
        Set set;
        ArrayList arrayList = new ArrayList();
        Collection collection2 = (List) this.rolesLiveList.getValue();
        if (collection2 == null) {
            collection = new ArrayList();
        } else {
            collection = collection2;
        }
        arrayList.addAll(collection);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((RoleLabelData) it.next()).getRoleId());
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        List<RoleLabelData> list = this.roleCacheDataWhenDelete;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (!set.contains(((RoleLabelData) obj).getRoleId())) {
                arrayList3.add(obj);
            }
        }
        arrayList.addAll(arrayList3);
        Object[] array = arrayList.toArray(new RoleLabelData[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (RoleLabelData[]) array;
    }

    @NotNull
    public final LiveData<Boolean> n2() {
        return this._endPageLivaData;
    }

    @NotNull
    public final LiveData<Integer> o2() {
        return this._lvRoleTotalSizeLiveData;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.mGPSService.deleteObserver(this.mGProObserver);
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.mGPSService = iGPSService;
        iGPSService.addObserver(this.mGProObserver);
    }

    public final void onDestroy() {
        this.mGPSService.deleteObserver(this.mGProObserver);
        AccountChangedNotifier.f214789d.d(this);
    }

    public final void onResume() {
        AccountChangedNotifier.f214789d.a(this);
    }

    @NotNull
    public final LiveData<PermissionSwitchStatus> p2() {
        return this._permissionSwitchLiveData;
    }

    @NotNull
    public final List<RoleLabelData> q2() {
        return this.roleCacheDataWhenDelete;
    }

    @NotNull
    public final LiveData<Integer> r2() {
        return this._roleTotalLiveData;
    }

    @NotNull
    public final LiveData<List<RoleLabelData>> s2() {
        return this.rolesLiveList;
    }

    @NotNull
    public final List<RoleGroupUserUIData> t2() {
        return this.userCacheData;
    }

    @NotNull
    public final LiveData<Integer> u2() {
        return this._userTotalLiveData;
    }

    @NotNull
    public final LiveData<List<a.b>> v2() {
        return this._usersLiveList;
    }

    public final void z2() {
        this._permissionSwitchLiveData.postValue(this.mFetchAction.a(this.mGPSService));
    }

    public k(@NotNull String guildId, @NotNull String channelId, @NotNull GuildBindPermissionActionFactory.FetchType fetchType, int i3, boolean z16, boolean z17, boolean z18) {
        List<RoleGroupModel> emptyList;
        List<RoleLabelData> emptyList2;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        this.guildId = guildId;
        this.channelId = channelId;
        this.fetchType = fetchType;
        this.channelType = i3;
        this.isCreatingScene = z16;
        this.isFilterLvRole = z17;
        this.needDisableRoleInfo = z18;
        MutableLiveData<List<RoleLabelData>> mutableLiveData = new MutableLiveData<>();
        this._rolesLiveList = mutableLiveData;
        LiveData<List<RoleLabelData>> map = Transformations.map(mutableLiveData, new Function() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.h
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List k26;
                k26 = k.this.k2((List) obj);
                return k26;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(_rolesLiveList, this\u2026oleLabelsIfNewFeedSquare)");
        this.rolesLiveList = map;
        this._roleTotalLiveData = new e12.e<>();
        this._usersLiveList = new MutableLiveData<>();
        this._userTotalLiveData = new e12.e<>();
        this._permissionSwitchLiveData = new e12.e<>();
        this._lvRoleTotalSizeLiveData = new e12.e<>();
        this._endPageLivaData = new e12.e<>(Boolean.FALSE);
        this.userCacheData = new ArrayList();
        this.roleCacheDataWhenDelete = new ArrayList();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.allRoles = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.selectedRoles = emptyList2;
        this.mFetchAction = GuildBindPermissionActionFactory.a(guildId, channelId, fetchType);
        e eVar = new e();
        this.mGProObserver = eVar;
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.mGPSService = iGPSService;
        iGPSService.addObserver(eVar);
        AccountChangedNotifier.f214789d.a(this);
    }
}
