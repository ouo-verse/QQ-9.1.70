package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopModuleEmptyHintLayoutBinding implements ViewBinding {
    public final RelativeLayout miniAppDesktopEmptyHintLayout;
    public final TextView miniAppDesktopEmptyHintTv;
    private final RelativeLayout rootView;

    MiniAppExpDesktopModuleEmptyHintLayoutBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.miniAppDesktopEmptyHintLayout = relativeLayout2;
        this.miniAppDesktopEmptyHintTv = textView;
    }

    public static MiniAppExpDesktopModuleEmptyHintLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopModuleEmptyHintLayoutBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rg5);
        if (textView != null) {
            return new MiniAppExpDesktopModuleEmptyHintLayoutBinding(relativeLayout, relativeLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rg5)));
    }

    public static MiniAppExpDesktopModuleEmptyHintLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.diu, viewGroup, false);
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
