package bp1;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.core.view.GestureDetectorCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\"R0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%0$j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010'\u00a8\u0006+"}, d2 = {"Lbp1/m;", "", "Landroid/content/Context;", "context", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "e", "Landroid/view/View;", "target", "", "axes", "type", "", "g", "Landroid/view/MotionEvent;", "ev", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "handled", "f", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "d", "()Lkotlin/jvm/functions/Function0;", tl.h.F, "(Lkotlin/jvm/functions/Function0;)V", "slideRightCallback", "Landroidx/core/view/GestureDetectorCompat;", "b", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetector", "c", "Landroid/view/ViewGroup;", "Z", "touchEventHandled", "Ljava/util/HashMap;", "Lbp1/y;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "offsetMap", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> slideRightCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GestureDetectorCompat gestureDetector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup rootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean touchEventHandled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, SlideState> offsetMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J,\u0010\u000e\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"bp1/m$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "velocityX", "velocityY", "onFling", "Landroid/widget/HorizontalScrollView;", "d", "Landroid/widget/HorizontalScrollView;", "horizontalScrollViewForFeed", "Z", "canHorizontalScrollViewConsumeSlideRightOnDownForFeed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private HorizontalScrollView horizontalScrollViewForFeed;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean canHorizontalScrollViewConsumeSlideRightOnDownForFeed;

        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent e16) {
            HorizontalScrollView horizontalScrollView;
            Intrinsics.checkNotNullParameter(e16, "e");
            if (m.this.touchEventHandled) {
                ViewGroup viewGroup = m.this.rootView;
                if (viewGroup != null) {
                    horizontalScrollView = (HorizontalScrollView) viewGroup.findViewById(R.id.wcl);
                } else {
                    horizontalScrollView = null;
                }
                this.horizontalScrollViewForFeed = horizontalScrollView;
                if (horizontalScrollView != null) {
                    Rect rect = new Rect();
                    horizontalScrollView.getGlobalVisibleRect(rect);
                    boolean contains = rect.contains((int) e16.getX(), (int) e16.getY());
                    this.canHorizontalScrollViewConsumeSlideRightOnDownForFeed = horizontalScrollView.canScrollHorizontally(-1);
                    Logger logger = Logger.f235387a;
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.NewHome.behavior.GuildSlideRightExitBehaviorHelper", "horizontalScrollViewForFeed onDown() -- " + contains + " / canScrollHorizontally=" + this.canHorizontalScrollViewConsumeSlideRightOnDownForFeed);
                    }
                    if (!contains) {
                        this.horizontalScrollViewForFeed = null;
                        this.canHorizontalScrollViewConsumeSlideRightOnDownForFeed = false;
                    } else {
                        return true;
                    }
                }
            }
            return super.onDown(e16);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.behavior.GuildSlideRightExitBehaviorHelper", "onFling() " + velocityX + " / " + velocityY);
            }
            if (velocityX > 6000.0f && Math.abs(velocityY) < ((int) (0.3f * velocityX))) {
                Collection values = m.this.offsetMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "offsetMap.values");
                Collection collection = values;
                boolean z16 = false;
                boolean z17 = true;
                if (!collection.isEmpty()) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!(!((SlideState) it.next()).getCanViewSlideRight())) {
                            z17 = false;
                            break;
                        }
                    }
                }
                HorizontalScrollView horizontalScrollView = this.horizontalScrollViewForFeed;
                if (horizontalScrollView != null) {
                    z16 = horizontalScrollView.canScrollHorizontally(-1);
                }
                if (z17 && !z16 && !this.canHorizontalScrollViewConsumeSlideRightOnDownForFeed) {
                    Function0<Unit> d16 = m.this.d();
                    if (d16 != null) {
                        d16.invoke();
                    }
                    Logger logger2 = Logger.f235387a;
                    if (QLog.isDevelopLevel()) {
                        Log.d("Guild.NewHome.behavior.GuildSlideRightExitBehaviorHelper", "onFling() invoke slideRightCallback!");
                    }
                }
            }
            return super.onFling(e16, e26, velocityX, velocityY);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
            if (this.horizontalScrollViewForFeed == null) {
                return false;
            }
            if (distanceX > 1.0f && !this.canHorizontalScrollViewConsumeSlideRightOnDownForFeed) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.behavior.GuildSlideRightExitBehaviorHelper", "onScroll() -- " + distanceX + " canHorizontalScrollViewConsumeSlideRightOnDownForFeed");
                }
                this.canHorizontalScrollViewConsumeSlideRightOnDownForFeed = true;
            }
            return super.onScroll(e16, e26, distanceX, distanceY);
        }
    }

    public m(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.gestureDetector = new GestureDetectorCompat(context, e(context));
        this.offsetMap = new HashMap<>();
    }

    private final GestureDetector.SimpleOnGestureListener e(Context context) {
        return new b();
    }

    @Nullable
    public final Function0<Unit> d() {
        return this.slideRightCallback;
    }

    public final void f(@NotNull MotionEvent ev5, @NotNull ViewGroup rootView, boolean handled) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        this.touchEventHandled = handled;
        this.gestureDetector.onTouchEvent(ev5);
    }

    public final void g(@NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        boolean canScrollHorizontally = target.canScrollHorizontally(-1);
        boolean canScrollHorizontally2 = target.canScrollHorizontally(1);
        if (!canScrollHorizontally && !canScrollHorizontally2 && target.getId() == R.id.f98755ny) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.behavior.GuildSlideRightExitBehaviorHelper", "onStartNestedScroll " + axes + " " + type + " " + target + ", wont handle");
                return;
            }
            return;
        }
        int identityHashCode = System.identityHashCode(target);
        SlideState slideState = this.offsetMap.get(Integer.valueOf(identityHashCode));
        if (slideState == null) {
            slideState = new SlideState(canScrollHorizontally);
            this.offsetMap.put(Integer.valueOf(identityHashCode), slideState);
        }
        slideState.b(canScrollHorizontally);
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.behavior.GuildSlideRightExitBehaviorHelper", "onStartNestedScroll " + axes + " " + type + " " + target + " " + canScrollHorizontally + " " + canScrollHorizontally2);
        }
    }

    public final void h(@Nullable Function0<Unit> function0) {
        this.slideRightCallback = function0;
    }
}
