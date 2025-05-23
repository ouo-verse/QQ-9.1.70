package com.tencent.qphone.base.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BaseQLogItem {
    public byte androidLogLevel;
    public short curJavaThreadId;
    public byte level;
    public long logTime;

    /* renamed from: msg, reason: collision with root package name */
    public String f344405msg;
    public String tag;
    public short threadId;
    public Throwable trace;

    public int computeStringCapacity() {
        return this.tag.length() + 80 + this.f344405msg.length();
    }

    public void recycle() {
        this.androidLogLevel = (byte) 0;
        this.logTime = 0L;
        this.threadId = (short) 0;
        this.curJavaThreadId = (short) 0;
        this.level = (byte) 0;
        this.tag = null;
        this.f344405msg = null;
        this.trace = null;
    }
}
