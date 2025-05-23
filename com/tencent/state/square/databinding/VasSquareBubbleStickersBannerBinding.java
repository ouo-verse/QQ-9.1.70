package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareBubbleStickersBannerBinding implements ViewBinding {
    public final LinearLayout likeContainer;
    private final View rootView;

    VasSquareBubbleStickersBannerBinding(View view, LinearLayout linearLayout) {
        this.rootView = view;
        this.likeContainer = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareBubbleStickersBannerBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f163445q54);
        if (linearLayout != null) {
            return new VasSquareBubbleStickersBannerBinding(view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f163445q54)));
    }

    public static VasSquareBubbleStickersBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3j, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
