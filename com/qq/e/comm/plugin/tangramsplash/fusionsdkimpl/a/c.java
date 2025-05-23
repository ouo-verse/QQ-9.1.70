package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.service.resdownload.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f40006a = new ArrayList();

    public static void a(final d dVar, final r rVar) {
        if (a()) {
            GDTLogger.i("ZipUtil: unzipSrc on async thread");
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.c(d.this, rVar);
                }
            });
        } else {
            GDTLogger.i("ZipUtil: unzipSrc on sync thread");
            c(dVar, rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(d dVar, r rVar) {
        if (dVar == null) {
            GDTLogger.i("ZipUtil: realUnzipSrc, mReq is null");
            return;
        }
        if (rVar == null) {
            GDTLogger.i("ZipUtil: realUnzipSrc, mAdInfo is null");
            return;
        }
        String a16 = dVar.a();
        if (TextUtils.isEmpty(a16)) {
            GDTLogger.i("ZipUtil: realUnzipSrc, url is null or empty");
            return;
        }
        File a17 = at.a(dVar.e(), rVar.s(), a16);
        if (a17 != null && a17.exists()) {
            try {
                List<String> list = f40006a;
                synchronized (list) {
                    if (list.contains(a16)) {
                        GDTLogger.i("ZipUtil: realUnzipSrc, url(" + a16 + ") is unzipping");
                        synchronized (list) {
                            list.remove(a16);
                        }
                        return;
                    }
                    list.add(a16);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    com.qq.e.comm.plugin.tangramsplash.c.b.a(dVar.a(), rVar.s());
                    long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                    com.qq.e.comm.plugin.tangramsplash.report.b.a(com.qq.e.comm.plugin.tangramsplash.report.b.a(rVar), com.qq.e.comm.plugin.tangramsplash.report.b.b(rVar), true, uptimeMillis2);
                    GDTLogger.i("ZipUtil: realUnzipSrc, cost = " + uptimeMillis2);
                    synchronized (list) {
                        list.remove(a16);
                    }
                    return;
                }
            } catch (Throwable th5) {
                try {
                    GDTLogger.i("ZipUtil: realUnzipSrc, url(" + a16 + "), error = " + th5.getMessage());
                    List<String> list2 = f40006a;
                    synchronized (list2) {
                        list2.remove(a16);
                        return;
                    }
                } catch (Throwable th6) {
                    List<String> list3 = f40006a;
                    synchronized (list3) {
                        list3.remove(a16);
                        throw th6;
                    }
                }
            }
        }
        GDTLogger.i("ZipUtil: realUnzipSrc, zipSrc not exists");
    }

    private static boolean a() {
        return com.qq.e.comm.plugin.j.c.a("unzipSrcInRealtimeOnAsyncThreadSwitch", 0, 1);
    }
}
