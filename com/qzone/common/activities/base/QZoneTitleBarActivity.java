package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.utils.DownloadBoxForTitle;
import com.qzone.publish.utils.PublishBoxForTitle;
import com.qzone.util.ToastUtil;
import com.qzone.widget.FillLinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTitleBarActivity extends BaseActivity implements PublishBoxForTitle.b, DownloadBoxForTitle.c {
    protected ViewGroup B0;
    protected ViewGroup I0;

    /* renamed from: a0, reason: collision with root package name */
    protected TextView f45399a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f45400b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f45401c0;

    /* renamed from: d0, reason: collision with root package name */
    protected View f45402d0;

    /* renamed from: e0, reason: collision with root package name */
    protected ImageView f45403e0;

    /* renamed from: f0, reason: collision with root package name */
    protected ViewGroup f45404f0;

    /* renamed from: g0, reason: collision with root package name */
    protected ProgressBar f45405g0;

    /* renamed from: h0, reason: collision with root package name */
    protected ProgressBar f45406h0;

    /* renamed from: i0, reason: collision with root package name */
    protected ViewGroup f45407i0;

    /* renamed from: j0, reason: collision with root package name */
    protected ViewGroup f45408j0;

    /* renamed from: k0, reason: collision with root package name */
    protected TextView f45409k0;

    /* renamed from: l0, reason: collision with root package name */
    protected TextView f45410l0;

    /* renamed from: m0, reason: collision with root package name */
    public SystemBarCompact f45411m0;

    /* renamed from: n0, reason: collision with root package name */
    LayoutInflater f45412n0;

    /* renamed from: r0, reason: collision with root package name */
    private int f45416r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f45417s0;

    /* renamed from: t0, reason: collision with root package name */
    protected int f45418t0;

    /* renamed from: u0, reason: collision with root package name */
    protected int f45419u0;

    /* renamed from: v0, reason: collision with root package name */
    protected int f45420v0;

    /* renamed from: w0, reason: collision with root package name */
    protected int f45421w0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f45424z0;

    /* renamed from: o0, reason: collision with root package name */
    protected int f45413o0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    protected int f45414p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    protected int f45415q0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    protected int f45422x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    protected int f45423y0 = 0;
    private AtomicBoolean A0 = new AtomicBoolean(false);
    protected int C0 = 0;
    protected int D0 = 0;
    protected int E0 = -1;
    protected boolean F0 = false;
    protected ArrayList<s4.e> G0 = new ArrayList<>();
    private TopGestureLayout.OnChangeMultiScreenListener H0 = new a();
    protected View.OnClickListener J0 = new View.OnClickListener() { // from class: com.qzone.common.activities.base.cc
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QZoneTitleBarActivity.this.i3(view);
        }
    };

    private void B3() {
        try {
            if (this.f45411m0 == null || !QQTheme.isNowThemeIsNightForQzone()) {
                return;
            }
            this.f45411m0.setStatusBarMask(new PorterDuffColorFilter(getResources().getColor(R.color.a_p), PorterDuff.Mode.SRC_ATOP));
        } catch (Exception e16) {
            QZLog.e(this.TAG, "catch an exception when set the NightMode for StatusBar.", e16);
        }
    }

    private void b3(Throwable th5, String str) {
        w5.b.h(this.TAG + str, 1, th5);
        ToastUtil.n(R.string.btc);
        QzoneBaseThread handlerThread = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread);
        final km.a aVar = km.a.f412646a;
        Objects.requireNonNull(aVar);
        handlerThread.postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.ce
            @Override // java.lang.Runnable
            public final void run() {
                km.a.this.d();
            }
        }, 500L);
        synchronized (this) {
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }

    private void c3(Intent intent, View view) {
        if (this.f45399a0 == null) {
            this.f45404f0 = (ViewGroup) view.findViewById(R.id.f166673ha1);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f166672ha0);
            this.B0 = viewGroup;
            if (viewGroup != null) {
                viewGroup.post(new Runnable() { // from class: com.qzone.common.activities.base.cf
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneTitleBarActivity.this.V2();
                    }
                });
            }
            setLayerType(this.f45404f0);
            r3(view);
            u3(view);
            setLeftViewName(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static void setLayerType(View view) {
        com.qzone.reborn.feedx.widget.i.e(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A3(int i3) {
        if (this.f45404f0 == null || this.B0 == null || this.E0 == i3) {
            return;
        }
        this.E0 = i3;
        if (i3 >= 125) {
            if (this.F0) {
                this.F0 = false;
                J1();
            }
        } else {
            this.F0 = true;
            g1();
        }
        if (this.B0.getBackground() != null && h3()) {
            this.B0.setAlpha(i3 / 255.0f);
        }
        if (i3 > 125) {
            x3(this.f45400b0, 0.0f);
            x3(this.f45399a0, 0.0f);
            x3(this.f45401c0, 0.0f);
        } else if (!com.tencent.mobileqq.simpleui.b.c()) {
            x3(this.f45400b0, 1.0f);
            x3(this.f45399a0, 1.0f);
            x3(this.f45401c0, 1.0f);
        }
        z3();
    }

    public ViewGroup B() {
        return (ViewGroup) ((ViewStub) Y2().findViewById(R.id.dtj)).inflate();
    }

    public ViewGroup G8() {
        return (ViewGroup) ((ViewStub) Y2().findViewById(R.id.dt8)).inflate();
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public void I(Bundle bundle) {
        Intent B = ak.B(this);
        B.putExtras(bundle);
        startActivity(B);
    }

    public void J1() {
        int simpleUiTextColor = SimpleUIUtil.getSimpleUiTextColor();
        this.f45411m0 = com.tencent.mobileqq.simpleui.b.b(this.f45411m0, getActivity(), h3(), SimpleUIUtil.useDarkResource());
        TextView textView = this.f45399a0;
        if (textView != null) {
            if (this.f45413o0 != 0) {
                textView.setTextColor(com.tencent.mobileqq.simpleui.b.c() ? simpleUiTextColor : this.f45413o0);
            } else {
                textView.setTextColor(com.tencent.mobileqq.simpleui.b.c() ? simpleUiTextColor : getResources().getColor(R.color.skin_bar_btn));
            }
            this.f45399a0.setBackgroundResource((com.tencent.mobileqq.simpleui.b.c() && SimpleUIUtil.useDarkResource()) ? R.drawable.hij : R.drawable.b5b);
        }
        TextView textView2 = this.f45400b0;
        if (textView2 != null) {
            if (this.f45413o0 != 0) {
                textView2.setTextColor(com.tencent.mobileqq.simpleui.b.c() ? simpleUiTextColor : this.f45413o0);
            } else {
                textView2.setTextColor(com.tencent.mobileqq.simpleui.b.c() ? simpleUiTextColor : getResources().getColor(R.color.skin_bar_text));
            }
        }
        TextView textView3 = this.f45401c0;
        if (textView3 != null) {
            if (this.f45415q0 != 0) {
                if (!com.tencent.mobileqq.simpleui.b.c()) {
                    simpleUiTextColor = this.f45415q0;
                }
                textView3.setTextColor(simpleUiTextColor);
            } else {
                if (!com.tencent.mobileqq.simpleui.b.c()) {
                    simpleUiTextColor = getResources().getColor(R.color.skin_bar_btn);
                }
                textView3.setTextColor(simpleUiTextColor);
            }
        }
        ViewGroup viewGroup = this.B0;
        if (viewGroup != null) {
            int paddingTop = viewGroup.getPaddingTop();
            int paddingRight = this.B0.getPaddingRight();
            int paddingLeft = this.B0.getPaddingLeft();
            int paddingBottom = this.B0.getPaddingBottom();
            if (com.tencent.mobileqq.simpleui.b.c()) {
                this.B0.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
            } else {
                this.B0.setBackgroundResource(R.drawable.qq_title_immersive_bar);
            }
            this.B0.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(int i3, View.OnClickListener onClickListener, boolean z16) {
        TextView textView = this.f45401c0;
        if (textView != null) {
            textView.setBackgroundResource(0);
            this.f45401c0.setVisibility(0);
            this.f45401c0.setText(i3);
            this.f45401c0.setEnabled(z16);
            if (onClickListener != null) {
                this.f45401c0.setOnClickListener(onClickListener);
            }
        }
    }

    public int Sf() {
        return 0;
    }

    protected void T2(int i3) {
        ArrayList<s4.e> arrayList = this.G0;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<s4.e> it = this.G0.iterator();
        while (it.hasNext()) {
            s4.e next = it.next();
            if (!next.f433306i) {
                next.f();
            }
            if (next.f433306i && next.a(i3)) {
                next.d(next.c(i3));
            }
        }
    }

    public void U2(s4.e eVar) {
        ArrayList<s4.e> arrayList = this.G0;
        if (arrayList != null) {
            arrayList.remove(eVar);
        }
    }

    protected void W2() {
        ArrayList<s4.e> arrayList = this.G0;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<s4.e> it = this.G0.iterator();
        while (it.hasNext()) {
            it.next().d(1.0f);
        }
    }

    public ViewGroup Y2() {
        return this.f45404f0;
    }

    public ViewGroup Z2() {
        return this.B0;
    }

    public int bd() {
        return 0;
    }

    protected void d3() {
        this.f45418t0 = getResources().getDimensionPixelSize(R.dimen.azx);
        this.f45419u0 = getResources().getDimensionPixelSize(R.dimen.azw);
        this.f45420v0 = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.f45421w0 = getResources().getDimensionPixelSize(R.dimen.f159598b01);
    }

    protected int f3(int i3) {
        int i16 = this.C0;
        if (i16 == 0) {
            return 0;
        }
        if (i3 >= i16) {
            return 255;
        }
        if (i3 <= 0) {
            return 0;
        }
        return (int) (((i3 * 1.0d) / i16) * 255.0d);
    }

    public void g1() {
        this.f45411m0 = com.tencent.mobileqq.simpleui.b.b(this.f45411m0, getActivity(), h3(), (!h3() || this.E0 >= 125) ? SimpleUIUtil.useDarkResource() : false);
        int parseColor = (com.tencent.mobileqq.simpleui.b.c() && !h3() && SimpleUIUtil.useDarkResource()) ? Color.parseColor("#03081A") : -1;
        TextView textView = this.f45399a0;
        if (textView != null) {
            textView.setTextColor(parseColor);
            if (com.tencent.mobileqq.simpleui.b.c() && !h3() && SimpleUIUtil.useDarkResource()) {
                this.f45399a0.setBackgroundResource(R.drawable.hij);
            } else {
                this.f45399a0.setBackgroundResource(R.drawable.b5b);
            }
        }
        TextView textView2 = this.f45400b0;
        if (textView2 != null) {
            textView2.setTextColor(parseColor);
        }
        TextView textView3 = this.f45401c0;
        if (textView3 != null) {
            textView3.setTextColor(parseColor);
        }
        TextView textView4 = this.f45409k0;
        if (textView4 != null) {
            textView4.setTextColor(parseColor);
        }
        TextView textView5 = this.f45410l0;
        if (textView5 != null) {
            textView5.setTextColor(parseColor);
        }
        if (this.B0 != null) {
            if (com.tencent.mobileqq.simpleui.b.c()) {
                this.B0.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
            } else {
                this.B0.setBackgroundResource(R.drawable.qq_title_immersive_bar);
            }
            if (this.B0.getBackground() != null && h3()) {
                this.B0.setAlpha(this.E0 / 255.0f);
            }
        }
        ViewGroup viewGroup = this.f45404f0;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(0);
        }
    }

    public final boolean g3() {
        if (!n3()) {
            return false;
        }
        ProgressBar progressBar = this.f45406h0;
        boolean isShown = progressBar != null ? progressBar.isShown() : false;
        ProgressBar progressBar2 = this.f45405g0;
        if (progressBar2 != null) {
            return progressBar2.getVisibility() == 0 || isShown;
        }
        return false;
    }

    public String getTextTitle() {
        CharSequence text;
        TextView textView = this.f45400b0;
        if (textView == null || !(textView instanceof TextView) || (text = textView.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public boolean h3() {
        return this.mNeedStatusTrans;
    }

    public boolean i0() {
        return false;
    }

    public void j1(int i3) {
        try {
            v3(this.f45412n0.inflate(i3, (ViewGroup) null, false));
            e3();
        } catch (Throwable th5) {
            b3(th5, " setLaterContentView has exception");
        }
    }

    protected boolean l3() {
        return true;
    }

    protected boolean n3() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        finish();
        return false;
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f45412n0 = LayoutInflater.from(this);
        d3();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateCenterView() {
        TextView textView = this.f45400b0;
        if (textView != null) {
            return textView;
        }
        TextView textView2 = (TextView) ((ViewStub) this.f45404f0.findViewById(R.id.ivTitleName)).inflate();
        this.f45400b0 = textView2;
        textView2.setFocusable(true);
        return this.f45400b0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        boolean h16 = TMSManager.e().h();
        QZonePublishQueue.w();
        if (QZonePublishQueue.F && !NetworkState.isWifiConn() && !h16) {
            QZonePublishQueue.w().b0(BaseActivity.getTopActivity());
            QZonePublishQueue.w();
            QZonePublishQueue.F = false;
        }
        if (com.tencent.mobileqq.simpleui.b.c() && ImmersiveUtils.isSupporImmersive() == 1) {
            if (h3() && this.E0 > 125) {
                J1();
            } else {
                g1();
            }
            B3();
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            try {
                getWindow().addFlags(67108864);
            } catch (Exception e16) {
                QZLog.e(this.TAG, 1, "add flags error!", e16);
            }
            ImmersiveUtils.clearCoverForStatus(getWindow(), true);
            if (this.f45411m0 != null) {
                return;
            }
            if (!h3()) {
                this.f45411m0 = new SystemBarCompact((Activity) this, true, getResources().getColor(R.color.skin_color_title_immersive_bar));
            } else {
                this.f45411m0 = new SystemBarCompact((Activity) this, false, getResources().getColor(R.color.skin_color_title_immersive_bar));
            }
            this.f45411m0.setStatusBarDrawable(getResources().getDrawable(R.drawable.qq_title_immersive_bar));
            this.f45411m0.init();
            B3();
        }
    }

    protected View p3() {
        ViewGroup viewGroup = this.f45408j0;
        if (viewGroup != null) {
            return viewGroup;
        }
        ViewGroup viewGroup2 = (ViewGroup) ((ViewStub) this.f45404f0.findViewById(R.id.asb)).inflate();
        this.f45408j0 = viewGroup2;
        this.f45409k0 = (TextView) viewGroup2.findViewById(R.id.k4p);
        this.f45410l0 = (TextView) this.f45408j0.findViewById(R.id.k4q);
        return this.f45408j0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View r3(View view) {
        TextView textView = this.f45399a0;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.f45399a0 = textView2;
        textView2.setOnClickListener(this.J0);
        setLayerType(this.f45399a0);
        this.f45399a0.setVisibility(0);
        return this.f45399a0;
    }

    protected void s3() {
        ViewGroup viewGroup;
        if (this.f45405g0 == null && (viewGroup = this.f45404f0) != null) {
            this.f45405g0 = (ProgressBar) ((ViewStub) viewGroup.findViewById(R.id.ivTitleprogress)).inflate();
            y();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        try {
            View inflate = this.f45412n0.inflate(i3, (ViewGroup) null, false);
            this.f45416r0 = getResources().getDimensionPixelSize(R.dimen.title_bar_height) + ImmersiveUtils.getStatusBarHeight(this);
            inflate.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.qzone.common.activities.base.cd
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
                    QZoneTitleBarActivity.this.j3(view, i16, i17, i18, i19, i26, i27, i28, i29);
                }
            });
            setContentView(inflate);
        } catch (Throwable th5) {
            b3(th5, " setContentView has exception");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        TextView textView = this.f45400b0;
        if (textView != null && textView.getText() != null && this.f45400b0.getText().length() != 0) {
            return this.f45400b0.getText().toString();
        }
        return getString(R.string.button_back);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLeftViewName(Intent intent) {
        if (this.f45399a0 == null || intent == null || intent.getExtras() == null) {
            return;
        }
        TextView textView = this.f45399a0;
        String string = getString(R.string.button_back);
        textView.setText("");
        AccessibilityUtil.p(textView, string);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (!l3()) {
            super.setTitle(charSequence);
        }
        onCreateCenterView();
        String a16 = com.qzone.util.g.a(charSequence.toString());
        this.f45400b0.setVisibility(0);
        this.f45400b0.setText(a16);
        this.f45400b0.setContentDescription(com.qzone.util.a.b(a16));
    }

    public final void t() {
        if (n3()) {
            s3();
            ProgressBar progressBar = this.f45405g0;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            ProgressBar progressBar2 = this.f45406h0;
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t3() {
        if (this.f45402d0 != null) {
            return;
        }
        View inflate = ((ViewStub) this.f45404f0.findViewById(R.id.dsj)).inflate();
        this.f45402d0 = inflate;
        this.f45403e0 = (ImageView) inflate.findViewById(R.id.dsr);
        this.f45402d0.setVisibility(0);
    }

    public TextView u() {
        return this.f45401c0;
    }

    public void v3(View view) {
        try {
            ViewGroup viewGroup = this.I0;
            if (viewGroup != null && viewGroup.getChildCount() >= 2) {
                this.I0.removeViewAt(r0.getChildCount() - 1);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, R.id.f166673ha1);
                this.I0.addView(view, layoutParams);
                super.setContentView(this.I0);
            } else {
                super.setContentView(view);
            }
            if (getActionBar() != null) {
                getActionBar().hide();
            }
        } catch (Throwable th5) {
            b3(th5, " setLaterContentView has exception");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w3() {
        int notchHeight = SystemUtil.getNotchHeight(BaseApplication.getContext(), getActivity());
        int i3 = 0;
        QZLog.d(this.TAG, 2, "notchHeight:", Integer.valueOf(notchHeight));
        if (notchHeight != 0) {
            ViewGroup viewGroup = this.f45404f0;
            if (viewGroup != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
                marginLayoutParams.topMargin = notchHeight;
                i3 = marginLayoutParams.height + notchHeight;
                this.f45404f0.setLayoutParams(marginLayoutParams);
            }
            ViewGroup viewGroup2 = this.B0;
            if (viewGroup2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) viewGroup2.getLayoutParams();
                if (i3 == 0) {
                    i3 = getTitleBarHeight() + notchHeight;
                }
                marginLayoutParams2.height = i3;
                this.B0.setLayoutParams(marginLayoutParams2);
            }
        }
    }

    public final void y() {
        if (n3()) {
            ProgressBar progressBar = this.f45405g0;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            ProgressBar progressBar2 = this.f45406h0;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
        }
    }

    public void y3(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (!l3()) {
            super.setTitle(charSequence);
        }
        p3();
        String charSequence3 = charSequence.toString();
        String a16 = com.qzone.util.g.a(charSequence3);
        this.f45409k0.setText(charSequence3);
        this.f45409k0.setContentDescription(com.qzone.util.a.b(a16));
        this.f45409k0.setMaxEms(10);
        this.f45410l0.setText(charSequence2);
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b, com.qzone.publish.utils.DownloadBoxForTitle.c
    public boolean z() {
        return this.F0;
    }

    protected void z3() {
        ViewGroup.LayoutParams layoutParams;
        if (this.f45422x0 == 0) {
            this.f45422x0 = getResources().getDimensionPixelSize(R.dimen.azy);
        }
        if (this.f45423y0 == 0) {
            this.f45423y0 = ImmersiveUtils.getStatusBarHeight(this);
        }
        if (this.A0.compareAndSet(false, true)) {
            this.f45424z0 = QzoneConfig.getInstance().getConfig("QZoneSetting", "second_key_title_special_phone", 0) == 1;
        }
        if (this.f45424z0) {
            ViewGroup viewGroup = this.f45407i0;
            if (viewGroup != null) {
                if (this.E0 >= 255) {
                    viewGroup.setVisibility(8);
                    return;
                } else {
                    viewGroup.setVisibility(0);
                    this.f45407i0.getBackground().setAlpha(255 - this.E0);
                    return;
                }
            }
            return;
        }
        ViewGroup viewGroup2 = this.f45407i0;
        if (viewGroup2 == null || this.f45399a0 == null || (layoutParams = viewGroup2.getLayoutParams()) == null) {
            return;
        }
        if (this.E0 >= 255) {
            this.f45407i0.setVisibility(8);
            return;
        }
        this.f45407i0.setVisibility(8);
        layoutParams.height = this.f45422x0;
        this.f45407i0.setLayoutParams(layoutParams);
        this.f45407i0.setBackgroundDrawable(getResources().getDrawable(R.drawable.gfk));
        this.f45407i0.setVisibility(0);
        this.f45407i0.getBackground().setAlpha(255 - this.E0);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements TopGestureLayout.OnChangeMultiScreenListener {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnChangeMultiScreenListener
        public void onChangeMultiScreen(boolean z16) {
            if (z16) {
                SystemBarCompact systemBarCompact = QZoneTitleBarActivity.this.f45411m0;
                if (systemBarCompact != null) {
                    systemBarCompact.setgetStatusBarVisible(false, 0);
                    return;
                }
                return;
            }
            SystemBarCompact systemBarCompact2 = QZoneTitleBarActivity.this.f45411m0;
            if (systemBarCompact2 != null) {
                systemBarCompact2.setgetStatusBarVisible(true, 0);
            }
        }
    }

    public void S2(s4.e eVar) {
        ArrayList<s4.e> arrayList;
        if (eVar == null || !eVar.b() || (arrayList = this.G0) == null || arrayList.contains(eVar)) {
            return;
        }
        this.G0.add(eVar);
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public void IOnSetTheme() {
        setTheme(R.style.a6t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View u3(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.f45401c0 = textView;
        setLayerType(textView);
        return this.f45401c0;
    }

    public int s1(int i3, AbsListView absListView, int i16) {
        int i17 = 0;
        if (absListView != null && absListView.getChildCount() != 0) {
            View childAt = absListView.getChildAt(0);
            i17 = (i3 > 0 || !((childAt instanceof FillLinearLayout) || (childAt instanceof FrameLayout) || (childAt instanceof RelativeLayout) || (childAt instanceof NormalAbsFeedView))) ? -10000 : childAt.getTop() - i16;
            if (this.C0 <= 0) {
                this.C0 = ((int) ((getResources().getDimension(R.dimen.aph) + (((i16 + getTitleBarHeight()) * 3) / 2)) - getResources().getDimension(R.dimen.f159597b00))) / 2;
                if (QZLog.isColorLevel()) {
                    QZLog.d(this.TAG, 2, "mCompleteFadePosition:" + this.C0);
                }
            }
        }
        T2(i17 * (-1));
        int f36 = f3(-(i17 + (this.C0 / 2)));
        this.D0 = f36;
        A3(f36);
        return this.D0;
    }

    public void L0(int i3) {
        if (i3 >= 1) {
            A3(255);
        }
        W2();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        try {
            this.I0 = (ViewGroup) this.f45412n0.inflate(R.layout.bjn, (ViewGroup) null);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.I0.setFitsSystemWindows(true);
                this.I0.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.f166673ha1);
            this.I0.addView(view, layoutParams);
            super.setContentView(this.I0);
            c3(getIntent(), this.I0);
        } catch (Throwable th5) {
            b3(th5, " setContentView has exception");
        }
    }

    private void x3(TextView textView, float f16) {
        if (textView != null) {
            textView.setShadowLayer(f16, 0.0f, 1.0f, R.color.black);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i3) {
        setTitle(getString(i3));
    }

    public void Fe(boolean z16) {
    }

    public void K4() {
    }

    public void Ng() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V2() {
    }

    public void b0(boolean z16) {
    }

    public void e3() {
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public Activity zf() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j3(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i3 == i19 && i17 == i27 && i16 == i26 && i18 == i28) {
            return;
        }
        if (i19 != 0 || i27 != 0 || i26 != 0 || i28 != 0 || i3 == 0 || i17 == 0 || i16 == 0 || i18 == 0) {
            boolean z16 = (i16 < i26 && i18 < i28) || (i16 == i26 && i16 < this.f45416r0 + (-5) && !(i17 == i27 && i18 == i28)) || i16 < this.f45416r0 + (-5);
            if (this.f45417s0 != z16) {
                this.f45417s0 = z16;
                TopGestureLayout.OnChangeMultiScreenListener onChangeMultiScreenListener = this.H0;
                if (onChangeMultiScreenListener != null) {
                    onChangeMultiScreenListener.onChangeMultiScreen(z16);
                }
            }
        }
    }
}
