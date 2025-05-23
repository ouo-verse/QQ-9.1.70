package com.tencent.biz.pubaccount.weishi.follow.joingroup;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class BottomDialog extends Dialog {

    /* renamed from: d, reason: collision with root package name */
    private Context f80712d;

    /* renamed from: e, reason: collision with root package name */
    private View f80713e;

    /* renamed from: f, reason: collision with root package name */
    private View f80714f;

    /* renamed from: h, reason: collision with root package name */
    private View f80715h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f80716i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f80717m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomDialog.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomDialog.this.dismiss();
        }
    }

    private void g() {
        if (this.f80713e == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f80714f.getHeight());
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.biz.pubaccount.weishi.follow.joingroup.BottomDialog.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BottomDialog.this.f80716i = false;
                BottomDialog.this.f80713e.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.follow.joingroup.BottomDialog.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BottomDialog.super.dismiss();
                        } catch (Exception unused) {
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                BottomDialog.this.f80716i = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.f80714f.startAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(200L);
        this.f80715h.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f80713e == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.f80714f.getHeight(), 0.0f);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        this.f80714f.startAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(200L);
        this.f80715h.startAnimation(alphaAnimation);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f80716i) {
            return;
        }
        g();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        View inflate = LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null);
        this.f80713e = inflate;
        i(inflate);
        super.setContentView(this.f80713e);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.f80714f.setVisibility(4);
        this.f80715h.setVisibility(4);
        this.f80717m.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.follow.joingroup.BottomDialog.4
            @Override // java.lang.Runnable
            public void run() {
                BottomDialog.this.f80714f.setVisibility(0);
                BottomDialog.this.f80715h.setVisibility(0);
                BottomDialog.this.h();
            }
        });
    }

    public BottomDialog(Context context) {
        super(context, R.style.f246468z);
        this.f80716i = false;
        this.f80717m = new Handler(Looper.getMainLooper());
        this.f80712d = context;
    }

    private void i(View view) {
        this.f80714f = view.findViewById(R.id.b8q);
        View findViewById = view.findViewById(R.id.a4f);
        this.f80715h = findViewById;
        findViewById.setBackgroundColor(this.f80712d.getResources().getColor(R.color.f156803br));
        this.f80715h.setOnClickListener(new a());
        view.findViewById(R.id.close).setOnClickListener(new b());
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f80713e = view;
        i(view);
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f80713e = view;
        i(view);
        super.setContentView(view, layoutParams);
    }
}
