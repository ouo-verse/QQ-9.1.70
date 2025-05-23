package com.tencent.mobileqq.guild.discoveryv2.share.picture;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.quiprofile.GuildContextWrapper;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.dj;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator$startGenerate$2", f = "GuildSearchLLMChatPictureGenerator.kt", i = {0, 1}, l = {60, 61}, m = "invokeSuspend", n = {"binding", "binding"}, s = {"L$0", "L$0"})
/* loaded from: classes13.dex */
public final class GuildSearchLLMChatPictureGenerator$startGenerate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuildContextWrapper $guildContext;
    final /* synthetic */ Function3<Boolean, View, Bitmap, Unit> $onResult;
    final /* synthetic */ GuildSearchLLMChatPictureGenerator.GeneratorParam $param;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildSearchLLMChatPictureGenerator$startGenerate$2(GuildContextWrapper guildContextWrapper, GuildSearchLLMChatPictureGenerator.GeneratorParam generatorParam, Function3<? super Boolean, ? super View, ? super Bitmap, Unit> function3, Continuation<? super GuildSearchLLMChatPictureGenerator$startGenerate$2> continuation) {
        super(2, continuation);
        this.$guildContext = guildContextWrapper;
        this.$param = generatorParam;
        this.$onResult = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildSearchLLMChatPictureGenerator$startGenerate$2(this.$guildContext, this.$param, this.$onResult, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        dj g16;
        Object h16;
        Object m3;
        dj djVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    djVar = (dj) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    GuildSearchLLMChatPictureGenerator.f217767a.i(djVar, this.$param);
                    FrameLayout root = djVar.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    c.e(root);
                    FrameLayout root2 = djVar.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                    c.a(root2);
                    this.$onResult.invoke(Boxing.boxBoolean(booleanValue), djVar.getRoot(), c.b(djVar));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dj djVar2 = (dj) this.L$0;
            ResultKt.throwOnFailure(obj);
            g16 = djVar2;
        } else {
            ResultKt.throwOnFailure(obj);
            g16 = dj.g(LayoutInflater.from(this.$guildContext));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(guildContext))");
            GuildSearchLLMChatPictureGenerator guildSearchLLMChatPictureGenerator = GuildSearchLLMChatPictureGenerator.f217767a;
            guildSearchLLMChatPictureGenerator.f(g16, this.$param);
            FrameLayout root3 = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            c.e(root3);
            GuildSearchLLMChatPictureGenerator.GeneratorParam generatorParam = this.$param;
            this.L$0 = g16;
            this.label = 1;
            h16 = guildSearchLLMChatPictureGenerator.h(g16, generatorParam, this);
            if (h16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildSearchLLMChatPictureGenerator guildSearchLLMChatPictureGenerator2 = GuildSearchLLMChatPictureGenerator.f217767a;
        GuildSearchLLMChatPictureGenerator.GeneratorParam generatorParam2 = this.$param;
        this.L$0 = g16;
        this.label = 2;
        m3 = guildSearchLLMChatPictureGenerator2.m(g16, generatorParam2, this);
        if (m3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        djVar = g16;
        obj = m3;
        boolean booleanValue2 = ((Boolean) obj).booleanValue();
        GuildSearchLLMChatPictureGenerator.f217767a.i(djVar, this.$param);
        FrameLayout root4 = djVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "binding.root");
        c.e(root4);
        FrameLayout root22 = djVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root22, "binding.root");
        c.a(root22);
        this.$onResult.invoke(Boxing.boxBoolean(booleanValue2), djVar.getRoot(), c.b(djVar));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildSearchLLMChatPictureGenerator$startGenerate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
