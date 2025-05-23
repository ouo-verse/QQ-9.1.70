package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareAvatarComponentBliandBoxBinding implements ViewBinding {
    public final FrameLayout blindBox;
    public final FrameLayout blindBoxHotArea;
    private final View rootView;

    VasSquareAvatarComponentBliandBoxBinding(View view, FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = view;
        this.blindBox = frameLayout;
        this.blindBoxHotArea = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareAvatarComponentBliandBoxBinding bind(View view) {
        int i3 = R.id.pdv;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pdv);
        if (frameLayout != null) {
            i3 = R.id.f163302pe1;
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.f163302pe1);
            if (frameLayout2 != null) {
                return new VasSquareAvatarComponentBliandBoxBinding(view, frameLayout, frameLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareAvatarComponentBliandBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3b, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
