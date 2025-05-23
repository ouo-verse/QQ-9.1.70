package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.FriendBirthdayGift;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import cooperation.qzone.util.WnsError;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedFriendBirthdayGiftView extends RelativeLayout implements Animation.AnimationListener {
    int mContainerPosition;
    FriendBirthdayGift mGiftData;
    ImageView mGiftImage;
    TextView mGiftName;
    int mMagic;
    OnSendGiftListener mOnSendGiftListener;
    ImageView mSendGiftImage;
    TextView mSendGiftName;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnSendGiftListener {
        void onSending(View view);
    }

    public FeedFriendBirthdayGiftView(Context context) {
        this(context, null);
    }

    public boolean checkMagic(int i3) {
        return this.mMagic == i3;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView = this.mGiftName;
        if (textView != null) {
            textView.clearAnimation();
            this.mGiftName.setVisibility(8);
        }
        ImageView imageView = this.mGiftImage;
        if (imageView != null) {
            imageView.clearAnimation();
            this.mGiftImage.setVisibility(8);
        }
        TextView textView2 = this.mSendGiftName;
        if (textView2 != null) {
            textView2.clearAnimation();
            this.mSendGiftName.setVisibility(0);
        }
        ImageView imageView2 = this.mSendGiftImage;
        if (imageView2 != null) {
            imageView2.clearAnimation();
            this.mSendGiftImage.setVisibility(0);
        }
        setEnabled(false);
    }

    public void onSendGift() {
        startAnimation();
    }

    public void onSendGiftFailed() {
        ImageView imageView;
        if (this.mGiftName == null || (imageView = this.mGiftImage) == null || this.mSendGiftName == null || this.mSendGiftImage == null) {
            return;
        }
        if (imageView.getVisibility() == 0 && this.mSendGiftImage.getVisibility() == 0) {
            this.mGiftName.clearAnimation();
            this.mGiftImage.clearAnimation();
            this.mSendGiftName.clearAnimation();
            this.mSendGiftImage.clearAnimation();
        }
        postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedFriendBirthdayGiftView.1
            @Override // java.lang.Runnable
            public void run() {
                FeedFriendBirthdayGiftView.this.onUpdate();
            }
        }, 300L);
    }

    public void onSendingGift() {
        onSendGift();
        OnSendGiftListener onSendGiftListener = this.mOnSendGiftListener;
        if (onSendGiftListener != null) {
            onSendGiftListener.onSending(this);
        }
    }

    public void onUpdate() {
        FriendBirthdayGift friendBirthdayGift = this.mGiftData;
        if (friendBirthdayGift == null) {
            return;
        }
        TextView textView = this.mGiftName;
        if (textView != null) {
            if (friendBirthdayGift.hasSent) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            setContainerPosition(this.mGiftName, this.mContainerPosition);
        }
        ImageView imageView = this.mGiftImage;
        if (imageView != null) {
            if (this.mGiftData.hasSent) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            setContainerPosition(this.mGiftImage, this.mContainerPosition);
        }
        TextView textView2 = this.mSendGiftName;
        if (textView2 != null) {
            if (this.mGiftData.hasSent) {
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            setContainerPosition(this.mSendGiftName, this.mContainerPosition);
        }
        ImageView imageView2 = this.mSendGiftImage;
        if (imageView2 != null) {
            if (this.mGiftData.hasSent) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            setContainerPosition(this.mSendGiftImage, this.mContainerPosition);
        }
        if (this.mGiftData.hasSent) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    void setContainerPosition(View view, int i3) {
        if (view != null) {
            view.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
        }
    }

    public void setGiftData(FriendBirthdayGift friendBirthdayGift) {
        this.mGiftData = friendBirthdayGift;
    }

    public void setGiftImage(Drawable drawable) {
        ImageView imageView = this.mGiftImage;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setGiftName(String str) {
        TextView textView = this.mGiftName;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setMagic(int i3) {
        this.mMagic = i3;
    }

    public void setOnSendGiftListener(OnSendGiftListener onSendGiftListener) {
        this.mOnSendGiftListener = onSendGiftListener;
    }

    public FeedFriendBirthdayGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContainerPosition = -1;
        View.inflate(context, com.qzone.adapter.feedcomponent.j.j(1670), this);
        this.mGiftName = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2398));
        this.mGiftImage = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2399));
        this.mSendGiftName = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(WnsError.WNS_CODE_DIS_STAT_BEGIN));
        this.mSendGiftImage = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_GROUP_ESSENCE_MSG_TIP));
    }

    public void setContainerPosition(int i3) {
        this.mContainerPosition = i3;
        setContainerPosition(this, i3);
    }

    public void startAnimation() {
        FriendBirthdayGift friendBirthdayGift = this.mGiftData;
        if (friendBirthdayGift == null || friendBirthdayGift.moreflag != 0 || this.mSendGiftName == null || this.mSendGiftImage == null || this.mGiftName == null || this.mGiftImage == null) {
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setFillAfter(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);
        AnimationSet animationSet2 = new AnimationSet(true);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(300L);
        alphaAnimation2.setFillAfter(true);
        animationSet2.addAnimation(alphaAnimation2);
        animationSet2.setAnimationListener(this);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        scaleAnimation2.setFillAfter(true);
        animationSet2.addAnimation(scaleAnimation2);
        animationSet2.setFillAfter(true);
        this.mGiftName.startAnimation(alphaAnimation);
        this.mGiftImage.startAnimation(animationSet);
        this.mSendGiftName.startAnimation(alphaAnimation2);
        this.mSendGiftImage.startAnimation(animationSet2);
        this.mSendGiftName.setVisibility(0);
        this.mSendGiftImage.setVisibility(0);
        setEnabled(false);
    }

    void setAlpha(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    public void onSendGiftSuccess() {
    }
}
