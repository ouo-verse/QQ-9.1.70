package com.tencent.zplan.utils;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\u001b\u0010\u000e\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u000f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/utils/ZPlanConstant;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "LIFECYCLE", "Lkotlin/Lazy;", "c", "memeCachePath", "getRecordResourceCachePath", "recordResourceCachePath", "d", "emoticon2DCachePath", "", "e", UserInfo.SEX_FEMALE, "getFRAME_DELTA_TIME", "()F", "FRAME_DELTA_TIME", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanConstant {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy memeCachePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy recordResourceCachePath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy emoticon2DCachePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final float FRAME_DELTA_TIME;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final ZPlanConstant f386195f = new ZPlanConstant();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String LIFECYCLE = "[LifeCycle]";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/zplan/utils/ZPlanConstant$a;", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f386199c;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/utils/ZPlanConstant$a$a;", "", "", "", "", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "CODE_MSG_MAP", "b", "UE_CODE_MAP", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.zplan.utils.ZPlanConstant$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes27.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private static final Map<Integer, String> CODE_MSG_MAP;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private static final Map<Integer, Integer> UE_CODE_MAP;

            /* renamed from: c, reason: collision with root package name */
            static final /* synthetic */ Companion f386199c = new Companion();

            static {
                Map<Integer, String> mapOf;
                Map<Integer, Integer> mapOf2;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(-1001, "zplan\u8fdb\u7a0b\u542f\u52a8\u5931\u8d25"), TuplesKt.to(-1002, "Service\u8fde\u63a5\u8d85\u65f6"), TuplesKt.to(-1003, "\u5f15\u64ce\u521d\u59cb\u5316\u5931\u8d25"), TuplesKt.to(-1004, "\u573a\u666f\u9996\u5e27\u8d85\u65f6"), TuplesKt.to(Integer.valueOf(WeakNetLearner.PROBE_REASON.INVALID_DATA), "world\u521b\u5efa\u5931\u8d25"), TuplesKt.to(Integer.valueOf(WeakNetLearner.PROBE_REASON.TRANSACTION_FAIL), "world\u521b\u5efa\u540e\u53ef\u7528\u72b6\u6001\u8d85\u65f6"), TuplesKt.to(-1103, "\u5f15\u64ce\u63a5\u53e3\u8c03\u7528\u5931\u8d25: \u56e0\u4e3a\u5f15\u64ce\u521d\u59cb\u5316\u5931\u8d25"), TuplesKt.to(-1104, "\u5f15\u64ce\u63a5\u53e3\u8c03\u7528\u5931\u8d25: \u56e0\u4e3a\u5f15\u64ce\u5904\u4e8e\u6302\u8d77\u72b6\u6001"), TuplesKt.to(-1105, "\u5f15\u64ce\u63a5\u53e3\u8c03\u7528\u5931\u8d25: \u56e0\u4e3a\u5f15\u64ce\u5904\u4e8e\u6e05\u7406\u72b6\u6001"));
                CODE_MSG_MAP = mapOf;
                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(2, -1104), TuplesKt.to(3, -1105));
                UE_CODE_MAP = mapOf2;
            }

            Companion() {
            }

            @NotNull
            public final Map<Integer, String> a() {
                return CODE_MSG_MAP;
            }

            @NotNull
            public final Map<Integer, Integer> b() {
                return UE_CODE_MAP;
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.zplan.utils.ZPlanConstant$memeCachePath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Context context;
                lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
                if (aVar != null && (context = aVar.getContext()) != null) {
                    File externalCacheDir = context.getExternalCacheDir();
                    if (externalCacheDir == null) {
                        externalCacheDir = context.getCacheDir();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(externalCacheDir != null ? externalCacheDir.getPath() : null);
                    sb5.append("/meme");
                    return sb5.toString();
                }
                throw new RuntimeException("can't init memeCachePath without Context");
            }
        });
        memeCachePath = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.zplan.utils.ZPlanConstant$recordResourceCachePath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Context context;
                lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
                if (aVar != null && (context = aVar.getContext()) != null) {
                    File externalCacheDir = context.getExternalCacheDir();
                    if (externalCacheDir == null) {
                        externalCacheDir = context.getCacheDir();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(externalCacheDir != null ? externalCacheDir.getPath() : null);
                    sb5.append("/record/resource");
                    return sb5.toString();
                }
                throw new RuntimeException("can't init recordResourceCachePath without Context");
            }
        });
        recordResourceCachePath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.zplan.utils.ZPlanConstant$emoticon2DCachePath$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Context context;
                lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
                if (aVar != null && (context = aVar.getContext()) != null) {
                    File externalCacheDir = context.getExternalCacheDir();
                    if (externalCacheDir == null) {
                        externalCacheDir = context.getCacheDir();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(externalCacheDir != null ? externalCacheDir.getPath() : null);
                    sb5.append("/emoticon_2D");
                    return sb5.toString();
                }
                throw new RuntimeException("can't init recordResourceCachePath without Context");
            }
        });
        emoticon2DCachePath = lazy3;
        FRAME_DELTA_TIME = 0.04f;
    }

    ZPlanConstant() {
    }

    @NotNull
    public final String a() {
        return (String) emoticon2DCachePath.getValue();
    }

    @NotNull
    public final String b() {
        return LIFECYCLE;
    }

    @NotNull
    public final String c() {
        return (String) memeCachePath.getValue();
    }
}
