package com.tencent.mobileqq.tvideo.base;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.activity.TVideoFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.TVideoLayerBean;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.viewmodel.j;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.HashMap;
import java.util.Map;
import tvideo.Video;
import zt2.k;

/* loaded from: classes19.dex */
public class TVideoLayerMultiTabPageFragment extends QFSLayerPageFragment implements com.tencent.mobileqq.pad.f {
    private QCircleInitBean F;

    private void setDtCustomPageId(Map<String, Object> map, Object obj) {
        if (map != null && (obj instanceof QCircleReportBean)) {
            Object obj2 = map.get("xsj_custom_pgid");
            if (!(obj2 instanceof String)) {
                return;
            }
            ((QCircleReportBean) obj).setDtCustomPageId((String) obj2);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        QCircleInitBean initBean = getInitBean();
        if (initBean instanceof TVideoLayerBean) {
            Video q16 = jy2.g.q(initBean.getFeed());
            if (q16 != null) {
                hashMap.put(QAdVrReportParams.ParamKey.PG_VID, q16.video_base_info.vid);
                hashMap.put(QAdVrReportParams.ParamKey.PG_CID, q16.video_base_info.cid);
                hashMap.put("material_vid", q16.video_base_info.material_aspect_vid);
                hashMap.put("material_starting_time", Integer.valueOf(q16.video_base_info.material_starting_time));
                hashMap.put("material_end_time", Integer.valueOf(q16.video_base_info.material_end_time));
            }
            hashMap.put(QAdVrReportParams.ParamKey.PLAYBOX_TYPE, Integer.valueOf(gy2.c.r()));
        }
        return hashMap;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.i2g;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "page_ugqqoa_play";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment
    protected QCircleInitBean getInitBean() {
        QCircleInitBean qCircleInitBean = this.F;
        if (qCircleInitBean != null) {
            return qCircleInitBean;
        }
        QCircleInitBean initBean = super.getInitBean();
        if (initBean == null && getArguments() != null) {
            QCircleInitBean qCircleInitBean2 = (QCircleInitBean) getArguments().getSerializable("key_bundle_common_init_bean");
            this.F = qCircleInitBean2;
            return qCircleInitBean2;
        }
        this.F = initBean;
        return initBean;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!(getActivity() instanceof TVideoFragmentActivity)) {
            jy2.g.t();
            new b().d(QCircleApplication.APP.getApplicationContext(), getLifecycle());
            zt2.e.f453199a.r();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.tvideo.pr.e.e().i();
        zt2.e.f453199a.t();
        jx2.c.k().i();
        gy2.c.l();
        iy2.a.a();
        k.b();
        j.a();
        com.tencent.mobileqq.tvideo.temporaryauth.d.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        gy2.a.b(3);
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
        if (((QCircleBaseFragment) this).mContentView == null) {
            QLog.i("TVideoLayerMultiTabPageFragment", 1, "reportDaTongRegister  mContentView == null , subPage: " + getTAG());
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        String daTongPageId = getDaTongPageId();
        Map<String, Object> childDaTongPageParams = getChildDaTongPageParams();
        VideoReport.setPageParams(((QCircleBaseFragment) this).mContentView, gy2.c.f(getTAG(), childDaTongPageParams));
        VideoReport.setPageId(((QCircleBaseFragment) this).mContentView, daTongPageId);
        Object createViewTagData = createViewTagData();
        setDtCustomPageId(childDaTongPageParams, createViewTagData);
        ((QCircleBaseFragment) this).mContentView.setTag(TagData.TAG_DATA_ID, createViewTagData);
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }
}
