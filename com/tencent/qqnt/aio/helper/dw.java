package com.tencent.qqnt.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.essence.EssenceEvent;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001b\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/aio/helper/dw;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/qqnt/aio/essence/EssenceEvent$ClickEssenceTail;", "intent", "", "e", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/troop/essencemsg/TroopEssenceMsgManager;", "emm", "b", "c", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "helpParam", "com/tencent/qqnt/aio/helper/dw$b", "Lcom/tencent/qqnt/aio/helper/dw$b;", "mAction", "Lcom/tencent/mobileqq/troop/essencemsg/a;", "f", "Lcom/tencent/mobileqq/troop/essencemsg/a;", "mEssObserver", "<init>", "()V", tl.h.F, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class dw implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helpParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b mAction = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.troop.essencemsg.a mEssObserver = new com.tencent.mobileqq.troop.essencemsg.a() { // from class: com.tencent.qqnt.aio.helper.dv
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/dw$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof EssenceEvent.ClickEssenceTail) {
                dw.this.e((EssenceEvent.ClickEssenceTail) i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void b(QQAppInterface app, TroopEssenceMsgManager emm) {
        com.tencent.aio.main.businesshelper.b bVar = this.helpParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helpParam");
            bVar = null;
        }
        String j3 = bVar.a().g().r().c().j();
        Manager manager = app.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopManager troopManager = manager instanceof TroopManager ? (TroopManager) manager : null;
        TroopInfo B = troopManager != null ? troopManager.B(j3) : null;
        if (B != null && B.isOwner()) {
            GroupExt groupExt = B.groupExt;
            if (groupExt != null && groupExt.essentialMsgPrivilege == 2) {
                emm.k0(j3, false);
            }
        }
    }

    private final void c() {
        com.tencent.aio.main.businesshelper.b bVar = this.helpParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helpParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.mAction);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            Manager manager = peekAppRuntime.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager");
            ((TroopEssenceMsgManager) manager).h0(this.mEssObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(EssenceEvent.ClickEssenceTail intent) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            String c16 = intent.c();
            long b16 = intent.b();
            int a16 = (int) intent.a();
            com.tencent.aio.main.businesshelper.b bVar = this.helpParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helpParam");
                bVar = null;
            }
            com.tencent.mobileqq.troop.essencemsg.u.r(qQAppInterface, c16, b16, a16, bVar.a().c().getContext(), 1);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.Q;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.essence.EssenceEvent.ClickEssenceTail");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopEssenceMsgHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.helpParam = param;
        param.a().e().f(this, this.mAction);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            Manager manager = peekAppRuntime.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
            TroopEssenceMsgManager troopEssenceMsgManager = manager instanceof TroopEssenceMsgManager ? (TroopEssenceMsgManager) manager : null;
            if (troopEssenceMsgManager != null) {
                troopEssenceMsgManager.v(this.mEssObserver);
                b((QQAppInterface) peekAppRuntime, troopEssenceMsgManager);
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            c();
        }
    }
}
