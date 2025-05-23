package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes12.dex */
public class EmotionInvalidPanelLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    public static final int BIG_EMOTION_ROWNUM = 3;
    public static final String LOG_TAG = "ClassicEmoticonPanelView";
    public static final int SMALL_EMOTION_ROWNUM = 4;
    private int columnNum;
    private Context context;
    private EmoticonPackage emotionPkg;
    private boolean isSmallEmotion;
    private float mDensity;
    private int rowNum;
    protected int widthPixels;

    public EmotionInvalidPanelLinearLayout(Context context, EmoticonPackage emoticonPackage, int i3, int i16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.context = context;
        this.emotionPkg = emoticonPackage;
        this.mDensity = super.getContext().getResources().getDisplayMetrics().density;
        this.isSmallEmotion = this.emotionPkg.jobType == 4;
        this.rowNum = i3;
        this.columnNum = i16;
        new DisplayMetrics();
        this.widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        super.setOrientation(1);
        init();
    }

    public void init() {
        TextView textView;
        char c16;
        boolean z16;
        int i3;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.removeAllViews();
        boolean z18 = false;
        for (int i16 = 0; i16 < this.rowNum; i16++) {
            LinearLayout linearLayout = new LinearLayout(this.context);
            float f16 = this.mDensity;
            float f17 = 72.0f;
            int i17 = (int) (f16 * 72.0f);
            int i18 = 7;
            float f18 = 18.0f;
            if (this.isSmallEmotion) {
                i17 = (this.widthPixels - (((int) (f16 * 18.0f)) * 8)) / 7;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i17);
            linearLayout.setOrientation(z18 ? 1 : 0);
            if (this.isSmallEmotion) {
                layoutParams.topMargin = (int) (this.mDensity * 18.0f);
            } else if (i16 == 0) {
                layoutParams.topMargin = (int) (this.mDensity * 16.0f);
            } else {
                layoutParams.topMargin = (int) (this.mDensity * 14.0f);
            }
            int i19 = z18 ? 1 : 0;
            while (i19 < this.columnNum) {
                if (this.isSmallEmotion) {
                    URLImageView uRLImageView = new URLImageView(this.context);
                    uRLImageView.setId(R.id.f915355f);
                    int i26 = (this.widthPixels - (((int) (this.mDensity * f18)) * 8)) / i18;
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i26, i26);
                    layoutParams2.leftMargin = (int) (this.mDensity * f18);
                    uRLImageView.setLayoutParams(layoutParams2);
                    uRLImageView.setVisibility(8);
                    uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    uRLImageView.setAdjustViewBounds(z18);
                    uRLImageView.setFocusable(true);
                    uRLImageView.setFocusableInTouchMode(true);
                    linearLayout.addView(uRLImageView);
                    z16 = z18 ? 1 : 0;
                    i3 = i18;
                    c16 = '\uffff';
                } else {
                    RelativeLayout relativeLayout = new RelativeLayout(this.context);
                    ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int) (this.mDensity * f17));
                    relativeLayout.setFocusable(true);
                    relativeLayout.setFocusableInTouchMode(true);
                    relativeLayout.setLayoutParams(layoutParams3);
                    try {
                        textView = new TextView(this.context);
                    } catch (Exception unused) {
                        textView = null;
                    }
                    if (textView != null) {
                        textView.setVisibility(8);
                        textView.setId(R.id.f6296329);
                        textView.setTextSize(11.0f);
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams4.addRule(12);
                        layoutParams4.addRule(14);
                        layoutParams4.topMargin = (int) (this.mDensity * 5.0f);
                        relativeLayout.addView(textView, layoutParams4);
                    }
                    URLImageView uRLImageView2 = new URLImageView(this.context);
                    uRLImageView2.setId(R.id.f915355f);
                    float f19 = this.mDensity;
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (f19 * 56.0f), (int) (f19 * 56.0f));
                    c16 = '\uffff';
                    layoutParams5.addRule(13, -1);
                    layoutParams5.addRule(2, R.id.f6296329);
                    layoutParams5.addRule(14);
                    uRLImageView2.setVisibility(8);
                    uRLImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    z16 = false;
                    uRLImageView2.setAdjustViewBounds(false);
                    relativeLayout.addView(uRLImageView2, layoutParams5);
                    ImageView imageView = new ImageView(this.context);
                    imageView.setVisibility(8);
                    imageView.setId(R.id.f629732_);
                    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                    i3 = 7;
                    layoutParams6.addRule(7, R.id.f915355f);
                    layoutParams6.addRule(8, R.id.f915355f);
                    relativeLayout.addView(imageView, layoutParams6);
                    if (AppSetting.f99565y) {
                        z17 = true;
                        relativeLayout.setFocusable(true);
                    } else {
                        z17 = true;
                    }
                    if (AppSetting.f99565y) {
                        relativeLayout.setFocusable(z17);
                    }
                    linearLayout.addView(relativeLayout);
                }
                i19++;
                z18 = z16;
                i18 = i3;
                f17 = 72.0f;
                f18 = 18.0f;
            }
            byte b16 = z18 ? 1 : 0;
            super.addView(linearLayout, layoutParams);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - currentTimeMillis) + "issmallemotion = " + this.isSmallEmotion);
        }
    }
}
