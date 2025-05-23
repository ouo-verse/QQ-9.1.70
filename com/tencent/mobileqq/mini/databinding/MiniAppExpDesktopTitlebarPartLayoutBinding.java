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

/* loaded from: classes33.dex */
public final class MiniAppExpDesktopTitlebarPartLayoutBinding implements ViewBinding {
    public final RelativeLayout microappEntryNavbarLayout;
    public final TextView miniAppDesktopTitle;
    public final ImageView miniAppNotificationBtn;
    private final RelativeLayout rootView;

    MiniAppExpDesktopTitlebarPartLayoutBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, ImageView imageView) {
        this.rootView = relativeLayout;
        this.microappEntryNavbarLayout = relativeLayout2;
        this.miniAppDesktopTitle = textView;
        this.miniAppNotificationBtn = imageView;
    }

    public static MiniAppExpDesktopTitlebarPartLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopTitlebarPartLayoutBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i3 = R.id.rg8;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rg8);
        if (textView != null) {
            i3 = R.id.f163690rh2;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163690rh2);
            if (imageView != null) {
                return new MiniAppExpDesktopTitlebarPartLayoutBinding(relativeLayout, relativeLayout, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static MiniAppExpDesktopTitlebarPartLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dj8, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
