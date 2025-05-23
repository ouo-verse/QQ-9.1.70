package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedFastPushRocketAnimEvent;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.thread.RFWThreadManager;
import mqq.util.WeakReference;

/* loaded from: classes5.dex */
public class QFSPushRocketAnimView extends FrameLayout {
    private int C;
    private String D;
    private Runnable E;
    private final Runnable F;

    /* renamed from: d, reason: collision with root package name */
    private QQAnimationDrawable f93374d;

    /* renamed from: e, reason: collision with root package name */
    private QQAnimationDrawable f93375e;

    /* renamed from: f, reason: collision with root package name */
    private QQAnimationDrawable f93376f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f93377h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f93378i;

    /* renamed from: m, reason: collision with root package name */
    private int f93379m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PushAnimCreateResultListener implements AnimationDrawableFactory.CreateResultListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSPushRocketAnimView> f93380d;

        PushAnimCreateResultListener(QFSPushRocketAnimView qFSPushRocketAnimView) {
            this.f93380d = new WeakReference<>(qFSPushRocketAnimView);
        }

        @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
        public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
            if (z16 && qQAnimationDrawable != null) {
                qQAnimationDrawable.setOneShot(true);
                final QFSPushRocketAnimView qFSPushRocketAnimView = this.f93380d.get();
                if (qFSPushRocketAnimView != null) {
                    qFSPushRocketAnimView.j(qQAnimationDrawable);
                }
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketAnimView.PushAnimCreateResultListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSPushRocketAnimView qFSPushRocketAnimView2 = qFSPushRocketAnimView;
                        if (qFSPushRocketAnimView2 != null) {
                            qFSPushRocketAnimView2.m();
                        }
                        QLog.d("QFSPushRocketAnimView", RFWLog.USR, "push rocket");
                    }
                });
                return;
            }
            QLog.d("QFSPushRocketAnimView", RFWLog.USR, "download push anim resource fail");
        }
    }

    public QFSPushRocketAnimView(@NonNull Context context) {
        super(context);
        this.f93378i = false;
        this.E = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QFSFeedFastPushRocketAnimEvent(QFSPushRocketAnimView.this.f93379m, QFSPushRocketAnimView.this.C, QFSPushRocketAnimView.this.D));
            }
        };
        this.F = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                QFSPushRocketAnimView.this.setVisibility(8);
            }
        };
    }

    private String i() {
        int i3 = this.f93379m;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                return "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/893/rocket_v3/qvideo_rocket_feed_quickpush_3_seq.zip";
            }
            return "https://downv6.qq.com/video_story/qcircle/zip/defaultmode/893/rocket_v3/qvideo_rocket_feed_quickpush_2_seq.zip";
        }
        return "https://downv6.qq.com/video_story/qcircle/feed/rocket/qvideo_rocket_feed_quickpush_V1.zip";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(QQAnimationDrawable qQAnimationDrawable) {
        int i3 = this.f93379m;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f93376f = qQAnimationDrawable;
                    return;
                }
                return;
            }
            this.f93375e = qQAnimationDrawable;
            return;
        }
        this.f93374d = qQAnimationDrawable;
    }

    private void k(QQAnimationDrawable qQAnimationDrawable) {
        if (qQAnimationDrawable == null) {
            QLog.d("QFSPushRocketAnimView", 1, "start download pushAnimationV1!");
            String i3 = i();
            if (RFWDownloaderFactory.getDownloader(com.tencent.biz.qqcircle.f.r()).isFileDownLoaded(i3)) {
                QLog.d("QFSPushRocketAnimView", 1, "pushAnimationV1 already downloaded! " + i3);
                AnimationDrawableCreateOption.Builder defaultBuilder = QCircleAnimationHelper.getDefaultBuilder(i3);
                defaultBuilder.setFrameDuration(40);
                defaultBuilder.setCreateTimeOut(TTL.MAX_VALUE);
                q50.a.a(hashCode(), defaultBuilder.build(), new PushAnimCreateResultListener(this));
                return;
            }
            QLog.d("QFSPushRocketAnimView", 1, "pushAnimation need download,show animation fail!");
            return;
        }
        m();
    }

    private void l() {
        int i3 = this.f93379m;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    k(this.f93376f);
                    return;
                }
                return;
            }
            k(this.f93375e);
            return;
        }
        k(this.f93374d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        int i3 = this.f93379m;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    p();
                    return;
                }
                return;
            }
            o();
            return;
        }
        n();
    }

    private void n() {
        QQAnimationDrawable qQAnimationDrawable;
        if (this.f93378i && this.f93377h != null && (qQAnimationDrawable = this.f93374d) != null) {
            t(qQAnimationDrawable);
        }
    }

    private void o() {
        QQAnimationDrawable qQAnimationDrawable;
        if (this.f93378i && (qQAnimationDrawable = this.f93375e) != null) {
            t(qQAnimationDrawable);
        }
    }

    private void p() {
        QQAnimationDrawable qQAnimationDrawable;
        if (this.f93378i && (qQAnimationDrawable = this.f93376f) != null) {
            t(qQAnimationDrawable);
        }
    }

    private void r(int i3) {
        this.f93379m = i3;
    }

    private void t(QQAnimationDrawable qQAnimationDrawable) {
        if (this.f93377h != null && qQAnimationDrawable != null) {
            setVisibility(0);
            qQAnimationDrawable.setListener(new a());
            this.f93377h.setImageDrawable(qQAnimationDrawable);
            qQAnimationDrawable.start();
            RFWLog.d("QFSPushRocketAnimView", RFWLog.USR, "play rocket animation");
        }
    }

    private void v() {
        QQAnimationDrawable qQAnimationDrawable = this.f93374d;
        if (qQAnimationDrawable != null && qQAnimationDrawable.isRunning()) {
            this.f93374d.stop();
        }
    }

    private void w() {
        QQAnimationDrawable qQAnimationDrawable = this.f93375e;
        if (qQAnimationDrawable != null && qQAnimationDrawable.isRunning()) {
            this.f93375e.stop();
        }
    }

    private void x() {
        QQAnimationDrawable qQAnimationDrawable = this.f93376f;
        if (qQAnimationDrawable != null && qQAnimationDrawable.isRunning()) {
            this.f93376f.stop();
        }
    }

    public void q() {
        r(0);
        setPushRocketCount(0);
        setFeedId("");
    }

    public void s(int i3, ImageView imageView) {
        this.f93378i = true;
        this.f93377h = imageView;
        r(i3);
        l();
    }

    public void setFeedId(String str) {
        this.D = str;
    }

    public void setPushRocketCount(int i3) {
        this.C = i3;
    }

    public void u() {
        int i3 = this.f93379m;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    x();
                }
            } else {
                w();
            }
        } else {
            v();
        }
        ImageView imageView = this.f93377h;
        if (imageView != null) {
            imageView.removeCallbacks(this.E);
            this.f93377h.removeCallbacks(this.F);
        }
    }

    public QFSPushRocketAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93378i = false;
        this.E = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QFSFeedFastPushRocketAnimEvent(QFSPushRocketAnimView.this.f93379m, QFSPushRocketAnimView.this.C, QFSPushRocketAnimView.this.D));
            }
        };
        this.F = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                QFSPushRocketAnimView.this.setVisibility(8);
            }
        };
    }

    public QFSPushRocketAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93378i = false;
        this.E = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QFSFeedFastPushRocketAnimEvent(QFSPushRocketAnimView.this.f93379m, QFSPushRocketAnimView.this.C, QFSPushRocketAnimView.this.D));
            }
        };
        this.F = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketAnimView.2
            @Override // java.lang.Runnable
            public void run() {
                QFSPushRocketAnimView.this.setVisibility(8);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements QQAnimationDrawable.QQAnimationListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStart() {
            long j3;
            if (QFSPushRocketAnimView.this.f93377h != null) {
                ImageView imageView = QFSPushRocketAnimView.this.f93377h;
                Runnable runnable = QFSPushRocketAnimView.this.E;
                if (QFSPushRocketAnimView.this.f93379m == 1) {
                    j3 = 520;
                } else {
                    j3 = 480;
                }
                imageView.postDelayed(runnable, j3);
            }
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStop() {
            if (QFSPushRocketAnimView.this.f93377h == null) {
                return;
            }
            QFSPushRocketAnimView.this.f93377h.postDelayed(QFSPushRocketAnimView.this.F, 1500L);
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onPlay(int i3) {
        }
    }
}
