package dy;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.aio.PAInputContainerAboveUIState;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Ldy/a;", "Lcom/tencent/aio/base/mvvm/b;", "", "Lcom/tencent/biz/pubaccount/aio/PAInputContainerAboveUIState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/a;", "d", "Lcom/tencent/mvi/base/route/a;", "getAction", "()Lcom/tencent/mvi/base/route/a;", "action", "<init>", "()V", "e", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.tencent.aio.base.mvvm.b<Object, PAInputContainerAboveUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mvi.base.route.a action = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"dy/a$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof PAInputIntent.AddInputContainerAboveViewIntent) {
                PAInputIntent.AddInputContainerAboveViewIntent addInputContainerAboveViewIntent = (PAInputIntent.AddInputContainerAboveViewIntent) i3;
                a.this.updateUI(new PAInputContainerAboveUIState.AddAboveView(addInputContainerAboveViewIntent.getView(), addInputContainerAboveViewIntent.getParams()));
            } else if (i3 instanceof PAInputIntent.RemoveInputContainerAboveViewIntent) {
                a.this.updateUI(new PAInputContainerAboveUIState.RemoveAboveView(((PAInputIntent.RemoveInputContainerAboveViewIntent) i3).getView()));
            } else if (i3 instanceof PAInputIntent.InputContainerAboveViewParentMarginIntent) {
                PAInputIntent.InputContainerAboveViewParentMarginIntent inputContainerAboveViewParentMarginIntent = (PAInputIntent.InputContainerAboveViewParentMarginIntent) i3;
                a.this.updateUI(new PAInputContainerAboveUIState.UpdateAboveParentViewMargin(inputContainerAboveViewParentMarginIntent.getLeftMargin(), inputContainerAboveViewParentMarginIntent.getTopMargin(), inputContainerAboveViewParentMarginIntent.getRightMargin(), inputContainerAboveViewParentMarginIntent.getBottomMargin()));
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PAInputIntent.AddInputContainerAboveViewIntent.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PAInputIntent.RemoveInputContainerAboveViewIntent.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PAInputIntent.InputContainerAboveViewParentMarginIntent.class).getQualifiedName(), this.action);
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        QLog.i("PAInputContainerAboveVM", 1, "[onCreate]");
        context.e().d(Reflection.getOrCreateKotlinClass(PAInputIntent.AddInputContainerAboveViewIntent.class).getQualifiedName(), this.action);
        context.e().d(Reflection.getOrCreateKotlinClass(PAInputIntent.RemoveInputContainerAboveViewIntent.class).getQualifiedName(), this.action);
        context.e().d(Reflection.getOrCreateKotlinClass(PAInputIntent.InputContainerAboveViewParentMarginIntent.class).getQualifiedName(), this.action);
    }
}
