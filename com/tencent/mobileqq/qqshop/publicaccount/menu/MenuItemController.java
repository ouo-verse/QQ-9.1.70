package com.tencent.mobileqq.qqshop.publicaccount.menu;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.d;
import com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopMenuLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b\"\u0010-R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItemController;", "Landroidx/lifecycle/LifecycleObserver;", "", "isSelected", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "drawableId", "color", "Landroid/graphics/drawable/Drawable;", "f", "drawable", "g", "Lcom/tencent/mobileqq/qqshop/publicaccount/d$a;", MiniChatConstants.MINI_APP_MENU_STYLE, "j", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$b;", "tabClickListener", "k", "l", "i", "Landroid/view/View;", "d", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;", "e", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;", "tabItem", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "iconImg", "iconArrow", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqshop/publicaccount/d$a;", "currentMenuStyle", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/PopMenuController;", "D", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qqshop/publicaccount/menu/PopMenuController;", "popupMenuController", "E", "Z", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;)V", UserInfo.SEX_FEMALE, "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class MenuItemController implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private d.a currentMenuStyle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy popupMenuController;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isSelected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MenuItem tabItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconImg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconArrow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQShopMenuLayout.b tabClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItemController$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.menu.MenuItemController$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MenuItemController(@NotNull View itemView, @NotNull MenuItem tabItem) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(tabItem, "tabItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) tabItem);
            return;
        }
        this.itemView = itemView;
        this.tabItem = tabItem;
        View findViewById = itemView.findViewById(R.id.md8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_item_title)");
        TextView textView = (TextView) findViewById;
        this.titleView = textView;
        View findViewById2 = itemView.findViewById(R.id.f165781xk3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.img_item_icon)");
        ImageView imageView = (ImageView) findViewById2;
        this.iconImg = imageView;
        View findViewById3 = itemView.findViewById(R.id.f165780xk2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.img_item_arrow)");
        this.iconArrow = (ImageView) findViewById3;
        this.currentMenuStyle = com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.g();
        lazy = LazyKt__LazyJVMKt.lazy(new MenuItemController$popupMenuController$2(this));
        this.popupMenuController = lazy;
        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(tabItem.getIconUrl(), com.tencent.mobileqq.urldrawable.b.f306350a));
        textView.setText(tabItem.getName());
        m(false);
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.menu.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuItemController.b(MenuItemController.this, view);
            }
        });
        Context context = itemView.getContext();
        if (context instanceof ComponentActivity) {
            ((ComponentActivity) context).getLifecycle().addObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MenuItemController this$0, View view) {
        QQShopMenuLayout.b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isSelected && (bVar = this$0.tabClickListener) != null) {
            bVar.a(this$0.tabItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Drawable f(@DrawableRes int drawableId, int color) {
        Drawable mutate;
        String str;
        Drawable drawable = ResourcesCompat.getDrawable(this.itemView.getContext().getResources(), drawableId, this.itemView.getContext().getTheme());
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
            str = "drawable.mutate2()";
        } else {
            mutate = drawable.mutate();
            str = "drawable.mutate()";
        }
        Intrinsics.checkNotNullExpressionValue(mutate, str);
        mutate.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        return mutate;
    }

    private final Drawable g(Drawable drawable, int color) {
        Drawable mutate;
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
        } else {
            mutate = drawable.mutate();
        }
        mutate.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        return mutate;
    }

    private final PopMenuController h() {
        return (PopMenuController) this.popupMenuController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(boolean isSelected) {
        int b16;
        boolean z16;
        int i3;
        if (isSelected) {
            b16 = this.currentMenuStyle.c();
        } else {
            b16 = this.currentMenuStyle.b();
        }
        String iconUrl = this.tabItem.getIconUrl();
        int i16 = 0;
        if (iconUrl != null && iconUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            URLDrawable netDrawableForAIO = QWalletPicHelper.getNetDrawableForAIO(this.tabItem.getIconUrl(), com.tencent.mobileqq.urldrawable.b.f306350a);
            if (netDrawableForAIO != null) {
                this.iconImg.setImageDrawable(g(netDrawableForAIO, b16));
                this.iconImg.setVisibility(0);
            }
        } else {
            this.iconImg.setVisibility(8);
        }
        this.titleView.setTextColor(b16);
        ImageView imageView = this.iconArrow;
        if (!(true ^ this.tabItem.getSheetList().isEmpty())) {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        if (isSelected) {
            i3 = R.drawable.nwf;
        } else {
            i3 = R.drawable.nwe;
        }
        this.iconArrow.setImageDrawable(f(i3, b16));
        this.isSelected = isSelected;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        h().d();
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Context context = this.itemView.getContext();
        if (context instanceof ComponentActivity) {
            ((ComponentActivity) context).getLifecycle().removeObserver(this);
        }
    }

    public final void j(@NotNull d.a menuStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) menuStyle);
            return;
        }
        Intrinsics.checkNotNullParameter(menuStyle, "menuStyle");
        this.currentMenuStyle = menuStyle;
        m(this.isSelected);
    }

    public final void k(@NotNull QQShopMenuLayout.b tabClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tabClickListener);
            return;
        }
        Intrinsics.checkNotNullParameter(tabClickListener, "tabClickListener");
        this.tabClickListener = tabClickListener;
        h().i(tabClickListener);
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            h().j(this.itemView);
            m(true);
        }
    }
}
