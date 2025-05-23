package com.tencent.mobileqq.qqgamepub.web.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameIndicator2 extends RadioGroup implements ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public ViewPager f264849d;

    /* renamed from: e, reason: collision with root package name */
    private jh2.c f264850e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends RadioButton {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameIndicator2.this, (Object) context);
            }
        }

        @Override // android.widget.CompoundButton, android.view.View
        public boolean performClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    public QQGameIndicator2(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            super.setOrientation(0);
            super.setGravity(17);
        }
    }

    private void c(int i3, int i16) {
        for (int i17 = 0; i17 < i16; i17++) {
            RadioButton radioButton = (RadioButton) super.getChildAt(i17);
            if (radioButton != null) {
                if (i17 == i3) {
                    radioButton.setTextColor(-1);
                } else {
                    radioButton.setTextColor(Color.parseColor("#9B9B9B"));
                }
            }
        }
    }

    public RadioButton a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RadioButton) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        a aVar = new a(super.getContext());
        aVar.setButtonDrawable((Drawable) null);
        aVar.setId(R.id.f166754hv2 + i3);
        aVar.setBackgroundResource(R.drawable.ajh);
        aVar.setGravity(17);
        aVar.setText(i3 + "");
        if (i16 + 1 == i3) {
            aVar.setTextColor(-1);
            aVar.setChecked(true);
        } else {
            aVar.setTextColor(Color.parseColor("#9B9B9B"));
        }
        aVar.setTextSize(12.0f);
        Resources resources = super.getContext().getResources();
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams((int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics()));
        layoutParams.gravity = 17;
        int applyDimension = (int) TypedValue.applyDimension(1, 2.0f, resources.getDisplayMetrics());
        layoutParams.leftMargin = applyDimension;
        layoutParams.rightMargin = applyDimension;
        aVar.setLayoutParams(layoutParams);
        aVar.setClickable(false);
        aVar.setFocusable(false);
        return aVar;
    }

    public void b() {
        PagerAdapter adapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ViewPager viewPager = this.f264849d;
        if (viewPager == null || (adapter = viewPager.getAdapter()) == null) {
            return;
        }
        int count = adapter.getCount();
        super.removeAllViews();
        int currentItem = this.f264849d.getCurrentItem();
        int i3 = 0;
        while (i3 < count) {
            i3++;
            super.addView(a(i3, currentItem));
        }
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

    public void d() {
        View childAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ViewPager viewPager = this.f264849d;
        if (viewPager == null || (childAt = getChildAt(viewPager.getCurrentItem())) == null) {
            return;
        }
        float left = childAt.getLeft();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(left - getChildAt(i3).getLeft(), 0.0f, 0.0f, 0.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 1.0f);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(250L);
            animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
            arrayList.add(animationSet);
        }
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            getChildAt(i16).startAnimation((AnimationSet) arrayList.get(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        jh2.c cVar = this.f264850e;
        if (cVar != null) {
            cVar.onPageScrolled(i3, f16, i16);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        PagerAdapter adapter;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        ViewPager viewPager = this.f264849d;
        if (viewPager == null || (adapter = viewPager.getAdapter()) == null || super.getChildCount() <= i3) {
            return;
        }
        if (i3 >= super.getChildCount()) {
            i16 = super.getChildCount() - 1;
        } else {
            i16 = i3;
        }
        RadioButton radioButton = (RadioButton) super.getChildAt(i16);
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
        c(i16, adapter.getCount());
        jh2.c cVar = this.f264850e;
        if (cVar != null) {
            cVar.onPageSelected(i3);
        }
    }

    public void setCurrentIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
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

    public void setPageListener(jh2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) cVar);
        } else {
            this.f264850e = cVar;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewPager);
            return;
        }
        this.f264849d = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(this);
        }
    }

    public QQGameIndicator2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            super.setOrientation(0);
            super.setGravity(17);
        }
    }
}
