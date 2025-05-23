package com.tencent.robot.widget.list.vb;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.f;
import com.tencent.input.base.mvicompat.h;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u0018\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0003BR\u0012I\u0010\u0017\u001aE\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012,\u0012*\u0012&\u0012$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u00140\u00120\r\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0016RW\u0010\u0017\u001aE\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012,\u0012*\u0012&\u0012$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u00140\u00120\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/widget/list/vb/b;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "context", "", "onCreate", "(Lcom/tencent/mvi/api/runtime/b;)V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "l", "Lkotlin/Function1;", "Lcom/tencent/robot/widget/list/vb/e;", "Lkotlin/ParameterName;", "name", "host", "", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/widget/list/vb/ICommonListVMDelegate;", "d", "Lkotlin/jvm/functions/Function1;", "mDelegatesInitializer", "com/tencent/robot/widget/list/vb/b$a", "e", "Lcom/tencent/robot/widget/list/vb/b$a;", "mVMDelegateMediator", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b<C extends com.tencent.mvi.api.runtime.b> extends BaseVM<com.tencent.robot.widget.list.vb.a, CommonListUIState, C> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<e, List<com.tencent.input.base.mvicompat.e<com.tencent.robot.widget.list.vb.a, CommonListUIState, C, e>>> mDelegatesInitializer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mVMDelegateMediator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0005J8\u0010\n\u001a*\u0012&\u0012$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00028\u0000`\t0\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/widget/list/vb/b$a", "Lcom/tencent/input/base/mvicompat/h;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/e;", "Lcom/tencent/robot/widget/list/vb/VMDelegateMediator;", "host", "", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/widget/list/vb/ICommonListVMDelegate;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends h<com.tencent.robot.widget.list.vb.a, CommonListUIState, C, e> {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ b<C> f368708h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b<C> bVar, C9785b c9785b) {
            super(c9785b);
            this.f368708h = bVar;
        }

        @Override // com.tencent.input.base.mvicompat.DelegateMediator
        @NotNull
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public List<com.tencent.input.base.mvicompat.e<com.tencent.robot.widget.list.vb.a, CommonListUIState, C, e>> i(@NotNull e host) {
            Intrinsics.checkNotNullParameter(host, "host");
            return (List) ((b) this.f368708h).mDelegatesInitializer.invoke(host);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/widget/list/vb/b$b", "Lcom/tencent/robot/widget/list/vb/e;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "state", "", "a", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Lcom/tencent/mvi/api/ability/e;", "fetchVBState", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.widget.list.vb.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9785b implements e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b<C> f368709d;

        C9785b(b<C> bVar) {
            this.f368709d = bVar;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(@NotNull CommonListUIState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.f368709d.updateUI(state);
        }

        @Override // com.tencent.mvi.api.ability.b
        @NotNull
        public com.tencent.mvi.api.ability.e fetchVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
            Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
            return this.f368709d.fetchVBState(stateCmd);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function1<? super e, ? extends List<? extends com.tencent.input.base.mvicompat.e<com.tencent.robot.widget.list.vb.a, CommonListUIState, C, e>>> mDelegatesInitializer) {
        Intrinsics.checkNotNullParameter(mDelegatesInitializer, "mDelegatesInitializer");
        this.mDelegatesInitializer = mDelegatesInitializer;
        this.mVMDelegateMediator = new a(this, new C9785b(this));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.robot.widget.list.vb.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.mVMDelegateMediator.f(intent);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        this.mVMDelegateMediator.onDestroy();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull C context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((b<C>) context);
        f.a.a(this.mVMDelegateMediator, context, false, 2, null);
    }
}
