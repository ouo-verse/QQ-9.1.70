package com.tencent.luggage.wxa.l7;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f133099a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final AppBrandSimpleImageLoader.g f133100b = new AppBrandSimpleImageLoader.g();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r0 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap a(String str) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        AppBrandSimpleImageLoader.g gVar = f133100b;
        Bitmap bitmap = gVar.get(str);
        if (bitmap == null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "file://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "assets://", false, 2, null);
                if (!startsWith$default2) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str, "wcf://", false, 2, null);
                }
            }
            try {
                Bitmap decodeStream = com.tencent.luggage.wxa.x9.a.decodeStream(x.n(str));
                gVar.a(str, decodeStream);
                return decodeStream;
            } catch (Exception e16) {
                w.b("Luggage.Wxa.Menu.SimpleBitmapCacheForFileUrl", "getBitmapForUrl decode failed by " + e16);
                return null;
            }
        }
        return bitmap;
    }
}
