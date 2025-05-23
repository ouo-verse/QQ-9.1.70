package nb4;

import android.content.Intent;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0016\u0010!\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010$R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010&\u00a8\u0006*"}, d2 = {"Lnb4/a;", "", "", "k", "l", "", "d", "c", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, "e", "", "ready", "j", "f", "i", h.F, "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mLoadingEndFlag", "b", "mServiceConnectedFlag", "mUE4InitFinishFlag", "mEnterAvatarFlag", "mFirstFrameFlag", "", "J", "mEntranceClickTime", "mOnCreateTime", "mEnterStoreSceneTime", "Z", "mIsDressInfoReady", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "", "I", "nativeAppId", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f419767m;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mLoadingEndFlag = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mServiceConnectedFlag = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mUE4InitFinishFlag = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mEnterAvatarFlag = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mFirstFrameFlag = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mEntranceClickTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long mOnCreateTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mEnterStoreSceneTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsDressInfoReady;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource sourceFrom;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int nativeAppId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR0\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lnb4/a$a;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "startStep", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "()Ljava/util/concurrent/ConcurrentHashMap;", "b", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: nb4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConcurrentHashMap<String, String> a() {
            return a.f419767m;
        }

        public final void b(ConcurrentHashMap<String, String> concurrentHashMap) {
            a.f419767m = concurrentHashMap;
        }

        Companion() {
        }
    }

    private final String c() {
        if (b.f419779a.a()) {
            return "1";
        }
        return "0";
    }

    private final String d() {
        if (!this.mUE4InitFinishFlag.get() && !ZPlanServiceHelper.I.l0()) {
            return "0";
        }
        return "1";
    }

    private final void k() {
        String str;
        String str2;
        Map map;
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        if (!zPlanQQMC.enablePortalCreateToFirstFrameReport()) {
            QLog.i("ZPlanPortalReportHelper_", 2, "disable reportFirstFrame");
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("k_click_time", String.valueOf(this.mEntranceClickTime));
        hashMap.put("k_loading_end_time", String.valueOf(serverTimeMillis));
        hashMap.put("k_loading_cost_time", String.valueOf(serverTimeMillis - this.mOnCreateTime));
        hashMap.put("k_loading_already_succeed_before", c());
        hashMap.put("k_key_dress_info_ready", String.valueOf(this.mIsDressInfoReady));
        ConcurrentHashMap<String, String> concurrentHashMap = f419767m;
        if (concurrentHashMap != null) {
            hashMap.putAll(concurrentHashMap);
            if (zPlanQQMC.enablePortalFilamentPreLaunch()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("enable_pre_launch", str);
            if (FilamentApiImpl.f369933a.d()) {
                str2 = ZPlanApiImpl.FILAMENT_TAG;
            } else {
                str2 = "ue";
            }
            hashMap.put(StartupReportKey.ENGINE_TYPE, str2);
            hashMap.put("click_to_create", String.valueOf(this.mOnCreateTime - this.mEntranceClickTime));
            hashMap.put("click_to_first_frame", String.valueOf(serverTimeMillis - this.mEntranceClickTime));
            ZootopiaSource zootopiaSource = this.sourceFrom;
            if (zootopiaSource != null) {
                hashMap.put("k_key_source_from_main", zootopiaSource.getMainSource().name());
                hashMap.put("k_key_source_from_sub_source", zootopiaSource.getSubSource());
            }
            map = MapsKt__MapsKt.toMap(hashMap);
            r.e(null, "zplan_portal_create_to_first_frame_cost", map, 1, null);
        }
    }

    private final void l() {
        Map mutableMapOf;
        Map map;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("scene", "PortalBusiness"), TuplesKt.to("startUpResult", "1"), TuplesKt.to("errorCode", "0"), TuplesKt.to("startWithEntry2FirstRenderTC", String.valueOf(NetConnInfoCenter.getServerTimeMillis() - this.mOnCreateTime)), TuplesKt.to("fetchBootDownload", "0"), TuplesKt.to("fetchAvatarDownload", "0"), TuplesKt.to("fetchAllDownload", "0"), TuplesKt.to("fetchAnimationDownload", "0"), TuplesKt.to("loadSoDownload", "0"), TuplesKt.to("lifecyclePauseHappened", "0"), TuplesKt.to("native_app_id", String.valueOf(this.nativeAppId)));
        ZootopiaSource zootopiaSource = this.sourceFrom;
        if (zootopiaSource != null) {
            mutableMapOf.put("k_key_source_from_main", zootopiaSource.getMainSource().name());
            mutableMapOf.put("k_key_source_from_sub_source", zootopiaSource.getSubSource());
        }
        map = MapsKt__MapsKt.toMap(mutableMapOf);
        r.e(null, "nativeAppStartUp", map, 1, null);
    }

    public final void e(Intent intent, ZootopiaSource sourceFrom) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        long longExtra = intent.getLongExtra("key_click_server_time", 0L);
        this.mEntranceClickTime = longExtra;
        QLog.i("ZPlanPortalReportHelper_", 2, "onCreate mEntranceClickTime:" + longExtra);
        this.sourceFrom = sourceFrom;
        this.nativeAppId = intent.getIntExtra(MiniAppGetNativeAppInfoServlet.KEY_NATIVE_APP_ID, 0);
        if (this.mEntranceClickTime == 0) {
            return;
        }
        this.mOnCreateTime = NetConnInfoCenter.getServerTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("k_click_time", String.valueOf(this.mEntranceClickTime));
        hashMap.put("k_cost_time", String.valueOf(this.mOnCreateTime - this.mEntranceClickTime));
        hashMap.put("k_is_engine_ready", d());
        mb4.c.c(mb4.c.f416532a, "e_zplan_portal_create", hashMap, false, 4, null);
    }

    public final void f() {
        if (this.mOnCreateTime == 0) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("k_click_time", String.valueOf(this.mEntranceClickTime));
        hashMap.put("k_loading_end_state", String.valueOf(this.mLoadingEndFlag.get()));
        hashMap.put("k_page_create_time", String.valueOf(this.mOnCreateTime));
        hashMap.put("k_stay_time", String.valueOf(serverTimeMillis - this.mOnCreateTime));
        hashMap.put("k_is_engine_ready", d());
        hashMap.put("k_key_dress_info_ready", String.valueOf(this.mIsDressInfoReady));
        ZootopiaSource zootopiaSource = this.sourceFrom;
        if (zootopiaSource != null) {
            hashMap.put("k_key_source_from_main", zootopiaSource.getMainSource().name());
            hashMap.put("k_key_source_from_sub_source", zootopiaSource.getSubSource());
        }
        mb4.c.c(mb4.c.f416532a, "e_zplan_portal_destory", hashMap, false, 4, null);
    }

    public final void g() {
        if (this.mFirstFrameFlag.get()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("k_store_load_cost_time", String.valueOf(NetConnInfoCenter.getServerTimeMillis() - this.mEnterStoreSceneTime));
        hashMap.put("k_loading_already_succeed_before", c());
        mb4.c.c(mb4.c.f416532a, "e_zplan_store_load_end", hashMap, false, 4, null);
        b.f419779a.c();
        this.mFirstFrameFlag.set(true);
    }

    public final void h() {
        if (this.mLoadingEndFlag.get()) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("k_click_time", String.valueOf(this.mEntranceClickTime));
        hashMap.put("k_loading_end_time", String.valueOf(serverTimeMillis));
        hashMap.put("k_loading_cost_time", String.valueOf(serverTimeMillis - this.mOnCreateTime));
        hashMap.put("k_loading_already_succeed_before", c());
        hashMap.put("k_key_dress_info_ready", String.valueOf(this.mIsDressInfoReady));
        mb4.c.c(mb4.c.f416532a, "e_zplan_portal_loading_end", hashMap, false, 4, null);
        k();
        if (this.nativeAppId > 0) {
            l();
        }
        this.mLoadingEndFlag.set(true);
    }

    public final void i() {
        String str;
        Map map;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        HashMap hashMap = new HashMap();
        ConcurrentHashMap<String, String> concurrentHashMap = f419767m;
        if (concurrentHashMap != null) {
            hashMap.putAll(concurrentHashMap);
            if (FilamentApiImpl.f369933a.d()) {
                str = ZPlanApiImpl.FILAMENT_TAG;
            } else {
                str = "ue";
            }
            hashMap.put(StartupReportKey.ENGINE_TYPE, str);
            hashMap.put("click_to_create", String.valueOf(this.mOnCreateTime - this.mEntranceClickTime));
            hashMap.put("click_to_loading_hide", String.valueOf(serverTimeMillis - this.mEntranceClickTime));
            map = MapsKt__MapsKt.toMap(hashMap);
            r.e(null, "zplan_portal_create_to_loading_hide_cost", map, 1, null);
            QLog.i("ZPlanPortalReportHelper_", 1, "onLoadingHide click_to_loading_hide " + (serverTimeMillis - this.mEntranceClickTime));
        }
    }

    public final void j(boolean ready) {
        this.mIsDressInfoReady = ready;
    }
}
