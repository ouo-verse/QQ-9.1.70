package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemBubbleSimpleMainContainerBinding implements ViewBinding {
    public final SquareImageView avatarSimpleBubbleIcon;
    public final TextView avatarSimpleBubbleMainText;
    public final FrameLayout avatarSimpleBubbleMainTextInnerContainer;
    private final View rootView;

    VasSquareItemBubbleSimpleMainContainerBinding(View view, SquareImageView squareImageView, TextView textView, FrameLayout frameLayout) {
        this.rootView = view;
        this.avatarSimpleBubbleIcon = squareImageView;
        this.avatarSimpleBubbleMainText = textView;
        this.avatarSimpleBubbleMainTextInnerContainer = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareItemBubbleSimpleMainContainerBinding bind(View view) {
        int i3 = R.id.pcm;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcm);
        if (squareImageView != null) {
            i3 = R.id.pcn;
            TextView textView = (TextView) view.findViewById(R.id.pcn);
            if (textView != null) {
                i3 = R.id.pco;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pco);
                if (frameLayout != null) {
                    return new VasSquareItemBubbleSimpleMainContainerBinding(view, squareImageView, textView, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareItemBubbleSimpleMainContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d59, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
