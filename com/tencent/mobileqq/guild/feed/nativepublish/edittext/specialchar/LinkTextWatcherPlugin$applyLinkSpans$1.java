package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin", f = "LinkTextWatcherPlugin.kt", i = {0}, l = {278}, m = "applyLinkSpans", n = {"this"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class LinkTextWatcherPlugin$applyLinkSpans$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LinkTextWatcherPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkTextWatcherPlugin$applyLinkSpans$1(LinkTextWatcherPlugin linkTextWatcherPlugin, Continuation<? super LinkTextWatcherPlugin$applyLinkSpans$1> continuation) {
        super(continuation);
        this.this$0 = linkTextWatcherPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object o16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        o16 = this.this$0.o(null, null, this);
        return o16;
    }
}
