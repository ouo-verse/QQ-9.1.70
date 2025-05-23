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
public final class VasSquareLibraryCommonDialogBinding implements ViewBinding {
    public final SquareImageView btnClose;
    public final TextView btnLeft;
    public final TextView btnMid;
    public final TextView btnRight;
    public final LinearLayout conformView;
    public final LinearLayout contentContainer;
    public final TextView contentText;
    public final RelativeLayout dialogContent;
    public final RelativeLayout dialogRoot;
    public final LinearLayout extraContent;
    public final SquareImageView headIcon;
    public final View imagePadding;
    private final RelativeLayout rootView;
    public final TextView titleName;

    VasSquareLibraryCommonDialogBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView4, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout3, SquareImageView squareImageView2, View view, TextView textView5) {
        this.rootView = relativeLayout;
        this.btnClose = squareImageView;
        this.btnLeft = textView;
        this.btnMid = textView2;
        this.btnRight = textView3;
        this.conformView = linearLayout;
        this.contentContainer = linearLayout2;
        this.contentText = textView4;
        this.dialogContent = relativeLayout2;
        this.dialogRoot = relativeLayout3;
        this.extraContent = linearLayout3;
        this.headIcon = squareImageView2;
        this.imagePadding = view;
        this.titleName = textView5;
    }

    public static VasSquareLibraryCommonDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibraryCommonDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5t, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLibraryCommonDialogBinding bind(View view) {
        int i3 = R.id.pfl;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pfl);
        if (squareImageView != null) {
            i3 = R.id.pg6;
            TextView textView = (TextView) view.findViewById(R.id.pg6);
            if (textView != null) {
                i3 = R.id.pg8;
                TextView textView2 = (TextView) view.findViewById(R.id.pg8);
                if (textView2 != null) {
                    i3 = R.id.pgf;
                    TextView textView3 = (TextView) view.findViewById(R.id.pgf);
                    if (textView3 != null) {
                        i3 = R.id.pls;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pls);
                        if (linearLayout != null) {
                            i3 = R.id.pm8;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.pm8);
                            if (linearLayout2 != null) {
                                i3 = R.id.pmb;
                                TextView textView4 = (TextView) view.findViewById(R.id.pmb);
                                if (textView4 != null) {
                                    i3 = R.id.ppr;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ppr);
                                    if (relativeLayout != null) {
                                        RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                        i3 = R.id.ptb;
                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ptb);
                                        if (linearLayout3 != null) {
                                            i3 = R.id.pyw;
                                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pyw);
                                            if (squareImageView2 != null) {
                                                i3 = R.id.q1d;
                                                View findViewById = view.findViewById(R.id.q1d);
                                                if (findViewById != null) {
                                                    i3 = R.id.qrt;
                                                    TextView textView5 = (TextView) view.findViewById(R.id.qrt);
                                                    if (textView5 != null) {
                                                        return new VasSquareLibraryCommonDialogBinding(relativeLayout2, squareImageView, textView, textView2, textView3, linearLayout, linearLayout2, textView4, relativeLayout, relativeLayout2, linearLayout3, squareImageView2, findViewById, textView5);
                                                    }
                                                }
                                            }
                                        }
                                    }
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
