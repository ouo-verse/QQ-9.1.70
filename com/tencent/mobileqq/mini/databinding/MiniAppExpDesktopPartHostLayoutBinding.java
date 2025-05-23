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
public final class MiniAppExpDesktopPartHostLayoutBinding implements ViewBinding {
    public final View desktopDraggingProhibitClickView;
    public final RecyclerView microappEntryRecyclerview;
    public final FrameLayout miniAppEntryRoot;
    public final LinearLayout miniAppNormalStateLayout;
    private final FrameLayout rootView;

    MiniAppExpDesktopPartHostLayoutBinding(FrameLayout frameLayout, View view, RecyclerView recyclerView, FrameLayout frameLayout2, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.desktopDraggingProhibitClickView = view;
        this.microappEntryRecyclerview = recyclerView;
        this.miniAppEntryRoot = frameLayout2;
        this.miniAppNormalStateLayout = linearLayout;
    }

    public static MiniAppExpDesktopPartHostLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopPartHostLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.diy, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopPartHostLayoutBinding bind(View view) {
        int i3 = R.id.rcx;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.rcx);
        if (findChildViewById != null) {
            i3 = R.id.rf9;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rf9);
            if (recyclerView != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                i3 = R.id.f163688rh0;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163688rh0);
                if (linearLayout != null) {
                    return new MiniAppExpDesktopPartHostLayoutBinding(frameLayout, findChildViewById, recyclerView, frameLayout, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
