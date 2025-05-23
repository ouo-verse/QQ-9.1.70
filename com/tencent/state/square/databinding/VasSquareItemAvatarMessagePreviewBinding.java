package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* loaded from: classes38.dex */
public final class VasSquareItemAvatarMessagePreviewBinding implements ViewBinding {
    public final FrameLayout avatarMessagePreviewContainer;
    public final FrameLayout avatarMessagePreviewSummary;
    public final TextView avatarMessagePreviewText;
    private final FrameLayout rootView;

    VasSquareItemAvatarMessagePreviewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, TextView textView) {
        this.rootView = frameLayout;
        this.avatarMessagePreviewContainer = frameLayout2;
        this.avatarMessagePreviewSummary = frameLayout3;
        this.avatarMessagePreviewText = textView;
    }

    public static VasSquareItemAvatarMessagePreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemAvatarMessagePreviewBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i3 = R.id.pcb;
        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.pcb);
        if (frameLayout2 != null) {
            i3 = R.id.pcc;
            TextView textView = (TextView) view.findViewById(R.id.pcc);
            if (textView != null) {
                return new VasSquareItemAvatarMessagePreviewBinding((FrameLayout) view, frameLayout, frameLayout2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareItemAvatarMessagePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d57, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
