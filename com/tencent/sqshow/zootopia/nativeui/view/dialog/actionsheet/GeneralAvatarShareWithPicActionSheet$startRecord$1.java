package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicActionSheet", f = "GeneralAvatarShareWithPicActionSheet.kt", i = {}, l = {com.tencent.luggage.wxa.fg.d.CTRL_INDEX}, m = "startRecord", n = {}, s = {})
/* loaded from: classes34.dex */
public final class GeneralAvatarShareWithPicActionSheet$startRecord$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GeneralAvatarShareWithPicActionSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneralAvatarShareWithPicActionSheet$startRecord$1(GeneralAvatarShareWithPicActionSheet generalAvatarShareWithPicActionSheet, Continuation<? super GeneralAvatarShareWithPicActionSheet$startRecord$1> continuation) {
        super(continuation);
        this.this$0 = generalAvatarShareWithPicActionSheet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object S0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        S0 = this.this$0.S0(this);
        return S0;
    }
}
