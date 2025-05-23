package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.luggage.wxa.nf.f;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "errorCode", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$makeProcessControlCallback$1", f = "FeedEditorLaunchApiImpl.kt", i = {}, l = {341, f.b.CTRL_INDEX, 355, 362}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$makeProcessControlCallback$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.feed.api.c $checkItemListener;
    final /* synthetic */ RichContentJsonPreProcessor.ProcessOption $processOption;
    /* synthetic */ int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorLaunchApiImpl$makeProcessControlCallback$1(com.tencent.mobileqq.guild.feed.api.c cVar, RichContentJsonPreProcessor.ProcessOption processOption, Continuation<? super FeedEditorLaunchApiImpl$makeProcessControlCallback$1> continuation) {
        super(2, continuation);
        this.$checkItemListener = cVar;
        this.$processOption = processOption;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedEditorLaunchApiImpl$makeProcessControlCallback$1 feedEditorLaunchApiImpl$makeProcessControlCallback$1 = new FeedEditorLaunchApiImpl$makeProcessControlCallback$1(this.$checkItemListener, this.$processOption, continuation);
        feedEditorLaunchApiImpl$makeProcessControlCallback$1.I$0 = ((Number) obj).intValue();
        return feedEditorLaunchApiImpl$makeProcessControlCallback$1;
    }

    @Nullable
    public final Object invoke(int i3, @Nullable Continuation<? super Boolean> continuation) {
        return ((FeedEditorLaunchApiImpl$makeProcessControlCallback$1) create(Integer.valueOf(i3), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            ResultKt.throwOnFailure(obj);
                            z16 = ((Boolean) obj).booleanValue();
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        z16 = ((Boolean) obj).booleanValue();
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    z16 = ((Boolean) obj).booleanValue();
                }
            } else {
                ResultKt.throwOnFailure(obj);
                z16 = ((Boolean) obj).booleanValue();
            }
        } else {
            ResultKt.throwOnFailure(obj);
            int i16 = this.I$0;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            z16 = false;
                        } else {
                            com.tencent.mobileqq.guild.feed.api.c cVar = this.$checkItemListener;
                            FeedEditorCheckItemResult feedEditorCheckItemResult = new FeedEditorCheckItemResult(4, Boxing.boxInt(this.$processOption.getOutMediaCheckResultCode()));
                            this.label = 4;
                            obj = cVar.a(feedEditorCheckItemResult, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z16 = ((Boolean) obj).booleanValue();
                        }
                    } else {
                        com.tencent.mobileqq.guild.feed.api.c cVar2 = this.$checkItemListener;
                        FeedEditorCheckItemResult feedEditorCheckItemResult2 = new FeedEditorCheckItemResult(6, null);
                        this.label = 3;
                        obj = cVar2.a(feedEditorCheckItemResult2, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z16 = ((Boolean) obj).booleanValue();
                    }
                } else {
                    com.tencent.mobileqq.guild.feed.api.c cVar3 = this.$checkItemListener;
                    FeedEditorCheckItemResult feedEditorCheckItemResult3 = new FeedEditorCheckItemResult(2, null);
                    this.label = 1;
                    obj = cVar3.a(feedEditorCheckItemResult3, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z16 = ((Boolean) obj).booleanValue();
                }
            } else {
                com.tencent.mobileqq.guild.feed.api.c cVar4 = this.$checkItemListener;
                FeedEditorCheckItemResult feedEditorCheckItemResult4 = new FeedEditorCheckItemResult(5, null);
                this.label = 2;
                obj = cVar4.a(feedEditorCheckItemResult4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z16 = ((Boolean) obj).booleanValue();
            }
        }
        return Boxing.boxBoolean(z16);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Boolean> continuation) {
        return invoke(num.intValue(), continuation);
    }
}
