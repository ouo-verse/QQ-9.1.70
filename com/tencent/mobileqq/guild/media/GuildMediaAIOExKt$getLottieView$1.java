package com.tencent.mobileqq.guild.media;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.GuildMediaAIOExKt", f = "GuildMediaAIOEx.kt", i = {0, 0}, l = {197}, m = "getLottieView", n = {"msgItem", "lottieView"}, s = {"L$0", "L$1"})
/* loaded from: classes14.dex */
public final class GuildMediaAIOExKt$getLottieView$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildMediaAIOExKt$getLottieView$1(Continuation<? super GuildMediaAIOExKt$getLottieView$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3 = GuildMediaAIOExKt.m(null, null, null, null, null, this);
        return m3;
    }
}
