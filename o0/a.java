package o0;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f421655a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f421656b;

    /* renamed from: c, reason: collision with root package name */
    private final Integer f421657c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f421658d;

    /* renamed from: e, reason: collision with root package name */
    private int f421659e;

    /* renamed from: f, reason: collision with root package name */
    private int f421660f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f421661g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f421662h;

    a(@NonNull Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("file:///") && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f421656b = null;
        this.f421655a = uri;
        this.f421657c = null;
        this.f421658d = true;
    }

    @NonNull
    public static a a(@NonNull String str) {
        if (str != null) {
            return m("file:///android_asset/" + str);
        }
        throw new NullPointerException("Asset name must not be null");
    }

    @NonNull
    public static a j(int i3) {
        return new a(i3);
    }

    @NonNull
    public static a m(@NonNull String str) {
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

    public final Bitmap b() {
        return this.f421656b;
    }

    public final Integer c() {
        return this.f421657c;
    }

    public final int d() {
        return this.f421660f;
    }

    public final Rect e() {
        return this.f421661g;
    }

    public final int f() {
        return this.f421659e;
    }

    public final boolean g() {
        return this.f421658d;
    }

    public final Uri h() {
        return this.f421655a;
    }

    public final boolean i() {
        return this.f421662h;
    }

    @NonNull
    public a k(boolean z16) {
        this.f421658d = z16;
        return this;
    }

    @NonNull
    public a l() {
        return k(true);
    }

    a(int i3) {
        this.f421656b = null;
        this.f421655a = null;
        this.f421657c = Integer.valueOf(i3);
        this.f421658d = true;
    }
}
