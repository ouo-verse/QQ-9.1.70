package com.tencent.mobileqq.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AntiphingToast {

    /* renamed from: b, reason: collision with root package name */
    private Resources f315406b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f315407c;

    /* renamed from: a, reason: collision with root package name */
    private int f315405a = 0;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f315408d = null;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f315409e = null;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f315410f = null;

    /* renamed from: g, reason: collision with root package name */
    private View f315411g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f315412h = true;

    /* renamed from: i, reason: collision with root package name */
    private String f315413i = "AntiPhing";

    /* renamed from: j, reason: collision with root package name */
    Handler f315414j = new a(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AntiphingToast.this.i(0.0f, 0 - r0.f315410f.getHeight(), true);
            }
            super.handleMessage(message);
        }
    }

    public void c(int i3, int i16, FrameLayout frameLayout) {
        e(frameLayout);
        f(i3);
        d(i16);
    }

    public void d(int i3) {
        this.f315405a = i3;
    }

    public void e(FrameLayout frameLayout) {
        this.f315410f = frameLayout;
        this.f315406b = frameLayout.getContext().getResources();
    }

    public void f(int i3) {
        g(this.f315406b.getString(i3));
    }

    public void g(CharSequence charSequence) {
        this.f315409e = charSequence;
    }

    public boolean h(String str) {
        FrameLayout frameLayout;
        TextView textView;
        if (!this.f315412h || (frameLayout = this.f315410f) == null) {
            return false;
        }
        this.f315412h = false;
        frameLayout.removeAllViewsInLayout();
        if (this.f315407c == null) {
            this.f315407c = LayoutInflater.from(this.f315410f.getContext());
        }
        if (this.f315411g == null) {
            View inflate = this.f315407c.inflate(R.layout.f168945bb3, (ViewGroup) null);
            this.f315411g = inflate;
            if (inflate != null && (textView = (TextView) inflate.findViewById(R.id.f164350sp)) != null && str != null) {
                textView.setText(str);
            }
        }
        this.f315410f.addView(this.f315411g);
        this.f315410f.setFocusable(false);
        this.f315410f.setVisibility(0);
        this.f315410f.bringToFront();
        i(-80.0f, 0.0f, false);
        new BaseTimer().schedule(new TimerTask() { // from class: com.tencent.mobileqq.widget.AntiphingToast.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = 1;
                AntiphingToast.this.f315414j.sendMessage(message);
            }
        }, this.f315405a + 700);
        return true;
    }

    public void i(float f16, float f17, boolean z16) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f16, f17);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(700L);
        translateAnimation.setStartOffset(20L);
        if (z16) {
            translateAnimation.setAnimationListener(new b());
        }
        this.f315410f.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AntiphingToast.this.f315412h = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
