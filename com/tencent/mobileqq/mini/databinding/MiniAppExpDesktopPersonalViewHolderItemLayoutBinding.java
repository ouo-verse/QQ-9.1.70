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
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.qqnt.base.widget.RoundRectImageView;

/* loaded from: classes33.dex */
public final class MiniAppExpDesktopPersonalViewHolderItemLayoutBinding implements ViewBinding {
    public final LinearLayout microappItemsContainer;
    public final ImageView miniAppDragMirrorMarkImage;
    public final FrameLayout miniAppDragMirrorMarkImageFl;
    public final FrameLayout miniAppItemIconLayout;
    public final ImageView miniAppWxTagIv;
    public final RoundRectImageView miniappItemsImage;
    public final TextView miniappItemsText;
    public final TextView miniappItemsVersionTypeMark;
    private final LinearLayout rootView;
    public final QUIBadge unreadTag;

    MiniAppExpDesktopPersonalViewHolderItemLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView2, RoundRectImageView roundRectImageView, TextView textView, TextView textView2, QUIBadge qUIBadge) {
        this.rootView = linearLayout;
        this.microappItemsContainer = linearLayout2;
        this.miniAppDragMirrorMarkImage = imageView;
        this.miniAppDragMirrorMarkImageFl = frameLayout;
        this.miniAppItemIconLayout = frameLayout2;
        this.miniAppWxTagIv = imageView2;
        this.miniappItemsImage = roundRectImageView;
        this.miniappItemsText = textView;
        this.miniappItemsVersionTypeMark = textView2;
        this.unreadTag = qUIBadge;
    }

    public static MiniAppExpDesktopPersonalViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopPersonalViewHolderItemLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.rg9;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rg9);
        if (imageView != null) {
            i3 = R.id.rg_;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rg_);
            if (frameLayout != null) {
                i3 = R.id.rgn;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rgn);
                if (frameLayout2 != null) {
                    i3 = R.id.f163693ri0;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163693ri0);
                    if (imageView2 != null) {
                        i3 = R.id.rjn;
                        RoundRectImageView roundRectImageView = (RoundRectImageView) ViewBindings.findChildViewById(view, R.id.rjn);
                        if (roundRectImageView != null) {
                            i3 = R.id.rjq;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rjq);
                            if (textView != null) {
                                i3 = R.id.rjr;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rjr);
                                if (textView2 != null) {
                                    i3 = R.id.rlz;
                                    QUIBadge qUIBadge = (QUIBadge) ViewBindings.findChildViewById(view, R.id.rlz);
                                    if (qUIBadge != null) {
                                        return new MiniAppExpDesktopPersonalViewHolderItemLayoutBinding(linearLayout, linearLayout, imageView, frameLayout, frameLayout2, imageView2, roundRectImageView, textView, textView2, qUIBadge);
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

    public static MiniAppExpDesktopPersonalViewHolderItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167477dj1, viewGroup, false);
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
