package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppSearchClassifyItemBinding implements ViewBinding {
    public final URLImageView miniClassifyIcon;
    public final TextView miniClassifyText;
    private final RelativeLayout rootView;

    MiniAppSearchClassifyItemBinding(RelativeLayout relativeLayout, URLImageView uRLImageView, TextView textView) {
        this.rootView = relativeLayout;
        this.miniClassifyIcon = uRLImageView;
        this.miniClassifyText = textView;
    }

    public static MiniAppSearchClassifyItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppSearchClassifyItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppSearchClassifyItemBinding bind(View view) {
        int i3 = R.id.f163695ri2;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f163695ri2);
        if (uRLImageView != null) {
            i3 = R.id.f163696ri3;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163696ri3);
            if (textView != null) {
                return new MiniAppSearchClassifyItemBinding((RelativeLayout) view, uRLImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
