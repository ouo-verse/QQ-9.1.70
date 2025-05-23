package com.tencent.mobileqq.profilecard.bussiness.personalitylabel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.c;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes16.dex */
public class ProfilePersonalityLabelComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String DT_EV_EDIT_LABEL_FINISH = "ev_profile_completelabel";
    private static final String TAG = "ProfilePersonalityLabelComponent";
    private boolean isInitDtReport;
    private Handler mHandler;
    private boolean mHasScrollToPersonalityLabel;
    private BroadcastReceiver mModifyDetailReceiver;
    private c mPersonalityLabelObserver;
    private boolean mScrollToPersonalityLabel;

    public ProfilePersonalityLabelComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.isInitDtReport = false;
            this.mPersonalityLabelObserver = new c() { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfilePersonalityLabelComponent.this);
                    }
                }

                @Override // com.tencent.mobileqq.profile.PersonalityLabel.c
                public void onGetPersonalityLabel(boolean z16, String str, ProfilePersonalityLabelInfo profilePersonalityLabelInfo, byte[] bArr, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str, profilePersonalityLabelInfo, bArr, Integer.valueOf(i3));
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(ProfilePersonalityLabelComponent.TAG, 2, String.format("onGetPersonalityLabel isSuccess=%s uin=%s flag=%s", Boolean.valueOf(z16), str, Integer.valueOf(i3)));
                    }
                    if (((AbsComponent) ProfilePersonalityLabelComponent.this).mData != null && TextUtils.equals(str, ((ProfileCardInfo) ((AbsComponent) ProfilePersonalityLabelComponent.this).mData).allInOne.uin)) {
                        ((ProfileCardInfo) ((AbsComponent) ProfilePersonalityLabelComponent.this).mData).putBusinessInfo(profilePersonalityLabelInfo);
                        ProfilePersonalityLabelComponent.this.initView(profilePersonalityLabelInfo, true);
                    }
                }
            };
        }
    }

    private void destroyModifyDetailReceiver() {
        try {
            BroadcastReceiver broadcastReceiver = this.mModifyDetailReceiver;
            if (broadcastReceiver != null) {
                this.mActivity.unregisterReceiver(broadcastReceiver);
                this.mModifyDetailReceiver = null;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "destroyModifyDetailReceiver " + e16);
        }
    }

    private void initModifyDetailReceiver() {
        if (this.mModifyDetailReceiver == null) {
            this.mModifyDetailReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfilePersonalityLabelComponent.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    Bundle bundleExtra = intent.getBundleExtra(SpecialProxy.KEY_DATA);
                    if (bundleExtra != null) {
                        boolean z16 = bundleExtra.getBoolean("onTagChanged");
                        if (QLog.isColorLevel()) {
                            QLog.d(ProfilePersonalityLabelComponent.TAG, 2, String.format("onReceive addTag=%s", Boolean.valueOf(z16)));
                        }
                        if (z16) {
                            ((PersonalityLabelHandler) ((AbsComponent) ProfilePersonalityLabelComponent.this).mApp.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).F2(((ProfileCardInfo) ((AbsComponent) ProfilePersonalityLabelComponent.this).mData).allInOne.uin, 0);
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.card.modify_personality_label");
            intentFilter.setPriority(Integer.MAX_VALUE);
            try {
                this.mActivity.registerReceiver(this.mModifyDetailReceiver, intentFilter);
            } catch (AssertionError e16) {
                QLog.i(TAG, 1, "initModifyDetailReceiver error" + e16);
            }
        }
    }

    private boolean isOwnerProfileCardEmptyItemFoldEnable() {
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        if (qQAppInterface == null) {
            return false;
        }
        return ((IFeatureRuntimeService) qQAppInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(ProfileCardFeatureSwitch.PROFILE_CARD_EMPTY_ITEM_FOLD_OWNER);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean makeOrRefreshPersonalityLabel(Card card, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        int i3;
        if (this.mApp == null) {
            return false;
        }
        boolean isElegantProfile = isElegantProfile();
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) ((ProfileCardInfo) this.mData).getBusinessInfo(ProfilePersonalityLabelInfo.class);
        boolean isPaTypeStrangerInContact = ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) this.mData).allInOne);
        boolean G = Utils.G(((ProfileCardInfo) this.mData).allInOne.uin);
        IProfileConfig iProfileConfig = this.mConfigHelper;
        if (iProfileConfig != null && !iProfileConfig.isSwitchEnable(3)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (card != null && profilePersonalityLabelInfo == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (card != null && profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.getSize() == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (card != null && profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.getSize() == 0 && !Utils.p(((ProfileCardInfo) this.mData).allInOne.uin, this.mApp.getCurrentAccountUin())) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (card != null && profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.isCloseByUser == 1) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (!isPaTypeStrangerInContact && !G && !z17 && !z18 && ((!z19 || isElegantProfile) && !z26 && !z27)) {
            z28 = false;
        } else {
            z28 = true;
        }
        HashMap hashMap = new HashMap();
        if (z19) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_IS_EMPTY, Integer.valueOf(i3));
        VideoReport.setElementParams(this.mViewContainer, hashMap);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshPersonalityLabel shouldNotShow=%s isStrangerInContact=%s isBabyQ=%s configDisable=%s dataIsNull=%s dataIsEmpty=%s dataIsEmptyForGuest=%s closeByUser=%s", Boolean.valueOf(z28), Boolean.valueOf(isPaTypeStrangerInContact), Boolean.valueOf(G), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Boolean.valueOf(z27)));
        }
        if (card != null && !z28) {
            return initView(profilePersonalityLabelInfo, z16);
        }
        if (this.mViewContainer == 0) {
            return false;
        }
        this.mViewContainer = null;
        return true;
    }

    private void scrollToPhotoWall() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfilePersonalityLabelComponent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int top;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (((AbsComponent) ProfilePersonalityLabelComponent.this).mViewContainer != null && (top = ((View) ((AbsComponent) ProfilePersonalityLabelComponent.this).mViewContainer).getTop()) >= 0 && ((AbsProfileComponent) ProfilePersonalityLabelComponent.this).mDelegate != null) {
                        ((AbsProfileComponent) ProfilePersonalityLabelComponent.this).mDelegate.scrollToMoreInfoView(top);
                    }
                }
            }, 1000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updatePersonalityLabelTheme(ProfileContentTitleView profileContentTitleView, PersonalityLabelBoard personalityLabelBoard) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z16;
        boolean isInNightMode;
        boolean z17;
        TagCloudView tagCloudView;
        ColorStateList colorStateList3;
        ConcurrentHashMap<String, Object> concurrentHashMap;
        boolean z18 = true;
        updateItemTheme(profileContentTitleView, true);
        int i3 = -16777216;
        try {
            ProfileCardTemplate profileCardTemplate = ((ProfileCardInfo) this.mData).currentTemplate;
            if (profileCardTemplate != null && (concurrentHashMap = profileCardTemplate.templateAttr) != null && concurrentHashMap.size() > 0) {
                Object obj = profileCardTemplate.templateAttr.get("commonItemContentColor");
                if (obj != null) {
                    if (obj instanceof ColorStateList) {
                        colorStateList3 = (ColorStateList) obj;
                    } else if (obj instanceof String) {
                        String str = (String) obj;
                        if (str.startsWith("#")) {
                            Color.parseColor(str);
                        }
                    }
                }
                colorStateList3 = null;
            } else {
                colorStateList3 = this.mActivity.getResources().getColorStateList(R.color.skin_black);
            }
            colorStateList = colorStateList3;
            try {
                TagCloudView tagCloudView2 = personalityLabelBoard.D;
                if (tagCloudView2 != null) {
                    i3 = tagCloudView2.k();
                }
            } catch (Exception e16) {
                e = e16;
                QLog.e(TAG, 1, "updatePersonalityLabelTheme fail.", e);
                int i16 = i3;
                colorStateList2 = colorStateList;
                if (((ProfileCardInfo) this.mData).curUseStyleId == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
                }
                if (z16) {
                }
                isInNightMode = ThemeUtil.isInNightMode(this.mApp);
                if (((ProfileCardInfo) this.mData).currentTemplate == null) {
                }
                if (!isInNightMode) {
                }
                z18 = false;
                personalityLabelBoard.setIsNormalTheme(z18);
                tagCloudView = personalityLabelBoard.D;
                if (tagCloudView != null) {
                }
                if (isInNightMode) {
                    updateItemTheme(null, personalityLabelBoard.f259807m, null, personalityLabelBoard.f259806i, null, null, null, profileContentTitleView.mContentContainer);
                }
                if (colorStateList2 == null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            colorStateList = null;
        }
        int i162 = i3;
        colorStateList2 = colorStateList;
        if (((ProfileCardInfo) this.mData).curUseStyleId == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            profileContentTitleView.setClickable(true);
        }
        isInNightMode = ThemeUtil.isInNightMode(this.mApp);
        if (((ProfileCardInfo) this.mData).currentTemplate == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!isInNightMode || z17) {
            z18 = false;
        }
        personalityLabelBoard.setIsNormalTheme(z18);
        tagCloudView = personalityLabelBoard.D;
        if (tagCloudView != null) {
            if (z16) {
                tagCloudView.setBackgroundDrawable(null);
            } else {
                tagCloudView.setBackgroundResource(R.drawable.f160556k2);
            }
            if (colorStateList2 != null) {
                personalityLabelBoard.D.setTextColor(colorStateList2);
            } else {
                personalityLabelBoard.D.setTextColor(i162);
            }
        }
        if (isInNightMode && z16) {
            updateItemTheme(null, personalityLabelBoard.f259807m, null, personalityLabelBoard.f259806i, null, null, null, profileContentTitleView.mContentContainer);
        }
        if (colorStateList2 == null) {
            personalityLabelBoard.setTextColors(colorStateList2);
        } else {
            personalityLabelBoard.setTextColors(ColorStateList.valueOf(i162));
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
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
        return 1010;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_PERSONALITY_LABEL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView, VIEW] */
    protected boolean initView(ProfilePersonalityLabelInfo profilePersonalityLabelInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, profilePersonalityLabelInfo, Boolean.valueOf(z16))).booleanValue();
        }
        if (this.mViewContainer == 0) {
            PersonalityLabelBoard personalityLabelBoard = new PersonalityLabelBoard(this.mActivity, this.mQQAppInterface, ((ProfileCardInfo) this.mData).allInOne.uin);
            ?? profileContentTitleView = new ProfileContentTitleView(this.mActivity);
            profileContentTitleView.setTitle(HardCodeUtil.qqStr(R.string.pd8));
            profileContentTitleView.addContentView(personalityLabelBoard);
            this.mViewContainer = profileContentTitleView;
        } else {
            z17 = false;
        }
        ProfileContentTitleView profileContentTitleView2 = (ProfileContentTitleView) this.mViewContainer;
        PersonalityLabelBoard personalityLabelBoard2 = (PersonalityLabelBoard) profileContentTitleView2.getContentView();
        personalityLabelBoard2.setNick(ProfileNameUtils.getCurCardName((ProfileCardInfo) this.mData));
        personalityLabelBoard2.d(profilePersonalityLabelInfo, z16, false);
        personalityLabelBoard2.setPersonalityLabelComponent(this);
        profileContentTitleView2.mTitleContainer.setTag(new b(86, profileContentTitleView2.getContentView()));
        profileContentTitleView2.mTitleContainer.setOnClickListener(this);
        updatePersonalityLabelTheme(profileContentTitleView2, personalityLabelBoard2);
        return z17;
    }

    protected boolean isElegantProfile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        DATA data;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 != 1029 || (data = this.mData) == 0) {
            return;
        }
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) ((ProfileCardInfo) data).getBusinessInfo(ProfilePersonalityLabelInfo.class);
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0 && profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.unreadCount > 0) {
            profilePersonalityLabelInfo.unreadCount = 0;
        }
        if (profilePersonalityLabelInfo != null) {
            updateView(profilePersonalityLabelInfo);
        }
        if (i16 == -1) {
            ((PersonalityLabelHandler) this.mApp.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).F2(this.mApp.getCurrentAccountUin(), 0);
            DATA data2 = this.mData;
            if (((ProfileCardInfo) data2).card == null) {
                str = "";
            } else {
                str = ((ProfileCardInfo) data2).allInOne.uin;
            }
            ProfileCardDtReportUtil.reportCommonEvent(this.mApp, str, DT_EV_EDIT_LABEL_FINISH);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            ProfileCardDtReportUtil.dtReportClick((View) this.mViewContainer);
            if (view.getTag() instanceof b) {
                b bVar = (b) view.getTag();
                if (bVar.f260135a == 86) {
                    Object obj = bVar.f260136b;
                    if (obj instanceof PersonalityLabelBoard) {
                        ((PersonalityLabelBoard) obj).g(false);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        this.mApp.addObserver(this.mPersonalityLabelObserver);
        initModifyDetailReceiver();
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mScrollToPersonalityLabel = intent.getBooleanExtra("profile_scroll_to_personality_label", false);
        }
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        this.mApp.removeObserver(this.mPersonalityLabelObserver);
        destroyModifyDetailReceiver();
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        VIEW view = this.mViewContainer;
        if (view instanceof ProfileContentTitleView) {
            ((PersonalityLabelBoard) ((ProfileContentTitleView) view).getContentView()).e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void updateView(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) profilePersonalityLabelInfo);
            return;
        }
        VIEW view = this.mViewContainer;
        if (view instanceof ProfileContentTitleView) {
            ((PersonalityLabelBoard) ((ProfileContentTitleView) view).getContentView()).d(profilePersonalityLabelInfo, false, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfilePersonalityLabelComponent) profileCardInfo);
        DATA data = this.mData;
        boolean makeOrRefreshPersonalityLabel = lambda$checkValidComponent$3 | makeOrRefreshPersonalityLabel(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
        if (this.mScrollToPersonalityLabel && !this.mHasScrollToPersonalityLabel) {
            this.mHasScrollToPersonalityLabel = true;
            scrollToPhotoWall();
        }
        if (makeOrRefreshPersonalityLabel && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) view, ProfileCardDtReportUtil.DT_REPORT_TAG);
        }
        return makeOrRefreshPersonalityLabel;
    }
}
