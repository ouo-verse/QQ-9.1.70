package com.tencent.smtt.sdk;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MimeTypeMap {

    /* renamed from: a, reason: collision with root package name */
    private static MimeTypeMap f368981a;

    MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().h(str);
        }
        return android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            if (f368981a == null) {
                f368981a = new MimeTypeMap();
            }
            mimeTypeMap = f368981a;
        }
        return mimeTypeMap;
    }

    public String getExtensionFromMimeType(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().l(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public String getMimeTypeFromExtension(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().j(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public boolean hasExtension(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().k(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().hasExtension(str);
    }

    public boolean hasMimeType(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().i(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().hasMimeType(str);
    }
}
