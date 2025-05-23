package com.tencent.mobileqq.profilecard.bussiness.accountinfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.api.IProfileGuideApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.report.ProfileAccountInfoReport;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.relation.common.config.toggle.c;
import com.tencent.util.TokenResUtils;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes16.dex */
public class BaseProfileAccountInfoV2Component extends AbsProfileContentComponent implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final float SPACE_WIDTH = 8.0f;
    private static final float SPLIT_WIDTH = 1.0f;
    private static final String TAG = "BaseProfileAccountInfoV2Component";
    private static final double WIDTH_RATE = 0.8d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class CustomImageSpan extends ImageSpan {
        static IPatchRedirector $redirector_ = null;
        public static final int ALIGN_CENTER = 2;

        public CustomImageSpan(Context context, int i3, int i16) {
            super(context, i3, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
            int i26;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
                return;
            }
            Drawable drawable = getDrawable();
            int i27 = ((ImageSpan) this).mVerticalAlignment;
            if (i27 == 0) {
                i26 = i19 - drawable.getBounds().bottom;
            } else if (i27 == 1) {
                i26 = 0 - paint.getFontMetricsInt().descent;
            } else {
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                i26 = ((((fontMetricsInt.descent + i18) + i18) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
            }
            canvas.save();
            canvas.translate(f16, i26);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public BaseProfileAccountInfoV2Component(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    public static void initElementWithExposure(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    public String calculateAccountInfoBreak(String str, TextView textView) {
        int measureText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) textView);
        }
        if (str != null && str.length() > 0 && textView != null) {
            Resources resources = textView.getResources();
            TextPaint paint = textView.getPaint();
            int instantScreenWidth = (int) (DisplayUtil.getInstantScreenWidth(textView.getContext()) * WIDTH_RATE);
            if (instantScreenWidth > 0) {
                int length = str.length();
                int i3 = 0;
                int i16 = 0;
                while (true) {
                    int offsetByCodePoints = str.offsetByCodePoints(i3, 1);
                    String substring = str.substring(i3, offsetByCodePoints);
                    if ("|".equals(substring)) {
                        measureText = Utils.n(1.0f, resources);
                    } else if (" ".equals(substring)) {
                        measureText = Utils.n(8.0f, resources);
                    } else {
                        measureText = (int) paint.measureText(substring);
                    }
                    i16 += measureText;
                    if (i16 <= instantScreenWidth) {
                        if (offsetByCodePoints < length - 1) {
                            i3 = offsetByCodePoints;
                        } else {
                            return str;
                        }
                    } else {
                        String trim = str.substring(0, i3).trim();
                        String trim2 = str.substring(i3).trim();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(trim);
                        if (!TextUtils.isEmpty(trim2)) {
                            sb5.append('\n');
                            sb5.append(trim2);
                        }
                        return sb5.toString();
                    }
                }
            } else {
                return str;
            }
        } else {
            return str;
        }
    }

    public SpannableStringBuilder combineAccountInfo(List<String> list, TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list, (Object) textView);
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
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("combineAccountInfo accountInfo=%s", calculateAccountInfoBreak));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(calculateAccountInfoBreak);
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

    public ImageSpan genSpaceImageSpan(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ImageSpan) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        }
        Resources resources = context.getResources();
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, Utils.n(8.0f, resources), 0);
        return new ImageSpan(colorDrawable);
    }

    public ImageSpan genSplitImageSpan(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ImageSpan) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        }
        return new CustomImageSpan(context, R.drawable.qui_common_divider, 2);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1023;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_ACCOUNT_INFO_V2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.view.View, VIEW] */
    public boolean makeOrRefreshAccountInfo() {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        DATA data = this.mData;
        if (data == 0) {
            return false;
        }
        List<String> makeAccountInfo = ProfileAccountInfoUtils.makeAccountInfo((ProfileCardInfo) data);
        DATA data2 = this.mData;
        if (((ProfileCardInfo) data2).allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isPaTypeShowAccount = ProfilePAUtils.isPaTypeShowAccount(((ProfileCardInfo) data2).allInOne);
        boolean z19 = !makeAccountInfo.isEmpty();
        if (((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).isDefaultProfile((ProfileCardInfo) this.mData) && (z16 || (isPaTypeShowAccount && z19))) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean isSwitchEnable = this.mConfigHelper.isSwitchEnable(12);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", Boolean.valueOf(z17), Boolean.valueOf(isSwitchEnable)));
        }
        if (z17 && isSwitchEnable) {
            if (this.mViewContainer == 0) {
                ?? inflate = this.mActivity.getLayoutInflater().inflate(R.layout.h0r, (ViewGroup) null);
                this.mViewContainer = inflate;
                View findViewById = inflate.findViewById(R.id.icon);
                if (findViewById != null) {
                    findViewById.setBackgroundResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_information, R.drawable.qui_contact));
                }
                ((View) this.mViewContainer).setOnClickListener(this);
                z18 = true;
            } else {
                z18 = false;
            }
            TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.jfb);
            ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164472yw);
            if (textView != null) {
                if (z16 && !z19) {
                    if (c.f364691d.g(false)) {
                        this.mViewContainer = null;
                        return true;
                    }
                    textView.setText(R.string.f203334zx);
                    ((View) this.mViewContainer).setTag(new b(81, null));
                } else {
                    textView.setText(combineAccountInfo(makeAccountInfo, textView));
                    ((View) this.mViewContainer).setTag(new b(103, null));
                }
            }
            updateItemTheme((View) this.mViewContainer, textView, null, imageView);
            return z18;
        }
        if (this.mViewContainer == 0) {
            return false;
        }
        this.mViewContainer = null;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (!u.a().b()) {
            Object tag = view.getTag();
            if (tag instanceof b) {
                int i3 = ((b) tag).f260135a;
                if (i3 != 81) {
                    if (i3 == 103) {
                        boolean z16 = false;
                        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0 && ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
                            ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).openProfileEdit(this.mActivity, ((ProfileCardInfo) this.mData).allInOne, false);
                        } else {
                            ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).jumpProfileOpenDetails((ProfileCardInfo) this.mData, this.mApp, this.mActivity);
                        }
                        if (((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).isDefaultProfile((ProfileCardInfo) this.mData)) {
                            int i16 = 1;
                            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                                z16 = true;
                            }
                            AppInterface appInterface = this.mApp;
                            if (!z16) {
                                i16 = 3;
                            }
                            ProfileAccountInfoReport.reportAccountInfoClick(appInterface, i16);
                        }
                    }
                } else {
                    ((IProfileGuideApi) QRoute.api(IProfileGuideApi.class)).jumpProfileEdit(this.mApp, this.mActivity, (ProfileCardInfo) this.mData);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean onDataUpdate(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? super.onDataUpdate((BaseProfileAccountInfoV2Component) profileCardInfo) | makeOrRefreshAccountInfo() : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
    }
}
