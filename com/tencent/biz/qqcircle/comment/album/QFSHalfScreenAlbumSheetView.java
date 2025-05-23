package com.tencent.biz.qqcircle.comment.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0002<=B\u001d\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018R'\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u001bj\b\u0012\u0004\u0012\u00020\u0018`\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010)R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,R\u0014\u0010/\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010.R\u0014\u00101\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0011\u00104\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b2\u00103\u00a8\u0006>"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/QFSHalfScreenAlbumSheetView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "rounded", ReportConstant.COSTREPORT_PREFIX, "o", "", "slideOffset", "r", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "Landroid/view/View;", ParseCommon.CONTAINER, "Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;", "layoutParams", DomainData.DOMAIN_NAME, "p", "i", "", "height", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/biz/qqcircle/comment/album/QFSHalfScreenAlbumSheetView$b;", "listener", tl.h.F, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "l", "()Ljava/util/ArrayList;", "stateChangeListener", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "e", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "j", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "f", "Landroid/view/View;", "mContentContainer", "mTitleTv", "Z", "mIsContentContainerRounded", "I", "mStartAnimY", BdhLogUtil.LogTag.Tag_Conn, "mTitleFinalHeight", "k", "()Z", "showing", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSHalfScreenAlbumSheetView extends CoordinatorLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int mTitleFinalHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> stateChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BottomSheetBehavior<View> behavior;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mContentContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mTitleTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsContentContainerRounded;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int mStartAnimY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/QFSHalfScreenAlbumSheetView$b;", "", "", "newState", "", "a", "", "slideOffset", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void a(int newState);

        void b(float slideOffset);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSHalfScreenAlbumSheetView$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends BottomSheetBehavior.e {
        c() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (QLog.isDevelopLevel()) {
                QLog.d("QFSHalfScreenAlbumSheetView", 1, "[onSlide] slideOffset:" + slideOffset);
            }
            QFSHalfScreenAlbumSheetView.this.r(slideOffset);
            Iterator<b> it = QFSHalfScreenAlbumSheetView.this.l().iterator();
            while (it.hasNext()) {
                it.next().b(slideOffset);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 5) {
                QFSHalfScreenAlbumSheetView.this.setVisibility(8);
            }
            if (newState == 4) {
                QFSHalfScreenAlbumSheetView.this.j().setHideable(false);
            }
            Iterator<b> it = QFSHalfScreenAlbumSheetView.this.l().iterator();
            while (it.hasNext()) {
                it.next().a(newState);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSHalfScreenAlbumSheetView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void m() {
        this.behavior.setDraggable(true);
        this.behavior.setPeekHeight(QFSBaseInputPopupWindow.U);
        this.behavior.setState(5);
        o();
    }

    private final void o() {
        this.behavior.addBottomSheetCallback(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(float slideOffset) {
        if (slideOffset < 0.0f) {
            return;
        }
        s(true);
        View view = this.mTitleTv;
        if (view != null) {
            float f16 = 1;
            float measuredHeight = (f16 - slideOffset) * (getMeasuredHeight() - this.behavior.getPeekHeight());
            if (measuredHeight < this.mStartAnimY) {
                view.setVisibility(0);
                float f17 = this.mTitleFinalHeight * (f16 - (measuredHeight / this.mStartAnimY));
                view.getLayoutParams().height = (int) f17;
                view.setLayoutParams(view.getLayoutParams());
                QLog.d("QFSHalfScreenAlbumSheetView", 4, "[showTitleAnim] targetH: " + f17);
                return;
            }
            view.getLayoutParams().height = 0;
            view.setVisibility(8);
        }
    }

    private final void s(boolean rounded) {
        Unit unit;
        int i3;
        if (this.mIsContentContainerRounded == rounded) {
            return;
        }
        View view = this.mContentContainer;
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
            QLog.e("QFSHalfScreenAlbumSheetView", 1, "[updateContainerBackground] mContentContainer is null");
        }
        this.mIsContentContainerRounded = rounded;
    }

    public final void h(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.stateChangeListener.contains(listener)) {
            this.stateChangeListener.add(listener);
        }
    }

    public final void i() {
        this.behavior.setHideable(true);
        this.behavior.setState(5);
    }

    @NotNull
    public final BottomSheetBehavior<View> j() {
        return this.behavior;
    }

    public final boolean k() {
        if (this.behavior.getState() != 4 && this.behavior.getState() != 3) {
            return false;
        }
        return true;
    }

    @NotNull
    public final ArrayList<b> l() {
        return this.stateChangeListener;
    }

    public final void n(@NotNull View container, @NotNull CoordinatorLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.mContentContainer = container;
        container.setClickable(true);
        layoutParams.setBehavior(this.behavior);
        container.setLayoutParams(layoutParams);
        addView(container);
        this.mTitleTv = container.findViewById(R.id.f489721f);
        s(false);
    }

    public final boolean p() {
        if (this.behavior.getState() == 1) {
            return true;
        }
        return false;
    }

    public final void q(int height) {
        s(false);
        setVisibility(0);
        this.behavior.setPeekHeight(height);
        this.behavior.setState(4);
    }

    @Override // android.view.View
    public void setLayoutParams(@Nullable ViewGroup.LayoutParams params) {
        boolean contains$default;
        String Q = uq3.o.Q();
        Intrinsics.checkNotNullExpressionValue(Q, "getCmtPicSelectPageHeightModels()");
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        Integer num = null;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) Q, (CharSequence) MODEL, false, 2, (Object) null);
        if (contains$default) {
            int currentNavigationBarHeight = RFWNavigationBarImmersiveHelper.INSTANCE.getCurrentNavigationBarHeight(getContext());
            if (params != null) {
                params.height = DisplayUtil.getScreenHeight() + currentNavigationBarHeight;
            }
            if (params != null) {
                num = Integer.valueOf(params.height);
            }
            QLog.d("QFSHalfScreenAlbumSheetView", 1, "[adjustLayoutParams] height: " + num + ", navHeight: " + currentNavigationBarHeight);
        }
        super.setLayoutParams(params);
    }

    public /* synthetic */ QFSHalfScreenAlbumSheetView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSHalfScreenAlbumSheetView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.stateChangeListener = new ArrayList<>();
        this.behavior = new BottomSheetBehavior<>();
        this.mStartAnimY = DisplayUtil.dip2px(getContext(), 80.0f);
        this.mTitleFinalHeight = DisplayUtil.dip2px(getContext(), 40.0f);
        m();
    }
}
