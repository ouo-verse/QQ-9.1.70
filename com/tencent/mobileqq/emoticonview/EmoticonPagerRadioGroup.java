package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;

/* loaded from: classes12.dex */
public class EmoticonPagerRadioGroup extends RadioGroup implements ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final int MODE_EMOJI = 2;
    private static final int MODE_SYSTEM = 1;
    private static final int RADIO_BUTOON_TYPE_RECENT = 4;
    private static final int RADIO_BUTTON_TYPE_EMOJI = 3;
    private static final int RADIO_BUTTON_TYPE_NORMAL = 1;
    private static final int RADIO_BUTTON_TYPE_SYSTEM = 2;
    RadioButton emojiButton;
    private int emojiPageCount;
    private int indicatorDrawable;
    private int lastClassicPageIndex;
    private int mClassicMode;
    private String mContentDescriptionFormatter;
    private boolean mIsClassicPage;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    RadioButton recentButton;
    private int sysEmoticonPageCount;
    RadioButton systemButton;
    private int totalEmoticonPageCount;
    ViewPager viewPager;

    public EmoticonPagerRadioGroup(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private RadioButton createButton(int i3) {
        float f16;
        float f17;
        float applyDimension;
        RadioButton radioButton = new RadioButton(getContext()) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonPagerRadioGroup.this, (Object) r5);
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
        };
        if (i3 == 2) {
            radioButton.setButtonDrawable(R.drawable.o47);
        } else if (i3 == 3) {
            radioButton.setButtonDrawable(R.drawable.o48);
        } else if (i3 == 4) {
            radioButton.setButtonDrawable(R.drawable.lon);
        } else {
            int i16 = this.indicatorDrawable;
            if (i16 == 0) {
                radioButton.setButtonDrawable(R.drawable.qui_systememojipanel_radio_btn);
            } else {
                radioButton.setButtonDrawable(i16);
            }
        }
        radioButton.setGravity(17);
        Resources resources = super.getContext().getResources();
        if (i3 == 2) {
            f17 = 15.0f;
        } else {
            f16 = 10.0f;
            if (i3 == 3) {
                f17 = 24.0f;
            } else if (i3 == 4) {
                f17 = 13.0f;
            } else {
                f17 = 10.0f;
            }
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams((int) TypedValue.applyDimension(1, f17, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, f16, resources.getDisplayMetrics()));
            layoutParams.gravity = 17;
            if (!QQTheme.isNowSimpleUI()) {
                applyDimension = TypedValue.applyDimension(1, 2.0f, resources.getDisplayMetrics());
            } else {
                applyDimension = TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics());
            }
            int i17 = (int) applyDimension;
            layoutParams.leftMargin = i17;
            layoutParams.rightMargin = i17;
            radioButton.setLayoutParams(layoutParams);
            radioButton.setClickable(true);
            return radioButton;
        }
        f16 = f17;
        RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams((int) TypedValue.applyDimension(1, f17, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, f16, resources.getDisplayMetrics()));
        layoutParams2.gravity = 17;
        if (!QQTheme.isNowSimpleUI()) {
        }
        int i172 = (int) applyDimension;
        layoutParams2.leftMargin = i172;
        layoutParams2.rightMargin = i172;
        radioButton.setLayoutParams(layoutParams2);
        radioButton.setClickable(true);
        return radioButton;
    }

    public ViewPager getViewPager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ViewPager) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.viewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f16, i16);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i3);
        }
        if (super.getChildCount() <= i3) {
            return;
        }
        if (!this.mIsClassicPage) {
            this.lastClassicPageIndex = -1;
        } else {
            int i17 = this.lastClassicPageIndex;
            int i18 = this.emojiPageCount;
            if ((i17 == i18 && i3 == i18 - 1) || i3 == 0) {
                this.emojiButton.setVisibility(8);
                this.systemButton.setVisibility(0);
                int i19 = this.emojiPageCount;
                int i26 = this.sysEmoticonPageCount;
                if (i19 > i26) {
                    for (int i27 = i26 + 1; i27 <= this.emojiPageCount; i27++) {
                        RadioButton radioButton = (RadioButton) super.getChildAt(i27);
                        if (radioButton != null) {
                            radioButton.setVisibility(0);
                        }
                    }
                } else if (i19 < i26) {
                    for (int i28 = i19 + 1; i28 <= this.sysEmoticonPageCount; i28++) {
                        RadioButton radioButton2 = (RadioButton) super.getChildAt(i28);
                        if (radioButton2 != null) {
                            radioButton2.setVisibility(8);
                        }
                    }
                }
                this.mClassicMode = 2;
            } else if (i3 == i18 || i3 == (i18 + this.sysEmoticonPageCount) - 1) {
                this.emojiButton.setVisibility(0);
                this.systemButton.setVisibility(8);
                int i29 = this.emojiPageCount;
                int i36 = this.sysEmoticonPageCount;
                if (i29 > i36) {
                    for (int i37 = i36 + 1; i37 <= this.emojiPageCount; i37++) {
                        RadioButton radioButton3 = (RadioButton) super.getChildAt(i37);
                        if (radioButton3 != null) {
                            radioButton3.setVisibility(8);
                        }
                    }
                } else if (i29 < i36) {
                    for (int i38 = i29 + 1; i38 <= this.sysEmoticonPageCount; i38++) {
                        RadioButton radioButton4 = (RadioButton) super.getChildAt(i38);
                        if (radioButton4 != null) {
                            radioButton4.setVisibility(0);
                        }
                    }
                }
                this.mClassicMode = 1;
            }
            if (this.mClassicMode == 2) {
                i16 = i3 + 1;
            } else {
                i16 = i3 - (this.emojiPageCount - 1);
            }
            this.lastClassicPageIndex = i3;
            i3 = i16;
        }
        if (i3 >= super.getChildCount()) {
            i3 = super.getChildCount() - 1;
        }
        RadioButton radioButton5 = (RadioButton) super.getChildAt(i3);
        if (radioButton5 != null) {
            radioButton5.setChecked(true);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.lastClassicPageIndex = -1;
        }
    }

    public void setContentDescriptionFormatter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mContentDescriptionFormatter = str;
        }
    }

    public void setIndicatorDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.indicatorDrawable = i3;
        }
    }

    public void setPagerChangedListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onPageChangeListener);
        } else {
            this.mOnPageChangeListener = onPageChangeListener;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewPager);
            return;
        }
        this.viewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(this);
        }
    }

    public void synButton(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            synButton(i3, false);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
    }

    public void synClassicButton(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.emojiPageCount = i16 - i3;
        this.sysEmoticonPageCount = i3;
        this.totalEmoticonPageCount = i16;
        if (!this.mIsClassicPage) {
            removeAllViews();
            int max = Math.max(this.emojiPageCount, i3);
            super.addView(this.emojiButton);
            for (int i17 = 0; i17 < max; i17++) {
                super.addView(createButton(1));
            }
            super.addView(this.systemButton);
            int i18 = (i16 - max) - 2;
            for (int i19 = 0; i19 < i18; i19++) {
                RadioButton createButton = createButton(1);
                createButton.setVisibility(8);
                super.addView(createButton);
            }
        }
        this.mIsClassicPage = true;
    }

    public EmoticonPagerRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.lastClassicPageIndex = -1;
        this.systemButton = createButton(2);
        this.emojiButton = createButton(3);
        this.recentButton = createButton(4);
    }

    public void synButton(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        super.removeView(this.systemButton);
        super.removeView(this.emojiButton);
        removeAllViews();
        if (z16) {
            super.addView(this.recentButton);
        }
        this.lastClassicPageIndex = -1;
        int childCount = getChildCount();
        if (i3 > childCount) {
            for (int i16 = 0; i16 < i3 - childCount; i16++) {
                super.addView(createButton(1));
            }
        } else if (i3 < childCount) {
            for (int i17 = childCount - 1; i17 >= i3; i17--) {
                super.removeViewAt(i17);
            }
        }
        if (i3 > 0 && this.viewPager != null) {
            RadioButton radioButton = (RadioButton) super.getChildAt(0);
            if (!z16) {
                int i18 = this.indicatorDrawable;
                if (i18 == 0) {
                    radioButton.setButtonDrawable(R.drawable.qui_systememojipanel_radio_btn);
                } else {
                    radioButton.setButtonDrawable(i18);
                }
            }
            RadioButton radioButton2 = (RadioButton) super.getChildAt(this.viewPager.getCurrentItem());
            if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
        }
        for (int i19 = 0; i19 < getChildCount(); i19++) {
            RadioButton radioButton3 = (RadioButton) super.getChildAt(i19);
            radioButton3.setVisibility(0);
            if (!TextUtils.isEmpty(this.mContentDescriptionFormatter)) {
                radioButton3.setContentDescription(String.format(this.mContentDescriptionFormatter, Integer.valueOf(i19 + 1)));
            }
        }
        this.mIsClassicPage = false;
    }
}
