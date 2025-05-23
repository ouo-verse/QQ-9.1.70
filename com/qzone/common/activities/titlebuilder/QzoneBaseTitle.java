package com.qzone.common.activities.titlebuilder;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qzone.common.activities.base.ak;
import com.qzone.publish.utils.DownloadBoxForTitle;
import com.qzone.publish.utils.PublishBoxForTitle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.QZLog;
import d5.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneBaseTitle implements PublishBoxForTitle.b, DownloadBoxForTitle.c, com.qzone.common.activities.titlebuilder.a {
    public SystemBarCompact C;
    protected LayoutInflater D;
    private int E;
    private boolean F;
    protected ViewGroup H;
    private f I;
    private g J;
    protected ViewGroup M;
    protected int W;
    protected int X;
    int Y;
    protected int Z;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f45555d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f45556e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f45557f;

    /* renamed from: h, reason: collision with root package name */
    protected ViewGroup f45558h;

    /* renamed from: i, reason: collision with root package name */
    protected ProgressBar f45559i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f45560m = false;
    private TopGestureLayout.OnChangeMultiScreenListener G = new a();
    protected ArrayList<s4.e> K = new ArrayList<>();
    protected View.OnClickListener L = new c();
    protected int N = 0;
    protected int P = 0;
    protected int Q = 0;
    protected int R = -1;
    protected boolean S = true;
    protected int T = 0;
    protected int U = 0;
    private AtomicBoolean V = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements g {
        b() {
        }

        @Override // d5.g
        public boolean onClick(View view) {
            if (QzoneBaseTitle.this.J == null) {
                return false;
            }
            QzoneBaseTitle.this.J.onClick(view);
            return false;
        }

        @Override // d5.g
        public void onDoubleClick(View view) {
            if (QzoneBaseTitle.this.J != null) {
                QzoneBaseTitle.this.J.onDoubleClick(view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QzoneBaseTitle.this.p();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QzoneBaseTitle> f45564d;

        public d(QzoneBaseTitle qzoneBaseTitle) {
            this.f45564d = new WeakReference<>(qzoneBaseTitle);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            WeakReference<QzoneBaseTitle> weakReference = this.f45564d;
            QzoneBaseTitle qzoneBaseTitle = weakReference == null ? null : weakReference.get();
            if (qzoneBaseTitle != null) {
                qzoneBaseTitle.k(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        }
    }

    public QzoneBaseTitle(f fVar) {
        this.I = fVar;
        this.D = LayoutInflater.from(fVar.getRealActivity());
        l();
    }

    private String g(int i3) {
        return f().getString(i3);
    }

    private Window i() {
        return f().getWindow();
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public ViewGroup B() {
        return (ViewGroup) ((ViewStub) this.f45558h.findViewById(R.id.dtj)).inflate();
    }

    protected void D(Intent intent) {
        TextView textView = this.f45555d;
        if (textView == null || !(textView instanceof TextView) || intent == null || intent.getExtras() == null) {
            return;
        }
        TextView textView2 = this.f45555d;
        String string = intent.getExtras().getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
        if (n()) {
            com.qzone.util.g.a(string);
        }
        String g16 = g(R.string.button_back);
        textView2.setText("");
        AccessibilityUtil.p(textView2, g16);
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void E1(int i3, int i16, boolean z16) {
        SystemBarCompact systemBarCompact;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (com.tencent.mobileqq.simpleui.b.c()) {
                if (z16 && this.R < 125) {
                    this.C = com.tencent.mobileqq.simpleui.b.b(this.C, f(), true, false);
                } else {
                    this.C = com.tencent.mobileqq.simpleui.b.b(this.C, f(), z16, SimpleUIUtil.useDarkResource());
                    int simpleUiBgColor = SimpleUIUtil.getSimpleUiBgColor();
                    int simpleUiTextColor = SimpleUIUtil.getSimpleUiTextColor();
                    TextView textView = this.f45555d;
                    if (textView != null) {
                        textView.setTextColor(simpleUiTextColor);
                        if (SimpleUIUtil.useDarkResource()) {
                            this.f45555d.setBackgroundResource(R.drawable.hij);
                        } else {
                            this.f45555d.setBackgroundResource(R.drawable.b5b);
                        }
                    }
                    TextView textView2 = this.f45556e;
                    if (textView2 != null) {
                        textView2.setTextColor(simpleUiTextColor);
                    }
                    TextView textView3 = this.f45557f;
                    if (textView3 != null) {
                        textView3.setTextColor(simpleUiTextColor);
                    }
                    ViewGroup viewGroup = this.M;
                    if (viewGroup != null) {
                        viewGroup.setBackgroundColor(simpleUiBgColor);
                    }
                    ViewGroup viewGroup2 = this.f45558h;
                    if (viewGroup2 != null) {
                        viewGroup2.setBackgroundResource(0);
                    }
                }
            } else {
                i().addFlags(67108864);
                ImmersiveUtils.clearCoverForStatus(f().getWindow(), true);
                SystemBarCompact systemBarCompact2 = new SystemBarCompact(f(), !z16, getResources().getColor(i3));
                this.C = systemBarCompact2;
                systemBarCompact2.setStatusBarDrawable(getResources().getDrawable(i16));
                this.C.init();
            }
            s5.a.i(this.M);
        }
        if (!QQTheme.isNowThemeIsNightForQzone() || (systemBarCompact = this.C) == null) {
            return;
        }
        systemBarCompact.setStatusBarColor(-16777216);
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public ViewGroup E5() {
        return this.f45558h;
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void G6(g gVar) {
        this.J = gVar;
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public ViewGroup G8() {
        return (ViewGroup) ((ViewStub) this.f45558h.findViewById(R.id.dt8)).inflate();
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void H4(int i3) {
        ViewGroup viewGroup = this.f45558h;
        if (viewGroup != null) {
            viewGroup.setLayerType(i3, null);
        }
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public void I(Bundle bundle) {
        Intent B = ak.B(f());
        B.putExtras(bundle);
        this.I.startActivity(B);
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void K3(Intent intent) {
        m();
        if (this.f45555d == null) {
            this.f45558h = (ViewGroup) d(R.id.f166673ha1);
            ViewGroup viewGroup = (ViewGroup) d(R.id.f166672ha0);
            this.M = viewGroup;
            if (viewGroup != null) {
                viewGroup.post(new Runnable() { // from class: com.qzone.common.activities.titlebuilder.QzoneBaseTitle.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QzoneBaseTitle.this.c();
                    }
                });
            }
            C(this.f45558h);
            r();
            q();
            w();
            D(intent);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void P(int i3, View.OnClickListener onClickListener, boolean z16) {
        TextView textView = this.f45557f;
        if (textView != null) {
            textView.setBackgroundResource(0);
            this.f45557f.setVisibility(0);
            this.f45557f.setText(i3);
            this.f45557f.setEnabled(z16);
            if (onClickListener != null) {
                this.f45557f.setOnClickListener(onClickListener);
            }
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public ViewGroup R0() {
        return this.H;
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public int Sf() {
        return 0;
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void T3(int i3, View.OnClickListener onClickListener) {
        this.f45555d.setVisibility(8);
        TextView textView = (TextView) ((ViewStub) this.f45558h.findViewById(R.id.ivTitleBtnLeftButton)).inflate();
        this.f45555d = textView;
        C(textView);
        this.f45555d.setVisibility(0);
        this.f45555d.setText(i3);
        if (onClickListener == null) {
            this.f45555d.setOnClickListener(this.L);
        } else {
            this.f45555d.setOnClickListener(onClickListener);
        }
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public int bd() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends View> T d(int i3) {
        ViewGroup viewGroup = this.H;
        T t16 = viewGroup == null ? null : (T) viewGroup.findViewById(i3);
        return t16 == null ? (T) f().findViewById(i3) : t16;
    }

    protected boolean e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity f() {
        return this.I.getRealActivity();
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b, com.qzone.publish.utils.DownloadBoxForTitle.c
    public Handler getHandler() {
        return this.I.getMainHandler();
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b, com.qzone.publish.utils.DownloadBoxForTitle.c
    public Resources getResources() {
        return f().getResources();
    }

    protected int h() {
        return R.layout.bsa;
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b, com.qzone.publish.utils.DownloadBoxForTitle.c
    public boolean i0() {
        return false;
    }

    @Override // com.qzone.feed.ui.activity.f
    public boolean isRefreshing() {
        ProgressBar progressBar;
        return o() && (progressBar = this.f45559i) != null && progressBar.getVisibility() == 0;
    }

    public SystemBarCompact j() {
        return this.C;
    }

    protected void l() {
        this.W = getResources().getDimensionPixelSize(R.dimen.azx);
        this.X = getResources().getDimensionPixelSize(R.dimen.azw);
        this.Y = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.Z = getResources().getDimensionPixelSize(R.dimen.f159598b01);
    }

    protected final void m() {
        this.H = (ViewGroup) this.D.inflate(h(), this.I.Kd(), true);
        ViewGroup viewGroup = (ViewGroup) f().findViewById(android.R.id.content);
        if (viewGroup == null) {
            return;
        }
        View childAt = viewGroup.getChildAt(0);
        if (ImmersiveUtils.isSupporImmersive() == 1 && e() && childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, true);
            childAt.setPadding(0, ImmersiveUtils.getStatusBarHeight(f()), 0, 0);
        }
        this.E = getResources().getDimensionPixelSize(R.dimen.title_bar_height) + ImmersiveUtils.getStatusBarHeight(f());
        if (childAt == null) {
            return;
        }
        viewGroup.addOnLayoutChangeListener(new d(this));
    }

    protected boolean n() {
        return true;
    }

    protected boolean o() {
        return true;
    }

    public boolean p() {
        f().finish();
        return false;
    }

    protected View q() {
        TextView textView = this.f45556e;
        if (textView != null) {
            return textView;
        }
        View findViewById = this.f45558h.findViewById(R.id.ivTitleName);
        if (findViewById instanceof ViewStub) {
            TextView textView2 = (TextView) ((ViewStub) findViewById).inflate();
            this.f45556e = textView2;
            textView2.setFocusable(true);
        }
        A(this.f45558h);
        return this.f45556e;
    }

    protected View r() {
        TextView textView = this.f45555d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) d(R.id.ivTitleBtnLeft);
        this.f45555d = textView2;
        textView2.setOnClickListener(this.L);
        C(this.f45555d);
        this.f45555d.setVisibility(0);
        return this.f45555d;
    }

    protected void s() {
        ViewGroup viewGroup;
        if (this.f45559i == null && (viewGroup = this.f45558h) != null) {
            this.f45559i = (ProgressBar) ((ViewStub) viewGroup.findViewById(R.id.ivTitleprogress)).inflate();
            y();
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        q();
        String a16 = com.qzone.util.g.a(charSequence.toString());
        TextView textView = this.f45556e;
        if (textView != null) {
            textView.setVisibility(0);
            this.f45556e.setText(a16);
            this.f45556e.setContentDescription(com.qzone.util.a.b(a16));
        }
    }

    @Override // com.qzone.feed.ui.activity.f
    public void t() {
        if (o()) {
            s();
            ProgressBar progressBar = this.f45559i;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public TextView u() {
        return this.f45557f;
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public TextView v() {
        return this.f45556e;
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public TextView x() {
        return this.f45555d;
    }

    @Override // com.qzone.feed.ui.activity.f
    public void y() {
        ProgressBar progressBar;
        if (o() && (progressBar = this.f45559i) != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b, com.qzone.publish.utils.DownloadBoxForTitle.c
    public boolean z() {
        return this.S;
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public Activity zf() {
        return f();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements TopGestureLayout.OnChangeMultiScreenListener {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnChangeMultiScreenListener
        public void onChangeMultiScreen(boolean z16) {
            if (z16) {
                SystemBarCompact systemBarCompact = QzoneBaseTitle.this.C;
                if (systemBarCompact != null) {
                    systemBarCompact.setgetStatusBarVisible(false, 0);
                    return;
                }
                return;
            }
            SystemBarCompact systemBarCompact2 = QzoneBaseTitle.this.C;
            if (systemBarCompact2 != null) {
                systemBarCompact2.setgetStatusBarVisible(true, 0);
            }
        }
    }

    protected void A(View view) {
        if (view != null) {
            new com.qzone.widget.c(view).d(new b());
        }
    }

    protected View w() {
        TextView textView = (TextView) d(R.id.ivTitleBtnRightText);
        this.f45557f = textView;
        C(textView);
        return this.f45557f;
    }

    public static void C(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setLayerType(1, null);
        } catch (Exception e16) {
            QZLog.e("QzoneTitleBarActivity", "close software false", e16);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void setTitle(int i3) {
        setTitle(f().getString(i3));
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public void Fe(boolean z16) {
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public void K4() {
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public void Ng() {
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public void b0(boolean z16) {
    }

    @Override // com.qzone.common.activities.titlebuilder.a
    public void b5(boolean z16) {
    }

    protected void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i3 == i19 && i17 == i27 && i16 == i26 && i18 == i28) {
            return;
        }
        if (i19 == 0 && i27 == 0 && i26 == 0 && i28 == 0 && i17 != 0 && i18 != 0) {
            return;
        }
        boolean z16 = (i16 < i26 && i18 < i28) || (i16 == i26 && i16 < this.E + (-5) && !(i17 == i27 && i18 == i28)) || i16 < this.E + (-5);
        if (this.F == z16) {
            QLog.e("QzoneBaseTitle", 2, "[handleLayoutChange] mIsMultiScreen == tmpIsMultiScreen");
            return;
        }
        this.F = z16;
        TopGestureLayout.OnChangeMultiScreenListener onChangeMultiScreenListener = this.G;
        if (onChangeMultiScreenListener != null) {
            onChangeMultiScreenListener.onChangeMultiScreen(z16);
        } else {
            QLog.e("QzoneBaseTitle", 1, "[handleLayoutChange] change multi screen listener should not be null.");
        }
    }
}
