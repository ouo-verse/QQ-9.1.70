package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta$MaterialInfo;
import java.util.Map;

/* loaded from: classes5.dex */
public class QFSPolymerizationTemplateItemView extends QCircleBaseWidgetView<FeedCloudMeta$MaterialInfo> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f93800d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f93801e;

    /* renamed from: f, reason: collision with root package name */
    private SquareImageView f93802f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93803h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f93804i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$MaterialInfo f93805m;

    public QFSPolymerizationTemplateItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93800d = (LinearLayout) findViewById(R.id.f493022b);
        this.f93801e = (ImageView) findViewById(R.id.f4926228);
        this.f93802f = (SquareImageView) findViewById(R.id.f492922a);
        this.f93803h = (TextView) findViewById(R.id.f492822_);
        TextView textView = (TextView) findViewById(R.id.f4927229);
        this.f93804i = textView;
        textView.setOnClickListener(this);
    }

    private void l0() {
        TextView textView = this.f93804i;
        if (textView != null && this.f93805m != null) {
            VideoReport.setElementId(textView, "em_xsj_template_item");
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_material_id", this.f93805m.f398443id.get());
            VideoReport.setElementParams(this.f93804i, buildElementParams);
        }
    }

    private void m0(String str) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.f93802f).setUrl(str).setRequestWidth(cx.a(40.0f)).setRequestHeight(cx.a(40.0f)));
    }

    private void n0() {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_tag_tuijian_bg")).setTargetView(this.f93801e).setRequestWidth(this.f93801e.getLayoutParams().width).setRequestHeight(this.f93801e.getLayoutParams().height).setLoadingDrawableColor(0).setFailedDrawableColor(0));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gnq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPolymerizationTemplateItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$MaterialInfo feedCloudMeta$MaterialInfo, int i3) {
        if (feedCloudMeta$MaterialInfo == null) {
            QLog.e("QFSPolymerizationTemplateItemView", 1, "[bindData] materialInfo == null");
            LinearLayout linearLayout = this.f93800d;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        this.f93805m = feedCloudMeta$MaterialInfo;
        m0(feedCloudMeta$MaterialInfo.iconURL.get());
        this.f93803h.setText(feedCloudMeta$MaterialInfo.title.get());
        this.f93804i.setText(feedCloudMeta$MaterialInfo.buttonName.get());
        n0();
        l0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f4927229 && this.f93805m != null) {
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), this.f93805m.jumpURL.get());
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
