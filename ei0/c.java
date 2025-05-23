package ei0;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import ck0.Product;
import com.tencent.ecommerce.base.report.service.f;
import com.tencent.ecommerce.repo.live.ActivityStatus;
import com.tencent.ecommerce.repo.live.ECShopExt;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0010J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0010J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u001e\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0010J&\u0010'\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010%2\u0006\u0010\n\u001a\u00020\tJ&\u0010(\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010%2\u0006\u0010\n\u001a\u00020\t\u00a8\u0006+"}, d2 = {"Lei0/c;", "", "Lck0/c;", "product", "", "a", "Landroidx/fragment/app/Fragment;", "fragment", "event", "", "windowType", "", "g", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Landroid/view/View;", "addProductBtn", "i", "searchBar", "query", "p", h.F, "confirmBtn", "l", "cancelBtn", "k", "btn", "d", "c", "productListView", "Landroid/os/Bundle;", "args", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "view", DomainData.DOMAIN_NAME, "j", "", "list", "e", "f", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f396302a = new c();

    c() {
    }

    private final String a(Product product) {
        if (product.getState() != 1) {
            return "3";
        }
        if (product.getInventory() <= 0) {
            return "2";
        }
        return "1";
    }

    private final int b(int windowType) {
        if (windowType == 3 || windowType != 4) {
            return 0;
        }
        return 2;
    }

    private final void g(Fragment fragment, String event, Product product, int windowType) {
        String str;
        String str2;
        LiveActivity liveActivity;
        ActivityStatus activityStatus;
        com.tencent.ecommerce.base.report.service.d a16 = com.tencent.ecommerce.base.report.service.e.INSTANCE.c(fragment).g().h("em_qqlive_sure_button").a("qqlive_commodity_name", product.getTitle()).a("qqlive_commodity_name", product.getTitle()).a("qqlive_commodity_price", String.valueOf(product.getPrice())).a("qqlive_commodity_sales", String.valueOf(product.getSales())).a("qqlive_product_inventory_status", a(product)).a("qqlive_product_state", a(product)).a("qqlive_item_id", product.getMediaProductId()).a("qqlive_product_type", String.valueOf(b(windowType)));
        if (Product.INSTANCE.c(product)) {
            str = "1";
        } else {
            str = "0";
        }
        com.tencent.ecommerce.base.report.service.d a17 = a16.a("qqlive_activity_product", str);
        ECShopExt liveShopExt = product.getLiveShopExt();
        if (liveShopExt == null || (liveActivity = liveShopExt.activity) == null || (activityStatus = liveActivity.getActivityStatus()) == null || (str2 = String.valueOf(activityStatus.value)) == null) {
            str2 = "";
        }
        a17.a("qqlive_activity_status", str2).f(event);
    }

    public final void c(View btn) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(btn).g().f("dt_clck");
    }

    public final void d(View btn) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(btn).g().f("dt_imp");
    }

    public final void h(View searchBar, String query) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(searchBar).g().a("qqlive_search_words", query).f(DTEventKey.SUBMIT);
    }

    public final void i(View addProductBtn) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(addProductBtn).g().h("em_qqlive_shop_button").i();
    }

    public final void j(View view) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_sure_button").i();
    }

    public final void k(View cancelBtn) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(cancelBtn).g().h("em_qqlive_operate_no_save").i();
        d(cancelBtn);
    }

    public final void l(View confirmBtn) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(confirmBtn).g().h("em_qqlive_operate_save").i();
        d(confirmBtn);
    }

    public final void m(View productListView, Bundle args) {
        String str;
        String string;
        f h16 = com.tencent.ecommerce.base.report.service.e.INSTANCE.d(productListView).g().h("em_qqlive_my_window_list");
        String str2 = "";
        if (args == null || (str = args.getString("shop_id")) == null) {
            str = "";
        }
        f a16 = h16.a("qqlive_store_name", str);
        if (args != null && (string = args.getString("shop_name")) != null) {
            str2 = string;
        }
        a16.a("qqlive_store_id", str2).i();
    }

    public final void n(View view, Product product, int windowType) {
        String str;
        String str2;
        LiveActivity liveActivity;
        ActivityStatus activityStatus;
        f a16 = com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_shop_select").j(product.getMediaProductId()).a("qqlive_commodity_name", product.getTitle()).a("qqlive_commodity_price", String.valueOf(product.getPrice())).a("qqlive_commodity_sales", String.valueOf(product.getSales())).a("qqlive_product_inventory_status", a(product)).a("qqlive_product_state", a(product)).a("qqlive_item_id", product.getMediaProductId()).a("qqlive_product_type", String.valueOf(b(windowType)));
        if (Product.INSTANCE.c(product)) {
            str = "1";
        } else {
            str = "0";
        }
        f a17 = a16.a("qqlive_activity_product", str);
        ECShopExt liveShopExt = product.getLiveShopExt();
        if (liveShopExt == null || (liveActivity = liveShopExt.activity) == null || (activityStatus = liveActivity.getActivityStatus()) == null || (str2 = String.valueOf(activityStatus.value)) == null) {
            str2 = "";
        }
        a17.a("qqlive_activity_status", str2).i();
    }

    public final void o(Fragment fragment) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.c(fragment).g().h("pg_qqlive_add_product_page").j(true).i();
    }

    public final void p(View searchBar, String query) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(searchBar).g().h("em_qqlive_shop_search").a("qqlive_search_words", query).i();
    }

    public final void q(Fragment fragment) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.c(fragment).g().h("pg_qqlive_store_add_product_page").j(true).i();
    }

    public final void e(Fragment fragment, List<Product> list, int windowType) {
        if (list != null) {
            Iterator<Product> it = list.iterator();
            while (it.hasNext()) {
                f396302a.g(fragment, "ev_qqlive_anchor_product_add", it.next(), windowType);
            }
        }
    }

    public final void f(Fragment fragment, List<Product> list, int windowType) {
        if (list != null) {
            Iterator<Product> it = list.iterator();
            while (it.hasNext()) {
                f396302a.g(fragment, "ev_qqlive_anchor_product_delete", it.next(), windowType);
            }
        }
    }
}
