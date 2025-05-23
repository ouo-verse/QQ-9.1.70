package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameSparkIncomeViewBinding implements ViewBinding {
    public final ImageView imCoin;
    public final ImageView imLimit;
    public final LinearLayout limitContainer;
    public final LinearLayout rewardContainer;
    private final FrameLayout rootView;
    public final TextView tvLimit;
    public final View tvLimitSub;
    public final TextView tvRewardSubTitle;
    public final TextView tvRewardTitle;

    MiniGameSparkIncomeViewBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, View view, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.imCoin = imageView;
        this.imLimit = imageView2;
        this.limitContainer = linearLayout;
        this.rewardContainer = linearLayout2;
        this.tvLimit = textView;
        this.tvLimitSub = view;
        this.tvRewardSubTitle = textView2;
        this.tvRewardTitle = textView3;
    }

    public static MiniGameSparkIncomeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameSparkIncomeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dki, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameSparkIncomeViewBinding bind(View view) {
        int i3 = R.id.rdv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rdv);
        if (imageView != null) {
            i3 = R.id.rdw;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rdw);
            if (imageView2 != null) {
                i3 = R.id.ren;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ren);
                if (linearLayout != null) {
                    i3 = R.id.rkz;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rkz);
                    if (linearLayout2 != null) {
                        i3 = R.id.rlk;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlk);
                        if (textView != null) {
                            i3 = R.id.rll;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.rll);
                            if (findChildViewById != null) {
                                i3 = R.id.rlr;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rlr);
                                if (textView2 != null) {
                                    i3 = R.id.rls;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rls);
                                    if (textView3 != null) {
                                        return new MiniGameSparkIncomeViewBinding((FrameLayout) view, imageView, imageView2, linearLayout, linearLayout2, textView, findChildViewById, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
