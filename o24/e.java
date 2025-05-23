package o24;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.api.IAIOImmersiveApi;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.aio.background.a;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.robot.aio.input.RobotMenuMsgIntent;
import com.tencent.robot.aio.input.RobotSearchMsgIntent;
import com.tencent.robot.aio.input.inputbar.blur.RobotInputBlurUIState;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import o24.a;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001!\u0018\u0000 +2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006:\u0001,B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u00a2\u0006\u0004\b*\u0010\u001bJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\"\u0010\u001c\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\"R&\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010(\u00a8\u0006-"}, d2 = {"Lo24/e;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "f", h.F, "Landroid/content/Context;", "context", "", "d", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "i", "Ljava/lang/Class;", "d0", "g", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/input/adorn/c;", "e", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "j", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Z", "mFullScreenMode", "o24/e$b", "Lo24/e$b;", "mAction", "", "Lkotlin/Pair;", "", "Lcom/tencent/mvi/base/route/a;", "Ljava/util/List;", "mMessageList", "<init>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mFullScreenMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, com.tencent.mvi.base.route.a>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"o24/e$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
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
        List<Pair<String, com.tencent.mvi.base.route.a>> listOf;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotMenuMsgIntent.OnRobotMenuDialogChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnSlashDialogChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotMenuMsgIntent.OnRobotMenuDismissAnimStart.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.OnSlashDismissAnimStart.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotSearchMsgIntent.OnRobotSearchDialogChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotSearchMsgIntent.OnRobotSearchDismissAnimStart.class)), bVar)});
        this.mMessageList = listOf;
    }

    private final int d(Context context) {
        return ImmersiveUtils.getScreenHeight() + ImmersiveUtils.getStatusBarHeight(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MsgIntent intent) {
        if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            this.mFullScreenMode = ((FullScreenMsgIntent.OnFullScreenModeChanged) intent).a();
            l(new RobotInputBlurUIState.UpdateBlurState(!r8.a(), null, null, 6, null));
            return;
        }
        if (intent instanceof RobotMenuMsgIntent.OnRobotMenuDialogChanged) {
            if (!this.mFullScreenMode) {
                l(new RobotInputBlurUIState.UpdateBlurState(!((RobotMenuMsgIntent.OnRobotMenuDialogChanged) intent).getIsShow(), null, null, 6, null));
                return;
            }
            return;
        }
        if (intent instanceof SlashDialogMsgIntent.OnSlashDialogChanged) {
            if (!this.mFullScreenMode) {
                l(new RobotInputBlurUIState.UpdateBlurState(!((SlashDialogMsgIntent.OnSlashDialogChanged) intent).getIsShow(), null, null, 6, null));
                return;
            }
            return;
        }
        if (intent instanceof RobotSearchMsgIntent.OnRobotSearchDialogChanged) {
            if (!this.mFullScreenMode) {
                l(new RobotInputBlurUIState.UpdateBlurState(!((RobotSearchMsgIntent.OnRobotSearchDialogChanged) intent).getIsShow(), null, null, 6, null));
            }
        } else if (intent instanceof RobotMenuMsgIntent.OnRobotMenuDismissAnimStart) {
            if (!this.mFullScreenMode) {
                l(new RobotInputBlurUIState.UpdateBlurState(true, null, null, 6, null));
            }
        } else if (intent instanceof SlashDialogMsgIntent.OnSlashDismissAnimStart) {
            if (!this.mFullScreenMode) {
                l(new RobotInputBlurUIState.UpdateBlurState(true, null, null, 6, null));
            }
        } else if ((intent instanceof RobotSearchMsgIntent.OnRobotSearchDismissAnimStart) && !this.mFullScreenMode) {
            l(new RobotInputBlurUIState.UpdateBlurState(true, null, null, 6, null));
        }
    }

    private final void h() {
        a.c cVar;
        View view;
        ArrayList arrayList;
        IAIOImmersiveApi iAIOImmersiveApi = (IAIOImmersiveApi) QRoute.api(IAIOImmersiveApi.class);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        View view2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        if (iAIOImmersiveApi.enableImmersive(aVar)) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            k k3 = aVar2.e().k(AIOBackgroundMsgIntent.GetBackgroundView.f349766d);
            if (k3 instanceof a.c) {
                cVar = (a.c) k3;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                view = cVar.a();
            } else {
                view = null;
            }
            if (view != null) {
                ColorDrawable colorDrawable = new ColorDrawable(ColorUtils.setAlphaComponent(view.getContext().getColor(R.color.qui_common_bg_nav_bottom_aio), 128));
                int screenWidth = ImmersiveUtils.getScreenWidth();
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "bgView.context");
                colorDrawable.setBounds(0, 0, screenWidth, d(context));
                arrayList = CollectionsKt__CollectionsKt.arrayListOf(view, colorDrawable);
            } else {
                arrayList = null;
            }
            if (cVar != null) {
                view2 = cVar.a();
            }
            l(new RobotInputBlurUIState.UpdateBlurState(true, view2, arrayList));
            return;
        }
        l(new RobotInputBlurUIState.UpdateBlurState(false, null, null, 6, null));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
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
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C10881a) {
            h();
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
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
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull InputUIState inputUIState) {
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
