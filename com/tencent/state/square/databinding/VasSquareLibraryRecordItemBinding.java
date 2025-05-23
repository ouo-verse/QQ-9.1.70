package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryRecordItemBinding implements ViewBinding {
    public final TextView date;
    public final SquareImageView icon;
    private final RelativeLayout rootView;
    public final TextView text;

    VasSquareLibraryRecordItemBinding(RelativeLayout relativeLayout, TextView textView, SquareImageView squareImageView, TextView textView2) {
        this.rootView = relativeLayout;
        this.date = textView;
        this.icon = squareImageView;
        this.text = textView2;
    }

    public static VasSquareLibraryRecordItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibraryRecordItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5x, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLibraryRecordItemBinding bind(View view) {
        int i3 = R.id.pod;
        TextView textView = (TextView) view.findViewById(R.id.pod);
        if (textView != null) {
            i3 = R.id.q0b;
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.q0b);
            if (squareImageView != null) {
                i3 = R.id.qqa;
                TextView textView2 = (TextView) view.findViewById(R.id.qqa);
                if (textView2 != null) {
                    return new VasSquareLibraryRecordItemBinding((RelativeLayout) view, textView, squareImageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
