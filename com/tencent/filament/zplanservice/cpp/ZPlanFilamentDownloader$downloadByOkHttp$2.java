package com.tencent.filament.zplanservice.cpp;

import com.google.gson.Gson;
import com.tencent.filament.zplanservice.okhttp.OkHttpClientFactory;
import com.tencent.filament.zplanservice.util.log.FLog;
import dl0.j;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplanservice.cpp.ZPlanFilamentDownloader$downloadByOkHttp$2", f = "ZPlanFilamentDownloader.kt", i = {0, 0, 0, 0}, l = {180}, m = "invokeSuspend", n = {"response", "callbackHeaders", "downloadStart", "downloadResponse"}, s = {"L$0", "L$1", "J$0", "J$1"})
/* loaded from: classes6.dex */
public final class ZPlanFilamentDownloader$downloadByOkHttp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $callback;
    final /* synthetic */ String $header;
    final /* synthetic */ String $saveDirectoryPath;
    final /* synthetic */ String $taskKey;
    final /* synthetic */ String $url;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentDownloader$downloadByOkHttp$2(String str, String str2, long j3, String str3, String str4, Continuation continuation) {
        super(2, continuation);
        this.$header = str;
        this.$url = str2;
        this.$callback = j3;
        this.$saveDirectoryPath = str3;
        this.$taskKey = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanFilamentDownloader$downloadByOkHttp$2(this.$header, this.$url, this.$callback, this.$saveDirectoryPath, this.$taskKey, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanFilamentDownloader$downloadByOkHttp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.Map] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List downloadTasksByKey;
        j jVar;
        Map map;
        int mapCapacity;
        InputStream inputStream;
        long currentTimeMillis;
        Object saveToFilePath;
        long j3;
        Response response;
        LinkedHashMap linkedHashMap;
        Object firstOrNull;
        List downloadTasksByKey2;
        j jVar2;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    long j16 = this.J$1;
                    long j17 = this.J$0;
                    ?? r46 = (Map) this.L$1;
                    Response response2 = (Response) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    currentTimeMillis = j16;
                    j3 = j17;
                    linkedHashMap = r46;
                    response = response2;
                    saveToFilePath = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                long currentTimeMillis2 = System.currentTimeMillis();
                OkHttpClient e16 = OkHttpClientFactory.f106417g.e();
                Request.Builder builder = new Request.Builder();
                map = ZPlanFilamentDownloader.INSTANCE.toMap(this.$header);
                for (Map.Entry entry : map.entrySet()) {
                    builder.addHeader((String) entry.getKey(), (String) entry.getValue());
                }
                builder.url(this.$url);
                builder.get();
                Unit unit = Unit.INSTANCE;
                Response execute = e16.newCall(builder.build()).execute();
                int code = execute.code();
                Map<String, List<String>> multimap = execute.headers().toMultimap();
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(multimap.size());
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
                for (Object obj2 : multimap.entrySet()) {
                    Object key = ((Map.Entry) obj2).getKey();
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ((Map.Entry) obj2).getValue());
                    String str2 = (String) firstOrNull;
                    if (str2 == null) {
                        str2 = "";
                    }
                    linkedHashMap2.put(key, str2);
                }
                ResponseBody body = execute.body();
                if (body != null) {
                    inputStream = body.byteStream();
                } else {
                    inputStream = null;
                }
                currentTimeMillis = System.currentTimeMillis();
                FLog.INSTANCE.i(ZPlanFilamentDownloader.TAG, "OkHttp download onResponse, callback: " + this.$callback + ',' + this.$url + ", " + execute.isSuccessful() + ", " + code + "request cost:  " + (currentTimeMillis - currentTimeMillis2));
                ZPlanFilamentDownloader zPlanFilamentDownloader = ZPlanFilamentDownloader.INSTANCE;
                String str3 = this.$saveDirectoryPath;
                this.L$0 = execute;
                this.L$1 = linkedHashMap2;
                this.J$0 = currentTimeMillis2;
                this.J$1 = currentTimeMillis;
                this.label = 1;
                saveToFilePath = zPlanFilamentDownloader.saveToFilePath(inputStream, str3, this);
                if (saveToFilePath == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = currentTimeMillis2;
                response = execute;
                linkedHashMap = linkedHashMap2;
            }
            Pair pair = (Pair) saveToFilePath;
            String str4 = (String) pair.component1();
            final String str5 = (String) pair.component2();
            long currentTimeMillis3 = System.currentTimeMillis();
            FLog.INSTANCE.i(ZPlanFilamentDownloader.TAG, "OkHttp download onResponse, callback: " + this.$callback + ", rspPath: " + str4 + ", save cost: " + (currentTimeMillis3 - currentTimeMillis));
            downloadTasksByKey2 = ZPlanFilamentDownloader.INSTANCE.getDownloadTasksByKey(this.$taskKey);
            if (downloadTasksByKey2 != null) {
                Iterator it = downloadTasksByKey2.iterator();
                while (it.hasNext()) {
                    final long longValue = ((Number) it.next()).longValue();
                    ZPlanFilamentDownloader zPlanFilamentDownloader2 = ZPlanFilamentDownloader.INSTANCE;
                    jVar2 = ZPlanFilamentDownloader.threadPoolProxy;
                    if (jVar2 != null) {
                        final LinkedHashMap linkedHashMap3 = linkedHashMap;
                        final String str6 = str4;
                        final Response response3 = response;
                        str = str4;
                        j.a.a(jVar2, new Runnable() { // from class: com.tencent.filament.zplanservice.cpp.ZPlanFilamentDownloader$downloadByOkHttp$2$invokeSuspend$$inlined$forEach$lambda$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                String str7;
                                boolean z16;
                                try {
                                    str7 = new Gson().toJson(linkedHashMap3);
                                } catch (Exception e17) {
                                    FLog.INSTANCE.e(ZPlanFilamentDownloader.TAG, "header json toString error. " + e17);
                                    str7 = "";
                                }
                                String str8 = str7;
                                if (str8 != null && str8.length() != 0) {
                                    z16 = false;
                                } else {
                                    z16 = true;
                                }
                                if (z16) {
                                    ZPlanFilamentDownloader.INSTANCE.onDownloadResponse(this.$callback, null, -2, null, "header to string fail");
                                } else {
                                    ZPlanFilamentDownloader.INSTANCE.onDownloadResponse(longValue, str6, response3.code(), str8, str5);
                                }
                            }
                        }, 0L, 2, null);
                    } else {
                        str = str4;
                    }
                    str4 = str;
                }
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            FLog.INSTANCE.i(ZPlanFilamentDownloader.TAG, "OkHttp download onResponse, callback: " + this.$callback + ", all cost: " + (currentTimeMillis4 - j3));
        } catch (Exception e17) {
            FLog.INSTANCE.e(ZPlanFilamentDownloader.TAG, "OkHttp download onFailure, " + this.$url + ", " + e17.getLocalizedMessage());
            downloadTasksByKey = ZPlanFilamentDownloader.INSTANCE.getDownloadTasksByKey(this.$taskKey);
            if (downloadTasksByKey != null) {
                Iterator it5 = downloadTasksByKey.iterator();
                while (it5.hasNext()) {
                    final long longValue2 = ((Number) it5.next()).longValue();
                    ZPlanFilamentDownloader zPlanFilamentDownloader3 = ZPlanFilamentDownloader.INSTANCE;
                    jVar = ZPlanFilamentDownloader.threadPoolProxy;
                    if (jVar != null) {
                        j.a.a(jVar, new Runnable() { // from class: com.tencent.filament.zplanservice.cpp.ZPlanFilamentDownloader$downloadByOkHttp$2$invokeSuspend$$inlined$forEach$lambda$2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ZPlanFilamentDownloader.INSTANCE.onDownloadResponse(longValue2, null, -1, "{}", e17.getLocalizedMessage());
                            }
                        }, 0L, 2, null);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
