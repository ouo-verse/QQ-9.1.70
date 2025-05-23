package com.tencent.mobileqq.guild.widget.selector;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes14.dex */
public class GuildActionSheetProfileEdit extends ReportDialog {
    protected Context C;
    protected Resources D;
    protected Handler E;
    private TranslateAnimation F;
    private d G;
    private boolean H;
    protected View I;
    protected ViewGroup J;
    private TextView K;
    private TextView L;
    private RelativeLayout M;
    private TextView N;
    protected boolean P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildActionSheetProfileEdit.this.G != null) {
                GuildActionSheetProfileEdit.this.G.onDismiss();
            }
            GuildActionSheetProfileEdit.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildActionSheetProfileEdit.this.G != null) {
                GuildActionSheetProfileEdit.this.G.onDismiss();
            }
            GuildActionSheetProfileEdit.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildActionSheetProfileEdit.this.G != null) {
                GuildActionSheetProfileEdit.this.G.onConfirm();
            }
            GuildActionSheetProfileEdit.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes14.dex */
    public interface d {
        void onConfirm();

        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GuildActionSheetProfileEdit(Context context) {
        this(context, false);
    }

    public static GuildActionSheetProfileEdit U(Context context, View view, boolean z16) {
        GuildActionSheetProfileEdit W = W(context, z16);
        W.setContentWrapperView(view);
        W.S();
        return W;
    }

    public static GuildActionSheetProfileEdit W(Context context, boolean z16) {
        return new GuildActionSheetProfileEdit(context, z16);
    }

    public static GuildActionSheetProfileEdit X(Context context, boolean z16) {
        return U(context, LayoutInflater.from(context).inflate(R.layout.f89, (ViewGroup) null), z16);
    }

    public static GuildActionSheetProfileEdit Y(Context context, boolean z16) {
        return U(context, LayoutInflater.from(context).inflate(R.layout.f2c, (ViewGroup) null), z16);
    }

    private void initUI() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.edi, (ViewGroup) null);
        this.I = inflate;
        super.setContentView(inflate);
        this.M = (RelativeLayout) this.I.findViewById(R.id.leh);
        this.J = (ViewGroup) this.I.findViewById(R.id.b8q);
        this.I.setOnClickListener(new a());
        this.J.setOnClickListener(null);
        TextView textView = (TextView) this.I.findViewById(R.id.cancel);
        this.K = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) this.I.findViewById(R.id.b7m);
        this.L = textView2;
        textView2.setOnClickListener(new c());
        this.N = (TextView) this.I.findViewById(R.id.title);
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
            QLog.e("ActionSheetProfileEdit", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        int color = this.C.getResources().getColor(R.color.c9r);
        if (this.P) {
            this.J.setBackgroundResource(R.drawable.jjj);
            this.K.setTextColor(Color.parseColor("#FFFFFF"));
            this.L.setTextColor(Color.parseColor("#FFFFFF"));
            this.N.setTextColor(Color.parseColor("#FFFFFF"));
            View findViewById = this.J.findViewById(R.id.e_x);
            if (findViewById != null) {
                findViewById.setBackgroundColor(color);
            }
            View findViewById2 = this.J.findViewById(R.id.e_b);
            if (findViewById2 != null) {
                findViewById2.setBackgroundColor(color);
            }
        }
    }

    public d Z() {
        return this.G;
    }

    public void a0(d dVar) {
        this.G = dVar;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.H) {
            this.H = false;
            this.E.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.5
                @Override // java.lang.Runnable
                public void run() {
                    GuildActionSheetProfileEdit.this.F = new TranslateAnimation(0.0f, 0.0f, 0.0f, GuildActionSheetProfileEdit.this.J.getHeight());
                    GuildActionSheetProfileEdit.this.F.setDuration(200L);
                    GuildActionSheetProfileEdit.this.F.setFillAfter(true);
                    GuildActionSheetProfileEdit guildActionSheetProfileEdit = GuildActionSheetProfileEdit.this;
                    guildActionSheetProfileEdit.J.startAnimation(guildActionSheetProfileEdit.F);
                    GuildActionSheetProfileEdit.this.F.setAnimationListener(new a());
                }

                /* renamed from: com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit$5$a */
                /* loaded from: classes14.dex */
                class a implements Animation.AnimationListener {
                    a() {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        GuildActionSheetProfileEdit.this.H = true;
                        GuildActionSheetProfileEdit.super.dismiss();
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
        d dVar = this.G;
        if (dVar != null) {
            dVar.onDismiss();
        }
        dismiss();
    }

    public void setContentWrapperView(View view) {
        if (view != null) {
            this.M.removeAllViews();
            this.M.addView(view);
        }
    }

    public void setTitle(String str) {
        this.N.setText(str);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        this.I.setVisibility(4);
        super.show();
        this.E.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.4
            @Override // java.lang.Runnable
            public void run() {
                GuildActionSheetProfileEdit.this.I.setVisibility(0);
                GuildActionSheetProfileEdit.this.F = new TranslateAnimation(0.0f, 0.0f, GuildActionSheetProfileEdit.this.J.getHeight(), 0.0f);
                GuildActionSheetProfileEdit.this.F.setFillEnabled(true);
                GuildActionSheetProfileEdit.this.F.setStartTime(300L);
                GuildActionSheetProfileEdit.this.F.setDuration(300L);
                GuildActionSheetProfileEdit.this.H = true;
                GuildActionSheetProfileEdit guildActionSheetProfileEdit = GuildActionSheetProfileEdit.this;
                guildActionSheetProfileEdit.J.startAnimation(guildActionSheetProfileEdit.F);
            }
        }, 0L);
    }

    protected GuildActionSheetProfileEdit(Context context, boolean z16) {
        super(context, R.style.MenuDialogStyle);
        this.H = true;
        this.C = context;
        this.D = context.getResources();
        this.E = new Handler(Looper.getMainLooper());
        this.P = z16;
        initWindow();
        initUI();
    }
}
