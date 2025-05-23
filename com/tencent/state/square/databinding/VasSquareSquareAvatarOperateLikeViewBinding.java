package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareSquareAvatarOperateLikeViewBinding implements ViewBinding {
    public final LinearLayout heart;
    public final SquareImageView likeSelected;
    public final SquareImageView likeUnselect;
    private final LinearLayout rootView;

    VasSquareSquareAvatarOperateLikeViewBinding(LinearLayout linearLayout, LinearLayout linearLayout2, SquareImageView squareImageView, SquareImageView squareImageView2) {
        this.rootView = linearLayout;
        this.heart = linearLayout2;
        this.likeSelected = squareImageView;
        this.likeUnselect = squareImageView2;
    }

    public static VasSquareSquareAvatarOperateLikeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareSquareAvatarOperateLikeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6u, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareSquareAvatarOperateLikeViewBinding bind(View view) {
        int i3 = R.id.pz6;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pz6);
        if (linearLayout != null) {
            i3 = R.id.q5c;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q5c);
            if (squareImageView != null) {
                i3 = R.id.q5e;
                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.q5e);
                if (squareImageView2 != null) {
                    return new VasSquareSquareAvatarOperateLikeViewBinding((LinearLayout) view, linearLayout, squareImageView, squareImageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
