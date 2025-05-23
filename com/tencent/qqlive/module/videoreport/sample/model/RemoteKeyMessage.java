package com.tencent.qqlive.module.videoreport.sample.model;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RemoteKeyMessage {
    public final String key;
    public final String segmentCount;
    public final String segmentIndex;
    public final String timestamp;

    public RemoteKeyMessage(String str, String str2, String str3, String str4) {
        this.timestamp = str2;
        this.segmentCount = str3;
        this.segmentIndex = str4;
        this.key = str;
    }

    public int compareBySegIndex(RemoteKeyMessage remoteKeyMessage) {
        try {
            return Long.compare(Integer.parseInt(this.segmentIndex), Integer.parseInt(remoteKeyMessage.segmentIndex));
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public int compareByTimestamp(RemoteKeyMessage remoteKeyMessage) {
        try {
            return Long.compare(Long.parseLong(remoteKeyMessage.timestamp), Long.parseLong(this.timestamp));
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return 0;
        }
    }
}
