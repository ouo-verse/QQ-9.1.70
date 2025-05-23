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
public final class MiniBoxUpgradeRetainDialogBinding implements ViewBinding {
    public final LinearLayout btnLayout;
    public final View dialogDivider;
    public final TextView dialogLeftBtn;
    public final TextView dialogRightBtn;
    public final LinearLayout dialogRoot;
    public final TextView dialogTitle;
    private final LinearLayout rootView;

    MiniBoxUpgradeRetainDialogBinding(LinearLayout linearLayout, LinearLayout linearLayout2, View view, TextView textView, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.rootView = linearLayout;
        this.btnLayout = linearLayout2;
        this.dialogDivider = view;
        this.dialogLeftBtn = textView;
        this.dialogRightBtn = textView2;
        this.dialogRoot = linearLayout3;
        this.dialogTitle = textView3;
    }

    public static MiniBoxUpgradeRetainDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniBoxUpgradeRetainDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniBoxUpgradeRetainDialogBinding bind(View view) {
        int i3 = R.id.rcd;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rcd);
        if (linearLayout != null) {
            i3 = R.id.f163668rd0;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163668rd0);
            if (findChildViewById != null) {
                i3 = R.id.f163669rd1;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163669rd1);
                if (textView != null) {
                    i3 = R.id.f163670rd2;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163670rd2);
                    if (textView2 != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view;
                        i3 = R.id.rd5;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rd5);
                        if (textView3 != null) {
                            return new MiniBoxUpgradeRetainDialogBinding(linearLayout2, linearLayout, findChildViewById, textView, textView2, linearLayout2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
