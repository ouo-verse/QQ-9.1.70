package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareOnlineStatusItemBinding implements ViewBinding {
    public final SquareImageView lockStatusIcon;
    public final SquareImageView onlineStatusIcon;
    public final TextView onlineStatusText;
    public final SquareImageView onlineStatusTips;
    public final SquareImageView redPoint;
    private final FrameLayout rootView;

    VasSquareOnlineStatusItemBinding(FrameLayout frameLayout, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView, SquareImageView squareImageView3, SquareImageView squareImageView4) {
        this.rootView = frameLayout;
        this.lockStatusIcon = squareImageView;
        this.onlineStatusIcon = squareImageView2;
        this.onlineStatusText = textView;
        this.onlineStatusTips = squareImageView3;
        this.redPoint = squareImageView4;
    }

    public static VasSquareOnlineStatusItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareOnlineStatusItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6h, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareOnlineStatusItemBinding bind(View view) {
        int i3 = R.id.q77;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q77);
        if (squareImageView != null) {
            i3 = R.id.q_t;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.q_t);
            if (squareImageView2 != null) {
                i3 = R.id.q_y;
                TextView textView = (TextView) view.findViewById(R.id.q_y);
                if (textView != null) {
                    i3 = R.id.q_z;
                    SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.q_z);
                    if (squareImageView3 != null) {
                        i3 = R.id.qgx;
                        SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.qgx);
                        if (squareImageView4 != null) {
                            return new VasSquareOnlineStatusItemBinding((FrameLayout) view, squareImageView, squareImageView2, textView, squareImageView3, squareImageView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
