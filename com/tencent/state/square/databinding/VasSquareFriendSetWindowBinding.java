package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareFriendSetWindowBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final VasSquareFloatSettingItemBinding settingFirstItem;
    public final VasSquareFloatSettingItemBinding settingForthItem;
    public final VasSquareFloatSettingItemBinding settingSecondItem;
    public final VasSquareFloatSettingItemBinding settingThirdItem;

    VasSquareFriendSetWindowBinding(RelativeLayout relativeLayout, VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding, VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding2, VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding3, VasSquareFloatSettingItemBinding vasSquareFloatSettingItemBinding4) {
        this.rootView = relativeLayout;
        this.settingFirstItem = vasSquareFloatSettingItemBinding;
        this.settingForthItem = vasSquareFloatSettingItemBinding2;
        this.settingSecondItem = vasSquareFloatSettingItemBinding3;
        this.settingThirdItem = vasSquareFloatSettingItemBinding4;
    }

    public static VasSquareFriendSetWindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareFriendSetWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4t, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareFriendSetWindowBinding bind(View view) {
        int i3 = R.id.qkm;
        View findViewById = view.findViewById(R.id.qkm);
        if (findViewById != null) {
            VasSquareFloatSettingItemBinding bind = VasSquareFloatSettingItemBinding.bind(findViewById);
            i3 = R.id.qkn;
            View findViewById2 = view.findViewById(R.id.qkn);
            if (findViewById2 != null) {
                VasSquareFloatSettingItemBinding bind2 = VasSquareFloatSettingItemBinding.bind(findViewById2);
                i3 = R.id.qko;
                View findViewById3 = view.findViewById(R.id.qko);
                if (findViewById3 != null) {
                    VasSquareFloatSettingItemBinding bind3 = VasSquareFloatSettingItemBinding.bind(findViewById3);
                    i3 = R.id.qkp;
                    View findViewById4 = view.findViewById(R.id.qkp);
                    if (findViewById4 != null) {
                        return new VasSquareFriendSetWindowBinding((RelativeLayout) view, bind, bind2, bind3, VasSquareFloatSettingItemBinding.bind(findViewById4));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
