package com.tencent.mobileqq.wink.editor.openingending;

import android.os.SystemClock;
import com.tencent.mobileqq.wink.aigc.utils.WinkAIGCService;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingViewModel$generateAigcImage$1", f = "WinkEditorOpeningEndingViewModel.kt", i = {0, 1, 1}, l = {434, 441}, m = "invokeSuspend", n = {"startTime", "aigcImagePath", "startTime"}, s = {"J$0", "L$0", "J$0"})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingViewModel$generateAigcImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Boolean, String, String, Long, Unit> $finishedCallback;
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ String $safeId;
    final /* synthetic */ String $styleId;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ WinkEditorOpeningEndingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkEditorOpeningEndingViewModel$generateAigcImage$1(WinkEditorOpeningEndingViewModel winkEditorOpeningEndingViewModel, String str, String str2, String str3, Function4<? super Boolean, ? super String, ? super String, ? super Long, Unit> function4, Continuation<? super WinkEditorOpeningEndingViewModel$generateAigcImage$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorOpeningEndingViewModel;
        this.$imageUrl = str;
        this.$styleId = str2;
        this.$safeId = str3;
        this.$finishedCallback = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorOpeningEndingViewModel$generateAigcImage$1(this.this$0, this.$imageUrl, this.$styleId, this.$safeId, this.$finishedCallback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x009c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long elapsedRealtime;
        Object d16;
        long j3;
        String k26;
        Object f16;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    long j16 = this.J$0;
                    str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    j3 = j16;
                    f16 = obj;
                    if (((Boolean) f16).booleanValue()) {
                        this.$finishedCallback.invoke(Boxing.boxBoolean(false), "", "", Boxing.boxLong(0L));
                        return Unit.INSTANCE;
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - j3;
                    this.$finishedCallback.invoke(Boxing.boxBoolean(true), "", str, Boxing.boxLong(elapsedRealtime2));
                    w53.b.f("WinkEditorOpeningEndingViewModel", "generateAigcImage total costtime: " + elapsedRealtime2);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            elapsedRealtime = this.J$0;
            ResultKt.throwOnFailure(obj);
            d16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            elapsedRealtime = SystemClock.elapsedRealtime();
            WinkAIGCService l26 = this.this$0.l2();
            String str2 = this.$imageUrl;
            String str3 = this.$styleId;
            String str4 = this.$safeId;
            this.J$0 = elapsedRealtime;
            this.label = 1;
            d16 = l26.d(str2, str3, str4, this);
            if (d16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        j3 = elapsedRealtime;
        String str5 = (String) d16;
        if (str5 != null) {
            k26 = this.this$0.k2(str5);
            WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
            Intrinsics.checkNotNullExpressionValue(a16, "getInstance()");
            this.L$0 = k26;
            this.J$0 = j3;
            this.label = 2;
            f16 = com.tencent.mobileqq.wink.edit.manager.ak.f(a16, str5, k26, null, this, 4, null);
            if (f16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = k26;
            if (((Boolean) f16).booleanValue()) {
            }
        } else {
            this.$finishedCallback.invoke(Boxing.boxBoolean(false), "", "", Boxing.boxLong(0L));
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorOpeningEndingViewModel$generateAigcImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
