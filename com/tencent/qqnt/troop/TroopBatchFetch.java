package com.tencent.qqnt.troop;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JU\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022)\u0010\u0010\u001a%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tj\u0004\u0018\u0001`\u000fH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/troop/TroopBatchFetch;", "", "", "troopUin", "", "isMember", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "from", "Lkotlin/Function1;", "Lcom/tencent/qqnt/troopmemberlist/datasync/e;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/qqnt/troop/TroopBatchFetchCallback;", "callback", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopBatchFetch {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopBatchFetch f362389a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f362389a = new TroopBatchFetch();
        }
    }

    TroopBatchFetch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void c(@NotNull String troopUin, boolean isMember, @Nullable LifecycleOwner lifecycleOwner, @NotNull String from, @Nullable final Function1<? super com.tencent.qqnt.troopmemberlist.datasync.e, Unit> callback) {
        int i3;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(from, "from");
        boolean z16 = true;
        QLog.i("TroopBatchFetch", 1, "[batchTroopInfo] troopUin:" + troopUin + ", isMember:" + isMember + ", from:" + from);
        if (isMember) {
            i3 = 4;
        } else {
            i3 = 2;
        }
        final com.tencent.qqnt.troopmemberlist.datasync.e eVar = new com.tencent.qqnt.troopmemberlist.datasync.e(i3);
        eVar.h(new com.tencent.qqnt.troopmemberlist.datasync.d() { // from class: com.tencent.qqnt.troop.j
            @Override // com.tencent.qqnt.troopmemberlist.datasync.d
            public final void a(Object obj) {
                TroopBatchFetch.d(Function1.this, (com.tencent.qqnt.troopmemberlist.datasync.e) obj);
            }
        });
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache == null || !troopInfoFromCache.isNeedInterceptOnBlockTroop()) {
            z16 = false;
        }
        if (!z16) {
            TroopInfoRepo.INSTANCE.fetchTroopInfoForBatch(troopUin, isMember, from, lifecycleOwner, new Function3<Boolean, Integer, TroopInfo, Unit>() { // from class: com.tencent.qqnt.troop.TroopBatchFetch$batchTroopInfo$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.troopmemberlist.datasync.e.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, TroopInfo troopInfo) {
                    invoke(bool.booleanValue(), num.intValue(), troopInfo);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, int i16, @NotNull TroopInfo info) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    boolean z18 = true;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z17), Integer.valueOf(i16), info);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(info, "info");
                    com.tencent.qqnt.troopmemberlist.datasync.e eVar2 = com.tencent.qqnt.troopmemberlist.datasync.e.this;
                    synchronized (eVar2) {
                        if (!eVar2.n() || !z17) {
                            z18 = false;
                        }
                        eVar2.t(z18);
                        eVar2.q(info);
                        eVar2.r(i16);
                        eVar2.g();
                        Unit unit = Unit.INSTANCE;
                    }
                }
            });
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("TroopBatchFetch", 2, "[batchTroopInfo] troopUin:" + troopUin + ", isNeedInterceptOnBlockTroop");
            }
            synchronized (eVar) {
                eVar.q(troopInfoFromCache);
                eVar.r(0);
                eVar.g();
                Unit unit = Unit.INSTANCE;
            }
        }
        TroopMemberExtInfoRepo troopMemberExtInfoRepo = TroopMemberExtInfoRepo.INSTANCE;
        troopMemberExtInfoRepo.fetchTroopMemberForBatch(troopUin, isMember, "2", lifecycleOwner, new Function2<Boolean, GroupMemberCommonListResult, Unit>() { // from class: com.tencent.qqnt.troop.TroopBatchFetch$batchTroopInfo$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.troopmemberlist.datasync.e.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, GroupMemberCommonListResult groupMemberCommonListResult) {
                invoke(bool.booleanValue(), groupMemberCommonListResult);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17, @Nullable GroupMemberCommonListResult groupMemberCommonListResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z18 = true;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z17), groupMemberCommonListResult);
                    return;
                }
                com.tencent.qqnt.troopmemberlist.datasync.e eVar2 = com.tencent.qqnt.troopmemberlist.datasync.e.this;
                synchronized (eVar2) {
                    if (!eVar2.n() || !z17) {
                        z18 = false;
                    }
                    eVar2.t(z18);
                    eVar2.p(groupMemberCommonListResult);
                    eVar2.g();
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        });
        if (isMember) {
            troopMemberExtInfoRepo.fetchTroopMemberForBatch(troopUin, true, "5", lifecycleOwner, new Function2<Boolean, GroupMemberCommonListResult, Unit>() { // from class: com.tencent.qqnt.troop.TroopBatchFetch$batchTroopInfo$5
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.troopmemberlist.datasync.e.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, GroupMemberCommonListResult groupMemberCommonListResult) {
                    invoke(bool.booleanValue(), groupMemberCommonListResult);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, @Nullable GroupMemberCommonListResult groupMemberCommonListResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    boolean z18 = true;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z17), groupMemberCommonListResult);
                        return;
                    }
                    com.tencent.qqnt.troopmemberlist.datasync.e eVar2 = com.tencent.qqnt.troopmemberlist.datasync.e.this;
                    synchronized (eVar2) {
                        if (!eVar2.n() || !z17) {
                            z18 = false;
                        }
                        eVar2.t(z18);
                        eVar2.s(groupMemberCommonListResult);
                        eVar2.g();
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            });
            troopMemberExtInfoRepo.fetchSelfTroopLevelInfo(troopUin, lifecycleOwner, new Function2<Boolean, GroupMemberExtListResult, Unit>() { // from class: com.tencent.qqnt.troop.TroopBatchFetch$batchTroopInfo$6
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.troopmemberlist.datasync.e.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, GroupMemberExtListResult groupMemberExtListResult) {
                    invoke(bool.booleanValue(), groupMemberExtListResult);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, @Nullable GroupMemberExtListResult groupMemberExtListResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    boolean z18 = true;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z17), groupMemberExtListResult);
                        return;
                    }
                    com.tencent.qqnt.troopmemberlist.datasync.e eVar2 = com.tencent.qqnt.troopmemberlist.datasync.e.this;
                    synchronized (eVar2) {
                        if (!eVar2.n() || !z17) {
                            z18 = false;
                        }
                        eVar2.t(z18);
                        eVar2.u(groupMemberExtListResult);
                        eVar2.g();
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final Function1 function1, final com.tencent.qqnt.troopmemberlist.datasync.e data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopBatchFetch", 4, "[onDataReadyOnSubThread] data:" + data);
        }
        com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.qqnt.troop.k
            @Override // java.lang.Runnable
            public final void run() {
                TroopBatchFetch.e(Function1.this, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 function1, com.tencent.qqnt.troopmemberlist.datasync.e data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        if (function1 != null) {
            function1.invoke(data);
        }
    }
}
