package com.tencent.qqnt.msgselect.msglist;

import com.tencent.aio.msgservice.g;
import com.tencent.aio.msgservice.h;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.msglist.msgprocessor.e;
import com.tencent.mobileqq.aio.msglist.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001+B-\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020#\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%\u00a2\u0006\u0004\b(\u0010)J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R+\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d8TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/msgselect/msglist/MsgSelectRepo;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "", Constants.BASE_IN_PLUGIN_ID, "", "displayList", "E1", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "H1", "e", "Lcom/tencent/qqnt/msgselect/msglist/a;", "H", "Lcom/tencent/qqnt/msgselect/msglist/a;", "getVmFetcher", "()Lcom/tencent/qqnt/msgselect/msglist/a;", "vmFetcher", "Lcom/tencent/aio/api/runtime/a;", "I", "Lcom/tencent/aio/api/runtime/a;", "F1", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "Lkotlin/collections/ArrayList;", "J", "Lkotlin/Lazy;", "S0", "()Ljava/util/ArrayList;", "mMsgProcessors", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/y;", "msgListVMApi", "<init>", "(Lcom/tencent/qqnt/msgselect/msglist/a;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/ref/WeakReference;)V", "K", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgSelectRepo extends AIOMsgRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final a vmFetcher;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMsgProcessors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msgselect/msglist/MsgSelectRepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msgselect.msglist.MsgSelectRepo$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgSelectRepo(@NotNull a vmFetcher, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull final CoroutineScope scope, @NotNull WeakReference<y> msgListVMApi) {
        super(aioContext, scope, msgListVMApi, null);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(vmFetcher, "vmFetcher");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(msgListVMApi, "msgListVMApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, vmFetcher, aioContext, scope, msgListVMApi);
            return;
        }
        this.vmFetcher = vmFetcher;
        this.aioContext = aioContext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<AbsAIOMsgProcessor>>(scope) { // from class: com.tencent.qqnt.msgselect.msglist.MsgSelectRepo$mMsgProcessors$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ CoroutineScope $scope;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$scope = scope;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgSelectRepo.this, (Object) scope);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<AbsAIOMsgProcessor> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ArrayList<AbsAIOMsgProcessor> arrayList = new ArrayList<>();
                MsgSelectRepo msgSelectRepo = MsgSelectRepo.this;
                CoroutineScope coroutineScope = this.$scope;
                arrayList.add(new e(msgSelectRepo.F1(), coroutineScope));
                arrayList.add(new c(msgSelectRepo.F1(), coroutineScope));
                return arrayList;
            }
        });
        this.mMsgProcessors = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(h<com.tencent.aio.data.msglist.a> rsp) {
        QLog.i("MsgSelectRepo", 1, "handleTopPage, succ = " + rsp.d() + ", data size = " + rsp.a().size());
        if (rsp.d()) {
            if (!rsp.a().isEmpty()) {
                List<com.tencent.aio.data.msglist.a> a16 = rsp.a();
                ArrayList arrayList = new ArrayList();
                for (Object obj : a16) {
                    if (((com.tencent.aio.data.msglist.a) obj) instanceof AIOMsgItem) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    Object obj2 = arrayList.get(arrayList.size() - 1);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                    if (H1((AIOMsgItem) obj2)) {
                        Object obj3 = arrayList.get(0);
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                        if (H1((AIOMsgItem) obj3)) {
                            this.aioContext.e().h(MultiSelectEvent.ReachMsgTimeLimit.f188670d);
                        }
                    }
                }
                List<com.tencent.aio.data.msglist.a> E1 = E1(arrayList);
                M().addAll(0, E1);
                super.l0(E1);
            }
            QLog.i("MsgSelectRepo", 1, "handleTopPage,  displaylist=" + M().size());
            d(IMsgListRepository.MsgListRepoOpType.LoadPrePage, M(), null);
            return;
        }
        d(IMsgListRepository.MsgListRepoOpType.LoadPrePageFail, M(), null);
    }

    private final List<com.tencent.aio.data.msglist.a> E1(List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List<com.tencent.aio.data.msglist.a> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) displayList);
        Iterator<com.tencent.aio.data.msglist.a> it = mutableList.iterator();
        while (it.hasNext()) {
            com.tencent.aio.data.msglist.a next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            if (H1((AIOMsgItem) next)) {
                it.remove();
            }
        }
        return mutableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(MsgSelectRepo this$0) {
        Object firstOrNull;
        Long l3;
        Long l16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this$0.M());
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        if (aVar != null) {
            l16 = Long.valueOf(aVar.getMsgId());
        } else {
            l16 = null;
        }
        QLog.i("MsgSelectRepo", 1, "loadTopPage, topLastMsg seq = " + l3 + ", msgId = " + l16);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this$0.i0().m(new g(this$0.D().g().r(), aVar, 28)), new MsgSelectRepo$loadPrePage$1$1(this$0, null)), zs.b.a(Dispatchers.INSTANCE)), this$0.J());
    }

    private final boolean H1(AIOMsgItem msgItem) {
        long j3 = this.aioContext.g().l().getLong("key_limited_time");
        if (j3 > 0 && System.currentTimeMillis() - (msgItem.getMsgRecord().msgTime * 1000) >= j3) {
            return true;
        }
        return false;
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a F1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aioContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgRepo
    @NotNull
    public ArrayList<AbsAIOMsgProcessor> S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (ArrayList) this.mMsgProcessors.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.qqnt.msgselect.msglist.d
                @Override // java.lang.Runnable
                public final void run() {
                    MsgSelectRepo.G1(MsgSelectRepo.this);
                }
            }, null, 2, null);
        }
    }
}
