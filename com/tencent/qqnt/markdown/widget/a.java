package com.tencent.qqnt.markdown.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.tip.QUICustomBubbleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010$\u001a\u00020 \u0012\u0006\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u00106J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u0013R\u0017\u0010$\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010.R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010.R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010.R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010.R\u0018\u00104\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/markdown/widget/a;", "", "Landroid/widget/PopupWindow;", "popupWindow", "Landroid/view/View;", "anchor", "", "vertPos", "horizPos", "transX", "transY", "", "d", "measureSpec", "maxSize", "c", "b", "a", "anchorView", "", "e", "color", h.F, "xOffsetPx", "yOffsetPx", "f", "xArrowOffset", "g", "Landroid/view/View$OnClickListener;", "clickListener", "i", "j", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/View;", "contentView", "Landroid/widget/PopupWindow;", "Lcom/tencent/mobileqq/widget/tip/QUICustomBubbleView;", "Lcom/tencent/mobileqq/widget/tip/QUICustomBubbleView;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "I", "backgroundColor", "xOffset", "yOffset", "k", "Landroid/view/View$OnClickListener;", "onClickListener", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View contentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PopupWindow popupWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUICustomBubbleView rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintLayout container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int backgroundColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View anchorView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int xOffset;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int yOffset;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int xArrowOffset;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener onClickListener;

    public a(@NotNull Context context, @NotNull View contentView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) contentView);
            return;
        }
        this.context = context;
        this.contentView = contentView;
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setSoftInputMode(1);
        popupWindow.setInputMethodMode(2);
        this.popupWindow = popupWindow;
        QUICustomBubbleView qUICustomBubbleView = new QUICustomBubbleView(context);
        qUICustomBubbleView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.rootView = qUICustomBubbleView;
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.container = constraintLayout;
    }

    private final int a(int measureSpec) {
        if (measureSpec == -2) {
            return 0;
        }
        return 1073741824;
    }

    private final int b(int measureSpec, int maxSize) {
        if (measureSpec != -1) {
            return View.MeasureSpec.getSize(measureSpec);
        }
        return maxSize;
    }

    private final int c(int measureSpec, int maxSize) {
        return View.MeasureSpec.makeMeasureSpec(b(measureSpec, maxSize), a(measureSpec));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int[] d(PopupWindow popupWindow, View anchor, int vertPos, int horizPos, int transX, int transY) {
        int height;
        int i3;
        int width;
        popupWindow.setClippingEnabled(true);
        View contentView = popupWindow.getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView, "popupWindow.getContentView()");
        Rect rect = new Rect();
        contentView.getWindowVisibleDisplayFrame(rect);
        contentView.measure(c(popupWindow.getWidth(), rect.width()), c(popupWindow.getHeight(), rect.height()));
        int measuredWidth = contentView.getMeasuredWidth();
        int measuredHeight = contentView.getMeasuredHeight();
        anchor.getLocationInWindow(new int[2]);
        if (vertPos != 0) {
            if (vertPos != 1) {
                if (vertPos != 3) {
                    if (vertPos != 4) {
                        i3 = 0;
                        if (horizPos != 0) {
                            if (horizPos != 1) {
                                if (horizPos != 2) {
                                    if (horizPos != 4) {
                                        width = 0;
                                    } else {
                                        measuredWidth -= anchor.getWidth();
                                    }
                                } else {
                                    width = anchor.getWidth() + 0;
                                }
                            }
                            width = 0 - measuredWidth;
                        } else {
                            width = ((anchor.getWidth() / 2) - (measuredWidth / 2)) + 0;
                        }
                        return new int[]{width + transX, i3 + transY};
                    }
                } else {
                    height = anchor.getHeight();
                }
            } else {
                measuredHeight += anchor.getHeight();
            }
            i3 = 0 - measuredHeight;
            if (horizPos != 0) {
            }
            return new int[]{width + transX, i3 + transY};
        }
        height = (anchor.getHeight() / 2) + (measuredHeight / 2);
        i3 = 0 - height;
        if (horizPos != 0) {
        }
        return new int[]{width + transX, i3 + transY};
    }

    public final void e(@NotNull View anchorView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anchorView);
        } else {
            Intrinsics.checkNotNullParameter(anchorView, "anchorView");
            this.anchorView = anchorView;
        }
    }

    public final void f(int xOffsetPx, int yOffsetPx) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(xOffsetPx), Integer.valueOf(yOffsetPx));
        } else {
            this.xOffset = xOffsetPx;
            this.yOffset = yOffsetPx;
        }
    }

    public final void g(int xArrowOffset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, xArrowOffset);
        } else {
            this.xArrowOffset = xArrowOffset;
        }
    }

    public final void h(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, color);
        } else {
            this.backgroundColor = color;
        }
    }

    public final void i(@NotNull View.OnClickListener clickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) clickListener);
        } else {
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.onClickListener = clickListener;
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        View view = this.anchorView;
        if (view == null) {
            return;
        }
        this.rootView.setBubbleColor(this.backgroundColor);
        this.rootView.setArrowPosition(0);
        this.rootView.setOnClickListener(this.onClickListener);
        this.rootView.setEnableShadow(true);
        ViewParent parent = this.contentView.getParent();
        ViewGroup viewGroup2 = null;
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this.contentView);
        }
        ViewParent parent2 = this.container.getParent();
        if (parent2 instanceof ViewGroup) {
            viewGroup2 = (ViewGroup) parent2;
        }
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.container);
        }
        this.container.addView(this.contentView);
        this.rootView.addView(this.container);
        this.rootView.setPadding(0, 0, 0, ViewUtils.dpToPx(6.0f));
        this.popupWindow.setContentView(this.rootView);
        int[] d16 = d(this.popupWindow, view, 1, 3, this.xOffset, this.yOffset);
        this.rootView.setArrowOffsetX(this.xArrowOffset);
        this.popupWindow.showAsDropDown(view, d16[0], d16[1]);
    }
}
