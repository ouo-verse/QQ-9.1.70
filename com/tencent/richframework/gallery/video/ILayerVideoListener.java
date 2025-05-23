package com.tencent.richframework.gallery.video;

import android.widget.SeekBar;
import com.tencent.richframework.video.IPlayerStateCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0017J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0017J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0017\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/gallery/video/ILayerVideoListener;", "Lcom/tencent/richframework/video/IPlayerStateCallback;", "onProgress", "", "timeString", "", "videoDuration", "", "currentDuration", "onSeekBarProgressChanged", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface ILayerVideoListener extends IPlayerStateCallback {
    @JvmDefault
    void onProgress(@NotNull String timeString, int videoDuration, int currentDuration);

    @JvmDefault
    void onSeekBarProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser);

    @JvmDefault
    void onStartTrackingTouch(@NotNull SeekBar seekBar);

    @JvmDefault
    void onStopTrackingTouch(@NotNull SeekBar seekBar);
}
