package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* loaded from: classes38.dex */
public final class VasSquareTextPopupWindowBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView textView;

    VasSquareTextPopupWindowBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.textView = textView;
    }

    public static VasSquareTextPopupWindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareTextPopupWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6w, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareTextPopupWindowBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.qql);
        if (textView != null) {
            return new VasSquareTextPopupWindowBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qql)));
    }
}
