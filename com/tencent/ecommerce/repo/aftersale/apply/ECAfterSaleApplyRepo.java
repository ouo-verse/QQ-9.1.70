package com.tencent.ecommerce.repo.aftersale.apply;

import android.app.Application;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyAmountItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyEntryItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyProductItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplySubOptionItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ItemType;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002Jt\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u000628\u0010\u000e\u001a4\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\t2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u000fH\u0002Jl\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000628\u0010\u000e\u001a4\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\t2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u000fH\u0002J(\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00060\fH\u0002J\u001a\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00060\fH\u0002J\u001a\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00060\fH\u0002J\u001a\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00060\fH\u0002J|\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000628\u0010\u000e\u001a4\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\u0004\u0012\u00020\u00020\t2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u000fH\u0016JE\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R(\u0010,\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00104\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010/R@\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001052\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006A"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/ECAfterSaleApplyRepo;", "", "", "i", "Lcom/tencent/ecommerce/repo/aftersale/apply/PageType;", "reqPageType", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "skuId", "Lkotlin/Function4;", "", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "Lkotlin/Pair;", "", "success", "Lkotlin/Function2;", "fail", "r", "afterSalesId", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Triple;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "pageType", "processId", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;", "extraItem", "", "t", "(Lcom/tencent/ecommerce/repo/aftersale/apply/PageType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "<set-?>", "b", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "j", "()Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "orderCard", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "c", "Lcom/tencent/ecommerce/repo/aftersale/apply/c;", "onlyRefundInfo", "d", "returnAndRefundInfo", "e", "judgementInfo", "", "f", "Ljava/util/Map;", "k", "()Ljava/util/Map;", "reportMap", "Landroid/app/Application;", "g", "Landroid/app/Application;", "context", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAfterSaleApplyRepo {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ECAfterSaleProductCard orderCard;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static ECAfterSaleApplyInfo onlyRefundInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static ECAfterSaleApplyInfo returnAndRefundInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static ECAfterSaleApplyInfo judgementInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Map<String, String> reportMap;

    /* renamed from: h, reason: collision with root package name */
    public static final ECAfterSaleApplyRepo f104899h = new ECAfterSaleApplyRepo();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineDispatcher coroutineDispatcher = Dispatchers.getIO();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Application context = wg0.a.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/aftersale/apply/ECAfterSaleApplyRepo$a", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/repo/aftersale/apply/a;", "Lcom/tencent/ecommerce/repo/aftersale/apply/b;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkCallback<com.tencent.ecommerce.repo.aftersale.apply.a, com.tencent.ecommerce.repo.aftersale.apply.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PageType f104900a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function4 f104901b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f104902c;

        a(PageType pageType, Function4 function4, Function2 function2) {
            this.f104900a = pageType;
            this.f104901b = function4;
            this.f104902c = function2;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(com.tencent.ecommerce.repo.aftersale.apply.a reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECAfterSaleApplyRepo", "requestApplyPageFromNet", "onError: " + errorResponse);
            this.f104902c.invoke(Integer.valueOf(errorResponse.getCode()), errorResponse.getMsg());
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(com.tencent.ecommerce.repo.aftersale.apply.a reqModel, com.tencent.ecommerce.repo.aftersale.apply.b respModel) {
            cg0.a.b("ECAfterSaleApplyRepo", "requestApplyPageFromNet onSuccess, orderCard:" + respModel.getProductCard() + ", onlyRefundInfo:" + respModel.getOnlyRefundInfo() + ", returnAndRefundInfo:" + respModel.getReturnAndRefundInfo() + ", extReportMap:" + respModel.a() + ", result:" + respModel.d());
            ECAfterSaleApplyRepo eCAfterSaleApplyRepo = ECAfterSaleApplyRepo.f104899h;
            ECAfterSaleApplyRepo.orderCard = respModel.getProductCard();
            ECAfterSaleApplyRepo.onlyRefundInfo = respModel.getOnlyRefundInfo();
            ECAfterSaleApplyRepo.returnAndRefundInfo = respModel.getReturnAndRefundInfo();
            ECAfterSaleApplyRepo.reportMap = respModel.a();
            Triple l3 = eCAfterSaleApplyRepo.l(this.f104900a);
            this.f104901b.invoke(l3.getFirst(), l3.getSecond(), l3.getThird(), respModel.d());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/aftersale/apply/ECAfterSaleApplyRepo$b", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/repo/aftersale/apply/d;", "Lcom/tencent/ecommerce/repo/aftersale/apply/e;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkCallback<d, e> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PageType f104903a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function4 f104904b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f104905c;

        b(PageType pageType, Function4 function4, Function2 function2) {
            this.f104903a = pageType;
            this.f104904b = function4;
            this.f104905c = function2;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(d reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECAfterSaleApplyRepo", "requestJudgementPageFromNet", "onError: " + errorResponse);
            this.f104905c.invoke(Integer.valueOf(errorResponse.getCode()), errorResponse.getMsg());
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(d reqModel, e respModel) {
            cg0.a.b("ECAfterSaleApplyRepo", "requestJudgementPageFromNet onSuccess, orderCard:" + respModel.getOrderCard() + ", judgementInfo:" + respModel.getJudgementInfo() + " extReportMap:" + respModel.a());
            ECAfterSaleApplyRepo eCAfterSaleApplyRepo = ECAfterSaleApplyRepo.f104899h;
            ECAfterSaleApplyRepo.orderCard = respModel.getOrderCard();
            ECAfterSaleApplyRepo.judgementInfo = respModel.getJudgementInfo();
            ECAfterSaleApplyRepo.reportMap = respModel.a();
            Triple l3 = eCAfterSaleApplyRepo.l(this.f104903a);
            this.f104904b.invoke(l3.getFirst(), l3.getSecond(), l3.getThird(), null);
        }
    }

    ECAfterSaleApplyRepo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Triple<PageType, String, List<com.tencent.ecommerce.repo.aftersale.apply.item.d>> l(PageType reqPageType) {
        List<com.tencent.ecommerce.repo.aftersale.apply.item.d> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        PageType pageType = PageType.PAGE_TYPE_UNINIT;
        String string = context.getString(R.string.wff);
        int i3 = h.f104941c[reqPageType.ordinal()];
        if (i3 == 1) {
            ECAfterSaleApplyInfo eCAfterSaleApplyInfo = onlyRefundInfo;
            if (eCAfterSaleApplyInfo != null && returnAndRefundInfo != null) {
                pageType = PageType.PAGE_TYPE_APPLY;
                Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> m3 = m();
                emptyList = m3.getFirst();
                string = m3.getSecond();
            } else if (eCAfterSaleApplyInfo != null && returnAndRefundInfo == null) {
                pageType = PageType.PAGE_TYPE_REFUND_ONLY;
                Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> o16 = o();
                emptyList = o16.getFirst();
                string = o16.getSecond();
            } else if (eCAfterSaleApplyInfo == null && returnAndRefundInfo != null) {
                PageType pageType2 = PageType.PAGE_TYPE_RETURN_REFUND;
                Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> p16 = p();
                List<com.tencent.ecommerce.repo.aftersale.apply.item.d> first = p16.getFirst();
                string = p16.getSecond();
                emptyList = first;
                pageType = pageType2;
            }
        } else if (i3 == 2) {
            pageType = PageType.PAGE_TYPE_REFUND_ONLY;
            Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> o17 = o();
            emptyList = o17.getFirst();
            string = o17.getSecond();
        } else if (i3 == 3) {
            pageType = PageType.PAGE_TYPE_RETURN_REFUND;
            Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> p17 = p();
            emptyList = p17.getFirst();
            string = p17.getSecond();
        } else if (i3 == 4) {
            pageType = PageType.PAGE_TYPE_JUDGEMENT;
            Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> n3 = n();
            emptyList = n3.getFirst();
            string = n3.getSecond();
        }
        return new Triple<>(pageType, string, emptyList);
    }

    private final Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> m() {
        ArrayList arrayList = new ArrayList();
        ECAfterSaleProductCard eCAfterSaleProductCard = orderCard;
        if (eCAfterSaleProductCard != null) {
            arrayList.add(new ECAfterSaleApplyProductItem(eCAfterSaleProductCard));
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo = onlyRefundInfo;
        if (eCAfterSaleApplyInfo != null) {
            arrayList.add(new ECAfterSaleApplyEntryItem(eCAfterSaleApplyInfo.getFormMainTitle(), eCAfterSaleApplyInfo.getFormSubTitle(), eCAfterSaleApplyInfo.getApplyType()));
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo2 = returnAndRefundInfo;
        if (eCAfterSaleApplyInfo2 != null) {
            arrayList.add(new ECAfterSaleApplyEntryItem(eCAfterSaleApplyInfo2.getFormMainTitle(), eCAfterSaleApplyInfo2.getFormSubTitle(), eCAfterSaleApplyInfo2.getApplyType()));
        }
        return new Pair<>(arrayList, context.getString(R.string.wff));
    }

    private final Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> n() {
        String string;
        ArrayList arrayList = new ArrayList();
        ECAfterSaleProductCard eCAfterSaleProductCard = orderCard;
        if (eCAfterSaleProductCard != null) {
            arrayList.add(new ECAfterSaleApplyProductItem(eCAfterSaleProductCard));
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo = judgementInfo;
        if (eCAfterSaleApplyInfo != null) {
            Iterator<ECAfterSaleApplyOptionInfo> it = eCAfterSaleApplyInfo.e().iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.ecommerce.repo.aftersale.apply.item.e(it.next()));
            }
            arrayList.add(new ECAfterSaleApplyExtraItem(true, null, null, 6, null));
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo2 = judgementInfo;
        if (eCAfterSaleApplyInfo2 == null || (string = eCAfterSaleApplyInfo2.getPageTitle()) == null) {
            string = context.getString(R.string.wfg);
        }
        return new Pair<>(arrayList, string);
    }

    private final Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> o() {
        String string;
        List<ECAfterSaleApplyOptionInfo> a16;
        ArrayList arrayList = new ArrayList();
        ECAfterSaleProductCard eCAfterSaleProductCard = orderCard;
        if (eCAfterSaleProductCard != null) {
            arrayList.add(new ECAfterSaleApplyProductItem(eCAfterSaleProductCard));
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo = onlyRefundInfo;
        if (eCAfterSaleApplyInfo != null) {
            for (ECAfterSaleApplyOptionInfo eCAfterSaleApplyOptionInfo : eCAfterSaleApplyInfo.e()) {
                arrayList.add(new com.tencent.ecommerce.repo.aftersale.apply.item.e(eCAfterSaleApplyOptionInfo));
                OptionValue defaultValue = eCAfterSaleApplyOptionInfo.getDefaultValue();
                if (defaultValue != null && (a16 = defaultValue.a()) != null) {
                    Iterator<T> it = a16.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new ECAfterSaleApplySubOptionItem((ECAfterSaleApplyOptionInfo) it.next(), null, 2, null));
                    }
                }
            }
            arrayList.add(new ECAfterSaleApplyAmountItem(eCAfterSaleApplyInfo.getApplyMount()));
            arrayList.add(new ECAfterSaleApplyExtraItem(false, null, null, 6, null));
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo2 = onlyRefundInfo;
        if (eCAfterSaleApplyInfo2 == null || (string = eCAfterSaleApplyInfo2.getPageTitle()) == null) {
            string = context.getString(R.string.f169586wg0);
        }
        return new Pair<>(arrayList, string);
    }

    private final Pair<List<com.tencent.ecommerce.repo.aftersale.apply.item.d>, String> p() {
        String string;
        ArrayList arrayList = new ArrayList();
        ECAfterSaleProductCard eCAfterSaleProductCard = orderCard;
        if (eCAfterSaleProductCard != null) {
            arrayList.add(new ECAfterSaleApplyProductItem(eCAfterSaleProductCard));
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo = returnAndRefundInfo;
        if (eCAfterSaleApplyInfo != null) {
            Iterator<ECAfterSaleApplyOptionInfo> it = eCAfterSaleApplyInfo.e().iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.ecommerce.repo.aftersale.apply.item.e(it.next()));
            }
            arrayList.add(new ECAfterSaleApplyAmountItem(eCAfterSaleApplyInfo.getApplyMount()));
            arrayList.add(new com.tencent.ecommerce.repo.aftersale.apply.item.d(ItemType.TYPE_POST_METHOD));
            arrayList.add(new ECAfterSaleApplyExtraItem(false, null, null, 6, null));
        }
        ECAfterSaleApplyInfo eCAfterSaleApplyInfo2 = returnAndRefundInfo;
        if (eCAfterSaleApplyInfo2 == null || (string = eCAfterSaleApplyInfo2.getPageTitle()) == null) {
            string = context.getString(R.string.f169587wg1);
        }
        return new Pair<>(arrayList, string);
    }

    private final void r(PageType reqPageType, String orderId, String skuId, Function4<? super PageType, ? super String, ? super List<? extends com.tencent.ecommerce.repo.aftersale.apply.item.d>, ? super Pair<Integer, String>, Unit> success, Function2<? super Integer, ? super String, Unit> fail) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.after_sales_svr.AfterSales", "/trpc.ecom.after_sales_svr.AfterSales/GetAfterSalesApplyPage", new com.tencent.ecommerce.repo.aftersale.apply.a(orderId, skuId), new com.tencent.ecommerce.repo.aftersale.apply.b(), new a(reqPageType, success, fail));
    }

    private final void s(PageType reqPageType, String afterSalesId, Function4<? super PageType, ? super String, ? super List<? extends com.tencent.ecommerce.repo.aftersale.apply.item.d>, ? super Pair<Integer, String>, Unit> success, Function2<? super Integer, ? super String, Unit> fail) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.after_sales_svr.AfterSales", "/trpc.ecom.after_sales_svr.AfterSales/GetApplyJudgementPage", new d(afterSalesId), new e(), new b(reqPageType, success, fail));
    }

    public final ECAfterSaleProductCard j() {
        return orderCard;
    }

    public final Map<String, String> k() {
        return reportMap;
    }

    public void q(PageType reqPageType, String orderId, String skuId, String afterSalesId, Function4<? super PageType, ? super String, ? super List<? extends com.tencent.ecommerce.repo.aftersale.apply.item.d>, ? super Pair<Integer, String>, Unit> success, Function2<? super Integer, ? super String, Unit> fail) {
        int i3 = h.f104939a[reqPageType.ordinal()];
        if (i3 == 1 || i3 == 2) {
            i();
            r(reqPageType, orderId, skuId, success, fail);
        } else if (i3 == 3 || i3 == 4) {
            Triple<PageType, String, List<com.tencent.ecommerce.repo.aftersale.apply.item.d>> l3 = l(reqPageType);
            success.invoke(l3.getFirst(), l3.getSecond(), l3.getThird(), null);
        } else {
            if (i3 != 5) {
                return;
            }
            i();
            s(reqPageType, afterSalesId, success, fail);
        }
    }

    public Object t(PageType pageType, String str, String str2, String str3, String str4, ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(coroutineDispatcher, new ECAfterSaleApplyRepo$submitApplyDataReq$2(pageType, str, eCAfterSaleApplyExtraItem, str2, str4, str3, null), continuation);
    }

    private final void i() {
        orderCard = null;
        onlyRefundInfo = null;
        returnAndRefundInfo = null;
        judgementInfo = null;
        reportMap = null;
    }
}
