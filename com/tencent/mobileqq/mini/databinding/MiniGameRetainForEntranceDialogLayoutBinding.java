package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameRetainForEntranceDialogLayoutBinding implements ViewBinding {
    public final View bottomPaddingView;
    public final LinearLayout btnLayout;
    public final ImageView closeBtn;
    public final TextView dialogLeftBtn;
    public final TextView dialogRightBtn;
    public final RelativeLayout dialogRoot;
    public final TextView dialogTitle;
    public final ViewPager dialogViewPager;
    public final LinearLayout indicatorLayout;
    private final RelativeLayout rootView;
    public final CheckBox subscribeCheck;
    public final LinearLayout subscribeLayout;
    public final RelativeLayout topLayout;
    public final RelativeLayout viewPagerContainer;

    MiniGameRetainForEntranceDialogLayoutBinding(RelativeLayout relativeLayout, View view, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, RelativeLayout relativeLayout2, TextView textView3, ViewPager viewPager, LinearLayout linearLayout2, CheckBox checkBox, LinearLayout linearLayout3, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4) {
        this.rootView = relativeLayout;
        this.bottomPaddingView = view;
        this.btnLayout = linearLayout;
        this.closeBtn = imageView;
        this.dialogLeftBtn = textView;
        this.dialogRightBtn = textView2;
        this.dialogRoot = relativeLayout2;
        this.dialogTitle = textView3;
        this.dialogViewPager = viewPager;
        this.indicatorLayout = linearLayout2;
        this.subscribeCheck = checkBox;
        this.subscribeLayout = linearLayout3;
        this.topLayout = relativeLayout3;
        this.viewPagerContainer = relativeLayout4;
    }

    public static MiniGameRetainForEntranceDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameRetainForEntranceDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkb, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameRetainForEntranceDialogLayoutBinding bind(View view) {
        int i3 = R.id.rcc;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.rcc);
        if (findChildViewById != null) {
            i3 = R.id.rci;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rci);
            if (linearLayout != null) {
                i3 = R.id.rcm;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rcm);
                if (imageView != null) {
                    i3 = R.id.rd7;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rd7);
                    if (textView != null) {
                        i3 = R.id.rd8;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rd8);
                        if (textView2 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view;
                            i3 = R.id.rd_;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rd_);
                            if (textView3 != null) {
                                i3 = R.id.rdb;
                                ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.rdb);
                                if (viewPager != null) {
                                    i3 = R.id.re6;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.re6);
                                    if (linearLayout2 != null) {
                                        i3 = R.id.rl9;
                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.rl9);
                                        if (checkBox != null) {
                                            i3 = R.id.rl_;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rl_);
                                            if (linearLayout3 != null) {
                                                i3 = R.id.rlh;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rlh);
                                                if (relativeLayout2 != null) {
                                                    i3 = R.id.f163713rm0;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163713rm0);
                                                    if (relativeLayout3 != null) {
                                                        return new MiniGameRetainForEntranceDialogLayoutBinding(relativeLayout, findChildViewById, linearLayout, imageView, textView, textView2, relativeLayout, textView3, viewPager, linearLayout2, checkBox, linearLayout3, relativeLayout2, relativeLayout3);
                                                    }
                                                }
                                            }
                                        }
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
