package com.tencent.mobileqq.qwallet.publicaccount.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.publicaccount.conf.QWalletPAConfBean;
import com.tencent.mobileqq.qwallet.publicaccount.conf.TabItem;
import com.tencent.mobileqq.qwallet.publicaccount.conf.TabLevel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u0018\u0018\u0000 \u00052\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/publicaccount/controller/TabLayoutController;", "", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/QWalletPAConfBean;", "confBean", "", "f", "g", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "tabLayout", "", "b", "Z", "isClicked", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/TabItem;", "Lcom/tencent/mobileqq/qwallet/publicaccount/controller/TabItemController;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "itemControllers", "d", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/QWalletPAConfBean;", "com/tencent/mobileqq/qwallet/publicaccount/controller/TabLayoutController$b", "e", "Lcom/tencent/mobileqq/qwallet/publicaccount/controller/TabLayoutController$b;", "tabClickListener", "<init>", "(Landroid/widget/LinearLayout;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class TabLayoutController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout tabLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isClicked;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<TabItem, TabItemController> itemControllers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QWalletPAConfBean confBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b tabClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/publicaccount/controller/TabLayoutController$b", "Lcom/tencent/mobileqq/qwallet/publicaccount/controller/a;", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/TabItem;", "tabItem", "", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.mobileqq.qwallet.publicaccount.controller.a
        public void a(@NotNull TabItem tabItem) {
            boolean startsWith;
            boolean startsWith2;
            boolean startsWith3;
            Intrinsics.checkNotNullParameter(tabItem, "tabItem");
            TabLayoutController.this.isClicked = true;
            TabLevel tabLevel = tabItem.getTabLevel();
            TabLevel tabLevel2 = TabLevel.TAB;
            if (tabLevel == tabLevel2) {
                com.tencent.mobileqq.qwallet.c.e("public.mywallet.click", "", String.valueOf(tabItem.getTabId()), tabItem.getName(), AppSetting.getSubVersion());
            } else {
                com.tencent.mobileqq.qwallet.c.e("public.bottom_drawer_sub.click", "", String.valueOf(tabItem.getTabId()), tabItem.getName(), AppSetting.getSubVersion());
            }
            if (tabItem.getTabLevel() == tabLevel2 && (!tabItem.getSheetList().isEmpty())) {
                TabItemController tabItemController = (TabItemController) TabLayoutController.this.itemControllers.get(tabItem);
                if (tabItemController != null) {
                    tabItemController.i();
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
                        QLog.e("TabLayoutController", 1, "config link url is error: " + linkUrl);
                        return;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("key_url_source", INewQWalletApi.QWALLET_SECURITY_WEB_URL_SOURCE);
                ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doStartBrowser(TabLayoutController.this.tabLayout.getContext(), linkUrl, bundle);
                return;
            }
            ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doJumpAction(TabLayoutController.this.tabLayout.getContext(), linkUrl);
        }
    }

    public TabLayoutController(@NotNull LinearLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.tabLayout = tabLayout;
        this.itemControllers = new HashMap<>();
        this.tabClickListener = new b();
    }

    public final void f(@NotNull QWalletPAConfBean confBean) {
        Intrinsics.checkNotNullParameter(confBean, "confBean");
        this.confBean = confBean;
        for (TabItem tabItem : confBean.getTabItems()) {
            View inflate = LayoutInflater.from(this.tabLayout.getContext()).inflate(R.layout.hjm, (ViewGroup) this.tabLayout, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tabLayout.context).\u2026b_item, tabLayout, false)");
            this.tabLayout.addView(inflate);
            TabItemController tabItemController = new TabItemController(inflate, tabItem);
            tabItemController.h(this.tabClickListener);
            this.itemControllers.put(tabItem, tabItemController);
            com.tencent.mobileqq.qwallet.c.e("public.mywallet.show", "", String.valueOf(tabItem.getTabId()), tabItem.getName(), AppSetting.getSubVersion());
        }
        this.tabLayout.setWeightSum(r6.getChildCount());
    }

    public final void g() {
        com.tencent.mobileqq.qwallet.publicaccount.conf.a.f279114a.f(new Function2<Boolean, QWalletPAConfBean, Unit>() { // from class: com.tencent.mobileqq.qwallet.publicaccount.controller.TabLayoutController$updateTabItemList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, QWalletPAConfBean qWalletPAConfBean) {
                invoke(bool.booleanValue(), qWalletPAConfBean);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable QWalletPAConfBean qWalletPAConfBean) {
                boolean z17;
                QWalletPAConfBean qWalletPAConfBean2;
                z17 = TabLayoutController.this.isClicked;
                if (!z17) {
                    Context context = TabLayoutController.this.tabLayout.getContext();
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    boolean z18 = false;
                    if (activity != null && !activity.isFinishing()) {
                        z18 = true;
                    }
                    if (!z18) {
                        QLog.i("TabLayoutController", 1, "pa config no update:is finish");
                        return;
                    }
                    if (z16 && qWalletPAConfBean != null && !qWalletPAConfBean.getTabItems().isEmpty()) {
                        qWalletPAConfBean2 = TabLayoutController.this.confBean;
                        if (!Intrinsics.areEqual(qWalletPAConfBean, qWalletPAConfBean2)) {
                            TabLayoutController.this.tabLayout.removeAllViews();
                            Iterator it = TabLayoutController.this.itemControllers.entrySet().iterator();
                            while (it.hasNext()) {
                                ((TabItemController) ((Map.Entry) it.next()).getValue()).g();
                            }
                            TabLayoutController.this.itemControllers.clear();
                            TabLayoutController.this.f(qWalletPAConfBean);
                            return;
                        }
                        QLog.i("TabLayoutController", 2, "pa config no update: is same");
                        return;
                    }
                    QLog.e("TabLayoutController", 1, "pa config no update:is update on fail");
                    return;
                }
                QLog.i("TabLayoutController", 1, "pa config no update:is user clicked");
            }
        });
    }
}
