package com.tencent.luggage.wxa.zg;

import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f146627a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    public static boolean f146628b = true;

    public static final Pattern a() {
        return f146627a;
    }

    public static final boolean b() {
        return f146628b;
    }
}
