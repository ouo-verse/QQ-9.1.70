package com.tencent.luggage.wxa.zg;

import android.content.Context;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.tn.w;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f146632a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f146633b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f146634c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a extends com.tencent.luggage.wxa.eo.c {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f146635a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(a.class));
            return Boolean.FALSE;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(b.f146635a);
        f146633b = lazy;
        f146634c = "DataSourceFactoryCreator";
    }

    public final boolean a() {
        return ((Boolean) f146633b.getValue()).booleanValue();
    }

    public g.a a(Context context, com.tencent.luggage.wxa.mg.i iVar, Map map) {
        g.a aVar;
        Intrinsics.checkNotNullParameter(context, "context");
        if (map == null && !com.tencent.luggage.wxa.mg.l.a().d()) {
            if (iVar != null) {
                aVar = a() ? iVar.y() : iVar.n();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                w.d("MicroMsg.AppBrand.DataSourceFactoryCreator", "getDataSourceFactory, return customized data source factory");
                return aVar;
            }
        }
        w.d("MicroMsg.AppBrand.DataSourceFactoryCreator", "getDataSourceFactory, return default data source factory");
        g.a a16 = k.a(context, map);
        Intrinsics.checkNotNullExpressionValue(a16, "buildDefaultDataSourceFactory(context, headers)");
        return a16;
    }
}
