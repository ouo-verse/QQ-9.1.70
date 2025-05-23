package com.tencent.biz.qqcircle.half;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r30.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 S2\u00020\u0001:\u0001TB\u001d\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000fJ \u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0002J\u0010\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"J\u000e\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u000fJ\u0006\u0010)\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\u000fR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00160+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\"0/j\b\u0012\u0004\u0012\u00020\"`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00105R\u0016\u0010;\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010B\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010:R\u0018\u0010E\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0011\u0010H\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR\u0011\u0010J\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bI\u0010GR\u0011\u0010L\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bK\u0010G\u00a8\u0006U"}, d2 = {"Lcom/tencent/biz/qqcircle/half/QFSHalfScreenBaseSheetView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "", ReportConstant.COSTREPORT_PREFIX, "", "newState", "y", "", "slideOffset", HippyTKDListViewAdapter.X, "", DomainData.DOMAIN_NAME, "p", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Lr30/a;", "nestScrollDelegate", "setNestScrollDelegate", "rounded", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", ParseCommon.CONTAINER, "Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;", "layoutParams", "pageContentView", "t", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lr30/b;", "stateListener", "i", "state", "setState", "isFixHalf", "B", "u", "v", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "d", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mStateListenerList", "f", "I", "mPanelHeight", h.F, "mTopSpaceHeight", "mTopVideoHeight", "Z", "mHasShowed", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mPanelContainerView", "D", "mPageContentContainer", "E", "mIsContentContainerRounded", UserInfo.SEX_FEMALE, "Lr30/a;", "mNestScrollDelegate", "o", "()I", "panelHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "topSpaceHeight", "r", "topVideoHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class QFSHalfScreenBaseSheetView extends CoordinatorLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View mPanelContainerView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mPageContentContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsContentContainerRounded;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private a mNestScrollDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BottomSheetBehavior<View> behavior;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<r30.b> mStateListenerList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mPanelHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mTopSpaceHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mTopVideoHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mHasShowed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/half/QFSHalfScreenBaseSheetView$b", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (QLog.isDevelopLevel()) {
                QLog.d(QFSHalfScreenBaseSheetView.this.n(), 1, "[onSlide] slideOffset:" + slideOffset);
            }
            QFSHalfScreenBaseSheetView.this.x(slideOffset);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            QLog.d(QFSHalfScreenBaseSheetView.this.n(), 1, "[onStateChanged] newState:" + newState);
            QFSHalfScreenBaseSheetView.this.y(newState);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSHalfScreenBaseSheetView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void s() {
        this.behavior.setHideable(true);
        this.behavior.setDraggable(true);
        this.behavior.setPeekHeight(o() + p());
        this.behavior.setState(5);
        this.behavior.addBottomSheetCallback(new b());
        try {
            Field declaredField = BottomSheetBehavior.class.getDeclaredField("paddingTopSystemWindowInsets");
            declaredField.setAccessible(true);
            declaredField.set(this.behavior, Boolean.TRUE);
        } catch (IllegalAccessException e16) {
            QLog.e(n(), 1, "[paddingTopSystemWindowInsets] error:" + e16);
        } catch (NoSuchFieldException e17) {
            QLog.e(n(), 1, "[paddingTopSystemWindowInsets] error:" + e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(float slideOffset) {
        Iterator<r30.b> it = this.mStateListenerList.iterator();
        while (it.hasNext()) {
            it.next().n6(slideOffset, o(), r());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int newState) {
        if (newState == 5) {
            this.mHasShowed = false;
            Iterator<r30.b> it = this.mStateListenerList.iterator();
            while (it.hasNext()) {
                it.next().l(false);
            }
        }
        if (newState == 3) {
            Iterator<r30.b> it5 = this.mStateListenerList.iterator();
            while (it5.hasNext()) {
                it5.next().k7();
            }
        }
        if (newState == 4) {
            Iterator<r30.b> it6 = this.mStateListenerList.iterator();
            while (it6.hasNext()) {
                it6.next().m5();
            }
        }
    }

    public final void A(boolean rounded) {
        Unit unit;
        int i3;
        if (this.mIsContentContainerRounded == rounded) {
            return;
        }
        View view = this.mPageContentContainer;
        if (view != null) {
            if (rounded) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            bk.d(view, i3);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(n(), 1, "[updateContainerBackground] mContentContainer is null");
        }
        this.mIsContentContainerRounded = rounded;
    }

    public final void B(boolean isFixHalf) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.mPanelContainerView;
        CoordinatorLayout.LayoutParams layoutParams2 = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            int i3 = -1;
            if (isFixHalf) {
                layoutParams2.gravity = 0;
                if (this.behavior.getPeekHeight() > 0) {
                    i3 = this.behavior.getPeekHeight();
                }
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = i3;
            } else {
                layoutParams2.gravity = 80;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = -1;
            }
            View view2 = this.mPanelContainerView;
            if (view2 != null) {
                view2.requestLayout();
            }
        }
    }

    public final void i(@Nullable r30.b stateListener) {
        if (stateListener != null && !this.mStateListenerList.contains(stateListener)) {
            this.mStateListenerList.add(stateListener);
        }
    }

    public final void j() {
        this.behavior.setState(4);
    }

    public final void k() {
        this.mHasShowed = false;
        Iterator<r30.b> it = this.mStateListenerList.iterator();
        while (it.hasNext()) {
            it.next().l(false);
        }
    }

    public final void l() {
        this.behavior.setState(5);
    }

    public final void m() {
        this.behavior.setState(3);
    }

    @NotNull
    public String n() {
        return "QFSHalfScreenBaseSheetView";
    }

    public final int o() {
        int i3 = this.mPanelHeight;
        if (i3 > 0) {
            return i3;
        }
        int screenHeight = DisplayUtil.getScreenHeight();
        if (!bz.r()) {
            screenHeight = RangesKt___RangesKt.coerceAtLeast(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
        }
        int q16 = q();
        int i16 = screenHeight - q16;
        if (i16 < q16) {
            i16 = (int) (cx.b(getContext()) * 0.7d);
        }
        this.mPanelHeight = i16;
        QLog.d(n(), 1, "[getPanelHeight] panelHeight:" + i16 + ", topSpaceHeight:" + q16 + ", screenHeight:" + DisplayUtil.getScreenHeight());
        return this.mPanelHeight;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        a aVar = this.mNestScrollDelegate;
        if (aVar != null) {
            z16 = aVar.r7(this, ev5);
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(n(), 1, "[onInterceptTouchEvent] child intercept");
            }
            return false;
        }
        a aVar2 = this.mNestScrollDelegate;
        if (aVar2 != null) {
            z17 = aVar2.p2(this, ev5);
        } else {
            z17 = false;
        }
        if (!z17 && !super.onInterceptTouchEvent(ev5)) {
            return false;
        }
        return true;
    }

    public int p() {
        return 0;
    }

    public final int q() {
        int i3 = this.mTopSpaceHeight;
        if (i3 > 0) {
            return i3;
        }
        int screenWidth = DisplayUtil.getScreenWidth();
        if (!bz.r()) {
            screenWidth = RangesKt___RangesKt.coerceAtMost(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
        }
        int i16 = (int) (screenWidth * 0.5625f);
        this.mTopSpaceHeight = i16;
        return i16;
    }

    public final int r() {
        int i3 = this.mTopVideoHeight;
        if (i3 > 0) {
            return i3;
        }
        int measuredHeight = getMeasuredHeight();
        int K = r.K(getContext());
        QLog.d(n(), 1, "[getTopVideoHeight] measuredHeight:" + measuredHeight + ", statusBarHeight:" + K + ", panelHeight:" + o());
        int o16 = (measuredHeight - o()) - K;
        this.mTopVideoHeight = o16;
        return o16;
    }

    public final void setNestScrollDelegate(@Nullable a nestScrollDelegate) {
        this.mNestScrollDelegate = nestScrollDelegate;
    }

    public final void setState(int state) {
        QLog.d(n(), 1, "[setState] " + state);
        this.behavior.setState(state);
    }

    public final void t(@NotNull View container, @NotNull CoordinatorLayout.LayoutParams layoutParams, @Nullable View pageContentView) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.mPanelContainerView = container;
        this.mPageContentContainer = pageContentView;
        container.setClickable(true);
        layoutParams.setBehavior(this.behavior);
        layoutParams.gravity = 80;
        container.setLayoutParams(layoutParams);
        addView(container);
        A(true);
    }

    public final boolean u() {
        if (this.behavior.getState() == 4) {
            return true;
        }
        return false;
    }

    public final boolean v() {
        if (this.behavior.getState() == 3) {
            return true;
        }
        return false;
    }

    public final boolean w() {
        if (this.behavior.getState() != 5) {
            return true;
        }
        return false;
    }

    public final void z() {
        if (this.mHasShowed) {
            QLog.e(n(), 1, "[show] has showed");
            return;
        }
        Iterator<r30.b> it = this.mStateListenerList.iterator();
        while (it.hasNext()) {
            it.next().l0();
        }
        this.behavior.setState(4);
        this.mHasShowed = true;
    }

    public /* synthetic */ QFSHalfScreenBaseSheetView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSHalfScreenBaseSheetView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.behavior = new BottomSheetBehavior<>();
        this.mStateListenerList = new ArrayList<>();
        s();
    }
}
