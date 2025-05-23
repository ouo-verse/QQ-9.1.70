package com.tencent.mobileqq.guild.base;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QQGuildCustomTitleBarFragment extends QPublicBaseFragment {
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public ImageView G;
    protected TextView H;
    protected ImageView I;
    protected GuildDefaultThemeNavBarCommon J;
    private boolean K;
    protected float L;
    public RelativeLayout N;
    protected View P;
    private boolean Q;
    public View M = null;
    protected boolean R = false;
    protected View.OnClickListener S = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGuildCustomTitleBarFragment.this.onBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(0, null);
    }

    private void setStatusBar() {
        this.N.setFitsSystemWindows(true);
        this.N.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()) + 5, 0, 0);
        yh(ph());
    }

    protected void Ah(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (AppSetting.f99565y) {
            textView.setContentDescription(((Object) textView.getText()) + HardCodeUtil.qqStr(R.string.f142520jl));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh(int i3) {
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.J;
        if (guildDefaultThemeNavBarCommon != null) {
            guildDefaultThemeNavBarCommon.b(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected abstract int getContentLayoutId();

    protected int getLayoutId() {
        return R.layout.ejt;
    }

    public View getRightTextView() {
        TextView textView = (TextView) this.N.findViewById(R.id.ivTitleBtnRightText);
        this.F = textView;
        setLayerType(textView);
        return this.F;
    }

    public View getTitleBarView() {
        return this.N.findViewById(R.id.rlCommenTitle);
    }

    public void hideTitleBar() {
        try {
            View findViewById = this.N.findViewById(R.id.rlCommenTitle);
            this.M = findViewById;
            findViewById.setVisibility(8);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("QQGuildCustomTitleBarFragment", 2, th5, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(Bundle bundle) {
        TextView textView;
        ViewParent parent;
        if (getActivity() == null) {
            return;
        }
        ((FrameLayout) getActivity().findViewById(android.R.id.content)).setForeground(getResources().getDrawable(R.drawable.guild_header_bar_shadow));
        if (isTransparent() && needImmersive() && needStatusTrans() && (parent = getActivity().findViewById(android.R.id.title).getParent()) != null && (parent instanceof FrameLayout)) {
            ((FrameLayout) parent).setVisibility(8);
        }
        if (this.C == null) {
            this.J = (GuildDefaultThemeNavBarCommon) this.N.findViewById(R.id.rlCommenTitle);
            onCreateLeftView();
            if (bundle != null) {
                try {
                    if (bundle.getBoolean("hide_title_left_arrow", false) && (textView = this.C) != null) {
                        textView.setBackgroundDrawable(null);
                    }
                } catch (Exception e16) {
                    QLog.d("QQGuildCustomTitleBarFragment", 1, "", e16);
                }
            }
            onCreateCenterView();
            onCreateRightView();
            setLeftViewName(bundle);
        }
        if (bundle != null && bundle.getBoolean(IPCConst.KEY_HIDE_TITLE, false)) {
            hideTitleBar();
            this.N.setPadding(0, 0, 0, 0);
            this.N.setFitsSystemWindows(false);
        }
    }

    protected boolean isTransparent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getActivity() != null) {
            getActivity().finish();
            return false;
        }
        return false;
    }

    protected View onCreateCenterView() {
        TextView textView = (TextView) this.N.findViewById(R.id.ivTitleName);
        this.E = textView;
        return textView;
    }

    protected View onCreateLeftView() {
        TextView textView = (TextView) this.N.findViewById(R.id.ivTitleBtnLeft);
        this.C = textView;
        textView.setOnClickListener(this.S);
        this.H = (TextView) this.N.findViewById(R.id.k4f);
        ImageView imageView = (ImageView) this.N.findViewById(R.id.f165972dz1);
        this.I = imageView;
        TextView textView2 = this.H;
        if (textView2 != null && imageView != null) {
            textView2.setOnClickListener(this.S);
            this.I.setOnClickListener(this.S);
        }
        return this.C;
    }

    protected View onCreateRightView() {
        this.F = (TextView) this.N.findViewById(R.id.ivTitleBtnRightText);
        this.G = (ImageView) this.N.findViewById(R.id.ivTitleBtnRightImage);
        setLayerType(this.F);
        setLayerType(this.G);
        return this.F;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    @TargetApi(14)
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        try {
            View inflate2 = layoutInflater.inflate(getContentLayoutId(), (ViewGroup) inflate, false);
            try {
                this.N = (RelativeLayout) inflate.findViewById(R.id.jqh);
                if (ImmersiveUtils.isSupporImmersive() == 1) {
                    setStatusBar();
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                if (this.Q) {
                    this.N.addView(inflate2, 0, layoutParams);
                } else {
                    layoutParams.addRule(3, R.id.rlCommenTitle);
                    this.N.addView(inflate2, layoutParams);
                }
                this.P = inflate2;
            } catch (InflateException e16) {
                QLog.e("QQGuildCustomTitleBarFragment", 1, e16, new Object[0]);
            }
            View view = this.M;
            if (view != null) {
                view.setVisibility(0);
            }
            this.L = getResources().getDisplayMetrics().density;
            init(getArguments());
            Bh(qh());
            doOnCreateView(layoutInflater, viewGroup, bundle);
            AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
            return inflate;
        } catch (Throwable th5) {
            QLog.e("QQGuildCustomTitleBarFragment", 1, th5, new Object[0]);
            throw th5;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        GuildSplitViewUtils.f235370a.z(this);
    }

    @ColorRes
    protected int ph() {
        return R.color.guild_color_ffffff_1d1d20;
    }

    @DrawableRes
    protected int qh() {
        return R.drawable.guild_titlebar_bg;
    }

    public void resetLeftButton() {
        TextView textView = this.D;
        if (textView != null) {
            textView.setVisibility(8);
        }
        setLayerType(this.C);
        this.C.setVisibility(0);
    }

    public void rh() {
        this.J.a();
    }

    public void setLeftButton(int i3, View.OnClickListener onClickListener) {
        this.C.setVisibility(8);
        TextView textView = (TextView) this.N.findViewById(R.id.ivTitleBtnLeftButton);
        this.D = textView;
        setLayerType(textView);
        this.D.setVisibility(0);
        this.D.setText(i3);
        if (onClickListener == null) {
            this.D.setOnClickListener(this.S);
        } else {
            this.D.setOnClickListener(onClickListener);
        }
    }

    public void setLeftViewName(Bundle bundle) {
        this.J.setLeftViewName(bundle);
    }

    public void setRightButton(int i3, View.OnClickListener onClickListener) {
        this.K = false;
        this.F.setVisibility(0);
        setTextWithTalk(this.F, i3);
        this.F.setEnabled(true);
        if (onClickListener != null) {
            this.F.setOnClickListener(onClickListener);
        }
    }

    public void setRightButtonEnable(boolean z16) {
        this.F.setEnabled(z16);
    }

    public void setRightButtonText(String str, View.OnClickListener onClickListener) {
        this.K = false;
        this.F.setVisibility(0);
        this.F.setText(str);
        this.F.setEnabled(true);
        if (onClickListener != null) {
            this.F.setOnClickListener(onClickListener);
        }
    }

    @TargetApi(11)
    public void setRightViewTextDisable(int i3) {
        if (i3 == 0) {
            this.F.setEnabled(false);
            this.F.setAlpha(0.5f);
        } else {
            this.F.setEnabled(true);
            this.F.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextWithTalk(TextView textView, @StringRes int i3) {
        textView.setText(i3);
        if (AppSetting.f99565y) {
            textView.setContentDescription(((Object) textView.getText()) + HardCodeUtil.qqStr(R.string.f142520jl));
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.J.setTitle(charSequence);
    }

    public void sh(boolean z16) {
        this.Q = z16;
        if (this.P != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (z16) {
                this.P.setLayoutParams(layoutParams);
            } else {
                layoutParams.addRule(3, R.id.rlCommenTitle);
                this.P.setLayoutParams(layoutParams);
            }
        }
    }

    public void th(View view) {
        this.J.setCustomView(view);
    }

    public void uh(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.leftMargin = i3;
        this.C.setLayoutParams(layoutParams);
    }

    public void vh(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.K = false;
        this.F.setVisibility(0);
        Ah(this.F, charSequence);
        this.F.setEnabled(true);
        if (onClickListener != null) {
            this.F.setOnClickListener(onClickListener);
        }
    }

    public void wh(int i3, View.OnClickListener onClickListener) {
        xh(getResources().getDrawable(i3), onClickListener);
    }

    public void xh(Drawable drawable, View.OnClickListener onClickListener) {
        this.G.setVisibility(0);
        this.G.setImageDrawable(drawable);
        this.G.setEnabled(true);
        if (onClickListener != null) {
            this.G.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yh(int i3) {
        QQGuildUIUtil.L(getActivity(), getResources().getColor(i3));
        if (getActivity() != null && !GuildThemeManager.f235286a.b()) {
            ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
            if (Build.VERSION.SDK_INT >= 26) {
                View decorView = getActivity().getWindow().getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
        }
    }

    public void zh(String str, String str2) {
        this.J.setSubTitleWithIcon(str, str2, null);
    }

    public void setLeftButton(String str, View.OnClickListener onClickListener) {
        this.C.setVisibility(8);
        this.D = (TextView) this.N.findViewById(R.id.ivTitleBtnLeftButton);
        if (TextUtils.isEmpty(str)) {
            this.D.setVisibility(8);
            return;
        }
        setLayerType(this.D);
        this.D.setVisibility(0);
        this.D.setText(str);
        if (onClickListener == null) {
            this.D.setOnClickListener(this.S);
        } else {
            this.D.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
    }
}
