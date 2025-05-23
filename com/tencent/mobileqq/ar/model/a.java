package com.tencent.mobileqq.ar.model;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.model.CameraProxy;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a implements CameraProxy.c {

    /* renamed from: d, reason: collision with root package name */
    protected int f198521d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected int f198522e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected int f198523f = 0;

    /* renamed from: h, reason: collision with root package name */
    protected int f198524h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected Context f198525i;

    /* renamed from: m, reason: collision with root package name */
    protected AppInterface f198526m;

    public int G() {
        return this.f198521d;
    }

    public void H(Context context, AppInterface appInterface) {
        this.f198525i = context;
        this.f198526m = appInterface;
    }

    public void I() {
        this.f198521d = 3;
    }

    public void J() {
        this.f198521d = 2;
    }

    public void K() {
        this.f198521d = 5;
    }
}
