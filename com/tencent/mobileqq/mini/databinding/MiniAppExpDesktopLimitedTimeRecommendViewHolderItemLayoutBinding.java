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
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopLimitedTimeRecommendViewHolderItemLayoutBinding implements ViewBinding {
    public final LinearLayout microappItemsContainer;
    public final FrameLayout miniAppItemIconLayout;
    public final ImageView miniAppWxTagIv;
    public final RoundRectImageView miniappItemsImage;
    public final TextView miniappItemsText;
    public final TextView miniappItemsVersionTypeMark;
    private final LinearLayout rootView;

    MiniAppExpDesktopLimitedTimeRecommendViewHolderItemLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, ImageView imageView, RoundRectImageView roundRectImageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.microappItemsContainer = linearLayout2;
        this.miniAppItemIconLayout = frameLayout;
        this.miniAppWxTagIv = imageView;
        this.miniappItemsImage = roundRectImageView;
        this.miniappItemsText = textView;
        this.miniappItemsVersionTypeMark = textView2;
    }

    public static MiniAppExpDesktopLimitedTimeRecommendViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopLimitedTimeRecommendViewHolderItemLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.rgn;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rgn);
        if (frameLayout != null) {
            i3 = R.id.f163693ri0;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163693ri0);
            if (imageView != null) {
                i3 = R.id.rjn;
                RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.rjn);
                if (roundRectImageView != null) {
                    i3 = R.id.rjq;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rjq);
                    if (textView != null) {
                        i3 = R.id.rjr;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rjr);
                        if (textView2 != null) {
                            return new MiniAppExpDesktopLimitedTimeRecommendViewHolderItemLayoutBinding(linearLayout, linearLayout, frameLayout, imageView, roundRectImageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static MiniAppExpDesktopLimitedTimeRecommendViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dis, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
