package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareFragmentChatLandRefreshPanelBinding implements ViewBinding {
    public final FrameLayout clickHit;
    public final FrameLayout pagContent;
    public final SquareImageView panelImage;
    private final View rootView;

    VasSquareFragmentChatLandRefreshPanelBinding(View view, FrameLayout frameLayout, FrameLayout frameLayout2, SquareImageView squareImageView) {
        this.rootView = view;
        this.clickHit = frameLayout;
        this.pagContent = frameLayout2;
        this.panelImage = squareImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentChatLandRefreshPanelBinding bind(View view) {
        int i3 = R.id.f163333pk2;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f163333pk2);
        if (frameLayout != null) {
            i3 = R.id.qba;
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.qba);
            if (frameLayout2 != null) {
                i3 = R.id.qbl;
                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qbl);
                if (squareImageView != null) {
                    return new VasSquareFragmentChatLandRefreshPanelBinding(view, frameLayout, frameLayout2, squareImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareFragmentChatLandRefreshPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d4j, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
