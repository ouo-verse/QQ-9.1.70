package com.tencent.mobileqq.nearbypro.repository.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.repository.service.AvatarService", f = "AvatarService.kt", i = {0, 0, 0, 1}, l = {110, 116}, m = "reqOtherAvatarInfo", n = {"$this$getOrPut$iv", "key$iv", "tinyId", "tinyId"}, s = {"L$0", "L$1", "J$0", "J$0"})
/* loaded from: classes15.dex */
public final class AvatarService$reqOtherAvatarInfo$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AvatarService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarService$reqOtherAvatarInfo$1(AvatarService avatarService, Continuation<? super AvatarService$reqOtherAvatarInfo$1> continuation) {
        super(continuation);
        this.this$0 = avatarService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reqOtherAvatarInfo(0L, null, this);
    }
}
