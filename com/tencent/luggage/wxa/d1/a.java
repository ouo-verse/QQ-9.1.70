package com.tencent.luggage.wxa.d1;

import android.content.Context;
import com.tencent.luggage.wxa.x0.h;
import com.tencent.mobileqq.R;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static com.tencent.luggage.wxa.x0.c a(com.tencent.luggage.wxa.x0.c cVar) {
        if (cVar != null) {
            if (cVar.k() != 1 && (cVar.b() == h.GALLERY_ONLY || cVar.b() == h.ALL)) {
                throw new IllegalStateException("ReturnMode.GALLERY_ONLY and ReturnMode.ALL is only applicable in Single Mode!");
            }
            if (cVar.g() == null || (cVar.g() instanceof Serializable)) {
                return cVar;
            }
            throw new IllegalStateException("Custom image loader must be a class that implement ImageLoader. This limitation due to Serializeable");
        }
        throw new IllegalStateException("ImagePickerConfig cannot be null");
    }

    public static String b(Context context, com.tencent.luggage.wxa.x0.c cVar) {
        String f16 = cVar.f();
        if (c.b(f16)) {
            return context.getString(R.string.f241577s9);
        }
        return f16;
    }

    public static String c(Context context, com.tencent.luggage.wxa.x0.c cVar) {
        String h16 = cVar.h();
        if (c.b(h16)) {
            return context.getString(R.string.f241587s_);
        }
        return h16;
    }

    public static boolean a(com.tencent.luggage.wxa.a1.a aVar, boolean z16) {
        h b16 = aVar.b();
        return z16 ? b16 == h.ALL || b16 == h.CAMERA_ONLY : b16 == h.ALL || b16 == h.GALLERY_ONLY;
    }

    public static String a(Context context, com.tencent.luggage.wxa.x0.c cVar) {
        String d16 = cVar.d();
        return c.b(d16) ? context.getString(R.string.f241437rv) : d16;
    }
}
