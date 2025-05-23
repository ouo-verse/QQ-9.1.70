package com.tencent.luggage.wxa.n6;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f135454a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap f135455b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f135456c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f135457d;

    /* renamed from: e, reason: collision with root package name */
    public int f135458e;

    /* renamed from: f, reason: collision with root package name */
    public int f135459f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f135460g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f135461h;

    public a(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("file:///") && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f135455b = null;
        this.f135454a = uri;
        this.f135456c = null;
        this.f135457d = true;
    }

    public static a a(String str) {
        if (str != null) {
            if (!str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER)) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                str = "file:///" + str;
            }
            return new a(Uri.parse(str));
        }
        throw new NullPointerException("Uri must not be null");
    }

    public final Integer b() {
        return this.f135456c;
    }

    public final int c() {
        return this.f135459f;
    }

    public final Rect d() {
        return this.f135460g;
    }

    public final int e() {
        return this.f135458e;
    }

    public final boolean f() {
        return this.f135457d;
    }

    public final Uri g() {
        return this.f135454a;
    }

    public final boolean h() {
        return this.f135461h;
    }

    public final Bitmap a() {
        return this.f135455b;
    }
}
