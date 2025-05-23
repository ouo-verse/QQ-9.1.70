package mg3;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.state.report.SquareReportConst;
import id3.d;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lmg3/a;", "", "", "modId", "", "modVersion", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "c", "a", "errorCode", "b", "Lid3/d;", "Lid3/d;", "dtReportHelper", "Ljava/util/HashMap;", "Lmg3/a$a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "reportParamsMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f416730a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final d dtReportHelper = new d(null, 1, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Integer, ReportParams> reportParamsMap = new HashMap<>();

    a() {
    }

    public final void a(int modId) {
        ReportParams remove = reportParamsMap.remove(Integer.valueOf(modId));
        if (remove == null) {
            QLog.i("CloudModReportHelper", 1, "reportCloudGameLoadComplete reportParams is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_map_id", Integer.valueOf(modId));
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ag.f373258a.d(remove.getSource()));
        hashMap.put("zplan_mod_version", remove.getModVersion());
        hashMap.put("zplan_error_code", 0);
        hashMap.put("zplan_is_cloud_mod", 1);
        hashMap.put("zplan_loading_id", remove.getLoadingId());
        hashMap.put("zplan_startup_lvtm", Long.valueOf(System.currentTimeMillis() - remove.getLoadingStartTime()));
        dtReportHelper.d("ev_zplan_mod_startup_complete", hashMap);
    }

    public final void b(int modId, String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        ReportParams remove = reportParamsMap.remove(Integer.valueOf(modId));
        if (remove == null) {
            QLog.i("CloudModReportHelper", 1, "reportCloudGameLoadFailed reportParams is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_map_id", Integer.valueOf(modId));
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ag.f373258a.d(remove.getSource()));
        hashMap.put("zplan_mod_version", remove.getModVersion());
        hashMap.put("zplan_error_code", errorCode);
        hashMap.put("zplan_is_cloud_mod", 1);
        hashMap.put("zplan_loading_id", remove.getLoadingId());
        hashMap.put("zplan_startup_lvtm", Long.valueOf(System.currentTimeMillis() - remove.getLoadingStartTime()));
        dtReportHelper.d("ev_zplan_mod_startup_complete", hashMap);
    }

    public final void c(int modId, String modVersion, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(modVersion, "modVersion");
        Intrinsics.checkNotNullParameter(source, "source");
        long currentTimeMillis = System.currentTimeMillis();
        String a16 = c.f327951a.a(currentTimeMillis);
        reportParamsMap.put(Integer.valueOf(modId), new ReportParams(a16, currentTimeMillis, modVersion, source));
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_map_id", Integer.valueOf(modId));
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ag.f373258a.d(source));
        hashMap.put("zplan_mod_version", modVersion);
        hashMap.put("zplan_is_cloud_mod", 1);
        hashMap.put("zplan_loading_id", a16);
        dtReportHelper.d("ev_zplan_mod_startup_begin", hashMap);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lmg3/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "loadingId", "", "b", "J", "()J", "loadingStartTime", "c", "modVersion", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "<init>", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mg3.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes38.dex */
    private static final /* data */ class ReportParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String loadingId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long loadingStartTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String modVersion;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final ZootopiaSource source;

        public ReportParams(String loadingId, long j3, String modVersion, ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(loadingId, "loadingId");
            Intrinsics.checkNotNullParameter(modVersion, "modVersion");
            Intrinsics.checkNotNullParameter(source, "source");
            this.loadingId = loadingId;
            this.loadingStartTime = j3;
            this.modVersion = modVersion;
            this.source = source;
        }

        /* renamed from: a, reason: from getter */
        public final String getLoadingId() {
            return this.loadingId;
        }

        /* renamed from: b, reason: from getter */
        public final long getLoadingStartTime() {
            return this.loadingStartTime;
        }

        /* renamed from: c, reason: from getter */
        public final String getModVersion() {
            return this.modVersion;
        }

        /* renamed from: d, reason: from getter */
        public final ZootopiaSource getSource() {
            return this.source;
        }

        public int hashCode() {
            return (((((this.loadingId.hashCode() * 31) + com.tencent.mobileqq.vas.banner.c.a(this.loadingStartTime)) * 31) + this.modVersion.hashCode()) * 31) + this.source.hashCode();
        }

        public String toString() {
            return "ReportParams(loadingId=" + this.loadingId + ", loadingStartTime=" + this.loadingStartTime + ", modVersion=" + this.modVersion + ", source=" + this.source + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportParams)) {
                return false;
            }
            ReportParams reportParams = (ReportParams) other;
            return Intrinsics.areEqual(this.loadingId, reportParams.loadingId) && this.loadingStartTime == reportParams.loadingStartTime && Intrinsics.areEqual(this.modVersion, reportParams.modVersion) && Intrinsics.areEqual(this.source, reportParams.source);
        }
    }
}
