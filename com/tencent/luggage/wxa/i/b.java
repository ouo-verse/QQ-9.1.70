package com.tencent.luggage.wxa.i;

import android.content.Context;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.i.d;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f129182b = "DrawableImageStreamFetcher";

    /* renamed from: c, reason: collision with root package name */
    public static final String f129183c = "drawable://";

    /* renamed from: a, reason: collision with root package name */
    private Context f129184a;

    public b(@NonNull Context context) {
        this.f129184a = context;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public String a() {
        return "drawable";
    }

    @Override // com.tencent.luggage.wxa.i.d
    public boolean accept(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return ((String) obj).startsWith(f129183c);
    }

    @Override // com.tencent.luggage.wxa.i.d
    public d.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        return new d.a(this.f129184a.getResources().openRawResource(Integer.valueOf(((String) obj).substring(11)).intValue()));
    }
}
