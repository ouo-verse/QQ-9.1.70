package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.impl.BaseService;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransferFileOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileTransferService;", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;", "bypass", "", "invoke", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileTransferService;Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
final class GuildFileTransferService$pauseFileGroupUpload$2 extends Lambda implements Function2<IKernelGuildFileTransferService, BaseService.b, Unit> {
    final /* synthetic */ IGProTransferFileOperateCallback $callback;
    final /* synthetic */ String $fileGroupId;
    final /* synthetic */ GuildFileTransferService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qqguildsdk.api.impl.GuildFileTransferService$pauseFileGroupUpload$2$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<IGProTransferFileOperateCallback, Integer, String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, IGProTransferFileOperateCallback.class, "onResult", "onResult(ILjava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(IGProTransferFileOperateCallback iGProTransferFileOperateCallback, Integer num, String str) {
            invoke(iGProTransferFileOperateCallback, num.intValue(), str);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull IGProTransferFileOperateCallback p06, int i3, String str) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            p06.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFileTransferService$pauseFileGroupUpload$2(String str, GuildFileTransferService guildFileTransferService, IGProTransferFileOperateCallback iGProTransferFileOperateCallback) {
        super(2);
        this.$fileGroupId = str;
        this.this$0 = guildFileTransferService;
        this.$callback = iGProTransferFileOperateCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 tmp0, int i3, String str) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str);
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
        String str = this.$fileGroupId;
        final Function2<P1, P2, Unit> M0 = this.this$0.M0(bypass, this.$callback, AnonymousClass1.INSTANCE);
        service.pauseFileGroupUpload(str, new IGProTransferFileOperateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.dp
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransferFileOperateCallback
            public final void onResult(int i3, String str2) {
                GuildFileTransferService$pauseFileGroupUpload$2.b(Function2.this, i3, str2);
            }
        });
    }
}
