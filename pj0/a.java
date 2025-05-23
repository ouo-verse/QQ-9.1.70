package pj0;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.VirtualProductAccount;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ProductTradeInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$VirtualAccount;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.ecommerce.repo.proto.ecom.real_name_svr.ECRealNameSvr$User;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0001\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0001\"\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$ProductTradeInfo;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "d", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$VirtualAccount;", "c", "Lcom/tencent/ecommerce/repo/proto/ecom/real_name_svr/ECRealNameSvr$User;", "b", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$OrderInfo;", "a", "(Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$OrderInfo;)Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "productType", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final j a(ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo) {
        int i3 = eCOrderInfo$OrderInfo.trade_type.get();
        if (i3 != 0 && i3 != 4) {
            ECOrderCommon$VirtualAccount eCOrderCommon$VirtualAccount = eCOrderInfo$OrderInfo.virtual_account.get();
            return new j.VirtualProduct(i3, new VirtualProductAccount(eCOrderCommon$VirtualAccount.virtual_account_type.get(), eCOrderCommon$VirtualAccount.account_name.get(), eCOrderCommon$VirtualAccount.account.get()), null, 4, null);
        }
        return new j.PhysicalProduct(i3);
    }

    public static final ECRealNameSvr$User b(j jVar) {
        if (jVar instanceof j.PhysicalProduct) {
            return null;
        }
        if (jVar instanceof j.VirtualProduct) {
            RealNameAccount realNameAccount = ((j.VirtualProduct) jVar).getRealNameAccount();
            if (realNameAccount == null) {
                return null;
            }
            ECRealNameSvr$User eCRealNameSvr$User = new ECRealNameSvr$User();
            eCRealNameSvr$User.f105262id.set(realNameAccount.id);
            eCRealNameSvr$User.name.set(realNameAccount.name);
            eCRealNameSvr$User.id_card.set(realNameAccount.identityNumber);
            return eCRealNameSvr$User;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ECOrderCommon$VirtualAccount c(j jVar) {
        if (jVar instanceof j.PhysicalProduct) {
            return null;
        }
        if (jVar instanceof j.VirtualProduct) {
            VirtualProductAccount virtualProductAccount = ((j.VirtualProduct) jVar).account;
            ECOrderCommon$VirtualAccount eCOrderCommon$VirtualAccount = new ECOrderCommon$VirtualAccount();
            eCOrderCommon$VirtualAccount.account_name.set(virtualProductAccount.platformName);
            String str = virtualProductAccount.id;
            if (str != null) {
                eCOrderCommon$VirtualAccount.account.set(str);
            }
            eCOrderCommon$VirtualAccount.virtual_account_type.set(virtualProductAccount.type);
            return eCOrderCommon$VirtualAccount;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final j d(ECOrderCommon$ProductTradeInfo eCOrderCommon$ProductTradeInfo) {
        int i3 = eCOrderCommon$ProductTradeInfo.trade_type.get();
        if (i3 != 0 && i3 != 4) {
            return new j.VirtualProduct(i3, new VirtualProductAccount(eCOrderCommon$ProductTradeInfo.account_type.get(), eCOrderCommon$ProductTradeInfo.account_name.get(), null, 4, null), null, 4, null);
        }
        return new j.PhysicalProduct(i3);
    }
}
