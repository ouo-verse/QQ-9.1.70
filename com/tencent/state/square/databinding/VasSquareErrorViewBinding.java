package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareErrorViewBinding implements ViewBinding {
    public final SquareImageView errorIcon;
    public final RelativeLayout requestErrorBackground;
    private final RelativeLayout rootView;

    VasSquareErrorViewBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.errorIcon = squareImageView;
        this.requestErrorBackground = relativeLayout2;
    }

    public static VasSquareErrorViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareErrorViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareErrorViewBinding bind(View view) {
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.psr);
        if (squareImageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new VasSquareErrorViewBinding(relativeLayout, squareImageView, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.psr)));
    }
}
