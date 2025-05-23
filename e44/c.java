package e44;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.robot.aio.input.RobotDrawMsgIntent;
import com.tencent.robot.draw.vb.d;
import com.tencent.robot.draw.vb.delegate.DrawListUIState;
import e44.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import m24.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\b\u0006*\u0001&\u0018\u0000 \r*\b\b\u0000\u0010\u0002*\u00020\u00012$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u0007:\u0001*B\u000f\u0012\u0006\u0010#\u001a\u00020\u0006\u00a2\u0006\u0004\b)\u0010\"J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0015H\u0016J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016R\"\u0010#\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'\u00a8\u0006+"}, d2 = {"Le44/c;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/e;", "Le44/a;", "Lcom/tencent/robot/draw/vb/delegate/DrawListUIState;", "Lcom/tencent/robot/draw/vb/d;", "Lcom/tencent/robot/draw/vb/IDrawListVMDelegate;", "Le44/a$c;", "intent", "", "i", "Le44/a$b;", h.F, "Le44/a$a;", "f", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "e", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$SubmitListMsgIntent;", "j", "Ljava/lang/Class;", "d0", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", "g", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/robot/draw/vb/d;", "()Lcom/tencent/robot/draw/vb/d;", "k", "(Lcom/tencent/robot/draw/vb/d;)V", "mHost", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "e44/c$b", "Le44/c$b;", "mAction", "<init>", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c<C extends com.tencent.mvi.api.runtime.b> implements e<a, DrawListUIState, C, d> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private C mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"e44/c$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c<C> f395701d;

        b(c<C> cVar) {
            this.f395701d = cVar;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.f395701d.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public c(@NotNull d mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mAction = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent event) {
        if (event instanceof RobotDrawMsgIntent.SubmitListMsgIntent) {
            j((RobotDrawMsgIntent.SubmitListMsgIntent) event);
        }
    }

    private final void f(a.GetAnchorViewIntent intent) {
        a.GeAnchorViewMsgResult geAnchorViewMsgResult;
        C c16 = this.mContext;
        View view = null;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        k k3 = c16.e().k(RobotDrawMsgIntent.GetAnchorViewMsgIntent.f367131d);
        if (k3 instanceof a.GeAnchorViewMsgResult) {
            geAnchorViewMsgResult = (a.GeAnchorViewMsgResult) k3;
        } else {
            geAnchorViewMsgResult = null;
        }
        if (geAnchorViewMsgResult != null) {
            view = geAnchorViewMsgResult.getAnchorView();
        }
        intent.b(view);
    }

    private final void h(a.OnRequireListItemClick intent) {
        C c16 = this.mContext;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        c16.e().h(new RobotDrawMsgIntent.UpdateRobotDrawData(2, null, null, intent.getRequireName(), intent.getRequireData()));
    }

    private final void i(a.OnStyleListItemClick intent) {
        C c16 = this.mContext;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        c16.e().h(new RobotDrawMsgIntent.UpdateRobotDrawData(1, intent.getStyleName(), intent.getStyleData(), null, null));
    }

    private final void j(RobotDrawMsgIntent.SubmitListMsgIntent event) {
        l(new DrawListUIState.SubmitListUIState(event.getDrawData()));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void b(@NotNull C context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.e().d(Reflection.getOrCreateKotlinClass(RobotDrawMsgIntent.SubmitListMsgIntent.class).getQualifiedName(), this.mAction);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public d getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @Nullable
    public Class<? extends a> d0() {
        return a.class;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.OnStyleListItemClick) {
            i((a.OnStyleListItemClick) intent);
        } else if (intent instanceof a.OnRequireListItemClick) {
            h((a.OnRequireListItemClick) intent);
        } else if (intent instanceof a.GetAnchorViewIntent) {
            f((a.GetAnchorViewIntent) intent);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.mHost = dVar;
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull DrawListUIState drawListUIState) {
        e.a.b(this, drawListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        C c16 = this.mContext;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        c16.e().b(Reflection.getOrCreateKotlinClass(RobotDrawMsgIntent.SubmitListMsgIntent.class).getQualifiedName(), this.mAction);
    }
}
