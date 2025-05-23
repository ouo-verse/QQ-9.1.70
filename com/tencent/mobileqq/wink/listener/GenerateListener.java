package com.tencent.mobileqq.wink.listener;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/listener/GenerateListener;", "", "beforeCaptureFrame", "", "frameNum", "", "frameTs", "", "beforeEncode", "onAddFrame", "onCaptureFrame", "frameBitmap", "Landroid/graphics/Bitmap;", "onCropFrame", "croppedBitmap", "onEncoded", "outputPath", "", "onError", "t", "", "onRelease", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public interface GenerateListener {
    void beforeCaptureFrame(int frameNum, long frameTs);

    void beforeEncode();

    void onAddFrame(int frameNum);

    void onCaptureFrame(int frameNum, long frameTs, @Nullable Bitmap frameBitmap);

    void onCropFrame(int frameNum, long frameTs, @Nullable Bitmap croppedBitmap);

    void onEncoded(@NotNull String outputPath);

    void onError(@NotNull Throwable t16);

    void onRelease();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class DefaultImpls {
        public static void onEncoded(@NotNull GenerateListener generateListener, @NotNull String outputPath) {
            Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        }

        public static void onError(@NotNull GenerateListener generateListener, @NotNull Throwable t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
        }

        public static void beforeEncode(@NotNull GenerateListener generateListener) {
        }

        public static void onRelease(@NotNull GenerateListener generateListener) {
        }

        public static void onAddFrame(@NotNull GenerateListener generateListener, int i3) {
        }

        public static void beforeCaptureFrame(@NotNull GenerateListener generateListener, int i3, long j3) {
        }

        public static void onCaptureFrame(@NotNull GenerateListener generateListener, int i3, long j3, @Nullable Bitmap bitmap) {
        }

        public static void onCropFrame(@NotNull GenerateListener generateListener, int i3, long j3, @Nullable Bitmap bitmap) {
        }
    }
}
