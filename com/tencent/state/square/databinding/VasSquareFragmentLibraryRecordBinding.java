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
public final class VasSquareFragmentLibraryRecordBinding implements ViewBinding {
    public final SquareImageView back;
    public final RecyclerView recordList;
    public final VasSquareErrorViewBinding requestErrorBackground;
    private final LinearLayout rootView;
    public final RelativeLayout titleContainer;
    public final SquareImageView vasSquareMsgBoxEmptyIcon;
    public final TextView vasSquareMsgBoxEmptyTips;
    public final RelativeLayout vasSquareRecordEmptyContainer;

    VasSquareFragmentLibraryRecordBinding(LinearLayout linearLayout, SquareImageView squareImageView, RecyclerView recyclerView, VasSquareErrorViewBinding vasSquareErrorViewBinding, RelativeLayout relativeLayout, SquareImageView squareImageView2, TextView textView, RelativeLayout relativeLayout2) {
        this.rootView = linearLayout;
        this.back = squareImageView;
        this.recordList = recyclerView;
        this.requestErrorBackground = vasSquareErrorViewBinding;
        this.titleContainer = relativeLayout;
        this.vasSquareMsgBoxEmptyIcon = squareImageView2;
        this.vasSquareMsgBoxEmptyTips = textView;
        this.vasSquareRecordEmptyContainer = relativeLayout2;
    }

    public static VasSquareFragmentLibraryRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentLibraryRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4p, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentLibraryRecordBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.f163501qg4;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f163501qg4);
            if (recyclerView != null) {
                i3 = R.id.qh9;
                View findViewById = view.findViewById(R.id.qh9);
                if (findViewById != null) {
                    VasSquareErrorViewBinding bind = VasSquareErrorViewBinding.bind(findViewById);
                    i3 = R.id.qro;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qro);
                    if (relativeLayout != null) {
                        i3 = R.id.qxf;
                        SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qxf);
                        if (squareImageView2 != null) {
                            i3 = R.id.qxg;
                            TextView textView = (TextView) view.findViewById(R.id.qxg);
                            if (textView != null) {
                                i3 = R.id.f163590qy3;
                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.f163590qy3);
                                if (relativeLayout2 != null) {
                                    return new VasSquareFragmentLibraryRecordBinding((LinearLayout) view, squareImageView, recyclerView, bind, relativeLayout, squareImageView2, textView, relativeLayout2);
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
