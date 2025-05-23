package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.ElegantAnonymousView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes16.dex */
public class ElegantProfileAnonymousComponent extends ProfileAnonymousComponent {
    static IPatchRedirector $redirector_;
    private static int ELEGANT_PROFILE_MARGIN_BOTTOM;
    private static String TAG;
    private static int TEXT_SIZE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        TAG = "ElegantProfileAnonymousComponent";
        TEXT_SIZE = 12;
        ELEGANT_PROFILE_MARGIN_BOTTOM = 16;
    }

    public ElegantProfileAnonymousComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.BaseProfileAnonymousComponent
    protected View initAnonymousView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ElegantAnonymousView elegantAnonymousView = new ElegantAnonymousView(this.mActivity);
        this.anonymousView = elegantAnonymousView;
        elegantAnonymousView.setTitle(this.mActivity.getString(R.string.f197614kh));
        TextView title = this.anonymousView.getTitle();
        boolean z16 = false;
        if (title != null) {
            title.setTextSize(2, 14.0f);
            title.setTypeface(Typeface.defaultFromStyle(0));
        }
        this.anonymousView.setIcon(this.mActivity.getResources().getDrawable(R.drawable.qui_anonymity));
        this.anonymousView.setIconVisible(true);
        ImageView icon = this.anonymousView.getIcon();
        if (icon != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f));
            layoutParams.rightMargin = ViewUtils.dip2px(14.0f);
            layoutParams.addRule(15);
            icon.setLayoutParams(layoutParams);
        }
        AnonymousView anonymousView = this.anonymousView;
        AppInterface appInterface = this.mApp;
        DATA data = this.mData;
        if (((ProfileCardInfo) data).currentTemplate != null) {
            z16 = true;
        }
        anonymousView.initData(appInterface, z16, ((ProfileCardInfo) data).allInOne.uin);
        return this.anonymousView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, VIEW] */
    @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.BaseProfileAnonymousComponent
    public boolean makeOrRefreshAnonymous(Card card) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) card)).booleanValue();
        }
        ProfileAnonymousAnswerInfo profileAnonymousAnswerInfo = (ProfileAnonymousAnswerInfo) ((ProfileCardInfo) this.mData).getBusinessInfo(ProfileAnonymousAnswerInfo.class);
        IProfileConfig iProfileConfig = this.mConfigHelper;
        boolean z27 = false;
        if (iProfileConfig != null && !iProfileConfig.isSwitchEnable(13)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileDisplaySettingStateFromCard(42425, card, this.mApp) != 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean isPaTypeFriend = ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne);
        boolean isHost = isHost();
        boolean isOwnerProfileCardEmptyItemFoldEnable = ProfileCardFeatureSwitch.INSTANCE.isOwnerProfileCardEmptyItemFoldEnable();
        if (profileAnonymousAnswerInfo != null && profileAnonymousAnswerInfo.mTotalQuestionCount > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (isHost && isOwnerProfileCardEmptyItemFoldEnable && (profileAnonymousAnswerInfo == null || profileAnonymousAnswerInfo.mAnsweredQuestionCount == 0)) {
            z19 = true;
        } else {
            z19 = false;
        }
        isGuestEmptyItemFold(profileAnonymousAnswerInfo, isHost);
        if ((card != null && profileAnonymousAnswerInfo != null && profileAnonymousAnswerInfo.needForbidEntry) || z19) {
            z26 = true;
        } else {
            z26 = false;
        }
        HashMap<String, Object> hashMap = this.reportParams;
        if (z18) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_IS_EMPTY, Integer.valueOf(i3));
        HashMap<String, Object> hashMap2 = this.reportParams;
        if (isGuestEmptyItemFold(profileAnonymousAnswerInfo, isHost)) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        hashMap2.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_GUEST_EMPTY_IS_NEW, Integer.valueOf(i16));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshAnonymous() configEnable=%b, visible=%b , isFriend=%b ,isForbidEntry=%b", Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(isPaTypeFriend), Boolean.valueOf(z26)));
        }
        if (!z26 && z16 && z17 && isPaTypeFriend) {
            if (this.mViewContainer == 0) {
                this.mViewContainer = initAnonymousView();
                if (isHost()) {
                    str = "";
                } else {
                    str = ((ProfileCardInfo) this.mData).allInOne.uin;
                }
                String str4 = str;
                if (isHost()) {
                    str2 = "0X800B461";
                } else {
                    str2 = "0X800B462";
                }
                if (isHost()) {
                    str3 = "0X800B461";
                } else {
                    str3 = "0X800B462";
                }
                ReportController.o(null, "dc00898", "", str4, str2, str3, 0, 0, "", "", "", "");
                z27 = true;
            }
            refreshAnonymousUI(profileAnonymousAnswerInfo, (ElegantAnonymousView) this.anonymousView, isHost);
            return z27;
        }
        if (this.mViewContainer == 0) {
            return false;
        }
        this.mViewContainer = null;
        return true;
    }

    protected void refreshAnonymousUI(ProfileAnonymousAnswerInfo profileAnonymousAnswerInfo, ElegantAnonymousView elegantAnonymousView, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        List<AnonymousQuestion> arrayList;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, profileAnonymousAnswerInfo, elegantAnonymousView, Boolean.valueOf(z16));
            return;
        }
        if (profileAnonymousAnswerInfo != null && profileAnonymousAnswerInfo.mTotalQuestionCount > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (profileAnonymousAnswerInfo != null && profileAnonymousAnswerInfo.mAnonymousQuestions.size() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 && profileAnonymousAnswerInfo.mTotalQuestionCount > profileAnonymousAnswerInfo.mAnonymousQuestions.size()) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z16 && !z18) {
            elegantAnonymousView.mTitleExtContainer.removeAllViews();
            elegantAnonymousView.setTitle(this.mActivity.getString(R.string.f203244zo));
            elegantAnonymousView.removeContentViews();
            elegantAnonymousView.setMarginBottomEnable(false);
            changeEmptyAndRefreshStatus(true);
            return;
        }
        changeEmptyAndRefreshStatus(false);
        elegantAnonymousView.setMarginBottomEnable(false);
        elegantAnonymousView.setContentMarginBottom(ELEGANT_PROFILE_MARGIN_BOTTOM);
        if (z17) {
            if (isHost()) {
                i3 = R.string.f197644kk;
            } else {
                i3 = R.string.f197684ko;
            }
            if (isHost()) {
                i16 = profileAnonymousAnswerInfo.mTotalQuestionCount;
            } else {
                i16 = profileAnonymousAnswerInfo.mAnsweredQuestionCount;
            }
            if (i16 > 0) {
                String format = String.format(this.mActivity.getString(i3), Integer.valueOf(i16));
                TextView textView = new TextView(this.mActivity);
                textView.setText(format);
                textView.setTextSize(2, TEXT_SIZE);
                textView.setTextColor(this.mActivity.getResources().getColor(R.color.qui_common_text_secondary));
                elegantAnonymousView.mTitleExtContainer.removeAllViews();
                elegantAnonymousView.mTitleExtContainer.addView(textView);
                elegantAnonymousView.mTitleExtContainer.setVisibility(0);
            }
        }
        if (AnonymousRedPointUtils.showProfileRedPointGuide(this.mApp) && isHost()) {
            Drawable drawable = elegantAnonymousView.getResources().getDrawable(R.drawable.skin_tips_dot);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            elegantAnonymousView.mTitleText.setCompoundDrawables(null, null, drawable, null);
            elegantAnonymousView.mTitleText.setCompoundDrawablePadding(Utils.n(4.0f, elegantAnonymousView.getResources()));
        }
        if (profileAnonymousAnswerInfo != null) {
            arrayList = profileAnonymousAnswerInfo.mAnonymousQuestions;
        } else {
            arrayList = new ArrayList<>();
        }
        elegantAnonymousView.show(buildRecyclerAdapterData(arrayList, z17, z18, z19));
    }
}
