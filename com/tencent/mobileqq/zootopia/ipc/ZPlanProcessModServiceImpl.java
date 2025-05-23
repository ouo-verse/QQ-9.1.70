package com.tencent.mobileqq.zootopia.ipc;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZPlanProcessModServiceImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/d;", "", "modId", "", "isModRunning", "(I)Ljava/lang/Boolean;", "", "onModExit", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanProcessModServiceImpl implements d {
    private final /* synthetic */ an $$delegate_0 = an.f328351a;

    @Override // com.tencent.mobileqq.zootopia.ipc.d
    public Boolean isModRunning(int modId) {
        return this.$$delegate_0.isModRunning(modId);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.d
    public void onModExit(int modId) {
        this.$$delegate_0.onModExit(modId);
    }
}
