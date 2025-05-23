package com.tencent.richframework.gallery.delegate.inner;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.richframework.video.IPlayer;
import com.tencent.richframework.video.RFWPlayerVideoInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u001e\u001fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&R\u0014\u0010\u0010\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "", "", "stop", "", "playRate", "setPlayRate", "Lcom/tencent/richframework/video/IPlayer;", "getPlayer", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ControlLayoutVisibleState;", "visibleState", "changeOperationLayoutVisible", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ICaptureListener;", "captureListener", "capture", "", "isPlaying", "()Z", "", "getDurationMs", "()J", "durationMs", "Landroid/graphics/drawable/Drawable;", "getCoverDrawable", "()Landroid/graphics/drawable/Drawable;", "coverDrawable", "Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", "getCurrentPlayInfo", "()Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", "currentPlayInfo", "ControlLayoutVisibleState", "ICaptureListener", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IVideoPlayerProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ControlLayoutVisibleState;", "", "isLock", "", "(Ljava/lang/String;IZ)V", "()Z", ParseCommon.VISIBLE, ParseCommon.GONE, "VISIBLE_THEN_HIDE", "VISIBLE_LOCK", "GONE_LOCK", "NONE", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum ControlLayoutVisibleState {
        VISIBLE(false),
        GONE(false),
        VISIBLE_THEN_HIDE(false),
        VISIBLE_LOCK(true),
        GONE_LOCK(true),
        NONE(false);

        private final boolean isLock;

        ControlLayoutVisibleState(boolean z16) {
            this.isLock = z16;
        }

        /* renamed from: isLock, reason: from getter */
        public final boolean getIsLock() {
            return this.isLock;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ICaptureListener;", "", "onResult", "", "isSuccess", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface ICaptureListener {
        void onResult(boolean isSuccess, @Nullable Bitmap bitmap);
    }

    void capture(@NotNull ICaptureListener captureListener);

    void changeOperationLayoutVisible(@NotNull ControlLayoutVisibleState visibleState);

    @Nullable
    Drawable getCoverDrawable();

    @Nullable
    RFWPlayerVideoInfo getCurrentPlayInfo();

    long getDurationMs();

    @Nullable
    IPlayer getPlayer();

    boolean isPlaying();

    void setPlayRate(float playRate);

    void stop();
}
