package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.utils.DownloadBoxForTitle;
import com.qzone.publish.utils.PublishBoxForTitle;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTitleBarFragmentV2 extends BaseFragment implements PublishBoxForTitle.b, DownloadBoxForTitle.c {
    protected TextView C;
    public TextView D;
    protected TextView E;
    protected ViewGroup F;
    protected ProgressBar G;
    protected ProgressBar H;
    protected ViewGroup I;
    protected TextView J;
    protected TextView K;
    public SystemBarCompact M;
    protected ViewGroup R;
    private int U;
    private boolean V;
    protected ViewGroup X;
    protected int Y;
    protected int Z;

    /* renamed from: a0, reason: collision with root package name */
    protected int f45426a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f45427b0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f45431f0;
    public boolean L = false;
    protected int N = 0;
    protected int P = 0;
    private int Q = -1;
    protected int S = -1;
    protected boolean T = false;
    private TopGestureLayout.OnChangeMultiScreenListener W = new a();

    /* renamed from: c0, reason: collision with root package name */
    protected View.OnClickListener f45428c0 = new View.OnClickListener() { // from class: com.qzone.common.activities.base.cg
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QZoneTitleBarFragmentV2.this.Lh(view);
        }
    };

    /* renamed from: d0, reason: collision with root package name */
    protected int f45429d0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f45430e0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    private AtomicBoolean f45432g0 = new AtomicBoolean(false);

    private int Ah() {
        int i3 = this.Q;
        if (i3 < 0) {
            return 1;
        }
        return i3;
    }

    private void Ch(Throwable th5, String str) {
        StringBuilder sb5 = new StringBuilder();
        String str2 = BaseFragment.TAG;
        sb5.append(str2);
        sb5.append(str);
        QZLog.e("exception", sb5.toString(), th5);
        w5.b.h(str2, 1, th5);
        ToastUtil.n(R.string.btc);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.QZoneTitleBarFragmentV2.3
            @Override // java.lang.Runnable
            public void run() {
                km.a.f412646a.d();
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

    private void Eh(Intent intent, View view) {
        if (this.C == null) {
            this.F = (ViewGroup) view.findViewById(R.id.f166673ha1);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f166672ha0);
            this.R = viewGroup;
            if (viewGroup != null) {
                viewGroup.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneTitleBarFragmentV2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneTitleBarFragmentV2.this.zh();
                    }
                });
            }
            setLayerType(this.F);
            Oh(view);
            Qh(view);
            Wh(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void bi(int i3) {
        this.Q = i3;
    }

    private void di() {
        try {
            if (this.M == null || !QQTheme.isNowThemeIsNightForQzone()) {
                return;
            }
            this.M.setStatusBarMask(new PorterDuffColorFilter(getResources().getColor(R.color.a_p), PorterDuff.Mode.SRC_ATOP));
        } catch (Exception e16) {
            QZLog.e(BaseFragment.TAG, "catch an exception when set the NightMode for StatusBar.", e16);
        }
    }

    private void ei() {
        if (this.R == null || this.M == null || !QQTheme.isNowSimpleUI() || !QQTheme.isNowThemeIsNightForQzone()) {
            return;
        }
        this.R.setBackgroundColor(-16777216);
        try {
            this.M.setStatusBarMask(new PorterDuffColorFilter(getResources().getColor(R.color.a_p), PorterDuff.Mode.SRC_ATOP));
        } catch (Exception e16) {
            QZLog.e(BaseFragment.TAG, "catch an exception when titleBarAdaptNightMode.", e16);
        }
    }

    private void xh() {
        ViewGroup viewGroup = this.R;
        if (viewGroup != null) {
            viewGroup.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.title_bar_height) + ImmersiveUtils.getStatusBarHeight(getActivity());
            this.R.setBackgroundColor(getResources().getColor(R.color.qui_common_bg_nav_secondary));
        }
        ViewGroup viewGroup2 = this.F;
        if (viewGroup2 != null && (viewGroup2.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) this.F.getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.qui_common_text_nav_secondary));
        }
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.qui_common_text_nav_secondary));
        }
        TextView textView3 = this.D;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(R.color.qui_common_text_nav_secondary));
        }
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public ViewGroup B() {
        return (ViewGroup) ((ViewStub) Bh().findViewById(R.id.dtj)).inflate();
    }

    public ViewGroup Bh() {
        return this.F;
    }

    public final void Dh() {
        if (Nh()) {
            ProgressBar progressBar = this.G;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            ProgressBar progressBar2 = this.H;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
        }
    }

    protected void Fh() {
        this.Y = getResources().getDimensionPixelSize(R.dimen.azx);
        this.Z = getResources().getDimensionPixelSize(R.dimen.azw);
        this.f45426a0 = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.f45427b0 = getResources().getDimensionPixelSize(R.dimen.f159598b01);
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public ViewGroup G8() {
        return (ViewGroup) ((ViewStub) Bh().findViewById(R.id.dt8)).inflate();
    }

    protected boolean Hh() {
        return false;
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public void I(Bundle bundle) {
        Intent B = ak.B(getActivity());
        B.putExtras(bundle);
        startActivity(B);
    }

    protected boolean Ih() {
        return true;
    }

    public final boolean Jh() {
        if (!Nh()) {
            return false;
        }
        ProgressBar progressBar = this.H;
        boolean isShown = progressBar != null ? progressBar.isShown() : false;
        ProgressBar progressBar2 = this.G;
        if (progressBar2 != null) {
            return progressBar2.getVisibility() == 0 || isShown;
        }
        return false;
    }

    public boolean Kh() {
        return this.L;
    }

    protected boolean Mh() {
        return true;
    }

    protected boolean Nh() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Oh(View view) {
        TextView textView = this.C;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.C = textView2;
        textView2.setOnClickListener(this.f45428c0);
        setLayerType(this.C);
        this.C.setVisibility(0);
        return this.C;
    }

    protected void Ph() {
        ViewGroup viewGroup;
        if (this.G == null && (viewGroup = this.F) != null) {
            this.G = (ProgressBar) ((ViewStub) viewGroup.findViewById(R.id.ivTitleprogress)).inflate();
            Dh();
        }
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b
    public int Sf() {
        return 0;
    }

    public View Th(LayoutInflater layoutInflater, View view, ViewGroup viewGroup) {
        try {
            ViewGroup viewGroup2 = this.X;
            if (viewGroup2 == null || viewGroup2.getChildCount() < 2) {
                return view;
            }
            this.X.removeViewAt(r2.getChildCount() - 1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.f166673ha1);
            this.X.addView(view, layoutParams);
            return this.X;
        } catch (Throwable th5) {
            Ch(th5, " setLaterCoZtentView has exception");
            return null;
        }
    }

    public void Vh() {
        this.M = com.tencent.mobileqq.simpleui.b.b(this.M, getActivity(), Kh(), (!Kh() || this.S >= 125) ? SimpleUIUtil.useDarkResource() : false);
        int parseColor = (com.tencent.mobileqq.simpleui.b.c() && !Kh() && SimpleUIUtil.useDarkResource()) ? Color.parseColor("#03081A") : -1;
        TextView textView = this.C;
        if (textView != null) {
            textView.setTextColor(parseColor);
            if (com.tencent.mobileqq.simpleui.b.c() && !Kh() && SimpleUIUtil.useDarkResource()) {
                this.C.setBackgroundResource(R.drawable.hij);
            } else {
                this.C.setBackgroundResource(R.drawable.b5b);
            }
        }
        TextView textView2 = this.D;
        if (textView2 != null) {
            textView2.setTextColor(parseColor);
        }
        TextView textView3 = this.E;
        if (textView3 != null) {
            textView3.setTextColor(parseColor);
        }
        TextView textView4 = this.J;
        if (textView4 != null) {
            textView4.setTextColor(parseColor);
        }
        TextView textView5 = this.K;
        if (textView5 != null) {
            textView5.setTextColor(parseColor);
        }
        if (this.R != null) {
            if (com.tencent.mobileqq.simpleui.b.c()) {
                this.R.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
            } else {
                this.R.setBackgroundResource(R.drawable.qq_title_immersive_bar);
            }
            if (this.R.getBackground() != null && Kh()) {
                this.R.setAlpha(this.S / 255.0f);
            }
        }
        ViewGroup viewGroup = this.F;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wh(Intent intent) {
        TextView textView = this.C;
        if (textView == null || !(textView instanceof TextView) || intent == null || intent.getExtras() == null) {
            return;
        }
        TextView textView2 = this.C;
        String string = intent.getExtras().getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
        if (Ih()) {
            com.qzone.util.g.a(string);
        }
        String string2 = getString(R.string.button_back);
        textView2.setText("");
        AccessibilityUtil.p(textView2, string2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xh(int i3, View.OnClickListener onClickListener, boolean z16) {
        TextView textView = this.E;
        if (textView != null) {
            textView.setBackgroundResource(0);
            this.E.setVisibility(0);
            this.E.setText(i3);
            this.E.setEnabled(z16);
            if (onClickListener != null) {
                this.E.setOnClickListener(onClickListener);
            }
        }
    }

    protected void Zh() {
        ViewGroup.LayoutParams layoutParams;
        if (this.f45429d0 == 0) {
            this.f45429d0 = getResources().getDimensionPixelSize(R.dimen.azy);
        }
        if (this.f45430e0 == 0) {
            this.f45430e0 = ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        if (this.f45432g0.compareAndSet(false, true)) {
            this.f45431f0 = QzoneConfig.getInstance().getConfig("QZoneSetting", "second_key_title_special_phone", 0) == 1;
        }
        if (this.f45431f0) {
            ViewGroup viewGroup = this.I;
            if (viewGroup != null) {
                if (this.S >= 255) {
                    viewGroup.setVisibility(8);
                    return;
                } else {
                    viewGroup.setVisibility(0);
                    this.I.getBackground().setAlpha(255 - this.S);
                    return;
                }
            }
            return;
        }
        ViewGroup viewGroup2 = this.I;
        if (viewGroup2 == null || this.C == null || (layoutParams = viewGroup2.getLayoutParams()) == null) {
            return;
        }
        if (this.S >= 255) {
            this.I.setVisibility(8);
            return;
        }
        this.I.setVisibility(8);
        layoutParams.height = this.f45429d0;
        this.I.setLayoutParams(layoutParams);
        this.I.setBackgroundDrawable(getResources().getDrawable(R.drawable.gfk));
        this.I.setVisibility(0);
        this.I.getBackground().setAlpha(255 - this.S);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(int i3) {
        if (this.F == null || this.R == null || this.S == i3) {
            return;
        }
        this.S = i3;
        if (i3 >= 125) {
            if (this.T) {
                this.T = false;
                yh();
            }
        } else {
            this.T = true;
            Vh();
        }
        if (this.R.getBackground() != null && Kh()) {
            this.R.setAlpha(i3 / 255.0f);
        }
        if (i3 > 125) {
            Yh(this.D, 0.0f);
            Yh(this.C, 0.0f);
            Yh(this.E, 0.0f);
        } else if (!com.tencent.mobileqq.simpleui.b.c()) {
            Yh(this.D, 1.0f);
            Yh(this.C, 1.0f);
            Yh(this.E, 1.0f);
        }
        Zh();
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public int bd() {
        return 0;
    }

    public final void ci() {
        if (Nh()) {
            Ph();
            ProgressBar progressBar = this.G;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            ProgressBar progressBar2 = this.H;
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return !Hh();
    }

    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b, com.qzone.publish.utils.DownloadBoxForTitle.c
    public boolean i0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return Hh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateCenterView() {
        TextView textView = this.D;
        if (textView != null) {
            return textView;
        }
        TextView textView2 = (TextView) ((ViewStub) this.F.findViewById(R.id.ivTitleName)).inflate();
        this.D = textView2;
        textView2.setFocusable(true);
        return this.D;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (QZLog.isColorLevel()) {
            String str = BaseFragment.TAG;
            QZLog.d(str, 2, "support:" + ImmersiveUtils.isSupporImmersive() + " sdk:" + Build.VERSION.SDK_INT);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("FEATURE_NO_TITLE:");
            sb5.append(getWindow().hasFeature(1));
            QZLog.d(str, 2, sb5.toString());
        }
        boolean h16 = TMSManager.e().h();
        if (QZLog.isColorLevel()) {
            QZLog.d(BaseFragment.TAG, 2, "isKingCard:", Boolean.valueOf(h16));
        }
        QZonePublishQueue.w();
        if (QZonePublishQueue.F && !NetworkState.isWifiConn() && !h16) {
            QZonePublishQueue.w().b0(BaseActivity.getTopActivity());
            QZonePublishQueue.w();
            QZonePublishQueue.F = false;
        }
        if (Hh()) {
            xh();
            return;
        }
        if (com.tencent.mobileqq.simpleui.b.c() && ImmersiveUtils.isSupporImmersive() == 1) {
            if (Kh() && this.S > 125) {
                yh();
            } else {
                Vh();
            }
            di();
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            try {
                getWindow().addFlags(67108864);
            } catch (Exception e16) {
                QZLog.e(BaseFragment.TAG, 1, "add flags error!", e16);
            }
            ImmersiveUtils.clearCoverForStatus(getWindow(), true);
            if (this.M != null) {
                return;
            }
            if (!Kh()) {
                this.M = new SystemBarCompact((Activity) getActivity(), true, getResources().getColor(R.color.skin_color_title_immersive_bar));
            } else {
                this.M = new SystemBarCompact((Activity) getActivity(), false, getResources().getColor(R.color.skin_color_title_immersive_bar));
            }
            this.M.setStatusBarDrawable(getResources().getDrawable(R.drawable.qq_title_immersive_bar));
            this.M.init();
            di();
            ei();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Fh();
        if (ImmersiveUtils.isSupportImmersive() && !Hh()) {
            getWindow().addFlags(67108864);
        }
        if (Ah() == 1) {
            Eh(getIntent(), this.X);
        } else if (Ah() == 2) {
            Gh();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public String setLastActivityName() {
        TextView textView = this.D;
        if (textView != null && textView.getText() != null && this.D.getText().length() != 0) {
            return this.D.getText().toString();
        }
        return getString(R.string.button_back);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLeftButton(int i3, View.OnClickListener onClickListener) {
        this.C.setVisibility(8);
        TextView textView = (TextView) ((ViewStub) this.F.findViewById(R.id.ivTitleBtnLeftButton)).inflate();
        this.C = textView;
        setLayerType(textView);
        this.C.setVisibility(0);
        this.C.setText(i3);
        if (onClickListener == null) {
            this.C.setOnClickListener(this.f45428c0);
        } else {
            this.C.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRightButton(int i3, View.OnClickListener onClickListener) {
        TextView textView = this.E;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        this.E.setText(i3);
        this.E.setEnabled(true);
        if (onClickListener != null) {
            this.E.setOnClickListener(onClickListener);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (!Mh()) {
            super.setTitle(charSequence);
        }
        onCreateCenterView();
        String a16 = com.qzone.util.g.a(charSequence.toString());
        this.D.setVisibility(0);
        this.D.setText(a16);
        this.D.setContentDescription(a16);
    }

    public void yh() {
        int simpleUiTextColor = SimpleUIUtil.getSimpleUiTextColor();
        this.M = com.tencent.mobileqq.simpleui.b.b(this.M, getActivity(), Kh(), SimpleUIUtil.useDarkResource());
        TextView textView = this.C;
        if (textView != null) {
            if (this.N != 0) {
                textView.setTextColor(com.tencent.mobileqq.simpleui.b.c() ? simpleUiTextColor : this.N);
            } else {
                textView.setTextColor(com.tencent.mobileqq.simpleui.b.c() ? simpleUiTextColor : getResources().getColor(R.color.skin_bar_btn));
            }
            this.C.setBackgroundResource((com.tencent.mobileqq.simpleui.b.c() && SimpleUIUtil.useDarkResource()) ? R.drawable.hij : R.drawable.b5b);
        }
        TextView textView2 = this.D;
        if (textView2 != null) {
            if (this.N != 0) {
                textView2.setTextColor(com.tencent.mobileqq.simpleui.b.c() ? simpleUiTextColor : this.N);
            } else {
                textView2.setTextColor(com.tencent.mobileqq.simpleui.b.c() ? simpleUiTextColor : getResources().getColor(R.color.skin_bar_text));
            }
        }
        TextView textView3 = this.E;
        if (textView3 != null) {
            if (this.P != 0) {
                if (!com.tencent.mobileqq.simpleui.b.c()) {
                    simpleUiTextColor = this.P;
                }
                textView3.setTextColor(simpleUiTextColor);
            } else {
                if (!com.tencent.mobileqq.simpleui.b.c()) {
                    simpleUiTextColor = getResources().getColor(R.color.skin_bar_btn);
                }
                textView3.setTextColor(simpleUiTextColor);
            }
        }
        ViewGroup viewGroup = this.R;
        if (viewGroup != null) {
            int paddingTop = viewGroup.getPaddingTop();
            int paddingRight = this.R.getPaddingRight();
            int paddingLeft = this.R.getPaddingLeft();
            int paddingBottom = this.R.getPaddingBottom();
            if (com.tencent.mobileqq.simpleui.b.c()) {
                this.R.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
            } else {
                this.R.setBackgroundResource(R.drawable.qq_title_immersive_bar);
            }
            this.R.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    @Override // com.qzone.publish.utils.PublishBoxForTitle.b, com.qzone.publish.utils.DownloadBoxForTitle.c
    public boolean z() {
        return this.T;
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public Activity zf() {
        return getActivity();
    }

    public View Uh(LayoutInflater layoutInflater, View view, ViewGroup viewGroup) {
        bi(2);
        return Th(layoutInflater, view, viewGroup);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements TopGestureLayout.OnChangeMultiScreenListener {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnChangeMultiScreenListener
        public void onChangeMultiScreen(boolean z16) {
            if (z16) {
                SystemBarCompact systemBarCompact = QZoneTitleBarFragmentV2.this.M;
                if (systemBarCompact != null) {
                    systemBarCompact.setgetStatusBarVisible(false, 0);
                    return;
                }
                return;
            }
            SystemBarCompact systemBarCompact2 = QZoneTitleBarFragmentV2.this.M;
            if (systemBarCompact2 != null) {
                systemBarCompact2.setgetStatusBarVisible(true, 0);
            }
        }
    }

    public View Rh(LayoutInflater layoutInflater, int i3, ViewGroup viewGroup) {
        try {
            View inflate = layoutInflater.inflate(i3, (ViewGroup) null, false);
            if (!Hh()) {
                this.U = getResources().getDimensionPixelSize(R.dimen.title_bar_height) + ImmersiveUtils.getStatusBarHeight(getActivity());
                inflate.addOnLayoutChangeListener(new b());
            }
            return Sh(layoutInflater, inflate, viewGroup);
        } catch (Throwable th5) {
            Ch(th5, " setContentView has exception");
            return null;
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void IOnSetTheme() {
        setTheme(R.style.a6t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Qh(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.E = textView;
        setLayerType(textView);
        return this.E;
    }

    public View Sh(LayoutInflater layoutInflater, View view, ViewGroup viewGroup) {
        try {
            this.X = (ViewGroup) layoutInflater.inflate(R.layout.bjn, viewGroup, false);
            if (ImmersiveUtils.isSupporImmersive() == 1 && !Hh()) {
                this.X.setFitsSystemWindows(true);
                this.X.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.f166673ha1);
            this.X.addView(view, layoutParams);
        } catch (Throwable th5) {
            Ch(th5, " setContentView has exception");
        }
        return this.X;
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setLayerType(1, null);
        } catch (Exception e16) {
            QZLog.e("QzoneTitleBarActivity", "close software false", e16);
        }
    }

    private void Yh(TextView textView, float f16) {
        if (textView != null) {
            textView.setShadowLayer(f16, 0.0f, 1.0f, R.color.black);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void setTitle(int i3) {
        setTitle(getString(i3));
    }

    @Override // com.qzone.publish.utils.DownloadBoxForTitle.c
    public void Fe(boolean z16) {
    }

    public void Gh() {
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

    protected void zh() {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (i3 == i19 && i17 == i27 && i16 == i26 && i18 == i28) {
                return;
            }
            if (i19 != 0 || i27 != 0 || i26 != 0 || i28 != 0 || i3 == 0 || i17 == 0 || i16 == 0 || i18 == 0) {
                boolean z16 = (i16 < i26 && i18 < i28) || (i16 == i26 && i16 < QZoneTitleBarFragmentV2.this.U + (-5) && !(i17 == i27 && i18 == i28)) || i16 < QZoneTitleBarFragmentV2.this.U + (-5);
                if (QZoneTitleBarFragmentV2.this.V != z16) {
                    QZoneTitleBarFragmentV2.this.V = z16;
                    if (QZoneTitleBarFragmentV2.this.W != null) {
                        QZoneTitleBarFragmentV2.this.W.onChangeMultiScreen(QZoneTitleBarFragmentV2.this.V);
                    }
                }
            }
        }
    }
}
