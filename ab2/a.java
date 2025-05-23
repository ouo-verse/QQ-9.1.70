package ab2;

import android.util.DisplayMetrics;
import android.util.Size;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.x;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProBytesEntry;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProCommonExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProEntry;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUserInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qp4.e;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\bC\u0010DJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\b\u0012\u0004\u0012\u00020\b0\u0004J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\b\u0012\u0004\u0012\u00020\u00180\u0004J\n\u0010\u001b\u001a\u00020\u0006*\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001fJ\u001c\u0010%\u001a\u00020$*\u00020!2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\nJ\n\u0010&\u001a\u00020$*\u00020\u0005J\u0012\u0010)\u001a\u00020\u0012*\u00020\u00052\u0006\u0010(\u001a\u00020'J\u0006\u0010+\u001a\u00020*J\u0006\u0010-\u001a\u00020,J\u0006\u0010/\u001a\u00020.J\u0006\u00100\u001a\u00020.J\u0006\u00102\u001a\u000201J\u0006\u00103\u001a\u000201J\u0006\u00104\u001a\u000201J\u0006\u00105\u001a\u00020.J\u0006\u00106\u001a\u00020.J\u000e\u00109\u001a\u00020\u00122\u0006\u00108\u001a\u000207J\u000e\u0010:\u001a\u00020\u00122\u0006\u00108\u001a\u000207J\u0006\u0010;\u001a\u00020$J*\u0010@\u001a\u00020\u001f2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.0<2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nJ\u0006\u0010B\u001a\u00020A\u00a8\u0006E"}, d2 = {"Lab2/a;", "", "Lcom/tencent/qqnt/kernel/api/x;", "g", "", "Lxp4/h;", "", h.F, "Lxp4/a;", "d", "", "lat1", "lng1", "lat2", "lng2", "a", "Lcom/tencent/mobileqq/nearbypro/api/IMapNearbyDataService;", "f", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Lda2/b;", "D", BdhLogUtil.LogTag.Tag_Conn, "Lqp4/a;", "B", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "e", "Lbb2/e;", "options", "r", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "b", "Lda2/d;", com.tencent.luggage.wxa.c8.c.G, "ratio", "", "u", "t", "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "selfUserInfo", "w", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/util/Size;", "k", "", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "o", DomainData.DOMAIN_NAME, "p", "i", "l", "Ljava/lang/Runnable;", "task", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Pair;", "disRange", QCircleSchemeAttr.Polymerize.LAT, "lng", "y", "Lab2/a$a;", "j", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f25767a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lab2/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "enableOptimize", "", "b", "D", "()D", "ratio", "<init>", "(ZD)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ab2.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes15.dex */
    public static final /* data */ class RequestInfoOptimizeConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enableOptimize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final double ratio;

        public RequestInfoOptimizeConfig(boolean z16, double d16) {
            this.enableOptimize = z16;
            this.ratio = d16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnableOptimize() {
            return this.enableOptimize;
        }

        /* renamed from: b, reason: from getter */
        public final double getRatio() {
            return this.ratio;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestInfoOptimizeConfig)) {
                return false;
            }
            RequestInfoOptimizeConfig requestInfoOptimizeConfig = (RequestInfoOptimizeConfig) other;
            if (this.enableOptimize == requestInfoOptimizeConfig.enableOptimize && Double.compare(this.ratio, requestInfoOptimizeConfig.ratio) == 0) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.enableOptimize;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.ratio);
        }

        @NotNull
        public String toString() {
            return "RequestInfoOptimizeConfig(enableOptimize=" + this.enableOptimize + ", ratio=" + this.ratio + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((xp4.a) t16).f448304i), Integer.valueOf(((xp4.a) t17).f448304i));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((xp4.a) t16).f448304i), Integer.valueOf(((xp4.a) t17).f448304i));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((xp4.h) t16).f448331g), Integer.valueOf(((xp4.h) t17).f448331g));
            return compareValues;
        }
    }

    a() {
    }

    private final double a(double lat1, double lng1, double lat2, double lng2) {
        int roundToInt;
        double d16 = (lat1 * 3.141592653589793d) / 180.0d;
        double d17 = (lat2 * 3.141592653589793d) / 180.0d;
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.asin(Math.sqrt(Math.pow(Math.sin((d16 - d17) / 2.0d), 2.0d) + (Math.cos(d16) * Math.cos(d17) * Math.pow(Math.sin((((lng1 * 3.141592653589793d) / 180.0d) - ((lng2 * 3.141592653589793d) / 180.0d)) / 2.0d), 2.0d)))) * 2.0d * 6378.137d * 10000.0d);
        return (roundToInt / 10000.0d) * 1000.0d;
    }

    private final String d(List<xp4.a> list) {
        List sortedWith;
        List sortedWith2;
        Pair pair;
        Pair pair2;
        Object first;
        Object last;
        Object first2;
        Object last2;
        boolean z16;
        long m3 = m();
        List<xp4.a> list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((xp4.a) next).f448297b != m3) {
                z17 = false;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list2) {
            if (((xp4.a) obj).f448297b != m3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new c());
        if (!sortedWith.isEmpty()) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) sortedWith);
            Integer valueOf = Integer.valueOf(((xp4.a) first2).f448304i);
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) sortedWith);
            pair = new Pair(valueOf, Integer.valueOf(((xp4.a) last2).f448304i));
        } else {
            pair = new Pair(0, 0);
        }
        if (!sortedWith2.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) sortedWith2);
            Integer valueOf2 = Integer.valueOf(((xp4.a) first).f448304i);
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) sortedWith2);
            pair2 = new Pair(valueOf2, Integer.valueOf(((xp4.a) last).f448304i));
        } else {
            pair2 = new Pair(0, 0);
        }
        return "selfFeedSize:" + sortedWith.size() + " pTs:" + pair.getFirst() + "-" + pair.getSecond() + " otherFeedSize:" + sortedWith2.size() + " pTs:" + pair2.getFirst() + "-" + pair2.getSecond();
    }

    private final x g() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService == null) {
            return null;
        }
        return iKernelService.getNearbyProService();
    }

    private final String h(List<xp4.h> list) {
        Pair pair;
        Object first;
        Object last;
        CollectionsKt___CollectionsKt.sortedWith(list, new d());
        if (!list.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            Integer valueOf = Integer.valueOf(((xp4.h) first).f448331g);
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            pair = new Pair(valueOf, Integer.valueOf(((xp4.h) last).f448331g));
        } else {
            pair = new Pair(0, 0);
        }
        return "personSize:" + list.size() + " rTs:" + pair.getFirst() + "-" + pair.getSecond();
    }

    public static /* synthetic */ boolean v(a aVar, da2.d dVar, da2.d dVar2, double d16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            d16 = 1.0d;
        }
        return aVar.u(dVar, dVar2, d16);
    }

    public final void A() {
        SelfUserInfo selfUserInfo;
        String str;
        np4.c a16 = com.tencent.mobileqq.nearbypro.request.a.a();
        x g16 = g();
        if (g16 != null) {
            long m3 = m();
            np4.b bVar = a16.f420673a;
            g16.setCommonExtInfo(new NearbyProCommonExtInfo(m3, new NearbyProClientInfo(bVar.f420670a, bVar.f420671b, bVar.f420672c), a16.f420674b, new NearbyProEntry(), new NearbyProBytesEntry()));
        }
        IMapNearbyDataService f16 = f();
        String str2 = null;
        if (f16 != null) {
            selfUserInfo = f16.getSelfUserInfo();
        } else {
            selfUserInfo = null;
        }
        aa2.a aVar = aa2.a.f25755a;
        long m16 = m();
        if (selfUserInfo != null) {
            str = selfUserInfo.getNickName();
        } else {
            str = null;
        }
        if (selfUserInfo != null) {
            str2 = selfUserInfo.getAvatarUrl();
        }
        aVar.e(new NearbyProUserInfo(m16, str, str2));
    }

    @NotNull
    public final List<da2.b> B(@NotNull List<qp4.a> list) {
        int collectionSizeOrDefault;
        List<da2.b> mutableList;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        j.c().e("NBP.NearByProClusterPart", "areaSize:" + list.size());
        ArrayList<qp4.a> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((qp4.a) obj).f429198b != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (qp4.a aVar : arrayList) {
            e eVar = aVar.f429198b;
            arrayList2.add(new eb2.a(aVar, new LatLng(eVar.f429215a, eVar.f429216b)));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        return mutableList;
    }

    @NotNull
    public final List<da2.b> C(@NotNull List<xp4.a> list) {
        int collectionSizeOrDefault;
        List<da2.b> mutableList;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        j.c().e("NBP.NearByProClusterPart", d(list));
        ArrayList<xp4.a> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((xp4.a) obj).f448298c != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (xp4.a aVar : arrayList) {
            e eVar = aVar.f448298c;
            arrayList2.add(new hb2.b(aVar, new LatLng(eVar.f429215a, eVar.f429216b)));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        return mutableList;
    }

    @NotNull
    public final List<da2.b> D(@NotNull List<xp4.h> list) {
        int collectionSizeOrDefault;
        List<da2.b> mutableList;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        j.c().e("NBP.NearByProClusterPart", h(list));
        ArrayList<xp4.h> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((xp4.h) obj).f448326b != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (xp4.h hVar : arrayList) {
            e eVar = hVar.f448326b;
            arrayList2.add(new gb2.c(hVar, new LatLng(eVar.f429215a, eVar.f429216b)));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        return mutableList;
    }

    public final double b(@NotNull LatLng lat1, @NotNull LatLng lat2) {
        Intrinsics.checkNotNullParameter(lat1, "lat1");
        Intrinsics.checkNotNullParameter(lat2, "lat2");
        return a(lat1.latitude, lat1.longitude, lat2.latitude, lat2.longitude);
    }

    public final int c() {
        if (!s()) {
            return c.a.d(j.d(), "MockClusterDis", 60, null, false, 12, null);
        }
        return 60;
    }

    @NotNull
    public final String e(@NotNull SosoLbsInfo sosoLbsInfo) {
        Double d16;
        Intrinsics.checkNotNullParameter(sosoLbsInfo, "<this>");
        SosoLocation sosoLocation = sosoLbsInfo.mLocation;
        Double d17 = null;
        if (sosoLocation != null) {
            d16 = Double.valueOf(sosoLocation.mLat02);
        } else {
            d16 = null;
        }
        SosoLocation sosoLocation2 = sosoLbsInfo.mLocation;
        if (sosoLocation2 != null) {
            d17 = Double.valueOf(sosoLocation2.mLon02);
        }
        return "mLat02:" + d16 + " mLon02:" + d17;
    }

    @Nullable
    public final IMapNearbyDataService f() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IMapNearbyDataService.class, "");
        }
        return (IMapNearbyDataService) iRuntimeService;
    }

    public final int i() {
        if (!s()) {
            return c.a.d(j.d(), "MockReqRadius", 7000, null, false, 12, null);
        }
        return 7000;
    }

    @NotNull
    public final RequestInfoOptimizeConfig j() {
        return new RequestInfoOptimizeConfig(true, 0.7d);
    }

    @NotNull
    public final Size k() {
        DisplayMetrics displayMetrics = BaseApplication.context.getResources().getDisplayMetrics();
        return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public final int l() {
        if (!s()) {
            return c.a.d(j.d(), "MockSelfMoveSpeed", 0, null, false, 12, null);
        }
        return 0;
    }

    public final long m() {
        SelfUserInfo selfUserInfo;
        IMapNearbyDataService f16 = f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
            return selfUserInfo.getTid();
        }
        return 0L;
    }

    public final float n() {
        if (!s()) {
            return c.a.c(j.d(), "MockZoomCluster", 14.85f, null, false, 12, null);
        }
        return 14.85f;
    }

    public final float o() {
        if (!s()) {
            return c.a.c(j.d(), "MockZoomCommon", 14.84f, null, false, 12, null);
        }
        return 14.84f;
    }

    public final float p() {
        if (!s()) {
            return c.a.c(j.d(), "MockZoomLandMode", 14.0f, null, false, 12, null);
        }
        return 14.0f;
    }

    public final int q() {
        if (!s()) {
            return c.a.d(j.d(), "MockZoomMix", 13, null, false, 12, null);
        }
        return 13;
    }

    public final void r(@NotNull bb2.e options) {
        Intrinsics.checkNotNullParameter(options, "options");
        options.alpha(0.0f);
        options.level(2);
        options.fastLoad(false);
        options.infoWindowEnable(true);
        options.viewInfoWindow(true);
        options.infoWindowAnchor(0.5f, 0.5f);
        options.flat(true);
        options.clockwise(false);
    }

    public final boolean s() {
        if (!j.a().mo208public() && !j.a().gray()) {
            return false;
        }
        return true;
    }

    public final boolean t(@NotNull xp4.h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        long m3 = m();
        long j3 = hVar.f448325a;
        if (j3 == m3 && j3 != 0) {
            return true;
        }
        return false;
    }

    public final boolean u(@NotNull da2.d dVar, @NotNull da2.d pos, double d16) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(pos, "pos");
        double a16 = a(pos.getLatLng().latitude, pos.getLatLng().longitude, dVar.getLatLng().latitude, dVar.getLatLng().longitude);
        if (a16 <= pos.getDis() * d16) {
            j.c().e("NBP.NearByProClusterPart", "isSubset ori:" + dVar + " lst:" + pos + " disBetween:" + a16);
            return true;
        }
        return false;
    }

    public final void w(@NotNull xp4.h hVar, @NotNull SelfUserInfo selfUserInfo) {
        Number number;
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        hVar.f448325a = selfUserInfo.getTid();
        hVar.f448328d = selfUserInfo.getAvatarUrl();
        e eVar = new e();
        ab2.c cVar = ab2.c.f25771a;
        LatLng a16 = cVar.a(selfUserInfo);
        Number number2 = 0;
        if (a16 != null) {
            number = Double.valueOf(a16.latitude);
        } else {
            number = number2;
        }
        eVar.f429215a = number.floatValue();
        LatLng a17 = cVar.a(selfUserInfo);
        if (a17 != null) {
            number2 = Double.valueOf(a17.longitude);
        }
        eVar.f429216b = number2.floatValue();
        hVar.f448326b = eVar;
        hVar.f448327c = selfUserInfo.getNickName();
        hVar.f448329e = selfUserInfo.getStatusInfo();
    }

    public final void x(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j.g().a(task);
    }

    @NotNull
    public final LatLng y(@NotNull Pair<Integer, Integer> disRange, double lat, double lng) {
        int random;
        int random2;
        Intrinsics.checkNotNullParameter(disRange, "disRange");
        IntRange intRange = new IntRange(disRange.getFirst().intValue(), disRange.getSecond().intValue());
        Random.Companion companion = Random.INSTANCE;
        random = RangesKt___RangesKt.random(intRange, companion);
        random2 = RangesKt___RangesKt.random(new IntRange(0, 360), companion);
        double radians = Math.toRadians(random2);
        double radians2 = Math.toRadians(lat);
        double radians3 = Math.toRadians(lng);
        double d16 = (random / 1000) / 6371.0d;
        double asin = Math.asin((Math.sin(radians2) * Math.cos(d16)) + (Math.cos(radians2) * Math.sin(d16) * Math.cos(radians)));
        return new LatLng(Math.toDegrees(asin), Math.toDegrees(radians3 + Math.atan2(Math.sin(radians) * Math.sin(d16) * Math.cos(radians2), Math.cos(d16) - (Math.sin(radians2) * Math.sin(asin)))));
    }

    public final void z(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        j.g().b(task);
    }
}
