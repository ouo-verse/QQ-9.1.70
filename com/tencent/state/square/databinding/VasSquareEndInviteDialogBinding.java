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
public final class VasSquareEndInviteDialogBinding implements ViewBinding {
    public final TextView accept;
    public final LinearLayout btnContainer;
    public final TextView ignore;
    private final RelativeLayout rootView;
    public final LinearLayout selfUseContainer;
    public final SquareImageView selfUseIcon;
    public final TextView selfUseTip;
    public final TextView title;

    VasSquareEndInviteDialogBinding(RelativeLayout relativeLayout, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, SquareImageView squareImageView, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.accept = textView;
        this.btnContainer = linearLayout;
        this.ignore = textView2;
        this.selfUseContainer = linearLayout2;
        this.selfUseIcon = squareImageView;
        this.selfUseTip = textView3;
        this.title = textView4;
    }

    public static VasSquareEndInviteDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareEndInviteDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167404d45, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareEndInviteDialogBinding bind(View view) {
        int i3 = R.id.p9r;
        TextView textView = (TextView) view.findViewById(R.id.p9r);
        if (textView != null) {
            i3 = R.id.pfq;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pfq);
            if (linearLayout != null) {
                i3 = R.id.q19;
                TextView textView2 = (TextView) view.findViewById(R.id.q19);
                if (textView2 != null) {
                    i3 = R.id.qk9;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.qk9);
                    if (linearLayout2 != null) {
                        i3 = R.id.qk_;
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qk_);
                        if (squareImageView != null) {
                            i3 = R.id.qka;
                            TextView textView3 = (TextView) view.findViewById(R.id.qka);
                            if (textView3 != null) {
                                i3 = R.id.qr6;
                                TextView textView4 = (TextView) view.findViewById(R.id.qr6);
                                if (textView4 != null) {
                                    return new VasSquareEndInviteDialogBinding((RelativeLayout) view, textView, linearLayout, textView2, linearLayout2, squareImageView, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
