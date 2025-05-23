package com.tencent.luggage.wxa.qc;

import android.os.Looper;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g extends h {

    /* renamed from: d, reason: collision with root package name */
    public final String[] f138668d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138669e;

    public g(String str, Looper looper) {
        super(str, looper);
        this.f138668d = new String[]{"invokeEnterMethods", "invokeExitMethods", "handleMessage:", "quit"};
        this.f138669e = false;
        super.a(true);
    }

    public abstract void a(f fVar);

    @Override // com.tencent.luggage.wxa.wn.c
    public void h(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArr = this.f138668d;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (str.startsWith(strArr[i3])) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (z16) {
            super.n(str);
        } else {
            super.o(str);
        }
        if (str.startsWith("handleMessage: E")) {
            this.f138669e = true;
        }
        if (str.startsWith("handleMessage: X")) {
            this.f138669e = false;
        }
    }

    public final boolean n() {
        return this.f138669e;
    }
}
