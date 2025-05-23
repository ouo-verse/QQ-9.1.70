package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLocationViewBinding implements ViewBinding {
    public final SquareImageView image;
    public final TextView locationText;
    private final View rootView;

    VasSquareLocationViewBinding(View view, SquareImageView squareImageView, TextView textView) {
        this.rootView = view;
        this.image = squareImageView;
        this.locationText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareLocationViewBinding bind(View view) {
        int i3 = R.id.q1_;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q1_);
        if (squareImageView != null) {
            i3 = R.id.q75;
            TextView textView = (TextView) view.findViewById(R.id.q75);
            if (textView != null) {
                return new VasSquareLocationViewBinding(view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareLocationViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d68, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
