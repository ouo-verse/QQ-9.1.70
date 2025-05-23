package com.tencent.mobileqq.guild.quickshare;

import com.tencent.mobileqq.guild.quickshare.GuildQuickShareHandler;
import com.tencent.mobileqq.guild.share.FetchGuildArkInfo;
import com.tencent.mobileqq.guild.share.w;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quickshare.GuildQuickShareHandler$fetchArkInfo$2", f = "GuildQuickShareHandler.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildQuickShareHandler$fetchArkInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildQuickShareHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildQuickShareHandler$fetchArkInfo$2(GuildQuickShareHandler guildQuickShareHandler, Continuation<? super GuildQuickShareHandler$fetchArkInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = guildQuickShareHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildQuickShareHandler$fetchArkInfo$2 guildQuickShareHandler$fetchArkInfo$2 = new GuildQuickShareHandler$fetchArkInfo$2(this.this$0, continuation);
        guildQuickShareHandler$fetchArkInfo$2.L$0 = obj;
        return guildQuickShareHandler$fetchArkInfo$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        w wVar;
        w wVar2;
        GuildQuickShareHandler.b bVar;
        GuildRecentUser guildRecentUser;
        GuildRecentUser guildRecentUser2;
        FetchGuildArkInfo fetchGuildArkInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                GuildQuickShareHandler guildQuickShareHandler = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                fetchGuildArkInfo = guildQuickShareHandler.mFetchArk;
                this.label = 1;
                obj = fetchGuildArkInfo.f(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            m476constructorimpl = Result.m476constructorimpl((com.tencent.mobileqq.guild.share.b) obj);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QQToastUtil.showQQToast(1, m479exceptionOrNullimpl.getMessage());
        }
        GuildQuickShareHandler guildQuickShareHandler2 = this.this$0;
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            com.tencent.mobileqq.guild.share.b bVar2 = (com.tencent.mobileqq.guild.share.b) m476constructorimpl;
            wVar = guildQuickShareHandler2.mExecutor;
            if (wVar != null) {
                wVar.y(bVar2);
            }
            wVar2 = guildQuickShareHandler2.mExecutor;
            if (wVar2 != null) {
                guildRecentUser = guildQuickShareHandler2.recentUser;
                String uin = guildRecentUser.getUin();
                guildRecentUser2 = guildQuickShareHandler2.recentUser;
                wVar2.s(uin, guildRecentUser2.getType());
            }
            WeakReference weakReference = guildQuickShareHandler2.shareCallbackRef;
            if (weakReference != null && (bVar = (GuildQuickShareHandler.b) weakReference.get()) != null) {
                bVar.onResult(true);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildQuickShareHandler$fetchArkInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
