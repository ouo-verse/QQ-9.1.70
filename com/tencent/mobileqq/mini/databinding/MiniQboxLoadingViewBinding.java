package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniQboxLoadingViewBinding implements ViewBinding {
    public final ImageView imgBack;
    public final ImageView imgQboxLoadingIcon;
    private final View rootView;
    public final TextView txtLoadingTitle;

    MiniQboxLoadingViewBinding(View view, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = view;
        this.imgBack = imageView;
        this.imgQboxLoadingIcon = imageView2;
        this.txtLoadingTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static MiniQboxLoadingViewBinding bind(View view) {
        int i3 = R.id.f163675re2;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163675re2);
        if (imageView != null) {
            i3 = R.id.re5;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.re5);
            if (imageView2 != null) {
                i3 = R.id.rlx;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlx);
                if (textView != null) {
                    return new MiniQboxLoadingViewBinding(view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static MiniQboxLoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dkr, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
