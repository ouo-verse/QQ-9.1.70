package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDFooterView extends FrameLayout {
    private LinearLayout mContentContainer;
    private int mImageVisibility;
    private ImageView mLeftImage;
    private TextView mRightText;
    private int mTextVisibility;

    public HippyTKDFooterView(@NonNull Context context) {
        super(context);
        this.mImageVisibility = 0;
        this.mTextVisibility = 0;
        LinearLayout linearLayout = new LinearLayout(context);
        this.mContentContainer = linearLayout;
        linearLayout.setOrientation(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.mContentContainer, layoutParams);
        this.mLeftImage = new ImageView(context);
        this.mContentContainer.addView(this.mLeftImage, new LinearLayout.LayoutParams(-2, -2));
        this.mRightText = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = ImmersiveUtils.dpToPx(8.0f);
        this.mContentContainer.addView(this.mRightText, layoutParams2);
    }

    private void changeVisibility(int i3, int i16) {
        int i17 = i16 ^ i3;
        if (i17 == 0) {
            return;
        }
        if (i3 == 0 || (i17 & 4) != 0) {
            invalidate();
        }
        if ((i17 & 8) != 0) {
            requestLayout();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        this.mLeftImage.setBackgroundDrawable(drawable);
    }

    public void setImageVisibility(int i3) {
        int i16 = this.mImageVisibility;
        this.mImageVisibility = i3;
        changeVisibility(i3, i16);
    }

    public void setText(String str) {
        this.mRightText.setText(str);
    }

    public void setTextColor(int i3) {
        this.mRightText.setTextColor(i3);
    }

    public void setTextMargins(int i3, int i16, int i17, int i18) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRightText.getLayoutParams();
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i16;
        layoutParams.rightMargin = i17;
        layoutParams.bottomMargin = i18;
        this.mRightText.setLayoutParams(layoutParams);
        requestLayout();
    }

    public void setTextSize(int i3) {
        this.mRightText.setTextSize(i3);
    }

    public void setTextVisisbility(int i3) {
        int i16 = this.mTextVisibility;
        this.mTextVisibility = i3;
        changeVisibility(i3, i16);
    }
}
