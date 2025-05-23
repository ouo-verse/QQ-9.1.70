package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppSearchbarAnimViewBinding implements ViewBinding {
    public final RelativeLayout miniApoDesktopCapsuleRl;
    public final ImageView miniAppCloseDesktopIv;
    public final RelativeLayout miniAppDesktopCapsuleLeftBtnContainerRl;
    public final ImageView miniAppDesktopCapsuleLeftIv;
    public final TextView miniAppDesktopLeftBtnRedDotTv;
    public final LinearLayout miniAppSearchContainer;
    public final TextView miniAppSearchKeyword;
    public final ImageView quiBackIv;
    public final TextView quiCancelTv;
    private final LinearLayout rootView;
    public final TextView tvMiniappTitle;
    public final RelativeLayout tvMiniappTitleContainer;

    MiniAppSearchbarAnimViewBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, ImageView imageView2, TextView textView, LinearLayout linearLayout2, TextView textView2, ImageView imageView3, TextView textView3, TextView textView4, RelativeLayout relativeLayout3) {
        this.rootView = linearLayout;
        this.miniApoDesktopCapsuleRl = relativeLayout;
        this.miniAppCloseDesktopIv = imageView;
        this.miniAppDesktopCapsuleLeftBtnContainerRl = relativeLayout2;
        this.miniAppDesktopCapsuleLeftIv = imageView2;
        this.miniAppDesktopLeftBtnRedDotTv = textView;
        this.miniAppSearchContainer = linearLayout2;
        this.miniAppSearchKeyword = textView2;
        this.quiBackIv = imageView3;
        this.quiCancelTv = textView3;
        this.tvMiniappTitle = textView4;
        this.tvMiniappTitleContainer = relativeLayout3;
    }

    public static MiniAppSearchbarAnimViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppSearchbarAnimViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djm, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppSearchbarAnimViewBinding bind(View view) {
        int i3 = R.id.rfc;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rfc);
        if (relativeLayout != null) {
            i3 = R.id.rfg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rfg);
            if (imageView != null) {
                i3 = R.id.rfq;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rfq);
                if (relativeLayout2 != null) {
                    i3 = R.id.rfs;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rfs);
                    if (imageView2 != null) {
                        i3 = R.id.rg6;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rg6);
                        if (textView != null) {
                            i3 = R.id.rhi;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rhi);
                            if (linearLayout != null) {
                                i3 = R.id.rhm;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rhm);
                                if (textView2 != null) {
                                    i3 = R.id.rkt;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.rkt);
                                    if (imageView3 != null) {
                                        i3 = R.id.rku;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rku);
                                        if (textView3 != null) {
                                            i3 = R.id.rln;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.rln);
                                            if (textView4 != null) {
                                                i3 = R.id.rlo;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rlo);
                                                if (relativeLayout3 != null) {
                                                    return new MiniAppSearchbarAnimViewBinding((LinearLayout) view, relativeLayout, imageView, relativeLayout2, imageView2, textView, linearLayout, textView2, imageView3, textView3, textView4, relativeLayout3);
                                                }
                                            }
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
