package com.tencent.luggage.wxa.i;

import android.content.Context;
import android.net.Uri;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.luggage.wxa.i.d;
import java.io.BufferedInputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f129191b = "URIImageStreamFetcher";

    /* renamed from: a, reason: collision with root package name */
    private Context f129192a;

    public e(Context context) {
        this.f129192a = context.getApplicationContext();
    }

    @Override // com.tencent.luggage.wxa.i.d
    public String a() {
        return LayoutAttrDefine.CLICK_URI;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public boolean accept(Object obj) {
        return obj instanceof Uri;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public d.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(this.f129192a.getContentResolver().openInputStream((Uri) obj));
        } catch (Exception unused) {
            com.tencent.luggage.wxa.h.b.b(f129191b, "can't open uri", new Object[0]);
            bufferedInputStream = null;
        }
        return new d.a(bufferedInputStream);
    }
}
