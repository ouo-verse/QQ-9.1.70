package com.tencent.mobileqq.aio.msglist.holder.component.facebubble;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FaceBubbleMsgItem;
import com.tencent.mobileqq.aio.msg.PokeMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.utils.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGetMsgSeqCallback;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/f;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "Lcom/tencent/mobileqq/aio/msg/FaceBubbleMsgItem;", "faceBubbleList", "Lcom/tencent/mobileqq/aio/msg/PokeMsgItem;", "pokeList", "", "g", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "", "d", "J", "mFirstUnreadSeq", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "e", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mFirstUnreadSeq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.facebubble.f$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49138);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        }
    }

    private final void g(final List<FaceBubbleMsgItem> faceBubbleList, final List<PokeMsgItem> pokeList) {
        ((IMsgService) QRoute.api(IMsgService.class)).getFirstUnreadMsgSeq(o.b(b().g().r().c()), new IGetMsgSeqCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.facebubble.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMsgSeqCallback
            public final void onGetMsgSeq(int i3, String str, long j3) {
                f.h(f.this, faceBubbleList, pokeList, i3, str, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x010d, code lost:
    
        if (r9 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void h(f this$0, List faceBubbleList, List pokeList, int i3, String str, long j3) {
        PokeMsgItem pokeMsgItem;
        int i16;
        Object last;
        Object last2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(faceBubbleList, "$faceBubbleList");
        Intrinsics.checkNotNullParameter(pokeList, "$pokeList");
        boolean z16 = true;
        QLog.d("FaceBubbleMsgProcessor", 1, "getFirstUnreadMsgSeq result=" + i3 + ", errMsg=" + str + ", seq=" + j3);
        if (i3 == 0) {
            this$0.mFirstUnreadSeq = j3;
            ArrayList<FaceBubbleMsgItem> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = faceBubbleList.iterator();
            while (it.hasNext()) {
                FaceBubbleMsgItem faceBubbleMsgItem = (FaceBubbleMsgItem) it.next();
                if (faceBubbleMsgItem.getMsgSeq() >= j3) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("FaceBubbleMsgProcessor", 4, "unread msgItem:" + faceBubbleMsgItem);
                    }
                    arrayList.add(faceBubbleMsgItem);
                } else {
                    faceBubbleMsgItem.r2();
                }
            }
            Iterator it5 = pokeList.iterator();
            while (it5.hasNext()) {
                PokeMsgItem pokeMsgItem2 = (PokeMsgItem) it5.next();
                if (pokeMsgItem2.getMsgSeq() >= j3) {
                    QLog.d("FaceBubbleMsgProcessor", 4, "unread msgItem:" + pokeMsgItem2);
                    arrayList2.add(pokeMsgItem2);
                }
            }
            FaceBubbleMsgItem faceBubbleMsgItem2 = null;
            if (!arrayList2.isEmpty()) {
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
                pokeMsgItem = (PokeMsgItem) last2;
            } else {
                pokeMsgItem = null;
            }
            if (!arrayList.isEmpty()) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                faceBubbleMsgItem2 = (FaceBubbleMsgItem) last;
            }
            int i17 = 0;
            if (faceBubbleMsgItem2 != null && pokeMsgItem != null) {
                if (pokeMsgItem.getMsgRecord().msgTime < faceBubbleMsgItem2.getMsgRecord().msgTime) {
                    QLog.d("AIOFaceBubbleContentComponent", 4, "msg[seq]" + pokeMsgItem.getMsgSeq() + "=======\u6233\u4e00\u6233\u6d88\u606f\u7531\u4e8e\u65f6\u95f4\u95ee\u9898 \u8bbe\u4e3a\u5df2\u64ad\u653e");
                    pokeMsgItem.x2();
                }
                z16 = false;
            }
            int size = arrayList.size();
            if (!z16) {
                for (FaceBubbleMsgItem faceBubbleMsgItem3 : arrayList) {
                    faceBubbleMsgItem3.r2();
                    QLog.d("AIOFaceBubbleContentComponent", 4, "msg[seq]" + faceBubbleMsgItem3.getMsgSeq() + "=======\u7531\u4e8e\u65f6\u95f4\u95ee\u9898 \u8bbe\u4e3a\u5df2\u64ad\u653e");
                }
                return;
            }
            if (size <= 3 || (i16 = size - 4) < 0) {
                return;
            }
            while (true) {
                FaceBubbleMsgItem faceBubbleMsgItem4 = (FaceBubbleMsgItem) arrayList.get(i17);
                if (!faceBubbleMsgItem4.o2()) {
                    QLog.d("AIOFaceBubbleContentComponent", 4, "msg[seq]" + faceBubbleMsgItem4.getMsgSeq() + "=======\u7531\u4e8e\u6570\u91cf\u95ee\u9898 \u8bbe\u4e3a\u5df2\u64ad\u653e");
                    faceBubbleMsgItem4.r2();
                }
                if (i17 != i16) {
                    i17++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        if (b().g().r().c().e() == 1) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.aio.data.msglist.a aVar : displayList) {
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                if (aIOMsgItem.getMsgRecord().msgType == 24 && (aVar instanceof FaceBubbleMsgItem)) {
                    arrayList.add(aVar);
                }
                if (aIOMsgItem.getMsgRecord().msgType == 6 && (aVar instanceof PokeMsgItem)) {
                    arrayList2.add(aVar);
                }
            }
            if ((!arrayList.isEmpty()) || (true ^ arrayList2.isEmpty())) {
                g(arrayList, arrayList2);
            }
        }
        return displayList;
    }
}
