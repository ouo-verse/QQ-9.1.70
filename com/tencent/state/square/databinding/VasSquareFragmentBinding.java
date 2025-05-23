package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFragmentBinding implements ViewBinding {
    public final SquareImageView background;
    public final FrameLayout fragment;
    private final FrameLayout rootView;
    public final View topBar;

    VasSquareFragmentBinding(FrameLayout frameLayout, SquareImageView squareImageView, FrameLayout frameLayout2, View view) {
        this.rootView = frameLayout;
        this.background = squareImageView;
        this.fragment = frameLayout2;
        this.topBar = view;
    }

    public static VasSquareFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4h, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentBinding bind(View view) {
        int i3 = R.id.pd8;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pd8);
        if (squareImageView != null) {
            i3 = R.id.pvv;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pvv);
            if (frameLayout != null) {
                i3 = R.id.qsb;
                View findViewById = view.findViewById(R.id.qsb);
                if (findViewById != null) {
                    return new VasSquareFragmentBinding((FrameLayout) view, squareImageView, frameLayout, findViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
