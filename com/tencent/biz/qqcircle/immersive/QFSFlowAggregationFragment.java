package com.tencent.biz.qqcircle.immersive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import x30.l;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFlowAggregationFragment extends QFSBaseFragment {
    private QFSBaseBlockPart E;
    private com.tencent.biz.qqcircle.bizparts.c F;
    private x30.e G;
    private QFSFlowAggregationInitBean H;
    private QFSFlowAggregationViewModel I;
    private w30.a J;
    private String K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
            QFSFlowAggregationFragment.this.K = uIStateData.getData().unifiedTagPageData.title.get();
            QFSFlowAggregationFragment.this.registerDaTongReportPageId();
        }
    }

    private void initIntentData() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra("key_bundle_common_init_bean")) {
            this.H = (QFSFlowAggregationInitBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        }
    }

    private void initViewModel() {
        this.I = (QFSFlowAggregationViewModel) getViewModel(QFSFlowAggregationViewModel.class);
        w20.a.j().registerDisplaySurface(this.I.k2(), this.I);
        this.I.z2(this.H);
        this.I.X1().observe(this, new a());
        this.I.w2(true);
    }

    private void th() {
        BlockContainer blockContainer = this.E.getBlockContainer();
        blockContainer.setParentFragment(this);
        blockContainer.setEnableRefresh(false);
        blockContainer.setEnableLoadMore(false);
    }

    private void uh(Bundle bundle) {
        this.J = new w30.a(bundle);
    }

    private void vh(Bundle bundle) {
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = this.H;
        if (qFSFlowAggregationInitBean == null) {
            this.F = null;
            return;
        }
        int aggregationType = qFSFlowAggregationInitBean.getAggregationType();
        if (aggregationType != 43) {
            if (aggregationType == 44) {
                this.F = new w30.d(bundle);
                return;
            }
            return;
        }
        this.F = new w30.c(bundle);
    }

    private List<MultiViewBlock> wh() {
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        vh(bundle);
        uh(bundle);
        arrayList.add(this.F);
        arrayList.add(this.J);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QFSBaseBlockPart qFSBaseBlockPart = new QFSBaseBlockPart(R.id.vfr, wh(), 1, 1);
        this.E = qFSBaseBlockPart;
        arrayList.add(qFSBaseBlockPart);
        if (o83.a.f422212a.d() && (this.H.getAggregationType() == 44 || this.H.getAggregationType() == 43)) {
            arrayList.add(new l(this.H));
            arrayList.add(new QFSSharePart());
        } else {
            x30.e eVar = new x30.e(this.H);
            this.G = eVar;
            arrayList.add(eVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = this.H;
        if (qFSFlowAggregationInitBean == null) {
            return hashMap;
        }
        int aggregationType = qFSFlowAggregationInitBean.getAggregationType();
        if (aggregationType != 43) {
            if (aggregationType == 44 && this.H.getFeedUnifiedTag() != null) {
                hashMap.put("xsj_material_type", this.H.getFeedUnifiedTag().unifiedType.get());
                hashMap.put("xsj_material_id", this.H.getFeedUnifiedTag().unifiedId.get());
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MATERIAL_NAME, this.K);
            }
        } else if (this.H.getFeedMusic() != null) {
            hashMap.put("xsj_material_type", "music");
            hashMap.put("xsj_material_id", this.H.getFeedMusic().MID.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MUSIC_TYPE, Integer.valueOf(this.H.getFeedMusic().scene.get()));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_ONLINE, Integer.valueOf(!TextUtils.isEmpty(this.H.getFeedMusic().playUrl.get()) ? 1 : 0));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g7h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = this.H;
        if (qFSFlowAggregationInitBean == null) {
            return "";
        }
        int aggregationType = qFSFlowAggregationInitBean.getAggregationType();
        if (aggregationType != 43) {
            if (aggregationType != 44) {
                return "";
            }
            return QCircleDaTongConstant.PageId.PG_XSJ_MATERIAL_AGG_PAGE;
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_MUSIC_AGG_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAggregationFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = this.H;
        if (qFSFlowAggregationInitBean == null) {
            return 0;
        }
        int aggregationType = qFSFlowAggregationInitBean.getAggregationType();
        if (aggregationType != 43) {
            if (aggregationType != 44) {
                return 0;
            }
            return 80002;
        }
        return 80000;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        initIntentData();
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        th();
    }

    public int sh() {
        return this.H.getAggregationType();
    }
}
