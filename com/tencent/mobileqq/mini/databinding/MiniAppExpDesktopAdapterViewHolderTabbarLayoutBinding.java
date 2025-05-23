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
import com.tencent.mobileqq.mini.entry.expDesktop.ui.MiniAppExpDesktopTabBar;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding implements ViewBinding {
    public final ImageView moduleTabbarMoreIcon;
    public final LinearLayout moduleTabbarMoreLayout;
    public final TextView moduleTabbarMoreText;
    public final MiniAppExpDesktopTabBar moduleTabbarTabbarView;
    private final RelativeLayout rootView;

    MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, MiniAppExpDesktopTabBar miniAppExpDesktopTabBar) {
        this.rootView = relativeLayout;
        this.moduleTabbarMoreIcon = imageView;
        this.moduleTabbarMoreLayout = linearLayout;
        this.moduleTabbarMoreText = textView;
        this.moduleTabbarTabbarView = miniAppExpDesktopTabBar;
    }

    public static MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dim, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding bind(View view) {
        int i3 = R.id.rjs;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rjs);
        if (imageView != null) {
            i3 = R.id.rjt;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rjt);
            if (linearLayout != null) {
                i3 = R.id.rju;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rju);
                if (textView != null) {
                    i3 = R.id.rjv;
                    MiniAppExpDesktopTabBar miniAppExpDesktopTabBar = (MiniAppExpDesktopTabBar) ViewBindings.findChildViewById(view, R.id.rjv);
                    if (miniAppExpDesktopTabBar != null) {
                        return new MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding((RelativeLayout) view, imageView, linearLayout, textView, miniAppExpDesktopTabBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
