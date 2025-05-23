package com.tencent.zplan.model;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \r2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/zplan/model/a;", "", "", "a", "I", "getEnterSceneType", "()I", "c", "(I)V", "enterSceneType", "b", "getChangeSceneType", "changeSceneType", "d", "firstFrameSceneType", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int enterSceneType = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int changeSceneType = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int firstFrameSceneType = -1;

    /* renamed from: a, reason: from getter */
    public final int getFirstFrameSceneType() {
        return this.firstFrameSceneType;
    }

    public final void b(int i3) {
        this.changeSceneType = i3;
    }

    public final void c(int i3) {
        this.enterSceneType = i3;
    }

    public final void d(int i3) {
        this.firstFrameSceneType = i3;
    }
}
