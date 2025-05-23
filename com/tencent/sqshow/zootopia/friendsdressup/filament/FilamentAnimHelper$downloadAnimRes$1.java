package com.tencent.sqshow.zootopia.friendsdressup.filament;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentAnimHelper", f = "FriendsDressUpAnimHelper.kt", i = {}, l = {114}, m = "downloadAnimRes", n = {}, s = {})
/* loaded from: classes34.dex */
public final class FilamentAnimHelper$downloadAnimRes$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilamentAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentAnimHelper$downloadAnimRes$1(FilamentAnimHelper filamentAnimHelper, Continuation<? super FilamentAnimHelper$downloadAnimRes$1> continuation) {
        super(continuation);
        this.this$0 = filamentAnimHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.s(null, null, null, this);
    }
}
