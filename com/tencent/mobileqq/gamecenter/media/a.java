package com.tencent.mobileqq.gamecenter.media;

import android.graphics.Color;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f212194a;

    /* renamed from: b, reason: collision with root package name */
    public final double f212195b;

    /* renamed from: c, reason: collision with root package name */
    public final long f212196c;

    /* renamed from: d, reason: collision with root package name */
    public double f212197d;

    /* renamed from: e, reason: collision with root package name */
    public int f212198e;

    /* renamed from: f, reason: collision with root package name */
    public int f212199f;

    public a(String str, double d16) {
        this(str, d16, 0.0d, -1, 0);
    }

    public a(String str, double d16, double d17, int i3, int i16) {
        this.f212194a = str;
        this.f212195b = d16;
        this.f212196c = (long) (d16 * 1000.0d);
        this.f212197d = d17;
        this.f212198e = i3;
        this.f212199f = i16;
    }

    public a(String str, double d16, double d17, String str2, String str3) {
        this.f212198e = -1;
        this.f212199f = 0;
        this.f212194a = str;
        this.f212195b = d16;
        this.f212196c = (long) (d16 * 1000.0d);
        this.f212197d = d17;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f212198e = Color.parseColor(str2);
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            this.f212199f = Color.parseColor(str3);
        } catch (Exception unused2) {
        }
    }
}
