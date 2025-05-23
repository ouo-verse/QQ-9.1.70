package com.tencent.mobileqq.activity.home.chats.biz.guild;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.widget.af;
import com.tencent.mobileqq.guild.widget.y;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002QRB'\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010M\u001a\u00020\"\u00a2\u0006\u0004\bN\u0010OJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\u0007*\u0004\u0018\u00010\u000bH\u0002J\f\u0010\u000e\u001a\u00020\r*\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0007H\u0016R$\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010(R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010$R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010<\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010,R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010ER\u0016\u0010G\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010$R\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010,\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildChatsFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/widget/y;", "Lcom/tencent/mobileqq/guild/widget/af;", "", "dx", "dy", "", "d", "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/e;", "e", "Landroid/view/VelocityTracker;", "g", "Landroid/view/MotionEvent;", "f", "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildChatsFrameLayout$a;", "listener", "setOnSlideListener", "event", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "ev", "dispatchTouchEvent", "disallowIntercept", "requestDisallowInterceptTouchEvent", "onTouchEvent", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "addRecyclerView", "removeRecyclerView", "isRefreshing", "setRefreshState", "", "<set-?>", "I", "c", "()I", "layoutWidth", UserInfo.SEX_FEMALE, "downX", "downY", h.F, "Z", "isIntercept", "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildChatsFrameLayout$Companion$DispatchEventState;", "i", "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildChatsFrameLayout$Companion$DispatchEventState;", "dispatchEventState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "touchSlopCount", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/e;", "layoutChangeListener", "D", "Landroid/view/VelocityTracker;", "velocityTracker", "E", "slideDetectTracker", "firstIntercept", "", "G", "[I", "interceptThresholds", "", "H", "[J", "touchCounts", "Landroidx/recyclerview/widget/RecyclerView;", "J", HippyTKDListViewAdapter.SCROLL_STATE, "K", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GuildChatsFrameLayout extends FrameLayout implements y, af {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private e layoutChangeListener;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private VelocityTracker velocityTracker;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private VelocityTracker slideDetectTracker;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean firstIntercept;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private int[] interceptThresholds;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private long[] touchCounts;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: J, reason: from kotlin metadata */
    private int scrollState;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isRefreshing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int layoutWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float downX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float downY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isIntercept;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Companion.DispatchEventState dispatchEventState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int touchSlopCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildChatsFrameLayout$a;", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/home/chats/biz/guild/GuildChatsFrameLayout$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Log.d("GuildChatsFrameLayout", "onScrollStateChanged: newState = " + newState);
            GuildChatsFrameLayout.this.scrollState = newState;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChatsFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean d(float dx5, float dy5) {
        if (dx5 > 0.0f && dx5 * 0.8d > Math.abs(dy5)) {
            return true;
        }
        return false;
    }

    private final e e() {
        return new e(new Function3<View, Rect, Rect, Unit>() { // from class: com.tencent.mobileqq.activity.home.chats.biz.guild.GuildChatsFrameLayout$newLayoutChangeListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view, Rect rect, Rect rect2) {
                invoke2(view, rect, rect2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View v3, @NotNull Rect rect, @NotNull Rect oldRect) {
                Intrinsics.checkNotNullParameter(v3, "v");
                Intrinsics.checkNotNullParameter(rect, "rect");
                Intrinsics.checkNotNullParameter(oldRect, "oldRect");
                QLog.e("GuildChatsFrameLayout", 2, "onLayoutChange: width = " + v3.getMeasuredWidth() + ", height = " + v3.getMeasuredHeight() + ", rect = " + rect + ", oldRect = " + oldRect);
                GuildChatsFrameLayout.this.layoutWidth = rect.width() - GuildLayoutManager.g();
                GuildChatsFrameLayout guildChatsFrameLayout = GuildChatsFrameLayout.this;
                ViewGroup.LayoutParams layoutParams = guildChatsFrameLayout.getLayoutParams();
                layoutParams.width = GuildChatsFrameLayout.this.getLayoutWidth();
                guildChatsFrameLayout.setLayoutParams(layoutParams);
            }
        });
    }

    private final MotionEvent f(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(obtain.getRawX() - obtain.getX(), 0.0f);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(this).apply {\n   \u2026n(rawX - x, 0f)\n        }");
        return obtain;
    }

    private final boolean g(VelocityTracker velocityTracker) {
        boolean z16 = false;
        if (velocityTracker == null) {
            return false;
        }
        velocityTracker.computeCurrentVelocity(1000);
        float xVelocity = velocityTracker.getXVelocity();
        float yVelocity = velocityTracker.getYVelocity();
        if (d(xVelocity, yVelocity) && Math.abs(xVelocity) > 1000.0f && this.scrollState != 0 && !this.isRefreshing) {
            z16 = true;
        }
        String arrays = Arrays.toString(this.touchCounts);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        Log.d("GuildChatsFrameLayout", "isDetectSlide: " + z16 + ", Vx = " + xVelocity + ", Vy = " + yVelocity + ", touchCounts=" + arrays + ", scroll=" + this.scrollState + ", refreshing=" + this.isRefreshing);
        return z16;
    }

    @Override // com.tencent.mobileqq.guild.widget.y
    public void addRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        recyclerView.addOnScrollListener(new b());
    }

    /* renamed from: c, reason: from getter */
    public final int getLayoutWidth() {
        return this.layoutWidth;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev5);
        if (ev5.getActionMasked() == 0) {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.slideDetectTracker = obtain;
            if (obtain != null) {
                obtain.addMovement(ev5);
            }
            if (!dispatchTouchEvent) {
                Log.d("GuildChatsFrameLayout", "force to eat event: " + ev5);
                this.isIntercept = true;
                return true;
            }
        } else if (ev5.getActionMasked() == 2) {
            long[] jArr = this.touchCounts;
            jArr[0] = jArr[0] + 1;
            VelocityTracker velocityTracker = this.slideDetectTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(ev5);
            }
            if (this.dispatchEventState == Companion.DispatchEventState.WAIT_FOR_CONSUME) {
                long[] jArr2 = this.touchCounts;
                if ((jArr2[0] - jArr2[1]) - jArr2[2] > 0) {
                    if (g(this.slideDetectTracker)) {
                        Log.d("GuildChatsFrameLayout", "force to intercept! event: " + ev5);
                        MotionEvent obtain2 = MotionEvent.obtain(ev5);
                        obtain2.setAction(3);
                        super.dispatchTouchEvent(obtain2);
                        obtain2.recycle();
                        this.dispatchEventState = Companion.DispatchEventState.CONSUME_TOUCH_EVENT;
                        this.downX = obtain2.getRawX();
                        this.isIntercept = true;
                    } else {
                        this.dispatchEventState = Companion.DispatchEventState.NOT_CONSUME_TOUCH_EVENT;
                    }
                }
            }
        }
        if (ev5.getActionMasked() == 1 || ev5.getActionMasked() == 3) {
            this.touchCounts = new long[]{0, 0, 0};
            this.touchSlopCount = 0;
            VelocityTracker velocityTracker2 = this.slideDetectTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
            this.slideDetectTracker = null;
            this.dispatchEventState = Companion.DispatchEventState.WAIT_FOR_CONSUME;
            Log.d("GuildChatsFrameLayout", "reset touchSlopCount: " + this.touchSlopCount);
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).addOnLayoutChangeListener(this.layoutChangeListener);
        this.velocityTracker = VelocityTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeOnLayoutChangeListener(this.layoutChangeListener);
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        if (r8 != 3) goto L34;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(event);
        if (this.isRefreshing) {
            return false;
        }
        if (event.getActionMasked() == 2) {
            long[] jArr = this.touchCounts;
            jArr[1] = jArr[1] + 1;
        }
        if (event.getActionMasked() == 3 || event.getActionMasked() == 1) {
            this.touchCounts[1] = 0;
        }
        if (onInterceptTouchEvent) {
            QLog.e("GuildChatsFrameLayout", 1, "onInterceptTouchEvent: " + onInterceptTouchEvent + ", " + event + ", by super");
            return true;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (event.getRawX() - this.downX > DisplayHelper.dpToPx(this.interceptThresholds[this.touchSlopCount]) && d(event.getRawX() - this.downX, event.getRawY() - this.downY)) {
                        Log.d("GuildChatsFrameLayout", "touchSlopCount: " + this.touchSlopCount + ", " + (event.getRawX() - this.downX) + " > " + this.interceptThresholds[this.touchSlopCount] + " match!");
                        int i3 = this.touchSlopCount;
                        if (i3 >= this.interceptThresholds.length - 1) {
                            this.touchSlopCount = 0;
                            this.isIntercept = true;
                            this.firstIntercept = true;
                            this.downX = event.getRawX();
                            onInterceptTouchEvent = true;
                        } else {
                            this.touchSlopCount = i3 + 1;
                        }
                    } else {
                        Log.d("GuildChatsFrameLayout", "touchSlopCount: " + this.touchSlopCount + ", " + (event.getRawX() - this.downX) + " <= " + this.interceptThresholds[this.touchSlopCount] + " not match!");
                        this.downX = event.getRawX();
                        this.touchSlopCount = 0;
                    }
                }
            }
            this.isIntercept = false;
            this.touchSlopCount = 0;
        } else {
            this.downX = event.getRawX();
            this.downY = event.getRawY();
        }
        QLog.e("GuildChatsFrameLayout", 1, "onInterceptTouchEvent: " + onInterceptTouchEvent + ", " + event);
        return onInterceptTouchEvent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
    
        if (r0 != 3) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean onTouchEvent = super.onTouchEvent(event);
        if (onTouchEvent) {
            return onTouchEvent;
        }
        if (event.getActionMasked() == 2) {
            long[] jArr = this.touchCounts;
            jArr[2] = jArr[2] + 1;
        } else if (event.getActionMasked() == 3 || event.getActionMasked() == 1) {
            this.touchCounts[2] = 0;
        }
        if (this.isIntercept) {
            MotionEvent f16 = f(event);
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(f16);
            }
            QLog.e("GuildChatsFrameLayout", 1, "slideByTouchEvent: " + f16);
            int actionMasked = f16.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        f16.getRawX();
                        if (this.isRefreshing) {
                            this.isIntercept = false;
                        }
                    }
                }
                this.isIntercept = false;
            } else if (this.isRefreshing) {
                this.isIntercept = false;
            } else {
                this.downX = f16.getRawX();
            }
            f16.recycle();
            return true;
        }
        QLog.e("GuildChatsFrameLayout", 1, "not intercept onTouchEvent: " + onTouchEvent + ", " + this.isRefreshing + ", " + event);
        if (event.getActionMasked() == 2 && !this.isRefreshing) {
            MotionEvent f17 = f(event);
            this.downX = f17.getRawX();
            this.isIntercept = true;
            f17.recycle();
            return onTouchEvent;
        }
        return onTouchEvent;
    }

    @Override // com.tencent.mobileqq.guild.widget.y
    public void removeRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Log.d("GuildChatsFrameLayout", "requestDisallowInterceptTouchEvent: " + disallowIntercept);
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    public final void setOnSlideListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.mobileqq.guild.widget.af
    public void setRefreshState(boolean isRefreshing) {
        this.isRefreshing = isRefreshing;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChatsFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildChatsFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChatsFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dispatchEventState = Companion.DispatchEventState.WAIT_FOR_CONSUME;
        this.layoutChangeListener = e();
        this.interceptThresholds = new int[]{4, 8, 0};
        this.touchCounts = new long[]{0, 0, 0};
        QLog.e("GuildChatsFrameLayout", 2, "init");
    }
}
