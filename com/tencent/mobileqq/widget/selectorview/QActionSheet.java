package com.tencent.mobileqq.widget.selectorview;

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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QActionSheet extends ReportDialog {
    protected static boolean X = true;
    protected Context C;
    protected Resources D;
    protected Handler E;
    private TranslateAnimation F;
    private f G;
    private f H;
    private boolean I;
    protected View J;
    protected ViewGroup K;
    private TextView L;
    private TextView M;
    private RelativeLayout N;
    private TextView P;
    private RelativeLayout Q;
    private RelativeLayout R;
    private RelativeLayout S;
    private TextView T;
    private TextView U;
    private ImageView V;
    protected boolean W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QActionSheet.this.G != null) {
                QActionSheet.this.G.onDismiss();
            }
            if (QActionSheet.this.H != null) {
                QActionSheet.this.H.onDismiss();
            }
            QActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QActionSheet.this.G != null) {
                QActionSheet.this.G.onDismiss();
            }
            if (QActionSheet.this.H != null) {
                QActionSheet.this.H.onDismiss();
            }
            QActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QActionSheet.this.G != null) {
                QActionSheet.this.G.onConfirm();
            }
            if (QActionSheet.this.H != null) {
                QActionSheet.this.H.onConfirm();
            }
            QActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QActionSheet.this.G != null) {
                QActionSheet.this.G.onDismiss();
            }
            if (QActionSheet.this.H != null) {
                QActionSheet.this.H.onDismiss();
            }
            QActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QActionSheet.this.G != null) {
                QActionSheet.this.G.onConfirm();
            }
            if (QActionSheet.this.H != null) {
                QActionSheet.this.H.onConfirm();
            }
            QActionSheet.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        void onConfirm();

        void onDismiss();

        void t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QActionSheet(Context context, boolean z16) {
        super(context, R.style.MenuDialogStyle);
        this.I = true;
        this.C = context;
        this.D = context.getResources();
        this.E = new Handler(Looper.getMainLooper());
        this.W = z16;
        initWindow();
        initUI();
    }

    public static QActionSheet W(Context context, View view, boolean z16) {
        QActionSheet X2 = X(context, z16);
        X2.setContentWrapperView(view);
        X2.U();
        return X2;
    }

    public static QActionSheet X(Context context, boolean z16) {
        return new QActionSheet(context, z16);
    }

    public static QActionSheet Y(Context context, boolean z16) {
        return W(context, LayoutInflater.from(context).inflate(R.layout.e3k, (ViewGroup) null), z16);
    }

    public static QActionSheet Z(Context context) {
        return a0(context, false);
    }

    public static QActionSheet a0(Context context, boolean z16) {
        X = false;
        return W(context, LayoutInflater.from(context).inflate(R.layout.e38, (ViewGroup) null), z16);
    }

    private void d0() {
        this.R = (RelativeLayout) this.J.findViewById(R.id.f61952zi);
        TextView textView = (TextView) this.J.findViewById(R.id.f61942zh);
        this.T = textView;
        textView.setOnClickListener(new e());
    }

    private void e0() {
        this.Q = (RelativeLayout) this.J.findViewById(R.id.f62072zu);
        TextView textView = (TextView) this.J.findViewById(R.id.f61972zk);
        this.L = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) this.J.findViewById(R.id.f61982zl);
        this.M = textView2;
        textView2.setOnClickListener(new c());
    }

    private void f0() {
        this.S = (RelativeLayout) this.J.findViewById(R.id.f62092zw);
        this.U = (TextView) this.J.findViewById(R.id.f62102zx);
        ImageView imageView = (ImageView) this.J.findViewById(R.id.f62082zv);
        this.V = imageView;
        imageView.setColorFilter(R.color.c9s);
        this.V.setOnClickListener(new d());
    }

    private void initUI() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.e39, (ViewGroup) null);
        this.J = inflate;
        super.setContentView(inflate);
        this.N = (RelativeLayout) this.J.findViewById(R.id.f61992zm);
        this.K = (ViewGroup) this.J.findViewById(R.id.b8q);
        this.J.setOnClickListener(new a());
        this.K.setOnClickListener(null);
        e0();
        f0();
        d0();
        this.P = (TextView) this.J.findViewById(R.id.f62062zt);
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
            QLog.e("QActionSheet", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        if (this.C != null && this.W) {
            this.K.setBackgroundResource(R.drawable.jjj);
            this.L.setTextColor(-1);
            this.M.setTextColor(-1);
            this.P.setTextColor(-1);
            this.U.setTextColor(-1);
            this.T.setTextColor(-1);
            View findViewById = this.K.findViewById(R.id.f61842z8);
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.qui_common_border_standard_bg);
            }
            View findViewById2 = this.K.findViewById(R.id.f61832z7);
            if (findViewById2 != null) {
                findViewById2.setBackgroundResource(R.drawable.qui_common_border_standard_bg);
            }
        }
    }

    public ViewGroup b0() {
        return this.K;
    }

    public f c0() {
        return this.G;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.I) {
            this.I = false;
            this.E.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.selectorview.QActionSheet.7
                @Override // java.lang.Runnable
                public void run() {
                    QActionSheet.this.F = new TranslateAnimation(0.0f, 0.0f, 0.0f, QActionSheet.this.K.getHeight());
                    he0.b.l(QActionSheet.this.F, R.anim.f154973ug);
                    QActionSheet.this.F.setFillAfter(true);
                    QActionSheet qActionSheet = QActionSheet.this;
                    qActionSheet.K.startAnimation(qActionSheet.F);
                    QActionSheet.this.F.setAnimationListener(new a());
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.widget.selectorview.QActionSheet$7$a */
                /* loaded from: classes20.dex */
                class a implements Animation.AnimationListener {
                    a() {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        QActionSheet.this.I = true;
                        if (QActionSheet.this.G != null) {
                            QActionSheet.this.G.t();
                        }
                        QActionSheet.super.dismiss();
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

    public void g0(int i3) {
        RelativeLayout relativeLayout = this.R;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(i3);
    }

    public void i0(f fVar) {
        this.H = fVar;
    }

    public void j0(f fVar) {
        this.G = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0(boolean z16) {
        View view = this.J;
        if (view == null) {
            return;
        }
        view.setClickable(z16);
    }

    public void l0(String str) {
        this.U.setText(str);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        f fVar = this.G;
        if (fVar != null) {
            fVar.onDismiss();
        }
        f fVar2 = this.H;
        if (fVar2 != null) {
            fVar2.onDismiss();
        }
        dismiss();
    }

    public void setContentWrapperView(View view) {
        if (view != null) {
            this.N.removeAllViews();
            this.N.addView(view);
        }
    }

    public void setTitle(String str) {
        this.P.setText(str);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        this.J.setVisibility(4);
        super.show();
        this.E.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.selectorview.QActionSheet.6
            @Override // java.lang.Runnable
            public void run() {
                QActionSheet.this.J.setVisibility(0);
                QActionSheet.this.F = new TranslateAnimation(0.0f, 0.0f, QActionSheet.this.K.getHeight(), 0.0f);
                QActionSheet.this.F.setFillEnabled(true);
                QActionSheet.this.F.setStartTime(300L);
                he0.b.l(QActionSheet.this.F, R.anim.f154976uj);
                QActionSheet.this.I = true;
                QActionSheet qActionSheet = QActionSheet.this;
                qActionSheet.K.startAnimation(qActionSheet.F);
            }
        }, 0L);
    }
}
