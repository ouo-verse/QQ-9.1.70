package com.qzone.reborn.layer.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0014J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/layer/adapter/ViewPager2Container;", "Landroid/widget/RelativeLayout;", "Landroid/view/ViewGroup;", "target", "", "b", "", "endX", "disX", "disY", "c", "endY", "d", "onFinishInflate", "Landroid/view/View;", "child", "addView", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "disallowParentInterceptDownEvent", "a", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager2", "e", "Z", "f", "I", "startX", h.F, "startY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ViewPager2Container extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 mViewPager2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean disallowParentInterceptDownEvent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int startX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int startY;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPager2Container(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(ViewGroup target) {
        int childCount;
        if (this.mViewPager2 != null || (childCount = target.getChildCount()) < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            View childAt = target.getChildAt(i3);
            if (childAt instanceof ViewPager2) {
                ViewPager2 viewPager2 = (ViewPager2) childAt;
                if (viewPager2.getOrientation() == 1) {
                    this.mViewPager2 = viewPager2;
                    return;
                }
            }
            if (childAt instanceof ViewGroup) {
                b((ViewGroup) childAt);
            }
            if (i3 == childCount) {
                return;
            } else {
                i3++;
            }
        }
    }

    private final void c(int endX, int disX, int disY) {
        ViewPager2 viewPager2 = this.mViewPager2;
        if ((viewPager2 != null ? viewPager2.getAdapter() : null) == null) {
            return;
        }
        if (disX <= disY) {
            if (disY > disX) {
                getParent().requestDisallowInterceptTouchEvent(false);
                return;
            }
            return;
        }
        ViewPager2 viewPager22 = this.mViewPager2;
        Integer valueOf = viewPager22 != null ? Integer.valueOf(viewPager22.getCurrentItem()) : null;
        ViewPager2 viewPager23 = this.mViewPager2;
        RecyclerView.Adapter adapter = viewPager23 != null ? viewPager23.getAdapter() : null;
        Intrinsics.checkNotNull(adapter);
        int itemCount = adapter.getItemCount();
        if (valueOf != null && valueOf.intValue() == 0 && endX - this.startX > 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            getParent().requestDisallowInterceptTouchEvent(valueOf == null || valueOf.intValue() != itemCount - 1 || endX - this.startX >= 0);
        }
    }

    private final void d(int endY, int disX, int disY) {
        ViewPager2 viewPager2 = this.mViewPager2;
        if ((viewPager2 != null ? viewPager2.getAdapter() : null) == null) {
            return;
        }
        ViewPager2 viewPager22 = this.mViewPager2;
        Integer valueOf = viewPager22 != null ? Integer.valueOf(viewPager22.getCurrentItem()) : null;
        ViewPager2 viewPager23 = this.mViewPager2;
        RecyclerView.Adapter adapter = viewPager23 != null ? viewPager23.getAdapter() : null;
        Intrinsics.checkNotNull(adapter);
        int itemCount = adapter.getItemCount();
        if (disY <= disX) {
            if (disX > disY) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (valueOf != null && valueOf.intValue() == 0 && endY - this.startY > 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            getParent().requestDisallowInterceptTouchEvent(valueOf == null || valueOf.intValue() != itemCount - 1 || endY - this.startY >= 0);
        }
    }

    public final void a(boolean disallowParentInterceptDownEvent) {
        this.disallowParentInterceptDownEvent = disallowParentInterceptDownEvent;
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        super.addView(child);
        if (child instanceof ViewGroup) {
            b((ViewGroup) child);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (childAt instanceof ViewPager2) {
                this.mViewPager2 = (ViewPager2) childAt;
                break;
            }
            i3++;
        }
        if (this.mViewPager2 == null) {
            throw new IllegalStateException("The root child of ViewPager2Container must contains a ViewPager2");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (r0 != 3) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        boolean z16;
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.mViewPager2 == null) {
            b(this);
        }
        ViewPager2 viewPager2 = this.mViewPager2;
        if ((viewPager2 != null ? viewPager2.getAdapter() : null) != null) {
            ViewPager2 viewPager22 = this.mViewPager2;
            if (viewPager22 != null ? viewPager22.isUserInputEnabled() : false) {
                ViewPager2 viewPager23 = this.mViewPager2;
                if (((viewPager23 == null || (adapter = viewPager23.getAdapter()) == null) ? 0 : adapter.getItemCount()) > 1) {
                    z16 = false;
                    if (!z16) {
                        return super.onInterceptTouchEvent(ev5);
                    }
                    int action = ev5.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                int x16 = (int) ev5.getX();
                                int y16 = (int) ev5.getY();
                                int abs = Math.abs(x16 - this.startX);
                                int abs2 = Math.abs(y16 - this.startY);
                                ViewPager2 viewPager24 = this.mViewPager2;
                                Intrinsics.checkNotNull(viewPager24);
                                if (viewPager24.getOrientation() == 1) {
                                    d(y16, abs, abs2);
                                } else {
                                    ViewPager2 viewPager25 = this.mViewPager2;
                                    Intrinsics.checkNotNull(viewPager25);
                                    if (viewPager25.getOrientation() == 0) {
                                        c(x16, abs, abs2);
                                    }
                                }
                            }
                        }
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        this.startX = (int) ev5.getX();
                        this.startY = (int) ev5.getY();
                        getParent().requestDisallowInterceptTouchEvent(!this.disallowParentInterceptDownEvent);
                    }
                    return super.onInterceptTouchEvent(ev5);
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPager2Container(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ViewPager2Container(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Container(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.disallowParentInterceptDownEvent = true;
    }
}
