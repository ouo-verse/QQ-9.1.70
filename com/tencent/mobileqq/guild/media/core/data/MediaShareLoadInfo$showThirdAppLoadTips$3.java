package com.tencent.mobileqq.guild.media.core.data;

import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.data.MediaShareLoadInfo$showThirdAppLoadTips$3", f = "MediaShareLoadInfo.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaShareLoadInfo$showThirdAppLoadTips$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Boolean, Boolean, String, Unit> $callback;
    int label;
    final /* synthetic */ MediaShareLoadInfo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MediaShareLoadInfo$showThirdAppLoadTips$3(MediaShareLoadInfo mediaShareLoadInfo, Function3<? super Boolean, ? super Boolean, ? super String, Unit> function3, Continuation<? super MediaShareLoadInfo$showThirdAppLoadTips$3> continuation) {
        super(2, continuation);
        this.this$0 = mediaShareLoadInfo;
        this.$callback = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaShareLoadInfo$showThirdAppLoadTips$3(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean h16;
        boolean z16;
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
            GuildMediaUtils guildMediaUtils = GuildMediaUtils.f227771a;
            String d16 = com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c());
            String b16 = com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c());
            this.label = 1;
            obj = guildMediaUtils.p(d16, b16, 102, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        h16 = this.this$0.h();
        int n3 = com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c());
        if (n3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.f235387a.d().d("QGMC.MediaShareLoadInfo", 1, "[showThirdAppLoadTips] defaultChatMode " + z16 + ", currentTheme " + n3 + ", hasOthersInRoom " + h16 + ", hasActivityPermission " + booleanValue);
        if (z16) {
            if (h16) {
                if (booleanValue) {
                    this.$callback.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(false), this.this$0.c() + " \u5df2\u5173\u95ed\uff0c\u6253\u58f0\u62db\u547c\u540e\u53bb\u53d1\u8d77");
                } else {
                    this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(true), this.this$0.c() + " \u5df2\u88ab\u5173\u95ed");
                }
                return Unit.INSTANCE;
            }
            if (booleanValue) {
                this.$callback.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(false), this.this$0.c() + " \u5df2\u5173\u95ed\uff0c\u53d1\u8d77\u540e\u53ef\u53c2\u4e0e");
            } else {
                this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(true), this.this$0.c() + " \u5df2\u88ab\u5173\u95ed");
            }
            return Unit.INSTANCE;
        }
        if (h16) {
            this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(true), this.this$0.c() + " \u5df2\u88ab\u5173\u95ed");
            return Unit.INSTANCE;
        }
        if (booleanValue) {
            this.$callback.invoke(Boxing.boxBoolean(true), Boxing.boxBoolean(false), this.this$0.c() + " \u5df2\u5173\u95ed\uff0c\u53d1\u8d77\u540e\u53ef\u53c2\u4e0e");
        } else {
            this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(true), this.this$0.c() + " \u5df2\u88ab\u5173\u95ed");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaShareLoadInfo$showThirdAppLoadTips$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
