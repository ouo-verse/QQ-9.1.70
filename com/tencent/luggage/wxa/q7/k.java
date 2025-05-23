package com.tencent.luggage.wxa.q7;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f138011a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static com.tencent.luggage.wxaapi.q f138012b;

    public final void a(com.tencent.luggage.wxaapi.q qVar) {
        f138012b = qVar;
    }

    public final void b(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a(4, tag, msg2);
    }

    public final void c(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a(5, tag, msg2);
    }

    public final void a(int i3, String str, String str2) {
        com.tencent.luggage.wxaapi.q qVar = f138012b;
        if (qVar != null) {
            qVar.println(i3, str, str2);
        }
    }

    public final void a(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a(6, tag, msg2);
    }
}
