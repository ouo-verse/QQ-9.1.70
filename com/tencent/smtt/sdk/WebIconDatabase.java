package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import com.tencent.smtt.export.external.interfaces.IconListener;

/* compiled from: P */
@Deprecated
/* loaded from: classes23.dex */
public class WebIconDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static WebIconDatabase f369196a;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes23.dex */
    public interface a {
        void a(String str, Bitmap bitmap);
    }

    WebIconDatabase() {
    }

    private static synchronized WebIconDatabase a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            if (f369196a == null) {
                f369196a = new WebIconDatabase();
            }
            webIconDatabase = f369196a;
        }
        return webIconDatabase;
    }

    public static WebIconDatabase getInstance() {
        return a();
    }

    public void close() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().m();
        } else {
            android.webkit.WebIconDatabase.getInstance().close();
        }
    }

    public void open(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().open(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().d(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        }
    }

    public void removeAllIcons() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().l();
        } else {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        }
    }

    public void requestIconForPageUrl(String str, final a aVar) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().a(str, new IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.1
                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        } else {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new WebIconDatabase.IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.2
                @Override // android.webkit.WebIconDatabase.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        }
    }

    public void retainIconForPageUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().c(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        }
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, a aVar) {
    }
}
