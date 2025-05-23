package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareLibraryTagPanelBinding implements ViewBinding {
    public final LinearLayout deskMateContainer;
    public final RecyclerView deskMateTagList;
    public final TextView operator;
    public final LinearLayout ownerTagContainer;
    public final RecyclerView ownerTagList;
    public final TextView ownerTagText;
    public final TextView ownerTagTitle;
    public final SquareImageView panelTopSign;
    public final SquareImageView refresh;
    private final LinearLayout rootView;
    public final TextView selfUseTip;
    public final LinearLayout showInSquare;
    public final SquareImageView showInSquareIcon;

    VasSquareLibraryTagPanelBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView, LinearLayout linearLayout3, RecyclerView recyclerView2, TextView textView2, TextView textView3, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView4, LinearLayout linearLayout4, SquareImageView squareImageView3) {
        this.rootView = linearLayout;
        this.deskMateContainer = linearLayout2;
        this.deskMateTagList = recyclerView;
        this.operator = textView;
        this.ownerTagContainer = linearLayout3;
        this.ownerTagList = recyclerView2;
        this.ownerTagText = textView2;
        this.ownerTagTitle = textView3;
        this.panelTopSign = squareImageView;
        this.refresh = squareImageView2;
        this.selfUseTip = textView4;
        this.showInSquare = linearLayout4;
        this.showInSquareIcon = squareImageView3;
    }

    public static VasSquareLibraryTagPanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibraryTagPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167413d62, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLibraryTagPanelBinding bind(View view) {
        int i3 = R.id.f163356pp0;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f163356pp0);
        if (linearLayout != null) {
            i3 = R.id.f163357pp1;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f163357pp1);
            if (recyclerView != null) {
                i3 = R.id.qa6;
                TextView textView = (TextView) view.findViewById(R.id.qa6);
                if (textView != null) {
                    i3 = R.id.f163476qb4;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.f163476qb4);
                    if (linearLayout2 != null) {
                        i3 = R.id.qb5;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.qb5);
                        if (recyclerView2 != null) {
                            i3 = R.id.qb6;
                            TextView textView2 = (TextView) view.findViewById(R.id.qb6);
                            if (textView2 != null) {
                                i3 = R.id.qb7;
                                TextView textView3 = (TextView) view.findViewById(R.id.qb7);
                                if (textView3 != null) {
                                    i3 = R.id.qbo;
                                    SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qbo);
                                    if (squareImageView != null) {
                                        i3 = R.id.qgy;
                                        SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qgy);
                                        if (squareImageView2 != null) {
                                            i3 = R.id.qka;
                                            TextView textView4 = (TextView) view.findViewById(R.id.qka);
                                            if (textView4 != null) {
                                                i3 = R.id.qlk;
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.qlk);
                                                if (linearLayout3 != null) {
                                                    i3 = R.id.qll;
                                                    SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.qll);
                                                    if (squareImageView3 != null) {
                                                        return new VasSquareLibraryTagPanelBinding((LinearLayout) view, linearLayout, recyclerView, textView, linearLayout2, recyclerView2, textView2, textView3, squareImageView, squareImageView2, textView4, linearLayout3, squareImageView3);
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
