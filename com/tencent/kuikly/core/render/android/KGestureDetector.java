package com.tencent.kuikly.core.render.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 b2\u00020\u0001:\u0007$')+.c0B\u001d\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010_\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b`\u0010aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J$\u0010\u0011\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\tJ\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\rH\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010%R\u0016\u00101\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010%R\u001a\u00104\u001a\u000602R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010:R\u0016\u0010=\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010<R\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010<R\u0016\u0010?\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010<R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010<R\u0016\u0010A\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010<R\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010<R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010<R\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010<R\u0018\u0010F\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0016\u0010L\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010<R\u0016\u0010N\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010,R\u0016\u0010P\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010,R\u0016\u0010R\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010,R\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010,R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010<R\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010<R\u0016\u0010^\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006d"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KGestureDetector;", "", "Landroid/content/Context;", "context", "", "l", "", "scrollX", "scrollY", "", "g", tl.h.F, "i", "Landroid/view/MotionEvent;", "firstDown", "firstUp", "secondDown", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$d;", "onDoubleTapListener", "r", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$c;", "onContextClickListener", "p", "isLongpressEnabled", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "enable", "k", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$ScrollDirection;", "direction", ReportConstant.COSTREPORT_PREFIX, "o", "ev", DomainData.DOMAIN_NAME, "", "a", "I", "mTouchSlopSquare", "b", "mDoubleTapTouchSlopSquare", "c", "mDoubleTapSlopSquare", "d", UserInfo.SEX_FEMALE, "mAmbiguousGestureMultiplier", "e", "mMinimumFlingVelocity", "f", "mMaximumFlingVelocity", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$b;", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$b;", "mHandler", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$e;", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$e;", "mListener", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$d;", "mDoubleTapListener", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$c;", "mContextClickListener", "Z", "mStillDown", "mDeferConfirmSingleTap", "mInLongPress", "mInContextClick", "mAlwaysInTapRegion", "mAlwaysInBiggerTapRegion", "mIgnoreNextUpEvent", "mHasRecordedClassification", "Landroid/view/MotionEvent;", "mCurrentDownEvent", "t", "mCurrentMotionEvent", "u", "mPreviousUpEvent", "v", "mIsDoubleTapping", "w", "mLastFocusX", HippyTKDListViewAdapter.X, "mLastFocusY", "y", "mDownFocusX", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "mDownFocusY", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/VelocityTracker;", "B", "Landroid/view/VelocityTracker;", "mVelocityTracker", BdhLogUtil.LogTag.Tag_Conn, "mIsExactlyScrollEnabled", "D", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$ScrollDirection;", "scrollDirection", "listener", "<init>", "(Landroid/content/Context;Lcom/tencent/kuikly/core/render/android/KGestureDetector$e;)V", "H", "ScrollDirection", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public class KGestureDetector {

    /* renamed from: A, reason: from kotlin metadata */
    private boolean isLongpressEnabled;

    /* renamed from: B, reason: from kotlin metadata */
    private VelocityTracker mVelocityTracker;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsExactlyScrollEnabled;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlopSquare;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mDoubleTapTouchSlopSquare;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mDoubleTapSlopSquare;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mAmbiguousGestureMultiplier;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mMinimumFlingVelocity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mMaximumFlingVelocity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private e mListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private d mDoubleTapListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private c mContextClickListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mStillDown;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean mDeferConfirmSingleTap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mInLongPress;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean mInContextClick;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean mAlwaysInTapRegion;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean mAlwaysInBiggerTapRegion;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean mIgnoreNextUpEvent;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean mHasRecordedClassification;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private MotionEvent mCurrentDownEvent;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private MotionEvent mCurrentMotionEvent;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private MotionEvent mPreviousUpEvent;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private boolean mIsDoubleTapping;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private float mLastFocusX;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private float mLastFocusY;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private float mDownFocusX;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private float mDownFocusY;
    private static final int E = ViewConfiguration.getTapTimeout();
    private static final int F = ViewConfiguration.getDoubleTapTimeout();
    private static final int G = 40;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private b mHandler = new b();

    /* renamed from: D, reason: from kotlin metadata */
    private ScrollDirection scrollDirection = ScrollDirection.DIRECTION_ALL;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KGestureDetector$ScrollDirection;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "DIRECTION_ALL", "DIRECTION_VERTICAL", "DIRECTION_HORIZONTAL", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public enum ScrollDirection {
        DIRECTION_ALL(0),
        DIRECTION_VERTICAL(1),
        DIRECTION_HORIZONTAL(2);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KGestureDetector$ScrollDirection$a;", "", "", "value", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$ScrollDirection;", "a", "", "b", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.kuikly.core.render.android.KGestureDetector$ScrollDirection$a, reason: from kotlin metadata */
        /* loaded from: classes7.dex */
        public static final class Companion {
            Companion() {
            }

            @NotNull
            public final ScrollDirection a(int value) {
                ScrollDirection scrollDirection;
                boolean z16;
                ScrollDirection[] values = ScrollDirection.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        scrollDirection = values[i3];
                        if (scrollDirection.getValue() == value) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i3++;
                    } else {
                        scrollDirection = null;
                        break;
                    }
                }
                if (scrollDirection == null) {
                    return ScrollDirection.DIRECTION_ALL;
                }
                return scrollDirection;
            }

            public final boolean b(int value) {
                if (ScrollDirection.DIRECTION_HORIZONTAL.getValue() != value && ScrollDirection.DIRECTION_VERTICAL.getValue() != value) {
                    return false;
                }
                return true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        ScrollDirection(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KGestureDetector$b;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "<init>", "(Lcom/tencent/kuikly/core/render/android/KGestureDetector;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public final class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 == 1) {
                e eVar = KGestureDetector.this.mListener;
                if (eVar != null) {
                    eVar.onShowPress(KGestureDetector.this.mCurrentDownEvent);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                KGestureDetector.this.j();
                return;
            }
            if (i3 == 3) {
                if (KGestureDetector.this.mDoubleTapListener != null) {
                    if (!KGestureDetector.this.mStillDown) {
                        d dVar = KGestureDetector.this.mDoubleTapListener;
                        if (dVar != null) {
                            dVar.onSingleTapConfirmed(KGestureDetector.this.mCurrentDownEvent);
                            return;
                        }
                        return;
                    }
                    KGestureDetector.this.mDeferConfirmSingleTap = true;
                    return;
                }
                return;
            }
            throw new RuntimeException("Unknown message " + msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KGestureDetector$c;", "", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KGestureDetector$d;", "", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "onDoubleTap", "onDoubleTapEvent", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public interface d {
        boolean onDoubleTap(@Nullable MotionEvent e16);

        boolean onDoubleTapEvent(@NotNull MotionEvent e16);

        boolean onSingleTapConfirmed(@Nullable MotionEvent e16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J*\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J*\u0010\u0012\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KGestureDetector$e;", "", "Landroid/view/MotionEvent;", "e", "", "onDown", "", "onShowPress", "onSingleTapUp", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "velocityX", "velocityY", "onFling", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public interface e {
        boolean onDown(@NotNull MotionEvent e16);

        boolean onFling(@Nullable MotionEvent e16, @NotNull MotionEvent e26, float velocityX, float velocityY);

        void onLongPress(@NotNull MotionEvent e16);

        boolean onScroll(@Nullable MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY);

        void onShowPress(@Nullable MotionEvent e16);

        boolean onSingleTapUp(@NotNull MotionEvent e16);
    }

    @JvmOverloads
    public KGestureDetector(@Nullable Context context, @Nullable e eVar) {
        this.mListener = eVar;
        if (eVar instanceof d) {
            r((d) eVar);
        }
        if (eVar instanceof c) {
            p((c) eVar);
        }
        l(context);
    }

    private final boolean g(float scrollX, float scrollY) {
        ScrollDirection scrollDirection = this.scrollDirection;
        if (scrollDirection == ScrollDirection.DIRECTION_ALL) {
            return true;
        }
        if (scrollDirection == ScrollDirection.DIRECTION_HORIZONTAL && Math.abs(scrollX) > Math.abs(scrollY)) {
            return true;
        }
        if (this.scrollDirection == ScrollDirection.DIRECTION_VERTICAL && Math.abs(scrollY) >= Math.abs(scrollX)) {
            return true;
        }
        return false;
    }

    private final void h() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = null;
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = false;
        this.mInContextClick = false;
        this.mIgnoreNextUpEvent = false;
    }

    private final void i() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mIsDoubleTapping = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = false;
        this.mInContextClick = false;
        this.mIgnoreNextUpEvent = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        this.mHandler.removeMessages(3);
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = true;
        e eVar = this.mListener;
        if (eVar != null) {
            MotionEvent motionEvent = this.mCurrentDownEvent;
            Intrinsics.checkNotNull(motionEvent);
            eVar.onLongPress(motionEvent);
        }
    }

    private final void l(Context context) {
        int scaledDoubleTapSlop;
        int i3;
        int i16;
        if (this.mListener != null) {
            this.isLongpressEnabled = true;
            if (context == null) {
                i16 = ViewConfiguration.getTouchSlop();
                this.mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
                this.mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
                this.mAmbiguousGestureMultiplier = 2.0f;
                scaledDoubleTapSlop = 100;
                i3 = i16;
            } else {
                ViewConfiguration configuration = ViewConfiguration.get(context);
                Intrinsics.checkNotNullExpressionValue(configuration, "configuration");
                int scaledTouchSlop = configuration.getScaledTouchSlop();
                scaledDoubleTapSlop = configuration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
                this.mAmbiguousGestureMultiplier = 2.0f;
                i3 = 8;
                i16 = scaledTouchSlop;
            }
            this.mTouchSlopSquare = i16 * i16;
            this.mDoubleTapTouchSlopSquare = i3 * i3;
            this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            return;
        }
        throw new NullPointerException("OnGestureListener must not be null");
    }

    private final boolean m(MotionEvent firstDown, MotionEvent firstUp, MotionEvent secondDown) {
        long j3;
        int i3;
        int i16;
        int i17;
        boolean z16;
        int i18;
        if (!this.mAlwaysInBiggerTapRegion) {
            return false;
        }
        long eventTime = secondDown.getEventTime();
        if (firstUp != null) {
            j3 = firstUp.getEventTime();
        } else {
            j3 = 0;
        }
        long j16 = eventTime - j3;
        if (j16 > F || j16 < G) {
            return false;
        }
        if (firstDown != null) {
            i3 = (int) firstDown.getX();
        } else {
            i3 = 0;
        }
        int x16 = i3 - ((int) secondDown.getX());
        if (firstDown != null) {
            i16 = (int) firstDown.getY();
        } else {
            i16 = 0;
        }
        int y16 = i16 - ((int) secondDown.getY());
        if (firstDown != null) {
            i17 = firstDown.getFlags();
        } else {
            i17 = 0;
        }
        if ((i17 & 8) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i18 = 0;
        } else {
            i18 = this.mDoubleTapSlopSquare;
        }
        if ((x16 * x16) + (y16 * y16) >= i18) {
            return false;
        }
        return true;
    }

    public final void k(boolean enable) {
        this.mIsExactlyScrollEnabled = enable;
    }

    /* JADX WARN: Removed duplicated region for block: B:205:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(@NotNull MotionEvent ev5) {
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        MotionEvent motionEvent;
        MotionEvent motionEvent2;
        e eVar;
        long j3;
        MotionEvent motionEvent3;
        boolean z19;
        boolean z26;
        float f16;
        e eVar2;
        boolean onFling;
        boolean z27;
        d dVar;
        boolean z28;
        float f17;
        int i16;
        int i17;
        boolean z29;
        float f18;
        float f19;
        float f26;
        float f27;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        MotionEvent motionEvent4 = this.mCurrentMotionEvent;
        if (motionEvent4 != null) {
            motionEvent4.recycle();
            Unit unit = Unit.INSTANCE;
        }
        this.mCurrentMotionEvent = MotionEvent.obtain(ev5);
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(ev5);
            Unit unit2 = Unit.INSTANCE;
        }
        int i18 = action & 255;
        boolean z36 = false;
        if (i18 == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = ev5.getActionIndex();
        } else {
            i3 = -1;
        }
        if ((ev5.getFlags() & 8) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        int pointerCount = ev5.getPointerCount();
        float f28 = 0.0f;
        float f29 = 0.0f;
        float f36 = 0.0f;
        for (int i19 = 0; i19 < pointerCount; i19++) {
            if (i3 != i19) {
                f29 += ev5.getX(i19);
                f36 += ev5.getY(i19);
            }
        }
        float f37 = z16 ? pointerCount - 1 : pointerCount;
        float f38 = f29 / f37;
        float f39 = f36 / f37;
        if (i18 != 0) {
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 != 5) {
                            if (i18 != 6) {
                                return false;
                            }
                            this.mLastFocusX = f38;
                            this.mDownFocusX = f38;
                            Unit unit3 = Unit.INSTANCE;
                            this.mLastFocusY = f39;
                            this.mDownFocusY = f39;
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            if (velocityTracker2 != null) {
                                velocityTracker2.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                            }
                            int actionIndex = ev5.getActionIndex();
                            int pointerId = ev5.getPointerId(actionIndex);
                            VelocityTracker velocityTracker3 = this.mVelocityTracker;
                            if (velocityTracker3 != null) {
                                f18 = velocityTracker3.getXVelocity(pointerId);
                            } else {
                                f18 = 0.0f;
                            }
                            VelocityTracker velocityTracker4 = this.mVelocityTracker;
                            if (velocityTracker4 != null) {
                                f19 = velocityTracker4.getYVelocity(pointerId);
                            } else {
                                f19 = 0.0f;
                            }
                            for (int i26 = 0; i26 < pointerCount; i26++) {
                                if (i26 != actionIndex) {
                                    int pointerId2 = ev5.getPointerId(i26);
                                    VelocityTracker velocityTracker5 = this.mVelocityTracker;
                                    if (velocityTracker5 != null) {
                                        f26 = velocityTracker5.getXVelocity(pointerId2);
                                    } else {
                                        f26 = 0.0f;
                                    }
                                    float f46 = f26 * f18;
                                    VelocityTracker velocityTracker6 = this.mVelocityTracker;
                                    if (velocityTracker6 != null) {
                                        f27 = velocityTracker6.getYVelocity(pointerId2);
                                    } else {
                                        f27 = 0.0f;
                                    }
                                    if (f46 + (f27 * f19) < 0) {
                                        VelocityTracker velocityTracker7 = this.mVelocityTracker;
                                        if (velocityTracker7 == null) {
                                            return false;
                                        }
                                        velocityTracker7.clear();
                                        Unit unit4 = Unit.INSTANCE;
                                        return false;
                                    }
                                }
                            }
                            return false;
                        }
                        this.mLastFocusX = f38;
                        this.mDownFocusX = f38;
                        Unit unit5 = Unit.INSTANCE;
                        this.mLastFocusY = f39;
                        this.mDownFocusY = f39;
                        i();
                        return false;
                    }
                    h();
                    return false;
                }
                if (this.mInLongPress || this.mInContextClick) {
                    return false;
                }
                this.mHandler.hasMessages(2);
                float f47 = this.mLastFocusX - f38;
                float f48 = this.mLastFocusY - f39;
                if (this.mIsDoubleTapping) {
                    d dVar2 = this.mDoubleTapListener;
                    if (dVar2 != null) {
                        z29 = dVar2.onDoubleTapEvent(ev5);
                    } else {
                        z29 = false;
                    }
                    return false | z29;
                }
                if (this.mAlwaysInTapRegion) {
                    int i27 = (int) (f38 - this.mDownFocusX);
                    int i28 = (int) (f39 - this.mDownFocusY);
                    int i29 = (i27 * i27) + (i28 * i28);
                    if (z17) {
                        i16 = 0;
                    } else {
                        i16 = this.mTouchSlopSquare;
                    }
                    if (i29 > i16 && g(f47, f48)) {
                        e eVar3 = this.mListener;
                        if (eVar3 != null) {
                            onFling = eVar3.onScroll(this.mCurrentDownEvent, ev5, f47, f48);
                        } else {
                            onFling = false;
                        }
                        this.mLastFocusX = f38;
                        this.mLastFocusY = f39;
                        this.mAlwaysInTapRegion = false;
                        this.mHandler.removeMessages(3);
                        this.mHandler.removeMessages(1);
                        this.mHandler.removeMessages(2);
                    } else {
                        onFling = false;
                    }
                    if (z17) {
                        i17 = 0;
                    } else {
                        i17 = this.mDoubleTapTouchSlopSquare;
                    }
                    if (i29 > i17) {
                        this.mAlwaysInBiggerTapRegion = false;
                    }
                } else {
                    float abs = Math.abs(f47);
                    if (this.mIsExactlyScrollEnabled) {
                        f17 = 0.0f;
                    } else {
                        f17 = 1.0f;
                    }
                    if (abs < f17) {
                        float abs2 = Math.abs(f48);
                        if (!this.mIsExactlyScrollEnabled) {
                            f28 = 1.0f;
                        }
                        if (abs2 < f28) {
                            return false;
                        }
                    }
                    if (!g(f47, f48)) {
                        return false;
                    }
                    e eVar4 = this.mListener;
                    if (eVar4 != null) {
                        z36 = eVar4.onScroll(this.mCurrentDownEvent, ev5, f47, f48);
                    }
                    this.mLastFocusX = f38;
                    this.mLastFocusY = f39;
                    return z36;
                }
            } else {
                this.mStillDown = false;
                MotionEvent obtain = MotionEvent.obtain(ev5);
                Intrinsics.checkNotNullExpressionValue(obtain, "MotionEvent.obtain(ev)");
                if (this.mIsDoubleTapping) {
                    d dVar3 = this.mDoubleTapListener;
                    if (dVar3 != null) {
                        z28 = dVar3.onDoubleTapEvent(ev5);
                    } else {
                        z28 = false;
                    }
                    onFling = z28 | false;
                } else {
                    if (this.mInLongPress) {
                        this.mHandler.removeMessages(3);
                        this.mInLongPress = false;
                    } else if (this.mAlwaysInTapRegion && !this.mIgnoreNextUpEvent) {
                        e eVar5 = this.mListener;
                        if (eVar5 != null) {
                            z27 = eVar5.onSingleTapUp(ev5);
                        } else {
                            z27 = false;
                        }
                        if (this.mDeferConfirmSingleTap && (dVar = this.mDoubleTapListener) != null && dVar != null) {
                            dVar.onSingleTapConfirmed(ev5);
                        }
                        onFling = z27;
                    } else if (!this.mIgnoreNextUpEvent) {
                        VelocityTracker velocityTracker8 = this.mVelocityTracker;
                        int pointerId3 = ev5.getPointerId(0);
                        if (velocityTracker8 != null) {
                            velocityTracker8.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        if (velocityTracker8 != null) {
                            f16 = velocityTracker8.getYVelocity(pointerId3);
                        } else {
                            f16 = 0.0f;
                        }
                        if (velocityTracker8 != null) {
                            f28 = velocityTracker8.getXVelocity(pointerId3);
                        }
                        if ((Math.abs(f16) > this.mMinimumFlingVelocity || Math.abs(f28) > this.mMinimumFlingVelocity) && (eVar2 = this.mListener) != null) {
                            onFling = eVar2.onFling(this.mCurrentDownEvent, ev5, f28, f16);
                        }
                    }
                    onFling = false;
                }
                MotionEvent motionEvent5 = this.mPreviousUpEvent;
                if (motionEvent5 != null) {
                    Intrinsics.checkNotNull(motionEvent5);
                    motionEvent5.recycle();
                }
                this.mPreviousUpEvent = obtain;
                VelocityTracker velocityTracker9 = this.mVelocityTracker;
                if (velocityTracker9 != null) {
                    Intrinsics.checkNotNull(velocityTracker9);
                    velocityTracker9.recycle();
                    this.mVelocityTracker = null;
                }
                this.mIsDoubleTapping = false;
                this.mDeferConfirmSingleTap = false;
                this.mIgnoreNextUpEvent = false;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
            }
            return onFling;
        }
        if (this.mDoubleTapListener != null) {
            boolean hasMessages = this.mHandler.hasMessages(3);
            if (hasMessages) {
                this.mHandler.removeMessages(3);
            }
            MotionEvent motionEvent6 = this.mCurrentDownEvent;
            if (motionEvent6 != null && (motionEvent3 = this.mPreviousUpEvent) != null && hasMessages && m(motionEvent6, motionEvent3, ev5)) {
                this.mIsDoubleTapping = true;
                d dVar4 = this.mDoubleTapListener;
                if (dVar4 != null) {
                    z19 = dVar4.onDoubleTap(this.mCurrentDownEvent);
                } else {
                    z19 = false;
                }
                boolean z37 = z19 | false;
                d dVar5 = this.mDoubleTapListener;
                if (dVar5 != null) {
                    z26 = dVar5.onDoubleTapEvent(ev5);
                } else {
                    z26 = false;
                }
                z18 = z37 | z26;
                this.mLastFocusX = f38;
                this.mDownFocusX = f38;
                Unit unit7 = Unit.INSTANCE;
                this.mLastFocusY = f39;
                this.mDownFocusY = f39;
                motionEvent = this.mCurrentDownEvent;
                if (motionEvent != null) {
                    motionEvent.recycle();
                }
                this.mCurrentDownEvent = MotionEvent.obtain(ev5);
                this.mAlwaysInTapRegion = true;
                this.mAlwaysInBiggerTapRegion = true;
                this.mStillDown = true;
                this.mInLongPress = false;
                this.mDeferConfirmSingleTap = false;
                this.mHasRecordedClassification = false;
                long j16 = 0;
                if (this.isLongpressEnabled) {
                    this.mHandler.removeMessages(2);
                    b bVar = this.mHandler;
                    Message obtainMessage = bVar.obtainMessage(2, 0);
                    MotionEvent motionEvent7 = this.mCurrentDownEvent;
                    if (motionEvent7 != null) {
                        j3 = motionEvent7.getDownTime();
                    } else {
                        j3 = 0;
                    }
                    bVar.sendMessageAtTime(obtainMessage, j3 + ViewConfiguration.getLongPressTimeout());
                }
                b bVar2 = this.mHandler;
                motionEvent2 = this.mCurrentDownEvent;
                if (motionEvent2 != null) {
                    j16 = motionEvent2.getDownTime();
                }
                bVar2.sendEmptyMessageAtTime(1, j16 + E);
                eVar = this.mListener;
                if (eVar != null) {
                    z36 = eVar.onDown(ev5);
                }
                return z36 | z18;
            }
            this.mHandler.sendEmptyMessageDelayed(3, F);
        }
        z18 = false;
        this.mLastFocusX = f38;
        this.mDownFocusX = f38;
        Unit unit72 = Unit.INSTANCE;
        this.mLastFocusY = f39;
        this.mDownFocusY = f39;
        motionEvent = this.mCurrentDownEvent;
        if (motionEvent != null) {
        }
        this.mCurrentDownEvent = MotionEvent.obtain(ev5);
        this.mAlwaysInTapRegion = true;
        this.mAlwaysInBiggerTapRegion = true;
        this.mStillDown = true;
        this.mInLongPress = false;
        this.mDeferConfirmSingleTap = false;
        this.mHasRecordedClassification = false;
        long j162 = 0;
        if (this.isLongpressEnabled) {
        }
        b bVar22 = this.mHandler;
        motionEvent2 = this.mCurrentDownEvent;
        if (motionEvent2 != null) {
        }
        bVar22.sendEmptyMessageAtTime(1, j162 + E);
        eVar = this.mListener;
        if (eVar != null) {
        }
        return z36 | z18;
    }

    public final boolean o() {
        if (this.scrollDirection.getValue() == ScrollDirection.DIRECTION_ALL.getValue()) {
            return true;
        }
        return false;
    }

    public final void p(@Nullable c onContextClickListener) {
        this.mContextClickListener = onContextClickListener;
    }

    public void q(boolean isLongpressEnabled) {
        this.isLongpressEnabled = isLongpressEnabled;
    }

    public final void r(@Nullable d onDoubleTapListener) {
        this.mDoubleTapListener = onDoubleTapListener;
    }

    public final void s(@NotNull ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.scrollDirection = direction;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/KGestureDetector$f;", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$e;", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$d;", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$c;", "Landroid/view/MotionEvent;", "e1", "e2", "", "velocityX", "velocityY", "", "onFling", "e", "", "onShowPress", "onDoubleTapEvent", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static class f implements e, d, c {
        @Override // com.tencent.kuikly.core.render.android.KGestureDetector.d
        public boolean onDoubleTapEvent(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            return false;
        }

        @Override // com.tencent.kuikly.core.render.android.KGestureDetector.e
        public boolean onFling(@Nullable MotionEvent e16, @NotNull MotionEvent e26, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e26, "e2");
            return false;
        }

        @Override // com.tencent.kuikly.core.render.android.KGestureDetector.e
        public void onShowPress(@Nullable MotionEvent e16) {
        }
    }
}
