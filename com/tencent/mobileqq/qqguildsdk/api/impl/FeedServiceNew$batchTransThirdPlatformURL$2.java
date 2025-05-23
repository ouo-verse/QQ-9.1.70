package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.impl.BaseService;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchTransThirdPlatformURCallback;
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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelFeedServiceNew;", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;", "bypass", "", "invoke", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelFeedServiceNew;Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
final class FeedServiceNew$batchTransThirdPlatformURL$2 extends Lambda implements Function2<IKernelFeedServiceNew, BaseService.b, Unit> {
    final /* synthetic */ IGProBatchTransThirdPlatformURCallback $cb;
    final /* synthetic */ GProBatchTransThirdPlatformURLReq $req;
    final /* synthetic */ FeedServiceNew this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qqguildsdk.api.impl.FeedServiceNew$batchTransThirdPlatformURL$2$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function4<IGProBatchTransThirdPlatformURCallback, Integer, String, GProBatchTransThirdPlatformURLRsp, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(4, IGProBatchTransThirdPlatformURCallback.class, "onResult", "onResult(ILjava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLRsp;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(IGProBatchTransThirdPlatformURCallback iGProBatchTransThirdPlatformURCallback, Integer num, String str, GProBatchTransThirdPlatformURLRsp gProBatchTransThirdPlatformURLRsp) {
            invoke(iGProBatchTransThirdPlatformURCallback, num.intValue(), str, gProBatchTransThirdPlatformURLRsp);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull IGProBatchTransThirdPlatformURCallback p06, int i3, String str, GProBatchTransThirdPlatformURLRsp gProBatchTransThirdPlatformURLRsp) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            p06.onResult(i3, str, gProBatchTransThirdPlatformURLRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedServiceNew$batchTransThirdPlatformURL$2(GProBatchTransThirdPlatformURLReq gProBatchTransThirdPlatformURLReq, FeedServiceNew feedServiceNew, IGProBatchTransThirdPlatformURCallback iGProBatchTransThirdPlatformURCallback) {
        super(2);
        this.$req = gProBatchTransThirdPlatformURLReq;
        this.this$0 = feedServiceNew;
        this.$cb = iGProBatchTransThirdPlatformURCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function3 tmp0, int i3, String str, GProBatchTransThirdPlatformURLRsp gProBatchTransThirdPlatformURLRsp) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str, gProBatchTransThirdPlatformURLRsp);
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
        GProBatchTransThirdPlatformURLReq gProBatchTransThirdPlatformURLReq = this.$req;
        final Function3<P1, P2, P3, Unit> N0 = this.this$0.N0(bypass, this.$cb, AnonymousClass1.INSTANCE);
        service.batchTransThirdPlatformURL(gProBatchTransThirdPlatformURLReq, new IGProBatchTransThirdPlatformURCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.br
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProBatchTransThirdPlatformURCallback
            public final void onResult(int i3, String str, GProBatchTransThirdPlatformURLRsp gProBatchTransThirdPlatformURLRsp) {
                FeedServiceNew$batchTransThirdPlatformURL$2.b(Function3.this, i3, str, gProBatchTransThirdPlatformURLRsp);
            }
        });
    }
}
