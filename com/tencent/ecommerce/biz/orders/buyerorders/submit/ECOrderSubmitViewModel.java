package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.plugin.ECPluginApplication;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.l;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.AddressCheckResult;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.CalculatePriceScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitDetailInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitPriceInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.VirtualProductAccount;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j;
import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import com.tencent.ecommerce.biz.orders.realname.IECRealNameListRepo;
import com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$LabelInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CaptchaToken;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CommitOrderResult;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00c9\u00012\u00020\u0001:\n\u00ca\u0001\u00cb\u0001\u00cc\u0001\u00cd\u0001\u00ce\u0001BF\u0012\u0007\u0010\u00b0\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u00b2\u0001\u001a\u0004\u0018\u00010\f\u0012\u000b\b\u0002\u0010\u00b4\u0001\u001a\u0004\u0018\u00010\f\u0012\u000b\b\u0002\u0010\u00b6\u0001\u001a\u0004\u0018\u00010\f\u0012\u000b\b\u0002\u0010\u00b9\u0001\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0006\b\u00c7\u0001\u0010\u00c8\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ:\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00062\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013J#\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001dJ\u001b\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J$\u0010)\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010(\u001a\u00020\u0006J+\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\fJ\u0014\u00100\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0013J%\u00104\u001a\u0004\u0018\u0001032\u0006\u00102\u001a\u0002012\u0006\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u00105J\u0018\u00108\u001a\u0002012\u0006\u00106\u001a\u0002012\u0006\u00107\u001a\u000201H\u0002J\u0010\u0010:\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u000209H\u0002J\u0012\u0010;\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001dH\u0002J \u0010?\u001a\u000201*\u0002012\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0<H\u0002J\u001e\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\u0013*\u0002012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@H\u0002J\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020B0\u0013*\u0002012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@H\u0002J\u0012\u0010E\u001a\b\u0012\u0004\u0012\u00020B0\u0013*\u000201H\u0002J\u001c\u0010K\u001a\u00020J*\u00020F2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u000201H\u0002R\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001a\u0010_\u001a\b\u0012\u0004\u0012\u0002010\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020`0\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010^R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00060\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010^R\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00060\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010^R\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020\u000e0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020k0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010iR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020\u000e0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010iR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020p0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010iR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020s0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010iR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020s0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010iR\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000e0x8\u0006\u00a2\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u001e\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020k0x8\u0006\u00a2\u0006\f\n\u0004\b~\u0010z\u001a\u0004\b\u007f\u0010|R \u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0x8\u0006\u00a2\u0006\u000e\n\u0005\b\u0081\u0001\u0010z\u001a\u0005\b\u0082\u0001\u0010|R \u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020p0x8\u0006\u00a2\u0006\u000e\n\u0005\b\u0084\u0001\u0010z\u001a\u0005\b\u0085\u0001\u0010|R \u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020s0x8\u0006\u00a2\u0006\u000e\n\u0005\b\u0087\u0001\u0010z\u001a\u0005\b\u0088\u0001\u0010|R \u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020s0x8\u0006\u00a2\u0006\u000e\n\u0005\b\u008a\u0001\u0010z\u001a\u0005\b\u008b\u0001\u0010|R\u001a\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R#\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020`0\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R#\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0094\u0001\u001a\u0006\b\u0099\u0001\u0010\u0096\u0001R#\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u0094\u0001\u001a\u0006\b\u009c\u0001\u0010\u0096\u0001R$\u0010\u00a1\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009f\u0001\u0010\u0094\u0001\u001a\u0006\b\u00a0\u0001\u0010\u0096\u0001R#\u0010\u00a4\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a2\u0001\u0010\u0094\u0001\u001a\u0006\b\u00a3\u0001\u0010\u0096\u0001R#\u0010\u00a7\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a5\u0001\u0010\u0094\u0001\u001a\u0006\b\u00a6\u0001\u0010\u0096\u0001R#\u0010\u00aa\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a8\u0001\u0010\u0094\u0001\u001a\u0006\b\u00a9\u0001\u0010\u0096\u0001R)\u0010\u00ad\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u00130\u0092\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ab\u0001\u0010\u0094\u0001\u001a\u0006\b\u00ac\u0001\u0010\u0096\u0001R\u0017\u0010\u00b0\u0001\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u001b\u0010\u00b2\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u0090\u0001R\u001b\u0010\u00b4\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u0090\u0001R\u0019\u0010\u00b6\u0001\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u0090\u0001R\u0019\u0010\u00b9\u0001\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\u0015\u0010.\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\b\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u0014\u0010\u00be\u0001\u001a\u00020\u00068F\u00a2\u0006\b\u001a\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u0016\u0010\u00c1\u0001\u001a\u0004\u0018\u00010\u001d8F\u00a2\u0006\b\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u0016\u0010+\u001a\u0005\u0018\u00010\u00c2\u00018F\u00a2\u0006\b\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u0014\u0010\u00c6\u0001\u001a\u00020\u00068F\u00a2\u0006\b\u001a\u0006\b\u00c5\u0001\u0010\u00bd\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00cf\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel;", "Landroidx/lifecycle/ViewModel;", "", "R2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "simpleSku", "", "isRefresh", "t2", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "o2", "", "orderGoodsId", "", "quantity", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;", "scene", "forceUpdateQuantity", "", "couponsIds", "m2", "maxQuantity", "v2", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "note", "c3", "account", "f3", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "e3", "r2", "(Lcom/tencent/ecommerce/biz/orders/realname/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "q2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "d3", "isUserAction", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CaptchaToken;", "captchaToken", "hasDoubleCheckVirtualProductAccount", "T2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j$b;", "productType", ICustomDataEditor.STRING_PARAM_2, "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j$b;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Q2", "S2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "orderDetail", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/a;", "p2", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userEditedInfo", "remoteLatestInfo", "P2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/k;", "h3", "g3", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "change", "b3", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/m;", "errorTipsItemData", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "V2", "W2", ICustomDataEditor.STRING_ARRAY_PARAM_3, "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CommitOrderResult;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "orderDetailRsp", "orderSubmitInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h$b;", "Y2", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo;", "i", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo;", "orderSubmitRepo", "Lcom/tencent/ecommerce/repo/buyerorder/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/repo/buyerorder/b;", "orderRepository", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameOperateRepo;", "realNameRepo", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameListRepo;", "D", "Lcom/tencent/ecommerce/biz/orders/realname/IECRealNameListRepo;", "realNameListRepo", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_orderSubmitDetailInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", UserInfo.SEX_FEMALE, "_pageState", "G", "_isAddressReachable", "H", "_submitEnabled", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "I", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_bestCouponSelectedEvent", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h;", "J", "_submitResult", "K", "_realNameDialogEvent", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/l;", "L", "_errorEvent", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$f;", "M", "_reportExposureEvent", "N", "_reportSubmitEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "P", "Lkotlinx/coroutines/flow/SharedFlow;", "w2", "()Lkotlinx/coroutines/flow/SharedFlow;", "bestCouponSelectedEvent", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "N2", "submitResult", BdhLogUtil.LogTag.Tag_Req, "H2", "realNameDialogEvent", ExifInterface.LATITUDE_SOUTH, "y2", "errorEvent", "T", "I2", "reportExposureEvent", "U", "J2", "reportSubmitEvent", "V", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "W", "Ljava/lang/String;", "pageExt", "Landroidx/lifecycle/LiveData;", "X", "Landroidx/lifecycle/LiveData;", "C2", "()Landroidx/lifecycle/LiveData;", "pageState", "Y", "M2", "submitEnabled", "Z", "L2", "showBelowZeroTips", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;", "a0", Constants.BASE_IN_PLUGIN_VERSION, "priceInfo", "b0", "x2", "blindBoxAgreementVersion", "c0", Constants.MMCCID, "qShopProductAgreementVersion", "d0", "F2", "qShopPrivacyAgreementVersion", "e0", NowProxyConstants.AccountInfoKey.A2, "listData", "f0", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "initialSimpleSku", "g0", "activityId", "h0", "adClickId", "i0", "groupId", "j0", "Ljava/lang/Boolean;", "isBuyAll", "B2", "()Ljava/lang/String;", "z2", "()Z", "hasRealNameAccount", "K2", "()Lcom/tencent/ecommerce/biz/orders/realname/a;", "selectedRealNameAccount", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "E2", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j;", "O2", "isJiGuangShang", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "k0", "d", "e", "f", "g", tl.h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final IECRealNameOperateRepo realNameRepo;

    /* renamed from: D, reason: from kotlin metadata */
    private final IECRealNameListRepo realNameListRepo;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<OrderSubmitDetailInfo> _orderSubmitDetailInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<g> _pageState;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isAddressReachable;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _submitEnabled;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableSharedFlow<Integer> _bestCouponSelectedEvent;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableSharedFlow<h> _submitResult;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableSharedFlow<Integer> _realNameDialogEvent;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> _errorEvent;

    /* renamed from: M, reason: from kotlin metadata */
    private final MutableSharedFlow<OrderSubmitReportInfo> _reportExposureEvent;

    /* renamed from: N, reason: from kotlin metadata */
    private final MutableSharedFlow<OrderSubmitReportInfo> _reportSubmitEvent;

    /* renamed from: P, reason: from kotlin metadata */
    private final SharedFlow<Integer> bestCouponSelectedEvent;

    /* renamed from: Q, reason: from kotlin metadata */
    private final SharedFlow<h> submitResult;

    /* renamed from: R, reason: from kotlin metadata */
    private final SharedFlow<Integer> realNameDialogEvent;

    /* renamed from: S, reason: from kotlin metadata */
    private final SharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> errorEvent;

    /* renamed from: T, reason: from kotlin metadata */
    private final SharedFlow<OrderSubmitReportInfo> reportExposureEvent;

    /* renamed from: U, reason: from kotlin metadata */
    private final SharedFlow<OrderSubmitReportInfo> reportSubmitEvent;

    /* renamed from: V, reason: from kotlin metadata */
    private ECQshopOrderQuerySvr$OrderPageDetailRsp orderDetailRsp;

    /* renamed from: W, reason: from kotlin metadata */
    private String pageExt;

    /* renamed from: X, reason: from kotlin metadata */
    private final LiveData<g> pageState;

    /* renamed from: Y, reason: from kotlin metadata */
    private final LiveData<Boolean> submitEnabled;

    /* renamed from: Z, reason: from kotlin metadata */
    private final LiveData<Boolean> showBelowZeroTips;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<OrderSubmitPriceInfo> priceInfo;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> blindBoxAgreementVersion;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> qShopProductAgreementVersion;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> qShopPrivacyAgreementVersion;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<p>> listData;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final SimpleSku initialSimpleSku;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String activityId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String adClickId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final IECOrderSubmitRepo orderSubmitRepo;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final String groupId;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final Boolean isBuyAll;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.repo.buyerorder.b orderRepository;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;)V", "com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$submitEnabled$1$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a<T> implements Observer<OrderSubmitDetailInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103506d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECOrderSubmitViewModel f103507e;

        a(MediatorLiveData mediatorLiveData, ECOrderSubmitViewModel eCOrderSubmitViewModel) {
            this.f103506d = mediatorLiveData;
            this.f103507e = eCOrderSubmitViewModel;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(OrderSubmitDetailInfo orderSubmitDetailInfo) {
            boolean z16 = false;
            boolean z17 = orderSubmitDetailInfo.orderSkusDetail.quantity > 0;
            MediatorLiveData mediatorLiveData = this.f103506d;
            if (z17) {
                Boolean bool = (Boolean) this.f103507e._isAddressReachable.getValue();
                if (bool != null ? bool.booleanValue() : true) {
                    z16 = true;
                }
            }
            mediatorLiveData.setValue(Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V", "com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$submitEnabled$1$3"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b<T> implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103508d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECOrderSubmitViewModel f103509e;

        b(MediatorLiveData mediatorLiveData, ECOrderSubmitViewModel eCOrderSubmitViewModel) {
            this.f103508d = mediatorLiveData;
            this.f103509e = eCOrderSubmitViewModel;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            OrderSubmitDetailInfo orderSubmitDetailInfo = (OrderSubmitDetailInfo) this.f103509e._orderSubmitDetailInfo.getValue();
            boolean z16 = false;
            boolean z17 = orderSubmitDetailInfo == null || orderSubmitDetailInfo.orderSkusDetail.quantity > 0;
            MediatorLiveData mediatorLiveData = this.f103508d;
            if (z17 && bool.booleanValue()) {
                z16 = true;
            }
            mediatorLiveData.setValue(Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "kotlin.jvm.PlatformType", "orderDetail", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;)V", "com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$listData$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c<T> implements Observer<OrderSubmitDetailInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103510d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECOrderSubmitViewModel f103511e;

        c(MediatorLiveData mediatorLiveData, ECOrderSubmitViewModel eCOrderSubmitViewModel) {
            this.f103510d = mediatorLiveData;
            this.f103511e = eCOrderSubmitViewModel;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(OrderSubmitDetailInfo orderSubmitDetailInfo) {
            p pVar;
            Object firstOrNull;
            List list = (List) this.f103510d.getValue();
            if (list != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                pVar = (p) firstOrNull;
            } else {
                pVar = null;
            }
            this.f103510d.setValue(this.f103511e.V2(orderSubmitDetailInfo, (ErrorTipsItemData) (pVar instanceof ErrorTipsItemData ? pVar : null)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class g {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "msg", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$g$a, reason: from toString */
        /* loaded from: classes31.dex */
        public static final /* data */ class Empty extends g {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final String msg;

            public Empty() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public int hashCode() {
                String str = this.msg;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Empty(msg=" + this.msg + ")";
            }

            public Empty(String str) {
                super(null);
                this.msg = str;
            }

            public /* synthetic */ Empty(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? "" : str);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && Intrinsics.areEqual(this.msg, ((Empty) other).msg);
                }
                return true;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "code", "b", "Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$g$b, reason: from toString */
        /* loaded from: classes31.dex */
        public static final /* data */ class Error extends g {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final int code;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String msg;

            public int hashCode() {
                int i3 = this.code * 31;
                String str = this.msg;
                return i3 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                return "Error(code=" + this.code + ", msg=" + this.msg + ")";
            }

            public Error(int i3, String str) {
                super(null);
                this.code = i3;
                this.msg = str;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return this.code == error.code && Intrinsics.areEqual(this.msg, error.msg);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class c extends g {

            /* renamed from: a, reason: collision with root package name */
            public static final c f103527a = new c();

            c() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class d extends g {

            /* renamed from: a, reason: collision with root package name */
            public static final d f103528a = new d();

            d() {
                super(null);
            }
        }

        g() {
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h;", "", "<init>", "()V", "a", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h$b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h$a;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class h {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "type", "b", "code", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "<init>", "(IILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$h$a, reason: from toString */
        /* loaded from: classes31.dex */
        public static final /* data */ class SubmitFailedResult extends h {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final int type;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final int code;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private final String msg;

            public /* synthetic */ SubmitFailedResult(int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
                this((i17 & 1) != 0 ? 0 : i3, i16, (i17 & 4) != 0 ? "" : str);
            }

            /* renamed from: a, reason: from getter */
            public final String getMsg() {
                return this.msg;
            }

            public int hashCode() {
                int i3 = ((this.type * 31) + this.code) * 31;
                String str = this.msg;
                return i3 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                return "SubmitFailedResult(type=" + this.type + ", code=" + this.code + ", msg=" + this.msg + ")";
            }

            public SubmitFailedResult(int i3, int i16, String str) {
                super(null);
                this.type = i3;
                this.code = i16;
                this.msg = str;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubmitFailedResult)) {
                    return false;
                }
                SubmitFailedResult submitFailedResult = (SubmitFailedResult) other;
                return this.type == submitFailedResult.type && this.code == submitFailedResult.code && Intrinsics.areEqual(this.msg, submitFailedResult.msg);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\n\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0012\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h$b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$h;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "payTokenUrl", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "orderIds", "c", "d", "spuList", "", "J", "orderPrice", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "e", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "()Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "orderDetailRsp", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "f", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;JLcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$h$b, reason: from toString */
        /* loaded from: classes31.dex */
        public static final /* data */ class SubmitSucceedResult extends h {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final String payTokenUrl;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final List<String> orderIds;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private final List<String> spuList;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final long orderPrice;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            private final ECQshopOrderQuerySvr$OrderPageDetailRsp orderDetailRsp;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
            private final PayType payType;

            /* renamed from: a, reason: from getter */
            public final ECQshopOrderQuerySvr$OrderPageDetailRsp getOrderDetailRsp() {
                return this.orderDetailRsp;
            }

            public final List<String> b() {
                return this.orderIds;
            }

            /* renamed from: c, reason: from getter */
            public final PayType getPayType() {
                return this.payType;
            }

            public final List<String> d() {
                return this.spuList;
            }

            public int hashCode() {
                String str = this.payTokenUrl;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<String> list = this.orderIds;
                int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                List<String> list2 = this.spuList;
                int hashCode3 = (((hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.orderPrice)) * 31;
                ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp = this.orderDetailRsp;
                int hashCode4 = (hashCode3 + (eCQshopOrderQuerySvr$OrderPageDetailRsp != null ? eCQshopOrderQuerySvr$OrderPageDetailRsp.hashCode() : 0)) * 31;
                PayType payType = this.payType;
                return hashCode4 + (payType != null ? payType.hashCode() : 0);
            }

            public String toString() {
                return "SubmitSucceedResult(payTokenUrl=" + this.payTokenUrl + ", orderIds=" + this.orderIds + ", spuList=" + this.spuList + ", orderPrice=" + this.orderPrice + ", orderDetailRsp=" + this.orderDetailRsp + ", payType=" + this.payType + ")";
            }

            public SubmitSucceedResult(String str, List<String> list, List<String> list2, long j3, ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp, PayType payType) {
                super(null);
                this.payTokenUrl = str;
                this.orderIds = list;
                this.spuList = list2;
                this.orderPrice = j3;
                this.orderDetailRsp = eCQshopOrderQuerySvr$OrderPageDetailRsp;
                this.payType = payType;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubmitSucceedResult)) {
                    return false;
                }
                SubmitSucceedResult submitSucceedResult = (SubmitSucceedResult) other;
                return Intrinsics.areEqual(this.payTokenUrl, submitSucceedResult.payTokenUrl) && Intrinsics.areEqual(this.orderIds, submitSucceedResult.orderIds) && Intrinsics.areEqual(this.spuList, submitSucceedResult.spuList) && this.orderPrice == submitSucceedResult.orderPrice && Intrinsics.areEqual(this.orderDetailRsp, submitSucceedResult.orderDetailRsp) && Intrinsics.areEqual(this.payType, submitSucceedResult.payType);
            }
        }

        h() {
        }

        public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "kotlin.jvm.PlatformType", "orderDetail", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class i<T> implements Observer<OrderSubmitDetailInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103538d;

        i(MediatorLiveData mediatorLiveData) {
            this.f103538d = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(OrderSubmitDetailInfo orderSubmitDetailInfo) {
            if (com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.b(orderSubmitDetailInfo.orderSkusDetail.productType) && (!Intrinsics.areEqual((String) this.f103538d.getValue(), orderSubmitDetailInfo.blindBoxAgreementVersion))) {
                this.f103538d.setValue(orderSubmitDetailInfo.blindBoxAgreementVersion);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class j<T> implements Observer<OrderSubmitDetailInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103539d;

        j(MediatorLiveData mediatorLiveData) {
            this.f103539d = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(OrderSubmitDetailInfo orderSubmitDetailInfo) {
            Object obj = (OrderSubmitPriceInfo) this.f103539d.getValue();
            if (obj == null) {
                obj = 0L;
            }
            OrderSubmitPriceInfo orderSubmitPriceInfo = orderSubmitDetailInfo.priceInfo;
            if (!Intrinsics.areEqual(obj, orderSubmitPriceInfo)) {
                this.f103539d.setValue(orderSubmitPriceInfo);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class k<T> implements Observer<OrderSubmitDetailInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103540d;

        k(MediatorLiveData mediatorLiveData) {
            this.f103540d = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(OrderSubmitDetailInfo orderSubmitDetailInfo) {
            this.f103540d.setValue(orderSubmitDetailInfo.qShopPrivacyAgreementVersion);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class l<T> implements Observer<OrderSubmitDetailInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103541d;

        l(MediatorLiveData mediatorLiveData) {
            this.f103541d = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(OrderSubmitDetailInfo orderSubmitDetailInfo) {
            if (com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.b(orderSubmitDetailInfo.orderSkusDetail.productType) || !(!Intrinsics.areEqual((String) this.f103541d.getValue(), orderSubmitDetailInfo.qShopProductAgreementVersion))) {
                return;
            }
            this.f103541d.setValue(orderSubmitDetailInfo.qShopProductAgreementVersion);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class m<T> implements Observer<OrderSubmitDetailInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103543d;

        m(MediatorLiveData mediatorLiveData) {
            this.f103543d = mediatorLiveData;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        
            if (r3.get() == true) goto L10;
         */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onChanged(OrderSubmitDetailInfo orderSubmitDetailInfo) {
            MediatorLiveData mediatorLiveData = this.f103543d;
            ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo = orderSubmitDetailInfo.couponInfo;
            boolean z16 = (eCQshopOrderQuerySvr$CouponInfo == null || (r3 = eCQshopOrderQuerySvr$CouponInfo.is_price_below_zero) == null) ? false : true;
            mediatorLiveData.setValue(Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class n<T> implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f103544d;

        n(MediatorLiveData mediatorLiveData) {
            this.f103544d = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            this.f103544d.setValue(bool);
        }
    }

    public /* synthetic */ ECOrderSubmitViewModel(SimpleSku simpleSku, String str, String str2, String str3, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleSku, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<p> V2(OrderSubmitDetailInfo orderSubmitDetailInfo, ErrorTipsItemData errorTipsItemData) {
        if (orderSubmitDetailInfo.orderSkusDetail.productType instanceof j.PhysicalProduct) {
            return W2(orderSubmitDetailInfo, errorTipsItemData);
        }
        return a3(orderSubmitDetailInfo);
    }

    private final List<p> W2(OrderSubmitDetailInfo orderSubmitDetailInfo, ErrorTipsItemData errorTipsItemData) {
        ArrayList arrayList = new ArrayList();
        if (errorTipsItemData != null) {
            arrayList.add(errorTipsItemData);
        }
        BulletinInfo bulletinInfo = orderSubmitDetailInfo.bulletinInfo;
        if (bulletinInfo != null) {
            String str = bulletinInfo.title;
            String str2 = bulletinInfo.content;
            OrderSkuDetail orderSkuDetail = orderSubmitDetailInfo.orderSkusDetail;
            arrayList.add(new BulletinItemData(str, str2, orderSkuDetail.shop.id, orderSkuDetail.spuId));
        }
        arrayList.add(new AddressItemData(orderSubmitDetailInfo.address));
        if (!Intrinsics.areEqual(orderSubmitDetailInfo.orderSkusDetail, com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.a())) {
            OrderSkuDetail orderSkuDetail2 = orderSubmitDetailInfo.orderSkusDetail;
            ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo = orderSubmitDetailInfo.enableCoupon ? orderSubmitDetailInfo.couponInfo : null;
            List<ECOrderInfo$LabelInfo> d16 = orderSubmitDetailInfo.d();
            String str3 = orderSubmitDetailInfo.deliveryMessage;
            Boolean bool = this.isBuyAll;
            arrayList.add(new OrderItemData(orderSkuDetail2, eCQshopOrderQuerySvr$CouponInfo, d16, str3, bool != null ? bool.booleanValue() : false));
        }
        if (orderSubmitDetailInfo.selectedPayType != PayType.UNKNOWN && (!orderSubmitDetailInfo.e().isEmpty())) {
            arrayList.add(new PayInfoItemData(orderSubmitDetailInfo.selectedPayType, orderSubmitDetailInfo.e()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (r10.box_order_ids.get().size() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final h.SubmitSucceedResult Y2(ECQshopOrderSvr$CommitOrderResult eCQshopOrderSvr$CommitOrderResult, ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp, OrderSubmitDetailInfo orderSubmitDetailInfo) {
        String str;
        List<String> listOf;
        List listOf2;
        boolean z16 = eCQshopOrderSvr$CommitOrderResult.box_order_ids.has();
        if (z16) {
            str = "multi-lottery";
        } else {
            str = "normal";
        }
        cg0.a.b("ECOrderSubmitViewModel", "handle pay scene: " + str);
        if (!z16) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(eCQshopOrderSvr$CommitOrderResult.order_id.get());
        } else {
            listOf = eCQshopOrderSvr$CommitOrderResult.box_order_ids.get();
        }
        String str2 = eCQshopOrderSvr$CommitOrderResult.pay_url_params.get();
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(eCQshopOrderSvr$CommitOrderResult.spu_id.get());
        return new h.SubmitSucceedResult(str2, listOf, listOf2, eCQshopOrderSvr$CommitOrderResult.order_price.get(), eCQshopOrderQuerySvr$OrderPageDetailRsp, orderSubmitDetailInfo.selectedPayType);
    }

    private final List<p> a3(OrderSubmitDetailInfo orderSubmitDetailInfo) {
        ArrayList arrayList = new ArrayList();
        if (!Intrinsics.areEqual(orderSubmitDetailInfo.orderSkusDetail, com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d.a())) {
            arrayList.add(new OrderItemData(orderSubmitDetailInfo.orderSkusDetail, orderSubmitDetailInfo.enableCoupon ? orderSubmitDetailInfo.couponInfo : null, null, null, false, 28, null));
        }
        com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j jVar = orderSubmitDetailInfo.orderSkusDetail.productType;
        if (jVar instanceof j.VirtualProduct) {
            arrayList.add(new AccountInfoItemData((j.VirtualProduct) jVar));
        }
        if (orderSubmitDetailInfo.selectedPayType != PayType.UNKNOWN && (!orderSubmitDetailInfo.e().isEmpty())) {
            arrayList.add(new PayInfoItemData(orderSubmitDetailInfo.selectedPayType, orderSubmitDetailInfo.e()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h3(VirtualProductAccount account) {
        boolean z16;
        boolean isBlank;
        int i3 = account.type;
        String str = account.id;
        if (i3 == 1) {
            return gh0.e.f402043b.a(str);
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                return z16;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public final LiveData<List<p>> A2() {
        return this.listData;
    }

    public final String B2() {
        PBStringField pBStringField;
        ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp = this.orderDetailRsp;
        if (eCQshopOrderQuerySvr$OrderPageDetailRsp == null || (pBStringField = eCQshopOrderQuerySvr$OrderPageDetailRsp.order_id) == null) {
            return null;
        }
        return pBStringField.get();
    }

    public final LiveData<g> C2() {
        return this.pageState;
    }

    public final LiveData<OrderSubmitPriceInfo> D2() {
        return this.priceInfo;
    }

    public final com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j E2() {
        OrderSkuDetail orderSkuDetail;
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value == null || (orderSkuDetail = value.orderSkusDetail) == null) {
            return null;
        }
        return orderSkuDetail.productType;
    }

    public final LiveData<String> F2() {
        return this.qShopPrivacyAgreementVersion;
    }

    public final LiveData<String> G2() {
        return this.qShopProductAgreementVersion;
    }

    public final SharedFlow<Integer> H2() {
        return this.realNameDialogEvent;
    }

    public final SharedFlow<OrderSubmitReportInfo> I2() {
        return this.reportExposureEvent;
    }

    public final SharedFlow<OrderSubmitReportInfo> J2() {
        return this.reportSubmitEvent;
    }

    public final RealNameAccount K2() {
        OrderSkuDetail orderSkuDetail;
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j jVar = (value == null || (orderSkuDetail = value.orderSkusDetail) == null) ? null : orderSkuDetail.productType;
        if (!(jVar instanceof j.VirtualProduct)) {
            jVar = null;
        }
        j.VirtualProduct virtualProduct = (j.VirtualProduct) jVar;
        if (virtualProduct != null) {
            return virtualProduct.getRealNameAccount();
        }
        return null;
    }

    public final LiveData<Boolean> L2() {
        return this.showBelowZeroTips;
    }

    public final LiveData<Boolean> M2() {
        return this.submitEnabled;
    }

    public final SharedFlow<h> N2() {
        return this.submitResult;
    }

    public final boolean O2() {
        PBUInt32Field pBUInt32Field;
        ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp = this.orderDetailRsp;
        return (eCQshopOrderQuerySvr$OrderPageDetailRsp == null || (pBUInt32Field = eCQshopOrderQuerySvr$OrderPageDetailRsp.box_type) == null || pBUInt32Field.get() != 0) ? false : true;
    }

    public final void Q2(String orderId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderSubmitViewModel$notifyPaySucceed$1(this, orderId, null), 3, null);
    }

    public final void R2() {
        SimpleSku simpleSku;
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            OrderSkuDetail orderSkuDetail = value.orderSkusDetail;
            simpleSku = new SimpleSku(orderSkuDetail.skuId, orderSkuDetail.quantity);
        } else {
            simpleSku = this.initialSimpleSku;
        }
        t2(simpleSku, true);
    }

    public final void S2(List<String> couponsIds) {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("selectedCouponChanged ");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(couponsIds, ",", null, null, 0, null, null, 62, null);
        sb5.append(joinToString$default);
        cg0.a.b("ECOrderSubmitViewModel", sb5.toString());
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            OrderSkuDetail orderSkuDetail = value.orderSkusDetail;
            n2(this, orderSkuDetail.skuId, orderSkuDetail.quantity, CalculatePriceScene.CHANGE_SELECT_COUPON, false, couponsIds, 8, null);
        } else {
            cg0.a.a("ECOrderSubmitViewModel", "changeSelectedAddress", "cannot edit order before fetching order detail");
        }
    }

    public final void c3(final String note) {
        cg0.a.b("ECOrderSubmitViewModel", "updateOrderGoodsNote, note=" + note);
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            this._orderSubmitDetailInfo.setValue(b3(value, new Function1<OrderSkuDetail, OrderSkuDetail>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$updateOrderGoodsNote$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final OrderSkuDetail invoke(OrderSkuDetail orderSkuDetail) {
                    OrderSkuDetail a16;
                    a16 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : 0, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : 0L, (r34 & 1024) != 0 ? orderSkuDetail.note : note, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : 0, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : null);
                    return a16;
                }
            }));
        } else {
            cg0.a.a("ECOrderSubmitViewModel", "updateOrderGoodsNote", "cannot edit order before fetching order detail");
        }
    }

    public final void e3(RealNameAccount account) {
        cg0.a.b("ECOrderSubmitViewModel", "updateOrderRealAccount, account=" + account);
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j jVar = value.orderSkusDetail.productType;
            if (jVar instanceof j.VirtualProduct) {
                j.VirtualProduct virtualProduct = (j.VirtualProduct) jVar;
                if (virtualProduct.d()) {
                    final j.VirtualProduct b16 = j.VirtualProduct.b(virtualProduct, 0, null, account, 3, null);
                    this._orderSubmitDetailInfo.setValue(b3(value, new Function1<OrderSkuDetail, OrderSkuDetail>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$updateOrderRealAccount$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final OrderSkuDetail invoke(OrderSkuDetail orderSkuDetail) {
                            OrderSkuDetail a16;
                            a16 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : 0, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : 0L, (r34 & 1024) != 0 ? orderSkuDetail.note : null, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : 0, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : j.VirtualProduct.this);
                            return a16;
                        }
                    }));
                    return;
                }
            }
            cg0.a.a("ECOrderSubmitViewModel", "updateOrderRealAccount", "only ticket can fill real name account");
            return;
        }
        cg0.a.a("ECOrderSubmitViewModel", "updateOrderRealAccount", "cannot edit order before fetching order detail");
    }

    public final void f3(String account) {
        cg0.a.b("ECOrderSubmitViewModel", "updateOrderVirtualAccount, account=" + account);
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j jVar = value.orderSkusDetail.productType;
            if (!(jVar instanceof j.VirtualProduct)) {
                cg0.a.a("ECOrderSubmitViewModel", "updateOrderVirtualAccount", "cannot edit account if the product is not a virtual product");
                return;
            }
            j.VirtualProduct virtualProduct = (j.VirtualProduct) jVar;
            final j.VirtualProduct b16 = j.VirtualProduct.b(virtualProduct, 0, VirtualProductAccount.b(virtualProduct.account, 0, null, account, 3, null), null, 5, null);
            this._orderSubmitDetailInfo.setValue(b3(value, new Function1<OrderSkuDetail, OrderSkuDetail>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$updateOrderVirtualAccount$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final OrderSkuDetail invoke(OrderSkuDetail orderSkuDetail) {
                    OrderSkuDetail a16;
                    a16 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : 0, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : 0L, (r34 & 1024) != 0 ? orderSkuDetail.note : null, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : 0, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : j.VirtualProduct.this);
                    return a16;
                }
            }));
            return;
        }
        cg0.a.a("ECOrderSubmitViewModel", "updateOrderVirtualAccount", "cannot edit order before fetching order detail");
    }

    public final void m2(String orderGoodsId, int quantity, CalculatePriceScene scene, boolean forceUpdateQuantity, List<String> couponsIds) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("calculateOrderPrice, ");
        sb5.append("id=");
        sb5.append(orderGoodsId);
        sb5.append(TokenParser.SP);
        sb5.append("quantity=");
        sb5.append(quantity);
        sb5.append(TokenParser.SP);
        sb5.append("forceUpdate=");
        sb5.append(forceUpdateQuantity);
        sb5.append(", ");
        sb5.append("couponList=");
        List<String> list = null;
        sb5.append(couponsIds != null ? CollectionsKt___CollectionsKt.joinToString$default(couponsIds, ",", null, null, 0, null, null, 62, null) : null);
        cg0.a.b("ECOrderSubmitViewModel", sb5.toString());
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            if (couponsIds != null) {
                list = couponsIds;
            } else {
                ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo = value.couponInfo;
                if (eCQshopOrderQuerySvr$CouponInfo != null) {
                    list = com.tencent.ecommerce.biz.orders.buyerorders.submit.model.g.a(eCQshopOrderQuerySvr$CouponInfo);
                }
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderSubmitViewModel$calculateOrderPrice$1(this, forceUpdateQuantity, quantity, value, orderGoodsId, scene, list, null), 3, null);
            return;
        }
        cg0.a.a("ECOrderSubmitViewModel", "calculateOrderPrice", "cannot edit order before fetching order detail");
    }

    public final void o2(ECAddress address) {
        cg0.a.b("ECOrderSubmitViewModel", "changeSelectedAddress, add=" + address);
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderSubmitViewModel$changeSelectedAddress$1(this, address, value, null), 3, null);
        } else {
            cg0.a.a("ECOrderSubmitViewModel", "changeSelectedAddress", "cannot edit order before fetching order detail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object p2(OrderSubmitDetailInfo orderSubmitDetailInfo, ECAddress eCAddress, Continuation<? super AddressCheckResult> continuation) {
        ECOrderSubmitViewModel$checkAddress$1 eCOrderSubmitViewModel$checkAddress$1;
        Object coroutine_suspended;
        int i3;
        ECOrderSubmitViewModel eCOrderSubmitViewModel;
        ECNetworkResponse<?> eCNetworkResponse;
        int i16;
        OrderSubmitDetailInfo orderSubmitDetailInfo2;
        ECNetworkResponse<?> eCNetworkResponse2;
        int i17;
        AddressCheckResult addressCheckResult;
        Map<String, String> mapOf;
        if (continuation instanceof ECOrderSubmitViewModel$checkAddress$1) {
            eCOrderSubmitViewModel$checkAddress$1 = (ECOrderSubmitViewModel$checkAddress$1) continuation;
            int i18 = eCOrderSubmitViewModel$checkAddress$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                eCOrderSubmitViewModel$checkAddress$1.label = i18 - Integer.MIN_VALUE;
                Object obj = eCOrderSubmitViewModel$checkAddress$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCOrderSubmitViewModel$checkAddress$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = orderSubmitDetailInfo.orderSkusDetail.spuId;
                    IECOrderSubmitRepo iECOrderSubmitRepo = this.orderSubmitRepo;
                    eCOrderSubmitViewModel$checkAddress$1.L$0 = this;
                    eCOrderSubmitViewModel$checkAddress$1.L$1 = orderSubmitDetailInfo;
                    eCOrderSubmitViewModel$checkAddress$1.label = 1;
                    obj = iECOrderSubmitRepo.checkAddressReachable(str, eCAddress, eCOrderSubmitViewModel$checkAddress$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCOrderSubmitViewModel = this;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            i17 = eCOrderSubmitViewModel$checkAddress$1.I$0;
                            eCNetworkResponse2 = (ECNetworkResponse) eCOrderSubmitViewModel$checkAddress$1.L$1;
                            orderSubmitDetailInfo2 = (OrderSubmitDetailInfo) eCOrderSubmitViewModel$checkAddress$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            i16 = i17;
                            eCNetworkResponse = eCNetworkResponse2;
                            orderSubmitDetailInfo = orderSubmitDetailInfo2;
                            cg0.a.b("ECOrderSubmitViewModel", "checkAddressReachable=" + eCNetworkResponse);
                            ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
                            String str2 = orderSubmitDetailInfo.orderId;
                            ECOrderSpanScene eCOrderSpanScene = ECOrderSpanScene.OrderSubmit;
                            ECOrderOperation eCOrderOperation = ECOrderOperation.CheckAddressReachable;
                            ECOrderSpan.OrderRequestInfo d16 = eCOrderSpan.d(eCNetworkResponse);
                            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isAddressReachable", String.valueOf(i16 != 0)));
                            eCOrderSpan.b(str2, eCOrderSpanScene, eCOrderOperation, d16, mapOf);
                            return eCNetworkResponse.b();
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    orderSubmitDetailInfo = (OrderSubmitDetailInfo) eCOrderSubmitViewModel$checkAddress$1.L$1;
                    eCOrderSubmitViewModel = (ECOrderSubmitViewModel) eCOrderSubmitViewModel$checkAddress$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                i16 = (eCNetworkResponse.getCode() == 0 || (addressCheckResult = (AddressCheckResult) eCNetworkResponse.b()) == null || !addressCheckResult.isReachable) ? 0 : 1;
                if (eCNetworkResponse.getCode() != 0) {
                    MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> mutableSharedFlow = eCOrderSubmitViewModel._errorEvent;
                    l.ErrorCommonEvent errorCommonEvent = new l.ErrorCommonEvent(eCNetworkResponse.getCode(), eCNetworkResponse.getMessage());
                    eCOrderSubmitViewModel$checkAddress$1.L$0 = orderSubmitDetailInfo;
                    eCOrderSubmitViewModel$checkAddress$1.L$1 = eCNetworkResponse;
                    eCOrderSubmitViewModel$checkAddress$1.I$0 = i16;
                    eCOrderSubmitViewModel$checkAddress$1.label = 2;
                    if (mutableSharedFlow.emit(errorCommonEvent, eCOrderSubmitViewModel$checkAddress$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    orderSubmitDetailInfo2 = orderSubmitDetailInfo;
                    eCNetworkResponse2 = eCNetworkResponse;
                    i17 = i16;
                    i16 = i17;
                    eCNetworkResponse = eCNetworkResponse2;
                    orderSubmitDetailInfo = orderSubmitDetailInfo2;
                }
                cg0.a.b("ECOrderSubmitViewModel", "checkAddressReachable=" + eCNetworkResponse);
                ECOrderSpan eCOrderSpan2 = ECOrderSpan.f103884c;
                String str22 = orderSubmitDetailInfo.orderId;
                ECOrderSpanScene eCOrderSpanScene2 = ECOrderSpanScene.OrderSubmit;
                ECOrderOperation eCOrderOperation2 = ECOrderOperation.CheckAddressReachable;
                ECOrderSpan.OrderRequestInfo d162 = eCOrderSpan2.d(eCNetworkResponse);
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isAddressReachable", String.valueOf(i16 != 0)));
                eCOrderSpan2.b(str22, eCOrderSpanScene2, eCOrderOperation2, d162, mapOf);
                return eCNetworkResponse.b();
            }
        }
        eCOrderSubmitViewModel$checkAddress$1 = new ECOrderSubmitViewModel$checkAddress$1(this, continuation);
        Object obj2 = eCOrderSubmitViewModel$checkAddress$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCOrderSubmitViewModel$checkAddress$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        if (eCNetworkResponse.getCode() != 0) {
        }
        cg0.a.b("ECOrderSubmitViewModel", "checkAddressReachable=" + eCNetworkResponse);
        ECOrderSpan eCOrderSpan22 = ECOrderSpan.f103884c;
        String str222 = orderSubmitDetailInfo.orderId;
        ECOrderSpanScene eCOrderSpanScene22 = ECOrderSpanScene.OrderSubmit;
        ECOrderOperation eCOrderOperation22 = ECOrderOperation.CheckAddressReachable;
        ECOrderSpan.OrderRequestInfo d1622 = eCOrderSpan22.d(eCNetworkResponse);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isAddressReachable", String.valueOf(i16 != 0)));
        eCOrderSpan22.b(str222, eCOrderSpanScene22, eCOrderOperation22, d1622, mapOf);
        return eCNetworkResponse.b();
    }

    public final void q2(RealNameAccount account) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderSubmitViewModel$createAndSelectRealNameAccount$1(this, account, null), 3, null);
    }

    public final void t2(SimpleSku simpleSku, boolean isRefresh) {
        cg0.a.b("ECOrderSubmitViewModel", "fetchOrderSubmitDetails sku=" + simpleSku + " isRefresh=" + isRefresh);
        String str = null;
        byte b16 = 0;
        if (!Intrinsics.areEqual(simpleSku, SimpleSku.INSTANCE.a())) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderSubmitViewModel$fetchOrderSubmitDetails$1(this, simpleSku, isRefresh, null), 3, null);
            return;
        }
        this._pageState.setValue(new g.Empty(str, 1, b16 == true ? 1 : 0));
        cg0.a.a("ECOrderSubmitViewModel", "fetchOrderSubmitDetails", "sku is is invalid = " + simpleSku);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object v2(int i3, int i16, Continuation<? super Integer> continuation) {
        ECOrderSubmitViewModel$fixQuantity$1 eCOrderSubmitViewModel$fixQuantity$1;
        Object coroutine_suspended;
        int i17;
        if (continuation instanceof ECOrderSubmitViewModel$fixQuantity$1) {
            eCOrderSubmitViewModel$fixQuantity$1 = (ECOrderSubmitViewModel$fixQuantity$1) continuation;
            int i18 = eCOrderSubmitViewModel$fixQuantity$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                eCOrderSubmitViewModel$fixQuantity$1.label = i18 - Integer.MIN_VALUE;
                Object obj = eCOrderSubmitViewModel$fixQuantity$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = eCOrderSubmitViewModel$fixQuantity$1.label;
                if (i17 == 0) {
                    if (i17 == 1) {
                        i3 = eCOrderSubmitViewModel$fixQuantity$1.I$0;
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxInt(i3);
                    }
                    if (i17 == 2) {
                        ResultKt.throwOnFailure(obj);
                        i3 = 1;
                        return Boxing.boxInt(i3);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (i16 == 0 && i3 <= 0) {
                    return Boxing.boxInt(i16);
                }
                if (i3 > i16) {
                    MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> mutableSharedFlow = this._errorEvent;
                    l.ErrorToastWithMsgResIdEvent errorToastWithMsgResIdEvent = new l.ErrorToastWithMsgResIdEvent(R.string.wvf);
                    eCOrderSubmitViewModel$fixQuantity$1.I$0 = i16;
                    eCOrderSubmitViewModel$fixQuantity$1.label = 1;
                    if (mutableSharedFlow.emit(errorToastWithMsgResIdEvent, eCOrderSubmitViewModel$fixQuantity$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i3 = i16;
                } else if (i3 < 1) {
                    MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> mutableSharedFlow2 = this._errorEvent;
                    l.ErrorToastWithMsgResIdEvent errorToastWithMsgResIdEvent2 = new l.ErrorToastWithMsgResIdEvent(R.string.wvh);
                    eCOrderSubmitViewModel$fixQuantity$1.label = 2;
                    if (mutableSharedFlow2.emit(errorToastWithMsgResIdEvent2, eCOrderSubmitViewModel$fixQuantity$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i3 = 1;
                }
                return Boxing.boxInt(i3);
            }
        }
        eCOrderSubmitViewModel$fixQuantity$1 = new ECOrderSubmitViewModel$fixQuantity$1(this, continuation);
        Object obj2 = eCOrderSubmitViewModel$fixQuantity$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = eCOrderSubmitViewModel$fixQuantity$1.label;
        if (i17 == 0) {
        }
    }

    public final SharedFlow<Integer> w2() {
        return this.bestCouponSelectedEvent;
    }

    public final LiveData<String> x2() {
        return this.blindBoxAgreementVersion;
    }

    public final SharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> y2() {
        return this.errorEvent;
    }

    public final boolean z2() {
        return this.realNameRepo.getHasRealNameAccount();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "owners", "b", "batchIds", "I", "()I", "discountInFen", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$e, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class CouponReportInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<String> owners;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<String> batchIds;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int discountInFen;

        public CouponReportInfo(List<String> list, List<String> list2, int i3) {
            this.owners = list;
            this.batchIds = list2;
            this.discountInFen = i3;
        }

        public final List<String> a() {
            return this.batchIds;
        }

        /* renamed from: b, reason: from getter */
        public final int getDiscountInFen() {
            return this.discountInFen;
        }

        public final List<String> c() {
            return this.owners;
        }

        public int hashCode() {
            List<String> list = this.owners;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<String> list2 = this.batchIds;
            return ((hashCode + (list2 != null ? list2.hashCode() : 0)) * 31) + this.discountInFen;
        }

        public String toString() {
            return "CouponReportInfo(owners=" + this.owners + ", batchIds=" + this.batchIds + ", discountInFen=" + this.discountInFen + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CouponReportInfo)) {
                return false;
            }
            CouponReportInfo couponReportInfo = (CouponReportInfo) other;
            return Intrinsics.areEqual(this.owners, couponReportInfo.owners) && Intrinsics.areEqual(this.batchIds, couponReportInfo.batchIds) && this.discountInFen == couponReportInfo.discountInFen;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "sellerId", "b", "shopId", "c", "spuId", "d", "skuId", "e", "priSortId", "f", "activityId", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$e;", "g", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$e;", "couponInfo", tl.h.F, "Z", "addressIsEmpty", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "i", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$e;ZLcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$f, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class OrderSubmitReportInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String sellerId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String shopId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String spuId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String skuId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String priSortId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final String activityId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final CouponReportInfo couponInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean addressIsEmpty;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        public final PayType payType;

        public OrderSubmitReportInfo(String str, String str2, String str3, String str4, String str5, String str6, CouponReportInfo couponReportInfo, boolean z16, PayType payType) {
            this.sellerId = str;
            this.shopId = str2;
            this.spuId = str3;
            this.skuId = str4;
            this.priSortId = str5;
            this.activityId = str6;
            this.couponInfo = couponReportInfo;
            this.addressIsEmpty = z16;
            this.payType = payType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.sellerId;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.shopId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.spuId;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.skuId;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.priSortId;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.activityId;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            CouponReportInfo couponReportInfo = this.couponInfo;
            int hashCode7 = (hashCode6 + (couponReportInfo != null ? couponReportInfo.hashCode() : 0)) * 31;
            boolean z16 = this.addressIsEmpty;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode7 + i3) * 31;
            PayType payType = this.payType;
            return i16 + (payType != null ? payType.hashCode() : 0);
        }

        public String toString() {
            return "OrderSubmitReportInfo(sellerId=" + this.sellerId + ", shopId=" + this.shopId + ", spuId=" + this.spuId + ", skuId=" + this.skuId + ", priSortId=" + this.priSortId + ", activityId=" + this.activityId + ", couponInfo=" + this.couponInfo + ", addressIsEmpty=" + this.addressIsEmpty + ", payType=" + this.payType + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrderSubmitReportInfo)) {
                return false;
            }
            OrderSubmitReportInfo orderSubmitReportInfo = (OrderSubmitReportInfo) other;
            return Intrinsics.areEqual(this.sellerId, orderSubmitReportInfo.sellerId) && Intrinsics.areEqual(this.shopId, orderSubmitReportInfo.shopId) && Intrinsics.areEqual(this.spuId, orderSubmitReportInfo.spuId) && Intrinsics.areEqual(this.skuId, orderSubmitReportInfo.skuId) && Intrinsics.areEqual(this.priSortId, orderSubmitReportInfo.priSortId) && Intrinsics.areEqual(this.activityId, orderSubmitReportInfo.activityId) && Intrinsics.areEqual(this.couponInfo, orderSubmitReportInfo.couponInfo) && this.addressIsEmpty == orderSubmitReportInfo.addressIsEmpty && Intrinsics.areEqual(this.payType, orderSubmitReportInfo.payType);
        }
    }

    public ECOrderSubmitViewModel(SimpleSku simpleSku, String str, String str2, String str3, Boolean bool) {
        this.initialSimpleSku = simpleSku;
        this.activityId = str;
        this.adClickId = str2;
        this.groupId = str3;
        this.isBuyAll = bool;
        ServiceLocator serviceLocator = ServiceLocator.f104891i;
        this.orderSubmitRepo = serviceLocator.l();
        this.orderRepository = serviceLocator.i();
        this.realNameRepo = serviceLocator.p();
        this.realNameListRepo = serviceLocator.o();
        MutableLiveData<OrderSubmitDetailInfo> mutableLiveData = new MutableLiveData<>();
        this._orderSubmitDetailInfo = mutableLiveData;
        MutableLiveData<g> mutableLiveData2 = new MutableLiveData<>();
        this._pageState = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._isAddressReachable = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._submitEnabled = mutableLiveData4;
        MutableSharedFlow<Integer> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._bestCouponSelectedEvent = MutableSharedFlow$default;
        MutableSharedFlow<h> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._submitResult = MutableSharedFlow$default2;
        MutableSharedFlow<Integer> MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._realNameDialogEvent = MutableSharedFlow$default3;
        MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> MutableSharedFlow$default4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._errorEvent = MutableSharedFlow$default4;
        MutableSharedFlow<OrderSubmitReportInfo> MutableSharedFlow$default5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._reportExposureEvent = MutableSharedFlow$default5;
        MutableSharedFlow<OrderSubmitReportInfo> MutableSharedFlow$default6 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._reportSubmitEvent = MutableSharedFlow$default6;
        this.bestCouponSelectedEvent = MutableSharedFlow$default;
        this.submitResult = MutableSharedFlow$default2;
        this.realNameDialogEvent = MutableSharedFlow$default3;
        this.errorEvent = MutableSharedFlow$default4;
        this.reportExposureEvent = MutableSharedFlow$default5;
        this.reportSubmitEvent = MutableSharedFlow$default6;
        this.pageExt = ug0.b.f438933d.f().toString();
        this.pageState = mutableLiveData2;
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(mutableLiveData4, new n(mediatorLiveData));
        mediatorLiveData.addSource(mutableLiveData, new a(mediatorLiveData, this));
        mediatorLiveData.addSource(mutableLiveData3, new b(mediatorLiveData, this));
        Unit unit = Unit.INSTANCE;
        this.submitEnabled = mediatorLiveData;
        MediatorLiveData mediatorLiveData2 = new MediatorLiveData();
        mediatorLiveData2.addSource(mutableLiveData, new m(mediatorLiveData2));
        this.showBelowZeroTips = mediatorLiveData2;
        MediatorLiveData mediatorLiveData3 = new MediatorLiveData();
        mediatorLiveData3.setValue(new OrderSubmitPriceInfo(0L, 0));
        mediatorLiveData3.addSource(mutableLiveData, new j(mediatorLiveData3));
        this.priceInfo = mediatorLiveData3;
        MediatorLiveData mediatorLiveData4 = new MediatorLiveData();
        mediatorLiveData4.addSource(mutableLiveData, new i(mediatorLiveData4));
        this.blindBoxAgreementVersion = mediatorLiveData4;
        MediatorLiveData mediatorLiveData5 = new MediatorLiveData();
        mediatorLiveData5.addSource(mutableLiveData, new l(mediatorLiveData5));
        this.qShopProductAgreementVersion = mediatorLiveData5;
        MediatorLiveData mediatorLiveData6 = new MediatorLiveData();
        mediatorLiveData6.addSource(mutableLiveData, new k(mediatorLiveData6));
        this.qShopPrivacyAgreementVersion = mediatorLiveData6;
        final MediatorLiveData mediatorLiveData7 = new MediatorLiveData();
        mediatorLiveData7.addSource(mutableLiveData, new c(mediatorLiveData7, this));
        mediatorLiveData7.addSource(mutableLiveData3, new Observer<Boolean>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$listData$1$2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Boolean bool2) {
                List arrayList;
                T t16;
                String string = ECPluginApplication.INSTANCE.a().getString(R.string.wow);
                List list = (List) MediatorLiveData.this.getValue();
                if (list != null) {
                    arrayList = list;
                } else {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                if (bool2.booleanValue()) {
                    CollectionsKt__MutableCollectionsKt.removeAll((List) arrayList2, (Function1) new Function1<p, Boolean>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$listData$1$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(p pVar) {
                            return Boolean.valueOf(invoke2(pVar));
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final boolean invoke2(p pVar) {
                            return pVar instanceof ErrorTipsItemData;
                        }
                    });
                } else {
                    Iterator<T> it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t16 = (T) null;
                            break;
                        } else {
                            t16 = it.next();
                            if (((p) t16) instanceof ErrorTipsItemData) {
                                break;
                            }
                        }
                    }
                    if (t16 == null) {
                        arrayList2.add(0, new ErrorTipsItemData(string));
                    }
                }
                MediatorLiveData.this.setValue(arrayList2);
            }
        });
        this.listData = mediatorLiveData7;
    }

    public final void T2(boolean isUserAction, ECQshopOrderSvr$CaptchaToken captchaToken, boolean hasDoubleCheckVirtualProductAccount) {
        cg0.a.b("ECOrderSubmitViewModel", "submit, token=" + captchaToken);
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp = this.orderDetailRsp;
            if (eCQshopOrderQuerySvr$OrderPageDetailRsp != null) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECOrderSubmitViewModel$submit$1(this, value, isUserAction, hasDoubleCheckVirtualProductAccount, eCQshopOrderQuerySvr$OrderPageDetailRsp, captchaToken, null), 3, null);
                return;
            } else {
                cg0.a.a("ECOrderSubmitViewModel", "submit", "cannot submit order before fetching order detail");
                return;
            }
        }
        cg0.a.a("ECOrderSubmitViewModel", "submit", "cannot submit order before fetching order detail");
    }

    public final void d3(PayType payType) {
        cg0.a.b("ECOrderSubmitViewModel", "updateOrderPayType, payType=" + payType);
        OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
        if (value != null) {
            this._orderSubmitDetailInfo.setValue(OrderSubmitDetailInfo.b(value, null, null, null, null, payType, null, null, false, null, null, null, null, null, null, null, 32751, null));
        } else {
            cg0.a.a("ECOrderSubmitViewModel", "updateOrderGoodsNote", "cannot edit order before fetching order detail");
        }
    }

    private final boolean g3(RealNameAccount account) {
        if (account != null) {
            if (!(account.name.length() == 0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrderSubmitDetailInfo b3(OrderSubmitDetailInfo orderSubmitDetailInfo, Function1<? super OrderSkuDetail, OrderSkuDetail> function1) {
        return OrderSubmitDetailInfo.b(orderSubmitDetailInfo, null, null, function1.invoke(orderSubmitDetailInfo.orderSkusDetail), null, null, null, null, false, null, null, null, null, null, null, null, 32763, null);
    }

    public static /* synthetic */ void u2(ECOrderSubmitViewModel eCOrderSubmitViewModel, SimpleSku simpleSku, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            simpleSku = eCOrderSubmitViewModel.initialSimpleSku;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        eCOrderSubmitViewModel.t2(simpleSku, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrderSubmitDetailInfo P2(OrderSubmitDetailInfo userEditedInfo, OrderSubmitDetailInfo remoteLatestInfo) {
        OrderSkuDetail a16;
        ECAddress eCAddress = userEditedInfo.address;
        PayType payType = userEditedInfo.selectedPayType;
        OrderSkuDetail orderSkuDetail = remoteLatestInfo.orderSkusDetail;
        OrderSkuDetail orderSkuDetail2 = userEditedInfo.orderSkusDetail;
        a16 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : orderSkuDetail2.quantity, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : 0L, (r34 & 1024) != 0 ? orderSkuDetail.note : orderSkuDetail2.note, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : 0, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : orderSkuDetail2.productType);
        return OrderSubmitDetailInfo.b(remoteLatestInfo, null, eCAddress, a16, null, payType, null, null, false, null, null, null, null, null, null, null, 32745, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object r2(RealNameAccount realNameAccount, Continuation<? super Boolean> continuation) {
        ECOrderSubmitViewModel$deleteRealAccount$1 eCOrderSubmitViewModel$deleteRealAccount$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j jVar;
        OrderSubmitDetailInfo orderSubmitDetailInfo;
        ECOrderSubmitViewModel eCOrderSubmitViewModel;
        boolean booleanValue;
        boolean z17;
        MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> mutableSharedFlow;
        l.ErrorToastWithMsgResIdEvent errorToastWithMsgResIdEvent;
        final RealNameAccount realNameAccount2 = realNameAccount;
        if (continuation instanceof ECOrderSubmitViewModel$deleteRealAccount$1) {
            eCOrderSubmitViewModel$deleteRealAccount$1 = (ECOrderSubmitViewModel$deleteRealAccount$1) continuation;
            int i16 = eCOrderSubmitViewModel$deleteRealAccount$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCOrderSubmitViewModel$deleteRealAccount$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCOrderSubmitViewModel$deleteRealAccount$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCOrderSubmitViewModel$deleteRealAccount$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECOrderSubmitViewModel", "deleteRealAccount, account=" + realNameAccount2);
                    OrderSubmitDetailInfo value = this._orderSubmitDetailInfo.getValue();
                    z16 = false;
                    if (value != null) {
                        jVar = value.orderSkusDetail.productType;
                        if ((jVar instanceof j.VirtualProduct) && ((j.VirtualProduct) jVar).d()) {
                            IECRealNameOperateRepo iECRealNameOperateRepo = this.realNameRepo;
                            String str = realNameAccount2.id;
                            eCOrderSubmitViewModel$deleteRealAccount$1.L$0 = this;
                            eCOrderSubmitViewModel$deleteRealAccount$1.L$1 = realNameAccount2;
                            eCOrderSubmitViewModel$deleteRealAccount$1.L$2 = value;
                            eCOrderSubmitViewModel$deleteRealAccount$1.L$3 = jVar;
                            eCOrderSubmitViewModel$deleteRealAccount$1.label = 1;
                            Object deleteAccounts = iECRealNameOperateRepo.deleteAccounts(str, eCOrderSubmitViewModel$deleteRealAccount$1);
                            if (deleteAccounts == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            orderSubmitDetailInfo = value;
                            obj = deleteAccounts;
                            eCOrderSubmitViewModel = this;
                        } else {
                            cg0.a.a("ECOrderSubmitViewModel", "updateOrderRealAccount", "only ticket can fill real name account");
                            return Boxing.boxBoolean(z16);
                        }
                    } else {
                        cg0.a.a("ECOrderSubmitViewModel", "updateOrderRealAccount", "cannot edit order before fetching order detail");
                        return Boxing.boxBoolean(false);
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3 && i3 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            z17 = eCOrderSubmitViewModel$deleteRealAccount$1.Z$0;
                            ResultKt.throwOnFailure(obj);
                            z16 = z17;
                            return Boxing.boxBoolean(z16);
                        }
                        z17 = eCOrderSubmitViewModel$deleteRealAccount$1.Z$0;
                        eCOrderSubmitViewModel = (ECOrderSubmitViewModel) eCOrderSubmitViewModel$deleteRealAccount$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableSharedFlow = eCOrderSubmitViewModel._errorEvent;
                        errorToastWithMsgResIdEvent = new l.ErrorToastWithMsgResIdEvent(R.string.wje);
                        eCOrderSubmitViewModel$deleteRealAccount$1.L$0 = null;
                        eCOrderSubmitViewModel$deleteRealAccount$1.Z$0 = z17;
                        eCOrderSubmitViewModel$deleteRealAccount$1.label = 3;
                        if (mutableSharedFlow.emit(errorToastWithMsgResIdEvent, eCOrderSubmitViewModel$deleteRealAccount$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z16 = z17;
                        return Boxing.boxBoolean(z16);
                    }
                    com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j jVar2 = (com.tencent.ecommerce.biz.orders.buyerorders.submit.model.j) eCOrderSubmitViewModel$deleteRealAccount$1.L$3;
                    OrderSubmitDetailInfo orderSubmitDetailInfo2 = (OrderSubmitDetailInfo) eCOrderSubmitViewModel$deleteRealAccount$1.L$2;
                    RealNameAccount realNameAccount3 = (RealNameAccount) eCOrderSubmitViewModel$deleteRealAccount$1.L$1;
                    ECOrderSubmitViewModel eCOrderSubmitViewModel2 = (ECOrderSubmitViewModel) eCOrderSubmitViewModel$deleteRealAccount$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    jVar = jVar2;
                    realNameAccount2 = realNameAccount3;
                    orderSubmitDetailInfo = orderSubmitDetailInfo2;
                    eCOrderSubmitViewModel = eCOrderSubmitViewModel2;
                }
                booleanValue = ((Boolean) obj).booleanValue();
                if (!booleanValue) {
                    j.VirtualProduct virtualProduct = (j.VirtualProduct) jVar;
                    RealNameAccount realNameAccount4 = virtualProduct.getRealNameAccount();
                    if (Intrinsics.areEqual(realNameAccount4 != null ? realNameAccount4.id : null, realNameAccount2.id)) {
                        final j.VirtualProduct b16 = j.VirtualProduct.b(virtualProduct, 0, null, null, 3, null);
                        eCOrderSubmitViewModel._orderSubmitDetailInfo.setValue(eCOrderSubmitViewModel.b3(orderSubmitDetailInfo, new Function1<OrderSkuDetail, OrderSkuDetail>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$deleteRealAccount$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final OrderSkuDetail invoke(OrderSkuDetail orderSkuDetail) {
                                OrderSkuDetail a16;
                                a16 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : 0, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : 0L, (r34 & 1024) != 0 ? orderSkuDetail.note : null, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : 0, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : j.VirtualProduct.this);
                                return a16;
                            }
                        }));
                    }
                    IECRealNameListRepo iECRealNameListRepo = eCOrderSubmitViewModel.realNameListRepo;
                    Function1<RealNameAccount, Boolean> function1 = new Function1<RealNameAccount, Boolean>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$deleteRealAccount$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(RealNameAccount realNameAccount5) {
                            return Boolean.valueOf(invoke2(realNameAccount5));
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final boolean invoke2(RealNameAccount realNameAccount5) {
                            return Intrinsics.areEqual(realNameAccount5.id, RealNameAccount.this.id);
                        }
                    };
                    eCOrderSubmitViewModel$deleteRealAccount$1.L$0 = eCOrderSubmitViewModel;
                    eCOrderSubmitViewModel$deleteRealAccount$1.L$1 = null;
                    eCOrderSubmitViewModel$deleteRealAccount$1.L$2 = null;
                    eCOrderSubmitViewModel$deleteRealAccount$1.L$3 = null;
                    eCOrderSubmitViewModel$deleteRealAccount$1.Z$0 = booleanValue;
                    eCOrderSubmitViewModel$deleteRealAccount$1.label = 2;
                    if (iECRealNameListRepo.deleteAccount(function1, eCOrderSubmitViewModel$deleteRealAccount$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z17 = booleanValue;
                    mutableSharedFlow = eCOrderSubmitViewModel._errorEvent;
                    errorToastWithMsgResIdEvent = new l.ErrorToastWithMsgResIdEvent(R.string.wje);
                    eCOrderSubmitViewModel$deleteRealAccount$1.L$0 = null;
                    eCOrderSubmitViewModel$deleteRealAccount$1.Z$0 = z17;
                    eCOrderSubmitViewModel$deleteRealAccount$1.label = 3;
                    if (mutableSharedFlow.emit(errorToastWithMsgResIdEvent, eCOrderSubmitViewModel$deleteRealAccount$1) == coroutine_suspended) {
                    }
                    z16 = z17;
                    return Boxing.boxBoolean(z16);
                }
                MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> mutableSharedFlow2 = eCOrderSubmitViewModel._errorEvent;
                l.ErrorToastWithMsgResIdEvent errorToastWithMsgResIdEvent2 = new l.ErrorToastWithMsgResIdEvent(R.string.wvb);
                eCOrderSubmitViewModel$deleteRealAccount$1.L$0 = null;
                eCOrderSubmitViewModel$deleteRealAccount$1.L$1 = null;
                eCOrderSubmitViewModel$deleteRealAccount$1.L$2 = null;
                eCOrderSubmitViewModel$deleteRealAccount$1.L$3 = null;
                eCOrderSubmitViewModel$deleteRealAccount$1.Z$0 = booleanValue;
                eCOrderSubmitViewModel$deleteRealAccount$1.label = 4;
                if (mutableSharedFlow2.emit(errorToastWithMsgResIdEvent2, eCOrderSubmitViewModel$deleteRealAccount$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z17 = booleanValue;
                z16 = z17;
                return Boxing.boxBoolean(z16);
            }
        }
        eCOrderSubmitViewModel$deleteRealAccount$1 = new ECOrderSubmitViewModel$deleteRealAccount$1(this, continuation);
        Object obj2 = eCOrderSubmitViewModel$deleteRealAccount$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCOrderSubmitViewModel$deleteRealAccount$1.label;
        if (i3 != 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        if (!booleanValue) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object s2(j.VirtualProduct virtualProduct, boolean z16, boolean z17, Continuation<? super Boolean> continuation) {
        ECOrderSubmitViewModel$doVirtualAccountVerification$1 eCOrderSubmitViewModel$doVirtualAccountVerification$1;
        Object coroutine_suspended;
        int i3;
        ECOrderSubmitViewModel eCOrderSubmitViewModel;
        MutableSharedFlow<Integer> mutableSharedFlow;
        Integer boxInt;
        if (continuation instanceof ECOrderSubmitViewModel$doVirtualAccountVerification$1) {
            eCOrderSubmitViewModel$doVirtualAccountVerification$1 = (ECOrderSubmitViewModel$doVirtualAccountVerification$1) continuation;
            int i16 = eCOrderSubmitViewModel$doVirtualAccountVerification$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCOrderSubmitViewModel$doVirtualAccountVerification$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCOrderSubmitViewModel$doVirtualAccountVerification$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCOrderSubmitViewModel$doVirtualAccountVerification$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!h3(virtualProduct.account)) {
                        int i17 = virtualProduct.account.type == 1 ? R.string.wv6 : R.string.wv5;
                        MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> mutableSharedFlow2 = this._errorEvent;
                        l.ErrorToastWithMsgResIdEvent errorToastWithMsgResIdEvent = new l.ErrorToastWithMsgResIdEvent(i17);
                        eCOrderSubmitViewModel$doVirtualAccountVerification$1.label = 1;
                        if (mutableSharedFlow2.emit(errorToastWithMsgResIdEvent, eCOrderSubmitViewModel$doVirtualAccountVerification$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Boxing.boxBoolean(false);
                    }
                    if (!virtualProduct.d() || g3(virtualProduct.getRealNameAccount())) {
                        if (z16 && !z17) {
                            MutableSharedFlow<h> mutableSharedFlow3 = this._submitResult;
                            int i18 = 0;
                            int i19 = -3333;
                            String str = virtualProduct.account.id;
                            if (str == null) {
                                str = "";
                            }
                            h.SubmitFailedResult submitFailedResult = new h.SubmitFailedResult(i18, i19, str, 1, null);
                            eCOrderSubmitViewModel$doVirtualAccountVerification$1.label = 4;
                            if (mutableSharedFlow3.emit(submitFailedResult, eCOrderSubmitViewModel$doVirtualAccountVerification$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Boxing.boxBoolean(false);
                        }
                        return Boxing.boxBoolean(true);
                    }
                    MutableSharedFlow<com.tencent.ecommerce.biz.orders.buyerorders.submit.l> mutableSharedFlow4 = this._errorEvent;
                    l.ErrorToastWithMsgResIdEvent errorToastWithMsgResIdEvent2 = new l.ErrorToastWithMsgResIdEvent(R.string.wk_);
                    eCOrderSubmitViewModel$doVirtualAccountVerification$1.L$0 = this;
                    eCOrderSubmitViewModel$doVirtualAccountVerification$1.label = 2;
                    if (mutableSharedFlow4.emit(errorToastWithMsgResIdEvent2, eCOrderSubmitViewModel$doVirtualAccountVerification$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCOrderSubmitViewModel = this;
                    mutableSharedFlow = eCOrderSubmitViewModel._realNameDialogEvent;
                    boxInt = Boxing.boxInt(1);
                    eCOrderSubmitViewModel$doVirtualAccountVerification$1.L$0 = null;
                    eCOrderSubmitViewModel$doVirtualAccountVerification$1.label = 3;
                    if (mutableSharedFlow.emit(boxInt, eCOrderSubmitViewModel$doVirtualAccountVerification$1) == coroutine_suspended) {
                    }
                } else {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxBoolean(false);
                    }
                    if (i3 == 2) {
                        eCOrderSubmitViewModel = (ECOrderSubmitViewModel) eCOrderSubmitViewModel$doVirtualAccountVerification$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableSharedFlow = eCOrderSubmitViewModel._realNameDialogEvent;
                        boxInt = Boxing.boxInt(1);
                        eCOrderSubmitViewModel$doVirtualAccountVerification$1.L$0 = null;
                        eCOrderSubmitViewModel$doVirtualAccountVerification$1.label = 3;
                        if (mutableSharedFlow.emit(boxInt, eCOrderSubmitViewModel$doVirtualAccountVerification$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                ResultKt.throwOnFailure(obj);
                                return Boxing.boxBoolean(false);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                }
                return Boxing.boxBoolean(false);
            }
        }
        eCOrderSubmitViewModel$doVirtualAccountVerification$1 = new ECOrderSubmitViewModel$doVirtualAccountVerification$1(this, continuation);
        Object obj2 = eCOrderSubmitViewModel$doVirtualAccountVerification$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCOrderSubmitViewModel$doVirtualAccountVerification$1.label;
        if (i3 != 0) {
        }
        return Boxing.boxBoolean(false);
    }

    public static /* synthetic */ void U2(ECOrderSubmitViewModel eCOrderSubmitViewModel, boolean z16, ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            eCQshopOrderSvr$CaptchaToken = null;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        eCOrderSubmitViewModel.T2(z16, eCQshopOrderSvr$CaptchaToken, z17);
    }

    public static /* synthetic */ void n2(ECOrderSubmitViewModel eCOrderSubmitViewModel, String str, int i3, CalculatePriceScene calculatePriceScene, boolean z16, List list, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            list = null;
        }
        eCOrderSubmitViewModel.m2(str, i3, calculatePriceScene, z17, list);
    }
}
