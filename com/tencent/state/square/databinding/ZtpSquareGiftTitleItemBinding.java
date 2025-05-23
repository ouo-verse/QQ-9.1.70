package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ZtpSquareGiftTitleItemBinding implements ViewBinding {
    public final TextView giftTitle;
    public final TextView myCoin;
    private final RelativeLayout rootView;

    ZtpSquareGiftTitleItemBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.giftTitle = textView;
        this.myCoin = textView2;
    }

    public static ZtpSquareGiftTitleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZtpSquareGiftTitleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dht, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ZtpSquareGiftTitleItemBinding bind(View view) {
        int i3 = R.id.pww;
        TextView textView = (TextView) view.findViewById(R.id.pww);
        if (textView != null) {
            i3 = R.id.q_5;
            TextView textView2 = (TextView) view.findViewById(R.id.q_5);
            if (textView2 != null) {
                return new ZtpSquareGiftTitleItemBinding((RelativeLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
