package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.richframework.video.IPlayerStateCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0006*\u0001\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/u;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/l;", "b", "Lcom/tencent/richframework/video/IPlayerStateCallback;", "videoListener", "", "a", "com/tencent/mobileqq/guild/feed/feedsquare/widget/u$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/u$a;", "_dispatcher", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a _dispatcher = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J(\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J*\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J \u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H\u0016R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006)"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/widget/u$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/l;", "", "onBufferEnd", "onBufferStart", "onCompletion", "onDownloadAllFinish", "onFirstFrameRendered", "", "firstInit", "onInitSuccess", "onRelease", "onSeekComplete", "onTimerCallback", "onVideoLoopEnd", "onVideoLoopStart", "", "what", "model", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "soloTime", "onVideoPassivePause", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "onVideoPlayError", "onVideoPrepared", "downloadSpeed", "downloadSize", "totalSize", "updateDownloadState", "", "Lcom/tencent/richframework/video/IPlayerStateCallback;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "videoListeners", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements l {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<IPlayerStateCallback> videoListeners = new ArrayList();

        a() {
        }

        @NotNull
        public final List<IPlayerStateCallback> a() {
            return this.videoListeners;
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onBufferEnd() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onBufferEnd();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onBufferStart() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onBufferStart();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onCompletion() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onCompletion();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onDownloadAllFinish() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onDownloadAllFinish();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onFirstFrameRendered() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onFirstFrameRendered();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onInitSuccess(boolean firstInit) {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onInitSuccess(firstInit);
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onRelease() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onRelease();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onSeekComplete() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onSeekComplete();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onTimerCallback() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onTimerCallback();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onVideoLoopEnd() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onVideoLoopEnd();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onVideoLoopStart() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onVideoLoopStart();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onVideoPassivePause(int what, int model, long playTime, long soloTime) {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onVideoPassivePause(what, model, playTime, soloTime);
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onVideoPlayError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onVideoPlayError(module, errorType, errorCode, extraInfo);
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onVideoPrepared() {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).onVideoPrepared();
            }
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void updateDownloadState(long downloadSpeed, long downloadSize, long totalSize) {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((IPlayerStateCallback) it.next()).updateDownloadState(downloadSpeed, downloadSize, totalSize);
            }
        }
    }

    public final void a(@NotNull IPlayerStateCallback videoListener) {
        Intrinsics.checkNotNullParameter(videoListener, "videoListener");
        this._dispatcher.a().add(videoListener);
    }

    @NotNull
    public final l b() {
        return this._dispatcher;
    }
}
