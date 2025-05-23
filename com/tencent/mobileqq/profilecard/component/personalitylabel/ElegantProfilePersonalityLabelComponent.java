package com.tencent.mobileqq.profilecard.component.personalitylabel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.utils.ProfileKoiLikeReportUtil;
import com.tencent.mobileqq.profilecard.base.utils.SpringPKReportUtil;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.SpecialPersonalityLabelResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.widget.FlowLayoutContainer;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.List;

/* loaded from: classes35.dex */
public class ElegantProfilePersonalityLabelComponent extends ProfilePersonalityLabelComponent {
    private static final String BG_STROKE_DEFAULT_COLOR = "#1A000000";
    private static final int PROFILE_PERSONALITY_LABEL_MAX_LINE = 2;
    private static final int PROFILE_PERSONALITY_LABEL_Tag_Radio = 6;
    private static final String TAG = "ElegantProfilePersonalityLabelComponent";

    public ElegantProfilePersonalityLabelComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addLabels(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        List<PersonalityLabelInfo> list = profilePersonalityLabelInfo.personalityLabelInfos;
        FlowLayoutContainer flowLayoutContainer = (FlowLayoutContainer) ((View) this.mViewContainer).findViewById(R.id.otp);
        if (list == null || flowLayoutContainer == null || this.mActivity == null) {
            return;
        }
        flowLayoutContainer.removeAllViews();
        if (list.size() == 0) {
            View createEmptyItemView = createEmptyItemView();
            flowLayoutContainer.setAndAddEndView(null);
            flowLayoutContainer.addView(createEmptyItemView);
            return;
        }
        for (PersonalityLabelInfo personalityLabelInfo : list) {
            if (isSpecialLabel(personalityLabelInfo.f259897id)) {
                if (!TextUtils.isEmpty(personalityLabelInfo.text)) {
                    flowLayoutContainer.addView(createItemViewSpecial(personalityLabelInfo));
                }
            } else {
                flowLayoutContainer.addView(createItemView(personalityLabelInfo.personalityLabelPhotos, personalityLabelInfo.text, false));
            }
        }
        flowLayoutContainer.setAndAddEndView(createItemView(null, this.mActivity.getResources().getString(R.string.x5m), true));
    }

