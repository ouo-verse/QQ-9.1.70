package com.tencent.mobileqq.guild.discoveryv2.share.oldpicture;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.guild.discoveryv2.share.oldpicture.GuildSearchLLMChatPictureOldGenerator;
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
import vp1.dk;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.share.oldpicture.GuildSearchLLMChatPictureOldGenerator$startGenerate$2", f = "GuildSearchLLMChatPictureOldGenerator.kt", i = {0, 1, 1}, l = {50, 52}, m = "invokeSuspend", n = {"binding", "binding", "isAllAsyncResourcesOk"}, s = {"L$0", "L$0", "Z$0"})
/* loaded from: classes13.dex */
public final class GuildSearchLLMChatPictureOldGenerator$startGenerate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuildContextWrapper $guildContext;
    final /* synthetic */ Function3<Boolean, View, Bitmap, Unit> $onResult;
    final /* synthetic */ GuildSearchLLMChatPictureOldGenerator.GeneratorParam $param;
    Object L$0;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildSearchLLMChatPictureOldGenerator$startGenerate$2(GuildContextWrapper guildContextWrapper, GuildSearchLLMChatPictureOldGenerator.GeneratorParam generatorParam, Function3<? super Boolean, ? super View, ? super Bitmap, Unit> function3, Continuation<? super GuildSearchLLMChatPictureOldGenerator$startGenerate$2> continuation) {
        super(2, continuation);
        this.$guildContext = guildContextWrapper;
        this.$param = generatorParam;
        this.$onResult = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildSearchLLMChatPictureOldGenerator$startGenerate$2(this.$guildContext, this.$param, this.$onResult, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object g16;
        dk dkVar;
        Object d16;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    z16 = this.Z$0;
                    dkVar = (dk) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    FrameLayout root = dkVar.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    a.e(root);
                    this.$onResult.invoke(Boxing.boxBoolean(z16), dkVar.getRoot(), a.b(dkVar));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dkVar = (dk) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            dk g17 = dk.g(LayoutInflater.from(this.$guildContext));
            Intrinsics.checkNotNullExpressionValue(g17, "inflate(LayoutInflater.from(guildContext))");
            GuildSearchLLMChatPictureOldGenerator guildSearchLLMChatPictureOldGenerator = GuildSearchLLMChatPictureOldGenerator.f217750a;
            guildSearchLLMChatPictureOldGenerator.e(g17, this.$param);
            GuildSearchLLMChatPictureOldGenerator.GeneratorParam generatorParam = this.$param;
            this.L$0 = g17;
            this.label = 1;
            g16 = guildSearchLLMChatPictureOldGenerator.g(g17, generatorParam, this);
            if (g16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            dkVar = g17;
            obj = g16;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        FrameLayout root2 = dkVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        a.e(root2);
        GuildSearchLLMChatPictureOldGenerator guildSearchLLMChatPictureOldGenerator2 = GuildSearchLLMChatPictureOldGenerator.f217750a;
        GuildSearchLLMChatPictureOldGenerator.GeneratorParam generatorParam2 = this.$param;
        this.L$0 = dkVar;
        this.Z$0 = booleanValue;
        this.label = 2;
        d16 = guildSearchLLMChatPictureOldGenerator2.d(dkVar, generatorParam2, this);
        if (d16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        z16 = booleanValue;
        FrameLayout root3 = dkVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
        a.e(root3);
        this.$onResult.invoke(Boxing.boxBoolean(z16), dkVar.getRoot(), a.b(dkVar));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildSearchLLMChatPictureOldGenerator$startGenerate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
