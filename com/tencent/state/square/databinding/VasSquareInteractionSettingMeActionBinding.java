package com.tencent.state.square.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.state.view.SquareImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class VasSquareInteractionSettingMeActionBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout vasSquareInteractionContentWrap;
    public final TextView vasSquareInteractionFixedText;
    public final TextView vasSquareInteractionLastTextLength;
    public final Button vasSquareInteractionSettingDone;
    public final SquareImageView vasSquareInteractionSettingMeClear;
    public final SquareImageView vasSquareInteractionSettingMeClose;
    public final SquareImageView vasSquareInteractionSettingMeEdit;
    public final EditText vasSquareInteractionSettingMeInput;
    public final RecyclerView vasSquareInteractionSettingMeList;

    VasSquareInteractionSettingMeActionBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, Button button, SquareImageView squareImageView, SquareImageView squareImageView2, SquareImageView squareImageView3, EditText editText, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.vasSquareInteractionContentWrap = linearLayout2;
        this.vasSquareInteractionFixedText = textView;
        this.vasSquareInteractionLastTextLength = textView2;
        this.vasSquareInteractionSettingDone = button;
        this.vasSquareInteractionSettingMeClear = squareImageView;
        this.vasSquareInteractionSettingMeClose = squareImageView2;
        this.vasSquareInteractionSettingMeEdit = squareImageView3;
        this.vasSquareInteractionSettingMeInput = editText;
        this.vasSquareInteractionSettingMeList = recyclerView;
    }

    public static VasSquareInteractionSettingMeActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VasSquareInteractionSettingMeActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167410d55, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VasSquareInteractionSettingMeActionBinding bind(View view) {
        int i3 = R.id.qwk;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.qwk);
        if (linearLayout != null) {
            i3 = R.id.qwl;
            TextView textView = (TextView) view.findViewById(R.id.qwl);
            if (textView != null) {
                i3 = R.id.qwm;
                TextView textView2 = (TextView) view.findViewById(R.id.qwm);
                if (textView2 != null) {
                    i3 = R.id.qwv;
                    Button button = (Button) view.findViewById(R.id.qwv);
                    if (button != null) {
                        i3 = R.id.qwy;
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.qwy);
                        if (squareImageView != null) {
                            i3 = R.id.qwz;
                            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.qwz);
                            if (squareImageView2 != null) {
                                i3 = R.id.f163582qx0;
                                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.f163582qx0);
                                if (squareImageView3 != null) {
                                    i3 = R.id.f163583qx1;
                                    EditText editText = (EditText) view.findViewById(R.id.f163583qx1);
                                    if (editText != null) {
                                        i3 = R.id.f163584qx2;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f163584qx2);
                                        if (recyclerView != null) {
                                            return new VasSquareInteractionSettingMeActionBinding((LinearLayout) view, linearLayout, textView, textView2, button, squareImageView, squareImageView2, squareImageView3, editText, recyclerView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
