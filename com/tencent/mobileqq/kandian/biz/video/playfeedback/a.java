package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.BaseApplication;
import l62.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private Context f239653a = BaseApplication.getContext();

    /* renamed from: b, reason: collision with root package name */
    private View f239654b;

    /* renamed from: c, reason: collision with root package name */
    private View.OnClickListener f239655c;

    /* renamed from: d, reason: collision with root package name */
    private View f239656d;

    public a(View view, View.OnClickListener onClickListener) {
        this.f239654b = view;
        this.f239655c = onClickListener;
    }

    public boolean b() {
        View view = this.f239656d;
        return view != null && view.getVisibility() == 0;
    }

    public void a() {
    }

    public void c(int i3, String str, String str2) {
    }
}
