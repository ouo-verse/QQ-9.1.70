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
import com.tencent.widget.ThemeImageView;

/* loaded from: classes33.dex */
public final class MiniAppDesktopPopularAdapterViewHolderItemLayoutBinding implements ViewBinding {
    public final LinearLayout microappItemsContainer;
    public final ImageView miniAppIndexPicView;
    public final FrameLayout miniAppItemHeader;
    public final FrameLayout miniAppItemIndex;
    public final RelativeLayout miniAppItemLayout;
    public final RelativeLayout miniAppRecommendBubble;
    public final ImageView miniAppRecommendBubbleBg;
    public final TextView miniAppRecommendBubbleText;
    public final ImageView miniAppRecommendMark;
    public final TextView miniAppRedDot;
    public final LinearLayout miniappDivierLine;
    public final LinearLayout miniappItemText;
    public final ThemeImageView miniappItemsImage;
    public final RoundRectImageView miniappItemsImage1;
    public final TextView miniappItemsIndexTxtView;
    public final TextView miniappItemsSubText;
    public final TextView miniappItemsText;
    public final TextView miniappItemsVersionTypeMark;
    private final LinearLayout rootView;

    public static MiniAppDesktopPopularAdapterViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    MiniAppDesktopPopularAdapterViewHolderItemLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2, LinearLayout linearLayout3, LinearLayout linearLayout4, ThemeImageView themeImageView, RoundRectImageView roundRectImageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.microappItemsContainer = linearLayout2;
        this.miniAppIndexPicView = imageView;
        this.miniAppItemHeader = frameLayout;
        this.miniAppItemIndex = frameLayout2;
        this.miniAppItemLayout = relativeLayout;
        this.miniAppRecommendBubble = relativeLayout2;
        this.miniAppRecommendBubbleBg = imageView2;
        this.miniAppRecommendBubbleText = textView;
        this.miniAppRecommendMark = imageView3;
        this.miniAppRedDot = textView2;
        this.miniappDivierLine = linearLayout3;
        this.miniappItemText = linearLayout4;
        this.miniappItemsImage = themeImageView;
        this.miniappItemsImage1 = roundRectImageView;
        this.miniappItemsIndexTxtView = textView3;
        this.miniappItemsSubText = textView4;
        this.miniappItemsText = textView5;
        this.miniappItemsVersionTypeMark = textView6;
    }

    public static MiniAppDesktopPopularAdapterViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dig, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopPopularAdapterViewHolderItemLayoutBinding bind(View view) {
        RoundRectImageView roundRectImageView;
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.rgf;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rgf);
        if (imageView != null) {
            i3 = R.id.rgm;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rgm);
            if (frameLayout != null) {
                i3 = R.id.rgo;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rgo);
                if (frameLayout2 != null) {
                    i3 = R.id.rgp;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rgp);
                    if (relativeLayout != null) {
                        i3 = R.id.rhc;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rhc);
                        if (relativeLayout2 != null) {
                            i3 = R.id.rhd;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rhd);
                            if (imageView2 != null) {
                                i3 = R.id.rhe;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rhe);
                                if (textView != null) {
                                    i3 = R.id.rhf;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.rhf);
                                    if (imageView3 != null) {
                                        i3 = R.id.rhg;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rhg);
                                        if (textView2 != null) {
                                            i3 = R.id.rjk;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rjk);
                                            if (linearLayout2 != null) {
                                                i3 = R.id.rjl;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rjl);
                                                if (linearLayout3 != null) {
                                                    i3 = R.id.rjn;
                                                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, R.id.rjn);
                                                    if (themeImageView != null && (roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.rjn)) != null) {
                                                        i3 = R.id.rjo;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rjo);
                                                        if (textView3 != null) {
                                                            i3 = R.id.rjp;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.rjp);
                                                            if (textView4 != null) {
                                                                i3 = R.id.rjq;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.rjq);
                                                                if (textView5 != null) {
                                                                    i3 = R.id.rjr;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.rjr);
                                                                    if (textView6 != null) {
                                                                        return new MiniAppDesktopPopularAdapterViewHolderItemLayoutBinding(linearLayout, linearLayout, imageView, frameLayout, frameLayout2, relativeLayout, relativeLayout2, imageView2, textView, imageView3, textView2, linearLayout2, linearLayout3, themeImageView, roundRectImageView, textView3, textView4, textView5, textView6);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
