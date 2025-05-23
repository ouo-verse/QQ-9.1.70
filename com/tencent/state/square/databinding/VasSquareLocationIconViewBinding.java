package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLocationIconViewBinding implements ViewBinding {
    public final SquareImageView image;
    public final TextView locationText;
    private final LinearLayout rootView;

    VasSquareLocationIconViewBinding(LinearLayout linearLayout, SquareImageView squareImageView, TextView textView) {
        this.rootView = linearLayout;
        this.image = squareImageView;
        this.locationText = textView;
    }

    public static VasSquareLocationIconViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLocationIconViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d67, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLocationIconViewBinding bind(View view) {
        int i3 = R.id.q1_;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q1_);
        if (squareImageView != null) {
            i3 = R.id.q75;
            TextView textView = (TextView) view.findViewById(R.id.q75);
            if (textView != null) {
                return new VasSquareLocationIconViewBinding((LinearLayout) view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
