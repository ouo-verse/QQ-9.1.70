package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ZtpSquareTaskSheetBinding implements ViewBinding {
    public final SquareImageView closeButton;
    private final RelativeLayout rootView;
    public final SquareImageView taskLogo;
    public final SquareImageView taskQqShowLogo;
    public final SquareImageView taskStarLogo;
    public final TextView taskTitle;
    public final RecyclerView taskView;
    public final RelativeLayout titleContainer;
    public final View topLeftBg;
    public final View topRightBg;

    ZtpSquareTaskSheetBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, SquareImageView squareImageView2, SquareImageView squareImageView3, SquareImageView squareImageView4, TextView textView, RecyclerView recyclerView, RelativeLayout relativeLayout2, View view, View view2) {
        this.rootView = relativeLayout;
        this.closeButton = squareImageView;
        this.taskLogo = squareImageView2;
        this.taskQqShowLogo = squareImageView3;
        this.taskStarLogo = squareImageView4;
        this.taskTitle = textView;
        this.taskView = recyclerView;
        this.titleContainer = relativeLayout2;
        this.topLeftBg = view;
        this.topRightBg = view2;
    }

    public static ZtpSquareTaskSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareTaskSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dhw, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ZtpSquareTaskSheetBinding bind(View view) {
        int i3 = R.id.pk_;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pk_);
        if (squareImageView != null) {
            i3 = R.id.qpz;
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qpz);
            if (squareImageView2 != null) {
                i3 = R.id.f163548qq1;
                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.f163548qq1);
                if (squareImageView3 != null) {
                    i3 = R.id.qq5;
                    SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.qq5);
                    if (squareImageView4 != null) {
                        i3 = R.id.qq6;
                        TextView textView = (TextView) view.findViewById(R.id.qq6);
                        if (textView != null) {
                            i3 = R.id.qq7;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.qq7);
                            if (recyclerView != null) {
                                i3 = R.id.qro;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qro);
                                if (relativeLayout != null) {
                                    i3 = R.id.qse;
                                    View findViewById = view.findViewById(R.id.qse);
                                    if (findViewById != null) {
                                        i3 = R.id.qsf;
                                        View findViewById2 = view.findViewById(R.id.qsf);
                                        if (findViewById2 != null) {
                                            return new ZtpSquareTaskSheetBinding((RelativeLayout) view, squareImageView, squareImageView2, squareImageView3, squareImageView4, textView, recyclerView, relativeLayout, findViewById, findViewById2);
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
