package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes16.dex */
public class VasProfileGameView extends AbsProfileHeaderView {
    public VasProfileGameView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
    }

    @NotNull
    private View initMainView(ProfileCardInfo profileCardInfo, Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bei, (ViewGroup) this, true);
        this.templateUtils.updateViewAttr((LinearLayout) inflate.findViewById(R.id.dka), "background", profileCardInfo.currentTemplate, "gameHeadInfoBackground");
        return inflate;
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
        this.templateUtils.updateViewAttr(textView, "color", profileCardInfo.currentTemplate, "gameAddressColor");
        this.mHeaderChildMap.put("map_key_sex_age_area", textView);
        super.updateSexAgeArea(profileCardInfo);
    }

    private void updateHeadArea(ProfileCardInfo profileCardInfo, View view) {
        ProfileNameView profileNameView = (ProfileNameView) view.findViewById(R.id.dkj);
        this.templateUtils.updateViewAttr(profileNameView, "color", profileCardInfo.currentTemplate, "gameNickNameColor");
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

    private void updateSignArea(ProfileCardInfo profileCardInfo, View view) {
        this.mHeaderChildMap.put("map_key_sign_common_topic", (LinearLayout) view.findViewById(R.id.f165806lm2));
        TextView textView = (TextView) view.findViewById(R.id.dld);
        this.templateUtils.updateViewAttr(textView, "color", profileCardInfo.currentTemplate, "gameSignColor");
        this.mHeaderChildMap.put("map_key_sign", textView);
        updateSign(profileCardInfo);
    }

    private void updateTipArea(View view) {
        this.mHeaderChildMap.put("map_key_tips", (LinearLayout) view.findViewById(R.id.dle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        Context context = getContext();
        View initMainView = initMainView(profileCardInfo, context);
        updateAvatarArea(profileCardInfo, context, initMainView);
        updateHeadArea(profileCardInfo, initMainView);
        updateBaseInfoArea(profileCardInfo, initMainView);
        updateSignArea(profileCardInfo, initMainView);
        updateLikeArea(profileCardInfo, initMainView);
        updateTipArea(initMainView);
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
        updateSign(profileCardInfo);
        super.updateAvatarPendantImage(profileCardInfo, false);
    }
}
