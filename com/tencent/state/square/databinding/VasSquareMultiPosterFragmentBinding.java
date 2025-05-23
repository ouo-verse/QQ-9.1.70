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
import com.tencent.state.view.VasSquareDetailPosterView;

/* loaded from: classes38.dex */
public final class VasSquareMultiPosterFragmentBinding implements ViewBinding {
    public final SquareImageView back;
    public final RelativeLayout bottomPanel;
    public final SquareImageView hideIc;
    public final LinearLayout hideNick;
    public final TextView hideTip;
    public final VasSquareDetailPosterView posterView;
    public final View preview;
    private final RelativeLayout rootView;
    public final TextView share;
    public final TextView title;
    public final RelativeLayout titleContainer;

    VasSquareMultiPosterFragmentBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, RelativeLayout relativeLayout2, SquareImageView squareImageView2, LinearLayout linearLayout, TextView textView, VasSquareDetailPosterView vasSquareDetailPosterView, View view, TextView textView2, TextView textView3, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.back = squareImageView;
        this.bottomPanel = relativeLayout2;
        this.hideIc = squareImageView2;
        this.hideNick = linearLayout;
        this.hideTip = textView;
        this.posterView = vasSquareDetailPosterView;
        this.preview = view;
        this.share = textView2;
        this.title = textView3;
        this.titleContainer = relativeLayout3;
    }

    public static VasSquareMultiPosterFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareMultiPosterFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6g, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareMultiPosterFragmentBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.pet;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pet);
            if (relativeLayout != null) {
                i3 = R.id.pza;
                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.pza);
                if (squareImageView2 != null) {
                    i3 = R.id.pzb;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pzb);
                    if (linearLayout != null) {
                        i3 = R.id.pzc;
                        TextView textView = (TextView) view.findViewById(R.id.pzc);
                        if (textView != null) {
                            i3 = R.id.qdc;
                            VasSquareDetailPosterView vasSquareDetailPosterView = (VasSquareDetailPosterView) view.findViewById(R.id.qdc);
                            if (vasSquareDetailPosterView != null) {
                                i3 = R.id.qdh;
                                View findViewById = view.findViewById(R.id.qdh);
                                if (findViewById != null) {
                                    i3 = R.id.qku;
                                    TextView textView2 = (TextView) view.findViewById(R.id.qku);
                                    if (textView2 != null) {
                                        i3 = R.id.qr6;
                                        TextView textView3 = (TextView) view.findViewById(R.id.qr6);
                                        if (textView3 != null) {
                                            i3 = R.id.qro;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qro);
                                            if (relativeLayout2 != null) {
                                                return new VasSquareMultiPosterFragmentBinding((RelativeLayout) view, squareImageView, relativeLayout, squareImageView2, linearLayout, textView, vasSquareDetailPosterView, findViewById, textView2, textView3, relativeLayout2);
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
