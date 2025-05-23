package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSCloseRecommendCollectBoxRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$CloseDraftFavoritesRsp;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRecommendCollectBoxItemView extends QFSCollectBoxItemView {
    private ImageView C;

    /* renamed from: m, reason: collision with root package name */
    private View f89360m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSRecommendCollectBoxItemView.this.r0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$CloseDraftFavoritesRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$CloseDraftFavoritesRsp feedCloudFavoritessvr$CloseDraftFavoritesRsp) {
            if (!z16 || j3 != 0 || feedCloudFavoritessvr$CloseDraftFavoritesRsp == null) {
                QLog.e("QFSRecommendCollectBoxItemView", 1, "collectBox close recommend error:" + j3 + "  errorMsg:" + str);
            }
        }
    }

    public QFSRecommendCollectBoxItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f89360m = findViewById(R.id.f41881i_);
        this.C = (ImageView) findViewById(R.id.f44171og);
    }

    private void q0() {
        VideoReport.setElementId(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_CLOSE_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        if (rVar != null) {
            List<FeedCloudFavoritessvr$FavoritesInfo> value = rVar.q2().getValue();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_NUM, Integer.valueOf(value.size()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_LIST_COLLECT_FOLDER_ID, com.tencent.biz.qqcircle.immersive.personal.utils.j.d(value));
        }
        VideoReport.setElementParams(this.C, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        if (rVar != null) {
            rVar.q2().setValue(new ArrayList());
            VSNetworkHelper.getInstance().sendRequest(new QFSCloseRecommendCollectBoxRequest(), new b());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSCollectBoxItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168731gn1;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSCollectBoxItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    protected String getLogTag() {
        return "QFSRecommendCollectBoxItemView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public QCircleBaseFragment getQCircleBaseFragment() {
        ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(getParentView());
        if (viewModelStoreOwner instanceof QCircleBaseFragment) {
            return (QCircleBaseFragment) viewModelStoreOwner;
        }
        return super.getQCircleBaseFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSCollectBoxItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, int i3) {
        super.bindData(feedCloudFavoritessvr$FavoritesInfo, i3);
        if (feedCloudFavoritessvr$FavoritesInfo == null) {
            return;
        }
        if (i3 == 0) {
            this.f89360m.setVisibility(0);
            this.C.setOnClickListener(new a());
            q0();
            return;
        }
        this.f89360m.setVisibility(8);
    }
}
