package com.tencent.mobileqq.profilecard.vas.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.j;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.config.business.qvip.QVipDiyTemplateProcessor;
import com.tencent.mobileqq.vas.pendant.drawable.AvatarPendantFileUtil;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.mobileqq.vip.diy.TemplateLikeView;
import com.tencent.mobileqq.vip.diy.e;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import d15.a;
import e15.f;
import hd0.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class VasProfileQVipDiyView extends AbsProfileHeaderView {
    public static final int SPACE_TIP_HEIGHT = 18;
    public static final String TAG = "DIYProfileTemplate.ProfileQVipDiyView";
    private View mAvatarContainer;
    private View.OnClickListener mClickHandler;
    private FrameLayout mHeaderContainer;
    private f mHeaderViewModel;
    private int mNickNameColor;
    private View mNickNameView;
    private ViewGroup mRoot;
    ViewGroup mTipLayout;
    private int mTitleStyle;
    private HeartLayout mVoteHeartLayout;
    private View mVoteView;

    public VasProfileQVipDiyView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
        this.mNickNameColor = -16777216;
        this.mClickHandler = new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                VasProfileQVipDiyView.this.handleClick(view);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mNewVoteAnimHelper = new j(qBaseActivity, this.mApp, 3, 1);
    }

    private void attachDiyProfileTemplateTipForGuest(Activity activity, ViewGroup viewGroup) {
        if (!QVipDiyTemplateProcessor.getConfig().enable || !ProfileCardUtil.P(this.mApp, this.mCardInfo.card.uin)) {
            return;
        }
        ProfileCardUtil.e0(this.mApp, this.mCardInfo.card.uin);
        this.mTipLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.beh, viewGroup, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BaseAIOUtils.f(350.0f, activity.getResources()), BaseAIOUtils.f(44.0f, activity.getResources()));
        layoutParams.addRule(14);
        layoutParams.addRule(2, R.id.f27940hl);
        layoutParams.bottomMargin = BaseAIOUtils.f(4.0f, activity.getResources());
        viewGroup.addView(this.mTipLayout, layoutParams);
        TextView textView = (TextView) this.mTipLayout.findViewById(R.id.h76);
        ImageView imageView = (ImageView) this.mTipLayout.findViewById(R.id.h75);
        textView.setOnClickListener(this.mClickHandler);
        imageView.setOnClickListener(this.mClickHandler);
        ReportController.o(this.mApp, "dc00898", "", "", "qvip", "0X8009E7A", 0, 0, "", "", "", "");
    }

    private void detachDIYProfileTip(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.mTipLayout;
        if (viewGroup2 != null) {
            viewGroup.removeView(viewGroup2);
            this.mTipLayout = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.h76) {
            detachDIYProfileTip(this.mRoot);
            dr.d(this.mCardInfo.card, this.mApp, this.mActivity);
            ReportController.o(this.mApp, "dc00898", "", "", "qvip", "0X8009E7B", 0, 0, "", "", "", "");
        } else if (id5 == R.id.h75) {
            detachDIYProfileTip(this.mRoot);
            ProfileCardUtil.d0(this.mApp);
            ReportController.o(this.mApp, "dc00898", "", "", "qvip", "0X8009E7C", 0, 0, "", "", "", "");
        }
    }

    private void initHeadUI() {
        String string;
        c.g(TAG, "init head UI");
        View view = this.mHeaderChildMap.get("map_key_profile_diy_nick_container");
        this.mAvatarContainer = view;
        if (view instanceof FrameLayout) {
            AvatarLayout avatarLayout = (AvatarLayout) view.findViewById(R.id.f165801dk3);
            avatarLayout.setVisibility(0);
            b bVar = new b(1, null);
            if (this.mCardInfo.allInOne.f260789pa == 0) {
                string = this.mActivity.getString(R.string.abp);
            } else {
                string = this.mActivity.getString(R.string.abo);
            }
            avatarLayout.setTag(bVar);
            avatarLayout.setOnClickListener(this.mOnClickListener);
            avatarLayout.setContentDescription(string);
            avatarLayout.d(0, avatarLayout.findViewById(R.id.a6e), false);
            this.mHeaderChildMap.put("map_key_face", avatarLayout);
            this.mHeaderChildMap.put("map_key_face_stoke", this.mAvatarContainer.findViewById(R.id.dk7));
            ImageView imageView = (ImageView) this.mAvatarContainer.findViewById(R.id.dfv);
            this.mHeaderChildMap.put("map_key_avatar_pendant", imageView);
            imageView.setVisibility(8);
            imageView.setTag(bVar);
            imageView.setOnClickListener(this.mOnClickListener);
            imageView.setContentDescription(string);
            AccessibilityUtil.n(imageView, false);
        }
        View view2 = this.mHeaderChildMap.get("map_key_profile_nick_name");
        this.mNickNameView = view2;
        if (view2 instanceof ProfileNameView) {
            ProfileNameView profileNameView = (ProfileNameView) view2;
            profileNameView.setVisibility(0);
            profileNameView.setClickable(true);
        } else if (view2 instanceof ETTextViewPlus) {
            ETTextViewPlus eTTextViewPlus = (ETTextViewPlus) view2;
            eTTextViewPlus.setTextSize(20.0f);
            eTTextViewPlus.setTextColor(this.mNickNameColor);
            eTTextViewPlus.setVisibility(0);
            eTTextViewPlus.setClickable(true);
        }
        View view3 = this.mHeaderChildMap.get("map_key_like");
        this.mVoteView = view3;
        if (view3 instanceof TemplateLikeView) {
            this.mVoteHeartLayout.setVisibility(0);
            this.mHeaderChildMap.put("map_key_like", this.mVoteView);
            ((TemplateLikeView) view3).setHeartLayout(this.mApp, this.mVoteHeartLayout);
            this.mVoteHeartLayout.setEnabled(false);
            return;
        }
        this.mVoteHeartLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSticker(NTVasSimpleInfo nTVasSimpleInfo) {
        View view = this.mHeaderChildMap.get("map_key_profile_diy_avatar_sticker");
        if (view == null) {
            return;
        }
        if (nTVasSimpleInfo != null && nTVasSimpleInfo.pendantId != 0) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public int getHorizontalMargin() {
        return UIUtils.b(getContext(), 23.0f);
    }

    @NonNull
    public int getTitleBarColorResource() {
        if (this.mTitleStyle == 0) {
            return R.color.a8u;
        }
        return R.color.f157887a54;
    }

    public void initDiyTemplate() {
        VasDiyData vasDiyData = (VasDiyData) this.mCardInfo.getBusinessInfo(VasDiyData.class);
        this.mTitleStyle = vasDiyData.getTitleStyle();
        Object headerJson = vasDiyData.getHeaderJson();
        if (headerJson instanceof JSONObject) {
            this.mHeaderViewModel = a.b(this.mActivity).f((JSONObject) headerJson, this.mHeaderContainer, true, new e(this.mHeaderChildMap, vasDiyData.getUrlPrefix()));
        } else if (headerJson instanceof JSONArray) {
            this.mHeaderViewModel = a.b(this.mActivity).e((JSONArray) headerJson, this.mHeaderContainer, true, new e(this.mHeaderChildMap, vasDiyData.getUrlPrefix()));
        } else {
            AssertUtils.fail("header is illegal", new Object[0]);
        }
        initHeadUI();
        onUpdate(this.mCardInfo, false);
        if (!this.mCardInfo.card.uin.equals(this.mApp.getCurrentAccountUin())) {
            attachDiyProfileTemplateTipForGuest(this.mActivity, this.mRoot);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onDestroy() {
        super.onDestroy();
        QLog.e(TAG, 1, "profileQvipDiyView destroy");
        f fVar = this.mHeaderViewModel;
        if (fVar != null) {
            fVar.l();
        }
        detachDIYProfileTip(this.mRoot);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        this.mNickNameColor = ((VasDiyData) profileCardInfo.getBusinessInfo(VasDiyData.class)).getMainColor();
        this.mHeaderContainer = new FrameLayout(this.mActivity);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158856qt);
        int i3 = ((((int) this.mScreenHeight) - ProfileCardUtil.i(this.mActivity, 18)) - dimensionPixelSize) - ProfileCardUtil.B(getResources());
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i3 += ImmersiveUtils.getStatusBarHeight(getContext());
        }
        addView(this.mHeaderContainer, new RelativeLayout.LayoutParams(-1, i3));
        this.mVoteHeartLayout = new HeartLayout(this.mActivity);
        addView(this.mVoteHeartLayout, new RelativeLayout.LayoutParams(-1, i3));
        this.mVoteHeartLayout.setVisibility(8);
        super.onInit(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onPause() {
        super.onPause();
        this.mHeaderViewModel.n();
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        super.onResume();
        this.mHeaderViewModel.o();
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        c.t(TAG, "\u81ea\u5b9a\u4e49\u8d44\u6599\u5361update isNetRet=" + z16);
        if (this.mNickNameView == null || this.mAvatarContainer == null) {
            initHeadUI();
        }
        if (this.mAvatarContainer != null) {
            c.t(TAG, "\u81ea\u5b9a\u4e49\u8d44\u6599\u5361update \u5934\u50cf");
            updateAvatar(profileCardInfo.allInOne);
            updateAvatarPendantImage(profileCardInfo, false);
        }
        if (this.mNickNameView != null) {
            c.t(TAG, "\u81ea\u5b9a\u4e49\u8d44\u6599\u5361update \u6635\u79f0");
            updateHead(profileCardInfo);
        }
        if (this.mVoteView != null) {
            c.t(TAG, "\u81ea\u5b9a\u4e49\u8d44\u6599\u5361update \u70b9\u8d5e");
            updateLike(profileCardInfo);
        }
    }

    public void setProfileArgs(ViewGroup viewGroup) {
        this.mRoot = viewGroup;
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateAvatarPendantImage(final ProfileCardInfo profileCardInfo, final boolean z16) {
        if (ProAvatarComponentUtils.m()) {
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_avatar_pendant");
        if (view instanceof ImageView) {
            final ImageView imageView = (ImageView) view;
            if (!ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
                imageView.setVisibility(4);
                this.mPendantId = 0L;
            } else {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(profileCardInfo.allInOne.uin), VasProfileQVipDiyView.TAG);
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NTVasSimpleInfo nTVasSimpleInfo = vasSimpleInfoWithUid;
                                if (nTVasSimpleInfo != null && nTVasSimpleInfo.pendantId != 0) {
                                    imageView.setVisibility(0);
                                    ((AbsProfileHeaderView) VasProfileQVipDiyView.this).mPendantId = vasSimpleInfoWithUid.pendantId;
                                    IPendantInfo pendantInfo = ((com.tencent.mobileqq.vas.b) ((AbsProfileHeaderView) VasProfileQVipDiyView.this).mApp.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).getPendantInfo(((AbsProfileHeaderView) VasProfileQVipDiyView.this).mPendantId);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    pendantInfo.setDrawable(imageView, 2, PendantConstant.PENDANT_TARGET_ID_PROFILE, profileCardInfo.allInOne.uin, vasSimpleInfoWithUid.pendantDiyId);
                                } else {
                                    imageView.setVisibility(8);
                                    ((AbsProfileHeaderView) VasProfileQVipDiyView.this).mPendantId = 0L;
                                }
                                VasProfileQVipDiyView.this.updateSticker(vasSimpleInfoWithUid);
                            }
                        });
                        if (z16 && vasSimpleInfoWithUid != null && AvatarPendantFileUtil.isDiyPendant(vasSimpleInfoWithUid.pendantId)) {
                            ((AbsProfileHeaderView) VasProfileQVipDiyView.this).mApp.addObserver(((AbsProfileHeaderView) VasProfileQVipDiyView.this).mDiyPendantObserver);
                            AvatarPendantUtil.e(((AbsProfileHeaderView) VasProfileQVipDiyView.this).mApp, profileCardInfo.allInOne.uin);
                        }
                    }
                }, 8, null, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateHead(ProfileCardInfo profileCardInfo) {
        View view = this.mHeaderChildMap.get("map_key_profile_nick_name");
        String str = " ";
        if (view instanceof ProfileNameView) {
            ProfileNameView profileNameView = (ProfileNameView) view;
            if (profileNameView != null) {
                profileNameView.k(this.mApp, profileCardInfo);
            }
            if (profileNameView.b() != null && profileNameView.b().getVisibility() == 0) {
                ETTextViewPlus b16 = profileNameView.b();
                AllInOne allInOne = profileCardInfo.allInOne;
                String str2 = profileCardInfo.profileName.f305805a.f305804b;
                if (str2 != null && str2.length() != 0) {
                    str = str2;
                } else if (ProfilePAUtils.isPaTypeShowAccount(allInOne)) {
                    str = String.valueOf(allInOne.uin);
                }
                b16.setText(str);
                b16.setTextSize(16.0f);
                b16.setContentDescription((this.mActivity.getString(R.string.ab7) + ":") + str);
                b16.setTag(new b(88, b16.getText().toString()));
                b16.setOnClickListener(this.mOnClickListener);
                b16.requestLayout();
                if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(b16, profileCardInfo.card)) {
                    b16.setTextColor(getResources().getColorStateList(R.color.skin_white, null));
                }
                LongClickCopyAction.attachCopyAction(b16);
                return;
            }
            return;
        }
        if (view instanceof ETTextView) {
            ETTextView eTTextView = (ETTextView) view;
            AllInOne allInOne2 = profileCardInfo.allInOne;
            String str3 = profileCardInfo.profileName.f305805a.f305804b;
            if (str3 != null && str3.length() != 0) {
                str = str3;
            } else if (ProfilePAUtils.isPaTypeShowAccount(allInOne2)) {
                str = String.valueOf(allInOne2.uin);
            }
            eTTextView.setText(str);
            eTTextView.setTextSize(16.0f);
            eTTextView.setContentDescription((this.mActivity.getString(R.string.ab7) + ":") + str);
            eTTextView.setTag(new b(88, eTTextView.getText().toString()));
            eTTextView.setOnClickListener(this.mOnClickListener);
            eTTextView.requestLayout();
            LongClickCopyAction.attachCopyAction(eTTextView);
            if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(eTTextView, profileCardInfo.card)) {
                eTTextView.setTextColor(getResources().getColorStateList(R.color.skin_white, null));
                return;
            }
            return;
        }
        super.updateHead(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateLike(ProfileCardInfo profileCardInfo) {
        int i3;
        int i16;
        boolean z16;
        b bVar;
        String format;
        String str;
        boolean z17;
        b bVar2;
        TroopManager troopManager = (TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
        if (profileCardInfo.isTroopMemberCard && troopManager.V(profileCardInfo.troopUin)) {
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_like");
        if (view instanceof VoteViewV2) {
            VoteViewV2 voteViewV2 = (VoteViewV2) view;
            boolean isShowZan = isShowZan(profileCardInfo);
            boolean equals = TextUtils.equals(profileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
            if (isShowZan) {
                voteViewV2.setVisibility(0);
                if (profileCardInfo.card == null) {
                    i3 = 0;
                    i16 = 0;
                    bVar2 = null;
                    z17 = false;
                    str = this.mActivity.getString(R.string.acw);
                } else {
                    if (this.mNewVoteAnimHelper == null) {
                        this.mNewVoteAnimHelper = new j(this.mActivity, this.mApp, 1, 1);
                    }
                    Card card = profileCardInfo.card;
                    i3 = (int) card.lVoteCount;
                    i16 = card.iVoteIncrement;
                    if (1 == card.bVoted) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.mNewVoteAnimHelper.M = card.getLastPraiseInfoList();
                    if (i16 <= this.mNewVoteAnimHelper.M.size()) {
                        j jVar = this.mNewVoteAnimHelper;
                        jVar.M = jVar.M.subList(0, i16);
                    }
                    j jVar2 = this.mNewVoteAnimHelper;
                    jVar2.M = com.tencent.mobileqq.profile.like.c.b(jVar2.M);
                    if (equals) {
                        bVar = new b(10, profileCardInfo.card);
                        format = String.format(this.mActivity.getString(R.string.acu), String.valueOf(i3));
                    } else {
                        bVar = new b(10, profileCardInfo.card);
                        format = String.format(this.mActivity.getString(R.string.aap), String.valueOf(i3));
                        if (profileCardInfo.card.bAvailVoteCnt == 0) {
                            voteViewV2.m();
                        }
                    }
                    str = format;
                    z17 = z16;
                    bVar2 = bVar;
                }
                j jVar3 = this.mNewVoteAnimHelper;
                Card card2 = profileCardInfo.card;
                voteViewV2.r(equals, z17, i3, i16, jVar3, false, card2.likeAreaId, Boolean.valueOf(card2.isLuckyVip()), profileCardInfo.card.uin);
                voteViewV2.setTag(bVar2);
                voteViewV2.setOnClickListener(this.mOnClickListener);
                voteViewV2.setContentDescription(str);
                return;
            }
            voteViewV2.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateLiked(ProfileCardInfo profileCardInfo, long j3, boolean z16) {
        long j16;
        View view = this.mHeaderChildMap.get("map_key_like");
        if (view instanceof VoteViewV2) {
            VoteViewV2 voteViewV2 = (VoteViewV2) view;
            if (j3 == -1) {
                j16 = voteViewV2.f316533e;
            } else {
                j16 = j3;
            }
            Card card = profileCardInfo.card;
            if (card == null) {
                return;
            }
            if (card.bAvailVoteCnt == 0) {
                voteViewV2.m();
            }
            Card card2 = profileCardInfo.card;
            voteViewV2.r(false, true, (int) j16, 0, null, z16, card2.likeAreaId, Boolean.valueOf(card2.isLuckyVip()), profileCardInfo.card.uin);
            voteViewV2.setContentDescription(String.format(this.mActivity.getString(R.string.f170791ab1), String.valueOf(j16)));
        }
    }
}
