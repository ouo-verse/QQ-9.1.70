package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppDialog extends ReportDialog {
    private static final int mAnimationDuration = 200;
    private View mContentView;
    private boolean mIsAnimating;
    private OnBottomSheetShowListener mOnBottomSheetShowListener;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnBottomSheetShowListener {
        void onShow();
    }

    public MiniAppDialog(@NonNull Context context) {
        super(context, R.style.mini_sdk_BottomSheet);
        this.mIsAnimating = false;
    }

    private void animateDown() {
        if (this.mContentView == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new DecelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.qqmini.sdk.ui.MiniAppDialog.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MiniAppDialog.this.mIsAnimating = false;
                MiniAppDialog.this.mContentView.post(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.MiniAppDialog.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            MiniAppDialog.super.dismiss();
                        } catch (Exception unused) {
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MiniAppDialog.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mContentView.startAnimation(animationSet);
    }

    private void animateUp() {
        if (this.mContentView == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new DecelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.mContentView.startAnimation(animationSet);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mIsAnimating) {
            return;
        }
        animateDown();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.gravity = 81;
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        if (screenWidth >= screenHeight) {
            screenWidth = screenHeight;
        }
        attributes.width = screenWidth;
        getWindow().setAttributes(attributes);
        setCanceledOnTouchOutside(true);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        View inflate = LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null);
        this.mContentView = inflate;
        super.setContentView(inflate);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        animateUp();
        OnBottomSheetShowListener onBottomSheetShowListener = this.mOnBottomSheetShowListener;
        if (onBottomSheetShowListener != null) {
            onBottomSheetShowListener.onShow();
        }
    }

    @Override // android.app.Dialog
    public void setContentView(@NonNull View view) {
        this.mContentView = view;
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        this.mContentView = view;
        super.setContentView(view, layoutParams);
    }
}
