package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSimpleItem;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniWxAppDebugItemBinding implements ViewBinding {
    public final TextView miniAppItemsText;
    public final FormSimpleItem miniAppQq;
    public final FormSimpleItem miniAppWx;
    private final LinearLayout rootView;

    MiniWxAppDebugItemBinding(LinearLayout linearLayout, TextView textView, FormSimpleItem formSimpleItem, FormSimpleItem formSimpleItem2) {
        this.rootView = linearLayout;
        this.miniAppItemsText = textView;
        this.miniAppQq = formSimpleItem;
        this.miniAppWx = formSimpleItem2;
    }

    public static MiniWxAppDebugItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniWxAppDebugItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dks, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniWxAppDebugItemBinding bind(View view) {
        int i3 = R.id.rgq;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rgq);
        if (textView != null) {
            i3 = R.id.rh_;
            FormSimpleItem formSimpleItem = (FormSimpleItem) ViewBindings.findChildViewById(view, R.id.rh_);
            if (formSimpleItem != null) {
                i3 = R.id.rhx;
                FormSimpleItem formSimpleItem2 = (FormSimpleItem) ViewBindings.findChildViewById(view, R.id.rhx);
                if (formSimpleItem2 != null) {
                    return new MiniWxAppDebugItemBinding((LinearLayout) view, textView, formSimpleItem, formSimpleItem2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
