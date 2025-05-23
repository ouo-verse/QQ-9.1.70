package com.tencent.mobileqq.aio.msglist.holder.component.reply;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.msg.MsgSimpleInfo;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.msg.u;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.ReplyUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.h;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.al;
import com.tencent.mobileqq.aio.utils.av;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.adapter.api.IArkApi;
import com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001(\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\fH\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020&H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R&\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020(0-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u0007R\u0016\u00107\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001d\u0010=\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/reply/AIOReplyComponentVM;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigationResultNotify;", "J", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Landroid/view/View;", "videoView", "L", "picMsgElement", "imageView", "K", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "replyMsgRecord", "Lcom/tencent/mobileqq/aio/msg/u;", "clickedView", "M", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "viewNode", "", "busId", "G", "", "D", UserInfo.SEX_FEMALE, "msgRecord", "N", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/aio/holder/a;", "o", "com/tencent/mobileqq/aio/msglist/holder/component/reply/AIOReplyComponentVM$a", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/reply/AIOReplyComponentVM$a;", "mAction", "", "Lkotlin/Pair;", "", tl.h.F, "Ljava/util/List;", "mMsgList", "", "i", "replayMsgSeq", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "replyNick", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/config/b;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "H", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/config/b;", "richReplyClickConfigData", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOReplyComponentVM extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy richReplyClickConfigData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, a>> mMsgList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long replayMsgSeq;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String replyNick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/reply/AIOReplyComponentVM$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOReplyComponentVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIOReplyComponentVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    public AIOReplyComponentVM() {
        List<Pair<String, a>> listOf;
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        a aVar = new a();
        this.mAction = aVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Pair(j.f352301a.a(Reflection.getOrCreateKotlinClass(MsgNavigationEvent.NavigationResultNotify.class)), aVar));
        this.mMsgList = listOf;
        this.replyNick = "";
        lazy = LazyKt__LazyJVMKt.lazy(AIOReplyComponentVM$richReplyClickConfigData$2.INSTANCE);
        this.richReplyClickConfigData = lazy;
    }

    private final boolean D(MsgRecord replyMsgRecord) {
        ArrayList<MsgElement> arrayList;
        String str;
        if (replyMsgRecord.msgType == 11 && (arrayList = replyMsgRecord.elements) != null && arrayList != null) {
            for (MsgElement msgElement : arrayList) {
                if (msgElement.elementType == 10 && msgElement.arkElement != null) {
                    try {
                        ArkElement arkElement = msgElement.arkElement;
                        if (arkElement != null) {
                            str = arkElement.bytesData;
                        } else {
                            str = null;
                        }
                        boolean handleArkQuoteOpenUrl = ((IArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IArkApi.class)).handleArkQuoteOpenUrl(0, new JSONObject(String.valueOf(str)));
                        if (QLog.isColorLevel()) {
                            QLog.i(FrameworkVM.TAG, 1, "[handleReplySourceClick]: canArkJump " + handleArkQuoteOpenUrl);
                        }
                        if (handleArkQuoteOpenUrl) {
                            return true;
                        }
                    } catch (Throwable th5) {
                        QLog.e(FrameworkVM.TAG, 1, "[canArkJump]: exception: ", th5);
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof MsgNavigationEvent.NavigationResultNotify) {
            J((MsgNavigationEvent.NavigationResultNotify) intent);
        }
    }

    private final boolean F(MsgRecord replyMsgRecord) {
        ArrayList<MsgElement> arrayList;
        int i3 = replyMsgRecord.msgType;
        if ((i3 == 2 || i3 == 9 || i3 == 17 || i3 == 24 || i3 == 11 || i3 == 6) && (arrayList = replyMsgRecord.elements) != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                int i16 = ((MsgElement) it.next()).elementType;
                if (i16 == 6 || i16 == 1 || i16 == 11 || i16 == 27 || i16 == 10 || i16 == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G(k viewNode, int busId) {
        com.tencent.android.androidbypass.richui.viewdata.j jVar;
        com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.b H;
        String a16;
        k g16;
        com.tencent.aio.api.runtime.a aVar;
        Fragment c16;
        Context it;
        if (viewNode instanceof com.tencent.android.androidbypass.richui.viewdata.j) {
            jVar = (com.tencent.android.androidbypass.richui.viewdata.j) viewNode;
        } else {
            jVar = null;
        }
        if (jVar != null && (H = H()) != null && (a16 = H.a(busId, jVar.F())) != null && (g16 = ((com.tencent.android.androidbypass.richui.viewdata.j) viewNode).g(a16)) != null && (aVar = (com.tencent.aio.api.runtime.a) getSafetyContext()) != null && (c16 = aVar.c()) != null && (it = c16.requireContext()) != null) {
            IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            iAIOJumpAction.doUrlAction(it, g16.k());
        }
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.b H() {
        return (com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.b) this.richReplyClickConfigData.getValue();
    }

    private final void J(MsgNavigationEvent.NavigationResultNotify intent) {
        if (intent.a() == this.replayMsgSeq && !intent.c()) {
            updateUI(AIOMsgItemUIState.ReplayNavigationFail.f190561d);
            this.replayMsgSeq = 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K(AIOMsgItem msgItem, MsgElement picMsgElement, View imageView) {
        z.a aVar;
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgListEvent.GetAIORichMediaMsgListEvent(msgItem.getMsgRecord()));
        List<AIOMsgItem> list = null;
        if (k3 instanceof z.a) {
            aVar = (z.a) k3;
        } else {
            aVar = null;
        }
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        if (aVar != null) {
            list = aVar.a();
        }
        IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, peekAppRuntime, requireContext, imageView, msgItem, picMsgElement, false, null, list, false, 256, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L(AIOMsgItem msgItem, MsgElement msgElement, View videoView) {
        z.a aVar;
        boolean z16;
        List<AIOMsgItem> list;
        MsgRecord msgRecord = msgItem.getMsgRecord();
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgListEvent.GetAIORichMediaMsgListEvent(msgRecord));
        List<AIOMsgItem> list2 = null;
        if (k3 instanceof z.a) {
            aVar = (z.a) k3;
        } else {
            aVar = null;
        }
        boolean z17 = true;
        if (msgElement != null && msgElement.elementType == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
            if (aVar != null) {
                list2 = aVar.a();
            }
            iRichMediaBrowserApi.enterVideoPreview(peekAppRuntime, requireContext, videoView, msgItem, 0L, false, false, null, list2);
            return;
        }
        if (msgElement == null || msgElement.elementType != 2) {
            z17 = false;
        }
        if (z17) {
            IRichMediaBrowserApi iRichMediaBrowserApi2 = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime2, "sMobileQQ.peekAppRuntime()");
            Context requireContext2 = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "mContext.fragment.requireContext()");
            if (aVar != null) {
                list = aVar.a();
            } else {
                list = null;
            }
            IRichMediaBrowserApi.a.a(iRichMediaBrowserApi2, peekAppRuntime2, requireContext2, videoView, msgItem, msgElement, false, null, list, false, 256, null);
            return;
        }
        if (MsgExtKt.w(msgRecord)) {
            Iterator<MsgElement> it = msgRecord.elements.iterator();
            FileElement fileElement = null;
            while (it.hasNext()) {
                MsgElement next = it.next();
                if (next.elementType == 3) {
                    fileElement = next.fileElement;
                }
            }
            Context requireContext3 = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext3, "mContext.fragment.requireContext()");
            AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
            aIOMsgItem.O1(msgItem.s0());
            aIOMsgItem.L1(msgItem.k0());
            if (aVar != null) {
                list2 = aVar.a();
            }
            c81.a.f(requireContext3, aIOMsgItem, fileElement, videoView, list2, false, 32, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M(MsgRecord replyMsgRecord, u msgItem, View clickedView) {
        AIOReplyComponentVM aIOReplyComponentVM;
        MarkdownElement markdownElement;
        if (!msgItem.M0() && al.c(replyMsgRecord)) {
            QLog.i(FrameworkVM.TAG, 1, "[handleReplySourceClick]: reply multiforward, msgId is " + replyMsgRecord.msgId);
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.k(AIOUtil.f194084a.h(((com.tencent.aio.api.runtime.a) getMContext()).g().r()), msgItem.q0(), msgItem.getMsgId()), new AIOReplyComponentVM$handleReplySourceClick$1(clickedView, this, msgItem, null)), Dispatchers.getMain()), vmScope());
            return;
        }
        if (D(replyMsgRecord)) {
            return;
        }
        if (!msgItem.M0() && F(replyMsgRecord)) {
            av avVar = av.f194117a;
            avVar.f((com.tencent.aio.api.runtime.a) getMContext(), msgItem, false, avVar.e(msgItem), replyMsgRecord.msgId);
            return;
        }
        if (N(replyMsgRecord, msgItem, clickedView)) {
            return;
        }
        if (!msgItem.M0() && msgItem.C2().d() != null) {
            QLog.i(FrameworkVM.TAG, 1, "handleReplyPicClick");
            AIOMsgItem aIOMsgItem = new AIOMsgItem(replyMsgRecord);
            long q06 = msgItem.q0();
            int i3 = aIOMsgItem.getMsgRecord().chatType;
            int i16 = aIOMsgItem.getMsgRecord().sendType;
            String str = aIOMsgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
            long j3 = aIOMsgItem.getMsgRecord().peerUin;
            long j16 = msgItem.getMsgRecord().msgId;
            int i17 = msgItem.getMsgRecord().chatType;
            int i18 = msgItem.getMsgRecord().sendType;
            String str2 = msgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
            aIOMsgItem.L1(new MsgRecordParams(q06, i3, i16, str, j3, new MsgRecordParams(j16, i17, i18, str2, msgItem.getMsgRecord().peerUin, null, 32, null)));
            aIOMsgItem.M1(msgItem.m0());
            aIOReplyComponentVM = this;
            aIOReplyComponentVM.L(aIOMsgItem, msgItem.C2().d(), clickedView);
        } else {
            aIOReplyComponentVM = this;
        }
        if (!msgItem.M0() && com.tencent.mobileqq.aio.utils.d.S(replyMsgRecord)) {
            long j17 = msgItem.getMsgRecord().peerUin;
            long j18 = replyMsgRecord.peerUin;
            if (j17 != 0 && j18 != 0 && j17 != j18) {
                av avVar2 = av.f194117a;
                avVar2.f((com.tencent.aio.api.runtime.a) getMContext(), msgItem, false, avVar2.e(msgItem), replyMsgRecord.msgId);
                return;
            }
            ArrayList<MsgElement> arrayList = replyMsgRecord.elements;
            if (arrayList != null) {
                for (MsgElement msgElement : arrayList) {
                    if (msgElement.elementType == 14 && (markdownElement = msgElement.markdownElement) != null) {
                        Intrinsics.checkNotNullExpressionValue(markdownElement, "markdownElement");
                        com.tencent.qqnt.markdown.c cVar = com.tencent.qqnt.markdown.c.f359326a;
                        String str3 = markdownElement.content;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.content");
                        for (com.tencent.android.androidbypass.viewgroup.b bVar : cVar.b(str3, new HashMap<>(), new JSONObject(), null).a()) {
                            if (bVar instanceof com.tencent.android.androidbypass.viewgroup.f) {
                                aIOReplyComponentVM.G(((com.tencent.android.androidbypass.viewgroup.f) bVar).e(), markdownElement.mdExtType);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean N(MsgRecord msgRecord, u msgItem, View clickedView) {
        MsgElement i3;
        z.a aVar;
        if (!MsgExtKt.w(msgRecord) || (i3 = MsgExtKt.i(msgRecord, 3)) == null) {
            return false;
        }
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgListEvent.GetAIORichMediaMsgListEvent(msgRecord));
        List<AIOMsgItem> list = null;
        if (k3 instanceof z.a) {
            aVar = (z.a) k3;
        } else {
            aVar = null;
        }
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        aIOMsgItem.O1(msgItem.s0());
        FileElement fileElement = i3.fileElement;
        if (aVar != null) {
            list = aVar.a();
        }
        c81.a.f(requireContext, aIOMsgItem, fileElement, clickedView, list, false, 32, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.am) {
            d.am amVar = (d.am) intent;
            L(amVar.b(), amVar.a(), amVar.c());
            return;
        }
        if (intent instanceof d.ac) {
            d.ac acVar = (d.ac) intent;
            K(acVar.b(), acVar.c(), acVar.a());
            return;
        }
        if (intent instanceof d.ao) {
            d.ao aoVar = (d.ao) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(2, new AIOMsgListEvent.SelectEvent(aoVar.a(), aoVar.b(), aoVar.c()), null, 4, null));
            return;
        }
        boolean z16 = false;
        MsgSimpleInfo msgSimpleInfo = null;
        a.C9495a c9495a = null;
        if (intent instanceof d.p) {
            com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new StreamMsgEvent.GetAnimStatus(null));
            if (k3 instanceof a.C9495a) {
                c9495a = (a.C9495a) k3;
            }
            d.p pVar = (d.p) intent;
            if (c9495a != null && c9495a.a()) {
                z16 = true;
            }
            pVar.b(z16);
            return;
        }
        if (intent instanceof d.g) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.DismissSelectMenu(((d.g) intent).a()));
            return;
        }
        if (intent instanceof d.ag) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.ReappearSelectMenu.f188367d);
            return;
        }
        if (intent instanceof p.o) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.SelectAll.f188375d);
            return;
        }
        if (intent instanceof h.b) {
            if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_reply_comeback_switch_9020", false)) {
                msgSimpleInfo = ((h.b) intent).c();
            }
            h.b bVar = (h.b) intent;
            if (bVar.b() > 0) {
                this.replayMsgSeq = bVar.b();
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateBySeqEvent("reply_msg", bVar.b(), 0L, false, null, false, false, msgSimpleInfo, 124, null));
                return;
            } else {
                if (bVar.a() > 0) {
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateByIdEvent("reply_msg", bVar.a(), false, null, false, msgSimpleInfo, 28, null));
                    return;
                }
                return;
            }
        }
        if (intent instanceof h.d) {
            h.d dVar = (h.d) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateByTimeEvent("reply_msg", dVar.a(), dVar.b(), false, null, 24, null));
            return;
        }
        if (intent instanceof d.an) {
            d.an anVar = (d.an) intent;
            M(anVar.c(), anVar.b(), anVar.a());
            return;
        }
        if (intent instanceof d.w) {
            av.g(av.f194117a, (com.tencent.aio.api.runtime.a) getMContext(), ((d.w) intent).a(), false, null, 0L, 28, null);
            return;
        }
        if (intent instanceof d.y) {
            av.g(av.f194117a, (com.tencent.aio.api.runtime.a) getMContext(), ((d.y) intent).a(), true, null, 0L, 24, null);
            return;
        }
        if (intent instanceof h.c) {
            h.c cVar = (h.c) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateForMultiForward(cVar.a(), cVar.c(), cVar.b()));
            return;
        }
        if (intent instanceof h.a) {
            if (!TextUtils.isEmpty(this.replyNick)) {
                ((h.a) intent).c(this.replyNick);
                return;
            } else {
                if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 2) {
                    QRouteApi api = QRoute.api(INtTroopMemberApi.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(INtTroopMemberApi::class.java)");
                    INtTroopMemberApi.a.a((INtTroopMemberApi) api, ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), ((h.a) intent).b(), false, true, FrameworkVM.TAG, new Function1<com.tencent.qqnt.aio.adapter.troop.a, Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.reply.AIOReplyComponentVM$handleIntent$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOReplyComponentVM.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.aio.adapter.troop.a aVar) {
                            invoke2(aVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull com.tencent.qqnt.aio.adapter.troop.a nickInfo) {
                            String str;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) nickInfo);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(nickInfo, "nickInfo");
                            AIOReplyComponentVM.this.replyNick = com.tencent.qqnt.aio.adapter.troop.a.f(nickInfo, false, false, 3, null);
                            AIOReplyComponentVM aIOReplyComponentVM = AIOReplyComponentVM.this;
                            str = aIOReplyComponentVM.replyNick;
                            aIOReplyComponentVM.updateUI(new ReplyUIState.FetchNickRefresh(str));
                        }
                    }, 4, null);
                    return;
                }
                return;
            }
        }
        super.handleIntent(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        Iterator<T> it = this.mMsgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.mMsgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }
}
