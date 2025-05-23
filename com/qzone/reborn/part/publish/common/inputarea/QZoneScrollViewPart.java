package com.qzone.reborn.part.publish.common.inputarea;

import android.view.MotionEvent;
import android.view.View;
import com.qzone.reborn.base.k;
import com.qzone.widget.ExtendScrollView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001\u0014\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/part/publish/common/inputarea/QZoneScrollViewPart;", "Lcom/qzone/reborn/base/k;", "", "E9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/widget/ExtendScrollView;", "d", "Lcom/qzone/widget/ExtendScrollView;", "scrollView", "Lcom/qzone/reborn/part/publish/common/inputkeyboardmenu/d;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "D9", "()Lcom/qzone/reborn/part/publish/common/inputkeyboardmenu/d;", "keyboardMenuViewModel", "com/qzone/reborn/part/publish/common/inputarea/QZoneScrollViewPart$b", "f", "Lcom/qzone/reborn/part/publish/common/inputarea/QZoneScrollViewPart$b;", "downListener", "<init>", "()V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneScrollViewPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ExtendScrollView scrollView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy keyboardMenuViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b downListener;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/part/publish/common/inputarea/QZoneScrollViewPart$b", "Lcom/qzone/widget/ExtendScrollView$a;", "Landroid/view/MotionEvent;", "event", "", "onDown", "onTouch", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements ExtendScrollView.a {
        b() {
        }

        @Override // com.qzone.widget.ExtendScrollView.a
        public boolean onDown(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Integer value = QZoneScrollViewPart.this.D9().L1().getValue();
            if (value == null || value.intValue() == 0) {
                return false;
            }
            QZoneScrollViewPart.this.broadcastMessage("close_input_panel", null);
            return false;
        }

        @Override // com.qzone.widget.ExtendScrollView.a
        public boolean onTouch(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }
    }

    public QZoneScrollViewPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.part.publish.common.inputkeyboardmenu.d>() { // from class: com.qzone.reborn.part.publish.common.inputarea.QZoneScrollViewPart$keyboardMenuViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.part.publish.common.inputkeyboardmenu.d invoke() {
                return (com.qzone.reborn.part.publish.common.inputkeyboardmenu.d) QZoneScrollViewPart.this.getViewModel(com.qzone.reborn.part.publish.common.inputkeyboardmenu.d.class);
            }
        });
        this.keyboardMenuViewModel = lazy;
        this.downListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.qzone.reborn.part.publish.common.inputkeyboardmenu.d D9() {
        return (com.qzone.reborn.part.publish.common.inputkeyboardmenu.d) this.keyboardMenuViewModel.getValue();
    }

    private final void E9() {
        ExtendScrollView extendScrollView = this.scrollView;
        if (extendScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            extendScrollView = null;
        }
        extendScrollView.b(R.id.f68683gp);
        extendScrollView.setOnDownListener(this.downListener);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneScrollViewPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.f69333ig);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_publish_scroll_view)");
            this.scrollView = (ExtendScrollView) findViewById;
        }
        E9();
    }
}
