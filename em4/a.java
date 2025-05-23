package em4;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static OkHttpClient f396828a;

    /* compiled from: P */
    /* renamed from: em4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C10250a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f396829a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f396830b;

        C10250a(String str, String str2) {
            this.f396829a = str;
            this.f396830b = str2;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
            QLog.i("ReportHttp", 1, "send fail! url:" + this.f396829a);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            try {
                response.close();
            } catch (Exception e16) {
                QLog.i("ReportHttp", 1, "sendGet fail!", e16);
            }
            QLog.d("ReportHttp", 1, this.f396830b + " send success! url: " + this.f396829a);
        }
    }

    private static OkHttpClient a() {
        if (f396828a == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient build = new OkHttpClient.Builder().connectionPool(new ConnectionPool(2, 5L, timeUnit)).writeTimeout(5L, timeUnit).readTimeout(5L, timeUnit).build();
            f396828a = build;
            build.dispatcher().setMaxRequests(2);
            f396828a.dispatcher().setMaxRequestsPerHost(2);
        }
        return f396828a;
    }

    public static void b(String str, String str2) {
        try {
            a().newCall(new Request.Builder().url(str).get().build()).enqueue(new C10250a(str, str2));
        } catch (Exception e16) {
            QLog.i("ReportHttp", 1, "sendGet fail!", e16);
        }
    }
}
