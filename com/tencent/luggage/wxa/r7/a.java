package com.tencent.luggage.wxa.r7;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.e5.j;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.n3.m0;
import com.tencent.luggage.wxa.q7.a0;
import com.tencent.luggage.wxa.rc.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z4.f;
import java.io.File;
import java.util.List;
import kotlin.UninitializedPropertyAccessException;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt__FileTreeWalkKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends a0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f139413f = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "STORAGE_SIZE_MAX_MB", "getSTORAGE_SIZE_MAX_MB()J", 0))};

    /* renamed from: e, reason: collision with root package name */
    public static final a f139412e = new a();

    /* renamed from: g, reason: collision with root package name */
    public static final String f139414g = "Luggage.WxaPkgCachePruner";

    /* renamed from: h, reason: collision with root package name */
    public static final j f139415h = new j("WxaPkgCachePruner", (Object) 0L);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6680a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f139416a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6680a(String str) {
            super(1);
            this.f139416a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(File it) {
            boolean contains$default;
            Intrinsics.checkNotNullParameter(it, "it");
            String name = it.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            String appId = this.f139416a;
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) appId, false, 2, (Object) null);
            return Boolean.valueOf(contains$default);
        }
    }

    public final void a(long j3) {
        f139415h.a(this, f139413f[0], Long.valueOf(j3));
    }

    @Override // com.tencent.luggage.wxa.q7.a0
    public void b() {
        try {
            i();
        } catch (Throwable th5) {
            w.b(h(), "doCheck get exception:" + th5);
        }
    }

    @Override // com.tencent.luggage.wxa.q7.a0
    public String h() {
        return f139414g;
    }

    public final void i() {
        FileTreeWalk walkBottomUp;
        Sequence<File> filter;
        long j3 = j();
        if (j3 <= 0) {
            return;
        }
        v vVar = new v(m0.b());
        long j16 = j3 * 1024 * 1024;
        long b16 = m.b(vVar);
        w.d(h(), "checkPruneGuarded, storageOccupiedSizeBytes:" + b16 + ", storageSizeMaxBytes:" + j16);
        if (b16 <= j16) {
            return;
        }
        try {
            f a16 = f.f146283b.a();
            List<String> b17 = o0.a().b();
            if (b17 == null) {
                return;
            }
            for (String appId : b17) {
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                if (a16.h(appId, -1)) {
                    w.d(f139412e.h(), "checkPruneGuarded " + appId + " is running. skip ");
                } else {
                    String b18 = x.b(vVar.g(), false);
                    Intrinsics.checkNotNull(b18);
                    walkBottomUp = FilesKt__FileTreeWalkKt.walkBottomUp(new File(b18));
                    filter = SequencesKt___SequencesKt.filter(walkBottomUp, new C6680a(appId));
                    for (File file : filter) {
                        if (file.exists()) {
                            if (file.isFile()) {
                                long length = file.length();
                                if (file.delete()) {
                                    b16 -= length;
                                    if (b16 <= j16) {
                                        return;
                                    }
                                } else {
                                    continue;
                                }
                            } else if (file.isDirectory()) {
                                v a17 = v.a(file);
                                Intrinsics.checkNotNull(a17);
                                long b19 = m.b(a17);
                                if (x.a(file.getAbsolutePath(), true)) {
                                    b16 -= b19;
                                    if (b16 <= j16) {
                                        return;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        } catch (UninitializedPropertyAccessException e16) {
            w.b(h(), "checkPruneGuarded acquire processManager failed by " + e16);
        }
    }

    public final long j() {
        return ((Number) f139415h.a(this, f139413f[0])).longValue();
    }
}
