package com.qq.e.comm.plugin.a;

import com.qq.e.comm.plugin.base.ad.model.d;
import com.qq.e.comm.plugin.base.ad.model.m;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f38337a;

    a() {
    }

    public static a a() {
        if (f38337a == null) {
            synchronized (a.class) {
                if (f38337a == null) {
                    f38337a = new a();
                }
            }
        }
        return f38337a;
    }

    public synchronized void b() {
        String[] strArr;
        String str;
        GDTLogger.i("APKProceedToDownloadTrigger: begin");
        if (ac.a("proceedDownloadAppNetworkType")) {
            GDTLogger.e("APKProceedToDownloadTrigger: network type is not Permission");
            return;
        }
        long a16 = c.a("proceedDownloadAppInterval", 7200000);
        long j3 = SharedPreferencedUtil.getLong("proceedDownloadLastTime", 0L);
        GDTLogger.d("APKProceedToDownloadTrigger: intervalConfig = " + a16 + "; lastTriggerPoint " + j3);
        if (System.currentTimeMillis() - j3 < a16) {
            GDTLogger.e("APKProceedToDownloadTrigger: interval is too short");
            return;
        }
        List<d> downloadingOrPausedTasks = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getDownloadingOrPausedTasks();
        if (g.b(downloadingOrPausedTasks)) {
            GDTLogger.e("APKProceedToDownloadTrigger: no pending task in db!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d dVar : downloadingOrPausedTasks) {
            if (dVar != null) {
                int a17 = dVar.a("pauseReason");
                if (dVar.m() != 32 || a17 == 201) {
                    arrayList.add(dVar);
                }
            }
        }
        try {
            GDTLogger.d("APKProceedToDownloadTrigger: sort before: " + a(arrayList));
            Collections.sort(arrayList, new Comparator<d>() { // from class: com.qq.e.comm.plugin.a.a.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(d dVar2, d dVar3) {
                    if (dVar2 != null && dVar3 != null) {
                        if (dVar2.a() > dVar3.a()) {
                            return -1;
                        }
                        if (dVar2.a() < dVar3.a()) {
                            return 1;
                        }
                    }
                    return 0;
                }
            });
            GDTLogger.d("APKProceedToDownloadTrigger: sort after: " + a(arrayList));
            d dVar2 = null;
            String a18 = c.a((String) null, "proceedDownloadAppWhiteList", "");
            if (a18 != null) {
                strArr = a18.split(";");
            } else {
                strArr = null;
            }
            if (!g.a(strArr)) {
                for (d dVar3 : arrayList) {
                    if (dVar3 != null) {
                        int length = strArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            String str2 = strArr[i3];
                            if (str2 != null && str2.equals(dVar3.e())) {
                                GDTLogger.d("APKProceedToDownloadTrigger: hit white list --" + dVar3.e());
                                dVar2 = dVar3;
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            if (dVar2 == null) {
                dVar2 = arrayList.get(0);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("APKProceedToDownloadTrigger: hit latest task-- ");
                if (dVar2 != null) {
                    str = dVar2.e();
                } else {
                    str = "";
                }
                sb5.append(str);
                GDTLogger.d(sb5.toString());
                if (dVar2 == null) {
                    GDTLogger.d("APKProceedToDownloadTrigger: no match any pending task");
                    return;
                }
            }
            m mVar = new m();
            mVar.a(2);
            mVar.b(207);
            if (((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).resumeTask(dVar2.k(), mVar)) {
                GDTLogger.d("APKProceedToDownloadTrigger:  resume success");
                SharedPreferencedUtil.putLong("proceedDownloadLastTime", System.currentTimeMillis());
            }
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    private String a(List<d> list) {
        String str = "";
        if (g.b(list)) {
            return "";
        }
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            d next = it.next();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(next != null ? next.e() : " ");
            sb5.append("|");
            str = sb5.toString();
        }
        return str;
    }
}
