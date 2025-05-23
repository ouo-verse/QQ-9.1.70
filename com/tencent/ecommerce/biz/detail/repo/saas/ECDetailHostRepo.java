package com.tencent.ecommerce.biz.detail.repo.saas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bh0.ECPageParserParams;
import ck0.Product;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.ecommerce.biz.detail.utils.e;
import com.tencent.ecommerce.biz.util.ECDebugUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 S2\u00020\u0001:\u0001\u0014Bi\u0012\b\b\u0002\u0010?\u001a\u00020\r\u0012\b\b\u0002\u0010@\u001a\u00020\r\u0012\b\b\u0002\u0010A\u001a\u00020\r\u0012\b\b\u0002\u0010C\u001a\u00020\r\u0012\b\b\u0002\u0010E\u001a\u00020\r\u0012\b\b\u0002\u0010G\u001a\u00020\r\u0012\u0006\u0010J\u001a\u00020\u001d\u0012\b\b\u0002\u0010L\u001a\u00020\r\u0012\b\b\u0002\u0010N\u001a\u00020\r\u0012\b\b\u0002\u0010P\u001a\u00020\r\u00a2\u0006\u0004\bQ\u0010RJ\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0011R\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00178\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0015R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\u00178\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001bR\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u0015R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020)0\u00178\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b,\u0010\u001bR\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020)0\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020)0\u00178\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u0019\u001a\u0004\b*\u0010\u001bR\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00104R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00106R\u001b\u0010;\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u00109\u001a\u0004\b/\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010=R\u0014\u0010?\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00106R\u0014\u0010@\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00106R\u0014\u0010A\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00106R\u0014\u0010C\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bB\u00106R\u0014\u0010E\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bD\u00106R\u0014\u0010G\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bF\u00106R\u0014\u0010J\u001a\u00020\u001d8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bK\u00106R\u0014\u0010N\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bM\u00106R\u0014\u0010P\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bO\u00106\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006T"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailHostRepo;", "", "Lorg/json/JSONObject;", "requestParams", "", "Lcom/tencent/ecommerce/base/ui/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "p", "data", "", "k", "o", "", "service", "method", "r", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "_baseViewData", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/LiveData;", "i", "()Landroidx/lifecycle/LiveData;", "adapterLiveDataPts", "", "c", "_isAdded", "d", DomainData.DOMAIN_NAME, "isAddedLiveData", "Lck0/c;", "e", "_product", "f", "l", "productLiveData", "", "g", "_activityStartTime", h.F, "activityStartTimeLiveData", "_activityEndTime", "j", "activityEndTimeLiveData", "Ljava/util/List;", "detailDataList", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Ljava/lang/String;", "mediaProductId", "Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailHostRelatedRepo;", "Lkotlin/Lazy;", "()Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailHostRelatedRepo;", "detailRelatedRepo", "Lcom/tencent/ecommerce/base/report/service/k;", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "saasProductId", "saasType", "mediaId", ReportConstant.COSTREPORT_PREFIX, "categoryId", "t", "categoryName", "u", "goodsType", "v", "Z", MiniGamePAHippyBaseFragment.KEY_THEME, "w", GetAdInfoRequest.SOURCE_FROM, HippyTKDListViewAdapter.X, "bannerId", "y", "bannerName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailHostRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<List<ECBasePtsViewData>> _baseViewData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<ECBasePtsViewData>> adapterLiveDataPts;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Boolean> _isAdded;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Boolean> isAddedLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Product> _product;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Product> productLiveData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Long> _activityStartTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Long> activityStartTimeLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Long> _activityEndTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Long> activityEndTimeLiveData;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final List<ECBasePtsViewData> detailDataList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Mutex mutex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String mediaProductId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Lazy detailRelatedRepo;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final k showPageCostTime;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final String saasProductId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final String saasType;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final String mediaId;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final String categoryId;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final String categoryName;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public final String goodsType;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final boolean isNightMode;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public final String sourceFrom;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final String bannerId;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final String bannerName;

    public ECDetailHostRepo(String str, String str2, String str3, String str4, String str5, String str6, boolean z16, String str7, String str8, String str9) {
        Lazy lazy;
        this.saasProductId = str;
        this.saasType = str2;
        this.mediaId = str3;
        this.categoryId = str4;
        this.categoryName = str5;
        this.goodsType = str6;
        this.isNightMode = z16;
        this.sourceFrom = str7;
        this.bannerId = str8;
        this.bannerName = str9;
        MutableLiveData<List<ECBasePtsViewData>> mutableLiveData = new MutableLiveData<>();
        this._baseViewData = mutableLiveData;
        this.adapterLiveDataPts = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._isAdded = mutableLiveData2;
        this.isAddedLiveData = mutableLiveData2;
        MutableLiveData<Product> mutableLiveData3 = new MutableLiveData<>();
        this._product = mutableLiveData3;
        this.productLiveData = mutableLiveData3;
        MutableLiveData<Long> mutableLiveData4 = new MutableLiveData<>();
        this._activityStartTime = mutableLiveData4;
        this.activityStartTimeLiveData = mutableLiveData4;
        MutableLiveData<Long> mutableLiveData5 = new MutableLiveData<>();
        this._activityEndTime = mutableLiveData5;
        this.activityEndTimeLiveData = mutableLiveData5;
        this.detailDataList = new ArrayList();
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.mediaProductId = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECDetailHostRelatedRepo>() { // from class: com.tencent.ecommerce.biz.detail.repo.saas.ECDetailHostRepo$detailRelatedRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECDetailHostRelatedRepo invoke() {
                return new ECDetailHostRelatedRepo();
            }
        });
        this.detailRelatedRepo = lazy;
        this.showPageCostTime = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_PRODUCT_DETAIL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECDetailHostRelatedRepo j() {
        return (ECDetailHostRelatedRepo) this.detailRelatedRepo.getValue();
    }

    private final List<ECBasePtsViewData> k(JSONObject data, JSONObject requestParams) {
        this._isAdded.postValue(Boolean.valueOf(data.optBoolean("is_add", false)));
        e eVar = e.f102467a;
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(eVar.c(data, true));
        int optInt = data.optInt("goods_type", 0);
        JSONObject a17 = eVar.a(String.valueOf(optInt), this.categoryName, this.isNightMode, false);
        if (eVar.g(String.valueOf(optInt))) {
            JSONObject optJSONObject = data.optJSONObject("tx_video_product");
            a17.put("EC_GOODS_DETAIL_TYPE", optJSONObject != null ? optJSONObject.optInt("detail_type") : 0);
        }
        JSONObject optJSONObject2 = data.optJSONObject(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (optJSONObject2 != null) {
            long j3 = 1000;
            long optLong = optJSONObject2.optLong("activity_start_time", 0L) * j3;
            long optLong2 = optJSONObject2.optLong("activity_end_time", 0L) * j3;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < optLong) {
                this._activityStartTime.postValue(Long.valueOf(optLong));
                this._activityEndTime.postValue(Long.valueOf(optLong2));
            } else if (optLong <= currentTimeMillis && currentTimeMillis <= optLong2) {
                this._activityEndTime.postValue(Long.valueOf(optLong2));
            }
            if (eVar.d(String.valueOf(optInt)) && currentTimeMillis < optLong2) {
                a17.put("activityInProgress", true);
            }
        }
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, a17);
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(a17);
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, requestParams);
        List<ECBasePtsViewData> mutableList = process != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) process) : null;
        ECDebugUtils.f104852b.c(wg0.a.a().getApplicationContext(), data.toString());
        return mutableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECBasePtsViewData> m(JSONObject requestParams) {
        JSONObject d16 = wh0.a.f445642d.d(true, this.saasProductId);
        if (d16 != null) {
            return k(d16, requestParams);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.detailDataList);
        this._baseViewData.postValue(arrayList);
    }

    public final LiveData<Long> g() {
        return this.activityEndTimeLiveData;
    }

    public final LiveData<Long> h() {
        return this.activityStartTimeLiveData;
    }

    public final LiveData<List<ECBasePtsViewData>> i() {
        return this.adapterLiveDataPts;
    }

    public final LiveData<Product> l() {
        return this.productLiveData;
    }

    public final LiveData<Boolean> n() {
        return this.isAddedLiveData;
    }

    public final void o(JSONObject requestParams) {
        List<ECBasePtsViewData> m3 = m(requestParams);
        if (m3 == null) {
            cg0.a.b("ECDetailHostRepo", "[requestAdapterLiveData] cache missed");
            return;
        }
        this._baseViewData.postValue(m3);
        cg0.a.b("ECDetailHostRepo", "[requestAdapterLiveData] cache = " + m3);
        d.f102466a.r(this.showPageCostTime, true, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object q(String str, String str2, JSONObject jSONObject, Continuation<? super List<ECBasePtsViewData>> continuation) {
        ECDetailHostRepo$requestDataWithModel$1 eCDetailHostRepo$requestDataWithModel$1;
        Object coroutine_suspended;
        int i3;
        ECDetailHostRepo eCDetailHostRepo;
        ECNetworkResponse eCNetworkResponse;
        String str3;
        String optString;
        Long boxLong;
        Long boxLong2;
        Long boxLong3;
        Long boxLong4;
        Long boxLong5;
        String str4 = str;
        String str5 = str2;
        JSONObject jSONObject2 = jSONObject;
        if (continuation instanceof ECDetailHostRepo$requestDataWithModel$1) {
            eCDetailHostRepo$requestDataWithModel$1 = (ECDetailHostRepo$requestDataWithModel$1) continuation;
            int i16 = eCDetailHostRepo$requestDataWithModel$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDetailHostRepo$requestDataWithModel$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDetailHostRepo$requestDataWithModel$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDetailHostRepo$requestDataWithModel$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCDetailHostRepo$requestDataWithModel$1.L$0 = this;
                    eCDetailHostRepo$requestDataWithModel$1.L$1 = str4;
                    eCDetailHostRepo$requestDataWithModel$1.L$2 = str5;
                    eCDetailHostRepo$requestDataWithModel$1.L$3 = jSONObject2;
                    eCDetailHostRepo$requestDataWithModel$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e(str4, str5, bVar, jSONObject2, eCDetailHostRepo$requestDataWithModel$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCDetailHostRepo = this;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    JSONObject jSONObject3 = (JSONObject) eCDetailHostRepo$requestDataWithModel$1.L$3;
                    str5 = (String) eCDetailHostRepo$requestDataWithModel$1.L$2;
                    String str6 = (String) eCDetailHostRepo$requestDataWithModel$1.L$1;
                    eCDetailHostRepo = (ECDetailHostRepo) eCDetailHostRepo$requestDataWithModel$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    jSONObject2 = jSONObject3;
                    str4 = str6;
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    JSONObject jSONObject4 = (JSONObject) eCNetworkResponse.b();
                    if (jSONObject4 == null) {
                        return null;
                    }
                    cg0.a.b("ECDetailHostRepo", "[requestDataWithModel] data = " + jSONObject4);
                    Product product = new Product(null, null, null, null, 0L, 0L, 0L, 0L, 0.0d, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, false, null, null, null, false, false, null, false, false, false, 0, null, false, false, false, 0, null, false, null, null, 0, false, false, null, null, -1, 2047, null);
                    if (jSONObject4.optInt("goods_type") == 3) {
                        JSONObject optJSONObject = jSONObject4.optJSONObject("commission_detail");
                        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("commission_range") : null;
                        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("commission_details") : null;
                        Integer boxInt = optJSONArray != null ? Boxing.boxInt(optJSONArray.length()) : null;
                        if (boxInt != null && boxInt.intValue() > 0) {
                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(0);
                            JSONObject optJSONObject4 = optJSONArray.optJSONObject(boxInt.intValue() - 1);
                            product.I((optJSONObject2 == null || (boxLong5 = Boxing.boxLong(optJSONObject2.optLong("min_commission"))) == null) ? 0L : boxLong5.longValue());
                            product.J((optJSONObject2 == null || (boxLong4 = Boxing.boxLong(optJSONObject2.optLong("max_commission"))) == null) ? 0L : boxLong4.longValue());
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("price");
                            product.R((optJSONObject5 == null || (boxLong3 = Boxing.boxLong(optJSONObject5.optLong("price"))) == null) ? 0L : boxLong3.longValue());
                            JSONObject optJSONObject6 = optJSONObject3.optJSONObject("price");
                            product.Q((optJSONObject6 == null || (boxLong2 = Boxing.boxLong(optJSONObject6.optLong("price"))) == null) ? 0L : boxLong2.longValue());
                        }
                    }
                    JSONObject optJSONObject7 = jSONObject4.optJSONObject("product");
                    String str7 = "";
                    if (optJSONObject7 == null || (str3 = optJSONObject7.optString("title")) == null) {
                        str3 = "";
                    }
                    product.Y(str3);
                    JSONObject optJSONObject8 = jSONObject4.optJSONObject("product");
                    product.U((optJSONObject8 == null || (boxLong = Boxing.boxLong(optJSONObject8.optLong("sales"))) == null) ? 0L : boxLong.longValue());
                    JSONObject optJSONObject9 = jSONObject4.optJSONObject("product");
                    if (optJSONObject9 != null && (optString = optJSONObject9.optString("saas_product_id")) != null) {
                        str7 = optString;
                    }
                    product.T(str7);
                    product.P(jSONObject4.optLong("price", 0L));
                    product.H(jSONObject4.optLong("commission", 0L));
                    product.M(jSONObject4.optInt("goods_type"));
                    eCDetailHostRepo._product.postValue(product);
                    e.f102467a.h(jSONObject4);
                    List<ECBasePtsViewData> k3 = eCDetailHostRepo.k(jSONObject4, jSONObject2);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("pre pts success, service: ");
                    sb5.append(str4);
                    sb5.append(TokenParser.SP);
                    sb5.append("method: ");
                    sb5.append(str5);
                    sb5.append(", count: ");
                    sb5.append(k3 != null ? Boxing.boxInt(k3.size()) : null);
                    cg0.a.b("ECDetailHostRepo", sb5.toString());
                    return k3;
                }
                cg0.a.a("ECDetailHostRepo", "requestPtsDataWithModel$\\requestWithCmd$\\onError", "pre pts failure, because req error. service: " + str4 + TokenParser.SP + "method: " + str5);
                return null;
            }
        }
        eCDetailHostRepo$requestDataWithModel$1 = new ECDetailHostRepo$requestDataWithModel$1(this, continuation);
        Object obj2 = eCDetailHostRepo$requestDataWithModel$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDetailHostRepo$requestDataWithModel$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    public final Object r(String str, String str2, JSONObject jSONObject, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ECDetailHostRepo$requestHostLiveData$2(this, str, str2, jSONObject, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }
}
