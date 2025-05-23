package ih0;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.common.e;
import com.tencent.ecommerce.repo.aftersale.apply.ApplyType;
import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyRepo;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.ecommerce.repo.aftersale.apply.PageType;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleShopInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J*\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0014"}, d2 = {"Lih0/b;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/common/e;", "a", "Lcom/tencent/ecommerce/repo/aftersale/apply/PageType;", "pageType", "", "c", "Lcom/tencent/ecommerce/repo/aftersale/apply/ApplyType;", "applyType", "b", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/e;", "optionItem", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;", "extraItem", "d", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f407641a = new b();

    b() {
    }

    private final e a(String orderId) {
        String str;
        ECAfterSaleShopInfo eCAfterSaleShopInfo;
        e b16 = new e().a("2").b("order_id", orderId);
        ECAfterSaleApplyRepo eCAfterSaleApplyRepo = ECAfterSaleApplyRepo.f104899h;
        Map<String, String> k3 = eCAfterSaleApplyRepo.k();
        if (k3 != null) {
            b16.c(k3);
        }
        ECAfterSaleProductCard j3 = eCAfterSaleApplyRepo.j();
        if (j3 == null || (eCAfterSaleShopInfo = j3.shopInfo) == null || (str = eCAfterSaleShopInfo.shopId) == null) {
            str = "";
        }
        return b16.b("shop_id", str);
    }

    public final void b(ApplyType applyType, String orderId) {
        String str;
        Map<Object, Object> f16 = a(orderId).f();
        int i3 = a.f407639b[applyType.ordinal()];
        if (i3 == 1 || i3 != 2) {
            str = "qstore_return_and_refund_clk";
        } else {
            str = "qstore_only_refund_clk";
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, str, f16, false, 4, null);
    }

    public final void c(PageType pageType, String orderId) {
        String str;
        Map<Object, Object> f16 = a(orderId).f();
        int i3 = a.f407638a[pageType.ordinal()];
        if (i3 == 1 || i3 == 2) {
            str = "qstore_apply_after_sales_exp";
        } else if (i3 == 3) {
            str = "qstore_return_and_refund_exp";
        } else if (i3 == 4) {
            str = "qstore_only_refund_exp";
        } else if (i3 == 5) {
            str = "qstore_apply_for_intervention_exp";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, str, f16, false, 4, null);
    }

    public final void d(PageType pageType, String orderId, com.tencent.ecommerce.repo.aftersale.apply.item.e optionItem, ECAfterSaleApplyExtraItem extraItem) {
        String str;
        boolean isBlank;
        e a16 = a(orderId);
        if (optionItem != null) {
            OptionValue selectedOption = optionItem.getOptionInfo().getSelectedOption();
            a16.b("refund_reason", String.valueOf(selectedOption != null ? Integer.valueOf(selectedOption.getValue()) : null));
        }
        if (extraItem != null) {
            String extraText = extraItem.getExtraText();
            if (extraText != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(extraText);
                if (!isBlank) {
                    str = "2";
                    a16.b("reason_describe", str);
                    a16.b("attachment_counts", String.valueOf(extraItem.c().size()));
                }
            }
            str = "1";
            a16.b("reason_describe", str);
            a16.b("attachment_counts", String.valueOf(extraItem.c().size()));
        }
        int i3 = a.f407640c[pageType.ordinal()];
        String str2 = "qstore_return_and_refund_submit_clk";
        if (i3 != 1) {
            if (i3 == 2) {
                str2 = "qstore_only_refund_submit_clk";
            } else if (i3 == 3) {
                str2 = "qstore_apply_for_intervention_clk";
            }
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, str2, a16.f(), false, 4, null);
    }
}
