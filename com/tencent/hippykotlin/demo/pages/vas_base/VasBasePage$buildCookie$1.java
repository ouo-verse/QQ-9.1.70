package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage", f = "VasBasePage.kt", i = {0, 0}, l = {401}, m = "buildCookie", n = {"this", "uin"}, s = {"L$0", "L$1"})
/* loaded from: classes33.dex */
public final class VasBasePage$buildCookie$1 extends ContinuationImpl {
    public VasBasePage L$0;
    public String L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ VasBasePage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasBasePage$buildCookie$1(VasBasePage vasBasePage, Continuation<? super VasBasePage$buildCookie$1> continuation) {
        super(continuation);
        this.this$0 = vasBasePage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        VasBasePage vasBasePage = this.this$0;
        VasBasePage.Companion companion = VasBasePage.Companion;
        return vasBasePage.buildCookie(null, this);
    }
}
