package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.qqcircle.preload.task.j;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedWaterFallHotTopicItemView extends QFSMixFeedBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {
    private static final int F = cx.a(15.0f);
    private TextView C;
    private LinearLayout D;
    private QCircleTagChallengeInfo E;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f90898e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f90899f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90900h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90901i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90902m;

    public QFSMixFeedWaterFallHotTopicItemView(@NotNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f90898e = (LinearLayout) findViewById(R.id.yon);
        this.f90899f = (LinearLayout) findViewById(R.id.yo5);
        this.D = (LinearLayout) findViewById(R.id.yrh);
        this.f90900h = (TextView) findViewById(R.id.kbs);
        this.C = (TextView) findViewById(R.id.k6s);
        this.f90901i = (TextView) findViewById(R.id.f112486o2);
        this.f90902m = (TextView) findViewById(R.id.f112606od);
        this.f90898e.setOnClickListener(this);
    }

    private void l0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        LinearLayout linearLayout;
        if (qQCircleDitto$StItemInfo != null && (linearLayout = this.f90898e) != null) {
            VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_HOT_TOPIC);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_topic_name", QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "tag_name"));
            VideoReport.setElementParams(this.f90898e, hashMap);
            VideoReport.setElementReuseIdentifier(this.f90898e, QCircleDaTongConstant.ElementId.EM_XSJ_HOT_TOPIC + i3);
        }
    }

    private QCircleLayerBean m0(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setTagChallengeInfo(qCircleTagChallengeInfo);
        qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
        qCircleLayerBean.setSourceType(57);
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.sourceType = 97001;
        qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
        qCircleLayerBean.setLayerBizAssemblerType("biz_tag_challenge_page");
        return qCircleLayerBean;
    }

    private void n0(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        if (qCircleTagChallengeInfo == null) {
            QLog.e("QFSMixFeedWaterFallHotTopicItemView", 1, "[jumpTagChallengePage] mTagChallengeInfo is null.");
        } else {
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), m0(qCircleTagChallengeInfo));
        }
    }

    private void o0(int i3) {
        if (i3 == 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f90899f.getLayoutParams();
        layoutParams.setMargins(0, cx.a(16.0f), 0, 0);
        this.f90899f.setLayoutParams(layoutParams);
    }

    private void p0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        this.f90900h.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "tag_name"));
        if (!TextUtils.isEmpty(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "topic_desc_copywriting"))) {
            this.C.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "topic_desc_copywriting"));
            this.C.setVisibility(0);
            this.D.setVisibility(8);
        } else {
            this.f90901i.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "visitor_desc_copywriting"));
            this.f90902m.setText(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "feed_num_desc_copywriting"));
            this.D.setVisibility(0);
            this.C.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g4o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedWaterFallHotTopicItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i3 = F;
        layoutParams.setMargins(i3, 0, i3, 0);
        return layoutParams;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        if (qQCircleDitto$StItemInfo == null) {
            return;
        }
        this.E = c40.d.e(qQCircleDitto$StItemInfo.tag);
        p0(qQCircleDitto$StItemInfo);
        o0(i3);
        l0(qQCircleDitto$StItemInfo, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.yon) {
            PreLoader.remove("2017");
            PreLoader.preLoad("2017", new j(m0(this.E), (Activity) getContext()));
            n0(this.E);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
