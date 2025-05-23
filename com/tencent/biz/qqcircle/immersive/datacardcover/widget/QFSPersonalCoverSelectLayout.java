package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverSelectLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001UB\u0019\u0012\u0006\u0010P\u001a\u00020O\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0014J(\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0014J0\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0014J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000f\u0010!\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010#\u001a\u00020\u0003J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0014R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u0010.\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u00018\u0000@BX\u0080.\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u00107R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00109R\u0016\u0010<\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010(R\u0016\u0010D\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010CR$\u0010G\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bE\u00109\u001a\u0004\b0\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020L8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010M\u00a8\u0006V"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverSelectLayout;", "Landroid/widget/FrameLayout;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "", "parentLeft", "parentHeight", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/MotionEvent;", "event", "", "g", h.F, "", "transY", "p", "c", "o", "onFinishInflate", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "changed", "left", "top", "right", "bottom", "onLayout", "onTouchEvent", "j", "()Z", "l", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "d", "I", "touchSlop", "<set-?>", "e", "Landroid/widget/FrameLayout;", "()Landroid/widget/FrameLayout;", "moveView", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBlurView;", "f", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBlurView;", "blurView", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverRegionView;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverRegionView;", "regionView", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPreviewView;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPreviewView;", "previewView", UserInfo.SEX_FEMALE, "downY", BdhLogUtil.LogTag.Tag_Conn, "lastY", "Landroid/graphics/Rect;", "D", "Landroid/graphics/Rect;", "regionRect", "E", "currentState", "Z", "isFirstDraw", "G", "()F", "yPercent", "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "startStaticRunnable", "", "()Ljava/lang/String;", "logState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverSelectLayout extends FrameLayout {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int J = cx.a(350.0f);
    private static final int K = cx.a(17.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private float lastY;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Rect regionRect;

    /* renamed from: E, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFirstDraw;

    /* renamed from: G, reason: from kotlin metadata */
    private float yPercent;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Runnable startStaticRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int touchSlop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout moveView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QFSPersonalCoverBlurView blurView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QFSPersonalCoverRegionView regionView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QFSPersonalCoverPreviewView previewView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float downY;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverSelectLayout$a;", "", "", "regionHeight", "I", "a", "()I", "", "ACTIVE_TO_STATIC_DELAY_MILLS", "J", "STATE_ACTIVE", "STATE_STATIC", "", "TAG", "Ljava/lang/String;", "previewViewOffset", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverSelectLayout$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QFSPersonalCoverSelectLayout.J;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverSelectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.regionRect = new Rect();
        this.currentState = 1;
        this.isFirstDraw = true;
        this.yPercent = -1.0f;
        this.startStaticRunnable = new Runnable() { // from class: k40.l
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalCoverSelectLayout.n(QFSPersonalCoverSelectLayout.this);
            }
        };
    }

    private final String d() {
        if (this.currentState == 1) {
            return "active";
        }
        return "static";
    }

    private final boolean g(MotionEvent event) {
        if (!j()) {
            QLog.d("QFSPersonalCoverSelectLayout", 1, "handleDown, not enough height: " + e().getHeight());
            return false;
        }
        QLog.d("QFSPersonalCoverSelectLayout", 1, "handleDown ");
        m();
        this.downY = event.getY();
        this.lastY = event.getY();
        return true;
    }

    private final void h(MotionEvent event) {
        float y16 = event.getY() - this.lastY;
        if (y16 > 0.0f) {
            float y17 = e().getY();
            int i3 = this.regionRect.top;
            if (y17 < i3) {
                if (y17 + y16 > i3) {
                    y16 = i3 - y17;
                    p(y16);
                } else {
                    p(y16);
                }
            }
        }
        if (y16 < 0.0f) {
            float y18 = e().getY() + e().getHeight();
            int i16 = this.regionRect.bottom;
            if (y18 > i16) {
                if (y18 + y16 < i16) {
                    y16 = i16 - y18;
                    p(y16);
                } else {
                    p(y16);
                }
            }
        }
        this.lastY = event.getY();
        if (Math.abs(y16) > this.touchSlop / 4) {
            m();
        }
    }

    private final void i() {
        QLog.d("QFSPersonalCoverSelectLayout", 1, "immediate2Active, currentState: " + d());
        removeCallbacks(this.startStaticRunnable);
        if (this.currentState == 1) {
            return;
        }
        this.currentState = 1;
        o();
    }

    private final void k(int parentLeft, int parentHeight) {
        int i3 = ((parentHeight / 2) + (J / 2)) - K;
        QFSPersonalCoverPreviewView qFSPersonalCoverPreviewView = this.previewView;
        QFSPersonalCoverPreviewView qFSPersonalCoverPreviewView2 = null;
        if (qFSPersonalCoverPreviewView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewView");
            qFSPersonalCoverPreviewView = null;
        }
        QFSPersonalCoverPreviewView qFSPersonalCoverPreviewView3 = this.previewView;
        if (qFSPersonalCoverPreviewView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewView");
            qFSPersonalCoverPreviewView3 = null;
        }
        int measuredWidth = qFSPersonalCoverPreviewView3.getMeasuredWidth() + parentLeft;
        QFSPersonalCoverPreviewView qFSPersonalCoverPreviewView4 = this.previewView;
        if (qFSPersonalCoverPreviewView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewView");
        } else {
            qFSPersonalCoverPreviewView2 = qFSPersonalCoverPreviewView4;
        }
        qFSPersonalCoverPreviewView.layout(parentLeft, i3, measuredWidth, qFSPersonalCoverPreviewView2.getMeasuredHeight() + i3);
    }

    private final void m() {
        if (QLog.isColorLevel()) {
            QLog.d("QFSPersonalCoverSelectLayout", 1, "pending2Static, currentState: " + d());
        }
        if (this.currentState == 2) {
            i();
        }
        removeCallbacks(this.startStaticRunnable);
        postDelayed(this.startStaticRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QFSPersonalCoverSelectLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSPersonalCoverSelectLayout", 1, "startStaticRunnable, currentState: " + this$0.d());
        if (this$0.currentState == 2) {
            return;
        }
        this$0.currentState = 2;
        this$0.c();
    }

    private final void p(float transY) {
        e().setTranslationY(e().getTranslationY() + transY);
    }

    private final void q() {
        float y16 = (this.regionRect.top - e().getY()) / e().getHeight();
        this.yPercent = y16;
        QLog.d("QFSPersonalCoverSelectLayout", 1, "updateYPercent, yPercent: " + y16);
    }

    public void c() {
        QFSPersonalCoverRegionView qFSPersonalCoverRegionView = this.regionView;
        QFSPersonalCoverPreviewView qFSPersonalCoverPreviewView = null;
        if (qFSPersonalCoverRegionView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("regionView");
            qFSPersonalCoverRegionView = null;
        }
        qFSPersonalCoverRegionView.c();
        QFSPersonalCoverPreviewView qFSPersonalCoverPreviewView2 = this.previewView;
        if (qFSPersonalCoverPreviewView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewView");
        } else {
            qFSPersonalCoverPreviewView = qFSPersonalCoverPreviewView2;
        }
        qFSPersonalCoverPreviewView.A0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.isFirstDraw) {
            this.isFirstDraw = false;
            m();
        }
    }

    @NotNull
    public final FrameLayout e() {
        FrameLayout frameLayout = this.moveView;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("moveView");
        return null;
    }

    /* renamed from: f, reason: from getter */
    public final float getYPercent() {
        return this.yPercent;
    }

    public final boolean j() {
        boolean z16;
        if (e().getHeight() > J) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QFSPersonalCoverSelectLayout", 1, "isMoveViewCanMove: " + z16);
        }
        return z16;
    }

    public final void l() {
        p((-1) * e().getTranslationY());
    }

    public void o() {
        QFSPersonalCoverRegionView qFSPersonalCoverRegionView = this.regionView;
        QFSPersonalCoverPreviewView qFSPersonalCoverPreviewView = null;
        if (qFSPersonalCoverRegionView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("regionView");
            qFSPersonalCoverRegionView = null;
        }
        qFSPersonalCoverRegionView.j();
        QFSPersonalCoverPreviewView qFSPersonalCoverPreviewView2 = this.previewView;
        if (qFSPersonalCoverPreviewView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewView");
        } else {
            qFSPersonalCoverPreviewView = qFSPersonalCoverPreviewView2;
        }
        qFSPersonalCoverPreviewView.D0();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.f57002m5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_video_container)");
        this.moveView = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.f34320yu);
        QFSPersonalCoverBlurView qFSPersonalCoverBlurView = (QFSPersonalCoverBlurView) findViewById2;
        qFSPersonalCoverBlurView.setSelectLayout(this);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<QFSPersonal\u2026erSelectLayout)\n        }");
        this.blurView = qFSPersonalCoverBlurView;
        View findViewById3 = findViewById(R.id.f5186299);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_region_view)");
        this.regionView = (QFSPersonalCoverRegionView) findViewById3;
        View findViewById4 = findViewById(R.id.f494822t);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_preview_view)");
        this.previewView = (QFSPersonalCoverPreviewView) findViewById4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        k(left, bottom - top);
        q();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        Rect rect = this.regionRect;
        rect.left = 0;
        int i3 = J;
        int i16 = (h16 / 2) - (i3 / 2);
        rect.top = i16;
        rect.right = w3;
        rect.bottom = i16 + i3;
        QLog.d("QFSPersonalCoverSelectLayout", 1, "onSizeChanged, regionRect:" + rect);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    h(event);
                }
                return super.onTouchEvent(event);
            }
            q();
            return super.onTouchEvent(event);
        }
        return g(event);
    }
}
