package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProConvertThirdIdRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper$getOpenId$2", f = "MediaChannelThirdAppHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaChannelThirdAppHelper$getOpenId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    int label;
    final /* synthetic */ MediaChannelThirdAppHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MediaChannelThirdAppHelper$getOpenId$2(MediaChannelThirdAppHelper mediaChannelThirdAppHelper, Function1<? super String, Unit> function1, Continuation<? super MediaChannelThirdAppHelper$getOpenId$2> continuation) {
        super(2, continuation);
        this.this$0 = mediaChannelThirdAppHelper;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
    
        if (r6 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(Function1 function1, int i3, String str, IGProConvertThirdIdRsp iGProConvertThirdIdRsp) {
        String str2;
        ArrayList<String> ids;
        Object firstOrNull;
        if (iGProConvertThirdIdRsp != null && (ids = iGProConvertThirdIdRsp.getIds()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ids);
            str2 = (String) firstOrNull;
        }
        str2 = "";
        Logger.f235387a.d().d("QGMC.MediaThirdApp.MediaChannelThirdAppHelper", 1, "[getOpenId] result " + i3 + " errMsg " + str + ", openId " + str2);
        function1.invoke(str2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelThirdAppHelper$getOpenId$2(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList<String> arrayListOf;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IGPSService iGPSService = (IGPSService) com.tencent.mobileqq.guild.util.ch.S0(IGPSService.class, "");
            String str = this.this$0.mediaChannelCore.getSelfUserInfo().f228093a;
            com.tencent.mobileqq.qqguildsdk.data.genc.ab abVar = new com.tencent.mobileqq.qqguildsdk.data.genc.ab();
            abVar.f(2);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
            abVar.e(arrayListOf);
            final Function1<String, Unit> function1 = this.$callback;
            iGPSService.convertGuildAndThirdIds(abVar, new wh2.n() { // from class: com.tencent.mobileqq.guild.media.core.logic.bw
                @Override // wh2.n
                public final void a(int i3, String str2, IGProConvertThirdIdRsp iGProConvertThirdIdRsp) {
                    MediaChannelThirdAppHelper$getOpenId$2.b(Function1.this, i3, str2, iGProConvertThirdIdRsp);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelThirdAppHelper$getOpenId$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
