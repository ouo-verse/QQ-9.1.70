package com.tencent.mobileqq.profilecard.view.zplan;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ZPlanProfileAvatarUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import ni3.a;

/* loaded from: classes35.dex */
public class ZplanProfileMaintainingLayout extends FrameLayout {
    private static final int MAINTAINING_IMAGE_HEAD_TOP_OFFSET = 240;
    private static final int MAINTAINING_IMAGE_HEIGHT = 1920;
    private static final float MAINTAINING_IMAGE_SCALE = 1.0f;
    private static final int MAINTAINING_IMAGE_SHOULDER_OFFSET = 800;
    private static final int MAINTAINING_IMAGE_WIDTH = 1500;
    private static final String SERVER_UNAVAILABLE_BG = "https://image.superqqshow.qq.com/qq/downqq/zplan_stop_serving_back.png";
    private static final String TAG = "ZplanProfileMaintainingLayout";
    private ImageView background;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    private ImageView maintainingAvatar;

    public ZplanProfileMaintainingLayout(Context context) {
        super(context);
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.h18, this);
        ImageView imageView = (ImageView) findViewById(R.id.f126137ny);
        this.background = imageView;
        imageView.setImageDrawable(ZPlanProfileAvatarUtils.getDrawable(SERVER_UNAVAILABLE_BG, false));
        ImageView imageView2 = (ImageView) findViewById(R.id.f126577p5);
        this.maintainingAvatar = imageView2;
        imageView2.setImageDrawable(new ColorDrawable(0));
        scaleAndTranslateAvatar(this.maintainingAvatar);
    }

    public void setMaintainingAvatarDrawable(ProfileCardInfo profileCardInfo) {
        if (this.maintainingAvatar == null || profileCardInfo == null || this.background == null || profileCardInfo.card == null) {
            return;
        }
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        this.maintainingAvatar.setVisibility(0);
        this.maintainingAvatar.setImageDrawable(ZPlanProfileAvatarUtils.getDrawable(ZPlanProfileAvatarUtils.getDefaultUrl(profileCardInfo, true, isNowThemeIsNight), false));
    }

    public ZplanProfileMaintainingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    private void scaleAndTranslateAvatar(final View view) {
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width != 0 && height != 0) {
            scaleAndTranslateForMaintaining(view);
        } else if (this.mOnPreDrawListener == null) {
            this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mobileqq.profilecard.view.zplan.ZplanProfileMaintainingLayout.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (view.getWidth() == 0 || view.getHeight() == 0) {
                        return true;
                    }
                    ZplanProfileMaintainingLayout.this.scaleAndTranslateForMaintaining(view);
                    view.getViewTreeObserver().removeOnPreDrawListener(ZplanProfileMaintainingLayout.this.mOnPreDrawListener);
                    ZplanProfileMaintainingLayout.this.mOnPreDrawListener = null;
                    return true;
                }
            };
            view.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleAndTranslateForMaintaining(View view) {
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        float height = view.getHeight();
        float min = Math.min(width / 1500.0f, height / 1920.0f) * 1.0f;
        float f16 = (height - (1920.0f * min)) / 2.0f;
        float f17 = (240.0f * min) + f16;
        float f18 = f16 + (min * 800.0f);
        if (a.f420201a.e() == null) {
            QLog.e(TAG, 1, "scaleAndTranslateForMaintaining failed, initHeight null.");
            return;
        }
        float intValue = r0.intValue() - f18;
        if (intValue + f17 < 0.0f) {
            intValue = -f17;
        }
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationY(intValue);
    }

    public ZplanProfileMaintainingLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initUI(context);
    }
}
