package com.tencent.mobileqq.sharepanel.forward.part;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/part/g;", "Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "contentContainer", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g extends ForwardPreviewBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout contentContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull com.tencent.mobileqq.sharepanel.forward.d param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f27160fh);
        } else {
            frameLayout = null;
        }
        this.contentContainer = frameLayout;
        if (frameLayout != null) {
            com.tencent.mobileqq.sharepanel.forward.f d16 = B9().d();
            Context context = frameLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            View a16 = d16.a(context);
            if (a16 == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(a16, layoutParams);
        }
    }
}
