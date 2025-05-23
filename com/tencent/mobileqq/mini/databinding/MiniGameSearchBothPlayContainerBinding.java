package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniGameSearchBothPlayContainerBinding implements ViewBinding {
    public final RecyclerView bothPlayItemList;
    public final TextView bothPlayItemTitle;
    public final ImageView bothPlayItemTitleLeft;
    public final ImageView bothPlayItemTitleRight;
    private final LinearLayout rootView;

    MiniGameSearchBothPlayContainerBinding(LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, ImageView imageView, ImageView imageView2) {
        this.rootView = linearLayout;
        this.bothPlayItemList = recyclerView;
        this.bothPlayItemTitle = textView;
        this.bothPlayItemTitleLeft = imageView;
        this.bothPlayItemTitleRight = imageView2;
    }

    public static MiniGameSearchBothPlayContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameSearchBothPlayContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkd, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameSearchBothPlayContainerBinding bind(View view) {
        int i3 = R.id.rc8;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rc8);
        if (recyclerView != null) {
            i3 = R.id.rc_;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rc_);
            if (textView != null) {
                i3 = R.id.rca;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rca);
                if (imageView != null) {
                    i3 = R.id.rcb;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.rcb);
                    if (imageView2 != null) {
                        return new MiniGameSearchBothPlayContainerBinding((LinearLayout) view, recyclerView, textView, imageView, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
