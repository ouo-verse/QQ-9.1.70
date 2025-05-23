package com.tencent.mobileqq.guild.feed.launcher.parser;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/launcher/parser/GuildFeedNativeEditorParser$makeCheckItemListener$1", "Lcom/tencent/mobileqq/guild/feed/api/c;", "Lcom/tencent/mobileqq/guild/feed/api/a;", "result", "", "a", "(Lcom/tencent/mobileqq/guild/feed/api/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedNativeEditorParser$makeCheckItemListener$1 implements com.tencent.mobileqq.guild.feed.api.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f220083a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f220084b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedNativeEditorParser$makeCheckItemListener$1(Context context, String str) {
        this.f220083a = context;
        this.f220084b = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.mobileqq.guild.feed.api.c
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull FeedEditorCheckItemResult feedEditorCheckItemResult, @NotNull Continuation<? super Boolean> continuation) {
        GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1 guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1) {
            guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1 = (GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1) continuation;
            int i16 = guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (feedEditorCheckItemResult.getWhat() == 1) {
                        GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2 guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2 = new GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2(this.f220083a, this.f220084b, feedEditorCheckItemResult, null);
                        guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1.label = 1;
                        if (CoroutineScopeKt.coroutineScope(guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2, guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Boxing.boxBoolean(z16);
                }
                z16 = false;
                return Boxing.boxBoolean(z16);
            }
        }
        guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1 = new GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1(this, continuation);
        Object obj2 = guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$1.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        z162 = false;
        return Boxing.boxBoolean(z162);
    }
}
