package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniGamePublicAccountArkViewBinding implements ViewBinding {
    public final ArkView qqgameArkView;
    public final FrameLayout qqgameArkViewContainer;
    private final FrameLayout rootView;

    MiniGamePublicAccountArkViewBinding(FrameLayout frameLayout, ArkView arkView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.qqgameArkView = arkView;
        this.qqgameArkViewContainer = frameLayout2;
    }

    public static MiniGamePublicAccountArkViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGamePublicAccountArkViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dk9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniGamePublicAccountArkViewBinding bind(View view) {
        ArkView arkView = (ArkView) ViewBindings.findChildViewById(view, R.id.rko);
        if (arkView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new MiniGamePublicAccountArkViewBinding(frameLayout, arkView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rko)));
    }
}
