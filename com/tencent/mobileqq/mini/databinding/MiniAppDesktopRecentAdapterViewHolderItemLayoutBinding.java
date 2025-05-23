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
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppDesktopRecentAdapterViewHolderItemLayoutBinding implements ViewBinding {
    public final LinearLayout microappItemsContainer;
    public final TextView miniAppAdText;
    public final ImageView miniAppDragMirrorMarkImage;
    public final FrameLayout miniAppDragMirrorMarkImageFl;
    public final RelativeLayout miniAppItemIconLayout;
    public final LinearLayout miniAppItemLayout;
    public final RelativeLayout miniAppRecommendBubble;
    public final ImageView miniAppRecommendBubbleBg;
    public final TextView miniAppRecommendBubbleText;
    public final ImageView miniAppRecommendMark;
    public final TextView miniAppRedDot;
    public final LinearLayout miniappDivierLine;
    public final RoundRectImageView miniappItemsImage;
    public final TextView miniappItemsText;
    public final TextView miniappItemsVersionTypeMark;
    private final LinearLayout rootView;

    public static MiniAppDesktopRecentAdapterViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    MiniAppDesktopRecentAdapterViewHolderItemLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ImageView imageView, FrameLayout frameLayout, RelativeLayout relativeLayout, LinearLayout linearLayout3, RelativeLayout relativeLayout2, ImageView imageView2, TextView textView2, ImageView imageView3, TextView textView3, LinearLayout linearLayout4, RoundRectImageView roundRectImageView, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.microappItemsContainer = linearLayout2;
        this.miniAppAdText = textView;
        this.miniAppDragMirrorMarkImage = imageView;
        this.miniAppDragMirrorMarkImageFl = frameLayout;
        this.miniAppItemIconLayout = relativeLayout;
        this.miniAppItemLayout = linearLayout3;
        this.miniAppRecommendBubble = relativeLayout2;
        this.miniAppRecommendBubbleBg = imageView2;
        this.miniAppRecommendBubbleText = textView2;
        this.miniAppRecommendMark = imageView3;
        this.miniAppRedDot = textView3;
        this.miniappDivierLine = linearLayout4;
        this.miniappItemsImage = roundRectImageView;
        this.miniappItemsText = textView4;
        this.miniappItemsVersionTypeMark = textView5;
    }

    public static MiniAppDesktopRecentAdapterViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dii, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopRecentAdapterViewHolderItemLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.rfd;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rfd);
        if (textView != null) {
            i3 = R.id.rg9;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rg9);
            if (imageView != null) {
                i3 = R.id.rg_;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rg_);
                if (frameLayout != null) {
                    i3 = R.id.rgn;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rgn);
                    if (relativeLayout != null) {
                        i3 = R.id.rgp;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rgp);
                        if (linearLayout2 != null) {
                            i3 = R.id.rhc;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rhc);
                            if (relativeLayout2 != null) {
                                i3 = R.id.rhd;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rhd);
                                if (imageView2 != null) {
                                    i3 = R.id.rhe;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rhe);
                                    if (textView2 != null) {
                                        i3 = R.id.rhf;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.rhf);
                                        if (imageView3 != null) {
                                            i3 = R.id.rhg;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rhg);
                                            if (textView3 != null) {
                                                i3 = R.id.rjk;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rjk);
                                                if (linearLayout3 != null) {
                                                    i3 = R.id.rjn;
                                                    RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.rjn);
                                                    if (roundRectImageView != null) {
                                                        i3 = R.id.rjq;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.rjq);
                                                        if (textView4 != null) {
                                                            i3 = R.id.rjr;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.rjr);
                                                            if (textView5 != null) {
                                                                return new MiniAppDesktopRecentAdapterViewHolderItemLayoutBinding(linearLayout, linearLayout, textView, imageView, frameLayout, relativeLayout, linearLayout2, relativeLayout2, imageView2, textView2, imageView3, textView3, linearLayout3, roundRectImageView, textView4, textView5);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
