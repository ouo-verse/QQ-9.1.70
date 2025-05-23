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
public class QZMPublishPreview extends QZoneBaseWidgetView<QZMPublishCaptureBean> {

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f59137e;

    /* renamed from: f, reason: collision with root package name */
    private RoundCornerImageView f59138f;

    /* renamed from: h, reason: collision with root package name */
    private QZMPublishCaptureBean f59139h;

    public QZMPublishPreview(Context context) {
        this(context, null);
    }

    private String o0(boolean z16) {
        QZMPublishCaptureBean qZMPublishCaptureBean = this.f59139h;
        if (qZMPublishCaptureBean == null) {
            return "";
        }
        if (z16) {
            return qZMPublishCaptureBean.getBackUrl();
        }
        return qZMPublishCaptureBean.getFrontUrl();
    }

    private void p0() {
        QZMPublishCaptureBean qZMPublishCaptureBean = this.f59139h;
        if (qZMPublishCaptureBean == null) {
            return;
        }
        qZMPublishCaptureBean.reverse();
        s0();
        u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        p0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void s0() {
        Option obtain = Option.obtain();
        obtain.setUrl(o0(true));
        obtain.setTargetView(this.f59137e);
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    private void u0() {
        Option obtain = Option.obtain();
        obtain.setUrl(o0(false));
        obtain.setTargetView(this.f59138f);
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f128413a;
    }

    public QZMPublishPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q0();
    }

    private void q0() {
        this.f59137e = (RoundCornerImageView) findViewById(R.id.kue);
        this.f59138f = (RoundCornerImageView) findViewById(R.id.lva);
        this.f59137e.setCorner(ImmersiveUtils.dpToPx(8.0f));
        this.f59138f.setBorder(true);
        this.f59138f.setCorner(ImmersiveUtils.dpToPx(4.0f));
        this.f59138f.setBorderWidth(ImmersiveUtils.dpToPx(2.0f));
        this.f59138f.setColor(getResources().getColor(R.color.qui_common_fill_light_tertiary));
        this.f59138f.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZMPublishPreview.this.r0(view);
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
        this.f59139h = qZMPublishCaptureBean;
        s0();
        u0();
    }
}
