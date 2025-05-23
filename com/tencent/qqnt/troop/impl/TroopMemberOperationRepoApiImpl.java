package com.tencent.qqnt.troop.impl;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.qqnt.bean.InviteToTroopParam;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troop.TroopMemberOperationRepo;
import com.tencent.qqnt.troop.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J?\u0010\u0011\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J-\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J!\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0001J9\u0010\u0013\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0096\u0001JK\u0010\u0013\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0096\u0001JA\u0010\u001d\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0096\u0001\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopMemberOperationRepoApiImpl;", "Lcom/tencent/qqnt/troop/ITroopMemberOperationRepoApi;", "Lcom/tencent/qqnt/bean/b;", "param", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "from", "Lcom/tencent/qqnt/troop/c;", "asyncCallback", "", "deleteTroopMember", "groupCode", "", "Lcom/tencent/mobileqq/troop/data/TroopCreateInfo$a;", "invitedMemberList", "Lcom/tencent/qqnt/troop/i;", "inviteMembersToGroup", "Lcom/tencent/qqnt/bean/InviteToTroopParam;", "inviteToGroup", "", "securityPass", "memberUid", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "invitedUidList", "troopUin", "", "gagTimeStamp", "setMemberShutUp", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberOperationRepoApiImpl implements ITroopMemberOperationRepoApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopMemberOperationRepo $$delegate_0;

    public TroopMemberOperationRepoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopMemberOperationRepo.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void deleteTroopMember(@NotNull com.tencent.qqnt.bean.b param, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable com.tencent.qqnt.troop.c asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, param, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.deleteTroopMember(param, owner, from, asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteMembersToGroup(@Nullable String groupCode, @Nullable List<? extends TroopCreateInfo.a> invitedMemberList, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, groupCode, invitedMemberList, owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.inviteMembersToGroup(groupCode, invitedMemberList, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteToGroup(@NotNull InviteToTroopParam param, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, param, owner, from, asyncCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.inviteToGroup(param, owner, from, asyncCallback);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void setMemberShutUp(@Nullable String troopUin, @Nullable String memberUid, long gagTimeStamp, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, memberUid, Long.valueOf(gagTimeStamp), owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.setMemberShutUp(troopUin, memberUid, gagTimeStamp, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteToGroup(@NotNull InviteToTroopParam param, @NotNull String from, boolean securityPass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, param, from, Boolean.valueOf(securityPass));
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.inviteToGroup(param, from, securityPass);
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteToGroup(@Nullable String groupCode, @Nullable String memberUid, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, groupCode, memberUid, owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.inviteToGroup(groupCode, memberUid, owner, from, asyncCallback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopMemberOperationRepoApi
    public void inviteToGroup(@Nullable String groupCode, @Nullable ArrayList<String> invitedUidList, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable i asyncCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, groupCode, invitedUidList, owner, from, asyncCallback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.inviteToGroup(groupCode, invitedUidList, owner, from, asyncCallback);
        }
    }
}
