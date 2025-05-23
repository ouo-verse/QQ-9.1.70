package com.tencent.mobileqq.profilecard.more.component;

import android.app.Activity;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.profile.i;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.handler.ProfileCardFeatureHandler;
import com.tencent.mobileqq.profilecard.bussiness.observer.ProfileCardFeatureObserver;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.more.PersonalInfo;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreController;
import com.tencent.mobileqq.profilecard.more.widget.ComponentTitleView;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ExpandAnimation;
import com.tencent.mobileqq.profilecard.utils.ProfileDateUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qcall.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes35.dex */
public class PersonalInfoComponent extends AbsMoreComponent {
    private static final int CONTENT_ROOT_VIEW_MARGIN_BOTTOM = 13;
    private static final int CONTENT_ROOT_VIEW_MARGIN_LEFT_RIGHT = 16;
    private static final int MAX_STOW_ITEM_NUM = 6;
    private static final String TAG = "PersonalInfoComponent";
    private ImageView mArrowIcon;
    private ViewGroup mBaseContainer;
    private CardHandler mCardHandler;
    private CardObserver mCardObserver;
    private ArrayList<PersonalInfo> mDatas;
    private List<PersonalInfo> mEducationList;
    private ViewGroup mExpandAndStowContainer;
    private ExpandAnimation mExpandAnimation;
    private ViewGroup mExpandContainer;
    private ProfileCardFeatureObserver mFeatureObserver;
    private boolean mIsPause;
    private ProfileCardInfo mProfileCardInfo;
    private final ProfileCardObserver mProfileCardObserver;
    private String mSourceWording;

