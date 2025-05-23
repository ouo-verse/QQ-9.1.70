package com.qzone.homepage.ui.Facade;

import android.text.TextUtils;
import com.qzone.util.al;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQZoneHttpDownloadUtil;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.MonitorManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FacadeVideoDownLoaderManager {

    /* renamed from: a, reason: collision with root package name */
    private static final al<FacadeVideoDownLoaderManager, Void> f47549a = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<FacadeVideoDownLoaderManager, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FacadeVideoDownLoaderManager a(Void r16) {
            return new FacadeVideoDownLoaderManager();
        }
    }

    public static String d(String str) {
        return h.l().j() + str.hashCode();
    }

    public static FacadeVideoDownLoaderManager e() {
        return f47549a.get(null);
    }

    public static final boolean f(String str) {
        return new File(d(str)).exists();
    }

    public void b(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int networkType = NetworkState.getNetworkType();
        if (1 == networkType || 4 == networkType || 5 == networkType) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.homepage.ui.Facade.FacadeVideoDownLoaderManager.2
                @Override // java.lang.Runnable
                public void run() {
                    FacadeVideoDownLoaderManager.this.c(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        try {
            final String d16 = d(str);
            if (new File(d16).exists()) {
                return;
            }
            ThreadManagerV2.postDownLoadTask(new Runnable() { // from class: com.qzone.homepage.ui.Facade.FacadeVideoDownLoaderManager.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        File file = new File(d16);
                        if (file.exists()) {
                            return;
                        }
                        String filterUrl = ((IQZoneHttpDownloadUtil) QRoute.api(IQZoneHttpDownloadUtil.class)).getFilterUrl(str);
                        if (((IQZoneHttpDownloadUtil) QRoute.api(IQZoneHttpDownloadUtil.class)).download(null, filterUrl, file)) {
                            return;
                        }
                        QZLog.i("FacadeVideoDownLoaderManager", String.format("download fail,url:%s ", filterUrl));
                        MonitorManager.f().h(15, 8, "download facade video fail" + str, false);
                    } catch (Exception e16) {
                        QZLog.e("FacadeVideoDownLoaderManager", "error download video " + str);
                        MonitorManager.f().h(15, 8, "exception downloading facade video " + str + " exception " + e16, false);
                    }
                }
            }, 5, null, false);
        } catch (Exception e16) {
            QZLog.e("FacadeVideoDownLoaderManager", "error download video " + str);
            MonitorManager.f().h(15, 8, "download facade video fail" + str + " exception " + e16, false);
        }
    }
}
