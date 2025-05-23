package com.tencent.mobileqq.profilecard.bussiness.accountinfo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.config.toggle.c;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes16.dex */
public class ElegantProfileAccountInfoV2Component extends BaseProfileAccountInfoV2Component {
    static IPatchRedirector $redirector_ = null;
    private static final String DT_REPORT_EM_PROFILE_BASIC = "em_profile_basic";
    private static final String FEMALE = "\u5973";
    private static final String MALE = "\u7537";
    private static final int SIXTEEN_DP = 16;
    private static final String TAG = "ElegantProfileAccountInfoV2Component";
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class CustomImageSpan extends ImageSpan {
        static IPatchRedirector $redirector_ = null;
        private static final int ALIGN = 2;

        public CustomImageSpan(Drawable drawable, int i3) {
            super(drawable, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable, i3);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
                return;
            }
            Drawable drawable = getDrawable();
            canvas.save();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i26 = i19 - drawable.getBounds().bottom;
            int i27 = ((ImageSpan) this).mVerticalAlignment;
            if (i27 == 1) {
                i26 -= fontMetricsInt.descent;
            } else if (i27 == 2) {
                i26 = (((fontMetricsInt.descent + i18) + (i18 + fontMetricsInt.ascent)) / 2) - (drawable.getBounds().bottom / 2);
            }
            canvas.translate(f16, i26);
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
            }
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i17 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i18 = (bounds.bottom - bounds.top) / 2;
                int i19 = i17 / 4;
                int i26 = i18 - i19;
                int i27 = -(i18 + i19);
                fontMetricsInt.ascent = i27;
                fontMetricsInt.top = i27;
                fontMetricsInt.bottom = i26;
                fontMetricsInt.descent = i26;
            }
            return bounds.right;
        }

        public CustomImageSpan(Context context, int i3) {
            super(context, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }

        public CustomImageSpan(Context context, int i3, int i16) {
            super(context, i3, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public ElegantProfileAccountInfoV2Component(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    private CharSequence removeRepeatSex(SpannableStringBuilder spannableStringBuilder) {
        CharSequence charSequence = null;
        if (spannableStringBuilder != null && spannableStringBuilder.length() != 0) {
            Matcher matcher = Pattern.compile(FEMALE).matcher(spannableStringBuilder);
            while (matcher.find() && matcher.start() == 0) {
                charSequence = spannableStringBuilder.subSequence(matcher.end(), spannableStringBuilder.length());
            }
            Matcher matcher2 = Pattern.compile(MALE).matcher(spannableStringBuilder);
            while (matcher2.find() && matcher2.start() == 0) {
                charSequence = spannableStringBuilder.subSequence(matcher2.end(), spannableStringBuilder.length());
            }
        }
        return charSequence;
    }

    private void replaceSex(SpannableStringBuilder spannableStringBuilder, String str) {
        Matcher matcher = Pattern.compile(FEMALE).matcher(str);
        while (matcher.find() && matcher.start() == 0) {
            Drawable drawable = this.mActivity.getApplicationContext().getResources().getDrawable(R.drawable.qui_female_pink);
            int spToPx = ViewUtils.spToPx(12.0f);
            drawable.setBounds(0, 0, spToPx, spToPx);
            spannableStringBuilder.setSpan(new CustomImageSpan(drawable, 2), matcher.start(), matcher.end(), 33);
        }
        Matcher matcher2 = Pattern.compile(MALE).matcher(str);
        while (matcher2.find() && matcher2.start() == 0) {
            Drawable drawable2 = this.mActivity.getApplicationContext().getResources().getDrawable(R.drawable.qui_male_brand);
            int spToPx2 = ViewUtils.spToPx(12.0f);
            drawable2.setBounds(0, 0, spToPx2, spToPx2);
            spannableStringBuilder.setSpan(new CustomImageSpan(drawable2, 2), matcher2.start(), matcher2.end(), 33);
        }
    }

    private void setAccountInfoDescription(TextView textView, SpannableStringBuilder spannableStringBuilder) {
        if (!AppSetting.f99565y || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100177", false)) {
            return;
        }
        CharSequence removeRepeatSex = removeRepeatSex(spannableStringBuilder);
        if (TextUtils.isEmpty(removeRepeatSex)) {
            return;
        }
        AccessibilityUtil.s(textView, removeRepeatSex.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateContactProfile(boolean z16) {
        if (z16) {
            ((View) this.mViewContainer).findViewById(R.id.f164472yw).setVisibility(4);
            ((View) this.mViewContainer).setOnClickListener(null);
        } else {
            ((View) this.mViewContainer).findViewById(R.id.f164472yw).setVisibility(0);
            ((View) this.mViewContainer).setOnClickListener(this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.accountinfo.BaseProfileAccountInfoV2Component
    public SpannableStringBuilder combineAccountInfo(List<String> list, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) textView);
        }
        StringBuilder sb5 = new StringBuilder();
        if (list != null && !list.isEmpty() && textView != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb5.append(list.get(i3));
                if (i3 != size - 1) {
                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                }
            }
        }
        String calculateAccountInfoBreak = calculateAccountInfoBreak(sb5.toString(), textView);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(calculateAccountInfoBreak);
        replaceSex(spannableStringBuilder, calculateAccountInfoBreak);
        Matcher matcher = Pattern.compile("\\|").matcher(calculateAccountInfoBreak);
        while (matcher.find()) {
            spannableStringBuilder.setSpan(genSplitImageSpan(this.mActivity.getApplicationContext()), matcher.start(), matcher.end(), 33);
        }
        Matcher matcher2 = Pattern.compile(" ").matcher(calculateAccountInfoBreak);
        while (matcher2.find()) {
            spannableStringBuilder.setSpan(genSpaceImageSpan(this.mActivity.getApplicationContext()), matcher2.start(), matcher2.end(), 33);
        }
        return spannableStringBuilder;
    }

    public ImageSpan genSexImage(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ImageSpan) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, i3);
        }
        return new CustomImageSpan(context.getDrawable(i3), 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12, types: [android.view.View, VIEW] */
    /* JADX WARN: Type inference failed for: r8v9, types: [android.view.View, VIEW] */
    @Override // com.tencent.mobileqq.profilecard.bussiness.accountinfo.BaseProfileAccountInfoV2Component
    public boolean makeOrRefreshAccountInfo() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        DATA data = this.mData;
        if (data == 0) {
            return false;
        }
        List<String> makeAccountElegantInfo = ProfileAccountInfoUtils.makeAccountElegantInfo((ProfileCardInfo) data);
        DATA data2 = this.mData;
        if (((ProfileCardInfo) data2).allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) data2).allInOne) && ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!ProfilePAUtils.isPaTypeShowAccount(((ProfileCardInfo) this.mData).allInOne) && !((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion()) {
            z18 = false;
        } else {
            z18 = true;
        }
        boolean z26 = !makeAccountElegantInfo.isEmpty();
        if (((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).isDefaultProfile((ProfileCardInfo) this.mData) && (z16 || (z18 && z26))) {
            z19 = true;
        } else {
            z19 = false;
        }
        boolean isSwitchEnable = this.mConfigHelper.isSwitchEnable(12);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", Boolean.valueOf(z19), Boolean.valueOf(isSwitchEnable)));
        }
        if (z19 && isSwitchEnable) {
            if (this.mViewContainer == 0) {
                LayoutInflater layoutInflater = this.mActivity.getLayoutInflater();
                IComponentCenter iComponentCenter = this.mComponentCenter;
                if (iComponentCenter != null) {
                    this.mViewContainer = iComponentCenter.getViewLoader().getViewById(R.layout.h0c);
                }
                if (this.mViewContainer == 0) {
                    this.mViewContainer = layoutInflater.inflate(R.layout.h0c, (ViewGroup) null);
                }
                updateContactProfile(z17);
                BaseProfileAccountInfoV2Component.initElementWithExposure((View) this.mViewContainer, "em_profile_basic");
            }
            this.textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.jfb);
            ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164472yw);
            TextView textView = this.textView;
            if (textView != null) {
                if (z16 && !z26) {
                    if (c.f364691d.g(false)) {
                        this.mViewContainer = null;
                        return true;
                    }
                    this.textView.setText(R.string.f203334zx);
                    ((View) this.mViewContainer).setTag(new b(81, null));
                } else {
                    SpannableStringBuilder combineAccountInfo = combineAccountInfo(makeAccountElegantInfo, textView);
                    this.textView.setText(combineAccountInfo);
                    setAccountInfoDescription(this.textView, combineAccountInfo);
                    ((View) this.mViewContainer).setTag(new b(103, null));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(15);
                layoutParams.rightMargin = ViewUtils.dpToPx(16.0f);
                imageView.setLayoutParams(layoutParams);
            }
        } else if (this.mViewContainer != 0) {
            this.mViewContainer = null;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.accountinfo.BaseProfileAccountInfoV2Component, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            super.onClick(view);
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
