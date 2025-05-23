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
public final class VasSquareDetailItemActionViewBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SquareImageView titleRedPoint;
    public final TextView titleText;

    VasSquareDetailItemActionViewBinding(LinearLayout linearLayout, SquareImageView squareImageView, TextView textView) {
        this.rootView = linearLayout;
        this.titleRedPoint = squareImageView;
        this.titleText = textView;
    }

    public static VasSquareDetailItemActionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareDetailItemActionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167399d40, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareDetailItemActionViewBinding bind(View view) {
        int i3 = R.id.qru;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qru);
        if (squareImageView != null) {
            i3 = R.id.qrw;
            TextView textView = (TextView) view.findViewById(R.id.qrw);
            if (textView != null) {
                return new VasSquareDetailItemActionViewBinding((LinearLayout) view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
