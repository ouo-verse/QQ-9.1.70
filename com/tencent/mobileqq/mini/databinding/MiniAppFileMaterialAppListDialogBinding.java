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

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppFileMaterialAppListDialogBinding implements ViewBinding {
    public final ImageView ivCloseArrow;
    public final LinearLayout llRootView;
    private final LinearLayout rootView;
    public final RecyclerView rvAppList;
    public final TextView tvListTitle;

    MiniAppFileMaterialAppListDialogBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.ivCloseArrow = imageView;
        this.llRootView = linearLayout2;
        this.rvAppList = recyclerView;
        this.tvListTitle = textView;
    }

    public static MiniAppFileMaterialAppListDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppFileMaterialAppListDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dj_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppFileMaterialAppListDialogBinding bind(View view) {
        int i3 = R.id.ree;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ree);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i3 = R.id.f163712rl4;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f163712rl4);
            if (recyclerView != null) {
                i3 = R.id.rlm;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlm);
                if (textView != null) {
                    return new MiniAppFileMaterialAppListDialogBinding(linearLayout, imageView, linearLayout, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
