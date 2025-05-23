package h81;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.PhotoPanelEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.input.adorn.c;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent;
import com.tencent.mobileqq.aio.input.inputbar.compat.AIOInputBarCompatMsgIntent;
import com.tencent.mobileqq.aio.input.inputbar.compat.AIOInputBarCompatUIState;
import com.tencent.mobileqq.aio.input.inputbar.compat.a;
import com.tencent.mobileqq.aio.input.inputbar.compat.c;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0006*\u00014\b\u0007\u0018\u0000 \u00182\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u0007:\u00018B\u000f\u0012\u0006\u0010/\u001a\u00020\u0005\u00a2\u0006\u0004\b7\u0010.J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\rH\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\bH\u0016R\"\u0010/\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u00100R\u0016\u00103\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00105\u00a8\u00069"}, d2 = {"Lh81/b;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/g;", "", "r", "u", h.F, "v", "", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "isImmersive", "w", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "f", "isGagMode", "l", "g", "p", "i", DomainData.DOMAIN_NAME, "isFullScreenMode", "j", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "e", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "o", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/inputbar/compat/a;", "d0", "intent", "k", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "t", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mContext", "Z", "isInGagMode", "h81/b$b", "Lh81/b$b;", "mAction", "<init>", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b implements e<at.a, InputUIState, com.tencent.aio.api.runtime.a, c>, g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInGagMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10423b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"h81/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: h81.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C10423b implements com.tencent.mvi.base.route.a {
        C10423b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            b.this.f(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public b(@NotNull c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mAction = new C10423b();
    }

    private final int e() {
        c.a aVar = new c.a(0, 1, null);
        getMHost().fetchVBState(aVar);
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MsgIntent event) {
        if (event instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            g();
            return;
        }
        if (event instanceof PhotoPanelEvent.SelectMediaChanged) {
            y(new AIOInputBarCompatUIState.RefreshSendBtn(((PhotoPanelEvent.SelectMediaChanged) event).a().size(), null, 2, null));
            return;
        }
        if (event instanceof PhotoPanelEvent.OnPictureNumberAboveInputChanged) {
            y(new AIOInputBarCompatUIState.RefreshSendBtn(((PhotoPanelEvent.OnPictureNumberAboveInputChanged) event).a(), null, 2, null));
            return;
        }
        if (event instanceof ThemeEvent.PostThemeChanged) {
            m();
            return;
        }
        if (event instanceof InputEditTextMsgIntent.AfterAddEmoticonToEditText) {
            s();
            return;
        }
        if (event instanceof InputGagMsgIntent.OnInputGagModeChanged) {
            l(((InputGagMsgIntent.OnInputGagModeChanged) event).a());
            return;
        }
        if (event instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            j(((FullScreenMsgIntent.OnFullScreenModeChanged) event).a());
            return;
        }
        if (event instanceof FullScreenMsgIntent.OnFullScreenAnimStartMsgIntent) {
            i();
        } else if (event instanceof AIOInputBarCompatMsgIntent.GetInputBarTopMargin) {
            ((AIOInputBarCompatMsgIntent.GetInputBarTopMargin) event).b(e());
        } else if (event instanceof AIOBackgroundMsgIntent.ImmersiveChangeMsg) {
            v();
        }
    }

    private final void g() {
        if (!this.isInGagMode) {
            q();
        }
    }

    private final void h() {
        v();
    }

    private final void i() {
        y(new AIOInputBarCompatUIState.ChangeStyleForFullScreenMode(true, n()));
    }

    private final void j(boolean isFullScreenMode) {
        if (!isFullScreenMode) {
            v();
        }
    }

    private final void l(boolean isGagMode) {
        this.isInGagMode = isGagMode;
        p(isGagMode);
    }

    private final void m() {
        QLog.i("AIOInputBarCompatVMDelegate", 1, "handleOnThemeChanged");
        v();
        y(AIOInputBarCompatUIState.PostThemeChanged.f189707d);
    }

    private final boolean n() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        long a16 = su3.c.a(g16);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(a16), Integer.valueOf(aVar2.g().r().c().e()));
    }

    private final void p(boolean isGagMode) {
        if (isGagMode) {
            y(new AIOInputBarCompatUIState.RefreshSendBtn(0, AIOInputBarCompatUIState.RefreshSendBtn.RefreshFlag.FLAG_FORCE_DISABLE));
        } else {
            q();
        }
    }

    private final void q() {
        d.h hVar;
        int i3;
        d.i iVar;
        List<com.tencent.mobileqq.album.ext.c> b16;
        List<com.tencent.mobileqq.album.media.c> a16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        k k3 = aVar.e().k(InputEvent.GetSelectMedia.f188575d);
        if (k3 instanceof d.h) {
            hVar = (d.h) k3;
        } else {
            hVar = null;
        }
        int i16 = 0;
        if (hVar != null && (a16 = hVar.a()) != null) {
            i3 = a16.size();
        } else {
            i3 = 0;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar2 = null;
        }
        k k16 = aVar2.e().k(InputEvent.RobotGetSelectMediaInfo.f188580d);
        if (k16 instanceof d.i) {
            iVar = (d.i) k16;
        } else {
            iVar = null;
        }
        if (iVar != null && (b16 = iVar.b()) != null) {
            i16 = b16.size();
        }
        y(new AIOInputBarCompatUIState.RefreshSendBtn(i3 + i16, null, 2, null));
    }

    private final void r() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().f(this, this.mAction);
    }

    private final void s() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(InputEditTextMsgIntent.RequestEditTextFocus.f189419d);
    }

    private final void u() {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
    }

    private final void v() {
        boolean z16;
        AIOUtil aIOUtil = AIOUtil.f194084a;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        boolean c16 = aIOUtil.c(aVar);
        if (!c16) {
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar3;
            }
            if (!aIOUtil.b(aVar2)) {
                z16 = false;
                w(z16, c16);
            }
        }
        z16 = true;
        w(z16, c16);
    }

    private final void w(boolean isTransparent, boolean isImmersive) {
        y(new AIOInputBarCompatUIState.SetBackgroundTransparent(isTransparent, isImmersive));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        return com.tencent.mobileqq.aio.input.inputbar.compat.a.class;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.AfterAddEmoticonToEditText");
        hashSet.add("com.tencent.mobileqq.aio.event.PhotoPanelEvent.SelectMediaChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.ThemeEvent.PostThemeChanged");
        hashSet.add("com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent.OnInputGagModeChanged");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.OnFullScreenModeChanged");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.OnFullScreenAnimStartMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.inputbar.compat.AIOInputBarCompatMsgIntent.GetInputBarTopMargin");
        hashSet.add("com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent.ImmersiveChangeMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.PhotoPanelEvent.OnPictureNumberAboveInputChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7272a) {
            h();
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        r();
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        u();
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void y(@NotNull InputUIState inputUIState) {
        e.a.b(this, inputUIState);
    }
}
