package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleTagChallenge;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ab extends c implements View.OnClickListener {
    private static final List<Integer> K;
    private LinearLayout D;
    private View E;
    private TextView F;
    private TextView G;
    private QCircleTagChallengeInfo H;
    private final Rect I;
    private String J;

    static {
        ArrayList arrayList = new ArrayList();
        K = arrayList;
        arrayList.add(57);
        arrayList.add(501);
        arrayList.add(503);
        arrayList.add(591);
        arrayList.add(80001);
        arrayList.add(59);
        arrayList.add(Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED));
        arrayList.add(80000);
        arrayList.add(80002);
        arrayList.add(73);
        arrayList.add(71);
        arrayList.add(80003);
        arrayList.add(57);
        arrayList.add(97001);
    }

    public ab(@NonNull a aVar) {
        super(aVar);
        this.I = new Rect();
    }

    private void A() {
        if (this.H == null) {
            QLog.e("QFSFeedTagChallengeView", 1, "[jumpTagChallengePage] mTagChallengeInfo is null.");
            return;
        }
        if (y(this.f90601d)) {
            PreLoader.remove("2017");
            PreLoader.preLoad("2017", new com.tencent.biz.qqcircle.preload.task.j(v(this.H), (Activity) j()));
        }
        com.tencent.biz.qqcircle.launcher.c.u(this.f90604h.getContext(), v(this.H));
    }

    private void B(@NonNull View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f55002gq);
        this.D = (LinearLayout) view.findViewById(R.id.f34340yw);
        if (viewStub == null) {
            return;
        }
        View findViewById = viewStub.inflate().findViewById(R.id.f41421h1);
        this.E = findViewById;
        this.F = (TextView) findViewById.findViewById(R.id.f41441h3);
        this.G = (TextView) this.E.findViewById(R.id.f41431h2);
        this.E.setOnClickListener(this);
        this.J = view.getContext().getResources().getString(R.string.f185303o8);
    }

    private void C(boolean z16) {
        int i3;
        View view = this.E;
        int i16 = 0;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        LinearLayout linearLayout = this.D;
        if (linearLayout != null) {
            if (!z16) {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
        }
    }

    private void D() {
        QCircleTagChallengeInfo qCircleTagChallengeInfo = this.H;
        if (qCircleTagChallengeInfo != null && this.F != null && qCircleTagChallengeInfo.mTagChallenge != null) {
            this.F.setText(this.J + this.H.mTagChallenge.title);
            this.G.setText(this.H.mTagChallenge.subTitle);
            return;
        }
        QLog.w("QFSFeedTagChallengeView", 1, "[updateTagChallengeData] mTagChallengeInfo == null.");
    }

    private void t(View view) {
        QCircleTagChallenge qCircleTagChallenge;
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_CHALLENGE_BAR);
        HashMap hashMap = new HashMap();
        QCircleTagChallengeInfo qCircleTagChallengeInfo = this.H;
        if (qCircleTagChallengeInfo != null && (qCircleTagChallenge = qCircleTagChallengeInfo.mTagChallenge) != null) {
            hashMap.put("xsj_topic_name", qCircleTagChallenge.title);
        }
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(view, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_CHALLENGE_BAR + this.f90602e.f398449id.get());
    }

    private void u(View view) {
        QCircleTagChallenge qCircleTagChallenge;
        if (view == null) {
            QLog.d("QFSFeedTagChallengeView", 1, "[dtReportCustomReport] view == null.");
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QCircleTagChallengeInfo qCircleTagChallengeInfo = this.H;
        if (qCircleTagChallengeInfo != null && (qCircleTagChallenge = qCircleTagChallengeInfo.mTagChallenge) != null) {
            buildElementParams.put("xsj_topic_name", qCircleTagChallenge.title);
        }
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    private QCircleLayerBean v(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setTagChallengeInfo(qCircleTagChallengeInfo);
        qCircleLayerBean.setFromReportBean(p().m466clone());
        qCircleLayerBean.setSourceType(57);
        qCircleLayerBean.setLayerBizAssemblerType("biz_tag_challenge_page");
        return qCircleLayerBean;
    }

    private void w() {
        if (z()) {
            A();
            u(this.E);
        }
    }

    private boolean x() {
        return K.contains(Integer.valueOf(k().sourceType));
    }

    private boolean y(e30.b bVar) {
        if (bVar == null || bVar.g() == null) {
            return false;
        }
        boolean contains = bVar.g().opMask2.get().contains(19);
        QLog.d("QFSFeedTagChallengeView", 1, "[isNeedPreloadTagChallengeData] needPreload: ", Boolean.valueOf(contains));
        return contains;
    }

    private boolean z() {
        LinearLayout linearLayout;
        View view = this.E;
        if (view != null && view.getVisibility() == 0 && this.E.getGlobalVisibleRect(this.I) && (linearLayout = this.D) != null && linearLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 111;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        this.H = c40.d.c(this.f90601d);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return c40.d.h(this.f90602e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f41421h1) {
            w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("QFSFeedTagChallengeView", 1, "[onElementActivated]");
        B(this.f90604h);
        D();
        C(!x());
        t(this.E);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        C(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
