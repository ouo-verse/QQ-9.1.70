package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.ark.ark;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qqexpand.utils.l;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R4\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "", "", "toString", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "Lcom/tencent/mobileqq/config/business/qflutter/a;", "resDescriptionList", "Ljava/util/List;", "getResDescriptionList", "()Ljava/util/List;", "setResDescriptionList", "(Ljava/util/List;)V", "", "Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "preloads", "Ljava/util/Map;", "getPreloads", "()Ljava/util/Map;", "setPreloads", "(Ljava/util/Map;)V", "", "time", "J", "c", "()J", "setTime", "(J)V", "version", "getVersion", "setVersion", "branchIdentify", "b", "setBranchIdentify", "", "a", "I", "getTaskId", "()I", "d", "(I)V", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QFlutterResConfig {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<Gson> f202785c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static QFlutterResConfig f202786d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int taskId;

    @SerializedName("branch")
    @NotNull
    private String branchIdentify;

    @SerializedName("name")
    @NotNull
    private String name = "";

    @SerializedName("preloads")
    @NotNull
    private Map<ExpandModuleKey, ? extends List<String>> preloads;

    @SerializedName("res_list")
    @NotNull
    private List<ResDescription> resDescriptionList;

    @SerializedName("time")
    private long time;

    @SerializedName("version")
    @NotNull
    private String version;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001d\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig$a;", "", "", ark.ARKMETADATA_JSON, "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "a", "", "Lcom/tencent/mobileqq/config/ai;", "items", "b", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "c", "()Lcom/google/gson/Gson;", "gson", "KEY_EXPAND_PLUGIN", "Ljava/lang/String;", "KEY_EXPAND_PLUGIN_PRE_INSTALL", "TAG", "currentResConfig", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C7473a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((QFlutterResConfig) t17).getBranchIdentify().length()), Integer.valueOf(((QFlutterResConfig) t16).getBranchIdentify().length()));
                return compareValues;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig$a$b */
        /* loaded from: classes10.dex */
        public static final class b<T> implements Comparator {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Comparator f202788d;

            public b(Comparator comparator) {
                this.f202788d = comparator;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                int compare = this.f202788d.compare(t16, t17);
                if (compare == 0) {
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((QFlutterResConfig) t17).getTime()), Long.valueOf(((QFlutterResConfig) t16).getTime()));
                    return compareValues;
                }
                return compare;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final QFlutterResConfig a(String json) {
            try {
                return (QFlutterResConfig) c().fromJson(json, QFlutterResConfig.class);
            } catch (Exception e16) {
                l.f264102a.a().e("QFlutterResConfig", 1, "QFlutterResConfig Parse json error: " + json, e16);
                return null;
            }
        }

        @NotNull
        public final QFlutterResConfig b(@NotNull ai[] items) {
            List filterNotNull;
            List sortedWith;
            Object firstOrNull;
            boolean z16;
            Intrinsics.checkNotNullParameter(items, "items");
            ArrayList arrayList = new ArrayList(items.length);
            int length = items.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                ai aiVar = items[i3];
                int i17 = i16 + 1;
                l lVar = l.f264102a;
                if (QLog.isColorLevel()) {
                    lVar.a().d("QFlutterResConfig", 2, "[" + i16 + "][" + aiVar.f202267a + "] Parse json: " + aiVar.f202268b);
                }
                QFlutterResConfig a16 = QFlutterResConfig.INSTANCE.a(aiVar.f202268b);
                if (a16 != null) {
                    a16.d(aiVar.f202267a);
                } else {
                    a16 = null;
                }
                arrayList.add(a16);
                i3++;
                i16 = i17;
            }
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : filterNotNull) {
                QFlutterResConfig qFlutterResConfig = (QFlutterResConfig) obj;
                boolean z17 = true;
                if (qFlutterResConfig.getBranchIdentify().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && !Intrinsics.areEqual(qFlutterResConfig.getBranchIdentify(), AppSetting.f99544d)) {
                    z17 = false;
                }
                if (z17) {
                    arrayList2.add(obj);
                }
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new b(new C7473a()));
            l lVar2 = l.f264102a;
            if (QLog.isColorLevel()) {
                lVar2.a().d("QFlutterResConfig", 2, "configs = " + sortedWith);
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortedWith);
            QFlutterResConfig qFlutterResConfig2 = (QFlutterResConfig) firstOrNull;
            if (qFlutterResConfig2 == null) {
                return new QFlutterResConfig();
            }
            return qFlutterResConfig2;
        }

        @NotNull
        public final Gson c() {
            Object value = QFlutterResConfig.f202785c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-gson>(...)");
            return (Gson) value;
        }

        Companion() {
        }
    }

    static {
        Lazy<Gson> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig$Companion$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                return new GsonBuilder().registerTypeAdapter(PreloadEngineOption.class, new PreloadEngineOptionAdapter()).registerTypeAdapter(ExpandModuleKey.class, new ExpandModuleAdapter()).create();
            }
        });
        f202785c = lazy;
        f202786d = new QFlutterResConfig();
    }

    public QFlutterResConfig() {
        List<ResDescription> emptyList;
        Map<ExpandModuleKey, ? extends List<String>> emptyMap;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.resDescriptionList = emptyList;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.preloads = emptyMap;
        this.version = "";
        this.branchIdentify = "";
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBranchIdentify() {
        return this.branchIdentify;
    }

    /* renamed from: c, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final void d(int i3) {
        this.taskId = i3;
    }

    @NotNull
    public String toString() {
        boolean z16;
        List<ResDescription> list = this.resDescriptionList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ResDescription) obj).getPkgSuffix().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return "QFlutterResConfig(name='" + this.name + "', time=" + this.time + ", version='" + this.version + "', preloads=" + this.preloads + ", hotfixList=" + arrayList + ", branchIdentify='" + this.branchIdentify + "', taskId=" + this.taskId + ")";
    }
}
