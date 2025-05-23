package com.tencent.open.downloadnew;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloaderGetCodeClient {

    /* renamed from: e, reason: collision with root package name */
    private static volatile DownloaderGetCodeClient f341267e;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, List<com.tencent.open.downloadnew.a>> f341268a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f341269b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Boolean> f341270c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private EIPCResultCallback f341271d = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            com.tencent.open.base.f.a("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
            if (eIPCResult == null) {
                return;
            }
            Bundle bundle = eIPCResult.data;
            if (bundle == null) {
                com.tencent.open.base.f.a("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
                return;
            }
            String string = bundle.getString("PackageName");
            int i3 = bundle.getInt("VersionCode");
            DownloaderGetCodeClient.this.f341270c.put(DownloaderGetCodeClient.this.j(string, i3), Boolean.FALSE);
            String string2 = bundle.getString("Code");
            boolean z16 = bundle.getBoolean("IsSuccess");
            com.tencent.open.base.f.a("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + string + " versionCode|" + i3 + " isSuc|" + z16 + " code|" + string2);
            synchronized (DownloaderGetCodeClient.class) {
                String j3 = DownloaderGetCodeClient.this.j(string, i3);
                String str = (String) DownloaderGetCodeClient.this.f341269b.get(j3);
                List<com.tencent.open.downloadnew.a> list = (List) DownloaderGetCodeClient.this.f341268a.get(j3);
                if (list != null) {
                    for (com.tencent.open.downloadnew.a aVar : list) {
                        if (aVar != null) {
                            Bundle bundle2 = new Bundle();
                            if (TextUtils.isEmpty(str)) {
                                aVar.a(string, i3, string2, z16, bundle2);
                            } else {
                                bundle2.putString(e.f341492a, str);
                                aVar.a(string, i3, string2, z16, bundle2);
                            }
                        }
                    }
                    DownloaderGetCodeClient.this.f341268a.remove(j3);
                } else {
                    com.tencent.open.base.f.a("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
                }
            }
        }
    }

    DownloaderGetCodeClient() {
    }

    private void f(String str, com.tencent.open.downloadnew.a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            List<com.tencent.open.downloadnew.a> list = this.f341268a.get(str);
            if (list == null) {
                list = Collections.synchronizedList(new ArrayList());
            }
            if (list.contains(aVar)) {
                return;
            }
            list.add(aVar);
            this.f341268a.put(str, list);
        }
    }

    public static DownloaderGetCodeClient i() {
        if (f341267e == null) {
            synchronized (DownloaderGetCodeClient.class) {
                if (f341267e == null) {
                    f341267e = new DownloaderGetCodeClient();
                }
            }
        }
        return f341267e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(String str, int i3) {
        return str + "_" + i3;
    }

    public void g(final String str, final int i3, com.tencent.open.downloadnew.a aVar) {
        f(j(str, i3), aVar);
        final Bundle bundle = new Bundle();
        bundle.putString("PackageName", str);
        bundle.putInt("VersionCode", i3);
        com.tencent.open.base.f.a("DownloaderGetCodeClient", str + "_" + i3 + " begin getApkCode ......");
        this.f341270c.put(j(str, i3), Boolean.TRUE);
        QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", bundle, this.f341271d);
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.DownloaderGetCodeClient.1
            @Override // java.lang.Runnable
            public void run() {
                if (((Boolean) DownloaderGetCodeClient.this.f341270c.get(DownloaderGetCodeClient.this.j(str, i3))).booleanValue()) {
                    com.tencent.open.base.f.a("DownloaderGetCodeClient", "last request not back,retry ......");
                    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", bundle, DownloaderGetCodeClient.this.f341271d);
                }
            }
        }, 3000L);
    }

    public void h(String str, String str2, int i3, com.tencent.open.downloadnew.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f341269b.put(j(str2, i3), str);
        }
        g(str2, i3, aVar);
    }
}
