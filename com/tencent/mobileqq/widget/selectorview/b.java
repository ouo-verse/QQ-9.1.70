package com.tencent.mobileqq.widget.selectorview;

import android.content.Context;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.widget.selectorview.QPickerView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends h {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f317391h = {IProfileCardConst.NAME_NO_LIMIT, "\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7", "\u767d\u7f8a\u5ea7", "\u91d1\u725b\u5ea7", "\u53cc\u5b50\u5ea7", "\u5de8\u87f9\u5ea7", "\u72ee\u5b50\u5ea7", "\u5904\u5973\u5ea7", "\u5929\u79e4\u5ea7", "\u5929\u874e\u5ea7", "\u5c04\u624b\u5ea7", "\u6469\u7faf\u5ea7"};

    /* renamed from: g, reason: collision with root package name */
    private final QPickerView.e f317392g;

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
            return b.f317391h.length;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int i3, int i16) {
            if (i16 < 0 || i16 >= b.f317391h.length) {
                i16 = 0;
            }
            return b.f317391h[i16];
        }
    }

    public b(Context context, boolean z16) {
        super(context, z16);
        a aVar = new a();
        this.f317392g = aVar;
        this.f317413c.k(aVar, z16);
        k("\u9009\u62e9\u661f\u5ea7");
    }

    public int o() {
        return this.f317413c.h(0);
    }

    public void p(int i3) {
        this.f317413c.setSelection(0, i3);
        this.f317413c.m(0);
    }
}
