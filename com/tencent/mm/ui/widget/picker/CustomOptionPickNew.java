package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.dc.a;
import com.tencent.luggage.wxa.fc.c;
import com.tencent.luggage.wxa.fc.d;
import com.tencent.luggage.wxa.hc.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mobileqq.R;
import java.util.Arrays;

/* loaded from: classes9.dex */
public class CustomOptionPickNew extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public String[] f153511a;

    /* renamed from: b, reason: collision with root package name */
    public b f153512b;

    /* renamed from: c, reason: collision with root package name */
    public Context f153513c;

    /* renamed from: d, reason: collision with root package name */
    public int f153514d;

    /* renamed from: e, reason: collision with root package name */
    public int f153515e;

    public CustomOptionPickNew(Context context) {
        super(new ContextThemeWrapper(context, R.style.at_));
        this.f153513c = context;
        this.f153512b = new b(context);
        init();
    }

    public int currentIndex() {
        return getValue();
    }

    public String currentValue() {
        this.f153512b.n();
        return this.f153511a[this.f153514d];
    }

    public int getValue() {
        this.f153512b.n();
        return this.f153514d;
    }

    public WheelView getView() {
        return this.f153512b.l();
    }

    public void init() {
        new a(this.f153513c, new d() { // from class: com.tencent.mm.ui.widget.picker.CustomOptionPickNew.1
            @Override // com.tencent.luggage.wxa.fc.d
            public void onOptionsSelect(int i3) {
                CustomOptionPickNew.this.f153514d = i3;
            }
        }).b(this.f153515e).a(ContextCompat.getColor(this.f153513c, R.color.f156611ai0)).a(this.f153512b);
        setDividerHeight(this.f153513c.getResources().getDimensionPixelSize(R.dimen.c5l));
        setItemHeight(this.f153513c.getResources().getDimensionPixelSize(R.dimen.bi8));
        setDividerColor(ContextCompat.getColor(this.f153513c, R.color.f156611ai0));
        this.f153512b.D.a(0, this.f153513c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f153513c.getResources().getDimensionPixelSize(R.dimen.bht));
        this.f153512b.D.c().d(ContextCompat.getColor(this.f153513c, R.color.f156614aj0)).c(this.f153513c.getResources().getDimensionPixelSize(R.dimen.bht)).setBackgroundColor(ContextCompat.getColor(this.f153513c, R.color.ah_));
    }

    public void setDividerColor(int i3) {
        this.f153512b.D.c(i3);
    }

    public void setDividerHeight(float f16) {
        this.f153512b.a(f16);
    }

    public void setItemHeight(int i3) {
        this.f153512b.b(i3);
    }

    public void setOnValueChangedListener(c cVar) {
        this.f153512b.a(cVar);
    }

    public void setOptionsArray(String[] strArr) {
        this.f153511a = strArr;
        this.f153512b.a(Arrays.asList(strArr));
    }

    public void setValue(int i3) {
        this.f153515e = i3;
    }

    public void updateSelectedItem(int i3) {
        this.f153512b.l().setCurrentItem(i3);
    }

    public CustomOptionPickNew(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.at_), attributeSet);
        this.f153513c = context;
        this.f153512b = new b(context);
        init();
    }

    public CustomOptionPickNew(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153513c = context;
        this.f153512b = new b(context);
        init();
    }
}
