package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareChatLandRepeatListViewBinding implements ViewBinding {
    public final FrameLayout container;
    public final RecyclerView list;
    private final FrameLayout rootView;

    VasSquareChatLandRepeatListViewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.container = frameLayout2;
        this.list = recyclerView;
    }

    public static VasSquareChatLandRepeatListViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareChatLandRepeatListViewBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.q5l);
        if (recyclerView != null) {
            return new VasSquareChatLandRepeatListViewBinding((FrameLayout) view, frameLayout, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.q5l)));
    }

    public static VasSquareChatLandRepeatListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3s, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
