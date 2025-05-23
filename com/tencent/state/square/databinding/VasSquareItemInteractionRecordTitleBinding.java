package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemInteractionRecordTitleBinding implements ViewBinding {
    public final SquareImageView interactionRecordIcon;
    public final TextView interactionRecordTitle;
    private final LinearLayout rootView;

    VasSquareItemInteractionRecordTitleBinding(LinearLayout linearLayout, SquareImageView squareImageView, TextView textView) {
        this.rootView = linearLayout;
        this.interactionRecordIcon = squareImageView;
        this.interactionRecordTitle = textView;
    }

    public static VasSquareItemInteractionRecordTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemInteractionRecordTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5g, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemInteractionRecordTitleBinding bind(View view) {
        int i3 = R.id.q29;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q29);
        if (squareImageView != null) {
            i3 = R.id.q2c;
            TextView textView = (TextView) view.findViewById(R.id.q2c);
            if (textView != null) {
                return new VasSquareItemInteractionRecordTitleBinding((LinearLayout) view, squareImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
