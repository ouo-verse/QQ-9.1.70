package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.SquareView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ZtpSquareChatLandFragmentBinding implements ViewBinding {
    public final SquareImageView back;
    public final VasSquareErrorViewBinding requestErrorBackground;
    private final FrameLayout rootView;
    public final FrameLayout square;
    public final View squareTopBar;
    public final SquareView squareView;

    ZtpSquareChatLandFragmentBinding(FrameLayout frameLayout, SquareImageView squareImageView, VasSquareErrorViewBinding vasSquareErrorViewBinding, FrameLayout frameLayout2, View view, SquareView squareView) {
        this.rootView = frameLayout;
        this.back = squareImageView;
        this.requestErrorBackground = vasSquareErrorViewBinding;
        this.square = frameLayout2;
        this.squareTopBar = view;
        this.squareView = squareView;
    }

    public static ZtpSquareChatLandFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareChatLandFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dho, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public FrameLayout getMRv() {
        return this.rootView;
    }

    public static ZtpSquareChatLandFragmentBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.qh9;
            View findViewById = view.findViewById(R.id.qh9);
            if (findViewById != null) {
                VasSquareErrorViewBinding bind = VasSquareErrorViewBinding.bind(findViewById);
                FrameLayout frameLayout = (FrameLayout) view;
                i3 = R.id.qn9;
                View findViewById2 = view.findViewById(R.id.qn9);
                if (findViewById2 != null) {
                    i3 = R.id.qn_;
                    SquareView squareView = (SquareView) view.findViewById(R.id.qn_);
                    if (squareView != null) {
                        return new ZtpSquareChatLandFragmentBinding(frameLayout, squareImageView, bind, frameLayout, findViewById2, squareView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
