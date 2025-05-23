package com.tencent.mobileqq.qqshop.publicaccount.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0017\u0018\u0000 \"2\u00020\u0001:\u0002#$B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout;", "Landroid/widget/LinearLayout;", "", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;", "tabItems", "", "c", "", "resId", "d", "e", "Lcom/tencent/mobileqq/qqshop/publicaccount/d$a;", MiniChatConstants.MINI_APP_MENU_STYLE, "f", "", "Z", "isClicked", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItemController;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "itemControllers", "Ljava/util/List;", "com/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$c", tl.h.F, "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$c;", "tabClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "b", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopMenuLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isClicked;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<MenuItem, MenuItemController> itemControllers;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<MenuItem> tabItems;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c tabClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopMenuLayout$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$b;", "", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;", "tabItem", "", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NotNull MenuItem tabItem);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$c", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/QQShopMenuLayout$b;", "Lcom/tencent/mobileqq/qqshop/publicaccount/menu/MenuItem;", "tabItem", "", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f274609b;

        c(Context context) {
            this.f274609b = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQShopMenuLayout.this, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopMenuLayout.b
        public void a(@NotNull MenuItem tabItem) {
            HashMap<String, String> hashMapOf;
            boolean startsWith;
            boolean startsWith2;
            boolean startsWith3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tabItem);
                return;
            }
            Intrinsics.checkNotNullParameter(tabItem, "tabItem");
            QQShopMenuLayout.this.isClicked = true;
            com.tencent.mobileqq.qqshop.report.beacon.b bVar = com.tencent.mobileqq.qqshop.report.beacon.b.f274709a;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ext1", tabItem.getName()));
            bVar.b("qgg_gzh_lifeselection_bottom_tab_click", hashMapOf);
            if (tabItem.getTabLevel() == TabLevel.TAB && (!tabItem.getSheetList().isEmpty())) {
                MenuItemController menuItemController = (MenuItemController) QQShopMenuLayout.this.itemControllers.get(tabItem);
                if (menuItemController != null) {
                    menuItemController.l();
                    return;
                }
                return;
            }
            String linkUrl = tabItem.getLinkUrl();
            startsWith = StringsKt__StringsJVMKt.startsWith(linkUrl, SchemaUtils.SCHEMA_MQQAPI, true);
            if (!startsWith) {
                startsWith2 = StringsKt__StringsJVMKt.startsWith(linkUrl, "http", true);
                if (!startsWith2) {
                    startsWith3 = StringsKt__StringsJVMKt.startsWith(linkUrl, "https", true);
                    if (!startsWith3) {
                        QLog.e("QQShopMenuLayout", 1, "config link url is error: " + linkUrl);
                        return;
                    }
                }
                ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doStartBrowser(this.f274609b, linkUrl, new Bundle());
                return;
            }
            ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doJumpAction(this.f274609b, linkUrl);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31451);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQShopMenuLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    private final void c(List<MenuItem> tabItems) {
        this.tabItems = tabItems;
        for (MenuItem menuItem : tabItems) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h4r, (ViewGroup) this, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026a_menu_item, this, false)");
            addView(inflate, new LinearLayout.LayoutParams(-1, -1, 1.0f));
            MenuItemController menuItemController = new MenuItemController(inflate, menuItem);
            menuItemController.k(this.tabClickListener);
            this.itemControllers.put(menuItem, menuItemController);
        }
        setWeightSum(getChildCount());
    }

    private final void d(int resId) {
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        setBackgroundResource(resId);
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void e(@NotNull List<MenuItem> tabItems) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tabItems);
            return;
        }
        Intrinsics.checkNotNullParameter(tabItems, "tabItems");
        if (this.isClicked) {
            QLog.i("QQShopMenuLayout", 1, "pa config no update:is user clicked");
            return;
        }
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (!z16) {
            QLog.i("QQShopMenuLayout", 1, "pa config no update:is finish");
            return;
        }
        if (Intrinsics.areEqual(tabItems, this.tabItems)) {
            QLog.i("QQShopMenuLayout", 2, "pa config no update: is same");
            return;
        }
        removeAllViews();
        Iterator<Map.Entry<MenuItem, MenuItemController>> it = this.itemControllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().i();
        }
        this.itemControllers.clear();
        c(tabItems);
    }

    public final void f(@NotNull d.a menuStyle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) menuStyle);
            return;
        }
        Intrinsics.checkNotNullParameter(menuStyle, "menuStyle");
        if (!menuStyle.d()) {
            i16 = 0;
        }
        setVisibility(i16);
        if (menuStyle.e()) {
            if (QQTheme.isVasTheme()) {
                i3 = R.drawable.skin_aio_input_bar_bg_theme_version2;
            } else {
                i3 = R.drawable.qui_common_bg_nav_bottom_aio_bg;
            }
            d(i3);
        } else {
            setBackgroundColor(menuStyle.a());
        }
        Iterator<Map.Entry<MenuItem, MenuItemController>> it = this.itemControllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().j(menuStyle);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQShopMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ QQShopMenuLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQShopMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.itemControllers = new HashMap<>();
            this.tabClickListener = new c(context);
        }
    }
}
