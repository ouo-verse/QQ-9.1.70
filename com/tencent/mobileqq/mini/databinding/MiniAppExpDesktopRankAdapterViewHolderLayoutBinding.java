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
public final class MiniAppExpDesktopRankAdapterViewHolderLayoutBinding implements ViewBinding {
    public final MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding miniAppPersonalTabbarLayout;
    public final MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding miniAppPersonalTitleLayout;
    public final RecyclerView miniAppRankInnerRecyclerView;
    public final MiniAppExpDesktopRankRvLoadingItemLayoutBinding miniAppRankLoadingLayout;
    private final LinearLayout rootView;

    MiniAppExpDesktopRankAdapterViewHolderLayoutBinding(LinearLayout linearLayout, MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding miniAppExpDesktopAdapterViewHolderTabbarLayoutBinding, MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding miniAppExpDesktopAdapterViewHolderTitleLayoutBinding, RecyclerView recyclerView, MiniAppExpDesktopRankRvLoadingItemLayoutBinding miniAppExpDesktopRankRvLoadingItemLayoutBinding) {
        this.rootView = linearLayout;
        this.miniAppPersonalTabbarLayout = miniAppExpDesktopAdapterViewHolderTabbarLayoutBinding;
        this.miniAppPersonalTitleLayout = miniAppExpDesktopAdapterViewHolderTitleLayoutBinding;
        this.miniAppRankInnerRecyclerView = recyclerView;
        this.miniAppRankLoadingLayout = miniAppExpDesktopRankRvLoadingItemLayoutBinding;
    }

    public static MiniAppExpDesktopRankAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopRankAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167478dj2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopRankAdapterViewHolderLayoutBinding bind(View view) {
        int i3 = R.id.rh8;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.rh8);
        if (findChildViewById != null) {
            MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding bind = MiniAppExpDesktopAdapterViewHolderTabbarLayoutBinding.bind(findChildViewById);
            i3 = R.id.rh9;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.rh9);
            if (findChildViewById2 != null) {
                MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding bind2 = MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding.bind(findChildViewById2);
                i3 = R.id.rha;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rha);
                if (recyclerView != null) {
                    i3 = R.id.rhb;
                    View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.rhb);
                    if (findChildViewById3 != null) {
                        return new MiniAppExpDesktopRankAdapterViewHolderLayoutBinding((LinearLayout) view, bind, bind2, recyclerView, MiniAppExpDesktopRankRvLoadingItemLayoutBinding.bind(findChildViewById3));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
