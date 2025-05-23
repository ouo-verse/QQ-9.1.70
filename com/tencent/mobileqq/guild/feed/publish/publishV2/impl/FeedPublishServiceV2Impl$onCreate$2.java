package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class FeedPublishServiceV2Impl$onCreate$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedPublishServiceV2Impl$onCreate$2(Object obj) {
        super(1, obj, FeedPublishServiceV2Impl.class, "onQuitGuild", "onQuitGuild(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((FeedPublishServiceV2Impl) this.receiver).onQuitGuild(p06);
    }
}
