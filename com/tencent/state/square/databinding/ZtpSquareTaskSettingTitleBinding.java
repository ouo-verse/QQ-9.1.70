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
public final class ZtpSquareTaskSettingTitleBinding implements ViewBinding {
    public final TextView effectTitleView;
    private final LinearLayout rootView;

    ZtpSquareTaskSettingTitleBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.effectTitleView = textView;
    }

    public static ZtpSquareTaskSettingTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareTaskSettingTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dhv, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ZtpSquareTaskSettingTitleBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.prd);
        if (textView != null) {
            return new ZtpSquareTaskSettingTitleBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.prd)));
    }
}
