package com.tencent.mobileqq.profilecard.vas.component.accountinfo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import kotlin.Pair;

/* loaded from: classes16.dex */
public class VasProfileAccountInfoComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    private static final String TAG = "VasProfileAccountInfoComponent";
    private float mDensity;
    private TextView mInfoView;
    private float mItemInfoWidth;
    private float mLeftSpace;
    private final IVasLiangNum.b mLiangIdChangedListener;
    private float mRightSpace;
    private float mScreenWidth;
    private Pair<Float, Float> w2h;

    public VasProfileAccountInfoComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.mLiangIdChangedListener = new IVasLiangNum.b() { // from class: com.tencent.mobileqq.profilecard.vas.component.accountinfo.VasProfileAccountInfoComponent.1
            @Override // com.tencent.mobileqq.vas.api.IVasLiangNum.b
            public void onChanged() {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.component.accountinfo.VasProfileAccountInfoComponent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((AbsComponent) VasProfileAccountInfoComponent.this).mData != null && ((ProfileCardInfo) ((AbsComponent) VasProfileAccountInfoComponent.this).mData).card != null && VasProfileAccountInfoComponent.this.mInfoView != null) {
                            Card card = ((ProfileCardInfo) ((AbsComponent) VasProfileAccountInfoComponent.this).mData).card;
                            PrettyAccountUtil.handleAccountCloth(VasProfileAccountInfoComponent.this.mInfoView, PrettyAccountUtil.isPrettyOpenForCard(card), card.lhLevel, card.liangNameplateId, card.uin);
                        }
                    }
                });
            }
        };
    }

    private ViewGroup addAccountBaseInfoItem(ViewGroup viewGroup, int i3, CharSequence charSequence, int i16) {
        ViewGroup viewGroup2 = null;
        if (viewGroup != null && i3 > 0 && !TextUtils.isEmpty(charSequence)) {
            viewGroup2 = (ViewGroup) this.mActivity.getLayoutInflater().inflate(R.layout.f168839b00, (ViewGroup) null);
            View findViewById = viewGroup2.findViewById(R.id.icon);
            TextView textView = (TextView) viewGroup2.findViewById(R.id.info);
            findViewById.setBackgroundResource(i3);
            if (charSequence instanceof String) {
                textView.setText(((String) charSequence).trim());
            } else {
                textView.setText(charSequence);
            }
            viewGroup.addView(viewGroup2);
            if (i16 == 1) {
                LongClickCopyAction.attachCopyAction(textView);
            }
            updateItemTheme(null, null, findViewById, textView, null);
        }
        return viewGroup2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ViewGroup addAccountPrettyItem(ViewGroup viewGroup, int i3, CharSequence charSequence, int i16) {
        int i17;
        String str;
        CharSequence handleAccountTxt;
        if (!isShowAccountPrettyItem(viewGroup, i3, charSequence)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.mActivity.getLayoutInflater().inflate(R.layout.h0s, (ViewGroup) null);
        View findViewById = viewGroup2.findViewById(R.id.icon);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.info);
        this.mInfoView = textView;
        findViewById.setBackgroundResource(i3);
        int i18 = -1;
        if (checkProfile((ProfileCardInfo) this.mData)) {
            i17 = ((ProfileCardInfo) this.mData).card.lhLevel;
        } else {
            i17 = -1;
        }
        if (checkProfile((ProfileCardInfo) this.mData)) {
            str = ((ProfileCardInfo) this.mData).card.uin;
        } else {
            str = "";
        }
        if (checkProfile((ProfileCardInfo) this.mData)) {
            i18 = ((ProfileCardInfo) this.mData).card.liangNameplateId;
        }
        if (charSequence instanceof String) {
            handleAccountTxt = PrettyAccountUtil.handleAccountTxt(PrettyAccountUtil.isPrettyOpenForCard(((ProfileCardInfo) this.mData).card), i17, ((String) charSequence).trim(), str);
        } else {
            handleAccountTxt = PrettyAccountUtil.handleAccountTxt(PrettyAccountUtil.isPrettyOpenForCard(((ProfileCardInfo) this.mData).card), i17, charSequence, str);
        }
        textView.setText(handleAccountTxt);
        PrettyAccountUtil.handleAccountCloth(textView, PrettyAccountUtil.isPrettyOpenForCard(((ProfileCardInfo) this.mData).card), i17, i18, str);
        viewGroup.addView(viewGroup2);
        if (i16 == 1) {
            LongClickCopyAction.attachCopyAction(textView);
        }
        if (PrettyAccountUtil.isPrettyOpenForCard(((ProfileCardInfo) this.mData).card) != 1) {
            updateItemTheme(null, null, findViewById, textView, null);
        }
        QidCoolTextView qidView = getQidView(viewGroup2);
        if (!qidView.isVipStyle((ProfileCardInfo) this.mData)) {
            updateItemTheme(null, null, findViewById, qidView, null);
        }
        if (QidCardManager.needHideSearchQid(this.mApp, (ProfileCardInfo) this.mData)) {
            qidView.setVisibility(8);
        }
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy()) {
            diyMoreInfoManager.updateAccountInfoForDeepDiy((View) this.mViewContainer);
        }
        return viewGroup2;
    }

    private boolean clearViewContainer() {
        if (this.mViewContainer != 0) {
            this.mViewContainer = null;
            return true;
        }
        return false;
    }

    private String combineNickNameAndNumber(TextView textView, TextView textView2, Card card) {
        String str;
        float f16;
        if (textView != null && textView2 != null && !TextUtils.isEmpty(card.uin) && !TextUtils.isEmpty(card.strNick)) {
            TextPaint paint = textView.getPaint();
            if (paint == null) {
                paint = new TextPaint(1);
                paint.density = this.mDensity;
            }
            TextPaint paint2 = textView2.getPaint();
            if (paint2 == null) {
                paint2 = new TextPaint(1);
                paint2.density = this.mDensity;
            }
            CharSequence charSequence = MiniBoxNoticeInfo.APPNAME_SUFFIX;
            float measureText = paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX) + (this.mDensity * 5.0f);
            float measureText2 = paint.measureText(String.format("(%s)", card.uin));
            if (TextUtils.isEmpty(card.qid)) {
                str = "";
            } else {
                str = card.qid;
            }
            float measureText3 = ((this.mItemInfoWidth - measureText2) - measureText) - paint2.measureText(str);
            if (isDIYTemplateProfile()) {
                f16 = this.mDensity * 40.0f;
            } else {
                f16 = 0.0f;
            }
            CharSequence ellipsize = TextUtils.ellipsize(card.strNick, paint, measureText3 - f16, TextUtils.TruncateAt.END);
            if (!TextUtils.isEmpty(ellipsize)) {
                charSequence = ellipsize;
            }
            return String.format("%s(%s)", charSequence, card.uin);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, VIEW] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private View getAccountBaseInfoView() {
        View view = (View) this.mViewContainer;
        ?? r06 = view;
        if (view == null) {
            r06 = this.mActivity.getLayoutInflater().inflate(R.layout.azz, (ViewGroup) null);
        }
        if (r06 != 0) {
            this.mViewContainer = r06;
        }
        return r06;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private QidCoolTextView getQidView(ViewGroup viewGroup) {
        QidCoolTextView qidCoolTextView = (QidCoolTextView) viewGroup.findViewById(R.id.f58072p1);
        qidCoolTextView.updateQidView(this.mQQAppInterface, (ProfileCardInfo) this.mData);
        qidCoolTextView.setTag(new com.tencent.mobileqq.profile.b(105, null));
        qidCoolTextView.setOnClickListener(this);
        return qidCoolTextView;
    }

    private void init(Context context) {
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mScreenWidth = Math.min(r0.widthPixels, r0.heightPixels);
        this.mLeftSpace = r4.getDimensionPixelSize(R.dimen.f159041uo) + r4.getDimensionPixelSize(R.dimen.a07) + r4.getDimensionPixelSize(R.dimen.a08);
        float dimensionPixelSize = (this.mDensity * 7.0f) + r4.getDimensionPixelSize(R.dimen.f159312a04) + r4.getDimensionPixelSize(R.dimen.f159313a05);
        this.mRightSpace = dimensionPixelSize;
        this.mItemInfoWidth = (this.mScreenWidth - this.mLeftSpace) - dimensionPixelSize;
    }

    private boolean isDIYTemplateProfile() {
        if (this.mData != 0) {
            return ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isDefaultProfile() {
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).curUseStyleId != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
            return false;
        }
        return true;
    }

    private boolean isLinag(int i3) {
        if (QQVasUpdateBusiness.getBusiness(350L).isFileExists(i3)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isQVipV5TemplateProfile() {
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).curUseStyleId != ProfileCardTemplate.PROFILE_CARD_STYLE_NEW_V800) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isShowAccountInfo(Card card) {
        boolean z16;
        if (card != null && ProfilePAUtils.isPaTypeShowAccount(((ProfileCardInfo) this.mData).allInOne)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isDefaultProfile() || isQVipV5TemplateProfile()) {
            return false;
        }
        return z16;
    }

    private boolean isShowAccountPrettyItem(ViewGroup viewGroup, int i3, CharSequence charSequence) {
        if (viewGroup != null && i3 > 0 && !TextUtils.isEmpty(charSequence)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isValidForAccountBaseInfoThirdLine(TroopManager troopManager) {
        if (!troopManager.V(((ProfileCardInfo) this.mData).troopUin) && !isDIYTemplateProfile()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean makeOrRefreshAccountBaseInfoView(Card card, boolean z16) {
        String str;
        boolean isShowAccountInfo = isShowAccountInfo(card);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshAccountBaseInfoView bShowAccountInfo=%s", Boolean.valueOf(isShowAccountInfo)));
        }
        if (!isShowAccountInfo) {
            return clearViewContainer();
        }
        View accountBaseInfoView = getAccountBaseInfoView();
        if (accountBaseInfoView == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) accountBaseInfoView;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.f163853ag);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.f163856ai);
        viewGroup2.removeAllViews();
        if (!ProfilePAUtils.isFromWholePeopleVote(((ProfileCardInfo) this.mData).allInOne) && !ProfilePAUtils.isFromExtendFriend(((ProfileCardInfo) this.mData).allInOne)) {
            str = " ";
        } else {
            str = null;
        }
        refreshAccountBaseInfoFirstLine(card, viewGroup2, str);
        refreshAccountBaseInfoSecondLine(viewGroup2);
        refreshAccountBaseInfoThirdLine(card, viewGroup2);
        refreshAccountBaseInfoLastLine(card, viewGroup3);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshAccountBaseInfoFirstLine(Card card, ViewGroup viewGroup, String str) {
        String combineNickNameAndNumber;
        String str2;
        boolean z16 = false;
        ViewGroup addAccountPrettyItem = addAccountPrettyItem(viewGroup, R.drawable.qq_profilecard_item_account, str, 0);
        if (addAccountPrettyItem == null) {
            return;
        }
        TextView textView = (TextView) addAccountPrettyItem.findViewById(R.id.info);
        this.mInfoView = textView;
        QidCoolTextView qidCoolTextView = (QidCoolTextView) addAccountPrettyItem.findViewById(R.id.f58072p1);
        if (textView == null) {
            return;
        }
        DATA data = this.mData;
        if (((ProfileCardInfo) data).isTroopMemberCard) {
            updateNickForTroopMemberCard(card, textView, qidCoolTextView);
            return;
        }
        if (((ProfileCardInfo) data).nameArray != null && !TextUtils.isEmpty(((ProfileCardInfo) data).nameArray[5]) && !TextUtils.equals(((ProfileCardInfo) this.mData).nameArray[5], card.strNick)) {
            z16 = true;
        }
        if (TextUtils.isEmpty(card.strReMark) && !z16) {
            combineNickNameAndNumber = card.uin;
            str2 = null;
        } else {
            combineNickNameAndNumber = combineNickNameAndNumber(textView, qidCoolTextView, card);
            str2 = card.strNick;
            if (TextUtils.isEmpty(combineNickNameAndNumber)) {
                combineNickNameAndNumber = card.uin;
            }
        }
        int isPrettyOpenForCard = PrettyAccountUtil.isPrettyOpenForCard(((ProfileCardInfo) this.mData).card);
        DATA data2 = this.mData;
        textView.setText(PrettyAccountUtil.handleAccountTxt(isPrettyOpenForCard, ((ProfileCardInfo) data2).card.lhLevel, combineNickNameAndNumber, ((ProfileCardInfo) data2).card.uin));
        String str3 = card.uin;
        PrettyAccountUtil.handleAccountCloth(textView, PrettyAccountUtil.isPrettyOpenForCard(((ProfileCardInfo) this.mData).card), ((ProfileCardInfo) this.mData).card.lhLevel, card.liangNameplateId, str3);
        ProfileCardUtil.e(textView, card.uin, str2);
    }

    private void refreshAccountBaseInfoLastLine(Card card, ViewGroup viewGroup) {
        viewGroup.setTag(new com.tencent.mobileqq.profile.b(66, card.uin));
        viewGroup.setOnClickListener(this);
        updateItemTheme(null, (TextView) viewGroup.findViewById(R.id.f163857aj), null, (ImageView) viewGroup.findViewById(R.id.f164472yw), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshAccountBaseInfoSecondLine(ViewGroup viewGroup) {
        if (isDIYTemplateProfile()) {
            addAccountBaseInfoItem(viewGroup, R.drawable.qq_profilecard_item_information, ProfileCardUtil.b0(this.mActivity, (ProfileCardInfo) this.mData), 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshAccountBaseInfoThirdLine(Card card, ViewGroup viewGroup) {
        if (!isValidForAccountBaseInfoThirdLine((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER))) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        while (childCount < 4 && i3 < 3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        String hometownWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getHometownWithPrivacy((ProfileCardInfo) this.mData);
                        if (!TextUtils.isEmpty(hometownWithPrivacy)) {
                            addAccountBaseInfoItem(viewGroup, R.drawable.qq_profilecard_item_hometown, hometownWithPrivacy, 1);
                        }
                    }
                } else {
                    String companyWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getCompanyWithPrivacy((ProfileCardInfo) this.mData);
                    if (!TextUtils.isEmpty(companyWithPrivacy)) {
                        refreshCompanyInfo(viewGroup, companyWithPrivacy);
                    }
                }
            } else {
                refreshSchoolInfo(card, viewGroup);
            }
            i3++;
            childCount = viewGroup.getChildCount();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshCompanyInfo(ViewGroup viewGroup, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String professionTagWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfessionTagWithPrivacy((ProfileCardInfo) this.mData);
        if (!TextUtils.isEmpty(professionTagWithPrivacy) && !TextUtils.equals(professionTagWithPrivacy, NearbyProfileUtil.f306396e[14])) {
            if (sb5.length() > 0) {
                sb5.append(" ");
            }
            sb5.append(professionTagWithPrivacy);
        }
        addAccountBaseInfoItem(viewGroup, R.drawable.qq_profilecard_item_profession, sb5.toString(), 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshSchoolInfo(Card card, ViewGroup viewGroup) {
        String schoolWithPrivacy = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getSchoolWithPrivacy((ProfileCardInfo) this.mData);
        if (!TextUtils.isEmpty(schoolWithPrivacy)) {
            CharSequence charSequence = schoolWithPrivacy;
            if (card.schoolVerifiedFlag) {
                charSequence = ProfileCardUtil.Y(schoolWithPrivacy, true, R.drawable.ne8, R.dimen.d6f, R.dimen.d6e, this.mActivity, this.mQQAppInterface);
            }
            addAccountBaseInfoItem(viewGroup, R.drawable.qq_profilecard_item_school, charSequence, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateNickForTroopMemberCard(Card card, TextView textView, QidCoolTextView qidCoolTextView) {
        String str;
        String combineNickNameAndNumber;
        TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(((ProfileCardInfo) this.mData).troopUin, card.uin, this.mActivity, TAG);
        if (troopMemberInfoSync != null && TextUtils.isEmpty(troopMemberInfoSync.troopnick) && !TextUtils.isEmpty(card.strReMark)) {
            str = card.strNick;
        } else if (TextUtils.isEmpty(card.strReMark)) {
            str = card.strNick;
        } else {
            str = card.strReMark;
        }
        if (TextUtils.isEmpty(str)) {
            str = ac.g(this.mQQAppInterface, card.uin, false);
        }
        if (((TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).V(((ProfileCardInfo) this.mData).troopUin)) {
            combineNickNameAndNumber = str;
        } else {
            combineNickNameAndNumber = combineNickNameAndNumber(textView, qidCoolTextView, card);
        }
        int isPrettyOpenForCard = PrettyAccountUtil.isPrettyOpenForCard(((ProfileCardInfo) this.mData).card);
        DATA data = this.mData;
        textView.setText(PrettyAccountUtil.handleAccountTxt(isPrettyOpenForCard, ((ProfileCardInfo) data).card.lhLevel, combineNickNameAndNumber, ((ProfileCardInfo) data).card.uin));
        String str2 = card.uin;
        PrettyAccountUtil.handleAccountCloth(textView, PrettyAccountUtil.isPrettyOpenForCard(((ProfileCardInfo) this.mData).card), ((ProfileCardInfo) this.mData).card.lhLevel, card.liangNameplateId, str2);
        ProfileCardUtil.e(textView, card.uin, str);
    }

    public boolean checkProfile(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1032;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_ACCOUNT_INFO_VAS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.profile.b) {
            int i3 = ((com.tencent.mobileqq.profile.b) tag).f260135a;
            if (i3 != 66) {
                if (i3 == 105) {
                    VipQidHelper.jumpQidSetInfoPage(this.mActivity, (ProfileCardInfo) this.mData);
                }
            } else {
                ProfileCardUtil.p0((ProfileCardInfo) this.mData, this.mQQAppInterface, this.mActivity);
                DATA data = this.mData;
                int i16 = 2;
                if (((ProfileCardInfo) data).allInOne != null && ((ProfileCardInfo) data).allInOne.f260789pa == 0) {
                    i16 = 1;
                }
                ReportController.o(this.mApp, "dc00898", "", "", "0X8009999", "0X8009999", i16, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        init(this.mActivity);
        ((IVasLiangNum) QRoute.api(IVasLiangNum.class)).registerLiangIdChangedListener(this.mLiangIdChangedListener);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        ((IVasLiangNum) QRoute.api(IVasLiangNum.class)).unregisterLiangIdChangedListener(this.mLiangIdChangedListener);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        return makeOrRefreshAccountBaseInfoView(profileCardInfo.card, profileCardInfo.isNetRet) | super.lambda$checkValidComponent$3((VasProfileAccountInfoComponent) profileCardInfo);
    }
}
