package com.tencent.aio.frame.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 l2\u00020\u0001:\u0001mB'\b\u0007\u0012\u0006\u0010f\u001a\u00020e\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g\u0012\b\b\u0002\u0010i\u001a\u00020\b\u00a2\u0006\u0004\bj\u0010kJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0014J0\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0014J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010$\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b&\u0010'J(\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0014J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0006R\u0018\u0010/\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010.R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00103R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00103R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00103R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00103R\u0014\u0010>\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b=\u0010=R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00103R\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010=R\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010E\u001a\u0004\bF\u0010GR#\u0010N\u001a\n J*\u0004\u0018\u00010I0I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010E\u001a\u0004\bL\u0010MR\u001b\u0010R\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010E\u001a\u0004\bP\u0010QR\u001b\u0010T\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010E\u001a\u0004\b6\u0010QR\u001b\u0010V\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010E\u001a\u0004\b(\u0010QR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u00103R\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010E\u001a\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006n"}, d2 = {"Lcom/tencent/aio/frame/drawer/DrawerFrameViewGroup;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "event", "", "j", "", ReportConstant.COSTREPORT_PREFIX, "", "startX", "toX", "duration", "g", Element.ELEMENT_NAME_DISTANCE, "u", "", "xDetail", "", "source", "r", "f", "Lcom/tencent/aio/frame/drawer/DrawerChildFrame;", "view", "e", "d", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "t", "()Z", "i", "(I)V", "l", "oldl", "oldt", "onScrollChanged", "enable", "k", "Lcom/tencent/aio/frame/drawer/DrawerChildFrame;", "leftFrameView", "rightFrameView", "contentFrameView", h.F, "I", "scrollDistance", "lastTouchX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lastTouchY", BdhLogUtil.LogTag.Tag_Conn, "initialTouchX", "D", "initialTouchY", "E", UserInfo.SEX_FEMALE, "rightOpenLimit", "leftOpenLimit", "G", "absScrollLimit", "H", "scrollPercent", "Landroid/view/VelocityTracker;", "Lkotlin/Lazy;", "p", "()Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/view/ViewConfiguration;", "viewConfig", "K", "o", "()I", "touchSlop", "L", "minFlingVelocity", "M", "maxFlingVelocity", "N", "mScrollPointerId", "Lcom/tencent/aio/frame/drawer/a;", "P", "Lcom/tencent/aio/frame/drawer/a;", "scrollInterpolator", "Lcom/tencent/aio/frame/drawer/ViewFlinger;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, DomainData.DOMAIN_NAME, "()Lcom/tencent/aio/frame/drawer/ViewFlinger;", "scroller", BdhLogUtil.LogTag.Tag_Req, "Z", "enableOpenRight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class DrawerFrameViewGroup extends FrameLayout {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a S;

    /* renamed from: C, reason: from kotlin metadata */
    private int initialTouchX;

    /* renamed from: D, reason: from kotlin metadata */
    private int initialTouchY;

    /* renamed from: E, reason: from kotlin metadata */
    private final float rightOpenLimit;

    /* renamed from: F, reason: from kotlin metadata */
    private final float leftOpenLimit;

    /* renamed from: G, reason: from kotlin metadata */
    private int absScrollLimit;

    /* renamed from: H, reason: from kotlin metadata */
    private float scrollPercent;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy velocityTracker;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy viewConfig;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy touchSlop;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy minFlingVelocity;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy maxFlingVelocity;

    /* renamed from: N, reason: from kotlin metadata */
    private int mScrollPointerId;

    /* renamed from: P, reason: from kotlin metadata */
    private final com.tencent.aio.frame.drawer.a scrollInterpolator;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy scroller;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean enableOpenRight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private DrawerChildFrame leftFrameView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private DrawerChildFrame rightFrameView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private DrawerChildFrame contentFrameView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int scrollDistance;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastTouchX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastTouchY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/frame/drawer/DrawerFrameViewGroup$a;", "", "", "TAG", "Ljava/lang/String;", "", "TIME_CLOSE_OPEN", "I", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            S = new a(null);
        }
    }

    @JvmOverloads
    public DrawerFrameViewGroup(@NotNull Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
    }

    private final void g(int startX, int toX, int duration) {
        n().stop();
        ViewFlinger.h(n(), startX, 0, toX - startX, 0, duration, 10, null);
    }

    static /* synthetic */ void h(DrawerFrameViewGroup drawerFrameViewGroup, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 2) != 0) {
            i16 = 0;
        }
        if ((i18 & 4) != 0) {
            i17 = 300;
        }
        drawerFrameViewGroup.g(i3, i16, i17);
    }

    private final void j(MotionEvent event) {
        DrawerChildFrame drawerChildFrame;
        p().computeCurrentVelocity(1000, l());
        if (Math.abs(p().getXVelocity()) > m()) {
            float f16 = 0;
            if (p().getXVelocity() < f16) {
                int i3 = this.scrollDistance;
                if (i3 > 0) {
                    h(this, i3, this.absScrollLimit, 0, 4, null);
                }
                int i16 = this.scrollDistance;
                if (i16 < 0) {
                    h(this, i16, 0, 0, 4, null);
                }
            } else if (p().getXVelocity() > f16) {
                int i17 = this.scrollDistance;
                if (i17 > 0) {
                    h(this, i17, 0, 0, 4, null);
                }
                int i18 = this.scrollDistance;
                if (i18 < 0) {
                    h(this, i18, -this.absScrollLimit, 0, 4, null);
                }
            }
        } else if (t()) {
            if (this.rightFrameView != null) {
                if (Math.abs(this.scrollDistance) > r14.getMeasuredWidth() * this.rightOpenLimit) {
                    h(this, this.scrollDistance, this.absScrollLimit, 0, 4, null);
                } else {
                    h(this, this.scrollDistance, 0, 0, 4, null);
                }
            }
        } else if (s() && (drawerChildFrame = this.leftFrameView) != null) {
            if (Math.abs(this.scrollDistance) > drawerChildFrame.getMeasuredWidth() * this.leftOpenLimit) {
                h(this, this.scrollDistance, -this.absScrollLimit, 0, 4, null);
            } else {
                h(this, this.scrollDistance, 0, 0, 4, null);
            }
        }
        p().clear();
    }

    private final int l() {
        return ((Number) this.maxFlingVelocity.getValue()).intValue();
    }

    private final int m() {
        return ((Number) this.minFlingVelocity.getValue()).intValue();
    }

    private final ViewFlinger n() {
        return (ViewFlinger) this.scroller.getValue();
    }

    private final int o() {
        return ((Number) this.touchSlop.getValue()).intValue();
    }

    private final VelocityTracker p() {
        return (VelocityTracker) this.velocityTracker.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewConfiguration q() {
        return (ViewConfiguration) this.viewConfig.getValue();
    }

    private final boolean r(float xDetail, String source) {
        int i3;
        int i16;
        Integer num;
        ct.a.a(this, "DrawerFrameViewGroup", "---------------------------------start---------------------");
        float f16 = 0;
        if (xDetail < f16) {
            int i17 = this.scrollDistance;
            DrawerChildFrame drawerChildFrame = this.rightFrameView;
            if (drawerChildFrame != null) {
                i16 = drawerChildFrame.getMeasuredWidth();
            } else {
                i16 = 0;
            }
            if (i17 >= i16) {
                ct.a.a(this, "DrawerFrameViewGroup", source + " \u5de6\u6ed1\u4e0d\u62e6\u622a");
                getParent().requestDisallowInterceptTouchEvent(false);
                com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("xDetail ");
                sb5.append(xDetail);
                sb5.append("  scrollDistance ");
                sb5.append(this.scrollDistance);
                sb5.append("  rightFrameView ");
                DrawerChildFrame drawerChildFrame2 = this.rightFrameView;
                if (drawerChildFrame2 != null) {
                    num = Integer.valueOf(drawerChildFrame2.getMeasuredWidth());
                } else {
                    num = null;
                }
                sb5.append(num);
                aVar.d("DrawerFrameViewGroup", sb5.toString());
                return false;
            }
        }
        if (xDetail > f16) {
            int i18 = this.scrollDistance;
            DrawerChildFrame drawerChildFrame3 = this.leftFrameView;
            if (drawerChildFrame3 != null) {
                i3 = drawerChildFrame3.getMeasuredWidth();
            } else {
                i3 = 0;
            }
            if (i18 <= i3) {
                ct.a.a(this, "DrawerFrameViewGroup", source + " \u53f3\u6ed1\u4e0d\u62e6\u622a");
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        }
        ct.a.a(this, "DrawerFrameViewGroup", source + " intercept xDetail");
        if (xDetail < f16 && !this.enableOpenRight) {
            com.tencent.aio.base.log.a.f69187b.d("DrawerFrameViewGroup", "xDetail " + xDetail + "   enableOpenRight " + this.enableOpenRight);
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    private final boolean s() {
        if (this.scrollDistance < 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int distance) {
        this.scrollDistance = distance;
        if (distance < 0 && this.leftFrameView == null) {
            this.scrollDistance = 0;
        }
        if (distance > 0 && this.rightFrameView == null) {
            this.scrollDistance = this.absScrollLimit;
        }
        int abs = Math.abs(this.scrollDistance);
        int i3 = this.absScrollLimit;
        if (abs > i3) {
            if (this.scrollDistance <= 0) {
                i3 = -i3;
            }
            this.scrollDistance = i3;
            n().stop();
        }
        this.scrollPercent = this.scrollDistance / getMeasuredWidth();
        ct.a.a(this, "DrawerFrameViewGroup", " scrollFrame scrollPercent " + this.scrollPercent);
        scrollTo(this.scrollDistance, 0);
    }

    public final void d(@NotNull DrawerChildFrame view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        addView(view);
        this.contentFrameView = view;
        if (view != null) {
            view.a(true);
        }
    }

    public final void e(@NotNull DrawerChildFrame view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            addView(view);
            this.rightFrameView = view;
            return;
        }
        aVar.b("addRightFrame");
        String str = "AIO#addRightFrame";
        if (!aVar.h()) {
            addView(view);
            this.rightFrameView = view;
            Unit unit = Unit.INSTANCE;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            addView(view);
            this.rightFrameView = view;
            Unit unit2 = Unit.INSTANCE;
            Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
        }
        aVar.e();
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        removeAllViews();
        this.leftFrameView = null;
        this.contentFrameView = null;
        this.rightFrameView = null;
    }

    public final void i(int duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, duration);
        } else if (t()) {
            g(this.absScrollLimit, 0, duration);
        }
    }

    public final void k(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, enable);
        } else {
            if (enable == this.enableOpenRight) {
                return;
            }
            this.enableOpenRight = enable;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) e16)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        if ((this.leftFrameView == null && this.rightFrameView == null) || this.contentFrameView == null) {
            return false;
        }
        int actionMasked = e16.getActionMasked();
        int actionIndex = e16.getActionIndex();
        int i3 = 1;
        if (actionMasked != 0) {
            if (actionMasked != 2) {
                if (actionMasked != 5) {
                    if (actionMasked == 6 && e16.getPointerId(actionIndex) == this.mScrollPointerId) {
                        if (actionIndex != 0) {
                            i3 = 0;
                        }
                        this.mScrollPointerId = e16.getPointerId(i3);
                        this.lastTouchX = (int) (e16.getX(i3) + 0.5f);
                        int y16 = (int) (e16.getY(i3) + 0.5f);
                        this.lastTouchY = y16;
                        this.initialTouchX = this.lastTouchX;
                        this.initialTouchY = y16;
                    }
                } else {
                    this.mScrollPointerId = e16.getPointerId(actionIndex);
                    this.lastTouchX = (int) (e16.getX(actionIndex) + 0.5f);
                    int y17 = (int) (e16.getY(actionIndex) + 0.5f);
                    this.lastTouchY = y17;
                    this.initialTouchX = this.lastTouchX;
                    this.initialTouchY = y17;
                    n().stop();
                }
            } else {
                int findPointerIndex = e16.findPointerIndex(this.mScrollPointerId);
                if (findPointerIndex < 0) {
                    return false;
                }
                float x16 = e16.getX(findPointerIndex) + 0.5f;
                float y18 = e16.getY(findPointerIndex) + 0.5f;
                float f16 = x16 - this.lastTouchX;
                float abs = Math.abs(f16);
                float abs2 = Math.abs(y18 - this.initialTouchY);
                if (abs > o() && abs * 0.5f > abs2 && r(f16, "intercept")) {
                    return true;
                }
            }
        } else {
            this.mScrollPointerId = e16.getPointerId(0);
            this.lastTouchX = (int) (e16.getX(actionIndex) + 0.5f);
            int y19 = (int) (e16.getY(actionIndex) + 0.5f);
            this.lastTouchY = y19;
            this.initialTouchX = this.lastTouchX;
            this.initialTouchY = y19;
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i3;
        int roundToInt;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        ct.a.a(this, "DrawerFrameViewGroup", "onLayout " + getScrollX() + "  changed " + changed);
        DrawerChildFrame drawerChildFrame = this.leftFrameView;
        if (drawerChildFrame != null) {
            int measuredWidth = 0 - drawerChildFrame.getMeasuredWidth();
            i3 = drawerChildFrame.getMeasuredWidth() + measuredWidth;
            drawerChildFrame.d(measuredWidth, 0, i3, drawerChildFrame.getMeasuredHeight());
        } else {
            i3 = 0;
        }
        DrawerChildFrame drawerChildFrame2 = this.contentFrameView;
        if (drawerChildFrame2 != null) {
            com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
            if (!aVar.g()) {
                int measuredWidth2 = drawerChildFrame2.getMeasuredWidth() + i3;
                drawerChildFrame2.d(i3, 0, measuredWidth2, drawerChildFrame2.getMeasuredHeight());
                i3 = measuredWidth2;
            } else {
                aVar.b("drawerlayoutContent");
                String str = "AIO#drawerlayoutContent";
                if (!aVar.h()) {
                    i16 = drawerChildFrame2.getMeasuredWidth() + i3;
                    drawerChildFrame2.d(i3, 0, i16, drawerChildFrame2.getMeasuredHeight());
                    Unit unit = Unit.INSTANCE;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    int measuredWidth3 = drawerChildFrame2.getMeasuredWidth() + i3;
                    drawerChildFrame2.d(i3, 0, measuredWidth3, drawerChildFrame2.getMeasuredHeight());
                    Unit unit2 = Unit.INSTANCE;
                    Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                    i16 = measuredWidth3;
                }
                aVar.e();
                i3 = i16;
            }
        }
        DrawerChildFrame drawerChildFrame3 = this.rightFrameView;
        if (drawerChildFrame3 != null) {
            com.tencent.aio.pref.a aVar2 = com.tencent.aio.pref.a.f69788j;
            if (!aVar2.g()) {
                drawerChildFrame3.d(i3, 0, drawerChildFrame3.getMeasuredWidth() + i3, drawerChildFrame3.getMeasuredHeight());
            } else {
                aVar2.b("draweralyoutRight");
                String str2 = "AIO#draweralyoutRight";
                if (!aVar2.h()) {
                    drawerChildFrame3.d(i3, 0, drawerChildFrame3.getMeasuredWidth() + i3, drawerChildFrame3.getMeasuredHeight());
                    Unit unit3 = Unit.INSTANCE;
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    drawerChildFrame3.d(i3, 0, drawerChildFrame3.getMeasuredWidth() + i3, drawerChildFrame3.getMeasuredHeight());
                    Unit unit4 = Unit.INSTANCE;
                    Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis2));
                }
                aVar2.e();
            }
        }
        float measuredWidth4 = this.scrollPercent * getMeasuredWidth();
        if (!Float.isNaN(measuredWidth4)) {
            roundToInt = MathKt__MathJVMKt.roundToInt(measuredWidth4);
            u(roundToInt);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        View.MeasureSpec.getSize(heightMeasureSpec);
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            DrawerChildFrame drawerChildFrame = this.leftFrameView;
            if (drawerChildFrame != null) {
                drawerChildFrame.e(widthMeasureSpec, heightMeasureSpec);
            }
        } else {
            aVar.b("drawerLeftMeasure");
            String str = "AIO#drawerLeftMeasure";
            if (!aVar.h()) {
                DrawerChildFrame drawerChildFrame2 = this.leftFrameView;
                if (drawerChildFrame2 != null) {
                    drawerChildFrame2.e(widthMeasureSpec, heightMeasureSpec);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                DrawerChildFrame drawerChildFrame3 = this.leftFrameView;
                if (drawerChildFrame3 != null) {
                    drawerChildFrame3.e(widthMeasureSpec, heightMeasureSpec);
                    Unit unit2 = Unit.INSTANCE;
                }
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar.e();
        }
        if (!aVar.g()) {
            DrawerChildFrame drawerChildFrame4 = this.contentFrameView;
            if (drawerChildFrame4 != null) {
                drawerChildFrame4.e(widthMeasureSpec, heightMeasureSpec);
            }
        } else {
            aVar.b("drawerContentMeasure");
            String str2 = "AIO#drawerContentMeasure";
            if (!aVar.h()) {
                DrawerChildFrame drawerChildFrame5 = this.contentFrameView;
                if (drawerChildFrame5 != null) {
                    drawerChildFrame5.e(widthMeasureSpec, heightMeasureSpec);
                    Unit unit3 = Unit.INSTANCE;
                }
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                DrawerChildFrame drawerChildFrame6 = this.contentFrameView;
                if (drawerChildFrame6 != null) {
                    drawerChildFrame6.e(widthMeasureSpec, heightMeasureSpec);
                    Unit unit4 = Unit.INSTANCE;
                }
                Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis2));
            }
            aVar.e();
        }
        if (!aVar.g()) {
            DrawerChildFrame drawerChildFrame7 = this.rightFrameView;
            if (drawerChildFrame7 != null) {
                drawerChildFrame7.e(widthMeasureSpec, heightMeasureSpec);
            }
        } else {
            aVar.b("drawerRightMeasure");
            String str3 = "AIO#drawerRightMeasure";
            if (!aVar.h()) {
                DrawerChildFrame drawerChildFrame8 = this.rightFrameView;
                if (drawerChildFrame8 != null) {
                    drawerChildFrame8.e(widthMeasureSpec, heightMeasureSpec);
                    Unit unit5 = Unit.INSTANCE;
                }
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                DrawerChildFrame drawerChildFrame9 = this.rightFrameView;
                if (drawerChildFrame9 != null) {
                    drawerChildFrame9.e(widthMeasureSpec, heightMeasureSpec);
                    Unit unit6 = Unit.INSTANCE;
                }
                Log.w("AIO#", str3 + " spend " + (System.currentTimeMillis() - currentTimeMillis3));
            }
            aVar.e();
        }
        if (getLayoutDirection() == 1) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        } else {
            DrawerChildFrame drawerChildFrame10 = this.leftFrameView;
            if (drawerChildFrame10 != null) {
                i3 = drawerChildFrame10.getMeasuredWidth();
            } else {
                i3 = 0;
            }
            DrawerChildFrame drawerChildFrame11 = this.contentFrameView;
            if (drawerChildFrame11 != null) {
                i16 = drawerChildFrame11.getMeasuredWidth();
            } else {
                i16 = 0;
            }
            int i18 = i3 + i16;
            DrawerChildFrame drawerChildFrame12 = this.rightFrameView;
            if (drawerChildFrame12 != null) {
                i17 = drawerChildFrame12.getMeasuredWidth();
            }
            setMeasuredDimension(i18 + i17, heightMeasureSpec);
        }
        this.absScrollLimit = size;
    }

    @Override // android.view.View
    protected void onScrollChanged(int l3, int t16, int oldl, int oldt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(oldl), Integer.valueOf(oldt));
            return;
        }
        super.onScrollChanged(l3, t16, oldl, oldt);
        ct.a.a(this, "DrawerFrameViewGroup", "onScrollChanged " + l3);
        if (l3 == this.absScrollLimit) {
            DrawerChildFrame drawerChildFrame = this.contentFrameView;
            if (drawerChildFrame != null) {
                drawerChildFrame.a(false);
            }
            DrawerChildFrame drawerChildFrame2 = this.rightFrameView;
            if (drawerChildFrame2 != null) {
                drawerChildFrame2.a(true);
                return;
            }
            return;
        }
        if (l3 == 0) {
            DrawerChildFrame drawerChildFrame3 = this.contentFrameView;
            if (drawerChildFrame3 != null) {
                drawerChildFrame3.a(true);
            }
            DrawerChildFrame drawerChildFrame4 = this.rightFrameView;
            if (drawerChildFrame4 != null) {
                drawerChildFrame4.a(false);
                return;
            }
            return;
        }
        if (l3 > 0) {
            DrawerChildFrame drawerChildFrame5 = this.contentFrameView;
            if (drawerChildFrame5 != null) {
                drawerChildFrame5.a(true);
            }
            DrawerChildFrame drawerChildFrame6 = this.rightFrameView;
            if (drawerChildFrame6 != null) {
                drawerChildFrame6.a(true);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = 0;
        if ((this.leftFrameView == null && this.rightFrameView == null) || this.contentFrameView == null) {
            return false;
        }
        p().addMovement(event);
        int actionMasked = event.getActionMasked();
        int actionIndex = event.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked != 6) {
                                return false;
                            }
                            int actionIndex2 = event.getActionIndex();
                            if (event.getPointerId(actionIndex2) == this.mScrollPointerId) {
                                if (actionIndex2 == 0) {
                                    i3 = 1;
                                }
                                this.mScrollPointerId = event.getPointerId(i3);
                                this.lastTouchX = (int) (event.getX(i3) + 0.5f);
                                int y16 = (int) (event.getY(i3) + 0.5f);
                                this.lastTouchY = y16;
                                this.initialTouchX = this.lastTouchX;
                                this.initialTouchY = y16;
                            }
                            return true;
                        }
                        this.mScrollPointerId = event.getPointerId(actionIndex);
                        this.lastTouchX = (int) (event.getX(actionIndex) + 0.5f);
                        int y17 = (int) (event.getY(actionIndex) + 0.5f);
                        this.lastTouchY = y17;
                        this.initialTouchX = this.lastTouchX;
                        this.initialTouchY = y17;
                        n().stop();
                        return true;
                    }
                    this.scrollDistance = 0;
                    u(0);
                    return true;
                }
                int findPointerIndex = event.findPointerIndex(this.mScrollPointerId);
                if (findPointerIndex < 0) {
                    return false;
                }
                int x16 = (int) (event.getX(findPointerIndex) + 0.5f);
                event.getY(findPointerIndex);
                int i16 = x16 - this.lastTouchX;
                if (i16 == 0 || !r(i16, "onTouch")) {
                    return false;
                }
                int i17 = this.scrollDistance - i16;
                this.scrollDistance = i17;
                u(i17);
                this.lastTouchX = x16;
                return true;
            }
            j(event);
            return true;
        }
        this.mScrollPointerId = event.getPointerId(0);
        this.lastTouchX = (int) (event.getX(actionIndex) + 0.5f);
        int y18 = (int) (event.getY(actionIndex) + 0.5f);
        this.lastTouchY = y18;
        this.initialTouchX = this.lastTouchX;
        this.initialTouchY = y18;
        n().stop();
        return true;
    }

    public final boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.scrollDistance > 0) {
            return true;
        }
        return false;
    }

    @JvmOverloads
    public DrawerFrameViewGroup(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ DrawerFrameViewGroup(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DrawerFrameViewGroup(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.rightOpenLimit = 0.5f;
        this.leftOpenLimit = 0.5f;
        lazy = LazyKt__LazyJVMKt.lazy(DrawerFrameViewGroup$velocityTracker$2.INSTANCE);
        this.velocityTracker = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ViewConfiguration>(context) { // from class: com.tencent.aio.frame.drawer.DrawerFrameViewGroup$viewConfig$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewConfiguration invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? ViewConfiguration.get(this.$context) : (ViewConfiguration) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.viewConfig = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.aio.frame.drawer.DrawerFrameViewGroup$touchSlop$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) DrawerFrameViewGroup.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                ViewConfiguration viewConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 1, (Object) this)).intValue();
                }
                viewConfig = DrawerFrameViewGroup.this.q();
                Intrinsics.checkNotNullExpressionValue(viewConfig, "viewConfig");
                return viewConfig.getScaledTouchSlop();
            }
        });
        this.touchSlop = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.aio.frame.drawer.DrawerFrameViewGroup$minFlingVelocity$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) DrawerFrameViewGroup.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                ViewConfiguration viewConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 1, (Object) this)).intValue();
                }
                viewConfig = DrawerFrameViewGroup.this.q();
                Intrinsics.checkNotNullExpressionValue(viewConfig, "viewConfig");
                return viewConfig.getScaledMinimumFlingVelocity();
            }
        });
        this.minFlingVelocity = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.aio.frame.drawer.DrawerFrameViewGroup$maxFlingVelocity$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) DrawerFrameViewGroup.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                ViewConfiguration viewConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 1, (Object) this)).intValue();
                }
                viewConfig = DrawerFrameViewGroup.this.q();
                Intrinsics.checkNotNullExpressionValue(viewConfig, "viewConfig");
                return viewConfig.getScaledMaximumFlingVelocity();
            }
        });
        this.maxFlingVelocity = lazy5;
        this.mScrollPointerId = -1;
        this.scrollInterpolator = new com.tencent.aio.frame.drawer.a(0.165f, 0.84f, 0.44f, 1.0f);
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ViewFlinger>(context) { // from class: com.tencent.aio.frame.drawer.DrawerFrameViewGroup$scroller$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) DrawerFrameViewGroup.this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewFlinger invoke() {
                a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (ViewFlinger) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                Context context2 = this.$context;
                DrawerFrameViewGroup drawerFrameViewGroup = DrawerFrameViewGroup.this;
                aVar = drawerFrameViewGroup.scrollInterpolator;
                return new ViewFlinger(context2, drawerFrameViewGroup, aVar, new Function2<Integer, Integer, Unit>() { // from class: com.tencent.aio.frame.drawer.DrawerFrameViewGroup$scroller$2.1
                    static IPatchRedirector $redirector_;

                    {
                        super(2);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, (Object) DrawerFrameViewGroup$scroller$2.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                        invoke(num.intValue(), num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i16, int i17) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 1)) {
                            DrawerFrameViewGroup.this.u(i16);
                        } else {
                            iPatchRedirector3.redirect((short) 1, this, Integer.valueOf(i16), Integer.valueOf(i17));
                        }
                    }
                });
            }
        });
        this.scroller = lazy6;
        this.enableOpenRight = true;
    }
}
