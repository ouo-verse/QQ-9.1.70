package dt3;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.api.config.qmanage.QQLiveQManageConfigTasksKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveCrashReportApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f394823a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f394824b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f394825c = "";

    /* renamed from: d, reason: collision with root package name */
    private static OkHttpClient f394826d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f394827e;

    /* renamed from: f, reason: collision with root package name */
    private static long f394828f;

    /* renamed from: g, reason: collision with root package name */
    private static final HashSet<String> f394829g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f394830h;

    /* renamed from: i, reason: collision with root package name */
    private static final Runnable f394831i;

    /* renamed from: j, reason: collision with root package name */
    private static final List<f> f394832j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f394833k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f394834a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f394835b;

        a(String str, boolean z16) {
            this.f394834a = str;
            this.f394835b = z16;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.i("QQLiveAegisLog", 1, "finalUrl=" + this.f394834a + ",fail: " + iOException.toString());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            e.j("QQLiveAegisLog", "success: " + response.message());
            if (this.f394835b) {
                QMMKV.from(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext(), QMMKVFile.FILE_QQLIVE).removeKey("key_cache_qqlive_crash_info_" + e.f394825c);
            }
            try {
                response.close();
            } catch (Exception e16) {
                QLog.e("QQLiveAegisLog", 1, "response.close() e= " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f394836a;

        b(String str) {
            this.f394836a = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.e("QQLiveAegisLog", 1, "finalUrl=" + this.f394836a + ",fail: " + iOException.toString());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            try {
                response.close();
            } catch (Exception e16) {
                QLog.e("QQLiveAegisLog", 1, "reportEvent response.close() e= " + e16);
            }
        }
    }

    static {
        Handler handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        f394830h = handler;
        f394831i = new Runnable() { // from class: dt3.a
            @Override // java.lang.Runnable
            public final void run() {
                e.w(false);
            }
        };
        f394832j = new ArrayList(10);
        f394833k = ah.Q(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext());
        handler.post(new Runnable() { // from class: dt3.b
            @Override // java.lang.Runnable
            public final void run() {
                e.v();
            }
        });
    }

    public static void A(final String str, final String str2, final String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f394830h.post(new Runnable() { // from class: dt3.d
            @Override // java.lang.Runnable
            public final void run() {
                e.t(str, str2, str3);
            }
        });
    }

    @Deprecated
    public static void B(String str, int i3, String str2) {
        QLog.w(str, i3, str2);
        if (1 == i3) {
            y(str2, str, "5");
        }
    }

    public static void C(String str, String str2) {
        B(str, 1, str2);
    }

    public static void f(String str, String str2) {
        g(str, str2, null);
    }

    public static void g(String str, String str2, et3.a aVar) {
        QLog.e(str, 1, str2);
        if (aVar == null) {
            aVar = et3.a.a();
        }
        z("[process:" + aVar.f397104b + "]" + str2, str, "2048", aVar.f397103a, aVar.f397105c);
        if (aVar.f397105c) {
            QMMKV.from(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext(), QMMKVFile.FILE_QQLIVE).encodeString("key_cache_qqlive_crash_info_" + f394825c, str2);
        }
    }

    private static void h(boolean z16, boolean z17) {
        List<f> list = f394832j;
        if (list.size() != 10 && !z16) {
            if (list.size() <= 1) {
                f394830h.postDelayed(f394831i, 8000L);
                return;
            }
            return;
        }
        w(z17);
    }

    private static boolean i(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf(124) < 0) {
            return false;
        }
        String substring = str.substring(0, str.indexOf(124));
        if (TextUtils.isEmpty(substring)) {
            return false;
        }
        return f394829g.contains(substring);
    }

    public static void j(String str, String str2) {
        QLog.d(str, 2, str2);
    }

    @Deprecated
    public static void k(String str, int i3, String str2) {
        QLog.e(str, i3, str2);
        if (1 == i3) {
            y(str2, str, "4");
        }
    }

    public static void l(String str, String str2) {
        k(str, 1, str2);
    }

    public static void m(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
        y(str2 + "," + th5, str, "4");
    }

    private static OkHttpClient n() {
        if (f394826d == null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            f394826d = okHttpClient;
            okHttpClient.dispatcher().setMaxRequests(2);
            f394826d.dispatcher().setMaxRequestsPerHost(2);
            if (f394826d.dispatcher().executorService() instanceof ThreadPoolExecutor) {
                ((ThreadPoolExecutor) f394826d.dispatcher().executorService()).setMaximumPoolSize(4);
            }
        }
        return f394826d;
    }

    @Deprecated
    public static void o(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
        if (1 == i3) {
            y(str2, str, "2");
        }
    }

    public static void p(String str, String str2) {
        o(str, 1, str2);
    }

    private static void q() {
        String str;
        f394825c = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        f394827e = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(QQLiveQManageConfigTasksKt.AEGIS_SWITCH_CONFIG, false);
        o("QQLiveAegisLog", 1, "isReportAegis=" + f394827e);
        try {
            str = ht3.a.d("qqlive_task_aegis_main_path_config", "[\"Send_Gift_Monitor\", \"Recv_Gift_Monitor\", \"QuickGiftHelper\"]");
        } catch (OutOfMemoryError e16) {
            l("QQLiveAegisLog", "initAegisInfo oom e=" + e16);
            str = null;
        }
        o("QQLiveAegisLog", 1, "mainPathConfigItem=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    f394829g.add(optString);
                }
            }
        } catch (JSONException e17) {
            l("QQLiveAegisLog", "initAegisInfo contentJsonArr e=" + e17);
        }
        r();
        f394828f = System.currentTimeMillis();
    }

    private static void r() {
        String decodeString = QMMKV.from(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext(), QMMKVFile.FILE_QQLIVE).decodeString("key_cache_qqlive_crash_info_" + f394825c, null);
        if (!TextUtils.isEmpty(decodeString)) {
            z(decodeString, ((IQQLiveCrashReportApi) QRoute.api(IQQLiveCrashReportApi.class)).getClass().getSimpleName(), "2048", "", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(String str, String str2, String str3, String str4, long j3, boolean z16) {
        if (!f394825c.equals(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount())) {
            q();
        }
        if (!f394827e && !i(str) && !"2048".equalsIgnoreCase(str2)) {
            return;
        }
        f fVar = new f();
        fVar.f394838b = "[" + f394833k + "]" + str3;
        fVar.f394839c = str2;
        fVar.f394837a = str;
        fVar.f394840d = str4;
        fVar.f394841e = String.valueOf(j3);
        f394832j.add(fVar);
        h("2048".equalsIgnoreCase(str2), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(String str, String str2, String str3) {
        if (!f394829g.contains("ReportAegisEventTag")) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("ext1", String.valueOf(str2));
            jSONObject.put("ext2", String.valueOf(str3));
        } catch (JSONException e16) {
            QLog.e("QQLiveAegisLog", 1, "reportEvent JSONException e= " + e16);
        }
        jSONArray.mo162put(jSONObject);
        String str4 = f394824b + "uin" + ContainerUtils.KEY_VALUE_DELIMITER + f394825c + ContainerUtils.FIELD_DELIMITER + "sessionId" + ContainerUtils.KEY_VALUE_DELIMITER + f394828f + "&payload=" + jSONArray.toString();
        n().newCall(new Request.Builder().url(str4).addHeader("Content-Type", "application/x-www-form-urlencoded").get().build()).enqueue(new b(str4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("https://aegis.qq.com/collect?");
        sb5.append("id");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append("PvuowNuWRzSqjMjcSO");
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("count");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append("1");
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("version");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        String str = f394833k;
        sb5.append(str);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("platform");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append("1");
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("ext1");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append("isDebug:");
        sb5.append(false);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        f394823a = sb5.toString();
        f394824b = "https://aegis.qq.com/collect/events?id" + ContainerUtils.KEY_VALUE_DELIMITER + "PvuowNuWRzSqjMjcSO" + ContainerUtils.FIELD_DELIMITER + "version" + ContainerUtils.KEY_VALUE_DELIMITER + str + ContainerUtils.FIELD_DELIMITER + "platform" + ContainerUtils.KEY_VALUE_DELIMITER + "1" + ContainerUtils.FIELD_DELIMITER + "ext1" + ContainerUtils.KEY_VALUE_DELIMITER + "isDebug:false" + ContainerUtils.FIELD_DELIMITER;
        f394829g.add("QQLiveAudienceView");
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(boolean z16) {
        List<f> list = f394832j;
        if (!list.isEmpty()) {
            x(z16);
        }
        f394830h.removeCallbacks(f394831i);
        list.clear();
    }

    private static void x(boolean z16) {
        String str = f394823a + "uin" + ContainerUtils.KEY_VALUE_DELIMITER + f394825c + ContainerUtils.FIELD_DELIMITER + "sessionId" + ContainerUtils.KEY_VALUE_DELIMITER + f394828f;
        FormBody.Builder builder = new FormBody.Builder();
        int i3 = 0;
        while (true) {
            List<f> list = f394832j;
            if (i3 < list.size()) {
                f fVar = list.get(i3);
                if (fVar != null) {
                    builder.addEncoded(String.format("msg[%d]", Integer.valueOf(i3)), "[" + fVar.f394841e + "]" + fVar.f394837a + "," + fVar.f394838b);
                    builder.addEncoded(String.format("level[%d]", Integer.valueOf(i3)), String.valueOf(fVar.f394839c));
                    builder.addEncoded(String.format("from[%d]", Integer.valueOf(i3)), String.valueOf(fVar.f394837a));
                    builder.addEncoded(String.format("ext1[%d]", Integer.valueOf(i3)), String.valueOf(fVar.f394837a));
                    builder.addEncoded(String.format("ext2[%d]", Integer.valueOf(i3)), String.valueOf(fVar.f394840d));
                }
                i3++;
            } else {
                builder.addEncoded("count", String.valueOf(list.size()));
                n().newCall(new Request.Builder().url(str).post(builder.build()).build()).enqueue(new a(str, z16));
                return;
            }
        }
    }

    private static void y(String str, String str2, String str3) {
        z(str, str2, str3, null, false);
    }

    private static void z(final String str, final String str2, final String str3, final String str4, final boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final long currentTimeMillis = System.currentTimeMillis();
            f394830h.post(new Runnable() { // from class: dt3.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.s(str2, str3, str, str4, currentTimeMillis, z16);
                }
            });
        }
    }
}
