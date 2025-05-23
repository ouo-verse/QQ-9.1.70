package com.qzone.homepage.ui.Facade;

import android.content.Context;
import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: l, reason: collision with root package name */
    private static d f47562l;

    /* renamed from: d, reason: collision with root package name */
    private Context f47566d;

    /* renamed from: e, reason: collision with root package name */
    private final Downloader f47567e;

    /* renamed from: f, reason: collision with root package name */
    private LinkedList<String> f47568f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f47569g;

    /* renamed from: a, reason: collision with root package name */
    private final String f47563a = "FacadePreload";

    /* renamed from: b, reason: collision with root package name */
    private final int f47564b = 100;

    /* renamed from: c, reason: collision with root package name */
    private long f47565c = 5000;

    /* renamed from: h, reason: collision with root package name */
    private NetworkState.NetworkStateListener f47570h = new a();

    /* renamed from: i, reason: collision with root package name */
    private String f47571i = "timestamp asc";

    /* renamed from: j, reason: collision with root package name */
    private Downloader.DownloadListener f47572j = new b();

    /* renamed from: k, reason: collision with root package name */
    private final c f47573k = new c("FacadePreload", com.qzone.homepage.ui.Facade.model.b.class);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements NetworkState.NetworkStateListener {
        a() {
        }

        @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
        public void onNetworkConnect(boolean z16) {
            if (NetworkState.isWifiConn()) {
                return;
            }
            d.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        long f47576a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f47577b;

        /* renamed from: c, reason: collision with root package name */
        String f47578c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f47579d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f47580e = new a();

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                c cVar = c.this;
                cVar.f47576a = 0L;
                cVar.f47577b = null;
            }
        }

        public c(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f47578c = str;
            this.f47579d = cls;
        }
    }

    d() {
        BaseApplication context = BaseApplication.getContext();
        this.f47566d = context;
        this.f47567e = DownloaderFactory.getInstance(context).getCommonDownloader();
        this.f47568f = new LinkedList<>();
        this.f47569g = new Object();
        i();
    }

    private void c() {
        synchronized (this.f47569g) {
            Iterator<String> it = this.f47568f.iterator();
            while (it.hasNext()) {
                this.f47567e.abort(it.next(), this.f47572j);
            }
        }
    }

    private void d(int i3) {
        ArrayList arrayList = new ArrayList();
        ArrayList<? extends IDBCacheDataWrapper> i06 = g().i0(null, null, this.f47571i, 0, 0);
        for (int i16 = 0; i16 < i3 && i16 < i06.size(); i16++) {
            com.qzone.homepage.ui.Facade.model.b bVar = (com.qzone.homepage.ui.Facade.model.b) i06.get(i16);
            if (bVar != null) {
                String str = bVar.imageUrl;
                arrayList.add("timestamp='" + str + "' ");
                File localFileByUrl = ImageManager.getLocalFileByUrl(BaseApplication.getContext(), str, h.l().i());
                if (localFileByUrl.exists()) {
                    localFileByUrl.delete();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g().f((String) it.next(), null);
        }
    }

    private DbCacheManager f(c cVar) {
        e(cVar);
        return cVar.f47577b;
    }

    private DbCacheManager g() {
        return f(this.f47573k);
    }

    public static synchronized d h() {
        d dVar;
        synchronized (d.class) {
            if (f47562l == null) {
                f47562l = new d();
            }
            dVar = f47562l;
        }
        return dVar;
    }

    private void i() {
        NetworkState.addListener(this.f47570h);
    }

    public void j() {
        c();
    }

    public void k(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.qzone.homepage.ui.Facade.model.b(currentTimeMillis, it.next()));
        }
        g().p0(arrayList, 1);
        ArrayList<? extends IDBCacheDataWrapper> i06 = g().i0(null, null, this.f47571i, 0, 0);
        if (i06.size() > 100) {
            d(i06.size() - 100);
        }
        synchronized (this.f47569g) {
            for (String str : list) {
                if (!this.f47568f.contains(str)) {
                    this.f47568f.add(str);
                }
            }
        }
    }

    private void e(c cVar) {
        DbCacheManager dbCacheManager;
        if (cVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != cVar.f47576a || (dbCacheManager = cVar.f47577b) == null || dbCacheManager.isClosed()) {
            cVar.f47576a = uin;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(cVar.f47579d, uin, cVar.f47578c);
            cVar.f47577b = e16;
            e16.U(cVar.f47580e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements Downloader.DownloadListener {
        b() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            synchronized (d.this.f47569g) {
                d.this.f47568f.remove(str);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}
