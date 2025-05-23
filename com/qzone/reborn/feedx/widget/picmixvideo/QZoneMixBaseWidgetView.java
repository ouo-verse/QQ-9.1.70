package com.qzone.reborn.feedx.widget.picmixvideo;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneMixBaseWidgetView extends QZoneBaseWidgetView<PictureItem> {
    private int C;

    /* renamed from: e, reason: collision with root package name */
    protected BusinessFeedData f56454e;

    /* renamed from: f, reason: collision with root package name */
    protected int f56455f;

    /* renamed from: h, reason: collision with root package name */
    protected int f56456h;

    /* renamed from: i, reason: collision with root package name */
    protected RoundCorneredFrameLayout f56457i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f56458m;

    public QZoneMixBaseWidgetView(Context context) {
        this(context, null);
    }

    private void m0() {
        BusinessFeedData businessFeedData;
        ViewGroup.LayoutParams layoutParams;
        if (this.f56457i != null && (businessFeedData = this.f56454e) != null && businessFeedData.getPictureInfo() != null && !bl.b(this.f56454e.getPictureInfo().pics)) {
            ViewGroup.LayoutParams layoutParams2 = this.f56457i.getLayoutParams();
            if (this.f56454e.getPictureInfo().pics.size() > 1) {
                Pair<Integer, Integer> f16 = b.f(q0(), this.f56454e.getPictureInfo().pics.size());
                if (layoutParams2 != null) {
                    layoutParams2.width = ((Integer) f16.first).intValue();
                    layoutParams2.height = ((Integer) f16.second).intValue();
                }
            } else {
                b.a(getContext(), this.f56454e, layoutParams2, b.h(this.f56454e.getPictureInfo().pics.get(0)), q0());
            }
            this.f56457i.setLayoutParams(layoutParams2);
            if (p0() == null || (layoutParams = p0().getLayoutParams()) == null || layoutParams2 == null) {
                return;
            }
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            p0().setLayoutParams(layoutParams);
            return;
        }
        QLog.e(getLogTag(), 1, "getPicItemMeasuredWidth  params error");
    }

    private TextView o0() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(24.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setBackgroundColor(Color.parseColor("#4D000000"));
        return textView;
    }

    protected abstract String getLogTag();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(PictureItem pictureItem, int i3) {
        m0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f56454e != null) {
            m0();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (com.qzone.reborn.configx.g.f53821a.b().J1()) {
            m0();
        }
    }

    public abstract ImageView p0();

    /* JADX INFO: Access modifiers changed from: protected */
    public int q0() {
        return pl.a.f426446a.l(getContext()) - this.C;
    }

    public void r0() {
        TextView textView = this.f56458m;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public boolean s0() {
        TextView textView = this.f56458m;
        return textView != null && textView.getVisibility() == 0;
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.f56454e = businessFeedData;
    }

    public void setFeedPosition(int i3) {
        this.f56455f = i3;
    }

    public void setItemViewMultiBorderWidth(int i3) {
        this.C = i3;
    }

    public void setPicPosition(int i3) {
        this.f56456h = i3;
    }

    public void u0(int i3) {
        if (this.f56458m == null) {
            TextView o06 = o0();
            this.f56458m = o06;
            this.f56457i.addView(o06);
        }
        this.f56458m.setVisibility(0);
        this.f56458m.setText(Marker.ANY_NON_NULL_MARKER + i3);
    }

    public QZoneMixBaseWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZoneMixBaseWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
