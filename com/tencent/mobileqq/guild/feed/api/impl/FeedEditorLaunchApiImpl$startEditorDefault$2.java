package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchOptionModel;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchSourceModel;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$startEditorDefault$2", f = "FeedEditorLaunchApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$startEditorDefault$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.data.s $contact;
    final /* synthetic */ Context $context;
    final /* synthetic */ FeedEditorLaunchOptionModel $option;
    final /* synthetic */ FeedEditorLaunchSourceModel $source;
    final /* synthetic */ com.tencent.mobileqq.guild.feed.api.d $startProcedureAware;
    int label;
    final /* synthetic */ FeedEditorLaunchApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorLaunchApiImpl$startEditorDefault$2(com.tencent.mobileqq.guild.feed.api.d dVar, FeedEditorLaunchApiImpl feedEditorLaunchApiImpl, Context context, com.tencent.mobileqq.guild.data.s sVar, FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, FeedEditorLaunchSourceModel feedEditorLaunchSourceModel, Continuation<? super FeedEditorLaunchApiImpl$startEditorDefault$2> continuation) {
        super(2, continuation);
        this.$startProcedureAware = dVar;
        this.this$0 = feedEditorLaunchApiImpl;
        this.$context = context;
        this.$contact = sVar;
        this.$option = feedEditorLaunchOptionModel;
        this.$source = feedEditorLaunchSourceModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorLaunchApiImpl$startEditorDefault$2(this.$startProcedureAware, this.this$0, this.$context, this.$contact, this.$option, this.$source, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.mobileqq.guild.feed.api.d dVar = this.$startProcedureAware;
            if (dVar != null) {
                dVar.b();
            }
            this.this$0.C(this.$context, 1, this.$contact, this.$option, this.$source);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorLaunchApiImpl$startEditorDefault$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
