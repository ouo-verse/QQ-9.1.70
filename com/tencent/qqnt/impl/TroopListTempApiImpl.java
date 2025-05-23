package com.tencent.qqnt.impl;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ITroopListTempApi;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troop.TroopListRepo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0002\b\u00030\rj\u0006\u0012\u0002\b\u0003`\u000eH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/impl/TroopListTempApiImpl;", "Lcom/tencent/qqnt/ITroopListTempApi;", "()V", "fetchTroopBasicInfo", "", "troopUin", "", "from", "callback", "Lkotlin/Function2;", "", "", "getSortedJoinedTroopInfoFromCache", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTroopExtDBInfoSync", "getTroopInfoFromCache", "getTroopUinByTroopCode", IProfileProtocolConst.PARAM_TROOP_CODE, "saveTroopInCache", "troopInfo", "updateMyTroopHonor", "myHonorList", "honorRichFlag", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class TroopListTempApiImpl implements ITroopListTempApi {
    static IPatchRedirector $redirector_;

    public TroopListTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ITroopListTempApi
    public void fetchTroopBasicInfo(@Nullable String troopUin, @NotNull String from, @Nullable final Function2<? super Boolean, Object, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            TroopInfoRepo.INSTANCE.fetchTroopBasicInfo(troopUin, from, null, new Function2<Boolean, TroopInfo, Unit>(callback) { // from class: com.tencent.qqnt.impl.TroopListTempApiImpl$fetchTroopBasicInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, Object, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                    invoke(bool.booleanValue(), troopInfo);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull TroopInfo data) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), data);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(data, "data");
                    Function2<Boolean, Object, Unit> function2 = this.$callback;
                    if (function2 != null) {
                        function2.invoke(Boolean.valueOf(z16), data);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ITroopListTempApi
    @NotNull
    public ArrayList<?> getSortedJoinedTroopInfoFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ArrayList<>(TroopListRepo.INSTANCE.getSortedJoinedTroopInfoFromCache());
    }

    @Override // com.tencent.qqnt.ITroopListTempApi
    @Nullable
    public Object getTroopExtDBInfoSync(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopUin);
        }
        return TroopExtDBInfoRepo.INSTANCE.getTroopExtInfoSync(troopUin);
    }

    @Override // com.tencent.qqnt.ITroopListTempApi
    @Nullable
    public Object getTroopInfoFromCache(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return TroopListRepo.INSTANCE.getTroopInfoFromCache(troopUin);
    }

    @Override // com.tencent.qqnt.ITroopListTempApi
    @NotNull
    public String getTroopUinByTroopCode(@Nullable String troopCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopCode);
        }
        if (troopCode == null) {
            return "";
        }
        return TroopListRepo.INSTANCE.getTroopUinByTroopCode(troopCode);
    }

    @Override // com.tencent.qqnt.ITroopListTempApi
    public void saveTroopInCache(@Nullable Object troopInfo) {
        TroopInfo troopInfo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, troopInfo);
            return;
        }
        if (troopInfo instanceof TroopInfo) {
            troopInfo2 = (TroopInfo) troopInfo;
        } else {
            troopInfo2 = null;
        }
        if (troopInfo2 != null) {
            TroopListRepo.INSTANCE.saveTroopInCache(troopInfo2);
        }
    }

    @Override // com.tencent.qqnt.ITroopListTempApi
    public void updateMyTroopHonor(@Nullable String troopUin, @NotNull String myHonorList, byte honorRichFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, myHonorList, Byte.valueOf(honorRichFlag));
        } else {
            Intrinsics.checkNotNullParameter(myHonorList, "myHonorList");
            TroopExtDBInfoRepo.INSTANCE.updateMyTroopHonor(troopUin, myHonorList, honorRichFlag);
        }
    }
}
