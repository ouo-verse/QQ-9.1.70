package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.square.avatar.SquareAvatarView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibrarySingleViewBinding implements ViewBinding {
    public final SquareAvatarView avatarImage;
    public final FocusCommonView commonView;
    private final FrameLayout rootView;

    VasSquareLibrarySingleViewBinding(FrameLayout frameLayout, SquareAvatarView squareAvatarView, FocusCommonView focusCommonView) {
        this.rootView = frameLayout;
        this.avatarImage = squareAvatarView;
        this.commonView = focusCommonView;
    }

    public static VasSquareLibrarySingleViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibrarySingleViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5z, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLibrarySingleViewBinding bind(View view) {
        int i3 = R.id.pbz;
        SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.pbz);
        if (squareAvatarView != null) {
            i3 = R.id.plf;
            FocusCommonView focusCommonView = (FocusCommonView) view.findViewById(R.id.plf);
            if (focusCommonView != null) {
                return new VasSquareLibrarySingleViewBinding((FrameLayout) view, squareAvatarView, focusCommonView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
