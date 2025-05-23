package com.tencent.mobileqq.multiforward.msglist;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.msglist.msgprocessor.e;
import com.tencent.mobileqq.aio.msglist.msgrepo.RichMediaAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.g;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.multiforward.MultiForwardEvent;
import com.tencent.mobileqq.multiforward.msglist.msgrepo.MultiForwardNavigationAbility;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 82\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010!\u001a\u00020 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R2\u00103\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0,j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-`.8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/multiforward/msglist/MultiForwardMsgRepo;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "", "z0", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "notifyMsgList", "y0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "list", "b", "displayList", "k", "", "source", "i", "a", "e", "", "beginMsgSeq", "endMsgSeq", "f", "o", "msgSeq", h.F, "c", "w0", "Landroid/os/Bundle;", "x0", "Lcom/tencent/aio/api/runtime/a;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/api/runtime/a;", "getAioContext", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "t", "Ljava/util/List;", "mMsgProcessors", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lkotlin/collections/ArrayList;", "u", "Ljava/util/ArrayList;", "k0", "()Ljava/util/ArrayList;", "msgRepoAbilityList", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "v", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiForwardMsgRepo extends BaseMsgRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends AbsAIOMsgProcessor> mMsgProcessors;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<g<?>> msgRepoAbilityList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/multiforward/msglist/MultiForwardMsgRepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multiforward.msglist.MultiForwardMsgRepo$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65396);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiForwardMsgRepo(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        List<? extends AbsAIOMsgProcessor> listOf;
        ArrayList<g<?>> arrayListOf;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
            return;
        }
        this.aioContext = aioContext;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AbsAIOMsgProcessor[]{new a(aioContext, scope), new e(aioContext, scope)});
        this.mMsgProcessors = listOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new RichMediaAbility(this, aioContext, scope), new MultiForwardNavigationAbility(this, aioContext, scope), new com.tencent.mobileqq.aio.msglist.msgrepo.b(this, D(), scope));
        this.msgRepoAbilityList = arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(List<? extends AIOMsgItem> notifyMsgList) {
        Long l3;
        String j3 = D().g().r().c().j();
        MsgRecordParams msgRecordParams = (MsgRecordParams) D().g().l().getParcelable("key_multiforward_root_msg_record");
        ArrayList<AIOMsgItem> arrayList = null;
        if (msgRecordParams != null) {
            l3 = Long.valueOf(msgRecordParams.b());
        } else {
            l3 = null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : notifyMsgList) {
            if (Intrinsics.areEqual(((AIOMsgItem) obj).getMsgRecord().peerUid, j3)) {
                arrayList2.add(obj);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            for (AIOMsgItem aIOMsgItem : arrayList) {
                if (d.Q(aIOMsgItem)) {
                    long msgId = aIOMsgItem.getMsgId();
                    if (l3 != null && msgId == l3.longValue()) {
                        QLog.i("MultiForwardMsgRepo", 1, "[handleMsgRecall]: rootMsg has recall, msgId is " + aIOMsgItem.getMsgId());
                        D().e().h(MultiForwardEvent.RootMsgRecall.f251492d);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        if (!rsp.d()) {
            QLog.i("MultiForwardMsgRepo", 1, "handleMultiMsgResult failed");
            D().e().h(new MultiForwardEvent.GetMsgError(rsp.c()));
        } else {
            if (rsp.a().isEmpty()) {
                QLog.i("MultiForwardMsgRepo", 1, "handleMultiMsgResult dataList is empty");
                D().e().h(new MultiForwardEvent.GetMsgError(rsp.c()));
                return;
            }
            MsgList M = M();
            M.clear();
            M.addAllWithFilter(rsp.a());
            l0(rsp.a());
            g(IMsgListRepository.MsgListRepoOpType.LoadFirst, rsp.a(), x0());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.Q();
        Iterator<T> it = this.mMsgProcessors.iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).d();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Collection) iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        return list;
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.c();
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().r(), new MultiForwardMsgRepo$registerNotification$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), J());
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void f(long beginMsgSeq, long endMsgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(beginMsgSeq), Long.valueOf(endMsgSeq));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(long msgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, msgSeq);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) source);
        } else {
            Intrinsics.checkNotNullParameter(source, "source");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        Iterator<T> it = this.mMsgProcessors.iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).a(displayList);
        }
        return displayList;
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo
    @NotNull
    protected ArrayList<g<?>> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgRepoAbilityList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.mMsgProcessors.iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).e();
        }
    }

    public final void w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().l(AIOUtil.f194084a.h(D().g().r()), D().g().l().getLong("key_multiforward_root_msgid"), D().g().l().getLong("key_multiforward_parent_msgid")), new MultiForwardMsgRepo$getMultiMsg$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    @NotNull
    public final Bundle x0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Bundle) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(QCircleDaTongConstant.ElementParamValue.SET_TOP, true);
        return bundle;
    }
}
