package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class au implements ds {

    /* renamed from: a, reason: collision with root package name */
    private final GProGuildMsg f265691a;

    public au(@NonNull GProGuildMsg gProGuildMsg) {
        this.f265691a = gProGuildMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ds
    public long getMsgSeq() {
        return this.f265691a.getMsgSeq();
    }

    public String toString() {
        return "GProGuildMsgImpl{mMsg=" + this.f265691a + '}';
    }
}
