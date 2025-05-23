package com.tencent.qqnt.forwardaio.msglist;

import android.content.Context;
import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msg.p;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttUtil;
import com.tencent.mobileqq.aio.msglist.msgprocessor.e;
import com.tencent.mobileqq.aio.msglist.msgrepo.g;
import com.tencent.mobileqq.aio.utils.k;
import com.tencent.mobileqq.aio.utils.n;
import com.tencent.mobileqq.aio.utils.o;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.multiforward.MultiForwardEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.forwardaio.ForwardMsgStore;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\u0006\u0010#\u001a\u00020\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R2\u0010/\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)`*8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/forwardaio/msglist/PreviewMsgRepo;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "", "z0", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItems", "A0", "B0", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "x0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "list", "b", "displayList", "k", "", "source", "i", "a", "e", "", "beginMsgSeq", "endMsgSeq", "f", "o", "msgSeq", h.F, "c", "Landroid/os/Bundle;", "y0", "Lcom/tencent/mobileqq/aio/msglist/msgprocessor/e;", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/List;", "mMsgProcessors", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lkotlin/collections/ArrayList;", "t", "Ljava/util/ArrayList;", "k0", "()Ljava/util/ArrayList;", "msgRepoAbilityList", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "u", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class PreviewMsgRepo extends BaseMsgRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<e> mMsgProcessors;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<g<?>> msgRepoAbilityList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/forwardaio/msglist/PreviewMsgRepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.forwardaio.msglist.PreviewMsgRepo$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewMsgRepo(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        List<e> listOf;
        ArrayList<g<?>> arrayListOf;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new e(aioContext, scope));
            this.mMsgProcessors = listOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.qqnt.forwardaio.msglist.msgability.a(this, D(), scope), new com.tencent.mobileqq.aio.msglist.msgrepo.b(this, D(), scope));
            this.msgRepoAbilityList = arrayListOf;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
    }

    private final void A0(List<? extends AIOMsgItem> aioMsgItems) {
        MsgList M = M();
        M.clear();
        M.addAll(B0(aioMsgItems));
        p0(IMsgListRepository.MsgListRepoOpType.OtherOperation, M(), y0(), "preview_msg_show_custom");
    }

    private final List<AIOMsgItem> B0(List<? extends AIOMsgItem> aioMsgItems) {
        Comparator comparator;
        List<AIOMsgItem> sortedWith;
        if (D().g().r().c().e() == 2) {
            comparator = new Comparator() { // from class: com.tencent.qqnt.forwardaio.msglist.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int C0;
                    C0 = PreviewMsgRepo.C0((AIOMsgItem) obj, (AIOMsgItem) obj2);
                    return C0;
                }
            };
        } else {
            comparator = new Comparator() { // from class: com.tencent.qqnt.forwardaio.msglist.d
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int D0;
                    D0 = PreviewMsgRepo.D0((AIOMsgItem) obj, (AIOMsgItem) obj2);
                    return D0;
                }
            };
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(aioMsgItems, comparator);
        return sortedWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int C0(AIOMsgItem aIOMsgItem, AIOMsgItem aIOMsgItem2) {
        return (int) (aIOMsgItem.getMsgSeq() - aIOMsgItem2.getMsgSeq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int D0(AIOMsgItem aIOMsgItem, AIOMsgItem aIOMsgItem2) {
        return (int) (aIOMsgItem.getMsgRecord().msgTime - aIOMsgItem2.getMsgRecord().msgTime);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        if (r1 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AIOMsgItem x0(AIOMsgItem item) {
        PttElement pttElement;
        String str;
        String content;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if ((item instanceof PttMsgItem) && ((PttMsgItem) item).A2()) {
            content = HardCodeUtil.qqStr(R.string.ytx);
        } else {
            MsgElement firstTypeElement = item.getFirstTypeElement(4);
            if (firstTypeElement != null) {
                pttElement = firstTypeElement.pttElement;
            } else {
                pttElement = null;
            }
            if (pttElement != null) {
                Integer num = pttElement.translateStatus;
                if (num != null && num.intValue() == 2) {
                    String str2 = pttElement.text;
                    if (str2 != null && str2.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        str = D().c().getString(R.string.hqu);
                    } else {
                        str = pttElement.text;
                    }
                } else {
                    str = " " + AIOPttUtil.f191743a.e(pttElement.getDuration());
                }
            }
            str = "";
            content = HardCodeUtil.qqStr(R.string.ytw) + str;
        }
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        arrayList.add(iMsgUtilApi.createTextElement(content));
        AIOMsgItem transformMsgRecordWithType = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).transformMsgRecordWithType(new MsgRecord(item.getMsgRecord().msgId, 0L, item.getMsgRecord().msgSeq, 0L, item.getMsgRecord().chatType, 2, 0, item.getMsgRecord().sendType, item.getMsgRecord().senderUid, item.getMsgRecord().peerUid, "", "", 0L, 0L, 0L, item.getMsgRecord().msgTime, null, item.getMsgRecord().sendStatus, "", "", item.getMsgRecord().sendNickName, "", "", arrayList, null, null, 0L, 0, null, item.getMsgRecord().peerName, null, false, null, null, "", 0L, 0L, null, false, 0, 0, null, null, null, 0L, false, null, 0L, 0, null, null, item.getMsgRecord().senderUin, item.getMsgRecord().peerUin, item.getMsgRecord().msgAttrs, item.getMsgRecord().anonymousExtInfo, 0, item.getMsgRecord().avatarFlag, null, null, 0, null));
        transformMsgRecordWithType.k1(item.C());
        transformMsgRecordWithType.Y1(n.f194168a.f(MobileQQ.sMobileQQ, transformMsgRecordWithType));
        return transformMsgRecordWithType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        if (!rsp.d()) {
            QLog.i("PreviewMsgRepo", 1, "handleMultiMsgResult failed");
            D().e().h(new MultiForwardEvent.GetMsgError(rsp.c()));
            return;
        }
        if (rsp.a().isEmpty()) {
            QLog.i("PreviewMsgRepo", 1, "handleMultiMsgResult dataList is empty");
            D().e().h(new MultiForwardEvent.GetMsgError(rsp.c()));
            return;
        }
        MsgList M = M();
        M.clear();
        M.addAll(rsp.a());
        for (com.tencent.aio.data.msglist.a aVar : M) {
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            ((AIOMsgItem) aVar).k1(0);
        }
        p0(IMsgListRepository.MsgListRepoOpType.OtherOperation, M, y0(), "preview_msg_multi_result_ability");
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.Q();
        Iterator<T> it = this.mMsgProcessors.iterator();
        while (it.hasNext()) {
            ((e) it.next()).d();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Collection) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        return list;
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void f(long beginMsgSeq, long endMsgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(beginMsgSeq), Long.valueOf(endMsgSeq));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(long msgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, msgSeq);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) source);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Bundle l3 = D().g().l();
        boolean z16 = l3.getBoolean("key_forward_aio_show_custom_msg");
        boolean z17 = l3.getBoolean("key_forward_aio_is_multi_msg");
        if (z16) {
            ForwardMsgStore a16 = ForwardMsgStore.INSTANCE.a();
            Context requireContext = D().c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "context.fragment.requireContext()");
            List<AIOMsgItem> b16 = a16.b(requireContext);
            if (b16 == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (AIOMsgItem aIOMsgItem : b16) {
                if (aIOMsgItem.getMsgRecord().msgType == 6) {
                    arrayList.add(x0(aIOMsgItem));
                } else if (com.tencent.mobileqq.aio.utils.d.R(aIOMsgItem)) {
                    aIOMsgItem.Y0(D().c().requireContext());
                    arrayList.add(aIOMsgItem);
                } else {
                    arrayList.add(aIOMsgItem);
                }
            }
            Object obj = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "msgItems[0]");
            AIOMsgItem aIOMsgItem2 = (AIOMsgItem) obj;
            if (z17 && (com.tencent.mobileqq.aio.utils.d.H(aIOMsgItem2) || (aIOMsgItem2 instanceof p) || (((aIOMsgItem2 instanceof ArkMsgItem) && k.f194164a.b(((ArkMsgItem) aIOMsgItem2).l2())) || ((aIOMsgItem2 instanceof TemplateMsgItem) && com.tencent.mobileqq.aio.msglist.holder.component.template.common.a.f191908a.b(aIOMsgItem2))))) {
                Contact b17 = o.b(D().g().r().c());
                long j3 = aIOMsgItem2.getMsgRecord().msgId;
                for (MsgRecordParams h06 = aIOMsgItem2.h0(); h06 != null; h06 = h06.c()) {
                    j3 = h06.b();
                }
                FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().l(b17, j3, aIOMsgItem2.getMsgRecord().msgId), new PreviewMsgRepo$loadFirstPage$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), J());
                return;
            }
            A0(arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        Iterator<T> it = this.mMsgProcessors.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(displayList);
        }
        return displayList;
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo
    @NotNull
    protected ArrayList<g<?>> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgRepoAbilityList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.mMsgProcessors.iterator();
        while (it.hasNext()) {
            ((e) it.next()).e();
        }
    }

    @NotNull
    public final Bundle y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Bundle) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(QCircleDaTongConstant.ElementParamValue.SET_TOP, true);
        return bundle;
    }
}
