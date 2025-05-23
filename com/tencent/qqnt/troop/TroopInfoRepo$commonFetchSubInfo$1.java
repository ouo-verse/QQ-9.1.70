package com.tencent.qqnt.troop;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.inner.ITroopInfoInnerService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "T", "errCode", "", "errMsg", "", "result", "invoke", "(ILjava/lang/String;Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopInfoRepo$commonFetchSubInfo$1<T> extends Lambda implements Function3<Integer, String, T, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function2<TroopInfo, T, Unit> $doUpdate;
    final /* synthetic */ com.tencent.qqnt.report.m $report;
    final /* synthetic */ int $token;
    final /* synthetic */ String $troopUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopInfoRepo$commonFetchSubInfo$1(com.tencent.qqnt.report.m mVar, String str, Function2<? super TroopInfo, ? super T, Unit> function2, int i3) {
        super(3);
        this.$report = mVar;
        this.$troopUin = str;
        this.$doUpdate = function2;
        this.$token = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mVar, str, function2, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, int i16, TroopInfo troopInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        Function2 function2 = (Function2) TroopInfoRepo.INSTANCE.getFetchTroopInfoCallbacks().f(i3);
        if (function2 != null) {
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            function2.invoke(Boolean.valueOf(z16), troopInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Object obj) {
        invoke(num.intValue(), str, (String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final int i3, @NotNull String errMsg, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, t16);
            return;
        }
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        com.tencent.qqnt.report.m mVar = this.$report;
        if (mVar != null) {
            mVar.f();
        }
        final TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(this.$troopUin);
        if (troopInfoFromCache == null) {
            troopInfoFromCache = new TroopInfo(this.$troopUin);
        }
        this.$doUpdate.invoke(troopInfoFromCache, t16);
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 != null) {
            e16.onDetailInfoUpdate(troopInfoFromCache);
        }
        final int i16 = this.$token;
        com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.as
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoRepo$commonFetchSubInfo$1.b(i16, i3, troopInfoFromCache);
            }
        });
        com.tencent.qqnt.report.m mVar2 = this.$report;
        if (mVar2 != null) {
            com.tencent.qqnt.report.m.c(mVar2, Integer.valueOf(i3), null, errMsg, 2, null);
        }
    }
}
