package com.gcloudsdk.apollo.apollovoice.httpclient;

/* loaded from: classes2.dex */
class SRTTAPIHTTPTaskQueue {
    private static SRTTAPIHTTPTaskQueueImp taskQueue = new SRTTAPIHTTPTaskQueueImp();

    SRTTAPIHTTPTaskQueue() {
    }

    public static synchronized void addTask(int i3, String str, byte[] bArr, int i16) {
        synchronized (SRTTAPIHTTPTaskQueue.class) {
            taskQueue.addTask(i3, str, bArr, i16);
        }
    }

    public static void setAppInfo(String str, String str2, String str3, int i3) {
        taskQueue.setAppInfo(str, str2, str3, i3);
    }

    public static void init() {
    }
}
