package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchOptionModel;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchSourceModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1", "Lcom/tencent/mobileqq/guild/feed/api/c;", "Lcom/tencent/mobileqq/guild/feed/api/a;", "result", "", "a", "(Lcom/tencent/mobileqq/guild/feed/api/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1 implements com.tencent.mobileqq.guild.feed.api.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.mobileqq.guild.feed.api.c f217990a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FeedEditorLaunchApiImpl f217991b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f217992c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.tencent.mobileqq.guild.data.s f217993d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ FeedEditorLaunchOptionModel f217994e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ FeedEditorLaunchSourceModel f217995f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ com.tencent.mobileqq.guild.feed.api.d f217996g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1(com.tencent.mobileqq.guild.feed.api.c cVar, FeedEditorLaunchApiImpl feedEditorLaunchApiImpl, Context context, com.tencent.mobileqq.guild.data.s sVar, FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, FeedEditorLaunchSourceModel feedEditorLaunchSourceModel, com.tencent.mobileqq.guild.feed.api.d dVar) {
        this.f217990a = cVar;
        this.f217991b = feedEditorLaunchApiImpl;
        this.f217992c = context;
        this.f217993d = sVar;
        this.f217994e = feedEditorLaunchOptionModel;
        this.f217995f = feedEditorLaunchSourceModel;
        this.f217996g = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.tencent.mobileqq.guild.feed.api.c
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull FeedEditorCheckItemResult feedEditorCheckItemResult, @NotNull Continuation<? super Boolean> continuation) {
        FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1 feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1;
        Object coroutine_suspended;
        int i3;
        FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1 feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1;
        Object L;
        if (continuation instanceof FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1) {
            feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1 = (FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1) continuation;
            int i16 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1.label = i16 - Integer.MIN_VALUE;
                FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1 feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1;
                Object obj = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1 = (FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1) feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        FeedEditorLaunchApiImpl feedEditorLaunchApiImpl = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217991b;
                        Context context = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217992c;
                        com.tencent.mobileqq.guild.data.s sVar = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217993d;
                        FeedEditorLaunchOptionModel feedEditorLaunchOptionModel = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217994e;
                        FeedEditorLaunchSourceModel feedEditorLaunchSourceModel = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217995f;
                        com.tencent.mobileqq.guild.feed.api.d dVar = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217996g;
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.L$0 = null;
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.label = 2;
                        L = feedEditorLaunchApiImpl.L(context, sVar, feedEditorLaunchOptionModel, feedEditorLaunchSourceModel, dVar, feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12);
                        if (L == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (feedEditorCheckItemResult.getWhat() == 0) {
                        com.tencent.mobileqq.guild.feed.api.c cVar = this.f217990a;
                        FeedEditorCheckItemResult feedEditorCheckItemResult2 = new FeedEditorCheckItemResult(0, null);
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.L$0 = this;
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.label = 1;
                        if (cVar.a(feedEditorCheckItemResult2, feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1 = this;
                        FeedEditorLaunchApiImpl feedEditorLaunchApiImpl2 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217991b;
                        Context context2 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217992c;
                        com.tencent.mobileqq.guild.data.s sVar2 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217993d;
                        FeedEditorLaunchOptionModel feedEditorLaunchOptionModel2 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217994e;
                        FeedEditorLaunchSourceModel feedEditorLaunchSourceModel2 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217995f;
                        com.tencent.mobileqq.guild.feed.api.d dVar2 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1.f217996g;
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.L$0 = null;
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.label = 2;
                        L = feedEditorLaunchApiImpl2.L(context2, sVar2, feedEditorLaunchOptionModel2, feedEditorLaunchSourceModel2, dVar2, feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12);
                        if (L == coroutine_suspended) {
                        }
                    } else {
                        com.tencent.mobileqq.guild.feed.api.c cVar2 = this.f217990a;
                        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12.label = 3;
                        obj = cVar2.a(feedEditorCheckItemResult, feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj;
                    }
                }
                return Boxing.boxBoolean(true);
            }
        }
        feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1 = new FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1(this, continuation);
        FeedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1 feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$122 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$1;
        Object obj2 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = feedEditorLaunchApiImpl$performCheckItemsToStartFeedEditorToPostNewOne$1$onCheckResult$122.label;
        if (i3 == 0) {
        }
        return Boxing.boxBoolean(true);
    }
}
