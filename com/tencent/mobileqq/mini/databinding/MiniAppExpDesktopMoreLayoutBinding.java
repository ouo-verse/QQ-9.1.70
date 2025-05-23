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

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopMoreLayoutBinding implements ViewBinding {
    public final ImageView miniAppMoreIcon;
    public final LinearLayout miniAppMoreLayout;
    public final TextView miniAppMoreText;
    private final LinearLayout rootView;

    MiniAppExpDesktopMoreLayoutBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.miniAppMoreIcon = imageView;
        this.miniAppMoreLayout = linearLayout2;
        this.miniAppMoreText = textView;
    }

    public static MiniAppExpDesktopMoreLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopMoreLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.diw, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopMoreLayoutBinding bind(View view) {
        int i3 = R.id.rgu;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rgu);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rgw);
            if (textView != null) {
                return new MiniAppExpDesktopMoreLayoutBinding(linearLayout, imageView, linearLayout, textView);
            }
            i3 = R.id.rgw;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
