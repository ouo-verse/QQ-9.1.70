package com.tencent.mobileqq.wink.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/WinkLruCache;", "", "", "filePath", "oriJsonString", "i", "", "d", "f", "", "kotlin.jvm.PlatformType", "b", "Ljava/util/List;", "FILE_PREFS_LIST", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/utils/k;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "getCacheFileInfo", "()Ljava/util/ArrayList;", "setCacheFileInfo", "(Ljava/util/ArrayList;)V", "cacheFileInfo", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "spJsonObject", "", "e", tl.h.F, "()Z", "isOpenLruCache", "Z", "hasInitialized", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLruCache {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkLruCache f326638a = new WinkLruCache();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> FILE_PREFS_LIST;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static volatile ArrayList<FileInfo> cacheFileInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy spJsonObject;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isOpenLruCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasInitialized;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((FileInfo) t16).getModifiedData()), Long.valueOf(((FileInfo) t17).getModifiedData()));
            return compareValues;
        }
    }

    static {
        List<String> listOf;
        Lazy lazy;
        Lazy lazy2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{u53.b.f438374e, u53.a.f438361b});
        FILE_PREFS_LIST = listOf;
        cacheFileInfo = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.wink.utils.WinkLruCache$spJsonObject$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVOptionEntity invoke() {
                return QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
            }
        });
        spJsonObject = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.utils.WinkLruCache$isOpenLruCache$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(uq3.c.p6());
            }
        });
        isOpenLruCache = lazy2;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.utils.ap
            @Override // java.lang.Runnable
            public final void run() {
                WinkLruCache.c();
            }
        }, 64, null, false);
    }

    WinkLruCache() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        JSONObject jSONObject;
        Object obj;
        String str;
        WinkLruCache winkLruCache = f326638a;
        if (!winkLruCache.h()) {
            return;
        }
        String decodeString = winkLruCache.g().decodeString("CACHE_FILE_LIST", null);
        w53.b.a("WinkLruCache", "WinkLruCache init: " + decodeString);
        if (!TextUtils.isEmpty(decodeString)) {
            JSONArray jSONArray = new JSONArray(decodeString);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj2 = jSONArray.get(i3);
                if (obj2 instanceof JSONObject) {
                    jSONObject = (JSONObject) obj2;
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    obj = jSONObject.get("path");
                } else {
                    obj = null;
                }
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = null;
                }
                if (str != null && !TextUtils.isEmpty(str)) {
                    File file = new File(str);
                    if (file.exists()) {
                        cacheFileInfo.add(new FileInfo(str, file.lastModified(), FileUtils.getFileOrFolderSize(str)));
                    }
                }
            }
        }
        f326638a.d();
        hasInitialized = true;
    }

    private final void d() {
        int collectionSizeOrDefault;
        long sumOfLong;
        Object firstOrNull;
        final String str;
        Object firstOrNull2;
        long j3;
        Object firstOrNull3;
        boolean startsWith$default;
        boolean z16;
        int i3 = MobileQQ.sProcessId;
        if (i3 != 9) {
            w53.b.a("WinkLruCache", "current process: " + i3);
            return;
        }
        ArrayList<FileInfo> arrayList = cacheFileInfo;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((FileInfo) it.next()).getFileSize()));
        }
        sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(arrayList2);
        w53.b.c("WinkLruCache", "current cache size: " + sumOfLong);
        if (sumOfLong > 536870912) {
            ArrayList<FileInfo> arrayList3 = cacheFileInfo;
            if (arrayList3.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList3, new a());
            }
            while (sumOfLong > VasBusiness.QWALLET && cacheFileInfo.size() > 1) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) cacheFileInfo);
                FileInfo fileInfo = (FileInfo) firstOrNull;
                if (fileInfo != null) {
                    str = fileInfo.getFilePath();
                } else {
                    str = null;
                }
                if (str != null) {
                    List<String> list = FILE_PREFS_LIST;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        for (String it5 : list) {
                            Intrinsics.checkNotNullExpressionValue(it5, "it");
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, it5, false, 2, null);
                            if (startsWith$default) {
                                z16 = false;
                                break;
                            }
                        }
                    }
                    z16 = true;
                    if (z16) {
                        w53.b.c("WinkLruCache", "\u6587\u4ef6\u8def\u5f84\u4e0d\u5728\u88ab\u5b9a\u4e49\u7684\u6587\u4ef6\u5939\u5185:" + str);
                    } else {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.utils.aq
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkLruCache.e(str);
                            }
                        }, 64, null, false);
                    }
                }
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) cacheFileInfo);
                FileInfo fileInfo2 = (FileInfo) firstOrNull2;
                if (fileInfo2 != null) {
                    j3 = fileInfo2.getFileSize();
                } else {
                    j3 = 0;
                }
                sumOfLong -= j3;
                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) cacheFileInfo);
                w53.b.c("WinkLruCache", "remove file: " + firstOrNull3);
                CollectionsKt__MutableCollectionsKt.removeFirstOrNull(cacheFileInfo);
            }
            w53.b.c("WinkLruCache", "current cache size: " + sumOfLong);
            JSONArray jSONArray = new JSONArray();
            for (FileInfo fileInfo3 : cacheFileInfo) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("path", fileInfo3.getFilePath());
                jSONArray.mo162put(jSONObject);
            }
            g().encodeString("CACHE_FILE_LIST", jSONArray.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String str) {
        FileUtils.deleteDirectory(str);
    }

    private final MMKVOptionEntity g() {
        return (MMKVOptionEntity) spJsonObject.getValue();
    }

    private final boolean h() {
        return ((Boolean) isOpenLruCache.getValue()).booleanValue();
    }

    private final String i(String filePath, String oriJsonString) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(oriJsonString)) {
            jSONArray = new JSONArray();
        } else {
            jSONArray = new JSONArray(oriJsonString);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("path", filePath);
        jSONArray.mo162put(jSONObject);
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
        return jSONArray2;
    }

    public final void f(@NotNull String filePath) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (!h()) {
            return;
        }
        String PATH_GENERATE_VIDEO = u53.b.f438374e;
        Intrinsics.checkNotNullExpressionValue(PATH_GENERATE_VIDEO, "PATH_GENERATE_VIDEO");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) filePath, (CharSequence) PATH_GENERATE_VIDEO, false, 2, (Object) null);
        if (!contains$default) {
            w53.b.a("WinkLruCache", "filepath invalid: " + filePath);
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            w53.b.a("WinkLruCache", "file doesn't exist: " + filePath);
            return;
        }
        g().encodeString("CACHE_FILE_LIST", i(filePath, g().decodeString("CACHE_FILE_LIST", "")));
        w53.b.c("WinkLruCache", "add file: " + file);
        if (!hasInitialized) {
            w53.b.a("WinkLruCache", "WinkLru not yet initialized: " + filePath);
            return;
        }
        cacheFileInfo.add(new FileInfo(filePath, file.lastModified(), FileUtils.getFileOrFolderSize(filePath)));
        d();
        w53.b.a("WinkLruCache", "cur sp: " + g().decodeString("CACHE_FILE_LIST", ""));
    }
}
