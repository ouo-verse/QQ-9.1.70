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
public final class VasSquareMayKnowLabelBinding implements ViewBinding {
    public final SquareImageView mayKnowIcon;
    public final TextView mayKnowText;
    private final View rootView;

    VasSquareMayKnowLabelBinding(View view, SquareImageView squareImageView, TextView textView) {
        this.rootView = view;
        this.mayKnowIcon = squareImageView;
        this.mayKnowText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareMayKnowLabelBinding bind(View view) {
        int i3 = R.id.f163460q83;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163460q83);
        if (squareImageView != null) {
            i3 = R.id.q8_;
            TextView textView = (TextView) view.findViewById(R.id.q8_);
            if (textView != null) {
                return new VasSquareMayKnowLabelBinding(view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareMayKnowLabelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d6_, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
