package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final String f36449a;

    /* renamed from: b, reason: collision with root package name */
    public final int f36450b;

    public w(String str) {
        this.f36449a = str;
        this.f36450b = a(str);
    }

    public static w a(String str) {
        return new w(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w.class == obj.getClass()) {
            return TextUtils.equals(this.f36449a, ((w) obj).f36449a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f36450b;
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
