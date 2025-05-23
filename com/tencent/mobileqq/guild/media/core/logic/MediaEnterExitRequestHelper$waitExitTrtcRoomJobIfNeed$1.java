package com.tencent.mobileqq.guild.media.core.logic;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper", f = "MediaEnterExitRequestHelper.kt", i = {}, l = {420}, m = "waitExitTrtcRoomJobIfNeed", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaEnterExitRequestHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1(MediaEnterExitRequestHelper mediaEnterExitRequestHelper, Continuation<? super MediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1> continuation) {
        super(continuation);
        this.this$0 = mediaEnterExitRequestHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object n16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        n16 = this.this$0.n1(this);
        return n16;
    }
}
