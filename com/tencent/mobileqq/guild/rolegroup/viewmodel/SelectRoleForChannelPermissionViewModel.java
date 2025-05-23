package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.ChannelPermissionTarget;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.ChannelPermissionType;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleForChannelPermissionViewModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx1.RoleSelectItem;

@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 b2\u00020\u00012\u00020\u0002:\ncdefghijklB7\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020\u0006\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\b`\u0010aJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\u0014\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\bJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013J\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0011R\u0014\u0010\u001e\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0018008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0006048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R6\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000bj\b\u0012\u0004\u0012\u00020\t`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010:R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010:R\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u00060KR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020O008\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00180S8F\u00a2\u0006\u0006\u001a\u0004\bT\u0010UR\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00060S8F\u00a2\u0006\u0006\u001a\u0004\bW\u0010UR\u001d\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0S8F\u00a2\u0006\u0006\u001a\u0004\bY\u0010UR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00060S8F\u00a2\u0006\u0006\u001a\u0004\b[\u0010UR\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020]0\b8F\u00a2\u0006\u0006\u001a\u0004\b^\u0010<\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel;", "Lef1/b;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "result", "d2", "", ICustomDataEditor.NUMBER_PARAM_2, "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "j2", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "Lkotlin/collections/ArrayList;", "l2", "", "lvRoleIds", "", "r2", "", "k2", "o2", "Lyx1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "checked", "p2", ICustomDataEditor.STRING_PARAM_2, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "D", "channelId", "E", "I", "channelType", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$PermissionType;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$PermissionType;", "permissionType", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$SelectedType;", "G", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$SelectedType;", "selectedType", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "H", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "roleGroupRepository", "Lcom/tencent/mobileqq/guild/util/cn;", "J", "Lcom/tencent/mobileqq/guild/util/cn;", "_liveEventSubmit", "Landroidx/lifecycle/MutableLiveData;", "K", "Landroidx/lifecycle/MutableLiveData;", "_liveSelectedLvRolesCount", "value", "L", "Ljava/util/List;", "i2", "()Ljava/util/List;", "q2", "(Ljava/util/List;)V", "localSelectedRoleIds", "M", "Ljava/util/ArrayList;", "lvRolesRemote", "N", "selectedLvRoles", "P", "tempSelectedLvRoles", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic;", "selectRoleLogic", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$h;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$h;", "onSubmitChange", "Lcf1/b;", "getToastEvent", "()Lcom/tencent/mobileqq/guild/util/cn;", "toastEvent", "Landroidx/lifecycle/LiveData;", "e2", "()Landroidx/lifecycle/LiveData;", "liveEventSubmit", SemanticAttributes.DbSystemValues.H2, "liveSelectedLvRolesCount", "f2", "liveList", "g2", "liveSelectCount", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "m2", "selectedRoles", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$PermissionType;Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$SelectedType;Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;)V", ExifInterface.LATITUDE_SOUTH, "a", "b", "c", "d", "e", "PermissionType", "f", "g", "SelectedType", tl.h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SelectRoleForChannelPermissionViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: E, reason: from kotlin metadata */
    private final int channelType;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final PermissionType permissionType;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SelectedType selectedType;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final IRoleGroupListRepository roleGroupRepository;
    private final /* synthetic */ ef1.d I;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _liveEventSubmit;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _liveSelectedLvRolesCount;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private List<String> localSelectedRoleIds;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<IGProGuildRoleInfo> lvRolesRemote;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final List<String> selectedLvRoles;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final List<String> tempSelectedLvRoles;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final SelectRoleLogic selectRoleLogic;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final h onSubmitChange;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$PermissionType;", "", "(Ljava/lang/String;I)V", "ViewPermission", "SpeakPermission", "ActivityPermission", "LiveAnchorPermission", "SpeakUnlimitedPermission", "ModifyMapPermission", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum PermissionType {
        ViewPermission,
        SpeakPermission,
        ActivityPermission,
        LiveAnchorPermission,
        SpeakUnlimitedPermission,
        ModifyMapPermission
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$SelectedType;", "", "(Ljava/lang/String;I)V", "LocalSelected", "RemoteSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum SelectedType {
        LocalSelected,
        RemoteSelected
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$a;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "callback", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class a implements SelectRoleLogic.b {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SelectRoleForChannelPermissionViewModel this$0, com.tencent.mobileqq.guild.base.repository.h callback, ri1.a error, RoleGroupListModel roleGroupListModel) {
            List<RoleGroupModel> list;
            List<IGProGuildRoleInfo> c16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(error, "error");
            if (roleGroupListModel != null && (c16 = roleGroupListModel.c()) != null) {
                this$0.lvRolesRemote.clear();
                this$0.lvRolesRemote.addAll(c16);
                for (IGProGuildRoleInfo iGProGuildRoleInfo : this$0.lvRolesRemote) {
                    if (this$0.i2().contains(iGProGuildRoleInfo.getRoleId())) {
                        List list2 = this$0.selectedLvRoles;
                        String roleId = iGProGuildRoleInfo.getRoleId();
                        Intrinsics.checkNotNullExpressionValue(roleId, "levelRole.roleId");
                        list2.add(roleId);
                    }
                }
            }
            RoleGroupListModel d26 = this$0.d2(roleGroupListModel);
            if (d26 != null) {
                list = d26.d();
            } else {
                list = null;
            }
            callback.a(error, list);
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.b
        public void a(@NotNull final com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            IRoleGroupListRepository iRoleGroupListRepository = SelectRoleForChannelPermissionViewModel.this.roleGroupRepository;
            FetchRoleGroupParam fetchRoleGroupParam = new FetchRoleGroupParam(SelectRoleForChannelPermissionViewModel.this.guildId, null, false, 113, 6, null);
            final SelectRoleForChannelPermissionViewModel selectRoleForChannelPermissionViewModel = SelectRoleForChannelPermissionViewModel.this;
            iRoleGroupListRepository.h(fetchRoleGroupParam, new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.q
                @Override // com.tencent.mobileqq.guild.base.repository.h
                public final void a(ri1.a aVar, Object obj) {
                    SelectRoleForChannelPermissionViewModel.a.c(SelectRoleForChannelPermissionViewModel.this, callback, aVar, (RoleGroupListModel) obj);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ2\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$c;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$e;", "", "", "addRoles", "removeRoles", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "callback", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class c implements SelectRoleLogic.e {
        public c() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.e
        public void a(@NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
            Set mutableSet;
            List<String> list;
            Intrinsics.checkNotNullParameter(addRoles, "addRoles");
            Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
            Intrinsics.checkNotNullParameter(callback, "callback");
            mutableSet = CollectionsKt___CollectionsKt.toMutableSet(SelectRoleForChannelPermissionViewModel.this.i2());
            mutableSet.addAll(addRoles);
            mutableSet.removeAll(removeRoles);
            SelectRoleForChannelPermissionViewModel selectRoleForChannelPermissionViewModel = SelectRoleForChannelPermissionViewModel.this;
            list = CollectionsKt___CollectionsKt.toList(mutableSet);
            selectRoleForChannelPermissionViewModel.q2(list);
            ri1.a f16 = ri1.a.f();
            Intrinsics.checkNotNullExpressionValue(f16, "ok()");
            callback.a(f16, Boolean.TRUE);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$d;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "callback", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class d implements SelectRoleLogic.b {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$d$a", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class a implements com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> f232864a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ SelectRoleForChannelPermissionViewModel f232865b;

            a(com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> hVar, SelectRoleForChannelPermissionViewModel selectRoleForChannelPermissionViewModel) {
                this.f232864a = hVar;
                this.f232865b = selectRoleForChannelPermissionViewModel;
            }

            @Override // com.tencent.mobileqq.guild.base.repository.h
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull ri1.a error, @Nullable RoleGroupListModel result) {
                boolean z16;
                Set set;
                List<RoleGroupModel> list;
                Intrinsics.checkNotNullParameter(error, "error");
                if (!error.d()) {
                    com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> hVar = this.f232864a;
                    if (result != null) {
                        list = result.d();
                    } else {
                        list = null;
                    }
                    hVar.a(error, list);
                    return;
                }
                if (result != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    RoleGroupListModel d26 = this.f232865b.d2(result);
                    Intrinsics.checkNotNull(d26);
                    set = CollectionsKt___CollectionsKt.toSet(this.f232865b.i2());
                    List<RoleGroupModel> d16 = d26.d();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : d16) {
                        if (set.contains(((RoleGroupModel) obj).getId())) {
                            arrayList.add(obj);
                        }
                    }
                    this.f232864a.a(error, arrayList);
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public d() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.b
        public void a(@NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.h(new FetchRoleGroupParam(SelectRoleForChannelPermissionViewModel.this.guildId, null, false, 114, 6, null), new a(callback, SelectRoleForChannelPermissionViewModel.this));
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$e;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$c;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "role", "", "isSelect", "", "allRoles", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class e implements SelectRoleLogic.c {
        public e() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.c
        public boolean a(@NotNull RoleGroupModel role, boolean isSelect, @NotNull List<RoleGroupModel> allRoles) {
            boolean z16;
            int i3;
            boolean z17;
            Intrinsics.checkNotNullParameter(role, "role");
            Intrinsics.checkNotNullParameter(allRoles, "allRoles");
            boolean z18 = true;
            if (SelectRoleForChannelPermissionViewModel.this.selectedType == SelectedType.LocalSelected) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean c16 = dy1.b.c(role, z16, SelectRoleForChannelPermissionViewModel.this.permissionType);
            if (ch.g0(SelectRoleForChannelPermissionViewModel.this.guildId)) {
                Iterator<RoleGroupModel> it = allRoles.iterator();
                int i16 = 0;
                while (true) {
                    i3 = -1;
                    if (it.hasNext()) {
                        if (it.next().t()) {
                            break;
                        }
                        i16++;
                    } else {
                        i16 = -1;
                        break;
                    }
                }
                Iterator<RoleGroupModel> it5 = allRoles.iterator();
                int i17 = 0;
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    if (Intrinsics.areEqual(it5.next().getId(), role.getId())) {
                        i3 = i17;
                        break;
                    }
                    i17++;
                }
                if (!role.s() && !role.v() && !role.t() && !role.u()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!c16 && (i3 <= i16 || z17)) {
                    z18 = false;
                }
                return z18;
            }
            return c16;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ2\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$f;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$e;", "", "", "addRolesParam", "removeRoles", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "callback", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class f implements SelectRoleLogic.e {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f232868a;

            static {
                int[] iArr = new int[PermissionType.values().length];
                try {
                    iArr[PermissionType.ViewPermission.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PermissionType.SpeakPermission.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PermissionType.LiveAnchorPermission.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PermissionType.SpeakUnlimitedPermission.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[PermissionType.ActivityPermission.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[PermissionType.ModifyMapPermission.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f232868a = iArr;
            }
        }

        public f() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.e
        public void a(@NotNull List<String> addRolesParam, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
            Intrinsics.checkNotNullParameter(addRolesParam, "addRolesParam");
            Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(addRolesParam);
            arrayList.addAll(SelectRoleForChannelPermissionViewModel.this.tempSelectedLvRoles);
            if ((!arrayList.isEmpty()) && (!removeRoles.isEmpty())) {
                removeRoles = new ArrayList<>();
            }
            switch (a.f232868a[SelectRoleForChannelPermissionViewModel.this.permissionType.ordinal()]) {
                case 1:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.b(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.ViewPermission), arrayList, removeRoles, callback);
                    return;
                case 2:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.b(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.SpeakPermission), arrayList, removeRoles, callback);
                    return;
                case 3:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.b(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.LivePermission), arrayList, removeRoles, callback);
                    return;
                case 4:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.m(SelectRoleForChannelPermissionViewModel.this.guildId, arrayList, removeRoles, callback);
                    return;
                case 5:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.b(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.ActivityPermission), arrayList, removeRoles, callback);
                    return;
                case 6:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.b(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.ModifyMapPermission), arrayList, removeRoles, callback);
                    return;
                default:
                    return;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$g;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "callback", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class g implements SelectRoleLogic.b {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f232870a;

            static {
                int[] iArr = new int[PermissionType.values().length];
                try {
                    iArr[PermissionType.ViewPermission.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PermissionType.SpeakPermission.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PermissionType.LiveAnchorPermission.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PermissionType.SpeakUnlimitedPermission.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[PermissionType.ActivityPermission.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[PermissionType.ModifyMapPermission.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f232870a = iArr;
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$g$b", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class b implements com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> f232871a;

            b(com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> hVar) {
                this.f232871a = hVar;
            }

            @Override // com.tencent.mobileqq.guild.base.repository.h
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull ri1.a error, @Nullable RoleGroupListModel result) {
                List<RoleGroupModel> emptyList;
                Intrinsics.checkNotNullParameter(error, "error");
                com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> hVar = this.f232871a;
                if (result == null || (emptyList = result.d()) == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                hVar.a(error, emptyList);
            }
        }

        public g() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.b
        public void a(@NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            switch (a.f232870a[SelectRoleForChannelPermissionViewModel.this.permissionType.ordinal()]) {
                case 1:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.c(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.ViewPermission), callback);
                    return;
                case 2:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.c(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.SpeakPermission), callback);
                    return;
                case 3:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.c(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.LivePermission), callback);
                    return;
                case 4:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.k(SelectRoleForChannelPermissionViewModel.this.guildId, true, new b(callback));
                    return;
                case 5:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.c(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.ActivityPermission), callback);
                    return;
                case 6:
                    SelectRoleForChannelPermissionViewModel.this.roleGroupRepository.c(new ChannelPermissionTarget(SelectRoleForChannelPermissionViewModel.this.guildId, SelectRoleForChannelPermissionViewModel.this.channelId, ChannelPermissionType.ModifyMapPermission), callback);
                    return;
                default:
                    return;
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel$h;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$d;", "Lri1/a;", "error", "result", "", "b", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleForChannelPermissionViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class h implements com.tencent.mobileqq.guild.base.repository.h<List<? extends SelectRoleLogic.RoleSelectOperation>> {
        public h() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable List<SelectRoleLogic.RoleSelectOperation> result) {
            Intrinsics.checkNotNullParameter(error, "error");
            boolean z16 = true;
            Logger.f235387a.d().i("Guild.rg.GuildBindPermission.SelectRoleForChannelPermissionViewModel", 1, "onResult error: " + error + ", result: " + result);
            int i3 = error.f431477a;
            if (i3 != 10023 && i3 != 180010) {
                if (!error.d()) {
                    SelectRoleForChannelPermissionViewModel.this.getToastEvent().setValue(new cf1.b(error.f431477a, cb.d(error.f431478b, QQGuildUIUtil.r(R.string.f15013146))));
                    SelectRoleForChannelPermissionViewModel.this._liveEventSubmit.setValue(Boolean.FALSE);
                    return;
                }
                if (result == null) {
                    z16 = false;
                }
                if (z16) {
                    SelectRoleForChannelPermissionViewModel.this.getToastEvent().setValue(new cf1.b(error.f431477a, QQGuildUIUtil.r(R.string.f141030fk)));
                    SelectRoleForChannelPermissionViewModel.this._liveEventSubmit.setValue(Boolean.TRUE);
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            SelectRoleForChannelPermissionViewModel.this.getToastEvent().setValue(new cf1.b(error.f431477a, error.f431478b));
            SelectRoleForChannelPermissionViewModel.this._liveEventSubmit.setValue(Boolean.FALSE);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class i {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232873a;

        static {
            int[] iArr = new int[SelectedType.values().length];
            try {
                iArr[SelectedType.LocalSelected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectedType.RemoteSelected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f232873a = iArr;
        }
    }

    public SelectRoleForChannelPermissionViewModel(@NotNull String guildId, @NotNull String channelId, int i3, @NotNull PermissionType permissionType, @NotNull SelectedType selectedType, @NotNull IRoleGroupListRepository roleGroupRepository) {
        List<String> emptyList;
        Pair pair;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
        Intrinsics.checkNotNullParameter(roleGroupRepository, "roleGroupRepository");
        this.guildId = guildId;
        this.channelId = channelId;
        this.channelType = i3;
        this.permissionType = permissionType;
        this.selectedType = selectedType;
        this.roleGroupRepository = roleGroupRepository;
        this.I = new ef1.d();
        this._liveEventSubmit = new cn<>();
        this._liveSelectedLvRolesCount = new MutableLiveData<>();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.localSelectedRoleIds = emptyList;
        this.lvRolesRemote = new ArrayList<>();
        this.selectedLvRoles = new ArrayList();
        this.tempSelectedLvRoles = new ArrayList();
        this.onSubmitChange = new h();
        int i16 = i.f232873a[selectedType.ordinal()];
        if (i16 != 1) {
            if (i16 == 2) {
                pair = TuplesKt.to(new g(), new f());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            pair = TuplesKt.to(new d(), new c());
        }
        this.selectRoleLogic = new SelectRoleLogic(new a(), (SelectRoleLogic.b) pair.component1(), (SelectRoleLogic.e) pair.component2(), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List P1(SelectRoleForChannelPermissionViewModel this$0, List roleList) {
        List emptyList;
        Boolean bool;
        Pair pair;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z18 = !ch.x0();
        String str = this$0.guildId;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        boolean contains = emptyList.contains(str);
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
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
        boolean booleanValue = ((Boolean) pair.getFirst()).booleanValue();
        Intrinsics.checkNotNullExpressionValue(roleList, "roleList");
        ArrayList arrayList = new ArrayList();
        Iterator it = roleList.iterator();
        while (true) {
            boolean z19 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RoleSelectItem roleSelectItem = (RoleSelectItem) next;
            if (roleSelectItem.getIsRemoteSelected() && roleSelectItem.getRole().getIsSortableForBackend() && !roleSelectItem.getRole().u() && !roleSelectItem.getRole().t()) {
                z19 = true;
            }
            if (!z19) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            RoleSelectItem roleSelectItem2 = (RoleSelectItem) obj;
            if (z18 && roleSelectItem2.getRole().w()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!((RoleSelectItem) obj2).getRole().C()) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList3) {
            RoleSelectItem roleSelectItem3 = (RoleSelectItem) obj3;
            if (booleanValue && this$0.channelType == 7 && roleSelectItem3.getRole().getRoleType() == 7) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer Q1(SelectRoleForChannelPermissionViewModel this$0, List roleList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(roleList, "roleList");
        ArrayList arrayList = new ArrayList();
        Iterator it = roleList.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RoleSelectItem roleSelectItem = (RoleSelectItem) next;
            if (roleSelectItem.getIsSelect() && roleSelectItem.getIsEnable()) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        Integer value = this$0.h2().getValue();
        if (value == null) {
            value = 0;
        }
        return Integer.valueOf(size + value.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoleGroupListModel d2(RoleGroupListModel result) {
        List emptyList;
        Boolean bool;
        Pair pair;
        IGProChannelInfo B = ch.B(this.channelId);
        boolean z16 = true;
        if (B == null) {
            Logger.f235387a.d().i("Guild.rg.GuildBindPermission.SelectRoleForChannelPermissionViewModel", 1, "getFixedModel, channelId(" + this.channelId + ") is invalid");
            return result;
        }
        if (B.getType() != 7) {
            z16 = false;
        }
        if (z16) {
            String str = this.guildId;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean contains = emptyList.contains(str);
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
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
                if (result == null) {
                    return null;
                }
                return result.a();
            }
        }
        return result;
    }

    @NotNull
    public final LiveData<Boolean> e2() {
        return this._liveEventSubmit;
    }

    @NotNull
    public final LiveData<List<RoleSelectItem>> f2() {
        LiveData<List<RoleSelectItem>> map = Transformations.map(this.selectRoleLogic.q(), new Function() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.o
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List P1;
                P1 = SelectRoleForChannelPermissionViewModel.P1(SelectRoleForChannelPermissionViewModel.this, (List) obj);
                return P1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(selectRoleLogic.live\u2026ATEGORY_ADMIN }\n        }");
        return map;
    }

    @NotNull
    public final LiveData<Integer> g2() {
        LiveData<Integer> map = Transformations.map(f2(), new Function() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.p
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer Q1;
                Q1 = SelectRoleForChannelPermissionViewModel.Q1(SelectRoleForChannelPermissionViewModel.this, (List) obj);
                return Q1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(liveList) { roleList\u2026edLvRolesCount.value?:0)}");
        return map;
    }

    @NotNull
    public cn<cf1.b> getToastEvent() {
        return this.I.a();
    }

    @NotNull
    public final LiveData<Integer> h2() {
        return this._liveSelectedLvRolesCount;
    }

    @NotNull
    public final List<String> i2() {
        return this.localSelectedRoleIds;
    }

    @NotNull
    public final List<IGProGuildRoleInfo> j2() {
        boolean z16;
        ArrayList<IGProGuildRoleInfo> arrayList = this.lvRolesRemote;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            IGProGuildRoleInfo iGProGuildRoleInfo = (IGProGuildRoleInfo) obj;
            if (!this.selectedLvRoles.contains(iGProGuildRoleInfo.getRoleId()) && !this.tempSelectedLvRoles.contains(iGProGuildRoleInfo.getRoleId())) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    @NotNull
    public final List<String> k2() {
        return this.tempSelectedLvRoles;
    }

    @NotNull
    public final ArrayList<RoleLabelData> l2() {
        int collectionSizeOrDefault;
        ArrayList<IGProGuildRoleInfo> arrayList = this.lvRolesRemote;
        ArrayList<IGProGuildRoleInfo> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (this.selectedLvRoles.contains(((IGProGuildRoleInfo) obj).getRoleId())) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList<RoleLabelData> arrayList3 = new ArrayList<>(collectionSizeOrDefault);
        for (IGProGuildRoleInfo iGProGuildRoleInfo : arrayList2) {
            String roleId = iGProGuildRoleInfo.getRoleId();
            Intrinsics.checkNotNullExpressionValue(roleId, "it.roleId");
            String name = iGProGuildRoleInfo.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            String levelSimpleDsc = iGProGuildRoleInfo.getLevelSimpleDsc();
            Intrinsics.checkNotNullExpressionValue(levelSimpleDsc, "it.levelSimpleDsc");
            String levelIconUrl = iGProGuildRoleInfo.getLevelIconUrl();
            Intrinsics.checkNotNullExpressionValue(levelIconUrl, "it.levelIconUrl");
            arrayList3.add(new RoleLabelData(roleId, 0, name, 0, levelSimpleDsc, levelIconUrl, false, false, 0, 458, null));
        }
        return arrayList3;
    }

    @NotNull
    public final List<RoleGroupModel> m2() {
        return this.selectRoleLogic.v();
    }

    public final int n2() {
        boolean z16;
        int size = this.tempSelectedLvRoles.size() + 0;
        List<RoleSelectItem> value = this.selectRoleLogic.q().getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                RoleSelectItem roleSelectItem = (RoleSelectItem) obj;
                if (roleSelectItem.getIsSelect() && roleSelectItem.getIsEnable() && !roleSelectItem.getIsRemoteSelected()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            return size + arrayList.size();
        }
        return size;
    }

    public final void o2() {
        this.selectRoleLogic.x();
    }

    public final void p2(@NotNull RoleSelectItem item, boolean checked) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.selectRoleLogic.y(item.getRole().getId(), checked);
    }

    public final void q2(@NotNull List<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.localSelectedRoleIds = value;
        this.selectRoleLogic.m();
    }

    public final void r2(@NotNull List<String> lvRoleIds) {
        Intrinsics.checkNotNullParameter(lvRoleIds, "lvRoleIds");
        Logger.f235387a.d().d("Guild.rg.GuildBindPermission.SelectRoleForChannelPermissionViewModel", 1, "setSelectedLvRoles lvRoles:" + lvRoleIds.size());
        this.tempSelectedLvRoles.clear();
        this.tempSelectedLvRoles.addAll(lvRoleIds);
        this._liveSelectedLvRolesCount.postValue(Integer.valueOf(lvRoleIds.size()));
    }

    public final void s2() {
        SelectRoleLogic.B(this.selectRoleLogic, this.onSubmitChange, null, 2, null);
    }
}
