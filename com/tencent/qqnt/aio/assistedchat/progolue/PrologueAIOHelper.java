package com.tencent.qqnt.aio.assistedchat.progolue;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.TofuProcessSimpleEvent;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.a;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.api.IPrologueApi;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$RecommendRsp;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AddLocalRecordMsgParams;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PrologueMsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0002AE\b\u0007\u0018\u0000 K2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0013\u0010\u001a\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\rH\u0003J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0012\u0010+\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-0,H\u0016R\u0016\u00101\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010<\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010G\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006M"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "r", "Lcom/tencent/mvi/base/route/k;", ReportConstant.COSTREPORT_PREFIX, "", "chatType", "", "t", "", "from", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "w", "y", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "rspResult", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", DomainData.DOMAIN_NAME, "o", "p", "v", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "e", "Z", "isPrologueTriggered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasLoadFirstScreenMsg", h.F, "hasReceiveTofuEvent", "i", "hasHandlePrologue", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "waitForTofuTimeoutTask", "com/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper$b;", "action", "com/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper$c", "D", "Lcom/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper$c;", "actionR", "<init>", "()V", "E", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PrologueAIOHelper implements com.tencent.aio.main.businesshelper.h, SimpleEventReceiver<SimpleBaseEvent>, g {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c actionR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isPrologueTriggered;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean hasLoadFirstScreenMsg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean hasReceiveTofuEvent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean hasHandlePrologue;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable waitForTofuTimeoutTask;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper$a;", "", "", "PROLOGUE_TEXT", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.progolue.PrologueAIOHelper$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrologueAIOHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                PrologueAIOHelper.this.r(i3);
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PrologueAIOHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return PrologueAIOHelper.this.s(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60032);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PrologueAIOHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.hasLoadFirstScreenMsg = new AtomicBoolean(false);
        this.hasReceiveTofuEvent = new AtomicBoolean(false);
        this.hasHandlePrologue = new AtomicBoolean(false);
        this.action = new b();
        this.actionR = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Contact contact, final d rspResult) {
        AddLocalRecordMsgParams addLocalRecordMsgParams = new AddLocalRecordMsgParams();
        addLocalRecordMsgParams.needNotify = true;
        addLocalRecordMsgParams.needStore = true;
        addLocalRecordMsgParams.needRecentContact = true;
        addLocalRecordMsgParams.msgElement.prologueMsgElement = new PrologueMsgElement("\u5c1d\u8bd5\u7528\u4ee5\u4e0b\u8bdd\u9898\u5f00\u542f\u804a\u5929\u5427");
        addLocalRecordMsgParams.msgElement.elementType = 46;
        HashMap<Integer, byte[]> hashMap = addLocalRecordMsgParams.extInfos;
        Intrinsics.checkNotNullExpressionValue(hashMap, "addLocalRecordMsgParams.extInfos");
        hashMap.put(1, rspResult.a());
        w e16 = f.e();
        if (e16 != null) {
            e16.b(contact, 29L, addLocalRecordMsgParams, new IOperateCallback() { // from class: com.tencent.qqnt.aio.assistedchat.progolue.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    PrologueAIOHelper.m(PrologueAIOHelper.this, rspResult, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(PrologueAIOHelper this$0, d rspResult, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rspResult, "$rspResult");
        if (i3 == 0) {
            this$0.v(rspResult);
        }
        QLog.i("PrologueAIOHelper", 1, "addLocalRecordMsgWithExtInfo, result=" + i3 + ", errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final boolean n() {
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        a.C9452a c9452a = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        k k3 = bVar.a().e().k(AssistedChatMsgIntent.GetCanShowPrologueMsgIntent.f348980d);
        if (k3 instanceof a.C9452a) {
            c9452a = (a.C9452a) k3;
        }
        if (c9452a != null) {
            return c9452a.a();
        }
        return false;
    }

    private final boolean o() {
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        int e16 = bVar.a().g().r().c().e();
        if (e16 != 1) {
            if (e16 == 104 || e16 == 119) {
                return true;
            }
            return false;
        }
        return p();
    }

    private final boolean p() {
        IPrologueApi iPrologueApi = (IPrologueApi) QRoute.api(IPrologueApi.class);
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "helperParam.aioContext.aioParam");
        boolean c2CNeedRequestPrologue = iPrologueApi.getC2CNeedRequestPrologue(String.valueOf(su3.c.a(g16)));
        QLog.i("PrologueAIOHelper", 1, "checkPrerequisiteForC2C needRequest=" + c2CNeedRequestPrologue + ", hasReceiveTofuEvent=" + this.hasReceiveTofuEvent.get());
        if (c2CNeedRequestPrologue && this.hasReceiveTofuEvent.get()) {
            return true;
        }
        return false;
    }

    private final void q(String from) {
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        int e16 = bVar.a().g().r().c().e();
        QLog.i("PrologueAIOHelper", 1, "checkRequestPrologueMsg from:" + from);
        if (!this.hasLoadFirstScreenMsg.get()) {
            QLog.i("PrologueAIOHelper", 1, "has not LoadFirstScreenMsg.");
            return;
        }
        if (this.hasHandlePrologue.get() || !t(e16)) {
            return;
        }
        IStrangerAssistantAdapterApi iStrangerAssistantAdapterApi = (IStrangerAssistantAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAssistantAdapterApi.class);
        com.tencent.aio.main.businesshelper.b bVar2 = this.helperParam;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar2 = null;
        }
        if (iStrangerAssistantAdapterApi.isLittleAssistant(bVar2.a().g().r().c())) {
            if (QLog.isColorLevel()) {
                QLog.i("PrologueAIOHelper", 2, "checkRequestPrologueMsg isLittleAssistant return");
                return;
            }
            return;
        }
        if (!u()) {
            return;
        }
        if (!o()) {
            QLog.i("PrologueAIOHelper", 1, "Preconditions not satisfied. chatType=" + e16);
            return;
        }
        QLog.i("PrologueAIOHelper", 1, "checkRequestPrologueMsg start. from:" + from);
        if (n()) {
            com.tencent.aio.main.businesshelper.b bVar3 = this.helperParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar3 = null;
            }
            Lifecycle lifecycle = bVar3.a().d().getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "helperParam.aioContext.lifecycleOwner.lifecycle");
            BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getIO(), null, new PrologueAIOHelper$checkRequestPrologueMsg$1(this, null), 2, null);
        } else {
            QLog.i("PrologueAIOHelper", 1, "has send msg.");
        }
        this.hasHandlePrologue.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(MsgIntent intent) {
        if (intent instanceof AssistedChatMsgIntent.PrologueMsgVisibilityChange) {
            AssistedChatMsgIntent.PrologueMsgVisibilityChange prologueMsgVisibilityChange = (AssistedChatMsgIntent.PrologueMsgVisibilityChange) intent;
            if (this.isPrologueTriggered != prologueMsgVisibilityChange.a()) {
                this.isPrologueTriggered = prologueMsgVisibilityChange.a();
                com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                    bVar = null;
                }
                bVar.a().e().h(new AssistedChatMsgIntent.PrologueStatusChange(this.isPrologueTriggered, 0, 2, null));
                return;
            }
            return;
        }
        if (intent instanceof AssistedChatMsgIntent.OnLoadFirstScreenMsg) {
            this.hasLoadFirstScreenMsg.set(true);
            q("OnLoadFirstScreenMsg");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k s(MsgIntent intent) {
        if (intent instanceof AssistedChatMsgIntent.GetPrologueStatusIntent) {
            return new a.b(this.isPrologueTriggered);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final boolean t(int chatType) {
        if (chatType == 1 || chatType == 104 || chatType == 119) {
            return true;
        }
        return false;
    }

    private final boolean u() {
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        return ((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).isExperiment(bVar.a().g().r().c().e());
    }

    private final void v(d rspResult) {
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        int e16 = bVar.a().g().r().c().e();
        if (e16 != 1) {
            if (e16 == 104 || e16 == 119) {
                com.tencent.qqnt.aio.assistedchat.progolue.c cVar = com.tencent.qqnt.aio.assistedchat.progolue.c.f349416a;
                com.tencent.aio.main.businesshelper.b bVar3 = this.helperParam;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                    bVar3 = null;
                }
                cVar.e(e16, bVar3.a().g().r().c().j(), rspResult.c());
            }
        } else {
            IPrologueApi iPrologueApi = (IPrologueApi) QRoute.api(IPrologueApi.class);
            com.tencent.aio.main.businesshelper.b bVar4 = this.helperParam;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar4 = null;
            }
            AIOParam g16 = bVar4.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "helperParam.aioContext.aioParam");
            iPrologueApi.setC2CNeedRequestPrologue(String.valueOf(su3.c.a(g16)), false);
        }
        com.tencent.aio.main.businesshelper.b bVar5 = this.helperParam;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
        } else {
            bVar2 = bVar5;
        }
        bVar2.a().e().h(new AssistedChatMsgIntent.PrologueStatusChange(true, rspResult.c()));
        this.isPrologueTriggered = true;
    }

    private final void w() {
        if (this.hasReceiveTofuEvent.get()) {
            QLog.d("PrologueAIOHelper", 2, "Do not need to post waitForTofuTimeoutTask.");
            return;
        }
        if (this.waitForTofuTimeoutTask == null) {
            this.waitForTofuTimeoutTask = new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.progolue.a
                @Override // java.lang.Runnable
                public final void run() {
                    PrologueAIOHelper.x(PrologueAIOHelper.this);
                }
            };
        }
        Runnable runnable = this.waitForTofuTimeoutTask;
        if (runnable != null) {
            QLog.i("PrologueAIOHelper", 1, "post waitForTofuTimeoutTask.");
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(PrologueAIOHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hasReceiveTofuEvent.set(true);
        this$0.q("WaitForTofuTimeout");
    }

    private final void y() {
        Runnable runnable = this.waitForTofuTimeoutTask;
        if (runnable != null) {
            QLog.i("PrologueAIOHelper", 1, "cancel waitForTofuTimeoutTask.");
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        this.waitForTofuTimeoutTask = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z(Continuation<? super d> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        AIOContact c16 = bVar.a().g().r().c();
        com.tencent.qqnt.aio.assistedchat.request.a.c(com.tencent.qqnt.aio.assistedchat.request.a.f349425a, c16.e(), c16.j(), 1, null, 0, null, 3, true, null, null, new Function3<Integer, String, AssistedChatPB$RecommendRsp, Unit>(cancellableContinuationImpl) { // from class: com.tencent.qqnt.aio.assistedchat.progolue.PrologueAIOHelper$requestPrologueData$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ CancellableContinuation<d> $continuation;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
                this.$continuation = cancellableContinuationImpl;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                invoke(num.intValue(), str, assistedChatPB$RecommendRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable String str, @Nullable AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, assistedChatPB$RecommendRsp);
                    return;
                }
                QLog.i("PrologueAIOHelper", 1, "requestPrologueData response code=" + i3 + " msg=" + str + " rsp=" + assistedChatPB$RecommendRsp);
                if (i3 == 0 && assistedChatPB$RecommendRsp != null) {
                    int i16 = assistedChatPB$RecommendRsp.rsp_head.ret_code.get();
                    d b16 = com.tencent.qqnt.aio.assistedchat.protocolbuffer.a.b(assistedChatPB$RecommendRsp, 1, i16 == 0);
                    b16.l(i16);
                    this.$continuation.resume(b16, AnonymousClass1.INSTANCE);
                    return;
                }
                this.$continuation.resume(new d(false, null, null, 6, null), AnonymousClass2.INSTANCE);
            }
        }, 824, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TofuProcessSimpleEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 54;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.ConfigUpdateIntent");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.PrologueMsgVisibilityChange");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnLoadFirstScreenMsg");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.GetPrologueStatusIntent");
        return hashSet;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "PrologueAIOHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.helperParam = param;
        if (!t(param.a().g().r().c().e())) {
            return;
        }
        IStrangerAssistantAdapterApi iStrangerAssistantAdapterApi = (IStrangerAssistantAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAssistantAdapterApi.class);
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        if (iStrangerAssistantAdapterApi.isLittleAssistant(bVar.a().g().r().c())) {
            if (QLog.isColorLevel()) {
                QLog.i("PrologueAIOHelper", 2, "onCreate isLittleAssistant return");
            }
        } else {
            param.a().e().f(this, this.action);
            param.a().e().l(this, this.actionR);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.action);
        com.tencent.aio.main.businesshelper.b bVar3 = this.helperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a().e().e(this);
        y();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
            return;
        }
        if (state == 4) {
            if (!this.hasLoadFirstScreenMsg.get()) {
                this.hasLoadFirstScreenMsg.set(true);
                q("DELAY_LOAD");
            }
            com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar = null;
            }
            if (bVar.a().g().r().c().e() == 1) {
                w();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        if (event instanceof TofuProcessSimpleEvent) {
            com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar = null;
            }
            if (bVar.a().g().r().c().e() != 1) {
                return;
            }
            if (this.hasReceiveTofuEvent.get()) {
                QLog.i("PrologueAIOHelper", 1, "onReceive TofuProcessSimpleEvent but too late.");
                return;
            }
            y();
            this.hasReceiveTofuEvent.set(true);
            q("TofuProcessSimpleEvent");
        }
    }
}
