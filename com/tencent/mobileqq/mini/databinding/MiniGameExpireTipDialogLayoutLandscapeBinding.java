package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.AnimationTextView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameExpireTipDialogLayoutLandscapeBinding implements ViewBinding {
    public final LinearLayout btnLayout;
    public final TextView dialogBtn;
    public final View dialogDivider;
    public final RelativeLayout dialogRoot;
    public final AnimationTextView dialogText;
    public final TextView dialogTitle;
    private final RelativeLayout rootView;

    MiniGameExpireTipDialogLayoutLandscapeBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, View view, RelativeLayout relativeLayout2, AnimationTextView animationTextView, TextView textView2) {
        this.rootView = relativeLayout;
        this.btnLayout = linearLayout;
        this.dialogBtn = textView;
        this.dialogDivider = view;
        this.dialogRoot = relativeLayout2;
        this.dialogText = animationTextView;
        this.dialogTitle = textView2;
    }

    public static MiniGameExpireTipDialogLayoutLandscapeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameExpireTipDialogLayoutLandscapeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167482dk1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameExpireTipDialogLayoutLandscapeBinding bind(View view) {
        int i3 = R.id.rcd;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rcd);
        if (linearLayout != null) {
            i3 = R.id.rd6;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rd6);
            if (textView != null) {
                i3 = R.id.f163668rd0;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163668rd0);
                if (findChildViewById != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.f163672rd4;
                    AnimationTextView animationTextView = (AnimationTextView) ViewBindings.findChildViewById(view, R.id.f163672rd4);
                    if (animationTextView != null) {
                        i3 = R.id.rd5;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rd5);
                        if (textView2 != null) {
                            return new MiniGameExpireTipDialogLayoutLandscapeBinding(relativeLayout, linearLayout, textView, findChildViewById, relativeLayout, animationTextView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
