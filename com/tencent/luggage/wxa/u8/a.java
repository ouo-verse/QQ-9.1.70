package com.tencent.luggage.wxa.u8;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Point;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.luggage.wxa.i.d;
import com.tencent.luggage.wxa.p8.f;
import com.tencent.luggage.wxa.s8.i;
import com.tencent.luggage.wxa.w8.b;
import com.tencent.magicbrush.c;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u8.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6790a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f142157a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6790a(c cVar) {
            super(0);
            this.f142157a = cVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean z16;
            if (this.f142157a.e() > 0 && this.f142157a.d() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    public static final void a(c cVar, String message) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        if (cVar.h()) {
            f.c("MagicBrush", message, new Object[0]);
        }
    }

    public static final void b(c cVar) {
        AssetManager assetManager;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar.c() == null) {
            Context f16 = cVar.f();
            if (f16 != null) {
                assetManager = f16.getAssets();
            } else {
                assetManager = null;
            }
            cVar.a(assetManager);
        }
        if (cVar.c() != null) {
        } else {
            throw new IllegalStateException("AssetManager invalid. Either assetManager or context should be provided.".toString());
        }
    }

    public static final void c(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar.g() <= 0.0f && cVar.f() != null) {
            Context f16 = cVar.f();
            Intrinsics.checkNotNull(f16);
            cVar.a(b.a(f16));
        }
        C6790a c6790a = new C6790a(cVar);
        if (!((Boolean) c6790a.invoke()).booleanValue()) {
            if (cVar.f() != null) {
                if (cVar.f() != null) {
                    Context f17 = cVar.f();
                    Intrinsics.checkNotNull(f17);
                    Point b16 = b.b(f17);
                    Intrinsics.checkNotNullExpressionValue(b16, "getDisplayLogicSize(context!!)");
                    cVar.b(b16.x);
                    cVar.a(b16.y);
                    a(cVar, "w/h invalid, use context automatically. " + cVar.e() + '/' + cVar.d());
                }
            } else {
                throw new IllegalStateException(("w/h invalid. context invalid. " + cVar.e() + '/' + cVar.d()).toString());
            }
        }
        if (((Boolean) c6790a.invoke()).booleanValue()) {
            return;
        }
        throw new IllegalStateException(("dpr/w/h invalid. " + cVar.g() + '/' + cVar.e() + '/' + cVar.d()).toString());
    }

    public static final void d(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (!cVar.m().b()) {
            if (cVar.m().d() == null) {
                a(cVar, "ImageHandler invalid, BindingImage can not use. BE CAUTIOUS!");
                Unit unit = Unit.INSTANCE;
                return;
            }
            return;
        }
        BaseImageDecodeService baseImageDecodeService = new BaseImageDecodeService();
        baseImageDecodeService.addImageStreamFetcher(new com.tencent.luggage.wxa.t8.b(), false);
        List c16 = cVar.m().c();
        int i3 = 0;
        for (Object obj : c16) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            d dVar = (d) obj;
            boolean z16 = true;
            if (i3 != c16.size() - 1) {
                z16 = false;
            }
            baseImageDecodeService.addImageStreamFetcher(dVar, z16);
            i3 = i16;
        }
        if (cVar.m().e() != null) {
            baseImageDecodeService.setKvReportDelegate(cVar.m().e());
        }
        if (cVar.m().a() != null) {
            IImageDecodeService.a a16 = cVar.m().a();
            Intrinsics.checkNotNull(a16);
            baseImageDecodeService.setBitmapDecodeSlave(a16);
        }
        cVar.m().a(baseImageDecodeService);
    }

    public static final boolean a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        try {
            double k3 = cVar.k();
            if (0.0d <= k3 && k3 <= 1.0d) {
                if (cVar.f() != null) {
                    if (cVar.n() != null) {
                        if (cVar.q() != null) {
                            b(cVar);
                            c(cVar);
                            if (cVar.i() == null) {
                                a(cVar, "FileSystem invalid, BindingFileSystem can not use. BE CAUTIOUS!");
                                Unit unit = Unit.INSTANCE;
                            }
                            d(cVar);
                            if (cVar.j() == null) {
                                cVar.a(new i());
                            }
                            return true;
                        }
                        throw new IllegalStateException("v8RawPointer invalid. Please define which JsEngine magicbrush should use.".toString());
                    }
                    throw new IllegalStateException("JsThreadHandler invalid.".toString());
                }
                throw new IllegalStateException("AndroidContext invalid.".toString());
            }
            throw new IllegalStateException(("GcFactor must in [0, 1], but " + cVar.k()).toString());
        } catch (Exception e16) {
            if (cVar.a()) {
                throw e16;
            }
            return false;
        }
    }
}
