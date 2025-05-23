package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ZtpSquareTaskItemBinding implements ViewBinding {
    public final TextView coinLabel;
    private final RelativeLayout rootView;
    public final TextView taskButton;
    public final SquareImageView taskIcon;
    public final SquareImageView taskItemIcon;
    public final TextView taskNameLabel;

    ZtpSquareTaskItemBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.coinLabel = textView;
        this.taskButton = textView2;
        this.taskIcon = squareImageView;
        this.taskItemIcon = squareImageView2;
        this.taskNameLabel = textView3;
    }

    public static ZtpSquareTaskItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareTaskItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dhu, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ZtpSquareTaskItemBinding bind(View view) {
        int i3 = R.id.pko;
        TextView textView = (TextView) view.findViewById(R.id.pko);
        if (textView != null) {
            i3 = R.id.qpn;
            TextView textView2 = (TextView) view.findViewById(R.id.qpn);
            if (textView2 != null) {
                i3 = R.id.qpv;
                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qpv);
                if (squareImageView != null) {
                    i3 = R.id.qpy;
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qpy);
                    if (squareImageView2 != null) {
                        i3 = R.id.f163547qq0;
                        TextView textView3 = (TextView) view.findViewById(R.id.f163547qq0);
                        if (textView3 != null) {
                            return new ZtpSquareTaskItemBinding((RelativeLayout) view, textView, textView2, squareImageView, squareImageView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
