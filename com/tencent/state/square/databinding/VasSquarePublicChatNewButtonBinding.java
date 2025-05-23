package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* loaded from: classes38.dex */
public final class VasSquarePublicChatNewButtonBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView titleText;

    VasSquarePublicChatNewButtonBinding(FrameLayout frameLayout, TextView textView) {
        this.rootView = frameLayout;
        this.titleText = textView;
    }

    public static VasSquarePublicChatNewButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquarePublicChatNewButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6p, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquarePublicChatNewButtonBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.qrw);
        if (textView != null) {
            return new VasSquarePublicChatNewButtonBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qrw)));
    }
}
