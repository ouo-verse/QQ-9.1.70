package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IRobotLoadingMsgFlagService;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u001f\u0012\u0006\u0010<\u001a\u00020\u0002\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ(\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J(\u0010\f\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\r\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0012\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u0006H\u0002J\u0014\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\u0014\u0010\u001f\u001a\u00020\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0018\u0010'\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020)H\u0016J(\u0010+\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010.\u001a\u00020\n2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040,H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u0018\u00100\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0016R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010:\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/RobotMsgRepoAbility;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "", "Lcom/tencent/aio/data/msglist/a;", "list", "", "source", "Landroid/os/Bundle;", "extra", "", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "K", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$OnMsgSendSuccessEvent;", "intent", UserInfo.SEX_FEMALE, "", "lastMsgId", "u", "O", "errMsg", "H", "originMsgItem", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "originRecord", "v", "Lcom/tencent/mobileqq/aio/msg/ae;", "msgItem", "B", "textContent", "P", "newMsgItem", "oldMsgItem", "E", "D", "Lcom/tencent/mvi/base/route/MsgIntent;", "g", "b", "", "msgItemList", "a", "k", "l", "", "i", "Z", "reported", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "msgCount", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "removeLoadingCallback", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotMsgRepoAbility extends g<AIOMsgRepo> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Runnable removeLoadingCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean reported;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int msgCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/RobotMsgRepoAbility$a;", "", "", "EM_BAS_GREETING", "Ljava/lang/String;", "", "FAKE_LOADING_DURATION", "J", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgrepo.RobotMsgRepoAbility$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotMsgRepoAbility(@NotNull AIOMsgRepo msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(msgRepo, aioContext, scope);
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
        } else {
            this.removeLoadingCallback = new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.r
                @Override // java.lang.Runnable
                public final void run() {
                    RobotMsgRepoAbility.N(RobotMsgRepoAbility.this);
                }
            };
        }
    }

    private final MarkdownMsgItem A() {
        Object last;
        MsgList M = e().M();
        if (!M.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) M);
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) last;
            if (aVar instanceof MarkdownMsgItem) {
                MarkdownMsgItem markdownMsgItem = (MarkdownMsgItem) aVar;
                if (markdownMsgItem.E2()) {
                    return markdownMsgItem;
                }
            }
            return null;
        }
        return null;
    }

    private final String B(ae msgItem) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = msgItem.Q().iterator();
        while (it.hasNext()) {
            sb5.append(((CharSequence) it.next()).toString());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "textContentBuilder.toString()");
        return sb6;
    }

    private final void C(List<com.tencent.aio.data.msglist.a> list, String source, Bundle extra) {
        if (list.isEmpty()) {
            return;
        }
        S(list, source, extra);
        R(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D(com.tencent.aio.data.msglist.a newMsgItem, com.tencent.aio.data.msglist.a oldMsgItem) {
        if ((newMsgItem instanceof com.tencent.mobileqq.aio.msg.l) && (oldMsgItem instanceof com.tencent.mobileqq.aio.msg.l) && ((com.tencent.mobileqq.aio.msg.l) newMsgItem).i() != ((com.tencent.mobileqq.aio.msg.l) oldMsgItem).i() && (newMsgItem instanceof AIOMsgItem) && (oldMsgItem instanceof AIOMsgItem)) {
            d().e().h(new StreamMsgEvent.OnStreamMsgRegenerated((AIOMsgItem) newMsgItem));
        }
    }

    private final void E(com.tencent.aio.data.msglist.a newMsgItem, com.tencent.aio.data.msglist.a oldMsgItem) {
        if ((newMsgItem instanceof AIOMsgItem) && (oldMsgItem instanceof AIOMsgItem) && newMsgItem.getMsgId() == oldMsgItem.getMsgId()) {
            AIOMsgItem aIOMsgItem = (AIOMsgItem) newMsgItem;
            if (com.tencent.qqnt.aio.msg.d.M(aIOMsgItem)) {
                AIOMsgItem aIOMsgItem2 = (AIOMsgItem) oldMsgItem;
                if (com.tencent.qqnt.aio.msg.d.M(aIOMsgItem2) && com.tencent.qqnt.aio.msg.d.g(aIOMsgItem) != com.tencent.qqnt.aio.msg.d.g(aIOMsgItem2)) {
                    d().e().h(new StreamMsgEvent.OnMsgStreamStatusChanged(aIOMsgItem, com.tencent.qqnt.aio.msg.d.g(aIOMsgItem2)));
                }
            }
        }
    }

    private final void F(final AIOMsgSendEvent.OnMsgSendSuccessEvent intent) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.removeLoadingCallback);
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.n
            @Override // java.lang.Runnable
            public final void run() {
                RobotMsgRepoAbility.G(RobotMsgRepoAbility.this, intent);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(RobotMsgRepoAbility this$0, AIOMsgSendEvent.OnMsgSendSuccessEvent intent) {
        Object last;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        MsgList M = this$0.e().M();
        if (!M.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) M);
            if (((com.tencent.aio.data.msglist.a) last).isSelf()) {
                MarkdownMsgItem markdownMsgItem = null;
                MsgRecord w3 = w(this$0, null, 1, null);
                AIOMsgItem s16 = MsgListUtil.s(MsgListUtil.f24918a, w3, false, this$0.d().c().requireContext(), null, 10, null);
                if (s16 instanceof MarkdownMsgItem) {
                    markdownMsgItem = (MarkdownMsgItem) s16;
                }
                if (markdownMsgItem != null) {
                    markdownMsgItem.M2(true);
                    markdownMsgItem.x1(com.tencent.mobileqq.aio.helper.ae.INSTANCE.a());
                    M.add((com.tencent.aio.data.msglist.a) markdownMsgItem);
                    this$0.u(intent.b(), w3);
                    AIOMsgRepo e16 = this$0.e();
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(markdownMsgItem);
                    e16.l0(arrayListOf);
                    this$0.e().p0(IMsgListRepository.MsgListRepoOpType.OtherOperation, M, this$0.e().Y0(false, true), "add_fake_loading_msg");
                }
                ThreadManagerV2.getUIHandlerV2().postDelayed(this$0.removeLoadingCallback, 15000L);
                QLog.d("RobotMsgRepoAbility", 1, "onAddFakeLoadingMsg seq=" + w3.msgSeq);
            }
        }
    }

    private final void H(String errMsg) {
        ArrayList<Long> arrayListOf;
        boolean z16;
        MarkdownMsgItem A = A();
        if (A != null && A.getMsgId() != 0) {
            final MsgRecord msgRecord = A.getMsgRecord();
            Contact contact = new Contact(msgRecord.chatType, msgRecord.peerUid, "");
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(msgRecord.getMsgId()));
            iMsgService.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.s
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    RobotMsgRepoAbility.J(MsgRecord.this, this, i3, str, arrayList);
                }
            });
            if (errMsg.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QQToast.makeText(BaseApplication.getContext(), 1, errMsg, 0).show();
                return;
            }
            return;
        }
        y(this, null, 1, null);
    }

    static /* synthetic */ void I(RobotMsgRepoAbility robotMsgRepoAbility, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = HardCodeUtil.qqStr(R.string.f170280yt3);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.aio_regenerate_fail)");
        }
        robotMsgRepoAbility.H(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(MsgRecord msgRecord, RobotMsgRepoAbility this$0, int i3, String str, ArrayList arrayList) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("RobotMsgRepoAbility", 1, "onRemoveFakeLoading getMsg result=" + i3 + " errMsg=" + str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((MsgRecord) obj).getMsgId() == msgRecord.getMsgId()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MsgRecord msgRecord2 = (MsgRecord) obj;
            if (msgRecord2 != null) {
                this$0.x(MsgListUtil.s(MsgListUtil.f24918a, msgRecord2, false, this$0.d().c().requireContext(), null, 10, null));
            }
        }
    }

    private final void K(final MsgRecord msgRecord) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.removeLoadingCallback);
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.o
            @Override // java.lang.Runnable
            public final void run() {
                RobotMsgRepoAbility.L(RobotMsgRepoAbility.this, msgRecord);
            }
        }, null, 2, null);
        d().e().h(new AIOMsgListEvent.OnUserTriggerMsgRegenerating(msgRecord));
        ((IMsgService) QRoute.api(IMsgService.class)).regenerateMsg(new Contact(msgRecord.chatType, msgRecord.peerUid, ""), msgRecord.getMsgId(), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.p
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RobotMsgRepoAbility.M(MsgRecord.this, this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(RobotMsgRepoAbility this$0, MsgRecord msgRecord) {
        Object lastOrNull;
        boolean z16;
        MarkdownMsgItem markdownMsgItem;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        List<? extends com.tencent.aio.data.msglist.a> M = this$0.e().M();
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) M);
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
        if (aVar != null && aVar.getMsgId() == msgRecord.getMsgId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("RobotMsgRepoAbility", 1, "regenerateMsg last msgId not equal " + msgRecord.getMsgId());
            return;
        }
        MsgRecord v3 = this$0.v(msgRecord);
        AIOMsgItem s16 = MsgListUtil.s(MsgListUtil.f24918a, v3, false, this$0.d().c().requireContext(), null, 10, null);
        if (s16 instanceof MarkdownMsgItem) {
            markdownMsgItem = (MarkdownMsgItem) s16;
        } else {
            markdownMsgItem = null;
        }
        if (markdownMsgItem != null) {
            markdownMsgItem.M2(true);
            CollectionsKt__MutableCollectionsKt.removeLast(M);
            M.add((com.tencent.aio.data.msglist.a) markdownMsgItem);
            AIOMsgRepo e16 = this$0.e();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(markdownMsgItem);
            e16.l0(arrayListOf);
            this$0.e().p0(IMsgListRepository.MsgListRepoOpType.OtherOperation, M, this$0.e().Y0(true, true), "regenerate_msg");
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this$0.removeLoadingCallback, 15000L);
        QLog.d("RobotMsgRepoAbility", 1, "regenerateMsg loading seq=" + v3.msgSeq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(MsgRecord msgRecord, RobotMsgRepoAbility this$0, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotMsgRepoAbility", 1, "regenerateMsg result=" + i3 + ", errMsg=" + errMsg + ", seq=" + msgRecord.getMsgSeq());
        if (i3 != 0) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this$0.removeLoadingCallback);
            boolean z16 = false;
            if (861700 <= i3 && i3 < 861800) {
                z16 = true;
            }
            if (z16) {
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                this$0.H(errMsg);
            } else {
                I(this$0, null, 1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(RobotMsgRepoAbility this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        I(this$0, null, 1, null);
    }

    private final void O() {
        IRobotLoadingMsgFlagService iRobotLoadingMsgFlagService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iRobotLoadingMsgFlagService = (IRobotLoadingMsgFlagService) peekAppRuntime.getRuntimeService(IRobotLoadingMsgFlagService.class, "")) != null) {
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            iRobotLoadingMsgFlagService.removeLoadingMsgFlag(su3.c.b(g16));
        }
    }

    private final void P(final String textContent) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.q
            @Override // java.lang.Runnable
            public final void run() {
                RobotMsgRepoAbility.Q(textContent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(String textContent) {
        Intrinsics.checkNotNullParameter(textContent, "$textContent");
        QLog.i("RobotMsgRepoAbility", 1, "[reportIceBreakMsg]: textContent is " + textContent);
        HashMap hashMap = new HashMap();
        hashMap.put("text_content", textContent);
        com.tencent.mobileqq.aio.utils.b.q("em_bas_greeting", hashMap);
    }

    private final void R(List<com.tencent.aio.data.msglist.a> list) {
        Object last;
        AIOMsgItem aIOMsgItem;
        IRobotLoadingMsgFlagService iRobotLoadingMsgFlagService;
        Object lastOrNull;
        boolean z16;
        ArrayList arrayListOf;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
        MarkdownMsgItem markdownMsgItem = null;
        if (last instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) last;
        } else {
            aIOMsgItem = null;
        }
        if ((aIOMsgItem instanceof MarkdownMsgItem) && ((MarkdownMsgItem) aIOMsgItem).E2()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iRobotLoadingMsgFlagService = (IRobotLoadingMsgFlagService) peekAppRuntime.getRuntimeService(IRobotLoadingMsgFlagService.class, "")) != null) {
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            com.tencent.qqnt.aio.utils.p lastLoadingMsgInfo = iRobotLoadingMsgFlagService.getLastLoadingMsgInfo(su3.c.b(g16));
            if (lastLoadingMsgInfo == null) {
                return;
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - lastLoadingMsgInfo.a();
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar != null && lastLoadingMsgInfo.b() == aVar.getMsgId()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && serverTimeMillis < 15000) {
                AIOMsgItem s16 = MsgListUtil.s(MsgListUtil.f24918a, lastLoadingMsgInfo.c(), false, d().c().requireContext(), null, 10, null);
                if (s16 instanceof MarkdownMsgItem) {
                    markdownMsgItem = (MarkdownMsgItem) s16;
                }
                if (markdownMsgItem != null) {
                    markdownMsgItem.M2(true);
                    markdownMsgItem.x1(false);
                    list.add(markdownMsgItem);
                    AIOMsgRepo e16 = e();
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(markdownMsgItem);
                    e16.l0(arrayListOf);
                    e().p0(IMsgListRepository.MsgListRepoOpType.OtherOperation, list, e().Y0(false, false), "regenerate_msg");
                }
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.removeLoadingCallback, 15000 - serverTimeMillis);
                QLog.d("RobotMsgRepoAbility", 1, "tryToAddLoadingMsg seq=" + lastLoadingMsgInfo.c().msgSeq);
                return;
            }
            AIOParam g17 = d().g();
            Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
            iRobotLoadingMsgFlagService.removeLoadingMsgFlag(su3.c.b(g17));
        }
    }

    private final void S(List<com.tencent.aio.data.msglist.a> list, String source, Bundle extra) {
        Object last;
        final AIOMsgItem aIOMsgItem;
        boolean removeAll;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
        if (last instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) last;
        } else {
            aIOMsgItem = null;
        }
        removeAll = CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<com.tencent.aio.data.msglist.a, Boolean>() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.RobotMsgRepoAbility$tryToFilterLoadingMsg$hasLoading$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgItem.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.aio.data.msglist.a it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                boolean z16 = false;
                if ((it instanceof MarkdownMsgItem) && ((MarkdownMsgItem) it).E2()) {
                    AIOMsgItem aIOMsgItem2 = AIOMsgItem.this;
                    if (!(aIOMsgItem2 != null && it.getMsgId() == aIOMsgItem2.getMsgId())) {
                        z16 = true;
                    }
                }
                if (z16) {
                    QLog.d("RobotMsgRepoAbility", 1, "filterLoadingMsg seq=" + it.getMsgSeq());
                }
                return Boolean.valueOf(z16);
            }
        });
        if (removeAll) {
            if (aIOMsgItem != null) {
                aIOMsgItem.x1(false);
            }
            if (Intrinsics.areEqual(source, "receive_msg") && extra != null) {
                extra.putBoolean("FOCUS_NO_ANIM", true);
            }
        }
    }

    private final void u(long lastMsgId, MsgRecord msgRecord) {
        IRobotLoadingMsgFlagService iRobotLoadingMsgFlagService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iRobotLoadingMsgFlagService = (IRobotLoadingMsgFlagService) peekAppRuntime.getRuntimeService(IRobotLoadingMsgFlagService.class, "")) != null) {
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            iRobotLoadingMsgFlagService.addRobotLoadingMsgFlag(su3.c.b(g16), lastMsgId, msgRecord);
        }
    }

    private final MsgRecord v(MsgRecord originRecord) {
        int i3;
        long j3;
        long j16;
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 14;
        msgElement.markdownElement = new MarkdownElement();
        if (originRecord != null) {
            i3 = com.tencent.qqnt.aio.msg.d.c(originRecord);
        } else {
            i3 = 0;
        }
        msgElement.elementGroupId = i3;
        com.tencent.aio.data.msglist.a e16 = e().F().e();
        long j17 = 0;
        if (e16 != null) {
            j3 = e16.getMsgSeq();
        } else {
            j3 = 0;
        }
        MsgRecord msgRecord = new MsgRecord();
        if (originRecord != null) {
            j17 = originRecord.getMsgId();
        }
        msgRecord.msgId = j17;
        if (originRecord != null) {
            j16 = originRecord.getMsgSeq();
        } else {
            j16 = 1 + j3;
        }
        msgRecord.msgSeq = j16;
        msgRecord.chatType = d().g().r().c().e();
        msgRecord.msgType = 2;
        msgRecord.sendType = 3;
        msgRecord.senderUid = d().g().r().c().j();
        msgRecord.peerUid = d().g().r().c().j();
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        msgRecord.senderUin = su3.c.a(g16);
        AIOParam g17 = d().g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        msgRecord.peerUin = su3.c.a(g17);
        msgRecord.msgTime = System.currentTimeMillis() / 1000;
        msgRecord.sendStatus = 2;
        msgRecord.elements.add(msgElement);
        return msgRecord;
    }

    static /* synthetic */ MsgRecord w(RobotMsgRepoAbility robotMsgRepoAbility, MsgRecord msgRecord, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            msgRecord = null;
        }
        return robotMsgRepoAbility.v(msgRecord);
    }

    private final void x(final com.tencent.aio.data.msglist.a originMsgItem) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.msgrepo.t
            @Override // java.lang.Runnable
            public final void run() {
                RobotMsgRepoAbility.z(RobotMsgRepoAbility.this, originMsgItem);
            }
        }, null, 2, null);
    }

    static /* synthetic */ void y(RobotMsgRepoAbility robotMsgRepoAbility, com.tencent.aio.data.msglist.a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        robotMsgRepoAbility.x(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(RobotMsgRepoAbility this$0, com.tencent.aio.data.msglist.a aVar) {
        Object last;
        boolean z16;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MsgList M = this$0.e().M();
        if (!M.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) M);
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) last;
            if ((aVar2 instanceof MarkdownMsgItem) && ((MarkdownMsgItem) aVar2).E2()) {
                CollectionsKt__MutableCollectionsKt.removeLast(M);
                this$0.O();
                if (aVar != null && aVar2.getMsgId() == aVar.getMsgId()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    AIOMsgRepo e16 = this$0.e();
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aVar);
                    e16.l0(arrayListOf);
                    M.add(aVar);
                }
                BaseMsgRepo.o0(this$0.e(), M, "remove_fake_loading_msg", null, null, 12, null);
                QLog.d("RobotMsgRepoAbility", 1, "onRemoveFakeLoadingMsg seq=" + aVar2.getMsgSeq());
                return;
            }
            QLog.d("RobotMsgRepoAbility", 1, "onRemoveFakeLoadingMsg last is not loading");
            return;
        }
        QLog.d("RobotMsgRepoAbility", 1, "doRemoveFakeLoadingMsg list is empty");
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void a(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItemList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        for (com.tencent.aio.data.msglist.a aVar : msgItemList) {
            if (aVar instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                if (com.tencent.mobileqq.aio.utils.m.f194167a.b(aIOMsgItem).length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    aIOMsgItem.Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(d().c().getContext(), aIOMsgItem));
                }
            }
            if (aVar instanceof ae) {
                ((ae) aVar).m2();
            } else if (aVar instanceof com.tencent.mobileqq.aio.msg.o) {
                ((com.tencent.mobileqq.aio.msg.o) aVar).m2();
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        Object first;
        ae aeVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, source, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(source, "source");
        C(list, source, extra);
        if (this.reported) {
            return;
        }
        this.reported = true;
        if (list.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            if (first instanceof ae) {
                aeVar = (ae) first;
            } else {
                aeVar = null;
            }
            if (aeVar != null && com.tencent.qqnt.aio.msg.d.i(aeVar)) {
                P(B(aeVar));
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgSendEvent.OnMsgSendSuccessEvent) {
            F((AIOMsgSendEvent.OnMsgSendSuccessEvent) intent);
        } else if (intent instanceof AIOMsgListEvent.RegenerateMsg) {
            K(((AIOMsgListEvent.RegenerateMsg) intent).a());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnMsgSendSuccessEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.RegenerateMsg");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Set) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.k();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.removeLoadingCallback);
        this.msgCount = 0;
    }

    @Override // com.tencent.mobileqq.aio.msglist.msgrepo.g
    public void l(@NotNull com.tencent.aio.data.msglist.a newMsgItem, @NotNull com.tencent.aio.data.msglist.a oldMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newMsgItem, (Object) oldMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        Intrinsics.checkNotNullParameter(oldMsgItem, "oldMsgItem");
        E(newMsgItem, oldMsgItem);
        D(newMsgItem, oldMsgItem);
    }
}
