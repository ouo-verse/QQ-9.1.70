package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ZtpSquareTaskTitleItemBinding implements ViewBinding {
    public final TextView descLabel;
    private final RelativeLayout rootView;
    public final TextView taskTitle;

    ZtpSquareTaskTitleItemBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.descLabel = textView;
        this.taskTitle = textView2;
    }

    public static ZtpSquareTaskTitleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareTaskTitleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dhx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ZtpSquareTaskTitleItemBinding bind(View view) {
        int i3 = R.id.pow;
        TextView textView = (TextView) view.findViewById(R.id.pow);
        if (textView != null) {
            i3 = R.id.qq6;
            TextView textView2 = (TextView) view.findViewById(R.id.qq6);
            if (textView2 != null) {
                return new ZtpSquareTaskTitleItemBinding((RelativeLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
