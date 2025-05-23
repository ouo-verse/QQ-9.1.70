package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareAvatarComponentFixedIconBinding implements ViewBinding {
    public final SquareImageView fixedStatic;
    private final View rootView;

    VasSquareAvatarComponentFixedIconBinding(View view, SquareImageView squareImageView) {
        this.rootView = view;
        this.fixedStatic = squareImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareAvatarComponentFixedIconBinding bind(View view) {
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pud);
        if (squareImageView != null) {
            return new VasSquareAvatarComponentFixedIconBinding(view, squareImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.pud)));
    }

    public static VasSquareAvatarComponentFixedIconBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3c, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
