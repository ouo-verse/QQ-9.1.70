package jj0;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 82\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\fR2\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R2\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R2\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060'8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b\u001a\u0010/\"\u0004\b0\u00101R\"\u00104\u001a\u00020,8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010.\u001a\u0004\b-\u0010/\"\u0004\b3\u00101R\"\u00107\u001a\u00020,8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b5\u0010/\"\u0004\b6\u00101R\"\u0010:\u001a\u00020,8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010.\u001a\u0004\b8\u0010/\"\u0004\b9\u00101\u00a8\u0006="}, d2 = {"Ljj0/b;", "", "Ljj0/d;", "reqTimeRange", "Lorg/json/JSONObject;", "b", "", "shouldRestoreData", "", DomainData.DOMAIN_NAME, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "e", "", "f", "a", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "setDateList", "(Ljava/util/ArrayList;)V", "dateList", h.F, "setMoneyList", "moneyList", "c", "j", "setOrderNumList", "orderNumList", "l", "setPersonNumList", "personNumList", "Ljava/lang/String;", "getLastModifiedTime", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "lastModifiedTime", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroidx/lifecycle/MutableLiveData;", "ptsLiveData", "Lorg/json/JSONArray;", "g", "Lorg/json/JSONArray;", "()Lorg/json/JSONArray;", "o", "(Lorg/json/JSONArray;)V", "dataJsonArray", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "moneyJSONArray", "i", "r", "orderNumJSONArray", "k", ReportConstant.COSTREPORT_PREFIX, "personNumJSONArray", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ArrayList<String> dateList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Long> moneyList = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Long> orderNumList = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Long> personNumList = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String lastModifiedTime = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> ptsLiveData = new MutableLiveData<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public JSONArray dataJsonArray;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public JSONArray moneyJSONArray;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public JSONArray orderNumJSONArray;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public JSONArray personNumJSONArray;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"jj0/b$b", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: jj0.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10591b implements IECJsonNetworkCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f409969b;

        C10591b(boolean z16) {
            this.f409969b = z16;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            cg0.a.a("ECTransactionHistoryCurveViewModel", "getHistoryCurve$\\reqHistoryCurve\\$\\onError", String.valueOf(errorResponse));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            ArrayList<Long> l3;
            Object obj;
            ArrayList<Long> j3;
            Object obj2;
            ArrayList<Long> h16;
            Object obj3;
            if (respData == null) {
                cg0.a.b("ECTransactionHistoryCurveViewModel", "req GetHistoryCurve, return rspData is null");
                return;
            }
            b.this.p(respData.optString("last_modified_time"));
            b bVar = b.this;
            JSONArray optJSONArray = respData.optJSONArray("dates");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            bVar.o(optJSONArray);
            b bVar2 = b.this;
            JSONArray optJSONArray2 = respData.optJSONArray("moneys");
            if (optJSONArray2 == null) {
                optJSONArray2 = new JSONArray();
            }
            bVar2.q(optJSONArray2);
            b bVar3 = b.this;
            JSONArray optJSONArray3 = respData.optJSONArray("order_nums");
            if (optJSONArray3 == null) {
                optJSONArray3 = new JSONArray();
            }
            bVar3.r(optJSONArray3);
            b bVar4 = b.this;
            JSONArray optJSONArray4 = respData.optJSONArray("person_nums");
            if (optJSONArray4 == null) {
                optJSONArray4 = new JSONArray();
            }
            bVar4.s(optJSONArray4);
            b.this.d().clear();
            int length = b.this.c().length();
            for (int i3 = 0; i3 < length; i3++) {
                ArrayList<String> d16 = b.this.d();
                Object obj4 = b.this.c().get(i3);
                if (obj4 != null) {
                    String substring = ((String) obj4).substring(5);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    d16.add(substring);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            b.this.h().clear();
            int length2 = b.this.g().length();
            for (int i16 = 0; i16 < length2; i16++) {
                try {
                    h16 = b.this.h();
                    obj3 = b.this.g().get(i16);
                } catch (Exception e16) {
                    b.this.h().add(0L);
                    cg0.a.a("ECTransactionHistoryCurveViewModel", "reqHistoryCurveData", "decode rspData error " + e16);
                }
                if (obj3 != null) {
                    h16.add(Long.valueOf(Long.parseLong((String) obj3)));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    break;
                }
            }
            b.this.j().clear();
            int length3 = b.this.i().length();
            for (int i17 = 0; i17 < length3; i17++) {
                try {
                    j3 = b.this.j();
                    obj2 = b.this.i().get(i17);
                } catch (Exception e17) {
                    b.this.j().add(0L);
                    cg0.a.a("ECTransactionHistoryCurveViewModel", "reqHistoryCurveData", "decode rspData error " + e17);
                }
                if (obj2 != null) {
                    j3.add(Long.valueOf(Long.parseLong((String) obj2)));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    break;
                }
            }
            b.this.l().clear();
            int length4 = b.this.k().length();
            for (int i18 = 0; i18 < length4; i18++) {
                try {
                    l3 = b.this.l();
                    obj = b.this.k().get(i18);
                } catch (Exception e18) {
                    b.this.l().add(0L);
                    cg0.a.a("ECTransactionHistoryCurveViewModel", "reqHistoryCurveData", "decode rspData error " + e18);
                }
                if (obj != null) {
                    l3.add(Long.valueOf(Long.parseLong((String) obj)));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    break;
                }
            }
            b.this.m().postValue(Boolean.TRUE);
            if (this.f409969b) {
                ECLocalConfig eCLocalConfig = ECLocalConfig.f100650f;
                IECLocalConfig.a.j(eCLocalConfig, "lc_transaction_curve_date_info_data_key", b.this.c().toString(), null, 4, null);
                IECLocalConfig.a.j(eCLocalConfig, "lc_transaction_curve_money_info_data_key", b.this.g().toString(), null, 4, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"jj0/b$c", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class c implements IECRequest {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECTransactionReqTimeRange f409971b;

        c(ECTransactionReqTimeRange eCTransactionReqTimeRange) {
            this.f409971b = eCTransactionReqTimeRange;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECRequest
        public JSONObject encodeParams() {
            return b.this.b(this.f409971b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject b(ECTransactionReqTimeRange reqTimeRange) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("start", reqTimeRange.getStartTime());
        jSONObject2.put("end", reqTimeRange.getEndTime());
        jSONObject.put("time_range", jSONObject2);
        return jSONObject;
    }

    public final JSONArray c() {
        JSONArray jSONArray = this.dataJsonArray;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataJsonArray");
        }
        return jSONArray;
    }

    public final ArrayList<String> d() {
        return this.dateList;
    }

    public final ArrayList<String> e() {
        String f16 = IECLocalConfig.a.f(ECLocalConfig.f100650f, "lc_transaction_curve_date_info_data_key", "", null, 4, null);
        if (Intrinsics.areEqual(f16, "")) {
            return new ArrayList<>();
        }
        JSONArray jSONArray = new JSONArray(f16);
        ArrayList<String> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = jSONArray.get(i3);
            if (obj != null) {
                String substring = ((String) obj).substring(5);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                arrayList.add(substring);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        return arrayList;
    }

    public final ArrayList<Long> f() {
        Object obj;
        String f16 = IECLocalConfig.a.f(ECLocalConfig.f100650f, "lc_transaction_curve_money_info_data_key", "", null, 4, null);
        if (Intrinsics.areEqual(f16, "")) {
            return new ArrayList<>();
        }
        JSONArray jSONArray = new JSONArray(f16);
        ArrayList<Long> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            try {
                obj = jSONArray.get(i3);
            } catch (Exception e16) {
                this.moneyList.add(0L);
                cg0.a.a("ECTransactionHistoryCurveViewModel", "getLocalConfigCurveMoneyData", "decode rspData error " + e16);
            }
            if (obj != null) {
                arrayList.add(Long.valueOf(Long.parseLong((String) obj)));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                break;
            }
        }
        return arrayList;
    }

    public final JSONArray g() {
        JSONArray jSONArray = this.moneyJSONArray;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moneyJSONArray");
        }
        return jSONArray;
    }

    public final ArrayList<Long> h() {
        return this.moneyList;
    }

    public final JSONArray i() {
        JSONArray jSONArray = this.orderNumJSONArray;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderNumJSONArray");
        }
        return jSONArray;
    }

    public final ArrayList<Long> j() {
        return this.orderNumList;
    }

    public final JSONArray k() {
        JSONArray jSONArray = this.personNumJSONArray;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personNumJSONArray");
        }
        return jSONArray;
    }

    public final ArrayList<Long> l() {
        return this.personNumList;
    }

    public final MutableLiveData<Boolean> m() {
        return this.ptsLiveData;
    }

    public final void n(ECTransactionReqTimeRange reqTimeRange, boolean shouldRestoreData) {
        com.tencent.ecommerce.base.network.service.a.c("trpc.ecom.trade_data_panel_svr.TradeDataPanelSvr", "/trpc.ecom.trade_data_panel_svr.TradeDataPanelSvr/GetStatCurve", new c(reqTimeRange).encodeParams(), new C10591b(shouldRestoreData));
    }

    public final void o(JSONArray jSONArray) {
        this.dataJsonArray = jSONArray;
    }

    public final void p(String str) {
        this.lastModifiedTime = str;
    }

    public final void q(JSONArray jSONArray) {
        this.moneyJSONArray = jSONArray;
    }

    public final void r(JSONArray jSONArray) {
        this.orderNumJSONArray = jSONArray;
    }

    public final void s(JSONArray jSONArray) {
        this.personNumJSONArray = jSONArray;
    }
}
