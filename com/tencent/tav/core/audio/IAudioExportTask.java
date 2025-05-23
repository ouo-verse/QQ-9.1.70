package com.tencent.tav.core.audio;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IAudioExportTask {
    void cancel();

    void setExportCallback(ExportCallback exportCallback);

    void start();
}
