package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopModuleInnerRvLayoutBinding implements ViewBinding {
    public final RecyclerView miniAppPersonalInnerRecyclerView;
    private final RecyclerView rootView;

    MiniAppExpDesktopModuleInnerRvLayoutBinding(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.miniAppPersonalInnerRecyclerView = recyclerView2;
    }

    public static MiniAppExpDesktopModuleInnerRvLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopModuleInnerRvLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.div, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopModuleInnerRvLayoutBinding bind(View view) {
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view;
            return new MiniAppExpDesktopModuleInnerRvLayoutBinding(recyclerView, recyclerView);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
