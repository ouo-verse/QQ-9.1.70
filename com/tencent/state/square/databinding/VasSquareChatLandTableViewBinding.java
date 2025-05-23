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
public final class VasSquareChatLandTableViewBinding implements ViewBinding {
    private final View rootView;
    public final SquareImageView table;

    VasSquareChatLandTableViewBinding(View view, SquareImageView squareImageView) {
        this.rootView = view;
        this.table = squareImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandTableViewBinding bind(View view) {
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qpc);
        if (squareImageView != null) {
            return new VasSquareChatLandTableViewBinding(view, squareImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qpc)));
    }

    public static VasSquareChatLandTableViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3u, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
