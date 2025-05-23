package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterDataManager", f = "AdelieCreativeCenterDataManager.kt", i = {0, 0}, l = {84}, m = "fetchCreativeCenterServerData$qecommerce_biz_release", n = {"rspByteArray", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE}, s = {"L$0", "Z$0"})
/* loaded from: classes31.dex */
public final class AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$1 extends ContinuationImpl {
    public Ref.ObjectRef L$0;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AdelieCreativeCenterDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$1(AdelieCreativeCenterDataManager adelieCreativeCenterDataManager, Continuation<? super AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$1> continuation) {
        super(continuation);
        this.this$0 = adelieCreativeCenterDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchCreativeCenterServerData$qecommerce_biz_release(null, null, false, this);
    }
}
