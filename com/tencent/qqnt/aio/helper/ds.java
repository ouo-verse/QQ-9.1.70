package com.tencent.qqnt.aio.helper;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockStateIntent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.blocktroop.k;
import com.tencent.mobileqq.troop.exitoptimise.msgintent.TroopUiStateManageMsgIntent;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/aio/helper/ds;", "Lcom/tencent/aio/main/businesshelper/h;", "", "i", "p", "g", "", "flag", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "uin", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", DomainData.DOMAIN_NAME, "e", tl.h.F, "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Ljava/lang/String;", "blockFlag", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroidx/lifecycle/Observer;", "", "Landroidx/lifecycle/Observer;", "groupListener", "Z", "hasShowBlockDialog", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ds implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String blockFlag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQCustomDialog dialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Observer<List<TroopInfo>> groupListener = new Observer() { // from class: com.tencent.qqnt.aio.helper.dp
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            ds.j(ds.this, (List) obj);
        }
    };

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasShowBlockDialog;

    private final void e(TroopInfo troopInfo) {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().h(new GroupBlockStateIntent.GroupBlockStateChange(troopInfo.isNeedInterceptOnBlockTroop(), troopInfo.getBlockType()));
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(new TroopUiStateManageMsgIntent.UpdateInputMode(3, !troopInfo.isReadableBlock(), ""));
    }

    private final void g() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        String j3 = aVar.g().r().c().j();
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(j3);
        if (QLog.isColorLevel()) {
            QLog.i("TroopBlockHelper", 2, "[checkTroopBlock] curUin:" + j3 + ", blockFlag:" + this.blockFlag + ", uniqueBlockFlag:" + (troopInfoFromCache != null ? troopInfoFromCache.getUniqueBlockFlag() : null));
        }
        if (m(troopInfoFromCache != null ? troopInfoFromCache.getUniqueBlockFlag() : null)) {
            n(j3, troopInfoFromCache);
        }
    }

    private final void h() {
        QQCustomDialog qQCustomDialog;
        QQCustomDialog qQCustomDialog2 = this.dialog;
        boolean z16 = false;
        if (qQCustomDialog2 != null && qQCustomDialog2.isShowing()) {
            z16 = true;
        }
        if (!z16 || (qQCustomDialog = this.dialog) == null) {
            return;
        }
        qQCustomDialog.dismiss();
    }

    private final void i() {
        if (QLog.isColorLevel()) {
            QLog.i("TroopBlockHelper", 2, "[doOnDestroy]");
        }
        fx3.a<List<TroopInfo>> troopListLiveData = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopListLiveData();
        if (troopListLiveData != null) {
            troopListLiveData.removeObserver(this.groupListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final ds this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.api.runtime.a aVar = this$0.aioContext;
        Object obj = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        final String j3 = aVar.g().r().c().j();
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((TroopInfo) next).troopuin, j3)) {
                    obj = next;
                    break;
                }
            }
            final TroopInfo troopInfo = (TroopInfo) obj;
            if (troopInfo == null) {
                return;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("TroopBlockHelper", 4, "[groupListener] blockFlag:" + this$0.blockFlag + ", uniqueBlockFlag:" + troopInfo.getUniqueBlockFlag());
            }
            if (this$0.m(troopInfo.getUniqueBlockFlag())) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.dr
                    @Override // java.lang.Runnable
                    public final void run() {
                        ds.k(ds.this, j3, troopInfo);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ds this$0, String curUin, TroopInfo groupInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(curUin, "$curUin");
        Intrinsics.checkNotNullParameter(groupInfo, "$groupInfo");
        this$0.n(curUin, groupInfo);
    }

    private final boolean m(String flag) {
        boolean z16 = !Intrinsics.areEqual(this.blockFlag, flag);
        if (z16) {
            this.blockFlag = flag;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ds this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fx3.a<List<TroopInfo>> troopListLiveData = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopListLiveData();
        if (troopListLiveData != null) {
            troopListLiveData.removeObserver(this$0.groupListener);
        }
        com.tencent.aio.api.runtime.a aVar = this$0.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void p() {
        if (QLog.isColorLevel()) {
            QLog.i("TroopBlockHelper", 2, "[registerObserver]");
        }
        fx3.a<List<TroopInfo>> troopListLiveData = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopListLiveData();
        if (troopListLiveData != null) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            LifecycleOwner d16 = aVar.d();
            Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
            troopListLiveData.observe(d16, this.groupListener);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350673t;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopBlockHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.aioContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        h();
        this.dialog = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    private final void n(String uin, TroopInfo troopInfo) {
        boolean z16 = false;
        boolean z17 = troopInfo != null && troopInfo.isReadableBlock();
        boolean z18 = troopInfo != null && troopInfo.isTroopBlocked;
        boolean z19 = (troopInfo != null && troopInfo.isUnreadableBlock()) && troopInfo.isMember();
        boolean z26 = this.hasShowBlockDialog;
        QQCustomDialog qQCustomDialog = this.dialog;
        com.tencent.aio.api.runtime.a aVar = null;
        QLog.i("TroopBlockHelper", 1, "[onBlockStateChange] uin:" + uin + ", needShowDialog:" + z19 + ", isBlock:" + z18 + ", isReadableBlock:" + z17 + ", hasShowBlockDialog:" + z26 + ", isShow:" + (qQCustomDialog != null ? Boolean.valueOf(qQCustomDialog.isShowing()) : null));
        if (troopInfo != null) {
            e(troopInfo);
        }
        if (z17) {
            com.tencent.mobileqq.troop.l.f297714a.a(troopInfo != null ? troopInfo.getTroopUin() : null);
        }
        if (!z19) {
            this.hasShowBlockDialog = false;
            h();
        }
        if (this.hasShowBlockDialog || !z19) {
            return;
        }
        QQCustomDialog qQCustomDialog2 = this.dialog;
        if (qQCustomDialog2 != null && qQCustomDialog2.isShowing()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.hasShowBlockDialog = true;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        FragmentActivity activity = aVar.c().getActivity();
        if (z19 && activity != null) {
            h();
            this.dialog = com.tencent.mobileqq.troop.blocktroop.k.F(activity, qQAppInterface, uin, new k.a() { // from class: com.tencent.qqnt.aio.helper.dq
                @Override // com.tencent.mobileqq.troop.blocktroop.k.a
                public final void onCancel() {
                    ds.o(ds.this);
                }
            });
        } else {
            h();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            this.blockFlag = null;
            this.hasShowBlockDialog = false;
            p();
        } else if (state != 3) {
            if (state != 12) {
                return;
            }
            i();
        } else {
            QQCustomDialog qQCustomDialog = this.dialog;
            if (qQCustomDialog != null) {
                if ((qQCustomDialog == null || qQCustomDialog.isShowing()) ? false : true) {
                    this.blockFlag = null;
                    this.hasShowBlockDialog = false;
                }
            }
            g();
        }
    }
}
