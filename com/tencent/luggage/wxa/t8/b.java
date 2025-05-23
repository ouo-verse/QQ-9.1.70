package com.tencent.luggage.wxa.t8;

import android.util.Base64;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.i.d;
import com.tencent.luggage.wxa.w8.h;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.ByteArrayInputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f140902a = {MimeHelper.IMAGE_SUBTYPE_JPEG, "png", "gif", "svg+xml"};

    @Override // com.tencent.luggage.wxa.i.d
    public String a() {
        return "base64";
    }

    @Override // com.tencent.luggage.wxa.i.d
    public boolean accept(Object obj) {
        if (!(obj instanceof String) || a((String) obj) <= 0) {
            return false;
        }
        return true;
    }

    public final int a(String str) {
        int i3;
        boolean z16;
        if (h.b(str) || !str.startsWith("data:image/")) {
            return 0;
        }
        String[] strArr = f140902a;
        int length = strArr.length;
        int i16 = 0;
        while (true) {
            i3 = 11;
            if (i16 >= length) {
                z16 = false;
                break;
            }
            String str2 = strArr[i16];
            if (str.startsWith(str2, 11)) {
                i3 = 11 + str2.length();
                z16 = true;
                break;
            }
            i16++;
        }
        if (z16 && str.startsWith(";base64,", i3)) {
            return i3 + 8;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public d.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        String str = (String) obj;
        return new d.a(new ByteArrayInputStream(Base64.decode(str.substring(a(str)), 2)));
    }
}
