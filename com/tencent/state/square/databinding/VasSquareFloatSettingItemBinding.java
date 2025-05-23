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
public final class VasSquareFloatSettingItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SquareImageView squareSettingIcon;
    public final TextView squareSettingText;

    VasSquareFloatSettingItemBinding(LinearLayout linearLayout, SquareImageView squareImageView, TextView textView) {
        this.rootView = linearLayout;
        this.squareSettingIcon = squareImageView;
        this.squareSettingText = textView;
    }

    public static VasSquareFloatSettingItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFloatSettingItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4c, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFloatSettingItemBinding bind(View view) {
        int i3 = R.id.qn7;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qn7);
        if (squareImageView != null) {
            i3 = R.id.qn8;
            TextView textView = (TextView) view.findViewById(R.id.qn8);
            if (textView != null) {
                return new VasSquareFloatSettingItemBinding((LinearLayout) view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
