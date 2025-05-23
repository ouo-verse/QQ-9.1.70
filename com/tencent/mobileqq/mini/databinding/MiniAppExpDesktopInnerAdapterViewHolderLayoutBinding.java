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
public final class MiniAppExpDesktopInnerAdapterViewHolderLayoutBinding implements ViewBinding {
    public final LinearLayout miniAppInnerRecyclerViewRoot;
    public final RecyclerView miniAppSubInnerRecyclerView;
    private final LinearLayout rootView;

    MiniAppExpDesktopInnerAdapterViewHolderLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.miniAppInnerRecyclerViewRoot = linearLayout2;
        this.miniAppSubInnerRecyclerView = recyclerView;
    }

    public static MiniAppExpDesktopInnerAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopInnerAdapterViewHolderLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rht);
        if (recyclerView != null) {
            return new MiniAppExpDesktopInnerAdapterViewHolderLayoutBinding(linearLayout, linearLayout, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rht)));
    }

    public static MiniAppExpDesktopInnerAdapterViewHolderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.diq, viewGroup, false);
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
