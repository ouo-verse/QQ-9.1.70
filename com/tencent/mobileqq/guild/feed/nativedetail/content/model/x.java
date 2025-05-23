package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/x;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "msgObject", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String message;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Object msgObject;

    public x(@NotNull String message, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.msgObject = obj;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Object getMsgObject() {
        return this.msgObject;
    }
}
