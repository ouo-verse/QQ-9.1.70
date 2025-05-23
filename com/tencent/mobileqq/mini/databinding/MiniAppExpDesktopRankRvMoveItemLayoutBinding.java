package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRankRvMoveItemLayoutBinding implements ViewBinding {
    public final ImageView moduleTitleMoreIcon;
    public final TextView moduleTitleMoreText;
    private final RelativeLayout rootView;

    MiniAppExpDesktopRankRvMoveItemLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.moduleTitleMoreIcon = imageView;
        this.moduleTitleMoreText = textView;
    }

    public static MiniAppExpDesktopRankRvMoveItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopRankRvMoveItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dj6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopRankRvMoveItemLayoutBinding bind(View view) {
        int i3 = R.id.rjw;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rjw);
        if (imageView != null) {
            i3 = R.id.rjy;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rjy);
            if (textView != null) {
                return new MiniAppExpDesktopRankRvMoveItemLayoutBinding((RelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
