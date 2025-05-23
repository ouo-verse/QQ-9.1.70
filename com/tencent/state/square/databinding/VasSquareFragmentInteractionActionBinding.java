package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.square.interaction.widget.InteractionPlayer;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFragmentInteractionActionBinding implements ViewBinding {
    public final InteractionPlayer player;
    private final LinearLayout rootView;

    VasSquareFragmentInteractionActionBinding(LinearLayout linearLayout, InteractionPlayer interactionPlayer) {
        this.rootView = linearLayout;
        this.player = interactionPlayer;
    }

    public static VasSquareFragmentInteractionActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFragmentInteractionActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4l, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFragmentInteractionActionBinding bind(View view) {
        InteractionPlayer interactionPlayer = (InteractionPlayer) view.findViewById(R.id.f163486qd4);
        if (interactionPlayer != null) {
            return new VasSquareFragmentInteractionActionBinding((LinearLayout) view, interactionPlayer);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f163486qd4)));
    }
}
