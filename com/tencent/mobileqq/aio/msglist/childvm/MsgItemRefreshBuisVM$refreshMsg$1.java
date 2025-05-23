package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.RefreshType;
import com.tencent.mobileqq.aio.msg.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.MsgItemRefreshBuisVM$refreshMsg$1", f = "MsgItemRefreshBuisVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class MsgItemRefreshBuisVM$refreshMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Map<String, ArrayList<t>> $refreshMap;
    final /* synthetic */ int $updateType;
    int label;
    final /* synthetic */ MsgItemRefreshBuisVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgItemRefreshBuisVM$refreshMsg$1(MsgItemRefreshBuisVM msgItemRefreshBuisVM, Map<String, ? extends ArrayList<t>> map, int i3, Continuation<? super MsgItemRefreshBuisVM$refreshMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = msgItemRefreshBuisVM;
        this.$refreshMap = map;
        this.$updateType = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItemRefreshBuisVM, map, Integer.valueOf(i3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MsgItemRefreshBuisVM$refreshMsg$1(this.this$0, this.$refreshMap, this.$updateType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Map<String, ArrayList<t>> map;
        Iterator it;
        int i3;
        Iterator it5;
        com.tencent.aio.data.msglist.a aVar;
        int i16;
        Iterator<Map.Entry<String, ArrayList<t>>> it6;
        int q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                long currentTimeMillis = System.currentTimeMillis();
                MsgList M = this.this$0.d().m().M();
                if (M.isEmpty()) {
                    QLog.i("MsgItemRefreshBuisVM", 1, "[refreshMsg]: displayList size is 0");
                }
                Map<String, ArrayList<t>> map2 = this.$refreshMap;
                int i17 = this.$updateType;
                MsgItemRefreshBuisVM msgItemRefreshBuisVM = this.this$0;
                Iterator it7 = M.iterator();
                int i18 = 0;
                int i19 = 0;
                while (it7.hasNext()) {
                    Object next = it7.next();
                    int i26 = i19 + 1;
                    if (i19 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) next;
                    if (aVar2 instanceof AIOMsgItem) {
                        Iterator<Map.Entry<String, ArrayList<t>>> it8 = map2.entrySet().iterator();
                        AIOMsgItem aIOMsgItem = null;
                        while (it8.hasNext()) {
                            Map.Entry<String, ArrayList<t>> next2 = it8.next();
                            RefreshType b16 = next2.getValue().get(i18).b();
                            AIOMsgItem aIOMsgItem2 = (AIOMsgItem) aVar2;
                            Map<String, ArrayList<t>> map3 = map2;
                            if (Intrinsics.areEqual(aIOMsgItem2.j0().get(b16), next2.getKey())) {
                                if (QLog.isDevelopLevel()) {
                                    String key = next2.getKey();
                                    it5 = it7;
                                    long msgId = aVar2.getMsgId();
                                    aVar = aVar2;
                                    int size = next2.getValue().size();
                                    i16 = i26;
                                    StringBuilder sb5 = new StringBuilder();
                                    it6 = it8;
                                    sb5.append("[refreshMsg]: key is ");
                                    sb5.append((Object) key);
                                    sb5.append(", msgId is ");
                                    sb5.append(msgId);
                                    sb5.append(", refreshType is ");
                                    sb5.append(b16);
                                    sb5.append(", size is ");
                                    sb5.append(size);
                                    sb5.append(", updateType is ");
                                    sb5.append(i17);
                                    QLog.i("MsgItemRefreshBuisVM", 4, sb5.toString());
                                } else {
                                    it5 = it7;
                                    aVar = aVar2;
                                    i16 = i26;
                                    it6 = it8;
                                }
                                if (aIOMsgItem == null) {
                                    aIOMsgItem = aIOMsgItem2.cloneNewInstance();
                                }
                                HashSet hashSet = new HashSet();
                                for (t tVar : next2.getValue()) {
                                    q16 = msgItemRefreshBuisVM.q(tVar.a());
                                    if (q16 > 0) {
                                        hashSet.add(Boxing.boxInt(q16));
                                    }
                                    Intrinsics.checkNotNull(aIOMsgItem);
                                    msgItemRefreshBuisVM.v(aIOMsgItem, tVar.a());
                                }
                                if (hashSet.size() > 0) {
                                    com.tencent.mobileqq.aio.msg.service.a aVar3 = com.tencent.mobileqq.aio.msg.service.a.f190218a;
                                    Intrinsics.checkNotNull(aIOMsgItem);
                                    aVar3.c(hashSet, aIOMsgItem);
                                }
                            } else {
                                it5 = it7;
                                aVar = aVar2;
                                i16 = i26;
                                it6 = it8;
                            }
                            map2 = map3;
                            it7 = it5;
                            i26 = i16;
                            aVar2 = aVar;
                            it8 = it6;
                            i18 = 0;
                        }
                        map = map2;
                        it = it7;
                        i3 = i26;
                        if (aIOMsgItem != null) {
                            M.set(i19, (com.tencent.aio.data.msglist.a) aIOMsgItem);
                        }
                    } else {
                        map = map2;
                        it = it7;
                        i3 = i26;
                    }
                    map2 = map;
                    it7 = it;
                    i19 = i3;
                    i18 = 0;
                }
                QLog.i("MsgItemRefreshBuisVM", 1, "[refreshMsg]: displayList Cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                e.a(this.this$0, M, "nt_frequency_control");
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgItemRefreshBuisVM$refreshMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
