package com.tencent.luggage.wxa.j;

import android.graphics.BitmapFactory;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f130759a;

    static {
        HashMap hashMap = new HashMap(6);
        f130759a = hashMap;
        hashMap.put("image/jpeg", com.tencent.luggage.wxa.f.c.JPG);
        hashMap.put("image/gif", com.tencent.luggage.wxa.f.c.GIF);
        hashMap.put("image/png", com.tencent.luggage.wxa.f.c.PNG);
        com.tencent.luggage.wxa.f.c cVar = com.tencent.luggage.wxa.f.c.BMP;
        hashMap.put(ImageContentType.MIME_TYPE_X_MS_BMP, cVar);
        hashMap.put(MimeHelper.IMAGE_BMP, cVar);
        hashMap.put("image/webp", com.tencent.luggage.wxa.f.c.WEBP);
    }

    public static com.tencent.luggage.wxa.f.d a(InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream a16 = e.a(inputStream);
        e.b(a16);
        BitmapFactory.decodeStream(a16, null, options);
        com.tencent.luggage.wxa.f.c cVar = (com.tencent.luggage.wxa.f.c) f130759a.get(options.outMimeType);
        if (cVar == null) {
            cVar = com.tencent.luggage.wxa.f.c.UNKNOWN;
        }
        try {
            a16.reset();
        } catch (IOException e16) {
            com.tencent.luggage.wxa.h.b.a("Ni.FormatUtil", e16, "hy: the given stream is markable, but still reset error. should not forward", new Object[0]);
            cVar = com.tencent.luggage.wxa.f.c.UNKNOWN;
        }
        com.tencent.luggage.wxa.f.d dVar = new com.tencent.luggage.wxa.f.d();
        dVar.f125094a = cVar;
        dVar.f125096c = options.outHeight;
        dVar.f125095b = options.outWidth;
        return dVar;
    }
}
