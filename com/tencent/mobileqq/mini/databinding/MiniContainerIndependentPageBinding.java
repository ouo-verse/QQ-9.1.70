package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.container.core.MiniView;

/* loaded from: classes33.dex */
public final class MiniContainerIndependentPageBinding implements ViewBinding {
    public final MiniView miniView;
    private final FrameLayout rootView;

    MiniContainerIndependentPageBinding(FrameLayout frameLayout, MiniView miniView) {
        this.rootView = frameLayout;
        this.miniView = miniView;
    }

    public static MiniContainerIndependentPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniContainerIndependentPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniContainerIndependentPageBinding bind(View view) {
        MiniView miniView = (MiniView) ViewBindings.findChildViewById(view, R.id.rjj);
        if (miniView != null) {
            return new MiniContainerIndependentPageBinding((FrameLayout) view, miniView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rjj)));
    }
}
