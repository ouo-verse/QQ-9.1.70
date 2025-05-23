package com.tencent.qqnt.chathistory.ui.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 .2\u00020\u0001:\u0002/0B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\fR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\"R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010$R\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010$\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/ChatHistoryGestureLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/qqnt/chathistory/ui/widget/b;", "touchlistener", "", "setTouchListener", "Lcom/tencent/qqnt/chathistory/ui/widget/a;", "swipeListener", "setGestureDetector", h.F, "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "event", "onTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "flag", "setGestureFlag", "e", "g", "f", "enable", "setInterceptScrollRLFlag", "setInterceptScrollLRFlag", "value", "setIsInterceptChildEventWhenScroll", "Landroid/view/GestureDetector;", "d", "Landroid/view/GestureDetector;", "mGestureDetector", "Lcom/tencent/qqnt/chathistory/ui/widget/a;", "mSwipeListener", "I", "mGestureFlag", "Z", "mInterceptScrollRL", "i", "mInterceptScrollLR", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mIsInterceptChildEventWhenScroll", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryGestureLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GestureDetector mGestureDetector;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chathistory.ui.widget.a mSwipeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mGestureFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mInterceptScrollRL;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mInterceptScrollLR;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInterceptChildEventWhenScroll;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J,\u0010\u000e\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/ChatHistoryGestureLayout$a;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "velocityX", "velocityY", "onFling", "onSingleTapUp", "d", UserInfo.SEX_FEMALE, "mTouchSlot", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/widget/ChatHistoryGestureLayout;Landroid/content/Context;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float mTouchSlot;

        public a(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryGestureLayout.this, (Object) context);
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
            ChatHistoryGestureLayout.this.setGestureFlag(0);
            return super.onDown(e16);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, e16, e26, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
            }
            if (!ChatHistoryGestureLayout.this.g() && !ChatHistoryGestureLayout.this.f()) {
                if (e16 != null && e26 != null) {
                    float x16 = e16.getX() - e26.getX();
                    float abs = Math.abs((e16.getY() - e26.getY()) / x16);
                    if (ChatHistoryGestureLayout.this.e(1)) {
                        if (x16 < 0.0f && abs < 0.5f) {
                            ChatHistoryGestureLayout.this.setGestureFlag(-1);
                            com.tencent.qqnt.chathistory.ui.widget.a aVar = ChatHistoryGestureLayout.this.mSwipeListener;
                            if (aVar != null) {
                                aVar.a();
                            }
                        }
                    } else if (ChatHistoryGestureLayout.this.e(2) && x16 > 0.0f && abs < 0.5f) {
                        ChatHistoryGestureLayout.this.setGestureFlag(-1);
                        com.tencent.qqnt.chathistory.ui.widget.a aVar2 = ChatHistoryGestureLayout.this.mSwipeListener;
                        if (aVar2 != null) {
                            aVar2.b();
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
            if (ChatHistoryGestureLayout.this.f()) {
                return super.onScroll(e16, e26, distanceX, distanceY);
            }
            if (e16 != null && e26 != null) {
                float x16 = e16.getX() - e26.getX();
                float abs = Math.abs((e16.getY() - e26.getY()) / x16);
                if (ChatHistoryGestureLayout.this.g()) {
                    if (Math.abs(x16) > this.mTouchSlot) {
                        if (distanceX < 0.0f && abs < 0.5f) {
                            if (ChatHistoryGestureLayout.this.mInterceptScrollLR) {
                                ChatHistoryGestureLayout.this.setGestureFlag(1);
                                return ChatHistoryGestureLayout.this.mIsInterceptChildEventWhenScroll;
                            }
                        } else if (distanceX > 0.0f && abs < 0.5f && ChatHistoryGestureLayout.this.mInterceptScrollRL) {
                            ChatHistoryGestureLayout.this.setGestureFlag(2);
                            return ChatHistoryGestureLayout.this.mIsInterceptChildEventWhenScroll;
                        }
                    }
                } else if (ChatHistoryGestureLayout.this.e(1)) {
                    if (distanceX > 0.0f || abs >= 0.5f) {
                        ChatHistoryGestureLayout.this.setGestureFlag(-1);
                    }
                } else if (ChatHistoryGestureLayout.this.e(2) && (distanceX < 0.0f || abs >= 0.5f)) {
                    ChatHistoryGestureLayout.this.setGestureFlag(-1);
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
            ChatHistoryGestureLayout.this.setGestureFlag(-1);
            return super.onSingleTapUp(e16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/ChatHistoryGestureLayout$b;", "", "", "FLAG_GESTURE_END", "I", "FLAG_GESTURE_FLINE_RL", "FLAG_GESTURE_FLING_LR", "FLAG_GESTURE_IDLE", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.widget.ChatHistoryGestureLayout$b, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryGestureLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        return super.dispatchTouchEvent(ev5);
    }

    public final boolean e(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, flag)).booleanValue();
        }
        if (!f() && (this.mGestureFlag & flag) == flag) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.mGestureFlag == -1) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.mGestureFlag == 0) {
            return true;
        }
        return false;
    }

    public final void h() {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) ev5)).booleanValue();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(ev5);
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) event)).booleanValue();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public final void setGestureDetector(@Nullable com.tencent.qqnt.chathistory.ui.widget.a swipeListener) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, flag);
        } else if (flag != -1 && flag != 0) {
            this.mGestureFlag = flag | (this.mGestureFlag & (~flag));
        } else {
            this.mGestureFlag = flag;
        }
    }

    public final void setInterceptScrollLRFlag(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, enable);
        } else {
            this.mInterceptScrollLR = enable;
        }
    }

    public final void setInterceptScrollRLFlag(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, enable);
        } else {
            this.mInterceptScrollRL = enable;
        }
    }

    public final void setIsInterceptChildEventWhenScroll(boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, value);
        } else {
            this.mIsInterceptChildEventWhenScroll = value;
        }
    }

    public final void setTouchListener(@NotNull b touchlistener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) touchlistener);
        } else {
            Intrinsics.checkNotNullParameter(touchlistener, "touchlistener");
        }
    }
}
