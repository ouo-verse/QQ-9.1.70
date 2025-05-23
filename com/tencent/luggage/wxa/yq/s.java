package com.tencent.luggage.wxa.yq;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.q0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.yq.u;
import com.tencent.xweb.XWebSdkInternal;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import com.tencent.xweb.updater.IXWebUpdateListener;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class s implements u.c {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            IXWebUpdateListener xWebUpdateListener;
            xWebUpdateListener = XWebSdkInternal.getXWebUpdateListener();
            if (xWebUpdateListener != null) {
                xWebUpdateListener.onNeedDownload();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            IXWebUpdateListener xWebUpdateListener;
            xWebUpdateListener = XWebSdkInternal.getXWebUpdateListener();
            if (xWebUpdateListener != null) {
                xWebUpdateListener.onUpdateStart();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f146132a;

        public c(int i3) {
            this.f146132a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            IXWebUpdateListener xWebUpdateListener;
            xWebUpdateListener = XWebSdkInternal.getXWebUpdateListener();
            if (xWebUpdateListener != null) {
                xWebUpdateListener.onUpdateFailed(this.f146132a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            IXWebUpdateListener xWebUpdateListener;
            xWebUpdateListener = XWebSdkInternal.getXWebUpdateListener();
            if (xWebUpdateListener != null) {
                xWebUpdateListener.onUpdateCancelled();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f146133a;

        public e(int i3) {
            this.f146133a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            IXWebUpdateListener xWebUpdateListener;
            xWebUpdateListener = XWebSdkInternal.getXWebUpdateListener();
            if (xWebUpdateListener != null) {
                xWebUpdateListener.onUpdateProgress(this.f146133a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            IXWebUpdateListener xWebUpdateListener;
            xWebUpdateListener = XWebSdkInternal.getXWebUpdateListener();
            if (xWebUpdateListener != null) {
                xWebUpdateListener.onUpdateCompleted();
            }
        }
    }

    public static void b() {
        a(2);
    }

    public static void c() {
        a(3);
    }

    public static void d() {
        a(4);
    }

    public static void e() {
        x0.d("XWebRuntimeUpdater", "notifyMainConfigUpdate");
        a(IXWebBroadcastListener.STAGE_MAINCFG_UPDATE, 0, 0);
    }

    public static void f() {
        x0.d("XWebRuntimeUpdater", "notifyNeedDownloadRuntime");
        com.tencent.luggage.wxa.lq.d.b(new a());
    }

    public static void g() {
        x0.d("XWebRuntimeUpdater", "notifyUpdateCancelled");
        a(IXWebBroadcastListener.STAGE_FINISHED, -2, 0);
        com.tencent.luggage.wxa.lq.d.b(new d());
    }

    public static void h() {
        x0.d("XWebRuntimeUpdater", "notifyUpdateCompleted");
        a(IXWebBroadcastListener.STAGE_FINISHED, 0, 0);
        com.tencent.luggage.wxa.lq.d.b(new f());
    }

    public static void i() {
        x0.d("XWebRuntimeUpdater", "notifyUpdateStart");
        a("start", 0, 0);
        com.tencent.luggage.wxa.lq.d.b(new b());
    }

    public final void a(boolean z16) {
        new q().a(z16);
    }

    @Override // com.tencent.luggage.wxa.yq.u.c
    public boolean isBusyUpdate() {
        if (Math.abs(System.currentTimeMillis() - t.b()) >= 10000 && !t.c() && !q0.b()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.yq.u.c
    public boolean needCheckUpdate() {
        return new r().a();
    }

    @Override // com.tencent.luggage.wxa.yq.u.c
    public void startCheck(Context context, HashMap hashMap) {
        String str;
        synchronized (this) {
            n0.Y();
            if (hashMap != null) {
                str = (String) hashMap.get(ConstValue.XWEB_UPDATER_START_CHECK_TYPE);
            } else {
                str = null;
            }
            x0.d("XWebRuntimeUpdater", "startCheck, check type:" + str);
            if ("5".equals(str)) {
                x0.d("XWebRuntimeUpdater", "startCheck, check config update only");
                a(hashMap);
            } else if ("4".equals(str)) {
                x0.d("XWebRuntimeUpdater", "startCheck, check embed install only");
                a(true);
            } else {
                a(false);
                a(hashMap);
                q0.d(context);
            }
        }
    }

    public static void b(int i3) {
        x0.d("XWebRuntimeUpdater", "notifyUpdateProgress, percentage:" + i3);
        a(IXWebBroadcastListener.STAGE_PROGRESSED, i3, 0);
        com.tencent.luggage.wxa.lq.d.b(new e(i3));
    }

    public final void a(HashMap hashMap) {
        new r().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, hashMap);
    }

    public static void a(String str, int i3, int i16) {
        Intent intent = new Intent();
        intent.setAction(IXWebBroadcastListener.UPDATE_ACTION);
        intent.putExtra("stage", str);
        intent.putExtra("extra_data", i3);
        intent.putExtra("error_code", i16);
        intent.putExtra("package_name", XWalkEnvironment.getPackageName());
        XWalkEnvironment.getApplicationContext().sendBroadcast(intent);
    }

    public static void a() {
        a(1);
    }

    public static void a(int i3) {
        x0.d("XWebRuntimeUpdater", "notifyUpdateFailed, errorCode:" + i3);
        a(IXWebBroadcastListener.STAGE_FINISHED, -1, i3);
        com.tencent.luggage.wxa.lq.d.b(new c(i3));
    }
}
