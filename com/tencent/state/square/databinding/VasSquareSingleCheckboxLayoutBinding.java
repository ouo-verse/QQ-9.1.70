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
public final class VasSquareSingleCheckboxLayoutBinding implements ViewBinding {
    public final LinearLayout checkboxContainer;
    public final SquareImageView checkboxIcon;
    public final TextView checkboxText;
    private final LinearLayout rootView;

    VasSquareSingleCheckboxLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, SquareImageView squareImageView, TextView textView) {
        this.rootView = linearLayout;
        this.checkboxContainer = linearLayout2;
        this.checkboxIcon = squareImageView;
        this.checkboxText = textView;
    }

    public static VasSquareSingleCheckboxLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareSingleCheckboxLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.pjc;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pjc);
        if (squareImageView != null) {
            i3 = R.id.pje;
            TextView textView = (TextView) view.findViewById(R.id.pje);
            if (textView != null) {
                return new VasSquareSingleCheckboxLayoutBinding((LinearLayout) view, linearLayout, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareSingleCheckboxLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6t, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
