package com.tencent.mobileqq.aio.input.at.common;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0007\u0018\u0000 I*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0014B\u0015\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000%\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\nR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010,R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010.R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00100R\u0016\u00103\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00102R\u0016\u00105\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00109R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00109R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00109R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00109R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010D\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00109R\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00109\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/ListDialogGestureLayout;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "Landroid/widget/LinearLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/MotionEvent;", "event", "", "d", "", "i", tl.h.F, "g", "e", "b", "c", "id", "o", "direction", "a", "l", "f", "k", "", "velocityY", "j", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/input/at/common/d;", "gestureListener", "setGestureListener", "computeScroll", "dispatchTouchEvent", "y", "isEffectSoftInput", "p", "setCommonScrollYInHalfMode", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "mDialogContext", "Landroid/widget/Scroller;", "Landroid/widget/Scroller;", "mScroller", "Landroid/view/VelocityTracker;", "Landroid/view/VelocityTracker;", "mVelocityTracker", "Lcom/tencent/mobileqq/aio/input/at/common/d;", "mGestureListener", "I", "mTouchSlop", UserInfo.SEX_FEMALE, "mPrevY", BdhLogUtil.LogTag.Tag_Conn, "mDownY", "D", "mScrollYInHalfMode", "E", "Z", "mChildConsumeEvent", "mIndexBarConsumeEvent", "G", "mListConsumeDownEvent", "H", "mListConsumeMoveEvent", "mSelfConsumeMoveEvent", "J", "mSelfHasMoved", "K", "mNeedNotifyScrollToBottom", "L", "mNeedHideSoftInput", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/j;)V", "M", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public final class ListDialogGestureLayout<T extends c> extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float mDownY;

    /* renamed from: D, reason: from kotlin metadata */
    private int mScrollYInHalfMode;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mChildConsumeEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIndexBarConsumeEvent;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mListConsumeDownEvent;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mListConsumeMoveEvent;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mSelfConsumeMoveEvent;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mSelfHasMoved;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mNeedNotifyScrollToBottom;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mNeedHideSoftInput;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j<T> mDialogContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Scroller mScroller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private VelocityTracker mVelocityTracker;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d mGestureListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mPrevY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/ListDialogGestureLayout$a;", "", "", "MIN_FLING_DISTANCE_RATIO", "I", "SCROLL_OVER_HEIGHT", "", "TAG", "Ljava/lang/String;", "", "TOUCH_SLOP_RATIO", "D", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.common.ListDialogGestureLayout$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53390);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListDialogGestureLayout(@NotNull j<T> mDialogContext) {
        super(mDialogContext.c());
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDialogContext);
            return;
        }
        this.mDialogContext = mDialogContext;
        m();
        this.mTouchSlop = (int) (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 1.5d);
    }

    private final boolean a(int direction) {
        return ((RecyclerView) findViewById(R.id.f82244gc)).canScrollVertically(direction);
    }

    private final boolean b(MotionEvent event) {
        boolean dispatchTouchEvent;
        if (this.mDialogContext.f() || getScrollY() < g()) {
            return false;
        }
        int y16 = (int) (this.mPrevY - event.getY());
        if (this.mSelfConsumeMoveEvent) {
            if (o(event, R.id.f82244gc) && a(y16)) {
                MotionEvent obtain = MotionEvent.obtain(event);
                obtain.setAction(0);
                boolean dispatchTouchEvent2 = super.dispatchTouchEvent(obtain);
                this.mListConsumeDownEvent = dispatchTouchEvent2;
                if (dispatchTouchEvent2) {
                    this.mChildConsumeEvent = true;
                    MotionEvent obtain2 = MotionEvent.obtain(event);
                    obtain2.setAction(2);
                    dispatchTouchEvent = super.dispatchTouchEvent(obtain2);
                    this.mListConsumeMoveEvent = dispatchTouchEvent;
                }
            }
            dispatchTouchEvent = false;
        } else {
            if ((this.mListConsumeDownEvent || this.mListConsumeMoveEvent) && a(y16)) {
                dispatchTouchEvent = super.dispatchTouchEvent(event);
                this.mListConsumeMoveEvent = dispatchTouchEvent;
            }
            dispatchTouchEvent = false;
        }
        if (dispatchTouchEvent) {
            this.mSelfConsumeMoveEvent = false;
        }
        return dispatchTouchEvent;
    }

    private final boolean c(MotionEvent event) {
        if (this.mChildConsumeEvent) {
            MotionEvent obtain = MotionEvent.obtain(event);
            obtain.setAction(3);
            super.dispatchTouchEvent(obtain);
            this.mChildConsumeEvent = false;
            this.mListConsumeDownEvent = false;
            this.mListConsumeMoveEvent = false;
        }
        float scrollY = getScrollY() + (this.mPrevY - event.getY());
        if (scrollY >= g()) {
            if (this.mDialogContext.f()) {
                l();
                scrollTo(0, g());
            } else if (scrollY > h()) {
                scrollTo(0, h());
            } else {
                scrollTo(0, (int) scrollY);
            }
        } else if (scrollY <= i()) {
            scrollTo(0, i());
        } else {
            scrollTo(0, (int) scrollY);
        }
        this.mSelfConsumeMoveEvent = true;
        this.mSelfHasMoved = true;
        return true;
    }

    private final boolean d(MotionEvent event) {
        boolean z16;
        boolean z17;
        this.mDownY = event.getY();
        this.mPrevY = event.getY();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        VelocityTracker velocityTracker2 = null;
        if (velocityTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVelocityTracker");
            velocityTracker = null;
        }
        velocityTracker.clear();
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVelocityTracker");
        } else {
            velocityTracker2 = velocityTracker3;
        }
        velocityTracker2.addMovement(event);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
        this.mChildConsumeEvent = dispatchTouchEvent;
        if (dispatchTouchEvent && o(event, R.id.djh)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIndexBarConsumeEvent = z16;
        if (this.mChildConsumeEvent && !z16 && o(event, R.id.f82244gc)) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mListConsumeDownEvent = z17;
        this.mSelfHasMoved = false;
        this.mListConsumeMoveEvent = false;
        this.mSelfConsumeMoveEvent = false;
        QLog.d("ListDialogGestureLayout", 1, "dispatchDownEvent mDownY = " + this.mDownY + " mPrevY = " + this.mPrevY + " mChildConsumedEvent = " + this.mChildConsumeEvent + "mIndexBarConsumeDownEvent = " + this.mIndexBarConsumeEvent + " mListConsumedDownEvent = " + z17);
        return true;
    }

    private final boolean e(MotionEvent event) {
        boolean z16;
        if (event.getY() == this.mPrevY) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (this.mIndexBarConsumeEvent) {
            return super.dispatchTouchEvent(event);
        }
        VelocityTracker velocityTracker = null;
        if (b(event)) {
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVelocityTracker");
            } else {
                velocityTracker = velocityTracker2;
            }
            velocityTracker.clear();
        } else if (Math.abs(event.getY() - this.mDownY) > this.mTouchSlop) {
            VelocityTracker velocityTracker3 = this.mVelocityTracker;
            if (velocityTracker3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVelocityTracker");
            } else {
                velocityTracker = velocityTracker3;
            }
            velocityTracker.addMovement(event);
            c(event);
        }
        this.mPrevY = event.getY();
        return true;
    }

    private final boolean f(MotionEvent event) {
        boolean z16;
        QLog.d("ListDialogGestureLayout", 1, "dispatchUpEvent event.y = " + event.getY() + " event.action = " + event.getAction());
        if (this.mChildConsumeEvent) {
            if (this.mIndexBarConsumeEvent) {
                return super.dispatchTouchEvent(event);
            }
            if (this.mSelfHasMoved && this.mListConsumeMoveEvent) {
                MotionEvent obtain = MotionEvent.obtain(event);
                obtain.setAction(3);
                super.dispatchTouchEvent(obtain);
            } else {
                super.dispatchTouchEvent(event);
            }
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        VelocityTracker velocityTracker2 = null;
        if (velocityTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVelocityTracker");
            velocityTracker = null;
        }
        velocityTracker.computeCurrentVelocity(1000);
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVelocityTracker");
            velocityTracker3 = null;
        }
        float yVelocity = velocityTracker3.getYVelocity();
        VelocityTracker velocityTracker4 = this.mVelocityTracker;
        if (velocityTracker4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVelocityTracker");
        } else {
            velocityTracker2 = velocityTracker4;
        }
        velocityTracker2.clear();
        if (event.getY() - this.mDownY > getHeight() / 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (n(yVelocity) && z16) {
            j(yVelocity);
        } else {
            k();
        }
        return true;
    }

    private final int g() {
        return -this.mDialogContext.b().a();
    }

    private final int h() {
        return -(this.mDialogContext.b().a() - com.tencent.qqnt.util.view.b.f362999a.b(30));
    }

    private final int i() {
        return -getHeight();
    }

    private final void j(float velocityY) {
        if (velocityY > 0.0f) {
            QLog.d("ListDialogGestureLayout", 1, "smoothScrollTo getMinScrollY");
            p(i(), true);
        } else {
            QLog.d("ListDialogGestureLayout", 1, "smoothScrollTo getMaxScrollY");
            p(g(), true);
        }
    }

    private final void k() {
        QLog.d("ListDialogGestureLayout", 1, "smoothScrollTo nothing");
        if (!this.mDialogContext.f()) {
            if (Math.abs(getScrollY()) > getHeight() / 2) {
                p(i(), false);
                return;
            } else {
                p(g(), false);
                return;
            }
        }
        int scrollY = getScrollY();
        int i3 = this.mScrollYInHalfMode;
        int i16 = i();
        int i17 = this.mScrollYInHalfMode;
        if (scrollY < i3 + ((i16 - i17) / 2)) {
            p(i(), false);
        } else {
            p(i17, false);
        }
    }

    private final void l() {
        Object systemService = this.mDialogContext.c().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(this.mDialogContext.a().getWindowToken(), 0);
    }

    private final void m() {
        this.mScroller = new Scroller(getContext());
        VelocityTracker obtain = VelocityTracker.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.mVelocityTracker = obtain;
    }

    private final boolean n(float velocityY) {
        if (Math.abs(velocityY) > ViewConfiguration.get(this.mDialogContext.c()).getScaledMinimumFlingVelocity()) {
            return true;
        }
        return false;
    }

    private final boolean o(MotionEvent event, int id5) {
        View findViewById = findViewById(id5);
        if (findViewById == null) {
            return false;
        }
        findViewById.getLocationOnScreen(new int[2]);
        int rawX = (int) (event.getRawX() - r1[0]);
        int rawY = (int) (event.getRawY() - r1[1]);
        if (rawX < 0 || rawY < 0 || rawX >= findViewById.getMeasuredWidth() || rawY >= findViewById.getMeasuredHeight()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.computeScroll();
        Scroller scroller = this.mScroller;
        d dVar = null;
        Scroller scroller2 = null;
        if (scroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScroller");
            scroller = null;
        }
        if (scroller.computeScrollOffset()) {
            Scroller scroller3 = this.mScroller;
            if (scroller3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScroller");
                scroller3 = null;
            }
            int currX = scroller3.getCurrX();
            Scroller scroller4 = this.mScroller;
            if (scroller4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScroller");
            } else {
                scroller2 = scroller4;
            }
            scrollTo(currX, scroller2.getCurrY());
            invalidate();
            return;
        }
        if (this.mNeedNotifyScrollToBottom) {
            d dVar2 = this.mGestureListener;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGestureListener");
            } else {
                dVar = dVar2;
            }
            dVar.d();
            this.mNeedNotifyScrollToBottom = false;
            return;
        }
        if (this.mNeedHideSoftInput) {
            l();
            this.mNeedHideSoftInput = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.dispatchTouchEvent(event);
                    }
                } else {
                    return e(event);
                }
            }
            return f(event);
        }
        return d(event);
    }

    public final void p(int y16, boolean isEffectSoftInput) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(y16), Boolean.valueOf(isEffectSoftInput));
            return;
        }
        float abs = (Math.abs(getScrollY() - y16) / ViewUtils.getScreenHeight()) * this.mDialogContext.b().f();
        if (y16 == i()) {
            this.mNeedNotifyScrollToBottom = true;
        }
        if (isEffectSoftInput && y16 == h()) {
            z16 = true;
        }
        this.mNeedHideSoftInput = z16;
        Scroller scroller = this.mScroller;
        if (scroller == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScroller");
            scroller = null;
        }
        scroller.startScroll(0, getScrollY(), 0, y16 - getScrollY(), (int) abs);
        invalidate();
    }

    public final void setCommonScrollYInHalfMode(int y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, y16);
        } else {
            this.mScrollYInHalfMode = y16;
        }
    }

    public final void setGestureListener(@NotNull d gestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gestureListener);
        } else {
            Intrinsics.checkNotNullParameter(gestureListener, "gestureListener");
            this.mGestureListener = gestureListener;
        }
    }
}
