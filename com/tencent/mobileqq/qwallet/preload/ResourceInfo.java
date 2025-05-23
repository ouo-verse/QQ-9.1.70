package com.tencent.mobileqq.qwallet.preload;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ResourceInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public long doneTime;
    public String fileMd5;
    public String filePath;
    public String folderPath;
    public String resId;
    public int type;
    public String url;

    public String toString() {
        return "ResourceInfo{url='" + this.url + "', filePath='" + this.filePath + "', fileMd5='" + this.fileMd5 + "', doneTime=" + this.doneTime + ", type=" + this.type + ", folderPath='" + this.folderPath + "', resId='" + this.resId + "'}";
    }
}
