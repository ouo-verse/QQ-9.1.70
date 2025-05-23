package com.qzone.business.tianshu;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.qzone.business.tianshu.h;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.util.ak;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.bubble.bean.RFWTipsBaseConfig;
import com.tencent.richframework.bubble.controller.RFWTipsBaseController;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGalleryEntranceGuideBubbleController {

    /* renamed from: a, reason: collision with root package name */
    private GalleryEntranceGuideBubbleRunnable f44837a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f44838b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class GalleryEntranceGuideBubbleRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final View f44839d;

        /* renamed from: e, reason: collision with root package name */
        private final Activity f44840e;

        /* renamed from: f, reason: collision with root package name */
        private final int f44841f;

        /* renamed from: h, reason: collision with root package name */
        private final QZoneBubbleInfo f44842h;

        public GalleryEntranceGuideBubbleRunnable(Activity activity, View view, int i3, QZoneBubbleInfo qZoneBubbleInfo) {
            this.f44840e = activity;
            this.f44839d = view;
            this.f44841f = i3;
            this.f44842h = qZoneBubbleInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.f44840e;
            if (activity != null && !activity.isFinishing() && !this.f44840e.isDestroyed()) {
                View view = this.f44839d;
                if (view != null && view.getVisibility() == 0) {
                    QZoneGalleryEntranceGuideBubbleController.this.g(this.f44840e, this.f44839d, this.f44841f, this.f44842h);
                    return;
                }
                QLog.d("QZoneGalleryEntranceGuideBubbleController", 1, "showGalleryEntranceGuideBubble fail, mAnchorView: " + this.f44839d);
                return;
            }
            QLog.d("QZoneGalleryEntranceGuideBubbleController", 1, "showGalleryEntranceGuideBubble fail, mActivity: " + this.f44840e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f44843a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f44844b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f44845c;

        a(Activity activity, View view, int i3) {
            this.f44843a = activity;
            this.f44844b = view;
            this.f44845c = i3;
        }

        @Override // com.qzone.business.tianshu.h.a
        public void a(QZoneBubbleInfo qZoneBubbleInfo) {
            QZoneGalleryEntranceGuideBubbleController.this.h(this.f44843a, this.f44844b, this.f44845c, qZoneBubbleInfo);
        }
    }

    public QZoneGalleryEntranceGuideBubbleController(Handler handler) {
        this.f44838b = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, View view, int i3, QZoneBubbleInfo qZoneBubbleInfo) {
        if (!h.l().s(qZoneBubbleInfo)) {
            QLog.d("QZoneGalleryEntranceGuideBubbleController", 1, "should not show guide bubble");
            return;
        }
        if (this.f44837a == null) {
            this.f44837a = new GalleryEntranceGuideBubbleRunnable(activity, view, i3, qZoneBubbleInfo);
        }
        this.f44838b.postDelayed(this.f44837a, 1500L);
    }

    public void d() {
        e();
        h.l().q();
    }

    public void e() {
        GalleryEntranceGuideBubbleRunnable galleryEntranceGuideBubbleRunnable;
        Handler handler = this.f44838b;
        if (handler == null || (galleryEntranceGuideBubbleRunnable = this.f44837a) == null) {
            return;
        }
        handler.removeCallbacks(galleryEntranceGuideBubbleRunnable);
        this.f44837a = null;
    }

    private void f(View view, QZoneBubbleInfo qZoneBubbleInfo, int i3) {
        if (qZoneBubbleInfo == null || TextUtils.isEmpty(qZoneBubbleInfo.getWords())) {
            return;
        }
        e5.b a16 = e5.b.a(view, qZoneBubbleInfo.getWords(), i3);
        QzoneGuideBubbleHelper.g().f();
        QzoneGuideBubbleHelper.d dVar = new QzoneGuideBubbleHelper.d();
        dVar.a(qZoneBubbleInfo.getBackgroundUrl());
        a16.f(dVar);
        a16.k(qZoneBubbleInfo.isShowArrow());
        RFWTipsBaseConfig rFWTipsBaseConfig = new RFWTipsBaseConfig();
        rFWTipsBaseConfig.setDuration(5000L);
        e5.a aVar = new e5.a(view, rFWTipsBaseConfig, a16);
        if (!TextUtils.isEmpty(qZoneBubbleInfo.getJumpUrl())) {
            aVar.addTipsStatusCallBack(new b(qZoneBubbleInfo, aVar));
        }
        if (h.l().m(qZoneBubbleInfo) < qZoneBubbleInfo.getMaxTimes()) {
            ak.g(qZoneBubbleInfo.getAdItem(), 101);
            aVar.startShowTip();
            h.l().o(qZoneBubbleInfo);
        }
    }

    public void c(Activity activity, View view, int i3) {
        if (view == null) {
            return;
        }
        h.l().r(new a(activity, view, i3));
        h.l().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Activity activity, View view, int i3, QZoneBubbleInfo qZoneBubbleInfo) {
        if (view != null && activity != null && qZoneBubbleInfo != null) {
            f(view, qZoneBubbleInfo, i3);
            return;
        }
        QLog.d("QZoneGalleryEntranceGuideBubbleController", 1, "showGalleryEntranceGuideBubble fail, anchorView: " + view + ", bubbleInfo: " + qZoneBubbleInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements RFWTipsBaseController.TipsStatusCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZoneBubbleInfo f44847a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e5.a f44848b;

        b(QZoneBubbleInfo qZoneBubbleInfo, e5.a aVar) {
            this.f44847a = qZoneBubbleInfo;
            this.f44848b = aVar;
        }

        @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
        public void click(View view) {
            ak.g(this.f44847a.getAdItem(), 102);
            yo.d.d(this.f44847a.getJumpUrl(), this.f44848b.getContext(), "");
        }

        @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
        public void dismiss() {
        }

        @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
        public void show() {
        }
    }
}
