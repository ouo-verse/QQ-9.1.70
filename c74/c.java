package c74;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import com.tencent.robot.widget.list.vb.a;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0005*\u0001\"\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u0007B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\u0004\b%\u0010\u001eJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#\u00a8\u0006&"}, d2 = {"Lc74/c;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/e;", "Lcom/tencent/robot/widget/list/vb/ICommonListVMDelegate;", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "", "e", "Ljava/lang/Class;", "Lcom/tencent/robot/widget/list/vb/a$a;", "d0", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", "intent", "f", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/concurrent/Executor;", "g", "(Lcom/tencent/mvi/api/runtime/b;)Ljava/util/concurrent/Executor;", "d", "Lcom/tencent/robot/widget/list/vb/e;", "()Lcom/tencent/robot/widget/list/vb/e;", h.F, "(Lcom/tencent/robot/widget/list/vb/e;)V", "mHost", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "c74/c$a", "Lc74/c$a;", "mAction", "<init>", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class c<C extends com.tencent.mvi.api.runtime.b> implements e<com.tencent.robot.widget.list.vb.a, CommonListUIState, C, com.tencent.robot.widget.list.vb.e> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.robot.widget.list.vb.e mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private C mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"c74/c$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c<C> f30427d;

        a(c<C> cVar) {
            this.f30427d = cVar;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.f30427d.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public c(@NotNull com.tencent.robot.widget.list.vb.e mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mAction = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent event) {
        if (event instanceof CommonListMsgIntent.SubmitListMsgIntent) {
            CommonListMsgIntent.SubmitListMsgIntent submitListMsgIntent = (CommonListMsgIntent.SubmitListMsgIntent) event;
            i(new CommonListUIState.SubmitListUIState(submitListMsgIntent.b(), submitListMsgIntent.getSubmitCallback()));
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull com.tencent.robot.widget.list.vb.a aVar) {
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
        context.e().d(Reflection.getOrCreateKotlinClass(CommonListMsgIntent.SubmitListMsgIntent.class).getQualifiedName(), this.mAction);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: d, reason: from getter and merged with bridge method [inline-methods] */
    public com.tencent.robot.widget.list.vb.e M() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends com.tencent.robot.widget.list.vb.a> d0() {
        return a.C9784a.class;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull com.tencent.robot.widget.list.vb.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C9784a) {
            C c16 = this.mContext;
            C c17 = null;
            if (c16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                c16 = null;
            }
            C c18 = this.mContext;
            if (c18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                c17 = c18;
            }
            i(new CommonListUIState.InitRecyclerViewAdapterUIState(c16, g(c17)));
        }
    }

    @NotNull
    public abstract Executor g(@NotNull C context);

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.robot.widget.list.vb.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.mHost = eVar;
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void i(@NotNull CommonListUIState commonListUIState) {
        e.a.b(this, commonListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        C c16 = this.mContext;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            c16 = null;
        }
        c16.e().b(Reflection.getOrCreateKotlinClass(CommonListMsgIntent.SubmitListMsgIntent.class).getQualifiedName(), this.mAction);
    }
}
