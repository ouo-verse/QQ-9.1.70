package com.tencent.icgame.game.floatwindow.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yu0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002$\u0014B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\b\u00a2\u0006\u0004\bL\u0010MJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0003J\"\u0010(\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\bR\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010,R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010)R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010)R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010)R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010?\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\"\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00105\u001a\u0004\b#\u0010@\"\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00105R\"\u0010H\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u00105\u001a\u0004\bF\u0010@\"\u0004\bG\u0010B\u00a8\u0006N"}, d2 = {"Lcom/tencent/icgame/game/floatwindow/impl/FloatWindowContainer;", "Landroid/widget/FrameLayout;", "", "", "fixPos", "isFreeDrag", "", "c", "", HippyTKDListViewAdapter.X, "y", "d", "Landroid/view/View;", "view", "roundCorners", "e", "Landroid/content/Context;", "context", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "b", "Lyu0/b;", "onDragListener", "setOnDragListener", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "Lyu0/a;", "listener", "setDragListener", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "isHorizontal", "a", "floatingWidgetWrapper", "customView", "roundCorner", "setRoundCorner", "I", "mTouchSlop", "Landroid/view/WindowManager;", "Landroid/view/WindowManager;", "mWindowManager", "f", "mScreenWidth", h.F, "mScreenHeight", "i", "mWindowType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsBeingDragged", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "mInitialMotionY", "D", "mInitialMotionX", "E", "Landroid/content/Context;", "mContext", "()Z", "setHorizontal", "(Z)V", "G", "mCanFreeDrag", "H", "getFloatShowing", "setFloatShowing", "floatShowing", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class FloatWindowContainer extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float mInitialMotionY;

    /* renamed from: D, reason: from kotlin metadata */
    private float mInitialMotionX;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isHorizontal;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mCanFreeDrag;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean floatShowing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WindowManager mWindowManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mScreenWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mScreenHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mWindowType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsBeingDragged;

    /* compiled from: P */
    @RequiresApi(api = 21)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/icgame/game/floatwindow/impl/FloatWindowContainer$b;", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "", "a", "I", "mRadius", "<init>", "(I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int mRadius;

        public b(int i3) {
            this.mRadius = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.mRadius);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatWindowContainer(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean b(Context context, String permission) {
        if (context.checkSelfPermission(permission) == 0) {
            return true;
        }
        return false;
    }

    private final void c(boolean fixPos, boolean isFreeDrag) {
        QLog.e("ICGameOpen_Live|ICGameFloatWindowContainer", 1, "onDragEndAnimation with null mNewFloatParams");
    }

    private final void e(View view, int roundCorners) {
        view.setOutlineProvider(new b(roundCorners));
        view.setClipToOutline(true);
    }

    public final void a(boolean isHorizontal) {
        this.isHorizontal = isHorizontal;
        QLog.i("ICGameOpen_Live|ICGameFloatWindowContainer", 1, "changeOrientation: isHorizontal:" + isHorizontal);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig != null) {
            if (newConfig.orientation == 2) {
                a(true);
            } else {
                a(false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r0 != 3) goto L23;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean z16 = true;
        if (ev5.getPointerCount() >= 2) {
            return true;
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y16 = ev5.getY();
                    float x16 = ev5.getX();
                    if (Math.abs(this.mInitialMotionY - y16) <= this.mTouchSlop && Math.abs(this.mInitialMotionX - x16) <= this.mTouchSlop) {
                        z16 = false;
                    }
                    this.mIsBeingDragged = z16;
                    if (z16) {
                        this.mInitialMotionY = ev5.getRawY();
                        this.mInitialMotionX = ev5.getRawX();
                    }
                }
            }
            this.mIsBeingDragged = false;
        } else {
            this.mInitialMotionY = ev5.getY();
            this.mInitialMotionX = ev5.getX();
            this.mIsBeingDragged = false;
        }
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r1 != 3) goto L24;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int pointerCount = event.getPointerCount();
        int action = event.getAction();
        boolean z16 = false;
        if (action != 1) {
            if (action == 2) {
                if (pointerCount == 1) {
                    if (!this.mIsBeingDragged) {
                        float y16 = event.getY();
                        float x16 = event.getX();
                        if (Math.abs(this.mInitialMotionY - y16) > this.mTouchSlop || Math.abs(this.mInitialMotionX - x16) > this.mTouchSlop) {
                            z16 = true;
                        }
                        this.mIsBeingDragged = z16;
                        if (z16) {
                            this.mInitialMotionY = event.getRawY();
                            this.mInitialMotionX = event.getRawX();
                        }
                    } else {
                        d((int) (event.getRawX() - this.mInitialMotionX), (int) (event.getRawY() - this.mInitialMotionY));
                    }
                }
            }
            return this.mIsBeingDragged;
        }
        if (this.mIsBeingDragged) {
            this.mIsBeingDragged = false;
            c(true, this.mCanFreeDrag);
        }
        return this.mIsBeingDragged;
    }

    public final void setDragListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void setFloatShowing(boolean z16) {
        this.floatShowing = z16;
    }

    public final void setHorizontal(boolean z16) {
        this.isHorizontal = z16;
    }

    public final void setRoundCorner(@Nullable View floatingWidgetWrapper, @Nullable View customView, int roundCorner) {
        if (roundCorner > 0) {
            if (floatingWidgetWrapper != null) {
                e(floatingWidgetWrapper, roundCorner);
            }
            if (customView != null) {
                e(customView, roundCorner);
            }
            e(this, roundCorner);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatWindowContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FloatWindowContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatWindowContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = 20;
        this.mContext = context;
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        this.mWindowManager = windowManager;
        if (windowManager != null) {
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
        }
        if (b(context, "android.permission.SYSTEM_ALERT_WINDOW")) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mWindowType = 2038;
            } else {
                this.mWindowType = 2002;
            }
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnDragListener(@Nullable yu0.b onDragListener) {
    }

    private final void d(int x16, int y16) {
    }
}
