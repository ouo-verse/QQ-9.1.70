package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppScanningLightIconLayoutBinding implements ViewBinding {
    public final ImageView miniAppWxTagIv;
    private final RelativeLayout rootView;
    public final ScanningLightView scanningLightView;

    MiniAppScanningLightIconLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, ScanningLightView scanningLightView) {
        this.rootView = relativeLayout;
        this.miniAppWxTagIv = imageView;
        this.scanningLightView = scanningLightView;
    }

    public static MiniAppScanningLightIconLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppScanningLightIconLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dje, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppScanningLightIconLayoutBinding bind(View view) {
        int i3 = R.id.f163693ri0;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163693ri0);
        if (imageView != null) {
            i3 = R.id.rl5;
            ScanningLightView scanningLightView = (ScanningLightView) ViewBindings.findChildViewById(view, R.id.rl5);
            if (scanningLightView != null) {
                return new MiniAppScanningLightIconLayoutBinding((RelativeLayout) view, imageView, scanningLightView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
