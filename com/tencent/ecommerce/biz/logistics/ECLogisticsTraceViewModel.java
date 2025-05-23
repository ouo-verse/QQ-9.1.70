package com.tencent.ecommerce.biz.logistics;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ecommerce.biz.orders.common.Coordinate;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.LogisticsTraceItem;
import com.tencent.ecommerce.biz.orders.common.TrailStatus;
import com.tencent.ecommerce.biz.util.DateFormat;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u000f\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010!R\u001f\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180#8\u0006\u00a2\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "other", "", "S1", "", "latLngList", "", "startIndex", "", "startTime", "estimatedDeliveryTime", "Lcom/tencent/ecommerce/biz/orders/common/TrailStatus;", "currentStatus", "N1", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "logisticsCode", "", "U1", "T1", "Lcom/tencent/ecommerce/biz/orders/common/e;", "info", "Lcom/tencent/lbssearch/object/result/DrivingResultObject;", "drivingResultObject", "O1", "currentLatLng", "nextLatLng", "", "P1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_logisticsInfo", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "logisticsInfo", BdhLogUtil.LogTag.Tag_Conn, "_logisticsDrivingResult", "D", "Q1", "logisticsDrivingResult", "<init>", "()V", "E", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLogisticsTraceViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<DrivingResultObject> _logisticsDrivingResult;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<DrivingResultObject> logisticsDrivingResult;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<LogisticsInfo> _logisticsInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<LogisticsInfo> logisticsInfo;

    public ECLogisticsTraceViewModel() {
        MutableLiveData<LogisticsInfo> mutableLiveData = new MutableLiveData<>();
        this._logisticsInfo = mutableLiveData;
        this.logisticsInfo = mutableLiveData;
        MutableLiveData<DrivingResultObject> mutableLiveData2 = new MutableLiveData<>();
        this._logisticsDrivingResult = mutableLiveData2;
        this.logisticsDrivingResult = mutableLiveData2;
    }

    private final int N1(List<? extends LatLng> latLngList, int startIndex, long startTime, long estimatedDeliveryTime, TrailStatus currentStatus) {
        int lastIndex;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= estimatedDeliveryTime) {
            if (currentStatus != TrailStatus.WRONG) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(latLngList);
                return lastIndex;
            }
            return startIndex + ((int) ((latLngList.size() - startIndex) * 0.9d));
        }
        return startIndex + ((int) ((latLngList.size() - startIndex) * (((float) (currentTimeMillis - startTime)) / ((float) (estimatedDeliveryTime - startTime)))));
    }

    private final boolean S1(LatLng latLng, LatLng latLng2) {
        return Math.abs(latLng.latitude - latLng2.latitude) < 0.001d && Math.abs(latLng.longitude - latLng2.longitude) < 0.001d;
    }

    public final int O1(LogisticsInfo info, DrivingResultObject drivingResultObject) {
        Object last;
        int i3;
        long d16;
        int i16;
        Object last2;
        int lastIndex;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) info.c());
        LatLng b16 = com.tencent.ecommerce.biz.orders.common.f.b((Coordinate) last);
        List<LatLng> list = drivingResultObject.result.routes.get(0).polyline;
        if (info.currentStatus.status == TrailStatus.SIGNED) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            return lastIndex;
        }
        ListIterator<LatLng> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i3 = -1;
                break;
            }
            if (S1(listIterator.previous(), b16)) {
                i3 = listIterator.nextIndex();
                break;
            }
        }
        Iterator<LogisticsTraceItem> it = info.f().iterator();
        int i17 = 0;
        while (true) {
            if (!it.hasNext()) {
                i17 = -1;
                break;
            }
            String str = it.next().location;
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) info.c());
            if (Intrinsics.areEqual(str, ((Coordinate) last2).getCityName())) {
                break;
            }
            i17++;
        }
        com.tencent.ecommerce.biz.util.d dVar = com.tencent.ecommerce.biz.util.d.f104866a;
        String str2 = info.estimatedDeliveryTime;
        DateFormat dateFormat = DateFormat.YMD_HMS;
        long d17 = dVar.d(str2, dateFormat);
        if (d17 == 0) {
            d17 = dVar.d(info.estimatedDeliveryTime, DateFormat.YMD);
            if (d17 == 0) {
                cg0.a.a("ECLogisticsTraceViewModel", "calculateCarLatLngIndex", "parse estimatedDeliveryTime(" + info.estimatedDeliveryTime + ") error");
                return 0;
            }
        }
        if (i3 != -1 && i17 != -1) {
            i16 = i3;
            d16 = dVar.d(info.f().get(i17).acceptTime, dateFormat);
        } else {
            cg0.a.a("ECLogisticsTraceViewModel", "calculateCarLatLng", "not found car last position, latLngIndex:" + i3 + ", traceIndex:" + i17 + ',');
            for (LogisticsTraceItem logisticsTraceItem : info.f()) {
                if (logisticsTraceItem.status == TrailStatus.PICKED_UP) {
                    d16 = dVar.d(logisticsTraceItem.acceptTime, DateFormat.YMD_HMS);
                    i16 = 0;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        return N1(list, i16, d16, d17, info.currentStatus.status);
    }

    public final float P1(LatLng currentLatLng, LatLng nextLatLng) {
        double d16 = nextLatLng.latitude;
        double d17 = currentLatLng.latitude;
        if (d16 == d17) {
            return nextLatLng.longitude > currentLatLng.longitude ? 180.0f : 0.0f;
        }
        double d18 = nextLatLng.longitude;
        double d19 = currentLatLng.longitude;
        if (d18 == d19) {
            return d16 > d17 ? 90.0f : -90.0f;
        }
        double d26 = (d16 - d17) / (d18 - d19);
        double atan = (180 * Math.atan(d26)) / 3.141592653589793d;
        return (float) ((d26 <= ((double) 0) ? nextLatLng.latitude >= currentLatLng.latitude : nextLatLng.longitude < currentLatLng.longitude) ? (-180) - atan : -atan);
    }

    public final LiveData<DrivingResultObject> Q1() {
        return this.logisticsDrivingResult;
    }

    public final LiveData<LogisticsInfo> R1() {
        return this.logisticsInfo;
    }

    public final void T1() {
        Object first;
        Object last;
        LogisticsInfo value = this.logisticsInfo.getValue();
        if (value != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value.e());
            Coordinate coordinate = (Coordinate) first;
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) value.e());
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ECLogisticsTraceViewModel$requestLogisticTraceRoute$1(this, coordinate, (Coordinate) last, value, null), 2, null);
        }
    }

    public final void U1(String orderId, String logisticsCode) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECLogisticsTraceViewModel$requestTraceDetail$1(this, orderId, logisticsCode, null), 3, null);
    }
}
