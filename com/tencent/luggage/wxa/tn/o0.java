package com.tencent.luggage.wxa.tn;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static b0 f141671a = new b0(com.tencent.luggage.wxa.kq.a.a("MicroMsg.ScreenShotUtil"));

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f141672b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public static final String f141673c = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f141674d = {InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "_data", "date_added"};

    /* renamed from: e, reason: collision with root package name */
    public static ContentObserver f141675e;

    /* renamed from: f, reason: collision with root package name */
    public static WeakReference f141676f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f141677a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f141678b;

        public a(Context context, b bVar) {
            this.f141677a = context;
            this.f141678b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", this.f141677a, this.f141678b, w0.b());
            try {
                if (this.f141677a == null) {
                    return;
                }
                if (this.f141678b != null) {
                    WeakReference unused = o0.f141676f = new WeakReference(this.f141678b);
                    if (o0.f141675e == null) {
                        ContentObserver unused2 = o0.f141675e = new c(this.f141677a, o0.f141672b);
                        this.f141677a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, o0.f141675e);
                        return;
                    }
                    return;
                }
                if (o0.f141675e != null) {
                    this.f141677a.getContentResolver().unregisterContentObserver(o0.f141675e);
                    ContentObserver unused3 = o0.f141675e = null;
                }
                if (o0.f141676f != null) {
                    o0.f141676f.clear();
                    WeakReference unused4 = o0.f141676f = null;
                }
            } catch (Throwable th5) {
                w.f("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(String str, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public long f141679a;

        /* renamed from: b, reason: collision with root package name */
        public String f141680b;

        /* renamed from: c, reason: collision with root package name */
        public Uri f141681c;

        /* renamed from: d, reason: collision with root package name */
        public Context f141682d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f141683a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Uri f141684b;

            public a(boolean z16, Uri uri) {
                this.f141683a = z16;
                this.f141684b = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                w.a("MicroMsg.ScreenShotUtil", "summerscreenshot onChange: " + this.f141683a + ", uri:" + this.f141684b.toString());
                try {
                    if (o0.f141676f != null && o0.f141676f.get() != null) {
                        if (this.f141684b.toString().matches(o0.f141673c) || this.f141684b.toString().contains(o0.f141673c)) {
                            c cVar = c.this;
                            cVar.a(cVar.f141682d, this.f141684b);
                            return;
                        }
                        return;
                    }
                    w.d("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", o0.f141676f);
                    if (o0.f141675e != null) {
                        c.this.f141682d.getContentResolver().unregisterContentObserver(o0.f141675e);
                        ContentObserver unused = o0.f141675e = null;
                    }
                    if (o0.f141676f != null) {
                        o0.f141676f.clear();
                        WeakReference unused2 = o0.f141676f = null;
                    }
                } catch (Throwable th5) {
                    w.f("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + th5.getMessage());
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f141686a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f141687b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f141688c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f141689d;

            public b(Context context, String str, long j3, long j16) {
                this.f141686a = context;
                this.f141687b = str;
                this.f141688c = j3;
                this.f141689d = j16;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.f141686a, this.f141687b, this.f141688c, this.f141689d);
            }
        }

        public c(Context context, Handler handler) {
            super(handler);
            this.f141682d = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16, Uri uri) {
            Uri uri2 = this.f141681c;
            if (uri2 != null && uri != null && uri2.getPath() != null && this.f141681c.getPath().equals(uri.getPath())) {
                super.onChange(z16, uri);
                return;
            }
            this.f141681c = uri;
            o0.f141671a.a((Runnable) new a(z16, uri));
            super.onChange(z16, uri);
        }

        public final void a(Context context, Uri uri) {
            Cursor query;
            Cursor cursor = null;
            try {
                try {
                    if (Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30) {
                        query = ContactsMonitor.query(context.getContentResolver(), uri, o0.f141674d, null, null, "date_added DESC limit 1");
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putInt("android:query-arg-limit", 1);
                        bundle.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});
                        bundle.putInt("android:query-arg-sort-direction", 1);
                        query = ContactsMonitor.query(context.getContentResolver(), uri, o0.f141674d, bundle, null);
                    }
                    cursor = query;
                    if (cursor != null && cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndex("_data"));
                        long j3 = cursor.getLong(cursor.getColumnIndex("date_added"));
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        w.a("MicroMsg.ScreenShotUtil", "summerscreenshot path: " + string + ", dateAdded: " + j3 + ", currentTime: " + currentTimeMillis);
                        o0.f141672b.post(new b(context, string, j3, currentTimeMillis));
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e16) {
                    w.f("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + e16.getMessage());
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th5) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th5;
            }
        }

        public final void a(Context context, String str, long j3, long j16) {
            try {
                if (Math.abs(j16 - j3) > 10 || j16 - this.f141679a <= 1 || w0.c(str) || (!(str.toLowerCase().contains("screenshot") || str.contains("\u622a\u5c4f") || str.contains("\u622a\u56fe")) || str.equals(this.f141680b))) {
                    j3 = 0;
                    str = null;
                } else {
                    this.f141679a = j16;
                    this.f141680b = str;
                }
                if (w0.c(str)) {
                    return;
                }
                w.d("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + str + ", time: " + j3);
                b bVar = o0.f141676f != null ? (b) o0.f141676f.get() : null;
                if (bVar == null) {
                    if (o0.f141675e != null) {
                        context.getContentResolver().unregisterContentObserver(o0.f141675e);
                        ContentObserver unused = o0.f141675e = null;
                    }
                    if (o0.f141676f != null) {
                        o0.f141676f.clear();
                        WeakReference unused2 = o0.f141676f = null;
                    }
                    w.d("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                    return;
                }
                bVar.a(str, j3);
            } catch (Throwable th5) {
                w.f("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + th5.getMessage());
            }
        }
    }

    public static void a(Context context, b bVar) {
        f141671a.a((Runnable) new a(context, bVar));
    }
}
