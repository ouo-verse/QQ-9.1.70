package com.tencent.smtt.export.external.interfaces;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ConsoleMessage {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    int lineNumber();

    String message();

    MessageLevel messageLevel();

    String sourceId();
}
