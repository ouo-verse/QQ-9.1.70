package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppDesktopBannerAdapterViewHolderLayoutBinding implements ViewBinding {
    public final ImageView ivPullDownBanner;
    private final LinearLayout rootView;

    MiniAppDesktopBannerAdapterViewHolderLayoutBinding(LinearLayout linearLayout, ImageView imageView) {
        this.rootView = linearLayout;
        this.ivPullDownBanner = imageView;
    }

    public static MiniAppDesktopBannerAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppDesktopBannerAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dib, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopBannerAdapterViewHolderLayoutBinding bind(View view) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.reg);
        if (imageView != null) {
            return new MiniAppDesktopBannerAdapterViewHolderLayoutBinding((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.reg)));
    }
}
