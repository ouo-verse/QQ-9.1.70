package com.tencent.mobileqq.triton.screenrecord;

import android.view.Surface;
import com.tencent.mobileqq.triton.engine.ScreenRecordCallback;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/Recordable;", "", "isRecordReady", "", "onInputSurfaceReady", "", "surface", "Landroid/view/Surface;", "prepareRecording", "recordAudio", "outputPath", "Ljava/io/File;", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenRecordCallback;", "releaseRecording", "startRecording", "stopRecording", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface Recordable {
    boolean isRecordReady();

    void onInputSurfaceReady(@NotNull Surface surface);

    void prepareRecording(boolean recordAudio, @NotNull File outputPath, @Nullable ScreenRecordCallback callback);

    void releaseRecording();

    void startRecording();

    void stopRecording();
}
