package com.tencent.mobileqq.profilecard.vas.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes16.dex */
public class VasProfileSimpleView extends AbsProfileHeaderView {
    private static final int ANIM_TIME_OUT_LENGTH = 1000;
    private static final int SPACE_HEAD_HEIGHT = 129;
    private static final int SPACE_TIP_HEIGHT = 18;
    private TextView mAgeText;
    private long mAnimBeginTime;
    private TextView mAreaText;
    private View mBlankView;
    private int mBottomBarHeight;
    private boolean mFromExtendFriend;
    private boolean mIsAnimEnd;
    private float mOldScreenHeight;
    private TextView mSexText;
    private int mStatusBarHeight;

    public VasProfileSimpleView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
        this.mIsAnimEnd = false;
        this.mOldScreenHeight = 0.0f;
        this.mBottomBarHeight = -1;
        this.mStatusBarHeight = -1;
    }

    private View initMainView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.bev, (ViewGroup) this, true);
    }

    private String jointPlaceStr(String str, String str2, int i3, String str3, String str4) {
        if (!TextUtils.isEmpty(str2) && !HardCodeUtil.qqStr(i3).equals(str2)) {
            str = str + str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "\uff0c";
            }
            str = str + str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "\uff0c";
            }
            return str + str4;
        }
        return str;
    }

    private void prepareForEnterAnimation(View view) {
        this.mBottomBarHeight = getResources().getDimensionPixelSize(R.dimen.f158856qt);
        this.mStatusBarHeight = ProfileCardUtil.B(getResources());
        View findViewById = view.findViewById(R.id.f165799dk1);
        this.mBlankView = findViewById;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null) {
            layoutParams.height = (((((int) this.mScreenHeight) - ProfileCardUtil.i(qBaseActivity, 129)) - ProfileCardUtil.i(this.mActivity, 18)) - this.mBottomBarHeight) - this.mStatusBarHeight;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            layoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
        }
        if (this.mFromExtendFriend) {
            layoutParams.height = (int) (layoutParams.height - (this.mScreenHeight / 2.0f));
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "rl.height: " + layoutParams.height);
        }
        this.mBlankView.setLayoutParams(layoutParams);
        this.mBlankView.setFocusable(true);
        this.mBlankView.setFocusableInTouchMode(true);
    }

    private void setAgeTxt(ProfileCardInfo profileCardInfo, Card card, ContactCard contactCard) {
        byte b16;
        String str;
        if (card != null) {
            b16 = card.age;
        } else if (contactCard != null) {
            b16 = contactCard.bAge;
        } else {
            b16 = -1;
        }
        String str2 = "";
        if (b16 <= 0) {
            str = "";
        } else {
            str = ((int) b16) + this.mActivity.getString(R.string.htz);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "updateSexAgeArea age=" + str);
        }
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41610, profileCardInfo)) {
            str2 = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.mAgeText.setVisibility(0);
            this.mAgeText.setText(str2);
            this.mAgeText.setContentDescription(str2);
            return;
        }
        this.mAgeText.setVisibility(8);
    }

    private void setPlaceTxt(ProfileCardInfo profileCardInfo, ContactCard contactCard) {
        String str = "";
        Card card = profileCardInfo.card;
        if (card != null) {
            str = jointPlaceStr("", card.strCountry, R.string.vgq, card.strProvince, card.strCity);
        } else if (contactCard != null) {
            str = jointPlaceStr("", contactCard.strCountry, R.string.vgp, contactCard.strProvince, contactCard.strCity);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "updateSexAgeArea place=" + str);
        }
        if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41614, profileCardInfo)) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.mAreaText.setVisibility(0);
            this.mAreaText.setText(str);
            this.mAreaText.setContentDescription(str);
            return;
        }
        this.mAreaText.setVisibility(8);
    }

    private void setSexTxt(ProfileCardInfo profileCardInfo, Card card, ContactCard contactCard) {
        int i3 = profileCardInfo.allInOne.gender;
        if (i3 != 0 && i3 != 1 && ((card == null || ((i3 = card.shGender) != 0 && i3 != 1)) && (contactCard == null || ((i3 = contactCard.bSex) != 0 && i3 != 1)))) {
            i3 = -1;
        }
        showSexTxt(profileCardInfo, "", i3);
    }

    private void showSexTxt(ProfileCardInfo profileCardInfo, String str, int i3) {
        if (i3 == 0) {
            str = this.mActivity.getString(R.string.c7_);
        } else if (i3 == 1) {
            str = this.mActivity.getString(R.string.b5e);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "updateSexAgeArea sex=" + str);
        }
        if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFieldVisible(41611, profileCardInfo)) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.mSexText.setVisibility(0);
            this.mSexText.setText(str);
            this.mSexText.setContentDescription(str);
            return;
        }
        this.mSexText.setVisibility(8);
    }

    private void startEnterAnimation(final ProfileCardInfo profileCardInfo) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, -100.0f);
        translateAnimation.setDuration(500L);
        translateAnimation.setFillAfter(true);
        final TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, -100.0f, 0, 0.0f);
        translateAnimation2.setDuration(500L);
        translateAnimation2.setAnimationListener(new SimpleAnimationListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView.1
            @Override // com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView.SimpleAnimationListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                VasProfileSimpleView.this.mIsAnimEnd = true;
                VasProfileSimpleView.this.updateJueban(profileCardInfo);
            }
        });
        translateAnimation.setAnimationListener(new SimpleAnimationListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView.2
            @Override // com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView.SimpleAnimationListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                VasProfileSimpleView.this.startAnimation(translateAnimation2);
            }
        });
        startAnimation(translateAnimation);
        this.mAnimBeginTime = System.currentTimeMillis();
    }

    private void updateAvatarArea(ProfileCardInfo profileCardInfo, Context context, View view) {
        String string;
        AvatarLayout avatarLayout = (AvatarLayout) view.findViewById(R.id.f165801dk3);
        avatarLayout.setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(R.id.f165802dk4);
        if (profileCardInfo.card != null) {
            if (((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(profileCardInfo.card.uin)) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
            }
        }
        this.templateUtils.updateViewAttr(imageView, "src", profileCardInfo.currentTemplate, "commonFaceBackground");
        b bVar = new b(1, null);
        avatarLayout.setTag(bVar);
        avatarLayout.setOnClickListener(this.mOnClickListener);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            string = context.getString(R.string.abp);
        } else {
            string = context.getString(R.string.abo);
        }
        avatarLayout.setContentDescription(string);
        avatarLayout.d(0, avatarLayout.findViewById(R.id.a6e), false);
        this.mHeaderChildMap.put("map_key_face", avatarLayout);
        this.mHeaderChildMap.put("map_key_face_stoke", view.findViewById(R.id.f165802dk4));
        super.updateAvatar(profileCardInfo.allInOne);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.dfv);
        imageView2.setVisibility(4);
        imageView2.setOnClickListener(this.mOnClickListener);
        imageView2.setTag(bVar);
        imageView2.setContentDescription(string);
        AccessibilityUtil.n(imageView2, false);
        this.mHeaderChildMap.put("map_key_avatar_pendant", imageView2);
        super.updateAvatarPendantImage(profileCardInfo, true);
    }

    private void updateBaseInfoArea(ProfileCardInfo profileCardInfo, View view) {
        this.mSexText = (TextView) view.findViewById(R.id.dke);
        this.mAgeText = (TextView) view.findViewById(R.id.dkc);
        this.mAreaText = (TextView) view.findViewById(R.id.dkd);
        this.templateUtils.updateViewAttr(this.mSexText, "color", profileCardInfo.currentTemplate, "simpleAddressColor");
        this.templateUtils.updateViewAttr(this.mAgeText, "color", profileCardInfo.currentTemplate, "simpleAddressColor");
        this.templateUtils.updateViewAttr(this.mAreaText, "color", profileCardInfo.currentTemplate, "simpleAddressColor");
        this.templateUtils.updateViewAttr(this.mSexText, "background", profileCardInfo.currentTemplate, "simpleAddressBackground");
        this.templateUtils.updateViewAttr(this.mAgeText, "background", profileCardInfo.currentTemplate, "simpleAddressBackground");
        this.templateUtils.updateViewAttr(this.mAreaText, "background", profileCardInfo.currentTemplate, "simpleAddressBackground");
        updateSexAgeAreaSimple(profileCardInfo);
    }

    private void updateHeadArea(ProfileCardInfo profileCardInfo, View view) {
        ProfileNameView profileNameView = (ProfileNameView) view.findViewById(R.id.dkj);
        this.templateUtils.updateViewAttr(profileNameView, "color", profileCardInfo.currentTemplate, "simpleNickNameColor");
        profileNameView.setVisibility(0);
        profileNameView.setClickable(true);
        profileNameView.setClickListener(this.mOnClickListener);
        this.mHeaderChildMap.put("map_key_profile_nick_name", profileNameView);
        super.updateHead(profileCardInfo);
    }

    private void updateLikeArea(ProfileCardInfo profileCardInfo, View view) {
        HeartLayout heartLayout = (HeartLayout) findViewById(R.id.f165689d53);
        heartLayout.setEnabled(false);
        VoteView voteView = (VoteView) findViewById(R.id.l0b);
        VoteViewV2 voteViewV2 = (VoteViewV2) findViewById(R.id.f12026793);
        if (profileCardInfo.card.likeAreaId == 0) {
            voteView.setVisibility(0);
            voteViewV2.setVisibility(4);
            voteView.setHeartLayout(this.mApp, heartLayout);
            this.mHeaderChildMap.put("map_key_like", voteView);
        } else {
            voteViewV2.setVisibility(0);
            voteView.setVisibility(4);
            voteViewV2.setHeartLayout(this.mApp, heartLayout);
            this.mHeaderChildMap.put("map_key_like", voteViewV2);
        }
        super.updateLike(profileCardInfo);
    }

    private void updatePhotoWallArea(ProfileCardInfo profileCardInfo, View view) {
        VipPhotoViewForSimple vipPhotoViewForSimple = (VipPhotoViewForSimple) view.findViewById(R.id.h7a);
        vipPhotoViewForSimple.setTemplateUtils(this.templateUtils);
        vipPhotoViewForSimple.i(this.mActivity, profileCardInfo);
        this.mHeaderChildMap.put("map_key_qzonecover", vipPhotoViewForSimple);
        this.templateUtils.updateViewAttr(vipPhotoViewForSimple, "background", profileCardInfo.currentTemplate, "commonMaskBackground");
    }

    private void updateTipArea(View view) {
        this.mHeaderChildMap.put("map_key_tips", (LinearLayout) view.findViewById(R.id.dle));
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView, com.tencent.widget.XListView.MotionEventInterceptor
    public boolean intercept(View view, MotionEvent motionEvent) {
        boolean z16;
        if (System.currentTimeMillis() - this.mAnimBeginTime > 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.mIsAnimEnd) {
            return true;
        }
        return super.intercept(view, motionEvent);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onApolloExpand(int i3) {
        super.onApolloExpand(i3);
        View view = this.mHeaderChildMap.get("map_key_like");
        if ((view instanceof VoteView) || (view instanceof VoteViewV2)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.addRule(8, R.id.dln);
            layoutParams.bottomMargin = i3;
            view.setLayoutParams(layoutParams);
            if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard", 2, "onApolloExpand h:" + i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mOldScreenHeight != this.mScreenHeight) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBlankView.getLayoutParams();
            layoutParams.height = (int) (layoutParams.height + (this.mScreenHeight - this.mOldScreenHeight));
            this.mBlankView.setLayoutParams(layoutParams);
            this.mOldScreenHeight = this.mScreenHeight;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    @TargetApi(9)
    public void onInit(ProfileCardInfo profileCardInfo) {
        this.mOldScreenHeight = this.mScreenHeight;
        Context context = getContext();
        View initMainView = initMainView(context);
        prepareForEnterAnimation(initMainView);
        updateAvatarArea(profileCardInfo, context, initMainView);
        updateHeadArea(profileCardInfo, initMainView);
        updateBaseInfoArea(profileCardInfo, initMainView);
        updateLikeArea(profileCardInfo, initMainView);
        updatePhotoWallArea(profileCardInfo, initMainView);
        updateTipArea(initMainView);
        super.onInit(profileCardInfo);
        if (this.mFromExtendFriend) {
            this.mIsAnimEnd = true;
            updateJueban(profileCardInfo);
        } else {
            startEnterAnimation(profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        super.onResume();
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null) {
            super.updateAvatarPendantImage(profileCardInfo, false);
        }
        View view = this.mHeaderChildMap.get("map_key_like");
        if ((view instanceof VoteView) || (view instanceof VoteViewV2)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(3, R.id.f165689d53);
            layoutParams.addRule(8, 0);
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        updateLikeArea(profileCardInfo, null);
        super.updateHead(profileCardInfo);
        updateSexAgeAreaSimple(profileCardInfo);
        super.updateAvatarPendantImage(profileCardInfo, false);
    }

    public void setFromExtendFriend(boolean z16) {
        this.mFromExtendFriend = z16;
    }

    public void updateSexAgeAreaSimple(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo.allInOne.f260789pa == 33) {
            String string = this.mActivity.getString(R.string.fpy);
            this.mAgeText.setVisibility(0);
            this.mSexText.setVisibility(8);
            this.mAreaText.setVisibility(8);
            this.mAgeText.setPadding(0, 10, 0, 0);
            this.mAgeText.setText(string);
            this.mAgeText.setContentDescription(string);
            return;
        }
        Card card = profileCardInfo.card;
        ContactCard contactCard = profileCardInfo.contactCard;
        setSexTxt(profileCardInfo, card, contactCard);
        setAgeTxt(profileCardInfo, card, contactCard);
        setPlaceTxt(profileCardInfo, contactCard);
    }

    /* loaded from: classes16.dex */
    private static class SimpleAnimationListener implements Animation.AnimationListener {
        SimpleAnimationListener() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
