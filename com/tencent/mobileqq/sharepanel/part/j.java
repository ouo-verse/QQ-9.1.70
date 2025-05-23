package com.tencent.mobileqq.sharepanel.part;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/part/j;", "Lcom/tencent/mobileqq/sharepanel/part/i;", "", "I9", "Landroid/view/ViewGroup$LayoutParams;", "lp", "Landroid/widget/FrameLayout$LayoutParams;", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "bottomBarContainer", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout bottomBarContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull SharePanelParam param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
    }

    private final FrameLayout.LayoutParams H9(ViewGroup.LayoutParams lp5) {
        if (lp5 instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) lp5;
        }
        if (lp5 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(lp5.width, lp5.height);
            layoutParams.gravity = 1;
            return layoutParams;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        return layoutParams2;
    }

    private final void I9() {
        FrameLayout frameLayout;
        View view;
        View partRootView = getPartRootView();
        ViewGroup viewGroup = null;
        if (partRootView != null) {
            frameLayout = (FrameLayout) partRootView.findViewById(R.id.f164625ac2);
        } else {
            frameLayout = null;
        }
        this.bottomBarContainer = frameLayout;
        if (frameLayout == null) {
            return;
        }
        com.tencent.mobileqq.sharepanel.c b16 = F9().b();
        if (b16 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            view = b16.a(context);
        } else {
            view = null;
        }
        if (view == null) {
            FrameLayout frameLayout2 = this.bottomBarContainer;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
                return;
            }
            return;
        }
        FrameLayout frameLayout3 = this.bottomBarContainer;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        FrameLayout frameLayout4 = this.bottomBarContainer;
        if (frameLayout4 != null) {
            frameLayout4.addView(view, H9(view.getLayoutParams()));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            I9();
        }
    }
}
