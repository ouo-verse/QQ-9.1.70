package com.tencent.qqmini.v8rt.engine;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IWorkerEventHandler {
    int create(String str);

    void postMsgToAppService(String str);

    void postMsgToWorker(int i3, String str);

    void terminate(int i3);
}
