package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareBottomActionSheetDialogBinding implements ViewBinding {
    public final LinearLayout actions;
    public final TextView cancel;
    private final LinearLayout rootView;

    VasSquareBottomActionSheetDialogBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.actions = linearLayout2;
        this.cancel = textView;
    }

    public static VasSquareBottomActionSheetDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareBottomActionSheetDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareBottomActionSheetDialogBinding bind(View view) {
        int i3 = R.id.p9x;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.p9x);
        if (linearLayout != null) {
            i3 = R.id.f163325pi4;
            TextView textView = (TextView) view.findViewById(R.id.f163325pi4);
            if (textView != null) {
                return new VasSquareBottomActionSheetDialogBinding((LinearLayout) view, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
