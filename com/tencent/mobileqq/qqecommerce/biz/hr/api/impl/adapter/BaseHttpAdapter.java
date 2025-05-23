package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.http2.HttpConnectionService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import dk0.c;
import fk0.d;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BaseHttpAdapter implements IBaseHttpAdapter {

    /* renamed from: c, reason: collision with root package name */
    public static String f262595c = "BaseHttpAdapter";

    /* renamed from: d, reason: collision with root package name */
    private static final a f262596d = new b();

    /* renamed from: e, reason: collision with root package name */
    public static final String f262597e = "QQ/" + AppSetting.f99551k + " Android/0.17 Android/" + Build.VERSION.RELEASE;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f262598a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f262599b;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a();

        void b(HttpURLConnection httpURLConnection, @Nullable String str);

        InputStream c(@Nullable InputStream inputStream);
    }

    public BaseHttpAdapter() {
        this(false);
    }

    private void e(dk0.a aVar) {
        String str;
        Map<String, String> map = aVar.f394017a;
        String str2 = (map == null || !map.containsKey("Cookie")) ? null : aVar.f394017a.get("Cookie");
        int i3 = 0;
        if (str2 != null) {
            String[] split = str2.split(";");
            int length = split.length;
            int i16 = 0;
            while (i3 < length) {
                String str3 = split[i3];
                if (!TextUtils.isEmpty(str3) && str3.startsWith("uin=")) {
                    i16 = 1;
                }
                i3++;
            }
            i3 = i16;
        }
        if (i3 == 0 && ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkUrlPermission(aVar.f394018b)) {
            StringBuilder sb5 = new StringBuilder();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                String account = runtime.getAccount();
                if (i3 == 0) {
                    sb5.append("uin=");
                    sb5.append('o');
                    sb5.append(account);
                }
            }
            if (TextUtils.isEmpty(sb5)) {
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                str = sb5.toString();
            } else {
                if (!str2.endsWith(";")) {
                    str2 = str2 + ';';
                }
                str = str2 + sb5.toString();
            }
            if (aVar.f394017a == null) {
                aVar.f394017a = new HashMap();
            }
            aVar.f394017a.put("Cookie", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(dk0.b bVar, c.a aVar, String str) {
        bVar.f394022a = "-1";
        bVar.f394024c = "-1";
        bVar.f394025d = str;
        if (aVar != null) {
            aVar.onHttpFinish(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection l(dk0.a aVar, c.a aVar2) throws IOException {
        HttpURLConnection f16 = f(new URL(aVar.f394018b), h(aVar.f394017a));
        f16.setConnectTimeout(aVar.f394021e);
        f16.setReadTimeout(aVar.f394021e);
        f16.setUseCaches(false);
        f16.setDoInput(true);
        e(aVar);
        Map<String, String> map = aVar.f394017a;
        if (map != null) {
            for (String str : map.keySet()) {
                f16.addRequestProperty(str, aVar.f394017a.get(str));
            }
        }
        Map<String, String> map2 = aVar.f394017a;
        if (map2 == null || !map2.containsKey("User-Agent")) {
            f16.addRequestProperty("User-Agent", f262597e);
        }
        if (!"POST".equals(aVar.f394019c) && !HttpPut.METHOD_NAME.equals(aVar.f394019c) && !"PATCH".equals(aVar.f394019c)) {
            if (!TextUtils.isEmpty(aVar.f394019c)) {
                f16.setRequestMethod(aVar.f394019c);
            } else {
                f16.setRequestMethod("GET");
            }
        } else {
            f16.setRequestMethod(aVar.f394019c);
            if (aVar.f394020d != null) {
                f16.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(f16.getOutputStream());
                dataOutputStream.write(aVar.f394020d.getBytes());
                dataOutputStream.close();
            }
        }
        return f16;
    }

    protected HttpURLConnection f(URL url, boolean z16) throws IOException {
        return new HttpConnectionService(z16).openConnection(url);
    }

    @Override // com.tencent.hippy.qq.api.IBaseHttpAdapter
    public Executor getExecutor() {
        if (this.f262598a == null) {
            synchronized (this) {
                if (this.f262598a == null) {
                    this.f262598a = ProxyExecutors.newFixedThreadPool(6);
                }
            }
        }
        if (this.f262598a.isShutdown()) {
            return null;
        }
        return this.f262598a;
    }

    public a k() {
        return f262596d;
    }

    @Override // com.tencent.hippy.qq.api.IBaseHttpAdapter, dk0.c
    public void sendRequest(dk0.a aVar, c.a aVar2, boolean z16) {
        g(aVar, aVar2, z16);
    }

    @Override // com.tencent.hippy.qq.api.IBaseHttpAdapter
    public void shutdownExecutor() {
        ExecutorService executorService = this.f262598a;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.f262598a.shutdown();
    }

    public BaseHttpAdapter(boolean z16) {
        this.f262599b = z16;
    }

    private void g(final dk0.a aVar, final c.a aVar2, boolean z16) {
        if (aVar2 != null) {
            aVar2.onHttpStart();
        }
        j(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.BaseHttpAdapter.1
            /* JADX WARN: Removed duplicated region for block: B:28:0x00e8 A[Catch: Exception -> 0x00e4, TRY_LEAVE, TryCatch #8 {Exception -> 0x00e4, blocks: (B:38:0x00e0, B:28:0x00e8), top: B:37:0x00e0 }] */
            /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                InputStream inputStream;
                InputStream errorStream;
                InputStream c16;
                GamePubAccountHelper.b(aVar.f394018b, System.currentTimeMillis());
                dk0.b bVar = new dk0.b();
                a k3 = BaseHttpAdapter.this.k();
                InputStream inputStream2 = null;
                try {
                    HttpURLConnection l3 = BaseHttpAdapter.this.l(aVar, aVar2);
                    k3.b(l3, aVar.f394020d);
                    Map<String, List<String>> headerFields = l3.getHeaderFields();
                    int responseCode = l3.getResponseCode();
                    c.a aVar3 = aVar2;
                    if (aVar3 != null) {
                        aVar3.onHeadersReceived(responseCode, headerFields);
                    }
                    k3.a();
                    bVar.f394022a = String.valueOf(responseCode);
                    if (responseCode >= 200 && responseCode <= 299) {
                        InputStream inputStream3 = l3.getInputStream();
                        try {
                            c16 = k3.c(inputStream3);
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                            inputStream2 = inputStream3;
                        }
                        try {
                            bVar.f394023b = BaseHttpAdapter.this.n(c16, aVar2);
                            inputStream2 = c16;
                            errorStream = null;
                        } catch (Throwable th6) {
                            inputStream2 = c16;
                            th = th6;
                            inputStream = null;
                            BaseHttpAdapter.this.i(bVar, aVar2, th.getMessage());
                            QLog.e(BaseHttpAdapter.f262595c, 2, "METHOD_OPEN_REQUEST_NET error! request url is:" + aVar.f394018b + "  request body is:" + aVar.f394020d + ",error msg:" + th.getMessage());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e16) {
                                    QLog.e(BaseHttpAdapter.f262595c, 1, e16, new Object[0]);
                                    return;
                                }
                            }
                            if (inputStream == null) {
                                inputStream.close();
                                return;
                            }
                            return;
                        }
                    } else {
                        errorStream = l3.getErrorStream();
                        try {
                            bVar.f394025d = BaseHttpAdapter.this.m(errorStream, aVar2);
                        } catch (Throwable th7) {
                            inputStream = errorStream;
                            th = th7;
                            try {
                                BaseHttpAdapter.this.i(bVar, aVar2, th.getMessage());
                                try {
                                    QLog.e(BaseHttpAdapter.f262595c, 2, "METHOD_OPEN_REQUEST_NET error! request url is:" + aVar.f394018b + "  request body is:" + aVar.f394020d + ",error msg:" + th.getMessage());
                                } catch (OutOfMemoryError unused) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (inputStream == null) {
                                }
                            } catch (Throwable th8) {
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e17) {
                                        QLog.e(BaseHttpAdapter.f262595c, 1, e17, new Object[0]);
                                        throw th8;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th8;
                            }
                        }
                    }
                    c.a aVar4 = aVar2;
                    if (aVar4 != null) {
                        aVar4.onHttpFinish(bVar);
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e18) {
                            QLog.e(BaseHttpAdapter.f262595c, 1, e18, new Object[0]);
                            return;
                        }
                    }
                    if (errorStream != null) {
                        errorStream.close();
                    }
                } catch (Throwable th9) {
                    th = th9;
                    inputStream = null;
                }
            }
        }, z16);
    }

    private boolean h(Map<String, String> map) {
        if (map != null && map.containsKey("Enable-Http2")) {
            boolean equals = "1".equals(map.get("Enable-Http2"));
            map.remove("Enable-Http2");
            return equals;
        }
        return this.f262599b;
    }

    private void j(Runnable runnable, boolean z16) {
        if (z16) {
            d.c().d(runnable);
        } else {
            ThreadManagerV2.excute(runnable, 128, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(InputStream inputStream, c.a aVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] cArr = new char[2048];
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                sb5.append(cArr, 0, read);
            } else {
                bufferedReader.close();
                return sb5.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] n(InputStream inputStream, c.a aVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private static class b implements a {
        b() {
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.BaseHttpAdapter.a
        public void a() {
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.BaseHttpAdapter.a
        public InputStream c(@Nullable InputStream inputStream) {
            return inputStream;
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.BaseHttpAdapter.a
        public void b(HttpURLConnection httpURLConnection, @Nullable String str) {
        }
    }
}
