package com.tencent.zplan.activity;

import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import com.tencent.zplan.view.ZPlanLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tx4.a;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/activity/ZPlanStoreActivityByView$engineLoadingListener$1", "Ltx4/a;", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "", "Q0", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanStoreActivityByView$engineLoadingListener$1 implements a {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZPlanStoreActivityByView f385225d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanStoreActivityByView$engineLoadingListener$1(ZPlanStoreActivityByView zPlanStoreActivityByView) {
        this.f385225d = zPlanStoreActivityByView;
    }

    @Override // tx4.a
    public void Q0(@NotNull final CommonLoadingData loadingData) {
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        this.f385225d.runOnUiThread(new Runnable() { // from class: com.tencent.zplan.activity.ZPlanStoreActivityByView$engineLoadingListener$1$onProgress$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanLoadingView zPlanLoadingView;
                int min = Math.min(100, loadingData.getProgress());
                zPlanLoadingView = ZPlanStoreActivityByView$engineLoadingListener$1.this.f385225d.loadingPageView;
                if (zPlanLoadingView != null) {
                    zPlanLoadingView.setProgressText(min);
                }
            }
        });
    }
}
