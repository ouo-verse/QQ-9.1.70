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
public final class MiniAppExpDesktopPersonalAdapterViewHolderLayoutBinding implements ViewBinding {
    public final LinearLayout miniAppInnerMineRecyclerViewRoot;
    public final RecyclerView miniAppPersonalInnerRecyclerView;
    private final LinearLayout rootView;

    MiniAppExpDesktopPersonalAdapterViewHolderLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.miniAppInnerMineRecyclerViewRoot = linearLayout2;
        this.miniAppPersonalInnerRecyclerView = recyclerView;
    }

    public static MiniAppExpDesktopPersonalAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopPersonalAdapterViewHolderLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rh7);
        if (recyclerView != null) {
            return new MiniAppExpDesktopPersonalAdapterViewHolderLayoutBinding(linearLayout, linearLayout, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rh7)));
    }

    public static MiniAppExpDesktopPersonalAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167476dj0, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
