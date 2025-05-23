package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareLibraryTagItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tag;

    VasSquareLibraryTagItemBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tag = textView;
    }

    public static VasSquareLibraryTagItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareLibraryTagItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167412d61, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareLibraryTagItemBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.qpe);
        if (textView != null) {
            return new VasSquareLibraryTagItemBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qpe)));
    }
}
