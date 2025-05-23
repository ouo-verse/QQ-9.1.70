package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppKuiklyBaseFragmentLayoutBinding implements ViewBinding {
    public final FrameLayout miniKuiklyBaseFragmentRoot;
    private final FrameLayout rootView;

    MiniAppKuiklyBaseFragmentLayoutBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.miniKuiklyBaseFragmentRoot = frameLayout2;
    }

    public static MiniAppKuiklyBaseFragmentLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppKuiklyBaseFragmentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djb, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppKuiklyBaseFragmentLayoutBinding bind(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new MiniAppKuiklyBaseFragmentLayoutBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
