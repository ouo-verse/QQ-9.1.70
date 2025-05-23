package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionTypeForRole;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.ChannelPermissionTargetForRole;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.ChannelPermissionType;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.GuildChannelSelectedData;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.PermissionForRoleRepository;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 N2\u00020\u0001:\u0001OB)\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010.\u001a\u00020#\u0012\u0006\u00100\u001a\u00020#\u0012\b\b\u0002\u00103\u001a\u00020\u0016\u00a2\u0006\u0004\bL\u0010MJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J.\u0010\u0012\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0006\u0010\u001b\u001a\u00020\u0005J\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001cJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cJ\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00103\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020#0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020#0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020#0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00105R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010<R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00160\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/ChannelPermissionEditViewModel;", "Lef1/b;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d;", "channelUIDataList", "", "r2", "o2", "l2", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "model", "p2", "list", "q2", VipFunCallConstants.KEY_GROUP, "", "newList", "currentSubChannels", ICustomDataEditor.STRING_ARRAY_PARAM_2, "d2", "Lcom/tencent/mobileqq/guild/base/repository/h;", "b2", "", "c2", "e2", "uiData", "k2", "initData", "Landroidx/lifecycle/MutableLiveData;", "f2", "Lcom/tencent/mobileqq/guild/util/cn;", "Lri1/a;", SemanticAttributes.DbSystemValues.H2, "g2", "j2", "", "channelId", "m2", "i2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", HttpMsg.MTYPE, "D", "Ljava/lang/String;", "mGuildId", "E", "mRoleId", UserInfo.SEX_FEMALE, "Z", "mReadOnly", "G", "Ljava/util/List;", "mOriginList", "H", "mAddList", "I", "mRemoveList", "J", "Landroidx/lifecycle/MutableLiveData;", "mIsSelectAllStrLivaData", "K", "Lcom/tencent/mobileqq/guild/util/cn;", "mSaveStateLiveData", "L", "mChannelListLiveData", "M", "Lcom/tencent/mobileqq/guild/base/repository/h;", "fetchRoleGroupCallback", "N", "mModifyChannelPermissionCallback", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/PermissionForRoleRepository;", "P", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/PermissionForRoleRepository;", "mPermissionForRoleRepository", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;Ljava/lang/String;Ljava/lang/String;Z)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ChannelPermissionEditViewModel extends ef1.b {

    @NotNull
    private static final Set<Integer> R;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ChannelPermissionTypeForRole mType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String mGuildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String mRoleId;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean mReadOnly;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<String> mOriginList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final List<String> mAddList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final List<String> mRemoveList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mIsSelectAllStrLivaData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final cn<ri1.a> mSaveStateLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<GuildChannelSelectedData>> mChannelListLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> fetchRoleGroupCallback;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.base.repository.h<Boolean> mModifyChannelPermissionCallback;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final PermissionForRoleRepository mPermissionForRoleRepository;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/ChannelPermissionEditViewModel$b", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable RoleGroupModel result) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (error.d()) {
                ChannelPermissionEditViewModel.this.p2(result);
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetch permission error:" + error;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.ChannelPermissionEditViewModel", 1, (String) it.next(), null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/ChannelPermissionEditViewModel$c", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lri1/a;", "error", "result", "", "b", "(Lri1/a;Ljava/lang/Boolean;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.base.repository.h<Boolean> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable Boolean result) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (!error.d()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "modify permission error:" + error;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.ChannelPermissionEditViewModel", 1, (String) it.next(), null);
                }
                ChannelPermissionEditViewModel.this.mSaveStateLiveData.setValue(error);
                return;
            }
            ChannelPermissionEditViewModel.this.mSaveStateLiveData.setValue(error);
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.rg.ChannelPermissionEditViewModel", 2, "modify permission success!");
            }
        }
    }

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 7, 2, 8});
        R = of5;
    }

    public /* synthetic */ ChannelPermissionEditViewModel(ChannelPermissionTypeForRole channelPermissionTypeForRole, String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(channelPermissionTypeForRole, str, str2, (i3 & 8) != 0 ? false : z16);
    }

    private final void a2(GuildChannelSelectedData group, List<GuildChannelSelectedData> newList, List<GuildChannelSelectedData> currentSubChannels) {
        if (group != null) {
            if (!group.getIsPostSquareCategory()) {
                newList.add(group);
                if (currentSubChannels.isEmpty()) {
                    newList.add(GuildChannelSelectedData.INSTANCE.b("\u6682\u65e0\u5b50\u9891\u9053"));
                } else {
                    newList.addAll(currentSubChannels);
                }
            }
        } else {
            List<GuildChannelSelectedData> list = currentSubChannels;
            if (!list.isEmpty()) {
                newList.addAll(list);
            }
        }
        currentSubChannels.clear();
    }

    private final com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> b2() {
        return new b();
    }

    private final com.tencent.mobileqq.guild.base.repository.h<Boolean> c2() {
        return new c();
    }

    private final void d2() {
        com.tencent.mobileqq.guild.rolegroup.model.repositories.r.f232798e.g(new FetchRoleGroupParam(this.mGuildId, this.mRoleId, true, 116), this.fetchRoleGroupCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<GuildChannelSelectedData> e2(List<GuildChannelSelectedData> list) {
        if (!this.mReadOnly) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            GuildChannelSelectedData guildChannelSelectedData = (GuildChannelSelectedData) obj;
            boolean z16 = true;
            if (guildChannelSelectedData.getType() != 1 || guildChannelSelectedData.getIsSelected() || k2(guildChannelSelectedData)) {
                z16 = false;
            }
            if (!z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean k2(GuildChannelSelectedData uiData) {
        Integer num;
        boolean contains;
        if (this.mType != ChannelPermissionTypeForRole.ApproveSpeak) {
            return false;
        }
        Set<Integer> set = R;
        IGProChannel channelInfo = uiData.getChannelInfo();
        if (channelInfo != null) {
            num = Integer.valueOf(channelInfo.getChannelType());
        } else {
            num = null;
        }
        contains = CollectionsKt___CollectionsKt.contains(set, num);
        return !contains;
    }

    private final void l2() {
        String str = this.mGuildId;
        String str2 = this.mRoleId;
        ChannelPermissionType channelPermissionType = ChannelPermissionType.ViewPermission;
        ChannelPermissionTargetForRole channelPermissionTargetForRole = new ChannelPermissionTargetForRole(str, str2, channelPermissionType);
        ChannelPermissionTypeForRole channelPermissionTypeForRole = this.mType;
        if (channelPermissionTypeForRole == ChannelPermissionTypeForRole.ApproveSpeak) {
            channelPermissionTargetForRole = new ChannelPermissionTargetForRole(this.mGuildId, this.mRoleId, ChannelPermissionType.SpeakPermission);
        } else if (channelPermissionTypeForRole == ChannelPermissionTypeForRole.ApproveVisible) {
            channelPermissionTargetForRole = new ChannelPermissionTargetForRole(this.mGuildId, this.mRoleId, channelPermissionType);
        } else if (channelPermissionTypeForRole == ChannelPermissionTypeForRole.ApproveLiveAnchor) {
            channelPermissionTargetForRole = new ChannelPermissionTargetForRole(this.mGuildId, this.mRoleId, ChannelPermissionType.LivePermission);
        } else {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str3 = "modifyChannelPermission: can not handle type[" + this.mType + "]";
            if (str3 instanceof String) {
                bVar.a().add(str3);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.ChannelPermissionEditViewModel", 1, (String) it.next(), null);
            }
        }
        com.tencent.mobileqq.guild.rolegroup.model.repositories.r.f232798e.d(channelPermissionTargetForRole, this.mAddList, this.mRemoveList, this.mModifyChannelPermissionCallback);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.rg.ChannelPermissionEditViewModel", 2, "modifyChannelPermission target:" + channelPermissionTargetForRole + " mAddList:" + this.mAddList + " mRemoveList:" + this.mRemoveList);
        }
    }

    private final void o2() {
        this.mAddList.clear();
        this.mRemoveList.clear();
        List<GuildChannelSelectedData> value = this.mChannelListLiveData.getValue();
        if (value == null) {
            return;
        }
        for (GuildChannelSelectedData guildChannelSelectedData : value) {
            if (guildChannelSelectedData.getType() != 2 && guildChannelSelectedData.getIsSelectable()) {
                if (guildChannelSelectedData.getChannelInfo() == null) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.rg.ChannelPermissionEditViewModel", 2, "data " + guildChannelSelectedData.getName() + " modifyChannelSelectedState channelInfo should not be null!");
                    }
                } else if (this.mOriginList.contains(String.valueOf(guildChannelSelectedData.getChannelInfo().getChannelId()))) {
                    if (!guildChannelSelectedData.getIsSelected()) {
                        this.mRemoveList.add(String.valueOf(guildChannelSelectedData.getChannelInfo().getChannelId()));
                    }
                } else if (guildChannelSelectedData.getIsSelected()) {
                    this.mAddList.add(String.valueOf(guildChannelSelectedData.getChannelInfo().getChannelId()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p2(RoleGroupModel model) {
        if (model != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ChannelPermissionEditViewModel$updateChannelsList$2(this, model, null), 3, null);
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.ChannelPermissionEditViewModel", 2, "updateChannelsList model is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<GuildChannelSelectedData> q2(List<GuildChannelSelectedData> list) {
        List emptyList;
        Boolean bool;
        Pair pair;
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        String str2 = this.mGuildId;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        boolean contains = emptyList.contains(str2);
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        String str3 = "";
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(str2);
        GuildChannelSelectedData guildChannelSelectedData = null;
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
        String str4 = guildDebugUtils.e().get(str2);
        if (str4 != null) {
            str3 = str4;
        }
        Intrinsics.checkNotNullExpressionValue(str3, "newFeedSquareResults.get(guildId) ?: \"\"");
        String pair2 = pair.toString();
        if (!Intrinsics.areEqual(str3, pair2)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + str2 + MsgSummary.STR_COLON + pair2);
            }
            guildDebugUtils.e().put(str2, pair2);
        }
        if (!((Boolean) pair.getFirst()).booleanValue()) {
            return list;
        }
        List<GuildChannelSelectedData> arrayList = new ArrayList<>();
        if (this.mType == ChannelPermissionTypeForRole.ApproveSpeak) {
            str = "\u53ef\u53d1\u8a00\u7684";
        } else {
            str = "\u53ef\u67e5\u770b\u7684";
        }
        arrayList.add(new GuildChannelSelectedData(3, str + "\u5e16\u5b50\u7248\u5757", false, null, false, false, 60, null));
        List<GuildChannelSelectedData> list2 = list;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (true) {
            boolean z19 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GuildChannelSelectedData guildChannelSelectedData2 = (GuildChannelSelectedData) next;
            if (guildChannelSelectedData2.getType() == 1) {
                IGProChannel channelInfo = guildChannelSelectedData2.getChannelInfo();
                if (channelInfo != null && channelInfo.getChannelType() == 7) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z19 = true;
                }
            }
            if (z19) {
                arrayList2.add(next);
            }
        }
        ArrayList<GuildChannelSelectedData> arrayList3 = new ArrayList();
        for (Object obj : list2) {
            GuildChannelSelectedData guildChannelSelectedData3 = (GuildChannelSelectedData) obj;
            if (guildChannelSelectedData3.getType() == 1) {
                IGProChannel channelInfo2 = guildChannelSelectedData3.getChannelInfo();
                if (channelInfo2 != null && channelInfo2.getChannelType() == 7) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16) {
                        arrayList3.add(obj);
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        if (arrayList2.isEmpty()) {
            arrayList.add(new GuildChannelSelectedData(4, "\u6682\u65e0\u5e16\u5b50\u7248\u5757", false, null, false, false, 60, null));
        } else {
            arrayList.addAll(arrayList2);
        }
        arrayList.add(new GuildChannelSelectedData(3, str + "\u5b50\u9891\u9053", false, null, false, false, 60, null));
        int size = arrayList.size();
        List<GuildChannelSelectedData> arrayList4 = new ArrayList<>();
        for (GuildChannelSelectedData guildChannelSelectedData4 : arrayList3) {
            if (guildChannelSelectedData4.getType() == 2) {
                a2(guildChannelSelectedData, arrayList, arrayList4);
                guildChannelSelectedData = guildChannelSelectedData4;
            } else {
                arrayList4.add(guildChannelSelectedData4);
            }
        }
        a2(guildChannelSelectedData, arrayList, arrayList4);
        if (arrayList.size() - size == 0) {
            arrayList.add(GuildChannelSelectedData.INSTANCE.b("\u6682\u65e0\u5b50\u9891\u9053"));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(List<GuildChannelSelectedData> channelUIDataList) {
        boolean z16;
        Iterator<GuildChannelSelectedData> it = channelUIDataList.iterator();
        while (true) {
            if (it.hasNext()) {
                GuildChannelSelectedData next = it.next();
                if (next.getIsSelectable() && next.getType() != 2 && !next.getIsSelected()) {
                    z16 = false;
                    break;
                }
            } else {
                z16 = true;
                break;
            }
        }
        this.mIsSelectAllStrLivaData.setValue(Boolean.valueOf(!z16));
    }

    @NotNull
    public final MutableLiveData<List<GuildChannelSelectedData>> f2() {
        return this.mChannelListLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> g2() {
        return this.mIsSelectAllStrLivaData;
    }

    @NotNull
    public final cn<ri1.a> h2() {
        return this.mSaveStateLiveData;
    }

    public final void i2() {
        boolean areEqual = Intrinsics.areEqual(this.mIsSelectAllStrLivaData.getValue(), Boolean.TRUE);
        List<GuildChannelSelectedData> value = this.mChannelListLiveData.getValue();
        if (value == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (GuildChannelSelectedData guildChannelSelectedData : value) {
            if (guildChannelSelectedData.getIsSelectable() && guildChannelSelectedData.getType() != 2) {
                arrayList.add(new GuildChannelSelectedData(guildChannelSelectedData.getType(), guildChannelSelectedData.getName(), false, guildChannelSelectedData.getChannelInfo(), guildChannelSelectedData.getIsSelectable(), areEqual, 4, null));
            } else {
                arrayList.add(guildChannelSelectedData);
            }
        }
        this.mIsSelectAllStrLivaData.setValue(Boolean.valueOf(!areEqual));
        this.mChannelListLiveData.setValue(arrayList);
    }

    public final void initData() {
        p2(com.tencent.mobileqq.guild.rolegroup.model.repositories.r.f232798e.e(new FetchRoleGroupParam(this.mGuildId, this.mRoleId, true, 0, 8, null)));
        d2();
    }

    public final boolean j2() {
        o2();
        if ((!this.mAddList.isEmpty()) || (!this.mRemoveList.isEmpty())) {
            return true;
        }
        return false;
    }

    public final void m2(@NotNull String channelId) {
        GuildChannelSelectedData guildChannelSelectedData;
        GuildChannelSelectedData guildChannelSelectedData2;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        List<GuildChannelSelectedData> value = this.mChannelListLiveData.getValue();
        if (value == null) {
            return;
        }
        TypeIntrinsics.asMutableList(value);
        Iterator<GuildChannelSelectedData> it = value.iterator();
        while (true) {
            if (it.hasNext()) {
                guildChannelSelectedData2 = it.next();
                if (guildChannelSelectedData2.getType() == 1) {
                    if (guildChannelSelectedData2.getChannelInfo() == null) {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str = "data:" + guildChannelSelectedData2.getName() + " modifyChannelSelectedState channelInfo should not be null!";
                        if (str instanceof String) {
                            bVar.a().add(str);
                        }
                        Iterator<T> it5 = bVar.a().iterator();
                        while (it5.hasNext()) {
                            Logger.f235387a.d().e("Guild.rg.ChannelPermissionEditViewModel", 1, (String) it5.next(), null);
                        }
                    } else if (Intrinsics.areEqual(channelId, String.valueOf(guildChannelSelectedData2.getChannelInfo().getChannelId()))) {
                        guildChannelSelectedData = new GuildChannelSelectedData(guildChannelSelectedData2.getType(), guildChannelSelectedData2.getName(), false, guildChannelSelectedData2.getChannelInfo(), guildChannelSelectedData2.getIsSelectable(), !guildChannelSelectedData2.getIsSelected(), 4, null);
                        break;
                    }
                }
            } else {
                guildChannelSelectedData = null;
                guildChannelSelectedData2 = null;
                break;
            }
        }
        if (guildChannelSelectedData2 != null && guildChannelSelectedData != null) {
            int indexOf = value.indexOf(guildChannelSelectedData2);
            value.remove(indexOf);
            value.add(indexOf, guildChannelSelectedData);
            r2(value);
            this.mChannelListLiveData.setValue(value);
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        String str2 = "channelId:" + channelId + " modifyChannelSelectedState error, target channel is not found";
        if (str2 instanceof String) {
            bVar2.a().add(str2);
        }
        Iterator<T> it6 = bVar2.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e("Guild.rg.ChannelPermissionEditViewModel", 1, (String) it6.next(), null);
        }
    }

    public final void n2() {
        if (!j2()) {
            return;
        }
        l2();
    }

    public ChannelPermissionEditViewModel(@NotNull ChannelPermissionTypeForRole mType, @NotNull String mGuildId, @NotNull String mRoleId, boolean z16) {
        Intrinsics.checkNotNullParameter(mType, "mType");
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        Intrinsics.checkNotNullParameter(mRoleId, "mRoleId");
        this.mType = mType;
        this.mGuildId = mGuildId;
        this.mRoleId = mRoleId;
        this.mReadOnly = z16;
        this.mOriginList = new ArrayList();
        this.mAddList = new ArrayList();
        this.mRemoveList = new ArrayList();
        this.mIsSelectAllStrLivaData = new MutableLiveData<>(Boolean.TRUE);
        this.mSaveStateLiveData = new cn<>();
        this.mChannelListLiveData = new MutableLiveData<>(new ArrayList());
        this.fetchRoleGroupCallback = b2();
        this.mModifyChannelPermissionCallback = c2();
        this.mPermissionForRoleRepository = new PermissionForRoleRepository(mGuildId, mType);
    }
}
