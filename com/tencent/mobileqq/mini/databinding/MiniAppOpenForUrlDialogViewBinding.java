package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.widget.RoundRectURLImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppOpenForUrlDialogViewBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final RoundRectURLImageView ivAppIcon;
    private final LinearLayout rootView;
    public final TextView tvOpenMiniApp;
    public final TextView tvOpenMiniAppHint;

    MiniAppOpenForUrlDialogViewBinding(LinearLayout linearLayout, Button button, Button button2, RoundRectURLImageView roundRectURLImageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.ivAppIcon = roundRectURLImageView;
        this.tvOpenMiniApp = textView;
        this.tvOpenMiniAppHint = textView2;
    }

    public static MiniAppOpenForUrlDialogViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppOpenForUrlDialogViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djd, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppOpenForUrlDialogViewBinding bind(View view) {
        int i3 = R.id.rce;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.rce);
        if (button != null) {
            i3 = R.id.rcg;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.rcg);
            if (button2 != null) {
                i3 = R.id.re7;
                RoundRectURLImageView roundRectURLImageView = (RoundRectURLImageView) ViewBindings.findChildViewById(view, R.id.re7);
                if (roundRectURLImageView != null) {
                    i3 = R.id.rlp;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlp);
                    if (textView != null) {
                        i3 = R.id.rlq;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rlq);
                        if (textView2 != null) {
                            return new MiniAppOpenForUrlDialogViewBinding((LinearLayout) view, button, button2, roundRectURLImageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
