package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareBubbleStickerBannerItemBinding implements ViewBinding {
    public final SquareImageView likeBgMe;
    public final SquareImageView likeBgUnread;
    public final SquareImageView likeIcon;
    public final FrameLayout likeItem;
    private final View rootView;

    VasSquareBubbleStickerBannerItemBinding(View view, SquareImageView squareImageView, SquareImageView squareImageView2, SquareImageView squareImageView3, FrameLayout frameLayout) {
        this.rootView = view;
        this.likeBgMe = squareImageView;
        this.likeBgUnread = squareImageView2;
        this.likeIcon = squareImageView3;
        this.likeItem = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareBubbleStickerBannerItemBinding bind(View view) {
        int i3 = R.id.f163442q51;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.f163442q51);
        if (squareImageView != null) {
            i3 = R.id.f163443q52;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.f163443q52);
            if (squareImageView2 != null) {
                i3 = R.id.q57;
                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.q57);
                if (squareImageView3 != null) {
                    i3 = R.id.q58;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.q58);
                    if (frameLayout != null) {
                        return new VasSquareBubbleStickerBannerItemBinding(view, squareImageView, squareImageView2, squareImageView3, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareBubbleStickerBannerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3i, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
