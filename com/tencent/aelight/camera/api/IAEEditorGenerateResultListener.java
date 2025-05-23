package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAEEditorGenerateResultListener {
    void onAETavSessionExportCompleted(String str, LocalMediaInfo localMediaInfo);

    void onAETavSessionExportError(String str, long j3, String str2);

    void onAETavSessionExporting(String str, float f16, LocalMediaInfo localMediaInfo, float f17);
}
