package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareTroopMessageBubbleBinding implements ViewBinding {
    public final LinearLayout bubbleContainer;
    private final View rootView;

    VasSquareTroopMessageBubbleBinding(View view, LinearLayout linearLayout) {
        this.rootView = view;
        this.bubbleContainer = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareTroopMessageBubbleBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pgw);
        if (linearLayout != null) {
            return new VasSquareTroopMessageBubbleBinding(view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.pgw)));
    }

    public static VasSquareTroopMessageBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d6y, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
