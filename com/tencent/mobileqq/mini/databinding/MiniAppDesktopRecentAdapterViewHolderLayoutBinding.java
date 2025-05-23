package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppDesktopRecentAdapterViewHolderLayoutBinding implements ViewBinding {
    public final RecyclerView miniAppInnerRecentRecyclerView;
    public final MiniAppDesktopAdapterViewHolderTitleLayoutBinding recentTitleLayout;
    private final LinearLayout rootView;

    MiniAppDesktopRecentAdapterViewHolderLayoutBinding(LinearLayout linearLayout, RecyclerView recyclerView, MiniAppDesktopAdapterViewHolderTitleLayoutBinding miniAppDesktopAdapterViewHolderTitleLayoutBinding) {
        this.rootView = linearLayout;
        this.miniAppInnerRecentRecyclerView = recyclerView;
        this.recentTitleLayout = miniAppDesktopAdapterViewHolderTitleLayoutBinding;
    }

    public static MiniAppDesktopRecentAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppDesktopRecentAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dij, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppDesktopRecentAdapterViewHolderLayoutBinding bind(View view) {
        int i3 = R.id.rgk;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rgk);
        if (recyclerView != null) {
            i3 = R.id.rkx;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.rkx);
            if (findChildViewById != null) {
                return new MiniAppDesktopRecentAdapterViewHolderLayoutBinding((LinearLayout) view, recyclerView, MiniAppDesktopAdapterViewHolderTitleLayoutBinding.bind(findChildViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
