package com.tencent.aelight.camera.ae.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/s;", "", "Lcom/tencent/aelight/camera/ae/util/Operator;", "a", "Lcom/tencent/aelight/camera/ae/util/Operator;", "b", "()Lcom/tencent/aelight/camera/ae/util/Operator;", "op", "Lcom/tencent/aelight/camera/ae/util/o;", "Lcom/tencent/aelight/camera/ae/util/o;", "()Lcom/tencent/aelight/camera/ae/util/o;", "action", "<init>", "(Lcom/tencent/aelight/camera/ae/util/Operator;Lcom/tencent/aelight/camera/ae/util/o;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Operator op;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final o action;

    public s(Operator op5, o action) {
        Intrinsics.checkNotNullParameter(op5, "op");
        Intrinsics.checkNotNullParameter(action, "action");
        this.op = op5;
        this.action = action;
    }

    /* renamed from: a, reason: from getter */
    public final o getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final Operator getOp() {
        return this.op;
    }
}
