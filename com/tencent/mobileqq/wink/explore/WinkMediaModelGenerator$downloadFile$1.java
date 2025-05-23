package com.tencent.mobileqq.wink.explore;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.explore.WinkMediaModelGenerator", f = "WinkMediaModelGenerator.kt", i = {}, l = {PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT}, m = "downloadFile", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkMediaModelGenerator$downloadFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkMediaModelGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMediaModelGenerator$downloadFile$1(WinkMediaModelGenerator winkMediaModelGenerator, Continuation<? super WinkMediaModelGenerator$downloadFile$1> continuation) {
        super(continuation);
        this.this$0 = winkMediaModelGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object l3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        l3 = this.this$0.l(null, this);
        return l3;
    }
}
