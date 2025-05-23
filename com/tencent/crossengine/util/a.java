package com.tencent.crossengine.util;

import android.content.Context;
import android.util.DisplayMetrics;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f100528a;

    /* renamed from: b, reason: collision with root package name */
    private int f100529b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f100530c;

    /* renamed from: d, reason: collision with root package name */
    private float f100531d;

    public a(Context context, boolean z16) {
        this.f100530c = false;
        this.f100531d = 1.0f;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f100531d = 1.0f;
        this.f100528a = displayMetrics.widthPixels;
        this.f100529b = displayMetrics.heightPixels;
        this.f100530c = z16;
    }

    public float a() {
        return this.f100531d;
    }

    public boolean b() {
        return this.f100530c;
    }
}
