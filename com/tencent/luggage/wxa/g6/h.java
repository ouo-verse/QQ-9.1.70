package com.tencent.luggage.wxa.g6;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h extends n implements com.tencent.luggage.wxa.ml.m {

    /* renamed from: h, reason: collision with root package name */
    public final l f126545h;

    /* renamed from: i, reason: collision with root package name */
    public int f126546i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f126547j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f126548k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f126549l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, l dialogController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogController, "dialogController");
        this.f126545h = dialogController;
        this.f126546i = 1;
        this.f126547j = true;
        this.f126548k = true;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return this.f126548k;
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        this.f126549l = false;
        DialogInterface.OnDismissListener f16 = f();
        if (f16 != null) {
            f16.onDismiss(this);
        }
        this.f126545h.dismiss();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return e();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return this.f126546i;
    }

    @Override // com.tencent.luggage.wxa.g6.k
    public boolean isShowing() {
        return this.f126549l;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
        this.f126549l = false;
        if (d() == null) {
            DialogInterface.OnDismissListener f16 = f();
            if (f16 != null) {
                f16.onDismiss(this);
            }
        } else {
            DialogInterface.OnCancelListener d16 = d();
            if (d16 != null) {
                d16.onCancel(this);
            }
        }
        cancel();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
        this.f126549l = true;
    }

    @Override // com.tencent.luggage.wxa.g6.k
    public void show() {
        this.f126545h.show();
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(com.tencent.luggage.wxa.ml.r rVar) {
        DialogInterface.OnShowListener g16 = g();
        if (g16 != null) {
            g16.onShow(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return this.f126547j;
    }
}
