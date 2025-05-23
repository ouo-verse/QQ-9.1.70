package com.tencent.mobileqq.wink.editor.music;

import android.app.Dialog;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

/* loaded from: classes21.dex */
public class WinkEditorPanelDialogDelegate {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f320703a;

    /* renamed from: b, reason: collision with root package name */
    private View f320704b;

    /* renamed from: c, reason: collision with root package name */
    private a f320705c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f320706d;

    /* loaded from: classes21.dex */
    public interface a {
        void a();

        void b();
    }

    public WinkEditorPanelDialogDelegate(Dialog dialog, View view, a aVar) {
        this.f320703a = dialog;
        this.f320704b = view;
        this.f320705c = aVar;
    }

    public void d() {
        if (this.f320703a == null || this.f320704b == null || this.f320706d) {
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
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.wink.editor.music.WinkEditorPanelDialogDelegate.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                WinkEditorPanelDialogDelegate.this.f320706d = false;
                WinkEditorPanelDialogDelegate.this.f320704b.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.WinkEditorPanelDialogDelegate.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (WinkEditorPanelDialogDelegate.this.f320705c != null) {
                                WinkEditorPanelDialogDelegate.this.f320705c.b();
                            }
                        } catch (Exception e16) {
                            ms.a.d("AEEditorLyricPanelDialog", "[dismiss], Dialog.dismiss() raised exception", e16);
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                WinkEditorPanelDialogDelegate.this.f320706d = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.f320704b.startAnimation(animationSet);
    }

    public void e() {
        WindowManager.LayoutParams layoutParams;
        Dialog dialog = this.f320703a;
        if (dialog == null) {
            return;
        }
        if (dialog.getWindow() != null) {
            layoutParams = this.f320703a.getWindow().getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 81;
            layoutParams.height = -1;
            layoutParams.width = -1;
            this.f320703a.getWindow().setAttributes(layoutParams);
        }
        this.f320703a.setCancelable(false);
        this.f320703a.setCanceledOnTouchOutside(false);
    }

    public void f() {
        if (this.f320703a != null && this.f320704b != null) {
            a aVar = this.f320705c;
            if (aVar != null) {
                aVar.a();
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setInterpolator(new DecelerateInterpolator());
            animationSet.setDuration(200L);
            animationSet.setFillAfter(true);
            this.f320704b.startAnimation(animationSet);
        }
    }
}
