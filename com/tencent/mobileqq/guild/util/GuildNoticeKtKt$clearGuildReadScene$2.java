package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Luh2/c;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.util.GuildNoticeKtKt$clearGuildReadScene$2", f = "GuildNoticeKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildNoticeKtKt$clearGuildReadScene$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super uh2.c>, Object> {
    final /* synthetic */ Function2<Integer, String, Unit> $cb;
    final /* synthetic */ String $guildId;
    final /* synthetic */ int $readScene;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildNoticeKtKt$clearGuildReadScene$2(String str, int i3, Function2<? super Integer, ? super String, Unit> function2, Continuation<? super GuildNoticeKtKt$clearGuildReadScene$2> continuation) {
        super(2, continuation);
        this.$guildId = str;
        this.$readScene = i3;
        this.$cb = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 function2, int i3, String str) {
        QLog.d("GuildNoticeKt", 2, "clearGuildReadScene result:" + i3 + "  errMsg:" + str);
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i3), str);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildNoticeKtKt$clearGuildReadScene$2(this.$guildId, this.$readScene, this.$cb, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
            if (gProGuildMsgService != null) {
                String str = this.$guildId;
                int i3 = this.$readScene;
                final Function2<Integer, String, Unit> function2 = this.$cb;
                gProGuildMsgService.clearGuildReadSceneV2(new GProContact(16, str, str), i3, new IGuildOperateCallback() { // from class: com.tencent.mobileqq.guild.util.ak
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                    public final void onResult(int i16, String str2) {
                        GuildNoticeKtKt$clearGuildReadScene$2.b(Function2.this, i16, str2);
                    }
                });
                return gProGuildMsgService;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super uh2.c> continuation) {
        return ((GuildNoticeKtKt$clearGuildReadScene$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
