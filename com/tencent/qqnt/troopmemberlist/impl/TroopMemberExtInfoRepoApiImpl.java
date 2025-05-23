package com.tencent.qqnt.troopmemberlist.impl;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberIllegalInfoResult;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0080\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2a\b\u0002\u0010\t\u001a[\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0004\u0018\u0001`\u0013H\u0096\u0001J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096\u0001J]\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2@\u0010\t\u001a<\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`\u001bH\u0096\u0001Je\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2F\b\u0002\u0010\t\u001a@\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u001d\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`\u001fH\u0096\u0001J\u0080\u0001\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2a\b\u0002\u0010\t\u001a[\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0004\u0018\u0001`\u0013H\u0096\u0001Jm\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2@\u0010\t\u001a<\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`&H\u0096\u0001JR\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2+\b\u0002\u0010\t\u001a%\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010)j\u0004\u0018\u0001`*H\u0096\u0001Jk\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2L\b\u0002\u0010\t\u001aF\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0\u0010\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`.H\u0096\u0001J_\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2@\b\u0002\u0010\t\u001a:\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`1H\u0096\u0001J\u001f\u00102\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dH\u0096\u0001J\u008b\u0001\u00103\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u00104\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2L\b\u0002\u0010\t\u001aF\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`8H\u0096\u0001Js\u00109\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2F\b\u0002\u0010\t\u001a@\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020:0\u001d\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`<H\u0096\u0001Ji\u0010=\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2D\u0010\t\u001a@\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u001d\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`\u001fH\u0096\u0001Je\u0010?\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2F\b\u0002\u0010\t\u001a@\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u001d\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`\u001fH\u0096\u0001J\u0013\u0010@\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J!\u0010A\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010B\u001a\u00020CH\u0096\u0001J!\u0010D\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0011H\u0096\u0001\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/impl/TroopMemberExtInfoRepoApiImpl;", "Lcom/tencent/qqnt/troopmemberlist/ITroopMemberExtInfoRepoApi;", "()V", "fetchCanTransferTroopMember", "", "troopUin", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "", "", "uin2flagMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberFlagCallback;", "fetchMemberIllegalInfoFromCache", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;", "fetchNewTroopHeadUinList", "fetchSelfTroopLevelInfo", "Lkotlin/Function2;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "extInfo", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberExtInfoCallback;", "fetchTroopAdmin", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberUinCallback;", "fetchTroopAdminFlagEx", "fetchTroopMemberForBatch", "isMember", "flag", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonListResult;", "memberCommonListResult", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberCommonInfoCallback;", "fetchTroopMemberGameInfo", "memberUin", "Lkotlin/Function1;", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberGameInfoCallback;", "fetchTroopMemberGapInfo", "", "uin2ShuntUpTimeMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberGapInfoCallback;", "fetchTroopMemberIllegalUinList", "result", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberIllegalUinCallback;", "fetchTroopMemberNickIconInfo", "fetchTroopMemberNickName", "needRemarkFirst", "extProcessParam", "Landroid/os/Bundle;", "uin2NameMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberNickNameCallback;", "fetchTroopMemberSpecialTitle", "Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo;", "titleInfoList", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberSpecialTitleInfoCallback;", "fetchTroopMemberUin", "memberCount", "fetchTroopOwner", "preloadMemberIllegalInfoFromLocal", "updateTroopMemberHonor", "honorInfo", "", "updateTroopMemberSpecialTitle", "titleId", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopMemberExtInfoRepoApiImpl implements ITroopMemberExtInfoRepoApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopMemberExtInfoRepo $$delegate_0;

    public TroopMemberExtInfoRepoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopMemberExtInfoRepo.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchCanTransferTroopMember(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function3<? super Boolean, ? super String, ? super Map<String, Integer>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchCanTransferTroopMember(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    @Nullable
    public GroupMemberIllegalInfoResult fetchMemberIllegalInfoFromCache(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GroupMemberIllegalInfoResult) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return this.$$delegate_0.fetchMemberIllegalInfoFromCache(troopUin);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchNewTroopHeadUinList(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchNewTroopHeadUinList(troopUin);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchSelfTroopLevelInfo(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super GroupMemberExtListResult, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchSelfTroopLevelInfo(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopAdmin(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchTroopAdmin(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopAdminFlagEx(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function3<? super Boolean, ? super String, ? super Map<String, Integer>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchTroopAdminFlagEx(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberForBatch(@NotNull String troopUin, boolean isMember, @NotNull String flag, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super GroupMemberCommonListResult, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, Boolean.valueOf(isMember), flag, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.$$delegate_0.fetchTroopMemberForBatch(troopUin, isMember, flag, owner, callback);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberGameInfo(@NotNull String troopUin, @NotNull String memberUin, @Nullable LifecycleOwner owner, @Nullable Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUin, memberUin, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        this.$$delegate_0.fetchTroopMemberGameInfo(troopUin, memberUin, owner, callback);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberGapInfo(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super Map<String, Long>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchTroopMemberGapInfo(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberIllegalUinList(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super GroupMemberIllegalInfoResult, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchTroopMemberIllegalUinList(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberNickIconInfo(@NotNull String troopUin, @NotNull List<String> uinList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopUin, (Object) uinList);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        this.$$delegate_0.fetchTroopMemberNickIconInfo(troopUin, uinList);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberNickName(@NotNull String troopUin, @NotNull List<String> uinList, boolean needRemarkFirst, @Nullable Bundle extProcessParam, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super Map<String, String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, uinList, Boolean.valueOf(needRemarkFirst), extProcessParam, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        this.$$delegate_0.fetchTroopMemberNickName(troopUin, uinList, needRemarkFirst, extProcessParam, owner, callback);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberSpecialTitle(@NotNull String troopUin, @NotNull List<String> uinList, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<TroopMemberSpecialTitleInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, troopUin, uinList, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        this.$$delegate_0.fetchTroopMemberSpecialTitle(troopUin, uinList, owner, callback);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberUin(@NotNull String troopUin, int memberCount, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, troopUin, Integer.valueOf(memberCount), owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchTroopMemberUin(troopUin, memberCount, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopOwner(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchTroopOwner(troopUin, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void preloadMemberIllegalInfoFromLocal(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) troopUin);
        } else {
            this.$$delegate_0.preloadMemberIllegalInfoFromLocal(troopUin);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void updateTroopMemberHonor(@NotNull String troopUin, @NotNull String memberUin, @NotNull byte[] honorInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, troopUin, memberUin, honorInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(honorInfo, "honorInfo");
        this.$$delegate_0.updateTroopMemberHonor(troopUin, memberUin, honorInfo);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void updateTroopMemberSpecialTitle(@NotNull String troopUin, @NotNull String memberUin, int titleId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, troopUin, memberUin, Integer.valueOf(titleId));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        this.$$delegate_0.updateTroopMemberSpecialTitle(troopUin, memberUin, titleId);
    }
}
