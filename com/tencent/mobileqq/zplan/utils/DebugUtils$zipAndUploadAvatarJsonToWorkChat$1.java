package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.zplan.utils.DebugUtils;
import java.io.File;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.utils.DebugUtils$zipAndUploadAvatarJsonToWorkChat$1", f = "DebugUtils.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class DebugUtils$zipAndUploadAvatarJsonToWorkChat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $avatarString;
    final /* synthetic */ String $cacheDirPath;
    final /* synthetic */ DebugUtils.a $fileUploadCallback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugUtils$zipAndUploadAvatarJsonToWorkChat$1(String str, String str2, DebugUtils.a aVar, Continuation<? super DebugUtils$zipAndUploadAvatarJsonToWorkChat$1> continuation) {
        super(2, continuation);
        this.$cacheDirPath = str;
        this.$avatarString = str2;
        this.$fileUploadCallback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugUtils$zipAndUploadAvatarJsonToWorkChat$1(this.$cacheDirPath, this.$avatarString, this.$fileUploadCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            DebugUtils debugUtils = DebugUtils.f335718a;
            String str = this.$cacheDirPath;
            String str2 = this.$avatarString;
            this.label = 1;
            obj = debugUtils.h(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str3 = (String) obj;
        File file = str3 != null ? new File(str3) : null;
        if (file != null) {
            DebugUtils.f335718a.e("21218ba7-97be-42b3-980f-22fd7ed9d812", file, this.$fileUploadCallback);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugUtils$zipAndUploadAvatarJsonToWorkChat$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
