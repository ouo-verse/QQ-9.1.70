package com.tencent.gdtad.views.canvas.components.danmaku;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes6.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private String[] f109613a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private Random f109614b = new Random();

    /* renamed from: c, reason: collision with root package name */
    private int f109615c = 0;

    @Nullable
    public final String a() {
        String[] strArr = this.f109613a;
        if (strArr != null && strArr.length != 0) {
            int max = Math.max(this.f109615c % strArr.length, 0);
            String str = strArr[max];
            this.f109615c = max + 1;
            return str;
        }
        return "";
    }

    public boolean b() {
        String[] strArr = this.f109613a;
        if (strArr != null && strArr.length != 0) {
            return false;
        }
        return true;
    }

    public void c() {
        this.f109615c = 0;
        this.f109613a = null;
    }

    @NonNull
    public a d(String[] strArr) {
        this.f109613a = strArr;
        return this;
    }
}
