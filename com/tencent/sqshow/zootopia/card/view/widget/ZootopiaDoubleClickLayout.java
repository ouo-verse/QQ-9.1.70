package com.tencent.sqshow.zootopia.card.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 e2\u00020\u0001:\u0004fg\u001f*B\u0011\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u00a2\u0006\u0004\b^\u0010_B\u0019\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010a\u001a\u00020`\u00a2\u0006\u0004\b^\u0010bB!\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010c\u001a\u00020-\u00a2\u0006\u0004\b^\u0010dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\"\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010%\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u001c\u0010(\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010)\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0002R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010.R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010.R\u0016\u00101\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010.R\u0018\u00103\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010.R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010+R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010+R\u0018\u0010C\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010BR\u0018\u0010H\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010BR\u0018\u0010J\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010BR\u0016\u0010M\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010GR\u0016\u0010O\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010GR\u0016\u0010Q\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010+R\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u0014\u0010Z\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u0010Y\u00a8\u0006h"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout;", "Landroid/widget/FrameLayout;", "", "isEnable", "", "setEnableDoubleClick", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$c;", "listener", "setOnLongClickListener", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$b;", "setOnDoubleClickListener", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$d;", "setOnTapClickListener", "t", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "event", "onTouchEvent", "i", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "g", "move", "isLeft", "isTop", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "down", "p", "up", "r", "c", "e", "f", "firstDown", "firstUp", "secondDown", "j", "lastEvent", "currentEvent", "k", DomainData.DOMAIN_NAME, "d", "Z", "mIsEnableDoubleClick", "", "I", "doubleTapSlop", "mDoubleTapSlopSquare", "mTouchSlop", "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$d;", "mOnTapClickListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$b;", "mOnDoubleClickListener", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Handler;", "mHandler", "D", "mClickCount", "E", "mIsRunnablePosting", UserInfo.SEX_FEMALE, "isRestByMove", "G", "Landroid/view/MotionEvent;", "mFirstDownEvent", "H", "mFirstUpEvent", "mPreviousDownEvent", "J", "mPreviousUpEvent", "K", "mPreviousMoveEvent", "", "L", "mCurrentDoubleClickTime", "M", "mCurrentSingleClickTime", "N", "mIsContinuousDoubleClick", "Ljava/lang/Runnable;", "P", "Ljava/lang/Runnable;", "mClickRunnable", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mLongClickRunnable", "l", "()Z", "isSatisfyDoubleClickTime", "isSatisfySingleClickTime", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Req, "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaDoubleClickLayout extends FrameLayout {
    private static long S = 300;
    private static long T = 50;
    private static final long U = 300;
    private static final int V = ViewConfiguration.getLongPressTimeout();

    /* renamed from: C, reason: from kotlin metadata */
    private final Handler mHandler;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile int mClickCount;

    /* renamed from: E, reason: from kotlin metadata */
    private volatile boolean mIsRunnablePosting;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isRestByMove;

    /* renamed from: G, reason: from kotlin metadata */
    private MotionEvent mFirstDownEvent;

    /* renamed from: H, reason: from kotlin metadata */
    private MotionEvent mFirstUpEvent;

    /* renamed from: I, reason: from kotlin metadata */
    private MotionEvent mPreviousDownEvent;

    /* renamed from: J, reason: from kotlin metadata */
    private MotionEvent mPreviousUpEvent;

    /* renamed from: K, reason: from kotlin metadata */
    private MotionEvent mPreviousMoveEvent;

    /* renamed from: L, reason: from kotlin metadata */
    private long mCurrentDoubleClickTime;

    /* renamed from: M, reason: from kotlin metadata */
    private long mCurrentSingleClickTime;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsContinuousDoubleClick;

    /* renamed from: P, reason: from kotlin metadata */
    private Runnable mClickRunnable;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Runnable mLongClickRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsEnableDoubleClick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int doubleTapSlop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mDoubleTapSlopSquare;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private d mOnTapClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private b mOnDoubleClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$b;", "", "Landroid/view/MotionEvent;", "event", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(MotionEvent event);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$c;", "", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/ZootopiaDoubleClickLayout$d;", "", "Landroid/view/MotionEvent;", "event", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface d {
        void a(MotionEvent event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDoubleClickLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsEnableDoubleClick = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mLongClickRunnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.card.view.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDoubleClickLayout.o(ZootopiaDoubleClickLayout.this);
            }
        };
        i();
    }

    private final void c(final MotionEvent ev5) {
        long j3;
        if (ev5 == null) {
            QLog.e("ZootopiaDoubleClickLayout", 1, "[dealActionDown] ev should not be null.");
            return;
        }
        if (this.mFirstDownEvent == null) {
            this.mFirstDownEvent = MotionEvent.obtain(ev5);
            this.mClickCount = 1;
            QLog.d("ZootopiaDoubleClickLayout", 4, "firstdown clickcount:" + this.mClickCount);
        }
        if (this.mClickCount >= 1 && j(this.mPreviousDownEvent, this.mPreviousUpEvent, ev5)) {
            this.mClickCount++;
            QLog.d("ZootopiaDoubleClickLayout", 4, "considerdown clickcount:" + this.mClickCount);
        }
        if (m()) {
            this.mIsContinuousDoubleClick = false;
        }
        if (!this.mIsRunnablePosting) {
            Runnable runnable = this.mClickRunnable;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.tencent.sqshow.zootopia.card.view.widget.g
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaDoubleClickLayout.d(ZootopiaDoubleClickLayout.this, ev5);
                }
            };
            this.mClickRunnable = runnable2;
            Handler handler = this.mHandler;
            if (this.mIsContinuousDoubleClick) {
                j3 = T;
            } else {
                j3 = S;
            }
            handler.postDelayed(runnable2, j3);
            this.mHandler.removeCallbacks(this.mLongClickRunnable);
            this.mHandler.postDelayed(this.mLongClickRunnable, V);
            this.mIsRunnablePosting = true;
        }
        MotionEvent motionEvent = this.mPreviousDownEvent;
        if (motionEvent != null) {
            Intrinsics.checkNotNull(motionEvent);
            motionEvent.recycle();
        }
        this.mPreviousDownEvent = MotionEvent.obtain(ev5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ZootopiaDoubleClickLayout this$0, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mIsRunnablePosting = false;
        QLog.d("ZootopiaDoubleClickLayout", 1, "[run] mClickCount: " + this$0.mClickCount);
        if (this$0.mClickCount >= 2) {
            this$0.s(motionEvent);
        } else if (this$0.mClickCount == 1 && this$0.mIsContinuousDoubleClick) {
            this$0.s(motionEvent);
        } else if (this$0.mClickCount == 1) {
            this$0.h();
        }
        this$0.mClickCount = 0;
        this$0.mFirstDownEvent = null;
        this$0.mFirstUpEvent = null;
        this$0.mPreviousDownEvent = null;
        this$0.mPreviousUpEvent = null;
        this$0.mPreviousMoveEvent = null;
    }

    private final void g() {
        MotionEvent motionEvent;
        if (this.mPreviousMoveEvent != null && (motionEvent = this.mPreviousDownEvent) != null) {
            p(motionEvent);
            MotionEvent motionEvent2 = this.mPreviousMoveEvent;
            MotionEvent motionEvent3 = this.mPreviousDownEvent;
            Intrinsics.checkNotNull(motionEvent3);
            float x16 = motionEvent3.getX();
            MotionEvent motionEvent4 = this.mPreviousMoveEvent;
            Intrinsics.checkNotNull(motionEvent4);
            boolean z16 = x16 > motionEvent4.getX();
            MotionEvent motionEvent5 = this.mPreviousDownEvent;
            Intrinsics.checkNotNull(motionEvent5);
            float y16 = motionEvent5.getY();
            MotionEvent motionEvent6 = this.mPreviousMoveEvent;
            Intrinsics.checkNotNull(motionEvent6);
            q(motionEvent2, z16, y16 > motionEvent6.getY());
            QLog.d("ZootopiaDoubleClickLayout", 4, "move success");
            return;
        }
        QLog.d("ZootopiaDoubleClickLayout", 4, "move error");
    }

    private final void h() {
        if (!m()) {
            QLog.d("ZootopiaDoubleClickLayout", 1, "[dispatchSingleClickEvent] current not need single click time, end flow.");
            return;
        }
        this.mCurrentSingleClickTime = System.currentTimeMillis();
        if (n(this.mFirstDownEvent, this.mFirstUpEvent)) {
            p(this.mFirstDownEvent);
            r(this.mFirstUpEvent);
            d dVar = this.mOnTapClickListener;
            if (dVar != null) {
                Intrinsics.checkNotNull(dVar);
                dVar.a(this.mFirstDownEvent);
            }
            QLog.d("ZootopiaDoubleClickLayout", 1, "singleTap success");
            return;
        }
        QLog.d("ZootopiaDoubleClickLayout", 1, "singleTap error");
    }

    private final void i() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.doubleTapSlop = scaledDoubleTapSlop;
        this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
    }

    private final boolean l() {
        return System.currentTimeMillis() - this.mCurrentSingleClickTime >= 560;
    }

    private final boolean m() {
        return System.currentTimeMillis() - this.mCurrentDoubleClickTime >= 500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ZootopiaDoubleClickLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
    }

    private final void s(MotionEvent event) {
        if (this.mOnDoubleClickListener == null) {
            QLog.e("ZootopiaDoubleClickLayout", 1, "[notifyDoubleClick] double click listener should not be null.");
            return;
        }
        if (!l()) {
            QLog.d("ZootopiaDoubleClickLayout", 1, "[notifyDoubleClick] current not need double click time, end flow.");
            return;
        }
        this.mCurrentDoubleClickTime = System.currentTimeMillis();
        b bVar = this.mOnDoubleClickListener;
        Intrinsics.checkNotNull(bVar);
        bVar.a(event);
        this.mIsContinuousDoubleClick = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.mIsEnableDoubleClick && ev5.getSource() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ZootopiaDoubleClickLayout", 2, "event:" + ev5.getAction() + " mIsRunnablePosting:" + this.mIsRunnablePosting);
            }
            if (ev5.getAction() == 0) {
                c(ev5);
            } else if (ev5.getAction() == 1) {
                this.mHandler.removeCallbacks(this.mLongClickRunnable);
                if (this.isRestByMove) {
                    QLog.w("ZootopiaDoubleClickLayout", 1, "[dispatchTouchEvent] isRestByMove == true...");
                    this.isRestByMove = false;
                    return super.dispatchTouchEvent(ev5);
                }
                f(ev5);
            } else if (ev5.getAction() == 2) {
                e(ev5);
            } else if (ev5.getAction() == 3) {
                t();
            }
            if (this.mIsRunnablePosting) {
                return true;
            }
            return super.dispatchTouchEvent(ev5);
        }
        QLog.d("ZootopiaDoubleClickLayout", 4, "not intercept");
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    public final void setEnableDoubleClick(boolean isEnable) {
        this.mIsEnableDoubleClick = isEnable;
    }

    public final void setOnDoubleClickListener(b listener) {
        this.mOnDoubleClickListener = listener;
    }

    public final void setOnTapClickListener(d listener) {
        this.mOnTapClickListener = listener;
    }

    private final boolean n(MotionEvent firstDown, MotionEvent firstUp) {
        if (firstDown != null && firstUp != null) {
            boolean z16 = !k(firstDown, firstUp);
            if (QLog.isColorLevel()) {
                QLog.d("ZootopiaDoubleClickLayout", 2, "[isSingleTap] isNotConsideredScroll: " + z16);
            }
            return z16;
        }
        QLog.d("ZootopiaDoubleClickLayout", 1, "[isSingleTap] firstDown: " + firstDown + " | firstUp: " + firstUp);
        return false;
    }

    public final void t() {
        this.mIsEnableDoubleClick = true;
        this.mClickCount = 0;
        this.mIsRunnablePosting = false;
        this.mFirstDownEvent = null;
        this.mFirstUpEvent = null;
        this.mPreviousDownEvent = null;
        this.mPreviousUpEvent = null;
        this.mPreviousMoveEvent = null;
        this.isRestByMove = false;
        this.mCurrentDoubleClickTime = 0L;
        this.mCurrentSingleClickTime = 0L;
        Runnable runnable = this.mClickRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        this.mHandler.removeCallbacks(this.mLongClickRunnable);
    }

    private final void p(MotionEvent down) {
        if (down != null) {
            super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, down.getX(), down.getY(), 0));
        }
    }

    private final void r(MotionEvent up5) {
        if (up5 != null) {
            super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, up5.getX(), up5.getY(), 0));
        }
    }

    private final void e(MotionEvent ev5) {
        if (ev5 == null) {
            return;
        }
        MotionEvent motionEvent = this.mPreviousMoveEvent;
        if (motionEvent != null) {
            Intrinsics.checkNotNull(motionEvent);
            motionEvent.recycle();
        }
        MotionEvent obtain = MotionEvent.obtain(ev5);
        this.mPreviousMoveEvent = obtain;
        if (k(this.mPreviousDownEvent, obtain)) {
            this.mHandler.removeCallbacks(this.mLongClickRunnable);
            g();
            t();
            this.isRestByMove = true;
        }
    }

    private final void f(MotionEvent ev5) {
        if (ev5 == null) {
            QLog.e("ZootopiaDoubleClickLayout", 1, "[dealActionUp] ev should not be null.");
            return;
        }
        if (this.mFirstUpEvent == null) {
            this.mFirstUpEvent = MotionEvent.obtain(ev5);
        }
        MotionEvent motionEvent = this.mPreviousUpEvent;
        if (motionEvent != null) {
            Intrinsics.checkNotNull(motionEvent);
            motionEvent.recycle();
        }
        this.mPreviousUpEvent = MotionEvent.obtain(ev5);
    }

    private final void q(MotionEvent move, boolean isLeft, boolean isTop) {
        float x16;
        if (move == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (isLeft) {
            x16 = move.getX() - this.mTouchSlop;
        } else {
            x16 = move.getX() + this.mTouchSlop;
        }
        float f16 = x16;
        float y16 = move.getY();
        float f17 = this.mTouchSlop;
        super.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis2, 2, f16, isTop ? y16 - f17 : y16 + f17, 0));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDoubleClickLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mIsEnableDoubleClick = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mLongClickRunnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.card.view.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDoubleClickLayout.o(ZootopiaDoubleClickLayout.this);
            }
        };
        i();
    }

    private final boolean j(MotionEvent firstDown, MotionEvent firstUp, MotionEvent secondDown) {
        if (firstDown == null || firstUp == null || secondDown.getEventTime() - firstUp.getEventTime() > U || k(firstDown, firstUp)) {
            return false;
        }
        int x16 = ((int) firstDown.getX()) - ((int) secondDown.getX());
        int y16 = ((int) firstDown.getY()) - ((int) secondDown.getY());
        return (x16 * x16) + (y16 * y16) < this.mDoubleTapSlopSquare;
    }

    private final boolean k(MotionEvent lastEvent, MotionEvent currentEvent) {
        if (lastEvent == null || currentEvent == null) {
            return false;
        }
        int x16 = ((int) currentEvent.getX()) - ((int) lastEvent.getX());
        int y16 = ((int) currentEvent.getY()) - ((int) lastEvent.getY());
        return (x16 * x16) + (y16 * y16) > this.mTouchSlop;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDoubleClickLayout(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mIsEnableDoubleClick = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mLongClickRunnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.card.view.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDoubleClickLayout.o(ZootopiaDoubleClickLayout.this);
            }
        };
        i();
    }

    public final void setOnLongClickListener(c listener) {
    }
}
