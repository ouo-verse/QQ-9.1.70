package com.tencent.robot.discover.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.InputMethodUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0004J\b\u0010\u0011\u001a\u00020\u0004H\u0004R\"\u0010\u0019\u001a\u00020\u00128\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/robot/discover/part/b;", "Landroidx/lifecycle/ViewModel;", "VM", "Lcom/tencent/biz/richframework/part/Part;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Ljava/lang/Class;", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "", "delay", "E9", "C9", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "d", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "z9", "()Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "D9", "(Lcom/tencent/mobileqq/widget/search/QUISearchBar;)V", "mSearchBar", "e", "Landroidx/lifecycle/ViewModel;", "A9", "()Landroidx/lifecycle/ViewModel;", "setMViewModel", "(Landroidx/lifecycle/ViewModel;)V", "mViewModel", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b<VM extends ViewModel> extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected QUISearchBar mSearchBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VM mViewModel;

    public static /* synthetic */ void F9(b bVar, long j3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                j3 = 200;
            }
            bVar.E9(j3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSoftInput");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mSearchBar == null) {
            return;
        }
        this$0.z9().getInputWidget().requestFocus();
        InputMethodUtil.show(this$0.z9().getInputWidget());
    }

    private final void initViewModel() {
        this.mViewModel = (VM) getViewModel(B9());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final VM A9() {
        return this.mViewModel;
    }

    @NotNull
    public abstract Class<VM> B9();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C9() {
        if (this.mSearchBar == null) {
            return;
        }
        InputMethodUtil.hide(z9());
        z9().getInputWidget().clearFocus();
    }

    protected final void D9(@NotNull QUISearchBar qUISearchBar) {
        Intrinsics.checkNotNullParameter(qUISearchBar, "<set-?>");
        this.mSearchBar = qUISearchBar;
    }

    protected final void E9(long delay) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.robot.discover.part.a
            @Override // java.lang.Runnable
            public final void run() {
                b.G9(b.this);
            }
        }, delay);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f765541z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.robot_discovery_search)");
        D9((QUISearchBar) findViewById);
        z9().setCustomResource(n34.e.f418127a.b());
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        C9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final QUISearchBar z9() {
        QUISearchBar qUISearchBar = this.mSearchBar;
        if (qUISearchBar != null) {
            return qUISearchBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSearchBar");
        return null;
    }
}
