package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.util.Logger;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedLauncherHelper$makeCheckItemListener$1", "Lcom/tencent/mobileqq/guild/feed/api/c;", "Lcom/tencent/mobileqq/guild/feed/api/d;", "Lcom/tencent/mobileqq/guild/feed/api/a;", "result", "", "a", "(Lcom/tencent/mobileqq/guild/feed/api/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedLauncherHelper$makeCheckItemListener$1 implements com.tencent.mobileqq.guild.feed.api.c, com.tencent.mobileqq.guild.feed.api.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GuildFeedLauncherHelper f218030a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Consumer<FeedEditorCheckItemResult> f218031b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedLauncherHelper$makeCheckItemListener$1(GuildFeedLauncherHelper guildFeedLauncherHelper, Consumer<FeedEditorCheckItemResult> consumer) {
        this.f218030a = guildFeedLauncherHelper;
        this.f218031b = consumer;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.mobileqq.guild.feed.api.c
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull FeedEditorCheckItemResult feedEditorCheckItemResult, @NotNull Continuation<? super Boolean> continuation) {
        GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1 guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1;
        Object coroutine_suspended;
        int i3;
        GuildFeedLauncherHelper$makeCheckItemListener$1 guildFeedLauncherHelper$makeCheckItemListener$1;
        WeakReference weakReference;
        if (continuation instanceof GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1) {
            guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1 = (GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1) continuation;
            int i16 = guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        feedEditorCheckItemResult = (FeedEditorCheckItemResult) guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.L$1;
                        guildFeedLauncherHelper$makeCheckItemListener$1 = (GuildFeedLauncherHelper$makeCheckItemListener$1) guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Logger.f235387a.d().i("GuildFeedLauncherHelper", 1, "onCheckResult: " + feedEditorCheckItemResult.getWhat() + ", payload=" + feedEditorCheckItemResult.getPayload());
                    MainCoroutineDispatcher e16 = ae.a().e();
                    GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3 guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3 = new GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3(feedEditorCheckItemResult, this.f218031b, null);
                    guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.L$0 = this;
                    guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.L$1 = feedEditorCheckItemResult;
                    guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.label = 1;
                    if (BuildersKt.withContext(e16, guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$3, guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildFeedLauncherHelper$makeCheckItemListener$1 = this;
                }
                if (feedEditorCheckItemResult.getWhat() != 0) {
                    weakReference = guildFeedLauncherHelper$makeCheckItemListener$1.f218030a.shareResultListenerRef;
                    com.tencent.mobileqq.guild.feed.api.g gVar = (com.tencent.mobileqq.guild.feed.api.g) weakReference.get();
                    if (gVar != null) {
                        gVar.a(false);
                    }
                }
                return Boxing.boxBoolean(false);
            }
        }
        guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1 = new GuildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1(this, continuation);
        Object obj2 = guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildFeedLauncherHelper$makeCheckItemListener$1$onCheckResult$1.label;
        if (i3 == 0) {
        }
        if (feedEditorCheckItemResult.getWhat() != 0) {
        }
        return Boxing.boxBoolean(false);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.d
    public void b() {
        int i3;
        WeakReference weakReference;
        GuildFeedLauncherHelper guildFeedLauncherHelper = this.f218030a;
        i3 = guildFeedLauncherHelper.requestId;
        guildFeedLauncherHelper.u(i3, this.f218030a.getGuildId());
        weakReference = this.f218030a.activityRef;
        if (((Activity) weakReference.get()) != null) {
            this.f218030a.o();
        }
    }
}
