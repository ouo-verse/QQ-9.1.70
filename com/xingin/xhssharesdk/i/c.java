package com.xingin.xhssharesdk.i;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteErrorCode;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteNewErrorCode;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.callback.XhsShareCallback;
import com.xingin.xhssharesdk.callback.XhsShareRegisterCallback;
import com.xingin.xhssharesdk.core.XhsShareActivity;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.i.c;
import com.xingin.xhssharesdk.log.IShareLogger;
import com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import xz4.j;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final Context f389979a;

    /* renamed from: b, reason: collision with root package name */
    public final String f389980b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final XhsShareGlobalConfig f389981c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a05.a f389982d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public XhsShareRegisterCallback f389983e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public XhsShareCallback f389984f;

    /* renamed from: g, reason: collision with root package name */
    public String f389985g;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public volatile xz4.a f389987i;

    /* renamed from: j, reason: collision with root package name */
    public com.xingin.xhssharesdk.p.a f389988j;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Handler f389990l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public WeakReference<Activity> f389991m;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public g f389993o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public b f389994p;

    /* renamed from: h, reason: collision with root package name */
    public e f389986h = null;

    /* renamed from: k, reason: collision with root package name */
    public boolean f389989k = false;

    /* renamed from: n, reason: collision with root package name */
    public final a f389992n = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements IShareLogger {
        public a() {
        }

        @Override // com.xingin.xhssharesdk.log.IShareLogger
        public final void d(String str, String str2) {
            if (c.this.f389981c.isEnableLog()) {
                c.this.f389981c.getShareLogger().d(str, str2);
            }
        }

        @Override // com.xingin.xhssharesdk.log.IShareLogger
        public final void e(String str, String str2, @Nullable Throwable th5) {
            if (c.this.f389981c.isEnableLog()) {
                c.this.f389981c.getShareLogger().e(str, str2, th5);
            }
        }

        @Override // com.xingin.xhssharesdk.log.IShareLogger
        public final void i(String str, String str2) {
            if (c.this.f389981c.isEnableLog()) {
                c.this.f389981c.getShareLogger().i(str, str2);
            }
        }

        @Override // com.xingin.xhssharesdk.log.IShareLogger
        public final void v(String str, String str2) {
            if (c.this.f389981c.isEnableLog()) {
                c.this.f389981c.getShareLogger().v(str, str2);
            }
        }

        @Override // com.xingin.xhssharesdk.log.IShareLogger
        public final void w(String str, String str2, @Nullable Throwable th5) {
            if (c.this.f389981c.isEnableLog()) {
                c.this.f389981c.getShareLogger().w(str, str2, th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public final String f389996d;

        public b(String str) {
            this.f389996d = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (XhsShareSdk.f389977a == null) {
                return;
            }
            c cVar = XhsShareSdk.f389977a;
            boolean equals = TextUtils.equals(this.f389996d, cVar.c());
            cVar.f389992n.d("XhsShare_Sdk", "delayInterruptRunnable run! sessionId equals: " + equals);
            if (equals) {
                WeakReference<Activity> weakReference = cVar.f389991m;
                if (weakReference != null && weakReference.get() != null) {
                    Activity activity = cVar.f389991m.get();
                    g gVar = cVar.f389993o;
                    if (gVar != null) {
                        try {
                            activity.unregisterReceiver(gVar);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    cVar.f389992n.w("XhsShare_Sdk", "unregisterShareResultReceiverWithOutsideActivity, OutsideActivity is NULL!", null);
                }
                cVar.g(cVar.c(), XhsShareConstants$XhsShareNoteNewErrorCode.GET_SHARE_RESULT_TIMEOUT, -10000001, "Get ShareResult from Xhs timeout!", null, true);
                cVar.f389992n.e("XhsShare_Sdk", "[" + cVar.c() + "][new: -20400006][old:-10000001]Get ShareResult from Xhs timeout!", null);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.xingin.xhssharesdk.i.c$c, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C10097c implements wz4.a {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public final wz4.a f389997a;

        public C10097c(@NonNull XhsShareActivity.a aVar) {
            this.f389997a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str, int i3, int i16, String str2, Throwable th5) {
            this.f389997a.a(str, i3, i16, str2, th5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, Uri uri) {
            this.f389997a.b(str, uri);
        }

        @Override // wz4.a
        public final void a(@NonNull final String str, final int i3, final int i16, @NonNull final String str2, final Throwable th5) {
            com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: xz4.f
                @Override // java.lang.Runnable
                public final void run() {
                    c.C10097c.this.e(str, i3, i16, str2, th5);
                }
            });
        }

        @Override // wz4.a
        public final void b(@NonNull final String str, @NonNull final Uri uri) {
            com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: xz4.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.C10097c.this.f(str, uri);
                }
            });
        }

        public /* synthetic */ C10097c(XhsShareActivity.a aVar, int i3) {
            this(aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class d implements wz4.c {
        @Override // wz4.c
        public final void a(a05.b bVar) {
            b bVar2;
            if (XhsShareSdk.f389977a == null) {
                return;
            }
            c cVar = XhsShareSdk.f389977a;
            boolean equals = TextUtils.equals(bVar.f25325d, cVar.c());
            cVar.f389992n.d("XhsShare_Sdk", "OutsideReceiveShareResultCallback onReceive, equals is " + equals + " ,result is " + bVar);
            if (equals) {
                Handler handler = cVar.f389990l;
                if (handler != null && (bVar2 = cVar.f389994p) != null) {
                    handler.removeCallbacks(bVar2);
                    cVar.f389994p = null;
                    cVar.f389992n.d("XhsShare_Sdk", "removeDelayInterruptRunnable");
                }
                WeakReference<Activity> weakReference = cVar.f389991m;
                if (weakReference != null && weakReference.get() != null) {
                    Activity activity = cVar.f389991m.get();
                    g gVar = cVar.f389993o;
                    if (gVar != null) {
                        try {
                            activity.unregisterReceiver(gVar);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    cVar.f389992n.w("XhsShare_Sdk", "unregisterShareResultReceiverWithOutsideActivity, OutsideActivity is NULL!", null);
                }
                if (bVar.f25322a) {
                    cVar.i(bVar.f25325d);
                    return;
                }
                Pair<Integer, Integer> errorCodeFromXhsShareResult = XhsShareSdkTools.getErrorCodeFromXhsShareResult(bVar);
                cVar.g(bVar.f25325d, ((Integer) errorCodeFromXhsShareResult.first).intValue(), ((Integer) errorCodeFromXhsShareResult.second).intValue(), bVar.f25324c, null, true);
                cVar.f389992n.e("XhsShare_Sdk", "[" + bVar.f25325d + "][new: " + errorCodeFromXhsShareResult.first + "][old:" + errorCodeFromXhsShareResult.second + "]" + bVar.f25324c, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e extends BaseThread {

        @NonNull
        public final XhsNote C;

        @NonNull
        public final C10097c D;

        @NonNull
        public final String E;
        public final long F;

        public e(XhsNote xhsNote, @NonNull String str, @NonNull long j3, XhsShareActivity.a aVar) {
            this.C = xhsNote;
            this.E = str;
            this.D = new C10097c(aVar, 0);
            this.F = j3;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Throwable th5;
            C10097c c10097c;
            String str;
            int i3;
            int i16;
            String str2;
            String cacheDirPath;
            super.run();
            try {
                c cVar = c.this;
                Context context = cVar.f389979a;
                String h16 = cVar.h();
                XhsNote xhsNote = this.C;
                c cVar2 = c.this;
                if (TextUtils.isEmpty(cVar2.f389981c.getCacheDirPath())) {
                    cacheDirPath = XhsShareSdkTools.getDefaultCacheDirPath(cVar2.f389979a);
                } else {
                    cacheDirPath = cVar2.f389981c.getCacheDirPath();
                }
                this.D.b(this.E, j.a(c.this.f389979a, j.c(context, h16, xhsNote, cacheDirPath), this.E, this.F));
            } catch (com.xingin.xhssharesdk.l.a e16) {
                this.D.a(this.E, XhsShareConstants$XhsShareNoteNewErrorCode.PROCESS_DATA_ERROR, XhsShareConstants$XhsShareNoteErrorCode.PROCESS_ERROR, "[" + e16.f389999a + "]" + e16.getMessage(), e16);
            } catch (IOException e17) {
                th5 = e17;
                c10097c = this.D;
                str = this.E;
                i3 = XhsShareConstants$XhsShareNoteNewErrorCode.IO_ERROR;
                i16 = XhsShareConstants$XhsShareNoteErrorCode.PROCESS_ERROR;
                str2 = "IO Exception!";
                c10097c.a(str, i3, i16, str2, th5);
            } catch (InterruptedException e18) {
                th5 = e18;
                c10097c = this.D;
                str = this.E;
                i3 = XhsShareConstants$XhsShareNoteNewErrorCode.INTERRUPTED_ERROR;
                i16 = XhsShareConstants$XhsShareNoteErrorCode.PROCESS_THREAD_INTERRUPTED;
                str2 = "ProcessDataThread has be interrupted!!";
                c10097c.a(str, i3, i16, str2, th5);
            } catch (JSONException e19) {
                th5 = e19;
                c10097c = this.D;
                str = this.E;
                i3 = XhsShareConstants$XhsShareNoteNewErrorCode.JSON_ERROR;
                i16 = XhsShareConstants$XhsShareNoteErrorCode.GENERATE_JSON_ERROR;
                str2 = "Convert json error!";
                c10097c.a(str, i3, i16, str2, th5);
            }
        }
    }

    public c(@NonNull Context context, String str, @NonNull XhsShareGlobalConfig xhsShareGlobalConfig) {
        this.f389979a = context;
        this.f389980b = str;
        this.f389981c = xhsShareGlobalConfig;
    }

    public static void d(c cVar) {
        if (cVar.f389982d != null) {
            SharedPreferences sharedPreferences = cVar.f389979a.getSharedPreferences("XHS_SHARE_SDK_SP", 0);
            try {
                sharedPreferences.edit().putString("XHS_SHARE_SDK_SP_KEY_TOKEN_CHECK_INFO", cVar.f389982d.b().toString()).apply();
            } catch (JSONException e16) {
                cVar.f389992n.w("XhsShare_Sdk", "TokenCheckInfo to Json error.", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        XhsShareCallback xhsShareCallback = this.f389984f;
        if (xhsShareCallback != null) {
            xhsShareCallback.onSuccess(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str, int i3, int i16, String str2, Throwable th5) {
        XhsShareCallback xhsShareCallback = this.f389984f;
        if (xhsShareCallback != null) {
            xhsShareCallback.onError2(str, i3, i16, str2, th5);
        }
    }

    public final String c() {
        xz4.a aVar = this.f389987i;
        if (aVar != null) {
            return aVar.f449175a;
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(final String str, final int i3, final int i16, final String str2, final Throwable th5, boolean z16) {
        boolean z17;
        String stringWriter;
        long j3;
        com.xingin.xhssharesdk.p.a aVar;
        String cacheDirPath;
        xz4.a aVar2 = this.f389987i;
        if (aVar2 == null) {
            this.f389992n.e("XhsShare_Sdk", "notifyShareError error, currentShareContext is NULL!", null);
            return;
        }
        d05.b bVar = aVar2.f449176b;
        String str3 = aVar2.f449175a;
        if (!TextUtils.isEmpty(bVar.f392637a) && TextUtils.equals(str3, bVar.f392637a)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (bVar.f392640d != 0) {
                XhsShareSdk.d("ShareTimelineTracker", "shareResultTimestamp has be assigned!", null);
            } else {
                bVar.f392640d = System.currentTimeMillis();
            }
        }
        aVar2.f449177c = false;
        Context context = this.f389979a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append("\t");
        if (th5 == null) {
            stringWriter = "";
        } else {
            StringWriter stringWriter2 = new StringWriter();
            th5.printStackTrace(new PrintWriter(stringWriter2));
            stringWriter = stringWriter2.toString();
        }
        sb5.append(stringWriter);
        String sb6 = sb5.toString();
        d05.b bVar2 = aVar2.f449176b;
        long j16 = bVar2.f392639c;
        if (j16 <= 0) {
            j16 = bVar2.f392638b;
        }
        if (j16 > 0) {
            long j17 = bVar2.f392640d;
            if (j17 > 0) {
                long j18 = j17 - j16;
                if (j18 >= 0) {
                    j3 = j18;
                    d05.a.b(context, str, false, i3, sb6, j3);
                    com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: xz4.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.xingin.xhssharesdk.i.c.this.f(str, i3, i16, str2, th5);
                        }
                    });
                    if (z16 && this.f389981c.isClearCacheWhenShareComplete()) {
                        aVar = this.f389988j;
                        if (aVar != null && aVar.isAlive()) {
                            this.f389988j.interrupt();
                        }
                        if (!TextUtils.isEmpty(this.f389981c.getCacheDirPath())) {
                            cacheDirPath = XhsShareSdkTools.getDefaultCacheDirPath(this.f389979a);
                        } else {
                            cacheDirPath = this.f389981c.getCacheDirPath();
                        }
                        com.xingin.xhssharesdk.p.a aVar3 = new com.xingin.xhssharesdk.p.a(new File(cacheDirPath));
                        this.f389988j = aVar3;
                        aVar3.start();
                    }
                    this.f389991m = null;
                }
            }
        }
        j3 = -1;
        d05.a.b(context, str, false, i3, sb6, j3);
        com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: xz4.d
            @Override // java.lang.Runnable
            public final void run() {
                com.xingin.xhssharesdk.i.c.this.f(str, i3, i16, str2, th5);
            }
        });
        if (z16) {
            aVar = this.f389988j;
            if (aVar != null) {
                this.f389988j.interrupt();
            }
            if (!TextUtils.isEmpty(this.f389981c.getCacheDirPath())) {
            }
            com.xingin.xhssharesdk.p.a aVar32 = new com.xingin.xhssharesdk.p.a(new File(cacheDirPath));
            this.f389988j = aVar32;
            aVar32.start();
        }
        this.f389991m = null;
    }

    public final String h() {
        if (TextUtils.isEmpty(this.f389981c.getFileProviderAuthority())) {
            return XhsShareSdkTools.getCurrentAppPackageName(this.f389979a) + ".provider";
        }
        return this.f389981c.getFileProviderAuthority();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(final String str) {
        boolean z16;
        long j3;
        String cacheDirPath;
        xz4.a aVar = this.f389987i;
        if (aVar == null) {
            this.f389992n.e("XhsShare_Sdk", "notifyShareSuccess error, currentShareContext is NULL!", null);
            return;
        }
        d05.b bVar = aVar.f449176b;
        String str2 = aVar.f449175a;
        if (!TextUtils.isEmpty(bVar.f392637a) && TextUtils.equals(str2, bVar.f392637a)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (bVar.f392640d != 0) {
                XhsShareSdk.d("ShareTimelineTracker", "shareResultTimestamp has be assigned!", null);
            } else {
                bVar.f392640d = System.currentTimeMillis();
            }
        }
        aVar.f449177c = false;
        Context context = this.f389979a;
        d05.b bVar2 = aVar.f449176b;
        long j16 = bVar2.f392639c;
        if (j16 <= 0) {
            j16 = bVar2.f392638b;
        }
        if (j16 > 0) {
            long j17 = bVar2.f392640d;
            if (j17 > 0) {
                long j18 = j17 - j16;
                if (j18 >= 0) {
                    j3 = j18;
                    d05.a.b(context, str, true, 0, "", j3);
                    com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: xz4.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.xingin.xhssharesdk.i.c.this.e(str);
                        }
                    });
                    if (this.f389981c.isClearCacheWhenShareComplete()) {
                        com.xingin.xhssharesdk.p.a aVar2 = this.f389988j;
                        if (aVar2 != null && aVar2.isAlive()) {
                            this.f389988j.interrupt();
                        }
                        if (TextUtils.isEmpty(this.f389981c.getCacheDirPath())) {
                            cacheDirPath = XhsShareSdkTools.getDefaultCacheDirPath(this.f389979a);
                        } else {
                            cacheDirPath = this.f389981c.getCacheDirPath();
                        }
                        com.xingin.xhssharesdk.p.a aVar3 = new com.xingin.xhssharesdk.p.a(new File(cacheDirPath));
                        this.f389988j = aVar3;
                        aVar3.start();
                    }
                    this.f389991m = null;
                }
            }
        }
        j3 = -1;
        d05.a.b(context, str, true, 0, "", j3);
        com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: xz4.c
            @Override // java.lang.Runnable
            public final void run() {
                com.xingin.xhssharesdk.i.c.this.e(str);
            }
        });
        if (this.f389981c.isClearCacheWhenShareComplete()) {
        }
        this.f389991m = null;
    }

    public final void j() {
        b bVar;
        if (this.f389990l == null) {
            this.f389990l = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.f389990l;
        if (handler != null && (bVar = this.f389994p) != null) {
            handler.removeCallbacks(bVar);
            this.f389994p = null;
            this.f389992n.d("XhsShare_Sdk", "removeDelayInterruptRunnable");
        }
        this.f389992n.d("XhsShare_Sdk", "setupInterruptTimeout");
        b bVar2 = new b(c());
        this.f389994p = bVar2;
        this.f389990l.postDelayed(bVar2, 20000L);
    }
}
