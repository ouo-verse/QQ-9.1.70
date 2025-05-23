package com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureGenerator;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
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
import x12.n;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureGenerator$startGenerate$2", f = "GuildLongFeedPictureGenerator.kt", i = {0, 0}, l = {72}, m = "invokeSuspend", n = {"binding", "feedViewContainer"}, s = {"L$0", "L$1"})
/* loaded from: classes13.dex */
public final class GuildLongFeedPictureGenerator$startGenerate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuildContextWrapper $guildContext;
    final /* synthetic */ Function3<Boolean, View, Bitmap, Unit> $onResult;
    final /* synthetic */ GuildLongFeedPictureGenerator.GeneratorParam $param;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildLongFeedPictureGenerator$startGenerate$2(GuildContextWrapper guildContextWrapper, GuildLongFeedPictureGenerator.GeneratorParam generatorParam, Function3<? super Boolean, ? super View, ? super Bitmap, Unit> function3, Continuation<? super GuildLongFeedPictureGenerator$startGenerate$2> continuation) {
        super(2, continuation);
        this.$guildContext = guildContextWrapper;
        this.$param = generatorParam;
        this.$onResult = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildLongFeedPictureGenerator$startGenerate$2(this.$guildContext, this.$param, this.$onResult, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        n g16;
        TextViewContainer textViewContainer;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                textViewContainer = (TextViewContainer) this.L$1;
                g16 = (n) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            g16 = n.g(LayoutInflater.from(this.$guildContext));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(guildContext))");
            GuildLongFeedPictureGenerator guildLongFeedPictureGenerator = GuildLongFeedPictureGenerator.f220341a;
            guildLongFeedPictureGenerator.i(g16, this.$param);
            GuildLongFeedPictureViewHelper guildLongFeedPictureViewHelper = GuildLongFeedPictureViewHelper.f220347a;
            TextViewContainer d16 = guildLongFeedPictureViewHelper.d(g16);
            guildLongFeedPictureViewHelper.b(d16, this.$param);
            d16.q().run();
            guildLongFeedPictureGenerator.h(g16, this.$param);
            guildLongFeedPictureGenerator.g(g16, this.$param);
            guildLongFeedPictureGenerator.k(g16, this.$param);
            GuildLongFeedPictureGenerator.GeneratorParam generatorParam = this.$param;
            this.L$0 = g16;
            this.L$1 = d16;
            this.label = 1;
            obj = guildLongFeedPictureGenerator.o(g16, generatorParam, d16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            textViewContainer = d16;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c.c(g16);
        FrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Bitmap a16 = c.a(root);
        textViewContainer.v();
        this.$onResult.invoke(Boxing.boxBoolean(booleanValue), g16.getRoot(), a16);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildLongFeedPictureGenerator$startGenerate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
