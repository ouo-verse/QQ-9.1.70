package com.tencent.qqnt.chathistory.ui.troopMember;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment;
import com.tencent.qqnt.chathistory.ui.troopMember.viewmodel.ChatHistoryTroopMemberViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.troopMember.TroopMemberFragment$onViewCreated$groupMemberFragment$1$1$invoke$1", f = "TroopMemberFragment.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
final class TroopMemberFragment$onViewCreated$groupMemberFragment$1$1$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Object[] $args;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TroopMemberFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberFragment$onViewCreated$groupMemberFragment$1$1$invoke$1(Object[] objArr, TroopMemberFragment troopMemberFragment, Continuation<? super TroopMemberFragment$onViewCreated$groupMemberFragment$1$1$invoke$1> continuation) {
        super(2, continuation);
        this.$args = objArr;
        this.this$0 = troopMemberFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, objArr, troopMemberFragment, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopMemberFragment$onViewCreated$groupMemberFragment$1$1$invoke$1(this.$args, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        final Object[] objArr;
        TroopMemberFragment troopMemberFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    objArr = (Object[]) this.L$1;
                    troopMemberFragment = (TroopMemberFragment) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Object[] objArr2 = this.$args;
                Object obj2 = objArr2[0];
                if (obj2 instanceof String) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
                if (str != null) {
                    TroopMemberFragment troopMemberFragment2 = this.this$0;
                    com.tencent.qqnt.chathistory.service.a aVar = com.tencent.qqnt.chathistory.service.a.f353327a;
                    long parseLong = Long.parseLong(str);
                    this.L$0 = troopMemberFragment2;
                    this.L$1 = objArr2;
                    this.label = 1;
                    Object m3 = aVar.m(parseLong, this);
                    if (m3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objArr = objArr2;
                    obj = m3;
                    troopMemberFragment = troopMemberFragment2;
                }
                return Unit.INSTANCE;
            }
            final String str2 = (String) obj;
            if (str2 != null) {
                ChatHistoryTroopMemberViewModel chatHistoryTroopMemberViewModel = (ChatHistoryTroopMemberViewModel) troopMemberFragment.rh();
                FragmentActivity requireActivity = troopMemberFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                chatHistoryTroopMemberViewModel.Q1(requireActivity, TroopMemberHistoryFragment.class, new Function1<Intent, Unit>(str2, objArr) { // from class: com.tencent.qqnt.chathistory.ui.troopMember.TroopMemberFragment$onViewCreated$groupMemberFragment$1$1$invoke$1$1$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Object[] $args;
                    final /* synthetic */ String $uin;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$uin = str2;
                        this.$args = objArr;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) str2, (Object) objArr);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                        invoke2(intent);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Intent start) {
                        ArrayList<String> arrayListOf;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) start);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(start, "$this$start");
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.$uin);
                        start.putStringArrayListExtra("key_troop_member_uids", arrayListOf);
                        Object obj3 = this.$args[1];
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                        start.putExtra("key_troop_member_nick", (String) obj3);
                    }
                });
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopMemberFragment$onViewCreated$groupMemberFragment$1$1$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
