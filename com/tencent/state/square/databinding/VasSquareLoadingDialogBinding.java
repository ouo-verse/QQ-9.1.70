package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLoadingDialogBinding implements ViewBinding {
    public final TextView loadingText;
    private final FrameLayout rootView;

    VasSquareLoadingDialogBinding(FrameLayout frameLayout, TextView textView) {
        this.rootView = frameLayout;
        this.loadingText = textView;
    }

    public static VasSquareLoadingDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLoadingDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d66, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLoadingDialogBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.q6z);
        if (textView != null) {
            return new VasSquareLoadingDialogBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.q6z)));
    }
}
