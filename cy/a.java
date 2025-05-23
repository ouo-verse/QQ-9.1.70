package cy;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.biz.pubaccount.aio.PAInputUIState;
import com.tencent.biz.pubaccount.aio.vm.PAInputBarVM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqnt.aio.api.IAIOExtBusinessVB;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u0010\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcy/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/aio/api/runtime/a;", "initializeChildVB", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "state", "c1", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "inputContainer", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "e", "Lcom/tencent/aio/base/mvvm/a;", "inputBarVB", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.tencent.aio.base.mvvm.a<PAInputIntent, PAInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout inputContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.base.mvvm.a<at.a, InputUIState> inputBarVB;

    private final void b1() {
        com.tencent.aio.base.mvvm.a<at.a, InputUIState> aVar = this.inputBarVB;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBarVB");
            aVar = null;
        }
        View hostView = aVar.getHostView();
        hostView.setBackground(null);
        hostView.setPadding(hostView.getPaddingLeft(), ViewUtils.dip2px(6.0f), hostView.getPaddingRight(), ViewUtils.dip2px(6.0f));
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(PAInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof PAInputUIState.OnResumeState) {
            b1();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public BaseVM<PAInputIntent, PAInputUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new PAInputBarVM();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> initializeChildVB(View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        com.tencent.aio.base.mvvm.a<at.a, InputUIState> publicAccountInputBarVB = ((IAIOExtBusinessVB) QRoute.api(IAIOExtBusinessVB.class)).getPublicAccountInputBarVB();
        this.inputBarVB = publicAccountInputBarVB;
        if (publicAccountInputBarVB == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBarVB");
            publicAccountInputBarVB = null;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(publicAccountInputBarVB);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    public View onCreateView(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.p9h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026R.id.extension_input_bar)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.inputContainer = linearLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputContainer");
        return null;
    }
}
