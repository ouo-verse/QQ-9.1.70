package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareAvatarMontionLockBinding implements ViewBinding {
    public final Button enterUnlockMap;
    private final View rootView;
    public final TextView title;
    public final TextView titleDesc;

    VasSquareAvatarMontionLockBinding(View view, Button button, TextView textView, TextView textView2) {
        this.rootView = view;
        this.enterUnlockMap = button;
        this.title = textView;
        this.titleDesc = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VasSquareAvatarMontionLockBinding bind(View view) {
        int i3 = R.id.f163371ps0;
        Button button = (Button) view.findViewById(R.id.f163371ps0);
        if (button != null) {
            i3 = R.id.qr6;
            TextView textView = (TextView) view.findViewById(R.id.qr6);
            if (textView != null) {
                i3 = R.id.qrp;
                TextView textView2 = (TextView) view.findViewById(R.id.qrp);
                if (textView2 != null) {
                    return new VasSquareAvatarMontionLockBinding(view, button, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static VasSquareAvatarMontionLockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d3d, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
