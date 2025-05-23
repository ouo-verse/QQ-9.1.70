package com.tencent.mobileqq.wink.view.selector;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkActionSheet extends ReportDialog {
    protected Context C;
    protected Resources D;
    protected Handler E;
    private TranslateAnimation F;
    private f G;
    private boolean H;
    protected View I;
    protected ViewGroup J;
    private TextView K;
    private TextView L;
    private RelativeLayout M;
    private TextView N;
    private RelativeLayout P;
    private RelativeLayout Q;
    private RelativeLayout R;
    private TextView S;
    private TextView T;
    private ImageView U;
    protected boolean V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WinkActionSheet.this.G != null) {
                WinkActionSheet.this.G.onDismiss();
            }
            WinkActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WinkActionSheet.this.G != null) {
                WinkActionSheet.this.G.onDismiss();
            }
            WinkActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WinkActionSheet.this.G != null) {
                WinkActionSheet.this.G.onConfirm();
            }
            WinkActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WinkActionSheet.this.G != null) {
                WinkActionSheet.this.G.onDismiss();
            }
            WinkActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WinkActionSheet.this.G != null) {
                WinkActionSheet.this.G.onConfirm();
            }
            WinkActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface f {
        void onConfirm();

        void onDismiss();
    }

    protected WinkActionSheet(Context context, boolean z16) {
        super(context, R.style.ato);
        this.H = true;
        this.C = context;
        this.D = context.getResources();
        this.E = new Handler(Looper.getMainLooper());
        this.V = z16;
        initWindow();
        initUI();
    }

    public static WinkActionSheet U(Context context, View view, boolean z16) {
        WinkActionSheet W = W(context, z16);
        W.setContentWrapperView(view);
        W.S();
        return W;
    }

    public static WinkActionSheet W(Context context, boolean z16) {
        return new WinkActionSheet(context, z16);
    }

    public static WinkActionSheet X(Context context, boolean z16) {
        return U(context, LayoutInflater.from(context).inflate(R.layout.g1z, (ViewGroup) null), z16);
    }

    private void Y() {
        this.Q = (RelativeLayout) this.I.findViewById(R.id.f61952zi);
        TextView textView = (TextView) this.I.findViewById(R.id.f61942zh);
        this.S = textView;
        textView.setOnClickListener(new e());
    }

    private void Z() {
        this.P = (RelativeLayout) this.I.findViewById(R.id.f62072zu);
        TextView textView = (TextView) this.I.findViewById(R.id.f61972zk);
        this.K = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) this.I.findViewById(R.id.f61982zl);
        this.L = textView2;
        textView2.setOnClickListener(new c());
    }

    private void a0() {
        this.R = (RelativeLayout) this.I.findViewById(R.id.f62092zw);
        this.T = (TextView) this.I.findViewById(R.id.f62102zx);
        ImageView imageView = (ImageView) this.I.findViewById(R.id.f62082zv);
        this.U = imageView;
        imageView.setColorFilter(R.color.czw);
        this.U.setOnClickListener(new d());
    }

    private void initUI() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.f168613g20, (ViewGroup) null);
        this.I = inflate;
        super.setContentView(inflate);
        this.M = (RelativeLayout) this.I.findViewById(R.id.f61992zm);
        this.J = (ViewGroup) this.I.findViewById(R.id.b8q);
        this.I.setOnClickListener(new a());
        this.J.setOnClickListener(null);
        Z();
        a0();
        Y();
        this.N = (TextView) this.I.findViewById(R.id.f62062zt);
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            w53.b.e("QActionSheet", e16);
        }
    }

    protected void S() {
        if (this.C != null && this.V) {
            this.J.setBackgroundResource(R.drawable.kfe);
            this.K.setTextColor(-1);
            this.L.setTextColor(-1);
            this.N.setTextColor(-1);
            this.T.setTextColor(-1);
            this.S.setTextColor(-1);
            View findViewById = this.J.findViewById(R.id.f61842z8);
            if (findViewById != null) {
                findViewById.setBackgroundColor(this.C.getResources().getColor(R.color.czv));
            }
            View findViewById2 = this.J.findViewById(R.id.f61832z7);
            if (findViewById2 != null) {
                findViewById2.setBackgroundColor(this.C.getResources().getColor(R.color.czv));
            }
        }
    }

    public void b0(f fVar) {
        this.G = fVar;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.H) {
            this.H = false;
            this.E.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.view.selector.WinkActionSheet.7
                @Override // java.lang.Runnable
                public void run() {
                    WinkActionSheet.this.F = new TranslateAnimation(0.0f, 0.0f, 0.0f, WinkActionSheet.this.J.getHeight());
                    WinkActionSheet.this.F.setDuration(200L);
                    WinkActionSheet.this.F.setFillAfter(true);
                    WinkActionSheet winkActionSheet = WinkActionSheet.this;
                    winkActionSheet.J.startAnimation(winkActionSheet.F);
                    WinkActionSheet.this.F.setAnimationListener(new a());
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.wink.view.selector.WinkActionSheet$7$a */
                /* loaded from: classes21.dex */
                class a implements Animation.AnimationListener {
                    a() {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        WinkActionSheet.this.H = true;
                        WinkActionSheet.super.dismiss();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                }
            }, 0L);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        f fVar = this.G;
        if (fVar != null) {
            fVar.onDismiss();
        }
        dismiss();
    }

    public void setContentWrapperView(View view) {
        if (view != null) {
            this.M.removeAllViews();
            this.M.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        this.I.setVisibility(4);
        super.show();
        this.E.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.view.selector.WinkActionSheet.6
            @Override // java.lang.Runnable
            public void run() {
                WinkActionSheet.this.I.setVisibility(0);
                WinkActionSheet.this.F = new TranslateAnimation(0.0f, 0.0f, WinkActionSheet.this.J.getHeight(), 0.0f);
                WinkActionSheet.this.F.setFillEnabled(true);
                WinkActionSheet.this.F.setStartTime(300L);
                WinkActionSheet.this.F.setDuration(300L);
                WinkActionSheet.this.H = true;
                WinkActionSheet winkActionSheet = WinkActionSheet.this;
                winkActionSheet.J.startAnimation(winkActionSheet.F);
            }
        }, 0L);
    }
}
