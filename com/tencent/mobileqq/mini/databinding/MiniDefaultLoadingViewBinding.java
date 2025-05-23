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
public final class MiniDefaultLoadingViewBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView txtLoading;

    MiniDefaultLoadingViewBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.txtLoading = textView;
    }

    public static MiniDefaultLoadingViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniDefaultLoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dju, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniDefaultLoadingViewBinding bind(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlw);
        if (textView != null) {
            return new MiniDefaultLoadingViewBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rlw)));
    }
}
