package com.qzone.video.TVK_SDK.mediaplayer.utils;

import android.content.Context;
import android.os.Looper;
import ap.g;
import org.apache.http.Header;

/* compiled from: P */
/* loaded from: classes37.dex */
public class HttpUtils {

    /* renamed from: a, reason: collision with root package name */
    private static ap.a f59871a;

    /* renamed from: b, reason: collision with root package name */
    private static g f59872b;

    /* compiled from: P */
    /* renamed from: com.qzone.video.TVK_SDK.mediaplayer.utils.HttpUtils$1, reason: invalid class name */
    /* loaded from: classes37.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f59873d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ap.d f59874e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ap.b f59875f;

        @Override // java.lang.Runnable
        public void run() {
            HttpUtils.a().e(this.f59873d, this.f59874e, this.f59875f);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.video.TVK_SDK.mediaplayer.utils.HttpUtils$2, reason: invalid class name */
    /* loaded from: classes37.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f59876d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ap.d f59877e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ap.b f59878f;

        @Override // java.lang.Runnable
        public void run() {
            HttpUtils.a().q(this.f59876d, this.f59877e, this.f59878f);
        }
    }

    static /* bridge */ /* synthetic */ g a() {
        return e();
    }

    public static String b(String str) {
        return c(str);
    }

    private static ap.a d() {
        if (f59871a == null) {
            synchronized (HttpUtils.class) {
                if (f59871a == null) {
                    f59871a = new ap.a();
                }
            }
        }
        return f59871a;
    }

    private static g e() {
        if (f59872b == null) {
            synchronized (HttpUtils.class) {
                if (f59872b == null) {
                    f59872b = new g();
                }
            }
        }
        return f59872b;
    }

    public static void f(final Context context, final String str, final String str2, final Header[] headerArr, final ap.d dVar, final String str3, final ap.b bVar) {
        if (Looper.myLooper() != null) {
            d().n(context, str, str2, headerArr, dVar, str3, bVar);
        } else {
            c.f59897g.execute(new Runnable() { // from class: com.qzone.video.TVK_SDK.mediaplayer.utils.HttpUtils.4
                @Override // java.lang.Runnable
                public void run() {
                    HttpUtils.a().n(context, str, str2, headerArr, dVar, str3, bVar);
                }
            });
        }
    }

    public static void g(final Context context, final String str, final Header[] headerArr, final ap.d dVar, final String str2, final ap.b bVar) {
        if (Looper.myLooper() != null) {
            d().p(context, str, headerArr, dVar, str2, bVar);
        } else {
            c.f59897g.execute(new Runnable() { // from class: com.qzone.video.TVK_SDK.mediaplayer.utils.HttpUtils.3
                @Override // java.lang.Runnable
                public void run() {
                    HttpUtils.a().p(context, str, headerArr, dVar, str2, bVar);
                }
            });
        }
    }

    public static String c(String str) {
        return (str == null || !str.startsWith("QZOutputJson=")) ? str : str.substring(13);
    }
}
