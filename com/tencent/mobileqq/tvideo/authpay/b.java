package com.tencent.mobileqq.tvideo.authpay;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.authpay.a;
import com.tencent.paysdk.api.l;
import com.tencent.paysdk.api.q;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements l {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f304353a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<a.f> f304354b;

    public b(ViewGroup viewGroup, a.f fVar) {
        this.f304353a = viewGroup;
        this.f304354b = new WeakReference<>(fVar);
    }

    @Override // com.tencent.paysdk.api.l
    public void b() {
        if (this.f304353a == null) {
            return;
        }
        QLog.d("TVideoAuthPayJsApiDelegate", 4, this.f304353a.getId() + " closePage ");
        this.f304353a.setVisibility(8);
    }

    @Override // com.tencent.paysdk.api.l
    public void e() {
        if (this.f304353a == null) {
            return;
        }
        QLog.d("TVideoAuthPayJsApiDelegate", 4, this.f304353a.getId() + " hideBackButton ");
    }

    @Override // com.tencent.paysdk.api.l
    public void f(int i3, int i16) {
        if (this.f304353a == null) {
            return;
        }
        QLog.d("TVideoAuthPayJsApiDelegate", 4, this.f304353a.getId() + " setH5LayoutParams ");
        ViewGroup.LayoutParams layoutParams = this.f304353a.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.f304353a.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.paysdk.api.l
    @NonNull
    public q g() {
        return new c(this.f304353a, this.f304354b.get());
    }
}
