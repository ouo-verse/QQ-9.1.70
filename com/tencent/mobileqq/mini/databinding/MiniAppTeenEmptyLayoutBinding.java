package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppTeenEmptyLayoutBinding implements ViewBinding {
    public final RelativeLayout miniAppTeenEmptyLayout;
    public final ImageView miniAppTeenEmptyView;
    private final RelativeLayout rootView;
    public final TextView teenModeDesc;

    MiniAppTeenEmptyLayoutBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.miniAppTeenEmptyLayout = relativeLayout2;
        this.miniAppTeenEmptyView = imageView;
        this.teenModeDesc = textView;
    }

    public static MiniAppTeenEmptyLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppTeenEmptyLayoutBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i3 = R.id.rhw;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rhw);
        if (imageView != null) {
            i3 = R.id.rlb;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlb);
            if (textView != null) {
                return new MiniAppTeenEmptyLayoutBinding(relativeLayout, relativeLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static MiniAppTeenEmptyLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
