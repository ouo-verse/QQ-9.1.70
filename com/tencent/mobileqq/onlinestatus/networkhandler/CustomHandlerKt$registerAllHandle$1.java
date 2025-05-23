package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public /* synthetic */ class CustomHandlerKt$registerAllHandle$1 extends FunctionReferenceImpl implements Function3<ToServiceMsg, FromServiceMsg, Object, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomHandlerKt$registerAllHandle$1(Object obj) {
        super(3, obj, CustomHandlerKt.class, "handleSetShareInfo", "handleSetShareInfo(Lcom/tencent/mobileqq/onlinestatus/networkhandler/CustomHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        invoke2(toServiceMsg, fromServiceMsg, obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ToServiceMsg p06, @NotNull FromServiceMsg p16, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        CustomHandlerKt.d((CustomHandler) this.receiver, p06, p16, obj);
    }
}
