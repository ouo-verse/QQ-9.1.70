package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.MarqueeTextView;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemBubbleSongBinding implements ViewBinding {
    public final SquareImageView avatarBubbleSongPlayIcon;
    public final MarqueeTextView avatarBubbleSongText;
    private final View rootView;

    VasSquareItemBubbleSongBinding(View view, SquareImageView squareImageView, MarqueeTextView marqueeTextView) {
        this.rootView = view;
        this.avatarBubbleSongPlayIcon = squareImageView;
        this.avatarBubbleSongText = marqueeTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareItemBubbleSongBinding bind(View view) {
        int i3 = R.id.pbs;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pbs);
        if (squareImageView != null) {
            i3 = R.id.pbt;
            MarqueeTextView marqueeTextView = (MarqueeTextView) view.findViewById(R.id.pbt);
            if (marqueeTextView != null) {
                return new VasSquareItemBubbleSongBinding(view, squareImageView, marqueeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareItemBubbleSongBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d5_, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
