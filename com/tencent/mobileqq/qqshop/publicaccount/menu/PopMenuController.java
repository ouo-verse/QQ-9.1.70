package com.tencent.mobileqq.qqshop.publicaccount.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.LifecycleObserver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopMenuLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u001c\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001c\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/PopMenuController;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/view/View;", "anchor", "", "j", "d", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$b;", "tabClickListener", "i", "Landroid/widget/PopupWindow$OnDismissListener;", "listener", tl.h.F, "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "Landroid/view/LayoutInflater;", "mInflater", "e", "Landroid/view/View;", "mRootView", "f", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$b;", "onTabClickListener", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "mWindow", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "menuContainer", "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;", "sheetList", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"InflateParams"})
/* loaded from: classes17.dex */
public final class PopMenuController implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater mInflater;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQShopMenuLayout.b onTabClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final PopupWindow mWindow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup menuContainer;

    public PopMenuController(@Nullable Context context, @NotNull List<MenuItem> sheetList) {
        Intrinsics.checkNotNullParameter(sheetList, "sheetList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) sheetList);
            return;
        }
        LayoutInflater from = LayoutInflater.from(context);
        this.mInflater = from;
        View inflate = from.inflate(R.layout.h4s, (ViewGroup) null);
        this.mRootView = inflate;
        final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean g16;
                g16 = PopMenuController.g(popupWindow, view, motionEvent);
                return g16;
            }
        });
        popupWindow.setBackgroundDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);
        this.mWindow = popupWindow;
        View findViewById = inflate.findViewById(R.id.epy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<L\u2026out>(R.id.menu_container)");
        this.menuContainer = (ViewGroup) findViewById;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f164476z2);
        imageView.setColorFilter(imageView.getResources().getColor(R.color.qui_common_bg_middle_light, null));
        for (final MenuItem menuItem : sheetList) {
            ViewGroup viewGroup = this.menuContainer;
            View inflate2 = this.mInflater.inflate(R.layout.h4t, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.eqi)).setText(menuItem.getName());
            inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PopMenuController.e(PopMenuController.this, menuItem, view);
                }
            });
            viewGroup.addView(inflate2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final PopMenuController this$0, MenuItem sheetItem, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheetItem, "$sheetItem");
        Intrinsics.checkNotNullParameter(v3, "v");
        QQShopMenuLayout.b bVar = this$0.onTabClickListener;
        if (bVar != null) {
            bVar.a(sheetItem);
        }
        v3.post(new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.f
            @Override // java.lang.Runnable
            public final void run() {
                PopMenuController.f(PopMenuController.this);
            }
        });
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PopMenuController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(PopupWindow this_apply, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (motionEvent.getAction() == 4) {
            this_apply.dismiss();
            return true;
        }
        return false;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.mWindow.isShowing()) {
            this.mWindow.dismiss();
        }
    }

    public final void h(@NotNull PopupWindow.OnDismissListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mWindow.setOnDismissListener(listener);
        }
    }

    public final void i(@Nullable QQShopMenuLayout.b tabClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tabClickListener);
        } else {
            this.onTabClickListener = tabClickListener;
        }
    }

    public final void j(@NotNull View anchor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anchor);
            return;
        }
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        int[] iArr = new int[2];
        anchor.getLocationInWindow(iArr);
        int i3 = iArr[0];
        Rect rect = new Rect(i3, iArr[1], anchor.getWidth() + i3, iArr[1] + anchor.getHeight());
        this.mRootView.measure(-2, -2);
        int measuredWidth = this.mRootView.getMeasuredWidth();
        int measuredHeight = this.mRootView.getMeasuredHeight();
        int width = iArr[0] + ((anchor.getWidth() - measuredWidth) / 2);
        int i16 = rect.top - measuredHeight;
        this.mWindow.setAnimationStyle(R.style.azc);
        this.mWindow.showAtLocation(anchor, 0, width, i16);
    }
}
