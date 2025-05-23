package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareFragmentPrivacyBinding implements ViewBinding {
    public final SquareImageView back;
    private final LinearLayout rootView;
    public final FormSwitchItem setPrivacy;
    public final FormSwitchItem setStrangerVisible;
    public final RelativeLayout titleContainer;

    VasSquareFragmentPrivacyBinding(LinearLayout linearLayout, SquareImageView squareImageView, FormSwitchItem formSwitchItem, FormSwitchItem formSwitchItem2, RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.back = squareImageView;
        this.setPrivacy = formSwitchItem;
        this.setStrangerVisible = formSwitchItem2;
        this.titleContainer = relativeLayout;
    }

    public static VasSquareFragmentPrivacyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentPrivacyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4r, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentPrivacyBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.qki;
            FormSwitchItem formSwitchItem = (FormSwitchItem) view.findViewById(R.id.qki);
            if (formSwitchItem != null) {
                i3 = R.id.qkj;
                FormSwitchItem formSwitchItem2 = (FormSwitchItem) view.findViewById(R.id.qkj);
                if (formSwitchItem2 != null) {
                    i3 = R.id.qro;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qro);
                    if (relativeLayout != null) {
                        return new VasSquareFragmentPrivacyBinding((LinearLayout) view, squareImageView, formSwitchItem, formSwitchItem2, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
