package com.tencent.mobileqq.zootopia.ipc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaDevSettingRemoteManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/l;", "", "type", "Lcom/tencent/mobileqq/zootopia/ipc/k;", "callback", "", "isSwitchOn", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDevSettingRemoteManagerImpl implements l {
    @Override // com.tencent.mobileqq.zootopia.ipc.l
    public void isSwitchOn(int type, k callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onResult(com.tencent.mobileqq.zootopia.g.f328305a.c(type));
    }
}
