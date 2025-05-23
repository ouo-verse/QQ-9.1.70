package com.tencent.mobileqq.guild.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/config/p;", "", "", "a", "I", "getMId", "()I", "mId", "", "b", "Ljava/lang/String;", "getMName", "()Ljava/lang/String;", "mName", "c", "getMUrl", "mUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int mId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mUrl;

    public p(int i3, @NotNull String mName, @NotNull String mUrl) {
        Intrinsics.checkNotNullParameter(mName, "mName");
        Intrinsics.checkNotNullParameter(mUrl, "mUrl");
        this.mId = i3;
        this.mName = mName;
        this.mUrl = mUrl;
    }
}
