package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.widget.GridView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameMetaFarmStatusListLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final GridView statusGridView;

    MiniGameMetaFarmStatusListLayoutBinding(RelativeLayout relativeLayout, GridView gridView) {
        this.rootView = relativeLayout;
        this.statusGridView = gridView;
    }

    public static MiniGameMetaFarmStatusListLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameMetaFarmStatusListLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dk7, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameMetaFarmStatusListLayoutBinding bind(View view) {
        GridView gridView = (GridView) ViewBindings.findChildViewById(view, R.id.rl7);
        if (gridView != null) {
            return new MiniGameMetaFarmStatusListLayoutBinding((RelativeLayout) view, gridView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rl7)));
    }
}
