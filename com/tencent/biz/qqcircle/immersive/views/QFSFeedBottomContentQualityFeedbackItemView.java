package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StChoiceQuestionBannerOption;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedBottomContentQualityFeedbackItemView extends QCircleBaseWidgetView<FeedCloudRead$StChoiceQuestionBannerOption> implements View.OnClickListener {
    private static final int I = cx.a(4.0f);
    private String C;
    private int D;
    private String E;
    private String F;
    private a G;
    private long H;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f90334d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90335e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90336f;

    /* renamed from: h, reason: collision with root package name */
    private e30.b f90337h;

    /* renamed from: i, reason: collision with root package name */
    private int f90338i;

    /* renamed from: m, reason: collision with root package name */
    private String f90339m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(String str);

        void b();
    }

    public QFSFeedBottomContentQualityFeedbackItemView(@NotNull Context context) {
        super(context);
        this.f90334d = (LinearLayout) findViewById(R.id.f39701cd);
        this.f90335e = (ImageView) findViewById(R.id.f39711ce);
        this.f90336f = (TextView) findViewById(R.id.f39721cf);
        this.f90334d.setOnClickListener(this);
        FontSettingManager.resetViewSize2Normal(context, this.f90334d);
    }

    private void l0() {
        int i3;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.f90337h;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.f90337h.g().f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90337h.g().poster.f398463id.get());
        }
        buildElementParams.put("xsj_tianshu_task_id", this.f90339m);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_ITEM_TEXT, this.E);
        if (this.D == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_FEEDBACK_ITEM_CONTAIN_EMOJI, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_ID, Integer.valueOf(this.D));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_TITLE, this.C);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_ITEM_SUM_NUM, Integer.valueOf(this.f90338i));
        VideoReport.setPageId(this, "pg_xsj_explore_page");
        VideoReport.setElementId(this.f90334d, QCircleDaTongConstant.ElementId.EM_XSJ_FEEDBACK_ITEM);
        VideoReport.reportEvent("dt_imp", this.f90334d, buildElementParams);
        VideoReport.setElementClickPolicy(this.f90334d, ClickPolicy.REPORT_NONE);
    }

    private void m0() {
        int i3;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.f90337h;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.f90337h.g().f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90337h.g().poster.f398463id.get());
        }
        buildElementParams.put("xsj_tianshu_task_id", this.f90339m);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_ITEM_TEXT, this.E);
        if (this.D == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_FEEDBACK_ITEM_CONTAIN_EMOJI, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_ID, Integer.valueOf(this.D));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_TITLE, this.C);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_ITEM_SUM_NUM, Integer.valueOf(this.f90338i));
        buildElementParams.put("play_duration", Long.valueOf(System.currentTimeMillis() - this.H));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
        VideoReport.setElementId(this.f90334d, QCircleDaTongConstant.ElementId.EM_XSJ_FEEDBACK_ITEM);
        VideoReport.reportEvent("dt_clck", this.f90334d, buildElementParams);
        VideoReport.setElementExposePolicy(this.f90334d, ExposurePolicy.REPORT_NONE);
    }

    private void n0() {
        if (!TextUtils.equals(this.F, "feedback_disappoint")) {
            QLog.e("QFSFeedBottomContentQualityFeedbackItemView", 1, "[doNegativeAction] is not FEEDBACK_DISAPPOINT");
            return;
        }
        QCircleToast.h(R.string.f1897740a, 1);
        a aVar = this.G;
        if (aVar != null) {
            aVar.b();
        }
    }

    private void o0() {
        this.f90334d.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.l9p));
        a aVar = this.G;
        if (aVar != null) {
            aVar.a(this.E);
        }
        n0();
    }

    private void p0(FeedCloudRead$StChoiceQuestionBannerOption feedCloudRead$StChoiceQuestionBannerOption) {
        int i3;
        if (feedCloudRead$StChoiceQuestionBannerOption == null) {
            QLog.e("QFSFeedBottomContentQualityFeedbackItemView", 1, "[updateOption] stChoiceQuestionBannerOption should not be null");
            return;
        }
        if (!TextUtils.isEmpty(feedCloudRead$StChoiceQuestionBannerOption.icon.get())) {
            try {
                int parseInt = Integer.parseInt(feedCloudRead$StChoiceQuestionBannerOption.icon.get().trim());
                this.D = parseInt;
                this.f90335e.setImageDrawable(QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.convertToLocal(parseInt)));
            } catch (Exception e16) {
                QLog.d("QFSFeedBottomContentQualityFeedbackItemView", 1, "[updateOption] emoji param exception:" + e16.toString());
            }
        }
        ImageView imageView = this.f90335e;
        if (this.D == 0) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        if (this.D != 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f90336f.getLayoutParams();
            layoutParams.leftMargin = I;
            this.f90336f.setLayoutParams(layoutParams);
        }
        String str = feedCloudRead$StChoiceQuestionBannerOption.content.get();
        this.E = str;
        this.f90336f.setText(str);
        this.F = feedCloudRead$StChoiceQuestionBannerOption.f398470id.get();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gai;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$StChoiceQuestionBannerOption feedCloudRead$StChoiceQuestionBannerOption, int i3) {
        p0(feedCloudRead$StChoiceQuestionBannerOption);
        l0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = System.currentTimeMillis();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (fb0.a.b("QFSFeedBottomContentQualityFeedbackItemView", 500L)) {
            QLog.e("QFSFeedBottomContentQualityFeedbackItemView", 1, "[onClick] is too fast");
        } else if (view.getId() == R.id.f39701cd) {
            o0();
            m0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setFeedBlockData(e30.b bVar) {
        this.f90337h = bVar;
    }

    public void setFeedbackTitle(String str) {
        this.C = str;
    }

    public void setOnSelectedListener(a aVar) {
        this.G = aVar;
    }

    public void setTaskId(String str) {
        this.f90339m = str;
    }

    public void setTotalOptions(int i3) {
        this.f90338i = i3;
    }
}
