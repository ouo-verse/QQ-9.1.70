package com.tencent.mobileqq.profilecard.bussiness.circle.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileCircleInfoView extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String INFO_DIVISION = "  ";
    private static final long LONG_ANIMATION_DURATION = 2000;
    private static final long SHORT_ANIMATION_DURATION = 1200;
    public static final int STYLE_VALUE_EFFECT = 1;
    public static final int STYLE_VALUE_NONE = 0;
    private static final String TAG = "ProfileCircleInfoView";
    private DynamicEffectTextView mEffectTextView;
    private String mFansText;
    private int mFansValueStyle;
    private String mFuelText;
    private int mFuelValueStyle;
    private int mGuideValueStyle;
    private String mPublishGuideText;
    private TextView mTextView;

    public ProfileCircleInfoView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mFansValueStyle = 0;
        this.mFuelValueStyle = 0;
        this.mGuideValueStyle = 0;
        initialized();
    }

    private void addEffectTextView(String str, long j3) {
        DynamicEffectTextView dynamicEffectTextView = this.mEffectTextView;
        if (dynamicEffectTextView == null) {
            return;
        }
        dynamicEffectTextView.setText(str);
        this.mEffectTextView.setDuration(j3);
        addView(this.mEffectTextView);
    }

    private void addNormalTextView(String str) {
        TextView textView = this.mTextView;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        addView(this.mTextView);
    }

    private DynamicEffectTextView buildEffectTextView() {
        DynamicEffectTextView dynamicEffectTextView = new DynamicEffectTextView(getContext());
        dynamicEffectTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        dynamicEffectTextView.setSingleLine(true);
        dynamicEffectTextView.setTextColor(RichStatus.TOPIC_COLOR);
        dynamicEffectTextView.setTextSize(2, 12.0f);
        dynamicEffectTextView.setDrawableResource(R.drawable.f161588nb0);
        return dynamicEffectTextView;
    }

    private TextView buildNormalTextView() {
        int i3;
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setSingleLine(true);
        if (getContext() != null && getContext().getResources() != null) {
            i3 = getContext().getResources().getColor(R.color.qui_common_text_secondary);
        } else {
            i3 = -7894119;
        }
        textView.setTextColor(i3);
        textView.setTextSize(2, 12.0f);
        return textView;
    }

    private StringBuilder createStringBuilder(String str, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            sb5.append(str);
            sb5.append(INFO_DIVISION);
        } else {
            sb5.append(str);
        }
        return sb5;
    }

    private void initialized() {
        this.mTextView = buildNormalTextView();
        this.mEffectTextView = buildEffectTextView();
    }

    private boolean isGuideStyleChange(int i3) {
        if (this.mGuideValueStyle != i3) {
            return true;
        }
        return false;
    }

    private boolean isGuideTextChange(String str) {
        return !TextUtils.equals(str, this.mPublishGuideText);
    }

    private boolean isTextChange(String str, String str2) {
        if (TextUtils.equals(str, this.mFansText) && TextUtils.equals(str2, this.mFuelText)) {
            return false;
        }
        return true;
    }

    private boolean isValueStyleChange(int i3, int i16) {
        if (i3 == this.mFansValueStyle && i16 == this.mFuelValueStyle) {
            return false;
        }
        return true;
    }

    private void refreshCircleInfoLayout() {
        if (TextUtils.isEmpty(this.mFansText) && TextUtils.isEmpty(this.mFuelText)) {
            QLog.w(TAG, 1, "[buildCircleInfoLayout] fans text and fuel text not is empty.");
            return;
        }
        release();
        resetGuideInfo();
        int i3 = this.mFansValueStyle;
        if (i3 == 1 && this.mFuelValueStyle == 1) {
            StringBuilder createStringBuilder = createStringBuilder(this.mFansText, true);
            createStringBuilder.append(this.mFuelText);
            addEffectTextView(createStringBuilder.toString(), 2000L);
            return;
        }
        if (i3 == 1) {
            addEffectTextView(this.mFansText, 1200L);
            if (!TextUtils.isEmpty(this.mFuelText)) {
                StringBuilder createStringBuilder2 = createStringBuilder(INFO_DIVISION, false);
                createStringBuilder2.append(this.mFuelText);
                addNormalTextView(createStringBuilder2.toString());
                return;
            }
            return;
        }
        if (this.mFuelValueStyle == 1) {
            if (!TextUtils.isEmpty(this.mFansText)) {
                addNormalTextView(createStringBuilder(this.mFansText, true).toString());
            }
            addEffectTextView(this.mFuelText, 1200L);
        } else if (!TextUtils.isEmpty(this.mFansText) && !TextUtils.isEmpty(this.mFuelText)) {
            StringBuilder createStringBuilder3 = createStringBuilder(this.mFansText, true);
            createStringBuilder3.append(this.mFuelText);
            addNormalTextView(createStringBuilder3.toString());
        } else if (!TextUtils.isEmpty(this.mFansText)) {
            addNormalTextView(createStringBuilder(this.mFansText, false).toString());
        } else if (!TextUtils.isEmpty(this.mFuelText)) {
            addNormalTextView(createStringBuilder(this.mFuelText, false).toString());
        }
    }

    private void release() {
        DynamicEffectTextView dynamicEffectTextView = this.mEffectTextView;
        if (dynamicEffectTextView != null) {
            dynamicEffectTextView.cancelAnimation();
        }
        removeAllViews();
    }

    private void resetFansAndFuelInfo() {
        this.mFansText = null;
        this.mFuelText = null;
    }

    private void resetGuideInfo() {
        this.mPublishGuideText = null;
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            release();
        }
    }

    public void updateCircleInfo(int i3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2);
            return;
        }
        if (isTextChange(str, str2) || isValueStyleChange(i3, i16)) {
            QLog.d(TAG, 1, "updateCircleInfo fansValueStyle: ", Integer.valueOf(i3), " | fuelValueStyle: ", Integer.valueOf(i16), " | fansText: ", str, " | fuelText: ", str2);
            this.mFansValueStyle = i3;
            this.mFuelValueStyle = i16;
            this.mFansText = str;
            this.mFuelText = str2;
            refreshCircleInfoLayout();
        }
    }

    public void updateCirclePublishGuideInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
            return;
        }
        if (isGuideTextChange(str) || isGuideStyleChange(i3)) {
            QLog.d(TAG, 1, "updateCirclePublishGuideInfo, publishGuideText: " + str + ", style: " + i3);
            this.mPublishGuideText = str;
            this.mGuideValueStyle = i3;
            release();
            resetFansAndFuelInfo();
            if (i3 == 1) {
                addEffectTextView(this.mPublishGuideText, 1200L);
            } else if (i3 == 0) {
                addNormalTextView(this.mPublishGuideText);
            }
        }
    }

    public ProfileCircleInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mFansValueStyle = 0;
        this.mFuelValueStyle = 0;
        this.mGuideValueStyle = 0;
        initialized();
    }

    public ProfileCircleInfoView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mFansValueStyle = 0;
        this.mFuelValueStyle = 0;
        this.mGuideValueStyle = 0;
        initialized();
    }
}
