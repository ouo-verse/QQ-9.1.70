package com.tencent.biz.richframework.queue;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDownloadQueueTaskInfo {
    private HashMap<String, String> mExtMap;
    private final String mUrl;

    public RFWDownloadQueueTaskInfo(String str) {
        this.mUrl = str;
    }

    public HashMap<String, String> getExtMap() {
        return this.mExtMap;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setExtMap(HashMap<String, String> hashMap) {
        this.mExtMap = hashMap;
    }

    public String toString() {
        return "RFWDownloadQueueTaskInfo{mUrl='" + this.mUrl + "', mExtMap=" + RFWDownloadQueueUtils.mapToString(this.mExtMap) + '}';
    }
}
