package com.tencent.mobileqq.zootopia.ark;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ark/d;", "Lcom/tencent/mobileqq/zootopia/ark/a;", "", "e", "I", tl.h.F, "()I", "k", "(I)V", "status", "", "f", "J", "g", "()J", "i", "(J)V", "billNum", "getOwnerUin", "j", "ownerUin", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long billNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long ownerUin;

    /* renamed from: g, reason: from getter */
    public final long getBillNum() {
        return this.billNum;
    }

    /* renamed from: h, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final void i(long j3) {
        this.billNum = j3;
    }

    public final void j(long j3) {
        this.ownerUin = j3;
    }

    public final void k(int i3) {
        this.status = i3;
    }
}
