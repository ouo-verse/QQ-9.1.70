package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasReaderApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J=\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nJ=\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nJ=\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nJ=\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nJ3\u0010\u0010\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nJ=\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nJ=\u0010\u0012\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nJ\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J=\u0010\u0016\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/d;", "", "", "params", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "i", "l", tl.h.F, "c", "f", "j", "d", "g", "url", "b", "k", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/qqnt/http/api/b;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "downloadFileTaskMap", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, com.tencent.qqnt.http.api.b> downloadFileTaskMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/d$b", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onSuccess", "onFailed", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements com.tencent.qqnt.http.api.l {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f309832b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309833c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f309834d;

        b(String str, Function1<Object, Unit> function1, String str2) {
            this.f309832b = str;
            this.f309833c = function1;
            this.f309834d = str2;
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            d.this.downloadFileTaskMap.remove(this.f309832b);
            Function1<Object, Unit> function1 = this.f309833c;
            if (function1 != null) {
                Pair[] pairArr = new Pair[3];
                int i3 = 0;
                pairArr[0] = TuplesKt.to("result", "failed");
                pairArr[1] = TuplesKt.to("msg", String.valueOf(result.b()));
                Integer c16 = result.c();
                if (c16 != null) {
                    i3 = c16.intValue();
                }
                pairArr[2] = TuplesKt.to("code", Integer.valueOf(i3));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            d.this.downloadFileTaskMap.remove(this.f309832b);
            Function1<Object, Unit> function1 = this.f309833c;
            if (function1 != null) {
                Pair[] pairArr = new Pair[3];
                int i3 = 0;
                pairArr[0] = TuplesKt.to("result", "success");
                pairArr[1] = TuplesKt.to("path", this.f309834d);
                Integer c16 = result.c();
                if (c16 != null) {
                    i3 = c16.intValue();
                }
                pairArr[2] = TuplesKt.to("code", Integer.valueOf(i3));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                function1.invoke(mapOf);
            }
        }
    }

    private final String e(String params) {
        boolean z16;
        File filesDir;
        String absolutePath = new JSONObject(params).optString("absolutePath");
        Intrinsics.checkNotNullExpressionValue(absolutePath, "absolutePath");
        if (absolutePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (new JSONObject(params).optInt("type") == 0) {
                filesDir = BaseApplication.getContext().getCacheDir();
            } else {
                filesDir = BaseApplication.getContext().getFilesDir();
            }
            absolutePath = new File(filesDir, new JSONObject(params).optString("business") + new JSONObject(params).optString("subFilePath")).getAbsolutePath();
        }
        Intrinsics.checkNotNullExpressionValue(absolutePath, "absolutePath");
        return absolutePath;
    }

    public final void b(@Nullable String url) {
        if (url != null) {
            com.tencent.qqnt.http.api.b bVar = this.downloadFileTaskMap.get(url);
            if (bVar != null) {
                ((IHttpService) QRoute.api(IHttpService.class)).cancel(bVar);
            }
            this.downloadFileTaskMap.remove(url);
            QLog.i("VasFileNative", 1, "cancelDownload " + url);
        }
    }

    public final void c(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        int i3;
        if (params != null) {
            new JSONObject(params);
            i3 = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).deleteFile(e(params));
        } else {
            i3 = -1;
        }
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", i3);
            callback.invoke(jSONObject.toString());
        }
    }

    public final void d(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        if (params != null) {
            String e16 = e(params);
            String url = new JSONObject(params).optString("url");
            QLog.i("VasFileNative", 1, "download " + url + " to " + e16);
            if (this.downloadFileTaskMap.contains(url)) {
                QLog.i("VasFileNative", 1, "downloadFileItem, but downloadFileTaskMap contains it.");
                return;
            }
            File file = new File(e16);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            b.a T = new b.a("vas_kuikly_download", url, file).T(new b(url, callback, e16));
            JSONObject header = new JSONObject(params).optJSONObject("Header");
            if (header != null) {
                Intrinsics.checkNotNullExpressionValue(header, "header");
                HashMap hashMap = new HashMap();
                Iterator keys = header.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "head.keys()");
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    String optString = header.optString(key);
                    Intrinsics.checkNotNullExpressionValue(optString, "head.optString(key)");
                    hashMap.put(key, optString);
                }
                if (!hashMap.isEmpty()) {
                    T.a(hashMap);
                }
            }
            com.tencent.qqnt.http.api.b c16 = T.c();
            this.downloadFileTaskMap.put(url, c16);
            ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(c16);
        }
    }

    public final void f(@Nullable Function1<Object, Unit> callback) {
        String availableSpace = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).getAvailableSpace();
        if (callback != null) {
            callback.invoke(availableSpace);
        }
    }

    @NotNull
    public final String g(@Nullable String params) {
        boolean z16;
        String str = "";
        if (params != null) {
            new JSONObject(params);
            String e16 = e(params);
            File file = new File(e16);
            if (file.exists()) {
                str = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(str, "{\n                    f.\u2026utePath\n                }");
            }
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("VasFileNative", 1, "getFile " + e16 + " exist:" + z16);
        }
        return str;
    }

    public final void h(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        String str;
        if (params != null) {
            new JSONObject(params);
            str = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).getFileList(e(params));
        } else {
            str = "";
        }
        if (callback != null) {
            callback.invoke(str);
        }
    }

    public final void i(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        String str;
        if (params != null) {
            str = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).readFile(e(params));
        } else {
            str = "";
        }
        if (callback != null) {
            callback.invoke(str);
        }
    }

    public final void j(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        String str;
        if (params != null) {
            new JSONObject(params);
            str = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).getFileSize(e(params));
        } else {
            str = "";
        }
        if (callback != null) {
            callback.invoke(str);
        }
    }

    public final void k(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        boolean z16 = true;
        QLog.i("VasFileNative", 1, "unZipFile " + params);
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("zipFilePath");
            String optString2 = jSONObject.optString("folderPath");
            if (new File(optString2).exists() && callback != null) {
                mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", Boolean.FALSE));
                callback.invoke(mapOf3);
            }
            if (ZipUtils.unZipFolder(optString, optString2) != 0) {
                z16 = false;
            }
            if (callback != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", Boolean.valueOf(z16)));
                callback.invoke(mapOf2);
            }
        }
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", Boolean.FALSE));
            callback.invoke(mapOf);
        }
    }

    public final void l(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        int i3;
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            String e16 = e(params);
            IVasReaderApi iVasReaderApi = (IVasReaderApi) QRoute.api(IVasReaderApi.class);
            boolean optBoolean = jSONObject.optBoolean("isAppend");
            String optString = jSONObject.optString("data");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"data\")");
            i3 = iVasReaderApi.writeFile(e16, optBoolean, optString);
        } else {
            i3 = -1;
        }
        if (callback != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ret", i3);
            callback.invoke(jSONObject2.toString());
        }
    }
}
