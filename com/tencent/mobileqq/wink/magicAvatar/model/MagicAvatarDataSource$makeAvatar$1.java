package com.tencent.mobileqq.wink.magicAvatar.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource", f = "MagicAvatarDataSource.kt", i = {0}, l = {321}, m = "makeAvatar", n = {"this"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class MagicAvatarDataSource$makeAvatar$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicAvatarDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarDataSource$makeAvatar$1(MagicAvatarDataSource magicAvatarDataSource, Continuation<? super MagicAvatarDataSource$makeAvatar$1> continuation) {
        super(continuation);
        this.this$0 = magicAvatarDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, null, null, null, this);
    }
}
