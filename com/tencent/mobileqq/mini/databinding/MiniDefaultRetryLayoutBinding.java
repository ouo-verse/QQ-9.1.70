package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniDefaultRetryLayoutBinding implements ViewBinding {
    public final LinearLayout miniRetryLayout;
    public final TextView miniTxtRetry;
    private final LinearLayout rootView;

    MiniDefaultRetryLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.miniRetryLayout = linearLayout2;
        this.miniTxtRetry = textView;
    }

    public static MiniDefaultRetryLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniDefaultRetryLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rji);
        if (textView != null) {
            return new MiniDefaultRetryLayoutBinding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rji)));
    }

    public static MiniDefaultRetryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djv, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
