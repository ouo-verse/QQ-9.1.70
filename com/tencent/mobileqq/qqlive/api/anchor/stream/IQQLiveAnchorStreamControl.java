package com.tencent.mobileqq.qqlive.api.anchor.stream;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveTranscodingConfig;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveAnchorStreamControl {
    void closeMixTranscoding();

    void openMixTranscoding(@NonNull QQLiveTranscodingConfig qQLiveTranscodingConfig);

    void pausePublishStream(Bitmap bitmap, int i3, boolean z16);

    void resumePublishStream(boolean z16);
}
