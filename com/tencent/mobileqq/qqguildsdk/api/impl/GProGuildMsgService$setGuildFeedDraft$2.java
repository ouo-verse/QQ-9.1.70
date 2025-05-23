package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.impl.BaseService;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgService;", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;", "bypass", "", "invoke", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgService;Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
final class GProGuildMsgService$setGuildFeedDraft$2 extends Lambda implements Function2<IKernelGProGuildMsgService, BaseService.b, Unit> {
    final /* synthetic */ IGuildOperateCallback $cb;
    final /* synthetic */ GProGuildFeedDraft $draft;
    final /* synthetic */ String $draftKey;
    final /* synthetic */ int $draftType;
    final /* synthetic */ String $guildID;
    final /* synthetic */ GProGuildMsgService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qqguildsdk.api.impl.GProGuildMsgService$setGuildFeedDraft$2$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<IGuildOperateCallback, Integer, String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, IGuildOperateCallback.class, "onResult", "onResult(ILjava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(IGuildOperateCallback iGuildOperateCallback, Integer num, String str) {
            invoke(iGuildOperateCallback, num.intValue(), str);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull IGuildOperateCallback p06, int i3, String str) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            p06.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GProGuildMsgService$setGuildFeedDraft$2(String str, int i3, String str2, GProGuildFeedDraft gProGuildFeedDraft, GProGuildMsgService gProGuildMsgService, IGuildOperateCallback iGuildOperateCallback) {
        super(2);
        this.$guildID = str;
        this.$draftType = i3;
        this.$draftKey = str2;
        this.$draft = gProGuildFeedDraft;
        this.this$0 = gProGuildMsgService;
        this.$cb = iGuildOperateCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 tmp0, int i3, String str) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(IKernelGProGuildMsgService iKernelGProGuildMsgService, BaseService.b bVar) {
        invoke2(iKernelGProGuildMsgService, bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull IKernelGProGuildMsgService service, @NotNull BaseService.b bypass) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(bypass, "bypass");
        String str = this.$guildID;
        int i3 = this.$draftType;
        String str2 = this.$draftKey;
        GProGuildFeedDraft gProGuildFeedDraft = this.$draft;
        final Function2<P1, P2, Unit> M0 = this.this$0.M0(bypass, this.$cb, AnonymousClass1.INSTANCE);
        service.setGuildFeedDraft(str, i3, str2, gProGuildFeedDraft, new IGuildOperateCallback() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.di
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
            public final void onResult(int i16, String str3) {
                GProGuildMsgService$setGuildFeedDraft$2.b(Function2.this, i16, str3);
            }
        });
    }
}
