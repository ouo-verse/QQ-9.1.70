package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemLibraryImageAnimeteViewstubBinding implements ViewBinding {
    public final SquareImageView image;
    private final SquareImageView rootView;

    VasSquareItemLibraryImageAnimeteViewstubBinding(SquareImageView squareImageView, SquareImageView squareImageView2) {
        this.rootView = squareImageView;
        this.image = squareImageView2;
    }

    public static VasSquareItemLibraryImageAnimeteViewstubBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemLibraryImageAnimeteViewstubBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5k, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public SquareImageView getRoot() {
        return this.rootView;
    }

    public static VasSquareItemLibraryImageAnimeteViewstubBinding bind(View view) {
        if (view != null) {
            SquareImageView squareImageView = (SquareImageView) view;
            return new VasSquareItemLibraryImageAnimeteViewstubBinding(squareImageView, squareImageView);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
