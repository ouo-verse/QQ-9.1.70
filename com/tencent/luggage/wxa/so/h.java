package com.tencent.luggage.wxa.so;

import android.content.Context;
import android.os.Trace;
import java.util.ArrayDeque;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f140579a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f140580b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayDeque initialValue() {
            return new ArrayDeque(8);
        }
    }

    static {
        boolean z16;
        if (!com.tencent.luggage.wxa.tn.e.f141559a && !com.tencent.luggage.wxa.tn.e.f141564f) {
            z16 = false;
        } else {
            z16 = true;
        }
        f140579a = z16;
        f140580b = new a();
    }

    public static void a(String str) {
        if (f140579a) {
            if (str.length() > 127) {
                str = str.substring(str.length() - 127);
            }
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (f140579a) {
            Trace.endSection();
        }
    }

    public static String a(Context context, String str) {
        String packageName = context.getPackageName();
        return str.startsWith(packageName) ? str.substring(packageName.length()) : str;
    }
}
