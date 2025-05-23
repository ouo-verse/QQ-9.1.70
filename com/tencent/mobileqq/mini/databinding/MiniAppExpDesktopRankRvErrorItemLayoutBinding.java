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
public final class MiniAppExpDesktopRankRvErrorItemLayoutBinding implements ViewBinding {
    private final FrameLayout rootView;

    MiniAppExpDesktopRankRvErrorItemLayoutBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public static MiniAppExpDesktopRankRvErrorItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopRankRvErrorItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167480dj4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopRankRvErrorItemLayoutBinding bind(View view) {
        if (view != null) {
            return new MiniAppExpDesktopRankRvErrorItemLayoutBinding((FrameLayout) view);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
