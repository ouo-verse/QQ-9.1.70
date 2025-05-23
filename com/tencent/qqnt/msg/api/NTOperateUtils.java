package com.tencent.qqnt.msg.api;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002JA\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\r0\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0007J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0005R'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/msg/api/NTOperateUtils;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Lcom/tencent/qqnt/msg/api/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "c", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contact", "", "d", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgTypeFilter;", "Lkotlin/collections/ArrayList;", "b", "", "msgId", "", "count", "i", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "", h.F, "msg", "f", "e", "Ljava/util/ArrayList;", "getTypeFilter", "()Ljava/util/ArrayList;", "typeFilter", "<init>", "()V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTOperateUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NTOperateUtils f359554a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<MsgTypeFilter> typeFilter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38071);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        NTOperateUtils nTOperateUtils = new NTOperateUtils();
        f359554a = nTOperateUtils;
        typeFilter = nTOperateUtils.b();
    }

    NTOperateUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<MsgTypeFilter> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList<MsgTypeFilter> arrayList2 = new ArrayList<>();
        arrayList2.add(new MsgTypeFilter(17, new ArrayList()));
        arrayList2.add(new MsgTypeFilter(2, arrayList));
        return arrayList2;
    }

    private final Object c(Contact contact, Continuation<? super c<MsgRecord>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(contact, 0L, 1, true, new IMsgOperateCallback(cancellableContinuationImpl) { // from class: com.tencent.qqnt.msg.api.NTOperateUtils$getMsgSuspend$2$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<c<MsgRecord>> f359556a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.f359556a = cancellableContinuationImpl;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String errMsg, ArrayList<MsgRecord> msgList) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, msgList);
                    return;
                }
                MsgRecord msgRecord = new MsgRecord();
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                c<MsgRecord> cVar = new c<>(msgRecord, i3, errMsg);
                try {
                    if (i3 == 0) {
                        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
                        if (!msgList.isEmpty()) {
                            MsgRecord msgRecord2 = msgList.get(0);
                            Intrinsics.checkNotNullExpressionValue(msgRecord2, "msgList[0]");
                            cVar.e(msgRecord2);
                            this.f359556a.resume(cVar, AnonymousClass1.INSTANCE);
                            return;
                        }
                    }
                    this.f359556a.resume(cVar, AnonymousClass1.INSTANCE);
                    return;
                } catch (Throwable unused) {
                    return;
                }
                cVar.e(new MsgRecord());
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final boolean d(Contact contact) {
        if (TextUtils.isEmpty(contact.guildId) && TextUtils.isEmpty(contact.peerUid)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(Contact contact, long j3, int i3, Continuation<? super c<ArrayList<MsgRecord>>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QueryMsgsParams queryMsgsParams = new QueryMsgsParams(new ChatInfo(contact.chatType, contact.peerUid), new ArrayList(), new ArrayList(), 0L, 0L, i3, false, false);
        w e16 = f.e();
        if (e16 != null) {
            e16.queryEmoticonMsgs(0L, 0L, 0L, queryMsgsParams, new IMsgOperateCallback(cancellableContinuationImpl) { // from class: com.tencent.qqnt.msg.api.NTOperateUtils$queryMsgForSpecialTypeSuspend$2$1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ CancellableContinuation<c<ArrayList<MsgRecord>>> f359557a;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f359557a = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i16, String errMsg, ArrayList<MsgRecord> msgList) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i16), errMsg, msgList);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                    c<ArrayList<MsgRecord>> cVar = new c<>(arrayList, i16, errMsg);
                    if (i16 == 0) {
                        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
                        CollectionsKt___CollectionsJvmKt.reverse(msgList);
                        cVar.e(msgList);
                    } else {
                        cVar.e(new ArrayList<>());
                    }
                    this.f359557a.resume(cVar, AnonymousClass1.INSTANCE);
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final boolean e(@NotNull MsgRecord msg2) {
        ArrayList<MsgElement> arrayList;
        MsgElement i3;
        PicElement picElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.msgType != 2 || (arrayList = msg2.elements) == null || arrayList.isEmpty() || (i3 = MsgExtKt.i(msg2, 2)) == null || (picElement = i3.picElement) == null || !MsgExtKt.u(picElement)) {
            return false;
        }
        return true;
    }

    public final boolean f(@NotNull MsgRecord msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.msgType != 17) {
            return false;
        }
        Iterator<MsgElement> it = msg2.elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 11 && next.marketFaceElement != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(@NotNull Contact contact, @NotNull Continuation<? super MsgRecord> continuation) {
        NTOperateUtils$queryLastMsg$1 nTOperateUtils$queryLastMsg$1;
        Object coroutine_suspended;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) contact, (Object) continuation);
        }
        if (continuation instanceof NTOperateUtils$queryLastMsg$1) {
            nTOperateUtils$queryLastMsg$1 = (NTOperateUtils$queryLastMsg$1) continuation;
            int i16 = nTOperateUtils$queryLastMsg$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTOperateUtils$queryLastMsg$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTOperateUtils$queryLastMsg$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTOperateUtils$queryLastMsg$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    nTOperateUtils$queryLastMsg$1.label = 1;
                    obj = c(contact, nTOperateUtils$queryLastMsg$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                QLog.i("NTOperateUtils", 1, "getChannelLastMsgSeq withContext");
                return ((c) obj).a();
            }
        }
        nTOperateUtils$queryLastMsg$1 = new NTOperateUtils$queryLastMsg$1(this, continuation);
        Object obj2 = nTOperateUtils$queryLastMsg$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTOperateUtils$queryLastMsg$1.label;
        if (i3 == 0) {
        }
        QLog.i("NTOperateUtils", 1, "getChannelLastMsgSeq withContext");
        return ((c) obj2).a();
    }

    @NotNull
    public final List<MsgRecord> h(@NotNull Contact contact, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) contact, count);
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        QLog.i("NTOperateUtils", 4, "queryMsgForSpecialType guildId=" + contact.guildId + " channelId=" + contact.peerUid);
        ArrayList arrayList = new ArrayList();
        if (!d(contact)) {
            BuildersKt__BuildersKt.runBlocking$default(null, new NTOperateUtils$queryMsgForSpecialType$1(contact, count, arrayList, null), 1, null);
            QLog.i("NTOperateUtils", 4, "queryMsgForSpecialType queryData=" + arrayList.size());
            return arrayList;
        }
        return arrayList;
    }
}
