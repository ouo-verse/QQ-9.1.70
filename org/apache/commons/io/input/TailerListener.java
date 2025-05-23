package org.apache.commons.io.input;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface TailerListener {
    void fileNotFound();

    void fileRotated();

    void handle(Exception exc);

    void handle(String str);

    void init(Tailer tailer);
}
