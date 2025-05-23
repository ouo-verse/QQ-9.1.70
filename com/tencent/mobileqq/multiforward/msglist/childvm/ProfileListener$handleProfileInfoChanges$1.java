package com.tencent.mobileqq.multiforward.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.childvm.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.multiforward.msglist.childvm.ProfileListener$handleProfileInfoChanges$1", f = "MultiForwardProfileListVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
final class ProfileListener$handleProfileInfoChanges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ HashMap<String, UserSimpleInfo> $profiles;
    final /* synthetic */ a $vm;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileListener$handleProfileInfoChanges$1(a aVar, HashMap<String, UserSimpleInfo> hashMap, Continuation<? super ProfileListener$handleProfileInfoChanges$1> continuation) {
        super(2, continuation);
        this.$vm = aVar;
        this.$profiles = hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, hashMap, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ProfileListener$handleProfileInfoChanges$1(this.$vm, this.$profiles, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        CoreInfo coreInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                MsgList M = this.$vm.d().m().M();
                HashMap<String, UserSimpleInfo> hashMap = this.$profiles;
                int i3 = 0;
                for (Object obj2 : M) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj2;
                    if (aVar instanceof AIOMsgItem) {
                        AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                        UserSimpleInfo userSimpleInfo = hashMap.get(aIOMsgItem.getMsgRecord().senderUid);
                        if (userSimpleInfo != null && (coreInfo = userSimpleInfo.coreInfo) != null) {
                            str = coreInfo.nick;
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            AIOMsgItem cloneNewInstance = aIOMsgItem.cloneNewInstance();
                            cloneNewInstance.A1(str);
                            M.set(i3, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                            booleanRef.element = true;
                        }
                    }
                    i3 = i16;
                }
                if (booleanRef.element) {
                    e.a(this.$vm, M, "multi_forward_profile");
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ProfileListener$handleProfileInfoChanges$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
