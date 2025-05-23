package com.tencent.mobileqq.icgame.techreport;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.raft.measure.report.ATTAReporter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Gson f237798a = new GsonBuilder().disableHtmlEscaping().create();

    /* renamed from: b, reason: collision with root package name */
    private static IAegisLogApi f237799b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: c, reason: collision with root package name */
    private static Map<e, List<g>> f237800c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static Handler f237801d = new a(ThreadManagerV2.getQQCommonThreadLooper());

    /* renamed from: e, reason: collision with root package name */
    private static long f237802e;

    /* renamed from: f, reason: collision with root package name */
    private static int f237803f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                c.f237799b.d("AttaReportUtil", "report interval");
                c.l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Callback {
        b() {
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
            c.f237799b.e("AttaReportUtil", "batch report send fail! ,e:" + iOException.getLocalizedMessage());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            try {
                c.f237799b.d("AttaReportUtil", "batch report code:" + response.code());
                response.close();
            } catch (Exception e16) {
                c.f237799b.e("AttaReportUtil", "batch report  fail!", e16);
            }
            c.f237799b.d("AttaReportUtil", "batch report send success!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.icgame.techreport.c$c, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C7931c implements Callback {
        C7931c() {
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
            c.f237799b.e("AttaReportUtil", "single report send fail! ,e:" + iOException.getLocalizedMessage());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            try {
                c.f237799b.d("AttaReportUtil", "single report code:" + response.code());
                response.close();
            } catch (Exception e16) {
                c.f237799b.e("AttaReportUtil", "single report  fail!", e16);
            }
            c.f237799b.d("AttaReportUtil", "single report send success!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d {

        @SerializedName("attaid")
        String attaid;

        @SerializedName("datas")
        List<String> datas;

        @SerializedName("token")
        String token;

        @SerializedName("type")
        String type;

        @SerializedName("version")
        String version;

        public d(String str, String str2, String str3, String str4, List<String> list) {
            this.attaid = str;
            this.token = str2;
            this.type = str3;
            this.version = str4;
            this.datas = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        String f237804a;

        /* renamed from: b, reason: collision with root package name */
        String f237805b;

        public e(String str, String str2) {
            this.f237804a = str;
            this.f237805b = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            if (!ObjectsCompat.equals(this.f237804a, eVar.f237804a)) {
                return false;
            }
            return ObjectsCompat.equals(this.f237805b, eVar.f237805b);
        }

        public int hashCode() {
            int i3;
            String str = this.f237804a;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str2 = this.f237805b;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return i17 + i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class f {

        @SerializedName("report_interval")
        private long reportInterval = 5000;

        @SerializedName("max_cache_size")
        private int maxCacheSize = 10;

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        Map<String, String> f237806a;

        public g(Map<String, String> map) {
            this.f237806a = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private static AtomicReference<OkHttpClient> f237807a = new AtomicReference<>();

        @NotNull
        static OkHttpClient a() {
            if (f237807a.get() == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                OkHttpClient build = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 60L, timeUnit)).writeTimeout(10L, timeUnit).readTimeout(10L, timeUnit).build();
                build.dispatcher().setMaxRequests(10);
                build.dispatcher().setMaxRequestsPerHost(10);
                if (build.dispatcher().executorService() instanceof ThreadPoolExecutor) {
                    ((ThreadPoolExecutor) build.dispatcher().executorService()).setMaximumPoolSize(4);
                }
                androidx.lifecycle.c.a(f237807a, null, build);
            }
            return f237807a.get();
        }
    }

    static {
        int i3;
        f fVar = (f) ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_ATTA_REPORT_CONFIG, f.class, new f());
        f237799b.i("AttaReportUtil", "maxCacheSize:" + fVar.maxCacheSize + ",interval:" + fVar.reportInterval);
        if (fVar.maxCacheSize >= 1) {
            i3 = fVar.maxCacheSize;
        } else {
            i3 = 10;
        }
        f237803f = i3;
        long j3 = 5000;
        if (fVar.reportInterval >= 5000) {
            j3 = fVar.reportInterval;
        }
        f237802e = j3;
    }

    public static void e(final String str, final String str2, final Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            f237799b.d("AttaReportUtil", "batchReport");
            f237801d.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.techreport.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.j(str, str2, map);
                }
            });
        }
    }

    private static void f(e eVar, List<g> list) {
        f237799b.d("AttaReportUtil", "batchReportToServer attaid = [" + eVar.f237804a + "], reportItems = [" + list.size() + "]");
        h.a().newCall(g(eVar, list)).enqueue(new b());
    }

    @NonNull
    private static Request g(e eVar, List<g> list) {
        return new Request.Builder().post(RequestBody.create(MediaType.parse("application/json"), f237798a.toJson(new d(eVar.f237804a, eVar.f237805b, "batch", "v1.0.0", p(list))))).addHeader(ATTAReporter.ATTA_TYPE, ATTAReporter.BATCH_REPORT).url("https://h.trace.qq.com/kv").build();
    }

    private static Request h(Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 != null) {
                builder.add(str, str2);
            }
        }
        return new Request.Builder().post(builder.build()).url("https://h.trace.qq.com/kv").build();
    }

    private static void i() {
        Iterator<Map.Entry<e, List<g>>> it = f237800c.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getValue().size();
        }
        if (i3 >= f237803f) {
            f237801d.removeMessages(1);
            f237799b.d("AttaReportUtil", "report size");
            l();
        } else if (!f237801d.hasMessages(1)) {
            f237801d.sendEmptyMessageDelayed(1, f237802e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(String str, String str2, Map map) {
        try {
            e eVar = new e(str, str2);
            List<g> list = f237800c.get(eVar);
            g gVar = new g(map);
            if (list == null) {
                list = new ArrayList<>();
                f237800c.put(eVar, list);
            }
            list.add(gVar);
            i();
        } catch (Throwable th5) {
            f237799b.a("AttaReportUtil", "batchReport exception:" + th5.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(Map map) {
        try {
            n(map);
        } catch (Throwable th5) {
            f237799b.a("AttaReportUtil", "singleReport exception:" + th5.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        Iterator<Map.Entry<e, List<g>>> it = f237800c.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getValue().size();
        }
        if (i3 <= 0) {
            return;
        }
        for (Map.Entry<e, List<g>> entry : f237800c.entrySet()) {
            List<g> value = entry.getValue();
            if (!value.isEmpty()) {
                f(entry.getKey(), value);
            }
        }
        f237800c.clear();
    }

    public static void m(final Map<String, String> map) {
        f237801d.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.techreport.a
            @Override // java.lang.Runnable
            public final void run() {
                c.k(map);
            }
        });
    }

    private static void n(Map<String, String> map) {
        f237799b.d("AttaReportUtil", "singleReportToServer");
        if (map != null && !map.isEmpty()) {
            h.a().newCall(h(map)).enqueue(new C7931c());
        }
    }

    private static String o(g gVar) {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : gVar.f237806a.entrySet()) {
            sb5.append(entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue());
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
        if (sb5.toString().endsWith(ContainerUtils.FIELD_DELIMITER)) {
            return sb5.substring(0, sb5.length() - 1);
        }
        return sb5.toString();
    }

    private static List<String> p(List<g> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(o(it.next()));
        }
        return arrayList;
    }
}
