package com.tencent.mobileqq.widget.selectorview;

import android.content.Context;
import com.tencent.mobileqq.widget.selectorview.QPickerView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f extends h {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements QPickerView.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int i3) {
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int i3, int i16) {
            if (i16 < 0 || i16 > 1) {
                i16 = 0;
            }
            if (i16 == 0) {
                return "\u7537";
            }
            return "\u5973";
        }
    }

    public f(Context context) {
        super(context);
        this.f317413c.j(new a());
    }

    public int o() {
        return this.f317413c.h(0);
    }

    public void p(int i3) {
        this.f317413c.setSelection(0, i3);
        this.f317413c.m(0);
    }
}
