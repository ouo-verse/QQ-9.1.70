package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFragmentMayKnowFriendBinding implements ViewBinding {
    public final SquareImageView back;
    public final RecyclerView mayKnowList;
    public final VasSquareErrorViewBinding requestErrorBackground;
    private final LinearLayout rootView;
    public final RelativeLayout titleContainer;

    VasSquareFragmentMayKnowFriendBinding(LinearLayout linearLayout, SquareImageView squareImageView, RecyclerView recyclerView, VasSquareErrorViewBinding vasSquareErrorViewBinding, RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.back = squareImageView;
        this.mayKnowList = recyclerView;
        this.requestErrorBackground = vasSquareErrorViewBinding;
        this.titleContainer = relativeLayout;
    }

    public static VasSquareFragmentMayKnowFriendBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentMayKnowFriendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4q, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentMayKnowFriendBinding bind(View view) {
        int i3 = R.id.pcx;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pcx);
        if (squareImageView != null) {
            i3 = R.id.q85;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.q85);
            if (recyclerView != null) {
                i3 = R.id.qh9;
                View findViewById = view.findViewById(R.id.qh9);
                if (findViewById != null) {
                    VasSquareErrorViewBinding bind = VasSquareErrorViewBinding.bind(findViewById);
                    i3 = R.id.qro;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.qro);
                    if (relativeLayout != null) {
                        return new VasSquareFragmentMayKnowFriendBinding((LinearLayout) view, squareImageView, recyclerView, bind, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
