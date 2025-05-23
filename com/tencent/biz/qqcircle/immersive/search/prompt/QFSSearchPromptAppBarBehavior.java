package com.tencent.biz.qqcircle.immersive.search.prompt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/QFSSearchPromptAppBarBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "Landroid/view/View;", "view", "", "b", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "child", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptAppBarBehavior extends AppBarLayout.ScrollingViewBehavior {
    public QFSSearchPromptAppBarBehavior(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private final void b(View view) {
        Object obj;
        Context context;
        InputMethodManager inputMethodManager = null;
        if (view != null && (context = view.getContext()) != null) {
            obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        } else {
            obj = null;
        }
        if (obj instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) obj;
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() == 0) {
            b(parent);
        }
        return super.onInterceptTouchEvent(parent, child, ev5);
    }
}
