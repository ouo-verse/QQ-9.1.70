package com.tencent.luggage.wxa.uk;

import android.graphics.BitmapFactory;
import com.tencent.mm.graphics.MMBitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f142757a = new l();

    public boolean a(String str) {
        Throwable th5;
        InputStream inputStream;
        boolean z16;
        InputStream inputStream2 = null;
        try {
            Intrinsics.checkNotNull(str);
            inputStream = com.tencent.luggage.wxa.cp.x.n(str);
        } catch (Exception unused) {
        } catch (Throwable th6) {
            th5 = th6;
            inputStream = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.a(inputStream, null, options);
            z16 = a(options);
            if (inputStream == null) {
                return z16;
            }
        } catch (Exception unused2) {
            inputStream2 = inputStream;
            if (inputStream2 == null) {
                return false;
            }
            InputStream inputStream3 = inputStream2;
            z16 = false;
            inputStream = inputStream3;
            inputStream.close();
        } catch (Throwable th7) {
            th5 = th7;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th5;
        }
        try {
            inputStream.close();
        } catch (IOException unused4) {
            return z16;
        }
    }

    public final boolean a(BitmapFactory.Options options) {
        String str;
        int indexOf$default;
        if (options == null || (str = options.outMimeType) == null) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String mimeType = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(mimeType, "this as java.lang.String).toLowerCase(locale)");
        Intrinsics.checkNotNullExpressionValue(mimeType, "mimeType");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) mimeType, "wxam", 0, false, 6, (Object) null);
        return indexOf$default >= 0;
    }
}
