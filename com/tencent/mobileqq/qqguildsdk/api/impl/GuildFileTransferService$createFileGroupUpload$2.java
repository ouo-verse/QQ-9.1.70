package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.impl.BaseService;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateUploadFileGroupParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadFileGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateUploadFileGroupCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileTransferService;", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;", "bypass", "", "invoke", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileTransferService;Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
final class GuildFileTransferService$createFileGroupUpload$2 extends Lambda implements Function2<IKernelGuildFileTransferService, BaseService.b, Unit> {
    final /* synthetic */ IGProCreateUploadFileGroupCallback $callback;
    final /* synthetic */ GProCreateUploadFileGroupParam $createParam;
    final /* synthetic */ GuildFileTransferService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService$createFileGroupUpload$2$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function4<IGProCreateUploadFileGroupCallback, Integer, String, GProUploadFileGroupInfo, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(4, IGProCreateUploadFileGroupCallback.class, "onCreateUploadFileGroupResult", "onCreateUploadFileGroupResult(ILjava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadFileGroupInfo;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(IGProCreateUploadFileGroupCallback iGProCreateUploadFileGroupCallback, Integer num, String str, GProUploadFileGroupInfo gProUploadFileGroupInfo) {
            invoke(iGProCreateUploadFileGroupCallback, num.intValue(), str, gProUploadFileGroupInfo);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull IGProCreateUploadFileGroupCallback p06, int i3, String str, GProUploadFileGroupInfo gProUploadFileGroupInfo) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            p06.onCreateUploadFileGroupResult(i3, str, gProUploadFileGroupInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFileTransferService$createFileGroupUpload$2(GProCreateUploadFileGroupParam gProCreateUploadFileGroupParam, GuildFileTransferService guildFileTransferService, IGProCreateUploadFileGroupCallback iGProCreateUploadFileGroupCallback) {
        super(2);
        this.$createParam = gProCreateUploadFileGroupParam;
        this.this$0 = guildFileTransferService;
        this.$callback = iGProCreateUploadFileGroupCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function3 tmp0, int i3, String str, GProUploadFileGroupInfo gProUploadFileGroupInfo) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str, gProUploadFileGroupInfo);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(IKernelGuildFileTransferService iKernelGuildFileTransferService, BaseService.b bVar) {
        invoke2(iKernelGuildFileTransferService, bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull IKernelGuildFileTransferService service, @NotNull BaseService.b bypass) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(bypass, "bypass");
        GProCreateUploadFileGroupParam gProCreateUploadFileGroupParam = this.$createParam;
        final Function3<P1, P2, P3, Unit> N0 = this.this$0.N0(bypass, this.$callback, AnonymousClass1.INSTANCE);
        service.createFileGroupUpload(gProCreateUploadFileGroupParam, new IGProCreateUploadFileGroupCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dj
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateUploadFileGroupCallback
            public final void onCreateUploadFileGroupResult(int i3, String str, GProUploadFileGroupInfo gProUploadFileGroupInfo) {
                GuildFileTransferService$createFileGroupUpload$2.b(Function3.this, i3, str, gProUploadFileGroupInfo);
            }
        });
    }
}
