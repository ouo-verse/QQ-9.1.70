package com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0002\u0013\u0018B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010)R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010)R\u0016\u0010,\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010)R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010.R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010.R\u0016\u00101\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010.R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0016\u00103\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010)R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOContentLeftSwipeHelper;", "", "Landroid/view/MotionEvent;", "ev", "", "g", "Landroid/view/View;", "view", "", h.F, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "j", "k", "Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOContentLeftSwipeHelper$b;", "listener", "e", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "f", "()Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "b", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "contentView", "c", "Z", "getToggle", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "toggle", "", "d", "Ljava/util/List;", "listeners", "", "I", "touchSlop", "maxScrollDistance", "maxDampingDistance", "", UserInfo.SEX_FEMALE, "downX", "downY", "lastX", "isDownOnContent", "state", "Landroid/widget/Scroller;", "Landroid/widget/Scroller;", "scroller", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "scrollRunnable", "<init>", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "o", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOContentLeftSwipeHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View contentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean toggle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> listeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int maxScrollDistance;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int maxDampingDistance;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float downX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float downY;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float lastX;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isDownOnContent;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Scroller scroller;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable scrollRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOContentLeftSwipeHelper$a;", "", "", "STATE_LEFT_SWIPE", "I", "STATE_NONE", "STATE_OTHER", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOContentLeftSwipeHelper$b;", "", "", "X", "", "dx", "O0", "scrollX", "Z0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "k", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface b {
        void O0(int dx5);

        void X();

        void Z0(int scrollX);

        void a1(int scrollX);

        void k();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60990);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOContentLeftSwipeHelper(@NotNull ViewGroup container, @Nullable View view) {
        Intrinsics.checkNotNullParameter(container, "container");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) container, (Object) view);
            return;
        }
        this.container = container;
        this.contentView = view;
        this.toggle = true;
        this.listeners = new ArrayList();
        this.touchSlop = ViewConfiguration.get(container.getContext()).getScaledTouchSlop();
        LeftSwipeConstants leftSwipeConstants = LeftSwipeConstants.f190932a;
        this.maxScrollDistance = leftSwipeConstants.b();
        this.maxDampingDistance = leftSwipeConstants.a();
        this.scroller = new Scroller(container.getContext(), new Interpolator() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.a
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f16) {
                float b16;
                b16 = AIOContentLeftSwipeHelper.b(f16);
                return b16;
            }
        });
        this.scrollRunnable = new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOContentLeftSwipeHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (AIOContentLeftSwipeHelper.this.scroller.computeScrollOffset()) {
                    AIOContentLeftSwipeHelper.this.f().scrollTo(AIOContentLeftSwipeHelper.this.scroller.getCurrX(), AIOContentLeftSwipeHelper.this.scroller.getCurrY());
                    List list = AIOContentLeftSwipeHelper.this.listeners;
                    AIOContentLeftSwipeHelper aIOContentLeftSwipeHelper = AIOContentLeftSwipeHelper.this;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).a1(aIOContentLeftSwipeHelper.scroller.getCurrX());
                    }
                    AIOContentLeftSwipeHelper.this.f().postOnAnimation(this);
                    return;
                }
                QLog.d("AIOContentLeftSwipeHelper", 1, "onLeftSwipeBackEnd");
                Iterator it5 = AIOContentLeftSwipeHelper.this.listeners.iterator();
                while (it5.hasNext()) {
                    ((b) it5.next()).k();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(float f16) {
        return (float) (Math.pow(f16 - 1.0d, 5.0d) + 1.0f);
    }

    private final void g(MotionEvent ev5) {
        this.downX = ev5.getX();
        this.downY = ev5.getY();
        this.lastX = ev5.getX();
        this.state = 0;
        ViewParent parent = this.container.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private final boolean h(MotionEvent ev5, View view) {
        if (ev5.getX() > view.getX() && ev5.getX() < view.getX() + view.getWidth() && ev5.getY() > view.getY() && ev5.getY() < view.getY() + view.getHeight()) {
            return true;
        }
        return false;
    }

    private final void i(MotionEvent ev5) {
        int i3;
        if (this.state != 0) {
            return;
        }
        float x16 = ev5.getX() - this.downX;
        float y16 = ev5.getY() - this.downY;
        if (Math.sqrt((x16 * x16) + (y16 * y16)) < this.touchSlop) {
            return;
        }
        if (x16 < 0.0f && (-x16) * 0.5d > Math.abs(y16)) {
            ViewParent parent = this.container.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((b) it.next()).X();
            }
            i3 = 1;
        } else {
            ViewParent parent2 = this.container.getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(false);
            }
            i3 = 2;
        }
        this.state = i3;
        QLog.d("AIOContentLeftSwipeHelper", 1, "judgeMoveState state=" + i3);
    }

    private final void l() {
        if (this.container.getScrollX() == 0) {
            return;
        }
        if (!this.scroller.isFinished()) {
            this.scroller.abortAnimation();
        }
        this.scroller.startScroll(this.container.getScrollX(), 0, -this.container.getScrollX(), 0, (int) (50 + ((Math.abs(this.container.getScrollX()) / this.maxScrollDistance) * 150)));
        ViewCompat.postOnAnimation(this.container, this.scrollRunnable);
    }

    private final void m() {
        QLog.d("AIOContentLeftSwipeHelper", 1, "resetState");
        this.state = 0;
        this.isDownOnContent = false;
        ViewParent parent = this.container.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public final void e(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listeners.add(listener);
        }
    }

    @NotNull
    public final ViewGroup f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.container;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if (r0 != 3) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.contentView == null || !this.toggle) {
            return false;
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.isDownOnContent) {
                        return false;
                    }
                    i(ev5);
                    this.lastX = ev5.getX();
                }
            }
            if (!this.isDownOnContent) {
                return false;
            }
            m();
        } else {
            boolean h16 = h(ev5, this.contentView);
            this.isDownOnContent = h16;
            if (!h16) {
                return false;
            }
            g(ev5);
        }
        if (this.state != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r0 != 3) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.contentView == null || !this.toggle) {
            return false;
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.isDownOnContent) {
                        return false;
                    }
                    i(ev5);
                    if (this.state == 1) {
                        float f16 = 1.0f;
                        if (this.container.getScrollX() > this.maxDampingDistance) {
                            f16 = 1.0f - ((this.container.getScrollX() - this.maxDampingDistance) / (this.maxScrollDistance - r3));
                        }
                        int scrollX = (int) (this.container.getScrollX() + ((this.lastX - ev5.getX()) * f16));
                        if (scrollX < 0) {
                            scrollX = 0;
                        } else {
                            int i3 = this.maxScrollDistance;
                            if (scrollX > i3) {
                                scrollX = i3;
                            }
                        }
                        this.container.scrollTo(scrollX, 0);
                        Iterator<T> it = this.listeners.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).O0(scrollX);
                        }
                    }
                    this.lastX = ev5.getX();
                }
            }
            if (!this.isDownOnContent) {
                return false;
            }
            if (this.state == 1) {
                QLog.d("AIOContentLeftSwipeHelper", 1, "onTouchEvent onLeftSwipeEnd");
                Iterator<T> it5 = this.listeners.iterator();
                while (it5.hasNext()) {
                    ((b) it5.next()).Z0(this.container.getScrollX());
                }
                l();
            }
            m();
        } else {
            boolean h16 = h(ev5, this.contentView);
            this.isDownOnContent = h16;
            if (!h16) {
                return false;
            }
            g(ev5);
        }
        return true;
    }

    public final void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.toggle = z16;
        }
    }
}
