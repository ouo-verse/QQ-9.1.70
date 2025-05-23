package com.tencent.state.square.chatland.view;

import android.app.Dialog;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Landroid/app/Dialog;", "p2", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final /* synthetic */ class ChatLandDialogTips$showSwitchRoomConfirmTip$1$dialog$1 extends FunctionReferenceImpl implements Function2<Dialog, View, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Dialog dialog, View view) {
        invoke2(dialog, view);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatLandDialogTips$showSwitchRoomConfirmTip$1$dialog$1(ChatLandDialogTips chatLandDialogTips) {
        super(2, chatLandDialogTips, ChatLandDialogTips.class, "onBeforeInitReport", "onBeforeInitReport(Landroid/app/Dialog;Landroid/view/View;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Dialog p16, View p26) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        ((ChatLandDialogTips) this.receiver).onBeforeInitReport(p16, p26);
    }
}
