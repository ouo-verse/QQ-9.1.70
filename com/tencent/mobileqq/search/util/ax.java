package com.tencent.mobileqq.search.util;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0011\u0010\r\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/util/ax;", "", "", "a", "J", "c", "()J", "e", "(J)V", "startTime", "b", "d", "endTime", "costTime", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ax {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    public final long a() {
        return this.endTime - this.startTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: c, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final void d(long j3) {
        this.endTime = j3;
    }

    public final void e(long j3) {
        this.startTime = j3;
    }
}
