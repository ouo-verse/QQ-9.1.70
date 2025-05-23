package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.widget.MiniGameShareVideoStateView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameShareCommonDialogBinding implements ViewBinding {
    public final ImageView miniGameShareCover;
    public final FrameLayout miniGameShareMediaContainer;
    public final MiniGameShareVideoStateView miniGameShareMediaIconContainer;
    public final Button miniGameShareNegativeBtn;
    public final Button miniGameSharePositiveBtn;
    private final LinearLayout rootView;

    MiniGameShareCommonDialogBinding(LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, MiniGameShareVideoStateView miniGameShareVideoStateView, Button button, Button button2) {
        this.rootView = linearLayout;
        this.miniGameShareCover = imageView;
        this.miniGameShareMediaContainer = frameLayout;
        this.miniGameShareMediaIconContainer = miniGameShareVideoStateView;
        this.miniGameShareNegativeBtn = button;
        this.miniGameSharePositiveBtn = button2;
    }

    public static MiniGameShareCommonDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameShareCommonDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkg, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameShareCommonDialogBinding bind(View view) {
        int i3 = R.id.ri8;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ri8);
        if (imageView != null) {
            i3 = R.id.rib;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rib);
            if (frameLayout != null) {
                i3 = R.id.ric;
                MiniGameShareVideoStateView miniGameShareVideoStateView = (MiniGameShareVideoStateView) ViewBindings.findChildViewById(view, R.id.ric);
                if (miniGameShareVideoStateView != null) {
                    i3 = R.id.rid;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.rid);
                    if (button != null) {
                        i3 = R.id.rie;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.rie);
                        if (button2 != null) {
                            return new MiniGameShareCommonDialogBinding((LinearLayout) view, imageView, frameLayout, miniGameShareVideoStateView, button, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
