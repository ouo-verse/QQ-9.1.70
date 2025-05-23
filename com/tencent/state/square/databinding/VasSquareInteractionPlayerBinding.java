package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.SquareAvatarView;

/* loaded from: classes38.dex */
public final class VasSquareInteractionPlayerBinding implements ViewBinding {
    public final SquareAvatarView composedAvatar;
    public final FrameLayout interactionAvatarContainer;
    public final FrameLayout interactionTipLayout;
    public final FrameLayout pagContainer;
    private final FrameLayout rootView;
    public final TextView selectResultTip;

    VasSquareInteractionPlayerBinding(FrameLayout frameLayout, SquareAvatarView squareAvatarView, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, TextView textView) {
        this.rootView = frameLayout;
        this.composedAvatar = squareAvatarView;
        this.interactionAvatarContainer = frameLayout2;
        this.interactionTipLayout = frameLayout3;
        this.pagContainer = frameLayout4;
        this.selectResultTip = textView;
    }

    public static VasSquareInteractionPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareInteractionPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167407d52, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareInteractionPlayerBinding bind(View view) {
        int i3 = R.id.plj;
        SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.plj);
        if (squareAvatarView != null) {
            i3 = R.id.f163426q23;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f163426q23);
            if (frameLayout != null) {
                i3 = R.id.q2e;
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.q2e);
                if (frameLayout2 != null) {
                    i3 = R.id.qb_;
                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.qb_);
                    if (frameLayout3 != null) {
                        i3 = R.id.f163517qk0;
                        TextView textView = (TextView) view.findViewById(R.id.f163517qk0);
                        if (textView != null) {
                            return new VasSquareInteractionPlayerBinding((FrameLayout) view, squareAvatarView, frameLayout, frameLayout2, frameLayout3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
