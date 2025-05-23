package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.container.core.MiniView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniContainerIndependentViewBinding implements ViewBinding {
    private final MiniView rootView;

    MiniContainerIndependentViewBinding(MiniView miniView) {
        this.rootView = miniView;
    }

    public static MiniContainerIndependentViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniContainerIndependentViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djs, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public MiniView getRoot() {
        return this.rootView;
    }

    public static MiniContainerIndependentViewBinding bind(View view) {
        if (view != null) {
            return new MiniContainerIndependentViewBinding((MiniView) view);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
