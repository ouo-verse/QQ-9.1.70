package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.thread.RFWThreadManager;

/* loaded from: classes5.dex */
public class QFSPushRocketFireworksView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private QQAnimationDrawable f93383d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f93384e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f93385f;

    /* renamed from: h, reason: collision with root package name */
    private final AnimationDrawableFactory.CreateResultListener f93386h;

    public QFSPushRocketFireworksView(@NonNull Context context) {
        super(context);
        this.f93386h = new AnimationDrawableFactory.CreateResultListener() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketFireworksView.1
            @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
            public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
                if (z16 && qQAnimationDrawable != null) {
                    qQAnimationDrawable.setOneShot(true);
                    QFSPushRocketFireworksView.this.f93383d = qQAnimationDrawable;
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketFireworksView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSPushRocketFireworksView qFSPushRocketFireworksView = QFSPushRocketFireworksView.this;
                            qFSPushRocketFireworksView.e(qFSPushRocketFireworksView.f93385f);
                            RFWLog.d("QFSPushRocketFireworksView", RFWLog.USR, "push rocket fireworks");
                        }
                    });
                    return;
                }
                RFWLog.d("QFSPushRocketFireworksView", RFWLog.USR, "download push anim resource fail");
            }
        };
    }

    private void d(ImageView imageView) {
        if (this.f93383d == null) {
            QLog.d("QFSPushRocketFireworksView", 1, "start download pushAnimationV1!");
            if (RFWDownloaderFactory.getDownloader(com.tencent.biz.qqcircle.f.r()).isFileDownLoaded("https://downv6.qq.com/video_story/qcircle/feed/rocket/qvideo_rocket_feed_quickpush_3_decorate_seq.zip")) {
                QLog.d("QFSPushRocketFireworksView", 1, "pushAnimationV1 already downloaded! https://downv6.qq.com/video_story/qcircle/feed/rocket/qvideo_rocket_feed_quickpush_3_decorate_seq.zip");
                AnimationDrawableCreateOption.Builder defaultBuilder = QCircleAnimationHelper.getDefaultBuilder("https://downv6.qq.com/video_story/qcircle/feed/rocket/qvideo_rocket_feed_quickpush_3_decorate_seq.zip");
                defaultBuilder.setFrameDuration(40);
                defaultBuilder.setCreateTimeOut(TTL.MAX_VALUE);
                q50.a.a(hashCode(), defaultBuilder.build(), this.f93386h);
                return;
            }
            QLog.d("QFSPushRocketFireworksView", 1, "pushAnimation need download,show animation fail!");
            return;
        }
        e(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ImageView imageView) {
        if (this.f93384e && this.f93383d != null && imageView != null) {
            setVisibility(0);
            this.f93383d.setListener(new a());
            imageView.setImageDrawable(this.f93383d);
            this.f93383d.start();
        }
    }

    public void f(ImageView imageView) {
        this.f93384e = true;
        this.f93385f = imageView;
        d(imageView);
    }

    public void g() {
        QQAnimationDrawable qQAnimationDrawable = this.f93383d;
        if (qQAnimationDrawable != null && qQAnimationDrawable.isRunning()) {
            this.f93383d.stop();
        }
    }

    public QFSPushRocketFireworksView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93386h = new AnimationDrawableFactory.CreateResultListener() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketFireworksView.1
            @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
            public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
                if (z16 && qQAnimationDrawable != null) {
                    qQAnimationDrawable.setOneShot(true);
                    QFSPushRocketFireworksView.this.f93383d = qQAnimationDrawable;
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketFireworksView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSPushRocketFireworksView qFSPushRocketFireworksView = QFSPushRocketFireworksView.this;
                            qFSPushRocketFireworksView.e(qFSPushRocketFireworksView.f93385f);
                            RFWLog.d("QFSPushRocketFireworksView", RFWLog.USR, "push rocket fireworks");
                        }
                    });
                    return;
                }
                RFWLog.d("QFSPushRocketFireworksView", RFWLog.USR, "download push anim resource fail");
            }
        };
    }

    public QFSPushRocketFireworksView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93386h = new AnimationDrawableFactory.CreateResultListener() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketFireworksView.1
            @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
            public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
                if (z16 && qQAnimationDrawable != null) {
                    qQAnimationDrawable.setOneShot(true);
                    QFSPushRocketFireworksView.this.f93383d = qQAnimationDrawable;
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSPushRocketFireworksView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSPushRocketFireworksView qFSPushRocketFireworksView = QFSPushRocketFireworksView.this;
                            qFSPushRocketFireworksView.e(qFSPushRocketFireworksView.f93385f);
                            RFWLog.d("QFSPushRocketFireworksView", RFWLog.USR, "push rocket fireworks");
                        }
                    });
                    return;
                }
                RFWLog.d("QFSPushRocketFireworksView", RFWLog.USR, "download push anim resource fail");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements QQAnimationDrawable.QQAnimationListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStop() {
            QFSPushRocketFireworksView.this.setVisibility(8);
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStart() {
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onPlay(int i3) {
        }
    }
}
