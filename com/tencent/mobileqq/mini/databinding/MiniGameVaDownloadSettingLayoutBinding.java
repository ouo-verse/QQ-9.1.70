package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSwitchItem;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniGameVaDownloadSettingLayoutBinding implements ViewBinding {
    public final FormSwitchItem miniGameVaWifiAutoUpgrade;
    private final LinearLayout rootView;

    MiniGameVaDownloadSettingLayoutBinding(LinearLayout linearLayout, FormSwitchItem formSwitchItem) {
        this.rootView = linearLayout;
        this.miniGameVaWifiAutoUpgrade = formSwitchItem;
    }

    public static MiniGameVaDownloadSettingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniGameVaDownloadSettingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniGameVaDownloadSettingLayoutBinding bind(View view) {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ViewBindings.findChildViewById(view, R.id.rij);
        if (formSwitchItem != null) {
            return new MiniGameVaDownloadSettingLayoutBinding((LinearLayout) view, formSwitchItem);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rij)));
    }
}
