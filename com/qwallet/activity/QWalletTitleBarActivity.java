package com.qwallet.activity;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.IQWalletHelper;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class QWalletTitleBarActivity extends QWalletBaseFragment {
    protected TextView C;
    protected TextView D;
    protected TextView E;
    protected ImageView F;
    protected ImageView G;
    protected View H;
    protected ViewGroup I;
    protected ViewGroup J;
    protected View K;

    @Nullable
    protected View M;
    protected int N;
    protected int P;
    protected int Q;
    private Drawable S;
    private Drawable[] T;
    private int U;
    protected boolean L = false;
    protected View.OnClickListener R = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QWalletTitleBarActivity.this.onBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void init(View view) {
        this.H = (ViewGroup) view.findViewById(R.id.f166670h70);
        this.K = view.findViewById(R.id.ds5);
        if (this.C == null) {
            this.I = (ViewGroup) view.findViewById(R.id.rlCommenTitle);
            this.J = (ViewGroup) view.findViewById(R.id.dtl);
            sh(view);
            rh(view);
            th(view);
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (!this.L) {
                qh();
            } else {
                this.H.setFitsSystemWindows(true);
                this.H.setPadding(0, this.Q, 0, 0);
            }
        }
    }

    private int ph(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return 0;
            }
            return R.drawable.common_loading5;
        }
        return R.drawable.common_loading6;
    }

    private void qh() {
        if (this.H == null) {
            return;
        }
        try {
            this.P = getResources().getColor(R.color.f156931fl);
            View findViewById = this.H.findViewById(R.id.j1w);
            this.M = findViewById;
            if (findViewById == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = this.Q;
            this.M.setLayoutParams(layoutParams);
            this.M.setBackgroundColor(this.P);
            new ul2.a(getActivity(), -16777216, this.M);
            this.H.setFitsSystemWindows(false);
        } catch (Exception e16) {
            QLog.e("QWalletTitleBarActivity", 1, "", e16);
        }
    }

    private View rh(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        this.D = textView;
        return textView;
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(1, null);
    }

    private View sh(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.C = textView;
        if (textView == null) {
            return null;
        }
        textView.setOnClickListener(this.R);
        setLayerType(this.C);
        return this.C;
    }

    private View th(View view) {
        this.E = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.F = (ImageView) view.findViewById(R.id.ivTitleBtnRightImage);
        this.G = (ImageView) view.findViewById(R.id.dsv);
        setLayerType(this.E);
        setLayerType(this.F);
        setLayerType(this.G);
        return this.E;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        finish();
        return false;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Q = ImmersiveUtils.getStatusBarHeight(getActivity());
        if (getIntent() != null) {
            getIntent().putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_IS_FLING, true);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        init(view);
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.D;
        if (textView == null || !(textView instanceof TextView) || charSequence == null) {
            return;
        }
        String charSequence2 = charSequence.toString();
        textView.setText(charSequence2);
        textView.setContentDescription(charSequence2);
        getOutActivity().setTitle(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean stopTitleProgress() {
        Object obj = this.S;
        if (obj == null) {
            return false;
        }
        ((Animatable) obj).stop();
        this.S = null;
        TextView textView = this.D;
        if (textView != null) {
            textView.setCompoundDrawablePadding(this.U);
            TextView textView2 = this.D;
            Drawable[] drawableArr = this.T;
            textView2.setCompoundDrawablesWithIntrinsicBounds(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
        }
        return true;
    }

    public void uh(int i3, int i16) {
        View view;
        if (this.P != i16) {
            if (ImmersiveUtils.isSupporImmersive() == 1 && !this.L && (view = this.M) != null) {
                view.setBackgroundColor(i16);
            }
            this.P = i16;
        }
        if (this.N != i3) {
            ViewGroup viewGroup = this.I;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(i3);
            }
            this.N = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vh(int i3) {
        if (isFinishing()) {
            return false;
        }
        Resources resources = getApplicationContext().getResources();
        if (this.S != null || this.D == null || resources == null) {
            return false;
        }
        try {
            this.S = resources.getDrawable(ph(i3));
        } catch (Exception unused) {
            this.S = resources.getDrawable(R.drawable.common_loading6);
        }
        this.T = this.D.getCompoundDrawables();
        this.U = this.D.getCompoundDrawablePadding();
        this.D.setCompoundDrawablePadding(10);
        TextView textView = this.D;
        Drawable drawable = this.S;
        Drawable[] drawableArr = this.T;
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawableArr[1], drawableArr[2], drawableArr[3]);
        ((Animatable) this.S).start();
        return true;
    }

    public void setTitle(int i3) {
        setTitle(getString(i3));
    }
}
