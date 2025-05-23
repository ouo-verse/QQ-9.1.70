package ei0;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.e;
import com.tencent.ecommerce.base.report.service.f;
import com.tencent.ecommerce.base.report.service.g;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.live.ui.ECLiveWindowMainFragment;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.util.PerfTracer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bJ.\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bJ6\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0004J>\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0018J\u0016\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!J\u0016\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010&\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fJ\u0018\u0010(\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010,\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020.2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u00100\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u00101\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fJ\u000e\u00102\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fJ\u000e\u00103\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fJ.\u00104\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J.\u00105\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u00108\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u00107\u00a8\u0006;"}, d2 = {"Lei0/d;", "", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "", "o", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "authorUin", "roomID", "programID", "liveType", "y", "action", "uin", "", "errorCode", "errorMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "curPlayTime", HippyTKDListViewAdapter.X, "v", "", "isButton", "w", "Landroidx/fragment/app/Fragment;", "fragment", "isMaster", "p", "Landroid/view/View;", "view", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "i", "a", h.F, "k", "e", "j", "g", "b", "f", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowMainFragment;", "t", "u", "l", "c", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "Ljava/util/Map;", "exposureMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final d f396304b = new d();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Long> exposureMap = new LinkedHashMap();

    d() {
    }

    private final int o(LiveProduct liveProduct) {
        if (liveProduct.getInventory() <= 0) {
            return 2;
        }
        return liveProduct.getStatus() == 1 ? 1 : 3;
    }

    public final void A(LiveProduct liveProduct) {
        exposureMap.put(liveProduct.getMediaProductId(), Long.valueOf(System.currentTimeMillis()));
    }

    public final void a(View view) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_product_add_button").i();
    }

    public final void c(View view) {
        e.Companion companion = com.tencent.ecommerce.base.report.service.e.INSTANCE;
        companion.d(view).g().h("em_qqlive_cancel_delete_shop").i();
        companion.d(view).g().f("dt_imp");
    }

    public final void d(View view) {
        e.Companion companion = com.tencent.ecommerce.base.report.service.e.INSTANCE;
        companion.d(view).g().h("em_qqlive_delete_shop").i();
        companion.d(view).g().f("dt_imp");
    }

    public final void h(View view) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_product_list").i();
    }

    public final void i(View view) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_product_manage_button").i();
    }

    public final void l(View view) {
        e.Companion companion = com.tencent.ecommerce.base.report.service.e.INSTANCE;
        companion.d(view).g().h("em_qqlive_shop_top").i();
        companion.d(view).g().f("dt_imp");
    }

    public final void m(View view, LiveTabId tabId) {
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_product_tab").a("qqlive_product_type", String.valueOf(tabId.getValue())).a("qqlive_tab_name", String.valueOf(tabId.getValue())).i();
        cg0.a.b("ECLiveWindowReporter", "bindTab view:" + view + " tabId:" + tabId);
    }

    public final void n(View view, LiveTabId tabId) {
        cg0.a.b("ECLiveWindowReporter", "clickTab tabId:" + tabId);
        com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_product_tab").a("qqlive_product_type", String.valueOf(tabId.getValue())).a("qqlive_tab_name", String.valueOf(tabId.getValue())).f("dt_clck");
    }

    public final void p(Fragment fragment, boolean isMaster) {
        String str;
        com.tencent.ecommerce.base.report.service.d g16 = com.tencent.ecommerce.base.report.service.e.INSTANCE.c(fragment).g();
        if (isMaster) {
            str = "pg_qqlive_product_page";
        } else {
            str = "pg_qqlive_audience_product";
        }
        g16.h(str).j(true).i();
    }

    public final void q(String authorUin, String roomID, String programID, int liveType, LiveProduct liveProduct) {
        String str;
        com.tencent.ecommerce.biz.common.e b16 = new com.tencent.ecommerce.biz.common.e().a("8").b("author_uin", authorUin).b(AudienceReportConst.ROOM_ID, roomID).b("program_id", programID).b("live_type", String.valueOf(liveType));
        if (liveProduct.getIsExplaining()) {
            str = "1";
        } else {
            str = "2";
        }
        g.d("ds_live_goods_author_explain", b16.b("explain_type", str).b("saas_id", liveProduct.getSaasTypeStr()).b("product_price", liveProduct.getPrice().pricesTxt).b(ReportDataBuilder.KEY_PRODUCT_ID, liveProduct.getSaasProductId()).b("product_name", liveProduct.getTitle()).b("product_number", String.valueOf(liveProduct.getIndex())).f());
    }

    public final void r(String authorUin, String roomID, String programID, int liveType, LiveProduct liveProduct) {
        g.d("ds_live_goods_audience_goodsexpo", new com.tencent.ecommerce.biz.common.e().a("8").b("author_uin", authorUin).b(AudienceReportConst.ROOM_ID, roomID).b("program_id", programID).b("live_type", String.valueOf(liveType)).b("saas_id", liveProduct.getSaasTypeStr()).b("product_price", liveProduct.getPrice().pricesTxt).b(ReportDataBuilder.KEY_PRODUCT_ID, liveProduct.getSaasProductId()).b("product_name", liveProduct.getTitle()).b("product_number", String.valueOf(liveProduct.getIndex())).b("expo_from", "2").f());
    }

    public final void s(String uin, long roomID, String programID, int errorCode, String errorMsg) {
        Map<Object, Object> f16 = new com.tencent.ecommerce.biz.common.e().b("uin", uin).b(AudienceReportConst.ROOM_ID, String.valueOf(roomID)).b("program_id", programID).b("error_code", String.valueOf(errorCode)).b("error_msg", errorMsg).f();
        cg0.a.b("ECLiveWindowReporter", "[reportAnchorExplainError] eventCode = qlive_anchor_explain_error, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qlive_anchor_explain_error", f16, false, 4, null);
    }

    public final void v(String authorUin, long roomID, int liveType) {
        Map<Object, Object> f16 = new com.tencent.ecommerce.biz.common.e().a("8").b("author_uin", authorUin).b(AudienceReportConst.ROOM_ID, String.valueOf(roomID)).b("live_type", String.valueOf(liveType)).f();
        cg0.a.b("ECLiveWindowReporter", "[reportLiveOpen] eventCode = ds_live_goods_list, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_live_goods_list", f16, false, 4, null);
    }

    public final void w(String authorUin, String roomID, String programID, int liveType, long curPlayTime, LiveProduct liveProduct, boolean isButton) {
        String str;
        com.tencent.ecommerce.biz.common.e b16 = e.a(new com.tencent.ecommerce.biz.common.e(), liveProduct).b("author_uin", authorUin).b(PerfTracer.PARAM_CLICK_TIME, String.valueOf(curPlayTime)).b(AudienceReportConst.ROOM_ID, roomID);
        if (isButton) {
            str = "2";
        } else {
            str = "1";
        }
        Map<Object, Object> f16 = b16.b("click_area", str).b("program_id", programID).b("live_type", String.valueOf(liveType)).f();
        cg0.a.b("ECLiveWindowReporter", "[reportLiveProductClick] eventCode = ds_live_goods_card_list_clk, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_live_goods_card_list_clk", f16, false, 4, null);
    }

    public final void x(String authorUin, String roomID, String programID, int liveType, long curPlayTime, LiveProduct liveProduct) {
        Map<Object, Object> f16 = e.a(new com.tencent.ecommerce.biz.common.e(), liveProduct).b("author_uin", authorUin).b("exp_time", String.valueOf(curPlayTime)).b(AudienceReportConst.ROOM_ID, roomID).b("program_id", programID).b("live_type", String.valueOf(liveType)).f();
        cg0.a.b("ECLiveWindowReporter", "[reportLiveProductExposure] eventCode = ds_live_goods_card_list_exp, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_live_goods_card_list_exp", f16, false, 4, null);
    }

    public final void y(String authorUin, String roomID, String programID, int liveType, LiveProduct liveProduct) {
        Map<String, Long> map = exposureMap;
        Long l3 = map.get(liveProduct.getMediaProductId());
        long longValue = l3 != null ? l3.longValue() : 0L;
        if (longValue <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - longValue;
        map.remove(liveProduct.getMediaProductId());
        Map<Object, Object> f16 = e.a(new com.tencent.ecommerce.biz.common.e(), liveProduct).b("author_uin", authorUin).b(AudienceReportConst.ROOM_ID, roomID).b("duration", String.valueOf(currentTimeMillis)).b("program_id", programID).b("live_type", String.valueOf(liveType)).f();
        cg0.a.b("ECLiveWindowReporter", "[reportLiveProductExposureDuration] eventCode = ds_live_goods_card_list_exp_duration, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_live_goods_card_list_exp_duration", f16, false, 4, null);
    }

    public final void z(String action, String uin, long roomID, String programID, int errorCode, String errorMsg) {
        Map<Object, Object> f16 = new com.tencent.ecommerce.biz.common.e().b("uin", uin).b(AudienceReportConst.ROOM_ID, String.valueOf(roomID)).b("program_id", programID).b("error_code", String.valueOf(errorCode)).b("error_msg", errorMsg).f();
        cg0.a.b("ECLiveWindowReporter", "[reportLiveWindowError] eventCode = " + action + ", params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, action, f16, false, 4, null);
    }

    public final void b(View view, LiveProduct liveProduct) {
        String str;
        if (liveProduct != null) {
            f a16 = com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_buy_button").j("buyBtn_" + liveProduct + ".mediaProductId").a("qqlive_commodity_name", liveProduct.getTitle()).a("qqlive_commodity_price", String.valueOf(liveProduct.getPrice().priceNum)).a("qqlive_commodity_sales", liveProduct.getSalesTxt()).a("qqlive_product_number", liveProduct.getIndexTxt()).a("qqlive_product_point_words", liveProduct.getAdTxt()).a("qqlive_product_inventory_status", String.valueOf(f396304b.o(liveProduct)));
            if (liveProduct.getIsExplaining()) {
                str = "1";
            } else {
                str = "2";
            }
            ((f) e.b(a16.a("qqlive_product_recommend_status", str).a("qqlive_item_id", liveProduct.getMediaProductId()), liveProduct)).i();
        }
    }

    public final void e(View view, LiveProduct liveProduct) {
        if (liveProduct != null) {
            ((f) e.b(com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_move_button").j("dragSortBtn_" + liveProduct + ".mediaProductId").a("qqlive_commodity_name", liveProduct.getTitle()).a("qqlive_commodity_price", String.valueOf(liveProduct.getPrice().priceNum)).a("qqlive_commodity_sales", liveProduct.getSalesTxt()).a("qqlive_item_id", liveProduct.getMediaProductId()), liveProduct)).i();
        }
    }

    public final void f(View view, LiveProduct liveProduct) {
        String str;
        if (liveProduct != null) {
            f a16 = com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_recommand_button").j("buyBtn_" + liveProduct + ".mediaProductId").a("qqlive_commodity_name", liveProduct.getTitle()).a("qqlive_commodity_price", String.valueOf(liveProduct.getPrice().priceNum)).a("qqlive_commodity_sales", liveProduct.getSalesTxt()).a("qqlive_product_number", liveProduct.getIndexTxt()).a("qqlive_product_point_words", liveProduct.getAdTxt()).a("qqlive_product_inventory_status", String.valueOf(f396304b.o(liveProduct)));
            if (liveProduct.getIsExplaining()) {
                str = "1";
            } else {
                str = "2";
            }
            ((f) e.b(a16.a("qqlive_product_recommend_status", str).a("qqlive_item_id", liveProduct.getMediaProductId()), liveProduct)).i();
        }
    }

    public final void g(View view, LiveProduct liveProduct) {
        String str;
        if (liveProduct != null) {
            f a16 = com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_product_details").j("itemview_" + liveProduct + ".mediaProductId").a("qqlive_commodity_name", liveProduct.getTitle()).a("qqlive_commodity_price", String.valueOf(liveProduct.getPrice().priceNum)).a("qqlive_commodity_sales", liveProduct.getSalesTxt()).a("qqlive_product_number", liveProduct.getIndexTxt()).a("qqlive_product_point_words", liveProduct.getAdTxt()).a("qqlive_product_inventory_status", String.valueOf(f396304b.o(liveProduct)));
            if (liveProduct.getIsExplaining()) {
                str = "1";
            } else {
                str = "2";
            }
            ((f) e.b(a16.a("qqlive_product_recommend_status", str).a("qqlive_item_id", liveProduct.getMediaProductId()), liveProduct)).i();
        }
    }

    public final void j(View view, LiveProduct liveProduct) {
        if (liveProduct != null) {
            ((f) e.b(com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_select_button").j("selectBtn_" + liveProduct + ".mediaProductId").a("qqlive_commodity_name", liveProduct.getTitle()).a("qqlive_commodity_price", String.valueOf(liveProduct.getPrice().priceNum)).a("qqlive_commodity_sales", liveProduct.getSalesTxt()).a("qqlive_product_number", liveProduct.getIndexTxt()).a("qqlive_product_point_words", liveProduct.getAdTxt()).a("qqlive_product_inventory_status", String.valueOf(f396304b.o(liveProduct))).a("qqlive_item_id", liveProduct.getMediaProductId()), liveProduct)).i();
        }
    }

    public final void k(View view, LiveProduct liveProduct) {
        if (liveProduct != null) {
            ((f) e.b(com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().h("em_qqlive_shop_save_button").j("sellingPointBtn_" + liveProduct + ".mediaProductId").a("qqlive_commodity_name", liveProduct.getTitle()).a("qqlive_commodity_price", String.valueOf(liveProduct.getPrice().priceNum)).a("qqlive_commodity_sales", liveProduct.getSalesTxt()).a("qqlive_item_id", liveProduct.getMediaProductId()), liveProduct)).i();
        }
    }

    public final void t(ECLiveWindowMainFragment fragment, LiveProduct liveProduct) {
        if (liveProduct != null) {
            ((com.tencent.ecommerce.base.report.service.d) e.b(com.tencent.ecommerce.base.report.service.e.INSTANCE.c(fragment).g().a("qqlive_commodity_name", liveProduct.getTitle()).a("qqlive_commodity_price", String.valueOf(liveProduct.getPrice().priceNum)).a("qqlive_commodity_sales", liveProduct.getSalesTxt()).a("qqlive_product_number", liveProduct.getIndexTxt()).a("qqlive_product_point_words", liveProduct.getAdTxt()).a("qqlive_product_inventory_status", String.valueOf(f396304b.o(liveProduct))).a("qqlive_item_id", liveProduct.getMediaProductId()), liveProduct)).f("ev_qqlive_anchor_product_delete");
        }
    }

    public final void u(View view, LiveProduct liveProduct) {
        if (liveProduct != null) {
            com.tencent.ecommerce.base.report.service.e.INSTANCE.d(view).g().a("qqlive_commodity_name", liveProduct.getTitle()).a("qqlive_commodity_price", String.valueOf(liveProduct.getPrice().priceNum)).a("qqlive_commodity_sales", liveProduct.getSalesTxt()).a("qqlive_product_number", liveProduct.getIndexTxt()).a("qqlive_product_point_words", liveProduct.getAdTxt()).a("qqlive_product_inventory_status", String.valueOf(f396304b.o(liveProduct))).a("qqlive_item_id", liveProduct.getMediaProductId()).f("dt_clck");
        }
    }
}
