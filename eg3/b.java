package eg3;

import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.IWinkReport;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u00032\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J0\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010#R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010#R\u0016\u0010'\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010&R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010&R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010&R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010&R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010&R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010&R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Leg3/b;", "Leg3/a;", "", "o", "p", "c", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "e", "f", "", "costMs", "g", "", "position", "d", h.F, ReportConstant.COSTREPORT_PREFIX, "t", "", "key", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "logString", "i", "Landroid/os/Bundle;", "bundle", "j", "eventKey", "a", "b", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onCreateFlag", "cameraFirstFrameFlag", "J", "entranceClickTime", "setFaceJsonTimeBegin", "generateThumbnailTimeBegin", "generateThumbnailBeforeFinishLoading", "prepareDataBegin", "requestDataBegin", "requestPermissionBegin", "requestPermissionCost", "downloadFakeCost", "downloadResBegin", "downloadResEnd", DomainData.DOMAIN_NAME, "I", "maxPosition", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements a {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean onCreateFlag = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean cameraFirstFrameFlag = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long entranceClickTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long setFaceJsonTimeBegin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long generateThumbnailTimeBegin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long generateThumbnailBeforeFinishLoading;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long prepareDataBegin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long requestDataBegin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long requestPermissionBegin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long requestPermissionCost;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long downloadFakeCost;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long downloadResBegin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long downloadResEnd;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int maxPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Leg3/b$a;", "", "", "a", "", "CAMERA_CAPTURE_PREPARE_DATA_BEGIN", "Ljava/lang/String;", "CAMERA_CAPTURE_REQUEST_DATA_BEGIN", "CAMERA_CAPTURE_REQUEST_DATA_END", "CAMERA_FIRST_FRAME_END", "CAMERA_REQUEST_PERMISSION_BEGIN", "CAMERA_REQUEST_PERMISSION_END", "ENTRANCE_CLICK_TIME_KEY", "ENTRANCE_LAUNCH_ACTIVITY_TIME_KEY", "GENERATE_THUMBNAIL_BEFORE_FINISH_LOADING", "GENERATE_THUMBNAIL_BEGIN", "GENERATE_THUMBNAIL_DOWNLOAD_RESOURCE_BEGIN", "GENERATE_THUMBNAIL_DOWNLOAD_RESOURCE_END", "GENERATE_THUMBNAIL_END", "MMKV_KEY_FIRST_OPEN_FILAMENT_AI_SCULPT", "PERFORMANCE_FALSE", "PERFORMANCE_TRUE", "SET_FACE_JSON_BEGIN", "SET_FACE_JSON_END", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: eg3.b$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return System.currentTimeMillis();
        }

        Companion() {
        }
    }

    private final void c() {
        String str;
        Map<String, String> mapOf;
        if (this.cameraFirstFrameFlag.get()) {
            return;
        }
        this.cameraFirstFrameFlag.set(true);
        long a16 = (INSTANCE.a() - this.entranceClickTime) - this.requestPermissionCost;
        if (((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("filament_ai_sculpt_first_open", true)) {
            i("filament_ai_sculpt_first_open_cost " + a16 + " ms");
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("filament_ai_sculpt_first_open", false);
            str = "1";
        } else {
            i("filament_ai_sculpt_open_cost " + a16 + " ms");
            str = "0";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_first_open", str));
        m("performance#filament_ai_sculpt#open_cost", a16, mapOf);
    }

    private final void d(int position) {
        long a16 = INSTANCE.a();
        this.generateThumbnailBeforeFinishLoading = a16;
        i("step3 filament_ai_sculpt_before_finish_loading " + (a16 - this.generateThumbnailTimeBegin) + " ms, position:" + position);
    }

    private final void f() {
        if (this.downloadResBegin <= 0) {
            this.downloadResBegin = INSTANCE.a();
        }
    }

    private final void g(long costMs) {
        this.downloadResEnd = INSTANCE.a();
        this.downloadFakeCost += costMs;
    }

    private final void h(int position) {
        Map<String, String> mapOf;
        this.maxPosition = Math.max(position, this.maxPosition);
        long a16 = INSTANCE.a();
        long j3 = a16 - this.generateThumbnailTimeBegin;
        long j16 = this.downloadResEnd - this.downloadResBegin;
        i("step3 download slot resource all success | cost: " + j16 + " ms, fakeCost: " + this.downloadFakeCost + " ms, position:" + position);
        long j17 = a16 - this.generateThumbnailBeforeFinishLoading;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("step3 filament_ai_sculpt_take_screenshot ");
        sb5.append(j17);
        sb5.append(" ms, position:");
        sb5.append(position);
        i(sb5.toString());
        i("step3 filament_ai_sculpt_thumbnail_generate_cost " + j3 + " ms, position:" + position);
        i("step3 filament_ai_sculpt_thumbnail_generate_cost_without_download " + (j3 - j16) + " ms, position:" + position);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("position", String.valueOf(position)));
        m("performance#filament_ai_sculpt#thumbnail_generate_cost", j3, mapOf);
        this.downloadResBegin = 0L;
        this.downloadResEnd = 0L;
        this.downloadFakeCost = 0L;
    }

    private final void l() {
        this.prepareDataBegin = INSTANCE.a();
    }

    private final void m(String key, long costMs, Map<String, String> params) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_COST_TIME, String.valueOf(costMs));
        if (params != null) {
            linkedHashMap.putAll(params);
        }
        ((IWinkReport) QRoute.api(IWinkReport.class)).reportDengTa(key, linkedHashMap);
    }

    private final void o() {
        this.requestPermissionBegin = INSTANCE.a();
    }

    private final void p() {
        long a16 = INSTANCE.a() - this.requestPermissionBegin;
        this.requestPermissionCost = a16;
        i("filament_ai_sculpt_request_permission_cost " + a16 + " ms");
    }

    private final void q() {
        long a16 = INSTANCE.a();
        this.requestDataBegin = a16;
        long j3 = a16 - this.prepareDataBegin;
        i("step1 filament_ai_sculpt_data_prepare_cost " + j3 + " ms");
        n(this, "performance#filament_ai_sculpt#data_prepare_cost", j3, null, 4, null);
    }

    private final void r() {
        long a16 = INSTANCE.a() - this.requestDataBegin;
        i("step2 filament_ai_sculpt_data_request_cost " + a16 + " ms");
        n(this, "performance#filament_ai_sculpt#data_request_cost", a16, null, 4, null);
    }

    private final void s() {
        this.setFaceJsonTimeBegin = INSTANCE.a();
    }

    private final void t() {
        String str;
        Map<String, String> mapOf;
        if (this.setFaceJsonTimeBegin <= 0) {
            return;
        }
        Companion companion = INSTANCE;
        long a16 = companion.a() - this.setFaceJsonTimeBegin;
        this.setFaceJsonTimeBegin = 0L;
        i("step4 filament_ai_sculpt_camera_first_frame_cost " + a16 + " ms");
        n(this, "performance#filament_ai_sculpt#camera_first_frame_cost", a16, null, 4, null);
        if (this.prepareDataBegin > 0) {
            long a17 = companion.a() - this.prepareDataBegin;
            i("filament_ai_sculpt_after_capture_cost " + a17 + " ms");
            if (this.maxPosition <= 2) {
                str = "1";
            } else {
                str = "0";
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_first_capture", str));
            m("performance#filament_ai_sculpt#after_capture_cost", a17, mapOf);
            this.prepareDataBegin = 0L;
        }
    }

    @Override // eg3.a
    public void a(String eventKey) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        switch (eventKey.hashCode()) {
            case -934838711:
                if (eventKey.equals("CAMERA_CAPTURE_REQUEST_DATA_END")) {
                    r();
                    return;
                }
                return;
            case -785349952:
                if (eventKey.equals("CAMERA_FIRST_FRAME_END")) {
                    c();
                    return;
                }
                return;
            case -734869865:
                if (eventKey.equals("CAMERA_CAPTURE_REQUEST_DATA_BEGIN")) {
                    q();
                    return;
                }
                return;
            case -89317559:
                if (eventKey.equals("SET_FACE_JSON_END")) {
                    t();
                    return;
                }
                return;
            case 62138263:
                if (eventKey.equals("SET_FACE_JSON_BEGIN")) {
                    s();
                    return;
                }
                return;
            case 640479519:
                if (eventKey.equals("CAMERA_CAPTURE_PREPARE_DATA_BEGIN")) {
                    l();
                    return;
                }
                return;
            case 1159512181:
                if (eventKey.equals("CAMERA_REQUEST_PERMISSION_END")) {
                    p();
                    return;
                }
                return;
            case 1297177330:
                if (eventKey.equals("GENERATE_THUMBNAIL_DOWNLOAD_RESOURCE_BEGIN")) {
                    f();
                    return;
                }
                return;
            case 1891642819:
                if (eventKey.equals("CAMERA_REQUEST_PERMISSION_BEGIN")) {
                    o();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // eg3.a
    public void b(String eventKey, int position) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        int hashCode = eventKey.hashCode();
        if (hashCode == -1759753076) {
            if (eventKey.equals("GENERATE_THUMBNAIL_BEGIN")) {
                e();
            }
        } else {
            if (hashCode != -454843341) {
                if (hashCode == 1549008254 && eventKey.equals("GENERATE_THUMBNAIL_END")) {
                    h(position);
                    return;
                }
                return;
            }
            if (eventKey.equals("GENERATE_THUMBNAIL_BEFORE_FINISH_LOADING")) {
                d(position);
            }
        }
    }

    public void i(String logString) {
        Intrinsics.checkNotNullParameter(logString, "logString");
        QLog.i("filament_ai_sculpt_pef", 1, logString);
    }

    public void j(Bundle bundle) {
        long a16;
        if (this.onCreateFlag.get()) {
            return;
        }
        this.onCreateFlag.set(true);
        long a17 = INSTANCE.a();
        if (bundle != null) {
            a17 = bundle.getLong("filament_face_entrance_click_time_ms", a17);
        }
        this.entranceClickTime = a17;
        if (bundle != null) {
            a16 = bundle.getLong("filament_face_entrance_launch_time_ms", INSTANCE.a());
        } else {
            a16 = INSTANCE.a();
        }
        i("filament_ai_sculpt_download_cost " + (a16 - this.entranceClickTime) + " ms");
    }

    public void k(String eventKey, long costMs) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        if (Intrinsics.areEqual(eventKey, "GENERATE_THUMBNAIL_DOWNLOAD_RESOURCE_END")) {
            g(costMs);
        }
    }

    private final void e() {
        this.downloadResBegin = 0L;
        this.downloadResEnd = 0L;
        this.downloadFakeCost = 0L;
        this.generateThumbnailTimeBegin = INSTANCE.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void n(b bVar, String str, long j3, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        bVar.m(str, j3, map);
    }
}
