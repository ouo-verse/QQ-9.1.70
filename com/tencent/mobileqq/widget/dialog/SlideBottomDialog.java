package com.tencent.mobileqq.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.registerGuideLogin.TouchControllerFrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.QQUIThemeNavigationBarUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SlideBottomDialog extends ReportDialog {
    private TouchControllerFrameLayout C;
    private LinearLayout D;
    private View E;
    private View F;
    private View G;
    private int H;
    private boolean I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SlideBottomDialog.this.R();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements TouchControllerFrameLayout.a {
        c() {
        }

        @Override // com.tencent.mobileqq.activity.registerGuideLogin.TouchControllerFrameLayout.a
        public void b() {
            SlideBottomDialog.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            SlideBottomDialog.this.C.scrollTo(0, 0);
        }
    }

    public SlideBottomDialog(@NonNull Context context) {
        this(context, R.style.MenuDialogStyle);
    }

    private void S() {
        Window window = getWindow();
        if (window != null) {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                window.addFlags(67108864);
            }
            ImmersiveUtils.clearCoverForStatus(window, true);
            QQUIThemeNavigationBarUtil.setNavigationBarColor(window);
        }
    }

    private void U() {
        a aVar = new a();
        this.C.setOnClickListener(aVar);
        this.E.setOnClickListener(aVar);
        this.D.setOnClickListener(new b());
        this.C.setCustomTouchListener(new c());
        setOnDismissListener(new d());
    }

    private void initViews() {
        TouchControllerFrameLayout touchControllerFrameLayout = (TouchControllerFrameLayout) getLayoutInflater().inflate(R.layout.gwc, (ViewGroup) null, false);
        this.C = touchControllerFrameLayout;
        setContentView(touchControllerFrameLayout);
        this.D = (LinearLayout) findViewById(R.id.yrg);
        this.F = findViewById(R.id.f1187374y);
        this.E = findViewById(R.id.f165905ln4);
        this.G = findViewById(R.id.f1185774i);
        this.C.setHeadView(this.F);
        this.C.setMaxScrollHeight(ViewUtils.dip2px(50.0f));
        this.C.setIsInterceptContentEvent(false);
        this.H = getContext().getResources().getDimensionPixelSize(R.dimen.d6c);
    }

    public void R() {
        if (!this.I) {
            return;
        }
        this.I = false;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154458a7);
        loadAnimation.setAnimationListener(new e());
        this.D.startAnimation(loadAnimation);
    }

    public void W(final int i3) {
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.widget.dialog.SlideBottomDialog.6
            @Override // java.lang.Runnable
            public void run() {
                int max = Math.max(0, SlideBottomDialog.this.C.getHeight() - (i3 + SlideBottomDialog.this.H));
                ViewGroup.LayoutParams layoutParams = SlideBottomDialog.this.G.getLayoutParams();
                layoutParams.height = max;
                SlideBottomDialog.this.G.setLayoutParams(layoutParams);
            }
        });
    }

    public void X(View view) {
        this.D.addView(view);
    }

    public void Y() {
        show();
        this.D.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154454a3));
    }

    public SlideBottomDialog(@NonNull Context context, int i3) {
        super(context, i3);
        this.I = true;
        S();
        initViews();
        U();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SlideBottomDialog.this.dismiss();
            SlideBottomDialog.this.I = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
