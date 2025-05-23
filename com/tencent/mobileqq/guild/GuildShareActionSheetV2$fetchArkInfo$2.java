package com.tencent.mobileqq.guild;

import com.tencent.mobileqq.guild.share.FetchGuildArkInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.GuildShareActionSheetV2$fetchArkInfo$2", f = "GuildShareActionSheetV2.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class GuildShareActionSheetV2$fetchArkInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $fetchedSuccess;
    final /* synthetic */ boolean $showToast;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildShareActionSheetV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildShareActionSheetV2$fetchArkInfo$2(GuildShareActionSheetV2 guildShareActionSheetV2, boolean z16, Function0<Unit> function0, Continuation<? super GuildShareActionSheetV2$fetchArkInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = guildShareActionSheetV2;
        this.$showToast = z16;
        this.$fetchedSuccess = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildShareActionSheetV2$fetchArkInfo$2 guildShareActionSheetV2$fetchArkInfo$2 = new GuildShareActionSheetV2$fetchArkInfo$2(this.this$0, this.$showToast, this.$fetchedSuccess, continuation);
        guildShareActionSheetV2$fetchArkInfo$2.L$0 = obj;
        return guildShareActionSheetV2$fetchArkInfo$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
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
                GuildShareActionSheetV2 guildShareActionSheetV2 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                fetchGuildArkInfo = guildShareActionSheetV2.guildArkInfoFetcher;
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
        boolean z16 = this.$showToast;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "need show?" + z16 + "\uff0c " + m479exceptionOrNullimpl.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildShareActionSheetV2", 1, (String) it.next(), m479exceptionOrNullimpl);
            }
            if (z16 && !(m479exceptionOrNullimpl instanceof CancellationException)) {
                QQToastUtil.showQQToast(1, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~");
            }
        }
        GuildShareActionSheetV2 guildShareActionSheetV22 = this.this$0;
        Function0<Unit> function0 = this.$fetchedSuccess;
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            guildShareActionSheetV22.executor.y((com.tencent.mobileqq.guild.share.b) m476constructorimpl);
            if (function0 != null) {
                function0.invoke();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildShareActionSheetV2$fetchArkInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
