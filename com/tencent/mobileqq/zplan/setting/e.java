package com.tencent.mobileqq.zplan.setting;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcall.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.qphone.base.util.QLog;
import hu4.l;
import hu4.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import nk3.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J*\u0010\u0011\u001a\u00020\b2\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ \u0010\u0017\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/setting/e;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "", "", "infoList", "", "e", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/zplan/setting/SwitchSetting;", "", "switches", "Lnk3/a;", "resultCallback", "g", "setting", "isChecked", "f", "Lkotlin/Function0;", "callback", "b", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f335451a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/setting/e$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<hu4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ nk3.a f335452d;

        a(nk3.a aVar) {
            this.f335452d = aVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(hu4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            m mVar = result.f406344a;
            if (mVar == null) {
                QLog.e("SettingRequest", 2, "request fail " + result);
                this.f335452d.onResult(false);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SettingRequest", 2, "request success " + mVar);
            }
            c.k("key_view_contract", mVar.f406387a);
            com.tencent.mobileqq.zplan.servlet.c cVar = com.tencent.mobileqq.zplan.servlet.c.f335402a;
            l[] lVarArr = mVar.f406388b;
            Intrinsics.checkNotNullExpressionValue(lVarArr, "data.greementInfo");
            c.l("key_view_contract_info", cVar.b(lVarArr).toString());
            this.f335452d.onResult(true);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SettingRequest", 1, "request failed " + error + " , " + message);
            this.f335452d.onResult(false);
        }
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(WeakReference appWeakReference, Function0 function0, Map map) {
        Intrinsics.checkNotNullParameter(appWeakReference, "$appWeakReference");
        if (map == null) {
            QLog.e("SettingRequest", 1, "[getAllSwitchFromService] it is null.");
            return;
        }
        AppInterface appInterface = (AppInterface) appWeakReference.get();
        if (appInterface == null) {
            QLog.e("SettingRequest", 1, "[getAllSwitchFromService] WeakReference app is null.");
            return;
        }
        f335451a.e(appInterface, map);
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void e(AppInterface app, Map<Integer, String> infoList) {
        if (app == null || infoList == null) {
            return;
        }
        for (SwitchSetting switchSetting : SwitchSetting.values()) {
            String str = infoList.get(Integer.valueOf(switchSetting.getPbName()));
            if (str == null) {
                QLog.e("SettingRequest", 1, "setAllSwitchState2SP get value fail! key: " + switchSetting.getKey());
            } else {
                try {
                    c.k(switchSetting.getKey(), Integer.parseInt(str));
                } catch (NumberFormatException e16) {
                    QLog.e("SettingRequest", 1, "setAllSwitchState2SP numberFormatException. " + switchSetting.getKey() + ":" + str, e16);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("SettingRequest", 2, "[setSwitchState2SP] success, uin:" + g.a(app.getLongAccountUin()) + " " + switchSetting.getKey() + ":" + str);
                }
            }
        }
    }

    public final void b(AppInterface app, final Function0<Unit> callback) {
        if (app == null) {
            QLog.e("SettingRequest", 1, "[getAllSwitchFromService] app is null.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SwitchSetting switchSetting : SwitchSetting.values()) {
            arrayList.add(new com.tencent.mobileqq.zplan.model.c(switchSetting.getPbName(), switchSetting.getPbType()));
        }
        QLog.i("SettingRequest", 1, "getAllSwitchFromService uin:" + g.a(app.getLongAccountUin()));
        final WeakReference weakReference = new WeakReference(app);
        ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).requestOidb1127(arrayList, app.getLongAccountUin(), 4, new p() { // from class: com.tencent.mobileqq.zplan.setting.d
            @Override // nk3.p
            public final void a(Map map) {
                e.c(WeakReference.this, callback, map);
            }
        });
    }

    public final void d(nk3.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.servlet.a.b(com.tencent.mobileqq.zplan.servlet.a.f335387a, new hu4.a(), new a(callback), 0, 4, null);
    }

    public final void f(SwitchSetting setting, boolean isChecked, nk3.a resultCallback) {
        List<? extends Pair<? extends SwitchSetting, Boolean>> listOf;
        Intrinsics.checkNotNullParameter(setting, "setting");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(setting, Boolean.valueOf(isChecked)));
        g(listOf, resultCallback);
    }

    public final void g(List<? extends Pair<? extends SwitchSetting, Boolean>> switches, nk3.a resultCallback) {
        Intrinsics.checkNotNullParameter(switches, "switches");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = switches.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            SwitchSetting switchSetting = (SwitchSetting) pair.getFirst();
            boolean booleanValue = ((Boolean) pair.getSecond()).booleanValue();
            int pbName = switchSetting.getPbName();
            if (pbName == 0) {
                return;
            }
            String valueOf = String.valueOf(switchSetting.getSwitchValue(booleanValue));
            arrayList.add(new com.tencent.mobileqq.zplan.model.b(pbName, 3, valueOf));
            QLog.i("SettingRequest", 1, "setSettingSwitch key:" + switchSetting.getKey() + ", value:" + valueOf);
        }
        QRouteApi api = QRoute.api(IZPlanRequest.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanRequest::class.java)");
        IZPlanRequest.a.a((IZPlanRequest) api, arrayList, 3, resultCallback, 0L, 8, null);
    }
}
