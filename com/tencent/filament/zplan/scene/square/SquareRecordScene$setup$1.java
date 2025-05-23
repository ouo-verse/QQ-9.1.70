package com.tencent.filament.zplan.scene.square;

import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0096@"}, d2 = {"Lorg/json/JSONObject;", "data", "statistic", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/filament/zplan/scene/record/b;", "continuation", "", ColorRingJsPlugin.Method_SetUp}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.square.SquareRecordScene", f = "SquareRecordScene.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {52, 283}, m = ColorRingJsPlugin.Method_SetUp, n = {"this", "statistic", "recordData", "bootStep", "this_$iv", "this", "statistic", "recordData", "playData", "avatarResourceStep", "this_$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes6.dex */
public final class SquareRecordScene$setup$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SquareRecordScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareRecordScene$setup$1(SquareRecordScene squareRecordScene, Continuation continuation) {
        super(continuation);
        this.this$0 = squareRecordScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.M(null, null, this);
    }
}
