package com.tencent.gdtad.api.interstitial;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
final class GdtArkPreDownloadTask {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<a> f108576a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.gdtad.api.interstitial.a f108577b;

    /* renamed from: c, reason: collision with root package name */
    private long f108578c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f108579d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f108580e = false;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private ArkAppMgr.IGetAppPathByNameCallback f108581f = new ArkAppMgr.IGetAppPathByNameCallback() { // from class: com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6
        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        public void onGetAppPathByName(final int i3, final String str, @Nullable final ArkAppMgr.AppPathInfo appPathInfo) {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6.1
                @Override // java.lang.Runnable
                public void run() {
                    Object obj;
                    ArkAppMgr.AppPathInfo appPathInfo2;
                    String str2 = null;
                    try {
                        obj = AdJSON.fromObject(appPathInfo);
                    } catch (Throwable th5) {
                        GdtLog.i("GdtArkPreDownloadTask", "onGetAppPathByName", th5);
                        obj = null;
                    }
                    Object[] objArr = new Object[3];
                    boolean z16 = false;
                    objArr[0] = Integer.valueOf(i3);
                    int i16 = 1;
                    objArr[1] = str;
                    if (obj != null) {
                        str2 = obj.toString();
                    }
                    objArr[2] = str2;
                    GdtLog.i("GdtArkPreDownloadTask", String.format("onGetAppPathByName retCode:%d msg:%s appPathInfo:%s", objArr));
                    int i17 = i3;
                    if (i17 == -6) {
                        return;
                    }
                    int a16 = b.a(i17);
                    if (a16 == 0 && (appPathInfo2 = appPathInfo) != null && !TextUtils.isEmpty(appPathInfo2.path) && !TextUtils.isEmpty(GdtArkPreDownloadTask.this.o())) {
                        z16 = true;
                    }
                    if (z16 || a16 != 0) {
                        i16 = a16;
                    }
                    if (z16) {
                        GdtArkPreDownloadTask.this.w(3);
                        GdtArkPreDownloadTask.this.t();
                    } else {
                        GdtArkPreDownloadTask.this.w(4);
                        GdtArkPreDownloadTask.this.r(i16, i3, 0L);
                    }
                }
            }, 5);
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.tencent.gdtad.api.interstitial.a aVar);

        void b(com.tencent.gdtad.api.interstitial.a aVar, int i3, int i16);

        void c(com.tencent.gdtad.api.interstitial.a aVar, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtArkPreDownloadTask(WeakReference<a> weakReference, com.tencent.gdtad.api.interstitial.a aVar, long j3) {
        this.f108578c = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f108576a = weakReference;
        this.f108577b = aVar;
        this.f108578c = j3;
        v();
    }

    private static boolean n(int i3, int i16) {
        if (i3 == 0) {
            if (i16 == 1 || i16 == 1) {
                return true;
            }
        } else if (i3 == 1) {
            if (i16 == 2 || i16 == 3) {
                return true;
            }
        } else if (i3 == 2 && (i16 == 3 || i16 == 4)) {
            return true;
        }
        GdtLog.e("GdtArkPreDownloadTask", String.format("checkStatus result:false oldStatus:%d newStatus:%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String o() {
        String str;
        if (q()) {
            ArkAppMgr arkAppMgr = ArkAppMgr.getInstance();
            com.tencent.gdtad.api.interstitial.a aVar = this.f108577b;
            str = arkAppMgr.getAppPathFromLocal(aVar.f108629a, aVar.f108631c);
        } else {
            str = null;
        }
        GdtLog.i("GdtArkPreDownloadTask", String.format("getPath %s", str));
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        com.tencent.gdtad.api.interstitial.a aVar = this.f108577b;
        if (aVar != null && aVar.a()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final int i3, final int i16, long j3) {
        AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.3
            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                boolean z16;
                if (GdtArkPreDownloadTask.this.f108576a != null) {
                    aVar = (a) GdtArkPreDownloadTask.this.f108576a.get();
                } else {
                    aVar = null;
                }
                Object[] objArr = new Object[5];
                if (aVar != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[0] = Boolean.valueOf(z16);
                objArr[1] = Integer.valueOf(GdtArkPreDownloadTask.this.f108579d);
                objArr[2] = Boolean.valueOf(GdtArkPreDownloadTask.this.f108580e);
                objArr[3] = Integer.valueOf(i3);
                objArr[4] = Integer.valueOf(i16);
                GdtLog.i("GdtArkPreDownloadTask", String.format("notifyFailed listener:%b status:%d notified:%b error:%d arkError:%d", objArr));
                if (!GdtArkPreDownloadTask.this.f108580e) {
                    GdtArkPreDownloadTask.this.f108580e = true;
                    if (aVar != null) {
                        aVar.b(GdtArkPreDownloadTask.this.f108577b, i3, i16);
                    }
                }
            }
        }, 0, j3);
    }

    private void s(final int i3) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.4
            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                boolean z16;
                if (GdtArkPreDownloadTask.this.f108576a != null) {
                    aVar = (a) GdtArkPreDownloadTask.this.f108576a.get();
                } else {
                    aVar = null;
                }
                Object[] objArr = new Object[2];
                if (aVar != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[0] = Boolean.valueOf(z16);
                objArr[1] = Integer.valueOf(i3);
                GdtLog.i("GdtArkPreDownloadTask", String.format("notifyStatusChanged listener:%b status:%d", objArr));
                if (aVar != null) {
                    aVar.c(GdtArkPreDownloadTask.this.f108577b, i3);
                }
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.2
            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                boolean z16;
                if (GdtArkPreDownloadTask.this.f108576a != null) {
                    aVar = (a) GdtArkPreDownloadTask.this.f108576a.get();
                } else {
                    aVar = null;
                }
                Object[] objArr = new Object[3];
                if (aVar != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[0] = Boolean.valueOf(z16);
                objArr[1] = Integer.valueOf(GdtArkPreDownloadTask.this.f108579d);
                objArr[2] = Boolean.valueOf(GdtArkPreDownloadTask.this.f108580e);
                GdtLog.i("GdtArkPreDownloadTask", String.format("notifySuccess listener:%b status:%d notified:%b", objArr));
                if (!GdtArkPreDownloadTask.this.f108580e) {
                    GdtArkPreDownloadTask.this.f108580e = true;
                    if (aVar != null) {
                        aVar.a(GdtArkPreDownloadTask.this.f108577b);
                    }
                }
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
            @Override // java.lang.Runnable
            public void run() {
                GdtLog.i("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", GdtArkPreDownloadTask.this.f108577b.f108629a, GdtArkPreDownloadTask.this.f108577b.f108630b, GdtArkPreDownloadTask.this.f108577b.f108632d));
                ArkAppMgr.getInstance().getAppPathByName(GdtArkPreDownloadTask.this.f108577b.f108629a, GdtArkPreDownloadTask.this.f108577b.f108632d, GdtArkPreDownloadTask.this.f108577b.f108631c, GdtArkPreDownloadTask.this.f108581f);
            }
        }, 4);
    }

    private void v() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                GdtLog.i("GdtArkPreDownloadTask", String.format("run status:%d", Integer.valueOf(GdtArkPreDownloadTask.this.f108579d)));
                if (!GdtArkPreDownloadTask.this.q()) {
                    GdtArkPreDownloadTask.this.w(1);
                    GdtArkPreDownloadTask.this.r(4, Integer.MIN_VALUE, 0L);
                    return;
                }
                GdtArkPreDownloadTask.this.w(1);
                b.b();
                if (TextUtils.isEmpty(GdtArkPreDownloadTask.this.o())) {
                    GdtArkPreDownloadTask.this.w(2);
                    GdtArkPreDownloadTask.this.u();
                } else {
                    GdtArkPreDownloadTask.this.w(3);
                    GdtArkPreDownloadTask.this.t();
                }
                if (GdtArkPreDownloadTask.this.f108578c >= 0) {
                    GdtArkPreDownloadTask gdtArkPreDownloadTask = GdtArkPreDownloadTask.this;
                    gdtArkPreDownloadTask.r(13, Integer.MIN_VALUE, gdtArkPreDownloadTask.f108578c);
                }
            }
        }, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3) {
        int i16 = this.f108579d;
        if (i16 != i3) {
            synchronized (this) {
                if (n(i16, i3)) {
                    this.f108579d = i3;
                    s(i3);
                } else {
                    r(1, Integer.MIN_VALUE, 0L);
                }
            }
        }
        GdtLog.i("GdtArkPreDownloadTask", String.format("setStatus oldStatus:%d newStatus:%d result:%s", Integer.valueOf(i16), Integer.valueOf(i3), Integer.valueOf(this.f108579d)));
    }

    public int p() {
        return this.f108579d;
    }
}
