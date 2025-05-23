package com.tencent.ams.xsad.rewarded.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.c;
import com.tencent.ams.xsad.rewarded.utils.g;
import com.tencent.ams.xsad.rewarded.view.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardedAdControllerView extends FrameLayout implements com.tencent.ams.xsad.rewarded.view.b {
    static IPatchRedirector $redirector_;
    private View C;
    private View D;
    private ImageView E;
    private TextView F;
    private TextView G;
    private View H;
    private View I;
    private View J;
    private NetworkImageView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private NetworkImageView P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private RewardedAdData T;
    private boolean U;
    private boolean V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private float f71875a0;

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f71876d;

    /* renamed from: e, reason: collision with root package name */
    private View.OnClickListener f71877e;

    /* renamed from: f, reason: collision with root package name */
    private b.a f71878f;

    /* renamed from: h, reason: collision with root package name */
    private View f71879h;

    /* renamed from: i, reason: collision with root package name */
    private View f71880i;

    /* renamed from: m, reason: collision with root package name */
    private View f71881m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdControllerView.this);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.c.a
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RewardedAdControllerView.this.x();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdControllerView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                RewardedAdControllerView.this.setMute(!r0.U, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdControllerView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (RewardedAdControllerView.this.f71877e != null) {
                RewardedAdControllerView.this.f71877e.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f71885d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f71886e;

        d(int i3, View view) {
            this.f71885d = i3;
            this.f71886e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, RewardedAdControllerView.this, Integer.valueOf(i3), view);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", "actionClick, clickArea: " + this.f71885d);
                if (RewardedAdControllerView.this.f71876d != null) {
                    RewardedAdListener.ClickInfo clickInfo = new RewardedAdListener.ClickInfo();
                    clickInfo.f71716a = this.f71885d;
                    clickInfo.f71717b = RewardedAdControllerView.this.W;
                    clickInfo.f71718c = RewardedAdControllerView.this.f71875a0;
                    clickInfo.f71719d = RewardedAdControllerView.this.getMeasuredWidth();
                    clickInfo.f71720e = RewardedAdControllerView.this.getMeasuredHeight();
                    clickInfo.f71721f = this.f71886e;
                    view.setTag(clickInfo);
                    RewardedAdControllerView.this.f71876d.onClick(view);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public RewardedAdControllerView(Context context) {
        this(context, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private View j() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(16);
        int u16 = u(10.0f);
        linearLayout.setPadding(u16, u16, u16, u16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(u(27.0f) / 2.0f);
        gradientDrawable.setColor(-1);
        linearLayout.setBackgroundDrawable(gradientDrawable);
        y(linearLayout, 5);
        NetworkImageView networkImageView = new NetworkImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(u(50.0f), u(50.0f));
        layoutParams.rightMargin = u(10.0f);
        networkImageView.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        float u17 = u(27.0f) / 2.0f;
        gradientDrawable2.setCornerRadius(u17);
        gradientDrawable2.setColor(Color.parseColor("#7F4D4D4D"));
        networkImageView.setBackgroundDrawable(gradientDrawable2);
        networkImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        networkImageView.setCornerRadius(u17);
        linearLayout.addView(networkImageView);
        this.K = networkImageView;
        y(networkImageView, 1);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.rightMargin = u(10.0f);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = u(6.0f);
        textView.setLayoutParams(layoutParams3);
        textView.setTextColor(Color.parseColor("#000028"));
        textView.setTextSize(1, 14.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.L = textView;
        linearLayout2.addView(textView);
        y(textView, 2);
        TextView textView2 = new TextView(getContext());
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView2.setTextColor(Color.parseColor("#848494"));
        textView2.setTextSize(1, 12.0f);
        textView2.setSingleLine(true);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        this.M = textView2;
        linearLayout2.addView(textView2);
        y(textView2, 3);
        TextView textView3 = new TextView(getContext());
        textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, u(30.0f)));
        textView3.setPadding(u(12.0f), 0, u(12.0f), 0);
        textView3.setTextSize(1, 12.0f);
        textView3.setGravity(17);
        linearLayout.addView(textView3);
        this.N = textView3;
        y(textView3, 4);
        this.J = linearLayout;
        return linearLayout;
    }

    private View k() {
        LinearLayout q16 = q();
        TextView s16 = s();
        q16.addView(s16);
        this.G = s16;
        View r16 = r();
        q16.addView(r16);
        this.H = r16;
        TextView s17 = s();
        s17.setText("\u5173\u95ed");
        q16.addView(s17);
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(u(14.0f), u(14.0f));
        layoutParams.leftMargin = u(2.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(g.a(getContext(), "images/qad_ad_rewarded_close.png"));
        q16.addView(imageView);
        q16.setOnClickListener(new c());
        this.I = q16;
        return q16;
    }

    private View l() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(Color.parseColor("#BF000000"));
        y(linearLayout, 10);
        NetworkImageView networkImageView = new NetworkImageView(getContext());
        networkImageView.setLayoutParams(new LinearLayout.LayoutParams(u(60.0f), u(60.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        float u16 = u(27.0f) / 2.0f;
        gradientDrawable.setCornerRadius(u16);
        gradientDrawable.setColor(Color.parseColor("#7F4D4D4D"));
        networkImageView.setBackgroundDrawable(gradientDrawable);
        networkImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        networkImageView.setCornerRadius(u16);
        linearLayout.addView(networkImageView);
        this.P = networkImageView;
        y(networkImageView, 6);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = u(14.0f);
        layoutParams2.bottomMargin = u(6.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(-1);
        textView.setTextSize(1, 17.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setSingleLine(true);
        textView.setGravity(17);
        this.Q = textView;
        linearLayout.addView(textView);
        y(textView, 7);
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = u(12.0f);
        layoutParams3.rightMargin = u(12.0f);
        layoutParams3.bottomMargin = u(24.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setTextColor(-1);
        textView2.setTextSize(1, 13.0f);
        textView2.setSingleLine(false);
        textView2.setGravity(17);
        this.R = textView2;
        linearLayout.addView(textView2);
        y(textView2, 8);
        TextView textView3 = new TextView(getContext());
        textView3.setLayoutParams(new LinearLayout.LayoutParams(u(200.0f), u(36.0f)));
        textView3.setTextSize(1, 14.0f);
        textView3.setGravity(17);
        linearLayout.addView(textView3);
        this.S = textView3;
        y(textView3, 9);
        this.f71881m = linearLayout;
        return linearLayout;
    }

    private View m() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(Color.parseColor("#FFFFFFFF"));
        textView.setText("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u5173\u95ed\u91cd\u8bd5");
        linearLayout.addView(textView);
        return linearLayout;
    }

    private View n() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        View progressBar = new ProgressBar(getContext());
        int b16 = g.b(getContext(), 34.0f);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(b16, b16));
        linearLayout.addView(progressBar);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = g.b(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(Color.parseColor("#FFFFFFFF"));
        textView.setText("\u52aa\u529b\u52a0\u8f7d\u4e2d");
        linearLayout.addView(textView);
        return linearLayout;
    }

    private View o() {
        LinearLayout q16 = q();
        q16.setPadding(0, 0, 0, 0);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(u(14.0f), u(14.0f)));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.E = imageView;
        q16.addView(imageView);
        return q16;
    }

    private View p() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        int i3 = -1;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        int u16 = u(12.0f);
        int h16 = com.tencent.ams.xsad.rewarded.c.f().h();
        if (this.V) {
            relativeLayout.setPadding(u16, h16 + u16, u16, u16);
        } else {
            relativeLayout.setPadding(h16 + u16, u16, u16, u16);
        }
        View view = new View(getContext());
        relativeLayout.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        y(view, 11);
        this.f71880i = view;
        View t16 = t();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, g.b(getContext(), 27.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        relativeLayout.addView(t16, layoutParams);
        View k3 = k();
        k3.setId(4096);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, g.b(getContext(), 27.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(11);
        relativeLayout.addView(k3, layoutParams2);
        View o16 = o();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(u(27.0f), u(27.0f));
        layoutParams3.rightMargin = u(10.0f);
        layoutParams3.addRule(10);
        layoutParams3.addRule(0, 4096);
        relativeLayout.addView(o16, layoutParams3);
        o16.setOnClickListener(new b());
        View j3 = j();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(12);
        layoutParams4.addRule(11);
        if (!this.V) {
            i3 = g.b(getContext(), 351.0f);
        }
        layoutParams4.width = i3;
        relativeLayout.addView(j3, layoutParams4);
        return relativeLayout;
    }

    private LinearLayout q() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, u(27.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(u(27.0f) / 2.0f);
        gradientDrawable.setColor(Color.parseColor("#7F4D4D4D"));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        int u16 = u(10.0f);
        linearLayout.setPadding(u16, 0, u16, 0);
        linearLayout.setGravity(17);
        return linearLayout;
    }

    private View r() {
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(u(0.5f), u(10.0f));
        layoutParams.leftMargin = u(6.0f);
        layoutParams.rightMargin = u(6.0f);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#7FFFFFFF"));
        return view;
    }

    private TextView s() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        return textView;
    }

    private View t() {
        LinearLayout q16 = q();
        TextView s16 = s();
        s16.setText("\u5e7f\u544a");
        q16.addView(s16);
        q16.addView(r());
        TextView s17 = s();
        this.F = s17;
        q16.addView(s17);
        return q16;
    }

    private String v(int i3) {
        String str;
        if (i3 > 0) {
            RewardedAdData rewardedAdData = this.T;
            if (rewardedAdData != null && !TextUtils.isEmpty(rewardedAdData.f71694h)) {
                str = this.T.f71694h;
            } else {
                str = "__TIME__\u79d2\u540e\u53ef\u9886\u53d6\u5956\u52b1";
            }
            return str.replace("__TIME__", String.valueOf(i3));
        }
        RewardedAdData rewardedAdData2 = this.T;
        if (rewardedAdData2 != null && !TextUtils.isEmpty(rewardedAdData2.f71695i)) {
            return this.T.f71695i;
        }
        return "\u5df2\u83b7\u5f97\u5956\u52b1";
    }

    private void w() {
        View l3 = l();
        this.f71881m = l3;
        l3.setVisibility(8);
        addView(this.f71881m);
        View n3 = n();
        this.C = n3;
        n3.setVisibility(8);
        addView(this.C);
        View m3 = m();
        this.D = m3;
        m3.setVisibility(8);
        addView(this.D);
        View p16 = p();
        this.f71879h = p16;
        addView(p16);
        com.tencent.ams.xsad.rewarded.c.f().p(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        int u16 = u(12.0f);
        if (this.f71879h != null && com.tencent.ams.xsad.rewarded.c.f().h() > 0) {
            if (this.V) {
                this.f71879h.setPadding(u16, com.tencent.ams.xsad.rewarded.c.f().h() + u16, u16, u16);
            } else {
                this.f71879h.setPadding(com.tencent.ams.xsad.rewarded.c.f().h() + u16, u16, u16, u16);
            }
        }
    }

    private void y(View view, int i3) {
        if (view != null) {
            view.setOnClickListener(new d(i3, view));
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", "showError");
        View view = this.D;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.C;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        TextView textView = this.G;
        if (textView != null && this.H != null) {
            textView.setVisibility(8);
            this.H.setVisibility(8);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", "showEnd");
        View view = this.f71881m;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f71880i;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.J;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void c(int i3, int i16) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", String.format(Locale.getDefault(), "showPlaying totalCountdown: %d, unlockCountdown: %d", Integer.valueOf(i3), Integer.valueOf(i16)));
        TextView textView = this.G;
        if (textView != null) {
            if (i3 > 0) {
                textView.setText(String.format(Locale.getDefault(), "%ds", Integer.valueOf(i3)));
            } else {
                textView.setVisibility(8);
                this.H.setVisibility(8);
            }
        }
        TextView textView2 = this.F;
        if (textView2 != null) {
            textView2.setText(v(i16));
        }
        if (i3 > 0 && (view = this.f71880i) != null && view.getVisibility() != 0) {
            this.f71880i.setVisibility(0);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", QCircleLpReportDc05507.KEY_CLEAR);
        setActionButtonClickListener(null);
        setMuteStatusChangeListener(null);
        setSkipButtonClickListener(null);
        com.tencent.ams.xsad.rewarded.c.f().p(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            this.W = motionEvent.getX();
            this.f71875a0 = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void hideLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", UIJsPlugin.EVENT_HIDE_LOADING);
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.J;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    @Override // android.view.View, com.tencent.ams.xsad.rewarded.view.b
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) configuration);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", NodeProps.ON_DETACHED_FROM_WINDOW);
        clear();
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void setActionButtonClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onClickListener);
        } else {
            this.f71876d = onClickListener;
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void setData(RewardedAdData rewardedAdData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rewardedAdData);
            return;
        }
        if (rewardedAdData == null) {
            com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAdControllerView", "null adData");
            return;
        }
        this.T = rewardedAdData;
        if (this.K != null) {
            if (!TextUtils.isEmpty(rewardedAdData.f71696j)) {
                this.K.setImageUrl(rewardedAdData.f71696j);
            } else {
                this.K.setVisibility(8);
            }
        }
        if (this.P != null) {
            if (!TextUtils.isEmpty(rewardedAdData.f71696j)) {
                this.P.setImageUrl(rewardedAdData.f71696j);
            } else {
                this.P.setVisibility(8);
            }
        }
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(rewardedAdData.f71697k);
        }
        TextView textView2 = this.M;
        if (textView2 != null) {
            textView2.setText(rewardedAdData.f71698l);
        }
        TextView textView3 = this.N;
        String str = "#FFFFFFFF";
        if (textView3 != null) {
            textView3.setText(rewardedAdData.f71699m);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(u(30.0f) / 2.0f);
            String str2 = rewardedAdData.f71700n;
            if (TextUtils.isEmpty(str2)) {
                str2 = com.tencent.ams.xsad.rewarded.c.f().i();
            }
            gradientDrawable.setColor(Color.parseColor(str2));
            this.N.setBackgroundDrawable(gradientDrawable);
            String str3 = rewardedAdData.f71701o;
            TextView textView4 = this.N;
            if (TextUtils.isEmpty(str3)) {
                str3 = "#FFFFFFFF";
            }
            textView4.setTextColor(Color.parseColor(str3));
        }
        TextView textView5 = this.Q;
        if (textView5 != null) {
            textView5.setText(rewardedAdData.f71697k);
        }
        TextView textView6 = this.R;
        if (textView6 != null) {
            textView6.setText(rewardedAdData.f71698l);
        }
        TextView textView7 = this.S;
        if (textView7 != null) {
            textView7.setText(rewardedAdData.f71699m);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(u(36.0f) / 2.0f);
            String str4 = rewardedAdData.f71700n;
            if (TextUtils.isEmpty(str4)) {
                str4 = com.tencent.ams.xsad.rewarded.c.f().i();
            }
            gradientDrawable2.setColor(Color.parseColor(str4));
            this.S.setBackgroundDrawable(gradientDrawable2);
            String str5 = rewardedAdData.f71701o;
            TextView textView8 = this.S;
            if (!TextUtils.isEmpty(str5)) {
                str = str5;
            }
            textView8.setTextColor(Color.parseColor(str));
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void setMute(boolean z16, boolean z17) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", "updateMuteStatus mute: " + z16 + " isFromUserClick: " + z17);
        this.U = z16;
        ImageView imageView = this.E;
        if (imageView != null) {
            if (z16) {
                str = "images/qad_ad_rewarded_sound_off.png";
            } else {
                str = "images/qad_ad_rewarded_sound_on.png";
            }
            imageView.setImageBitmap(g.a(getContext(), str));
        }
        b.a aVar = this.f71878f;
        if (aVar != null) {
            aVar.a(this.U, z17);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void setMuteStatusChangeListener(b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
        } else {
            this.f71878f = aVar;
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void setSkipButtonClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onClickListener);
        } else {
            this.f71877e = onClickListener;
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.b
    public void showLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdControllerView", UIJsPlugin.EVENT_SHOW_LOADING);
        View view = this.C;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.J;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public int u(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16))).intValue();
        }
        return g.b(getContext(), f16);
    }

    public RewardedAdControllerView(Context context, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
        } else {
            this.V = z16;
            w();
        }
    }
}
