package k61;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.ZPlanUpgradeEvent;
import com.tencent.mobileqq.activity.aio.zplan.IntimateUpgradeBannerView;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J*\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lk61/x;", "Lk61/d;", "", "eventId", "", "r", "Landroid/view/View;", "containerView", "onInitView", "Lj61/a;", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class x extends d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"k61/x$a", "Lcom/tencent/mobileqq/activity/aio/zplan/a;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.mobileqq.activity.aio.zplan.a {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.zplan.a
        public void a() {
            x.this.r("dt_clck");
            SimpleEventBus.getInstance().dispatchEvent(new ZPlanUpgradeEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String eventId) {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent(eventId, "pg_aio_swipleft", "em_zplan_friend_time_banner", j61.d.f409515a.d(), null);
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IntimateUpgradeBannerView intimateUpgradeBannerView;
        super.onDestroy();
        View view = this.mRootView;
        if (view instanceof IntimateUpgradeBannerView) {
            intimateUpgradeBannerView = (IntimateUpgradeBannerView) view;
        } else {
            intimateUpgradeBannerView = null;
        }
        if (intimateUpgradeBannerView != null) {
            intimateUpgradeBannerView.setCallback(null);
        }
        r("dt_imp_end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        r("dt_imp");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        IntimateUpgradeBannerView intimateUpgradeBannerView;
        View view = this.mRootView;
        if (view instanceof IntimateUpgradeBannerView) {
            intimateUpgradeBannerView = (IntimateUpgradeBannerView) view;
        } else {
            intimateUpgradeBannerView = null;
        }
        if (intimateUpgradeBannerView != null) {
            intimateUpgradeBannerView.setCallback(new a());
        }
    }
}
