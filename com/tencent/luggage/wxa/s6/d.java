package com.tencent.luggage.wxa.s6;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.s6.h;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends f {

    /* renamed from: a0, reason: collision with root package name */
    public static final b f140075a0 = new b(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.z1.f {
        @Override // com.tencent.luggage.wxa.z1.f, com.tencent.luggage.wxa.kj.p.e0
        public v a(p container, String str) {
            Intrinsics.checkNotNullParameter(container, "container");
            return d.f140075a0.a(h.INSTANCE);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/luggage/wxa/s6/d$b$a", "Lcom/tencent/luggage/wxa/s6/h;", "Landroid/graphics/Bitmap;", "w0", "Lcom/tencent/luggage/wxa/xo/d;", ICustomDataEditor.STRING_PARAM_1, "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes8.dex */
        public static final class a extends h {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.s6.d$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6706a implements com.tencent.luggage.wxa.uo.b {
                public C6706a() {
                }

                @Override // com.tencent.luggage.wxa.uo.b
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Bitmap call(Void r36) {
                    com.tencent.magicbrush.ui.g c16;
                    com.tencent.magicbrush.b magicBrush;
                    com.tencent.magicbrush.a s16;
                    com.tencent.luggage.wxa.z1.d dVar = (com.tencent.luggage.wxa.z1.d) a.this.f(com.tencent.luggage.wxa.z1.d.class);
                    if (dVar == null || (c16 = dVar.c()) == null || (magicBrush = c16.getMagicBrush()) == null || (s16 = magicBrush.s()) == null) {
                        return null;
                    }
                    return com.tencent.magicbrush.a.a(s16, (Bitmap) null, 1, (Object) null);
                }
            }

            public a(Class<e> cls) {
                super(cls);
            }

            @Override // com.tencent.luggage.wxa.m4.b
            public com.tencent.luggage.wxa.xo.d s1() {
                com.tencent.luggage.wxa.xo.d b16 = com.tencent.luggage.wxa.xo.h.c().b(new C6706a());
                Intrinsics.checkNotNullExpressionValue(b16, "override fun getScreensh\u2026     })\n                }");
                return b16;
            }

            @Override // com.tencent.luggage.wxa.p5.e, com.tencent.luggage.wxa.kj.v
            public Bitmap w0() {
                com.tencent.magicbrush.ui.g c16;
                com.tencent.magicbrush.b magicBrush;
                com.tencent.magicbrush.a s16;
                com.tencent.luggage.wxa.z1.d dVar = (com.tencent.luggage.wxa.z1.d) f(com.tencent.luggage.wxa.z1.d.class);
                if (dVar == null || (c16 = dVar.c()) == null || (magicBrush = c16.getMagicBrush()) == null || (s16 = magicBrush.s()) == null) {
                    return null;
                }
                com.tencent.magicbrush.ui.g c17 = dVar.c();
                Intrinsics.checkNotNull(c17);
                return s16.a(c17.getVirtualElementId(), -1, true);
            }
        }

        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a(h.Companion companion) {
            Intrinsics.checkNotNullParameter(companion, "<this>");
            return new a(e.class);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, com.tencent.luggage.wxa.c5.e rt5) {
        super(context, rt5, new a());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rt5, "rt");
    }
}
