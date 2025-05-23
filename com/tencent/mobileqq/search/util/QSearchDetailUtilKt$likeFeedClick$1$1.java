package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.util.QSearchDetailUtilKt$likeFeedClick$1$1", f = "QSearchDetailUtil.kt", i = {}, l = {TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class QSearchDetailUtilKt$likeFeedClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $channelId;
    final /* synthetic */ int $currentStatus;
    final /* synthetic */ Map<String, String> $extensionMap;
    final /* synthetic */ String $feedId;
    final /* synthetic */ long $guildId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchDetailUtilKt$likeFeedClick$1$1(String str, long j3, long j16, int i3, Map<String, String> map, Continuation<? super QSearchDetailUtilKt$likeFeedClick$1$1> continuation) {
        super(2, continuation);
        this.$feedId = str;
        this.$guildId = j3;
        this.$channelId = j16;
        this.$currentStatus = i3;
        this.$extensionMap = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QSearchDetailUtilKt$likeFeedClick$1$1(this.$feedId, this.$guildId, this.$channelId, this.$currentStatus, this.$extensionMap, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            IGuildFeedUtilsApi iGuildFeedUtilsApi = (IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class);
            String feedId = this.$feedId;
            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
            long j3 = this.$guildId;
            long j16 = this.$channelId;
            int i16 = this.$currentStatus;
            GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
            guildFeedReportSourceInfo.setReportInfoMap(this.$extensionMap);
            Unit unit = Unit.INSTANCE;
            this.label = 1;
            obj = iGuildFeedUtilsApi.doVoteUpFeed(feedId, j3, j16, i16, guildFeedReportSourceInfo, false, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        QLog.d("QSearchDetailUtil", 1, "vote up result " + ((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QSearchDetailUtilKt$likeFeedClick$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
