package com.tencent.qqnt.aio.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.exception.OperateViewOnSubThreadException;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 A2\u00020\u0001:\u0002BCB\u000f\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0011J0\u0010&\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0014J\u0012\u0010)\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010<\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00108\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/aio/widget/AIOGestureLayout;", "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", "", tl.h.F, "Lcom/tencent/qqnt/aio/widget/h;", "touchlistener", "setTouchListener", "Lcom/tencent/qqnt/aio/widget/g;", "swipeListener", "setGestureDetector", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", ParseCommon.CONTAINER, "dispatchRestoreInstanceState", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "event", "onTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "flag", "setGestureFlag", "i", "k", "j", "enable", "setInterceptScrollRLFlag", "setInterceptScrollLRFlag", "value", "setIsInterceptChildEventWhenScroll", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/view/View;", "view", "removeView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/widget/h;", "mTouchListener", "Landroid/view/GestureDetector;", "D", "Landroid/view/GestureDetector;", "mGestureDetector", "E", "Lcom/tencent/qqnt/aio/widget/g;", "mSwipeListener", UserInfo.SEX_FEMALE, "I", "mGestureFlag", "G", "Z", "mInterceptScrollRL", "H", "mInterceptScrollLR", "mIsInterceptChildEventWhenScroll", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "J", "a", "b", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOGestureLayout extends RoundFrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean K;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private h mTouchListener;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GestureDetector mGestureDetector;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private g mSwipeListener;

    /* renamed from: F, reason: from kotlin metadata */
    private int mGestureFlag;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mInterceptScrollRL;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mInterceptScrollLR;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsInterceptChildEventWhenScroll;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J,\u0010\u000e\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/widget/AIOGestureLayout$a;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "velocityX", "velocityY", "onFling", "onSingleTapUp", "d", UserInfo.SEX_FEMALE, "mTouchSlot", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/qqnt/aio/widget/AIOGestureLayout;Landroid/content/Context;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float mTouchSlot;

        public a(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOGestureLayout.this, (Object) context);
            } else {
                this.mTouchSlot = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e");
            AIOGestureLayout.this.setGestureFlag(0);
            return super.onDown(e16);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, e16, e26, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
            }
            if (!AIOGestureLayout.this.k() && !AIOGestureLayout.this.j()) {
                if (e16 != null && e26 != null) {
                    float x16 = e16.getX() - e26.getX();
                    float abs = Math.abs((e16.getY() - e26.getY()) / x16);
                    if (AIOGestureLayout.this.i(1)) {
                        if (x16 < 0.0f && abs < 0.5f) {
                            AIOGestureLayout.this.setGestureFlag(-1);
                            g gVar = AIOGestureLayout.this.mSwipeListener;
                            if (gVar != null) {
                                gVar.a();
                            }
                        }
                    } else if (AIOGestureLayout.this.i(2) && x16 > 0.0f && abs < 0.5f) {
                        AIOGestureLayout.this.setGestureFlag(-1);
                        g gVar2 = AIOGestureLayout.this.mSwipeListener;
                        if (gVar2 != null) {
                            gVar2.b();
                        }
                    }
                    return super.onFling(e16, e26, velocityX, velocityY);
                }
                return super.onFling(e16, e26, velocityX, velocityY);
            }
            return super.onFling(e16, e26, velocityX, velocityY);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, e16, e26, Float.valueOf(distanceX), Float.valueOf(distanceY))).booleanValue();
            }
            if (AIOGestureLayout.this.j()) {
                return super.onScroll(e16, e26, distanceX, distanceY);
            }
            if (e16 != null && e26 != null) {
                float x16 = e16.getX() - e26.getX();
                float abs = Math.abs((e16.getY() - e26.getY()) / x16);
                if (AIOGestureLayout.this.k()) {
                    if (Math.abs(x16) > this.mTouchSlot) {
                        if (distanceX < 0.0f && abs < 0.5f) {
                            if (AIOGestureLayout.this.mInterceptScrollLR) {
                                AIOGestureLayout.this.setGestureFlag(1);
                                return AIOGestureLayout.this.mIsInterceptChildEventWhenScroll;
                            }
                        } else if (distanceX > 0.0f && abs < 0.5f && AIOGestureLayout.this.mInterceptScrollRL) {
                            AIOGestureLayout.this.setGestureFlag(2);
                            return AIOGestureLayout.this.mIsInterceptChildEventWhenScroll;
                        }
                    }
                } else if (AIOGestureLayout.this.i(1)) {
                    if (distanceX > 0.0f || abs >= 0.5f) {
                        AIOGestureLayout.this.setGestureFlag(-1);
                    }
                } else if (AIOGestureLayout.this.i(2) && (distanceX < 0.0f || abs >= 0.5f)) {
                    AIOGestureLayout.this.setGestureFlag(-1);
                }
                return super.onScroll(e16, e26, distanceX, distanceY);
            }
            return super.onScroll(e16, e26, distanceX, distanceY);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e");
            AIOGestureLayout.this.setGestureFlag(-1);
            return super.onSingleTapUp(e16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/widget/AIOGestureLayout$b;", "", "", "FLAG_GESTURE_END", "I", "FLAG_GESTURE_FLINE_RL", "FLAG_GESTURE_FLING_LR", "FLAG_GESTURE_IDLE", "", "TAG", "Ljava/lang/String;", "", "aioRemoveViewSwitch", "Z", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.widget.AIOGestureLayout$b, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47974);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        INSTANCE = new Companion(null);
        boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_remove_view_9015_119529861", false);
        QLog.e("AIOGestureLayout", 1, "aioRemoveViewSwitch:" + isSwitchOn);
        K = isSwitchOn;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOGestureLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private final void h() {
        Activity activity;
        WindowManager.LayoutParams attributes;
        Context context = getContext();
        Window window = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            window = activity.getWindow();
        }
        if (window != null && (attributes = window.getAttributes()) != null) {
            int i3 = attributes.softInputMode;
            if ((i3 & 255) != 18) {
                window.setSoftInputMode((i3 & (-256)) | 18);
                requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AIOGestureLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@Nullable SparseArray<Parcelable> container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) container);
            return;
        }
        try {
            super.dispatchRestoreInstanceState(container);
        } catch (Exception e16) {
            QLog.i("AIOGestureLayout", 1, "[dispatchRestoreInstanceState]: " + e16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        h hVar = this.mTouchListener;
        if (hVar != null) {
            hVar.dispatchTouchEvent(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final boolean i(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, flag)).booleanValue();
        }
        if (!j() && (this.mGestureFlag & flag) == flag) {
            return true;
        }
        return false;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.mGestureFlag == -1) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.mGestureFlag == 0) {
            return true;
        }
        return false;
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mGestureDetector = null;
            this.mSwipeListener = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) ev5)).booleanValue();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(ev5);
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        try {
            h();
            super.onLayout(changed, left, top, right, bottom);
        } catch (Exception e16) {
            QLog.e("AIOGestureLayout", 1, "onLayout " + e16);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) event)).booleanValue();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@Nullable final View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
            return;
        }
        if (!K) {
            super.removeView(view);
            return;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            super.removeView(view);
            return;
        }
        if (com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            QLog.e("AIOGestureLayout", 1, "removeView on sub thread, StackTrace:" + QLog.getStackTraceString(new Throwable()));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    AIOGestureLayout.l(AIOGestureLayout.this, view);
                }
            });
            return;
        }
        throw new OperateViewOnSubThreadException("AIOGestureLayout removeView on sub thread");
    }

    public final void setGestureDetector(@Nullable g swipeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) swipeListener);
        } else {
            this.mGestureDetector = new GestureDetector(getContext(), new a(getContext()));
            this.mSwipeListener = swipeListener;
        }
    }

    public final void setGestureFlag(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, flag);
        } else if (flag != -1 && flag != 0) {
            this.mGestureFlag = flag | (this.mGestureFlag & (~flag));
        } else {
            this.mGestureFlag = flag;
        }
    }

    public final void setInterceptScrollLRFlag(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, enable);
        } else {
            this.mInterceptScrollLR = enable;
        }
    }

    public final void setInterceptScrollRLFlag(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, enable);
        } else {
            this.mInterceptScrollRL = enable;
        }
    }

    public final void setIsInterceptChildEventWhenScroll(boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, value);
        } else {
            this.mIsInterceptChildEventWhenScroll = value;
        }
    }

    public final void setTouchListener(@NotNull h touchlistener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) touchlistener);
        } else {
            Intrinsics.checkNotNullParameter(touchlistener, "touchlistener");
            this.mTouchListener = touchlistener;
        }
    }
}
