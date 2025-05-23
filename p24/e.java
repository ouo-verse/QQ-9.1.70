package p24;

import android.content.Context;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.robot.aio.input.RobotMenuMsgIntent;
import com.tencent.robot.aio.input.RobotSearchMsgIntent;
import com.tencent.robot.aio.input.inputbar.edittext.RobotInputEditTextExtUIState;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordMsgIntent;
import com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent;
import com.tencent.robot.slash.input.InputRobotMsgIntent;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001*\u0018\u0000  2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006:\u00013B\u000f\u0012\u0006\u0010'\u001a\u00020\u0005\u00a2\u0006\u0004\b2\u0010&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\"\u0010'\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010+R&\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020*0.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00100\u00a8\u00064"}, d2 = {"Lp24/e;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "f", "Lcom/tencent/mobileqq/aio/input/at/InputAtMsgIntent$InsertAtMemberSpan;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$OnPttRecordModeChanged;", "j", "Lcom/tencent/mobileqq/aio/input/fullscreen/FullScreenMsgIntent$OnFullScreenModeChanged;", "g", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleConfigMsgIntent$OnInputStyleConfigChanged;", h.F, "Lcom/tencent/robot/slash/input/InputRobotMsgIntent$SetSlashCmdToInputEdiText;", "k", "", ViewStickEventHelper.IS_SHOW, "needAnim", "p", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/Class;", "Lp24/a;", "d0", "i", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "e", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "o", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "p24/e$b", "Lp24/e$b;", "mAction", "", "Lkotlin/Pair;", "", "Ljava/util/List;", "mMessageList", "<init>", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"p24/e$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            e.this.f(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public e(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(InputAtMsgIntent.InsertAtMemberSpan.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotInputPttRecordMsgIntent.OnPttRecordModeChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(InputStyleConfigMsgIntent.OnInputStyleConfigChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(InputRobotMsgIntent.SetSlashCmdToInputEdiText.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotMenuMsgIntent.OnRobotMenuDialogChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotMenuMsgIntent.OnRobotMenuDismissAnimStart.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnSlashDialogChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnSlashDismissAnimStart.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotSearchMsgIntent.OnRobotSearchDialogChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotSearchMsgIntent.OnRobotSearchDismissAnimStart.class)), bVar)});
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MsgIntent intent) {
        if (intent instanceof InputAtMsgIntent.InsertAtMemberSpan) {
            m((InputAtMsgIntent.InsertAtMemberSpan) intent);
            return;
        }
        if (intent instanceof RobotInputPttRecordMsgIntent.OnPttRecordModeChanged) {
            j((RobotInputPttRecordMsgIntent.OnPttRecordModeChanged) intent);
            return;
        }
        if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            g((FullScreenMsgIntent.OnFullScreenModeChanged) intent);
            return;
        }
        if (intent instanceof InputStyleConfigMsgIntent.OnInputStyleConfigChanged) {
            h((InputStyleConfigMsgIntent.OnInputStyleConfigChanged) intent);
            return;
        }
        if (intent instanceof InputRobotMsgIntent.SetSlashCmdToInputEdiText) {
            k((InputRobotMsgIntent.SetSlashCmdToInputEdiText) intent);
            return;
        }
        if (intent instanceof RobotMenuMsgIntent.OnRobotMenuDialogChanged) {
            p(((RobotMenuMsgIntent.OnRobotMenuDialogChanged) intent).getIsShow(), false);
            return;
        }
        if (intent instanceof SlashDialogMsgIntent.OnSlashDialogChanged) {
            p(((SlashDialogMsgIntent.OnSlashDialogChanged) intent).getIsShow(), false);
            return;
        }
        if (intent instanceof RobotSearchMsgIntent.OnRobotSearchDialogChanged) {
            p(((RobotSearchMsgIntent.OnRobotSearchDialogChanged) intent).getIsShow(), false);
            return;
        }
        if (intent instanceof RobotMenuMsgIntent.OnRobotMenuDismissAnimStart) {
            p(false, true);
        } else if (intent instanceof SlashDialogMsgIntent.OnSlashDismissAnimStart) {
            p(false, true);
        } else if (intent instanceof RobotSearchMsgIntent.OnRobotSearchDismissAnimStart) {
            p(false, true);
        }
    }

    private final void g(FullScreenMsgIntent.OnFullScreenModeChanged intent) {
        r(new RobotInputEditTextExtUIState.FullScreenModeChangedState(intent.a()));
    }

    private final void h(InputStyleConfigMsgIntent.OnInputStyleConfigChanged intent) {
        r(new RobotInputEditTextExtUIState.InputStyleChangedState(intent.getInputStyleConfig()));
    }

    private final void j(RobotInputPttRecordMsgIntent.OnPttRecordModeChanged intent) {
        r(new RobotInputEditTextExtUIState.PttRecordModeChangedState(intent.getIsPttRecordMode()));
    }

    private final void k(final InputRobotMsgIntent.SetSlashCmdToInputEdiText intent) {
        r(new RobotInputEditTextExtUIState.PostInputEditTextRunnable(new Runnable() { // from class: p24.d
            @Override // java.lang.Runnable
            public final void run() {
                e.l(e.this, intent);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, InputRobotMsgIntent.SetSlashCmdToInputEdiText intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new InputEditTextMsgIntent.SetTextToEditText(intent.getContent(), true));
    }

    private final void m(InputAtMsgIntent.InsertAtMemberSpan intent) {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        String b16 = su3.c.b(g16);
        if (peekAppRuntime != null) {
            String a16 = intent.a();
            if (a16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                a16 = ((IRobotExtApi) QRoute.api(IRobotExtApi.class)).getBuddyName(peekAppRuntime, b16, true);
            }
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar2 = aVar3;
            }
            aVar2.e().h(new InputEditTextMsgIntent.AppendTextToEditText(a16 + " ", intent.b()));
        }
    }

    private final void p(boolean isShow, boolean needAnim) {
        int alphaComponent;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Context context = aVar.c().getContext();
        if (context == null) {
            return;
        }
        if (isShow) {
            alphaComponent = context.getColor(R.color.qui_common_bg_middle_light);
        } else {
            alphaComponent = ColorUtils.setAlphaComponent(context.getColor(R.color.qui_common_bg_middle_light), 0);
        }
        r(new RobotInputEditTextExtUIState.UpdateBackgroundColor(alphaComponent, needAnim));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        return a.class;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
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
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
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

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void r(@NotNull InputUIState inputUIState) {
        e.a.b(this, inputUIState);
    }
}
