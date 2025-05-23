package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.k0.d;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VerticalStepView extends LinearLayout implements VerticalStepViewIndicator.a {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f152208a;

    /* renamed from: b, reason: collision with root package name */
    public VerticalStepViewIndicator f152209b;

    /* renamed from: c, reason: collision with root package name */
    public List f152210c;

    /* renamed from: d, reason: collision with root package name */
    public int f152211d;

    /* renamed from: e, reason: collision with root package name */
    public int f152212e;

    /* renamed from: f, reason: collision with root package name */
    public int f152213f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f152214g;

    public VerticalStepView(Context context) {
        this(context, null);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator.a
    public void a() {
        RelativeLayout relativeLayout = this.f152208a;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            List<Float> circleCenterPointPositionList = this.f152209b.getCircleCenterPointPositionList();
            if (this.f152210c != null && circleCenterPointPositionList != null && circleCenterPointPositionList.size() > 0 && this.f152210c.size() > 0) {
                TextView textView = new TextView(getContext());
                this.f152214g = textView;
                textView.setTextSize(2, this.f152213f);
                d.a(this.f152210c.get(0));
                throw null;
            }
        }
    }

    public final void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.i4g, this);
        VerticalStepViewIndicator verticalStepViewIndicator = (VerticalStepViewIndicator) inflate.findViewById(R.id.f88394wy);
        this.f152209b = verticalStepViewIndicator;
        verticalStepViewIndicator.setOnDrawListener(this);
        this.f152208a = (RelativeLayout) inflate.findViewById(R.id.f760240j);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public VerticalStepView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalStepView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152211d = ContextCompat.getColor(getContext(), R.color.cxp);
        this.f152212e = ContextCompat.getColor(getContext(), android.R.color.white);
        this.f152213f = 14;
        b();
    }
}
