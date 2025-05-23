package com.tencent.open.appcommon.now.download.local;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadCallbackNativeImpl implements com.tencent.open.appcommon.now.download.b {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<DownloadNativeApi.a> f340730a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, b> f340731b = new HashMap();

    @Override // com.tencent.open.appcommon.now.download.b
    public void a(final int i3) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl.1
            @Override // java.lang.Runnable
            public void run() {
                int i16 = i3;
                if (i16 != 4 && i16 != 3 && i16 != 2) {
                    if (i16 == 1) {
                        for (b bVar : DownloadCallbackNativeImpl.this.f340731b.values()) {
                            DownloadInfo d16 = com.tencent.open.appcommon.now.download.a.e().d(bVar.f340748a);
                            if (d16 != null && d16.f() == 3 && !bVar.f340755h) {
                                DownloadNativeApi.c().g(null, bVar);
                            }
                        }
                        return;
                    }
                    return;
                }
                for (b bVar2 : DownloadCallbackNativeImpl.this.f340731b.values()) {
                    DownloadInfo d17 = com.tencent.open.appcommon.now.download.a.e().d(bVar2.f340748a);
                    if (d17 != null) {
                        if (d17.f() == 2) {
                            if (bVar2.f340754g) {
                                DownloadNativeApi.c().e(bVar2.f340748a);
                            }
                        } else if (d17.f() == 3 && !bVar2.f340754g && !bVar2.f340755h) {
                            DownloadNativeApi.c().g(null, bVar2);
                        }
                    }
                }
            }
        }, 3000L);
    }

    @Override // com.tencent.open.appcommon.now.download.b
    public void c(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        for (DownloadInfo downloadInfo : list) {
            if (downloadInfo != null) {
                a aVar = new a();
                aVar.a(downloadInfo);
                Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
                while (it.hasNext()) {
                    it.next().a(aVar);
                }
            }
        }
    }

    public void e(b bVar) {
        if (this.f340731b == null) {
            this.f340731b = new HashMap();
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.f340748a) && !this.f340731b.containsKey(bVar.f340748a)) {
            this.f340731b.put(bVar.f340748a, bVar);
        }
    }

    public void f(String str) {
        Map<String, b> map = this.f340731b;
        if (map != null && map.containsKey(str)) {
            this.f340731b.get(str).f340755h = true;
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void installSucceed(String str, String str2) {
        if (this.f340730a != null) {
            a aVar = new a();
            aVar.f340740a = str;
            aVar.f340741b = str2;
            aVar.f340742c = 7;
            Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
            while (it.hasNext()) {
                it.next().c(aVar);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadCancel(DownloadInfo downloadInfo) {
        if (this.f340730a != null && downloadInfo != null) {
            a aVar = new a();
            aVar.a(downloadInfo);
            Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
            while (it.hasNext()) {
                it.next().c(aVar);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
        b bVar;
        if (this.f340730a != null && downloadInfo != null) {
            a aVar = new a();
            aVar.a(downloadInfo);
            aVar.f340742c = aVar.b(downloadInfo.f());
            aVar.f340746g = aVar.c(i3);
            aVar.f340747h = str;
            Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
            while (it.hasNext()) {
                it.next().b(aVar);
            }
            if (aVar.f340746g == 201 && (bVar = this.f340731b.get(aVar.f340740a)) != null && !bVar.f340754g) {
                com.tencent.open.appcommon.now.download.a.e().j(downloadInfo);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadFinish(DownloadInfo downloadInfo) {
        if (this.f340730a != null && downloadInfo != null) {
            a aVar = new a();
            aVar.a(downloadInfo);
            Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
            while (it.hasNext()) {
                it.next().c(aVar);
            }
            if (this.f340731b.containsKey(downloadInfo.f341184e)) {
                this.f340731b.remove(downloadInfo.f341184e);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadPause(DownloadInfo downloadInfo) {
        if (this.f340730a != null && downloadInfo != null) {
            a aVar = new a();
            aVar.a(downloadInfo);
            Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
            while (it.hasNext()) {
                it.next().c(aVar);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadUpdate(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        for (DownloadInfo downloadInfo : list) {
            if (downloadInfo != null) {
                a aVar = new a();
                aVar.a(downloadInfo);
                Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
                while (it.hasNext()) {
                    it.next().d(aVar);
                }
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadWait(DownloadInfo downloadInfo) {
        if (this.f340730a != null && downloadInfo != null) {
            a aVar = new a();
            aVar.a(downloadInfo);
            Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
            while (it.hasNext()) {
                it.next().c(aVar);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void packageReplaced(String str, String str2) {
        if (this.f340730a != null) {
            a aVar = new a();
            aVar.f340740a = str;
            aVar.f340741b = str2;
            aVar.f340742c = 9;
            Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
            while (it.hasNext()) {
                it.next().c(aVar);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void uninstallSucceed(String str, String str2) {
        if (this.f340730a != null) {
            a aVar = new a();
            aVar.f340740a = str;
            aVar.f340741b = str2;
            aVar.f340742c = 8;
            Iterator<DownloadNativeApi.a> it = this.f340730a.iterator();
            while (it.hasNext()) {
                it.next().c(aVar);
            }
        }
    }

    @Override // com.tencent.open.appcommon.now.download.b
    public void b(DownloadInfo downloadInfo, int i3) {
    }
}
