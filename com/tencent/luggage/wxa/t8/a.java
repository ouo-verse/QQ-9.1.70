package com.tencent.luggage.wxa.t8;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.LegacyBitmap;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.a.h;
import com.tencent.luggage.wxa.a.k;
import com.tencent.luggage.wxa.d.c;
import com.tencent.luggage.wxa.f.d;
import com.tencent.luggage.wxa.p8.f;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.d.a {

    /* renamed from: h, reason: collision with root package name */
    public final String f140896h = "MB.BitmapDecoderMagicBrushExtension";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t8.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6743a extends c {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a f140897g;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.t8.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6744a implements com.tencent.luggage.wxa.f.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f140898a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C6743a f140899b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.t8.a$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6745a extends LegacyBitmap {

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ h f140900c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ C6743a f140901d;

                public C6745a(h hVar, C6743a c6743a) {
                    this.f140900c = hVar;
                    this.f140901d = c6743a;
                }

                @Override // com.github.henryye.nativeiv.LegacyBitmap
                public Bitmap a(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.tencent.luggage.wxa.f.c cVar) {
                    int d16 = (int) this.f140900c.d();
                    int c16 = (int) this.f140900c.c();
                    if (cVar == com.tencent.luggage.wxa.f.c.CUSTOM && d16 > 0 && d16 > 0) {
                        if (imageDecodeConfig != null) {
                            Pair a16 = this.f140901d.a(imageDecodeConfig);
                            if (((Number) a16.getFirst()).intValue() > 0 && ((Number) a16.getSecond()).intValue() > 0) {
                                d16 = ((Number) a16.getFirst()).intValue();
                                c16 = ((Number) a16.getSecond()).intValue();
                            }
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(d16, c16, Bitmap.Config.ARGB_8888);
                        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(preferredWi\u2026 Bitmap.Config.ARGB_8888)");
                        new Canvas(createBitmap).drawPicture(this.f140900c.h(), new RectF(0.0f, 0.0f, d16, c16));
                        return createBitmap;
                    }
                    Bitmap a17 = super.a(inputStream, imageDecodeConfig, cVar);
                    Intrinsics.checkNotNullExpressionValue(a17, "{\n                      \u2026                        }");
                    return a17;
                }
            }

            public C6744a(h hVar, C6743a c6743a) {
                this.f140898a = hVar;
                this.f140899b = c6743a;
            }

            @Override // com.tencent.luggage.wxa.f.b
            public boolean a(InputStream inputStream, Bitmap.Config config, com.tencent.luggage.wxa.f.c cVar) {
                return true;
            }

            @Override // com.tencent.luggage.wxa.f.b
            public IBitmap a() {
                return new C6745a(this.f140898a, this.f140899b);
            }

            @Override // com.tencent.luggage.wxa.f.b
            public void destroy() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6743a(com.tencent.luggage.wxa.d.b bVar, com.tencent.luggage.wxa.e.a aVar, a aVar2) {
            super(bVar, aVar);
            this.f140897g = aVar2;
        }

        @Override // com.tencent.luggage.wxa.d.c
        public d b(InputStream ins) {
            Intrinsics.checkNotNullParameter(ins, "ins");
            d info = super.b(ins);
            if (info.f125094a == com.tencent.luggage.wxa.f.c.UNKNOWN) {
                com.tencent.luggage.wxa.h.b.d(this.f140897g.f140896h, "hy: unknown type. judge svg", new Object[0]);
                try {
                    h a16 = h.a(ins);
                    if (a16 != null) {
                        info.f125094a = com.tencent.luggage.wxa.f.c.CUSTOM;
                        a(BitmapType.Legacy);
                        a(new C6744a(a16, this));
                    }
                } catch (k e16) {
                    com.tencent.luggage.wxa.h.b.a(this.f140897g.f140896h, e16, "hy: not svg image. return as failed", new Object[0]);
                    info.f125094a = com.tencent.luggage.wxa.f.c.UNKNOWN;
                }
            }
            Intrinsics.checkNotNullExpressionValue(info, "info");
            return info;
        }

        public final Pair a(ImageDecodeConfig imageDecodeConfig) {
            int i3;
            int i16;
            f.a(this.f140897g.f140896h, "hy: image config width %d, height %d, scale %f", Integer.valueOf(imageDecodeConfig.mPreferredWidth), Integer.valueOf(imageDecodeConfig.mPreferredHeight), Double.valueOf(imageDecodeConfig.mPreferredScale));
            int i17 = imageDecodeConfig.mPreferredWidth;
            if (i17 <= 0 || (i16 = imageDecodeConfig.mPreferredHeight) <= 0) {
                double d16 = imageDecodeConfig.mPreferredScale;
                i3 = d16 > 0.0d ? (int) (0 * d16) : 0;
                i17 = i3;
            } else {
                i3 = i16;
            }
            return new Pair(Integer.valueOf(i17), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.luggage.wxa.d.a
    public c a(com.tencent.luggage.wxa.d.b mgr, com.tencent.luggage.wxa.e.a decodeInfo) {
        Intrinsics.checkNotNullParameter(mgr, "mgr");
        Intrinsics.checkNotNullParameter(decodeInfo, "decodeInfo");
        return new C6743a(mgr, decodeInfo, this);
    }
}
