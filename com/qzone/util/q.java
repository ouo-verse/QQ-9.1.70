package com.qzone.util;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class q implements NetworkState.NetworkStateListener {

    /* renamed from: d, reason: collision with root package name */
    private static final String f59834d = "q";

    /* renamed from: e, reason: collision with root package name */
    public static String f59835e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f59836f = "";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f59837h;

    /* renamed from: i, reason: collision with root package name */
    private static final al<q, Void> f59838i = new a();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends al<q, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public q a(Void r16) {
            return new q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f59839a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, String str) {
            super(looper);
            this.f59839a = str;
        }

        /* JADX WARN: Not initialized variable reg: 1, insn: 0x00f4: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:48:0x00f4 */
        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2;
            Exception e16;
            IOException e17;
            MalformedURLException e18;
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    try {
                        com.tencent.mobileqq.teamwork.c cVar = new com.tencent.mobileqq.teamwork.c();
                        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                        sSLContext.init(null, new TrustManager[]{cVar}, null);
                        com.tencent.mobileqq.teamwork.l lVar = new com.tencent.mobileqq.teamwork.l(sSLContext.getSocketFactory());
                        HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.f59839a).openConnection();
                        httpsURLConnection.setSSLSocketFactory(lVar);
                        httpsURLConnection.setConnectTimeout(5000);
                        httpsURLConnection.setReadTimeout(30000);
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.setRequestMethod("GET");
                        httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                        httpsURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                        httpsURLConnection.setRequestProperty(ISchemeApi.KEY_REFERER, this.f59839a);
                        httpsURLConnection.setRequestProperty("Accept", "*/*");
                        httpsURLConnection.setRequestProperty(HttpMsg.CHARSET, "UTF-8");
                        httpsURLConnection.connect();
                        int responseCode = httpsURLConnection.getResponseCode();
                        QZLog.i(q.f59834d, "ping.huatuo stat:" + responseCode);
                        if (responseCode == 200) {
                            bufferedReader2 = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                            try {
                                q.h(bufferedReader2.readLine());
                                bufferedReader3 = bufferedReader2;
                            } catch (MalformedURLException e19) {
                                e18 = e19;
                                e18.printStackTrace();
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                q.f59837h = false;
                                return doNext(false);
                            } catch (IOException e26) {
                                e17 = e26;
                                e17.printStackTrace();
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                q.f59837h = false;
                                return doNext(false);
                            } catch (Exception e27) {
                                e16 = e27;
                                e16.printStackTrace();
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                q.f59837h = false;
                                return doNext(false);
                            }
                        }
                    } catch (MalformedURLException e28) {
                        bufferedReader2 = null;
                        e18 = e28;
                    } catch (IOException e29) {
                        bufferedReader2 = null;
                        e17 = e29;
                    } catch (Exception e36) {
                        bufferedReader2 = null;
                        e16 = e36;
                    } catch (Throwable th5) {
                        th = th5;
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e37) {
                                e37.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                } catch (IOException e38) {
                    e38.printStackTrace();
                }
                q.f59837h = false;
                return doNext(false);
            } catch (Throwable th6) {
                th = th6;
                bufferedReader3 = bufferedReader;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f59840a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Looper looper, String str) {
            super(looper);
            this.f59840a = str;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            int i3 = -1;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f59840a).openConnection();
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                i3 = httpURLConnection.getResponseCode();
                QZLog.i(q.f59834d, "sngdia test stat:" + i3);
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
            } catch (IOException e17) {
                e17.printStackTrace();
            } catch (Exception e18) {
                e18.printStackTrace();
            }
            if (i3 != 200) {
                q.f59837h = false;
            } else {
                try {
                    LockMethodProxy.sleep(2000L);
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
            }
            return doNext(i3 == 200);
        }
    }

    q() {
        NetworkState.addListener(this);
    }

    public static String c() {
        return f59836f;
    }

    public static q d() {
        return f59838i.get(null);
    }

    public static String e() {
        if (TextUtils.isEmpty(f59835e) && !f59837h) {
            g();
        }
        return f59835e;
    }

    private static boolean f() {
        return QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_VIDEO_ENABLE_LOAD_LOCAL_DNS, 0, false) == 1;
    }

    public static void g() {
        if (f()) {
            f59837h = true;
            long currentTimeMillis = System.currentTimeMillis();
            long hashCode = UUID.randomUUID().hashCode();
            String qua3 = QUA.getQUA3();
            String str = currentTimeMillis + "." + Math.abs(hashCode) + ".sngdia.imtmp.Service";
            HdAsync.with(null).then(new c(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), String.format("https://%s/s", str))).then(new b(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), String.format("https://ping.huatuo.qq.com/getLocalDns.php?d=%s&app=%s", str, qua3))).call();
        }
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("localdns");
            String string2 = jSONObject.getString("userip");
            if (!TextUtils.isEmpty(string)) {
                f59835e = string;
                QZLog.i(f59834d, "sLocalDns:" + f59835e);
            }
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            f59836f = string2;
            QZLog.i(f59834d, "sClientIp:" + f59836f);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void i() {
        f59835e = "";
        f59836f = "";
        g();
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (z16) {
            i();
        }
    }
}
