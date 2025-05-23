package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareMsgBoxTailBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView vasSquareMsgBoxTail;

    VasSquareMsgBoxTailBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.vasSquareMsgBoxTail = textView2;
    }

    public static VasSquareMsgBoxTailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareMsgBoxTailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static VasSquareMsgBoxTailBinding bind(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new VasSquareMsgBoxTailBinding(textView, textView);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
