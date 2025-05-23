package com.tencent.filament.zplanservice.feature;

import androidx.exifinterface.media.ExifInterface;
import cl0.FilamentCoupleTextureViewConfig;
import cl0.FilamentMiniHomeConnectDelayTimeConfig;
import cl0.FilamentRecordSizeConfig;
import cl0.FilamentSceneMonitorConfig;
import cl0.FilamentTextureViewConfig;
import cl0.SceneConfig;
import cl0.c;
import cl0.f;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import dl0.g;
import dl0.k;
import fl0.a;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bJ\u0010KJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\u0002J\b\u0010#\u001a\u0004\u0018\u00010\bJ\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020\u0002J\u0006\u0010(\u001a\u00020\u0002J\u0006\u0010*\u001a\u00020)J\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0+R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u00101R\u001d\u00106\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b4\u00105R\u001d\u0010:\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b8\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010<R\u001b\u0010A\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b?\u0010@R*\u0010I\u001a\u00020B2\u0006\u0010C\u001a\u00020B8F@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006L"}, d2 = {"Lcom/tencent/filament/zplanservice/feature/FilamentFeatureUtil;", "", "", "a", "H", "l", "", "B", "Lorg/json/JSONObject;", "u", "Lcl0/f;", "p", "g", "Lcl0/c;", "o", "", HippyTKDListViewAdapter.X, "c", "Lcl0/e;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcl0/h;", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcl0/b;", "r", "K", "J", "b", "d", "k", "e", "f", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "t", "G", "", ReportConstant.COSTREPORT_PREFIX, h.F, "i", "Lcl0/g;", "w", "", "Lcl0/k;", "v", "Ldl0/g;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ldl0/g;", "qqmcProxy", "Ldl0/k;", "E", "()Ldl0/k;", "toggleProxy", "Ldl0/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ldl0/a;", "appSettingProxy", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "urlTemplateLock", "Lcom/google/gson/Gson;", "y", "()Lcom/google/gson/Gson;", "gson", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "value", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", UserInfo.SEX_FEMALE, "()Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "I", "(Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;)V", "urlTemplate", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentFeatureUtil {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy qqmcProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy toggleProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy appSettingProxy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static ReentrantLock urlTemplateLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Lazy gson;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static FilamentUrlTemplate urlTemplate;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final FilamentFeatureUtil f106409g;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/filament/zplanservice/feature/FilamentFeatureUtil$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcl0/k;", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends TypeToken<Map<String, ? extends SceneConfig>> {
        a() {
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        FilamentUrlTemplate filamentUrlTemplate;
        FilamentFeatureUtil filamentFeatureUtil = new FilamentFeatureUtil();
        f106409g = filamentFeatureUtil;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<g>() { // from class: com.tencent.filament.zplanservice.feature.FilamentFeatureUtil$qqmcProxy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final g invoke() {
                return (g) a.f399763a.a(g.class);
            }
        });
        qqmcProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.filament.zplanservice.feature.FilamentFeatureUtil$toggleProxy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final k invoke() {
                return (k) a.f399763a.a(k.class);
            }
        });
        toggleProxy = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<dl0.a>() { // from class: com.tencent.filament.zplanservice.feature.FilamentFeatureUtil$appSettingProxy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final dl0.a invoke() {
                return (dl0.a) a.f399763a.a(dl0.a.class);
            }
        });
        appSettingProxy = lazy3;
        urlTemplateLock = new ReentrantLock();
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.filament.zplanservice.feature.FilamentFeatureUtil$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Gson invoke() {
                return new Gson();
            }
        });
        gson = lazy4;
        g z16 = filamentFeatureUtil.z();
        if (z16 == null || (filamentUrlTemplate = z16.a()) == null) {
            filamentUrlTemplate = new FilamentUrlTemplate(null, 1, null);
        }
        urlTemplate = filamentUrlTemplate;
    }

    FilamentFeatureUtil() {
    }

    private final k E() {
        return (k) toggleProxy.getValue();
    }

    private final dl0.a q() {
        return (dl0.a) appSettingProxy.getValue();
    }

    private final Gson y() {
        return (Gson) gson.getValue();
    }

    private final g z() {
        return (g) qqmcProxy.getValue();
    }

    @NotNull
    public final FilamentRecordSizeConfig A() {
        FilamentRecordSizeConfig filamentRecordSizeConfig;
        g z16 = z();
        if (z16 == null || (filamentRecordSizeConfig = (FilamentRecordSizeConfig) z16.getConfig("zplan_filament_record_size_config", FilamentRecordSizeConfig.class, "")) == null) {
            return new FilamentRecordSizeConfig(0, 0, 3, null);
        }
        return filamentRecordSizeConfig;
    }

    @Nullable
    public final String B() {
        k E = E();
        if (E != null) {
            return E.a("zplan_filament_res_black_list");
        }
        return null;
    }

    @NotNull
    public final FilamentTextureViewConfig C() {
        FilamentTextureViewConfig filamentTextureViewConfig;
        g z16 = z();
        if (z16 == null || (filamentTextureViewConfig = (FilamentTextureViewConfig) z16.getConfig("zplan_filament_textureview_config", FilamentTextureViewConfig.class, "")) == null) {
            return new FilamentTextureViewConfig(0L, 0L, 3, null);
        }
        return filamentTextureViewConfig;
    }

    @NotNull
    public final FilamentTextureViewConfig D() {
        FilamentTextureViewConfig filamentTextureViewConfig;
        g z16 = z();
        if (z16 == null || (filamentTextureViewConfig = (FilamentTextureViewConfig) z16.getConfig("zplan_filament_textureview_config_v2305", FilamentTextureViewConfig.class, "")) == null) {
            return new FilamentTextureViewConfig(0L, 0L, 3, null);
        }
        return filamentTextureViewConfig;
    }

    @NotNull
    public final FilamentUrlTemplate F() {
        ReentrantLock reentrantLock = urlTemplateLock;
        reentrantLock.lock();
        try {
            return urlTemplate;
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public final String G() {
        String b16;
        g z16 = z();
        if (z16 == null || (b16 = z16.b("zplan_xwconnet_init_config", "{}")) == null) {
            return "{}";
        }
        return b16;
    }

    public final boolean H() {
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("zplan_lite_download_again_when_file_not_found", false);
    }

    public final void I(@NotNull FilamentUrlTemplate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ReentrantLock reentrantLock = urlTemplateLock;
        reentrantLock.lock();
        try {
            urlTemplate = value;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean J() {
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("100710", false);
    }

    public final boolean K() {
        dl0.a q16 = q();
        if (q16 == null || !q16.isPublicVersion()) {
            return true;
        }
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("zplan_lite_use_zplan_material", false);
    }

    public final boolean a() {
        return false;
    }

    public final boolean b() {
        dl0.a q16 = q();
        if (q16 != null && q16.isPublicVersion()) {
            g z16 = z();
            if (z16 == null) {
                return true;
            }
            return z16.isSwitchOn("zplan_filament_disable_span", true);
        }
        return false;
    }

    public final boolean c() {
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("zplan_enable_avatar_resource_cache", false);
    }

    public final boolean d() {
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("zplan_filament_enable_bloom", false);
    }

    public final boolean e() {
        dl0.a q16 = q();
        if (q16 == null || !q16.isPublicVersion()) {
            return true;
        }
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("enable_filament_compressed_textures_of_head", false);
    }

    public final boolean f() {
        dl0.a q16 = q();
        if (q16 == null || !q16.isPublicVersion()) {
            return true;
        }
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("enable_filament_compressed_textures_of_makeup", false);
    }

    public final boolean g() {
        g z16 = z();
        if (z16 == null) {
            return true;
        }
        return z16.isSwitchOn("enable_zplan_cpp_download", true);
    }

    public final boolean h() {
        g z16 = z();
        if (z16 == null) {
            return true;
        }
        return z16.isSwitchOn("enable_cpp_retain_surface_texture", true);
    }

    public final boolean i() {
        g z16 = z();
        if (z16 == null) {
            return true;
        }
        return z16.isSwitchOn("enable_delay_in_zplan_controller", true);
    }

    public final boolean j() {
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("enable_filament_local_shader_binary", false);
    }

    public final boolean k() {
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("zplan_filament_enable_particle_system", false);
    }

    public final boolean l() {
        k E = E();
        if (E != null) {
            return E.c("zplan_filament_res_black_list");
        }
        return false;
    }

    public final boolean m() {
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("enable_split_function", false);
    }

    public final boolean n() {
        g z16 = z();
        if (z16 == null) {
            return false;
        }
        return z16.isSwitchOn("enable_strong_reference_when_destroy", false);
    }

    @NotNull
    public final c o() {
        c cVar;
        g z16 = z();
        if (z16 != null) {
            cVar = (c) z16.getConfig("enable_zplan_cpp_download", c.class, "");
        } else {
            cVar = null;
        }
        if (cVar != null) {
            return cVar;
        }
        dl0.a q16 = q();
        if (q16 != null && q16.isPublicVersion()) {
            return new c(false, 0, 3, null);
        }
        return new c(true, 0);
    }

    @NotNull
    public final f p() {
        f fVar;
        g z16 = z();
        if (z16 != null) {
            fVar = (f) z16.getConfig("filament_resource_check_config", f.class, "");
        } else {
            fVar = null;
        }
        if (fVar != null) {
            return fVar;
        }
        dl0.a q16 = q();
        if (q16 != null && q16.isPublicVersion()) {
            return new f(false, false, 0, 7, null);
        }
        return new f(true, true, 0);
    }

    @NotNull
    public final FilamentCoupleTextureViewConfig r() {
        FilamentCoupleTextureViewConfig filamentCoupleTextureViewConfig;
        g z16 = z();
        if (z16 == null || (filamentCoupleTextureViewConfig = (FilamentCoupleTextureViewConfig) z16.getConfig("zplan_filament_couple_textureview_config_v2305", FilamentCoupleTextureViewConfig.class, "")) == null) {
            return new FilamentCoupleTextureViewConfig(0L, 1, null);
        }
        return filamentCoupleTextureViewConfig;
    }

    public final long s() {
        FilamentMiniHomeConnectDelayTimeConfig filamentMiniHomeConnectDelayTimeConfig;
        g z16 = z();
        if (z16 == null || (filamentMiniHomeConnectDelayTimeConfig = (FilamentMiniHomeConnectDelayTimeConfig) z16.getConfig("minihome_connect_delay_time", FilamentMiniHomeConnectDelayTimeConfig.class, "")) == null) {
            filamentMiniHomeConnectDelayTimeConfig = new FilamentMiniHomeConnectDelayTimeConfig(0L, 1, null);
        }
        return filamentMiniHomeConnectDelayTimeConfig.getDelayTime();
    }

    @Nullable
    public final JSONObject t() {
        String b16;
        g z16 = z();
        if (z16 != null && (b16 = z16.b("zplan_filament_effect_slot_items", "{}")) != null) {
            return com.tencent.zplan.common.utils.h.f385294a.b(b16);
        }
        return null;
    }

    @Nullable
    public final JSONObject u() {
        String b16;
        g z16 = z();
        if (z16 != null && (b16 = z16.b("101244", "")) != null) {
            return com.tencent.zplan.common.utils.h.f385294a.b(b16);
        }
        return null;
    }

    @NotNull
    public final Map<String, SceneConfig> v() {
        String str;
        Map<String, SceneConfig> emptyMap;
        g z16 = z();
        if (z16 != null) {
            str = z16.b("zplan_filament_gpu_level_config", "{}");
        } else {
            str = null;
        }
        try {
            Object fromJson = y().fromJson(str, new a().getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(json, type)");
            return (Map) fromJson;
        } catch (Exception unused) {
            FLog.INSTANCE.e("FilamentFeatureUtil", "getFilamentGpuLevelConfig json is error");
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }

    @NotNull
    public final FilamentSceneMonitorConfig w() {
        FilamentSceneMonitorConfig filamentSceneMonitorConfig;
        g z16 = z();
        if (z16 == null || (filamentSceneMonitorConfig = (FilamentSceneMonitorConfig) z16.getConfig("filament_scene_runtime_monitor_config", FilamentSceneMonitorConfig.class, new FilamentSceneMonitorConfig(null, 1, null).toString())) == null) {
            return new FilamentSceneMonitorConfig(null, 1, null);
        }
        return filamentSceneMonitorConfig;
    }

    public final int x() {
        k E = E();
        if (E == null) {
            return 0;
        }
        return E.d("zplan_filament_native_app_thread_priority", 0);
    }
}
