package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareBubbleItemBinding implements ViewBinding {
    public final SquareImageView bubbleConfirm;
    public final SquareImageView bubbleIcon;
    public final RelativeLayout bubbleItem;
    public final SquareImageView bubbleLock;
    public final TextView name;
    private final LinearLayout rootView;
    public final TextView validTimeLabel;

    VasSquareBubbleItemBinding(LinearLayout linearLayout, SquareImageView squareImageView, SquareImageView squareImageView2, RelativeLayout relativeLayout, SquareImageView squareImageView3, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.bubbleConfirm = squareImageView;
        this.bubbleIcon = squareImageView2;
        this.bubbleItem = relativeLayout;
        this.bubbleLock = squareImageView3;
        this.name = textView;
        this.validTimeLabel = textView2;
    }

    public static VasSquareBubbleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareBubbleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3g, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareBubbleItemBinding bind(View view) {
        int i3 = R.id.pgv;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pgv);
        if (squareImageView != null) {
            i3 = R.id.f163317ph1;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.f163317ph1);
            if (squareImageView2 != null) {
                i3 = R.id.f163318ph2;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f163318ph2);
                if (relativeLayout != null) {
                    i3 = R.id.f163320ph4;
                    SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.f163320ph4);
                    if (squareImageView3 != null) {
                        i3 = R.id.q_6;
                        TextView textView = (TextView) view.findViewById(R.id.q_6);
                        if (textView != null) {
                            i3 = R.id.qwh;
                            TextView textView2 = (TextView) view.findViewById(R.id.qwh);
                            if (textView2 != null) {
                                return new VasSquareBubbleItemBinding((LinearLayout) view, squareImageView, squareImageView2, relativeLayout, squareImageView3, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
