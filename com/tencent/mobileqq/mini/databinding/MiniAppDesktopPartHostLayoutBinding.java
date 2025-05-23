package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniAppDesktopPartHostLayoutBinding implements ViewBinding {
    public final RecyclerView microappEntryRecyclerview;
    public final FrameLayout miniAppEntryRoot;
    public final LinearLayout miniAppNormalStateLayout;
    private final FrameLayout rootView;

    MiniAppDesktopPartHostLayoutBinding(FrameLayout frameLayout, RecyclerView recyclerView, FrameLayout frameLayout2, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.microappEntryRecyclerview = recyclerView;
        this.miniAppEntryRoot = frameLayout2;
        this.miniAppNormalStateLayout = linearLayout;
    }

    public static MiniAppDesktopPartHostLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppDesktopPartHostLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.die, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopPartHostLayoutBinding bind(View view) {
        int i3 = R.id.rf9;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rf9);
        if (recyclerView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163688rh0);
            if (linearLayout != null) {
                return new MiniAppDesktopPartHostLayoutBinding(frameLayout, recyclerView, frameLayout, linearLayout);
            }
            i3 = R.id.f163688rh0;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
