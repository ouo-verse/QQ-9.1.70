package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemLibraryImageBinding implements ViewBinding {
    public final ViewStub animateView;
    public final SquareImageView image;
    private final RelativeLayout rootView;

    VasSquareItemLibraryImageBinding(RelativeLayout relativeLayout, ViewStub viewStub, SquareImageView squareImageView) {
        this.rootView = relativeLayout;
        this.animateView = viewStub;
        this.image = squareImageView;
    }

    public static VasSquareItemLibraryImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemLibraryImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5j, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemLibraryImageBinding bind(View view) {
        int i3 = R.id.pah;
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.pah);
        if (viewStub != null) {
            i3 = R.id.q1_;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q1_);
            if (squareImageView != null) {
                return new VasSquareItemLibraryImageBinding((RelativeLayout) view, viewStub, squareImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
