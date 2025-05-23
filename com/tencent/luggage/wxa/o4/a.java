package com.tencent.luggage.wxa.o4;

import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends p {
    private static final int CTRL_INDEX = -2;

    @NotNull
    private static final String NAME = "onClientRequest";

    /* renamed from: a, reason: collision with root package name */
    public static final C6531a f136144a = new C6531a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.o4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6531a {
        public C6531a() {
        }

        public /* synthetic */ C6531a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(com.tencent.luggage.wxa.ic.d env, int i3, int i16, com.tencent.luggage.wxa.fn.b bVar) {
            byte[] bArr;
            Intrinsics.checkNotNullParameter(env, "env");
            HashMap hashMap = new HashMap();
            hashMap.put("id", Integer.valueOf(i3));
            hashMap.put(DTConstants.TAG.API, Integer.valueOf(i16));
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (bVar != null) {
                bArr = bVar.b();
            } else {
                bArr = null;
            }
            hashMap.put("data", c0.a(bArr));
            c0.a(env.getJsRuntime(), hashMap, (c0.a) env.a(c0.a.class));
            env.a(new a(hashMap, defaultConstructorMarker));
        }
    }

    public /* synthetic */ a(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public a(Map map) {
        super.setData(map);
    }
}
