package com.tencent.biz.troopgift;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.troopgift.absMultiViewPager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RadioButtonIndicator extends RadioGroup implements ViewPager.OnPageChangeListener, absMultiViewPager.a, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    protected ViewPager f96899d;

    /* renamed from: e, reason: collision with root package name */
    protected int f96900e;

    /* renamed from: f, reason: collision with root package name */
    public int f96901f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends RadioButton {
        a(Context context) {
            super(context);
        }

        @Override // android.widget.CompoundButton, android.view.View
        public boolean performClick() {
            return true;
        }
    }

    public RadioButtonIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f96900e = R.drawable.f160637m9;
    }

    @Override // com.tencent.biz.troopgift.absMultiViewPager.a
    public void a(int i3, int i16, int i17) {
        setButtons(i16);
    }

    public RadioButton b(int i3) {
        a aVar = new a(getContext());
        aVar.setButtonDrawable(this.f96900e);
        aVar.setPadding(10, 0, 10, 0);
        aVar.setClickable(true);
        if (AppSetting.f99565y) {
            ViewCompat.setImportantForAccessibility(aVar, 2);
        }
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int intValue = ((Integer) view.getTag()).intValue();
        ViewPager viewPager = this.f96899d;
        if (viewPager != null) {
            viewPager.setCurrentItem(intValue);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        RadioButton radioButton = (RadioButton) getChildAt(i3);
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
    }

    public void setButtonResourceId(int i3) {
        this.f96900e = i3;
    }

    public void setButtons(int i3) {
        removeAllViews();
        if (i3 <= 1) {
            return;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            RadioButton b16 = b(i16);
            b16.setTag(Integer.valueOf(i16));
            b16.setOnClickListener(this);
            addView(b16);
        }
        this.f96901f = i3;
        ((RadioButton) getChildAt(0)).setChecked(true);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f96899d = viewPager;
    }

    public RadioButtonIndicator(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
