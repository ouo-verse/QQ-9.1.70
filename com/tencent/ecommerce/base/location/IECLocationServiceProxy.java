package com.tencent.ecommerce.base.location;

import ag0.a;
import android.content.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.lbssearch.object.result.DistrictResultObject;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 '2\u00020\u0001:\u0002()JJ\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H&Jo\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00022S\u0010\u000b\u001aO\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H&J_\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H&J\u007f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H&Jg\u0010 \u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00112M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u001f\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H&J\u0085\u0001\u0010&\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010%\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H&\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;", "", "", "requestLevel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errCode", "Lag0/a;", "info", "", "callback", "requestCurrentLocation", "Landroid/content/Context;", "context", "id", "Lkotlin/Function3;", "", "errMsg", "", "Lcom/tencent/lbssearch/object/result/DistrictResultObject$DistrictResult;", "requestDistrictList", "Lcom/tencent/lbssearch/object/result/DistrictResultObject;", "requestFullDistrictList", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "from", "to", "wayPoints", "Lcom/tencent/lbssearch/object/result/DrivingResultObject;", "requestLogisticTraceRoute", "address", "Lag0/c;", "smartParseAddress", "keyword", TtmlNode.TAG_REGION, "pageIndex", "pageSize", "Lcom/tencent/lbssearch/object/result/SuggestionResultObject;", "searchAddressWithKeyword", "Companion", "a", "c", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECLocationServiceProxy {

    @NotNull
    public static final String ALL_REGION = "\u5168\u56fd";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f100802a;
    public static final int PROVINCE_DISTRICT = -1;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy$a;", "", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.location.IECLocationServiceProxy$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f100802a = new Companion();

        Companion() {
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ void a(IECLocationServiceProxy iECLocationServiceProxy, Context context, String str, String str2, int i3, int i16, Function3 function3, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 4) != 0) {
                    str2 = IECLocationServiceProxy.ALL_REGION;
                }
                String str3 = str2;
                if ((i17 & 8) != 0) {
                    i3 = 1;
                }
                int i18 = i3;
                if ((i17 & 16) != 0) {
                    i16 = 10;
                }
                iECLocationServiceProxy.searchAddressWithKeyword(context, str, str3, i18, i16, function3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchAddressWithKeyword");
        }
    }

    void requestCurrentLocation(int requestLevel, @NotNull Function2<? super Integer, ? super a, Unit> callback);

    void requestDistrictList(@NotNull Context context, int id5, @NotNull Function3<? super Integer, ? super String, ? super List<DistrictResultObject.DistrictResult>, Unit> callback);

    void requestFullDistrictList(@NotNull Context context, @NotNull Function3<? super Integer, ? super String, ? super DistrictResultObject, Unit> callback);

    void requestLogisticTraceRoute(@NotNull Context context, @NotNull LatLng from, @NotNull LatLng to5, @NotNull List<? extends LatLng> wayPoints, @NotNull Function3<? super Integer, ? super String, ? super DrivingResultObject, Unit> callback);

    void searchAddressWithKeyword(@NotNull Context context, @NotNull String keyword, @NotNull String region, int pageIndex, int pageSize, @NotNull Function3<? super Integer, ? super String, ? super SuggestionResultObject, Unit> callback);

    void smartParseAddress(@NotNull Context context, @NotNull String address, @NotNull Function3<? super Integer, ? super String, ? super ag0.c, Unit> callback);

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(JJ\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H\u0016Jm\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022S\u0010\u000b\u001aO\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H\u0016J_\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H\u0016J}\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H\u0016Jg\u0010 \u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00112M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u001f\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u007f\u0010&\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022M\u0010\u000b\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010%\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0010H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy$c;", "Lcom/tencent/ecommerce/base/location/IECLocationServiceProxy;", "", "requestLevel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errCode", "Lag0/a;", "info", "", "callback", "requestCurrentLocation", "Landroid/content/Context;", "context", "id", "Lkotlin/Function3;", "", "errMsg", "", "Lcom/tencent/lbssearch/object/result/DistrictResultObject$DistrictResult;", "requestDistrictList", "Lcom/tencent/lbssearch/object/result/DistrictResultObject;", "requestFullDistrictList", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "from", "to", "wayPoints", "Lcom/tencent/lbssearch/object/result/DrivingResultObject;", "requestLogisticTraceRoute", "address", "Lag0/c;", "smartParseAddress", "keyword", TtmlNode.TAG_REGION, "pageIndex", "pageSize", "Lcom/tencent/lbssearch/object/result/SuggestionResultObject;", "searchAddressWithKeyword", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class c implements IECLocationServiceProxy {
        @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
        public void requestCurrentLocation(int requestLevel, @NotNull Function2<? super Integer, ? super a, Unit> callback) {
        }

        @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
        public void requestFullDistrictList(@NotNull Context context, @NotNull Function3<? super Integer, ? super String, ? super DistrictResultObject, Unit> callback) {
        }

        @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
        public void requestDistrictList(@NotNull Context context, int id5, @NotNull Function3<? super Integer, ? super String, ? super List<DistrictResultObject.DistrictResult>, Unit> callback) {
        }

        @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
        public void smartParseAddress(@NotNull Context context, @NotNull String address, @NotNull Function3<? super Integer, ? super String, ? super ag0.c, Unit> callback) {
        }

        @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
        public void requestLogisticTraceRoute(@NotNull Context context, @NotNull LatLng from, @NotNull LatLng to5, @NotNull List<? extends LatLng> wayPoints, @NotNull Function3<? super Integer, ? super String, ? super DrivingResultObject, Unit> callback) {
        }

        @Override // com.tencent.ecommerce.base.location.IECLocationServiceProxy
        public void searchAddressWithKeyword(@NotNull Context context, @NotNull String keyword, @NotNull String region, int pageIndex, int pageSize, @NotNull Function3<? super Integer, ? super String, ? super SuggestionResultObject, Unit> callback) {
        }
    }
}
