package com.tencent.mobileqq.qqlive.trtc.video.source;

import android.graphics.Bitmap;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.engine.c;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface a {
    void a(@NonNull Handler handler);

    void b() throws IllegalStateException;

    void c(@NonNull c cVar) throws IllegalArgumentException;

    void destroy();

    void f() throws IllegalStateException;

    TRTCVideoQualityParams getVideoQuality();

    void i(Bitmap bitmap, int i3);

    void j(boolean z16);

    void setVideoQuality(@NonNull TRTCVideoQualityParams tRTCVideoQualityParams) throws IllegalStateException;
}
