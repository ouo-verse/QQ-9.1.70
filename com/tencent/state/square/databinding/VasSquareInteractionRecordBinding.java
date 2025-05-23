package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareInteractionRecordBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SquareImageView vasSquareInteractionRecordDragIcon;
    public final RecyclerView vasSquareInteractionRecordList;
    public final SquareImageView vasSquareInteractionRecordQuestion;
    public final LinearLayout vasSquareInteractionRecordQuestionFloat;
    public final LinearLayout vasSquareInteractionRecordTitle;

    VasSquareInteractionRecordBinding(LinearLayout linearLayout, SquareImageView squareImageView, RecyclerView recyclerView, SquareImageView squareImageView2, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.vasSquareInteractionRecordDragIcon = squareImageView;
        this.vasSquareInteractionRecordList = recyclerView;
        this.vasSquareInteractionRecordQuestion = squareImageView2;
        this.vasSquareInteractionRecordQuestionFloat = linearLayout2;
        this.vasSquareInteractionRecordTitle = linearLayout3;
    }

    public static VasSquareInteractionRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareInteractionRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167408d53, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareInteractionRecordBinding bind(View view) {
        int i3 = R.id.qwq;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qwq);
        if (squareImageView != null) {
            i3 = R.id.qwr;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.qwr);
            if (recyclerView != null) {
                i3 = R.id.qws;
                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qws);
                if (squareImageView2 != null) {
                    i3 = R.id.qwt;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qwt);
                    if (linearLayout != null) {
                        i3 = R.id.qwu;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.qwu);
                        if (linearLayout2 != null) {
                            return new VasSquareInteractionRecordBinding((LinearLayout) view, squareImageView, recyclerView, squareImageView2, linearLayout, linearLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
