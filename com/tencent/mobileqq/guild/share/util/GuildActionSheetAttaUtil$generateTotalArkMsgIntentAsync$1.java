package com.tencent.mobileqq.guild.share.util;

import android.content.Intent;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.guild.share.GuildShareForwardReceiver;
import com.tencent.mobileqq.guild.share.s;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil$generateTotalArkMsgIntentAsync$1", f = "GuildActionSheetAttaUtil.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildActionSheetAttaUtil$generateTotalArkMsgIntentAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $callback;
    final /* synthetic */ String $forceUpdateAttaId;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ s $shareForwardCB;
    final /* synthetic */ int $sharePanelPageSource;
    final /* synthetic */ String $shareUrl;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildActionSheetAttaUtil$generateTotalArkMsgIntentAsync$1(String str, int i3, String str2, Intent intent, s sVar, g gVar, Continuation<? super GuildActionSheetAttaUtil$generateTotalArkMsgIntentAsync$1> continuation) {
        super(2, continuation);
        this.$shareUrl = str;
        this.$sharePanelPageSource = i3;
        this.$forceUpdateAttaId = str2;
        this.$intent = intent;
        this.$shareForwardCB = sVar;
        this.$callback = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildActionSheetAttaUtil$generateTotalArkMsgIntentAsync$1(this.$shareUrl, this.$sharePanelPageSource, this.$forceUpdateAttaId, this.$intent, this.$shareForwardCB, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
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
            int i16 = this.$sharePanelPageSource;
            this.label = 1;
            obj = guildActionSheetAttaUtil.m(str, -1, i16, "", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        AttaIdReportData attaIdReportData = (AttaIdReportData) obj;
        if (attaIdReportData != null) {
            String str2 = this.$forceUpdateAttaId;
            Intent intent = this.$intent;
            s sVar = this.$shareForwardCB;
            g gVar = this.$callback;
            if (str2.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                attaIdReportData.g(str2);
            }
            intent.putExtra("extra_key_atta_report_id", attaIdReportData);
            intent.putExtra("PARAM_ActivityResultReceiver", new GuildShareForwardReceiver(attaIdReportData, sVar));
            gVar.a(intent);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildActionSheetAttaUtil$generateTotalArkMsgIntentAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
