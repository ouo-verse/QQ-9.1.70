package com.tencent.mobileqq.zootopia.ueloading.prepare.preparer;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.ModChekerParams;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vd3.PrepareErr;
import vd3.PrepareResult;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/prepare/preparer/CheckPreparer;", "Lvd3/a;", "", "e", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "enterJson", "Lvd3/c;", "callback", "", "a", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "d", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "loaderController", "<init>", "(Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CheckPreparer extends vd3.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanUELoaderControllerV2 loaderController;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckPreparer(ZPlanUELoaderControllerV2 loaderController) {
        super(loaderController);
        Intrinsics.checkNotNullParameter(loaderController, "loaderController");
        this.loaderController = loaderController;
    }

    @Override // vd3.a, vd3.b
    public void a(final ZootopiaEnterParams enterParams, final JSONObject enterJson, final vd3.c callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(enterParams, enterJson, callback);
        com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar = new com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult>() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.CheckPreparer$prepare$checkCallback$1
            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(final EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                CheckPreparer.this.h("onCheckComplete result=" + result + " ");
                final ZootopiaEnterParams zootopiaEnterParams = enterParams;
                final CheckPreparer checkPreparer = CheckPreparer.this;
                final vd3.c cVar = callback;
                final JSONObject jSONObject = enterJson;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.CheckPreparer$prepare$checkCallback$1$onCheckComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (EnterModCheckResult.this.isPassed()) {
                            ZootopiaEnterParams enterParamsAfterCheck = EnterModCheckResult.this.getEnterParamsAfterCheck();
                            if (enterParamsAfterCheck == null) {
                                enterParamsAfterCheck = zootopiaEnterParams;
                            }
                            checkPreparer.f(enterParamsAfterCheck, enterParamsAfterCheck.toJsonObject(), cVar);
                            return;
                        }
                        cVar.a(new PrepareResult(zootopiaEnterParams, jSONObject, EnterModCheckResult.this.getModUpdateInfo(), new PrepareErr(2, EnterModCheckResult.this.getResultCode(), "check failed")));
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                CheckPreparer.this.h("onCheckInterceptor");
            }
        };
        if (!this.loaderController.getIsBackLoad()) {
            com.tencent.mobileqq.zplan.authorize.api.c cVar = (com.tencent.mobileqq.zplan.authorize.api.c) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.authorize.api.c.class);
            int mapId = enterParams.getMapId();
            ZootopiaSource source = this.loaderController.getSource();
            if (source == null) {
                source = ZootopiaSource.INSTANCE.i();
            }
            cVar.n0(mapId, enterParams, source, aVar);
            return;
        }
        com.tencent.mobileqq.zplan.authorize.api.c cVar2 = (com.tencent.mobileqq.zplan.authorize.api.c) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.authorize.api.c.class);
        int mapId2 = enterParams.getMapId();
        ZootopiaSource source2 = this.loaderController.getSource();
        if (source2 == null) {
            source2 = ZootopiaSource.INSTANCE.i();
        }
        cVar2.U(mapId2, new ModChekerParams(source2, this.loaderController.getEnterSource(), true, false, null, 24, null), aVar);
    }

    @Override // vd3.a
    public String e() {
        return "CheckPreparer";
    }
}
