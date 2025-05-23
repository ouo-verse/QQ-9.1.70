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
public final class VasSquareMsgBoxButtonBinding implements ViewBinding {
    public final SquareImageView msgBoxIcon;
    public final FrameLayout msgBoxIconContainer;
    public final TextView msgBoxReddot;
    private final FrameLayout rootView;

    VasSquareMsgBoxButtonBinding(FrameLayout frameLayout, SquareImageView squareImageView, FrameLayout frameLayout2, TextView textView) {
        this.rootView = frameLayout;
        this.msgBoxIcon = squareImageView;
        this.msgBoxIconContainer = frameLayout2;
        this.msgBoxReddot = textView;
    }

    public static VasSquareMsgBoxButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareMsgBoxButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6c, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareMsgBoxButtonBinding bind(View view) {
        int i3 = R.id.q9m;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q9m);
        if (squareImageView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            TextView textView = (TextView) view.findViewById(R.id.q9o);
            if (textView != null) {
                return new VasSquareMsgBoxButtonBinding(frameLayout, squareImageView, frameLayout, textView);
            }
            i3 = R.id.q9o;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
