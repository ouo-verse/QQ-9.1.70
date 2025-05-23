package com.tencent.qqnt.aio.assistedchat.input;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.simpleui.InputSimpleUIMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.input.AssistedChatInputUIState;
import com.tencent.qqnt.aio.assistedchat.input.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006*\u00010\b\u0007\u0018\u0000 72\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u0007:\u00018B\u000f\u0012\u0006\u0010(\u001a\u00020\u0005\u00a2\u0006\u0004\b6\u0010'J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\"\u0010(\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010)R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010+R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010+R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010+R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00101R\u0014\u00105\u001a\u0002038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/d;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "l", "", "checkBubbleTip", h.F, "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "msgIntent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isSelected", "j", "", "e", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "r", "g", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/Class;", "d0", "k", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "f", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "p", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Z", "isFullScreenMode", "isPressToSpeakMode", "i", "isIconVisible", "com/tencent/qqnt/aio/assistedchat/input/d$b", "Lcom/tencent/qqnt/aio/assistedchat/input/d$b;", "action", "", "()I", "chatType", "<init>", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes23.dex */
public final class d implements e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, g {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isFullScreenMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPressToSpeakMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isIconVisible;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/input/d$a;", "", "", "KEY_LAST_SHOW_BUBBLE_TIP_TIME", "Ljava/lang/String;", "KEY_NEED_SHAKE_ICON", "KEY_NEED_SHOW_BUBBLE_TIP", "KEY_SHOW_BUBBLE_TIP_COUNT", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.input.d$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/input/d$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                d.this.l(i3);
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
            this.action = new b();
        }
    }

    private final int d() {
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            return c16.e();
        }
        return 0;
    }

    private final String e() {
        CharSequence a16;
        String obj;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        d.C7264d c7264d = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        j e16 = aVar.e();
        if (e16 == null) {
            return "";
        }
        k k3 = e16.k(new InputEvent.GetInputString());
        if (k3 instanceof d.C7264d) {
            c7264d = (d.C7264d) k3;
        }
        if (c7264d == null || (a16 = c7264d.a()) == null || (obj = a16.toString()) == null) {
            return "";
        }
        return obj;
    }

    private final void g() {
        String str;
        if (!this.isIconVisible) {
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = "assisted_chat_need_shake_icon_" + str + "_" + d();
        if (fromV2.getBoolean(str2, true)) {
            u(AssistedChatInputUIState.ShakeIconState.f349092d);
            fromV2.putBoolean(str2, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(boolean checkBubbleTip) {
        boolean z16;
        boolean z17;
        Integer a16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        h.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        AIOContact c16 = aVar.g().r().c();
        boolean z18 = true;
        if (!this.isPressToSpeakMode && !this.isFullScreenMode) {
            a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
            if (((IAssistedChatAdapterApi) companion.a(IAssistedChatAdapterApi.class)).isExperiment(c16.e()) && !((IStrangerAssistantAdapterApi) companion.a(IStrangerAssistantAdapterApi.class)).isLittleAssistant(c16)) {
                z16 = true;
                if (!checkBubbleTip && z16) {
                    z17 = n();
                    if (z17) {
                        s();
                        r();
                    }
                } else {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AssistedChatInputVMDelegate", 2, "assisted chat icon visible:" + z16 + " showBubbleTip:" + z17);
                }
                this.isIconVisible = z16;
                u(new AssistedChatInputUIState.ChangeVisibilityState(z16, z17));
                if (!z16) {
                    com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                        aVar3 = null;
                    }
                    k k3 = aVar3.e().k(PanelContainerMsgIntent.GetPanelContainerStateMsgIntent.f116805d);
                    if (k3 instanceof h.a) {
                        aVar2 = (h.a) k3;
                    }
                    if (aVar2 == null) {
                        return;
                    }
                    if (!aVar2.c() || (a16 = aVar2.a()) == null || a16.intValue() != 1014) {
                        z18 = false;
                    }
                    u(new AssistedChatInputUIState.ChangeSelectedState(z18));
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!checkBubbleTip) {
        }
        z17 = false;
        if (QLog.isColorLevel()) {
        }
        this.isIconVisible = z16;
        u(new AssistedChatInputUIState.ChangeVisibilityState(z16, z17));
        if (!z16) {
        }
    }

    static /* synthetic */ void i(d dVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        dVar.h(z16);
    }

    private final void j(boolean isSelected) {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (isSelected) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar2;
            }
            j e16 = aVar.e();
            if (e16 != null) {
                e16.h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
                return;
            }
            return;
        }
        String e17 = e();
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar3;
        }
        j e18 = aVar.e();
        if (e18 != null) {
            int i3 = 1;
            if (e17.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = 2;
            }
            e18.h(new AssistedChatMsgIntent.ShowAssistedChatPanelIntent("input_icon", i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(MsgIntent intent) {
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            m((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent);
            return;
        }
        if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            this.isFullScreenMode = ((FullScreenMsgIntent.OnFullScreenModeChanged) intent).a();
            h(false);
        } else if (intent instanceof InputSimpleUIMsgIntent.OnPressToSpeakModeChange) {
            this.isPressToSpeakMode = ((InputSimpleUIMsgIntent.OnPressToSpeakModeChange) intent).a();
            h(false);
        } else if (intent instanceof AssistedChatMsgIntent.OnAutoPolishTriggerUpperLimit) {
            g();
        }
    }

    private final void m(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent msgIntent) {
        boolean z16;
        if (msgIntent.b() && msgIntent.a() == 1014) {
            z16 = true;
        } else {
            z16 = false;
        }
        u(new AssistedChatInputUIState.ChangeSelectedState(z16));
        if (z16) {
            q();
        }
    }

    private final boolean n() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        if (!fromV2.getBoolean("assisted_chat_need_show_bubble_tip_" + d(), true)) {
            return false;
        }
        if (fromV2.getInt("assisted_chat_show_bubble_tip_count_" + d(), 0) >= 3) {
            return false;
        }
        if (System.currentTimeMillis() - fromV2.getLong("assisted_chat_last_show_bubble_tip_time_" + d(), 0L) >= 604800000) {
            return true;
        }
        return false;
    }

    private final void q() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        fromV2.putBoolean("assisted_chat_need_show_bubble_tip_" + d(), false);
    }

    private final void r() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        fromV2.putLong("assisted_chat_last_show_bubble_tip_time_" + d(), System.currentTimeMillis());
    }

    private final void s() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        int i3 = fromV2.getInt("assisted_chat_show_bubble_tip_count_" + d(), 0);
        fromV2.putInt("assisted_chat_show_bubble_tip_count_" + d(), i3 + 1);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            e.a.a(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.OnFullScreenModeChanged");
        hashSet.add("com.tencent.mobileqq.aio.input.simpleui.InputSimpleUIMsgIntent.OnPressToSpeakModeChange");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnAutoPolishTriggerUpperLimit");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.aio.api.runtime.a aVar = null;
        if (intent instanceof a.c) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar2;
            }
            u(new AssistedChatInputUIState.SetAIOContextState(aVar));
            return;
        }
        if (intent instanceof a.b) {
            j(((a.b) intent).a());
        } else if (intent instanceof a.C9455a) {
            i(this, false, 1, null);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.aioContext = context;
        j e16 = context.e();
        if (e16 != null) {
            e16.f(this, this.action);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        j e16 = aVar.e();
        if (e16 != null) {
            e16.i(this, this.action);
        }
        this.isFullScreenMode = false;
        this.isPressToSpeakMode = false;
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) inputUIState);
        } else {
            e.a.b(this, inputUIState);
        }
    }
}
