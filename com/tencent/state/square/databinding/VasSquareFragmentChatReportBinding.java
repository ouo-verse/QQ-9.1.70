package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFragmentChatReportBinding implements ViewBinding {
    public final SquareImageView back;
    public final RecyclerView msgContainer;
    public final RelativeLayout reportContainer;
    private final LinearLayout rootView;
    public final TextView submitBtn;
    public final RelativeLayout titleContainer;

    VasSquareFragmentChatReportBinding(LinearLayout linearLayout, SquareImageView squareImageView, RecyclerView recyclerView, RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2) {
        this.rootView = linearLayout;
        this.back = squareImageView;
        this.msgContainer = recyclerView;
        this.reportContainer = relativeLayout;
        this.submitBtn = textView;
        this.titleContainer = relativeLayout2;
    }

    public static VasSquareFragmentChatReportBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentChatReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4k, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentChatReportBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.q9p;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.q9p);
            if (recyclerView != null) {
                i3 = R.id.qh8;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qh8);
                if (relativeLayout != null) {
                    i3 = R.id.qob;
                    TextView textView = (TextView) view.findViewById(R.id.qob);
                    if (textView != null) {
                        i3 = R.id.qro;
                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qro);
                        if (relativeLayout2 != null) {
                            return new VasSquareFragmentChatReportBinding((LinearLayout) view, squareImageView, recyclerView, relativeLayout, textView, relativeLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
