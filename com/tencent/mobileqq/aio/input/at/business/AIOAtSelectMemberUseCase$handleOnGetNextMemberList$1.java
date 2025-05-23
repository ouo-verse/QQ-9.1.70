package com.tencent.mobileqq.aio.input.at.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import java.util.ArrayList;
import java.util.HashMap;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.input.at.business.AIOAtSelectMemberUseCase$handleOnGetNextMemberList$1", f = "AIOAtSelectMemberUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class AIOAtSelectMemberUseCase$handleOnGetNextMemberList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $errCode;
    final /* synthetic */ String $errMsg;
    final /* synthetic */ GroupMemberListResult $result;
    int label;
    final /* synthetic */ AIOAtSelectMemberUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOAtSelectMemberUseCase$handleOnGetNextMemberList$1(int i3, String str, AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase, GroupMemberListResult groupMemberListResult, Continuation<? super AIOAtSelectMemberUseCase$handleOnGetNextMemberList$1> continuation) {
        super(2, continuation);
        this.$errCode = i3;
        this.$errMsg = str;
        this.this$0 = aIOAtSelectMemberUseCase;
        this.$result = groupMemberListResult;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, aIOAtSelectMemberUseCase, groupMemberListResult, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOAtSelectMemberUseCase$handleOnGetNextMemberList$1(this.$errCode, this.$errMsg, this.this$0, this.$result, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                QLog.d("AIOAtUseCase", 1, "getNextMemberList callback. errCode = " + this.$errCode + " errMsg = " + this.$errMsg);
                boolean z17 = false;
                this.this$0.mIsPullNextList.set(false);
                if (this.$errCode == 0 && this.$result != null) {
                    this.this$0.mIsEndOfPage.set(this.$result.finish);
                    ArrayList<GroupMemberInfoListId> arrayList = this.$result.ids;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        HashMap<String, MemberInfo> hashMap = this.$result.infos;
                        if (hashMap == null || hashMap.isEmpty()) {
                            z17 = true;
                        }
                        if (z17) {
                            return Unit.INSTANCE;
                        }
                    }
                    AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase = this.this$0;
                    GroupMemberListResult groupMemberListResult = this.$result;
                    synchronized (aIOAtSelectMemberUseCase) {
                        aIOAtSelectMemberUseCase.mIdList.addAll(groupMemberListResult.ids);
                        aIOAtSelectMemberUseCase.mMemberInfoMap.putAll(groupMemberListResult.infos);
                        Unit unit = Unit.INSTANCE;
                    }
                    if (this.this$0.mIsSearchMode.get()) {
                        return Unit.INSTANCE;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    AIOAtSelectMemberUseCase aIOAtSelectMemberUseCase2 = this.this$0;
                    synchronized (aIOAtSelectMemberUseCase2) {
                        Iterator it = aIOAtSelectMemberUseCase2.mIdList.iterator();
                        while (it.hasNext()) {
                            MemberInfo memberInfo = (MemberInfo) aIOAtSelectMemberUseCase2.mMemberInfoMap.get(((GroupMemberInfoListId) it.next()).uid);
                            if (memberInfo != null) {
                                String str = memberInfo.uid;
                                Intrinsics.checkNotNullExpressionValue(str, "memberInfo.uid");
                                arrayList2.add(new o(str, memberInfo));
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    QLog.d("AIOAtUseCase", 1, "getNextMemberList submitList. newItemList size = " + arrayList2.size());
                    this.this$0.l0(arrayList2);
                    return Unit.INSTANCE;
                }
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOAtSelectMemberUseCase$handleOnGetNextMemberList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
