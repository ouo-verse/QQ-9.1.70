package com.tencent.filament.zplanservice.cpp;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.filament.zplanservice.util.log.FLog;
import dl0.g;
import dl0.j;
import dl0.l;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0002H\u0002J9\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0082 J\u0018\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015*\u00020\u0002H\u0002J5\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R&\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060*0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/filament/zplanservice/cpp/ZPlanFilamentDownloader;", "", "", "url", "header", "saveDirectoryPath", "", "callback", "", "download", "downloadByQQDownloader", "downloadByOkHttp", "taskKey", "", "getDownloadTasksByKey", "callbackPtr", "savePath", "", "httpCode", "errorMessage", "onDownloadResponse", "", "toMap", "Ljava/io/InputStream;", "inputStream", "saveDir", "Lkotlin/Pair;", "saveToFilePath", "(Ljava/io/InputStream;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Ldl0/j;", "threadPoolProxy", "Ldl0/j;", "", "enableLog", "Z", "enableOkhttp", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "", "", "downloadingTasks", "Ljava/util/Map;", "Ljava/util/concurrent/locks/ReentrantLock;", "downloadingTaskLock", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanFilamentDownloader {

    @NotNull
    public static final ZPlanFilamentDownloader INSTANCE = new ZPlanFilamentDownloader();

    @NotNull
    public static final String TAG = "ZPlanFilamentDownloader";
    private static final ReentrantLock downloadingTaskLock;
    private static final Map<String, List<Long>> downloadingTasks;
    private static final boolean enableLog = true;
    private static final boolean enableOkhttp;
    private static final CoroutineScope scope;
    private static final j threadPoolProxy;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/filament/zplanservice/cpp/ZPlanFilamentDownloader$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        a() {
        }
    }

    static {
        fl0.a aVar = fl0.a.f399763a;
        threadPoolProxy = (j) aVar.a(j.class);
        g gVar = (g) aVar.a(g.class);
        boolean z16 = true;
        if (gVar != null) {
            z16 = gVar.isSwitchOn("filament_use_okhttp", true);
        }
        enableOkhttp = z16;
        scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        downloadingTasks = new LinkedHashMap();
        downloadingTaskLock = new ReentrantLock();
    }

    ZPlanFilamentDownloader() {
    }

    @JvmStatic
    @NativeMethodProxy
    public static final void download(@NotNull String url, @NotNull String header, @NotNull String saveDirectoryPath, long callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(saveDirectoryPath, "saveDirectoryPath");
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("download callback: ");
        sb5.append(callback);
        sb5.append(", url: ");
        sb5.append(url);
        sb5.append(", saveDirectoryPath: ");
        sb5.append(saveDirectoryPath);
        sb5.append(", enableOkhttp: ");
        boolean z16 = enableOkhttp;
        sb5.append(z16);
        sb5.append(", header: ");
        sb5.append(header);
        fLog.i(TAG, sb5.toString());
        if (z16) {
            INSTANCE.downloadByOkHttp(url, header, saveDirectoryPath, callback);
        } else {
            INSTANCE.downloadByQQDownloader(url, header, saveDirectoryPath, callback);
        }
    }

    private final void downloadByOkHttp(String url, String header, String saveDirectoryPath, long callback) {
        List<Long> mutableListOf;
        String str = url + '#' + header.hashCode();
        ReentrantLock reentrantLock = downloadingTaskLock;
        reentrantLock.lock();
        try {
            Map<String, List<Long>> map = downloadingTasks;
            boolean z16 = false;
            if (!map.containsKey(str)) {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(callback));
                map.put(str, mutableListOf);
                Unit unit = Unit.INSTANCE;
                z16 = true;
            } else {
                FLog.INSTANCE.i(TAG, "downloadByOkHttp: task already in progress: " + str);
                List<Long> list = map.get(str);
                if (list != null) {
                    list.add(Long.valueOf(callback));
                }
            }
            if (z16) {
                BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ZPlanFilamentDownloader$downloadByOkHttp$2(header, url, callback, saveDirectoryPath, str, null), 3, null);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void downloadByQQDownloader(String url, String header, String saveDirectoryPath, long callback) {
        long currentTimeMillis = System.currentTimeMillis();
        l lVar = (l) fl0.a.f399763a.a(l.class);
        if (lVar != null) {
            lVar.a(url, saveDirectoryPath, toMap(header), new ZPlanFilamentDownloader$downloadByQQDownloader$1(callback, currentTimeMillis, url));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Long> getDownloadTasksByKey(String taskKey) {
        List<Long> list;
        ReentrantLock reentrantLock = downloadingTaskLock;
        reentrantLock.lock();
        try {
            Map<String, List<Long>> map = downloadingTasks;
            List<Long> list2 = map.get(taskKey);
            if (list2 != null && list != null) {
                map.remove(taskKey);
            } else {
                list = null;
            }
            return list;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void onDownloadResponse(long callbackPtr, String savePath, int httpCode, String header, String errorMessage);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void onDownloadResponse$default(ZPlanFilamentDownloader zPlanFilamentDownloader, long j3, String str, int i3, String str2, String str3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            str3 = null;
        }
        zPlanFilamentDownloader.onDownloadResponse(j3, str, i3, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> toMap(String str) {
        Type type = new a().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<Map<S\u2026ng?, String?>?>() {}.type");
        Object fromJson = new Gson().fromJson(str, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(this, type)");
        return (Map) fromJson;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object saveToFilePath(InputStream inputStream, String str, Continuation<? super Pair<String, String>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ZPlanFilamentDownloader$saveToFilePath$2(inputStream, str, null), continuation);
    }
}
