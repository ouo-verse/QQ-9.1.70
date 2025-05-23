package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareChatLandInteractionMotionIndicatorBinding implements ViewBinding {
    public final FrameLayout btnAction;
    public final LinearLayout lvTips;
    private final View rootView;
    public final TextView tvTick;
    public final TextView tvTips;

    VasSquareChatLandInteractionMotionIndicatorBinding(View view, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = view;
        this.btnAction = frameLayout;
        this.lvTips = linearLayout;
        this.tvTick = textView;
        this.tvTips = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareChatLandInteractionMotionIndicatorBinding bind(View view) {
        int i3 = R.id.pf6;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pf6);
        if (frameLayout != null) {
            i3 = R.id.q7d;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.q7d);
            if (linearLayout != null) {
                i3 = R.id.quc;
                TextView textView = (TextView) view.findViewById(R.id.quc);
                if (textView != null) {
                    i3 = R.id.qud;
                    TextView textView2 = (TextView) view.findViewById(R.id.qud);
                    if (textView2 != null) {
                        return new VasSquareChatLandInteractionMotionIndicatorBinding(view, frameLayout, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareChatLandInteractionMotionIndicatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3o, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
