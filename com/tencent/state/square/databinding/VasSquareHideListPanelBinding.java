package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* loaded from: classes38.dex */
public final class VasSquareHideListPanelBinding implements ViewBinding {
    public final LinearLayout empty;
    public final RecyclerView list;
    public final FrameLayout root;
    private final FrameLayout rootView;

    VasSquareHideListPanelBinding(FrameLayout frameLayout, LinearLayout linearLayout, RecyclerView recyclerView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.empty = linearLayout;
        this.list = recyclerView;
        this.root = frameLayout2;
    }

    public static VasSquareHideListPanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareHideListPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4z, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareHideListPanelBinding bind(View view) {
        int i3 = R.id.prf;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.prf);
        if (linearLayout != null) {
            i3 = R.id.q5l;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.q5l);
            if (recyclerView != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                return new VasSquareHideListPanelBinding(frameLayout, linearLayout, recyclerView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
