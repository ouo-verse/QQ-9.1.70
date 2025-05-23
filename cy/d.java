package cy;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.biz.pubaccount.aio.PAInputUIState;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcy/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/biz/pubaccount/aio/PAInputIntent;", "Lcom/tencent/biz/pubaccount/aio/PAInputUIState;", "", "f1", "", "visibility", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "state", "e1", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "inputSwitchButton", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends com.tencent.aio.base.mvvm.a<PAInputIntent, PAInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView inputSwitchButton;

    private final void d1(int visibility) {
        ImageView imageView = this.inputSwitchButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSwitchButton");
            imageView = null;
        }
        imageView.setVisibility(visibility);
    }

    private final void f1() {
        ImageView imageView = this.inputSwitchButton;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSwitchButton");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cy.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.g1(d.this, view);
            }
        });
        ImageView imageView3 = this.inputSwitchButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputSwitchButton");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new PAInputIntent.InputMenuSwitchBtnClickIntent());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<PAInputIntent, PAInputUIState> createVM() {
        return new dy.b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(PAInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof PAInputUIState.CustomMenuSwitchBtnVisibleState) {
            d1(((PAInputUIState.CustomMenuSwitchBtnVisibleState) state).getVisibility());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    public View onCreateView(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.p9i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026ension_switch_custom_btn)");
        this.inputSwitchButton = (ImageView) findViewById;
        f1();
        return createViewParams.b();
    }
}
