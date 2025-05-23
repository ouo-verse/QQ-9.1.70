package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.graphics.Outline;
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
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;

/* loaded from: classes4.dex */
public class QFSLayerFeedPropItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {
    private String C;
    private String D;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f90377d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90378e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90379f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90380h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90381i;

    /* renamed from: m, reason: collision with root package name */
    private String f90382m;

    /* loaded from: classes4.dex */
    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), DisplayUtil.dip2px(QFSLayerFeedPropItemView.this.getContext(), 8.0f));
        }
    }

    public QFSLayerFeedPropItemView(@NonNull Context context) {
        super(context);
        this.f90382m = "";
        this.C = "";
        this.D = "";
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f90377d = (LinearLayout) findViewById(R.id.f44871qc);
        this.f90378e = (ImageView) findViewById(R.id.f44371p0);
        this.f90379f = (TextView) findViewById(R.id.f56412kj);
        this.f90380h = (TextView) findViewById(R.id.f56422kk);
        this.f90381i = (TextView) findViewById(R.id.f56432kl);
        this.f90377d.setOutlineProvider(new a());
        this.f90377d.setClipToOutline(true);
        this.f90377d.setOnClickListener(this);
        this.f90381i.setOnClickListener(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168692gf2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPropItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        String str;
        String a16 = af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "cover_url");
        this.f90382m = qQCircleDitto$StItemInfo.f429300id.get();
        this.C = af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "jump_url");
        this.D = qQCircleDitto$StItemInfo.buttonInfo.jumpUrl.get();
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(a16).setTargetView(this.f90378e));
        String str2 = qQCircleDitto$StItemInfo.name.get();
        this.f90379f.setText(str2);
        if (qQCircleDitto$StItemInfo.des.get().size() > 0) {
            str = qQCircleDitto$StItemInfo.des.get(0);
        } else {
            str = "";
        }
        this.f90380h.setText(str);
        this.f90381i.setText(qQCircleDitto$StItemInfo.buttonInfo.name.get());
        String str3 = qQCircleDitto$StItemInfo.f429300id.get();
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_prop_id", str3);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROP_NAME, str2);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROP_INDEX, Integer.valueOf(i3 + 1));
        VideoReport.setElementId(this.f90377d, QCircleDaTongConstant.ElementId.EM_XSJ_PROP_ITEM);
        VideoReport.setElementParams(this.f90377d, buildElementParams);
        VideoReport.setElementId(this.f90381i, QCircleDaTongConstant.ElementId.EM_XSJ_SAMESTYLE_BUTTON);
        VideoReport.setElementParams(this.f90381i, buildElementParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(613).setSubActionType(5).setExt3(this.f90382m));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f44871qc) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(613).setSubActionType(7).setExt3(this.f90382m));
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.C);
        } else if (id5 == R.id.f56432kl) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(613).setSubActionType(6).setExt3(this.f90382m));
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.D);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
