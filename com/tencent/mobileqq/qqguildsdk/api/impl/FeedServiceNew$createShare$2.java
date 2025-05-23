package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.impl.BaseService;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateShareRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateShareCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelFeedServiceNew;", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;", "bypass", "", "invoke", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelFeedServiceNew;Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
final class FeedServiceNew$createShare$2 extends Lambda implements Function2<IKernelFeedServiceNew, BaseService.b, Unit> {
    final /* synthetic */ IGProCreateShareCallback $cb;
    final /* synthetic */ GProCreateShareReq $req;
    final /* synthetic */ int $serviceType;
    final /* synthetic */ FeedServiceNew this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$createShare$2$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function4<IGProCreateShareCallback, Integer, String, GProCreateShareRsp, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(4, IGProCreateShareCallback.class, "onResult", "onResult(ILjava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateShareRsp;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(IGProCreateShareCallback iGProCreateShareCallback, Integer num, String str, GProCreateShareRsp gProCreateShareRsp) {
            invoke(iGProCreateShareCallback, num.intValue(), str, gProCreateShareRsp);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull IGProCreateShareCallback p06, int i3, String str, GProCreateShareRsp gProCreateShareRsp) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            p06.onResult(i3, str, gProCreateShareRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedServiceNew$createShare$2(GProCreateShareReq gProCreateShareReq, int i3, FeedServiceNew feedServiceNew, IGProCreateShareCallback iGProCreateShareCallback) {
        super(2);
        this.$req = gProCreateShareReq;
        this.$serviceType = i3;
        this.this$0 = feedServiceNew;
        this.$cb = iGProCreateShareCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function3 tmp0, int i3, String str, GProCreateShareRsp gProCreateShareRsp) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str, gProCreateShareRsp);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(IKernelFeedServiceNew iKernelFeedServiceNew, BaseService.b bVar) {
        invoke2(iKernelFeedServiceNew, bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull IKernelFeedServiceNew service, @NotNull BaseService.b bypass) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(bypass, "bypass");
        GProCreateShareReq gProCreateShareReq = this.$req;
        int i3 = this.$serviceType;
        final Function3<P1, P2, P3, Unit> N0 = this.this$0.N0(bypass, this.$cb, AnonymousClass1.INSTANCE);
        service.createShare(gProCreateShareReq, i3, new IGProCreateShareCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bs
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateShareCallback
            public final void onResult(int i16, String str, GProCreateShareRsp gProCreateShareRsp) {
                FeedServiceNew$createShare$2.b(Function3.this, i16, str, gProCreateShareRsp);
            }
        });
    }
}
