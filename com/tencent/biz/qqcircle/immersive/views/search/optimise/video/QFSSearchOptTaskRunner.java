package com.tencent.biz.qqcircle.immersive.views.search.optimise.video;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBean;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchOptTaskRunner {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<QFSSearchOptTask> f91151a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private final RFWVideoPreloadManager.OnPreloadListener f91152b;

    /* renamed from: c, reason: collision with root package name */
    private final RFWPlayerPreRenderHelper.OnPrerenderListener f91153c;

    /* renamed from: d, reason: collision with root package name */
    private volatile QFSSearchOptTask f91154d;

    /* renamed from: e, reason: collision with root package name */
    private RFWVideoPreloadManager.OnPreloadListener f91155e;

    /* renamed from: f, reason: collision with root package name */
    private RFWPlayerPreRenderHelper.OnPrerenderListener f91156f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f91157g;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements RFWVideoPreloadManager.OnPreloadListener {
        a() {
        }

        private boolean a(RFWVideoPreloadBean rFWVideoPreloadBean) {
            QFSSearchOptTask qFSSearchOptTask = QFSSearchOptTaskRunner.this.f91154d;
            if (qFSSearchOptTask == null) {
                return false;
            }
            return TextUtils.equals(rFWVideoPreloadBean.getVid(), qFSSearchOptTask.f91159e);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager.OnPreloadListener
        public void beforePreloadStart(RFWVideoPreloadBean rFWVideoPreloadBean) {
            if (a(rFWVideoPreloadBean)) {
                if (QFSSearchOptTaskRunner.this.f91155e != null) {
                    QFSSearchOptTaskRunner.this.f91155e.beforePreloadStart(rFWVideoPreloadBean);
                }
                QLog.d("QFSSearchOptTaskRunner", 2, "#beforePreloadStart: preloadDuration=" + rFWVideoPreloadBean.getPreloadDuration());
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager.OnPreloadListener
        public void onPreloadFinish(RFWVideoPreloadBean rFWVideoPreloadBean) {
            if (a(rFWVideoPreloadBean)) {
                if (QFSSearchOptTaskRunner.this.f91155e != null) {
                    QFSSearchOptTaskRunner.this.f91155e.onPreloadFinish(rFWVideoPreloadBean);
                }
                QLog.d("QFSSearchOptTaskRunner", 2, "#onPreloadFinish");
                QFSSearchOptTaskRunner.this.j();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements RFWPlayerPreRenderHelper.OnPrerenderListener {
        b() {
        }

        private boolean a(CharSequence charSequence) {
            QFSSearchOptTask qFSSearchOptTask = QFSSearchOptTaskRunner.this.f91154d;
            if (qFSSearchOptTask == null) {
                return false;
            }
            return TextUtils.equals(charSequence, qFSSearchOptTask.f91159e);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper.OnPrerenderListener
        public void onPrerenderFinish(boolean z16, @Nullable String str, int i3) {
            if (a(str)) {
                if (QFSSearchOptTaskRunner.this.f91156f != null) {
                    QFSSearchOptTaskRunner.this.f91156f.onPrerenderFinish(z16, str, i3);
                }
                QLog.d("QFSSearchOptTaskRunner", 2, "#onPrerenderFinish: success=" + z16 + ", errorCode=" + i3);
                QFSSearchOptTaskRunner.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QFSSearchOptTaskRunner() {
        a aVar = new a();
        this.f91152b = aVar;
        b bVar = new b();
        this.f91153c = bVar;
        RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).registerPreloadListenerAsWeakRef(aVar);
        RFWPlayerPreRenderHelper.getInstance().registerPrerenderListener(bVar);
    }

    private void h(CharSequence charSequence) {
        for (int size = this.f91151a.size() - 1; size >= 0; size--) {
            if (TextUtils.equals(charSequence, this.f91151a.get(size).f91159e)) {
                this.f91151a.remove(size);
            }
        }
    }

    private void i() {
        if (this.f91157g) {
            QLog.d("QFSSearchOptTaskRunner", 2, "#run: destroyed");
            return;
        }
        QFSSearchOptTask pollFirst = this.f91151a.pollFirst();
        this.f91154d = pollFirst;
        if (pollFirst == null) {
            QLog.d("QFSSearchOptTaskRunner", 2, "#run: no task");
            return;
        }
        if (pollFirst.f91158d == 1) {
            h(pollFirst.f91159e);
        }
        long currentTimeMillis = System.currentTimeMillis();
        pollFirst.run();
        QLog.d("QFSSearchOptTaskRunner", 2, "#run: type=" + pollFirst.f91158d + ", costTime=" + (System.currentTimeMillis() - currentTimeMillis) + ", logMessage=" + pollFirst.f91160f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f91154d = null;
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@NonNull QFSSearchOptTask qFSSearchOptTask) {
        if (qFSSearchOptTask.f91158d == 1) {
            if (this.f91154d != null && this.f91154d.f91158d != 1) {
                RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).releaseAllPreloadVideo();
                this.f91151a.addFirst(this.f91154d);
            }
            this.f91154d = null;
            this.f91151a.addFirst(qFSSearchOptTask);
        } else {
            this.f91151a.addLast(qFSSearchOptTask);
        }
        if (this.f91154d == null) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f91151a.clear();
        this.f91154d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f91157g = true;
        RFWPlayerPreRenderHelper.getInstance().unregisterPrerenderListener(this.f91153c);
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(RFWVideoPreloadManager.OnPreloadListener onPreloadListener) {
        this.f91155e = onPreloadListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(RFWPlayerPreRenderHelper.OnPrerenderListener onPrerenderListener) {
        this.f91156f = onPrerenderListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static abstract class QFSSearchOptTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final int f91158d;

        /* renamed from: e, reason: collision with root package name */
        final String f91159e;

        /* renamed from: f, reason: collision with root package name */
        final String f91160f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QFSSearchOptTask(int i3, String str) {
            this.f91158d = i3;
            this.f91159e = str;
            this.f91160f = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public QFSSearchOptTask(int i3, String str, String str2) {
            this.f91158d = i3;
            this.f91159e = str;
            this.f91160f = str2;
        }
    }
}
