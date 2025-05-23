package com.tencent.mobileqq.icgame.base.room.service.lifecycle;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/b;", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/e;", "", "a", "b", "", "c", "Z", "isPageIn", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isPageIn;

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.e
    public void a() {
        this.isPageIn = true;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.e
    public void b() {
        this.isPageIn = false;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.e
    /* renamed from: c, reason: from getter */
    public boolean getIsPageIn() {
        return this.isPageIn;
    }
}
