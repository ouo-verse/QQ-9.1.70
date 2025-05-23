package com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard;

import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.AIOInlineKeyboardPermissionChecker$evaluateAdminPermission$1", f = "AIOInlineKeyboardPermissionChecker.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOInlineKeyboardPermissionChecker$evaluateAdminPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a $btnModel;
    final /* synthetic */ com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b $ctx;
    final /* synthetic */ long $groupCode;
    final /* synthetic */ Function0<Unit> $onPermissionDenied;
    final /* synthetic */ Function0<Unit> $onPermissionGranted;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AIOInlineKeyboardPermissionChecker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOInlineKeyboardPermissionChecker$evaluateAdminPermission$1(AIOInlineKeyboardPermissionChecker aIOInlineKeyboardPermissionChecker, com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b bVar, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar, long j3, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super AIOInlineKeyboardPermissionChecker$evaluateAdminPermission$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOInlineKeyboardPermissionChecker;
        this.$ctx = bVar;
        this.$btnModel = aVar;
        this.$groupCode = j3;
        this.$onPermissionGranted = function0;
        this.$onPermissionDenied = function02;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOInlineKeyboardPermissionChecker, bVar, aVar, Long.valueOf(j3), function0, function02, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOInlineKeyboardPermissionChecker$evaluateAdminPermission$1(this.this$0, this.$ctx, this.$btnModel, this.$groupCode, this.$onPermissionGranted, this.$onPermissionDenied, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AIOInlineKeyboardPermissionChecker aIOInlineKeyboardPermissionChecker;
        com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b bVar;
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar;
        boolean z16;
        MemberRole memberRole;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar2 = (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a) this.L$2;
                    bVar = (com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b) this.L$1;
                    aIOInlineKeyboardPermissionChecker = (AIOInlineKeyboardPermissionChecker) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    aVar = aVar2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                aIOInlineKeyboardPermissionChecker = this.this$0;
                bVar = this.$ctx;
                com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar3 = this.$btnModel;
                AIOUtil aIOUtil = AIOUtil.f194084a;
                long j3 = this.$groupCode;
                this.L$0 = aIOInlineKeyboardPermissionChecker;
                this.L$1 = bVar;
                this.L$2 = aVar3;
                this.label = 1;
                Object j16 = AIOUtil.j(aIOUtil, j3, false, this, 2, null);
                if (j16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar = aVar3;
                obj = j16;
            }
            com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b bVar2 = bVar;
            GroupDetailInfo groupDetailInfo = (GroupDetailInfo) obj;
            if (groupDetailInfo != null && (memberRole = groupDetailInfo.cmdUinPrivilege) != null && AIOUtil.f194084a.v(memberRole)) {
                z16 = true;
            } else {
                z16 = false;
            }
            aIOInlineKeyboardPermissionChecker.e(bVar2, aVar, z16, this.$onPermissionGranted, this.$onPermissionDenied);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOInlineKeyboardPermissionChecker$evaluateAdminPermission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
