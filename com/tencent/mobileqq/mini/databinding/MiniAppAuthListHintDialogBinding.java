package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppAuthListHintDialogBinding implements ViewBinding {
    public final ImageView ivAuthDetailBack;
    public final View line;
    public final ListView lvDetailItems;
    public final RelativeLayout rlAuthDetailTitle;
    private final RelativeLayout rootView;
    public final TextView tvAuthDetailTitle;

    MiniAppAuthListHintDialogBinding(RelativeLayout relativeLayout, ImageView imageView, View view, ListView listView, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.ivAuthDetailBack = imageView;
        this.line = view;
        this.lvDetailItems = listView;
        this.rlAuthDetailTitle = relativeLayout2;
        this.tvAuthDetailTitle = textView;
    }

    public static MiniAppAuthListHintDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppAuthListHintDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.di_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppAuthListHintDialogBinding bind(View view) {
        int i3 = R.id.re8;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.re8);
        if (imageView != null) {
            i3 = R.id.reo;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.reo);
            if (findChildViewById != null) {
                i3 = R.id.f163682rf4;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.f163682rf4);
                if (listView != null) {
                    i3 = R.id.f163709rl1;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163709rl1);
                    if (relativeLayout != null) {
                        i3 = R.id.rli;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rli);
                        if (textView != null) {
                            return new MiniAppAuthListHintDialogBinding((RelativeLayout) view, imageView, findChildViewById, listView, relativeLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
