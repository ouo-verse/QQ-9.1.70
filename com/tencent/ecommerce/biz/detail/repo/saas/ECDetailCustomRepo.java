package com.tencent.ecommerce.biz.detail.repo.saas;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bh0.ECPageParserParams;
import ck0.Product;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.ecommerce.biz.detail.utils.e;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.pts.core.PTSComposer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \b2\u00020\u0001:\u0001\u0019B7\u0012\b\b\u0002\u0010J\u001a\u00020\u0012\u0012\b\b\u0002\u0010K\u001a\u00020\u0012\u0012\b\b\u0002\u0010L\u001a\u00020\u0012\u0012\b\b\u0002\u0010M\u001a\u00020\u0012\u0012\u0006\u0010N\u001a\u000206\u00a2\u0006\u0004\bO\u0010PJ\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J \u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u0010\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0002J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J+\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R#\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\"8\u0006\u00a2\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010 R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b/\u0010$\u001a\u0004\b0\u0010&R\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010 R\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002020\"8\u0006\u00a2\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b4\u0010&R\"\u0010<\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010=R\"\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010ER\u0014\u0010H\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010GR\u0014\u0010J\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010IR\u0014\u0010K\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010IR\u0014\u0010L\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010IR\u0014\u0010M\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010IR\u0017\u0010N\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u00107\u001a\u0004\bN\u00109\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Q"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailCustomRepo;", "", "Lorg/json/JSONObject;", "requestParams", "", "Lcom/tencent/ecommerce/base/ui/b;", "p", "data", "u", "", "r", "", "j", WebViewPlugin.KEY_REQUEST, "Lcom/tencent/ecommerce/base/network/api/d;", "remoteResponse", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "", "service", "method", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailCustomRelatedRepo;", "a", "Lkotlin/Lazy;", "k", "()Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailCustomRelatedRepo;", "customRelatedRepo", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "_baseViewData", "Landroidx/lifecycle/LiveData;", "c", "Landroidx/lifecycle/LiveData;", h.F, "()Landroidx/lifecycle/LiveData;", "adapterLiveDataPts", "d", "_buyItemUrl", "e", "i", "buyItemUrlData", "f", "_sourceData", "g", DomainData.DOMAIN_NAME, "sourceLiveData", "Lck0/c;", "_product", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "productLiveData", "", "Z", "l", "()Z", "setNeedDetail", "(Z)V", "needDetail", "Lcom/tencent/ecommerce/base/network/api/d;", "_realTimeResponse", "Ljava/util/List;", "dataSourcePts", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lcom/tencent/ecommerce/base/report/service/k;", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "Lck0/c;", "product", "Ljava/lang/String;", "mediaProductId", "mediaId", "categoryName", "goodsType", MiniGamePAHippyBaseFragment.KEY_THEME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailCustomRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy customRelatedRepo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<List<ECBasePtsViewData>> _baseViewData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<ECBasePtsViewData>> adapterLiveDataPts;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<String> _buyItemUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> buyItemUrlData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<JSONObject> _sourceData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final LiveData<JSONObject> sourceLiveData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Product> _product;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Product> productLiveData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean needDetail;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ECNetworkResponse<JSONObject> _realTimeResponse;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private List<List<ECBasePtsViewData>> dataSourcePts;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Mutex mutex;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final k showPageCostTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Product product;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final String mediaProductId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final String mediaId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final String categoryName;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final String goodsType;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final boolean isNightMode;

    private final List<ECBasePtsViewData> j(JSONObject data, JSONObject requestParams) {
        JSONObject optJSONObject = data.optJSONObject("product");
        this.needDetail = (optJSONObject != null ? optJSONObject.optInt("state") : 0) == 1;
        e eVar = e.f102467a;
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(eVar.c(data, false));
        JSONObject a17 = eVar.a(this.goodsType, this.categoryName, this.isNightMode, true);
        if (eVar.g(this.goodsType)) {
            JSONObject optJSONObject2 = data.optJSONObject("tx_video_product");
            a17.put("EC_GOODS_DETAIL_TYPE", optJSONObject2 != null ? optJSONObject2.optInt("detail_type") : 0);
        }
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, a17);
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(a17);
        }
        return a16.process(processRemoteParserParamsArray, data, requestParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECDetailCustomRelatedRepo k() {
        return (ECDetailCustomRelatedRepo) this.customRelatedRepo.getValue();
    }

    private final List<ECBasePtsViewData> p(JSONObject requestParams) {
        String str = (String) ECLocalConfig.f100650f.get(k().b(this.mediaId), "", Boolean.TRUE);
        if (!TextUtils.isEmpty(str)) {
            try {
                List<ECBasePtsViewData> a16 = k().a(new JSONObject(str), requestParams);
                return a16 != null ? a16 : new ArrayList();
            } catch (JSONException e16) {
                cg0.a.a("ECDetailCustomRepo", "[loadDetailFromCache]", e16.toString());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        if (this.dataSourcePts.size() != 2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<ECBasePtsViewData> list = this.dataSourcePts.get(0);
        List<ECBasePtsViewData> list2 = list;
        if (!list2.isEmpty()) {
            ECNetworkResponse<JSONObject> eCNetworkResponse = this._realTimeResponse;
            if (eCNetworkResponse != null) {
                q(list, eCNetworkResponse);
                this._realTimeResponse = null;
            }
            arrayList.addAll(list2);
            arrayList.addAll(this.dataSourcePts.get(1));
            this._baseViewData.postValue(arrayList);
        }
    }

    private final JSONObject u(JSONObject data) {
        JSONObject jSONObject = new JSONObject();
        String optString = data.optString(AppDownloadCallback.BUTTON_TXT);
        if (optString == null) {
            optString = "\u7acb\u5373\u8d2d\u4e70";
        }
        jSONObject.put(AppDownloadCallback.BUTTON_TXT, optString);
        String optString2 = data.optString("button_extra_txt");
        if (optString2 == null) {
            optString2 = "";
        }
        jSONObject.put("button_extra_txt", optString2);
        String optString3 = data.optString("button_bg_color");
        if (optString3 == null) {
            optString3 = "linear-gradient(to right, #0099FF 0%, #0099FF 100%)";
        }
        String str = optString3;
        jSONObject.put("button_bg_color", str);
        IECLocalConfig.a.j(ECLocalConfig.f100650f, "button_bg_color", str, null, 4, null);
        return jSONObject;
    }

    public final LiveData<List<ECBasePtsViewData>> h() {
        return this.adapterLiveDataPts;
    }

    public final LiveData<String> i() {
        return this.buyItemUrlData;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getNeedDetail() {
        return this.needDetail;
    }

    public final LiveData<Product> m() {
        return this.productLiveData;
    }

    public final LiveData<JSONObject> n() {
        return this.sourceLiveData;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List, T] */
    public final void o(JSONObject requestParams) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        JSONObject d16 = wh0.a.f445642d.d(false, this.mediaProductId);
        if (d16 != null) {
            objectRef.element = j(d16, requestParams);
            this._sourceData.postValue(u(d16));
            cg0.a.b("ECDetailCustomRepo", "[requestCustomLiveData] cache = " + d16);
            d.f102466a.r(this.showPageCostTime, false, 1);
        } else {
            cg0.a.b("ECDetailCustomRepo", "[requestCustomLiveData] cache missed");
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ECDetailCustomRepo$loadDetailFromCache$2(this, objectRef, p(requestParams), null), 3, null);
    }

    public final Object s(String str, String str2, JSONObject jSONObject, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ECDetailCustomRepo$requestCustomLiveData$2(this, str, str2, jSONObject, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object t(String str, String str2, JSONObject jSONObject, Continuation<? super List<ECBasePtsViewData>> continuation) {
        ECDetailCustomRepo$requestDataWithModel$1 eCDetailCustomRepo$requestDataWithModel$1;
        Object coroutine_suspended;
        int i3;
        ECDetailCustomRepo eCDetailCustomRepo;
        ECNetworkResponse eCNetworkResponse;
        String str3;
        String optString;
        Long boxLong;
        if (continuation instanceof ECDetailCustomRepo$requestDataWithModel$1) {
            eCDetailCustomRepo$requestDataWithModel$1 = (ECDetailCustomRepo$requestDataWithModel$1) continuation;
            int i16 = eCDetailCustomRepo$requestDataWithModel$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDetailCustomRepo$requestDataWithModel$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDetailCustomRepo$requestDataWithModel$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDetailCustomRepo$requestDataWithModel$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCDetailCustomRepo$requestDataWithModel$1.L$0 = this;
                    eCDetailCustomRepo$requestDataWithModel$1.L$1 = jSONObject;
                    eCDetailCustomRepo$requestDataWithModel$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e(str, str2, bVar, jSONObject, eCDetailCustomRepo$requestDataWithModel$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCDetailCustomRepo = this;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCDetailCustomRepo$requestDataWithModel$1.L$1;
                    eCDetailCustomRepo = (ECDetailCustomRepo) eCDetailCustomRepo$requestDataWithModel$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    JSONObject jSONObject2 = (JSONObject) eCNetworkResponse.b();
                    if (jSONObject2 == null) {
                        return null;
                    }
                    cg0.a.b("ECDetailCustomRepo", "[requestPreloadProductDetail] data = " + jSONObject2);
                    Product product = eCDetailCustomRepo.product;
                    JSONObject optJSONObject = jSONObject2.optJSONObject("product");
                    String str4 = "";
                    if (optJSONObject == null || (str3 = optJSONObject.optString("title")) == null) {
                        str3 = "";
                    }
                    product.Y(str3);
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("product");
                    product.U((optJSONObject2 == null || (boxLong = Boxing.boxLong(optJSONObject2.optLong("sales"))) == null) ? 0L : boxLong.longValue());
                    JSONObject optJSONObject3 = jSONObject2.optJSONObject("product");
                    if (optJSONObject3 != null && (optString = optJSONObject3.optString("saas_product_id")) != null) {
                        str4 = optString;
                    }
                    product.T(str4);
                    eCDetailCustomRepo._product.postValue(eCDetailCustomRepo.product);
                    e.f102467a.h(jSONObject2);
                    eCDetailCustomRepo._sourceData.postValue(eCDetailCustomRepo.u(jSONObject2));
                    return eCDetailCustomRepo.j(jSONObject2, jSONObject);
                }
                cg0.a.a("ECDetailCustomRepo", "requestPtsDataWithModel$\\requestWithCmd$\\onError", "pre pts failure, because req error.");
                return null;
            }
        }
        eCDetailCustomRepo$requestDataWithModel$1 = new ECDetailCustomRepo$requestDataWithModel$1(this, continuation);
        Object obj2 = eCDetailCustomRepo$requestDataWithModel$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDetailCustomRepo$requestDataWithModel$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    public ECDetailCustomRepo(String str, String str2, String str3, String str4, boolean z16) {
        Lazy lazy;
        List emptyList;
        List emptyList2;
        List<List<ECBasePtsViewData>> mutableListOf;
        this.mediaProductId = str;
        this.mediaId = str2;
        this.categoryName = str3;
        this.goodsType = str4;
        this.isNightMode = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECDetailCustomRelatedRepo>() { // from class: com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo$customRelatedRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECDetailCustomRelatedRepo invoke() {
                return new ECDetailCustomRelatedRepo();
            }
        });
        this.customRelatedRepo = lazy;
        MutableLiveData<List<ECBasePtsViewData>> mutableLiveData = new MutableLiveData<>();
        this._baseViewData = mutableLiveData;
        this.adapterLiveDataPts = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._buyItemUrl = mutableLiveData2;
        this.buyItemUrlData = mutableLiveData2;
        MutableLiveData<JSONObject> mutableLiveData3 = new MutableLiveData<>();
        this._sourceData = mutableLiveData3;
        this.sourceLiveData = mutableLiveData3;
        MutableLiveData<Product> mutableLiveData4 = new MutableLiveData<>();
        this._product = mutableLiveData4;
        this.productLiveData = mutableLiveData4;
        this.needDetail = true;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(emptyList, emptyList2);
        this.dataSourcePts = mutableListOf;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.showPageCostTime = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_PRODUCT_DETAIL);
        this.product = new Product(null, null, null, null, 0L, 0L, 0L, 0L, 0.0d, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, false, null, null, null, false, false, null, false, false, false, 0, null, false, false, false, 0, null, false, null, null, 0, false, false, null, null, -1, 2047, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(List<ECBasePtsViewData> requestData, ECNetworkResponse<JSONObject> remoteResponse) {
        long optLong;
        if (remoteResponse == null || remoteResponse.getCode() != 0) {
            return;
        }
        JSONObject b16 = remoteResponse.b();
        this.product.P(b16 != null ? b16.optLong("price") : 0L);
        this._product.postValue(this.product);
        this._buyItemUrl.postValue(b16 != null ? b16.optString("url", "") : null);
        int size = requestData.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(requestData.get(i3).getPageName(), "product_detail_price_sales")) {
                if (b16 != null) {
                    try {
                        optLong = b16.optLong("price");
                    } catch (JSONException e16) {
                        cg0.a.b("ECDetailCustomRepo", "[requestCustomAdapterLiveData] e = " + e16);
                        return;
                    }
                } else {
                    optLong = 0;
                }
                long optLong2 = b16 != null ? b16.optLong("coupon_price") : 0L;
                if (optLong2 != 0) {
                    optLong = optLong2;
                }
                long optLong3 = b16 != null ? b16.optLong("origin_price") : 0L;
                String proteusData = requestData.get(i3).getProteusData();
                if (proteusData == null) {
                    proteusData = "{}";
                }
                JSONObject jSONObject = new JSONObject(proteusData);
                i iVar = i.f104869a;
                jSONObject.put("ec_ProductInfo_BasicInfo_price", iVar.b(optLong));
                if (optLong3 > optLong) {
                    jSONObject.put("ec_ProductInfo_BasicInfo_origin_price", iVar.b(optLong3));
                }
                requestData.get(i3).d(jSONObject.toString());
                PTSComposer ptsComposer = requestData.get(i3).getPtsComposer();
                if (ptsComposer != null) {
                    ptsComposer.setData(jSONObject.toString());
                    return;
                }
                return;
            }
        }
    }
}
