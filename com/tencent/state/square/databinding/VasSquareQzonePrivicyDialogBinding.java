package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;

/* loaded from: classes38.dex */
public final class VasSquareQzonePrivicyDialogBinding implements ViewBinding {
    public final TextView accept;
    public final LinearLayout btnContainer;
    public final TextView ignore;
    private final LinearLayout rootView;
    public final TextView selfUseTip;
    public final TextView title;

    VasSquareQzonePrivicyDialogBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.accept = textView;
        this.btnContainer = linearLayout2;
        this.ignore = textView2;
        this.selfUseTip = textView3;
        this.title = textView4;
    }

    public static VasSquareQzonePrivicyDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareQzonePrivicyDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d6r, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareQzonePrivicyDialogBinding bind(View view) {
        int i3 = R.id.p9r;
        TextView textView = (TextView) view.findViewById(R.id.p9r);
        if (textView != null) {
            i3 = R.id.pfq;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.pfq);
            if (linearLayout != null) {
                i3 = R.id.q19;
                TextView textView2 = (TextView) view.findViewById(R.id.q19);
                if (textView2 != null) {
                    i3 = R.id.qka;
                    TextView textView3 = (TextView) view.findViewById(R.id.qka);
                    if (textView3 != null) {
                        i3 = R.id.qr6;
                        TextView textView4 = (TextView) view.findViewById(R.id.qr6);
                        if (textView4 != null) {
                            return new VasSquareQzonePrivicyDialogBinding((LinearLayout) view, textView, linearLayout, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
