package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.msg.GrayTipsMsgItem;
import com.tencent.mobileqq.aio.reserve1.navigation.AIONavType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.msgrepo.MsgLocationAbility$handleNavigateBySeqEvent$1", f = "MsgLocationAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class MsgLocationAbility$handleNavigateBySeqEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MsgNavigationEvent.NavigateBySeqEvent $intent;
    int label;
    final /* synthetic */ MsgLocationAbility this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgLocationAbility$handleNavigateBySeqEvent$1(MsgNavigationEvent.NavigateBySeqEvent navigateBySeqEvent, MsgLocationAbility msgLocationAbility, Continuation<? super MsgLocationAbility$handleNavigateBySeqEvent$1> continuation) {
        super(2, continuation);
        this.$intent = navigateBySeqEvent;
        this.this$0 = msgLocationAbility;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, navigateBySeqEvent, msgLocationAbility, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MsgLocationAbility$handleNavigateBySeqEvent$1(this.$intent, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        int i3;
        Object first;
        Object last;
        boolean z17;
        long j3;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = this.$intent.b();
                long a16 = this.$intent.a();
                MsgList M = this.this$0.q().M();
                ArrayList arrayList = new ArrayList();
                Iterator<com.tencent.aio.data.msglist.a> it = M.iterator();
                while (true) {
                    z16 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.aio.data.msglist.a next = it.next();
                    if (!(next instanceof GrayTipsMsgItem)) {
                        arrayList.add(next);
                    }
                }
                Iterator it5 = arrayList.iterator();
                int i16 = 0;
                while (true) {
                    if (it5.hasNext()) {
                        if (((com.tencent.aio.data.msglist.a) it5.next()).getMsgSeq() == longRef.element) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                QLog.d("MsgLocationAbility", 1, "navigateToMsg msgSeq=" + longRef.element + ", pop=" + i3);
                Bundle U0 = this.this$0.q().U0(longRef.element, a16, this.$intent.d(), this.$intent.g());
                this.this$0.focusBottomOnBackground = false;
                if (i3 != -1) {
                    if (this.$intent.f()) {
                        U0.putBoolean("navigate_order_down", true);
                    }
                    this.this$0.q().g(IMsgListRepository.MsgListRepoOpType.OtherOperation, M, U0);
                    this.this$0.d().e().h(new MsgNavigationEvent.NavigationResultNotify(true, longRef.element, this.$intent));
                } else {
                    if ((!arrayList.isEmpty()) && (!M.isEmpty())) {
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) M);
                        long msgSeq = ((com.tencent.aio.data.msglist.a) first).getMsgSeq();
                        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) M);
                        long msgSeq2 = ((com.tencent.aio.data.msglist.a) last).getMsgSeq();
                        long j16 = longRef.element;
                        if (msgSeq <= j16 && j16 <= msgSeq2) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            com.tencent.aio.data.msglist.a aVar = null;
                            if (this.$intent.c() == AIONavType.UNREAD) {
                                Iterator it6 = arrayList.iterator();
                                while (true) {
                                    if (!it6.hasNext()) {
                                        break;
                                    }
                                    Object next2 = it6.next();
                                    if (((com.tencent.aio.data.msglist.a) next2).getMsgSeq() > longRef.element) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z18) {
                                        aVar = next2;
                                        break;
                                    }
                                }
                                aVar = aVar;
                            }
                            if (aVar != null) {
                                QLog.d("MsgLocationAbility", 1, "navigateToMsg next seq " + Boxing.boxLong(aVar.getMsgSeq()));
                                this.this$0.q().g(IMsgListRepository.MsgListRepoOpType.OtherOperation, M, this.this$0.q().U0(aVar.getMsgSeq(), aVar.getMsgId(), this.$intent.d(), this.$intent.g()));
                            } else {
                                QLog.d("MsgLocationAbility", 1, "navigateToMsg seq not found in list");
                            }
                            com.tencent.mvi.base.route.j e16 = this.this$0.d().e();
                            if (aVar == null) {
                                z16 = false;
                            }
                            if (aVar != null) {
                                j3 = aVar.getMsgSeq();
                            } else {
                                j3 = longRef.element;
                            }
                            e16.h(new MsgNavigationEvent.NavigationResultNotify(z16, j3, this.$intent));
                            return Unit.INSTANCE;
                        }
                    }
                    AIONavType c16 = this.$intent.c();
                    if (c16 != null && c16 == AIONavType.UNREAD) {
                        longRef.element--;
                    }
                    if (this.$intent.f()) {
                        U0.remove("navigate_id");
                        U0.remove("navigate_seq");
                        U0.putBoolean("navigate_order_down", true);
                        U0.putBoolean("set_bottom", true);
                        U0.putBoolean("check_current_focus", false);
                    }
                    U0.putInt("extra_count", 3);
                    this.this$0.q().t1(longRef.element, 15, U0, this.$intent);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgLocationAbility$handleNavigateBySeqEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
