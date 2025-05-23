package com.tencent.mobileqq.zplan.push;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/push/i;", "", "", "buf", "", "b", "", "a", "I", "()I", "cmdId", "<init>", "(I)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int cmdId;

    public i(int i3) {
        this.cmdId = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getCmdId() {
        return this.cmdId;
    }

    public abstract void b(@NotNull byte[] buf);
}
