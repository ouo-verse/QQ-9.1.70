package com.qzone.module.feedcomponent.ui;

import android.os.Handler;
import android.widget.ImageView;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView$videoPlayStatusList$1", "Lcom/qzone/module/feedcomponent/ui/FeedAutoVideo$OnVideoPlayStatusListener;", "onVideoPlayComplete", "", "baseVideo", "Lcom/tencent/mobileqq/qzoneplayer/video/BaseVideo;", "onVideoPlayProgressUpdate", "onVideoPlayStart", "onVideoPlayStop", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class QZoneOldFrdHotVideoItemView$videoPlayStatusList$1 implements FeedAutoVideo.OnVideoPlayStatusListener {
    final /* synthetic */ QZoneOldFrdHotVideoItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QZoneOldFrdHotVideoItemView$videoPlayStatusList$1(QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView) {
        this.this$0 = qZoneOldFrdHotVideoItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVideoPlayComplete$lambda$2(QZoneOldFrdHotVideoItemView this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZoneOldFrdHotVideoItemView", 1, "onVideoPlayComplete, show cover");
        imageView = this$0.videoCoverView;
        imageView.setVisibility(0);
        this$0.onEndPlayVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVideoPlayProgressUpdate$lambda$1(QZoneOldFrdHotVideoItemView this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZoneOldFrdHotVideoItemView", 1, "onVideoPlayProgressUpdate, hide cover");
        imageView = this$0.videoCoverView;
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVideoPlayStart$lambda$0(QZoneOldFrdHotVideoItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZoneOldFrdHotVideoItemView", 1, "onVideoPlayStart");
        this$0.onStartPlayVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVideoPlayStop$lambda$3(QZoneOldFrdHotVideoItemView this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZoneOldFrdHotVideoItemView", 1, "onVideoPlayStop, show cover");
        imageView = this$0.videoCoverView;
        imageView.setVisibility(0);
        this$0.onEndPlayVideo();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
    public void onVideoPlayComplete(BaseVideo baseVideo) {
        Handler handler;
        handler = this.this$0.mainHandler;
        final QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView = this.this$0;
        handler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                QZoneOldFrdHotVideoItemView$videoPlayStatusList$1.onVideoPlayComplete$lambda$2(QZoneOldFrdHotVideoItemView.this);
            }
        });
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
    public void onVideoPlayProgressUpdate(BaseVideo baseVideo) {
        ImageView imageView;
        Handler handler;
        FeedAutoVideo feedAutoVideo = baseVideo instanceof FeedAutoVideo ? (FeedAutoVideo) baseVideo : null;
        if (feedAutoVideo == null) {
            return;
        }
        FeedVideoView feedVideoView = this.this$0.getFeedVideoView();
        if (!Intrinsics.areEqual(feedAutoVideo, feedVideoView != null ? feedVideoView.getAutoVideoView() : null) || feedAutoVideo.getmCurPositionMills() <= 0) {
            return;
        }
        imageView = this.this$0.videoCoverView;
        if (imageView.getVisibility() == 0) {
            handler = this.this$0.mainHandler;
            final QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView = this.this$0;
            handler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.i
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneOldFrdHotVideoItemView$videoPlayStatusList$1.onVideoPlayProgressUpdate$lambda$1(QZoneOldFrdHotVideoItemView.this);
                }
            });
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
    public void onVideoPlayStart(BaseVideo baseVideo) {
        Handler handler;
        handler = this.this$0.mainHandler;
        final QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView = this.this$0;
        handler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.h
            @Override // java.lang.Runnable
            public final void run() {
                QZoneOldFrdHotVideoItemView$videoPlayStatusList$1.onVideoPlayStart$lambda$0(QZoneOldFrdHotVideoItemView.this);
            }
        });
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
    public void onVideoPlayStop(BaseVideo baseVideo) {
        Handler handler;
        handler = this.this$0.mainHandler;
        final QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView = this.this$0;
        handler.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                QZoneOldFrdHotVideoItemView$videoPlayStatusList$1.onVideoPlayStop$lambda$3(QZoneOldFrdHotVideoItemView.this);
            }
        });
    }
}
