package com.qzone.reborn.qzmoment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.reborn.qzmoment.bean.QZMPublishCaptureBean;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes37.dex */
public class QZMMessagePreview extends QZoneBaseWidgetView<QZMPublishCaptureBean> {

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f59132e;

    /* renamed from: f, reason: collision with root package name */
    private RoundCornerImageView f59133f;

    /* renamed from: h, reason: collision with root package name */
    private QZMPublishCaptureBean f59134h;

    public QZMMessagePreview(Context context) {
        this(context, null);
    }

    private String o0(boolean z16) {
        QZMPublishCaptureBean qZMPublishCaptureBean = this.f59134h;
        if (qZMPublishCaptureBean == null) {
            return "";
        }
        if (z16) {
            return qZMPublishCaptureBean.getBackUrl();
        }
        return qZMPublishCaptureBean.getFrontUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void r0() {
        Option obtain = Option.obtain();
        obtain.setUrl(o0(true));
        obtain.setTargetView(this.f59132e);
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    private void s0() {
        Option obtain = Option.obtain();
        obtain.setUrl(o0(false));
        obtain.setTargetView(this.f59133f);
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1283232;
    }

    public QZMMessagePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p0();
    }

    private void p0() {
        this.f59132e = (RoundCornerImageView) findViewById(R.id.kue);
        this.f59133f = (RoundCornerImageView) findViewById(R.id.lva);
        this.f59132e.setCorner(ImmersiveUtils.dpToPx(4.0f));
        this.f59133f.setBorder(true);
        this.f59133f.setCorner(ImmersiveUtils.dpToPx(2.0f));
        this.f59133f.setBorderWidth(ImmersiveUtils.dpToPx(1.0f));
        this.f59133f.setColor(getResources().getColor(R.color.qui_common_fill_light_tertiary));
        this.f59133f.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZMMessagePreview.q0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZMPublishCaptureBean qZMPublishCaptureBean, int i3) {
        if (qZMPublishCaptureBean == null) {
            return;
        }
        this.f59134h = qZMPublishCaptureBean;
        r0();
        s0();
    }
}
