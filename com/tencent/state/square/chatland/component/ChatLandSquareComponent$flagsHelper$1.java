package com.tencent.state.square.chatland.component;

import com.tencent.state.utils.FlagsHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/tencent/state/utils/FlagsHelper;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* synthetic */ class ChatLandSquareComponent$flagsHelper$1 extends FunctionReferenceImpl implements Function1<FlagsHelper, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FlagsHelper flagsHelper) {
        invoke2(flagsHelper);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatLandSquareComponent$flagsHelper$1(ChatLandSquareComponent chatLandSquareComponent) {
        super(1, chatLandSquareComponent, ChatLandSquareComponent.class, "onFlagsChange", "onFlagsChange(Lcom/tencent/state/utils/FlagsHelper;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FlagsHelper p16) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((ChatLandSquareComponent) this.receiver).onFlagsChange(p16);
    }
}
