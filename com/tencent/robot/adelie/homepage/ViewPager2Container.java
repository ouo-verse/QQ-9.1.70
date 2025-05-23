package com.tencent.robot.adelie.homepage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0019\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ViewPager2Container;", "Landroid/widget/RelativeLayout;", "", "onFinishInflate", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "Landroidx/viewpager2/widget/ViewPager2;", "d", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager2", "", "e", UserInfo.SEX_FEMALE, "touchDownX", "f", "touchDownY", tl.h.F, "Z", "touchEventHandled", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "touchSlop", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ViewPager2Container extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 mViewPager2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float touchDownX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float touchDownY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean touchEventHandled;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int touchSlop;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/adelie/homepage/ViewPager2Container$b", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            info.setVisibleToUser(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPager2Container(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        int i3;
        boolean z16;
        boolean z17;
        ViewParent parent;
        RecyclerView.LayoutManager layoutManager;
        RecyclerView.LayoutManager layoutManager2;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        ViewPager2 viewPager2 = this.mViewPager2;
        if (viewPager2 == null) {
            return super.dispatchTouchEvent(ev5);
        }
        if (viewPager2.isUserInputEnabled()) {
            RecyclerView.Adapter adapter = viewPager2.getAdapter();
            boolean z18 = false;
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (i3 > 1) {
                if (ev5.getActionMasked() == 0) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    this.touchDownX = ev5.getX();
                    this.touchDownY = ev5.getY();
                    this.touchEventHandled = false;
                }
                if (this.touchEventHandled) {
                    return super.dispatchTouchEvent(ev5);
                }
                if (ev5.getActionMasked() == 2) {
                    RecyclerView recyclerView = this.recyclerView;
                    if (recyclerView != null && (layoutManager2 = recyclerView.getLayoutManager()) != null && layoutManager2.canScrollHorizontally()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16 && Math.abs(ev5.getX() - this.touchDownX) > this.touchSlop) {
                        ViewParent parent3 = getParent();
                        if (parent3 != null) {
                            parent3.requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        RecyclerView recyclerView2 = this.recyclerView;
                        if (recyclerView2 != null && (layoutManager = recyclerView2.getLayoutManager()) != null && layoutManager.canScrollVertically()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17 && Math.abs(ev5.getY() - this.touchDownY) > this.touchSlop && (parent = getParent()) != null) {
                            parent.requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                boolean dispatchTouchEvent = super.dispatchTouchEvent(ev5);
                if (viewPager2.getScrollState() == 1) {
                    z18 = true;
                }
                this.touchEventHandled = z18;
                return dispatchTouchEvent;
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        KeyEvent.Callback callback;
        Sequence<View> children;
        KeyEvent.Callback callback2;
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
        ViewPager2 viewPager2 = this.mViewPager2;
        RecyclerView recyclerView = null;
        if (viewPager2 != null && (children = ViewGroupKt.getChildren(viewPager2)) != null) {
            Iterator<View> it = children.iterator();
            while (true) {
                if (it.hasNext()) {
                    callback2 = it.next();
                    if (((View) callback2) instanceof RecyclerView) {
                        break;
                    }
                } else {
                    callback2 = null;
                    break;
                }
            }
            callback = (View) callback2;
        } else {
            callback = null;
        }
        if (callback instanceof RecyclerView) {
            recyclerView = (RecyclerView) callback;
        }
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setAccessibilityDelegate(new b());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPager2Container(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPager2Container(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public /* synthetic */ ViewPager2Container(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
