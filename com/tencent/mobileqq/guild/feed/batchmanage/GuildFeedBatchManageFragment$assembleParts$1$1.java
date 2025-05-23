package com.tencent.mobileqq.guild.feed.batchmanage;

import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageCooperatePart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class GuildFeedBatchManageFragment$assembleParts$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedBatchManageFragment$assembleParts$1$1(Object obj) {
        super(1, obj, GuildFeedBatchManageCooperatePart.class, "onBatchOperationFinished", "onBatchOperationFinished(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i3) {
        ((GuildFeedBatchManageCooperatePart) this.receiver).F9(i3);
    }
}
