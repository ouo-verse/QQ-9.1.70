package com.tencent.biz.pubaccount.weishi.push;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/push/c;", "", "Lcom/tencent/biz/pubaccount/weishi/push/WSRedDotPushMsg;", "pushMsgData", "", "a", "c", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f81352a = new c();

    c() {
    }

    @JvmStatic
    public static final boolean a(WSRedDotPushMsg pushMsgData) {
        IWSPushBaseStrategy iWSPushBaseStrategy;
        Integer valueOf = (pushMsgData == null || (iWSPushBaseStrategy = pushMsgData.mStrategyInfo) == null) ? null : Integer.valueOf(iWSPushBaseStrategy.getType());
        return (valueOf != null && valueOf.intValue() == 6) || (valueOf != null && valueOf.intValue() == 7);
    }

    @JvmStatic
    public static final boolean b(WSRedDotPushMsg pushMsgData) {
        IWSPushBaseStrategy iWSPushBaseStrategy;
        return (pushMsgData == null || (iWSPushBaseStrategy = pushMsgData.mStrategyInfo) == null || iWSPushBaseStrategy.getType() != 5) ? false : true;
    }

    @JvmStatic
    public static final boolean c(WSRedDotPushMsg pushMsgData) {
        IWSPushBaseStrategy iWSPushBaseStrategy;
        return (pushMsgData == null || (iWSPushBaseStrategy = pushMsgData.mStrategyInfo) == null || iWSPushBaseStrategy.getType() != 8) ? false : true;
    }
}
