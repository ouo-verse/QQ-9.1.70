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
public final class MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding implements ViewBinding {
    public final ImageView moduleTitleMoreIcon;
    public final LinearLayout moduleTitleMoreLayout;
    public final TextView moduleTitleMoreText;
    public final TextView moduleTitleTitleTv;
    private final RelativeLayout rootView;

    MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.moduleTitleMoreIcon = imageView;
        this.moduleTitleMoreLayout = linearLayout;
        this.moduleTitleMoreText = textView;
        this.moduleTitleTitleTv = textView2;
    }

    public static MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.din, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding bind(View view) {
        int i3 = R.id.rjw;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rjw);
        if (imageView != null) {
            i3 = R.id.rjx;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rjx);
            if (linearLayout != null) {
                i3 = R.id.rjy;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rjy);
                if (textView != null) {
                    i3 = R.id.rjz;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rjz);
                    if (textView2 != null) {
                        return new MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding((RelativeLayout) view, imageView, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
