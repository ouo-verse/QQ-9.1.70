package com.tencent.mobileqq.profilecard.view.head;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.utils.VasSvipPrivilegeAnimateHelper;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreFragment;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.profilecard.utils.ProfileCardForbidAccountHelper;
import com.tencent.mobileqq.profilecard.utils.ProfileNickUpgradeSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.QUIEllipsizeTextView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public abstract class AbsElegantProfileHeadView extends AbsQCircleProfileHeaderView {
    private static final String TROOP_MEMBER_NICK_CACHE_KEY_FORMAT = "%s_%s";
    private static final LruCache<String, String> sTroopMemberCardNickCache = new LruCache<>(20);
    private QUIEllipsizeTextView mElegantNickView;
    private WeakReference<QBaseActivity> mRefActivity;
    protected TextView mRemarkPreView;
    protected TextView mRemarkView;
    protected TextView mTroopRemarkView;

    public AbsElegantProfileHeadView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate) {
        super(qBaseActivity, profileCardInfo);
        this.mDelegate = iProfileActivityDelegate;
        this.mRefActivity = new WeakReference<>(qBaseActivity);
    }

    private void asyncUpdateTroopNick(final ProfileCardInfo profileCardInfo) {
        if (this.mApp != null && profileCardInfo != null && profileCardInfo.card != null) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(profileCardInfo.troopUin, profileCardInfo.card.uin, false, this.mRefActivity.get(), AbsQCircleProfileHeaderView.TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.profilecard.view.head.d
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    AbsElegantProfileHeadView.this.lambda$asyncUpdateTroopNick$2(profileCardInfo, troopMemberInfo);
                }
            });
        } else {
            QLog.e(AbsQCircleProfileHeaderView.TAG, 1, "asyncUpdateTroopNick fail, card is null or app is null");
        }
    }

    private void checkViewOverlap() {
        post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.a
            @Override // java.lang.Runnable
            public final void run() {
                AbsElegantProfileHeadView.this.lambda$checkViewOverlap$3();
            }
        });
    }

    private void initNickView(ProfileCardInfo profileCardInfo) {
        ProfileNameView profileNameView = (ProfileNameView) this.mHeaderChildMap.get("map_key_profile_nick_name");
        if (profileNameView != null) {
            profileNameView.setVisibility(8);
        }
        Card card = profileCardInfo.card;
        String buddyRemark = getBuddyRemark(profileCardInfo);
        if (!TextUtils.isEmpty(buddyRemark)) {
            this.mElegantNickView.setText(buddyRemark);
            ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(this.mElegantNickView, card);
        } else {
            setElegantNickViewText(profileCardInfo, card);
        }
        this.mElegantNickView.setTag(new com.tencent.mobileqq.profile.b(88, this.mElegantNickView.getText().toString()));
        this.mElegantNickView.setOnClickListener(this.mOnClickListener);
        this.mElegantNickView.setTextSize(1, 17.0f);
        this.mElegantNickView.setTypeface(Typeface.DEFAULT_BOLD);
        this.mElegantNickView.setVisibility(0);
        LongClickCopyAction.attachCopyAction(this.mElegantNickView, getResources().getString(R.string.f203254zp), this.mElegantNickView.getText().toString());
        ProfileCardDtReportUtil.initElementWithExposureClick(this.mElegantNickView, ProfileCardDtReportUtil.DT_REPORT_NAME);
    }

    private boolean isFriend(String str) {
        Friends friend = ((IFriendDataService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "all")).getFriend(str);
        if (friend == null) {
            QLog.i(AbsQCircleProfileHeaderView.TAG, 1, "friends = null");
            return false;
        }
        return friend.isFriend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncUpdateTroopNick$1(TroopMemberInfo troopMemberInfo, String str) {
        String str2;
        if (this.mElegantNickView != null && troopMemberInfo != null) {
            if (TextUtils.isEmpty(troopMemberInfo.troopnick)) {
                str2 = "";
            } else {
                str2 = troopMemberInfo.troopnick;
            }
            LruCache<String, String> lruCache = sTroopMemberCardNickCache;
            String str3 = lruCache.get(str);
            if (str2.equals(str3)) {
                return;
            }
            if (!TextUtils.isEmpty(str3)) {
                lruCache.remove(str);
            }
            lruCache.put(str, str2);
            if (TextUtils.isEmpty(str2)) {
                initNickView(this.mCardInfo);
                return;
            } else {
                this.mElegantNickView.setText(str2);
                return;
            }
        }
        QLog.e(AbsQCircleProfileHeaderView.TAG, 1, "null pointer found, return directly");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncUpdateTroopNick$2(ProfileCardInfo profileCardInfo, final TroopMemberInfo troopMemberInfo) {
        final String format = String.format(Locale.getDefault(), TROOP_MEMBER_NICK_CACHE_KEY_FORMAT, profileCardInfo.troopUin, profileCardInfo.card.uin);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.c
            @Override // java.lang.Runnable
            public final void run() {
                AbsElegantProfileHeadView.this.lambda$asyncUpdateTroopNick$1(troopMemberInfo, format);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUinInfo$0(ProfileCardInfo profileCardInfo, View view) {
        if (ProfileCardForbidAccountHelper.isForbidByAnyType(profileCardInfo)) {
            QLog.i(AbsQCircleProfileHeaderView.TAG, 1, "uinView click but isForbidAccount");
            return;
        }
        if (ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne)) {
            onPhoneClick(profileCardInfo.allInOne);
        } else {
            openProfileCardMore(profileCardInfo);
        }
        ProfileCardDtReportUtil.dtReportClick(view);
    }

    private void openProfileCardMore(ProfileCardInfo profileCardInfo) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("openProfileCardMoreWeb", true)) {
            QLog.i(AbsQCircleProfileHeaderView.TAG, 1, "openProfileCardMore in native");
            Intent intent = new Intent();
            intent.putExtra(ProfileCardMoreConstants.KEY_ALL_IN_ONE, profileCardInfo.allInOne);
            ProfileCardMoreFragment.openProfileCardMore(this.mActivity, intent, 1038);
            return;
        }
        QLog.i(AbsQCircleProfileHeaderView.TAG, 1, "openProfileCardMore in web");
        Intent intent2 = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
        intent2.putExtra("uin", this.mApp.getCurrentAccountUin());
        intent2.putExtra("url", ProfileCardUtil.t(this.mApp, this.mActivity, profileCardInfo));
        intent2.putExtra("hide_more_button", true);
        this.mActivity.startActivity(intent2);
    }

    private void removeRemarkView() {
        TextView textView = (TextView) this.mHeaderChildMap.get("map_key_profile_remark_name");
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void setCoverMask() {
        RandomCoverView randomCoverView = this.mCoverView;
        if (randomCoverView == null || randomCoverView.b() == null) {
            return;
        }
        this.mCoverView.b().setVisibility(8);
    }

    private void setElegantNickViewText(ProfileCardInfo profileCardInfo, Card card) {
        if (card != null) {
            asyncUpdateTroopNick(profileCardInfo);
            String troopMemberLRUCacheNick = getTroopMemberLRUCacheNick(profileCardInfo);
            if (!ProfileNickUpgradeSwitch.getInstance().isEnable() && !TextUtils.isEmpty(troopMemberLRUCacheNick)) {
                this.mElegantNickView.setText(troopMemberLRUCacheNick);
            } else if (!TextUtils.isEmpty(card.strReMark)) {
                this.mElegantNickView.setText(card.strReMark);
            } else if (com.tencent.mobileqq.profilecard.utils.ProfileCardUtil.isContactNicknameValid(card.strNick)) {
                this.mElegantNickView.setText(card.strNick);
            }
            ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(this.mElegantNickView, card);
            return;
        }
        ContactCard contactCard = profileCardInfo.contactCard;
        if (contactCard != null) {
            this.mElegantNickView.setText(contactCard.nickName);
            ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(this.mElegantNickView, profileCardInfo.contactCard.uin, false);
        } else {
            this.mElegantNickView.setText("");
        }
    }

    private void updateCoverMode(ProfileCardInfo profileCardInfo) {
        String string;
        this.mCoverView.setVisibility(0);
        FrameLayout frameLayout = this.mZplanCoverView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.mQCircleCoverView;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentBgView.getLayoutParams();
        layoutParams.addRule(3, R.id.dkn);
        layoutParams.addRule(10, 0);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.f10602i);
        this.mContentBgView.setLayoutParams(layoutParams);
        com.tencent.mobileqq.profile.b bVar = new com.tencent.mobileqq.profile.b(17, null);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            string = getContext().getString(R.string.abn);
        } else {
            string = getContext().getString(R.string.abm);
        }
        this.mCoverView.setTag(bVar);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null && iProfileActivityDelegate.isShowVasCustomBgCover()) {
            this.mCoverView.setOnClickListener(null);
        } else {
            this.mCoverView.setOnClickListener(this.mOnClickListener);
        }
        this.mCoverView.setClickable(true);
        this.mCoverView.setContentDescription(string);
        HashMap hashMap = new HashMap();
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE, "1");
        ProfileCardDtReportUtil.initElementWithExposureClickAndParams(this.mCoverView, ProfileCardDtReportUtil.DT_REPORT_COVER, hashMap);
    }

    private void updateNoCoverMode() {
        this.mCoverView.setVisibility(0);
        FrameLayout frameLayout = this.mZplanCoverView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.mQCircleCoverView;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentBgView.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.addRule(10, 1);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.title_bar_height) + ImmersiveUtils.getStatusBarHeight(getContext()) + getResources().getDimensionPixelSize(R.dimen.f10612j);
        this.mContentBgView.setLayoutParams(layoutParams);
        this.mCoverView.setTag(null);
        this.mCoverView.setOnClickListener(null);
        this.mCoverView.setClickable(false);
        this.mCoverView.setContentDescription(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissRemarkView() {
        TextView textView = this.mRemarkView;
        if (textView == null) {
            return;
        }
        textView.setText("");
        this.mRemarkView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissTroopRemarkView() {
        TextView textView = this.mTroopRemarkView;
        if (textView == null) {
            return;
        }
        textView.setText("");
        this.mTroopRemarkView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getBuddyRemark(ProfileCardInfo profileCardInfo) {
        String str;
        String str2;
        String str3;
        AllInOne allInOne = profileCardInfo.allInOne;
        if (allInOne == null) {
            str = "";
            str2 = str;
        } else {
            str2 = allInOne.uid;
            str = allInOne.uin;
        }
        if (!TextUtils.isEmpty(str2)) {
            com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
            if (b16 == null) {
                return "";
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str2);
            Map<String, String> buddyRemark = b16.getBuddyRemark(arrayList);
            if (buddyRemark != null) {
                str3 = buddyRemark.get(str2);
                String str4 = isFriend(str) ? "" : str3;
                QLog.i(AbsQCircleProfileHeaderView.TAG, 2, "getBuddyRemark: " + str4);
                return str4;
            }
        }
        str3 = "";
        if (isFriend(str)) {
        }
        QLog.i(AbsQCircleProfileHeaderView.TAG, 2, "getBuddyRemark: " + str4);
        return str4;
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected View initContentView() {
        View viewById;
        LayoutInflater from = LayoutInflater.from(getContext());
        IProfileViewLoader iProfileViewLoader = this.mViewLoader;
        if (iProfileViewLoader != null && (viewById = iProfileViewLoader.getViewById(R.layout.hhc)) != null) {
            if (viewById.getParent() != null && (viewById.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewById.getParent()).removeView(viewById);
                QLog.i(AbsQCircleProfileHeaderView.TAG, 1, "initContentView,remove_view_first!");
            }
            addView(viewById);
            return viewById;
        }
        return from.inflate(R.layout.hhc, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView, com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public int initCoverMode(ProfileCardInfo profileCardInfo) {
        int initCoverMode = super.initCoverMode(profileCardInfo);
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate == null || !iProfileActivityDelegate.isShowVasCustomBgCover()) {
            return initCoverMode;
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected void initCustomView() {
        QidCoolTextView qidCoolTextView = (QidCoolTextView) this.mContentView.findViewById(R.id.f61892zc);
        this.mQidInfoView = qidCoolTextView;
        this.mHeaderChildMap.put("map_key_qid_info", qidCoolTextView);
        this.mQidInfoView.setOnClickListener(this.mOnClickListener);
        ImageView imageView = (ImageView) this.mContentView.findViewById(R.id.f1198577z);
        this.mVipMedalView = imageView;
        if (imageView != null) {
            this.mHeaderChildMap.put("map_key_vip_medal", imageView);
            this.mVipMedalView.setOnClickListener(this.mOnClickListener);
        }
        if (OnlineStatusToggleUtils.t()) {
            LinearLayout linearLayout = (LinearLayout) this.mContentView.findViewById(R.id.zy8);
            this.mOnlineStatusLayout = linearLayout;
            if (linearLayout != null) {
                this.mHeaderChildMap.put("map_key_online_status", linearLayout);
                this.mOnlineStatusLayout.setOnClickListener(this.mOnClickListener);
            }
        }
        removeRemarkView();
        TextView textView = (TextView) this.mContentView.findViewById(R.id.gmx);
        this.mRemarkPreView = textView;
        textView.setTextSize(1, 12.0f);
        TextView textView2 = (TextView) this.mContentView.findViewById(R.id.f72733rn);
        this.mRemarkView = textView2;
        textView2.setTextSize(1, 12.0f);
        this.mTroopRemarkView = (TextView) this.mContentView.findViewById(R.id.f1035660y);
        this.mElegantNickView = (QUIEllipsizeTextView) this.mContentView.findViewById(R.id.f166409zr2);
        this.mContentBgView.setBackgroundResource(R.drawable.k6x);
        setCoverMask();
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected int initHeadViewResource() {
        return R.layout.hhd;
    }

    public abstract void initRemarkView(ProfileCardInfo profileCardInfo);

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView, com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void onCoverModeChange(int i3, ProfileCardInfo profileCardInfo) {
        super.onCoverModeChange(i3, profileCardInfo);
        if (QLog.isColorLevel()) {
            QLog.i(AbsProfileHeaderView.TAG, 2, String.format("onCoverModeChange mode: %s", Integer.valueOf(i3)));
        }
        if (i3 == 1) {
            updateNoCoverMode();
            return;
        }
        if (i3 == 2) {
            updateZplanCoverMode();
        } else if (i3 != 3) {
            updateCoverMode(profileCardInfo);
        } else {
            updateQCircleCoverMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        super.onInit(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView, com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate == null) {
            return;
        }
        boolean isShowZplanCover = iProfileActivityDelegate.getIsShowZplanCover();
        if (this.mIsShowZplanCover != isShowZplanCover) {
            this.mIsShowZplanCover = isShowZplanCover;
            if (isShowZplanCover) {
                resetZPlanState();
            } else if (this.mIsShowQCircleCover) {
                resetQCircleState();
            }
            IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
            if (iProfileActivityDelegate2 != null) {
                PullToZoomHeaderListView listView = iProfileActivityDelegate2.getListView();
                this.mListView = listView;
                if (listView != null) {
                    listView.setSelection(0);
                }
            }
        }
        super.onUpdate(profileCardInfo, z16);
        initRemarkView(profileCardInfo);
        removeRemarkView();
        checkViewOverlap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTroopRemarkName(String str) {
        if (this.mTroopRemarkView == null) {
            return;
        }
        this.mTroopRemarkView.setText(((INickNameApi) QRoute.api(INickNameApi.class)).getEmotionNickName(String.format("\u7fa4\u6635\u79f0\uff1a%s", str), 16));
        this.mTroopRemarkView.setVisibility(0);
        LongClickCopyAction.attachCopyAction(this.mTroopRemarkView, getResources().getString(R.string.f203254zp), str);
        this.mTroopRemarkView.setTag(new com.tencent.mobileqq.profile.b(112, this.mTroopRemarkView.getText().toString()));
        this.mTroopRemarkView.setOnClickListener(this.mOnClickListener);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateHead(ProfileCardInfo profileCardInfo) {
        super.updateHead(profileCardInfo);
        initNickView(profileCardInfo);
        initRemarkView(profileCardInfo);
        updateQidViewMargin(profileCardInfo);
        checkAccountForbid(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateLike(ProfileCardInfo profileCardInfo) {
        VoteViewV2 voteViewV2 = (VoteViewV2) this.mHeaderChildMap.get("map_key_like");
        if (voteViewV2 != null) {
            voteViewV2.setVoteImageId(R.drawable.qui_like, R.drawable.qui_like_filled);
            voteViewV2.setVoteColor(R.color.qui_common_brand_standard);
        }
        super.updateLike(profileCardInfo);
        VasSvipPrivilegeAnimateHelper.addSvipPrivilegeAnimateView(voteViewV2);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateUinInfo(final ProfileCardInfo profileCardInfo, String str) {
        String string;
        super.updateUinInfo(profileCardInfo, str);
        TextView textView = (TextView) this.mHeaderChildMap.get("map_key_uin_info");
        if (textView == null || profileCardInfo == null || profileCardInfo.allInOne == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbsElegantProfileHeadView.this.lambda$updateUinInfo$0(profileCardInfo, view);
            }
        });
        if (ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne)) {
            string = getResources().getString(R.string.f203274zr);
        } else {
            string = getResources().getString(R.string.f203284zs);
        }
        LongClickCopyAction.attachCopyAction(textView, string, profileCardInfo.allInOne.uin);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMarkName(String str) {
        this.mRemarkView.setText(String.format("\u6635\u79f0\uff1a%s", str));
        this.mRemarkView.setVisibility(0);
        LongClickCopyAction.attachCopyAction(this.mRemarkView, getResources().getString(R.string.f203254zp), str);
    }

    private void checkAccountForbid(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo == null || (card = profileCardInfo.card) == null) {
            return;
        }
        boolean z16 = card.isForbidAccount;
        QUIEllipsizeTextView qUIEllipsizeTextView = this.mElegantNickView;
        if (qUIEllipsizeTextView != null) {
            this.mElegantNickView.setVisibility((z16 || (qUIEllipsizeTextView.getVisibility() == 8)) ? 8 : 0);
        }
        TextView textView = this.mRemarkView;
        if (textView != null) {
            this.mRemarkView.setVisibility((z16 || (textView.getVisibility() == 8)) ? 8 : 0);
        }
        TextView textView2 = this.mTroopRemarkView;
        if (textView2 != null) {
            this.mTroopRemarkView.setVisibility((z16 || (textView2.getVisibility() == 8)) ? 8 : 0);
        }
    }

    private String getTroopMemberLRUCacheNick(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo != null && profileCardInfo.card != null) {
            return sTroopMemberCardNickCache.get(String.format(Locale.getDefault(), TROOP_MEMBER_NICK_CACHE_KEY_FORMAT, profileCardInfo.troopUin, profileCardInfo.card.uin));
        }
        QLog.e(AbsQCircleProfileHeaderView.TAG, 1, "getTroopMemberLRUCacheNick fail, card is null");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkViewOverlap$3() {
        View findViewById = findViewById(R.id.l0b);
        View findViewById2 = findViewById(R.id.f61892zc);
        if (findViewById == null || findViewById2 == null) {
            return;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        findViewById.getLocationOnScreen(iArr);
        findViewById2.getLocationOnScreen(iArr2);
        int i3 = iArr[0];
        Rect rect = new Rect(i3, iArr[1], findViewById.getMeasuredWidth() + i3, iArr[1] + findViewById.getMeasuredHeight());
        int i16 = iArr2[0];
        boolean intersect = rect.intersect(new Rect(i16, iArr2[1], findViewById2.getMeasuredWidth() + i16, iArr2[1] + findViewById2.getMeasuredHeight()));
        QLog.i(AbsQCircleProfileHeaderView.TAG, 1, "checkViewOverlap:" + intersect);
        if (intersect && (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.removeRule(15);
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.c_5);
            findViewById.setLayoutParams(layoutParams);
        }
    }

    public void onPhoneClick(AllInOne allInOne) {
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void updateLayoutMargin(int i3) {
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateNickInfo(String str) {
    }
}
