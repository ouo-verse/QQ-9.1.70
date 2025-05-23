package com.tencent.luggage.wxa.i;

import android.content.Context;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.i.d;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f129179b = "AssetsImageStreamFetcher";

    /* renamed from: c, reason: collision with root package name */
    public static final String f129180c = "assets://";

    /* renamed from: a, reason: collision with root package name */
    private Context f129181a;

    public a(@NonNull Context context) {
        this.f129181a = context;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public String a() {
        return "assets";
    }

    @Override // com.tencent.luggage.wxa.i.d
    public boolean accept(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return ((String) obj).startsWith("assets://");
    }

    @Override // com.tencent.luggage.wxa.i.d
    public d.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        return new d.a(a(this.f129181a, ((String) obj).substring(9)));
    }

    private InputStream a(@NonNull Context context, @NonNull String str) {
        try {
            return context.getAssets().open(str);
        } catch (IOException e16) {
            com.tencent.luggage.wxa.h.b.a(f129179b, e16, "encountered exception!", new Object[0]);
            return null;
        }
    }
}
