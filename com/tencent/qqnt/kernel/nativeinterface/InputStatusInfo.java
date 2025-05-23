package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InputStatusInfo {
    public int chatType;
    public int eventType;
    public String fromUin;
    public long interval;
    public long showTime;
    public String statusText;
    public long timestamp;
    public String toUin;

    public InputStatusInfo() {
        this.fromUin = "";
        this.toUin = "";
        this.statusText = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getEventType() {
        return this.eventType;
    }

    public String getFromUin() {
        return this.fromUin;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getShowTime() {
        return this.showTime;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getToUin() {
        return this.toUin;
    }

    public String toString() {
        return "InputStatusInfo{chatType=" + this.chatType + ",fromUin=" + this.fromUin + ",toUin=" + this.toUin + ",interval=" + this.interval + ",showTime=" + this.showTime + ",eventType=" + this.eventType + ",statusText=" + this.statusText + ",timestamp=" + this.timestamp + ",}";
    }

    public InputStatusInfo(int i3, String str, String str2, long j3, long j16, int i16, String str3, long j17) {
        this.chatType = i3;
        this.fromUin = str;
        this.toUin = str2;
        this.interval = j3;
        this.showTime = j16;
        this.eventType = i16;
        this.statusText = str3;
        this.timestamp = j17;
    }
}
