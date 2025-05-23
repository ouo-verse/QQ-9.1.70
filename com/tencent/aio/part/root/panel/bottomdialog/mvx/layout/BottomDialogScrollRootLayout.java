package com.tencent.aio.part.root.panel.bottomdialog.mvx.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0002\u00183B\u0013\b\u0016\u0012\b\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b8\u00109B\u001d\b\u0016\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u00a2\u0006\u0004\b8\u0010<B%\b\u0016\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\u0006\u0010=\u001a\u00020\u0004\u00a2\u0006\u0004\b8\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0017R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\"\u0010,\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010&R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u001bR\u0018\u00102\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00101R\u0014\u00105\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u0006@"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/BottomDialogScrollRootLayout;", "Landroid/widget/LinearLayout;", "", "c", "", "y", "e", "Landroid/view/View;", "targetView", "Landroid/view/MotionEvent;", "event", "", "d", "computeScroll", "disable", "setDisableMinScrollY", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/BottomDialogScrollRootLayout$b;", "listener", "setAtPanelTouchListener", "ev", "dispatchTouchEvent", "mode", "setMode", "", "a", UserInfo.SEX_FEMALE, "preY", "Z", "isDownOnLitTongue", "f", "mControlLitTongue", "Landroid/widget/Scroller;", h.F, "Landroid/widget/Scroller;", "mScroller", "i", "mScrollToBottom", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", BdhLogUtil.LogTag.Tag_Conn, "getMDisableMinScrollY", "()Z", "setMDisableMinScrollY", "(Z)V", "mDisableMinScrollY", "D", "mTotalHeight", "E", "isMove", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/BottomDialogScrollRootLayout$b;", "mListener", "b", "()I", "maxScrollDistance", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class BottomDialogScrollRootLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mDisableMinScrollY;

    /* renamed from: D, reason: from kotlin metadata */
    private int mTotalHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isMove;

    /* renamed from: F, reason: from kotlin metadata */
    private b mListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float preY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isDownOnLitTongue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean mControlLitTongue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Scroller mScroller;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mScrollToBottom;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/BottomDialogScrollRootLayout$a;", "", "Landroid/view/View;", "targetView", "Landroid/view/MotionEvent;", "event", "", "a", "", "MODE_STATUS_HALF", "I", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.bottomdialog.mvx.layout.BottomDialogScrollRootLayout$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final boolean a(@Nullable View targetView, @NotNull MotionEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) targetView, (Object) event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(event, "event");
            if (targetView == null) {
                return false;
            }
            int rawY = (int) event.getRawY();
            int rawX = (int) event.getRawX();
            int[] iArr = new int[2];
            targetView.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i16 = iArr[1];
            int measuredWidth = targetView.getMeasuredWidth() + i3;
            int measuredHeight = targetView.getMeasuredHeight() + i16;
            if (i16 <= rawY && measuredHeight >= rawY && rawX >= i3 && rawX <= measuredWidth) {
                return true;
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/layout/BottomDialogScrollRootLayout$b;", "", "", "up", "", "a", "", "mode", "b", "scrollToTop", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean up5);

        void b(int mode);

        void scrollToTop();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45645);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BottomDialogScrollRootLayout(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
            return;
        }
        this.preY = -3.4028235E38f;
        this.mControlLitTongue = true;
        this.mode = 1;
    }

    private final int b() {
        int childCount = getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View view = getChildAt(i16);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            if (view.getVisibility() == 0) {
                i3 += view.getHeight();
            }
        }
        this.mTotalHeight = i3;
        return i3 / 3;
    }

    private final void c() {
        this.mScroller = new Scroller(getContext());
    }

    private final boolean d(View targetView, MotionEvent event) {
        if (this.isDownOnLitTongue) {
            return true;
        }
        if (this.mControlLitTongue && !INSTANCE.a(targetView, event)) {
            return false;
        }
        this.isDownOnLitTongue = true;
        return true;
    }

    private final void e(int y16) {
        Scroller scroller = this.mScroller;
        if (scroller != null) {
            Intrinsics.checkNotNull(scroller);
            scroller.startScroll(0, getScrollY(), 0, y16 - getScrollY());
            invalidate();
            return;
        }
        scrollTo(0, y16);
    }

    public final float a(float y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, this, Float.valueOf(y16))).floatValue();
        }
        int scrollY = (int) (getScrollY() + y16);
        if (scrollY < 20) {
            return y16;
        }
        if (scrollY >= 20) {
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.scrollToTop();
            }
            return 20 - getScrollY();
        }
        return 0.0f;
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
        if (scroller != null) {
            Intrinsics.checkNotNull(scroller);
            if (scroller.computeScrollOffset()) {
                Scroller scroller2 = this.mScroller;
                Intrinsics.checkNotNull(scroller2);
                int currX = scroller2.getCurrX();
                Scroller scroller3 = this.mScroller;
                Intrinsics.checkNotNull(scroller3);
                scrollTo(currX, scroller3.getCurrY());
                invalidate();
                return;
            }
        }
        if (this.mScrollToBottom) {
            this.mScrollToBottom = false;
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.b(this.mode);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r2 != 3) goto L58;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean z17 = false;
        View childAt = getChildAt(0);
        if (childAt != null && !d(childAt, ev5)) {
            return super.dispatchTouchEvent(ev5);
        }
        float y16 = ev5.getY();
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f16 = this.preY;
                    if (f16 == -3.4028235E38f) {
                        this.preY = y16;
                        return super.dispatchTouchEvent(ev5);
                    }
                    float f17 = -(y16 - f16);
                    float a16 = a(f17);
                    if (this.isDownOnLitTongue && a16 != 0.0f) {
                        scrollBy(0, (int) a16);
                    } else if (a16 > 0) {
                        scrollBy(0, (int) a16);
                    }
                    if (Math.abs(f17) > 5) {
                        this.isMove = true;
                    }
                    b bVar = this.mListener;
                    if (bVar != null) {
                        if (getScrollY() > 0) {
                            z17 = true;
                        }
                        bVar.a(z17);
                    }
                    this.preY = y16;
                    return true;
                }
            }
            this.isDownOnLitTongue = false;
            this.preY = -3.4028235E38f;
            if (!this.isMove) {
                return super.dispatchTouchEvent(ev5);
            }
            ev5.setAction(3);
            super.dispatchTouchEvent(ev5);
            if ((-getScrollY()) < b()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                e(0);
            } else if (this.mListener != null) {
                this.mScrollToBottom = true;
                e(-this.mTotalHeight);
            }
            return false;
        }
        this.isMove = false;
        this.preY = ev5.getY();
        super.dispatchTouchEvent(ev5);
        return true;
    }

    public final void setAtPanelTouchListener(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        } else {
            this.mListener = listener;
        }
    }

    public final void setDisableMinScrollY(boolean disable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, disable);
        } else {
            this.mDisableMinScrollY = disable;
        }
    }

    public final void setMDisableMinScrollY(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.mDisableMinScrollY = z16;
        }
    }

    public final void setMode(int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, mode);
        } else {
            this.mode = mode;
        }
    }

    public BottomDialogScrollRootLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.preY = -3.4028235E38f;
        this.mControlLitTongue = true;
        this.mode = 1;
        c();
    }

    public BottomDialogScrollRootLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.preY = -3.4028235E38f;
        this.mControlLitTongue = true;
        this.mode = 1;
        c();
    }
}
