package com.tencent.robot.aio.bottomcontainer;

import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/aio/bottomcontainer/a;", "Lcom/tencent/qqnt/aio/baseVM/a;", "", "Lcom/tencent/mvi/base/route/g;", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends com.tencent.qqnt.aio.baseVM.a<Object, Object> {
    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        return new HashSet();
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetBottomLayoutHeight");
        return hashSet;
    }
}
