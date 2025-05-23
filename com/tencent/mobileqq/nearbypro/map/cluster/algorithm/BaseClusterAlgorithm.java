package com.tencent.mobileqq.nearbypro.map.cluster.algorithm;

import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import bb2.SortCluster;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.base.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \\2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010Y\u001a\u00020X\u00a2\u0006\u0004\bZ\u0010[J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J4\u0010\u0017\u001a\u00020\b2\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J<\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002JH\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00132\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013H\u0002Jp\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00132\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00132&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0002J`\u0010#\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010!\u001a\u00020\u00062\"\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013H\u0002JB\u0010%\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062&\u0010$\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0002J\u0018\u0010(\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rH\u0002J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010.\u001a\u00020\u00042\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150,H&J\b\u0010/\u001a\u00020\u0011H&J\u0014\u00102\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001500J\u0014\u00103\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001500J\u0006\u00104\u001a\u00020\bJ\u000e\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0004J\u0006\u00107\u001a\u00020\bJ\u001e\u0010:\u001a\u00020\b2\u0006\u0010\u0003\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0006R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R0\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150?j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015`@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR0\u0010E\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150?j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015`@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010BR6\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010\u001bR\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010+R\u0018\u0010R\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010V\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/cluster/algorithm/BaseClusterAlgorithm;", "", "", "zoomLevel", "", "forceCluster", "Lbb2/c;", "callback", "", "y", "zoomLive", "", "dataSize", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "currentLatLng", "J", "Ljava/util/LinkedHashMap;", "", "Lbb2/f;", "Lkotlin/collections/LinkedHashMap;", "clusterHashMap", "Lda2/b;", "infoData", "o", "p", "Landroid/graphics/Point;", "point", "D", "resultCenterMap", "E", "lastClusterMap", UserInfo.SEX_FEMALE, "lastResultMap", "callbackListener", "currentResultMap", DomainData.DOMAIN_NAME, "resultMapCluster", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "latLng1", "latLng2", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "I", "Ljava/lang/Class;", "clazz", BdhLogUtil.LogTag.Tag_Conn, "B", "", "collection", "l", "j", "r", "showMarker", "G", "t", "", "iClusterResult", "v", "Lab2/d;", "a", "Lab2/d;", "mapProxy", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "dataList", "c", "debugList", "d", "Ljava/util/LinkedHashMap;", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "clusterRunnable", "f", "lastZoom", "g", "lastDataSize", tl.h.F, "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "lastLatLng", "i", "Z", "isShowMarker", "Ljava/lang/String;", "logTag", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "k", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class BaseClusterAlgorithm {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    private static final int f253405l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f253406m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final Comparator<da2.b> f253407n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ab2.d mapProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, da2.b> dataList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, da2.b> debugList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinkedHashMap<String, SortCluster> lastResultMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable clusterRunnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private double lastZoom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int lastDataSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LatLng lastLatLng;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isShowMarker;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/cluster/algorithm/BaseClusterAlgorithm$a;", "", "Ljava/util/Comparator;", "Lda2/b;", "comparator", "Ljava/util/Comparator;", "a", "()Ljava/util/Comparator;", "", "SCREEN_MIN_X", "I", "SCREEN_MIN_Y", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.map.cluster.algorithm.BaseClusterAlgorithm$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Comparator<da2.b> a() {
            return BaseClusterAlgorithm.f253407n;
        }

        Companion() {
        }
    }

    static {
        ab2.a aVar = ab2.a.f25767a;
        f253405l = aVar.k().getWidth();
        f253406m = aVar.k().getHeight();
        f253407n = new Comparator() { // from class: com.tencent.mobileqq.nearbypro.map.cluster.algorithm.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int x16;
                x16 = BaseClusterAlgorithm.x((da2.b) obj, (da2.b) obj2);
                return x16;
            }
        };
    }

    public BaseClusterAlgorithm(@NotNull TencentMap tencentMap) {
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
        this.mapProxy = new ab2.d(tencentMap);
        this.dataList = new HashMap<>();
        this.debugList = new HashMap<>();
        this.isShowMarker = true;
        this.logTag = B();
    }

    private final int A(LatLng latLng1, LatLng latLng2) {
        Projection c16 = this.mapProxy.c();
        if (c16 == null) {
            return 0;
        }
        Point screenLocation = c16.toScreenLocation(latLng1);
        Point screenLocation2 = c16.toScreenLocation(latLng2);
        return (int) Math.sqrt(Math.pow(screenLocation.x - screenLocation2.x, 2.0d) + Math.pow(screenLocation.y - screenLocation2.y, 2.0d));
    }

    private final boolean D(Point point) {
        int i3 = point.x;
        int i16 = f253405l;
        if (i3 >= (-i16) && i3 <= i16 * 2) {
            int i17 = point.y;
            int i18 = f253406m;
            if (i17 >= (-i18) && i17 <= i18 * 2) {
                return true;
            }
        }
        return false;
    }

    private final LinkedHashMap<String, SortCluster> E(LinkedHashMap<String, SortCluster> resultCenterMap) {
        for (SortCluster sortCluster : resultCenterMap.values()) {
            if (!sortCluster.getForceNoCluster()) {
                for (da2.b bVar : new ArrayList(sortCluster.f())) {
                    if (!Intrinsics.areEqual(bVar.b(), sortCluster.getClusterKey())) {
                        for (SortCluster sortCluster2 : resultCenterMap.values()) {
                            if (!Intrinsics.areEqual(sortCluster.getClusterKey(), sortCluster2.getClusterKey()) && !sortCluster2.getForceNoCluster()) {
                                ab2.a aVar = ab2.a.f25767a;
                                if (aVar.b(bVar.getCom.tencent.luggage.wxa.c8.c.G java.lang.String(), sortCluster.h()) > aVar.b(bVar.getCom.tencent.luggage.wxa.c8.c.G java.lang.String(), sortCluster2.h())) {
                                    sortCluster.f().remove(bVar);
                                    sortCluster2.a(bVar);
                                }
                            }
                        }
                    }
                }
            }
        }
        return resultCenterMap;
    }

    private final LinkedHashMap<String, SortCluster> F(LinkedHashMap<String, SortCluster> clusterHashMap, LinkedHashMap<String, SortCluster> lastClusterMap) {
        LinkedHashMap<String, SortCluster> linkedHashMap = new LinkedHashMap<>();
        for (SortCluster entry : clusterHashMap.values()) {
            if (entry.j()) {
                String clusterKey = entry.getClusterKey();
                Intrinsics.checkNotNullExpressionValue(entry, "entry");
                linkedHashMap.put(clusterKey, entry);
            } else {
                entry.k(lastClusterMap);
                String clusterKey2 = entry.getClusterKey();
                Intrinsics.checkNotNullExpressionValue(entry, "entry");
                linkedHashMap.put(clusterKey2, entry);
            }
        }
        return linkedHashMap;
    }

    private final boolean H(LatLng latLng1, LatLng latLng2) {
        if (A(latLng1, latLng2) < z()) {
            return true;
        }
        return false;
    }

    private final boolean I(da2.b infoData, double zoomLevel) {
        if (zoomLevel < ab2.a.f25767a.n() && infoData.a()) {
            return false;
        }
        return true;
    }

    private final boolean J(double zoomLive, int dataSize, LatLng currentLatLng) {
        Projection c16;
        boolean z16;
        if (this.lastLatLng == null || currentLatLng == null || (c16 = this.mapProxy.c()) == null) {
            return false;
        }
        Point screenLocation = c16.toScreenLocation(this.lastLatLng);
        Point screenLocation2 = c16.toScreenLocation(currentLatLng);
        if (Math.abs(screenLocation2.x - screenLocation.x) < f253405l * 0.5f && Math.abs(screenLocation2.y - screenLocation.y) < f253406m * 0.5f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Math.abs(zoomLive - this.lastZoom) >= 0.1d || dataSize != this.lastDataSize || !z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Collection collection, BaseClusterAlgorithm this$0) {
        Intrinsics.checkNotNullParameter(collection, "$collection");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            da2.b bVar = (da2.b) it.next();
            this$0.debugList.put(bVar.b(), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Collection collection, BaseClusterAlgorithm this$0) {
        Intrinsics.checkNotNullParameter(collection, "$collection");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            da2.b bVar = (da2.b) it.next();
            this$0.dataList.put(bVar.b(), bVar);
        }
    }

    private final void n(double zoomLive, LinkedHashMap<String, SortCluster> lastResultMap, bb2.c callbackListener, LinkedHashMap<String, SortCluster> currentResultMap) {
        this.lastResultMap = currentResultMap;
        q(zoomLive, callbackListener, currentResultMap);
    }

    private final void o(LinkedHashMap<String, SortCluster> clusterHashMap, da2.b infoData) {
        boolean z16;
        Iterator<Map.Entry<String, SortCluster>> it = clusterHashMap.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                SortCluster value = it.next().getValue();
                Intrinsics.checkNotNullExpressionValue(value, "entry.value");
                SortCluster sortCluster = value;
                if (!sortCluster.getForceNoCluster() && H(infoData.getCom.tencent.luggage.wxa.c8.c.G java.lang.String(), sortCluster.h())) {
                    sortCluster.a(infoData);
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            SortCluster sortCluster2 = new SortCluster(infoData, null, false, null, null, null, 62, null);
            clusterHashMap.put(sortCluster2.getClusterKey(), sortCluster2);
        }
    }

    private final void p(boolean forceCluster, LinkedHashMap<String, SortCluster> clusterHashMap, da2.b infoData) {
        SortCluster sortCluster = new SortCluster(infoData, null, false, null, null, null, 62, null);
        sortCluster.l(true);
        clusterHashMap.put(sortCluster.getClusterKey(), sortCluster);
    }

    private final void q(final double zoomLive, final bb2.c callback, final LinkedHashMap<String, SortCluster> resultMapCluster) {
        j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.cluster.algorithm.BaseClusterAlgorithm$callbackOnUiThread$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                ga2.a c16 = j.c();
                str = BaseClusterAlgorithm.this.logTag;
                double d16 = zoomLive;
                LinkedHashMap<String, SortCluster> linkedHashMap = resultMapCluster;
                c16.e(str, "zoomLive:" + d16 + " resultMapCluster:" + (linkedHashMap != null ? Integer.valueOf(linkedHashMap.size()) : null));
                bb2.c cVar = callback;
                if (cVar != null) {
                    cVar.a(resultMapCluster);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(BaseClusterAlgorithm this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.debugList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(BaseClusterAlgorithm this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dataList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(BaseClusterAlgorithm this$0, float f16, boolean z16, bb2.c iClusterResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(iClusterResult, "$iClusterResult");
        m mVar = m.f253240a;
        String str = this$0.logTag;
        long uptimeMillis = SystemClock.uptimeMillis();
        this$0.y(f16, z16, iClusterResult);
        Unit unit = Unit.INSTANCE;
        j.c().e(str, "cluster cost(ms):" + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int x(da2.b bVar, da2.b bVar2) {
        if (!TextUtils.isEmpty(bVar.b()) && !TextUtils.isEmpty(bVar2.b())) {
            return bVar.b().compareTo(bVar2.b());
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(double zoomLevel, boolean forceCluster, bb2.c callback) {
        Projection c16 = this.mapProxy.c();
        if (c16 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(this.dataList.values());
        Collections.sort(arrayList2, f253407n);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            Point screenLocation = c16.toScreenLocation(((da2.b) obj).getCom.tencent.luggage.wxa.c8.c.G java.lang.String());
            Intrinsics.checkNotNullExpressionValue(screenLocation, "projection.toScreenLocation(it.position)");
            if (D(screenLocation)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList(this.debugList.values());
        Collections.sort(arrayList4, f253407n);
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            Point screenLocation2 = c16.toScreenLocation(((da2.b) obj2).getCom.tencent.luggage.wxa.c8.c.G java.lang.String());
            Intrinsics.checkNotNullExpressionValue(screenLocation2, "projection.toScreenLocation(it.position)");
            if (D(screenLocation2)) {
                arrayList5.add(obj2);
            }
        }
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList5);
        j.c().e(this.logTag, "doCluster list_size before: " + (this.dataList.size() + this.debugList.size()) + " after:" + arrayList.size());
        CameraPosition b16 = this.mapProxy.b();
        if (b16 == null) {
            return;
        }
        LatLng latLng = b16.target;
        if (!forceCluster && J(zoomLevel, arrayList.size(), latLng)) {
            j.c().e(this.logTag, "should not cluster");
            return;
        }
        if (!this.isShowMarker) {
            arrayList.clear();
        }
        LinkedHashMap<String, SortCluster> linkedHashMap = new LinkedHashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            da2.b bVar = (da2.b) arrayList.get(i3);
            if (I(bVar, zoomLevel)) {
                p(forceCluster, linkedHashMap, bVar);
            } else {
                o(linkedHashMap, bVar);
            }
        }
        LinkedHashMap<String, SortCluster> F = F(E(linkedHashMap), this.lastResultMap);
        LinkedHashMap<String, SortCluster> linkedHashMap2 = this.lastResultMap;
        if (linkedHashMap2 == null) {
            this.lastResultMap = F;
            q(zoomLevel, callback, F);
        } else {
            Intrinsics.checkNotNull(linkedHashMap2);
            n(zoomLevel, linkedHashMap2, callback, F);
        }
        this.lastZoom = zoomLevel;
        this.lastDataSize = arrayList.size();
        this.lastLatLng = latLng;
    }

    private final int z() {
        int c16 = ab2.a.f25767a.c();
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return com.tencent.mobileqq.nearbypro.utils.d.c(c16, context);
    }

    @NotNull
    public abstract String B();

    public abstract boolean C(@NotNull Class<? extends da2.b> clazz);

    public final void G(boolean showMarker) {
        this.isShowMarker = showMarker;
        j.c().e(this.logTag, "setShowMarker:" + this.isShowMarker);
    }

    public final void j(@NotNull final Collection<? extends da2.b> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        ab2.a.f25767a.x(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.cluster.algorithm.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseClusterAlgorithm.k(collection, this);
            }
        });
    }

    public final void l(@NotNull final Collection<? extends da2.b> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        ab2.a.f25767a.x(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.cluster.algorithm.e
            @Override // java.lang.Runnable
            public final void run() {
                BaseClusterAlgorithm.m(collection, this);
            }
        });
    }

    public final void r() {
        ab2.a.f25767a.x(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.cluster.algorithm.d
            @Override // java.lang.Runnable
            public final void run() {
                BaseClusterAlgorithm.s(BaseClusterAlgorithm.this);
            }
        });
    }

    public final void t() {
        ab2.a.f25767a.x(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.cluster.algorithm.f
            @Override // java.lang.Runnable
            public final void run() {
                BaseClusterAlgorithm.u(BaseClusterAlgorithm.this);
            }
        });
    }

    public final void v(final float zoomLevel, final boolean forceCluster, @NotNull final bb2.c iClusterResult) {
        Intrinsics.checkNotNullParameter(iClusterResult, "iClusterResult");
        Runnable runnable = this.clusterRunnable;
        if (runnable != null) {
            ab2.a.f25767a.z(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.cluster.algorithm.g
            @Override // java.lang.Runnable
            public final void run() {
                BaseClusterAlgorithm.w(BaseClusterAlgorithm.this, zoomLevel, forceCluster, iClusterResult);
            }
        };
        ab2.a.f25767a.x(runnable2);
        this.clusterRunnable = runnable2;
    }
}
