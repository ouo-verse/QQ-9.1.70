package com.tencent.luggage.wxa.xd;

import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class q extends p {
    public static final int CTRL_INDEX = 754;

    @NotNull
    public static final String NAME = "onCopyUrl";

    /* renamed from: b, reason: collision with root package name */
    public static final a f144876b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f144877a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public q(boolean z16) {
        this.f144877a = z16;
    }

    public final void a(int i3, com.tencent.luggage.wxa.r4.d service) {
        Intrinsics.checkNotNullParameter(service, "service");
        HashMap hashMap = new HashMap();
        hashMap.put("webviewId", Integer.valueOf(i3));
        hashMap.put("shortLinkEnable", Boolean.valueOf(this.f144877a));
        setContext(service).setData(hashMap).dispatch();
    }
}
