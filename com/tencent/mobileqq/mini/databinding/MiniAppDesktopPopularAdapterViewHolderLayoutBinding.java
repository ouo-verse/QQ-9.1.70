package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniAppDesktopPopularAdapterViewHolderLayoutBinding implements ViewBinding {
    public final RecyclerView miniAppInnerPopularRecyclerView;
    public final View miniAppModuleOuterDivider;
    public final MiniAppDesktopAdapterViewHolderTitleLayoutBinding recentTitleLayout;
    private final LinearLayout rootView;

    MiniAppDesktopPopularAdapterViewHolderLayoutBinding(LinearLayout linearLayout, RecyclerView recyclerView, View view, MiniAppDesktopAdapterViewHolderTitleLayoutBinding miniAppDesktopAdapterViewHolderTitleLayoutBinding) {
        this.rootView = linearLayout;
        this.miniAppInnerPopularRecyclerView = recyclerView;
        this.miniAppModuleOuterDivider = view;
        this.recentTitleLayout = miniAppDesktopAdapterViewHolderTitleLayoutBinding;
    }

    public static MiniAppDesktopPopularAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppDesktopPopularAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dih, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopPopularAdapterViewHolderLayoutBinding bind(View view) {
        int i3 = R.id.rgj;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rgj);
        if (recyclerView != null) {
            i3 = R.id.rgs;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.rgs);
            if (findChildViewById != null) {
                i3 = R.id.rkx;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.rkx);
                if (findChildViewById2 != null) {
                    return new MiniAppDesktopPopularAdapterViewHolderLayoutBinding((LinearLayout) view, recyclerView, findChildViewById, MiniAppDesktopAdapterViewHolderTitleLayoutBinding.bind(findChildViewById2));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
