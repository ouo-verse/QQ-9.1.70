package com.tencent.mobileqq.zplan.download;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final yg3.a f332763a = new com.tencent.mobileqq.zplan.download.api.impl.a();

    public static void a(g gVar) {
        boolean z16 = true;
        if (gVar == null) {
            QLog.e("[zplan][ApolloResDownloaderUtil]", 1, "addHeaderNecessary task == null");
            return;
        }
        if (!"apollo_res".equals(gVar.S)) {
            QLog.e("[zplan][ApolloResDownloaderUtil]", 1, "addHeaderNecessary not apollo downloader business");
            return;
        }
        Iterator<String> it = gVar.f313009g.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            } else if (it.next().contains("res.zplan.qq.com")) {
                break;
            }
        }
        if (z16) {
            gVar.b("Referer", "https://h5.cmshow.qq.com/");
        }
    }

    public static yg3.a b() {
        return f332763a;
    }

    public static h c(AppRuntime appRuntime) {
        h u16;
        DownloaderFactory downloaderFactory = (DownloaderFactory) appRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        if (downloaderFactory == null || (u16 = downloaderFactory.u(3)) == null) {
            return null;
        }
        return u16;
    }
}
