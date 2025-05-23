package com.tencent.mobileqq.zplan.download.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import yg3.a;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a implements yg3.a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.zplan.download.api.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    class C9167a extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f332785a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC11614a f332786b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f332787c;

        C9167a(String str, a.InterfaceC11614a interfaceC11614a, Map map) {
            this.f332785a = str;
            this.f332786b = interfaceC11614a;
            this.f332787c = map;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            super.onDone(gVar);
            if (3 != gVar.i()) {
                QLog.e("[zplan][ApolloResDownloader]", 1, "download error ", Integer.valueOf(gVar.i()), this.f332785a);
                a.InterfaceC11614a interfaceC11614a = this.f332786b;
                if (interfaceC11614a != null) {
                    interfaceC11614a.a(false, null, "download error " + gVar.i());
                    return;
                }
                return;
            }
            QLog.i("[zplan][ApolloResDownloader]", 1, "download ok " + this.f332785a);
            a.InterfaceC11614a interfaceC11614a2 = this.f332786b;
            if (interfaceC11614a2 != null) {
                interfaceC11614a2.a(true, this.f332787c, "download ok");
            }
        }
    }

    @Override // yg3.a
    public void a(AppRuntime appRuntime, Map<String, String> map, a.InterfaceC11614a interfaceC11614a) {
        if (appRuntime != null && NetworkUtil.isNetworkAvailable(appRuntime.getApplication())) {
            h c16 = com.tencent.mobileqq.zplan.download.a.c(appRuntime);
            if (c16 == null) {
                if (interfaceC11614a != null) {
                    interfaceC11614a.a(false, null, "no downloader error");
                }
                QLog.e("[zplan][ApolloResDownloader]", 1, "no downloader error ");
                return;
            }
            if (map.isEmpty()) {
                if (interfaceC11614a != null) {
                    interfaceC11614a.a(false, null, "no download entry");
                }
                QLog.e("[zplan][ApolloResDownloader]", 1, "no download entry");
                return;
            }
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    if (interfaceC11614a != null) {
                        interfaceC11614a.a(false, null, "no url");
                    }
                    QLog.e("[zplan][ApolloResDownloader]", 1, "downloadFile no url error");
                    return;
                }
                File file = new File(value);
                if (!file.exists()) {
                    if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                        if (interfaceC11614a != null) {
                            interfaceC11614a.a(false, null, "download path error");
                        }
                        QLog.e("[zplan][ApolloResDownloader]", 1, "download path error " + key + value);
                        return;
                    }
                    arrayList.add(key);
                    sb5.append(key);
                    hashMap.put(key, file);
                }
            }
            if (arrayList.size() <= 0) {
                if (interfaceC11614a != null) {
                    interfaceC11614a.a(true, map, "already download");
                    return;
                }
                return;
            }
            String sb6 = sb5.toString();
            String str = (String) arrayList.get(0);
            try {
                str = MD5Utils.toMD5(sb6);
            } catch (Exception e16) {
                QLog.e("[zplan][ApolloResDownloader]", 1, "downloadFiles make key exception, ", sb6, e16);
            }
            g gVar = new g(arrayList, hashMap, str);
            gVar.U = true;
            gVar.Q = true;
            gVar.S = "apollo_res";
            gVar.f313008f = 1;
            gVar.W = true;
            gVar.X = true;
            com.tencent.mobileqq.zplan.download.a.a(gVar);
            c16.startDownload(gVar, new C9167a(sb6, interfaceC11614a, map), null);
            return;
        }
        if (interfaceC11614a != null) {
            interfaceC11614a.a(false, null, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK);
        }
        QLog.e("[zplan][ApolloResDownloader]", 1, "downloadFile no network error, app:", appRuntime);
    }
}
