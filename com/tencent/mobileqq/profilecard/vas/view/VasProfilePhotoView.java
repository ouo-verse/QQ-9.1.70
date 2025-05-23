package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;

/* loaded from: classes16.dex */
public class VasProfilePhotoView extends AbsProfileHeaderView {
    public VasProfilePhotoView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
    }

    private View initMainView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.bep, (ViewGroup) this, true);
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
        TextView textView = (TextView) view.findViewById(R.id.dkb);
        this.templateUtils.updateViewAttr(textView, "color", profileCardInfo.currentTemplate, "photoAddressColor");
        this.mHeaderChildMap.put("map_key_sex_age_area", textView);
        super.updateSexAgeArea(profileCardInfo);
    }

    private void updateHeadArea(ProfileCardInfo profileCardInfo, View view) {
        ProfileNameView profileNameView = (ProfileNameView) view.findViewById(R.id.dkj);
        this.templateUtils.updateViewAttr(profileNameView, "color", profileCardInfo.currentTemplate, "photoNickNameColor");
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
        QzonePhotoView qzonePhotoView = (QzonePhotoView) view.findViewById(R.id.h7a);
        qzonePhotoView.setTemplateUtils(this.templateUtils);
        qzonePhotoView.j(this.mActivity, profileCardInfo);
        this.mHeaderChildMap.put("map_key_qzonecover", qzonePhotoView);
        this.templateUtils.updateViewAttr(qzonePhotoView, "background", profileCardInfo.currentTemplate, "commonMaskBackground");
    }

    private void updateTipsArea(View view) {
        this.mHeaderChildMap.put("map_key_tips", (LinearLayout) view.findViewById(R.id.dle));
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView, com.tencent.widget.XListView.MotionEventInterceptor
    public boolean intercept(View view, MotionEvent motionEvent) {
        View view2 = this.mHeaderChildMap.get("map_key_qzonecover");
        if (view2 != null && (view2 instanceof QzonePhotoView)) {
            return ((QzonePhotoView) view2).intercept(view, motionEvent);
        }
        return super.intercept(view, motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        Context context = getContext();
        View initMainView = initMainView(context);
        updateAvatarArea(profileCardInfo, context, initMainView);
        updateHeadArea(profileCardInfo, initMainView);
        updateBaseInfoArea(profileCardInfo, initMainView);
        updateLikeArea(profileCardInfo, initMainView);
        updatePhotoWallArea(profileCardInfo, initMainView);
        updateTipsArea(initMainView);
        super.onInit(profileCardInfo);
        super.updateJueban(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        super.onResume();
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null) {
            super.updateAvatarPendantImage(profileCardInfo, false);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        updateLikeArea(profileCardInfo, null);
        super.updateHead(profileCardInfo);
        super.updateSexAgeArea(profileCardInfo);
        super.updateAvatarPendantImage(profileCardInfo, false);
    }
}
