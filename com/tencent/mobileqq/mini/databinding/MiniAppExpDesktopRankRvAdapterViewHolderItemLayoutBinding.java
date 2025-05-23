package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.expDesktop.ui.MiniAppExpDesktopRankTags;
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRankRvAdapterViewHolderItemLayoutBinding implements ViewBinding {
    public final MiniAppExpDesktopRankTags miniAppExpDesktopRecommendTagContainer;
    public final ImageView miniAppWxTagIv;
    public final TextView miniappItemsAppDescTv;
    public final RoundRectImageView miniappItemsImage;
    public final TextView miniappItemsIndexTxtView;
    public final TextView miniappItemsText;
    private final LinearLayout rootView;

    MiniAppExpDesktopRankRvAdapterViewHolderItemLayoutBinding(LinearLayout linearLayout, MiniAppExpDesktopRankTags miniAppExpDesktopRankTags, ImageView imageView, TextView textView, RoundRectImageView roundRectImageView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.miniAppExpDesktopRecommendTagContainer = miniAppExpDesktopRankTags;
        this.miniAppWxTagIv = imageView;
        this.miniappItemsAppDescTv = textView;
        this.miniappItemsImage = roundRectImageView;
        this.miniappItemsIndexTxtView = textView2;
        this.miniappItemsText = textView3;
    }

    public static MiniAppExpDesktopRankRvAdapterViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopRankRvAdapterViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167479dj3, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopRankRvAdapterViewHolderItemLayoutBinding bind(View view) {
        int i3 = R.id.rge;
        MiniAppExpDesktopRankTags miniAppExpDesktopRankTags = (MiniAppExpDesktopRankTags) ViewBindings.findChildViewById(view, R.id.rge);
        if (miniAppExpDesktopRankTags != null) {
            i3 = R.id.f163693ri0;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163693ri0);
            if (imageView != null) {
                i3 = R.id.rjm;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rjm);
                if (textView != null) {
                    i3 = R.id.rjn;
                    RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.rjn);
                    if (roundRectImageView != null) {
                        i3 = R.id.rjo;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rjo);
                        if (textView2 != null) {
                            i3 = R.id.rjq;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rjq);
                            if (textView3 != null) {
                                return new MiniAppExpDesktopRankRvAdapterViewHolderItemLayoutBinding((LinearLayout) view, miniAppExpDesktopRankTags, imageView, textView, roundRectImageView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
