package com.tencent.qqnt.aio.locate;

import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.locate.MsgLocation$suspendGetDisplayName$2", f = "MsgLocation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MsgLocation$suspendGetDisplayName$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $troopUin;
    final /* synthetic */ int $type;
    final /* synthetic */ String $uin;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgLocation$suspendGetDisplayName$2(String str, String str2, int i3, Continuation<? super MsgLocation$suspendGetDisplayName$2> continuation) {
        super(2, continuation);
        this.$uin = str;
        this.$troopUin = str2;
        this.$type = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MsgLocation$suspendGetDisplayName$2(this.$uin, this.$troopUin, this.$type, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String displayNameInPeak;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.d(MsgLocation.TAG, 1, "suspendGetDisplayName running");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                displayNameInPeak = ac.s((QQAppInterface) peekAppRuntime, this.$uin, this.$troopUin, ac.w(this.$type), 3);
            } else if (peekAppRuntime instanceof ToolRuntimePeak) {
                displayNameInPeak = MsgLocation.INSTANCE.getDisplayNameInPeak(this.$type, this.$uin, this.$troopUin);
            } else {
                throw new RuntimeException("Unsupported operation in " + MobileQQ.processName + " process!!!");
            }
            return displayNameInPeak == null ? this.$uin : displayNameInPeak;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((MsgLocation$suspendGetDisplayName$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
