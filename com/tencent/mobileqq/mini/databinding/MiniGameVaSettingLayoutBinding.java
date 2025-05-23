package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameVaSettingLayoutBinding implements ViewBinding {
    public final QUISettingsRecyclerView miniGameVaSettingRv;
    private final LinearLayout rootView;

    MiniGameVaSettingLayoutBinding(LinearLayout linearLayout, QUISettingsRecyclerView qUISettingsRecyclerView) {
        this.rootView = linearLayout;
        this.miniGameVaSettingRv = qUISettingsRecyclerView;
    }

    public static MiniGameVaSettingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameVaSettingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameVaSettingLayoutBinding bind(View view) {
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) ViewBindings.findChildViewById(view, R.id.rii);
        if (qUISettingsRecyclerView != null) {
            return new MiniGameVaSettingLayoutBinding((LinearLayout) view, qUISettingsRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rii)));
    }
}
