package l54;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.robot.at.dialog.content.list.mvidelegate.RobotAtListUIState;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.SlashListUIState;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u64.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\"\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u0007B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\u0004\b%\u0010\u001aJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\"\u0010\u001b\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#\u00a8\u0006&"}, d2 = {"Ll54/b;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/e;", "Lcom/tencent/robot/widget/list/vb/ICommonListVMDelegate;", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "", "f", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", "intent", "g", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "d", "Lcom/tencent/robot/widget/list/vb/e;", "e", "()Lcom/tencent/robot/widget/list/vb/e;", h.F, "(Lcom/tencent/robot/widget/list/vb/e;)V", "mHost", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "", "", "Ljava/util/List;", "mMessageList", "l54/b$a", "Ll54/b$a;", "mAction", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b<C extends com.tencent.mvi.api.runtime.b> implements e<com.tencent.robot.widget.list.vb.a, CommonListUIState, C, com.tencent.robot.widget.list.vb.e> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.robot.widget.list.vb.e mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private C mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mMessageList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"l54/b$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b<C> f413869d;

        a(b<C> bVar) {
            this.f413869d = bVar;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            this.f413869d.f(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public b(@NotNull com.tencent.robot.widget.list.vb.e mHost) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.DisplayModeChange.class)), c.c(Reflection.getOrCreateKotlinClass(CommonListMsgIntent.SubmitListMsgIntent.class))});
        this.mMessageList = listOf;
        this.mAction = new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MsgIntent event) {
        if (event instanceof BottomSheetDialogAdornMsgIntent.DisplayModeChange) {
            i(new SlashListUIState.DisplayModeState(((BottomSheetDialogAdornMsgIntent.DisplayModeChange) event).getNewMode()));
        } else if (event instanceof CommonListMsgIntent.SubmitListMsgIntent) {
            i(new RobotAtListUIState.SetItemCount(((CommonListMsgIntent.SubmitListMsgIntent) event).b().size()));
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
        for (String str : this.mMessageList) {
            C c16 = this.mContext;
            if (c16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                c16 = null;
            }
            c16.e().d(str, this.mAction);
        }
    }

    @Nullable
    public Void d() {
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.e
    public /* bridge */ /* synthetic */ Class<? extends com.tencent.robot.widget.list.vb.a> d0() {
        return (Class) d();
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public com.tencent.robot.widget.list.vb.e getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull com.tencent.robot.widget.list.vb.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

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
        for (String str : this.mMessageList) {
            C c16 = this.mContext;
            if (c16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                c16 = null;
            }
            c16.e().b(str, this.mAction);
        }
    }
}
