package com.tencent.luggage.wxa.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.i.d;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements IImageDecodeService.a {

    /* renamed from: g, reason: collision with root package name */
    private static final String f123859g = "DefaultBitmapDecoder";

    /* renamed from: d, reason: collision with root package name */
    private BitmapType f123863d;

    /* renamed from: e, reason: collision with root package name */
    private IImageDecodeService.b f123864e;

    /* renamed from: a, reason: collision with root package name */
    private int f123860a = 2048;

    /* renamed from: b, reason: collision with root package name */
    private int f123861b = 2048;

    /* renamed from: c, reason: collision with root package name */
    private b f123862c = new b();

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f123865f = false;

    public a() {
        this.f123862c.a(BitmapType.Native, new com.github.henryye.nativeiv.comm.a());
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public boolean a() {
        return this.f123865f;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public void destroy() {
        this.f123865f = true;
        this.f123862c.a();
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public void forceSetUseType(BitmapType bitmapType) {
        this.f123863d = bitmapType;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public IBitmap a(String str, Object obj, com.tencent.luggage.wxa.i.d dVar, ImageDecodeConfig imageDecodeConfig) {
        com.tencent.luggage.wxa.e.a aVar = new com.tencent.luggage.wxa.e.a();
        aVar.a(this.f123860a, this.f123861b);
        aVar.a(str);
        aVar.b(dVar.a());
        try {
            d.a a16 = dVar.a(obj, imageDecodeConfig);
            if (a16.f129189a != null && TextUtils.isEmpty(a16.f129190b)) {
                InputStream inputStream = a16.f129189a;
                c a17 = a(this.f123862c, aVar);
                a17.a(this.f123863d);
                a17.a(this.f123864e);
                com.tencent.luggage.wxa.f.d a18 = a(a17, inputStream);
                if (a18 == null) {
                    this.f123864e.a(str, IImageDecodeService.b.a.PRE_DECODE_ERROR, aVar);
                    return null;
                }
                if (a18.f125094a == com.tencent.luggage.wxa.f.c.UNKNOWN) {
                    this.f123864e.a(str, IImageDecodeService.b.a.UNSUPPORTED_IMG_FORMAT, aVar);
                    return null;
                }
                a(a17, str, inputStream, imageDecodeConfig, a18);
                if (a18.f125095b <= this.f123860a && a18.f125096c <= this.f123861b) {
                    return a17.b();
                }
                this.f123864e.a(str, IImageDecodeService.b.a.HUGE_SIZE, aVar);
                a17.b().recycle();
                return null;
            }
            aVar.c(a16.f129190b);
            this.f123864e.a(str, IImageDecodeService.b.a.NOT_EXIST, aVar);
            return null;
        } catch (Exception e16) {
            this.f123864e.a(str, IImageDecodeService.b.a.THROW_EXCEPTION, aVar);
            com.tencent.luggage.wxa.h.b.b(f123859g, "ImageDecoder(%s) decode path[%s] error %s", dVar, obj.toString(), e16.toString());
            return null;
        }
    }

    public c a(@NonNull b bVar, @NonNull com.tencent.luggage.wxa.e.a aVar) {
        return new c(bVar, aVar);
    }

    private com.tencent.luggage.wxa.f.d a(@NonNull c cVar, @Nullable InputStream inputStream) {
        return cVar.a(inputStream);
    }

    public void a(@NonNull c cVar, String str, InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.tencent.luggage.wxa.f.d dVar) {
        cVar.a(str, inputStream, imageDecodeConfig, dVar.f125094a);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public void a(int i3, int i16) {
        this.f123860a = i3;
        this.f123861b = i16;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService.a
    public void a(IImageDecodeService.b bVar) {
        this.f123864e = bVar;
    }
}
