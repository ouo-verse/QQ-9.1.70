package com.tencent.mobileqq.flock.feedcommon.part;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/part/d;", "Lcom/tencent/mobileqq/flock/base/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "d", "Landroid/view/View;", "titleLayout", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class d extends com.tencent.mobileqq.flock.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View titleLayout;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View onInitView$lambda$2$lambda$1 = rootView.findViewById(R.id.yfs);
            Intrinsics.checkNotNullExpressionValue(onInitView$lambda$2$lambda$1, "onInitView$lambda$2$lambda$1");
            ViewGroup.LayoutParams layoutParams = onInitView$lambda$2$lambda$1.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height += ImmersiveUtils.getStatusBarHeight(onInitView$lambda$2$lambda$1.getContext());
                onInitView$lambda$2$lambda$1.setLayoutParams(layoutParams);
                onInitView$lambda$2$lambda$1.setPadding(0, ImmersiveUtils.getStatusBarHeight(onInitView$lambda$2$lambda$1.getContext()), 0, 0);
                Intrinsics.checkNotNullExpressionValue(onInitView$lambda$2$lambda$1, "findViewById<View>(R.id.\u2026ext), 0, 0)\n            }");
                this.titleLayout = onInitView$lambda$2$lambda$1;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }
}
