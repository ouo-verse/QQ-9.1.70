package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.af;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedMulHotTagItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {
    private static final Drawable G = new ColorDrawable(0);
    private ImageView C;
    private String D;
    private String E;
    private String F;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f90370d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90371e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f90372f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90373h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90374i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90375m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), DisplayUtil.dip2px(QFSLayerFeedMulHotTagItemView.this.getContext(), 8.0f));
        }
    }

    public QFSLayerFeedMulHotTagItemView(@NonNull Context context) {
        super(context);
        this.D = "";
        this.E = "";
        this.F = "";
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f90370d = (LinearLayout) findViewById(R.id.f46141ts);
        this.f90371e = (ImageView) findViewById(R.id.f44351oy);
        this.f90372f = (ImageView) findViewById(R.id.f44361oz);
        this.f90373h = (TextView) findViewById(R.id.f56382kg);
        this.f90374i = (TextView) findViewById(R.id.f56392kh);
        this.f90375m = (TextView) findViewById(R.id.f56402ki);
        this.C = (ImageView) findViewById(R.id.f44461p9);
        this.f90370d.setOutlineProvider(new a());
        this.f90370d.setClipToOutline(true);
    }

    private void l0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSHotTagItemView", 1, "[updateHotBackground] sendBgUrl is null");
            return;
        }
        this.f90375m.setBackgroundDrawable(G);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(this.C));
    }

    private void m0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo != null && this.f90372f != null) {
            String a16 = af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "icon_url");
            if (TextUtils.isEmpty(a16)) {
                this.f90372f.setVisibility(8);
                return;
            } else {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(a16).setTargetView(this.f90372f));
                this.f90372f.setVisibility(0);
                return;
            }
        }
        QLog.e("QFSHotTagItemView", 1, "[updateHotTagIcon] stItemInfo is null");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gew;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSHotTagItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        String str;
        if (qQCircleDitto$StItemInfo == null) {
            QLog.e("QFSHotTagItemView", 1, "[bindData] stItemInfo is null");
            return;
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "cover_url")).setTargetView(this.f90371e));
        m0(qQCircleDitto$StItemInfo);
        this.D = qQCircleDitto$StItemInfo.name.get();
        this.F = af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "jump_url");
        this.E = qQCircleDitto$StItemInfo.buttonInfo.jumpUrl.get();
        this.f90373h.setText(this.D);
        this.f90375m.setText(qQCircleDitto$StItemInfo.buttonInfo.name.get());
        l0(qQCircleDitto$StItemInfo.buttonInfo.style.button_diaplay_url.get());
        TextView textView = this.f90374i;
        if (qQCircleDitto$StItemInfo.des.get().size() > 0) {
            str = qQCircleDitto$StItemInfo.des.get(0);
        } else {
            str = "";
        }
        textView.setText(str);
        this.f90375m.setOnClickListener(this);
        this.f90370d.setOnClickListener(this);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_topic_id", qQCircleDitto$StItemInfo.f429300id.get());
        buildElementParams.put("xsj_topic_name", this.D);
        buildElementParams.put("xsj_topic_index", Integer.valueOf(i3 + 1));
        VideoReport.setElementId(this.f90370d, "em_xsj_topic_item");
        VideoReport.setElementParams(this.f90370d, buildElementParams);
        VideoReport.setElementId(this.f90375m, QCircleDaTongConstant.ElementId.EM_XSJ_CONTRIBUTE_BUTTON);
        VideoReport.setElementParams(this.f90375m, buildElementParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(611).setSubActionType(4).setExt3(this.D));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f56402ki) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(611).setSubActionType(5).setExt3(this.D));
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.E);
        } else if (id5 == R.id.f46141ts) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(611).setSubActionType(6).setExt3(this.D));
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.F);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
