package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.core.EventListener;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0014J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0015R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u0004\u0018\u00010*8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00100\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "", "orientation", "", EventListener.KEY_DELTA, "", "a", "Landroid/view/MotionEvent;", "ev", "f", "e", "", "d", "event", "onFinishInflate", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/NestedScrollableHost$a;", "dragDelegate", "setDragInterceptDelegate", "dispatchTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "I", "touchSlop", UserInfo.SEX_FEMALE, "initialX", "initialY", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/gallery/widget/NestedScrollableHost$a;", "dragInterceptDelegate", "Landroid/view/View;", "i", "Landroid/view/View;", "seekBarSlideDetectorView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "downX", BdhLogUtil.LogTag.Tag_Conn, "downY", "D", "Z", "firstDispatch", "E", "needDispatchToSeekBar", "Landroidx/viewpager2/widget/ViewPager2;", "c", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager", "b", "()Landroid/view/View;", "child", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NestedScrollableHost extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int downY;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean firstDispatch;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needDispatchToSeekBar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float initialX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float initialY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a dragInterceptDelegate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View seekBarSlideDetectorView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int downX;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/NestedScrollableHost$a;", "", "Landroid/view/MotionEvent;", "motionEvent", "", "deltaX", "deltaY", "", IGuildSpeechApi.KEY_NEED_INTERCEPT, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        boolean needIntercept(@Nullable MotionEvent motionEvent, float deltaX, float deltaY);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NestedScrollableHost(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean a(int orientation, float delta) {
        int i3 = -((int) Math.signum(delta));
        if (orientation != 0) {
            if (orientation == 1) {
                View b16 = b();
                if (b16 == null) {
                    return false;
                }
                return b16.canScrollVertically(i3);
            }
            throw new IllegalArgumentException();
        }
        View b17 = b();
        if (b17 == null) {
            return false;
        }
        return b17.canScrollHorizontally(i3);
    }

    private final View b() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x000d, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ViewPager2 c() {
        View view;
        Object parent = getParent();
        if (parent instanceof View) {
            view = (View) parent;
            while (view != null && !(view instanceof ViewPager2)) {
                Object parent2 = view.getParent();
                if (parent2 instanceof View) {
                    view = (View) parent2;
                }
            }
            if (!(view instanceof ViewPager2)) {
                return null;
            }
            return (ViewPager2) view;
        }
        view = null;
    }

    private final void d(MotionEvent e16) {
        boolean z16;
        float f16;
        boolean z17;
        ViewPager2 c16 = c();
        if (c16 != null) {
            int orientation = c16.getOrientation();
            if (e16.getAction() == 0) {
                this.initialX = e16.getX();
                this.initialY = e16.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                return;
            }
            if (e16.getAction() == 2) {
                float x16 = e16.getX() - this.initialX;
                float y16 = e16.getY() - this.initialY;
                boolean z18 = false;
                if (orientation == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                float abs = Math.abs(x16);
                float f17 = 0.5f;
                if (z16) {
                    f16 = 0.5f;
                } else {
                    f16 = 1.0f;
                }
                float f18 = abs * f16;
                float abs2 = Math.abs(y16);
                if (z16) {
                    f17 = 1.0f;
                }
                float f19 = abs2 * f17;
                int i3 = this.touchSlop;
                if (f18 > i3 || f19 > i3) {
                    if (f19 > f18) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z16 == z17) {
                        a aVar = this.dragInterceptDelegate;
                        if (aVar != null) {
                            z18 = aVar.needIntercept(e16, f18, f19);
                        }
                        getParent().requestDisallowInterceptTouchEvent(z18);
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

    private final boolean e(MotionEvent event) {
        View view;
        if (event == null || (view = this.seekBarSlideDetectorView) == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        int i3 = iArr[0];
        int i16 = iArr[1];
        View view2 = this.seekBarSlideDetectorView;
        Intrinsics.checkNotNull(view2);
        int measuredWidth = view2.getMeasuredWidth() + i3;
        View view3 = this.seekBarSlideDetectorView;
        Intrinsics.checkNotNull(view3);
        int measuredHeight = view3.getMeasuredHeight() + i16;
        if (event.getRawX() < i3 || event.getRawX() > measuredWidth || event.getRawY() < i16 || event.getRawY() > measuredHeight) {
            return false;
        }
        return true;
    }

    private final boolean f(MotionEvent ev5) {
        float abs = Math.abs(ev5.getRawX() - this.downX);
        float abs2 = Math.abs(ev5.getRawY() - this.downY);
        if (this.downX > 0 && abs > this.touchSlop + 5 && abs > abs2) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        Integer num;
        boolean z16;
        View view;
        View view2;
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            this.downX = (int) ev5.getRawX();
            this.downY = (int) ev5.getRawY();
            this.firstDispatch = true;
            this.needDispatchToSeekBar = false;
        } else if (num != null && num.intValue() == 2) {
            if (this.firstDispatch && f(ev5) && e(ev5)) {
                MotionEvent obtain = MotionEvent.obtain(ev5);
                obtain.setAction(0);
                View view3 = this.seekBarSlideDetectorView;
                if (view3 != null) {
                    view3.dispatchTouchEvent(obtain);
                }
                this.firstDispatch = false;
                this.needDispatchToSeekBar = true;
            }
            if (this.needDispatchToSeekBar && (view2 = this.seekBarSlideDetectorView) != null) {
                view2.dispatchTouchEvent(ev5);
            }
        } else {
            if ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 1)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.needDispatchToSeekBar && (view = this.seekBarSlideDetectorView) != null) {
                    view.dispatchTouchEvent(ev5);
                }
                this.downX = -1;
                this.downY = -1;
                this.firstDispatch = true;
                this.needDispatchToSeekBar = false;
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.seekBarSlideDetectorView = findViewById(R.id.f86274r8);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        d(e16);
        return super.onInterceptTouchEvent(e16);
    }

    public final void setDragInterceptDelegate(@NotNull a dragDelegate) {
        Intrinsics.checkNotNullParameter(dragDelegate, "dragDelegate");
        this.dragInterceptDelegate = dragDelegate;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NestedScrollableHost(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NestedScrollableHost(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NestedScrollableHost(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.downX = -1;
        this.downY = -1;
        this.firstDispatch = true;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
