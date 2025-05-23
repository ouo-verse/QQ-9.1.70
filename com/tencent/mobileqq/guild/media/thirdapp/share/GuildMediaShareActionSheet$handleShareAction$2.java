package com.tencent.mobileqq.guild.media.thirdapp.share;

import android.app.Dialog;
import com.tencent.mobileqq.guild.media.thirdapp.share.GuildMediaShareActionSheet;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.Logger;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.thirdapp.share.GuildMediaShareActionSheet$handleShareAction$2", f = "GuildMediaShareActionSheet.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildMediaShareActionSheet$handleShareAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $action;
    final /* synthetic */ Integer $actionType;
    int label;
    final /* synthetic */ GuildMediaShareActionSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaShareActionSheet$handleShareAction$2(GuildMediaShareActionSheet guildMediaShareActionSheet, Integer num, int i3, Continuation<? super GuildMediaShareActionSheet$handleShareAction$2> continuation) {
        super(2, continuation);
        this.this$0 = guildMediaShareActionSheet;
        this.$actionType = num;
        this.$action = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaShareActionSheet$handleShareAction$2(this.this$0, this.$actionType, this.$action, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        boolean U;
        Dialog dialog;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildMediaShareActionSheet guildMediaShareActionSheet = this.this$0;
            Integer num = this.$actionType;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            this.label = 1;
            obj = guildMediaShareActionSheet.Q(i3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildMediaShareActionSheet.FetchShortUrlRsp fetchShortUrlRsp = (GuildMediaShareActionSheet.FetchShortUrlRsp) obj;
        U = this.this$0.U();
        if (!U) {
            dialog = this.this$0.shareDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            Logger.a d16 = Logger.f235387a.d();
            int code = fetchShortUrlRsp.getCode();
            b.c fetchInfo = fetchShortUrlRsp.getFetchInfo();
            if (fetchInfo != null) {
                str = fetchInfo.f235319a;
            } else {
                str = null;
            }
            d16.d("GuildMediaShareActionSheet", 1, "[requestNewShortUrl] code: " + code + " url: " + str);
            if (fetchShortUrlRsp.getCode() == 0 && fetchShortUrlRsp.getFetchInfo() != null) {
                ((m) this.this$0).f235059n = fetchShortUrlRsp.getFetchInfo();
                ((m) this.this$0).f235060o = true;
                this.this$0.R(true);
                super/*com.tencent.mobileqq.guild.share.m*/.m(this.$action);
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaShareActionSheet$handleShareAction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
