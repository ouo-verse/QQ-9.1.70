package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquarePublicChatMsgPanelItemBinding implements ViewBinding {
    public final SquareImageView image;
    public final LinearLayout itemIcon;
    private final LinearLayout rootView;
    public final TextView text;

    VasSquarePublicChatMsgPanelItemBinding(LinearLayout linearLayout, SquareImageView squareImageView, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.image = squareImageView;
        this.itemIcon = linearLayout2;
        this.text = textView;
    }

    public static VasSquarePublicChatMsgPanelItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquarePublicChatMsgPanelItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6o, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquarePublicChatMsgPanelItemBinding bind(View view) {
        int i3 = R.id.q1_;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q1_);
        if (squareImageView != null) {
            i3 = R.id.q3a;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q3a);
            if (linearLayout != null) {
                i3 = R.id.qqa;
                TextView textView = (TextView) view.findViewById(R.id.qqa);
                if (textView != null) {
                    return new VasSquarePublicChatMsgPanelItemBinding((LinearLayout) view, squareImageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
