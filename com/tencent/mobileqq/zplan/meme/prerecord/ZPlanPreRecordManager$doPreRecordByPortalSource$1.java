package com.tencent.mobileqq.zplan.meme.prerecord;

import com.tencent.state.data.SquareJSConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager", f = "ZPlanPreRecordManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11}, l = {119, 126, 131, 139, 144, 152, 157, 165, 171, 179, 183, 191}, m = "doPreRecordByPortalSource", n = {"this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST, "this", SquareJSConst.Params.PARAMS_UIN_LIST}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes34.dex */
public final class ZPlanPreRecordManager$doPreRecordByPortalSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanPreRecordManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPreRecordManager$doPreRecordByPortalSource$1(ZPlanPreRecordManager zPlanPreRecordManager, Continuation<? super ZPlanPreRecordManager$doPreRecordByPortalSource$1> continuation) {
        super(continuation);
        this.this$0 = zPlanPreRecordManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object e16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        e16 = this.this$0.e(null, null, this);
        return e16;
    }
}
