package com.tencent.qqnt.troop.impl;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.TroopListRepo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0013\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001J\u0017\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\nH\u0096\u0001J\u001b\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0016H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0096\u0001J\u001b\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u0016H\u0096\u0001J%\u0010\u001e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0006H\u0096\u0001J\t\u0010 \u001a\u00020\u0006H\u0096\u0001J\t\u0010!\u001a\u00020\u0004H\u0096\u0001JV\u0010,\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062)\u0010+\u001a%\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0004\u0018\u00010&j\u0004\u0018\u0001`*H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\rH\u0096\u0001\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopListRepoApiImpl;", "Lcom/tencent/qqnt/troop/ITroopListRepoApi;", "", "troopUin", "", "deleteTroopInCache", "", "forceNet", "fetchTroopLevelInfo", "fetchTroopList", "Lfx3/a;", "getFetchTroopListResultLiveData", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getJoinedTroopInfoFromCache", "getSortedJoinedTopTroopInfoFromCache", "getSortedJoinedTroopInfoFromCache", "getSortedJoinedValidTroopInfoFromCache", "getTopTroopListFromCache", "getTroopInfoFromCache", "getTroopListFromCache", "getTroopListLiveData", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "getTroopListWithMsgMask", IProfileProtocolConst.PARAM_TROOP_CODE, "getTroopUinByTroopCode", "getTroopUinListWithMsgMask", "from", "printLog", "isExit", "isTroopListCacheAllInited", "isTroopListInited", "preloadTroopList", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "isTop", "needToast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/qqnt/troop/SetTroopTopCallback;", "callback", "requestSetTroopTop", "troopInfo", "saveTroopInCache", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopListRepoApiImpl implements ITroopListRepoApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopListRepo $$delegate_0;

    public TroopListRepoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopListRepo.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void deleteTroopInCache(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.deleteTroopInCache(troopUin);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void fetchTroopLevelInfo(@NotNull String troopUin, boolean forceNet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, Boolean.valueOf(forceNet));
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            this.$$delegate_0.fetchTroopLevelInfo(troopUin, forceNet);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void fetchTroopList(boolean forceNet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, forceNet);
        } else {
            this.$$delegate_0.fetchTroopList(forceNet);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public fx3.a<Boolean> getFetchTroopListResultLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (fx3.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.$$delegate_0.getFetchTroopListResultLiveData();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getJoinedTroopInfoFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.$$delegate_0.getJoinedTroopInfoFromCache();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getSortedJoinedTopTroopInfoFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.$$delegate_0.getSortedJoinedTopTroopInfoFromCache();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getSortedJoinedTroopInfoFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.$$delegate_0.getSortedJoinedTroopInfoFromCache();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getSortedJoinedValidTroopInfoFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.$$delegate_0.getSortedJoinedValidTroopInfoFromCache();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getTopTroopListFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.$$delegate_0.getTopTroopListFromCache();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @Nullable
    public TroopInfo getTroopInfoFromCache(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopUin);
        }
        return this.$$delegate_0.getTroopInfoFromCache(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public List<TroopInfo> getTroopListFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.$$delegate_0.getTroopListFromCache();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @Nullable
    public fx3.a<List<TroopInfo>> getTroopListLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (fx3.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.$$delegate_0.getTroopListLiveData();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public Map<GroupMsgMask, List<TroopInfo>> getTroopListWithMsgMask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Map) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.$$delegate_0.getTroopListWithMsgMask();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public String getTroopUinByTroopCode(@NotNull String troopCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) troopCode);
        }
        Intrinsics.checkNotNullParameter(troopCode, "troopCode");
        return this.$$delegate_0.getTroopUinByTroopCode(troopCode);
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    @NotNull
    public Map<GroupMsgMask, List<String>> getTroopUinListWithMsgMask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Map) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.$$delegate_0.getTroopUinListWithMsgMask();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public boolean isExit(@Nullable String troopUin, @NotNull String from, boolean printLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, troopUin, from, Boolean.valueOf(printLog))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return this.$$delegate_0.isExit(troopUin, from, printLog);
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public boolean isTroopListCacheAllInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.$$delegate_0.isTroopListCacheAllInited();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public boolean isTroopListInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.$$delegate_0.isTroopListInited();
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void preloadTroopList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.$$delegate_0.preloadTroopList();
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void requestSetTroopTop(@Nullable LifecycleOwner lifecycleOwner, @NotNull String troopCode, boolean isTop, boolean needToast, @Nullable Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, lifecycleOwner, troopCode, Boolean.valueOf(isTop), Boolean.valueOf(needToast), callback);
        } else {
            Intrinsics.checkNotNullParameter(troopCode, "troopCode");
            this.$$delegate_0.requestSetTroopTop(lifecycleOwner, troopCode, isTop, needToast, callback);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopListRepoApi
    public void saveTroopInCache(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) troopInfo);
        } else {
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            this.$$delegate_0.saveTroopInCache(troopInfo);
        }
    }
}
