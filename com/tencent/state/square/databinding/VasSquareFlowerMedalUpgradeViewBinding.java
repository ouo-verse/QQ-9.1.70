package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFlowerMedalUpgradeViewBinding implements ViewBinding {
    public final SquareImageView medalBg;
    public final SquareImageView medalIcon;
    private final FrameLayout rootView;
    public final TextView tipsText;

    VasSquareFlowerMedalUpgradeViewBinding(FrameLayout frameLayout, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView) {
        this.rootView = frameLayout;
        this.medalBg = squareImageView;
        this.medalIcon = squareImageView2;
        this.tipsText = textView;
    }

    public static VasSquareFlowerMedalUpgradeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFlowerMedalUpgradeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFlowerMedalUpgradeViewBinding bind(View view) {
        int i3 = R.id.q8b;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q8b);
        if (squareImageView != null) {
            i3 = R.id.q8c;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.q8c);
            if (squareImageView2 != null) {
                i3 = R.id.f163556qr4;
                TextView textView = (TextView) view.findViewById(R.id.f163556qr4);
                if (textView != null) {
                    return new VasSquareFlowerMedalUpgradeViewBinding((FrameLayout) view, squareImageView, squareImageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
