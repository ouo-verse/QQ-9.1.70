package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameHippyDialogLayoutBinding implements ViewBinding {
    public final FrameLayout container;
    private final RelativeLayout rootView;

    MiniGameHippyDialogLayoutBinding(RelativeLayout relativeLayout, FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.container = frameLayout;
    }

    public static MiniGameHippyDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameHippyDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167483dk2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameHippyDialogLayoutBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rcn);
        if (frameLayout != null) {
            return new MiniGameHippyDialogLayoutBinding((RelativeLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rcn)));
    }
}
