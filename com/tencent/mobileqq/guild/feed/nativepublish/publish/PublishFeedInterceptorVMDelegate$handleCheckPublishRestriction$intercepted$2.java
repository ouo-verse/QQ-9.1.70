package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class PublishFeedInterceptorVMDelegate$handleCheckPublishRestriction$intercepted$2 extends FunctionReferenceImpl implements Function0<Function3<? super String, ? super JSONObject, ? super zl1.a, ? extends Boolean>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PublishFeedInterceptorVMDelegate$handleCheckPublishRestriction$intercepted$2(Object obj) {
        super(0, obj, PublishFeedInterceptorVMDelegate.class, "checkEmptyContentRestriction", "checkEmptyContentRestriction()Lkotlin/jvm/functions/Function3;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Function3<? super String, ? super JSONObject, ? super zl1.a, ? extends Boolean> invoke() {
        Function3<? super String, ? super JSONObject, ? super zl1.a, ? extends Boolean> g16;
        g16 = ((PublishFeedInterceptorVMDelegate) this.receiver).g();
        return g16;
    }
}
