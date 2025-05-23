package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.core.CommonRsp;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.AppAuthResult;
import com.tencent.mobileqq.mini.servlet.MiniAppObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper$startThirdApp$1", f = "MediaChannelThirdAppHelper.kt", i = {}, l = {MiniAppObserver.MINI_APP_BATCH_GET_GAME_FOLLOW_COUNT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaChannelThirdAppHelper$startThirdApp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppAuthResult $appAuthResult;
    final /* synthetic */ String $appId;
    final /* synthetic */ int $lastThemeType;
    final /* synthetic */ com.tencent.mobileqq.guild.media.core.n $mediaDataModel;
    int label;
    final /* synthetic */ MediaChannelThirdAppHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChannelThirdAppHelper$startThirdApp$1(MediaChannelThirdAppHelper mediaChannelThirdAppHelper, String str, AppAuthResult appAuthResult, com.tencent.mobileqq.guild.media.core.n nVar, int i3, Continuation<? super MediaChannelThirdAppHelper$startThirdApp$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaChannelThirdAppHelper;
        this.$appId = str;
        this.$appAuthResult = appAuthResult;
        this.$mediaDataModel = nVar;
        this.$lastThemeType = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelThirdAppHelper$startThirdApp$1(this.this$0, this.$appId, this.$appAuthResult, this.$mediaDataModel, this.$lastThemeType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Integer value;
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
            MediaChannelThirdAppHelper mediaChannelThirdAppHelper = this.this$0;
            String str = this.$appId;
            int capacity = this.$appAuthResult.getAppInfo().getCapacity();
            this.label = 1;
            obj = MediaChannelThirdAppHelper.v2(mediaChannelThirdAppHelper, str, capacity, 0, this, 4, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (!((CommonRsp) obj).c() && (value = this.$mediaDataModel.M().getValue()) != null && value.intValue() == 6) {
            com.tencent.mobileqq.guild.media.core.notify.p eventBus = this.this$0.mediaChannelCore.getEventBus();
            Integer value2 = this.$mediaDataModel.M().getValue();
            Intrinsics.checkNotNull(value2);
            eventBus.i(new SwitchThemeEvent(value2.intValue(), this.$lastThemeType));
            this.$mediaDataModel.M().setValue(Boxing.boxInt(this.$lastThemeType));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelThirdAppHelper$startThirdApp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
