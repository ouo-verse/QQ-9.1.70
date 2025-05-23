package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareActivityCommonBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    private final FrameLayout rootView;

    VasSquareActivityCommonBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.fragmentContainer = frameLayout2;
    }

    public static VasSquareActivityCommonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareActivityCommonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d38, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareActivityCommonBinding bind(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new VasSquareActivityCommonBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
