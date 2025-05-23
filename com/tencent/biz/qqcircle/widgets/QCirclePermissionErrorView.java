package com.tencent.biz.qqcircle.widgets;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes5.dex */
public class QCirclePermissionErrorView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f93046d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93047e;

    public QCirclePermissionErrorView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleSchemeLauncher.d(getContext(), "mqqapi://qcircle/openfolder?tabtype=6&is_force_jump_sub_page=1");
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void b() {
        VideoReport.setElementId(this.f93046d, QCircleDaTongConstant.ElementId.EM_XSJ_MOREVIDEO_BUTTON);
        VideoReport.setElementReuseIdentifier(this.f93046d, QCircleDaTongConstant.ElementId.EM_XSJ_MOREVIDEO_BUTTON);
        VideoReport.setElementParams(this.f93046d, new QCircleDTParamBuilder().buildElementParams());
    }

    public void d(Activity activity) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(this, QCircleDaTongConstant.PageId.PG_XSJ_PRIVATE_VIDEO_DETAIL_PAGE);
        VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams(QCircleDaTongConstant.PageId.PG_XSJ_PRIVATE_VIDEO_DETAIL_PAGE));
        QLog.i("QCirclePermissionErrorView", 1, "QCirclePermissionErrorView, pageId: " + QCircleDaTongConstant.PageId.PG_XSJ_PRIVATE_VIDEO_DETAIL_PAGE);
    }

    public void e(Activity activity, String str) {
        TextView textView;
        setVisibility(0);
        d(activity);
        b();
        if (!TextUtils.isEmpty(str) && (textView = this.f93047e) != null) {
            textView.setText(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f93046d = (TextView) findViewById(R.id.f44711px);
        this.f93047e = (TextView) findViewById(R.id.f47901yj);
        this.f93046d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCirclePermissionErrorView.this.c(view);
            }
        });
    }

    public QCirclePermissionErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QCirclePermissionErrorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
