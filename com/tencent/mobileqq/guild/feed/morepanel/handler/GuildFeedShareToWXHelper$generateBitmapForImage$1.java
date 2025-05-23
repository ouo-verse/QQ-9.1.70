package com.tencent.mobileqq.guild.feed.morepanel.handler;

import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedShareToWXHelper", f = "GuildFeedShareToWXHelper.kt", i = {0, 0, 0, 0, 1, 1}, l = {207, 219}, m = "generateBitmapForImage", n = {"this", "imageUrl", "binding", BaseProfileQZoneComponent.KEY_IS_VIDEO, "this", "binding"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1"})
/* loaded from: classes13.dex */
public final class GuildFeedShareToWXHelper$generateBitmapForImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuildFeedShareToWXHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareToWXHelper$generateBitmapForImage$1(GuildFeedShareToWXHelper guildFeedShareToWXHelper, Continuation<? super GuildFeedShareToWXHelper$generateBitmapForImage$1> continuation) {
        super(continuation);
        this.this$0 = guildFeedShareToWXHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object k3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        k3 = this.this$0.k(null, null, 0, 0, false, this);
        return k3;
    }
}
