package com.tencent.ecommerce.biz.shophome.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.ecommerce.biz.shophome.model.ECOrderByTabInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopProductInfo;
import com.tencent.ecommerce.biz.shophome.repo.ECShopHomeDefaultRepository;
import com.tencent.ecommerce.biz.util.k;
import com.tencent.ecommerce.biz.util.l;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000 \u0094\u00012\u00020\u0001:\u0004\u0095\u0001\u0096\u0001B\t\u00a2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0004J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0004J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0004J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0004J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0004J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0004J\u0010\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0004H\u0004J\u0018\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0011H\u0004J\u0018\u0010'\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0011H\u0004R\"\u0010,\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00110\u00110(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u0010.\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00110\u00110(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010+R$\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u001601j\b\u0012\u0004\u0012\u00020\u0016`28\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R \u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0016060(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010+R$\u0010;\u001a\u0012\u0012\u0004\u0012\u00020901j\b\u0012\u0004\u0012\u000209`28\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00104R \u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000209060(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010+R$\u0010?\u001a\u0012\u0012\u0004\u0012\u00020901j\b\u0012\u0004\u0012\u000209`28\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00104R \u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000209060(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010+R\"\u0010C\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00110\u00110(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010+R\"\u0010E\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00110\u00110(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010+R(\u0010I\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00110\u00110(8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bF\u0010+\u001a\u0004\bG\u0010HR \u0010L\u001a\b\u0012\u0004\u0012\u00020\t0(8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bJ\u0010+\u001a\u0004\bK\u0010HR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010+R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000e0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010+R\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00070(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010+R\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00110(8\u0006\u00a2\u0006\f\n\u0004\bS\u0010+\u001a\u0004\bT\u0010HR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00110(8\u0006\u00a2\u0006\f\n\u0004\bV\u0010+\u001a\u0004\bW\u0010HR\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00160(8\u0006\u00a2\u0006\f\n\u0004\bY\u0010+\u001a\u0004\bZ\u0010HR#\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0016060(8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010+\u001a\u0004\b]\u0010HR#\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000209060(8\u0006\u00a2\u0006\f\n\u0004\b_\u0010+\u001a\u0004\b`\u0010HR#\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000209060(8\u0006\u00a2\u0006\f\n\u0004\bb\u0010+\u001a\u0004\bc\u0010HR\u001d\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00110(8\u0006\u00a2\u0006\f\n\u0004\be\u0010+\u001a\u0004\bf\u0010HR\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00110(8\u0006\u00a2\u0006\f\n\u0004\bh\u0010+\u001a\u0004\bi\u0010HR\u001d\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00110(8\u0006\u00a2\u0006\f\n\u0004\bk\u0010+\u001a\u0004\bl\u0010HR\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020\t0(8\u0006\u00a2\u0006\f\n\u0004\bn\u0010+\u001a\u0004\bo\u0010HR\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00070(8\u0006\u00a2\u0006\f\n\u0004\bq\u0010+\u001a\u0004\br\u0010HR\u001d\u0010v\u001a\b\u0012\u0004\u0012\u00020\u000e0(8\u0006\u00a2\u0006\f\n\u0004\bt\u0010+\u001a\u0004\bu\u0010HR\u001d\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00070w8\u0006\u00a2\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u001a\u0010\u0082\u0001\u001a\u00020}8\u0006\u00a2\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R*\u0010\u0088\u0001\u001a\u00020\u00022\u0007\u0010\u0083\u0001\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R*\u0010\u008b\u0001\u001a\u00020\u00022\u0007\u0010\u0083\u0001\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u0085\u0001\u001a\u0006\b\u008a\u0001\u0010\u0087\u0001R)\u0010\u000b\u001a\u00020\u00022\u0007\u0010\u0083\u0001\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u0085\u0001\u001a\u0006\b\u008d\u0001\u0010\u0087\u0001R)\u0010\u0091\u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b\u008e\u0001\u0010@\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "Landroidx/lifecycle/ViewModel;", "", "title", "Lorg/json/JSONArray;", "labelsJson", "M1", "Lorg/json/JSONObject;", "data", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "R1", "shopId", "", "w2", "", "reqSource", ICustomDataEditor.STRING_PARAM_2, "", "isOrderByTabSelected", ICustomDataEditor.NUMBER_PARAM_2, "scrollToTop", "u2", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "currentOrderByTabInfo", "l2", "abnormal", "v2", FeedManager.LOAD_MORE, "L1", "N1", "rspData", "k2", "r2", "t2", "m2", "orderByJsonArray", "o2", "cardsJsonArray", "p2", "q2", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "_isOrderByTabSelected", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_scrollToTop", BdhLogUtil.LogTag.Tag_Conn, "_currentOrderByTabInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "_orderByInfoList", "", "E", "_orderByTabInfoListLiveData", "Lcom/tencent/ecommerce/biz/shophome/model/c;", UserInfo.SEX_FEMALE, "_productInfoList", "G", "_productInfoListLiveData", "H", "_productRecommendInfoList", "I", "_productRecommendInfoListLiveData", "J", "_isEnd", "K", "_isRecommendEnd", "L", "e2", "()Landroidx/lifecycle/MutableLiveData;", "_isLoadingMore", "M", "f2", "_pageState", "N", "_shopHomeAbnormal", "P", "_shopHomeRoleType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_shopDiscountInfo", BdhLogUtil.LogTag.Tag_Req, "i2", "isOrderByTabSelectedData", ExifInterface.LATITUDE_SOUTH, "X1", "scrollToTopLiveData", "T", "P1", "currentOrderByTabInfoLiveData", "U", "Q1", "orderByTabInfoListLiveData", "V", "S1", "productInfoListLiveData", "W", "T1", "productRecommendInfoListLiveData", "X", "g2", "isEndLiveData", "Y", "j2", "isRecommendEndLiveData", "Z", SemanticAttributes.DbSystemValues.H2, "isLoadingMoreLiveData", "a0", "getPageState", "pageState", "b0", ICustomDataEditor.STRING_ARRAY_PARAM_2, "shopHomeAbnormal", "c0", "b2", "shopHomeRoleType", "Landroidx/lifecycle/LiveData;", "d0", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "shopDiscountInfo", "Lcom/tencent/ecommerce/biz/shophome/repo/ECShopHomeDefaultRepository;", "e0", "Lcom/tencent/ecommerce/biz/shophome/repo/ECShopHomeDefaultRepository;", "W1", "()Lcom/tencent/ecommerce/biz/shophome/repo/ECShopHomeDefaultRepository;", "repo", "<set-?>", "f0", "Ljava/lang/String;", "O1", "()Ljava/lang/String;", "cookie", "g0", "U1", "recommendCookie", "h0", "c2", "i0", "d2", "()I", "source", "<init>", "()V", "j0", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class a extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<ECOrderByTabInfo> _currentOrderByTabInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private final ArrayList<ECOrderByTabInfo> _orderByInfoList;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<List<ECOrderByTabInfo>> _orderByTabInfoListLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final ArrayList<ECShopProductInfo> _productInfoList;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<List<ECShopProductInfo>> _productInfoListLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<ECShopProductInfo> _productRecommendInfoList;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<List<ECShopProductInfo>> _productRecommendInfoListLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isEnd;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isRecommendEnd;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isLoadingMore;

    /* renamed from: M, reason: from kotlin metadata */
    private final MutableLiveData<b> _pageState;

    /* renamed from: N, reason: from kotlin metadata */
    private final MutableLiveData<JSONObject> _shopHomeAbnormal;

    /* renamed from: P, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _shopHomeRoleType;

    /* renamed from: Q, reason: from kotlin metadata */
    private final MutableLiveData<JSONObject> _shopDiscountInfo;

    /* renamed from: R, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isOrderByTabSelectedData;

    /* renamed from: S, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> scrollToTopLiveData;

    /* renamed from: T, reason: from kotlin metadata */
    private final MutableLiveData<ECOrderByTabInfo> currentOrderByTabInfoLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    private final MutableLiveData<List<ECOrderByTabInfo>> orderByTabInfoListLiveData;

    /* renamed from: V, reason: from kotlin metadata */
    private final MutableLiveData<List<ECShopProductInfo>> productInfoListLiveData;

    /* renamed from: W, reason: from kotlin metadata */
    private final MutableLiveData<List<ECShopProductInfo>> productRecommendInfoListLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isEndLiveData;

    /* renamed from: Y, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isRecommendEndLiveData;

    /* renamed from: Z, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> isLoadingMoreLiveData;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<b> pageState;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<JSONObject> shopHomeAbnormal;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> shopHomeRoleType;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<JSONObject> shopDiscountInfo;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final ECShopHomeDefaultRepository repo;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String cookie;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String recommendCookie;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String shopId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _isOrderByTabSelected;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int source;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _scrollToTop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b$c;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b$d;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b$a;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b$a;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "msg", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.shophome.viewmodel.a$b$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes31.dex */
        public static final /* data */ class EmptyState extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final String msg;

            public EmptyState() {
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
                return "EmptyState(msg=" + this.msg + ")";
            }

            public EmptyState(String str) {
                super(null);
                this.msg = str;
            }

            public /* synthetic */ EmptyState(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? "" : str);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof EmptyState) && Intrinsics.areEqual(this.msg, ((EmptyState) other).msg);
                }
                return true;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b$b;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "errorCode", "b", "Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.shophome.viewmodel.a$b$b, reason: collision with other inner class name and from toString */
        /* loaded from: classes31.dex */
        public static final /* data */ class ErrorState extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final int errorCode;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String msg;

            public ErrorState(int i3, String str) {
                super(null);
                this.errorCode = i3;
                this.msg = str;
            }

            public int hashCode() {
                int i3 = this.errorCode * 31;
                String str = this.msg;
                return i3 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                return "ErrorState(errorCode=" + this.errorCode + ", msg=" + this.msg + ")";
            }

            public /* synthetic */ ErrorState(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, (i16 & 2) != 0 ? "" : str);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ErrorState)) {
                    return false;
                }
                ErrorState errorState = (ErrorState) other;
                return this.errorCode == errorState.errorCode && Intrinsics.areEqual(this.msg, errorState.msg);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b$c;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final c f104428a = new c();

            c() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b$d;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class d extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final d f104429a = new d();

            d() {
                super(null);
            }
        }

        b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a() {
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(bool);
        this._isOrderByTabSelected = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(bool);
        this._scrollToTop = mutableLiveData2;
        MutableLiveData<ECOrderByTabInfo> mutableLiveData3 = new MutableLiveData<>();
        this._currentOrderByTabInfo = mutableLiveData3;
        ArrayList<ECOrderByTabInfo> arrayList = new ArrayList<>();
        this._orderByInfoList = arrayList;
        MutableLiveData<List<ECOrderByTabInfo>> mutableLiveData4 = new MutableLiveData<>(arrayList);
        this._orderByTabInfoListLiveData = mutableLiveData4;
        ArrayList<ECShopProductInfo> arrayList2 = new ArrayList<>();
        this._productInfoList = arrayList2;
        MutableLiveData<List<ECShopProductInfo>> mutableLiveData5 = new MutableLiveData<>(arrayList2);
        this._productInfoListLiveData = mutableLiveData5;
        this._productRecommendInfoList = new ArrayList<>();
        MutableLiveData<List<ECShopProductInfo>> mutableLiveData6 = new MutableLiveData<>(arrayList2);
        this._productRecommendInfoListLiveData = mutableLiveData6;
        MutableLiveData<Boolean> mutableLiveData7 = new MutableLiveData<>(bool);
        this._isEnd = mutableLiveData7;
        MutableLiveData<Boolean> mutableLiveData8 = new MutableLiveData<>(bool);
        this._isRecommendEnd = mutableLiveData8;
        MutableLiveData<Boolean> mutableLiveData9 = new MutableLiveData<>(bool);
        this._isLoadingMore = mutableLiveData9;
        MutableLiveData<b> mutableLiveData10 = new MutableLiveData<>();
        this._pageState = mutableLiveData10;
        MutableLiveData<JSONObject> mutableLiveData11 = new MutableLiveData<>();
        this._shopHomeAbnormal = mutableLiveData11;
        MutableLiveData<Integer> mutableLiveData12 = new MutableLiveData<>();
        this._shopHomeRoleType = mutableLiveData12;
        MutableLiveData<JSONObject> mutableLiveData13 = new MutableLiveData<>();
        this._shopDiscountInfo = mutableLiveData13;
        this.isOrderByTabSelectedData = mutableLiveData;
        this.scrollToTopLiveData = mutableLiveData2;
        this.currentOrderByTabInfoLiveData = mutableLiveData3;
        this.orderByTabInfoListLiveData = mutableLiveData4;
        this.productInfoListLiveData = mutableLiveData5;
        this.productRecommendInfoListLiveData = mutableLiveData6;
        this.isEndLiveData = mutableLiveData7;
        this.isRecommendEndLiveData = mutableLiveData8;
        this.isLoadingMoreLiveData = mutableLiveData9;
        this.pageState = mutableLiveData10;
        this.shopHomeAbnormal = mutableLiveData11;
        this.shopHomeRoleType = mutableLiveData12;
        this.shopDiscountInfo = mutableLiveData13;
        this.repo = ECShopHomeDefaultRepository.f104251a;
        this.cookie = "";
        this.recommendCookie = "";
        this.shopId = "";
    }

    private final JSONArray M1(String title, JSONArray labelsJson) {
        l h16 = new k(null, 1, null).h(labelsJson);
        h16.e(title, 14, "qecommerce_skin_color_text_primary", 2);
        return h16.g();
    }

    private final b R1(JSONObject data) {
        int i3 = 1;
        String str = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        byte b19 = 0;
        byte b26 = 0;
        if (data.length() == 0) {
            return new b.EmptyState(str, i3, b26 == true ? 1 : 0);
        }
        int optInt = data.optInt("code", 0);
        if (optInt == 0) {
            JSONArray optJSONArray = data.optJSONArray("cards");
            if ((optJSONArray != null ? optJSONArray.length() : 0) > 0) {
                return b.d.f104429a;
            }
            return new b.EmptyState(b19 == true ? 1 : 0, i3, b18 == true ? 1 : 0);
        }
        return new b.ErrorState(optInt, b17 == true ? 1 : 0, 2, b16 == true ? 1 : 0);
    }

    /* renamed from: O1, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    public final MutableLiveData<ECOrderByTabInfo> P1() {
        return this.currentOrderByTabInfoLiveData;
    }

    public final MutableLiveData<List<ECOrderByTabInfo>> Q1() {
        return this.orderByTabInfoListLiveData;
    }

    public final MutableLiveData<List<ECShopProductInfo>> S1() {
        return this.productInfoListLiveData;
    }

    public final MutableLiveData<List<ECShopProductInfo>> T1() {
        return this.productRecommendInfoListLiveData;
    }

    /* renamed from: U1, reason: from getter */
    public final String getRecommendCookie() {
        return this.recommendCookie;
    }

    /* renamed from: W1, reason: from getter */
    public final ECShopHomeDefaultRepository getRepo() {
        return this.repo;
    }

    public final MutableLiveData<Boolean> X1() {
        return this.scrollToTopLiveData;
    }

    public final LiveData<JSONObject> Z1() {
        return this.shopDiscountInfo;
    }

    public final MutableLiveData<JSONObject> a2() {
        return this.shopHomeAbnormal;
    }

    public final MutableLiveData<Integer> b2() {
        return this.shopHomeRoleType;
    }

    /* renamed from: c2, reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    /* renamed from: d2, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<Boolean> e2() {
        return this._isLoadingMore;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<b> f2() {
        return this._pageState;
    }

    public final MutableLiveData<Boolean> g2() {
        return this.isEndLiveData;
    }

    public final MutableLiveData<b> getPageState() {
        return this.pageState;
    }

    public final MutableLiveData<Boolean> h2() {
        return this.isLoadingMoreLiveData;
    }

    public final MutableLiveData<Boolean> i2() {
        return this.isOrderByTabSelectedData;
    }

    public final MutableLiveData<Boolean> j2() {
        return this.isRecommendEndLiveData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k2(JSONObject rspData) {
        String optString = rspData.optString("cookie", "");
        boolean optBoolean = rspData.optBoolean("is_end", true);
        this.cookie = optString;
        this._isEnd.setValue(Boolean.valueOf(optBoolean));
    }

    public final void l2(ECOrderByTabInfo currentOrderByTabInfo) {
        this._currentOrderByTabInfo.postValue(currentOrderByTabInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m2(JSONObject rspData) {
        this._shopDiscountInfo.setValue(rspData);
    }

    public final void n2(boolean isOrderByTabSelected) {
        this._isOrderByTabSelected.postValue(Boolean.valueOf(isOrderByTabSelected));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o2(JSONArray orderByJsonArray) {
        ArrayList arrayList = new ArrayList();
        int length = orderByJsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = orderByJsonArray.optJSONObject(i3);
            if (optJSONObject != null) {
                ECOrderByTabInfo eCOrderByTabInfo = new ECOrderByTabInfo(optJSONObject.optString("key", ""), optJSONObject.optString("name", ""), 0, optJSONObject.optBoolean("sortable", false), optJSONObject.optBoolean("disabled", false), 4, null);
                if (eCOrderByTabInfo.sortable) {
                    eCOrderByTabInfo.b(0);
                }
                arrayList.add(eCOrderByTabInfo);
            }
        }
        if (!arrayList.isEmpty()) {
            this._orderByInfoList.clear();
            this._orderByInfoList.addAll(arrayList);
            this._orderByTabInfoListLiveData.setValue(this._orderByInfoList);
            l2(this._orderByInfoList.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r2(JSONObject rspData) {
        String optString = rspData.optString("cookie", "");
        boolean optBoolean = rspData.optBoolean("is_end", true);
        this.recommendCookie = optString;
        this._isRecommendEnd.setValue(Boolean.valueOf(optBoolean));
    }

    public final void s2(int reqSource) {
        this.source = reqSource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t2(JSONObject rspData) {
        this._shopHomeRoleType.setValue(Integer.valueOf(rspData.optInt("role_type", 0)));
    }

    public final void u2(boolean scrollToTop) {
        this._scrollToTop.postValue(Boolean.valueOf(scrollToTop));
    }

    public final void v2(JSONObject abnormal) {
        this._shopHomeAbnormal.postValue(abnormal);
    }

    public final void w2(String shopId) {
        this.shopId = shopId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L1(boolean loadMore) {
        if (loadMore) {
            this._isLoadingMore.postValue(Boolean.TRUE);
        } else {
            this._pageState.postValue(b.c.f104428a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N1(boolean loadMore, JSONObject data) {
        if (loadMore) {
            this._isLoadingMore.postValue(Boolean.FALSE);
        } else {
            this._pageState.postValue(R1(data));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p2(JSONArray cardsJsonArray, boolean loadMore) {
        ArrayList arrayList = new ArrayList();
        int length = cardsJsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = cardsJsonArray.optJSONObject(i3);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("title", "");
                JSONArray optJSONArray = optJSONObject.optJSONArray("labels");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                String optString2 = optJSONObject.optString("spu_id", "");
                String optString3 = optJSONObject.optString("url", "");
                optJSONObject.put("nodes", M1(optString, optJSONArray));
                Unit unit = Unit.INSTANCE;
                arrayList.add(new ECShopProductInfo(optString2, optString, optString3, optJSONObject, 0, false, 48, null));
            }
        }
        if (!arrayList.isEmpty()) {
            if (!loadMore) {
                this._productInfoList.clear();
            }
            this._productInfoList.addAll(arrayList);
            this._productInfoListLiveData.setValue(this._productInfoList);
            return;
        }
        this._productInfoListLiveData.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q2(JSONArray cardsJsonArray, boolean loadMore) {
        ArrayList arrayList = new ArrayList();
        if (cardsJsonArray.length() > 0) {
            if (!loadMore) {
                arrayList.add(new ECShopProductInfo("", "", "", new JSONObject(), 2, false, 32, null));
            }
            int length = cardsJsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = cardsJsonArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    arrayList.add(new ECShopProductInfo(optJSONObject.optString("spu_id", ""), optJSONObject.optString("title", ""), optJSONObject.optString("url", ""), optJSONObject, 0, false, 48, null));
                }
            }
        }
        int i16 = 1;
        if (!arrayList.isEmpty()) {
            if (!loadMore) {
                this._productRecommendInfoList.clear();
            }
            this._productRecommendInfoList.addAll(arrayList);
            this._productRecommendInfoListLiveData.setValue(this._productRecommendInfoList);
            return;
        }
        List<ECShopProductInfo> value = this._productInfoListLiveData.getValue();
        if (value == null || !value.isEmpty()) {
            return;
        }
        this._pageState.postValue(new b.EmptyState(null, i16, 0 == true ? 1 : 0));
    }
}
