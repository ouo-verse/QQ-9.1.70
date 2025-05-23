package f81;

import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.qwallet.RedPacketPanelState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.j;
import f81.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u000f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lf81/e;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lf81/c;", "Lcom/tencent/mobileqq/aio/qwallet/RedPacketPanelState;", "intent", "", "l", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "e", "Ljava/lang/String;", "panelChangeMsgType", "f81/e$a", "f", "Lf81/e$a;", "panelChangeAction", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends com.tencent.qqnt.aio.baseVM.a<c, RedPacketPanelState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String panelChangeMsgType = j.f352301a.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class));

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a panelChangeAction = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"f81/e$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            PanelContainerMsgIntent.OnPanelStateChangedMsgIntent onPanelStateChangedMsgIntent;
            boolean z16;
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
                onPanelStateChangedMsgIntent = (PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) i3;
            } else {
                onPanelStateChangedMsgIntent = null;
            }
            if (onPanelStateChangedMsgIntent == null) {
                return;
            }
            if (onPanelStateChangedMsgIntent.b() && onPanelStateChangedMsgIntent.a() == 1004) {
                z16 = true;
            } else {
                z16 = false;
            }
            e.this.updateUI(new RedPacketPanelState.VisibilityChangeState(z16));
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (QLog.isDevelopLevel()) {
            QLog.d(FrameworkVM.TAG, 4, "handleIntent: " + intent);
        }
        if (Intrinsics.areEqual(intent, c.a.f398003d)) {
            AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
            updateUI(new RedPacketPanelState.InitCompletedState(c16.e(), c16.j(), (com.tencent.aio.api.runtime.a) getMContext()));
        } else {
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(this.panelChangeMsgType, this.panelChangeAction);
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.e().d(this.panelChangeMsgType, this.panelChangeAction);
    }
}
