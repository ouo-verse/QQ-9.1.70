package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/i;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/g;", "", "a", "J", "()J", "data", "", "b", "Z", "()Z", "isOutCalled", "<init>", "(JZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class i extends g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isOutCalled;

    public i(long j3, boolean z16) {
        this.data = j3;
        this.isOutCalled = z16;
    }

    /* renamed from: a, reason: from getter */
    public final long getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsOutCalled() {
        return this.isOutCalled;
    }
}
