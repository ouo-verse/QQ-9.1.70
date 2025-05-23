package com.tencent.biz.qcircleshadow.lib.listener;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface QCircleAEEditorGenerateResultListener {
    void onAETavSessionExportCompleted(String str, LocalMediaInfo localMediaInfo);

    void onAETavSessionExportError(String str, long j3, String str2);

    void onAETavSessionExporting(String str, float f16);
}
