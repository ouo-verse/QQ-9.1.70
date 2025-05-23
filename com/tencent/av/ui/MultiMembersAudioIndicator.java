package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MultiMembersAudioIndicator extends RadioGroup implements ViewPager.OnPageChangeListener {

    /* renamed from: d, reason: collision with root package name */
    public ViewPager f74890d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends RadioButton {
        a(Context context) {
            super(context);
        }

        @Override // android.widget.CompoundButton, android.view.View
        public boolean performClick() {
            return true;
        }
    }

    public MultiMembersAudioIndicator(Context context) {
        super(context);
        super.setOrientation(0);
        super.setGravity(17);
    }

    public RadioButton a() {
        a aVar = new a(super.getContext());
        aVar.setButtonDrawable(R.drawable.f161370vy);
        aVar.setGravity(17);
        Resources resources = super.getContext().getResources();
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        layoutParams.gravity = 17;
        int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics());
        layoutParams.leftMargin = applyDimension;
        layoutParams.rightMargin = applyDimension;
        aVar.setLayoutParams(layoutParams);
        aVar.setClickable(false);
        aVar.setFocusable(false);
        return aVar;
    }

    public void b() {
        PagerAdapter adapter;
        ViewPager viewPager = this.f74890d;
        if (viewPager == null || (adapter = viewPager.getAdapter()) == null) {
            return;
        }
        int count = adapter.getCount();
        super.removeAllViews();
        for (int i3 = 0; i3 < count; i3++) {
            super.addView(a());
        }
        int currentItem = this.f74890d.getCurrentItem();
        if (currentItem >= super.getChildCount()) {
            currentItem = super.getChildCount() - 1;
        }
        RadioButton radioButton = (RadioButton) super.getChildAt(currentItem);
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
        if (count <= 1) {
            super.setVisibility(4);
        } else {
            super.setVisibility(0);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        ViewPager viewPager = this.f74890d;
        if (viewPager == null || viewPager.getAdapter() == null || super.getChildCount() <= i3) {
            return;
        }
        if (i3 >= super.getChildCount()) {
            i3 = super.getChildCount() - 1;
        }
        RadioButton radioButton = (RadioButton) super.getChildAt(i3);
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.f74890d = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(this);
        }
    }

    public MultiMembersAudioIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOrientation(0);
        super.setGravity(17);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
