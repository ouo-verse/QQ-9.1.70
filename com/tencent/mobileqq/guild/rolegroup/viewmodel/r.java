package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx1.RoleSelectItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0006@ABCDEB'\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0003J\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0003R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u00060)R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0!8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b018F\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u001d\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t05018F\u00a2\u0006\u0006\u001a\u0004\b6\u00103R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u000208018F\u00a2\u0006\u0006\u001a\u0004\b9\u00103R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b018F\u00a2\u0006\u0006\u001a\u0004\b;\u00103\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r;", "Lef1/b;", "", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "result", "Q1", "Z1", "Lyx1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "checked", "b2", "c2", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "D", "P1", "channelId", "E", "X1", "targetTinyId", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "W1", "()Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "roleGroupRepository", "Lcom/tencent/mobileqq/guild/util/cn;", "H", "Lcom/tencent/mobileqq/guild/util/cn;", "_liveEventSubmit", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic;", "I", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic;", "selectRoleLogic", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r$f;", "J", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r$f;", "onSubmitChange", "Lcf1/b;", "getToastEvent", "()Lcom/tencent/mobileqq/guild/util/cn;", "toastEvent", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "liveEventSubmit", "", "T1", "liveList", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$RunningState;", "U1", "liveRunningState", "S1", "liveIsSelectRoleChanged", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;)V", "K", "a", "b", "c", "d", "e", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class r extends ef1.b {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String targetTinyId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final IRoleGroupListRepository roleGroupRepository;
    private final /* synthetic */ ef1.d G;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _liveEventSubmit;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final SelectRoleLogic selectRoleLogic;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final f onSubmitChange;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r$a;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "callback", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class a implements SelectRoleLogic.b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/r$a$a", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.rolegroup.viewmodel.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7888a implements com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ r f233017a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> f233018b;

            C7888a(r rVar, com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> hVar) {
                this.f233017a = rVar;
                this.f233018b = hVar;
            }

            @Override // com.tencent.mobileqq.guild.base.repository.h
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull ri1.a error, @Nullable RoleGroupListModel result) {
                ArrayList arrayList;
                List<RoleGroupModel> d16;
                Intrinsics.checkNotNullParameter(error, "error");
                RoleGroupListModel Q1 = this.f233017a.Q1(result);
                com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> hVar = this.f233018b;
                if (Q1 != null && (d16 = Q1.d()) != null) {
                    arrayList = new ArrayList();
                    for (Object obj : d16) {
                        if (!((RoleGroupModel) obj).C()) {
                            arrayList.add(obj);
                        }
                    }
                } else {
                    arrayList = null;
                }
                hVar.a(error, arrayList);
                if (!error.d()) {
                    this.f233017a.getToastEvent().setValue(new cf1.b(error.f431477a, cb.d(error.f431478b, QQGuildUIUtil.r(R.string.f15014147))));
                }
            }
        }

        public a() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.b
        public void a(@NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            r.this.getRoleGroupRepository().h(new FetchRoleGroupParam(r.this.getGuildId(), null, false, 115, 6, null), new C7888a(r.this, callback));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r$b;", "", "", "guildId", "", "d", "tinyId", "c", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.viewmodel.r$b, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(String tinyId) {
            return Intrinsics.areEqual(((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId(), tinyId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(String guildId) {
            IGProGuildInfo guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(guildId);
            if (guildInfo == null || guildInfo.getUserType() != 2) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r$c;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$c;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "role", "", "isSelect", "", "allRoles", "a", "Z", "hasRoleNotAccessible", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class c implements SelectRoleLogic.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean hasRoleNotAccessible;

        public c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
        
            if (r6.c(r3.f233020b.getTargetTinyId()) == false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
        
            if (r4.getRolePermission().getIsAccessibleInList() != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00c3, code lost:
        
            if (r6 == false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00cf, code lost:
        
            if (r3.hasRoleNotAccessible == false) goto L11;
         */
        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(@NotNull RoleGroupModel role, boolean isSelect, @NotNull List<RoleGroupModel> allRoles) {
            boolean isAccessibleInList;
            boolean z16;
            boolean z17;
            boolean z18;
            String str;
            boolean z19;
            boolean isAccessibleInList2;
            Intrinsics.checkNotNullParameter(role, "role");
            Intrinsics.checkNotNullParameter(allRoles, "allRoles");
            boolean z26 = true;
            if (!role.v()) {
                if (role.s()) {
                    Companion companion = r.INSTANCE;
                    if (companion.d(r.this.getGuildId())) {
                    }
                } else if (role.t()) {
                    if (r.this.getChannelId().length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        IRuntimeService S0 = ch.S0(IGPSService.class, "");
                        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
                        IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(r.this.getChannelId());
                        if (channelInfo != null) {
                            str = channelInfo.getCategoryName();
                        } else {
                            str = null;
                        }
                        if (str != null && str.length() != 0) {
                            z19 = false;
                        } else {
                            z19 = true;
                        }
                        if (!z19) {
                        }
                    }
                } else if (role.u()) {
                    if (r.this.getChannelId().length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && role.getRolePermission().getIsAccessibleInList()) {
                        IGProChannelInfo B = ch.B(r.this.getChannelId());
                        if (B != null && B.isHiddenPostChannel()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                    }
                } else if (!role.w()) {
                    isAccessibleInList = role.getRolePermission().getIsAccessibleInList();
                }
                if (role.u() && !role.t()) {
                    isAccessibleInList2 = isAccessibleInList;
                } else {
                    isAccessibleInList2 = role.getRolePermission().getIsAccessibleInList();
                }
                if (!this.hasRoleNotAccessible && (!isSelect || isAccessibleInList2)) {
                    z26 = false;
                }
                this.hasRoleNotAccessible = z26;
                return isAccessibleInList;
            }
            isAccessibleInList = false;
            if (role.u()) {
            }
            isAccessibleInList2 = role.getRolePermission().getIsAccessibleInList();
            if (!this.hasRoleNotAccessible) {
                z26 = false;
            }
            this.hasRoleNotAccessible = z26;
            return isAccessibleInList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ2\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r$d;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$e;", "", "", "addRoles", "removeRoles", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "callback", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class d implements SelectRoleLogic.e {
        public d() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.e
        public void a(@NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
            ArrayList arrayList;
            String l3;
            Intrinsics.checkNotNullParameter(addRoles, "addRoles");
            Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (addRoles.contains("1")) {
                arrayList = new ArrayList();
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : removeRoles) {
                    if (!Intrinsics.areEqual((String) obj, "1")) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = arrayList2;
            }
            String str = "";
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(r.this.getChannelId());
            if (channelInfo != null && (l3 = Long.valueOf(channelInfo.getCategoryId()).toString()) != null) {
                str = l3;
            }
            r.this.getRoleGroupRepository().l(new GuildTarget(r.this.getGuildId(), r.this.getChannelId(), str), r.this.getTargetTinyId(), addRoles, arrayList, callback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r$e;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "callback", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class e implements SelectRoleLogic.b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/r$e$a", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class a implements com.tencent.mobileqq.guild.base.repository.h<List<? extends RoleGroupModel>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> f233023a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ r f233024b;

            a(com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> hVar, r rVar) {
                this.f233023a = hVar;
                this.f233024b = rVar;
            }

            @Override // com.tencent.mobileqq.guild.base.repository.h
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull ri1.a error, @Nullable List<RoleGroupModel> result) {
                Intrinsics.checkNotNullParameter(error, "error");
                this.f233023a.a(error, result);
                if (!error.d()) {
                    this.f233024b.getToastEvent().setValue(new cf1.b(error.f431477a, cb.d(error.f431478b, QQGuildUIUtil.r(R.string.f15014147))));
                }
            }
        }

        public e() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic.b
        public void a(@NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            r.this.getRoleGroupRepository().n(new GuildTarget(r.this.getGuildId(), r.this.getChannelId(), null, 4, null), r.this.getTargetTinyId(), new a(callback, r.this));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r$f;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$d;", "Lri1/a;", "error", "result", "", "b", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class f implements com.tencent.mobileqq.guild.base.repository.h<List<? extends SelectRoleLogic.RoleSelectOperation>> {
        public f() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable List<SelectRoleLogic.RoleSelectOperation> result) {
            Object obj;
            Intrinsics.checkNotNullParameter(error, "error");
            boolean z16 = true;
            if (!error.d()) {
                r.this.getToastEvent().setValue(new cf1.b(error.f431477a, cb.d(error.f431478b, QQGuildUIUtil.r(R.string.f1501714_))));
                return;
            }
            if (result == null) {
                z16 = false;
            }
            if (z16) {
                r.this.getToastEvent().setValue(new cf1.b(error.f431477a, QQGuildUIUtil.r(R.string.f141030fk)));
                r.this._liveEventSubmit.setValue(Boolean.TRUE);
                Iterator<T> it = result.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((SelectRoleLogic.RoleSelectOperation) obj).getRoleId(), "2")) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                SelectRoleLogic.RoleSelectOperation roleSelectOperation = (SelectRoleLogic.RoleSelectOperation) obj;
                if (roleSelectOperation != null) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.rg.SelectRoleForUserViewModel", 2, "[submitChanges] notify admin change " + roleSelectOperation);
                    }
                    com.tencent.mobileqq.guild.setting.mute.c.W(r.this.getGuildId(), r.this.getTargetTinyId(), roleSelectOperation.getIsSelect());
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public r(@NotNull String guildId, @NotNull String channelId, @NotNull String targetTinyId, @NotNull IRoleGroupListRepository roleGroupRepository) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(targetTinyId, "targetTinyId");
        Intrinsics.checkNotNullParameter(roleGroupRepository, "roleGroupRepository");
        this.guildId = guildId;
        this.channelId = channelId;
        this.targetTinyId = targetTinyId;
        this.roleGroupRepository = roleGroupRepository;
        this.G = new ef1.d();
        this._liveEventSubmit = new cn<>();
        this.selectRoleLogic = new SelectRoleLogic(new a(), new e(), new d(), new c());
        this.onSubmitChange = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoleGroupListModel Q1(RoleGroupListModel result) {
        List emptyList;
        Boolean bool;
        Pair pair;
        IGProChannelInfo B = ch.B(this.channelId);
        boolean z16 = true;
        if (B == null) {
            Logger.f235387a.d().i("Guild.rg.SelectRoleForUserViewModel", 1, "getFixedModel, channelId(" + getChannelId() + ") is invalid");
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

    private final void a2() {
        int collectionSizeOrDefault;
        List<String> u16 = this.selectRoleLogic.u();
        ArrayList arrayList = new ArrayList();
        List<String> list = u16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(new SelectRoleLogic.RoleSelectOperation((String) it.next(), false));
        }
        arrayList.addAll(arrayList2);
        arrayList.add(new SelectRoleLogic.RoleSelectOperation("1", true));
        this.selectRoleLogic.z(arrayList);
    }

    @NotNull
    /* renamed from: P1, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this._liveEventSubmit;
    }

    @NotNull
    public final LiveData<Boolean> S1() {
        return this.selectRoleLogic.o();
    }

    @NotNull
    public final LiveData<List<RoleSelectItem>> T1() {
        return this.selectRoleLogic.q();
    }

    @NotNull
    public final LiveData<SelectRoleLogic.RunningState> U1() {
        return this.selectRoleLogic.r();
    }

    @NotNull
    /* renamed from: W1, reason: from getter */
    public final IRoleGroupListRepository getRoleGroupRepository() {
        return this.roleGroupRepository;
    }

    @NotNull
    /* renamed from: X1, reason: from getter */
    public final String getTargetTinyId() {
        return this.targetTinyId;
    }

    public final void Z1() {
        this.selectRoleLogic.x();
    }

    public final void b2(@NotNull RoleSelectItem item, boolean checked) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getRole().w()) {
            if (checked) {
                a2();
            }
        } else {
            this.selectRoleLogic.y(item.a(), checked);
            List<String> u16 = this.selectRoleLogic.u();
            if (u16.size() > 1 && u16.contains("1")) {
                this.selectRoleLogic.y("1", false);
            }
        }
    }

    public final void c2() {
        SelectRoleLogic.B(this.selectRoleLogic, this.onSubmitChange, null, 2, null);
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public cn<cf1.b> getToastEvent() {
        return this.G.a();
    }
}
