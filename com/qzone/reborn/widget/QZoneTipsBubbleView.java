package com.qzone.reborn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneTipsBubbleView extends QZoneBaseWidgetView {

    /* renamed from: e, reason: collision with root package name */
    private TextView f59654e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f59655f;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f59656h;

    public QZoneTipsBubbleView(Context context) {
        super(context);
        this.f59656h = new Runnable() { // from class: com.qzone.reborn.widget.QZoneTipsBubbleView.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneTipsBubbleView.this.m0();
            }
        };
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.co6;
    }

    public void m0() {
        getMainHandler().removeCallbacks(this.f59656h);
        setVisibility(8);
    }

    public QZoneTipsBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f59656h = new Runnable() { // from class: com.qzone.reborn.widget.QZoneTipsBubbleView.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneTipsBubbleView.this.m0();
            }
        };
        n0(this);
    }

    private void n0(View view) {
        this.f59654e = (TextView) view.findViewById(R.id.nbl);
        this.f59655f = (ImageView) view.findViewById(R.id.nbk);
        setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
