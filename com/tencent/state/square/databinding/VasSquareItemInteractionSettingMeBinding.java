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
public final class VasSquareItemInteractionSettingMeBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SquareImageView vasSquareInteractionSettingItemImg;
    public final TextView vasSquareInteractionSettingItemText;

    VasSquareItemInteractionSettingMeBinding(LinearLayout linearLayout, SquareImageView squareImageView, TextView textView) {
        this.rootView = linearLayout;
        this.vasSquareInteractionSettingItemImg = squareImageView;
        this.vasSquareInteractionSettingItemText = textView;
    }

    public static VasSquareItemInteractionSettingMeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemInteractionSettingMeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5h, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemInteractionSettingMeBinding bind(View view) {
        int i3 = R.id.qww;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qww);
        if (squareImageView != null) {
            i3 = R.id.qwx;
            TextView textView = (TextView) view.findViewById(R.id.qwx);
            if (textView != null) {
                return new VasSquareItemInteractionSettingMeBinding((LinearLayout) view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
