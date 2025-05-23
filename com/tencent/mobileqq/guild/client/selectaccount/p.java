package com.tencent.mobileqq.guild.client.selectaccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/client/selectaccount/p;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "id", "desc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String desc;

    public p(@NotNull String id5, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.id = id5;
        this.desc = desc;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }
}
