package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareAvatarBubbleSimpleBinding implements ViewBinding {
    public final SquareImageView avatarBubbleIcon;
    private final View rootView;
    public final LinearLayout simpleSongContainer;
    public final FrameLayout simpleTextContainer;

    VasSquareAvatarBubbleSimpleBinding(View view, SquareImageView squareImageView, LinearLayout linearLayout, FrameLayout frameLayout) {
        this.rootView = view;
        this.avatarBubbleIcon = squareImageView;
        this.simpleSongContainer = linearLayout;
        this.simpleTextContainer = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareAvatarBubbleSimpleBinding bind(View view) {
        int i3 = R.id.pbp;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pbp);
        if (squareImageView != null) {
            i3 = R.id.qlz;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qlz);
            if (linearLayout != null) {
                i3 = R.id.f163527qm0;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f163527qm0);
                if (frameLayout != null) {
                    return new VasSquareAvatarBubbleSimpleBinding(view, squareImageView, linearLayout, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareAvatarBubbleSimpleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3a, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
