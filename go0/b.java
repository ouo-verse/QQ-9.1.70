package go0;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.input.at.DMSlashMsgIntent;
import com.tencent.guild.aio.input.at.DMSlashUIState;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import go0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\t*\u0001\u001d\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lgo0/b;", "Lcom/tencent/aio/base/mvvm/b;", "Lgo0/a;", "Lcom/tencent/guild/aio/input/at/DMSlashUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "action", "", DomainData.DOMAIN_NAME, "", "isEnable", "p", "Lcom/tencent/aio/part/root/panel/mvx/intent/PanelStatusIntent$PanelStatusChangeIntent;", "o", "Lrr1/i;", "notifyData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "e", "Lcom/tencent/aio/part/root/panel/mvx/intent/PanelStatusIntent$PanelStatusChangeIntent;", "mCurPanelState", "go0/b$b", "f", "Lgo0/b$b;", "msgSendAction", "<init>", "()V", tl.h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.b<a, DMSlashUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PanelStatusIntent.PanelStatusChangeIntent mCurPanelState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10392b msgSendAction = new C10392b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"go0/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: go0.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C10392b implements com.tencent.mvi.base.route.a {
        C10392b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            b.this.n(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void m(rr1.i notifyData) {
        if (q(notifyData)) {
            updateUI(DMSlashUIState.AioHideUIState.f110878d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MsgIntent action) {
        if (action instanceof MFGestureListIntent.NotifyEvent) {
            m(((MFGestureListIntent.NotifyEvent) action).getNotifyData());
        } else if (action instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            o((PanelStatusIntent.PanelStatusChangeIntent) action);
        } else if (action instanceof DMSlashMsgIntent.SetSlashAbility) {
            p(((DMSlashMsgIntent.SetSlashAbility) action).getIsEnable());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r2) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o(PanelStatusIntent.PanelStatusChangeIntent action) {
        Boolean bool;
        Boolean b16 = action.b();
        PanelStatusIntent.PanelStatusChangeIntent panelStatusChangeIntent = this.mCurPanelState;
        Integer num = null;
        if (panelStatusChangeIntent != null) {
            bool = panelStatusChangeIntent.b();
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(b16, bool)) {
            Integer a16 = action.a();
            PanelStatusIntent.PanelStatusChangeIntent panelStatusChangeIntent2 = this.mCurPanelState;
            if (panelStatusChangeIntent2 != null) {
                num = panelStatusChangeIntent2.a();
            }
        }
        if (!Intrinsics.areEqual(action.b(), Boolean.TRUE) && action.a() != null) {
            updateUI(DMSlashUIState.DismissSlashPanel.f110879d);
        }
        this.mCurPanelState = action;
    }

    private final void p(boolean isEnable) {
        updateUI(new DMSlashUIState.SetSlashAbilityUIState(isEnable));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.aio.api.runtime.a aVar = null;
        if (intent instanceof a.b) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar2;
            }
            AIOParam g16 = aVar.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            updateUI(new DMSlashUIState.RefreshBotBtnUIState(g16));
            return;
        }
        if (intent instanceof a.C10391a) {
            com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar3;
            }
            updateUI(new DMSlashUIState.InitSlashUIState(aVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(DMSlashMsgIntent.SetSlashAbility.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.msgSendAction);
    }

    public final boolean q(@NotNull rr1.i notifyData) {
        Intrinsics.checkNotNullParameter(notifyData, "notifyData");
        if (notifyData.f() == 1 && notifyData.a() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.aioContext = context;
        context.e().d(Reflection.getOrCreateKotlinClass(DMSlashMsgIntent.SetSlashAbility.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.msgSendAction);
    }
}
