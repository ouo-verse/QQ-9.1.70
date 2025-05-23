package com.tencent.mobileqq.aio.input.at.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$mMemberListListener$1$updateAtInteractionDataBusinessLogic$1", f = "AIOAtSelectMemberUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class AIOAtSelectMemberUseCase$mMemberListListener$1$updateAtInteractionDataBusinessLogic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ GroupMemberListChangeInfo $info;
    int label;
    final /* synthetic */ AIOAtSelectMemberUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOAtSelectMemberUseCase$mMemberListListener$1$updateAtInteractionDataBusinessLogic$1(AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase, GroupMemberListChangeInfo groupMemberListChangeInfo, Continuation<? super AIOAtSelectMemberUseCase$mMemberListListener$1$updateAtInteractionDataBusinessLogic$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOAtSelectMemberUseCase;
        this.$info = groupMemberListChangeInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOAtSelectMemberUseCase, groupMemberListChangeInfo, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOAtSelectMemberUseCase$mMemberListListener$1$updateAtInteractionDataBusinessLogic$1(this.this$0, this.$info, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase = this.this$0;
                GroupMemberListChangeInfo groupMemberListChangeInfo = this.$info;
                synchronized (aIOAtSelectMemberUseCase) {
                    aIOAtSelectMemberUseCase.mIdList.clear();
                    aIOAtSelectMemberUseCase.mIdList.addAll(groupMemberListChangeInfo.ids);
                    aIOAtSelectMemberUseCase.mMemberInfoMap.putAll(groupMemberListChangeInfo.infos);
                    Unit unit = Unit.INSTANCE;
                }
                if (this.this$0.mIsSearchMode.get()) {
                    return Unit.INSTANCE;
                }
                ArrayList arrayList = new ArrayList();
                AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase2 = this.this$0;
                synchronized (aIOAtSelectMemberUseCase2) {
                    Iterator it = aIOAtSelectMemberUseCase2.mIdList.iterator();
                    while (it.hasNext()) {
                        MemberInfo memberInfo = (MemberInfo) aIOAtSelectMemberUseCase2.mMemberInfoMap.get(((GroupMemberInfoListId) it.next()).uid);
                        if (memberInfo != null) {
                            String str = memberInfo.uid;
                            Intrinsics.checkNotNullExpressionValue(str, "memberInfo.uid");
                            arrayList.add(new o(str, memberInfo));
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
                this.this$0.l0(arrayList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOAtSelectMemberUseCase$mMemberListListener$1$updateAtInteractionDataBusinessLogic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
