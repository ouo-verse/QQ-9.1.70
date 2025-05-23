package com.qzone.business.plusunion.plusoperation;

import QZONE_OPERATION_ENTRANCE.EntranceRes;
import android.view.View;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.vas.an;
import cooperation.qzone.ServerListProvider;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f44682a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public final class a implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        private String f44683a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<View> f44684b;

        /* renamed from: c, reason: collision with root package name */
        private EntranceRes f44685c;

        /* renamed from: d, reason: collision with root package name */
        private int f44686d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(f fVar, String str, View view, EntranceRes entranceRes, int i3) {
            this.f44683a = str;
            this.f44684b = new WeakReference<>(view);
            this.f44685c = entranceRes;
            this.f44686d = i3;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            if (ServerListProvider.isServerFileExits()) {
                an.h().loadSoLib();
            }
            if (this.f44684b.get() == null) {
                return;
            }
            f.c(null, this.f44683a, this.f44684b, this.f44685c, this.f44686d);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            QZLog.e("PlusMenuDecorates", 2, "download", str, "canceld;");
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            QZLog.e("PlusMenuDecorates", 2, "download", str, "failed;");
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>(6);
        f44682a = hashMap;
        hashMap.put(0, 18);
        hashMap.put(1, 19);
        hashMap.put(2, 20);
        hashMap.put(3, 21);
        hashMap.put(4, 22);
        hashMap.put(5, 23);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void a(f fVar, String str, Downloader.DownloadListener downloadListener) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void b(f fVar, View view, String str, EntranceRes entranceRes, int i3) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void c(f fVar, String str, WeakReference weakReference, EntranceRes entranceRes, int i3) {
        throw null;
    }
}
