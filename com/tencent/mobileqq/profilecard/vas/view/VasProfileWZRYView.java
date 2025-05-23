package com.tencent.mobileqq.profilecard.vas.view;

import SummaryCardTaf.summaryCardWzryInfo;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.ApngImage;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profile.o;
import com.tencent.mobileqq.profile.p;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class VasProfileWZRYView extends AbsProfileHeaderView {
    private static final String NUMBER_PLACE_HOLDER = "[num]";
    private static final int WZRY_HEADER_HEIGHT = 160;
    private ImageView mAddIcon;
    private View mBlankView;
    private HorizontalScrollView mGameInfoLayout;
    private ShimmerLinearLayout mGameInfoShimmerLayout;
    private LayoutInflater mInflater;
    private ImageView mLogo;
    private ImageView mLogoBg;
    private float mOldScreenHeight;
    private int mOriginalBlankViewHeight;

    /* loaded from: classes16.dex */
    public static class CustomTypefaceSpan extends TypefaceSpan {
        Typeface mTypeface;

        public CustomTypefaceSpan(String str, Typeface typeface) {
            super(str);
            this.mTypeface = typeface;
        }

        private void apply(Paint paint, Typeface typeface) {
            int style;
            Typeface typeface2 = paint.getTypeface();
            if (typeface2 == null) {
                style = 0;
            } else {
                style = typeface2.getStyle();
            }
            int i3 = style & (~typeface.getStyle());
            if ((i3 & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((i3 & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(typeface);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Typeface typeface = this.mTypeface;
            if (typeface != null) {
                apply(textPaint, typeface);
            } else {
                super.updateDrawState(textPaint);
            }
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            Typeface typeface = this.mTypeface;
            if (typeface != null) {
                apply(textPaint, typeface);
            } else {
                super.updateMeasureState(textPaint);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static class VerticalCenterTextSpan extends ReplacementSpan {
        private float fontSize;
        private float offset;

        public VerticalCenterTextSpan(float f16, float f17) {
            this.fontSize = f16;
            this.offset = f17;
        }

        private TextPaint getCustomTextPaint(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.fontSize);
            return textPaint;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
            CharSequence subSequence = charSequence.subSequence(i3, i16);
            TextPaint customTextPaint = getCustomTextPaint(paint);
            Paint.FontMetricsInt fontMetricsInt = customTextPaint.getFontMetricsInt();
            float f17 = ((((fontMetricsInt.top + i18) + i18) + fontMetricsInt.bottom) / 2) - ((i19 + i17) / 2);
            float f18 = this.offset;
            if (f18 != 0.0f) {
                f17 = f18;
            }
            canvas.drawText(subSequence.toString(), f16, i18 - f17, customTextPaint);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
            return (int) getCustomTextPaint(paint).measureText(charSequence.subSequence(i3, i16).toString());
        }
    }

    public VasProfileWZRYView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo) {
        super(qBaseActivity, profileCardInfo);
        this.mInflater = null;
        this.mOldScreenHeight = 0.0f;
    }

    private void addHonorView(ProfileCardInfo profileCardInfo, List<summaryCardWzryInfo> list, LinearLayout.LayoutParams layoutParams, o oVar, int i3, int i16, ColorStateList colorStateList, ColorStateList colorStateList2) {
        o oVar2;
        String[] strArr;
        boolean z16;
        String str;
        String str2;
        for (summaryCardWzryInfo summarycardwzryinfo : list) {
            if (QLog.isColorLevel()) {
                QLog.d(AbsProfileHeaderView.TAG, 4, "honor data: id=" + summarycardwzryinfo.honorId + ", record=" + summarycardwzryinfo.strRecord);
            }
            if (!TextUtils.isEmpty(summarycardwzryinfo.strRecord)) {
                oVar2 = oVar;
                strArr = summarycardwzryinfo.strRecord.split("_");
            } else {
                oVar2 = oVar;
                strArr = null;
            }
            o.a aVar = oVar2.f260269a.get(summarycardwzryinfo.honorId);
            if (aVar != null) {
                View inflate = this.mInflater.inflate(R.layout.f168968bf4, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.l5z);
                TextView textView = (TextView) inflate.findViewById(R.id.f167134l61);
                TextView textView2 = (TextView) inflate.findViewById(R.id.f167133l60);
                Typeface typeface = ProfileCardTemplate.wzryTTFChn;
                if (typeface != null) {
                    textView.setTypeface(typeface);
                    textView2.setTypeface(ProfileCardTemplate.wzryTTFChn);
                }
                if (aVar.f260273d == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    str = aVar.f260272c;
                } else {
                    str = aVar.f260271b;
                }
                if (z16) {
                    str2 = aVar.f260271b;
                } else {
                    str2 = aVar.f260272c;
                }
                String[] strArr2 = strArr;
                textView.setText(getSpannableString(str, strArr2, calcTopNumTextSize(textView, i16, str, strArr), 0.0f, colorStateList2));
                textView2.setText(getSpannableString(str2, strArr2, i3, textView2.getTextSize(), colorStateList));
                o.b bVar = aVar.f260274e;
                if (bVar != null && !TextUtils.isEmpty(bVar.f260275a)) {
                    imageView.setVisibility(0);
                    textView.setVisibility(8);
                    String str3 = aVar.f260274e.f260275a;
                    if (str3.contains("/")) {
                        str3 = str3.substring(str3.lastIndexOf("/"));
                    }
                    String str4 = p.c() + str3;
                    ProfileCardTemplate profileCardTemplate = profileCardInfo.currentTemplate;
                    if (profileCardTemplate != null) {
                        imageView.setImageDrawable(this.templateUtils.getTemplateDrawable(profileCardTemplate, true, true, str4));
                    }
                } else {
                    imageView.setVisibility(8);
                    textView.setVisibility(0);
                }
                this.mGameInfoShimmerLayout.addView(inflate, layoutParams);
            }
        }
    }

    private View initMainView() {
        LayoutInflater from = LayoutInflater.from(getContext());
        this.mInflater = from;
        return from.inflate(R.layout.f168967bf3, (ViewGroup) this, true);
    }

    private void prepareForEnterAnimation() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158856qt);
        int B = ProfileCardUtil.B(getResources());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBlankView.getLayoutParams();
        layoutParams.height = ((((int) this.mScreenHeight) - ProfileCardUtil.i(this.mActivity, 160)) - dimensionPixelSize) - B;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            layoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "rl.height: " + layoutParams.height);
        }
        this.mOriginalBlankViewHeight = layoutParams.height;
        this.mBlankView.setLayoutParams(layoutParams);
        this.mBlankView.setFocusable(true);
        this.mBlankView.setFocusableInTouchMode(true);
    }

    private void updateAvatarArea(ProfileCardInfo profileCardInfo, View view) {
        String string;
        AvatarLayout avatarLayout = (AvatarLayout) view.findViewById(R.id.l5r);
        avatarLayout.setVisibility(0);
        b bVar = new b(1, null);
        avatarLayout.setTag(bVar);
        avatarLayout.setOnClickListener(this.mOnClickListener);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            string = getContext().getString(R.string.abp);
        } else {
            string = getContext().getString(R.string.abo);
        }
        avatarLayout.setContentDescription(string);
        avatarLayout.d(0, avatarLayout.findViewById(R.id.a6e), false);
        this.mHeaderChildMap.put("map_key_face", avatarLayout);
        super.updateAvatar(profileCardInfo.allInOne);
        ImageView imageView = (ImageView) view.findViewById(R.id.l5p);
        imageView.setVisibility(4);
        imageView.setOnClickListener(this.mOnClickListener);
        imageView.setTag(bVar);
        imageView.setContentDescription(string);
        AccessibilityUtil.n(imageView, false);
        this.mHeaderChildMap.put("map_key_avatar_pendant", imageView);
        super.updateAvatarPendantImage(profileCardInfo, true);
    }

    private void updateBaseInfoArea(ProfileCardInfo profileCardInfo, View view) {
        this.mHeaderChildMap.put("map_key_sex_age_area", (TextView) view.findViewById(R.id.l5v));
        super.updateSexAgeArea(profileCardInfo);
    }

    private void updateHeadArea(ProfileCardInfo profileCardInfo, View view) {
        ProfileNameView profileNameView = (ProfileNameView) view.findViewById(R.id.l5t);
        profileNameView.setVisibility(0);
        profileNameView.setClickable(true);
        profileNameView.setClickListener(this.mOnClickListener);
        this.mHeaderChildMap.put("map_key_profile_nick_name", profileNameView);
        super.updateHead(profileCardInfo);
    }

    private void updateLikeArea(ProfileCardInfo profileCardInfo, View view) {
        HeartLayout heartLayout = (HeartLayout) view.findViewById(R.id.l5n);
        heartLayout.setEnabled(false);
        VoteView voteView = (VoteView) view.findViewById(R.id.f167136l63);
        voteView.setHeartLayout(this.mApp, heartLayout);
        this.mHeaderChildMap.put("map_key_like", voteView);
        super.updateLike(profileCardInfo);
    }

    private void updateLogoArea(ProfileCardInfo profileCardInfo, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.l5w);
        this.mLogo = imageView;
        this.templateUtils.updateViewAttr(imageView, "apngDrawable", profileCardInfo.currentTemplate, "wzryLogo");
        ApngImage.playByTag(7);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.l5x);
        this.mLogoBg = imageView2;
        this.templateUtils.updateViewAttr(imageView2, "background", profileCardInfo.currentTemplate, "wzryLogoBg");
    }

    int calcTopNumTextSize(TextView textView, int i3, String str, String[] strArr) {
        TextPaint textPaint = new TextPaint(textView.getPaint());
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (str.endsWith(NUMBER_PLACE_HOLDER)) {
                str = str + "\r\n";
            }
            int length = str.split("\\[num\\]").length - 1;
            if (length > strArr.length) {
                length = strArr.length;
            }
            if (length > 0) {
                int i16 = 0;
                String str2 = "";
                for (int i17 = 0; i17 < length; i17++) {
                    i16 += strArr[i17].length();
                    str2 = str2 + strArr[i17];
                }
                if (i16 > 0) {
                    String replace = str.replace(NUMBER_PLACE_HOLDER, "");
                    for (int i18 = 0; i18 < i16 - 1; i18++) {
                        replace = replace + "\u00a0";
                    }
                    float measureText = i3 - textPaint.measureText(replace);
                    for (float f16 = measureText; f16 > 0.0f; f16 -= 1.0f) {
                        textPaint.setTextSize(f16);
                        if (textPaint.measureText(str2) < measureText) {
                            int i19 = i3 / 2;
                            if (f16 > i19) {
                                return i19;
                            }
                            return (int) f16;
                        }
                    }
                }
            }
        }
        return 0;
    }

    void generateLogoAnimation() {
        this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView.2
            @Override // java.lang.Runnable
            @TargetApi(11)
            public void run() {
                VasProfileWZRYView.this.mLogo.setVisibility(0);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogo, BasicAnimation.KeyPath.SCALE_X, 3.5f, 0.9f), ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogo, BasicAnimation.KeyPath.SCALE_Y, 3.5f, 0.9f));
                animatorSet.setDuration(150L);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogo, BasicAnimation.KeyPath.SCALE_X, 0.9f, 1.1f), ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogo, BasicAnimation.KeyPath.SCALE_Y, 0.9f, 1.1f));
                animatorSet2.setDuration(100L);
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogo, BasicAnimation.KeyPath.SCALE_X, 1.1f, 1.0f), ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogo, BasicAnimation.KeyPath.SCALE_Y, 1.1f, 1.0f));
                animatorSet3.setDuration(50L);
                AnimatorSet animatorSet4 = new AnimatorSet();
                animatorSet4.playSequentially(animatorSet, animatorSet2, animatorSet3);
                animatorSet4.start();
                VasProfileWZRYView.this.mLogoBg.setVisibility(0);
                AnimatorSet animatorSet5 = new AnimatorSet();
                animatorSet5.playTogether(ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogoBg, BasicAnimation.KeyPath.SCALE_X, 2.0f, 3.0f), ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogoBg, BasicAnimation.KeyPath.SCALE_Y, 2.0f, 3.0f), ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogoBg, c.f123400v, 0.0f, 1.0f));
                animatorSet5.setDuration(50L);
                AnimatorSet animatorSet6 = new AnimatorSet();
                animatorSet6.playTogether(ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogoBg, BasicAnimation.KeyPath.SCALE_X, 3.0f, 0.5f), ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogoBg, BasicAnimation.KeyPath.SCALE_Y, 3.0f, 0.5f));
                animatorSet6.setDuration(100L);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(VasProfileWZRYView.this.mLogoBg, c.f123400v, 1.0f, 0.0f);
                ofFloat.setDuration(100L);
                AnimatorSet animatorSet7 = new AnimatorSet();
                animatorSet7.playSequentially(animatorSet5, animatorSet6, ofFloat);
                animatorSet7.start();
            }
        }, 1000L);
    }

    public SpannableStringBuilder getSpannableString(String str, String[] strArr, int i3, float f16, ColorStateList colorStateList) {
        int i16;
        String str2 = str;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (TextUtils.isEmpty(str)) {
            return spannableStringBuilder;
        }
        if (str2.contains(NUMBER_PLACE_HOLDER)) {
            if (str2.equals(NUMBER_PLACE_HOLDER)) {
                str2 = str2 + "\u00a0";
            } else if (str2.endsWith(NUMBER_PLACE_HOLDER)) {
                str2 = str2 + "\r\n";
            }
            String[] split = str2.split("\\[num\\]");
            for (int i17 = 0; i17 < split.length; i17++) {
                String str3 = split[i17];
                if (i17 != 0 && !"\r\n".equals(str3)) {
                    spannableStringBuilder.append((CharSequence) "\u00a0");
                }
                if (!"\r\n".equals(str3)) {
                    spannableStringBuilder.append((CharSequence) str3);
                }
                if (i17 < split.length - 1) {
                    int length = spannableStringBuilder.length();
                    if (strArr != null && i17 < strArr.length) {
                        i16 = strArr[i17].length() + length;
                        spannableStringBuilder.append((CharSequence) strArr[i17]);
                    } else {
                        i16 = length + 5;
                        spannableStringBuilder.append((CharSequence) NUMBER_PLACE_HOLDER);
                    }
                    if (ProfileCardTemplate.wzryTTFNum != null) {
                        spannableStringBuilder.setSpan(new CustomTypefaceSpan("", ProfileCardTemplate.wzryTTFNum), length, i16, 17);
                    }
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 3, i3, colorStateList, null), length, i16, 17);
                    spannableStringBuilder.setSpan(new VerticalCenterTextSpan(i3, -2.0f), length, i16, 17);
                }
            }
        } else {
            spannableStringBuilder.append((CharSequence) str2);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mOldScreenHeight != this.mScreenHeight) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBlankView.getLayoutParams();
            layoutParams.height = (int) (layoutParams.height + (this.mScreenHeight - this.mOldScreenHeight));
            this.mBlankView.setLayoutParams(layoutParams);
            float f16 = this.mOriginalBlankViewHeight;
            float f17 = this.mScreenHeight;
            this.mOriginalBlankViewHeight = (int) (f16 + (f17 - this.mOldScreenHeight));
            this.mOldScreenHeight = f17;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onDestroy() {
        super.onDestroy();
        QLog.i(AbsProfileHeaderView.TAG, 1, "VipProfileWZRYView.onDestroy");
        ShimmerLinearLayout shimmerLinearLayout = this.mGameInfoShimmerLayout;
        if (shimmerLinearLayout != null) {
            shimmerLinearLayout.e();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onInit(ProfileCardInfo profileCardInfo) {
        String str;
        this.mOldScreenHeight = this.mScreenHeight;
        View initMainView = initMainView();
        updateLogoArea(profileCardInfo, initMainView);
        this.mBlankView = initMainView.findViewById(R.id.l5q);
        this.mGameInfoShimmerLayout = (ShimmerLinearLayout) initMainView.findViewById(R.id.l5l);
        this.mAddIcon = (ImageView) initMainView.findViewById(R.id.l5i);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) initMainView.findViewById(R.id.l5m);
        this.mGameInfoLayout = horizontalScrollView;
        this.templateUtils.updateViewAttr(horizontalScrollView, "background", profileCardInfo.currentTemplate, "wzryGameInfoBackground");
        prepareForEnterAnimation();
        updateAvatarArea(profileCardInfo, initMainView);
        updateHeadArea(profileCardInfo, initMainView);
        updateBaseInfoArea(profileCardInfo, initMainView);
        updateLikeArea(profileCardInfo, initMainView);
        updateGameInfo(profileCardInfo);
        super.onInit(profileCardInfo);
        super.updateJueban(profileCardInfo);
        generateLogoAnimation();
        if (this.mApp.getCurrentAccountUin().equals(profileCardInfo.allInOne.uin)) {
            str = "PV_owner";
        } else {
            str = "PV_visitor";
        }
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", str, "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(profileCardInfo.card.lCurrentBgId), String.valueOf(profileCardInfo.card.lCurrentStyleId));
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onPause() {
        super.onPause();
        this.mGameInfoShimmerLayout.i();
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onResume() {
        super.onResume();
        ApngImage.playByTag(7);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        super.updateLike(profileCardInfo);
        super.updateHead(profileCardInfo);
        super.updateSexAgeArea(profileCardInfo);
        super.updateAvatarPendantImage(profileCardInfo, false);
        updateGameInfo(profileCardInfo);
    }

    public void updateGameInfo(final ProfileCardInfo profileCardInfo) {
        this.mGameInfoShimmerLayout.i();
        this.mGameInfoShimmerLayout.removeAllViews();
        ArrayList<summaryCardWzryInfo> wzryHonorInfo = profileCardInfo.card.getWzryHonorInfo();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBlankView.getLayoutParams();
        if (wzryHonorInfo.isEmpty()) {
            this.mGameInfoLayout.setVisibility(8);
            layoutParams.height = this.mOriginalBlankViewHeight - ProfileCardUtil.i(this.mActivity, 67);
            return;
        }
        this.mGameInfoLayout.setVisibility(0);
        layoutParams.height = this.mOriginalBlankViewHeight - ProfileCardUtil.i(this.mActivity, 132);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, x.c(getContext(), 5.0f), 0);
        o oVar = o.f260268b;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b2m);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.b2o);
        ColorStateList colorStateList = getResources().getColorStateList(R.color.alm);
        ColorStateList colorStateList2 = getResources().getColorStateList(R.color.alo);
        if (oVar != null) {
            addHonorView(profileCardInfo, wzryHonorInfo, layoutParams2, oVar, dimensionPixelSize, dimensionPixelSize2, colorStateList, colorStateList2);
        }
        AllInOne allInOne = profileCardInfo.allInOne;
        if (allInOne.f260789pa == 0 || allInOne.uin.equals(this.mApp.getCurrentAccountUin())) {
            this.mAddIcon.setVisibility(0);
            this.templateUtils.updateViewAttr(this.mAddIcon, "background", profileCardInfo.currentTemplate, "addIcon");
            this.mAddIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    VasWebviewUtil.openQQBrowserWithoutAD(((AbsProfileHeaderView) VasProfileWZRYView.this).mActivity, IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.CARD_WZRY_MADE), -1L, null, false, -1);
                    VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_into", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(profileCardInfo.card.lCurrentBgId), String.valueOf(profileCardInfo.card.lCurrentStyleId));
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
        ShimmerLinearLayout shimmerLinearLayout = this.mGameInfoShimmerLayout;
        if (shimmerLinearLayout.f260433i == null) {
            this.templateUtils.updateViewAttr(shimmerLinearLayout, "shimmer_mask", profileCardInfo.currentTemplate, "wzryShimmer");
        }
        this.mGameInfoShimmerLayout.h();
    }
}
