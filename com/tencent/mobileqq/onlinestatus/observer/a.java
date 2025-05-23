package com.tencent.mobileqq.onlinestatus.observer;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR$\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0004\u0010\u0010\"\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/observer/a;", "T", "", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "a", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "getReq", "()Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "b", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "()Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "data", "<init>", "(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ToServiceMsg req;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FromServiceMsg res;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T data;

    public a(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable T t16) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        this.req = req;
        this.res = res;
        this.data = t16;
    }

    @Nullable
    public final T a() {
        return this.data;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final FromServiceMsg getRes() {
        return this.res;
    }

    public final void c(@Nullable T t16) {
        this.data = t16;
    }

    public /* synthetic */ a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(toServiceMsg, fromServiceMsg, (i3 & 4) != 0 ? null : obj);
    }
}
