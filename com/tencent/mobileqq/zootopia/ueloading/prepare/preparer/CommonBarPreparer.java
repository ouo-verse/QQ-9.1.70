package com.tencent.mobileqq.zootopia.ueloading.prepare.preparer;

import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoadingController;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/prepare/preparer/CommonBarPreparer;", "Lvd3/a;", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "enterJson", "Lvd3/c;", "callback", "", "a", "", "e", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "d", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "ueLoader", "<init>", "(Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CommonBarPreparer extends vd3.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanUELoaderControllerV2 ueLoader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonBarPreparer(ZPlanUELoaderControllerV2 ueLoader) {
        super(ueLoader);
        Intrinsics.checkNotNullParameter(ueLoader, "ueLoader");
        this.ueLoader = ueLoader;
    }

    @Override // vd3.a, vd3.b
    public void a(ZootopiaEnterParams enterParams, JSONObject enterJson, vd3.c callback) {
        ZPlanBaseSceneLoadingView loadingView;
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(enterParams, enterJson, callback);
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.o(vd3.a.c(this, false, 0L, 3, null));
        ZPlanUELoadingController loadingController = this.ueLoader.getLoadingController();
        if (loadingController != null && (loadingView = loadingController.getLoadingView()) != null) {
            loadingView.h(ZPlanModLoadStatus.NativeSourceCheck);
        }
        ((si3.b) vb3.a.f441346a.a(si3.b.class)).E(enterParams, new CommonBarPreparer$prepare$1(this, enterJson, enterParams, callback));
    }

    @Override // vd3.a
    public String e() {
        return "CommonBarPreparer";
    }
}
