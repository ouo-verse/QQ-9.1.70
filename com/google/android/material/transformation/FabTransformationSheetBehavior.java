package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.transformation.FabTransformationBehavior;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.Map;
import x0.h;
import x0.j;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private Map<View, Integer> f34525o;

    public FabTransformationSheetBehavior() {
    }

    private void D(@NonNull View view, boolean z16) {
        boolean z17;
        ViewParent parent = view.getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z16) {
            this.f34525o = new HashMap(childCount);
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = coordinatorLayout.getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (childAt != view && !z17) {
                if (!z16) {
                    Map<View, Integer> map = this.f34525o;
                    if (map != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.f34525o.get(childAt).intValue());
                    }
                } else {
                    this.f34525o.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.setImportantForAccessibility(childAt, 4);
                }
            }
        }
        if (!z16) {
            this.f34525o = null;
        }
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @NonNull
    protected FabTransformationBehavior.e B(Context context, boolean z16) {
        int i3;
        if (z16) {
            i3 = R.animator.f155148a1;
        } else {
            i3 = R.animator.f155147a0;
        }
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f34518a = h.d(context, i3);
        eVar.f34519b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    public boolean e(@NonNull View view, @NonNull View view2, boolean z16, boolean z17) {
        D(view2, z16);
        return super.e(view, view2, z16, z17);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
