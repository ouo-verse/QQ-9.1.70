package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareInteractionRecordLayoutBinding implements ViewBinding {
    public final SquareImageView interactionRecordIcon;
    public final SquareImageView interactionRecordUnreadPoint;
    private final FrameLayout rootView;

    VasSquareInteractionRecordLayoutBinding(FrameLayout frameLayout, SquareImageView squareImageView, SquareImageView squareImageView2) {
        this.rootView = frameLayout;
        this.interactionRecordIcon = squareImageView;
        this.interactionRecordUnreadPoint = squareImageView2;
    }

    public static VasSquareInteractionRecordLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareInteractionRecordLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167409d54, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareInteractionRecordLayoutBinding bind(View view) {
        int i3 = R.id.q29;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q29);
        if (squareImageView != null) {
            i3 = R.id.q2d;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.q2d);
            if (squareImageView2 != null) {
                return new VasSquareInteractionRecordLayoutBinding((FrameLayout) view, squareImageView, squareImageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
