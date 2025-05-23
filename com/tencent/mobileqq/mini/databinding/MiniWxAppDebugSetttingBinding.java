package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniWxAppDebugSetttingBinding implements ViewBinding {
    public final EditText miniAppDebugEditOpen;
    public final Spinner miniAppDebugFilter;
    public final FormSwitchItem miniAppDebugIpSwitch;
    public final FormSimpleItem miniAppDebugLoadWx;
    public final FormSimpleItem miniAppDebugOpenWx;
    public final RecyclerView miniAppDebugRv;
    public final FormSimpleItem miniAppWxDelete;
    public final FormSimpleItem miniAppWxExpose;
    private final LinearLayout rootView;
    public final TextView wxaSdkVersion;

    MiniWxAppDebugSetttingBinding(LinearLayout linearLayout, EditText editText, Spinner spinner, FormSwitchItem formSwitchItem, FormSimpleItem formSimpleItem, FormSimpleItem formSimpleItem2, RecyclerView recyclerView, FormSimpleItem formSimpleItem3, FormSimpleItem formSimpleItem4, TextView textView) {
        this.rootView = linearLayout;
        this.miniAppDebugEditOpen = editText;
        this.miniAppDebugFilter = spinner;
        this.miniAppDebugIpSwitch = formSwitchItem;
        this.miniAppDebugLoadWx = formSimpleItem;
        this.miniAppDebugOpenWx = formSimpleItem2;
        this.miniAppDebugRv = recyclerView;
        this.miniAppWxDelete = formSimpleItem3;
        this.miniAppWxExpose = formSimpleItem4;
        this.wxaSdkVersion = textView;
    }

    public static MiniWxAppDebugSetttingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniWxAppDebugSetttingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dkt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniWxAppDebugSetttingBinding bind(View view) {
        int i3 = R.id.rfh;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.rfh);
        if (editText != null) {
            i3 = R.id.rfi;
            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.rfi);
            if (spinner != null) {
                i3 = R.id.rfj;
                FormSwitchItem formSwitchItem = (FormSwitchItem) ViewBindings.findChildViewById(view, R.id.rfj);
                if (formSwitchItem != null) {
                    i3 = R.id.rfk;
                    FormSimpleItem formSimpleItem = (FormSimpleItem) ViewBindings.findChildViewById(view, R.id.rfk);
                    if (formSimpleItem != null) {
                        i3 = R.id.rfl;
                        FormSimpleItem formSimpleItem2 = (FormSimpleItem) ViewBindings.findChildViewById(view, R.id.rfl);
                        if (formSimpleItem2 != null) {
                            i3 = R.id.rfm;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rfm);
                            if (recyclerView != null) {
                                i3 = R.id.rhy;
                                FormSimpleItem formSimpleItem3 = (FormSimpleItem) ViewBindings.findChildViewById(view, R.id.rhy);
                                if (formSimpleItem3 != null) {
                                    i3 = R.id.rhz;
                                    FormSimpleItem formSimpleItem4 = (FormSimpleItem) ViewBindings.findChildViewById(view, R.id.rhz);
                                    if (formSimpleItem4 != null) {
                                        i3 = R.id.f163714rm1;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163714rm1);
                                        if (textView != null) {
                                            return new MiniWxAppDebugSetttingBinding((LinearLayout) view, editText, spinner, formSwitchItem, formSimpleItem, formSimpleItem2, recyclerView, formSimpleItem3, formSimpleItem4, textView);
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
