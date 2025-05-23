package com.tencent.state.square.chatland.component;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.template.data.ActionType;
import com.tencent.state.template.data.InteractionMotionInfo;
import com.tencent.state.template.service.VasSquareRoomInteractionService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "p1", "Lcom/tencent/state/template/data/ActionType;", "p2", "Lcom/tencent/state/service/ResultCallback;", "", "Lcom/tencent/state/template/data/InteractionMotionInfo;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final /* synthetic */ class ChatLandInteractionMotionComponent$openInviteDialog$1 extends FunctionReferenceImpl implements Function2<ActionType, ResultCallback<List<? extends InteractionMotionInfo>>, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ActionType actionType, ResultCallback<List<? extends InteractionMotionInfo>> resultCallback) {
        invoke2(actionType, (ResultCallback<List<InteractionMotionInfo>>) resultCallback);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatLandInteractionMotionComponent$openInviteDialog$1(VasSquareRoomInteractionService vasSquareRoomInteractionService) {
        super(2, vasSquareRoomInteractionService, VasSquareRoomInteractionService.class, "getMotionList", "getMotionList(Lcom/tencent/state/template/data/ActionType;Lcom/tencent/state/service/ResultCallback;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ActionType p16, ResultCallback<List<InteractionMotionInfo>> p26) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        ((VasSquareRoomInteractionService) this.receiver).getMotionList(p16, p26);
    }
}
