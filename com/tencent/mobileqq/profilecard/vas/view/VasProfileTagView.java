package com.tencent.mobileqq.profilecard.vas.view;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.FragmentBreadCrumbs;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenKuikly;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import uy2.a;

/* loaded from: classes16.dex */
public class VasProfileTagView extends AbsProfileHeaderView implements a.InterfaceC11376a, Animator.AnimatorListener {
    private static final int AUTO_FULL_SCREEN_DELAY = 300;
    private static final float ROTATION_DEGREE = 120.0f;
    private static String TAG = "ProfileTagView";
    private static final String TAG_PRAISE_KEY = "%s-%d";
    BreatheEffectView.f aniEndBreatheListener;
    public boolean isDragging;
    public boolean isFullScreen;
    private TextView mAddTagTips;
    private ValueAnimator mAnimEnterFullScreen;
    private ValueAnimator mAnimLeaveFullScreen;
    private ImageView mAvatarPendantImage;
    private TextView mBasicInfoLabel;
    private Drawable mBlurBackground;
    private BreatheEffectView mBreatheView;
    private int mColorScheme;
    private IComponentCenter mComponentCenter;
    private IProfileActivityDelegate mDelegate;
    private ValueAnimator[] mDiffuseAnims;
    private final int mDistanceThreshold;
    private a mDragDetector;
    private boolean mFromExtendFriend;
    private int mFullScreenHeight;
    private ValueAnimator[] mGatherAnims;
    private GestureDetector mGestureDetector;
    private HeartRiseLayerDrawable mHeartRiseDrawable;
    private boolean mIsFirstAnimation;
    private boolean mIsFullAnimPlaying;
    private boolean mIsScrollByExtendFriend;
    private boolean mIsScrolled;
    private SharedPreferences mLikedTagStoreSP;
    private ProfileNameView mNickLabel;
    private Drawable mNormalBackground;
    private int[] mOffsetOnScreen;
    private PointF mPhotoFullPos;
    private PointF mPhotoInitPos;
    private AvatarLayout mPhotoView;
    ValueAnimator.AnimatorUpdateListener mSwitchScreenUpdateListener;
    private int mTagAnimCount;
    private int[] mTagCloudInWindow;
    private RatioLayout mTagCloudLayout;
    private boolean mTagCloudNeedUpdate;
    private View[] mTagViews;
    private static PointF[] TAG_POS = {new PointF(0.126562f, 0.478873f), new PointF(0.220312f, 0.242077f), new PointF(0.559375f, 0.206866f), new PointF(0.85f, 0.279049f), new PointF(0.889062f, 0.440141f), new PointF(0.815625f, 0.61f), new PointF(0.521875f, 0.75f), new PointF(0.18125f, 0.705f)};
    private static final int[] TAG_ADD_ORDER = {3, 1, 0, 5, 4, 2, 6};

