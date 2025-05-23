package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppWechatBindingAndAuthLayoutBinding implements ViewBinding {
    public final LinearLayout miniAppWxchatBindingAndAuthView;
    public final TextView notificationWxBindingTv;
    public final TextView notificationWxDescTv;
    public final ImageView notificationWxIconIv;
    public final TextView notificationWxNameTv;
    public final QUIButton notificationWxUnbindingBtn;
    private final LinearLayout rootView;

    MiniAppWechatBindingAndAuthLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView, TextView textView3, QUIButton qUIButton) {
        this.rootView = linearLayout;
        this.miniAppWxchatBindingAndAuthView = linearLayout2;
        this.notificationWxBindingTv = textView;
        this.notificationWxDescTv = textView2;
        this.notificationWxIconIv = imageView;
        this.notificationWxNameTv = textView3;
        this.notificationWxUnbindingBtn = qUIButton;
    }

    public static MiniAppWechatBindingAndAuthLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppWechatBindingAndAuthLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.rk5;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rk5);
        if (textView != null) {
            i3 = R.id.rk6;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rk6);
            if (textView2 != null) {
                i3 = R.id.rk7;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rk7);
                if (imageView != null) {
                    i3 = R.id.rk8;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rk8);
                    if (textView3 != null) {
                        i3 = R.id.rk9;
                        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.rk9);
                        if (qUIButton != null) {
                            return new MiniAppWechatBindingAndAuthLayoutBinding(linearLayout, linearLayout, textView, textView2, imageView, textView3, qUIButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static MiniAppWechatBindingAndAuthLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djo, viewGroup, false);
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
