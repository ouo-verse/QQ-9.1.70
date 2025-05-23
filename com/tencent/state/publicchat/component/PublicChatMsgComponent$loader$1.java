package com.tencent.state.publicchat.component;

import com.tencent.state.publicchat.data.MsgInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "p1", "", "Lcom/tencent/state/publicchat/data/MsgInfo;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* synthetic */ class PublicChatMsgComponent$loader$1 extends FunctionReferenceImpl implements Function1<List<? extends MsgInfo>, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends MsgInfo> list) {
        invoke2((List<MsgInfo>) list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublicChatMsgComponent$loader$1(PublicChatMsgComponent publicChatMsgComponent) {
        super(1, publicChatMsgComponent, PublicChatMsgComponent.class, "onNewMsgLoaded", "onNewMsgLoaded(Ljava/util/List;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<MsgInfo> p16) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((PublicChatMsgComponent) this.receiver).onNewMsgLoaded(p16);
    }
}
