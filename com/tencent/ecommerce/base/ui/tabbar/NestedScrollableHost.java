package com.tencent.ecommerce.base.ui.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.core.EventListener;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\u0007B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b\u001d\u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/base/ui/tabbar/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "", "orientation", "", EventListener.KEY_DELTA, "", "a", "Landroid/view/MotionEvent;", "e", "", "d", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "I", "touchSlop", UserInfo.SEX_FEMALE, "initialX", "f", "initialY", "Landroidx/viewpager2/widget/ViewPager2;", "c", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager", "Landroid/view/View;", "b", "()Landroid/view/View;", "child", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class NestedScrollableHost extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float initialX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float initialY;

    public NestedScrollableHost(Context context) {
        super(context);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final boolean a(int orientation, float delta) {
        int i3 = -((int) Math.signum(delta));
        if (orientation == 0) {
            View b16 = b();
            if (b16 != null) {
                return b16.canScrollHorizontally(i3);
            }
            return false;
        }
        if (orientation == 1) {
            View b17 = b();
            if (b17 != null) {
                return b17.canScrollVertically(i3);
            }
            return false;
        }
        throw new IllegalArgumentException();
    }

    private final View b() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    private final ViewPager2 c() {
        Object parent = getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view = (View) parent;
        while (view != null && !(view instanceof ViewPager2)) {
            Object parent2 = view.getParent();
            if (!(parent2 instanceof View)) {
                parent2 = null;
            }
            view = (View) parent2;
        }
        return (ViewPager2) (view instanceof ViewPager2 ? view : null);
    }

    private final void d(MotionEvent e16) {
        ViewPager2 c16 = c();
        if (c16 != null) {
            int orientation = c16.getOrientation();
            if (a(orientation, -1.0f) || a(orientation, 1.0f)) {
                if (e16.getAction() == 0) {
                    this.initialX = e16.getX();
                    this.initialY = e16.getY();
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return;
                }
                if (e16.getAction() == 2) {
                    float x16 = e16.getX() - this.initialX;
                    float y16 = e16.getY() - this.initialY;
                    boolean z16 = orientation == 0;
                    float abs = Math.abs(x16) * (z16 ? 0.5f : 1.0f);
                    float abs2 = Math.abs(y16) * (z16 ? 1.0f : 0.5f);
                    int i3 = this.touchSlop;
                    if (abs > i3 || abs2 > i3) {
                        if (z16 == (abs2 > abs)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            return;
                        }
                        if (!z16) {
                            x16 = y16;
                        }
                        if (a(orientation, x16)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e16) {
        d(e16);
        return super.onInterceptTouchEvent(e16);
    }

    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
