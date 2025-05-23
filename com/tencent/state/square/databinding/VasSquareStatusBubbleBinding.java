package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.SquareAvatarView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareStatusBubbleBinding implements ViewBinding {
    public final SquareAvatarView avatarView;
    private final RelativeLayout rootView;

    VasSquareStatusBubbleBinding(RelativeLayout relativeLayout, SquareAvatarView squareAvatarView) {
        this.rootView = relativeLayout;
        this.avatarView = squareAvatarView;
    }

    public static VasSquareStatusBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareStatusBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6v, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareStatusBubbleBinding bind(View view) {
        SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.pcs);
        if (squareAvatarView != null) {
            return new VasSquareStatusBubbleBinding((RelativeLayout) view, squareAvatarView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.pcs)));
    }
}
