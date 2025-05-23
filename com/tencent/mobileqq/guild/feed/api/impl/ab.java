package com.tencent.mobileqq.guild.feed.api.impl;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/ab;", "T", "", "", "a", "I", "c", "()I", "result", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "Ljava/lang/Object;", "()Ljava/lang/Object;", "resp", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ab<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final T resp;

    public ab(int i3, @Nullable String str, @Nullable T t16) {
        this.result = i3;
        this.errMsg = str;
        this.resp = t16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    public final T b() {
        return this.resp;
    }

    /* renamed from: c, reason: from getter */
    public final int getResult() {
        return this.result;
    }
}
