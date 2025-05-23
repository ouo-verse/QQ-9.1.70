package com.tencent.luggage.wxa.ao;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f121605a;

    /* renamed from: b, reason: collision with root package name */
    public final String f121606b;

    /* renamed from: c, reason: collision with root package name */
    public final String f121607c;

    /* renamed from: d, reason: collision with root package name */
    public final String f121608d;

    public a(String name, String dataType, String tableName, String referTo) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(referTo, "referTo");
        this.f121605a = name;
        this.f121606b = dataType;
        this.f121607c = tableName;
        this.f121608d = referTo;
    }
}
