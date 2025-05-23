package com.tencent.biz.qqcircle.immersive.feed.event;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/event/f;", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "", "a", "Ljava/lang/String;", "mTraceId", "traceId", "<init>", "(Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mTraceId;

    public f(@Nullable String str) {
        this.mTraceId = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getMTraceId() {
        return this.mTraceId;
    }
}
