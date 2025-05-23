package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareCallMateButtonViewBinding implements ViewBinding {
    public final LinearLayout btnCallMate;
    public final FrameLayout callMateBubble;
    private final FrameLayout rootView;
    public final TextView tvCallMateBubble;

    VasSquareCallMateButtonViewBinding(FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, TextView textView) {
        this.rootView = frameLayout;
        this.btnCallMate = linearLayout;
        this.callMateBubble = frameLayout2;
        this.tvCallMateBubble = textView;
    }

    public static VasSquareCallMateButtonViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareCallMateButtonViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3k, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareCallMateButtonViewBinding bind(View view) {
        int i3 = R.id.pfg;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pfg);
        if (linearLayout != null) {
            i3 = R.id.f163321pi0;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f163321pi0);
            if (frameLayout != null) {
                i3 = R.id.qt_;
                TextView textView = (TextView) view.findViewById(R.id.qt_);
                if (textView != null) {
                    return new VasSquareCallMateButtonViewBinding((FrameLayout) view, linearLayout, frameLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
