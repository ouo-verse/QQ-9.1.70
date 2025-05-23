package com.tencent.robot.aio.input.inputbar.pttrecord;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.input.adorn.c;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAudioRecordTouchEventApi;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordMsgIntent;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordUIState;
import com.tencent.robot.aio.input.inputbar.pttrecord.a;
import com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001)\u0018\u0000  2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006:\u00012B\u000f\u0012\u0006\u0010&\u001a\u00020\u0005\u00a2\u0006\u0004\b1\u0010%J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0013H\u0002J\u001a\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u001aH\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\"\u0010&\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010*R&\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020)0-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordVMDelegate;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "e", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleConfigMsgIntent$OnInputStyleConfigChanged;", h.F, "Lcom/tencent/mobileqq/aio/input/fullscreen/FullScreenMsgIntent$OnFullScreenModeChanged;", "g", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$SetPttRecordModeMsgIntent;", "l", "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "j", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/a$a;", "k", "", "isPttRecordMode", "Landroid/view/View;", "pttRecordView", "f", "Ljava/lang/Class;", "d0", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "i", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "com/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordVMDelegate$b", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordVMDelegate$b;", "mAction", "", "Lkotlin/Pair;", "", "Ljava/util/List;", "mMessageList", "<init>", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotInputPttRecordVMDelegate implements e<at.a, InputUIState, com.tencent.aio.api.runtime.a, c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordVMDelegate$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            RobotInputPttRecordVMDelegate.this.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public RobotInputPttRecordVMDelegate(@NotNull c mHost) {
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(InputStyleConfigMsgIntent.OnInputStyleConfigChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotInputPttRecordMsgIntent.SetPttRecordModeMsgIntent.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class)), bVar)});
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent intent) {
        if (intent instanceof InputStyleConfigMsgIntent.OnInputStyleConfigChanged) {
            h((InputStyleConfigMsgIntent.OnInputStyleConfigChanged) intent);
            return;
        }
        if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            g((FullScreenMsgIntent.OnFullScreenModeChanged) intent);
        } else if (intent instanceof RobotInputPttRecordMsgIntent.SetPttRecordModeMsgIntent) {
            l((RobotInputPttRecordMsgIntent.SetPttRecordModeMsgIntent) intent);
        } else if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            j((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent);
        }
    }

    private final void f(boolean isPttRecordMode, View pttRecordView) {
        try {
            if (isPttRecordMode && pttRecordView != null) {
                IAudioRecordTouchEventApi iAudioRecordTouchEventApi = (IAudioRecordTouchEventApi) QRoute.api(IAudioRecordTouchEventApi.class);
                com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    aVar = null;
                }
                iAudioRecordTouchEventApi.setTouchEvent(pttRecordView, aVar);
                return;
            }
            ((IAudioRecordTouchEventApi) QRoute.api(IAudioRecordTouchEventApi.class)).destroy();
        } catch (Exception e16) {
            QLog.w("RobotInputPttRecordVMDelegate", 2, "handlePttRecordModeChangeMviIntent exception: " + e16.getMessage());
        }
    }

    private final void g(FullScreenMsgIntent.OnFullScreenModeChanged intent) {
        p(new RobotInputPttRecordUIState.FullScreenModeChangedState(intent.a()));
    }

    private final void h(InputStyleConfigMsgIntent.OnInputStyleConfigChanged intent) {
        p(new RobotInputPttRecordUIState.InputStyleConfigChangedState(intent.getInputStyleConfig()));
    }

    private final void j(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent intent) {
        if (intent.b()) {
            p(new RobotInputPttRecordUIState.SetPttRecordModeState(false));
        }
    }

    private final void k(a.PttRecordModeChangedMviIntent intent) {
        QLog.i("RobotInputPttRecordVMDelegate", 1, "handlePttRecordModeChangeMviIntent " + intent.getIsPttRecordMode());
        com.tencent.aio.api.runtime.a aVar = null;
        if (intent.getIsPttRecordMode()) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            aVar2.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("RobotInputPttRecordVMDelegate", false, 2, null));
        }
        f(intent.getIsPttRecordMode(), intent.getPttRecordView());
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar3;
        }
        aVar.e().h(new RobotInputPttRecordMsgIntent.OnPttRecordModeChanged(intent.getIsPttRecordMode()));
    }

    private final void l(RobotInputPttRecordMsgIntent.SetPttRecordModeMsgIntent intent) {
        QLog.i("RobotInputPttRecordVMDelegate", 1, "handleSetPttRecordMode source = " + intent.getSource());
        if (intent.getIsPttRecordMode()) {
            v24.a aVar = v24.a.f440822a;
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            Fragment c16 = aVar2.c();
            Intrinsics.checkNotNullExpressionValue(c16, "mAIOContext.fragment");
            aVar.a(c16, "ptt", new Function0<Unit>() { // from class: com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordVMDelegate$handleSetPttRecordMode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RobotInputPttRecordVMDelegate.this.p(new RobotInputPttRecordUIState.SetPttRecordModeState(true));
                }
            });
            return;
        }
        p(new RobotInputPttRecordUIState.SetPttRecordModeState(false));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public c getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @Nullable
    public Class<? extends at.a> d0() {
        return a.class;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.PttRecordModeChangedMviIntent) {
            k((a.PttRecordModeChangedMviIntent) intent);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAIOContext = context;
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            String str = (String) pair.getFirst();
            com.tencent.mvi.base.route.a aVar3 = (com.tencent.mvi.base.route.a) pair.getSecond();
            com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar4;
            }
            LifecycleOwner d16 = aVar2.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
            e16.c(str, aVar3, d16);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void p(@NotNull InputUIState inputUIState) {
        e.a.b(this, inputUIState);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            aVar.e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }
}
