package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareOperateSquareLikeAnimationBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final FrameLayout vasSquareLikeAnimationContainer;

    VasSquareOperateSquareLikeAnimationBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.vasSquareLikeAnimationContainer = frameLayout2;
    }

    public static VasSquareOperateSquareLikeAnimationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareOperateSquareLikeAnimationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6k, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareOperateSquareLikeAnimationBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f163585qx3);
        if (frameLayout != null) {
            return new VasSquareOperateSquareLikeAnimationBinding((FrameLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f163585qx3)));
    }
}