    private View createEmptyItemView() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.cyz, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.oux);
        TextView textView = (TextView) inflate.findViewById(R.id.ox7);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.otg);
        imageView.setVisibility(8);
        imageView2.setVisibility(0);
        textView.setText(this.mActivity.getResources().getString(R.string.x5l));
        imageView2.setImageDrawable(ContextCompat.getDrawable(this.mActivity, R.drawable.qui_add));
        return inflate;
    }

    private View createItemView(List<PersonalityLabelPhoto> list, String str, boolean z16) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.cyz, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.oux);
        TextView textView = (TextView) inflate.findViewById(R.id.ox7);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.otg);
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        textView.setText(str);
        if (z16) {
            imageView2.setVisibility(0);
            imageView2.setImageDrawable(ContextCompat.getDrawable(this.mActivity, R.drawable.qui_chevron_right));
        } else if (list != null && list.size() > 0) {
            imageView.setVisibility(0);
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_profilecard_performance_optimisation_switch", false)) {
                imageView.setImageDrawable(getUrlDrawable(list.get(0).get350SizeUrl()));
            } else {
                imageView.setImageDrawable(getUrlDrawable(list.get(0).url));
            }
        }
        return inflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View createItemViewSpecial(final PersonalityLabelInfo personalityLabelInfo) {
        String str;
        final View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.cyz, (ViewGroup) null);
        final SpecialPersonalityLabelResourceUtil.TagResource tagResource = getTagResource(personalityLabelInfo.f259897id);
        if (tagResource == null) {
            QLog.i(TAG, 1, "createItemViewSpecial fail because tagResource is null");
            return inflate;
        }
        inflate.setBackground(getTagBackgroundDrawable(personalityLabelInfo.bgColor, tagResource.bgBorderColor, 6, tagResource.bgBorderWidth));
        ImageView imageView = (ImageView) inflate.findViewById(R.id.oux);
        TextView textView = (TextView) inflate.findViewById(R.id.ox7);
        textView.setTextColor(Color.parseColor(tagResource.textColor));
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.otg);
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        textView.setText(personalityLabelInfo.text);
        List<PersonalityLabelPhoto> list = personalityLabelInfo.personalityLabelPhotos;
        if (list != null && list.size() > 0) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(getUrlDrawable(personalityLabelInfo.personalityLabelPhotos.get(0).url));
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.personalitylabel.ElegantProfilePersonalityLabelComponent.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2;
                String str3 = tagResource.url;
                if (((AbsComponent) ElegantProfilePersonalityLabelComponent.this).mActivity == null || TextUtils.isEmpty(str3)) {
                    ElegantProfilePersonalityLabelComponent.this.handleCLickEvent();
                    return;
                }
                if (str3.startsWith("http")) {
                    Intent intent = new Intent(((AbsComponent) ElegantProfilePersonalityLabelComponent.this).mActivity, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str3);
                    ((AbsComponent) ElegantProfilePersonalityLabelComponent.this).mActivity.startActivity(intent);
                }
                long j3 = personalityLabelInfo.f259897id;
                if (j3 > Constant.FROM_ID_STOP_SERVICE && j3 < 1016) {
                    if (((AbsComponent) ElegantProfilePersonalityLabelComponent.this).mApp == null) {
                        QLog.e(ElegantProfilePersonalityLabelComponent.TAG, 1, "PK Label Report mApp == null");
                        return;
                    }
                    String currentAccountUin = ((AbsComponent) ElegantProfilePersonalityLabelComponent.this).mApp.getCurrentAccountUin();
                    if (!TextUtils.isEmpty(currentAccountUin) && Friends.isValidUin(currentAccountUin)) {
                        if (currentAccountUin.equals(((ProfileCardInfo) ((AbsComponent) ElegantProfilePersonalityLabelComponent.this).mData).allInOne.uin)) {
                            str2 = "0";
                        } else {
                            str2 = "1";
                        }
                        SpringPKReportUtil.pkTagClickReport(str2, ((ProfileCardInfo) ((AbsComponent) ElegantProfilePersonalityLabelComponent.this).mData).allInOne.uin, personalityLabelInfo.text, tagResource.reportParamValue);
                        return;
                    }
                    QLog.e(ElegantProfilePersonalityLabelComponent.TAG, 1, "mApp.getCurrentAccountUin() error");
                    return;
                }
                ProfileKoiLikeReportUtil profileKoiLikeReportUtil = ProfileKoiLikeReportUtil.getInstance();
                SpecialPersonalityLabelResourceUtil.TagResource tagResource2 = tagResource;
                profileKoiLikeReportUtil.koiTitleReport(tagResource2.reportEventClick, tagResource2.reportAppKey, tagResource2.reportParamKey, tagResource2.reportParamValue, ((ProfileCardInfo) ((AbsComponent) ElegantProfilePersonalityLabelComponent.this).mData).allInOne.uin);
            }
        });
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.profilecard.component.personalitylabel.ElegantProfilePersonalityLabelComponent.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    inflate.setAlpha(0.5f);
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                inflate.setAlpha(1.0f);
                return false;
            }
        });
        long j3 = personalityLabelInfo.f259897id;
        if (j3 > Constant.FROM_ID_STOP_SERVICE && j3 < 1016) {
            AppInterface appInterface = this.mApp;
            if (appInterface == null) {
                QLog.e(TAG, 1, "PK Label Report mApp == null");
                return inflate;
            }
            String currentAccountUin = appInterface.getCurrentAccountUin();
            if (!TextUtils.isEmpty(currentAccountUin) && Friends.isValidUin(currentAccountUin)) {
                if (currentAccountUin.equals(((ProfileCardInfo) this.mData).allInOne.uin)) {
                    str = "0";
                } else {
                    str = "1";
                }
                SpringPKReportUtil.pkTagImpReport(str, ((ProfileCardInfo) this.mData).allInOne.uin, personalityLabelInfo.text, tagResource.reportParamValue);
            } else {
                QLog.e(TAG, 1, "PK Label Report mApp.getCurrentAccountUin() error");
            }
            return inflate;
        }
        ProfileKoiLikeReportUtil.getInstance().koiTitleReport(tagResource.reportEventImp, tagResource.reportAppKey, tagResource.reportParamKey, tagResource.reportParamValue, ((ProfileCardInfo) this.mData).allInOne.uin);
        return inflate;
    }

    private Drawable getTagBackgroundDrawable(int i3, String str, int i16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ViewUtils.dip2px(i16));
        gradientDrawable.setColor(i3);
        if (!TextUtils.isEmpty(str)) {
            gradientDrawable.setStroke(ViewUtils.dip2px(i17), Color.parseColor(str));
        } else {
            gradientDrawable.setStroke(ViewUtils.dip2px(i17), Color.parseColor(BG_STROKE_DEFAULT_COLOR));
        }
        return gradientDrawable;
    }

    private SpecialPersonalityLabelResourceUtil.TagResource getTagResource(long j3) {
        return SpecialPersonalityLabelResourceUtil.getInstance().getTagResource(j3);
    }

    private static URLDrawable getUrlDrawable(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = new Bundle();
        obtain.mPlayGifImage = true;
        try {
            return URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleCLickEvent() {
        DATA data;
        if (this.mApp == null || this.mActivity == null || (data = this.mData) == 0 || ((ProfileCardInfo) data).allInOne == null) {
            return;
        }
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) ((ProfileCardInfo) data).getBusinessInfo(ProfilePersonalityLabelInfo.class);
        if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.personalityLabelInfos.size() != 0) {
            jump2LabelGallery();
            ProfileCardDtReportUtil.dtReportClick((View) this.mViewContainer);
        } else if (this.mApp instanceof QQAppInterface) {
            ProfileCardDtReportUtil.dtReportClick((View) this.mViewContainer);
            ProfileCardUtil.k0(this.mApp.getCurrentAccountUin(), (QQAppInterface) this.mApp, this.mActivity, true);
        }
    }

    private boolean isSpecialLabel(long j3) {
        return SpecialPersonalityLabelResourceUtil.getInstance().isSpecialLabel(j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void jump2LabelGallery() {
        Intent intent = new Intent(this.mActivity, (Class<?>) PersonalityLabelGalleryActivity.class);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 0);
        String str = ((ProfileCardInfo) this.mData).allInOne.uin;
        intent.putExtra("uin", str);
        if (!TextUtils.equals(str, this.mApp.getCurrentAccountUin()) && !TextUtils.isEmpty(ProfileNameUtils.getCurCardName((ProfileCardInfo) this.mData))) {
            intent.putExtra("nickname", ProfileNameUtils.getCurCardName((ProfileCardInfo) this.mData));
        }
        this.mActivity.startActivityForResult(intent, 1029);
    }

    /* JADX WARN: Type inference failed for: r6v8, types: [android.view.View, VIEW] */
    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent
    protected boolean initView(ProfilePersonalityLabelInfo profilePersonalityLabelInfo, boolean z16) {
        boolean z17;
        QBaseActivity qBaseActivity;
        if (this.mViewContainer != 0 || (qBaseActivity = this.mActivity) == null || qBaseActivity.getResources() == null) {
            z17 = false;
        } else {
            ?? inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.cyy, (ViewGroup) null);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.personalitylabel.ElegantProfilePersonalityLabelComponent.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ElegantProfilePersonalityLabelComponent.this.handleCLickEvent();
                }
            });
            FlowLayoutContainer flowLayoutContainer = (FlowLayoutContainer) inflate.findViewById(R.id.otp);
            flowLayoutContainer.setMargin((int) this.mActivity.getResources().getDimension(R.dimen.f10632l), (int) this.mActivity.getResources().getDimension(R.dimen.f10622k));
            flowLayoutContainer.setMaxLine(2);
            this.mViewContainer = inflate;
            inflate.setBackground(this.mActivity.getResources().getDrawable(R.drawable.ktt));
            z17 = true;
        }
        addLabels(profilePersonalityLabelInfo);
        return z17;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent
    protected boolean isElegantProfile() {
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent
    protected void updateView(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        initView(profilePersonalityLabelInfo, false);
    }
}
