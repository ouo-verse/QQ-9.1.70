package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QADApkDownloadCallback implements gv2.b {

    /* renamed from: a, reason: collision with root package name */
    private ListenerMgr<gv2.b> f303755a = new ListenerMgr<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements ListenerMgr.a<gv2.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e f303758a;

        a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
            this.f303758a = eVar;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(gv2.b bVar) {
            bVar.b(this.f303758a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements ListenerMgr.a<gv2.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d f303760a;

        b(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d dVar) {
            this.f303760a = dVar;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(gv2.b bVar) {
            bVar.a(this.f303760a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d dVar) {
        this.f303755a.b(new b(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        this.f303755a.b(new a(eVar));
    }

    @Override // gv2.b
    public void a(final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d dVar) {
        if (UIThreadUtils.isOnUiThread()) {
            QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.QADApkDownloadCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    QADApkDownloadCallback.this.e(dVar);
                }
            });
        } else {
            e(dVar);
        }
    }

    @Override // gv2.b
    public void b(final com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        if (UIThreadUtils.isOnUiThread()) {
            QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.QADApkDownloadCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    QADApkDownloadCallback.this.f(eVar);
                }
            });
        } else {
            f(eVar);
        }
    }

    public void g(gv2.b bVar) {
        this.f303755a.a(bVar);
    }
}
