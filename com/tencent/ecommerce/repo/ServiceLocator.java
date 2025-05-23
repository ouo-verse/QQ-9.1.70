package com.tencent.ecommerce.repo;

import com.tencent.ecommerce.base.cache.service.c;
import com.tencent.ecommerce.base.list.BaseListDataSource;
import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.list.ListRepository;
import com.tencent.ecommerce.biz.commission.forecast.IECCommissionForecastRepo;
import com.tencent.ecommerce.biz.commission.forecast.n;
import com.tencent.ecommerce.biz.customerservice.ECCustomerServiceRepo;
import com.tencent.ecommerce.biz.customerservice.IECCustomerServiceRepo;
import com.tencent.ecommerce.biz.orders.address.ECDefaultAddressRepository;
import com.tencent.ecommerce.biz.orders.address.IECAddressRepository;
import com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerRepo;
import com.tencent.ecommerce.biz.orders.address.picker.IECAddressPickerRepo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitRepo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo;
import com.tencent.ecommerce.biz.orders.realname.ECRealNameListRepo;
import com.tencent.ecommerce.biz.orders.realname.ECRealNameOperateRepo;
import com.tencent.ecommerce.biz.orders.realname.IECRealNameListRepo;
import com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo;
import com.tencent.ecommerce.biz.shoplist.ECPromoteShopItem;
import com.tencent.ecommerce.repo.blindbox.ECBlindBoxRepo;
import com.tencent.ecommerce.repo.blindbox.b;
import com.tencent.ecommerce.repo.buyerorder.ECQShopOrderInfoRepository;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListDataSource;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListExtraInfo;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListItem;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListRequestInfo;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderOperateRepository;
import com.tencent.ecommerce.repo.buyerorder.sample.ECSampleOrderInfoRepository;
import com.tencent.ecommerce.repo.comment.ECQShopOrderCommentRepo;
import com.tencent.ecommerce.repo.comment.f;
import com.tencent.ecommerce.repo.commission.subsidy.ECSubsidyRepo;
import com.tencent.ecommerce.repo.logistics.ECLogisticsRepo;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleOrderListDataSource;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleOrderListRequest;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleRepo;
import com.tencent.ecommerce.repo.sampleorder.d;
import com.tencent.ecommerce.repo.shoplist.ECPromoteShopListDataSource;
import com.tencent.ecommerce.repo.shoplist.ECPromoteShopRequestInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tl.h;
import wg0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bP\u0010QR-\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00028VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\u0018R-\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00028VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\tR\u001b\u0010$\u001a\u00020 8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0007\u001a\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020*8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\u0007\u001a\u0004\b\u001d\u0010,R\u0014\u00100\u001a\u00020.8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010/R\u0014\u00104\u001a\u0002018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00107\u001a\u0002058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u00106R\u0014\u0010;\u001a\u0002088VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020@8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010AR\u0014\u0010E\u001a\u00020C8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010DR\u0014\u0010H\u001a\u00020F8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010GR\u0014\u0010K\u001a\u00020I8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010JR&\u0010O\u001a\u0014\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050L8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010N\u00a8\u0006R"}, d2 = {"Lcom/tencent/ecommerce/repo/ServiceLocator;", "", "Lcom/tencent/ecommerce/base/list/IListRepository;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/c;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/a;", "a", "Lkotlin/Lazy;", "j", "()Lcom/tencent/ecommerce/base/list/IListRepository;", "orderListRepo", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/d;", "b", "k", "()Lcom/tencent/ecommerce/repo/buyerorder/orderlist/d;", "orderOperateRepo", "Lcom/tencent/ecommerce/repo/buyerorder/b;", "c", "i", "()Lcom/tencent/ecommerce/repo/buyerorder/b;", "orderInfoRepo", "Lcom/tencent/ecommerce/repo/buyerorder/sample/a;", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/ecommerce/repo/buyerorder/sample/a;", "sampleOrderInfo", "Lcom/tencent/ecommerce/repo/shoplist/b;", "Lcom/tencent/ecommerce/biz/shoplist/a;", "", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "promoteShopListRepo", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "f", "p", "()Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "realNameRepo", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameListRepo;", "g", "o", "()Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameListRepo;", "realNameListRepo", "Lcom/tencent/ecommerce/repo/blindbox/b;", h.F, "()Lcom/tencent/ecommerce/repo/blindbox/b;", "blindBoxRepo", "Lcom/tencent/ecommerce/biz/orders/address/IECAddressRepository;", "()Lcom/tencent/ecommerce/biz/orders/address/IECAddressRepository;", "addressRepository", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo;", "l", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo;", "orderSubmitRepo", "Lcom/tencent/ecommerce/biz/commission/forecast/IECCommissionForecastRepo;", "()Lcom/tencent/ecommerce/biz/commission/forecast/IECCommissionForecastRepo;", "commissionForecastRepo", "Lcom/tencent/ecommerce/repo/commission/subsidy/a;", "r", "()Lcom/tencent/ecommerce/repo/commission/subsidy/a;", "subsidyRepo", "Lcom/tencent/ecommerce/repo/comment/f;", DomainData.DOMAIN_NAME, "()Lcom/tencent/ecommerce/repo/comment/f;", "qShopOrderCommentRepo", "Lcom/tencent/ecommerce/repo/logistics/a;", "()Lcom/tencent/ecommerce/repo/logistics/a;", "logisticsRepo", "Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo;", "()Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo;", "customerServiceRepo", "Lcom/tencent/ecommerce/biz/orders/address/picker/IECAddressPickerRepo;", "()Lcom/tencent/ecommerce/biz/orders/address/picker/IECAddressPickerRepo;", "addressPickerRepo", "Lcom/tencent/ecommerce/repo/sampleorder/d;", "()Lcom/tencent/ecommerce/repo/sampleorder/d;", "applySampleRepo", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "Lcom/tencent/ecommerce/repo/sampleorder/c;", "()Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "applySampleOrderListDataSource", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ServiceLocator {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy orderOperateRepo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy orderInfoRepo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy sampleOrderInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Lazy promoteShopListRepo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy realNameRepo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Lazy realNameListRepo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final Lazy blindBoxRepo;

    /* renamed from: i, reason: collision with root package name */
    public static final ServiceLocator f104891i = new ServiceLocator();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy orderListRepo = c.b(null, new Function0<ListRepository<ECOrderListRequestInfo, ECOrderListItem, ECOrderListExtraInfo>>() { // from class: com.tencent.ecommerce.repo.ServiceLocator$orderListRepo$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ListRepository<ECOrderListRequestInfo, ECOrderListItem, ECOrderListExtraInfo> invoke() {
            return new ListRepository<>(new ECOrderListDataSource(), null, null, 6, null);
        }
    }, 1, null);

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECOrderOperateRepository>() { // from class: com.tencent.ecommerce.repo.ServiceLocator$orderOperateRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECOrderOperateRepository invoke() {
                return new ECOrderOperateRepository(null, 1, null);
            }
        });
        orderOperateRepo = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ECQShopOrderInfoRepository>() { // from class: com.tencent.ecommerce.repo.ServiceLocator$orderInfoRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECQShopOrderInfoRepository invoke() {
                return new ECQShopOrderInfoRepository(null, 1, 0 == true ? 1 : 0);
            }
        });
        orderInfoRepo = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ECSampleOrderInfoRepository>() { // from class: com.tencent.ecommerce.repo.ServiceLocator$sampleOrderInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECSampleOrderInfoRepository invoke() {
                return new ECSampleOrderInfoRepository(null, 1, 0 == true ? 1 : 0);
            }
        });
        sampleOrderInfo = lazy3;
        promoteShopListRepo = c.b(null, new Function0<ListRepository<ECPromoteShopRequestInfo, ECPromoteShopItem, String>>() { // from class: com.tencent.ecommerce.repo.ServiceLocator$promoteShopListRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ListRepository<ECPromoteShopRequestInfo, ECPromoteShopItem, String> invoke() {
                return new ListRepository<>(new ECPromoteShopListDataSource(), null, null, 6, null);
            }
        }, 1, null);
        realNameRepo = c.b(null, new Function0<ECRealNameOperateRepo>() { // from class: com.tencent.ecommerce.repo.ServiceLocator$realNameRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECRealNameOperateRepo invoke() {
                return new ECRealNameOperateRepo();
            }
        }, 1, null);
        realNameListRepo = c.b(null, new Function0<ECRealNameListRepo>() { // from class: com.tencent.ecommerce.repo.ServiceLocator$realNameListRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECRealNameListRepo invoke() {
                return new ECRealNameListRepo();
            }
        }, 1, null);
        blindBoxRepo = c.b(null, new Function0<ECBlindBoxRepo>() { // from class: com.tencent.ecommerce.repo.ServiceLocator$blindBoxRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECBlindBoxRepo invoke() {
                return new ECBlindBoxRepo();
            }
        }, 1, null);
    }

    ServiceLocator() {
    }

    public IECAddressPickerRepo a() {
        return new ECAddressPickerRepo(a.a());
    }

    public IECAddressRepository b() {
        return ECDefaultAddressRepository.f103000a;
    }

    public BaseListDataSource<ECApplySampleOrderListRequest, ECOrderListItem, ECOrderListExtraInfo> c() {
        return new ECApplySampleOrderListDataSource();
    }

    public d d() {
        return new ECApplySampleRepo();
    }

    public b e() {
        return (b) blindBoxRepo.getValue();
    }

    public IECCommissionForecastRepo f() {
        return new n();
    }

    public IECCustomerServiceRepo g() {
        return new ECCustomerServiceRepo(null, 1, 0 == true ? 1 : 0);
    }

    public com.tencent.ecommerce.repo.logistics.a h() {
        return ECLogisticsRepo.f105220a;
    }

    public com.tencent.ecommerce.repo.buyerorder.b i() {
        return (com.tencent.ecommerce.repo.buyerorder.b) orderInfoRepo.getValue();
    }

    public IListRepository<ECOrderListRequestInfo, ECOrderListItem, ECOrderListExtraInfo> j() {
        return (IListRepository) orderListRepo.getValue();
    }

    public com.tencent.ecommerce.repo.buyerorder.orderlist.d k() {
        return (com.tencent.ecommerce.repo.buyerorder.orderlist.d) orderOperateRepo.getValue();
    }

    public IECOrderSubmitRepo l() {
        return new ECOrderSubmitRepo();
    }

    public IListRepository<ECPromoteShopRequestInfo, ECPromoteShopItem, String> m() {
        return (IListRepository) promoteShopListRepo.getValue();
    }

    public f n() {
        return ECQShopOrderCommentRepo.f105029a;
    }

    public IECRealNameListRepo o() {
        return (IECRealNameListRepo) realNameListRepo.getValue();
    }

    public IECRealNameOperateRepo p() {
        return (IECRealNameOperateRepo) realNameRepo.getValue();
    }

    public com.tencent.ecommerce.repo.buyerorder.sample.a q() {
        return (com.tencent.ecommerce.repo.buyerorder.sample.a) sampleOrderInfo.getValue();
    }

    public com.tencent.ecommerce.repo.commission.subsidy.a r() {
        return ECSubsidyRepo.f105063a;
    }
}
