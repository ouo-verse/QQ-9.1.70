package ot0;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static OkHttpClient f423997c;

    /* renamed from: a, reason: collision with root package name */
    private final IAegisLogApi f423998a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f423999b = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f424000a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f424001b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f424002c;

        a(String str, b bVar, long j3) {
            this.f424000a = str;
            this.f424001b = bVar;
            this.f424002c = j3;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
            c.this.j("onFailure url:" + this.f424000a);
            c.this.k(this.f424001b);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            c.this.j("send success! url: " + this.f424000a);
            c.this.l(this.f424002c, response, this.f424001b);
            try {
                response.close();
            } catch (Exception e16) {
                QLog.i("ICGamePlayerStrategy|ICGameNetworkSpeed", 1, "sendGet fail!", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        void a(int i3, long j3);

        void onStart();
    }

    private long e(ResponseBody responseBody) {
        int read;
        long j3 = 0;
        if (responseBody == null) {
            return 0L;
        }
        byte[] bArr = new byte[131072];
        try {
            InputStream byteStream = responseBody.byteStream();
            while (!this.f423999b.get() && (read = byteStream.read(bArr)) > 0) {
                j3 += read;
            }
        } catch (Exception e16) {
            i("read size fail! " + e16.getMessage());
        }
        if (this.f423999b.get()) {
            return -1L;
        }
        return j3;
    }

    private long f(long j3, long j16) {
        return (((float) j3) / 1024.0f) / (((float) j16) / 1000.0f);
    }

    private static OkHttpClient g() {
        if (f423997c == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient build = new OkHttpClient.Builder().connectionPool(new ConnectionPool(1, 5L, timeUnit)).connectTimeout(5L, timeUnit).callTimeout(5L, timeUnit).writeTimeout(5L, timeUnit).readTimeout(5L, timeUnit).build();
            f423997c = build;
            build.dispatcher().setMaxRequests(1);
            f423997c.dispatcher().setMaxRequestsPerHost(1);
        }
        return f423997c;
    }

    private void i(String str) {
        this.f423998a.e("ICGamePlayerStrategy|ICGameNetworkSpeed", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        this.f423998a.i("ICGamePlayerStrategy|ICGameNetworkSpeed", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(b bVar) {
        if (bVar != null) {
            bVar.a(-1, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j3, Response response, b bVar) {
        if (this.f423999b.get()) {
            j("notifyFinish download stop! isStop:" + this.f423999b.get());
            k(bVar);
            return;
        }
        long e16 = e(response.body());
        if (e16 < 0) {
            j("notifyFinish calcSize stop! isStop:" + this.f423999b.get());
            k(bVar);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        long f16 = f(e16, currentTimeMillis);
        j("notifyFinish size:" + e16 + " useTime:" + currentTimeMillis + " speedKbps:" + f16 + "KB/s");
        if (bVar != null) {
            bVar.a(0, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void h(String str, b bVar) {
        this.f423999b.set(false);
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar != null) {
            bVar.onStart();
        }
        try {
            g().newCall(new Request.Builder().url(str).get().build()).enqueue(new a(str, bVar, currentTimeMillis));
        } catch (Exception e16) {
            QLog.i("ICGamePlayerStrategy|ICGameNetworkSpeed", 1, "sendGet fail!", e16);
        }
    }

    public void n(final String str, final b bVar) {
        j("start");
        if (TextUtils.isEmpty(str)) {
            i("\u6d4b\u901f\u5730\u5740\u4e3a\u7a7a\uff01\u6d4b\u901f\u5931\u8d25");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: ot0.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.h(str, bVar);
                }
            }, 128, null, false);
        }
    }

    public void o() {
        j("stop");
        this.f423999b.set(true);
    }
}