    public VasProfileTagView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
        this.mIsFullAnimPlaying = false;
        this.mOffsetOnScreen = new int[2];
        this.mTagCloudInWindow = new int[2];
        PointF[] pointFArr = TAG_POS;
        this.mTagViews = new View[pointFArr.length];
        this.mDiffuseAnims = new ValueAnimator[pointFArr.length];
        this.mGatherAnims = new ValueAnimator[pointFArr.length];
        this.mIsScrollByExtendFriend = false;
        this.mIsFirstAnimation = true;
        this.isDragging = false;
        this.isFullScreen = false;
        this.mSwitchScreenUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                View childAt;
                ViewGroup.LayoutParams layoutParams = VasProfileTagView.this.mTagCloudLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    VasProfileTagView.this.mTagCloudLayout.setLayoutParams(layoutParams);
                    FrameLayout frameLayout = (FrameLayout) ((AbsProfileHeaderView) VasProfileTagView.this).mActivity.findViewById(R.id.content);
                    if (frameLayout == null || frameLayout.getChildCount() <= 0 || (childAt = frameLayout.getChildAt(0)) == null) {
                        return;
                    }
                    Drawable background = childAt.getBackground();
                    if (background instanceof BitmapDrawable) {
                        int animatedFraction = (int) (valueAnimator.getAnimatedFraction() * 255.0f);
                        if (valueAnimator == VasProfileTagView.this.mAnimLeaveFullScreen) {
                            animatedFraction = 255 - animatedFraction;
                        }
                        background.setAlpha(animatedFraction);
                    }
                }
            }
        };
        this.aniEndBreatheListener = new BreatheEffectView.f() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.5
            @Override // com.tencent.mobileqq.profile.view.BreatheEffectView.f
            public void onBreatheShown() {
                RatioLayout.LayoutParams layoutParams;
                if (VasProfileTagView.this.mPhotoFullPos != null) {
                    for (View view : VasProfileTagView.this.mTagViews) {
                        if (view != null && view.getVisibility() != 8 && (layoutParams = (RatioLayout.LayoutParams) view.getLayoutParams()) != null) {
                            layoutParams.f316150a = VasProfileTagView.this.mPhotoFullPos.x;
                            layoutParams.f316151b = VasProfileTagView.this.mPhotoFullPos.y;
                            view.setLayoutParams(layoutParams);
                        }
                    }
                    VasProfileTagView.this.tagsDiffuse();
                }
                FrameLayout frameLayout = (FrameLayout) ((AbsProfileHeaderView) VasProfileTagView.this).mActivity.findViewById(R.id.content);
                if (frameLayout != null) {
                    VasProfileTagView.this.mNormalBackground = frameLayout.getBackground();
                    if (!(VasProfileTagView.this.mNormalBackground instanceof IGLDrawable)) {
                        frameLayout.setBackgroundDrawable(null);
                    }
                }
            }
        };
        this.mDistanceThreshold = qBaseActivity.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.anh);
    }

    private void addAnimationListener(final View view, final PointF pointF, ValueAnimator valueAnimator) {
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VasProfileTagView.this.mTagAnimCount--;
                RatioLayout.LayoutParams layoutParams = (RatioLayout.LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    return;
                }
                if (view.getAnimation() != null) {
                    view.clearAnimation();
                }
                float f16 = layoutParams.f316150a;
                PointF pointF2 = pointF;
                float f17 = pointF2.x;
                if (f16 != f17 || layoutParams.f316151b != pointF2.y) {
                    layoutParams.f316150a = f17;
                    layoutParams.f316151b = pointF2.y;
                    view.setLayoutParams(layoutParams);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    View view2 = view;
                    if (view2 instanceof VipTagView) {
                        ((VipTagView) view2).setShakingState(true);
                    }
                }
                VasProfileTagView.this.mIsFullAnimPlaying = false;
                if (VasProfileTagView.this.mTagAnimCount == 0) {
                    VasProfileTagView.this.updateAddTagTips();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProfileTag(int i3, List<ProfileLabelInfo> list, ProfileCardInfo profileCardInfo) {
        RatioLayout.LayoutParams layoutParams;
        for (int i16 = 0; i16 < i3; i16++) {
            ProfileLabelInfo profileLabelInfo = list.get(i16);
            if (this.mTagViews[i16] == null) {
                VipTagView vipTagView = new VipTagView(getContext());
                this.mTagViews[i16] = vipTagView;
                this.mTagCloudLayout.addView(vipTagView);
                vipTagView.setGravity(17);
                vipTagView.setTag(com.tencent.mobileqq.R.id.h7m, Integer.valueOf(i16));
                vipTagView.setTag(com.tencent.mobileqq.R.id.h7o, Integer.valueOf(TAG_ADD_ORDER[i16]));
                vipTagView.setTextColor(-1);
            }
            VipTagView vipTagView2 = (VipTagView) this.mTagViews[i16];
            if (this.isFullScreen && !this.mIsFullAnimPlaying) {
                PointF pointF = TAG_POS[TAG_ADD_ORDER[i16]];
                layoutParams = new RatioLayout.LayoutParams(-2, -2, 0.5f, 0.5f, pointF.x, pointF.y);
                vipTagView2.setVisibility(0);
                vipTagView2.setShakingState(true);
            } else {
                layoutParams = new RatioLayout.LayoutParams(-2, -2, 0.5f, 0.5f, 0.5f, 0.5f);
                vipTagView2.setVisibility(4);
            }
            vipTagView2.setLayoutParams(layoutParams);
            vipTagView2.setLabelAndPraise(profileLabelInfo.labelName, profileLabelInfo.likeNum.intValue());
            vipTagView2.setTag(com.tencent.mobileqq.R.id.h7n, profileLabelInfo.labelId);
            if (checkTagLiked(vipTagView2) && profileCardInfo.allInOne.f260789pa != 0) {
                vipTagView2.setTagColor(getResources().getColor(com.tencent.mobileqq.R.color.a5n), getResources().getColor(com.tencent.mobileqq.R.color.a5l));
            }
            vipTagView2.setTagColor(getResources().getColor(com.tencent.mobileqq.R.color.a5m), getResources().getColor(com.tencent.mobileqq.R.color.a5k));
        }
    }

    private ValueAnimator enterFullScreen() {
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.scrollToListTop();
        }
        if (this.mFullScreenHeight == 0) {
            this.mFullScreenHeight = this.mActivity.findViewById(R.id.content).getHeight();
            View findViewById = this.mActivity.findViewById(com.tencent.mobileqq.R.id.al_);
            if (findViewById != null) {
                this.mFullScreenHeight -= findViewById.getHeight();
            }
        }
        ValueAnimator valueAnimator = this.mAnimEnterFullScreen;
        if (valueAnimator == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.mTagCloudLayout.getHeight(), this.mFullScreenHeight);
            this.mAnimEnterFullScreen = ofInt;
            return ofInt;
        }
        valueAnimator.start();
        return null;
    }

    private ValueAnimator exitFullScreen() {
        ValueAnimator valueAnimator = this.mAnimLeaveFullScreen;
        if (valueAnimator == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(this.mTagCloudLayout.getHeight(), getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.an9));
            this.mAnimLeaveFullScreen = ofInt;
            return ofInt;
        }
        valueAnimator.start();
        return null;
    }

    private RatioLayout.LayoutParams getTagLayoutParams(View view) {
        RatioLayout.LayoutParams layoutParams = (RatioLayout.LayoutParams) view.getLayoutParams();
        layoutParams.f316150a = 0.5f;
        layoutParams.f316151b = 0.5f;
        layoutParams.f316152c = 0.5f;
        layoutParams.f316153d = 0.5f;
        view.setLayoutParams(layoutParams);
        RatioLayout.LayoutParams layoutParams2 = (RatioLayout.LayoutParams) this.mAddTagTips.getLayoutParams();
        PointF pointF = TAG_POS[r0.length - 1];
        layoutParams2.f316150a = pointF.x + 0.07f;
        layoutParams2.f316151b = pointF.y;
        layoutParams2.f316152c = 0.0f;
        layoutParams2.f316153d = 0.5f;
        return layoutParams2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideOldProcileTag(int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            View view = this.mTagViews[i16];
            if ((view instanceof VipTagView) && view.getVisibility() != 8) {
                ((VipTagView) view).setShakingState(false);
                view.setVisibility(8);
            }
        }
    }

    private void initMainView(Context context) {
        LayoutInflater.from(context).inflate(com.tencent.mobileqq.R.layout.bew, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadColorScreen(IComponentCenter iComponentCenter) {
        ProfileColorScreenComponent profileColorScreenComponent;
        if (iComponentCenter != null && !((IVasColorScreenKuikly) QRoute.api(IVasColorScreenKuikly.class)).getEnable() && (profileColorScreenComponent = (ProfileColorScreenComponent) iComponentCenter.getComponent(1004)) != null) {
            profileColorScreenComponent.loadColorScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAddTagTips() {
        List<ProfileLabelInfo> labelList;
        if (!checkTagUpdateFlag() && (labelList = this.mCardInfo.card.getLabelList()) != null) {
            if (this.mTagViews[TAG_POS.length - 1] != null && labelList.size() == 0) {
                this.mAddTagTips.setVisibility(0);
            } else {
                this.mAddTagTips.setVisibility(4);
            }
        }
        if (this.mIsFirstAnimation) {
            updateJueban(this.mCardInfo);
            this.mIsFirstAnimation = false;
        }
    }

    private void updateAvatarArea(ProfileCardInfo profileCardInfo, Context context) {
        String string;
        AvatarLayout avatarLayout = (AvatarLayout) findViewById(com.tencent.mobileqq.R.id.f165801dk3);
        this.mPhotoView = avatarLayout;
        avatarLayout.d(0, avatarLayout.findViewById(com.tencent.mobileqq.R.id.a6e), false);
        this.mHeaderChildMap.put("map_key_face", this.mPhotoView);
        super.updateAvatar(profileCardInfo.allInOne);
        b bVar = new b(1, null);
        this.mPhotoView.setTag(bVar);
        this.mPhotoView.setOnClickListener(this.mOnClickListener);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            string = context.getString(com.tencent.mobileqq.R.string.abp);
        } else {
            string = context.getString(com.tencent.mobileqq.R.string.abo);
        }
        this.mPhotoView.setContentDescription(string);
        ImageView imageView = (ImageView) findViewById(com.tencent.mobileqq.R.id.dfv);
        this.mAvatarPendantImage = imageView;
        imageView.setVisibility(4);
        this.mAvatarPendantImage.setOnClickListener(this.mOnClickListener);
        this.mAvatarPendantImage.setTag(bVar);
        this.mAvatarPendantImage.setContentDescription(string);
        AccessibilityUtil.n(this.mAvatarPendantImage, false);
        this.mHeaderChildMap.put("map_key_avatar_pendant", this.mAvatarPendantImage);
        super.updateAvatarPendantImage(profileCardInfo, true);
    }

    private void updateBaseInfoArea(ProfileCardInfo profileCardInfo) {
        TextView textView = (TextView) findViewById(com.tencent.mobileqq.R.id.dkb);
        this.mBasicInfoLabel = textView;
        this.mHeaderChildMap.put("map_key_sex_age_area", textView);
        super.updateSexAgeArea(profileCardInfo);
    }

    private void updateHeadArea(ProfileCardInfo profileCardInfo) {
        ProfileNameView profileNameView = (ProfileNameView) findViewById(com.tencent.mobileqq.R.id.dkj);
        this.mNickLabel = profileNameView;
        profileNameView.setClickListener(this.mOnClickListener);
        this.mHeaderChildMap.put("map_key_profile_nick_name", this.mNickLabel);
        super.updateHead(profileCardInfo);
    }

    private void updateLikeArea(ProfileCardInfo profileCardInfo) {
        HeartLayout heartLayout = (HeartLayout) findViewById(com.tencent.mobileqq.R.id.f165689d53);
        heartLayout.setEnabled(false);
        VoteView voteView = (VoteView) findViewById(com.tencent.mobileqq.R.id.l0b);
        VoteViewV2 voteViewV2 = (VoteViewV2) findViewById(com.tencent.mobileqq.R.id.f12026793);
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

    private void updateTagArea() {
        RatioLayout ratioLayout = (RatioLayout) findViewById(com.tencent.mobileqq.R.id.jaf);
        this.mTagCloudLayout = ratioLayout;
        this.mHeaderChildMap.put("map_key_tag_cloud", ratioLayout);
    }

    private void updateTipArea() {
        this.mHeaderChildMap.put("map_key_tips", (LinearLayout) findViewById(com.tencent.mobileqq.R.id.dle));
    }

    void addLike(VipTagView vipTagView, long j3) {
        String format = String.format(TAG_PRAISE_KEY, this.mCardInfo.card.uin, Long.valueOf(j3));
        if (!this.mLikedTagStoreSP.getBoolean(format, false)) {
            ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X80047EF", 0, 0, Long.toString(j3), "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "appreciate the label");
            }
            this.mLikedTagStoreSP.edit().putBoolean(format, true).commit();
            CardHandler cardHandler = (CardHandler) this.mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (cardHandler == null) {
                return;
            }
            cardHandler.j5(this.mApp.getCurrentAccountUin(), this.mCardInfo.card.uin, Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "submit the network params \uff1asrcUin = " + this.mApp.getCurrentAccountUin() + "destUin  = " + this.mCardInfo.card.uin + " labelId  = " + j3);
            }
            vipTagView.h();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "the label has appreciated");
        }
        vipTagView.setShakingState(true);
    }

    boolean checkTagLiked(VipTagView vipTagView) {
        Card card;
        if (vipTagView.getTag(com.tencent.mobileqq.R.id.h7n) == null) {
            return false;
        }
        long longValue = ((Long) vipTagView.getTag(com.tencent.mobileqq.R.id.h7n)).longValue();
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo == null || (card = profileCardInfo.card) == null || TextUtils.isEmpty(card.uin)) {
            return false;
        }
        return this.mLikedTagStoreSP.getBoolean(String.format(TAG_PRAISE_KEY, this.mCardInfo.card.uin, Long.valueOf(longValue)), false);
    }

    boolean checkTagUpdateFlag() {
        if (!this.mTagCloudNeedUpdate) {
            return false;
        }
        this.mTagCloudNeedUpdate = false;
        updateTagCloud(this.mCardInfo);
        return true;
    }

    void doTagScale(final VipTagView vipTagView) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(150L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                VasProfileTagView.this.doTagSpringBack(vipTagView, true);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                if (((AbsProfileHeaderView) VasProfileTagView.this).mCardInfo.allInOne.f260789pa != 0) {
                    vipTagView.setTagColor(VasProfileTagView.this.getResources().getColor(com.tencent.mobileqq.R.color.a5n), VasProfileTagView.this.getResources().getColor(com.tencent.mobileqq.R.color.a5l));
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        vipTagView.startAnimation(scaleAnimation);
    }

    void doTagSpringBack(final VipTagView vipTagView, final boolean z16) {
        Object tag;
        RatioLayout.LayoutParams layoutParams = (RatioLayout.LayoutParams) vipTagView.getLayoutParams();
        if (layoutParams != null && (tag = vipTagView.getTag(com.tencent.mobileqq.R.id.h7o)) != null) {
            PointF pointF = TAG_POS[((Integer) tag).intValue()];
            ValueAnimator ofObject = ValueAnimator.ofObject(new TypeEvaluator<PointF>() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.7
                @Override // android.animation.TypeEvaluator
                public PointF evaluate(float f16, PointF pointF2, PointF pointF3) {
                    float f17 = pointF2.x;
                    float f18 = pointF2.y;
                    return new PointF(f17 + ((pointF3.x - f17) * f16), f18 + (f16 * (pointF3.y - f18)));
                }
            }, new PointF((vipTagView.getLeft() + (vipTagView.getWidth() * layoutParams.f316152c)) / this.mTagCloudLayout.getWidth(), (vipTagView.getTop() + (vipTagView.getHeight() * layoutParams.f316153d)) / this.mTagCloudLayout.getHeight()), new PointF(pointF.x, pointF.y));
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PointF pointF2 = (PointF) valueAnimator.getAnimatedValue();
                    VasProfileTagView.this.mTagCloudLayout.b(vipTagView, pointF2.x, pointF2.y);
                }
            });
            ofObject.setDuration(400L);
            ofObject.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (z16 && ((AbsProfileHeaderView) VasProfileTagView.this).mCardInfo.allInOne.f260789pa != 0 && vipTagView.getTag(com.tencent.mobileqq.R.id.h7l) != null && vipTagView.getTag(com.tencent.mobileqq.R.id.h7l).equals(Boolean.TRUE)) {
                        vipTagView.setTag(com.tencent.mobileqq.R.id.h7l, Boolean.FALSE);
                        VasProfileTagView vasProfileTagView = VasProfileTagView.this;
                        VipTagView vipTagView2 = vipTagView;
                        vasProfileTagView.addLike(vipTagView2, ((Long) vipTagView2.getTag(com.tencent.mobileqq.R.id.h7n)).longValue());
                        return;
                    }
                    vipTagView.setShakingState(true);
                }
            });
            ofObject.start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // uy2.a.InterfaceC11376a
    public a.b findDraggableByPos(float f16, float f17) {
        int[] iArr = new int[2];
        for (FragmentBreadCrumbs fragmentBreadCrumbs : this.mTagViews) {
            if ((fragmentBreadCrumbs instanceof a.b) && fragmentBreadCrumbs.getVisibility() == 0) {
                fragmentBreadCrumbs.getLocationOnScreen(iArr);
                int width = iArr[0] + fragmentBreadCrumbs.getWidth();
                int height = iArr[1] + fragmentBreadCrumbs.getHeight();
                if (f16 >= iArr[0] && f16 <= width && f17 >= iArr[1] && f17 <= height) {
                    return (a.b) fragmentBreadCrumbs;
                }
            }
        }
        return null;
    }

    void initTagLayout() {
        this.mBreatheView = (BreatheEffectView) findViewById(com.tencent.mobileqq.R.id.f165802dk4);
        ImageView imageView = (ImageView) findViewById(com.tencent.mobileqq.R.id.f165688d52);
        HeartRiseLayerDrawable heartRiseLayerDrawable = new HeartRiseLayerDrawable(5, getResources());
        this.mHeartRiseDrawable = heartRiseLayerDrawable;
        imageView.setImageDrawable(heartRiseLayerDrawable);
        this.mAddTagTips = (TextView) findViewById(com.tencent.mobileqq.R.id.jn7);
        this.mAddTagTips.setLayoutParams(getTagLayoutParams(findViewById(com.tencent.mobileqq.R.id.f165675d35)));
        this.mDragDetector = new a(this, this.mBreatheView, true);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                if (QLog.isDebugVersion()) {
                    QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "onScroll invoked");
                }
                VasProfileTagView.this.mIsScrolled = true;
                if (motionEvent != null && motionEvent2 != null) {
                    f17 = motionEvent.getY() - motionEvent2.getY();
                }
                if (QLog.isDebugVersion()) {
                    QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "onScroll distance = " + f17);
                }
                return VasProfileTagView.this.scrollAnimation(f17);
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView, com.tencent.widget.XListView.MotionEventInterceptor
    public boolean intercept(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        if (this.isFullScreen) {
            try {
                a aVar = this.mDragDetector;
                if ((aVar == null || !aVar.a(motionEvent)) && (gestureDetector = this.mGestureDetector) != null && !gestureDetector.onTouchEvent(motionEvent)) {
                    dispatchTouchEvent(motionEvent);
                }
                if (!this.mFromExtendFriend) {
                    return true;
                }
                return super.intercept(view, motionEvent);
            } catch (NullPointerException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return super.intercept(view, motionEvent);
            }
        }
        if (this.mGestureDetector != null) {
            this.mTagCloudLayout.getLocationInWindow(this.mTagCloudInWindow);
            if (this.mTagCloudInWindow[1] - this.mOffsetOnScreen[1] == 0) {
                return this.mGestureDetector.onTouchEvent(motionEvent);
            }
        }
        return super.intercept(view, motionEvent);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        View childAt;
        Drawable drawable;
        Drawable drawable2;
        this.mTagCloudLayout.setSkipMeasure(true);
        FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(R.id.content);
        if (frameLayout != null) {
            if (frameLayout.getBackground() == null && (drawable2 = this.mNormalBackground) != null) {
                frameLayout.setBackgroundDrawable(drawable2);
            }
            if (frameLayout.getChildCount() <= 0 || (childAt = frameLayout.getChildAt(0)) == null || childAt.getBackground() != null || (drawable = this.mBlurBackground) == null) {
                return;
            }
            childAt.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onApolloExpand(int i3) {
        super.onApolloExpand(i3);
        View view = this.mHeaderChildMap.get("map_key_like");
        if ((view instanceof VoteView) || (view instanceof VoteViewV2)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.bottomMargin = ScreenUtil.dip2px(10.0f) + i3;
            view.setLayoutParams(layoutParams);
            if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard", 2, "onApolloExpand h:" + i3);
            }
        }
    }

    @Override // uy2.a.InterfaceC11376a
    public boolean onDrag(a.b bVar, float f16, float f17) {
        this.isDragging = true;
        if (((VipTagView) bVar).j()) {
            onMove(bVar, f16, f17);
            this.mBreatheView.j();
            return true;
        }
        return false;
    }

    @Override // uy2.a.InterfaceC11376a
    public void onDrop(a.c cVar, a.b bVar, float f16, float f17) {
        this.isDragging = false;
        this.mBreatheView.i(null);
        if (cVar != null) {
            VipTagView vipTagView = (VipTagView) bVar;
            vipTagView.setTag(com.tencent.mobileqq.R.id.h7l, Boolean.TRUE);
            doTagScale(vipTagView);
            if (!checkTagLiked(vipTagView) && this.mCardInfo.allInOne.f260789pa != 0) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.amz);
                if (getHandler() != null) {
                    this.mHeartRiseDrawable.b(getHandler(), 900, dimensionPixelSize);
                    return;
                }
                return;
            }
            return;
        }
        if (bVar != null && (bVar instanceof VipTagView)) {
            doTagSpringBack((VipTagView) bVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        Context context = getContext();
        this.mLikedTagStoreSP = this.mActivity.getSharedPreferences(this.mApp.getCurrentAccountUin(), 0);
        initMainView(context);
        updateAvatarArea(profileCardInfo, context);
        updateHeadArea(profileCardInfo);
        updateBaseInfoArea(profileCardInfo);
        updateLikeArea(profileCardInfo);
        updateTagArea();
        updateTipArea();
        super.onInit(profileCardInfo);
        initTagLayout();
        updateTagCloud(profileCardInfo);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        RatioLayout.LayoutParams layoutParams;
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.mPhotoInitPos == null) {
            getLocationOnScreen(this.mOffsetOnScreen);
            a aVar = this.mDragDetector;
            int[] iArr = this.mOffsetOnScreen;
            aVar.b(iArr[0], iArr[1]);
            int width = this.mPhotoView.getWidth();
            int height = this.mPhotoView.getHeight();
            this.mPhotoView.getLocationOnScreen(new int[2]);
            this.mPhotoInitPos = new PointF(((r2[0] - this.mOffsetOnScreen[0]) + (width / 2)) / getWidth(), ((r2[1] - this.mOffsetOnScreen[1]) + (height / 2)) / getHeight());
            if (this.mCardInfo.allInOne.colorScreen != 1) {
                postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        VasProfileTagView.this.switchScreenMode();
                    }
                }, 300L);
            }
        }
        int i19 = this.mFullScreenHeight;
        if (i19 > 0 && i18 - i16 == i19 && this.mPhotoFullPos == null) {
            int width2 = this.mPhotoView.getWidth();
            int height2 = this.mPhotoView.getHeight();
            int[] iArr2 = new int[2];
            this.mPhotoView.getLocationOnScreen(iArr2);
            BreatheEffectView breatheEffectView = this.mBreatheView;
            int i26 = iArr2[0];
            int i27 = iArr2[1];
            breatheEffectView.setHoverHotArea(new Rect(i26, i27, i26 + width2, i27 + height2));
            this.mPhotoFullPos = new PointF(((iArr2[0] - this.mOffsetOnScreen[0]) + (width2 / 2)) / getWidth(), ((iArr2[1] - this.mOffsetOnScreen[1]) + (height2 / 2)) / getHeight());
            int height3 = this.mBasicInfoLabel.getHeight();
            this.mBasicInfoLabel.getLocationOnScreen(iArr2);
            float height4 = (((iArr2[1] - this.mOffsetOnScreen[1]) + height3) + ((int) (((this.mDensity * 45.0f) + 0.5d) / 2.0d))) / getHeight();
            PointF pointF = TAG_POS[TAG_POS.length - 1];
            pointF.set(pointF.x, height4);
            TextView textView = this.mAddTagTips;
            if (textView != null && (layoutParams = (RatioLayout.LayoutParams) textView.getLayoutParams()) != null) {
                layoutParams.f316151b = height4;
                this.mAddTagTips.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // uy2.a.InterfaceC11376a
    public void onMove(a.b bVar, float f16, float f17) {
        RatioLayout ratioLayout = this.mTagCloudLayout;
        int[] iArr = this.mOffsetOnScreen;
        ratioLayout.a((View) bVar, ((int) f16) - iArr[0], ((int) f17) - iArr[1]);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        Card card;
        super.onResume();
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null) {
            super.updateAvatarPendantImage(profileCardInfo, false);
            ProfileCardInfo profileCardInfo2 = this.mCardInfo;
            if (profileCardInfo2.allInOne.f260789pa == 0 && (card = profileCardInfo2.card) != null) {
                int i3 = this.mColorScheme;
                long j3 = card.backgroundColor;
                if (i3 != ((int) j3)) {
                    setColorScheme((int) j3);
                }
            }
        }
        View view = this.mHeaderChildMap.get("map_key_like");
        if ((view instanceof VoteView) || (view instanceof VoteViewV2)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.bottomMargin = ScreenUtil.dip2px(15.0f);
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (!this.mIsScrolled && this.mOnClickListener != null) {
                this.mTagCloudLayout.setTag(new b(29, null));
                this.mOnClickListener.onClick(this.mTagCloudLayout);
                return true;
            }
            this.mIsScrolled = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        super.updateAvatar(profileCardInfo.allInOne);
        super.updateSexAgeArea(profileCardInfo);
        super.updateHead(profileCardInfo);
        updateLikeArea(profileCardInfo);
        if (this.mIsFullAnimPlaying) {
            this.mTagCloudNeedUpdate = true;
        } else {
            updateTagCloud(profileCardInfo);
        }
        super.updateAvatarPendantImage(profileCardInfo, false);
    }

    protected boolean scrollAnimation(float f16) {
        if (Math.abs(f16) > this.mDistanceThreshold) {
            if (f16 > 0.0f && this.isFullScreen) {
                if (switchScreenMode()) {
                    tagsGather();
                    this.mBreatheView.f(null);
                    return true;
                }
                return true;
            }
            if (f16 < 0.0f && !this.isFullScreen) {
                switchScreenMode();
                return true;
            }
            return true;
        }
        return false;
    }

    void setColorScheme(int i3) {
        int i16;
        int i17;
        this.mColorScheme = i3;
        TextView textView = this.mAddTagTips;
        int i18 = -1;
        if (2 == i3) {
            i16 = -1;
        } else {
            i16 = -16777216;
        }
        textView.setTextColor(i16);
        ProfileNameView profileNameView = this.mNickLabel;
        if (2 == i3) {
            i17 = -1;
        } else {
            i17 = -16777216;
        }
        profileNameView.setTextColor(i17);
        TextView textView2 = this.mBasicInfoLabel;
        if (2 != i3) {
            i18 = -16777216;
        }
        textView2.setTextColor(i18);
    }

    public void setFromExtendFriend(boolean z16) {
        this.mFromExtendFriend = z16;
    }

    public void setProfileArgs(IComponentCenter iComponentCenter, IProfileActivityDelegate iProfileActivityDelegate) {
        this.mComponentCenter = iComponentCenter;
        this.mDelegate = iProfileActivityDelegate;
    }

    boolean switchScreenMode() {
        ValueAnimator enterFullScreen;
        if (this.mIsFullAnimPlaying) {
            return false;
        }
        if (this.mFromExtendFriend && !this.mIsScrollByExtendFriend) {
            this.mIsScrollByExtendFriend = true;
            return false;
        }
        this.mIsFullAnimPlaying = true;
        if (this.isFullScreen) {
            enterFullScreen = exitFullScreen();
        } else {
            if (this.mFullScreenHeight == 0 && this.mActivity.findViewById(R.id.content) == null) {
                return false;
            }
            enterFullScreen = enterFullScreen();
        }
        this.isFullScreen = !this.isFullScreen;
        if (enterFullScreen != null) {
            enterFullScreen.setDuration(500L);
            enterFullScreen.setInterpolator(new AccelerateDecelerateInterpolator());
            enterFullScreen.removeListener(this);
            enterFullScreen.removeAllUpdateListeners();
            enterFullScreen.addListener(this);
            enterFullScreen.addUpdateListener(this.mSwitchScreenUpdateListener);
            enterFullScreen.start();
        }
        return true;
    }

    public void tagsDiffuse() {
        this.mTagAnimCount = 0;
        int i3 = 0;
        for (final View view : this.mTagViews) {
            if (view != null && view.getVisibility() != 8) {
                Integer num = (Integer) view.getTag(com.tencent.mobileqq.R.id.h7o);
                if (num != null) {
                    final PointF pointF = TAG_POS[num.intValue()];
                    this.mTagAnimCount++;
                    ValueAnimator[] valueAnimatorArr = this.mDiffuseAnims;
                    ValueAnimator valueAnimator = valueAnimatorArr[i3];
                    if (valueAnimator == null) {
                        valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
                        valueAnimatorArr[i3] = valueAnimator;
                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.10
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                                Float f16 = (Float) valueAnimator2.getAnimatedValue();
                                view.setScaleX(f16.floatValue());
                                view.setScaleY(f16.floatValue());
                                float width = (pointF.x - VasProfileTagView.this.mPhotoFullPos.x) * VasProfileTagView.this.mTagCloudLayout.getWidth();
                                float height = (pointF.y - VasProfileTagView.this.mPhotoFullPos.y) * VasProfileTagView.this.mTagCloudLayout.getHeight();
                                view.setTranslationX(width * f16.floatValue());
                                view.setTranslationY(height * f16.floatValue());
                                view.setRotation((f16.floatValue() * 120.0f) - 120.0f);
                            }
                        });
                        valueAnimator.setInterpolator(new DecelerateInterpolator());
                        addAnimationListener(view, pointF, valueAnimator);
                        valueAnimator.setDuration(600L);
                    }
                    view.setVisibility(0);
                    valueAnimator.start();
                }
            }
            i3++;
        }
        if (this.mTagAnimCount == 0) {
            this.mIsFullAnimPlaying = false;
            if (this.mIsFirstAnimation) {
                updateJueban(this.mCardInfo);
                this.mIsFirstAnimation = false;
            }
        }
    }

    public void tagsGather() {
        this.mTagAnimCount = 0;
        int i3 = 0;
        for (final View view : this.mTagViews) {
            if (view != null && view.getVisibility() == 0) {
                if (view instanceof VipTagView) {
                    ((VipTagView) view).setShakingState(false);
                }
                Integer num = (Integer) view.getTag(com.tencent.mobileqq.R.id.h7o);
                if (num != null) {
                    final PointF pointF = TAG_POS[num.intValue()];
                    RatioLayout.LayoutParams layoutParams = (RatioLayout.LayoutParams) view.getLayoutParams();
                    if (layoutParams != null) {
                        PointF pointF2 = this.mPhotoInitPos;
                        layoutParams.f316150a = pointF2.x;
                        layoutParams.f316151b = pointF2.y;
                        view.setLayoutParams(layoutParams);
                    }
                    this.mTagAnimCount++;
                    ValueAnimator[] valueAnimatorArr = this.mGatherAnims;
                    ValueAnimator valueAnimator = valueAnimatorArr[i3];
                    if (valueAnimator == null) {
                        valueAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
                        valueAnimatorArr[i3] = valueAnimator;
                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.12
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                                Float f16 = (Float) valueAnimator2.getAnimatedValue();
                                view.setScaleX(f16.floatValue());
                                view.setScaleY(f16.floatValue());
                                float width = (pointF.x - VasProfileTagView.this.mPhotoInitPos.x) * VasProfileTagView.this.mTagCloudLayout.getWidth();
                                float height = (pointF.y - VasProfileTagView.this.mPhotoInitPos.y) * VasProfileTagView.this.mTagCloudLayout.getHeight();
                                view.setTranslationX(width * f16.floatValue());
                                view.setTranslationY(height * f16.floatValue());
                                view.setRotation((f16.floatValue() * 120.0f) - 120.0f);
                            }
                        });
                        valueAnimator.setInterpolator(new AccelerateInterpolator());
                        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.13
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                VasProfileTagView vasProfileTagView = VasProfileTagView.this;
                                vasProfileTagView.mTagAnimCount--;
                                view.setVisibility(4);
                                view.setTranslationX(0.0f);
                                view.setTranslationY(0.0f);
                                VasProfileTagView.this.mIsFullAnimPlaying = false;
                                if (VasProfileTagView.this.mTagAnimCount == 0) {
                                    VasProfileTagView.this.checkTagUpdateFlag();
                                }
                                VasProfileTagView vasProfileTagView2 = VasProfileTagView.this;
                                vasProfileTagView2.loadColorScreen(vasProfileTagView2.mComponentCenter);
                            }
                        });
                        valueAnimator.setDuration(600L);
                    }
                    this.mAddTagTips.setVisibility(4);
                    valueAnimator.start();
                }
            }
            i3++;
        }
        if (this.mTagAnimCount == 0) {
            this.mIsFullAnimPlaying = false;
            loadColorScreen(this.mComponentCenter);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateTagCloud(final ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateTagCloud");
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.2
            @Override // java.lang.Runnable
            public void run() {
                final List<ProfileLabelInfo> labelList = profileCardInfo.card.getLabelList();
                ((AbsProfileHeaderView) VasProfileTagView.this).mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int size;
                        if (labelList != null) {
                            int length = VasProfileTagView.TAG_POS.length - 1;
                            if (labelList.size() >= length) {
                                size = length;
                            } else {
                                size = labelList.size();
                            }
                            VasProfileTagView vasProfileTagView = VasProfileTagView.this;
                            if (vasProfileTagView.isFullScreen && !vasProfileTagView.mIsFullAnimPlaying && VasProfileTagView.this.mTagViews[length] != null && size == 0) {
                                VasProfileTagView.this.mAddTagTips.setVisibility(0);
                            } else {
                                VasProfileTagView.this.mAddTagTips.setVisibility(4);
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (profileCardInfo.allInOne.f260789pa == 0 && VasProfileTagView.this.mTagViews[length] == null) {
                                View[] viewArr = VasProfileTagView.this.mTagViews;
                                View inflate = View.inflate(VasProfileTagView.this.getContext(), com.tencent.mobileqq.R.layout.bfo, null);
                                viewArr[length] = inflate;
                                VasProfileTagView.this.mTagCloudLayout.addView(inflate, new RatioLayout.LayoutParams(-2, -2, 0.5f, 0.5f, 0.5f, 0.5f));
                                inflate.setVisibility(4);
                                inflate.setTag(new b(32, null));
                                inflate.setOnClickListener(((AbsProfileHeaderView) VasProfileTagView.this).mOnClickListener);
                                inflate.setId(com.tencent.mobileqq.R.id.h7m);
                                inflate.setTag(com.tencent.mobileqq.R.id.h7m, -1);
                                inflate.setTag(com.tencent.mobileqq.R.id.h7o, Integer.valueOf(VasProfileTagView.TAG_POS.length - 1));
                            }
                            VasProfileTagView.this.hideOldProcileTag(length);
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            VasProfileTagView.this.addProfileTag(size, labelList, profileCardInfo);
                        }
                        AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                        VasProfileTagView.this.setColorScheme((int) profileCardInfo.card.backgroundColor);
                    }
                });
            }
        }, 8, null, true);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View childAt;
        if (animator == null) {
            return;
        }
        if (animator == this.mAnimEnterFullScreen) {
            this.mBreatheView.i(this.aniEndBreatheListener);
        } else {
            FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(R.id.content);
            if (frameLayout != null && frameLayout.getChildCount() > 0 && (childAt = frameLayout.getChildAt(0)) != null) {
                this.mBlurBackground = childAt.getBackground();
                childAt.setBackgroundDrawable(null);
            }
        }
        this.mTagCloudLayout.setSkipMeasure(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
