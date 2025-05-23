package com.tencent.component.network.module.common.dns;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AnswerRecord {
    public String domain;

    /* renamed from: ip, reason: collision with root package name */
    public byte[] f99901ip;
    public int qclass;
    public long ttl;
    public int type;

    public AnswerRecord() {
    }

    public AnswerRecord(String str, byte[] bArr, int i3, long j3, int i16) {
        this.domain = str;
        this.f99901ip = bArr;
        this.type = i3;
        this.ttl = j3;
        this.qclass = i16;
    }
}
