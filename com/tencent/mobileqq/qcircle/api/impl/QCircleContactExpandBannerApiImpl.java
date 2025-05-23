package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.friendupdate.QCircleContactUpdateListContainer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mobileqq.zplan.api.IFrameHelperActivityApi;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCircleContactExpandBannerApiImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCircleContactExpandBannerApi;", "Landroid/view/ViewGroup;", "parentView", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "", "initView", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "isEnable", "onResume", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "onPostThemeChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer;", ParseCommon.CONTAINER, "Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer;", "<init>", "()V", "Companion", "a", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QCircleContactExpandBannerApiImpl implements IQCircleContactExpandBannerApi {

    @NotNull
    private static final String CONFIG_KEY = "qqcircle_enable_show_contact_update_list";

    @NotNull
    private static final String TAG = "QCircleContactExpandBannerApiImpl";

    @Nullable
    private QCircleContactUpdateListContainer container;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qcircle/api/impl/QCircleContactExpandBannerApiImpl$b", "Lcom/tencent/biz/qqcircle/friendupdate/QCircleContactUpdateListContainer$c;", "", "b", "a", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements QCircleContactUpdateListContainer.c {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.friendupdate.QCircleContactUpdateListContainer.c
        public void a() {
            QCircleContactUpdateListContainer qCircleContactUpdateListContainer = QCircleContactExpandBannerApiImpl.this.container;
            Intrinsics.checkNotNull(qCircleContactUpdateListContainer);
            Intrinsics.checkNotNullExpressionValue(qCircleContactUpdateListContainer.findViewById(R.id.f33010va), "container!!.findViewById\u2026d.qcircle_update_firends)");
            ((IFrameHelperActivityApi) QRoute.api(IFrameHelperActivityApi.class)).setDrawerFrameEnable(!r0.canScrollHorizontally(-1));
        }

        @Override // com.tencent.biz.qqcircle.friendupdate.QCircleContactUpdateListContainer.c
        public void b() {
            ((IFrameHelperActivityApi) QRoute.api(IFrameHelperActivityApi.class)).setDrawerFrameEnable(true);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi
    @Nullable
    public View createView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.container == null) {
            QCircleContactUpdateListContainer qCircleContactUpdateListContainer = new QCircleContactUpdateListContainer(context, null, 2, null);
            this.container = qCircleContactUpdateListContainer;
            Intrinsics.checkNotNull(qCircleContactUpdateListContainer);
            qCircleContactUpdateListContainer.setOnActionListener(new b());
        }
        QCircleContactUpdateListContainer qCircleContactUpdateListContainer2 = this.container;
        if (qCircleContactUpdateListContainer2 != null) {
            ab.c(qCircleContactUpdateListContainer2);
        }
        return this.container;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi
    public void initView(@Nullable ViewGroup parentView, boolean canShow) {
        if (parentView != null) {
            if (isEnable() && canShow) {
                if (parentView.getChildCount() > 0) {
                    return;
                }
                Context context = parentView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
                View createView = createView(context);
                if (createView == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "initFriendUpdateList return, bannerView == null ");
                    }
                    parentView.setVisibility(8);
                    return;
                } else {
                    parentView.setPadding(0, 0, 0, 0);
                    parentView.addView(createView, new ViewGroup.LayoutParams(-1, -2));
                    parentView.setVisibility(0);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initFriendUpdateList return, isEnable = false");
            }
            onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi
    public boolean isEnable() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_KEY, true) && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi
    public void onDestroy() {
        QCircleContactUpdateListContainer qCircleContactUpdateListContainer = this.container;
        if (qCircleContactUpdateListContainer != null) {
            ab.c(qCircleContactUpdateListContainer);
        }
        QCircleContactUpdateListContainer qCircleContactUpdateListContainer2 = this.container;
        if (qCircleContactUpdateListContainer2 != null) {
            qCircleContactUpdateListContainer2.onDestroy();
        }
        this.container = null;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi
    public void onPostThemeChanged() {
        QCircleContactUpdateListContainer qCircleContactUpdateListContainer = this.container;
        if (qCircleContactUpdateListContainer != null) {
            qCircleContactUpdateListContainer.d();
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi
    public void onRefresh() {
        QCircleContactUpdateListContainer qCircleContactUpdateListContainer = this.container;
        if (qCircleContactUpdateListContainer != null) {
            qCircleContactUpdateListContainer.e();
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi
    public void onResume() {
        QCircleContactUpdateListContainer qCircleContactUpdateListContainer = this.container;
        if (qCircleContactUpdateListContainer != null) {
            qCircleContactUpdateListContainer.onResume();
        }
    }
}
