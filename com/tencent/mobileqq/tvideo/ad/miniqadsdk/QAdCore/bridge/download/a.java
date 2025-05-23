package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADApkDownloadTaskState;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<QADApkDownloadTaskState, Integer> f303769a;

    static {
        HashMap hashMap = new HashMap();
        f303769a = hashMap;
        hashMap.put(QADApkDownloadTaskState.TASK_WAITING, 16);
        hashMap.put(QADApkDownloadTaskState.TASK_DOWNLOADING, 13);
        hashMap.put(QADApkDownloadTaskState.TASK_SUCCEED, 11);
        hashMap.put(QADApkDownloadTaskState.TASK_YYB_DOWNLOADING, 15);
        hashMap.put(QADApkDownloadTaskState.TASK_APK_INSTALLED, 10);
        hashMap.put(QADApkDownloadTaskState.TASK_FAILED, 14);
        hashMap.put(QADApkDownloadTaskState.TASK_PAUSED, 14);
        hashMap.put(QADApkDownloadTaskState.TASK_NO_NETWORK, 17);
        hashMap.put(QADApkDownloadTaskState.TASK_WAITING_WIFI, 18);
        hashMap.put(QADApkDownloadTaskState.TASK_DELETE, 19);
        hashMap.put(QADApkDownloadTaskState.TASK_LAUNCH_INSTALL_SUCCESS, 17);
        hashMap.put(QADApkDownloadTaskState.TASK_LAUNCH_INSTALL_FAILED, 17);
    }

    public static com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c a(f fVar) {
        boolean z16;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c();
        cVar.h(fVar.f303810a);
        cVar.j(fVar.f303813d);
        cVar.g(fVar.f303815f);
        cVar.n(fVar.f303814e);
        cVar.f(fVar.f303812c);
        cVar.i(fVar.f303828s);
        cVar.l(fVar.f303811b);
        cVar.m(fVar.f303818i);
        cVar.k(fVar.f303823n);
        cVar.a("via", fVar.f303822m);
        cVar.a("route", Integer.valueOf(fVar.f303831v));
        cVar.a("save_to_db", Boolean.valueOf(fVar.f303825p));
        cVar.a("download_only_wifi", Boolean.valueOf(fVar.f303826q));
        cVar.a("auto_install", Boolean.valueOf(fVar.f303827r));
        cVar.a("h5_info", fVar.f303833x);
        cVar.a("install_policy", Integer.valueOf(fVar.f303830u));
        cVar.a("context_info", fVar.f303832w);
        cVar.a("identifyKey", fVar.f303834y);
        if (fVar.f303829t != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        cVar.a("is_spa", Boolean.valueOf(z16));
        return cVar;
    }

    public static int b(QADApkDownloadTaskState qADApkDownloadTaskState) {
        Integer num = f303769a.get(qADApkDownloadTaskState);
        if (num == null) {
            return 12;
        }
        return num.intValue();
    }
}
