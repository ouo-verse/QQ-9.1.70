package com.tencent.mobileqq.guild.homev2.parts.title;

import android.graphics.Rect;
import com.tencent.mobileqq.guild.homev2.parts.title.view.GuildHomeV2TitleLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitlePart$initData$4", f = "GuildHomeV2TitlePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeV2TitlePart$initData$4 extends SuspendLambda implements Function2<Rect, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildHomeV2TitlePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeV2TitlePart$initData$4(GuildHomeV2TitlePart guildHomeV2TitlePart, Continuation<? super GuildHomeV2TitlePart$initData$4> continuation) {
        super(2, continuation);
        this.this$0 = guildHomeV2TitlePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildHomeV2TitlePart$initData$4 guildHomeV2TitlePart$initData$4 = new GuildHomeV2TitlePart$initData$4(this.this$0, continuation);
        guildHomeV2TitlePart$initData$4.L$0 = obj;
        return guildHomeV2TitlePart$initData$4;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull Rect rect, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeV2TitlePart$initData$4) create(rect, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        GuildHomeV2TitleLayout guildHomeV2TitleLayout;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Rect rect = (Rect) this.L$0;
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitlePart", 1, "initData flowSystemInsets rect:" + rect);
            }
            guildHomeV2TitleLayout = this.this$0.mTitleLayout;
            if (guildHomeV2TitleLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
                guildHomeV2TitleLayout = null;
            }
            guildHomeV2TitleLayout.o(rect.top);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
