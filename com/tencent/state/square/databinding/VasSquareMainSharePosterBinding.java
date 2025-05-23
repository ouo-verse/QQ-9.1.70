package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareMainSharePosterBinding implements ViewBinding {
    public final SquareImageView background;
    public final RelativeLayout container;
    public final TextView nick;
    public final SquareImageView qrCode;
    private final View rootView;

    VasSquareMainSharePosterBinding(View view, SquareImageView squareImageView, RelativeLayout relativeLayout, TextView textView, SquareImageView squareImageView2) {
        this.rootView = view;
        this.background = squareImageView;
        this.container = relativeLayout;
        this.nick = textView;
        this.qrCode = squareImageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareMainSharePosterBinding bind(View view) {
        int i3 = R.id.pd8;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pd8);
        if (squareImageView != null) {
            i3 = R.id.plw;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.plw);
            if (relativeLayout != null) {
                i3 = R.id.q_h;
                TextView textView = (TextView) view.findViewById(R.id.q_h);
                if (textView != null) {
                    i3 = R.id.qf6;
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qf6);
                    if (squareImageView2 != null) {
                        return new VasSquareMainSharePosterBinding(view, squareImageView, relativeLayout, textView, squareImageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareMainSharePosterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d69, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
