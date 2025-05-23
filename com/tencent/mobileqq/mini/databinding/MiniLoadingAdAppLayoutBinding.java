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
public final class MiniLoadingAdAppLayoutBinding implements ViewBinding {
    public final ImageView miniLoadingAdAppIcon;
    public final RelativeLayout miniLoadingAdAppLayout;
    public final TextView miniLoadingAdAppName;
    private final RelativeLayout rootView;

    MiniLoadingAdAppLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.miniLoadingAdAppIcon = imageView;
        this.miniLoadingAdAppLayout = relativeLayout2;
        this.miniLoadingAdAppName = textView;
    }

    public static MiniLoadingAdAppLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniLoadingAdAppLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkm, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniLoadingAdAppLayoutBinding bind(View view) {
        int i3 = R.id.rim;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rim);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rip);
            if (textView != null) {
                return new MiniLoadingAdAppLayoutBinding(relativeLayout, imageView, relativeLayout, textView);
            }
            i3 = R.id.rip;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
