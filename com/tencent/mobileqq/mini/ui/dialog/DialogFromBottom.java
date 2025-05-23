package com.tencent.mobileqq.mini.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DialogFromBottom extends ReportDialog {
    private static final int mAnimationDuration = 200;
    private View mContentView;
    private boolean mIsAnimating;
    private OnBottomSheetShowListener mOnBottomSheetShowListener;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface OnBottomSheetShowListener {
        void onShow();
    }

    public DialogFromBottom(@NonNull Context context) {
        super(context, R.style.f173330ag);
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
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                DialogFromBottom.this.mIsAnimating = false;
                DialogFromBottom.this.mContentView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DialogFromBottom.super.dismiss();
                        } catch (Exception unused) {
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                DialogFromBottom.this.mIsAnimating = true;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.gravity = 81;
        int screenWidth = DisplayHelper.getScreenWidth(getContext());
        int screenHeight = DisplayHelper.getScreenHeight(getContext());
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

    public DialogFromBottom(@NonNull Context context, int i3) {
        super(context, i3);
        this.mIsAnimating = false;
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
