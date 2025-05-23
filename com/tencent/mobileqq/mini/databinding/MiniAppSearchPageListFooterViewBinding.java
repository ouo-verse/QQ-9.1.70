package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniAppSearchPageListFooterViewBinding implements ViewBinding {
    private final LinearLayout rootView;

    MiniAppSearchPageListFooterViewBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static MiniAppSearchPageListFooterViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppSearchPageListFooterViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppSearchPageListFooterViewBinding bind(View view) {
        if (view != null) {
            return new MiniAppSearchPageListFooterViewBinding((LinearLayout) view);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
