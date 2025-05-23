package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameDownloadManagerBinding implements ViewBinding {
    public final ImageView back;
    public final ViewPager downloadContent;
    public final TextView downloaded;
    public final TextView downloading;
    public final TextView downloadingCount;
    private final RelativeLayout rootView;
    public final RelativeLayout tab;
    public final TextView title;

    MiniGameDownloadManagerBinding(RelativeLayout relativeLayout, ImageView imageView, ViewPager viewPager, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout2, TextView textView4) {
        this.rootView = relativeLayout;
        this.back = imageView;
        this.downloadContent = viewPager;
        this.downloaded = textView;
        this.downloading = textView2;
        this.downloadingCount = textView3;
        this.tab = relativeLayout2;
        this.title = textView4;
    }

    public static MiniGameDownloadManagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameDownloadManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameDownloadManagerBinding bind(View view) {
        int i3 = R.id.rc5;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rc5);
        if (imageView != null) {
            i3 = R.id.rdd;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.rdd);
            if (viewPager != null) {
                i3 = R.id.rde;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rde);
                if (textView != null) {
                    i3 = R.id.rdf;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.rdf);
                    if (textView2 != null) {
                        i3 = R.id.rdg;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.rdg);
                        if (textView3 != null) {
                            i3 = R.id.rla;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rla);
                            if (relativeLayout != null) {
                                i3 = R.id.rlg;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.rlg);
                                if (textView4 != null) {
                                    return new MiniGameDownloadManagerBinding((RelativeLayout) view, imageView, viewPager, textView, textView2, textView3, relativeLayout, textView4);
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
