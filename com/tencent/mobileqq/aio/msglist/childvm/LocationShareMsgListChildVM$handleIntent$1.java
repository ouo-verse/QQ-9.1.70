package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.LocationShareMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.LocationShareMsgListChildVM$handleIntent$1", f = "LocationShareMsgListChildVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class LocationShareMsgListChildVM$handleIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOMsgListEvent.UpdateLocationShare $intent;
    int label;
    final /* synthetic */ LocationShareMsgListChildVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationShareMsgListChildVM$handleIntent$1(LocationShareMsgListChildVM locationShareMsgListChildVM, AIOMsgListEvent.UpdateLocationShare updateLocationShare, Continuation<? super LocationShareMsgListChildVM$handleIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = locationShareMsgListChildVM;
        this.$intent = updateLocationShare;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, locationShareMsgListChildVM, updateLocationShare, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LocationShareMsgListChildVM$handleIntent$1(this.this$0, this.$intent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int lastIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MsgList M = this.this$0.d().m().M();
                boolean z16 = true;
                boolean z17 = false;
                for (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(M); -1 < lastIndex; lastIndex--) {
                    com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) M.get(lastIndex);
                    if (aVar instanceof LocationShareMsgItem) {
                        LocationShareMsgItem locationShareMsgItem = (LocationShareMsgItem) aVar;
                        if (Intrinsics.areEqual(locationShareMsgItem.getMsgRecord().peerUid, this.$intent.b())) {
                            if (!z16) {
                                if (locationShareMsgItem.j2()) {
                                    AIOMsgItem cloneNewInstance = locationShareMsgItem.cloneNewInstance();
                                    Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.LocationShareMsgItem");
                                    LocationShareMsgItem locationShareMsgItem2 = (LocationShareMsgItem) cloneNewInstance;
                                    locationShareMsgItem2.k2(false);
                                    M.set(lastIndex, (com.tencent.aio.data.msglist.a) locationShareMsgItem2);
                                    z17 = true;
                                }
                                z16 = false;
                            } else {
                                if (locationShareMsgItem.j2() != this.$intent.a()) {
                                    AIOMsgItem cloneNewInstance2 = locationShareMsgItem.cloneNewInstance();
                                    Intrinsics.checkNotNull(cloneNewInstance2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.LocationShareMsgItem");
                                    LocationShareMsgItem locationShareMsgItem3 = (LocationShareMsgItem) cloneNewInstance2;
                                    locationShareMsgItem3.k2(this.$intent.a());
                                    M.set(lastIndex, (com.tencent.aio.data.msglist.a) locationShareMsgItem3);
                                    z17 = true;
                                }
                                z16 = false;
                            }
                        }
                    }
                }
                if (z17) {
                    e.a(this.this$0, M, "location_share");
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LocationShareMsgListChildVM$handleIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
