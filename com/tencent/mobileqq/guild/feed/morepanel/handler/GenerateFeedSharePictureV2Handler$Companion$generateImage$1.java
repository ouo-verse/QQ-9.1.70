package com.tencent.mobileqq.guild.feed.morepanel.handler;

import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler$Companion", f = "GenerateFeedSharePictureV2Handler.kt", i = {0, 0, 0, 0, 0, 0}, l = {213}, m = "generateImage", n = {"this", "guildInfo", QCircleScheme.AttrDetail.FEED_INFO, MimeHelper.IMAGE_SUBTYPE_BITMAP, "throwable", "timeStart"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
/* loaded from: classes13.dex */
public final class GenerateFeedSharePictureV2Handler$Companion$generateImage$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GenerateFeedSharePictureV2Handler.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenerateFeedSharePictureV2Handler$Companion$generateImage$1(GenerateFeedSharePictureV2Handler.Companion companion, Continuation<? super GenerateFeedSharePictureV2Handler$Companion$generateImage$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, null, null, null, false, this);
    }
}
