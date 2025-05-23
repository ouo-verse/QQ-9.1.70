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

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameDownloadingBinding implements ViewBinding {
    public final LinearLayout emptyView;
    public final RecyclerView list;
    private final FrameLayout rootView;

    MiniGameDownloadingBinding(FrameLayout frameLayout, LinearLayout linearLayout, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.emptyView = linearLayout;
        this.list = recyclerView;
    }

    public static MiniGameDownloadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameDownloadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djz, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameDownloadingBinding bind(View view) {
        int i3 = R.id.rdj;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rdj);
        if (linearLayout != null) {
            i3 = R.id.rep;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rep);
            if (recyclerView != null) {
                return new MiniGameDownloadingBinding((FrameLayout) view, linearLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
