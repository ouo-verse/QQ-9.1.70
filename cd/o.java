package cd;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.reborn.comment.bean.QZoneMenuModeView;
import com.qzone.reborn.comment.utils.QZoneSwitchKeyboardHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010)\u00a8\u0006-"}, d2 = {"Lcd/o;", "", "Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "clickViewMenuMode", "", "j", "", "f", "g", "k", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;", "a", "Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;", "getSwitchKeyboardHelper", "()Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;", "switchKeyboardHelper", "b", "Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "d", "()Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "IDLE", "c", "e", tl.h.F, "(Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;)V", "menuMode", "Landroid/view/View;", "Landroid/view/View;", "lastVisibleView", "lastMenuModeView", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "menuViewContainer", "", "[Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "getMenuModeViews", "()[Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;", "i", "([Lcom/qzone/reborn/comment/bean/QZoneMenuModeView;)V", "menuModeViews", "Lcd/e;", "Lcd/e;", "animalHelper", "<init>", "(Lcom/qzone/reborn/comment/utils/QZoneSwitchKeyboardHelper;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QZoneSwitchKeyboardHelper switchKeyboardHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final QZoneMenuModeView IDLE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QZoneMenuModeView menuMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View lastVisibleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneMenuModeView lastMenuModeView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup menuViewContainer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private QZoneMenuModeView[] menuModeViews;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final e animalHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"cd/o$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZoneMenuModeView f30706e;

        b(QZoneMenuModeView qZoneMenuModeView) {
            this.f30706e = qZoneMenuModeView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            o.this.animalHelper.d();
            ViewGroup toggleViewContainer = this.f30706e.getToggleViewContainer();
            if (toggleViewContainer != null && (viewTreeObserver = toggleViewContainer.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            int height = o.this.menuViewContainer.getVisibility() == 8 ? 0 : o.this.menuViewContainer.getHeight();
            o.this.menuViewContainer.setVisibility(0);
            int f16 = o.this.f(this.f30706e);
            if (height != f16) {
                o.this.animalHelper.b(o.this.menuViewContainer, height, f16);
                return;
            }
            ViewGroup.LayoutParams layoutParams = o.this.menuViewContainer.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = f16;
            }
            o.this.menuViewContainer.requestLayout();
        }
    }

    public o(QZoneSwitchKeyboardHelper switchKeyboardHelper) {
        Intrinsics.checkNotNullParameter(switchKeyboardHelper, "switchKeyboardHelper");
        this.switchKeyboardHelper = switchKeyboardHelper;
        QZoneMenuModeView qZoneMenuModeView = new QZoneMenuModeView(null, null);
        this.IDLE = qZoneMenuModeView;
        this.menuMode = qZoneMenuModeView;
        ViewGroup menuViewContainer = switchKeyboardHelper.getMenuViewContainer();
        Intrinsics.checkNotNullExpressionValue(menuViewContainer, "switchKeyboardHelper.menuViewContainer");
        this.menuViewContainer = menuViewContainer;
        this.animalHelper = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int f(QZoneMenuModeView clickViewMenuMode) {
        int i3;
        int i16;
        int i17;
        if (clickViewMenuMode.getToggleViewContainer() == null) {
            return this.menuViewContainer.getPaddingTop() + this.menuViewContainer.getPaddingBottom();
        }
        ViewGroup viewGroup = this.menuViewContainer;
        if (viewGroup instanceof FrameLayout) {
            ViewGroup toggleViewContainer = clickViewMenuMode.getToggleViewContainer();
            Intrinsics.checkNotNull(toggleViewContainer);
            ViewGroup.LayoutParams layoutParams = toggleViewContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            i16 = layoutParams2.topMargin;
            i17 = layoutParams2.bottomMargin;
        } else if (viewGroup instanceof RelativeLayout) {
            ViewGroup toggleViewContainer2 = clickViewMenuMode.getToggleViewContainer();
            Intrinsics.checkNotNull(toggleViewContainer2);
            ViewGroup.LayoutParams layoutParams3 = toggleViewContainer2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            i16 = layoutParams4.topMargin;
            i17 = layoutParams4.bottomMargin;
        } else if (viewGroup instanceof LinearLayout) {
            ViewGroup toggleViewContainer3 = clickViewMenuMode.getToggleViewContainer();
            Intrinsics.checkNotNull(toggleViewContainer3);
            ViewGroup.LayoutParams layoutParams5 = toggleViewContainer3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
            i16 = layoutParams6.topMargin;
            i17 = layoutParams6.bottomMargin;
        } else {
            i3 = 0;
            ViewGroup toggleViewContainer4 = clickViewMenuMode.getToggleViewContainer();
            Intrinsics.checkNotNull(toggleViewContainer4);
            int measuredHeight = toggleViewContainer4.getMeasuredHeight() + this.menuViewContainer.getPaddingTop() + this.menuViewContainer.getPaddingBottom() + i3;
            QLog.i("QZoneToggleMenuHelper", 1, "[getMenuViewEndHeight] endHeight =" + measuredHeight);
            return measuredHeight;
        }
        i3 = i16 + i17;
        ViewGroup toggleViewContainer42 = clickViewMenuMode.getToggleViewContainer();
        Intrinsics.checkNotNull(toggleViewContainer42);
        int measuredHeight2 = toggleViewContainer42.getMeasuredHeight() + this.menuViewContainer.getPaddingTop() + this.menuViewContainer.getPaddingBottom() + i3;
        QLog.i("QZoneToggleMenuHelper", 1, "[getMenuViewEndHeight] endHeight =" + measuredHeight2);
        return measuredHeight2;
    }

    private final void g() {
        QZoneMenuModeView[] qZoneMenuModeViewArr = this.menuModeViews;
        if (qZoneMenuModeViewArr == null) {
            return;
        }
        Intrinsics.checkNotNull(qZoneMenuModeViewArr);
        for (QZoneMenuModeView qZoneMenuModeView : qZoneMenuModeViewArr) {
            ViewGroup toggleViewContainer = qZoneMenuModeView.getToggleViewContainer();
            if (toggleViewContainer != null && toggleViewContainer.getVisibility() == 0) {
                this.lastVisibleView = qZoneMenuModeView.getToggleViewContainer();
                this.lastMenuModeView = qZoneMenuModeView;
            }
        }
    }

    private final void j(QZoneMenuModeView clickViewMenuMode) {
        QZoneSwitchKeyboardHelper.b onKeyboardMenuListener = this.switchKeyboardHelper.getOnKeyboardMenuListener();
        if (onKeyboardMenuListener != null) {
            onKeyboardMenuListener.i4(clickViewMenuMode.getToggleViewContainer());
        }
        if (clickViewMenuMode.getToggleViewContainer() == null) {
            QLog.e("QZoneToggleMenuHelper", 1, "[setSwitchAnim] lastVisibleView =" + this.lastVisibleView);
            return;
        }
        QZoneMenuModeView[] qZoneMenuModeViewArr = this.menuModeViews;
        if (qZoneMenuModeViewArr != null) {
            Intrinsics.checkNotNull(qZoneMenuModeViewArr);
            int length = qZoneMenuModeViewArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                QZoneMenuModeView qZoneMenuModeView = qZoneMenuModeViewArr[i3];
                ViewGroup toggleViewContainer = qZoneMenuModeView.getToggleViewContainer();
                if (toggleViewContainer != null) {
                    toggleViewContainer.setVisibility(clickViewMenuMode == qZoneMenuModeView ? 0 : 8);
                }
            }
        }
        if (this.menuViewContainer.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = this.menuViewContainer.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
            }
            this.menuViewContainer.requestLayout();
        }
        ViewGroup toggleViewContainer2 = clickViewMenuMode.getToggleViewContainer();
        Intrinsics.checkNotNull(toggleViewContainer2);
        toggleViewContainer2.getViewTreeObserver().addOnGlobalLayoutListener(new b(clickViewMenuMode));
    }

    /* renamed from: d, reason: from getter */
    public final QZoneMenuModeView getIDLE() {
        return this.IDLE;
    }

    /* renamed from: e, reason: from getter */
    public final QZoneMenuModeView getMenuMode() {
        return this.menuMode;
    }

    public final void h(QZoneMenuModeView qZoneMenuModeView) {
        Intrinsics.checkNotNullParameter(qZoneMenuModeView, "<set-?>");
        this.menuMode = qZoneMenuModeView;
    }

    public final void i(QZoneMenuModeView[] qZoneMenuModeViewArr) {
        this.menuModeViews = qZoneMenuModeViewArr;
    }

    public final void k(QZoneMenuModeView clickViewMenuMode) {
        Intrinsics.checkNotNullParameter(clickViewMenuMode, "clickViewMenuMode");
        QLog.i("QZoneToggleMenuHelper", 1, "[switchMenu] clickViewMenuMode =" + clickViewMenuMode);
        g();
        QZoneMenuModeView qZoneMenuModeView = this.menuMode;
        if (qZoneMenuModeView == this.IDLE) {
            this.menuMode = clickViewMenuMode;
            this.switchKeyboardHelper.E();
            j(clickViewMenuMode);
        } else if (qZoneMenuModeView != clickViewMenuMode) {
            this.switchKeyboardHelper.z(true);
            this.menuMode = clickViewMenuMode;
            j(clickViewMenuMode);
        } else if (this.switchKeyboardHelper.E()) {
            j(clickViewMenuMode);
        } else {
            this.switchKeyboardHelper.C();
        }
    }
}
