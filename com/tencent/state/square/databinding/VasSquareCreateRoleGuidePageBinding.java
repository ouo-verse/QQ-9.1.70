package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* loaded from: classes38.dex */
public final class VasSquareCreateRoleGuidePageBinding implements ViewBinding {
    public final View background;
    public final TextView btnCancel;
    public final TextView btnDress;
    public final RelativeLayout container;
    public final TextView firstTitle;
    public final View firstTitleBg;
    public final FrameLayout rolePagContainer;
    public final RelativeLayout rolePageContentContainer;
    private final RelativeLayout rootView;
    public final TextView secondTitle;

    VasSquareCreateRoleGuidePageBinding(RelativeLayout relativeLayout, View view, TextView textView, TextView textView2, RelativeLayout relativeLayout2, TextView textView3, View view2, FrameLayout frameLayout, RelativeLayout relativeLayout3, TextView textView4) {
        this.rootView = relativeLayout;
        this.background = view;
        this.btnCancel = textView;
        this.btnDress = textView2;
        this.container = relativeLayout2;
        this.firstTitle = textView3;
        this.firstTitleBg = view2;
        this.rolePagContainer = frameLayout;
        this.rolePageContentContainer = relativeLayout3;
        this.secondTitle = textView4;
    }

    public static VasSquareCreateRoleGuidePageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareCreateRoleGuidePageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d3w, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareCreateRoleGuidePageBinding bind(View view) {
        int i3 = R.id.pd8;
        View findViewById = view.findViewById(R.id.pd8);
        if (findViewById != null) {
            i3 = R.id.pfh;
            TextView textView = (TextView) view.findViewById(R.id.pfh);
            if (textView != null) {
                i3 = R.id.f163311pg0;
                TextView textView2 = (TextView) view.findViewById(R.id.f163311pg0);
                if (textView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.pua;
                    TextView textView3 = (TextView) view.findViewById(R.id.pua);
                    if (textView3 != null) {
                        i3 = R.id.pub;
                        View findViewById2 = view.findViewById(R.id.pub);
                        if (findViewById2 != null) {
                            i3 = R.id.qij;
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.qij);
                            if (frameLayout != null) {
                                i3 = R.id.qik;
                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.qik);
                                if (relativeLayout2 != null) {
                                    i3 = R.id.qjl;
                                    TextView textView4 = (TextView) view.findViewById(R.id.qjl);
                                    if (textView4 != null) {
                                        return new VasSquareCreateRoleGuidePageBinding(relativeLayout, findViewById, textView, textView2, relativeLayout, textView3, findViewById2, frameLayout, relativeLayout2, textView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
