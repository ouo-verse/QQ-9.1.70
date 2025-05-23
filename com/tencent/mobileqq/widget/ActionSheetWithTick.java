package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ActionSheetWithTick extends ReportDialog {
    private final Context C;
    private final Handler D;
    private TranslateAnimation E;
    private boolean F;
    private View G;
    private ViewGroup H;
    private ViewGroup I;
    private View J;
    private View K;
    private TextView L;
    private final ArrayList<String> M;
    private int N;
    private boolean P;
    private boolean Q;
    private d R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ActionSheetWithTick.this.Z();
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
            ActionSheetWithTick.this.Z();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f315372d;

        c(int i3) {
            this.f315372d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ActionSheetWithTick.this.handleClick(this.f315372d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void onCancel();

        void onSelected(int i3);
    }

    protected ActionSheetWithTick(Context context, boolean z16) {
        super(context, R.style.MenuDialogStyle);
        this.F = true;
        this.M = new ArrayList<>();
        this.N = 0;
        this.C = context;
        this.D = new Handler(Looper.getMainLooper());
        this.P = z16;
        initWindow();
        initUI();
    }

    public static ActionSheetWithTick X(Context context, boolean z16) {
        return new ActionSheetWithTick(context, z16);
    }

    private View Y(int i3, boolean z16) {
        int i16;
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.dqf, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dr5);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.xxu);
        View findViewById = inflate.findViewById(R.id.xt9);
        textView.setText(this.M.get(i3));
        int i17 = 0;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        if (i3 == 0) {
            i17 = 8;
        }
        findViewById.setVisibility(i17);
        if (i3 == 0 && this.Q) {
            inflate.setBackgroundResource(R.drawable.j2h);
        } else {
            inflate.setBackgroundResource(R.drawable.qui_common_bg_top_light_bg);
        }
        inflate.setOnClickListener(new c(i3));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        d dVar = this.R;
        if (dVar != null) {
            dVar.onCancel();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClick(int i3) {
        d dVar = this.R;
        if (dVar != null) {
            dVar.onSelected(i3);
        }
        dismiss();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.dqg, (ViewGroup) null);
        this.G = inflate;
        super.setContentView(inflate);
        this.H = (ViewGroup) this.G.findViewById(R.id.content);
        this.I = (ViewGroup) this.G.findViewById(R.id.b8q);
        this.J = this.G.findViewById(R.id.bmt);
        this.K = this.G.findViewById(R.id.cancel);
        this.L = (TextView) this.G.findViewById(R.id.tll);
        this.G.setOnClickListener(new a());
        this.H.setOnClickListener(null);
        this.K.setOnClickListener(new b());
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
            QLog.e("ActionSheetWithTick", 1, e16, new Object[0]);
        }
    }

    private void updateUI() {
        boolean z16;
        int size = this.M.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == this.N) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.I.addView(Y(i3, z16));
        }
        if (this.P) {
            this.J.setBackgroundColor(-16777216);
            this.K.setBackgroundColor(MiniChatConstants.COLOR_SELECTED_NIGHT);
            this.L.setTextColor(-1);
        }
    }

    public void a0(List<String> list) {
        if (list == null) {
            return;
        }
        this.M.clear();
        this.M.addAll(list);
    }

    public void b0(d dVar) {
        this.R = dVar;
    }

    public void c0(int i3) {
        this.N = i3;
    }

    public void d0(boolean z16) {
        this.Q = z16;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.F) {
            this.F = false;
            this.D.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.ActionSheetWithTick.5
                @Override // java.lang.Runnable
                public void run() {
                    ActionSheetWithTick.this.E = new TranslateAnimation(0.0f, 0.0f, 0.0f, ActionSheetWithTick.this.H.getHeight());
                    ActionSheetWithTick.this.E.setDuration(200L);
                    ActionSheetWithTick.this.E.setFillAfter(true);
                    ActionSheetWithTick.this.H.startAnimation(ActionSheetWithTick.this.E);
                    ActionSheetWithTick.this.E.setAnimationListener(new a());
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.widget.ActionSheetWithTick$5$a */
                /* loaded from: classes20.dex */
                class a implements Animation.AnimationListener {
                    a() {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ActionSheetWithTick.this.F = true;
                        ActionSheetWithTick.super.dismiss();
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
        Z();
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        updateUI();
        this.G.setVisibility(4);
        super.show();
        this.D.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.ActionSheetWithTick.4
            @Override // java.lang.Runnable
            public void run() {
                ActionSheetWithTick.this.G.setVisibility(0);
                ActionSheetWithTick.this.E = new TranslateAnimation(0.0f, 0.0f, ActionSheetWithTick.this.H.getHeight(), 0.0f);
                ActionSheetWithTick.this.E.setFillEnabled(true);
                ActionSheetWithTick.this.E.setStartTime(300L);
                ActionSheetWithTick.this.E.setDuration(300L);
                ActionSheetWithTick.this.F = true;
                ActionSheetWithTick.this.H.startAnimation(ActionSheetWithTick.this.E);
            }
        }, 0L);
    }
}
