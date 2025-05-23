package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ImportOldDbMsgNotifyInfo {
    public int chatType;

    /* renamed from: msg, reason: collision with root package name */
    public String f359188msg;
    public float progress;
    public int result;
    public String uid;

    public ImportOldDbMsgNotifyInfo() {
        this.uid = "";
        this.f359188msg = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getMsg() {
        return this.f359188msg;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getResult() {
        return this.result;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "ImportOldDbMsgNotifyInfo{progress=" + this.progress + ",chatType=" + this.chatType + ",uid=" + this.uid + ",result=" + this.result + ",msg=" + this.f359188msg + ",}";
    }

    public ImportOldDbMsgNotifyInfo(float f16, int i3, String str, int i16, String str2) {
        this.progress = f16;
        this.chatType = i3;
        this.uid = str;
        this.result = i16;
        this.f359188msg = str2;
    }
}
