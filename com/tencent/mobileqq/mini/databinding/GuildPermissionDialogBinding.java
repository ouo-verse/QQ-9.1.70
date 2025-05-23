package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class GuildPermissionDialogBinding implements ViewBinding {
    public final LinearLayout contentView;
    public final Button permissionConfirm;
    public final Button permissionReject;
    public final TextView permissionRequestContent;
    public final ImageView permissionRequestIcon;
    public final TextView permissionRequestIconText;
    public final TextView permissionRequestTitle;
    private final LinearLayout rootView;

    GuildPermissionDialogBinding(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, Button button2, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.contentView = linearLayout2;
        this.permissionConfirm = button;
        this.permissionReject = button2;
        this.permissionRequestContent = textView;
        this.permissionRequestIcon = imageView;
        this.permissionRequestIconText = textView2;
        this.permissionRequestTitle = textView3;
    }

    public static GuildPermissionDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GuildPermissionDialogBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.rkc;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.rkc);
        if (button != null) {
            i3 = R.id.rkd;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.rkd);
            if (button2 != null) {
                i3 = R.id.rke;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rke);
                if (textView != null) {
                    i3 = R.id.rkf;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rkf);
                    if (imageView != null) {
                        i3 = R.id.rkg;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rkg);
                        if (textView2 != null) {
                            i3 = R.id.rkh;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rkh);
                            if (textView3 != null) {
                                return new GuildPermissionDialogBinding(linearLayout, linearLayout, button, button2, textView, imageView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static GuildPermissionDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.di9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
