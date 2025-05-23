package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameMetaFarmStatusListItemBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView statusDesc;
    public final URLImageView statusIcon;

    MiniGameMetaFarmStatusListItemBinding(RelativeLayout relativeLayout, TextView textView, URLImageView uRLImageView) {
        this.rootView = relativeLayout;
        this.statusDesc = textView;
        this.statusIcon = uRLImageView;
    }

    public static MiniGameMetaFarmStatusListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameMetaFarmStatusListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dk6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameMetaFarmStatusListItemBinding bind(View view) {
        int i3 = R.id.rl6;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rl6);
        if (textView != null) {
            i3 = R.id.rl8;
            URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.rl8);
            if (uRLImageView != null) {
                return new MiniGameMetaFarmStatusListItemBinding((RelativeLayout) view, textView, uRLImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
