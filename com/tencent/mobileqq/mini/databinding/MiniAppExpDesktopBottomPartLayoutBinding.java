package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniAppExpDesktopBottomPartLayoutBinding implements ViewBinding {
    public final RelativeLayout deleteLayout;
    public final View deleteLayoutMirror;
    public final TextView deleteText;
    public final LinearLayout llMoreAdd;
    public final LinearLayout llMoreDelete;
    public final LinearLayout llMoreDeleteAdd;
    public final FrameLayout miniAppMoveUpGuide;
    public final ImageView miniAppMoveUpImg;
    public final TextView moreAdd;
    public final TextView moreDelete;
    private final FrameLayout rootView;

    MiniAppExpDesktopBottomPartLayoutBinding(FrameLayout frameLayout, RelativeLayout relativeLayout, View view, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout2, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.deleteLayout = relativeLayout;
        this.deleteLayoutMirror = view;
        this.deleteText = textView;
        this.llMoreAdd = linearLayout;
        this.llMoreDelete = linearLayout2;
        this.llMoreDeleteAdd = linearLayout3;
        this.miniAppMoveUpGuide = frameLayout2;
        this.miniAppMoveUpImg = imageView;
        this.moreAdd = textView2;
        this.moreDelete = textView3;
    }

    public static MiniAppExpDesktopBottomPartLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopBottomPartLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dio, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopBottomPartLayoutBinding bind(View view) {
        int i3 = R.id.rcv;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rcv);
        if (relativeLayout != null) {
            i3 = R.id.rcw;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.rcw);
            if (findChildViewById != null) {
                i3 = R.id.rcu;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rcu);
                if (textView != null) {
                    i3 = R.id.rer;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rer);
                    if (linearLayout != null) {
                        i3 = R.id.res;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.res);
                        if (linearLayout2 != null) {
                            i3 = R.id.ret;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ret);
                            if (linearLayout3 != null) {
                                FrameLayout frameLayout = (FrameLayout) view;
                                i3 = R.id.rgy;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rgy);
                                if (imageView != null) {
                                    i3 = R.id.f163703rk0;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163703rk0);
                                    if (textView2 != null) {
                                        i3 = R.id.f163704rk1;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f163704rk1);
                                        if (textView3 != null) {
                                            return new MiniAppExpDesktopBottomPartLayoutBinding(frameLayout, relativeLayout, findChildViewById, textView, linearLayout, linearLayout2, linearLayout3, frameLayout, imageView, textView2, textView3);
                                        }
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
