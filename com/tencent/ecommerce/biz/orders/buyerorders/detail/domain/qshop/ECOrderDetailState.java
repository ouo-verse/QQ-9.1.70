package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.OrderStateUpdateType;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuPicInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuProperty;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.OrderSnapShotData;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.SnapshotOrderInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.SnapshotProduct;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.SnapshotProductInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.SnapshotProductPic;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.SnapshotProductPrice;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.SnapshotProductProp;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.SnapshotShopInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.snapshot.SnapshotSpecification;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderShop;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuSpec;
import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderCouponInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderPromoInfo;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\b\u0086\b\u0018\u0000 l2\u00020\u0001:\u0001\u0003B\u00bf\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001c\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u001c\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u001c\u0012\u0006\u0010.\u001a\u00020-\u0012\b\b\u0002\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u0002030\u001c\u0012\b\b\u0002\u00105\u001a\u00020\u0004\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u00a2\u0006\u0004\bj\u0010kJ\u0006\u0010\u0003\u001a\u00020\u0002J\u00d9\u0002\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001c2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u001c2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u00102\u001a\u0004\u0018\u0001012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u0002030\u001c2\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u0004H\u00c6\u0001J\t\u00108\u001a\u00020\u0004H\u00d6\u0001J\t\u00109\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010;\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010<R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010=R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010<R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010<R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010DR\u0014\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010DR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010<R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010<R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010<R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bB\u0010MR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010UR\u0014\u0010\"\u001a\u00020!8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001c8\u0006\u00a2\u0006\f\n\u0004\b[\u0010U\u001a\u0004\bE\u0010\\R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u001c8\u0006\u00a2\u0006\f\n\u0004\b]\u0010U\u001a\u0004\bH\u0010\\R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u001c8\u0006\u00a2\u0006\f\n\u0004\b`\u0010U\u001a\u0004\bF\u0010\\R\u0014\u0010.\u001a\u00020-8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u00100\u001a\u00020/8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002030\u001c8\u0006\u00a2\u0006\f\n\u0004\bg\u0010U\u001a\u0004\bC\u0010\\R\u0014\u00105\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010<R\u0014\u00106\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010<\u00a8\u0006m"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/OrderSnapShotData;", "a", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "orderStateVal", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/f;", "headerState", "preferOrderStateTitle", "preferOrderStateDesc", "", "createTimestampMs", "deadlineMs", "", "hasComment", "orderNote", "orderNoteFromSeller", "buyerMobile", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/b;", "accountInfo", "Lcom/tencent/ecommerce/biz/orders/common/e;", "logisticsInfo", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "addressInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", "modifyAddressValidInfo", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "orderSkuInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "orderSpuInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/g;", "payInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "ticketInfo", "Lcom/tencent/ecommerce/biz/orders/common/j;", "promoInfos", "Lcom/tencent/ecommerce/biz/orders/common/i;", "usedCouponInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;", "goodsOperateState", "Lcom/tencent/ecommerce/biz/recommend/models/a;", "recommendList", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/i;", "widgetsVisibility", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/OrderStateUpdateType;", "updateType", "Lcom/tencent/ecommerce/biz/orders/common/a;", "bulletinInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/a;", "extraJumpInfoList", "blindBoxWareHouseLink", "deliverMessage", "b", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "I", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/f;", "f", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/f;", "d", "e", "J", "g", tl.h.F, "Z", "i", "j", "k", "l", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/b;", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/orders/common/e;", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "o", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", "p", "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/g;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "t", "()Ljava/util/List;", "u", "v", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;", "w", HippyTKDListViewAdapter.X, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/i;", "y", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/OrderStateUpdateType;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/ecommerce/biz/orders/common/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "<init>", "(Ljava/lang/String;ILcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/f;Ljava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/b;Lcom/tencent/ecommerce/biz/orders/common/e;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;Ljava/util/List;Ljava/util/List;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/g;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;Ljava/util/List;Ljava/util/List;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;Ljava/util/List;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/i;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/OrderStateUpdateType;Lcom/tencent/ecommerce/biz/orders/common/a;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "D", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class ECOrderDetailState {

    /* renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata and from toString */
    private final List<ECExtraJumpInfo> extraJumpInfoList;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    public final String blindBoxWareHouseLink;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    public final String deliverMessage;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int orderStateVal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ECOrderDetailHeaderState headerState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String preferOrderStateTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String preferOrderStateDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final long createTimestampMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final long deadlineMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean hasComment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderNote;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderNoteFromSeller;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final String buyerMobile;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final ECOrderDetailAccountInfoData accountInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final LogisticsInfo logisticsInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECAddress addressInfo;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    public final OrderDetailCheckValidData modifyAddressValidInfo;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<OrderSkuDetail> orderSkuInfo;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<OrderSpuDetail> orderSpuInfo;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECOrderDetailPayInfo payInfo;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    public final f.TicketInfoData ticketInfo;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<QShopOrderPromoInfo> promoInfos;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<QShopOrderCouponInfo> usedCouponInfo;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECOrderDetailGoodsOperateState goodsOperateState;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ECProductRecommendItemData> recommendList;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECOrderDetailWidgetsVisibility widgetsVisibility;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    public final OrderStateUpdateType updateType;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    public final BulletinInfo bulletinInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState$a;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "", "a", "", "DEFAULT_ORDER_ID", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(ECOrderDetailState eCOrderDetailState) {
            return Intrinsics.areEqual(eCOrderDetailState.orderId, "");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECOrderDetailState(String str, int i3, ECOrderDetailHeaderState eCOrderDetailHeaderState, String str2, String str3, long j3, long j16, boolean z16, String str4, String str5, String str6, ECOrderDetailAccountInfoData eCOrderDetailAccountInfoData, LogisticsInfo logisticsInfo, ECAddress eCAddress, OrderDetailCheckValidData orderDetailCheckValidData, List<OrderSkuDetail> list, List<OrderSpuDetail> list2, ECOrderDetailPayInfo eCOrderDetailPayInfo, f.TicketInfoData ticketInfoData, List<QShopOrderPromoInfo> list3, List<QShopOrderCouponInfo> list4, ECOrderDetailGoodsOperateState eCOrderDetailGoodsOperateState, List<ECProductRecommendItemData> list5, ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility, OrderStateUpdateType orderStateUpdateType, BulletinInfo bulletinInfo, List<ECExtraJumpInfo> list6, String str7, String str8) {
        this.orderId = str;
        this.orderStateVal = i3;
        this.headerState = eCOrderDetailHeaderState;
        this.preferOrderStateTitle = str2;
        this.preferOrderStateDesc = str3;
        this.createTimestampMs = j3;
        this.deadlineMs = j16;
        this.hasComment = z16;
        this.orderNote = str4;
        this.orderNoteFromSeller = str5;
        this.buyerMobile = str6;
        this.accountInfo = eCOrderDetailAccountInfoData;
        this.logisticsInfo = logisticsInfo;
        this.addressInfo = eCAddress;
        this.modifyAddressValidInfo = orderDetailCheckValidData;
        this.orderSkuInfo = list;
        this.orderSpuInfo = list2;
        this.payInfo = eCOrderDetailPayInfo;
        this.ticketInfo = ticketInfoData;
        this.promoInfos = list3;
        this.usedCouponInfo = list4;
        this.goodsOperateState = eCOrderDetailGoodsOperateState;
        this.recommendList = list5;
        this.widgetsVisibility = eCOrderDetailWidgetsVisibility;
        this.updateType = orderStateUpdateType;
        this.bulletinInfo = bulletinInfo;
        this.extraJumpInfoList = list6;
        this.blindBoxWareHouseLink = str7;
        this.deliverMessage = str8;
    }

    public final ECOrderDetailState b(String orderId, int orderStateVal, ECOrderDetailHeaderState headerState, String preferOrderStateTitle, String preferOrderStateDesc, long createTimestampMs, long deadlineMs, boolean hasComment, String orderNote, String orderNoteFromSeller, String buyerMobile, ECOrderDetailAccountInfoData accountInfo, LogisticsInfo logisticsInfo, ECAddress addressInfo, OrderDetailCheckValidData modifyAddressValidInfo, List<OrderSkuDetail> orderSkuInfo, List<OrderSpuDetail> orderSpuInfo, ECOrderDetailPayInfo payInfo, f.TicketInfoData ticketInfo, List<QShopOrderPromoInfo> promoInfos, List<QShopOrderCouponInfo> usedCouponInfo, ECOrderDetailGoodsOperateState goodsOperateState, List<ECProductRecommendItemData> recommendList, ECOrderDetailWidgetsVisibility widgetsVisibility, OrderStateUpdateType updateType, BulletinInfo bulletinInfo, List<ECExtraJumpInfo> extraJumpInfoList, String blindBoxWareHouseLink, String deliverMessage) {
        return new ECOrderDetailState(orderId, orderStateVal, headerState, preferOrderStateTitle, preferOrderStateDesc, createTimestampMs, deadlineMs, hasComment, orderNote, orderNoteFromSeller, buyerMobile, accountInfo, logisticsInfo, addressInfo, modifyAddressValidInfo, orderSkuInfo, orderSpuInfo, payInfo, ticketInfo, promoInfos, usedCouponInfo, goodsOperateState, recommendList, widgetsVisibility, updateType, bulletinInfo, extraJumpInfoList, blindBoxWareHouseLink, deliverMessage);
    }

    /* renamed from: d, reason: from getter */
    public final ECOrderDetailAccountInfoData getAccountInfo() {
        return this.accountInfo;
    }

    public final List<ECExtraJumpInfo> e() {
        return this.extraJumpInfoList;
    }

    /* renamed from: f, reason: from getter */
    public final ECOrderDetailHeaderState getHeaderState() {
        return this.headerState;
    }

    public final List<QShopOrderPromoInfo> g() {
        return this.promoInfos;
    }

    public final List<ECProductRecommendItemData> h() {
        return this.recommendList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.orderId;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.orderStateVal) * 31;
        ECOrderDetailHeaderState eCOrderDetailHeaderState = this.headerState;
        int hashCode2 = (hashCode + (eCOrderDetailHeaderState != null ? eCOrderDetailHeaderState.hashCode() : 0)) * 31;
        String str2 = this.preferOrderStateTitle;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.preferOrderStateDesc;
        int hashCode4 = (((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.createTimestampMs)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.deadlineMs)) * 31;
        boolean z16 = this.hasComment;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode4 + i3) * 31;
        String str4 = this.orderNote;
        int hashCode5 = (i16 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.orderNoteFromSeller;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.buyerMobile;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ECOrderDetailAccountInfoData eCOrderDetailAccountInfoData = this.accountInfo;
        int hashCode8 = (hashCode7 + (eCOrderDetailAccountInfoData != null ? eCOrderDetailAccountInfoData.hashCode() : 0)) * 31;
        LogisticsInfo logisticsInfo = this.logisticsInfo;
        int hashCode9 = (hashCode8 + (logisticsInfo != null ? logisticsInfo.hashCode() : 0)) * 31;
        ECAddress eCAddress = this.addressInfo;
        int hashCode10 = (hashCode9 + (eCAddress != null ? eCAddress.hashCode() : 0)) * 31;
        OrderDetailCheckValidData orderDetailCheckValidData = this.modifyAddressValidInfo;
        int hashCode11 = (hashCode10 + (orderDetailCheckValidData != null ? orderDetailCheckValidData.hashCode() : 0)) * 31;
        List<OrderSkuDetail> list = this.orderSkuInfo;
        int hashCode12 = (hashCode11 + (list != null ? list.hashCode() : 0)) * 31;
        List<OrderSpuDetail> list2 = this.orderSpuInfo;
        int hashCode13 = (hashCode12 + (list2 != null ? list2.hashCode() : 0)) * 31;
        ECOrderDetailPayInfo eCOrderDetailPayInfo = this.payInfo;
        int hashCode14 = (hashCode13 + (eCOrderDetailPayInfo != null ? eCOrderDetailPayInfo.hashCode() : 0)) * 31;
        f.TicketInfoData ticketInfoData = this.ticketInfo;
        int hashCode15 = (hashCode14 + (ticketInfoData != null ? ticketInfoData.hashCode() : 0)) * 31;
        List<QShopOrderPromoInfo> list3 = this.promoInfos;
        int hashCode16 = (hashCode15 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<QShopOrderCouponInfo> list4 = this.usedCouponInfo;
        int hashCode17 = (hashCode16 + (list4 != null ? list4.hashCode() : 0)) * 31;
        ECOrderDetailGoodsOperateState eCOrderDetailGoodsOperateState = this.goodsOperateState;
        int hashCode18 = (hashCode17 + (eCOrderDetailGoodsOperateState != null ? eCOrderDetailGoodsOperateState.hashCode() : 0)) * 31;
        List<ECProductRecommendItemData> list5 = this.recommendList;
        int hashCode19 = (hashCode18 + (list5 != null ? list5.hashCode() : 0)) * 31;
        ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility = this.widgetsVisibility;
        int hashCode20 = (hashCode19 + (eCOrderDetailWidgetsVisibility != null ? eCOrderDetailWidgetsVisibility.hashCode() : 0)) * 31;
        OrderStateUpdateType orderStateUpdateType = this.updateType;
        int hashCode21 = (hashCode20 + (orderStateUpdateType != null ? orderStateUpdateType.hashCode() : 0)) * 31;
        BulletinInfo bulletinInfo = this.bulletinInfo;
        int hashCode22 = (hashCode21 + (bulletinInfo != null ? bulletinInfo.hashCode() : 0)) * 31;
        List<ECExtraJumpInfo> list6 = this.extraJumpInfoList;
        int hashCode23 = (hashCode22 + (list6 != null ? list6.hashCode() : 0)) * 31;
        String str7 = this.blindBoxWareHouseLink;
        int hashCode24 = (hashCode23 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.deliverMessage;
        return hashCode24 + (str8 != null ? str8.hashCode() : 0);
    }

    public final List<QShopOrderCouponInfo> i() {
        return this.usedCouponInfo;
    }

    public String toString() {
        return "ECOrderDetailState(orderId=" + this.orderId + ", orderStateVal=" + this.orderStateVal + ", headerState=" + this.headerState + ", preferOrderStateTitle=" + this.preferOrderStateTitle + ", preferOrderStateDesc=" + this.preferOrderStateDesc + ", createTimestampMs=" + this.createTimestampMs + ", deadlineMs=" + this.deadlineMs + ", hasComment=" + this.hasComment + ", orderNote=" + this.orderNote + ", orderNoteFromSeller=" + this.orderNoteFromSeller + ", buyerMobile=" + this.buyerMobile + ", accountInfo=" + this.accountInfo + ", logisticsInfo=" + this.logisticsInfo + ", addressInfo=" + this.addressInfo + ", modifyAddressValidInfo=" + this.modifyAddressValidInfo + ", orderSkuInfo=" + this.orderSkuInfo + ", orderSpuInfo=" + this.orderSpuInfo + ", payInfo=" + this.payInfo + ", ticketInfo=" + this.ticketInfo + ", promoInfos=" + this.promoInfos + ", usedCouponInfo=" + this.usedCouponInfo + ", goodsOperateState=" + this.goodsOperateState + ", recommendList=" + this.recommendList + ", widgetsVisibility=" + this.widgetsVisibility + ", updateType=" + this.updateType + ", bulletinInfo=" + this.bulletinInfo + ", extraJumpInfoList=" + this.extraJumpInfoList + ", blindBoxWareHouseLink=" + this.blindBoxWareHouseLink + ", deliverMessage=" + this.deliverMessage + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ECOrderDetailState(String str, int i3, ECOrderDetailHeaderState eCOrderDetailHeaderState, String str2, String str3, long j3, long j16, boolean z16, String str4, String str5, String str6, ECOrderDetailAccountInfoData eCOrderDetailAccountInfoData, LogisticsInfo logisticsInfo, ECAddress eCAddress, OrderDetailCheckValidData orderDetailCheckValidData, List list, List list2, ECOrderDetailPayInfo eCOrderDetailPayInfo, f.TicketInfoData ticketInfoData, List list3, List list4, ECOrderDetailGoodsOperateState eCOrderDetailGoodsOperateState, List list5, ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility, OrderStateUpdateType orderStateUpdateType, BulletinInfo bulletinInfo, List list6, String str7, String str8, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, r7, r8, str3, j3, r12, r14, r15, r16, r17, r18, logisticsInfo, eCAddress, orderDetailCheckValidData, list, list2, eCOrderDetailPayInfo, r25, r26, r27, eCOrderDetailGoodsOperateState, r29, eCOrderDetailWidgetsVisibility, r31, r32, r33, (134217728 & i16) != 0 ? "" : str7, (i16 & 268435456) != 0 ? "" : str8);
        List list7;
        List list8;
        List list9;
        List list10;
        List emptyList;
        List emptyList2;
        List emptyList3;
        List emptyList4;
        ECOrderDetailHeaderState eCOrderDetailHeaderState2 = (i16 & 4) != 0 ? new ECOrderDetailHeaderState(null, null, 3, null) : eCOrderDetailHeaderState;
        String str9 = (i16 & 8) != 0 ? "" : str2;
        long j17 = (i16 & 64) != 0 ? 0L : j16;
        boolean z17 = (i16 & 128) != 0 ? false : z16;
        String str10 = (i16 & 256) != 0 ? "" : str4;
        String str11 = (i16 & 512) != 0 ? "" : str5;
        String str12 = (i16 & 1024) != 0 ? "" : str6;
        ECOrderDetailAccountInfoData eCOrderDetailAccountInfoData2 = (i16 & 2048) != 0 ? new ECOrderDetailAccountInfoData(0, null, null, 7, null) : eCOrderDetailAccountInfoData;
        f.TicketInfoData ticketInfoData2 = (262144 & i16) != 0 ? null : ticketInfoData;
        if ((524288 & i16) != 0) {
            emptyList4 = CollectionsKt__CollectionsKt.emptyList();
            list7 = emptyList4;
        } else {
            list7 = list3;
        }
        if ((1048576 & i16) != 0) {
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            list8 = emptyList3;
        } else {
            list8 = list4;
        }
        if ((4194304 & i16) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list9 = emptyList2;
        } else {
            list9 = list5;
        }
        OrderStateUpdateType orderStateUpdateType2 = (16777216 & i16) != 0 ? OrderStateUpdateType.ALL : orderStateUpdateType;
        BulletinInfo bulletinInfo2 = (33554432 & i16) != 0 ? null : bulletinInfo;
        if ((67108864 & i16) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list10 = emptyList;
        } else {
            list10 = list6;
        }
    }

    public final OrderSnapShotData a() {
        Object first;
        int collectionSizeOrDefault;
        Object first2;
        int collectionSizeOrDefault2;
        Object first3;
        Object first4;
        int collectionSizeOrDefault3;
        Object first5;
        int collectionSizeOrDefault4;
        Object first6;
        Object first7;
        Object first8;
        Object first9;
        Object first10;
        String joinToString$default;
        Object first11;
        String joinToString$default2;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSpuInfo);
        List<OrderSpuPicInfo> b16 = ((OrderSpuDetail) first).b();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (OrderSpuPicInfo orderSpuPicInfo : b16) {
            arrayList.add(new SnapshotProductPic(orderSpuPicInfo.url, orderSpuPicInfo.width, orderSpuPicInfo.height));
        }
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSpuInfo);
        List<OrderSpuPicInfo> a16 = ((OrderSpuDetail) first2).a();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (OrderSpuPicInfo orderSpuPicInfo2 : a16) {
            arrayList2.add(new SnapshotProductPic(orderSpuPicInfo2.url, orderSpuPicInfo2.width, orderSpuPicInfo2.height));
        }
        com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
        first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSpuInfo);
        SnapshotProductPrice snapshotProductPrice = new SnapshotProductPrice(iVar.d(((OrderSpuDetail) first3).minPrice));
        first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSkuInfo);
        List<OrderSkuSpec> d16 = ((OrderSkuDetail) first4).d();
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(d16, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        for (OrderSkuSpec orderSkuSpec : d16) {
            arrayList3.add(new SnapshotSpecification(orderSkuSpec.name, orderSkuSpec.value));
        }
        first5 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSpuInfo);
        List<OrderSpuProperty> c16 = ((OrderSpuDetail) first5).c();
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault4);
        for (OrderSpuProperty orderSpuProperty : c16) {
            arrayList4.add(new SnapshotProductProp(orderSpuProperty.id, orderSpuProperty.name, orderSpuProperty.value));
        }
        first6 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSpuInfo);
        String str = ((OrderSpuDetail) first6).title;
        first7 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSpuInfo);
        SnapshotProduct snapshotProduct = new SnapshotProduct(arrayList, arrayList, arrayList2, str, ((OrderSpuDetail) first7).id, snapshotProductPrice, arrayList3, arrayList4);
        first8 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSkuInfo);
        OrderShop orderShop = ((OrderSkuDetail) first8).shop;
        SnapshotShopInfo snapshotShopInfo = new SnapshotShopInfo(orderShop.id, orderShop.avatarUrl, orderShop.name, null, 8, null);
        first9 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSpuInfo);
        SnapshotProductInfo snapshotProductInfo = new SnapshotProductInfo(((OrderSpuDetail) first9).id, 0, snapshotProduct, snapshotShopInfo, 2, null);
        String str2 = this.orderId;
        first10 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSkuInfo);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(((OrderSkuDetail) first10).d(), null, null, null, 0, null, new Function1<OrderSkuSpec, CharSequence>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState$composeSnapshotData$orderInfo$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(OrderSkuSpec orderSkuSpec2) {
                return orderSkuSpec2.value;
            }
        }, 31, null);
        first11 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.orderSpuInfo);
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(((OrderSpuDetail) first11).c(), null, null, null, 0, null, new Function1<OrderSpuProperty, CharSequence>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState$composeSnapshotData$orderInfo$2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(OrderSpuProperty orderSpuProperty2) {
                return orderSpuProperty2.name;
            }
        }, 31, null);
        return new OrderSnapShotData(snapshotProductInfo, new SnapshotOrderInfo(str2, joinToString$default, joinToString$default2));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderDetailState)) {
            return false;
        }
        ECOrderDetailState eCOrderDetailState = (ECOrderDetailState) other;
        return Intrinsics.areEqual(this.orderId, eCOrderDetailState.orderId) && this.orderStateVal == eCOrderDetailState.orderStateVal && Intrinsics.areEqual(this.headerState, eCOrderDetailState.headerState) && Intrinsics.areEqual(this.preferOrderStateTitle, eCOrderDetailState.preferOrderStateTitle) && Intrinsics.areEqual(this.preferOrderStateDesc, eCOrderDetailState.preferOrderStateDesc) && this.createTimestampMs == eCOrderDetailState.createTimestampMs && this.deadlineMs == eCOrderDetailState.deadlineMs && this.hasComment == eCOrderDetailState.hasComment && Intrinsics.areEqual(this.orderNote, eCOrderDetailState.orderNote) && Intrinsics.areEqual(this.orderNoteFromSeller, eCOrderDetailState.orderNoteFromSeller) && Intrinsics.areEqual(this.buyerMobile, eCOrderDetailState.buyerMobile) && Intrinsics.areEqual(this.accountInfo, eCOrderDetailState.accountInfo) && Intrinsics.areEqual(this.logisticsInfo, eCOrderDetailState.logisticsInfo) && Intrinsics.areEqual(this.addressInfo, eCOrderDetailState.addressInfo) && Intrinsics.areEqual(this.modifyAddressValidInfo, eCOrderDetailState.modifyAddressValidInfo) && Intrinsics.areEqual(this.orderSkuInfo, eCOrderDetailState.orderSkuInfo) && Intrinsics.areEqual(this.orderSpuInfo, eCOrderDetailState.orderSpuInfo) && Intrinsics.areEqual(this.payInfo, eCOrderDetailState.payInfo) && Intrinsics.areEqual(this.ticketInfo, eCOrderDetailState.ticketInfo) && Intrinsics.areEqual(this.promoInfos, eCOrderDetailState.promoInfos) && Intrinsics.areEqual(this.usedCouponInfo, eCOrderDetailState.usedCouponInfo) && Intrinsics.areEqual(this.goodsOperateState, eCOrderDetailState.goodsOperateState) && Intrinsics.areEqual(this.recommendList, eCOrderDetailState.recommendList) && Intrinsics.areEqual(this.widgetsVisibility, eCOrderDetailState.widgetsVisibility) && Intrinsics.areEqual(this.updateType, eCOrderDetailState.updateType) && Intrinsics.areEqual(this.bulletinInfo, eCOrderDetailState.bulletinInfo) && Intrinsics.areEqual(this.extraJumpInfoList, eCOrderDetailState.extraJumpInfoList) && Intrinsics.areEqual(this.blindBoxWareHouseLink, eCOrderDetailState.blindBoxWareHouseLink) && Intrinsics.areEqual(this.deliverMessage, eCOrderDetailState.deliverMessage);
    }
}
