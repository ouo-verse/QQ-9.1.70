package com.tencent.ecommerce.biz.orders.sellerorders;

import ak0.ECSellerOrder;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.SellerOrderFilterOption;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.f;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.g;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.ecommerce.biz.util.j;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\f\u0010\u0016\u001a\u00020\n*\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0012\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e*\u00020\u0018H\u0002J\u0006\u0010\u001b\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0006R \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000e0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R#\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000e0$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00103\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010\"R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0006\u00a2\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u0010(R\u0018\u00109\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\"R(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010&\u001a\u0004\bB\u0010(\"\u0004\bC\u0010DR \u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010\"R#\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0$8\u0006\u00a2\u0006\f\n\u0004\bH\u0010&\u001a\u0004\bI\u0010(R$\u0010P\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/d;", "filterOption", "", "cookie", "", "i2", "Lorg/json/JSONObject;", "respData", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "isLocal", "d2", "", "Lak0/a;", SemanticAttributes.DbSystemValues.H2, "", "price", "T1", "time", "m2", "f2", "W1", "Lorg/json/JSONArray;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/c;", "l2", "g2", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, MiniChatConstants.MINI_APP_SHOW_DETAIL, ICustomDataEditor.NUMBER_PARAM_2, "Z1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_saasPlatforms", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/LiveData;", "saasPlatforms", "value", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/d;", "U1", "()Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/d;", "k2", "(Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/d;)V", "kotlin.jvm.PlatformType", "D", "_sellerOrderFilterOption", "E", "b2", "sellerOrderFilterOption", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "curCookie", "G", "Z", "isEnd", "H", "isRequesting", "I", "searchQuery", "J", "getSearchQueryLiveData", "setSearchQueryLiveData", "(Landroidx/lifecycle/LiveData;)V", "searchQueryLiveData", "K", "_sellerOrderList", "L", "c2", "sellerOrderList", "<set-?>", "M", "Lorg/json/JSONArray;", "X1", "()Lorg/json/JSONArray;", "saasInfoJsonArray", "<init>", "()V", "P", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSellerOrderViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private SellerOrderFilterOption filterOption;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<SellerOrderFilterOption> _sellerOrderFilterOption;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<SellerOrderFilterOption> sellerOrderFilterOption;

    /* renamed from: F, reason: from kotlin metadata */
    private volatile String curCookie;

    /* renamed from: G, reason: from kotlin metadata */
    private volatile boolean isEnd;

    /* renamed from: H, reason: from kotlin metadata */
    private volatile boolean isRequesting;

    /* renamed from: I, reason: from kotlin metadata */
    private MutableLiveData<String> searchQuery;

    /* renamed from: J, reason: from kotlin metadata */
    private LiveData<String> searchQueryLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<List<ECSellerOrder>> _sellerOrderList;

    /* renamed from: L, reason: from kotlin metadata */
    private final LiveData<List<ECSellerOrder>> sellerOrderList;

    /* renamed from: M, reason: from kotlin metadata */
    private JSONArray saasInfoJsonArray;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<c>> _saasPlatforms;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<c>> saasPlatforms;
    private static final int N = 200;

    public ECSellerOrderViewModel() {
        MutableLiveData<List<c>> mutableLiveData = new MutableLiveData<>();
        this._saasPlatforms = mutableLiveData;
        this.saasPlatforms = mutableLiveData;
        this.filterOption = new SellerOrderFilterOption(null, null, null, null, null, 31, null);
        MutableLiveData<SellerOrderFilterOption> mutableLiveData2 = new MutableLiveData<>(this.filterOption);
        this._sellerOrderFilterOption = mutableLiveData2;
        this.sellerOrderFilterOption = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.searchQuery = mutableLiveData3;
        this.searchQueryLiveData = mutableLiveData3;
        MutableLiveData<List<ECSellerOrder>> mutableLiveData4 = new MutableLiveData<>();
        this._sellerOrderList = mutableLiveData4;
        this.sellerOrderList = mutableLiveData4;
        this.saasInfoJsonArray = new JSONArray();
        W1();
        j2(this, this.filterOption, null, 2, null);
    }

    private final void T1(long price) {
        int i3 = N;
        if (price <= i3 || price <= i3) {
            cg0.a.a("ECSellerOrderViewModel", "parseOrderListFromRspData", "price error, response Data:" + price);
        }
    }

    private final void W1() {
        String f16 = IECLocalConfig.a.f(ECLocalConfig.f100650f, "lc_seller_order_info_data_key", "", null, 4, null);
        if (Intrinsics.areEqual(f16, "")) {
            return;
        }
        d2(new JSONObject(f16), false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f2(SellerOrderFilterOption sellerOrderFilterOption) {
        return (sellerOrderFilterOption.searchKey.length() == 0) && Intrinsics.areEqual(sellerOrderFilterOption.timeOption, g.a.f103876c) && Intrinsics.areEqual(sellerOrderFilterOption.category, f.a.f103871c) && sellerOrderFilterOption.c().isEmpty() && sellerOrderFilterOption.d().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<c> l2(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            arrayList.add(new c(jSONObject.optInt("goods_type"), jSONObject.optString("saas_name"), jSONObject.optString("saas_str")));
        }
        return arrayList;
    }

    private final String m2(String time) {
        Calendar calendar = Calendar.getInstance();
        Date parse = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINA).parse(time);
        calendar.setTime(parse);
        int i3 = calendar.get(1);
        int i16 = calendar.get(2);
        int i17 = calendar.get(5);
        calendar.setTime(new Date());
        int i18 = calendar.get(1);
        int i19 = calendar.get(2);
        int i26 = calendar.get(5);
        if (i3 == i18 && i16 == i19 && i17 == i26) {
            return "\u4eca\u5929";
        }
        if (i3 == i18) {
            return new SimpleDateFormat("MM.dd", Locale.CHINA).format(parse);
        }
        return new SimpleDateFormat("yyyy.MM.dd", Locale.CHINA).format(parse);
    }

    /* renamed from: U1, reason: from getter */
    public final SellerOrderFilterOption getFilterOption() {
        return this.filterOption;
    }

    /* renamed from: X1, reason: from getter */
    public final JSONArray getSaasInfoJsonArray() {
        return this.saasInfoJsonArray;
    }

    public final void Z1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSellerOrderViewModel$getSaasInfoList$1(this, null), 3, null);
    }

    public final LiveData<List<c>> a2() {
        return this.saasPlatforms;
    }

    public final LiveData<SellerOrderFilterOption> b2() {
        return this.sellerOrderFilterOption;
    }

    public final LiveData<List<ECSellerOrder>> c2() {
        return this.sellerOrderList;
    }

    public final void g2() {
        cg0.a.b("ECSellerOrderViewModel", "loadData, cookie = " + this.curCookie + ", isRequesting=" + this.isRequesting + ",isEnd=" + this.isEnd);
        if (this.isRequesting || this.isEnd) {
            return;
        }
        i2(this.filterOption, this.curCookie);
    }

    public final void k2(SellerOrderFilterOption sellerOrderFilterOption) {
        this.filterOption = sellerOrderFilterOption;
        this.curCookie = "";
        this._sellerOrderFilterOption.postValue(sellerOrderFilterOption);
        j2(this, sellerOrderFilterOption, null, 2, null);
    }

    private final void i2(SellerOrderFilterOption filterOption, String cookie) {
        this.isRequesting = true;
        ECSellerOrderRepository.f103821a.d(filterOption, cookie != null ? cookie : "", new b(cookie, filterOption));
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n2(String orderId, boolean showDetail) {
        List<ECSellerOrder> mutableList;
        ECSellerOrder a16;
        List<ECSellerOrder> value = this._sellerOrderList.getValue();
        if (value == null || mutableList == null) {
            return;
        }
        Iterator<ECSellerOrder> it = mutableList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().orderId, orderId)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            JSONObject jSONObject = new JSONObject(mutableList.get(i3).dataJSONObject.toString());
            jSONObject.put("show_details", !showDetail ? 1 : 0);
            a16 = r4.a((r18 & 1) != 0 ? r4.dataJSONObject : jSONObject, (r18 & 2) != 0 ? r4.orderId : null, (r18 & 4) != 0 ? r4.state : 0, (r18 & 8) != 0 ? r4.orderPrice : 0L, (r18 & 16) != 0 ? r4.saasType : null, (r18 & 32) != 0 ? r4.saasTypeStr : null, (r18 & 64) != 0 ? mutableList.get(i3).createTime : null);
            mutableList.set(i3, a16);
            this._sellerOrderList.setValue(mutableList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderViewModel$b", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECJsonNetworkCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f103825b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SellerOrderFilterOption f103826c;

        b(String str, SellerOrderFilterOption sellerOrderFilterOption) {
            this.f103825b = str;
            this.f103826c = sellerOrderFilterOption;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            ECSellerOrderViewModel.this.isRequesting = false;
            cg0.a.a("ECSellerOrderViewModel", "requestSellerOrders$onError", "requestSellerOrders Error");
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            boolean z16;
            String str;
            if (respData == null) {
                return;
            }
            if (ECSellerOrderViewModel.this.f2(this.f103826c) && this.f103825b == null) {
                IECLocalConfig.a.j(ECLocalConfig.f100650f, "lc_seller_order_info_data_key", respData.toString(), null, 4, null);
            }
            ECSellerOrderViewModel eCSellerOrderViewModel = ECSellerOrderViewModel.this;
            String str2 = this.f103825b;
            boolean z17 = true;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z16 = true;
                    ECSellerOrderViewModel.e2(eCSellerOrderViewModel, respData, z16, false, 4, null);
                    ECSellerOrderViewModel.this.curCookie = respData.optString("cookie");
                    ECSellerOrderViewModel eCSellerOrderViewModel2 = ECSellerOrderViewModel.this;
                    str = eCSellerOrderViewModel2.curCookie;
                    if (str != null && str.length() != 0) {
                        z17 = false;
                    }
                    eCSellerOrderViewModel2.isEnd = z17;
                    ECSellerOrderViewModel.this.isRequesting = false;
                }
            }
            z16 = false;
            ECSellerOrderViewModel.e2(eCSellerOrderViewModel, respData, z16, false, 4, null);
            ECSellerOrderViewModel.this.curCookie = respData.optString("cookie");
            ECSellerOrderViewModel eCSellerOrderViewModel22 = ECSellerOrderViewModel.this;
            str = eCSellerOrderViewModel22.curCookie;
            if (str != null) {
                z17 = false;
            }
            eCSellerOrderViewModel22.isEnd = z17;
            ECSellerOrderViewModel.this.isRequesting = false;
        }
    }

    private final void d2(JSONObject respData, boolean isLoadMore, boolean isLocal) {
        if (!isLocal || this._sellerOrderList.getValue() == null) {
            List<ECSellerOrder> h26 = h2(respData);
            if (!isLoadMore) {
                this._sellerOrderList.postValue(h26);
                return;
            }
            ArrayList arrayList = new ArrayList();
            List<ECSellerOrder> value = this.sellerOrderList.getValue();
            if (value != null) {
                arrayList.addAll(value);
            }
            arrayList.addAll(h26);
            this._sellerOrderList.postValue(arrayList);
        }
    }

    private final List<ECSellerOrder> h2(JSONObject respData) {
        String str;
        String str2;
        JSONArray jSONArray;
        int i3;
        int i16;
        long optLong;
        Object orNull;
        Object orNull2;
        JSONObject optJSONObject;
        String str3 = "price";
        String str4 = "order_price";
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = respData.optJSONArray("seller_orders");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            int i17 = 0;
            int i18 = 0;
            while (i18 < length) {
                try {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i18);
                    optJSONObject2.put("show_details", i17);
                    String optString = optJSONObject2.optString("saas_order_info");
                    String optString2 = optJSONObject2.optString("qshop_order_info");
                    jSONArray = optJSONArray;
                    if (!Intrinsics.areEqual(optString, "null")) {
                        try {
                            JSONObject jSONObject = new JSONObject(optString);
                            JSONObject optJSONObject3 = jSONObject.optJSONObject("saas_product_info");
                            i3 = length;
                            if (optJSONObject3 != null) {
                                try {
                                    long optLong2 = optJSONObject3.optLong("product_price");
                                    i16 = i18;
                                    try {
                                        optJSONObject3.put("product_price", j.f104870a.a(optLong2));
                                        optJSONObject2.put("saas_order_info", jSONObject);
                                        T1(optLong2);
                                    } catch (JSONException e16) {
                                        e = e16;
                                        str = str3;
                                        str2 = str4;
                                        cg0.a.a("ECSellerOrderViewModel", "getSellerOrderList$onSuccess", e.toString());
                                        i18 = i16 + 1;
                                        str3 = str;
                                        optJSONArray = jSONArray;
                                        length = i3;
                                        str4 = str2;
                                        i17 = 0;
                                    }
                                } catch (JSONException e17) {
                                    e = e17;
                                    i16 = i18;
                                    str = str3;
                                    str2 = str4;
                                    cg0.a.a("ECSellerOrderViewModel", "getSellerOrderList$onSuccess", e.toString());
                                    i18 = i16 + 1;
                                    str3 = str;
                                    optJSONArray = jSONArray;
                                    length = i3;
                                    str4 = str2;
                                    i17 = 0;
                                }
                            } else {
                                i16 = i18;
                            }
                        } catch (JSONException e18) {
                            e = e18;
                            i3 = length;
                        }
                    } else {
                        i3 = length;
                        i16 = i18;
                        if (!Intrinsics.areEqual(optString2, "null")) {
                            JSONObject jSONObject2 = new JSONObject(optString2);
                            JSONObject optJSONObject4 = jSONObject2.optJSONObject("product_cart");
                            JSONObject optJSONObject5 = (optJSONObject4 == null || (optJSONObject = optJSONObject4.optJSONObject("order_sku")) == null) ? null : optJSONObject.optJSONObject("sku");
                            if (optJSONObject5 != null) {
                                long optLong3 = optJSONObject5.optLong(str3);
                                optJSONObject5.put(str3, j.f104870a.a(optLong3));
                                optJSONObject2.put("qshop_order_info", jSONObject2);
                                T1(optLong3);
                            }
                        }
                    }
                    JSONObject optJSONObject6 = optJSONObject2.optJSONObject("basic_info");
                    if (optJSONObject6 == null) {
                        optJSONObject6 = new JSONObject();
                    }
                    long optLong4 = optJSONObject6.optLong(str4);
                    j jVar = j.f104870a;
                    optJSONObject6.put(str4, jVar.a(optLong4));
                    JSONObject optJSONObject7 = optJSONObject2.optJSONObject("subsidy_info");
                    str = str3;
                    str2 = str4;
                    if (optJSONObject7 != null) {
                        try {
                            optLong = optJSONObject7.optLong(WidgetCacheConstellationData.MONEY);
                            optJSONObject7.put(WidgetCacheConstellationData.MONEY, i.f104869a.b(optLong));
                        } catch (JSONException e19) {
                            e = e19;
                            cg0.a.a("ECSellerOrderViewModel", "getSellerOrderList$onSuccess", e.toString());
                            i18 = i16 + 1;
                            str3 = str;
                            optJSONArray = jSONArray;
                            length = i3;
                            str4 = str2;
                            i17 = 0;
                        }
                    } else {
                        optLong = 0;
                    }
                    JSONObject optJSONObject8 = optJSONObject2.optJSONObject("commission_info");
                    if (optJSONObject8 != null) {
                        List<String> b16 = jVar.b(optJSONObject8.optLong("commission") + optLong);
                        orNull = CollectionsKt___CollectionsKt.getOrNull(b16, 0);
                        String str5 = (String) orNull;
                        if (str5 == null) {
                            str5 = "0";
                        }
                        optJSONObject8.put("commission_integer", str5);
                        orNull2 = CollectionsKt___CollectionsKt.getOrNull(b16, 1);
                        String str6 = (String) orNull2;
                        if (str6 == null) {
                            str6 = "00";
                        }
                        optJSONObject8.put("commission_decimal", str6);
                        optJSONObject8.put("commission", i.f104869a.b(optJSONObject8.optLong("commission")));
                    }
                    String optString3 = optJSONObject6.optString("order_id");
                    if (optString3 == null) {
                        optString3 = "";
                    }
                    arrayList.add(new ECSellerOrder(optJSONObject2, optString3, 0, 0L, null, null, m2(optJSONObject6.optString(AlbumCacheData.CREATE_TIME)), 60, null));
                } catch (JSONException e26) {
                    e = e26;
                    str = str3;
                    str2 = str4;
                    jSONArray = optJSONArray;
                    i3 = length;
                    i16 = i18;
                }
                i18 = i16 + 1;
                str3 = str;
                optJSONArray = jSONArray;
                length = i3;
                str4 = str2;
                i17 = 0;
            }
        }
        return arrayList;
    }

    static /* synthetic */ void e2(ECSellerOrderViewModel eCSellerOrderViewModel, JSONObject jSONObject, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        eCSellerOrderViewModel.d2(jSONObject, z16, z17);
    }

    static /* synthetic */ void j2(ECSellerOrderViewModel eCSellerOrderViewModel, SellerOrderFilterOption sellerOrderFilterOption, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        eCSellerOrderViewModel.i2(sellerOrderFilterOption, str);
    }
}
