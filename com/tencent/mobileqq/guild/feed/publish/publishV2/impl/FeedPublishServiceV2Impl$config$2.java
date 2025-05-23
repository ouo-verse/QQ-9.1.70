package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.mobileqq.guild.feed.util.ax;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class FeedPublishServiceV2Impl$config$2 extends FunctionReferenceImpl implements Function0<String> {
    public static final FeedPublishServiceV2Impl$config$2 INSTANCE = new FeedPublishServiceV2Impl$config$2();

    FeedPublishServiceV2Impl$config$2() {
        super(0, ax.class, "getCurrentUin", "getCurrentUin()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return ax.v();
    }
}
