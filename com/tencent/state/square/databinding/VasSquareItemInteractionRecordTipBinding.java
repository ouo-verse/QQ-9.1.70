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
public final class VasSquareItemInteractionRecordTipBinding implements ViewBinding {
    public final TextView interactionRecordTip;
    private final TextView rootView;

    VasSquareItemInteractionRecordTipBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.interactionRecordTip = textView2;
    }

    public static VasSquareItemInteractionRecordTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareItemInteractionRecordTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d5f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static VasSquareItemInteractionRecordTipBinding bind(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new VasSquareItemInteractionRecordTipBinding(textView, textView);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }
}
