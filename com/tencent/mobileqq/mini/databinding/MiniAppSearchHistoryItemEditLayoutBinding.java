package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppSearchHistoryItemEditLayoutBinding implements ViewBinding {
    public final TextView miniAppSearchHistoryText;
    private final RelativeLayout rootView;

    MiniAppSearchHistoryItemEditLayoutBinding(RelativeLayout relativeLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.miniAppSearchHistoryText = textView;
    }

    public static MiniAppSearchHistoryItemEditLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppSearchHistoryItemEditLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djh, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppSearchHistoryItemEditLayoutBinding bind(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rhl);
        if (textView != null) {
            return new MiniAppSearchHistoryItemEditLayoutBinding((RelativeLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rhl)));
    }
}
