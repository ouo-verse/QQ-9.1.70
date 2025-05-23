package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/part/cs;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "F9", "", "E9", "onInitView", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "mToolBar", "e", "Landroid/view/View;", "mTitleLayout", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class cs extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Toolbar mToolBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mTitleLayout;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(cs this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(cs this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("QZONE_INTIMATE_SCROLL_TOP", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        F9(rootView);
    }

    private final int E9() {
        return ef.d.b(50);
    }

    private final void F9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f162893n63);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026qzone_intimate_title_bar)");
        Toolbar toolbar = (Toolbar) findViewById;
        this.mToolBar = toolbar;
        Toolbar toolbar2 = null;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolBar");
            toolbar = null;
        }
        toolbar.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext()) + E9();
        Toolbar toolbar3 = this.mToolBar;
        if (toolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolBar");
            toolbar3 = null;
        }
        toolbar3.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        View findViewById2 = rootView.findViewById(R.id.f162894n64);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ne_intimate_title_layout)");
        this.mTitleLayout = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            findViewById2 = null;
        }
        findViewById2.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext()) + E9();
        View view = this.mTitleLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            view = null;
        }
        view.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        View findViewById3 = rootView.findViewById(R.id.f162892n62);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026zone_intimate_title_back)");
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.cq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                cs.G9(cs.this, view2);
            }
        });
        AccessibilityUtil.s(findViewById3, com.qzone.util.l.a(R.string.f2201668d));
        Toolbar toolbar4 = this.mToolBar;
        if (toolbar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolBar");
        } else {
            toolbar2 = toolbar4;
        }
        toolbar2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.cr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                cs.H9(cs.this, view2);
            }
        });
    }
}
