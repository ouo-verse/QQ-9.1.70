package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeDataManager", f = "AdelieCategoryHomeDataManager.kt", i = {0, 0}, l = {24}, m = "fetchMobileRobotRecommendCards$qecommerce_biz_release", n = {"rspByteArray", "saveCache"}, s = {"L$0", "Z$0"})
/* loaded from: classes31.dex */
public final class AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1 extends ContinuationImpl {
    public Ref.ObjectRef L$0;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AdelieCategoryHomeDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1(AdelieCategoryHomeDataManager adelieCategoryHomeDataManager, Continuation<? super AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1> continuation) {
        super(continuation);
        this.this$0 = adelieCategoryHomeDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchMobileRobotRecommendCards$qecommerce_biz_release(null, null, null, false, this);
    }
}
