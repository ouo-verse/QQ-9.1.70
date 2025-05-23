package com.tencent.qqnt.aio.robot.screenshot;

import android.app.Activity;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.robot.screenshot.LongShotManagerForRobot$showPreviewShareActionSheetForRobot$1", f = "LongShotManagerForRobot.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class LongShotManagerForRobot$showPreviewShareActionSheetForRobot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ com.tencent.qqnt.aio.adapter.api.c $exit;
    final /* synthetic */ boolean $exitOnDismiss;
    final /* synthetic */ String $path;
    final /* synthetic */ String $subBusiness;
    int label;
    final /* synthetic */ LongShotManagerForRobot this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongShotManagerForRobot$showPreviewShareActionSheetForRobot$1(LongShotManagerForRobot longShotManagerForRobot, String str, Activity activity, boolean z16, com.tencent.qqnt.aio.adapter.api.c cVar, String str2, Continuation<? super LongShotManagerForRobot$showPreviewShareActionSheetForRobot$1> continuation) {
        super(2, continuation);
        this.this$0 = longShotManagerForRobot;
        this.$path = str;
        this.$activity = activity;
        this.$exitOnDismiss = z16;
        this.$exit = cVar;
        this.$subBusiness = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongShotManagerForRobot$showPreviewShareActionSheetForRobot$1(this.this$0, this.$path, this.$activity, this.$exitOnDismiss, this.$exit, this.$subBusiness, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            LongShotManagerForRobot longShotManagerForRobot = this.this$0;
            String str = this.$path;
            this.label = 1;
            obj = longShotManagerForRobot.n(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            this.this$0.h(this.$activity, bitmap, this.$path, this.$exitOnDismiss, this.$exit, this.$subBusiness);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LongShotManagerForRobot$showPreviewShareActionSheetForRobot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
