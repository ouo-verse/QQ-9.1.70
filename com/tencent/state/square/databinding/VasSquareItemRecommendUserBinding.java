package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.view.SquareTabLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareItemRecommendUserBinding implements ViewBinding {
    public final TextView recommendReason;
    public final SquareAvatarView recommendUserAvatar;
    public final SquareTabLayout recommendUserLabelsContainer;
    public final TextView recommendUserName;
    private final LinearLayout rootView;

    VasSquareItemRecommendUserBinding(LinearLayout linearLayout, TextView textView, SquareAvatarView squareAvatarView, SquareTabLayout squareTabLayout, TextView textView2) {
        this.rootView = linearLayout;
        this.recommendReason = textView;
        this.recommendUserAvatar = squareAvatarView;
        this.recommendUserLabelsContainer = squareTabLayout;
        this.recommendUserName = textView2;
    }

    public static VasSquareItemRecommendUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemRecommendUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5n, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareItemRecommendUserBinding bind(View view) {
        int i3 = R.id.qfp;
        TextView textView = (TextView) view.findViewById(R.id.qfp);
        if (textView != null) {
            i3 = R.id.qfv;
            SquareAvatarView squareAvatarView = (SquareAvatarView) view.findViewById(R.id.qfv);
            if (squareAvatarView != null) {
                i3 = R.id.qfw;
                SquareTabLayout squareTabLayout = (SquareTabLayout) view.findViewById(R.id.qfw);
                if (squareTabLayout != null) {
                    i3 = R.id.qfx;
                    TextView textView2 = (TextView) view.findViewById(R.id.qfx);
                    if (textView2 != null) {
                        return new VasSquareItemRecommendUserBinding((LinearLayout) view, textView, squareAvatarView, squareTabLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
