package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* loaded from: classes38.dex */
public final class VasSquareFriendStatusPanelBinding implements ViewBinding {
    public final RelativeLayout friendStatusPanel;
    public final SquareImageView friendStatusPanelClose;
    public final RecyclerView friendStatusPanelRv;
    public final TextView friendStatusPanelTitle;
    private final RelativeLayout rootView;

    VasSquareFriendStatusPanelBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, SquareImageView squareImageView, RecyclerView recyclerView, TextView textView) {
        this.rootView = relativeLayout;
        this.friendStatusPanel = relativeLayout2;
        this.friendStatusPanelClose = squareImageView;
        this.friendStatusPanelRv = recyclerView;
        this.friendStatusPanelTitle = textView;
    }

    public static VasSquareFriendStatusPanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFriendStatusPanelBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i3 = R.id.pwg;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.pwg);
        if (squareImageView != null) {
            i3 = R.id.pwh;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pwh);
            if (recyclerView != null) {
                i3 = R.id.pwi;
                TextView textView = (TextView) view.findViewById(R.id.pwi);
                if (textView != null) {
                    return new VasSquareFriendStatusPanelBinding((RelativeLayout) view, relativeLayout, squareImageView, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareFriendStatusPanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4u, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
