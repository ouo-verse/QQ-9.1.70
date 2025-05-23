package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryTableViewBinding implements ViewBinding {
    public final SquareImageView decorator;
    public final TextView decoratorText;
    public final View hitArea;
    private final View rootView;
    public final SquareImageView table;

    VasSquareLibraryTableViewBinding(View view, SquareImageView squareImageView, TextView textView, View view2, SquareImageView squareImageView2) {
        this.rootView = view;
        this.decorator = squareImageView;
        this.decoratorText = textView;
        this.hitArea = view2;
        this.table = squareImageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareLibraryTableViewBinding bind(View view) {
        int i3 = R.id.pol;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pol);
        if (squareImageView != null) {
            i3 = R.id.pom;
            TextView textView = (TextView) view.findViewById(R.id.pom);
            if (textView != null) {
                i3 = R.id.pzs;
                View findViewById = view.findViewById(R.id.pzs);
                if (findViewById != null) {
                    i3 = R.id.qpc;
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qpc);
                    if (squareImageView2 != null) {
                        return new VasSquareLibraryTableViewBinding(view, squareImageView, textView, findViewById, squareImageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareLibraryTableViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167411d60, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
