package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProComment;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ab implements dm {

    /* renamed from: a, reason: collision with root package name */
    private final GProComment f265656a;

    public ab(GProComment gProComment) {
        this.f265656a = gProComment;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dm
    public long getMsgSeq() {
        return this.f265656a.getMsgSeq();
    }
}
