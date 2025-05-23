package com.tencent.qqnt.msg.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.msg.api.NTOperateUtils$queryMsgForSpecialType$1", f = "NTOperateUtils.kt", i = {}, l = {63, 66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes24.dex */
public final class NTOperateUtils$queryMsgForSpecialType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Contact $contact;
    final /* synthetic */ int $count;
    final /* synthetic */ ArrayList<MsgRecord> $queryData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTOperateUtils$queryMsgForSpecialType$1(Contact contact, int i3, ArrayList<MsgRecord> arrayList, Continuation<? super NTOperateUtils$queryMsgForSpecialType$1> continuation) {
        super(2, continuation);
        this.$contact = contact;
        this.$count = i3;
        this.$queryData = arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contact, Integer.valueOf(i3), arrayList, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new NTOperateUtils$queryMsgForSpecialType$1(this.$contact, this.$count, this.$queryData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxBoolean(this.$queryData.addAll((Collection) ((c) obj).a()));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                NTOperateUtils nTOperateUtils = NTOperateUtils.f359554a;
                Contact contact = this.$contact;
                this.label = 1;
                obj = nTOperateUtils.g(contact, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            long j3 = ((MsgRecord) obj).msgId;
            QLog.i("NTOperateUtils", 4, "queryMsgForSpecialType lastMsgId=" + j3);
            NTOperateUtils nTOperateUtils2 = NTOperateUtils.f359554a;
            Contact contact2 = this.$contact;
            int i16 = this.$count;
            this.label = 2;
            obj = nTOperateUtils2.i(contact2, j3, i16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Boxing.boxBoolean(this.$queryData.addAll((Collection) ((c) obj).a()));
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((NTOperateUtils$queryMsgForSpecialType$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
