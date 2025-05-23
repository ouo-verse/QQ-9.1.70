package com.tencent.mobileqq.qqecommerce.base.location;

import ag0.ECLocationInfo;
import ag0.ECPoi;
import android.content.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ark.ark;
import com.tencent.ecommerce.base.location.IECLocationServiceProxy;
import com.tencent.lbssearch.HttpProvider;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.DistrictChildrenParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.result.DistrictResultObject;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b)\u0010*J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002JJ\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u000528\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007H\u0016Jm\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052S\u0010\r\u001aO\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0014\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0012H\u0016J_\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2M\u0010\r\u001aI\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0012H\u0016J}\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00152M\u0010\r\u001aI\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u001e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0012H\u0016J\u007f\u0010%\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052M\u0010\r\u001aI\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0012H\u0016Jg\u0010(\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00132M\u0010\r\u001aI\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010'\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0012H\u0016\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/location/ECLocationService;", "Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "Lag0/a;", "b", "", "requestLevel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errCode", "info", "", "callback", "requestCurrentLocation", "Landroid/content/Context;", "context", "id", "Lkotlin/Function3;", "", "errMsg", "", "Lcom/tencent/lbssearch/object/result/DistrictResultObject$DistrictResult;", "requestDistrictList", "Lcom/tencent/lbssearch/object/result/DistrictResultObject;", "requestFullDistrictList", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "from", "to", "wayPoints", "Lcom/tencent/lbssearch/object/result/DrivingResultObject;", "requestLogisticTraceRoute", "keyword", TtmlNode.TAG_REGION, "pageIndex", "pageSize", "Lcom/tencent/lbssearch/object/result/SuggestionResultObject;", "searchAddressWithKeyword", "address", "Lag0/c;", "smartParseAddress", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECLocationService implements IECLocationServiceProxy {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/location/ECLocationService$b", "Lcom/tencent/mobileqq/soso/location/SosoInterfaceOnLocationListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends SosoInterfaceOnLocationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, ECLocationInfo, Unit> f262425a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECLocationService f262426b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(int i3, Function2<? super Integer, ? super ECLocationInfo, Unit> function2, ECLocationService eCLocationService) {
            super(i3, true, true, 30000L, true, false, "ECommerce");
            this.f262425a = function2;
            this.f262426b = eCLocationService;
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int errCode, SosoLbsInfo info) {
            if (QLog.isColorLevel()) {
                QLog.d("ECLocationService", 2, "onLocationFinish() errCode = " + errCode);
            }
            this.f262425a.invoke(Integer.valueOf(errCode), info != null ? this.f262426b.b(info) : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/location/ECLocationService$c", "Lcom/tencent/lbssearch/httpresponse/HttpResponseListener;", "Lcom/tencent/lbssearch/httpresponse/BaseObject;", "", "errCode", "data", "", "a", "", "errMsg", "", "e", "onFailure", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements HttpResponseListener<BaseObject> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, List<DistrictResultObject.DistrictResult>, Unit> f262427a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function3<? super Integer, ? super String, ? super List<DistrictResultObject.DistrictResult>, Unit> function3) {
            this.f262427a = function3;
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(int errCode, BaseObject data) {
            if (data == null) {
                QLog.e("ECLocationService", 2, "no data return, errCode:" + errCode);
                this.f262427a.invoke(Integer.valueOf(errCode), "", null);
                return;
            }
            List<DistrictResultObject.DistrictResult> list = ((DistrictResultObject) data).result.get(0);
            Intrinsics.checkNotNullExpressionValue(list, "obj.result[0]");
            this.f262427a.invoke(Integer.valueOf(errCode), "", list);
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onFailure(int errCode, String errMsg, Throwable e16) {
            QLog.e("ECLocationService", 2, e16, "getDistrictList error, errCode:" + errCode + ", errMsg:" + errMsg);
            Function3<Integer, String, List<DistrictResultObject.DistrictResult>, Unit> function3 = this.f262427a;
            Integer valueOf = Integer.valueOf(errCode);
            if (errMsg == null) {
                errMsg = "";
            }
            function3.invoke(valueOf, errMsg, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/location/ECLocationService$d", "Lcom/tencent/lbssearch/httpresponse/HttpResponseListener;", "Lcom/tencent/lbssearch/httpresponse/BaseObject;", "", "errCode", "data", "", "a", "", "errMsg", "", "e", "onFailure", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements HttpResponseListener<BaseObject> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, DistrictResultObject, Unit> f262428a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function3<? super Integer, ? super String, ? super DistrictResultObject, Unit> function3) {
            this.f262428a = function3;
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(int errCode, BaseObject data) {
            if (data == null) {
                QLog.e("ECLocationService", 2, "no data return, errCode:" + errCode);
                this.f262428a.invoke(Integer.valueOf(errCode), "", null);
                return;
            }
            this.f262428a.invoke(Integer.valueOf(errCode), "", (DistrictResultObject) data);
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onFailure(int errCode, String errMsg, Throwable e16) {
            QLog.e("ECLocationService", 2, e16, "getDistrictList error, errCode:" + errCode + ", errMsg:" + errMsg);
            Function3<Integer, String, DistrictResultObject, Unit> function3 = this.f262428a;
            Integer valueOf = Integer.valueOf(errCode);
            if (errMsg == null) {
                errMsg = "";
            }
            function3.invoke(valueOf, errMsg, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/location/ECLocationService$e", "Lcom/tencent/map/tools/net/http/HttpResponseListener;", "Lcom/tencent/lbssearch/object/result/DrivingResultObject;", "", "errCode", "result", "", "a", "", "errMsg", "", "p2", "onFailure", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.map.tools.net.http.HttpResponseListener<DrivingResultObject> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, DrivingResultObject, Unit> f262429a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function3<? super Integer, ? super String, ? super DrivingResultObject, Unit> function3) {
            this.f262429a = function3;
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(int errCode, DrivingResultObject result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f262429a.invoke(Integer.valueOf(errCode), "", result);
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onFailure(int errCode, String errMsg, Throwable p26) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f262429a.invoke(Integer.valueOf(errCode), errMsg, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/location/ECLocationService$f", "Lcom/tencent/lbssearch/httpresponse/HttpResponseListener;", "Lcom/tencent/lbssearch/object/result/SuggestionResultObject;", "", "errCode", "result", "", "a", "", "errMsg", "", "e", "onFailure", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements HttpResponseListener<SuggestionResultObject> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, SuggestionResultObject, Unit> f262430a;

        /* JADX WARN: Multi-variable type inference failed */
        f(Function3<? super Integer, ? super String, ? super SuggestionResultObject, Unit> function3) {
            this.f262430a = function3;
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(int errCode, SuggestionResultObject result) {
            this.f262430a.invoke(Integer.valueOf(errCode), "", result);
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onFailure(int errCode, String errMsg, Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f262430a.invoke(Integer.valueOf(errCode), errMsg, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/location/ECLocationService$g", "Lcom/tencent/lbssearch/httpresponse/HttpResponseListener;", "Lag0/c;", "", "errCode", "result", "", "a", "", "errMsg", "", "p2", "onFailure", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements HttpResponseListener<ag0.c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, String, ag0.c, Unit> f262431a;

        /* JADX WARN: Multi-variable type inference failed */
        g(Function3<? super Integer, ? super String, ? super ag0.c, Unit> function3) {
            this.f262431a = function3;
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(int errCode, ag0.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f262431a.invoke(Integer.valueOf(errCode), "", result);
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onFailure(int errCode, String errMsg, Throwable p26) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f262431a.invoke(Integer.valueOf(errCode), errMsg, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECLocationInfo b(SosoLbsInfo sosoLbsInfo) {
        List<ECPoi> emptyList;
        int collectionSizeOrDefault;
        SosoLocation sosoLocation = sosoLbsInfo.mLocation;
        ECLocationInfo eCLocationInfo = new ECLocationInfo(sosoLocation.mLat02 * 1000000.0d, 1000000.0d * sosoLocation.mLon02, sosoLocation.accuracy);
        String str = sosoLbsInfo.mLocation.name;
        String str2 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "mLocation.name ?: \"\"");
        }
        eCLocationInfo.l(str);
        String str3 = sosoLbsInfo.mLocation.address;
        if (str3 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str3, "mLocation.address ?: \"\"");
        }
        eCLocationInfo.h(str3);
        String str4 = sosoLbsInfo.mLocation.nation;
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "mLocation.nation ?: \"\"");
        }
        eCLocationInfo.m(str4);
        String str5 = sosoLbsInfo.mLocation.province;
        if (str5 == null) {
            str5 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str5, "mLocation.province ?: \"\"");
        }
        eCLocationInfo.o(str5);
        String str6 = sosoLbsInfo.mLocation.city;
        if (str6 == null) {
            str6 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str6, "mLocation.city ?: \"\"");
        }
        eCLocationInfo.i(str6);
        String str7 = sosoLbsInfo.mLocation.district;
        if (str7 == null) {
            str7 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str7, "mLocation.district ?: \"\"");
        }
        eCLocationInfo.k(str7);
        String str8 = sosoLbsInfo.mLocation.cityCode;
        if (str8 == null) {
            str8 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str8, "mLocation.cityCode ?: \"\"");
        }
        eCLocationInfo.j(str8);
        String str9 = sosoLbsInfo.mLocation.town;
        if (str9 != null) {
            Intrinsics.checkNotNullExpressionValue(str9, "mLocation.town ?: \"\"");
            str2 = str9;
        }
        eCLocationInfo.p(str2);
        List<TencentPoi> poi = sosoLbsInfo.mLocation.poi;
        if (poi == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Intrinsics.checkNotNullExpressionValue(poi, "poi");
            List<TencentPoi> list = poi;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList<>(collectionSizeOrDefault);
            for (TencentPoi tencentPoi : list) {
                String name = tencentPoi.getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                String address = tencentPoi.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "it.address");
                emptyList.add(new ECPoi(name, address));
            }
        }
        eCLocationInfo.n(emptyList);
        return eCLocationInfo;
    }

    @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
    public void requestCurrentLocation(int requestLevel, Function2<? super Integer, ? super ECLocationInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new b(requestLevel, callback, this));
    }

    @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
    public void requestDistrictList(Context context, int id5, Function3<? super Integer, ? super String, ? super List<DistrictResultObject.DistrictResult>, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TencentMapInitializer.setAgreePrivacy(true);
        TencentSearch tencentSearch = new TencentSearch(context);
        DistrictChildrenParam districtChildrenParam = new DistrictChildrenParam();
        if (id5 != -1) {
            districtChildrenParam.id(id5);
        }
        tencentSearch.getDistrictChildren(districtChildrenParam, new c(callback));
    }

    @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
    public void requestFullDistrictList(Context context, Function3<? super Integer, ? super String, ? super DistrictResultObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TencentMapInitializer.setAgreePrivacy(true);
        new TencentSearch(context).getDistrictList(new d(callback));
    }

    @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
    public void searchAddressWithKeyword(Context context, String keyword, String region, int pageIndex, int pageSize, Function3<? super Integer, ? super String, ? super SuggestionResultObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (keyword.length() == 0) {
            callback.invoke(-1, "keyword must not be empty", null);
            return;
        }
        TencentMapInitializer.setAgreePrivacy(true);
        TencentSearch tencentSearch = new TencentSearch(context);
        SuggestionParam suggestionParam = new SuggestionParam();
        suggestionParam.keyword(keyword);
        suggestionParam.region(region);
        suggestionParam.pageIndex(pageIndex);
        suggestionParam.pageSize(pageSize);
        suggestionParam.policy(SuggestionParam.Policy.O2O);
        tencentSearch.suggestion(suggestionParam, new f(callback));
    }

    @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
    public void smartParseAddress(Context context, String address, Function3<? super Integer, ? super String, ? super ag0.c, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String metaKey = Util.getMetaKey(context, "TencentMapSDK");
        RequestParams requestParams = new RequestParams();
        requestParams.add("key", metaKey);
        requestParams.add("smart_address", address);
        HttpProvider.get(context, "https://apis.map.qq.com/ws/geocoder/v1/", requestParams, ag0.c.class, metaKey, new g(callback));
    }

    @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
    public void requestLogisticTraceRoute(Context context, LatLng from, LatLng to5, List<? extends LatLng> wayPoints, Function3<? super Integer, ? super String, ? super DrivingResultObject, Unit> callback) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to5, "to");
        Intrinsics.checkNotNullParameter(wayPoints, "wayPoints");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String metaKey = Util.getMetaKey(context, "TencentMapSDK");
        RequestParams requestParams = new RequestParams();
        requestParams.add("key", metaKey);
        requestParams.add("from", from.latitude + "," + from.longitude);
        requestParams.add("to", to5.latitude + "," + to5.longitude);
        if (!wayPoints.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(wayPoints, ";", null, null, 0, null, new Function1<LatLng, CharSequence>() { // from class: com.tencent.mobileqq.qqecommerce.base.location.ECLocationService$requestLogisticTraceRoute$requestParams$1$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(LatLng it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.latitude + "," + it.longitude;
                }
            }, 30, null);
            requestParams.add("waypoints", joinToString$default);
        }
        requestParams.add("output", ark.ARKMETADATA_JSON);
        requestParams.put("no_step", 1);
        HttpProvider.get(context, UrlConstant.ROUTE_PLANNING_DRIVING, requestParams, DrivingResultObject.class, null, new e(callback));
    }
}
