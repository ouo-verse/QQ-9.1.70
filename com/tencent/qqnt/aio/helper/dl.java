package com.tencent.qqnt.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopPlusAppService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/helper/dl;", "Lcom/tencent/aio/main/businesshelper/h;", "", "k", "i", "", "troopUin", "g", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class dl implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    private final void g(final long troopUin) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.dj
            @Override // java.lang.Runnable
            public final void run() {
                dl.h(troopUin);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(long j3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ITroopPlusAppService iTroopPlusAppService = peekAppRuntime != null ? (ITroopPlusAppService) peekAppRuntime.getRuntimeService(ITroopPlusAppService.class, "all") : null;
        boolean z16 = false;
        if (iTroopPlusAppService != null && iTroopPlusAppService.isMoreListSwitchOn()) {
            z16 = true;
        }
        if (z16) {
            iTroopPlusAppService.initPlusAppsCache(j3);
        }
    }

    private final void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.di
            @Override // java.lang.Runnable
            public final void run() {
                dl.j();
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
        }
    }

    private final void k() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        final String j3 = bVar.a().g().r().c().j();
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.dh
            @Override // java.lang.Runnable
            public final void run() {
                dl.m(AppRuntime.this, j3);
            }
        }, 16, null, false);
        i();
        g(Long.parseLong(j3));
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 2, "initAIOAppsCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AppRuntime appRuntime, final String curTroopCode) {
        Intrinsics.checkNotNullParameter(curTroopCode, "$curTroopCode");
        IRuntimeService runtimeService = appRuntime.getRuntimeService(ITroopAioAppService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        final ITroopAioAppService iTroopAioAppService = (ITroopAioAppService) runtimeService;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.dk
            @Override // java.lang.Runnable
            public final void run() {
                dl.n(curTroopCode, iTroopAioAppService);
            }
        }, 16, null, false);
        iTroopAioAppService.initAioAppsCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String curTroopCode, ITroopAioAppService troopAppService) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(curTroopCode, "$curTroopCode");
        Intrinsics.checkNotNullParameter(troopAppService, "$troopAppService");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(curTroopCode);
        if (longOrNull != null) {
            troopAppService.getAppsInObserver(longOrNull.longValue());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.J;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopAppHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            k();
        }
    }
}
