package com.tencent.mobileqq.vas.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u00062\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/data/c;", "", "", "a", "I", "()I", "d", "(I)V", "changeType", "", "b", "J", "c", "()J", "f", "(J)V", "oldData", "e", "newData", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int changeType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long oldData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long newData;

    /* renamed from: a, reason: from getter */
    public final int getChangeType() {
        return this.changeType;
    }

    /* renamed from: b, reason: from getter */
    public final long getNewData() {
        return this.newData;
    }

    /* renamed from: c, reason: from getter */
    public final long getOldData() {
        return this.oldData;
    }

    public final void d(int i3) {
        this.changeType = i3;
    }

    public final void e(long j3) {
        this.newData = j3;
    }

    public final void f(long j3) {
        this.oldData = j3;
    }
}
