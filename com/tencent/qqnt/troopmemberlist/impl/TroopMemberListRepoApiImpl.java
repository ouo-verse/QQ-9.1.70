package com.tencent.qqnt.troopmemberlist.impl;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.qqnt.troopmemberlist.f;
import com.tencent.qqnt.troopmemberlist.g;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b=\u0010>J7\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001JA\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000eH\u0096\u0001JA\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J7\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001J7\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001J\\\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aH\u0096\u0001JR\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aH\u0096\u0001JO\u0010 \u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022:\u0010\n\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000b0\u001cj\u0002`\u001fH\u0096\u0001J_\u0010 \u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!2F\u0010\n\u001aB\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000b0\u001cj\u0002`%H\u0096\u0001JO\u0010(\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u00022:\u0010\n\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000b0\u001cj\u0002`'H\u0096\u0001J_\u0010(\u001a\u00020\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020!2F\u0010\n\u001aB\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u000b0\u001cj\u0002`+H\u0096\u0001JG\u0010-\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001JG\u0010.\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001J1\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0001J;\u00101\u001a\u0004\u0018\u00010/2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\t\u00103\u001a\u000202H\u0096\u0001J3\u00104\u001a\u0004\u0018\u00010/2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0097\u0001J;\u00104\u001a\u0004\u0018\u00010/2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0097\u0001J;\u00107\u001a\u0004\u0018\u00010/2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J3\u00108\u001a\u0004\u0018\u00010/2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0097\u0001J\u0011\u00109\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0013\u0010:\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001JG\u0010;\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0011\u0010<\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/impl/TroopMemberListRepoApiImpl;", "Lcom/tencent/qqnt/troopmemberlist/ITroopMemberListRepoApi;", "", "troopUin", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "forceNet", "from", "Lcom/tencent/qqnt/troopmemberlist/f;", "callback", "", "fetchGagTroopMemberInfo", "uin", "Lcom/tencent/qqnt/troopmemberlist/g;", "fetchTroopMemberInfo", "fetchTroopMemberInfoWithExtInfo", "fetchTroopMemberList", "fetchTroopMemberListWithExtInfo", "memberUin", "lifecycleOwner", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "Lkotlin/ParameterName;", "name", "nickInfo", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberNameCallback;", "fetchTroopMemberName", "Lkotlin/Function2;", "isSuccess", "uid", "Lcom/tencent/qqnt/troopmemberlist/FetchSingleTroopMemberUidCallback;", "fetchTroopMemberUid", "", "memberUinList", "", "uin2UidMap", "Lcom/tencent/qqnt/troopmemberlist/FetchMultiTroopMemberUidCallback;", "memberUid", "Lcom/tencent/qqnt/troopmemberlist/FetchSingleTroopMemberUinCallback;", "fetchTroopMemberUin", "memberUidList", "uid2UinMap", "Lcom/tencent/qqnt/troopmemberlist/FetchMultiTroopMemberUinCallback;", SquareJSConst.Params.PARAMS_UIN_LIST, "fetchTroopMemberUinListInfo", "fetchTroopMemberUinListInfoWithExtInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "getTroopMemberFromCache", "getTroopMemberFromCacheOrFetchAsync", "", "getTroopMemberInfoDBVersion", "getTroopMemberInfoSync", "", "timeoutMs", "getTroopMemberWithExtFromCacheOrFetchAsync", "getTroopMemberWithExtInfoSync", "isTroopMemberInfoDBInited", "isTroopMemberListExpired", "preLoadTroopMemberUinListInfo", "updateMemberDBVersionAfterNetRsp", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberListRepoApiImpl implements ITroopMemberListRepoApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopMemberListRepo $$delegate_0;

    public TroopMemberListRepoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopMemberListRepo.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchGagTroopMemberInfo(@Nullable String troopUin, @Nullable LifecycleOwner owner, boolean forceNet, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, owner, Boolean.valueOf(forceNet), from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchGagTroopMemberInfo(troopUin, owner, forceNet, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberInfo(@Nullable String troopUin, @Nullable String uin, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, uin, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberInfo(troopUin, uin, forceNet, owner, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberInfoWithExtInfo(@Nullable String troopUin, @Nullable String uin, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, uin, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberInfoWithExtInfo(troopUin, uin, forceNet, owner, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberList(@Nullable String troopUin, @Nullable LifecycleOwner owner, boolean forceNet, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, owner, Boolean.valueOf(forceNet), from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberList(troopUin, owner, forceNet, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberListWithExtInfo(@Nullable String troopUin, @Nullable LifecycleOwner owner, boolean forceNet, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, owner, Boolean.valueOf(forceNet), from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberListWithExtInfo(troopUin, owner, forceNet, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberName(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner lifecycleOwner, @NotNull String from, @Nullable Function1<? super TroopMemberNickInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, memberUin, lifecycleOwner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberName(troopUin, memberUin, lifecycleOwner, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUid(@Nullable String memberUin, @NotNull Function2<? super Boolean, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) memberUin, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.fetchTroopMemberUid(memberUin, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUin(@Nullable String memberUid, @NotNull Function2<? super Boolean, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) memberUid, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.$$delegate_0.fetchTroopMemberUin(memberUid, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUinListInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, uinList, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberUinListInfo(troopUin, uinList, forceNet, owner, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUinListInfoWithExtInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, troopUin, uinList, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberUinListInfoWithExtInfo(troopUin, uinList, forceNet, owner, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberFromCache(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 15, this, troopUin, memberUin, owner, from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return this.$$delegate_0.getTroopMemberFromCache(troopUin, memberUin, owner, from);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 16, this, troopUin, memberUin, owner, from, callback);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return this.$$delegate_0.getTroopMemberFromCacheOrFetchAsync(troopUin, memberUin, owner, from, callback);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public int getTroopMemberInfoDBVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.$$delegate_0.getTroopMemberInfoDBVersion();
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Deprecated(message = "\u517c\u5bb9\u65e7\u903b\u8f91\uff0c\u8fc7\u6e21\u7528\uff0c\u65b0\u903b\u8f91\u4e0d\u8981\u4f7f\u7528")
    @Nullable
    public TroopMemberInfo getTroopMemberInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 18, this, troopUin, memberUin, owner, from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return this.$$delegate_0.getTroopMemberInfoSync(troopUin, memberUin, owner, from);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberWithExtFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 20, this, troopUin, memberUin, owner, from, callback);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return this.$$delegate_0.getTroopMemberWithExtFromCacheOrFetchAsync(troopUin, memberUin, owner, from, callback);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Deprecated(message = "\u517c\u5bb9\u65e7\u903b\u8f91\uff0c\u8fc7\u6e21\u7528\uff0c\u65b0\u903b\u8f91\u4e0d\u8981\u4f7f\u7528")
    @Nullable
    public TroopMemberInfo getTroopMemberWithExtInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 21, this, troopUin, memberUin, owner, from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return this.$$delegate_0.getTroopMemberWithExtInfoSync(troopUin, memberUin, owner, from);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public boolean isTroopMemberInfoDBInited(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return this.$$delegate_0.isTroopMemberInfoDBInited(troopUin);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public boolean isTroopMemberListExpired(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) troopUin)).booleanValue();
        }
        return this.$$delegate_0.isTroopMemberListExpired(troopUin);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void preLoadTroopMemberUinListInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, troopUin, uinList, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.preLoadTroopMemberUinListInfo(troopUin, uinList, forceNet, owner, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void updateMemberDBVersionAfterNetRsp(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.updateMemberDBVersionAfterNetRsp(troopUin);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberName(@Nullable String troopUin, @Nullable String memberUin, @NotNull String from, @Nullable Function1<? super TroopMemberNickInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, memberUin, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.fetchTroopMemberName(troopUin, memberUin, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUid(@NotNull List<String> memberUinList, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) memberUinList, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(memberUinList, "memberUinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$$delegate_0.fetchTroopMemberUid(memberUinList, callback);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUin(@NotNull List<String> memberUidList, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) memberUidList, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(memberUidList, "memberUidList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$$delegate_0.fetchTroopMemberUin(memberUidList, callback);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Deprecated(message = "\u517c\u5bb9\u65e7\u903b\u8f91\uff0c\u8fc7\u6e21\u7528\uff0c\u65b0\u903b\u8f91\u4e0d\u8981\u4f7f\u7528")
    @Nullable
    public TroopMemberInfo getTroopMemberInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, long timeoutMs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 19, this, troopUin, memberUin, owner, from, Long.valueOf(timeoutMs));
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return this.$$delegate_0.getTroopMemberInfoSync(troopUin, memberUin, owner, from, timeoutMs);
    }
}
