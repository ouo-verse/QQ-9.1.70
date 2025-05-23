package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
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
import com.tencent.mobileqq.profile.like.c;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.pendant.drawable.AvatarPendantFileUtil;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* loaded from: classes16.dex */
public class VasProfileQVipV5View extends AbsProfileHeaderView {
    private View mAccountInfoView;
    private AvatarLayout mAvatar;
    private ImageView mAvatarPendant;
    private View mContentView;
    private ViewGroup mHeadContainer;
    private boolean mIsFromArkBabyQ;
    private ProfileNameView mNameView;
    private QidCoolTextView mQidInfoView;
    private TextView mRemarkName;
    private TextView mUinInfoView;
    private HeartLayout mVoteHeartLayout;
    private VoteViewV2 mVoteView;

    public VasProfileQVipV5View(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
        this.mNewVoteAnimHelper = new j(qBaseActivity, this.mApp, 3, 1);
    }

    private void initHeadUI() {
        String string;
        int i3;
        float f16;
        if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.TAG, 2, "initHeadUI");
        }
        Context context = getContext();
        this.mHeadContainer = (ViewGroup) this.mContentView.findViewById(R.id.dk9);
        AvatarLayout avatarLayout = (AvatarLayout) this.mContentView.findViewById(R.id.f165801dk3);
        this.mAvatar = avatarLayout;
        avatarLayout.setVisibility(0);
        b bVar = new b(1, null);
        if (this.mCardInfo.allInOne.f260789pa == 0) {
            string = context.getString(R.string.abp);
        } else {
            string = context.getString(R.string.abo);
        }
        this.mAvatar.setTag(bVar);
        this.mAvatar.setOnClickListener(this.mOnClickListener);
        this.mAvatar.setContentDescription(string);
        AvatarLayout avatarLayout2 = this.mAvatar;
        avatarLayout2.d(0, avatarLayout2.findViewById(R.id.a6e), false);
        this.mHeaderChildMap.put("map_key_face", this.mAvatar);
        this.mHeaderChildMap.put("map_key_face_stoke", this.mContentView.findViewById(R.id.dk7));
        ImageView imageView = (ImageView) this.mContentView.findViewById(R.id.dfv);
        this.mAvatarPendant = imageView;
        this.mHeaderChildMap.put("map_key_avatar_pendant", imageView);
        this.mAvatarPendant.setVisibility(8);
        this.mAvatarPendant.setTag(bVar);
        this.mAvatarPendant.setOnClickListener(this.mOnClickListener);
        this.mAvatarPendant.setContentDescription(string);
        AccessibilityUtil.n(this.mAvatarPendant, false);
        ProfileNameView profileNameView = (ProfileNameView) this.mContentView.findViewById(R.id.f9c);
        this.mNameView = profileNameView;
        int i16 = -16777216;
        if (this.mCardInfo.card.backgroundColor == 1) {
            i3 = -16777216;
        } else {
            i3 = -1;
        }
        profileNameView.setTextColor(i3);
        this.mHeaderChildMap.put("map_key_profile_nick_name", this.mNameView);
        this.mNameView.setVisibility(0);
        this.mNameView.setClickable(true);
        this.mNameView.setClickListener(this.mOnClickListener);
        TextView textView = (TextView) this.mContentView.findViewById(R.id.f72723rm);
        this.mRemarkName = textView;
        this.mHeaderChildMap.put("map_key_profile_remark_name", textView);
        View findViewById = this.mContentView.findViewById(R.id.gqh);
        this.mAccountInfoView = findViewById;
        this.mHeaderChildMap.put("map_key_details", findViewById);
        this.mVoteView = (VoteViewV2) this.mContentView.findViewById(R.id.l0b);
        this.mVoteHeartLayout = (HeartLayout) this.mContentView.findViewById(R.id.f165689d53);
        this.mHeaderChildMap.put("map_key_like", this.mVoteView);
        this.mVoteView.setHeartLayout(this.mApp, this.mVoteHeartLayout);
        this.mVoteView.d(0);
        this.mVoteHeartLayout.setEnabled(false);
        TextView textView2 = (TextView) this.mContentView.findViewById(R.id.gmx);
        this.mUinInfoView = textView2;
        if (this.mCardInfo.card.backgroundColor != 1) {
            i16 = -1;
        }
        textView2.setTextColor(i16);
        this.mHeaderChildMap.put("map_key_uin_info", this.mUinInfoView);
        QidCoolTextView qidCoolTextView = (QidCoolTextView) this.mContentView.findViewById(R.id.f61892zc);
        this.mQidInfoView = qidCoolTextView;
        this.mHeaderChildMap.put("map_key_qid_info", qidCoolTextView);
        this.mQidInfoView.setOnClickListener(this.mOnClickListener);
        QidCoolTextView qidCoolTextView2 = this.mQidInfoView;
        if (PrettyAccountUtil.isPrettyOpenForCard(this.mCardInfo.card) == 1) {
            f16 = 8.5f;
        } else {
            f16 = 7.0f;
        }
        qidCoolTextView2.adapterQidMargin(f16, 0.0f);
    }

    protected void loadHeadLayout(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.TAG, 2, " needRefreshUI=" + z16);
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bel, this.mHeadContainer, false);
        if (inflate != null) {
            this.mHeadContainer.removeAllViews();
            this.mHeadContainer.addView(inflate);
            if (z16) {
                initHeadUI();
                updateAvatar(this.mCardInfo.allInOne);
                updateAvatarPendantImage(this.mCardInfo, false);
                updateHead(this.mCardInfo);
                updateDetail(this.mCardInfo);
                updateLike(this.mCardInfo);
                updateUinInfo(this.mCardInfo, this.mApp.getCurrentAccountUin());
                updateQidInfo(this.mCardInfo);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168965bf1, (ViewGroup) this, true);
        this.mContentView = inflate;
        this.mHeadContainer = (ViewGroup) inflate.findViewById(R.id.dk9);
        loadHeadLayout(false);
        initHeadUI();
        updateAvatar(profileCardInfo.allInOne);
        updateAvatarPendantImage(profileCardInfo, true);
        updateHead(profileCardInfo);
        updateDetail(profileCardInfo);
        updateLike(profileCardInfo);
        updateUinInfo(profileCardInfo, this.mApp.getCurrentAccountUin());
        updateQidInfo(profileCardInfo);
        super.onInit(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        super.onResume();
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null) {
            updateAvatarPendantImage(profileCardInfo, false);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        updateAvatar(profileCardInfo.allInOne);
        updateAvatarPendantImage(profileCardInfo, false);
        updateHead(profileCardInfo);
        updateDetail(profileCardInfo);
        updateLike(profileCardInfo);
        updateUinInfo(profileCardInfo, this.mApp.getCurrentAccountUin());
        updateQidInfo(profileCardInfo);
    }

    public void setProfileArgs(boolean z16) {
        this.mIsFromArkBabyQ = z16;
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateAvatarPendantImage(final ProfileCardInfo profileCardInfo, final boolean z16) {
        if (ProAvatarComponentUtils.m() || this.mAvatarPendant == null) {
            return;
        }
        if (!ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
            this.mAvatarPendant.setVisibility(8);
            this.mPendantId = 0L;
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View.1
                @Override // java.lang.Runnable
                public void run() {
                    final NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(profileCardInfo.allInOne.uin), AbsProfileHeaderView.TAG);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NTVasSimpleInfo nTVasSimpleInfo = vasSimpleInfoWithUid;
                            if (nTVasSimpleInfo != null && nTVasSimpleInfo.pendantId != 0) {
                                VasProfileQVipV5View.this.mAvatarPendant.setVisibility(0);
                                ((AbsProfileHeaderView) VasProfileQVipV5View.this).mPendantId = vasSimpleInfoWithUid.pendantId;
                                ((com.tencent.mobileqq.vas.b) ((AbsProfileHeaderView) VasProfileQVipV5View.this).mApp.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).getPendantInfo(((AbsProfileHeaderView) VasProfileQVipV5View.this).mPendantId).setDrawable(VasProfileQVipV5View.this.mAvatarPendant, 2, PendantConstant.PENDANT_TARGET_ID_PROFILE, profileCardInfo.allInOne.uin, vasSimpleInfoWithUid.pendantDiyId);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (z16) {
                                    ReportController.o(((AbsProfileHeaderView) VasProfileQVipV5View.this).mApp, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
                                    return;
                                }
                                return;
                            }
                            VasProfileQVipV5View.this.mAvatarPendant.setVisibility(8);
                            ((AbsProfileHeaderView) VasProfileQVipV5View.this).mPendantId = 0L;
                        }
                    });
                    if (z16 && vasSimpleInfoWithUid != null && AvatarPendantFileUtil.isDiyPendant(vasSimpleInfoWithUid.pendantId)) {
                        ((AbsProfileHeaderView) VasProfileQVipV5View.this).mApp.addObserver(((AbsProfileHeaderView) VasProfileQVipV5View.this).mDiyPendantObserver);
                        AvatarPendantUtil.e(((AbsProfileHeaderView) VasProfileQVipV5View.this).mApp, profileCardInfo.allInOne.uin);
                    }
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateLike(ProfileCardInfo profileCardInfo) {
        int i3;
        int i16;
        boolean z16;
        b bVar;
        String format;
        b bVar2;
        TroopManager troopManager = (TroopManager) this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
        if (profileCardInfo.isTroopMemberCard && troopManager.V(profileCardInfo.troopUin)) {
            return;
        }
        View view = this.mHeaderChildMap.get("map_key_like");
        if (view instanceof VoteViewV2) {
            VoteViewV2 voteViewV2 = (VoteViewV2) view;
            voteViewV2.setVoteImageId(R.drawable.qui_like, R.drawable.qui_like_filled);
            voteViewV2.setVoteColor(R.color.qui_common_brand_standard);
            boolean isShowZan = isShowZan(profileCardInfo);
            if (this.mIsFromArkBabyQ) {
                isShowZan = false;
            }
            boolean equals = TextUtils.equals(profileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
            if (isShowZan) {
                voteViewV2.setVisibility(0);
                if (profileCardInfo.card == null) {
                    format = this.mActivity.getString(R.string.acw);
                    bVar2 = null;
                    i3 = 0;
                    i16 = 0;
                    z16 = false;
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
                    jVar2.M = c.b(jVar2.M);
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
                    bVar2 = bVar;
                }
                j jVar3 = this.mNewVoteAnimHelper;
                Card card2 = profileCardInfo.card;
                voteViewV2.r(equals, z16, i3, i16, jVar3, false, card2.likeAreaId, Boolean.valueOf(card2.isLuckyVip()), profileCardInfo.card.uin);
                voteViewV2.setTag(bVar2);
                voteViewV2.setOnClickListener(this.mOnClickListener);
                voteViewV2.setContentDescription(format);
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

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateSexAgeArea(ProfileCardInfo profileCardInfo) {
    }
}
