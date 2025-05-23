package com.tencent.luggage.wxa.p004if;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tencent.luggage.wxa.eo.d;
import com.tencent.luggage.wxa.fo.b;
import com.tencent.mm.graphics.MMBitmapFactory;
import java.io.InputStream;

/* compiled from: P */
@b
/* loaded from: classes8.dex */
public class z extends d implements s {
    @Override // com.tencent.luggage.wxa.p004if.s
    public Bitmap a(String str, BitmapFactory.Options options) {
        return MMBitmapFactory.a(str, options);
    }

    @Override // com.tencent.luggage.wxa.p004if.s
    public Bitmap a(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return MMBitmapFactory.a(inputStream, rect, options);
    }

    @Override // com.tencent.luggage.wxa.p004if.s
    public Bitmap a(InputStream inputStream) {
        return com.tencent.luggage.wxa.tn.d.a(inputStream);
    }
}
