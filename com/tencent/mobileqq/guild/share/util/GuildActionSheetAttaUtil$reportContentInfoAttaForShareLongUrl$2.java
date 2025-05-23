package com.tencent.mobileqq.guild.share.util;

import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil$reportContentInfoAttaForShareLongUrl$2", f = "GuildActionSheetAttaUtil.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildActionSheetAttaUtil$reportContentInfoAttaForShareLongUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $actionItem;
    final /* synthetic */ int $sharePanelPageSource;
    final /* synthetic */ String $shareUrl;
    final /* synthetic */ String $toGuildId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildActionSheetAttaUtil$reportContentInfoAttaForShareLongUrl$2(String str, int i3, int i16, String str2, Continuation<? super GuildActionSheetAttaUtil$reportContentInfoAttaForShareLongUrl$2> continuation) {
        super(2, continuation);
        this.$shareUrl = str;
        this.$actionItem = i3;
        this.$sharePanelPageSource = i16;
        this.$toGuildId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildActionSheetAttaUtil$reportContentInfoAttaForShareLongUrl$2(this.$shareUrl, this.$actionItem, this.$sharePanelPageSource, this.$toGuildId, continuation);
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
            GuildActionSheetAttaUtil guildActionSheetAttaUtil = GuildActionSheetAttaUtil.f235105a;
            String str = this.$shareUrl;
            int i16 = this.$actionItem;
            int i17 = this.$sharePanelPageSource;
            String str2 = this.$toGuildId;
            this.label = 1;
            obj = guildActionSheetAttaUtil.m(str, i16, i17, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        AttaIdReportData attaIdReportData = (AttaIdReportData) obj;
        if (attaIdReportData != null) {
            GuildActionSheetAttaUtil.g(attaIdReportData);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildActionSheetAttaUtil$reportContentInfoAttaForShareLongUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
