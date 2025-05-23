package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface DecodeCompletionListener {
    void onDecodeTaskCompleted(FaceInfo faceInfo, Bitmap bitmap);

    void onDecodeTaskCompletedNeedDownload(FaceInfo faceInfo);
}