    public PersonalInfoComponent(ProfileCardMoreController profileCardMoreController) {
        super(profileCardMoreController);
        this.mDatas = new ArrayList<>();
        this.mEducationList = new ArrayList();
        this.mIsPause = false;
        this.mSourceWording = "";
        this.mProfileCardInfo = null;
        this.mProfileCardObserver = new ProfileCardObserver() { // from class: com.tencent.mobileqq.profilecard.more.component.PersonalInfoComponent.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            public void onGetProfileDetail(boolean z16, String str, final Card card) {
                if (QLog.isColorLevel()) {
                    QLog.d(PersonalInfoComponent.TAG, 2, "onGetProfileDetail uin=" + g.b(str));
                }
                super.onGetProfileDetail(z16, str, card);
                if (z16 && card != null && Utils.p(PersonalInfoComponent.this.mMoreController.mTargetUin, card.uin)) {
                    PersonalInfoComponent.this.mMoreController.mApp.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.more.component.PersonalInfoComponent.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PersonalInfoComponent.this.mIsPause) {
                                return;
                            }
                            PersonalInfoComponent personalInfoComponent = PersonalInfoComponent.this;
                            ProfileCardMoreController profileCardMoreController2 = personalInfoComponent.mMoreController;
                            Card card2 = card;
                            profileCardMoreController2.mCard = card2;
                            personalInfoComponent.updateData(card2);
                            PersonalInfoComponent.this.updateExpandView();
                        }
                    });
                }
            }
        };
        this.mCardObserver = new CardObserver() { // from class: com.tencent.mobileqq.profilecard.more.component.PersonalInfoComponent.2
            @Override // com.tencent.mobileqq.app.CardObserver
            protected void onGetEducationList(boolean z16, long j3, ArrayList<i> arrayList) {
                if (QLog.isColorLevel()) {
                    QLog.d(PersonalInfoComponent.TAG, 2, "onGetEducationList, success:" + z16 + ", uin=" + g.a(j3));
                }
                if (!z16 || PersonalInfoComponent.this.mIsPause) {
                    return;
                }
                PersonalInfoComponent.this.mEducationList.clear();
                PersonalInfoComponent.this.mEducationList.addAll(PersonalInfoComponent.this.getEducationList(arrayList));
                PersonalInfoComponent personalInfoComponent = PersonalInfoComponent.this;
                personalInfoComponent.updateData(personalInfoComponent.mMoreController.mCard);
                PersonalInfoComponent.this.updateExpandView();
            }
        };
        this.mFeatureObserver = new ProfileCardFeatureObserver() { // from class: com.tencent.mobileqq.profilecard.more.component.PersonalInfoComponent.3
            @Override // com.tencent.mobileqq.profilecard.bussiness.observer.ProfileCardFeatureObserver
            protected void onGetFriendSource(boolean z16, String str) {
                if (QLog.isColorLevel()) {
                    QLog.d(PersonalInfoComponent.TAG, 2, "onGetFriendSource, success:" + z16 + ", sourceWording=" + String.valueOf(str));
                }
                if (z16 || !TextUtils.isEmpty(str)) {
                    PersonalInfoComponent.this.mSourceWording = str;
                    PersonalInfoComponent personalInfoComponent = PersonalInfoComponent.this;
                    personalInfoComponent.updateData(personalInfoComponent.mMoreController.mCard);
                    PersonalInfoComponent.this.updateExpandView();
                }
            }
        };
    }

    private void addAgeInfo(ProfileCardInfo profileCardInfo) {
        short ageWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getAgeWithPrivacy(profileCardInfo);
        if (ageWithPrivacy > 0) {
            this.mDatas.add(getInfo(R.string.f169707x52, String.valueOf((int) ageWithPrivacy)));
        }
    }

    private void addBirthdayInfo(ProfileCardInfo profileCardInfo) {
        long birthdayWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getBirthdayWithPrivacy(profileCardInfo);
        if (birthdayWithPrivacy > 0) {
            this.mDatas.add(getInfo(R.string.f169708x53, getBirthday((int) birthdayWithPrivacy)));
        }
    }

    private void addCompanyInfo(ProfileCardInfo profileCardInfo) {
        String companyWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getCompanyWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(companyWithPrivacy)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.f169709x54, companyWithPrivacy));
    }

    private void addConstellationInfo(ProfileCardInfo profileCardInfo) {
        String constellationWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getConstellationWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(constellationWithPrivacy)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.x55, constellationWithPrivacy));
    }

    private void addDividerInfo() {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.type = 2;
        this.mDatas.add(personalInfo);
    }

    private void addEmailInfo(ProfileCardInfo profileCardInfo) {
        String emailWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getEmailWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(emailWithPrivacy)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.x56, emailWithPrivacy));
    }

    private void addFriendSourceInfo() {
        String str = this.mSourceWording;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.x57, str));
    }

    private void addGenderInfo(ProfileCardInfo profileCardInfo) {
        ProfileCardMoreController profileCardMoreController;
        int i3;
        short genderWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getGenderWithPrivacy(profileCardInfo);
        if (genderWithPrivacy == 0 || genderWithPrivacy == 1) {
            if (genderWithPrivacy == 0) {
                profileCardMoreController = this.mMoreController;
                i3 = R.string.x4k;
            } else {
                profileCardMoreController = this.mMoreController;
                i3 = R.string.x4j;
            }
            this.mDatas.add(getInfo(R.string.x58, profileCardMoreController.getString(i3)));
        }
    }

    private void addHometownInfo(ProfileCardInfo profileCardInfo) {
        String hometownWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getHometownWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(hometownWithPrivacy)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.x59, hometownWithPrivacy));
    }

    private void addLocationInfo(ProfileCardInfo profileCardInfo) {
        String local = getLocal(profileCardInfo);
        if (TextUtils.isEmpty(local)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.x5c, local));
    }

    private void addNickInfo() {
        if (TextUtils.isEmpty(this.mMoreController.mCard.strNick)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.x5f, this.mMoreController.mCard.strNick));
    }

    private void addPersonalDescriptionInfo(ProfileCardInfo profileCardInfo) {
        String personalDescription = getPersonalDescription(profileCardInfo);
        if (TextUtils.isEmpty(personalDescription)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.x5g, personalDescription));
    }

    private void addProfessionInfo(ProfileCardInfo profileCardInfo) {
        String professionWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfessionWithPrivacy(profileCardInfo);
        if (TextUtils.isEmpty(professionWithPrivacy)) {
            return;
        }
        this.mDatas.add(getInfo(R.string.x5_, professionWithPrivacy));
    }

    private View buildContentView(int i3, String str) {
        View inflate = LayoutInflater.from(this.mMoreController.mActivity).inflate(R.layout.f167373cz2, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.f163207ow1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.otw);
        textView.setText(i3);
        textView2.setText(str);
        if (this.mMoreController.isNightMode()) {
            textView.setTextColor(-7500397);
            textView2.setTextColor(-1);
        }
        if (inflate.getParent() != null) {
            ((ViewGroup) inflate.getParent()).removeView(inflate);
        }
        return inflate;
    }

    private View buildDividerView() {
        View inflate = LayoutInflater.from(this.mMoreController.mActivity).inflate(R.layout.f167374cz3, (ViewGroup) null);
        if (this.mMoreController.isNightMode()) {
            inflate.findViewById(R.id.f163209ow3).setBackgroundColor(-12763839);
        }
        if (inflate.getParent() != null) {
            ((ViewGroup) inflate.getParent()).removeView(inflate);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<PersonalInfo> getEducationList(ArrayList<i> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                Iterator<i> it = arrayList.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (!TextUtils.isEmpty(next.f260185d) && !next.f260192k) {
                        int i3 = next.f260183b;
                        if (i3 == 3) {
                            stringBuffer.append(next.f260185d);
                            stringBuffer.append(" ");
                            stringBuffer.append(getDegreeName(next.f260188g));
                            stringBuffer.append("\n");
                        } else if (i3 == 2) {
                            stringBuffer2.append(next.f260185d);
                            stringBuffer2.append("\n");
                        } else if (i3 == 1) {
                            stringBuffer3.append(next.f260185d);
                            stringBuffer3.append("\n");
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    arrayList2.add(getInfo(R.string.x5j, stringBuffer.toString()));
                }
                if (stringBuffer2.length() > 0) {
                    stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
                    arrayList2.add(getInfo(R.string.x5d, stringBuffer2.toString()));
                }
                if (stringBuffer3.length() > 0) {
                    stringBuffer3.deleteCharAt(stringBuffer3.length() - 1);
                    arrayList2.add(getInfo(R.string.x5h, stringBuffer3.toString()));
                }
            } else {
                Card card = this.mMoreController.mCard;
                if (card != null && !TextUtils.isEmpty(card.strSchool)) {
                    arrayList2.add(getInfo(R.string.x5i, card.strSchool));
                }
            }
        }
        return arrayList2;
    }

    private PersonalInfo getInfo(int i3, String str) {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.name = i3;
        personalInfo.content = str;
        return personalInfo;
    }

    private String getLocal(ProfileCardInfo profileCardInfo) {
        String locationCountryWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationCountryWithPrivacy(profileCardInfo);
        String locationProvinceWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationProvinceWithPrivacy(profileCardInfo);
        String locationCityWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getLocationCityWithPrivacy(profileCardInfo);
        String str = "";
        if (!TextUtils.isEmpty(locationCountryWithPrivacy) && !HardCodeUtil.qqStr(R.string.pef).equals(locationCountryWithPrivacy)) {
            str = "" + locationCountryWithPrivacy;
        }
        if (!TextUtils.isEmpty(locationProvinceWithPrivacy)) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "-";
            }
            str = str + locationProvinceWithPrivacy;
        }
        if (TextUtils.isEmpty(locationCityWithPrivacy)) {
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + "-";
        }
        return str + locationCityWithPrivacy;
    }

    private String getPersonalDescription(ProfileCardInfo profileCardInfo) {
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41623, profileCardInfo)) {
            return profileCardInfo.card.strPersonalNote;
        }
        return null;
    }

    private void getSourceWording() {
        try {
            ((ProfileCardFeatureHandler) this.mMoreController.mApp.getBusinessHandler(ProfileCardFeatureHandler.class.getName())).getFriendSource(Long.parseLong(this.mMoreController.mTargetUin));
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "getSourceWording:" + e16.toString());
        }
    }

    private void ifNeedRemoveDivider() {
        if (this.mDatas.size() <= 0) {
            return;
        }
        if (this.mDatas.get(r0.size() - 1).type == 2) {
            this.mDatas.remove(r0.size() - 1);
        }
    }

    private void initExpandView() {
        View inflate = LayoutInflater.from(this.mViewContainer.getComponentContent().getContext()).inflate(R.layout.czh, (ViewGroup) null);
        this.mViewContainer.addComponentContent(inflate);
        this.mExpandContainer = (ViewGroup) inflate.findViewById(R.id.ou6);
        this.mBaseContainer = (ViewGroup) inflate.findViewById(R.id.otm);
        this.mArrowIcon = (ImageView) inflate.findViewById(R.id.oth);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.f163200ou4);
        this.mExpandAndStowContainer = viewGroup;
        viewGroup.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.rightMargin = ViewUtils.dip2px(16.0f);
        layoutParams.leftMargin = ViewUtils.dip2px(16.0f);
        layoutParams.bottomMargin = ViewUtils.dip2px(13.0f);
        if (this.mMoreController.isNightMode()) {
            inflate.findViewById(R.id.ou5).setBackgroundResource(R.drawable.g_o);
            this.mArrowIcon.setImageResource(R.drawable.g7i);
            this.mExpandAndStowContainer.setBackgroundResource(R.drawable.g7q);
        }
        ExpandAnimation expandAnimation = new ExpandAnimation(this.mExpandContainer);
        this.mExpandAnimation = expandAnimation;
        expandAnimation.initExpand(false);
        this.mMoreController.initDtElementReport(this.mExpandAndStowContainer, ProfileCardMoreConstants.DT_EM_PROFILE_MORE_UNFOLD, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_FIRST);
    }

    private void initRequestObserver() {
        if (!this.mMoreController.isSelf()) {
            this.mMoreController.mApp.addObserver(this.mProfileCardObserver);
            this.mMoreController.mApp.addObserver(this.mFeatureObserver);
        }
        this.mMoreController.mApp.addObserver(this.mCardObserver);
    }

    private void initViewContainer() {
        this.mViewContainer.setTitle(R.string.x4e);
        ComponentTitleView componentTitleView = this.mViewContainer;
        componentTitleView.setRightTxt(componentTitleView.getContext().getString(R.string.x4i));
        this.mViewContainer.setOnClickListener(this);
        this.mViewContainer.setRightContainerState(this.mMoreController.isSelf() ? 0 : 8);
        this.mViewContainer.getRightContainer().setOnClickListener(this);
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        ComponentTitleView componentTitleView2 = this.mViewContainer;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        profileCardMoreController.initDtElementReport(componentTitleView2, ProfileCardMoreConstants.DT_EM_PROFILE_MORE_BASIC, clickPolicy, ExposurePolicy.REPORT_FIRST);
        this.mMoreController.initDtElementReport(this.mViewContainer.getRightContainer(), ProfileCardMoreConstants.DT_EM_PROFILE_MORE_EDIT, clickPolicy, ExposurePolicy.REPORT_NONE);
    }

    private boolean isNeedShowEducation() {
        ProfileCardInfo profileCardInfo = new ProfileCardInfo();
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        profileCardInfo.allInOne = profileCardMoreController.mAllInOne;
        profileCardInfo.card = profileCardMoreController.mCard;
        return ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41619, profileCardInfo);
    }

    private float measureTextHeight(String str) {
        TextView textView = (TextView) LayoutInflater.from(this.mMoreController.mActivity).inflate(R.layout.f167373cz2, (ViewGroup) null).findViewById(R.id.otw);
        textView.setText(str);
        int screenWidth = DisplayHelper.getScreenWidth(this.mMoreController.mActivity) - ViewUtils.dip2px(162.0f);
        textView.setWidth(screenWidth);
        TextPaint paint = textView.getPaint();
        int lineCount = new StaticLayout(str, paint, screenWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f16 = (fontMetrics.bottom - fontMetrics.top) * lineCount;
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "measureTextHeight == " + f16);
        }
        return f16;
    }

    private void requestEducationList(String str) {
        if (!isNeedShowEducation()) {
            QLog.d(TAG, 1, "requestEducationList: not need show education");
            return;
        }
        if (this.mCardHandler == null) {
            this.mCardHandler = (CardHandler) this.mMoreController.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "uin == null");
            return;
        }
        try {
            long longValue = Long.valueOf(str).longValue();
            this.mCardHandler.V2(longValue, this.mMoreController.mApp.getCurrentAccountUin().equals(Long.valueOf(longValue)));
        } catch (NumberFormatException e16) {
            QLog.d(TAG, 1, "numberFormatException == " + e16.toString());
        }
    }

    private void showExpandTxtAndIcon() {
        if (this.mMoreController.isNightMode()) {
            this.mArrowIcon.setImageResource(R.drawable.g7i);
        } else {
            this.mArrowIcon.setImageResource(R.drawable.g7h);
        }
    }

    private void showStowTxtAndIcon() {
        if (this.mMoreController.isNightMode()) {
            this.mArrowIcon.setImageResource(R.drawable.g9a);
        } else {
            this.mArrowIcon.setImageResource(R.drawable.g8i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateData(Card card) {
        ProfileCardInfo profileCardInfo = new ProfileCardInfo();
        profileCardInfo.allInOne = this.mMoreController.mAllInOne;
        profileCardInfo.card = card;
        this.mProfileCardInfo = profileCardInfo;
        this.mDatas.clear();
        addNickInfo();
        addGenderInfo(profileCardInfo);
        addAgeInfo(profileCardInfo);
        addBirthdayInfo(profileCardInfo);
        addConstellationInfo(profileCardInfo);
        addLocationInfo(profileCardInfo);
        addHometownInfo(profileCardInfo);
        addDividerInfo();
        this.mDatas.addAll(this.mEducationList);
        addProfessionInfo(profileCardInfo);
        addCompanyInfo(profileCardInfo);
        addEmailInfo(profileCardInfo);
        addPersonalDescriptionInfo(profileCardInfo);
        ifNeedRemoveDivider();
        addDividerInfo();
        addFriendSourceInfo();
        ifNeedRemoveDivider();
    }

    private void updateRequestData() {
        if (!this.mMoreController.isSelf()) {
            getProfileDetail(this.mMoreController.mTargetUin);
            getSourceWording();
        }
        requestEducationList(this.mMoreController.mTargetUin);
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getComponentKey() {
        return ProfileCardMoreConstants.MORE_COMPONENT_KEY_BASIC_DATA;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getPartIndex() {
        return 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.f163200ou4) {
            this.mExpandAnimation.toggleExpand();
            if (this.mExpandAnimation.isExpand()) {
                showStowTxtAndIcon();
            } else {
                showExpandTxtAndIcon();
            }
            VideoReport.reportEvent("dt_clck", this.mExpandAndStowContainer, null);
            return;
        }
        if (id5 != R.id.owu) {
            return;
        }
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        Activity activity = profileCardMoreController.mActivity;
        if (activity != null) {
            ProfileCardUtils.openProfileEdit(profileCardMoreController.mApp, activity, this.mProfileCardInfo);
        }
        VideoReport.reportEvent("dt_clck", this.mViewContainer.getRightContainer(), null);
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onCreate(LayoutInflater layoutInflater) {
        super.onCreate(layoutInflater);
        initViewContainer();
        initRequestObserver();
        initExpandView();
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onDestroy() {
        if (!this.mMoreController.isSelf()) {
            this.mMoreController.mApp.removeObserver(this.mProfileCardObserver);
            this.mMoreController.mApp.removeObserver(this.mFeatureObserver);
        }
        this.mMoreController.mApp.removeObserver(this.mCardObserver);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onStart() {
        super.onStart();
        this.mMoreController.updateCard();
        updateData(this.mMoreController.mCard);
        updateExpandView();
        updateRequestData();
    }

    public void updateExpandView() {
        View buildContentView;
        if (this.mExpandContainer == null || this.mBaseContainer == null) {
            return;
        }
        this.mExpandAnimation.updateViewHeight(measureExpandHeight());
        if (this.mBaseContainer.getChildCount() > 0) {
            this.mBaseContainer.removeAllViews();
        }
        if (this.mExpandContainer.getChildCount() > 0) {
            this.mExpandContainer.removeAllViews();
        }
        for (int i3 = 0; i3 < this.mDatas.size(); i3++) {
            PersonalInfo personalInfo = this.mDatas.get(i3);
            if (personalInfo.type == 2) {
                buildContentView = buildDividerView();
            } else {
                buildContentView = buildContentView(personalInfo.name, personalInfo.content);
            }
            if (i3 < 6) {
                this.mBaseContainer.addView(buildContentView);
            } else {
                this.mExpandContainer.addView(buildContentView);
            }
        }
        if (this.mDatas.size() <= 6) {
            this.mExpandAndStowContainer.setVisibility(8);
        } else {
            this.mExpandAndStowContainer.setVisibility(0);
        }
    }

    private void getProfileDetail(String str) {
        QLog.d(TAG, 2, "getProfileDetail");
        ArrayList arrayList = new ArrayList();
        arrayList.add(Short.valueOf(ProfileContants.FIELD_PERSONAL_NOTE));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_EMAIL));
        ProfileServiceUtils.getIProfileProtocolService(this.mMoreController.mApp).getProfileDetail(str, arrayList, 9, null);
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onPause() {
        this.mIsPause = true;
        super.onPause();
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onResume() {
        this.mIsPause = false;
        super.onResume();
    }

    private String getBirthday(int i3) {
        int[] defaultBirthday;
        if (i3 != 0) {
            defaultBirthday = ProfileDateUtils.parseBirthdayCode(i3);
        } else {
            defaultBirthday = ProfileDateUtils.getDefaultBirthday();
        }
        if (defaultBirthday != null && defaultBirthday.length >= 3 && defaultBirthday[1] != 0 && defaultBirthday[2] != 0) {
            return defaultBirthday[1] + "\u6708" + defaultBirthday[2] + "\u65e5";
        }
        return "";
    }

    private int measureExpandHeight() {
        float measureTextHeight;
        float f16 = 0.0f;
        for (int i3 = 0; i3 < this.mDatas.size(); i3++) {
            if (i3 >= 6) {
                PersonalInfo personalInfo = this.mDatas.get(i3);
                int i16 = personalInfo.type;
                if (i16 == 2) {
                    measureTextHeight = ViewUtils.dip2px(29.0f);
                } else if (i16 == 1) {
                    f16 += ViewUtils.dip2px(24.0f);
                    measureTextHeight = measureTextHeight(personalInfo.content);
                }
                f16 += measureTextHeight;
            }
        }
        float dip2px = f16 + ViewUtils.dip2px(12.0f);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "measureExpandHeight == " + dip2px);
        }
        return (int) dip2px;
    }

    private String getDegreeName(int i3) {
        switch (i3) {
            case 1:
                return HardCodeUtil.qqStr(R.string.x5h);
            case 2:
            case 3:
                return HardCodeUtil.qqStr(R.string.x5d);
            case 4:
                return HardCodeUtil.qqStr(R.string.x6_);
            case 5:
                return HardCodeUtil.qqStr(R.string.x65);
            case 6:
                return HardCodeUtil.qqStr(R.string.x66);
            case 7:
                return HardCodeUtil.qqStr(R.string.x68);
            case 8:
                return HardCodeUtil.qqStr(R.string.x67);
            case 9:
                return HardCodeUtil.qqStr(R.string.x69);
            default:
                return "";
        }
    }
}
