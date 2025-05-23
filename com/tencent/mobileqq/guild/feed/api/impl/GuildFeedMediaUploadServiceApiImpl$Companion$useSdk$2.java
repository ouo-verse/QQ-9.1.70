package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.mobileqq.guild.util.ch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
/* synthetic */ class GuildFeedMediaUploadServiceApiImpl$Companion$useSdk$2 extends FunctionReferenceImpl implements Function0<String> {
    public static final GuildFeedMediaUploadServiceApiImpl$Companion$useSdk$2 INSTANCE = new GuildFeedMediaUploadServiceApiImpl$Companion$useSdk$2();

    GuildFeedMediaUploadServiceApiImpl$Companion$useSdk$2() {
        super(0, ch.class, "accountUin", "accountUin()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final String invoke() {
        return ch.g();
    }
}
