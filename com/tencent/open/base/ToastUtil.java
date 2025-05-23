package com.tencent.open.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.widget.QFixToast;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ToastUtil {

    /* renamed from: d, reason: collision with root package name */
    protected static ToastUtil f340959d;

    /* renamed from: a, reason: collision with root package name */
    protected QQToast f340960a = null;

    /* renamed from: b, reason: collision with root package name */
    protected QFixToast f340961b = null;

    /* renamed from: c, reason: collision with root package name */
    protected Handler f340962c = new Handler(Looper.getMainLooper());

    public static ToastUtil a() {
        if (f340959d == null) {
            f340959d = new ToastUtil();
        }
        return f340959d;
    }

    public void b(int i3) {
        c(i3, 0);
    }

    public void c(final int i3, final int i16) {
        this.f340962c.post(new Runnable() { // from class: com.tencent.open.base.ToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                ToastUtil toastUtil = ToastUtil.this;
                QQToast qQToast = toastUtil.f340960a;
                if (qQToast == null) {
                    toastUtil.f340960a = QQToast.makeText(com.tencent.open.adapter.a.f().e(), i3, i16);
                    ToastUtil.this.f340960a.show();
                } else {
                    qQToast.setToastMsg(i3);
                    ToastUtil.this.f340960a.setDuration(i16);
                    ToastUtil.this.f340960a.show();
                }
            }
        });
    }

    public void d(final View view, final int i3) {
        this.f340962c.post(new Runnable() { // from class: com.tencent.open.base.ToastUtil.3
            @Override // java.lang.Runnable
            public void run() {
                ToastUtil toastUtil = ToastUtil.this;
                QFixToast qFixToast = toastUtil.f340961b;
                if (qFixToast == null) {
                    toastUtil.f340961b = new QFixToast(com.tencent.open.adapter.a.f().e());
                    ToastUtil.this.f340961b.setView(view);
                    ToastUtil.this.f340961b.setDuration(i3);
                    ToastUtil.this.f340961b.show();
                    return;
                }
                qFixToast.setView(view);
                ToastUtil.this.f340961b.setDuration(i3);
                ToastUtil.this.f340961b.show();
            }
        });
    }

    public void e(String str) {
        f(str, 0);
    }

    public void f(final String str, final int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f340962c.post(new Runnable() { // from class: com.tencent.open.base.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                ToastUtil toastUtil = ToastUtil.this;
                QQToast qQToast = toastUtil.f340960a;
                if (qQToast == null) {
                    toastUtil.f340960a = QQToast.makeText(com.tencent.open.adapter.a.f().e(), str, i3);
                    ToastUtil.this.f340960a.show();
                } else {
                    qQToast.setToastMsg(str);
                    ToastUtil.this.f340960a.setDuration(i3);
                    ToastUtil.this.f340960a.show();
                }
            }
        });
    }
}
