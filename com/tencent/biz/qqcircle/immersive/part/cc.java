package com.tencent.biz.qqcircle.immersive.part;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cc extends u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private Button f87803d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f87804e = false;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StFeed f87805f;

    /* renamed from: h, reason: collision with root package name */
    private String f87806h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f87807i;

    private void A9() {
        if (this.f87804e) {
            return;
        }
        View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f45221ra)).inflate();
        this.f87807i = (FrameLayout) inflate.findViewById(R.id.f44731pz);
        Button button = (Button) inflate.findViewById(R.id.f44721py);
        this.f87803d = button;
        button.setOnClickListener(this);
        this.f87804e = true;
    }

    private void B9(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QFSLayerJumpButtonPart", 1, "url is empty");
        } else {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), str);
        }
    }

    private void C9(View view, String str) {
        if (this.f87805f == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", this.f87805f.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f87805f.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_BIZ_NAME, this.f87805f.communityInfo.name.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CIRCLE_ID, Integer.valueOf(this.f87805f.communityInfo.subSource.get()));
        buildElementParams.put("come_from", z9());
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private void D9(boolean z16) {
        int i3;
        FrameLayout frameLayout = this.f87807i;
        if (frameLayout == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
    }

    private void x9(e30.b bVar) {
        if (bVar != null && bVar.g() != null && !TextUtils.isEmpty(bVar.g().communityInfo.schemaURL.get())) {
            this.f87805f = bVar.g();
            this.f87806h = bVar.g().communityInfo.schemaURL.get();
            A9();
            D9(true);
            this.f87803d.setText(this.f87805f.communityInfo.name.get());
            C9(this.f87803d, QCircleDaTongConstant.ElementId.EM_XSJ_BUSINESS_LAUNCH_ENTRANCE_BUTTON);
            return;
        }
        D9(false);
    }

    private String z9() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getActivity());
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            if (!qCircleInitBean.getSchemeAttrs().containsKey("xsj_main_entrance")) {
                return "";
            }
            return qCircleInitBean.getSchemeAttrs().get("xsj_main_entrance");
        }
        QLog.e("QFSLayerJumpButtonPart", 1, "[parseSchemeAttrs] schemeAttr is null");
        return "";
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerJumpButtonPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (!"layer_notify_part_update_feed".equals(str) || !(obj instanceof e30.b)) {
            return;
        }
        x9((e30.b) obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f44721py) {
            B9(this.f87806h);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }
}
